package com.ai.psims.web.dao;

import com.ai.psims.web.model.RecoveryImport;

public interface RecoveryImportMapper {
    int insert(RecoveryImport record);

    int insertSelective(RecoveryImport record);
}