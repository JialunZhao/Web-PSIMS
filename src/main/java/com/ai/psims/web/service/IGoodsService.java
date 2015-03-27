package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.Goods;

public interface IGoodsService {
	public Goods queryGoodsByKey(Integer id);
	
	public int deleteGoodsByKey(Integer id);
	
	public int updateGoodsByKey(Goods goods);
	
	public int insertGoods(Goods goods);
	
	public List<Goods> queryGoodsByName(String goodsName);
}
