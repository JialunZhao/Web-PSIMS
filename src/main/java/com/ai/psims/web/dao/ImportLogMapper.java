package com.ai.psims.web.dao;

import com.ai.psims.web.model.ImportLog;

public interface ImportLogMapper extends SelectIdMapper {
	int deleteByPrimaryKey(Integer logId);

	int insert(ImportLog record);

	int insertSelective(ImportLog record);

	ImportLog selectByPrimaryKey(Integer logId);

	int updateByPrimaryKeySelective(ImportLog record);

	int updateByPrimaryKey(ImportLog record);
}