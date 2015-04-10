package com.ai.psims.web.business;

import java.util.List;

import com.ai.psims.web.model.Import;
import com.ai.psims.web.model.ImportExample;

public interface IQueryImportList {
	public List<Import> queryImportByColum(ImportExample example);

	public Import selectByPrimaryKey(String importSerialNumber);
}
