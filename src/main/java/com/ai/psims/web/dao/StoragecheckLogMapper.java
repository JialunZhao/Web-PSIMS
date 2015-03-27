package com.ai.psims.web.dao;

import com.ai.psims.web.model.StoragecheckLog;

public interface StoragecheckLogMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(StoragecheckLog record);

    int insertSelective(StoragecheckLog record);

    StoragecheckLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(StoragecheckLog record);

    int updateByPrimaryKey(StoragecheckLog record);
}