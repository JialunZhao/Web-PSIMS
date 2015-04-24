package com.ai.psims.web.business;

import java.util.List;
import java.util.Set;

import com.ai.psims.web.model.AddSalesbackData;
import com.ai.psims.web.model.SalesBackGoodsData;
import com.ai.psims.web.model.Salesback;
import com.ai.psims.web.model.SalesbackExample;
import com.ai.psims.web.model.SalesbackGoods;
import com.ai.psims.web.model.SalesbackGoodsExample;

public interface ISalesbackBusiness {
	List<Salesback> selectSalesback();

	Set<String> queryGoodsName(String salesSerialNumber);

	List<SalesBackGoodsData> getSalesBackGoodsData(String goodsName,
			String backType, String salesSerialNumber);

	String addSalesbackList(AddSalesbackData addSalesbackData);

	List<Salesback> querySalesbacks(SalesbackExample example);

	Salesback selectSalesbackByKey(String salesbackSerialNumber);

	List<SalesbackGoods> selectSalesbackGoods(SalesbackGoodsExample example);

	String updateSalesbackInfo(String goodsAmountList,
			String salesbackSerialNumber, String salesbackType,
			String salesbackReason, String storageIdList);

	String deleteSalesbackData(String salesbackSerialNumber);
}
