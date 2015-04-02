package com.ai.psims.web.dao;

import java.util.List;

import com.ai.psims.web.model.ImportGoods;

public interface ImportGoodsMapper extends SelectIdMapper{
	int deleteByPrimaryKey(Integer importGoodsId);

    int insert(ImportGoods record);

    int insertSelective(ImportGoods record);

    ImportGoods selectByPrimaryKey(Integer importGoodsId);
    
    List<ImportGoods> selectBySerNum(String importSerialNumber);

    int updateByPrimaryKeySelective(ImportGoods record);

    int updateByPrimaryKey(ImportGoods record);
}
