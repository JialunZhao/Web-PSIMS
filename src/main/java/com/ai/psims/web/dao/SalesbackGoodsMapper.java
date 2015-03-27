package com.ai.psims.web.dao;

import com.ai.psims.web.model.SalesbackGoods;

public interface SalesbackGoodsMapper {
    int insert(SalesbackGoods record);

    int insertSelective(SalesbackGoods record);
}