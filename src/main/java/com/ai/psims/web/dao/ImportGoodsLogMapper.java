package com.ai.psims.web.dao;

import com.ai.psims.web.model.ImportGoodsLog;

public interface ImportGoodsLogMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(ImportGoodsLog record);

    int insertSelective(ImportGoodsLog record);

    ImportGoodsLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(ImportGoodsLog record);

    int updateByPrimaryKey(ImportGoodsLog record);
}