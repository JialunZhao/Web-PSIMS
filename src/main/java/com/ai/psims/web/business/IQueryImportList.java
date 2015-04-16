package com.ai.psims.web.business;

import java.util.List;

import com.ai.psims.web.model.TbImport;
import com.ai.psims.web.model.TbImportExample;

public interface IQueryImportList {
	public List<TbImport> queryImportByColum(TbImportExample example);

	public TbImport selectByPrimaryKey(String importSerialNumber);
}
