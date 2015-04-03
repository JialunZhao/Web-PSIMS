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
import com.ai.psims.web.model.ImportGoodsLog;
import com.ai.psims.web.model.ImportLog;
import com.ai.psims.web.model.Storagecheck;
import com.ai.psims.web.model.UpdateImportDemo;
import com.ai.psims.web.service.IGoodsService;
import com.ai.psims.web.service.IImportGoodsLogService;
import com.ai.psims.web.service.IImportGoodsService;
import com.ai.psims.web.service.IImportLogService;
import com.ai.psims.web.service.IImportService;
import com.ai.psims.web.service.IStoragecheckService;
import com.ai.psims.web.util.Constants;

@Service
public class AddGoodsImportListImpl implements IAddGoodsImportList {
	@Resource(name = "importServiceImpl")
	private IImportService importService;
	@Resource(name = "importGoodsServiceImpl")
	private IImportGoodsService importGoodsService;
	@Resource(name = "importGoodsLogServiceImpl")
	private IImportGoodsLogService importGoodsLogService;
	@Resource(name = "importLogServiceImpl")
	private IImportLogService importLogService;
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
		importGoodsList = importGoodsService.selBySerNum(importSerialNumber);
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
		Import import2 = importService.selectByPrimaryKey(updateImportDemo
				.getImportSerialNumber());
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
				storagecheckService.insert(storagecheck);
			}
			// deleteImportData(updateImportDemo.getImportSerialNumber());

		} else {
			for (ImportGoods importGoods : importGoodsList) {
				ImportGoods importGood = importGoodsService
						.selectByPrimaryKey(importGoods.getImportGoodsId());
				ImportGoodsLog importGoodsLog = getLog(importGood);
				importGoodsLogService.insertImportGoodsLog(importGoodsLog);
				importGoodsService.updateImportGoods(importGoods);
			}
			Import import1 = new Import();
			import1.setImportSerialNumber(updateImportDemo
					.getImportSerialNumber());
			import1.setImportStatus(updateImportDemo.getImportStatus());
			import1.setPaymentType(updateImportDemo.getPaymentType());
			import1.setPaymentTime(Date.valueOf(updateImportDemo.getPayTime()));
			import1.setProviderId(Integer.parseInt(updateImportDemo
					.getProviderId()));
			import1.setStorehouseId(Integer.parseInt(updateImportDemo
					.getStorehouseId()));
			import1.setProviderName(updateImportDemo.getProviderName());
			import1.setStorehouseName(updateImportDemo.getStorehouseName());

			ImportLog importLog = getImpLog(import2);
			importLogService.insertImportLog(importLog);
			importService.updateImport(import1);
		}
		return "SUCCESS";
	}

	public ImportGoodsLog getLog(ImportGoods importGoods) {
		ImportGoodsLog importGoodsLog = new ImportGoodsLog();
		importGoodsLog.setLogDatetime(new java.util.Date());
		importGoodsLog.setImportGoodsId(importGoods.getImportGoodsId());
		importGoodsLog.setImportSerialNumber(importGoods
				.getImportSerialNumber());
		importGoodsLog.setGoodsId(importGoods.getGoodsId());
		importGoodsLog.setGoodsName(importGoods.getGoodsName());
		importGoodsLog.setImportGoodsType(importGoods.getImportGoodsType());
		importGoodsLog.setImportGoodsAmount(importGoods.getImportGoodsAmount());
		importGoodsLog.setImportGoodsUnit(importGoods.getImportGoodsUnit());
		importGoodsLog.setImportGoodsPrice(importGoods.getImportGoodsPrice());
		importGoodsLog.setImportGoodsProductionDate(importGoods
				.getImportGoodsProductionDate());
		importGoodsLog.setImportGoodsExpirationDate(importGoods
				.getImportGoodsExpirationDate());
		importGoodsLog.setImportDiscountAmount(importGoods
				.getImportDiscountAmount());
		importGoodsLog.setImportGoodsCreatetime(importGoods
				.getImportGoodsCreatetime());
		importGoodsLog.setImportGoodsModifytime(importGoods
				.getImportGoodsModifytime());
		importGoodsLog.setImportGoodsEndtime(importGoods
				.getImportGoodsEndtime());
		importGoodsLog.setImportGoodsRemark(importGoods.getImportGoodsRemark());
		importGoodsLog.setImportGoodsTotalPrice(importGoods
				.getImportGoodsTotalPrice());
		return importGoodsLog;
	}

	public ImportLog getImpLog(Import import1) {
		ImportLog importLog = new ImportLog();
		importLog.setLogDatetime(new java.util.Date());
		importLog.setImportSerialNumber(import1.getImportSerialNumber());
		importLog.setImportDatetime(import1.getImportDatetime());
		importLog.setImportBatchNumber(import1.getImportBatchNumber());
		importLog.setImportTotalPrice(import1.getImportTotalPrice());
		importLog.setPaymentType(import1.getPaymentType());
		importLog.setPaymentTime(import1.getPaymentTime());
		importLog.setImportType(import1.getImportType());
		importLog.setImportStatus(import1.getImportStatus());
		importLog.setImportRemark(import1.getImportRemark());
		importLog.setProviderId(import1.getProviderId());
		importLog.setProviderName(import1.getProviderName());
		importLog.setStorehouseId(import1.getStorehouseId());
		importLog.setStorehouseName(import1.getStorehouseName());
		return importLog;
	}

	public String deleteImportData(String importSerialNumber) {
		Import import1 = importService.selectByPrimaryKey(importSerialNumber);
		List<ImportGoods> importGoodsList = new ArrayList<ImportGoods>();
		importGoodsList = importGoodsService.selBySerNum(importSerialNumber);
		ImportLog importLog = getImpLog(import1);
		importLogService.insertImportLog(importLog);
		importService.deleteImport(importSerialNumber);
		for (ImportGoods importGoods : importGoodsList) {
			ImportGoodsLog importGoodsLog = getLog(importGoods);
			importGoodsLogService.insertImportGoodsLog(importGoodsLog);
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
