package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.Goods;
import com.ai.psims.web.model.GoodsExample;

public interface IGoodsService {
	public List<Goods> selectByExample(GoodsExample example);

	public Goods selectByKey(Integer goodsId);
}
