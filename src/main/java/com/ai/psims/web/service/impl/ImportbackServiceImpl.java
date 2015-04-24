package com.ai.psims.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.ImportbackMapper;
import com.ai.psims.web.model.Importback;
import com.ai.psims.web.model.ImportbackExample;
import com.ai.psims.web.service.IImportbackService;

@Service
public class ImportbackServiceImpl implements IImportbackService {
	@Resource(name = "importbackMapper")
	private ImportbackMapper importbackMapper;

	@Override
	public int insert(Importback importback) {
		return importbackMapper.insertSelective(importback);
	}

	@Override
	public int deleteByPrimaryKey(String importbackSerialNumber) {
		return importbackMapper.deleteByPrimaryKey(importbackSerialNumber);
	}

	@Override
	public int deleteByExample(ImportbackExample example) {
		return importbackMapper.deleteByExample(example);
	}

	@Override
	public List<Importback> selectByExample(ImportbackExample example) {
		return importbackMapper.selectByExample(example);
	}

	@Override
	public Importback selectByPrimaryKey(String importbackSerialNumber) {
		return importbackMapper.selectByPrimaryKey(importbackSerialNumber);
	}

	@Override
	public int updateByPrimaryKey(Importback record) {
		return importbackMapper.updateByPrimaryKeySelective(record);
	}

}
