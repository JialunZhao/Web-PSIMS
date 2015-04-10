package com.ai.psims.web.business.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.business.IAddGoodsImportList;
import com.ai.psims.web.model.AddGoodsBean;
import com.ai.psims.web.model.Goods;
import com.ai.psims.web.model.Import;
import com.ai.psims.web.model.ImportGoods;
import com.ai.psims.web.model.ImportGoodsExample;
import com.ai.psims.web.model.ImportGoodsExample.Criteria;
import com.ai.psims.web.model.Storagecheck;
import com.ai.psims.web.model.UpdateImportDemo;
import com.ai.psims.web.service.IGoodsService;
import com.ai.psims.web.service.IImportGoodsService;
import com.ai.psims.web.service.IImportService;
import com.ai.psims.web.service.IStoragecheckService;
import com.ai.psims.web.util.Constants;

@Service
public class AddGoodsImportListImpl implements IAddGoodsImportList {
	@Resource(name = "importServiceImpl")
	private IImportService importService;
	@Resource(name = "importGoodsServiceImpl")
	private IImportGoodsService importGoodsService;
	@Resource(name = "storagecheckServiceImpl")
	private IStoragecheckService storagecheckService;
	@Resource(name = "goodsServiceImpl")
	private IGoodsService goodsService;

	public String addGoodsList(AddGoodsBean goodsBean) {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String number = sdf.format(date);
		String importSerialNumber = importService.getImportSerialNumber(number);
		if (importSerialNumber == null) {
			importSerialNumber = number + "0000";
		} else {
			importSerialNumber = Long.toString((Long
					.parseLong(importSerialNumber) + 1L));
		}
		Long goodsAllPay = 0l;
		String[] goodsArray = goodsBean.getGoodList().split(",");
		int n = (goodsArray.length) / 9;
		for (int i = 0; i < n; i++) {
			int j = i * 9;
			goodsAllPay += Long.parseLong(goodsArray[7 + j]);
			ImportGoods goodsDemo = new ImportGoods();
			goodsDemo.setGoodsId(Integer.parseInt(goodsArray[0 + j]));
			goodsDemo.setGoodsName(goodsArray[1 + j]);
			goodsDemo.setImportGoodsUnit(goodsArray[2 + j]);
			goodsDemo.setImportGoodsAmount(Integer.parseInt(goodsArray[3 + j]));
			goodsDemo.setImportGoodsPrice(Long.parseLong(goodsArray[4 + j]));
			goodsDemo.setImportGoodsProductionDate(Date
					.valueOf(goodsArray[5 + j]));
			goodsDemo.setImportGoodsExpirationDate(Date
					.valueOf(goodsArray[6 + j]));
			goodsDemo.setImportSerialNumber(importSerialNumber);
			goodsDemo.setImportGoodsType(Constants.ImportGoodsStatus.NOTSALE);
			goodsDemo.setImportGoodsCreatetime(Date.valueOf(goodsBean
					.getImportcreatetime()));
			goodsDemo.setImportGoodsTotalPrice(Long
					.parseLong(goodsArray[7 + j]) * 1000);
			importGoodsService.insertImportGoods(goodsDemo);
		}

		Import import1 = new Import();
		import1.setImportSerialNumber(importSerialNumber);
		import1.setImportTotalPrice(goodsAllPay * 1000);
		import1.setPaymentType(goodsBean.getPayMed());
		import1.setImportDatetime(Date.valueOf(goodsBean.getImportcreatetime()));
		import1.setProviderName(goodsBean.getProviderName());
		import1.setProviderId(Integer.parseInt(goodsBean.getProviderId()));
		if (goodsBean.getPayStatus().equals(Constants.PayStatus.NOPAY)) {
			import1.setImportStatus(Constants.ImportStatus.ORDERNOPAY);
		} else {
			import1.setImportStatus(Constants.ImportStatus.ORDERYESPAY);
			import1.setPaymentType(goodsBean.getPayMed());
			import1.setPaymentTime(Date.valueOf(goodsBean.getPayTime()));
		}
		import1.setStorehouseName(goodsBean.getStoreName());
		import1.setStorehouseId(Integer.parseInt(goodsBean.getStoreId()));
		importService.InsertImport(import1);
		return "SUCCESS";
	}

	public List<ImportGoods> selBySerNum(String importSerialNumber) {
		List<ImportGoods> importGoodsList = new ArrayList<ImportGoods>();
		ImportGoodsExample example = new ImportGoodsExample();
		Criteria criteria = example.createCriteria();
		if (importSerialNumber != null && importSerialNumber != "") {
			criteria.andImportSerialNumberEqualTo(importSerialNumber);
		}
		criteria.andImportGoodsEndtimeIsNull();
		importGoodsList = importGoodsService.selectByExample(example);
		return importGoodsList;
	}

	public String updateImportGoods(UpdateImportDemo updateImportDemo) {
		List<ImportGoods> importGoodsList = new ArrayList<ImportGoods>();
		List<ImportGoods> begigImportGoodsList = new ArrayList<ImportGoods>();
		importGoodsList = updateImportDemo.getImportGoodsList();
		for (ImportGoods importGoods : importGoodsList) {
			ImportGoods importGood = importGoodsService
					.selectByPrimaryKey(importGoods.getImportGoodsId());
			begigImportGoodsList.add(importGood);
		}
		if (updateImportDemo.getImportStatus().equals(
				Constants.ImportStatus.GOODSIMPORT)) {
			for (ImportGoods importGoods : begigImportGoodsList) {
				Storagecheck storagecheck = new Storagecheck();
				Goods goods = goodsService
						.selectByKey(importGoods.getGoodsId());
				storagecheck.setGoodsId(importGoods.getGoodsId());
				storagecheck.setGoodsName(importGoods.getGoodsName());
				storagecheck.setProviderId(goods.getProviderId());
				storagecheck.setProviderName(goods.getProviderName());
				storagecheck.setStorageRateTotal(importGoods
						.getImportGoodsAmount());
				storagecheck.setStorageRateCurrent(importGoods
						.getImportGoodsAmount());
				storagecheck.setGoodsProductionDate(importGoods
						.getImportGoodsProductionDate());
				storagecheck.setGoodsExpirationDate(importGoods
						.getImportGoodsExpirationDate());
				storagecheck.setGoodsShelfLife(goods.getGoodsShelfLife());
				storagecheck.setGoodsPrice(goods.getGoodsPrice());
				storagecheck
						.setGoodsStatus(Constants.ImportGoodsStatus.CANSALE);
				storagecheck.setImportSerialNumber(importGoods
						.getImportSerialNumber());
				storagecheck.setImportGoodsUnit(goods.getGoodsUnit());
				storagecheck.setStorageWarning(goods.getStorageWarning());
				storagecheck.setShelfLifeWarning(goods.getShelfLifeWarning());
				storagecheckService.insert(storagecheck);
			}

		}
		for (ImportGoods importGoods : importGoodsList) {
			importGoodsService.updateByKey(importGoods);
		}
		Import import1 = new Import();
		import1.setImportSerialNumber(updateImportDemo.getImportSerialNumber());
		import1.setImportStatus(updateImportDemo.getImportStatus());
		import1.setPaymentType(updateImportDemo.getPaymentType());
		import1.setPaymentTime(Date.valueOf(updateImportDemo.getPayTime()));
		import1.setProviderId(Integer.parseInt(updateImportDemo.getProviderId()));
		import1.setStorehouseId(Integer.parseInt(updateImportDemo
				.getStorehouseId()));
		import1.setProviderName(updateImportDemo.getProviderName());
		import1.setStorehouseName(updateImportDemo.getStorehouseName());
		importService.updateByKey(import1);

		return "SUCCESS";
	}

	public String deleteImportData(String importSerialNumber) {
		List<ImportGoods> importGoodsList = new ArrayList<ImportGoods>();
		ImportGoodsExample example = new ImportGoodsExample();
		if (importSerialNumber != null && importSerialNumber != "") {
			example.createCriteria().andImportSerialNumberEqualTo(
					importSerialNumber);
		}
		importGoodsList = importGoodsService.selectByExample(example);
		importService.deleteImport(importSerialNumber);
		for (ImportGoods importGoods : importGoodsList) {
			importGoodsService.deleteByPrimaryKey(importGoods
					.getImportGoodsId());
		}

		return "SUCCESS";
	}

	public Long getShelifLife(java.util.Date CreateData,
			java.util.Date expirData) {
		long CreateDataLong = CreateData.getTime();
		long expirDataLong = expirData.getTime();
		long shelifLife = (expirDataLong - CreateDataLong)
				/ (1000 * 60 * 60 * 24);
		return shelifLife;
	}

}
