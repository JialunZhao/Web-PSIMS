package com.ai.psims.web.dao;

import com.ai.psims.web.model.RecoveryExport;

public interface RecoveryExportMapper {
    int insert(RecoveryExport record);

    int insertSelective(RecoveryExport record);
}