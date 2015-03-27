package com.ai.psims.web.service;

import java.util.List;
import java.util.Map;

import com.ai.psims.web.model.GoodsDemo;

public interface IGoodsDemoService {
	public List<GoodsDemo> selectByProvider(String providerName);
	
	public GoodsDemo select(Map<String, String> m);
	
	public int insertGoodsDemo(GoodsDemo goodsDemo);
}
