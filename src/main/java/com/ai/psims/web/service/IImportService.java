package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.TbImport;
import com.ai.psims.web.model.TbImportExample;

public interface IImportService {
	public String getImportSerialNumber(String importSerialNumber);

	public int InsertImport(TbImport import1);

	public List<TbImport> selectByExample(TbImportExample example);

	public TbImport selectByPrimaryKey(String importSerialNumber);

	public int updateImport(TbImport import1);

	public int updateByKey(TbImport import1);

	public int deleteImport(String importSerialNumber);

	public int insertToLog(TbImport import1);
}
