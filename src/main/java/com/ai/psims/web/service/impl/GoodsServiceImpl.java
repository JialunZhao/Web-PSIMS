package com.ai.psims.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.GoodsMapper;
import com.ai.psims.web.model.Goods;
import com.ai.psims.web.service.IGoodsService;

@Service
public class GoodsServiceImpl implements IGoodsService {
	@Resource(name="goodsMapper")
	private GoodsMapper goodsMapper;

	public Goods queryGoodsByKey(Integer id) {
		return goodsMapper.selectByPrimaryKey(id);
	}

	public int deleteGoodsByKey(Integer id) {
		return goodsMapper.deleteByPrimaryKey(id);
	}

	public int updateGoodsByKey(Goods goods) {
		return goodsMapper.updateByPrimaryKey(goods);
	}

	public int insertGoods(Goods goods) {
		return goodsMapper.insertSelective(goods);
	}

	public List<Goods> queryGoodsByName(String goodsName) {
		return goodsMapper.selectByGoodsName(goodsName);
	}

}
