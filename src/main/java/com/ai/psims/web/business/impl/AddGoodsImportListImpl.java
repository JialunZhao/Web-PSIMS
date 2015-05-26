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
import com.ai.psims.web.model.TbImport;
import com.ai.psims.web.model.TbImportGoods;
import com.ai.psims.web.model.TbImportGoodsExample;
import com.ai.psims.web.model.TbImportGoodsExample.Criteria;
import com.ai.psims.web.model.Storagecheck;
import com.ai.psims.web.model.TbProvider;
import com.ai.psims.web.model.UpdateImportDemo;
import com.ai.psims.web.service.IGoodsService;
import com.ai.psims.web.service.IImportGoodsService;
import com.ai.psims.web.service.IImportService;
import com.ai.psims.web.service.IProviderService;
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
	@Resource(name = "providerServiceImpl")
	private IProviderService providerService;

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
		Long prizePool = 0l;
		String isDiscount, haveBox;
		long goodsPrice, discountRate, haveBoxNamePrice;
		int goodsCount;		
		String[] goodsArray = goodsBean.getGoodList().split(",");
		int n = (goodsArray.length) / 12;
		for (int i = 0; i < n; i++) {
			int j = i * 12;
			goodsCount = Integer.parseInt(goodsArray[5 + j]);
			goodsPrice = (long) (Float.parseFloat(goodsArray[6 + j]) * 1000);
			isDiscount = goodsArray[7 + j];
			discountRate = (long) (Float.parseFloat(goodsArray[8 + j]) * 10);
			haveBox = goodsArray[9 + j];
			haveBoxNamePrice = (long) (Float.parseFloat(goodsArray[10 + j]) * 1000);
			TbImportGoods goodsDemo = new TbImportGoods();
			goodsDemo.setGoodsId(Integer.parseInt(goodsArray[0 + j]));
			goodsDemo.setGoodsName(goodsArray[2 + j]);
			goodsDemo.setImportGoodsUnit(goodsArray[3 + j]);
			goodsDemo.setImportGoodsAmount(goodsCount);
			goodsDemo.setResImportGoodsAmount(goodsCount);
			goodsDemo.setImportSerialNumber(importSerialNumber);
			goodsDemo.setImportGoodsPrice(goodsPrice);
			goodsDemo.setGoodsShelfLife(Integer.parseInt(goodsArray[4 + j]));
			goodsDemo.setTotalPrice(goodsCount * goodsPrice);
			goodsDemo.setDiscountRate(discountRate);
			goodsDemo.setDiscountDutyTotalPrice((long) (goodsCount
					* goodsPrice * (1 - discountRate * 1.0 / 1000)));
			goodsDemo.setDiscountTotalPrice((long) ((goodsCount
					* goodsPrice * discountRate * 1.0 / 1000) / 1.17));
			goodsDemo.setBoxBottlePrice(haveBoxNamePrice);
			goodsDemo.setBoxBottleTotalPrice(haveBoxNamePrice * goodsCount);
			if (isDiscount.equals(Constants.DiscountMed.YES01)) {
				goodsDemo.setIsDiscount(Constants.DiscountMed.YES);
			} else {
				goodsDemo.setIsDiscount(Constants.DiscountMed.NO);
			}
			if (haveBox.equals(Constants.DiscountMed.YES01)) {
				goodsDemo.setIsBoxBottle(Constants.DiscountMed.YES);
				
			} else {
				goodsDemo.setIsBoxBottle(Constants.DiscountMed.NO);
			}
			goodsAllPay = (long) (goodsAllPay + haveBoxNamePrice * goodsCount
					+ goodsCount * goodsPrice - (goodsCount * goodsPrice
					* discountRate * 1.0 / 1000) / 1.17);
			prizePool+=(long)(((goodsCount * goodsPrice
					* discountRate * 1.0 / 1000) / 1.17)*1000);
			goodsDemo.setImportGoodsCreatetime(Date.valueOf(goodsBean
					.getImportcreatetime()));
			importGoodsService.insertImportGoods(goodsDemo);
		}

		TbImport import1 = new TbImport();
		import1.setImportSerialNumber(importSerialNumber);
		import1.setImportTotalPrice(goodsAllPay);
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
		if (prizePool!=0) {
			TbProvider provider=new TbProvider();
			provider=providerService.selectProvider(Integer.parseInt(goodsBean.getProviderId()));
			provider.setProviderPrizePool(Integer.parseInt(provider.getProviderPrizePool())-prizePool+"");
			providerService.modifyProviderInfo(provider);
		}		
		importService.InsertImport(import1);
		return "SUCCESS";
	}

	public List<TbImportGoods> selBySerNum(String importSerialNumber) {
		List<TbImportGoods> importGoodsList = new ArrayList<TbImportGoods>();
		TbImportGoodsExample example = new TbImportGoodsExample();
		Criteria criteria = example.createCriteria();
		if (importSerialNumber != null && importSerialNumber != "") {
			criteria.andImportSerialNumberEqualTo(importSerialNumber);
		}
		criteria.andImportGoodsEndtimeIsNull();
		importGoodsList = importGoodsService.selectByExample(example);
		return importGoodsList;
	}

	public String updateImportGoods(UpdateImportDemo updateImportDemo) {
		List<TbImportGoods> importGoodsList = new ArrayList<TbImportGoods>();
		List<TbImportGoods> begigImportGoodsList = new ArrayList<TbImportGoods>();
		importGoodsList = updateImportDemo.getImportGoodsList();
		for (TbImportGoods importGoods : importGoodsList) {
			TbImportGoods importGood = importGoodsService
					.selectByPrimaryKey(importGoods.getImportGoodsId());
			begigImportGoodsList.add(importGood);
		}
		TbImport imports = importService.selectByPrimaryKey(updateImportDemo
				.getImportSerialNumber());
		long totalPrice = imports.getImportTotalPrice();
		long goodsAllPay = 0l;
		int i = 0, goodsCount;
		long goodsPrice, discountRate, haveBoxNamePrice;
		String isDiscount, haveBox;
		for (TbImportGoods importGoods : importGoodsList) {
			TbImportGoods iGoods = begigImportGoodsList.get(i);
			goodsCount = iGoods.getImportGoodsAmount();
			if (importGoods.getImportGoodsAmount() != goodsCount) {
				goodsCount = importGoods.getImportGoodsAmount();
				goodsPrice = iGoods.getImportGoodsPrice();
				discountRate = iGoods.getDiscountRate();
				haveBoxNamePrice = iGoods.getBoxBottlePrice();
				isDiscount = iGoods.getIsDiscount();
				haveBox = iGoods.getIsBoxBottle();
				importGoods.setTotalPrice(goodsCount*goodsPrice);
				if (isDiscount.equals(Constants.DiscountMed.YES)) {
					importGoods.setDiscountDutyTotalPrice((long) (goodsCount
							* goodsPrice * (1 - discountRate * 1.0 / 1000)));
					importGoods.setDiscountTotalPrice((long) ((goodsCount
							* goodsPrice * discountRate * 1.0 / 1000) / 1.17));
				}
				if (haveBox.equals(Constants.DiscountMed.YES)) {
					importGoods.setBoxBottlePrice(haveBoxNamePrice);
					importGoods.setBoxBottleTotalPrice(haveBoxNamePrice
							* goodsCount);
				}
				goodsAllPay = goodsAllPay
						+ importGoods.getBoxBottleTotalPrice()
						+ importGoods.getTotalPrice()
						- importGoods.getDiscountTotalPrice();
				importGoodsService.updateByKey(importGoods);
			} else {
				goodsAllPay = goodsAllPay + iGoods.getBoxBottleTotalPrice()
						+ iGoods.getTotalPrice()
						- iGoods.getDiscountTotalPrice();
			}

			i++;
		}
		TbImport import1 = new TbImport();
		import1.setImportSerialNumber(updateImportDemo.getImportSerialNumber());
		import1.setImportStatus(updateImportDemo.getImportStatus());
		import1.setPaymentType(updateImportDemo.getPaymentType());
		import1.setPaymentTime(Date.valueOf(updateImportDemo.getPayTime()));
		import1.setProviderId(Integer.parseInt(updateImportDemo.getProviderId()));
		import1.setProviderName(updateImportDemo.getProviderName());
		if (goodsAllPay != totalPrice) {
			import1.setImportTotalPrice(goodsAllPay);
		}
		importService.updateByKey(import1);

		return "SUCCESS";
	}

	public String deleteImportData(String importSerialNumber) {
		List<TbImportGoods> importGoodsList = new ArrayList<TbImportGoods>();
		TbImportGoodsExample example = new TbImportGoodsExample();
		if (importSerialNumber != null && importSerialNumber != "") {
			example.createCriteria().andImportSerialNumberEqualTo(
					importSerialNumber);
		}
		importGoodsList = importGoodsService.selectByExample(example);
		importService.deleteImport(importSerialNumber);
		for (TbImportGoods importGoods : importGoodsList) {
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

	@Override
	public List<String> getGoodsName(String importSerialNumber) {
		List<String> goodsNames = new ArrayList<String>();
		List<TbImportGoods> importGoodsList = new ArrayList<TbImportGoods>();
		TbImportGoodsExample example = new TbImportGoodsExample();
		Criteria criteria = example.createCriteria();
		criteria.andImportSerialNumberEqualTo(importSerialNumber);
		criteria.andResImportGoodsAmountGreaterThan(0);
		importGoodsList = importGoodsService.selectByExample(example);
		for (TbImportGoods importGoods : importGoodsList) {
			goodsNames.add(importGoods.getGoodsName());
		}
		return goodsNames;
	}

	@Override
	public List<TbImportGoods> queryImportGoods(TbImportGoodsExample example) {
		return importGoodsService.selectByExample(example);
	}

	@Override
	public String goodsImport(String goodList, String importSerialNumber,
			String storeName, String storeId) {
		String[] goodsArray = goodList.split(",");
		int n = (goodsArray.length) / 5;
		int importCount;
		TbImportGoodsExample example = new TbImportGoodsExample();
		for (int i = 0; i < n; i++) {
			int j = i * 5;
			Criteria criteria = example.createCriteria();
			criteria.andImportSerialNumberEqualTo(importSerialNumber);
			criteria.andGoodsNameEqualTo(goodsArray[0 + j]);
			TbImportGoods importGoods = importGoodsService.selectByExample(
					example).get(0);
			importCount = Integer.parseInt(goodsArray[1 + j]);
			Storagecheck storagecheck = new Storagecheck();
			Goods goods = goodsService.selectByKey(importGoods.getGoodsId());
			storagecheck.setGoodsId(importGoods.getGoodsId());
			storagecheck.setGoodsName(importGoods.getGoodsName());
			storagecheck.setProviderId(goods.getProviderId());
			storagecheck.setProviderName(goods.getProviderName());
			storagecheck.setStorageRateTotal(importCount);
			storagecheck.setStorageRateCurrent(importCount);
			storagecheck
					.setGoodsProductionDate(Date.valueOf(goodsArray[2 + j]));
			storagecheck
					.setGoodsExpirationDate(Date.valueOf(goodsArray[3 + j]));
			storagecheck.setGoodsShelfLife(goods.getGoodsShelfLife());
			storagecheck.setGoodsPrice(goods.getGoodsPrice());
			storagecheck.setGoodsStatus(Constants.ImportGoodsStatus.CANSALE);
			storagecheck.setImportSerialNumber(importGoods
					.getImportSerialNumber());
			storagecheck.setCreatetime(new java.util.Date());
			storagecheck.setImportGoodsUnit(goods.getGoodsUnit());
			storagecheck.setStorageWarning(goods.getStorageWarning());
			storagecheck.setShelfLifeWarning(goods.getShelfLifeWarning());
			storagecheckService.insert(storagecheck);

			importGoods.setResImportGoodsAmount(importGoods
					.getResImportGoodsAmount() - importCount);
			importGoodsService.updateByKey(importGoods);

		}

		List<TbImportGoods> importGoodsList = selBySerNum(importSerialNumber);
		TbImport import1 = importService.selectByPrimaryKey(importSerialNumber);
		int resCount = 0;
		for (TbImportGoods importGoods : importGoodsList) {
			resCount += importGoods.getResImportGoodsAmount();
		}
		if (resCount == 0) {
			import1.setImportStatus(Constants.ImportStatus.GOODSARRIVAL);
		} else {
			import1.setImportStatus(Constants.ImportStatus.GOODSLITARRIVAL);
		}
		importService.updateByKey(import1);

		return "SUCCESS";
	}

}
