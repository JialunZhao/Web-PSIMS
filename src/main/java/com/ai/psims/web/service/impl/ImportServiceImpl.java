package com.ai.psims.web.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.ImportLogMapper;
import com.ai.psims.web.dao.ImportMapper;
import com.ai.psims.web.model.Import;
import com.ai.psims.web.model.ImportExample;
import com.ai.psims.web.model.ImportLog;
import com.ai.psims.web.service.IImportService;

@Service
public class ImportServiceImpl implements IImportService {
	@Resource(name = "importMapper")
	private ImportMapper importMapper;
	@Resource(name = "importLogMapper")
	private ImportLogMapper importLogMapper;

	public int InsertImport(Import import1) {
		return importMapper.insert(import1);
	}

	public Import selectByPrimaryKey(String importSerialNumber) {
		return importMapper.selectByPrimaryKey(importSerialNumber);
	}

	public int updateImport(Import import1) {
		insertToLog(import1);
		return importMapper.updateByPrimaryKey(import1);
	}

	public int updateByKey(Import import1) {
		insertToLog(import1);
		return importMapper.updateByPrimaryKeySelective(import1);
	}

	public int deleteImport(String importSerialNumber) {
		Import import1 = new Import();
		import1 = importMapper.selectByPrimaryKey(importSerialNumber);
		insertToLog(import1);
		// 00-失效；01-有效
		import1.setImportStatus("00");
		return importMapper.updateByPrimaryKeySelective(import1);
	}

	@Override
	public int insertToLog(Import import1) {
		Import imports = new Import();
		imports = importMapper.selectByPrimaryKey(import1
				.getImportSerialNumber());
		ImportLog log = new ImportLog();
		log.setImportBatchNumber(imports.getImportBatchNumber());
		log.setImportDatetime(imports.getImportDatetime());
		log.setImportRemark(imports.getImportRemark());
		log.setImportSerialNumber(imports.getImportSerialNumber());
		log.setImportStatus(imports.getImportStatus());
		log.setImportTotalPrice(imports.getImportTotalPrice());
		log.setImportType(imports.getImportType());
		log.setLogDatetime(new Date());
		log.setPaymentTime(imports.getPaymentTime());
		log.setPaymentType(imports.getPaymentType());
		log.setProviderId(imports.getProviderId());
		log.setProviderName(imports.getProviderName());
		log.setStorehouseId(imports.getStorehouseId());
		log.setStorehouseName(imports.getStorehouseName());

		return importLogMapper.insertSelective(log);
	}

	@Override
	public List<Import> selectByExample(ImportExample example) {
		return importMapper.selectByExample(example);
	}

	@Override
	public String getImportSerialNumber(String importSerialNumber) {
		return importMapper.getImportSerialNumber(importSerialNumber);
	}

}
