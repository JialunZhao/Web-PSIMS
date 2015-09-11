package com.ai.psims.web.business.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.business.ISalesbackBusiness;
import com.ai.psims.web.model.AddSalesbackData;
import com.ai.psims.web.model.Sales;
import com.ai.psims.web.model.SalesBackGoodsData;
import com.ai.psims.web.model.SalesGoods;
import com.ai.psims.web.model.SalesGoodsExample;
import com.ai.psims.web.model.SalesGoodsExample.Criteria;
import com.ai.psims.web.model.Salesback;
import com.ai.psims.web.model.SalesbackExample;
import com.ai.psims.web.model.SalesbackGoods;
import com.ai.psims.web.model.SalesbackGoodsExample;
import com.ai.psims.web.model.TbStoragecheck;
import com.ai.psims.web.model.TbStoragecheckExample;
import com.ai.psims.web.service.ISalesGoodsService;
import com.ai.psims.web.service.ISalesService;
import com.ai.psims.web.service.ISalesbackGoodsService;
import com.ai.psims.web.service.ISalesbackService;
import com.ai.psims.web.service.IStoragecheckService;
import com.ai.psims.web.util.Constants;
import com.ai.psims.web.util.CreateIdUtil;

@Service
public class SalesbackBusinessImpl implements ISalesbackBusiness {
	@Resource(name = "salesbackServiceImpl")
	private ISalesbackService salesbackService;
	@Resource(name = "storagecheckServiceImpl")
	private IStoragecheckService storagecheckService;
	@Resource(name = "salesGoodsServiceImpl")
	private ISalesGoodsService salesGoodsService;
	@Resource(name = "salesbackGoodsServiceImpl")
	private ISalesbackGoodsService salesbackGoodsService;
	@Resource(name = "salesServiceImpl")
	private ISalesService salesService;

	@Override
	public List<Salesback> selectSalesback() {
		SalesbackExample salesbackExample = new SalesbackExample();
		salesbackExample.createCriteria().andSalesbackTypeNotEqualTo("00");
		List<Salesback> salesbacksList = new ArrayList<Salesback>();
		salesbacksList = salesbackService.selectByExample(salesbackExample);
		for (Salesback salesback : salesbacksList) {
			salesback.setSalesbackType(CreateIdUtil.getTranslation(salesback
					.getSalesbackType()));
		}
		return salesbacksList;
	}

	@Override
	public Set<String> queryGoodsName(String salesSerialNumber) {
		Set<String> goodsNames = new HashSet<String>();
		List<SalesGoods> salesGoodsList = new ArrayList<SalesGoods>();
		SalesGoodsExample example = new SalesGoodsExample();
		example.createCriteria().andSalesSerialNumberEqualTo(salesSerialNumber);
		salesGoodsList = salesGoodsService.selectSalesGoods(example);
		for (SalesGoods salesGoods : salesGoodsList) {
			goodsNames.add(salesGoods.getGoodsName());
		}
		return goodsNames;
	}

	@Override
	public List<SalesBackGoodsData> getSalesBackGoodsData(String goodsName,
			String backType, String salesSerialNumber) {
		List<SalesBackGoodsData> salesBackGoodsDatasList = new ArrayList<SalesBackGoodsData>();
		int saleCount = 0;
		SalesGoodsExample salesGoodsExample = new SalesGoodsExample();
		Criteria criteria = salesGoodsExample.createCriteria();
		criteria.andGoodsNameEqualTo(goodsName);
		criteria.andSalesSerialNumberEqualTo(salesSerialNumber);
		List<SalesGoods> salesGoodsList = new ArrayList<SalesGoods>();
		salesGoodsList = salesGoodsService.selectSalesGoods(salesGoodsExample);
		for (SalesGoods salesGoods : salesGoodsList) {
			saleCount += salesGoods.getSalesGoodsAmount();
		}
		if (backType.equals(Constants.BackType.BACKGOODS)) {
			for (SalesGoods salesGoods : salesGoodsList) {
				SalesBackGoodsData salesBackGoodsData = new SalesBackGoodsData();
				salesBackGoodsData.setGoodsExpirationDate(salesGoods
						.getSalesGoodsExpirationDate());
				salesBackGoodsData.setGoodsName(salesGoods.getGoodsName());
				salesBackGoodsData.setGoodsProductionDate(salesGoods
						.getSalesGoodsProductionDate());
				salesBackGoodsData.setImportGoodsUnit(salesGoods
						.getSalesGoodsUnit());
				salesBackGoodsData.setSalesCount(salesGoods
						.getSalesGoodsAmount());
				salesBackGoodsData.setStorageId(salesGoods.getStorageId());
				salesBackGoodsData
						.setSalesGoodsId(salesGoods.getSalesGoodsId());
				salesBackGoodsDatasList.add(salesBackGoodsData);
			}

		} else {
			TbStoragecheckExample storagecheckExample = new TbStoragecheckExample();
			storagecheckExample.createCriteria().andGoodsNameEqualTo(goodsName);
			List<TbStoragecheck> storagechecksList = storagecheckService
					.selectByExample(storagecheckExample);
			for (TbStoragecheck storagecheck : storagechecksList) {
				SalesBackGoodsData salesBackGoodsData = new SalesBackGoodsData();
				salesBackGoodsData.setGoodsExpirationDate(storagecheck
						.getGoodsExpirationDate());
				salesBackGoodsData.setGoodsName(storagecheck.getGoodsName());
				salesBackGoodsData.setGoodsProductionDate(storagecheck
						.getGoodsProductionDate());
				salesBackGoodsData.setImportGoodsUnit(storagecheck
						.getImportGoodsUnit());
				salesBackGoodsData.setStorageId(storagecheck.getStorageId());
				salesBackGoodsData.setStorageRateCurrent(storagecheck
						.getStorageRateCurrent());
				salesBackGoodsData.setSalesCount(saleCount);
				salesBackGoodsDatasList.add(salesBackGoodsData);
			}
		}
		return salesBackGoodsDatasList;
	}

	@Override
	public String addSalesbackList(AddSalesbackData addSalesbackData) {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String number = sdf.format(date);
		String salesbackSerialNumber = salesbackService
				.getSalesbackSerialNumber(number);
		if (salesbackSerialNumber == null) {
			salesbackSerialNumber = number + "0000";
		} else {
			salesbackSerialNumber = Long.toString((Long
					.parseLong(salesbackSerialNumber) + 1L));
		}
		String[] storageIds = addSalesbackData.getStorageIdList().split(",");
		String[] changeCounts = addSalesbackData.getChangeCountList()
				.split(",");
		String salesSerialNumber = addSalesbackData.getSalesSerialNumber();
		String backReson = addSalesbackData.getBackReson();
		String backgoodsTime = addSalesbackData.getBackgoodsTime();

		for (int i = 0; i < changeCounts.length; i++) {
			SalesbackGoods salesbackGoods = new SalesbackGoods();
			TbStoragecheck storagecheck = new TbStoragecheck();
			storagecheck = storagecheckService.selectByKey(Integer
					.parseInt(storageIds[i]));
			salesbackGoods.setSalesbackSerialNumber(salesbackSerialNumber);
			salesbackGoods.setGoodsId(storagecheck.getGoodsId());
			salesbackGoods.setGoodsName(storagecheck.getGoodsName());
			salesbackGoods.setGoodsType(Constants.SalesStatus.DOWNORDER);
			salesbackGoods.setGoodsAmount(Integer.parseInt(changeCounts[i]));
			salesbackGoods.setGoodsUnit(storagecheck.getImportGoodsUnit());
			salesbackGoods.setGoodsProduction(storagecheck
					.getGoodsProductionDate());
			salesbackGoods.setGoodsExpiration(storagecheck
					.getGoodsExpirationDate());
			salesbackGoods.setCreatetime(Date.valueOf(backgoodsTime));
			salesbackGoods.setStorageId(storagecheck.getStorageId());

			if (storagecheck.getStorageRateCurrent() == Integer
					.parseInt(changeCounts[i])) {
				storagecheck.setStorageRateCurrent(0);
				storagecheck.setEndtime(new java.util.Date());
				storagecheckService.updateTbStoragecheck(storagecheck);
			} else {
				storagecheck.setStorageRateCurrent(storagecheck
						.getStorageRateCurrent()
						- Integer.parseInt(changeCounts[i]));
				storagecheckService.updateTbStoragecheck(storagecheck);
			}
			salesbackGoodsService.insert(salesbackGoods);
		}
		Sales sales = new Sales();
		sales = salesService.selectByKey(salesSerialNumber);
		Salesback salesback = new Salesback();
		salesback.setSalesbackSerialNumber(salesbackSerialNumber);
		salesback.setSalesSerialNumber(salesSerialNumber);
		salesback.setCustomerId(sales.getCustomerId());
		salesback.setCustomerName(sales.getCustomerName());
		salesback.setStorehouseId(sales.getStorehouseId());
		salesback.setStorehouseName(sales.getStorehouseName());
		salesback.setEmployeeId(sales.getEmployeeId());
		salesback.setEmployeeName(sales.getEmployeeName());
		salesback.setSalesbackType(Constants.BackType.CHANGEGOODS);
		salesback.setSalesbackReason(backReson);
		salesback.setSalesbackTime(Date.valueOf(backgoodsTime));
		salesbackService.insert(salesback);

		return "SUCCESS";
	}

	@Override
	public List<Salesback> querySalesbacks(SalesbackExample example) {
		List<Salesback> salesbacksList = new ArrayList<Salesback>();
		salesbacksList = salesbackService.selectByExample(example);
		for (Salesback salesback : salesbacksList) {
			salesback.setSalesbackType(CreateIdUtil.getTranslation(salesback
					.getSalesbackType()));
		}
		return salesbacksList;
	}

	@Override
	public Salesback selectSalesbackByKey(String salesbackSerialNumber) {
		Salesback salesback = salesbackService
				.selectByPrimaryKey(salesbackSerialNumber);
		salesback.setSalesbackType(CreateIdUtil.getTranslation(salesback
				.getSalesbackType()));
		return salesback;
	}

	@Override
	public List<SalesbackGoods> selectSalesbackGoods(
			SalesbackGoodsExample example) {
		List<SalesbackGoods> salesbackGoodsList = new ArrayList<SalesbackGoods>();
		salesbackGoodsList = salesbackGoodsService.selectByExample(example);
		return salesbackGoodsList;
	}

	@Override
	public String updateSalesbackInfo(String goodsAmountList,
			String salesbackSerialNumber, String salesbackType,
			String salesbackReason, String storageIdList) {
		Salesback salesback = salesbackService
				.selectByPrimaryKey(salesbackSerialNumber);
		SalesbackGoodsExample example = new SalesbackGoodsExample();
		example.createCriteria().andSalesbackSerialNumberEqualTo(
				salesbackSerialNumber);
		List<SalesbackGoods> salesbackGoodsList = salesbackGoodsService
				.selectByExample(example);
		String[] goodsAmounts = goodsAmountList.split(",");
		String[] storageIds = storageIdList.split(",");
		for (int i = 0; i < salesbackGoodsList.size(); i++) {
			int count = salesbackGoodsList.get(i).getGoodsAmount()
					- Integer.parseInt(goodsAmounts[i]);
			if (count != 0) {
				salesbackGoodsList.get(i).setGoodsAmount(
						Integer.parseInt(goodsAmounts[i]));
				TbStoragecheck storagecheck = new TbStoragecheck();
				storagecheck = storagecheckService.selectByKey(Integer
						.parseInt(storageIds[i]));
				if (storagecheck.getStorageRateCurrent() == count) {
					storagecheck.setStorageRateCurrent(0);
					storagecheck.setEndtime(new java.util.Date());
				} else if (storagecheck.getStorageRateCurrent() + count < 0) {
					return "ERROE";
				} else {
					storagecheck.setStorageRateCurrent(storagecheck
							.getStorageRateCurrent() + count);
				}
				salesbackGoodsService.update(salesbackGoodsList.get(i));
				storagecheckService.updateTbStoragecheck(storagecheck);
			}
		}
		salesback.setSalesbackReason(salesbackReason);
		salesback.setSalesbackType(salesbackType);
		salesbackService.update(salesback);
		return "SUCCESS";
	}

	@Override
	public String deleteSalesbackData(String salesbackSerialNumber) {
		SalesbackGoodsExample example = new SalesbackGoodsExample();
		example.createCriteria().andSalesbackSerialNumberEqualTo(
				salesbackSerialNumber);
		List<SalesbackGoods> salesbackGoodsList = salesbackGoodsService
				.selectByExample(example);
		for (SalesbackGoods salesbackGoods : salesbackGoodsList) {
			TbStoragecheck storagecheck = new TbStoragecheck();
			storagecheck = storagecheckService.selectByKey(salesbackGoods
					.getStorageId());
			if (storagecheck.getEndtime() != null) {
				storagecheck.setEndtime(null);
				storagecheck.setStorageRateCurrent(salesbackGoods
						.getGoodsAmount());
				storagecheckService.updateTbStoragecheck(storagecheck);
			} else {
				storagecheck.setStorageRateCurrent(storagecheck
						.getStorageRateCurrent()
						+ salesbackGoods.getGoodsAmount());
				storagecheckService.updateTbStoragecheck(storagecheck);
			}
			salesbackGoodsService.deleteByPrimaryKey(salesbackGoods
					.getSalesbackGoodsId());
		}
		salesbackService.deleteByPrimaryKey(salesbackSerialNumber);
		return "SUCCESS";
	}

}
