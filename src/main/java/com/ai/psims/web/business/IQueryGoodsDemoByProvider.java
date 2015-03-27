package com.ai.psims.web.business;

import java.util.List;

import com.ai.psims.web.model.GoodsDemo;

public interface IQueryGoodsDemoByProvider {
	public List<GoodsDemo> queryGoodsDemo(String providerName);
	
	public GoodsDemo select(String goodsName,String providerName);
}
