package com.ai.psims.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.ImportLogMapper;
import com.ai.psims.web.model.ImportLog;
import com.ai.psims.web.service.IImportLogService;
import com.ai.psims.web.util.CreateIdUtil;

@Service
public class ImportLogServiceImpl implements IImportLogService {
	@Resource(name = "importLogMapper")
	private ImportLogMapper importLogMapper;

	public int insertImportLog(ImportLog importLog) {
		importLog.setLogId(CreateIdUtil.getNewId(importLogMapper));
		return importLogMapper.insertSelective(importLog);
	}

}
