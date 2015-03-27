package com.ai.psims.web.dao;

import com.ai.psims.web.model.ImportbackGoods;

public interface ImportbackGoodsMapper {
    int deleteByPrimaryKey(String importbackGoodsId);

    int insert(ImportbackGoods record);

    int insertSelective(ImportbackGoods record);

    ImportbackGoods selectByPrimaryKey(String importbackGoodsId);

    int updateByPrimaryKeySelective(ImportbackGoods record);

    int updateByPrimaryKey(ImportbackGoods record);
}