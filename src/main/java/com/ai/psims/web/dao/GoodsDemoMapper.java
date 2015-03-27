package com.ai.psims.web.dao;

import java.util.List;
import java.util.Map;

import com.ai.psims.web.model.GoodsDemo;

public interface GoodsDemoMapper {
    int deleteByPrimaryKey(Integer goodsId);

    int insert(GoodsDemo record);

    int insertSelective(GoodsDemo record);

    GoodsDemo selectByPrimaryKey(Integer goodsId);
    
    GoodsDemo selectGoodsDemo(Map<String, String> m);
    
    List<GoodsDemo> selectByProvider(String providerName);

    int updateByPrimaryKeySelective(GoodsDemo record);

    int updateByPrimaryKey(GoodsDemo record);
}