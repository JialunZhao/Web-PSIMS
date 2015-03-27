package com.ai.psims.web.dao;

import com.ai.psims.web.model.SalesGoods;

public interface SalesGoodsMapper {
    int deleteByPrimaryKey(Integer salesGoodsId);

    int insert(SalesGoods record);

    int insertSelective(SalesGoods record);

    SalesGoods selectByPrimaryKey(Integer salesGoodsId);

    int updateByPrimaryKeySelective(SalesGoods record);

    int updateByPrimaryKey(SalesGoods record);
}