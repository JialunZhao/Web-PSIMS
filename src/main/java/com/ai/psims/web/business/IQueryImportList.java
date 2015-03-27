package com.ai.psims.web.business;

import java.util.List;
import java.util.Map;

import com.ai.psims.web.model.Import;

public interface IQueryImportList {
	public List<Import> queryImportByColum(Map<String, String> m);
}
