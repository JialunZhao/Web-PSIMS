package com.ai.psims.web.dao;

import com.ai.psims.web.model.Storagecheck;

public interface StoragecheckMapper {
    int insert(Storagecheck record);

    int insertSelective(Storagecheck record);
}