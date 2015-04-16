package com.ai.psims.web.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.TbImportLogMapper;
import com.ai.psims.web.dao.TbImportMapper;
import com.ai.psims.web.model.TbImport;
import com.ai.psims.web.model.TbImportExample;
import com.ai.psims.web.model.TbImportLog;
import com.ai.psims.web.service.IImportService;

@Service
public class ImportServiceImpl implements IImportService {
	@Resource(name = "tbImportMapper")
	private TbImportMapper importMapper;
	@Resource(name = "tbImportLogMapper")
	private TbImportLogMapper importLogMapper;

	public int InsertImport(TbImport import1) {
		return importMapper.insert(import1);
	}

	public TbImport selectByPrimaryKey(String importSerialNumber) {
		return importMapper.selectByPrimaryKey(importSerialNumber);
	}

	public int updateImport(TbImport import1) {
		insertToLog(import1);
		return importMapper.updateByPrimaryKey(import1);
	}

	public int updateByKey(TbImport import1) {
		insertToLog(import1);
		return importMapper.updateByPrimaryKeySelective(import1);
	}

	public int deleteImport(String importSerialNumber) {
		TbImport import1 = new TbImport();
		import1 = importMapper.selectByPrimaryKey(importSerialNumber);
		insertToLog(import1);
		// 00-失效；01-有效
		import1.setImportStatus("00");
		return importMapper.updateByPrimaryKeySelective(import1);
	}

	@Override
	public int insertToLog(TbImport import1) {
		TbImport imports = new TbImport();
		imports = importMapper.selectByPrimaryKey(import1
				.getImportSerialNumber());
		TbImportLog log = new TbImportLog();
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

		return importLogMapper.insertSelective(log);
	}

	@Override
	public List<TbImport> selectByExample(TbImportExample example) {
		return importMapper.selectByExample(example);
	}

	@Override
	public String getImportSerialNumber(String importSerialNumber) {
		return importMapper.getImportSerialNumber(importSerialNumber);
	}

}
