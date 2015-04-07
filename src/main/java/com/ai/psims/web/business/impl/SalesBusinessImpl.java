package com.ai.psims.web.business.impl;

import java.text.SimpleDateFormat;
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
import com.ai.psims.web.model.Storagecheck;
import com.ai.psims.web.model.StoragecheckExample;
import com.ai.psims.web.service.ISalesGoodsService;
import com.ai.psims.web.service.ISalesService;
import com.ai.psims.web.service.IStoragecheckService;
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
				storagecheckService.deleteStoragecheck(storagecheck
						.getStorageId());
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
		if (addSalesGoodsBean.getPayTime() != null
				&& addSalesGoodsBean.getPayTime() != "") {
			sales.setIncomeTime(java.sql.Date.valueOf(addSalesGoodsBean
					.getPayTime()));
			sales.setIncomeType(addSalesGoodsBean.getPayMed());
		}
		sales.setSalesStatus(addSalesGoodsBean.getPayStatus());
		salesService.insertSelective(sales);
		return "SUCCESS";
	}

	@Override
	public List<Sales> selectByExample(SalesExample example) {
		List<Sales> salesList = salesService.selectByExample(example);
		for (Sales sales : salesList) {
			if (sales.getIncomeType() != null && sales.getIncomeType() != "") {
				sales.setIncomeType(CreateIdUtil.getTranslation(sales
						.getIncomeType()));
			}
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

}
