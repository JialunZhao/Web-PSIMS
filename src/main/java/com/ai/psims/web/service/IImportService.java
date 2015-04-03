package com.ai.psims.web.service;

import java.util.List;
import java.util.Map;

import com.ai.psims.web.model.Import;

public interface IImportService {
	public String getImportSerialNumber(String importSerialNumber);

	public int InsertImport(Import import1);

	public List<Import> selectAllImport();

	public List<Import> selectByColum(Map<String, String> m);

	public Import selectByPrimaryKey(String importSerialNumber);

	public int updateImport(Import import1);

	public int deleteImport(String importSerialNumber);
}
