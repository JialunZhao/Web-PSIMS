package com.ai.psims.web.dao;

import com.ai.psims.web.model.ImportGoods;

public interface ImportGoodsMapper extends SelectIdMapper{
	int deleteByPrimaryKey(Integer importGoodsId);

    int insert(ImportGoods record);

    int insertSelective(ImportGoods record);

    ImportGoods selectByPrimaryKey(Integer importGoodsId);

    int updateByPrimaryKeySelective(ImportGoods record);

    int updateByPrimaryKey(ImportGoods record);
}
