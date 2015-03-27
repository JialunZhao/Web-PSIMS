package com.ai.psims.web.business.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.business.IAddGoodsImportList;
import com.ai.psims.web.model.AddGoodsBean;
import com.ai.psims.web.model.Import;
import com.ai.psims.web.model.ImportGoods;
import com.ai.psims.web.service.IImportGoodsService;
import com.ai.psims.web.service.IImportService;

@Service
public class AddGoodsImportListImpl implements IAddGoodsImportList {
	@Resource(name = "importServiceImpl")
	private IImportService importService;
	@Resource(name = "importGoodsServiceImpl")
	private IImportGoodsService importGoodsService;

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
		int n = (goodsArray.length) / 8;
		for (int i = 0; i < n; i++) {
			int j = i * 8;
			goodsAllPay += Long.parseLong(goodsArray[6 + j]);
			ImportGoods goodsDemo = new ImportGoods();
			goodsDemo.setGoodsName(goodsArray[0 + j]);
			goodsDemo.setImportGoodsUnit(goodsArray[1 + j]);
			goodsDemo.setImportGoodsAmount(Integer.parseInt(goodsArray[2 + j]));
			goodsDemo.setImportGoodsPrice(Long.parseLong(goodsArray[3 + j]));
			goodsDemo.setImportGoodsProductionDate(Date
					.valueOf(goodsArray[4 + j]));
			goodsDemo.setImportGoodsExpirationDate(Date
					.valueOf(goodsArray[5 + j]));
			goodsDemo.setImportSerialNumber(importSerialNumber);
			goodsDemo.setImportGoodsType(goodsBean.getPayStatus());
			goodsDemo.setImportGoodsCreatetime(Date.valueOf(goodsBean
					.getImportcreatetime()));
			importGoodsService.insertImportGoods(goodsDemo);
		}

		Import import1 = new Import();
		import1.setImportSerialNumber(importSerialNumber);
		import1.setImportTotalPrice(goodsAllPay * 1000);
		import1.setPaymentType(goodsBean.getPayMed());
		import1.setImportDatetime(Date.valueOf(goodsBean
				.getImportcreatetime()));
		import1.setProviderName(goodsBean.getProviderName());
		import1.setStorehouseName(goodsBean.getStoreName());
		import1.setPaymentType(goodsBean.getPayMed());
		importService.InsertImport(import1);
		return "SUCCESS";
	}
	
	
}
