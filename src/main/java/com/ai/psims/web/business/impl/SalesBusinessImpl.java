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
import com.ai.psims.web.model.TbSystemParameter;
import com.ai.psims.web.service.IGoodsService;
import com.ai.psims.web.service.ISalesGoodsService;
import com.ai.psims.web.service.ISalesService;
import com.ai.psims.web.service.IStoragecheckService;
import com.ai.psims.web.service.ISystemParameterService;
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
	@Resource(name = "systemParameterServiceImpl")
	private ISystemParameterService systemParameterService;

	@Override
	public List<TbStoragecheck> queryStrTbStoragechecks(
			TbStoragecheckExample tbStoragecheckExample) {

		return storagecheckService.selectByExample(tbStoragecheckExample);
	}

	@Override
	public TbStoragecheck selectByKey(Integer storageId) {
		return storagecheckService.selectByKey(storageId);
	}

	@Override
	public TbStoragecheck queryTbStoragecheck(
			TbStoragecheckExample storagecheckExample, int goodsName) {
		List<TbStoragecheck> storagechecksList = new ArrayList<TbStoragecheck>();
		storagechecksList = storagecheckService
				.selectTbStoragecheck(storagecheckExample);
		Integer storageRateCurrent = storagecheckService
				.selectStorageRateCurrentById(goodsName);
		if (storagechecksList.size() > 0) {
			storagechecksList.get(0).setStorageRateCurrent(storageRateCurrent);
			return storagechecksList.get(0);
		} else {
			return null;
		}
	}

	@Override
	public String addSalesList(AddSalesGoodsBean addSalesGoodsBean,
			String remark) {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
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
			TbStoragecheck storagecheck = new TbStoragecheck();
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
			salesGoods.setSalesGoodsUnit(storagecheck.getGoodsUnit());
			salesGoods.setSalesGoodsType(storagecheck.getGoodsType());
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
						storagecheckService.updateTbStoragecheck(storagecheck);
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
			sales.setSalesRemark(remark);
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
		List<SalesGoods> saList = new ArrayList<SalesGoods>();
		saList = salesGoodsService.selectSalesGoods(example);
		for (SalesGoods salesGoods : saList) {
			TbSystemParameter systemParameter = new TbSystemParameter();
			systemParameter = systemParameterService.getSysById(Integer
					.parseInt(salesGoods.getSalesGoodsUnit()));
			salesGoods.setSalesGoodsUnit(systemParameter.getPpDesc());
			salesGoods.setGoodsUnit(systemParameter.getPpDesc());
		}
		for (SalesGoods salesGoods : saList) {
			TbSystemParameter systemParameter = new TbSystemParameter();
			systemParameter = systemParameterService.getSysById(Integer.parseInt(salesGoods.getSalesGoodsType()));
			salesGoods.setSalesGoodsType(systemParameter.getPpDesc());
			salesGoods.setGoodsType(systemParameter.getPpDesc());
		}
		return saList;
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
			TbStoragecheck storagecheck = new TbStoragecheck();
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
						count = count - tbStoragecheck.getStorageRateCurrent();
					} else if (tbStoragecheck.getStorageRateCurrent() == count) {
						storagecheck.setStorageRateCurrent(0);
						storagecheck.setEndtime(new Date());
						storagecheckService
								.updateTbStoragecheck(tbStoragecheck);
						break;
					} else {
						storagecheck.setStorageRateCurrent(storagecheck
								.getStorageRateCurrent() - count);
						storagecheckService.updateTbStoragecheck(storagecheck);
						break;
					}
				}
				storagecheck.setStorageRateCurrent(storagecheck
						.getStorageRateCurrent() + count);
				if (storagecheck.getStorageRateCurrent() == 0) {
					storagecheckService.deleteTbStoragecheck(storagecheck);
				} else {
					storagecheck.setEndtime(null);
					storagecheckService.updateTbStoragecheck(storagecheck);
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
				TbStoragecheck tbStoragecheck = new TbStoragecheck();
				tbStoragecheck = storagecheckService.selectByKey(salesGoods
						.getStorageId());
				if (tbStoragecheck.getEndtime() != null) {
					tbStoragecheck.setEndtime(null);
					tbStoragecheck.setStorageRateCurrent(salesGoods
							.getSalesGoodsAmount());
					storagecheckService.updateTbStoragecheck(tbStoragecheck);
				} else {
					tbStoragecheck.setStorageRateCurrent(tbStoragecheck
							.getStorageRateCurrent()
							+ salesGoods.getSalesGoodsAmount());
					storagecheckService.updateTbStoragecheck(tbStoragecheck);
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
