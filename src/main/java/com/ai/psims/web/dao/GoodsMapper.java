package com.ai.psims.web.dao;

import java.util.List;

import com.ai.psims.web.model.Goods;

public interface GoodsMapper {
	int deleteByPrimaryKey(Integer goodsId);

	int insert(Goods record);

	int insertSelective(Goods record);

	Goods selectByPrimaryKey(Integer goodsId);

	List<Goods> selectByGoodsName(String goodsName);

	int updateByPrimaryKeySelective(Goods record);

	int updateByPrimaryKey(Goods record);
}