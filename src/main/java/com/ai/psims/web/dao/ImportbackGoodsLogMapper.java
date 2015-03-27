package com.ai.psims.web.dao;

import com.ai.psims.web.model.ImportbackGoodsLog;

public interface ImportbackGoodsLogMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(ImportbackGoodsLog record);

    int insertSelective(ImportbackGoodsLog record);

    ImportbackGoodsLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(ImportbackGoodsLog record);

    int updateByPrimaryKey(ImportbackGoodsLog record);
}