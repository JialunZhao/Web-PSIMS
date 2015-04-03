package com.ai.psims.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.GoodsMapper;
import com.ai.psims.web.model.Goods;
import com.ai.psims.web.model.GoodsExample;
import com.ai.psims.web.service.IGoodsService;

@Service
public class GoodsServiceImpl implements IGoodsService {
	@Resource(name = "goodsMapper")
	private GoodsMapper goodsMapper;

	public List<Goods> selectByExample(GoodsExample example) {
		return goodsMapper.selectByExample(example);
	}

	@Override
	public Goods selectByKey(Integer goodsId) {
		return goodsMapper.selectByPrimaryKey(goodsId);
	}

}
