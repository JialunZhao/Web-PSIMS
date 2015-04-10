package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.Import;
import com.ai.psims.web.model.ImportExample;

public interface IImportService {
	public String getImportSerialNumber(String importSerialNumber);

	public int InsertImport(Import import1);

	public List<Import> selectByExample(ImportExample example);

	public Import selectByPrimaryKey(String importSerialNumber);

	public int updateImport(Import import1);

	public int updateByKey(Import import1);

	public int deleteImport(String importSerialNumber);

	public int insertToLog(Import import1);
}
