package com.ai.psims.web.business.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.business.ISalesBusiness;
import com.ai.psims.web.model.AddSalesGoodsBean;
import com.ai.psims.web.model.Sales;
import com.ai.psims.web.model.SalesExample;
import com.ai.psims.web.model.SalesGoods;
import com.ai.psims.web.model.SalesGoodsExample;
import com.ai.psims.web.model.SalesUpdateData;
import com.ai.psims.web.model.Storagecheck;
import com.ai.psims.web.model.StoragecheckExample;
import com.ai.psims.web.model.TbGoods;
import com.ai.psims.web.model.TbStoragecheck;
import com.ai.psims.web.model.TbStoragecheckExample;
import com.ai.psims.web.service.IGoodsService;
import com.ai.psims.web.service.ISalesGoodsService;
import com.ai.psims.web.service.ISalesService;
import com.ai.psims.web.service.IStoragecheckService;
import com.ai.psims.web.util.Constants;
import com.ai.psims.web.util.CreateIdUtil;

@Service
public class SalesBusinessImpl implements ISalesBusiness {
	@Resource(name = "storagecheckServiceImpl")
	private IStoragecheckService storagecheckService;
	@Resource(name = "salesServiceImpl")
	private ISalesService salesService;
	@Resource(name = "salesGoodsServiceImpl")
	private ISalesGoodsService salesGoodsService;
	@Resource(name = "goodsServiceImpl")
	private IGoodsService goodsService;

	@Override
	public List<Storagecheck> queryStrStoragechecks(
			StoragecheckExample storagecheckExample) {

		return storagecheckService.selectByExample(storagecheckExample);
	}

	@Override
	public Storagecheck selectByKey(Integer storageId) {
		return storagecheckService.selectByKey(storageId);
	}

	@Override
	public TbStoragecheck queryStoragecheck(
			TbStoragecheckExample storagecheckExample, String goodsName) {
		List<TbStoragecheck> storagechecksList = new ArrayList<TbStoragecheck>();
		storagechecksList = storagecheckService
				.selectTbStoragecheck(storagecheckExample);
		Integer storageRateCurrent = storagecheckService
				.selectStorageRateCurrentByName(goodsName);
		if (storagechecksList.size() > 0) {
			storagechecksList.get(0).setStorageRateCurrent(storageRateCurrent);
			return storagechecksList.get(0);
		} else {
			return null;
		}
	}

	@Override
	public String addSalesList(AddSalesGoodsBean addSalesGoodsBean) {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		String number = sdf.format(date);
		String salesSerialNumber = salesService.selectSalesSerialNumber(number);
		if (salesSerialNumber == null) {
			salesSerialNumber = number + "0000";
		} else {
			salesSerialNumber = Long.toString((Long
					.parseLong(salesSerialNumber) + 1L));
		}
		String[] storageIdArray = addSalesGoodsBean.getStorageIdList().split(
				",");
		String[] salesCountArray = addSalesGoodsBean.getSalesCountList().split(
				",");
		String[] salesPriceArray = addSalesGoodsBean.getSalesPriceList().split(
				",");
		BigDecimal totalPriceBD = new BigDecimal(0);
		boolean falg = true;
		for (int i = 0; i < storageIdArray.length; i++) {
			SalesGoods salesGoods = new SalesGoods();
			Storagecheck storagecheck = new Storagecheck();
			TbGoods goods = new TbGoods();
			storagecheck = storagecheckService.selectByKey(Integer
					.parseInt(storageIdArray[i]));

			int storeRateCurrt = storagecheckService
					.selectStorageRateCurrentByName(storagecheck.getGoodsName());
			if (storeRateCurrt < Integer.parseInt(salesCountArray[i])) {
				falg = false;
				break;
			}

			goods = goodsService.selectGoodsInfo(storagecheck.getGoodsId());
			BigDecimal salesPriceBD = new BigDecimal(salesPriceArray[i])
					.divide(new BigDecimal(1), 2, BigDecimal.ROUND_HALF_UP);
			BigDecimal goodsAmountBD = new BigDecimal(salesCountArray[i]);
			totalPriceBD = salesPriceBD.multiply(goodsAmountBD).add(
					totalPriceBD);
			salesGoods.setSalesSerialNumber(salesSerialNumber);
			salesGoods.setGoodsId(storagecheck.getGoodsId());
			salesGoods.setGoodsName(storagecheck.getGoodsName());
			salesGoods
					.setSalesGoodsAmount(Integer.parseInt(salesCountArray[i]));
			salesGoods.setSalesGoodsUnit(storagecheck.getImportGoodsUnit());
			salesGoods.setSalesGoodsPrice(salesPriceArray[i]);
			salesGoods.setSalesGoodsProductionDate(storagecheck
					.getGoodsProductionDate());
			salesGoods.setSalesGoodsExpirationDate(storagecheck
					.getGoodsExpirationDate());
			salesGoods.setSalesGoodsCreatetime(new java.util.Date());
			salesGoods.setSalesGoodsTotalPrice(salesPriceBD.multiply(
					goodsAmountBD).toString());
			salesGoods.setStorageId(storagecheck.getStorageId());

			salesGoods.setGoodsCurrentStock(goods.getGoodsCurrentStock());
			salesGoods.setGoodsTotalStock(goods.getGoodsTotalStock());
			salesGoods.setGoodsActualCost(goods.getGoodsActualCost());
			salesGoods.setGoodsPrice(goods.getGoodsPrice());
			salesGoods.setGoodsProfit(goods.getGoodsProfit());
			salesGoods.setGoodsType(goods.getGoodsType());
			salesGoods.setGoodsStatus(goods.getGoodsStatus());
			salesGoods.setGoodsDiscount(goods.getGoodsDiscount());
			salesGoods.setSingleRebate(goods.getSingleRebate());
			salesGoods.setQuarterRebate(goods.getQuarterRebate());
			salesGoods.setAnnualRebate(goods.getAnnualRebate());
			salesGoods.setPromotionRebate(goods.getPromotionRebate());
			salesGoods.setPurchaseRebate(goods.getPurchaseRebate());
			salesGoods.setProviderSubsidy(goods.getProviderSubsidy());
			salesGoods.setCustomerBottleSubsidy(goods
					.getCustomerBottleSubsidy());
			salesGoods.setProviderPackageSubsidy(goods
					.getProviderPackageSubsidy());
			salesGoods.setCustomerSubsidy(goods.getCustomerSubsidy());
			salesGoods.setOtherSubsidy(goods.getOtherSubsidy());
			salesGoods.setSingleFinalCost(goods.getSingleFinalCost());

			List<TbStoragecheck> storagechecks = new ArrayList<TbStoragecheck>();
			storagechecks = storagecheckService
					.selectTbStoragecheckByName(storagecheck.getGoodsName());
			int salesCount = Integer.parseInt(salesCountArray[i]);
			if (storagechecks != null) {
				for (int j = 0; j < storagechecks.size(); j++) {
					TbStoragecheck tbStoragecheck = storagechecks.get(j);
					if (tbStoragecheck.getStorageRateCurrent() < salesCount) {
						storagecheck.setStorageRateCurrent(0);
						storagecheck.setEndtime(new Date());
						storagecheckService
								.updateTbStoragecheck(tbStoragecheck);
						salesCount = salesCount
								- tbStoragecheck.getStorageRateCurrent();
					} else if (tbStoragecheck.getStorageRateCurrent() == salesCount) {
						storagecheck.setStorageRateCurrent(0);
						storagecheck.setEndtime(new Date());
						storagecheckService
								.updateTbStoragecheck(tbStoragecheck);
						break;
					} else {
						storagecheck.setStorageRateCurrent(storagecheck
								.getStorageRateCurrent() - salesCount);
						storagecheckService.updateStoragecheck(storagecheck);
						break;
					}
				}
			}
			//
			// if (storagecheck.getStorageRateCurrent() == Integer
			// .parseInt(salesCountArray[i])) {
			// storagecheck.setStorageRateCurrent(0);
			// storagecheck.setEndtime(new Date());
			// storagecheckService.updateStoragecheck(storagecheck);
			// } else {
			// storagecheck.setStorageRateCurrent(storagecheck
			// .getStorageRateCurrent()
			// - Integer.parseInt(salesCountArray[i]));
			// storagecheckService.updateStoragecheck(storagecheck);
			// }
			salesGoodsService.insertSelective(salesGoods);
		}
		if (falg) {
			Sales sales = new Sales();
			sales.setSalesSerialNumber(salesSerialNumber);
			sales.setSalesDate(new Date());
			sales.setCustomerId(Integer.parseInt(addSalesGoodsBean
					.getCustomerId()));
			sales.setCustomerName(addSalesGoodsBean.getCustomerName());
			sales.setStorehouseId(Integer.parseInt(addSalesGoodsBean
					.getStoreId()));
			sales.setStorehouseName(addSalesGoodsBean.getStoreName());
			sales.setEmployeeId(Integer.parseInt(addSalesGoodsBean
					.getEmployeeId()));
			sales.setEmployeeName(addSalesGoodsBean.getEmployeeName());
			sales.setTotalSalesAmount(totalPriceBD.toString());
			sales.setSalesStatus(Constants.SalesStatus.DOWNORDER);
			salesService.insertSelective(sales);
			return "SUCCESS";
		} else {
			return "ERROR";
		}

	}

	@Override
	public List<Sales> selectByExample(SalesExample example) {
		List<Sales> salesList = salesService.selectByExample(example);
		for (Sales sales : salesList) {
			sales.setSalesStatus(CreateIdUtil.getTranslation(sales
					.getSalesStatus()));
		}
		return salesList;
	}

	@Override
	public Sales selectSalesByKey(String salesSerialNumber) {
		return salesService.selectByKey(salesSerialNumber);
	}

	@Override
	public List<SalesGoods> selectSalesGoods(SalesGoodsExample example) {
		return salesGoodsService.selectSalesGoods(example);
	}

	@Override
	public String updateSalesData(SalesUpdateData salesUpdateData, Sales sales) {
		String[] salesGoodsIds = salesUpdateData.getSalesGoodsIdList().split(
				",");
		String[] goodsAmounts = salesUpdateData.getGoodsAmountList().split(",");
		String salesSerialNumber = salesUpdateData.getSalesSerialNumber();
		float totalPrice = 0.0f;
		for (int i = 0; i < goodsAmounts.length; i++) {
			SalesGoods salesGoods = new SalesGoods();
			Storagecheck storagecheck = new Storagecheck();
			salesGoods = salesGoodsService.selectSalesGoodsByKey(Integer
					.parseInt(salesGoodsIds[i]));
			List<TbStoragecheck> storagechecksList = storagecheckService
					.selectTbStoragecheckByName(salesGoods.getGoodsName());
			storagecheck = storagecheckService.selectByKey(salesGoods
					.getStorageId());
			totalPrice = totalPrice
					+ Float.parseFloat(salesGoods.getSalesGoodsPrice())
					* Long.parseLong(goodsAmounts[i]);
			int count = salesGoods.getSalesGoodsAmount()
					- Integer.parseInt(goodsAmounts[i]);
			if (count != 0) {
				for (int j = 0; j < storagechecksList.size(); j++) {
					TbStoragecheck tbStoragecheck = storagechecksList.get(j);
					if (tbStoragecheck.getStorageRateCurrent() < count) {
						storagecheck.setStorageRateCurrent(0);
						storagecheck.setEndtime(new Date());
						storagecheckService
								.updateTbStoragecheck(tbStoragecheck);
						count = count
								- tbStoragecheck.getStorageRateCurrent();
					} else if (tbStoragecheck.getStorageRateCurrent() == count) {
						storagecheck.setStorageRateCurrent(0);
						storagecheck.setEndtime(new Date());
						storagecheckService
								.updateTbStoragecheck(tbStoragecheck);
						break;
					} else {
						storagecheck.setStorageRateCurrent(storagecheck
								.getStorageRateCurrent() - count);
						storagecheckService.updateStoragecheck(storagecheck);
						break;
					}
				}
				storagecheck.setStorageRateCurrent(storagecheck
						.getStorageRateCurrent() + count);
				if (storagecheck.getStorageRateCurrent() == 0) {
					storagecheckService.deleteStoragecheck(storagecheck
							.getStorageId());
				} else {
					storagecheck.setEndtime(null);
					storagecheckService.updateStoragecheck(storagecheck);
				}
				SalesGoods salesGoods2 = new SalesGoods();
				salesGoods2.setSalesGoodsId(Integer.parseInt(salesGoodsIds[i]));
				salesGoods2.setSalesGoodsAmount(Integer
						.parseInt(goodsAmounts[i]));
				salesGoods2.setSalesGoodsTotalPrice((Float
						.parseFloat(salesGoods.getSalesGoodsPrice()) * Long
						.parseLong(goodsAmounts[i]))
						+ "");
				salesGoodsService.updateSalesGoodsByKey(salesGoods2);
			}
		}
		// Sales sales = new Sales();
		if (salesUpdateData.getSalesStatus().equals(
				Constants.SalesStatus.SQUARE)) {
			sales.setIncomeType(salesUpdateData.getPayMed());
			sales.setIncomeTime(java.sql.Date.valueOf(salesUpdateData
					.getPayTime()));
		}
		sales.setSalesStatus(salesUpdateData.getSalesStatus());
		sales.setSalesSerialNumber(salesSerialNumber);
		sales.setTotalSalesAmount(totalPrice + "");
		salesService.updateSalesByKey(sales);
		return "SUCCESS";
	}

	@Override
	public String deleteSalesData(String salesSerialNumber) {
		SalesGoodsExample example = new SalesGoodsExample();
		example.createCriteria().andSalesSerialNumberEqualTo(salesSerialNumber);
		if (salesSerialNumber != null && salesSerialNumber != "") {
			example.createCriteria().andSalesSerialNumberEqualTo(
					salesSerialNumber);
			List<SalesGoods> salesGoodsList = new ArrayList<SalesGoods>();
			salesGoodsList = salesGoodsService.selectSalesGoods(example);
			for (SalesGoods salesGoods : salesGoodsList) {
				Storagecheck storagecheck = new Storagecheck();
				storagecheck = storagecheckService.selectByKey(salesGoods
						.getStorageId());
				if (storagecheck.getEndtime() != null) {
					storagecheck.setEndtime(null);
					storagecheck.setStorageRateCurrent(salesGoods
							.getSalesGoodsAmount());
					storagecheckService.updateStoragecheck(storagecheck);
				} else {
					storagecheck.setStorageRateCurrent(storagecheck
							.getStorageRateCurrent()
							+ salesGoods.getSalesGoodsAmount());
					storagecheckService.updateStoragecheck(storagecheck);
				}
				salesGoodsService.deleteByPrimaryKey(salesGoods
						.getSalesGoodsId());
			}
			salesService.deleteSales(salesSerialNumber);
			return "SUCCESS";
		}
		return "ERROR";
	}

}
