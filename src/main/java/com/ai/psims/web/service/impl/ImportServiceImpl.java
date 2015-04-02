package com.ai.psims.web.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.ImportMapper;
import com.ai.psims.web.model.Import;
import com.ai.psims.web.service.IImportService;

@Service
public class ImportServiceImpl implements IImportService {
	@Resource(name = "importMapper")
	private ImportMapper importMapper;

	public String getImportSerialNumber(String importSerialNumber) {
		return importMapper.selectImportSerialNumber(importSerialNumber);
	}

	public int InsertImport(Import import1) {
		return importMapper.insert(import1);
	}

	public List<Import> selectAllImport() {
		return importMapper.selectAll();
	}

	public List<Import> selectByColum(Map<String, String> m) {
		return importMapper.selectByColum(m);
	}

	public Import selectByPrimaryKey(String importSerialNumber) {
		return importMapper.selectByPrimaryKey(importSerialNumber);
	}

	public int updateImport(Import import1) {
		return importMapper.updateByPrimaryKeySelective(import1);
	}

	public int deleteImport(String importSerialNumber) {
		return importMapper.deleteByPrimaryKey(importSerialNumber);
	}

}
