package com.ai.psims.web.business.impl;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.psims.web.business.IImporBusiness;
import com.ai.psims.web.model.AddGoodsBean;
import com.ai.psims.web.model.Goods;
import com.ai.psims.web.model.TbGoods;
import com.ai.psims.web.model.TbImport;
import com.ai.psims.web.model.TbImportGoods;
import com.ai.psims.web.model.TbImportGoodsExample;
import com.ai.psims.web.model.TbImportGoodsExample.Criteria;
import com.ai.psims.web.model.Storagecheck;
import com.ai.psims.web.model.TbProvider;
import com.ai.psims.web.model.TbStoragecheck;
import com.ai.psims.web.model.TbSystemParameter;
import com.ai.psims.web.model.UpdateImportDemo;
import com.ai.psims.web.service.IGoodsService;
import com.ai.psims.web.service.IImportGoodsService;
import com.ai.psims.web.service.IImportService;
import com.ai.psims.web.service.IProviderService;
import com.ai.psims.web.service.IStoragecheckService;
import com.ai.psims.web.service.ISystemParameterService;
import com.ai.psims.web.util.Constants;

@Service
public class ImporBusinessImpl implements IImporBusiness {
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

	@Resource(name = "systemParameterServiceImpl")
	private ISystemParameterService systemParameterService;

	private static final Logger logger = LoggerFactory
			.getLogger(ImporBusinessImpl.class);

	public String addGoodsList(AddGoodsBean goodsBean) {

		logger.info("addGoodsList");

		TbImport tbImport = new TbImport();
		String prizePool = new String();
		String providerName = new String();
		String goodsAllPay = null;
		// Long prizePool = 0l;

		// 获取入库流水号
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
		// 获取供应商信息
		TbProvider providerInfo = providerService.selectProvider(goodsBean
				.getTbImport().getProviderId());
		tbImport.setProviderId(goodsBean.getTbImport().getProviderId());
		tbImport.setProviderName(providerInfo.getProviderName());
		tbImport.setProviderCode(providerInfo.getProviderCode());
		tbImport.setImportRemark(goodsBean.getTbImport().getImportRemark());
		BigDecimal importTotalPrice = new BigDecimal(0);

		// 获取商品信息及数量
		List<TbImportGoods> goodsArray = goodsBean.getGoodList();
		int n = goodsArray.size();
		for (int i = 0; i < n; i++) {
			// 获取奖金池信息
			prizePool = systemParameterService.getSystemParameterPrizePool(
					Integer.parseInt(providerInfo.getProviderPrizePool()))
					.getPpValue();
			// 获取商品原始折扣率等商品信息
			TbGoods tbGoods = new TbGoods();
			tbGoods = goodsService.selectGoodsInfo(goodsArray.get(i)
					.getGoodsId());
			// 校验前台获取的商品价格和折扣率
			if (!tbGoods.getGoodsActualCost().equals(
					goodsArray.get(i).getImportGoodsPrice())) {
				return "商品价格校验失败";
			}
			if (!tbGoods.getGoodsPrizePoolRatio().equals(
					goodsArray.get(i).getImportDiscountRate())) {
				return "商品奖金池折扣校验失败";
			}

			// 单项商品总价：（正价销售总额(含税)）
			BigDecimal goodsPriceBD = new BigDecimal(goodsArray.get(i)
					.getImportGoodsPrice()); // 100
			BigDecimal goodsAmountBD = new BigDecimal(goodsArray.get(i)
					.getImportGoodsAmount()); // 100
			BigDecimal totalPriceBD = goodsPriceBD.multiply(goodsAmountBD); // 10000=100*100
			BigDecimal discountRateBD = new BigDecimal(goodsArray.get(i)
					.getImportDiscountRate()); // 60%
			BigDecimal importDiscountPriceBD = goodsPriceBD.multiply(
					discountRateBD).multiply(new BigDecimal(0.01)); // 60=100*60%
			importTotalPrice = importTotalPrice.add(totalPriceBD);
			// 奖金池使用总额(未税)
			BigDecimal prizePoolUsedBD = goodsPriceBD.multiply(goodsAmountBD)
					.multiply(discountRateBD)
					.divide(new BigDecimal(117), 3, BigDecimal.ROUND_HALF_UP);
			// 折扣销售总额(含税)
			BigDecimal prizePoolBD = new BigDecimal(prizePool);
			BigDecimal discountDutyTotalPriceBD = new BigDecimal(0); // =总价-奖金池使用金额
			if (prizePoolUsedBD.compareTo(prizePoolBD) == 1) {
				// 折扣额大于奖金池金额 ： goodsPrice*goodsCount-(prizePool*1.17);
				discountDutyTotalPriceBD = totalPriceBD.subtract(prizePoolBD
						.multiply(new BigDecimal(1.17)));
				prizePoolUsedBD = prizePoolBD;
			} else {
				// 折扣额小于奖金池金额 ：goodsPrice*goodsCount*(100-discountRate)/100;
				discountDutyTotalPriceBD = totalPriceBD.multiply(
						new BigDecimal(100).subtract(discountRateBD)).divide(
						new BigDecimal(100), 3, BigDecimal.ROUND_HALF_UP);
			}

			goodsArray.get(i).setGoodsName(tbGoods.getGoodsName());
			;
			goodsArray.get(i).setImportGoodsTotalPrice(totalPriceBD.toString());
			goodsArray.get(i).setImportGoodsCreatetime(new java.util.Date());
			// goodsArray.get(i).setImportGoodsRemark(goodsBean.getTbImport().getImportRemark());
			goodsArray.get(i).setImportDiscountPrice(
					importDiscountPriceBD.toString());
			goodsArray.get(i).setImportTotalPrice(totalPriceBD.toString());
			goodsArray.get(i).setDiscountDutyTotalPrice(
					discountDutyTotalPriceBD.toString());
			goodsArray.get(i).setDiscountGoodsTotalPrice(
					discountDutyTotalPriceBD.toString());
			goodsArray.get(i)
					.setImportId(goodsBean.getTbImport().getImportId());
			goodsArray.get(i).setImportSerialNumber(importSerialNumber);
			goodsArray.get(i).setImportDatetime(
					goodsBean.getTbImport().getImportDatetime());
			// goodsArray.get(i).setImportType();
			// goodsArray.get(i).setImportStatus();
			goodsArray.get(i).setImportRemark(
					goodsBean.getTbImport().getImportRemark());
			goodsArray.get(i).setPaymentType(
					goodsBean.getTbImport().getPaymentType());
			goodsArray.get(i).setPaymentTime(
					goodsBean.getTbImport().getPaymentTime());
			goodsArray.get(i).setProviderId(tbImport.getProviderId());
			goodsArray.get(i).setProviderCode(tbImport.getProviderCode());
			goodsArray.get(i).setProviderName(tbImport.getProviderName());

			importGoodsService.insertImportGoods(goodsArray.get(i));

			// 奖金池金额更新
			if (prizePool != null) {
				TbSystemParameter tbSystemParameter = new TbSystemParameter();
				tbSystemParameter = systemParameterService
						.getSystemParameterPrizePool(goodsBean.getProviderId());
				tbSystemParameter.setPpValue(new BigDecimal(tbSystemParameter
						.getPpValue()).subtract(prizePoolUsedBD).toString());
				systemParameterService.update(tbSystemParameter);
			}
		}

		tbImport.setImportSerialNumber(importSerialNumber);
		tbImport.setImportTotalPrice(goodsAllPay);
		tbImport.setPaymentType(goodsBean.getPayMed());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		ParsePosition pos = new ParsePosition(0);
		java.util.Date strtodate = formatter.parse(
				goodsBean.getImportcreatetime(), pos);
		tbImport.setImportDatetime(strtodate);
		tbImport.setImportTotalPrice(importTotalPrice.toString());
		if (goodsBean.getPayStatus().equals(Constants.PayStatus.NOPAY)) {
			tbImport.setImportStatus(Constants.ImportStatus.ORDERNOPAY);
		} else {
			tbImport.setImportStatus(Constants.ImportStatus.ORDERYESPAY);
			tbImport.setPaymentType(goodsBean.getPayMed());
			tbImport.setPaymentTime(Date.valueOf(goodsBean.getPayTime()));
		}

		//
		// String[] goodsArray = goodsBean.getGoodList().split(",");
		// int n = (goodsArray.length) / 12;
		// for (int i = 0; i < n; i++) {
		// int j = i * 12;
		// goodsCount = Integer.parseInt(goodsArray[5 + j]);
		// goodsPrice = (long) (Float.parseFloat(goodsArray[6 + j]) * 1000);
		// isDiscount = goodsArray[7 + j];
		// discountRate = (long) (Float.parseFloat(goodsArray[8 + j]) * 10);
		// haveBox = goodsArray[9 + j];
		// haveBoxNamePrice = (long) (Float.parseFloat(goodsArray[10 + j]) *
		// 1000);
		// TbImportGoods goodsDemo = new TbImportGoods();
		// goodsDemo.setGoodsId(Integer.parseInt(goodsArray[0 + j]));
		// goodsDemo.setGoodsName(goodsArray[2 + j]);
		// goodsDemo.setImportGoodsUnit(goodsArray[3 + j]);
		// goodsDemo.setImportGoodsAmount(goodsCount);
		// goodsDemo.setResImportGoodsAmount(goodsCount);
		// goodsDemo.setImportSerialNumber(importSerialNumber);
		// goodsDemo.setImportGoodsPrice(goodsPrice);
		// goodsDemo.setGoodsShelfLife(Integer.parseInt(goodsArray[4 + j]));
		// goodsDemo.setTotalPrice(goodsCount * goodsPrice);
		// goodsDemo.setDiscountRate(discountRate);
		// goodsDemo.setDiscountDutyTotalPrice((long) (goodsCount
		// * goodsPrice * (1 - discountRate * 1.0 / 1000)));
		// goodsDemo.setDiscountTotalPrice((long) ((goodsCount
		// * goodsPrice * discountRate * 1.0 / 1000) / 1.17));
		// goodsDemo.setBoxBottlePrice(haveBoxNamePrice);
		// goodsDemo.setBoxBottleTotalPrice(haveBoxNamePrice * goodsCount);
		// if (isDiscount.equals(Constants.DiscountMed.YES01)) {
		// goodsDemo.setIsDiscount(Constants.DiscountMed.YES);
		// } else {
		// goodsDemo.setIsDiscount(Constants.DiscountMed.NO);
		// }
		// if (haveBox.equals(Constants.DiscountMed.YES01)) {
		// goodsDemo.setIsBoxBottle(Constants.DiscountMed.YES);
		//
		// } else {
		// goodsDemo.setIsBoxBottle(Constants.DiscountMed.NO);
		// }
		// goodsAllPay = (long) (goodsAllPay + haveBoxNamePrice * goodsCount
		// + goodsCount * goodsPrice - (goodsCount * goodsPrice
		// * discountRate * 1.0 / 1000) / 1.17);
		// prizePool+=(long)(((goodsCount * goodsPrice
		// * discountRate * 1.0 / 1000) / 1.17)*1000);
		// goodsDemo.setImportGoodsCreatetime(Date.valueOf(goodsBean
		// .getImportcreatetime()));
		// importGoodsService.insertImportGoods(goodsDemo);
		// }

		// TbProvider provider=new TbProvider();
		// provider=providerService.selectProvider(Integer.parseInt(goodsBean.getProviderId()));
		// provider.setProviderPrizePool(Integer.parseInt(provider.getProviderPrizePool())-prizePool+"");
		// providerService.modifyProviderInfo(provider);

		importService.InsertImport(tbImport);
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
		List<TbImportGoods> beginImportGoodsList = new ArrayList<TbImportGoods>();
		importGoodsList = updateImportDemo.getImportGoodsList();
		for (TbImportGoods importGoods : importGoodsList) {
			TbImportGoods importGood = importGoodsService
					.selectByPrimaryKey(importGoods.getImportGoodsId());
			beginImportGoodsList.add(importGood);
		}
		TbImport imports = importService.selectByPrimaryKey(updateImportDemo
				.getImportSerialNumber());
		String totalPrice = imports.getImportTotalPrice();
		String goodsAllPay = null;
		int i = 0, goodsCount;
		String goodsPrice, discountRate, haveBoxNamePrice;
		String isDiscount, haveBox;
		for (TbImportGoods importGoods : importGoodsList) {
			TbImportGoods iGoods = beginImportGoodsList.get(i);
			goodsCount = iGoods.getImportGoodsAmount();
			if (importGoods.getImportGoodsAmount() != goodsCount) {
				goodsCount = importGoods.getImportGoodsAmount();
				goodsPrice = iGoods.getImportGoodsPrice();
				discountRate = iGoods.getImportDiscountRate();
				haveBoxNamePrice = iGoods.getBoxBottlePrice();
				isDiscount = iGoods.getIsDiscount();
				haveBox = iGoods.getIsBoxBottle();
				// importGoods.setTotalPrice(goodsCount*goodsPrice);
				// if (isDiscount.equals(Constants.DiscountMed.YES)) {
				// importGoods.setDiscountDutyTotalPrice((long) (goodsCount
				// * goodsPrice * (1 - discountRate * 1.0 / 1000)));
				// importGoods.setDiscountTotalPrice((long) ((goodsCount
				// * goodsPrice * discountRate * 1.0 / 1000) / 1.17));
				// }
				// if (haveBox.equals(Constants.DiscountMed.YES)) {
				// importGoods.setBoxBottlePrice(haveBoxNamePrice);
				// importGoods.setBoxBottleTotalPrice(haveBoxNamePrice
				// * goodsCount);
				// }
				// goodsAllPay = goodsAllPay
				// + importGoods.getBoxBottleTotalPrice()
				// + importGoods.getTotalPrice()
				// - importGoods.getDiscountTotalPrice();
				// importGoodsService.updateByKey(importGoods);
				// } else {
				// goodsAllPay = goodsAllPay + iGoods.getBoxBottleTotalPrice()
				// + iGoods.getTotalPrice()
				// - iGoods.getDiscountTotalPrice();
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
			TbStoragecheck storagecheck = new TbStoragecheck();
			TbGoods tbGoods = goodsService.selectGoodsInfo(importGoods
					.getGoodsId());
			storagecheck.setGoodsId(importGoods.getGoodsId());
			storagecheck.setGoodsName(importGoods.getGoodsName());
			storagecheck.setGoodsCode(importGoods.getGoodsCode());
			storagecheck.setProviderId(tbGoods.getProviderId());
			storagecheck.setProviderName(tbGoods.getProviderName());
			storagecheck.setStorageRateTotal(importCount);
			storagecheck.setStorageRateCurrent(importCount);
			storagecheck
					.setGoodsProductionDate(Date.valueOf(goodsArray[2 + j]));
			storagecheck
					.setGoodsExpirationDate(Date.valueOf(goodsArray[3 + j]));
			storagecheck.setGoodsShelfLife(tbGoods.getGoodsShelfLife());
			storagecheck.setGoodsPrice(tbGoods.getGoodsPrice());
			storagecheck.setGoodsStatus(Constants.ImportGoodsStatus.CANSALE);
			storagecheck.setImportSerialNumber(importGoods
					.getImportSerialNumber());
			storagecheck.setCreatetime(new java.util.Date());
			storagecheck.setImportGoodsUnit(tbGoods.getGoodsUnit());
			storagecheck.setStorageWarning(tbGoods.getStorageWarning());
			storagecheck.setShelfLifeWarning(tbGoods.getShelfLifeWarning());
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