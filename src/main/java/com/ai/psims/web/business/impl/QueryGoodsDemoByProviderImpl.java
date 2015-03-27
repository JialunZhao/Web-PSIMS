package com.ai.psims.web.business.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.business.IQueryGoodsDemoByProvider;
import com.ai.psims.web.model.GoodsDemo;
import com.ai.psims.web.service.IGoodsDemoService;

@Service
public class QueryGoodsDemoByProviderImpl implements IQueryGoodsDemoByProvider {
	@Resource(name = "goodsDemoServiceImpl")
	private IGoodsDemoService goodsDemoService;

	public List<GoodsDemo> queryGoodsDemo(String providerName) {
		return goodsDemoService.selectByProvider(providerName);
	}

	public GoodsDemo select(String goodsName, String providerName) {
		Map<String, String> m=new HashMap<String, String>();
		m.put("goodsName", goodsName);
		m.put("providerName", providerName);
		return goodsDemoService.select(m);
	}
}
