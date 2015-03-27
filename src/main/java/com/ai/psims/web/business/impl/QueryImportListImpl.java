package com.ai.psims.web.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.business.IQueryImportList;
import com.ai.psims.web.model.Import;
import com.ai.psims.web.service.IImportService;
@Service
public class QueryImportListImpl implements IQueryImportList{
	@Resource(name="importServiceImpl")
	private IImportService importService;

	public List<Import> queryImportByColum(Map<String, String> m) {
		List<Import> importList=new ArrayList<Import>();
		importList=importService.selectByColum(m);
		return importList;
	}

}
