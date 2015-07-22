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
	private TbImportMapper tbImportMapper;
	@Resource(name = "tbImportLogMapper")
	private TbImportLogMapper tbImportLogMapper;

	public int InsertImport(TbImport import1) {
		return tbImportMapper.insert(import1);
	}

	public TbImport selectByPrimaryKey(String importSerialNumber) {
		return tbImportMapper.selectBySerialNumber(importSerialNumber);
	}

	public int updateImport(TbImport import1) {
		insertToLog(import1);
		return tbImportMapper.updateByPrimaryKey(import1);
	}

	public int updateByKey(TbImport import1) {
		insertToLog(import1);
		return tbImportMapper.updateByPrimaryKeySelective(import1);
	}

	public int deleteImport(String importSerialNumber) {
		TbImport import1 = new TbImport();
		import1 = tbImportMapper.selectBySerialNumber(importSerialNumber);
		insertToLog(import1);
		// 00-失效；01-有效
		import1.setImportStatus("00");
		return tbImportMapper.updateByPrimaryKeySelective(import1);
	}

	@Override
	public int insertToLog(TbImport import1) {
		TbImport imports = new TbImport();
		imports = tbImportMapper.selectBySerialNumber(import1
				.getImportSerialNumber());
		TbImportLog log = new TbImportLog();
		log.setLogDatetime(new Date());
		log.setImportId(imports.getImportId());
		log.setImportSerialNumber(imports.getImportSerialNumber());
		log.setImportDatetime(imports.getImportDatetime());
		log.setImportBatchNumber(imports.getImportBatchNumber());
		log.setImportTotalPrice(imports.getImportTotalPrice());
		log.setPaymentStatus(imports.getPaymentStatus());
		log.setPaymentType(imports.getPaymentType());
		log.setPaymentTime(imports.getPaymentTime());
//		log.setPaymentPrice(imports.getPaymentPrice());
		log.setImportType(imports.getImportType());
		log.setImportStatus(imports.getImportStatus());
		log.setImportRemark(imports.getImportRemark());
		log.setProviderId(imports.getProviderId());
		log.setProviderName(imports.getProviderName());
		log.setProviderCode(imports.getProviderCode());

		return tbImportLogMapper.insertSelective(log);
	}

	@Override
	public List<TbImport> selectByExample(TbImportExample example) {
		return tbImportMapper.selectByExample(example);
	}

	@Override
	public String getImportSerialNumber(String importSerialNumber) {
		return tbImportMapper.getImportSerialNumber(importSerialNumber);
	}

}
