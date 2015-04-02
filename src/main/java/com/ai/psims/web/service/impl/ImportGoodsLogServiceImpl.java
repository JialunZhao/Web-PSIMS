package com.ai.psims.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.ImportGoodsLogMapper;
import com.ai.psims.web.model.ImportGoodsLog;
import com.ai.psims.web.service.IImportGoodsLogService;
import com.ai.psims.web.util.CreateIdUtil;

@Service
public class ImportGoodsLogServiceImpl implements IImportGoodsLogService {
	@Resource(name = "importGoodsLogMapper")
	private ImportGoodsLogMapper importGoodsLogMapper;

	public int insertImportGoodsLog(ImportGoodsLog importGoodsLog) {
		importGoodsLog.setLogId(CreateIdUtil.getNewId(importGoodsLogMapper));
		return importGoodsLogMapper.insertSelective(importGoodsLog);
	}

}
