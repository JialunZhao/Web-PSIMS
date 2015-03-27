package com.ai.psims.web.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.GoodsDemoMapper;
import com.ai.psims.web.model.GoodsDemo;
import com.ai.psims.web.service.IGoodsDemoService;

@Service
public class GoodsDemoServiceImpl implements IGoodsDemoService {
	@Resource(name = "goodsDemoMapper")
	private GoodsDemoMapper goodsDemoMapper;

	public List<GoodsDemo> selectByProvider(String providerName) {
		return goodsDemoMapper.selectByProvider(providerName);
	}

	public GoodsDemo select(Map<String, String> m) {
		return goodsDemoMapper.selectGoodsDemo(m);
	}

	public int insertGoodsDemo(GoodsDemo goodsDemo) {
		return goodsDemoMapper.insert(goodsDemo);
	}

}
