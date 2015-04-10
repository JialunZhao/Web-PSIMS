package com.ai.psims.web.business.impl;

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
	public String addSalesList(AddSalesGoodsBean addSalesGoodsBean) {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
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
		Long goodsAllPay = 0l;
		for (int i = 0; i < storageIdArray.length; i++) {
			SalesGoods salesGoods = new SalesGoods();
			Storagecheck storagecheck = new Storagecheck();
			storagecheck = storagecheckService.selectByKey(Integer
					.parseInt(storageIdArray[i]));
			goodsAllPay += Long.parseLong(salesCountArray[i])
					* Long.parseLong(salesPriceArray[i]);
			salesGoods.setSalesSerialNumber(salesSerialNumber);
			salesGoods.setGoodsId(storagecheck.getGoodsId());
			salesGoods.setGoodsName(storagecheck.getGoodsName());
			salesGoods
					.setSalesGoodsAmount(Integer.parseInt(salesCountArray[i]));
			salesGoods.setSalesGoodsUnit(storagecheck.getImportGoodsUnit());
			salesGoods.setSalesGoodsPrice(Long.parseLong(salesPriceArray[i]));
			salesGoods.setSalesGoodsProductionDate(storagecheck
					.getGoodsProductionDate());
			salesGoods.setSalesGoodsExpirationDate(storagecheck
					.getGoodsExpirationDate());
			salesGoods.setSalesGoodsTotalPrice(Long
					.parseLong(salesCountArray[i])
					* Long.parseLong(salesPriceArray[i]));
			salesGoods.setStorageId(storagecheck.getStorageId());
			if (storagecheck.getStorageRateCurrent() == Integer
					.parseInt(salesCountArray[i])) {
				storagecheck.setStorageRateCurrent(0);
				storagecheck.setEndtime(new Date());
				storagecheckService.updateStoragecheck(storagecheck);
			} else {
				storagecheck.setStorageRateCurrent(storagecheck
						.getStorageRateCurrent()
						- Integer.parseInt(salesCountArray[i]));
				storagecheckService.updateStoragecheck(storagecheck);
			}
			salesGoodsService.insertSelective(salesGoods);
		}
		Sales sales = new Sales();
		sales.setSalesSerialNumber(salesSerialNumber);
		sales.setSalesDate(new Date());
		sales.setCustomerId(Integer.parseInt(addSalesGoodsBean.getCustomerId()));
		sales.setCustomerName(addSalesGoodsBean.getCustomerName());
		sales.setStorehouseId(Integer.parseInt(addSalesGoodsBean.getStoreId()));
		sales.setStorehouseName(addSalesGoodsBean.getStoreName());
		sales.setEmployeeId(Integer.parseInt(addSalesGoodsBean.getEmployeeId()));
		sales.setEmployeeName(addSalesGoodsBean.getEmployeeName());
		sales.setSalesTotalPrice(goodsAllPay);
		sales.setSalesStatus(Constants.SalesStatus.DOWNORDER);
		salesService.insertSelective(sales);
		return "SUCCESS";
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
	public String updateSalesData(SalesUpdateData salesUpdateData) {
		String[] salesGoodsIds = salesUpdateData.getSalesGoodsIdList().split(
				",");
		String[] goodsAmounts = salesUpdateData.getGoodsAmountList().split(",");
		String salesSerialNumber = salesUpdateData.getSalesSerialNumber();
		Long totalPrice = 0L;
		for (int i = 0; i < goodsAmounts.length; i++) {
			SalesGoods salesGoods = new SalesGoods();
			Storagecheck storagecheck = new Storagecheck();
			salesGoods = salesGoodsService.selectSalesGoodsByKey(Integer
					.parseInt(salesGoodsIds[i]));
			storagecheck = storagecheckService.selectByKey(salesGoods
					.getStorageId());
			totalPrice = totalPrice + salesGoods.getSalesGoodsPrice()
					* Long.parseLong(goodsAmounts[i]);
			int count = salesGoods.getSalesGoodsAmount()
					- Integer.parseInt(goodsAmounts[i]);
			if (count != 0) {
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
				salesGoods2.setSalesGoodsAmount(Integer.parseInt(goodsAmounts[i]));
				salesGoods2.setSalesGoodsTotalPrice(salesGoods.getSalesGoodsPrice()
						* Long.parseLong(goodsAmounts[i]));
				salesGoodsService.updateSalesGoodsByKey(salesGoods2);
			}			
		}
		Sales sales = new Sales();
		if (salesUpdateData.getSalesStatus().equals(
				Constants.SalesStatus.CREDIT)) {
			sales.setCreditCount(Long.parseLong(salesUpdateData
					.getCreditCount()));
		} else if (salesUpdateData.getSalesStatus().equals(
				Constants.SalesStatus.SQUARE)) {
			sales.setIncomeType(salesUpdateData.getPayMed());
			sales.setIncomeTime(java.sql.Date.valueOf(salesUpdateData
					.getPayTime()));
		}
		sales.setSalesStatus(salesUpdateData.getSalesStatus());
		sales.setSalesSerialNumber(salesSerialNumber);
		sales.setSalesTotalPrice(totalPrice);
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
