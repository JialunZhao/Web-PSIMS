package com.ai.psims.web.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.business.IQueryImportList;
import com.ai.psims.web.model.Import;
import com.ai.psims.web.model.ImportExample;
import com.ai.psims.web.service.IImportService;
import com.ai.psims.web.util.CreateIdUtil;

@Service
public class QueryImportListImpl implements IQueryImportList {
	@Resource(name = "importServiceImpl")
	private IImportService importService;

	public List<Import> queryImportByColum(ImportExample example) {
		List<Import> importList = new ArrayList<Import>();
		importList = importService.selectByExample(example);
		for (Import import1 : importList) {
			import1.setImportStatus(CreateIdUtil.getTranslation(import1.getImportStatus()));
			import1.setPaymentType(CreateIdUtil.getTranslation(import1.getPaymentType()));
		}
		return importList;
	}

	public Import selectByPrimaryKey(String importSerialNumber) {
		Import import1=new Import();
		import1=importService.selectByPrimaryKey(importSerialNumber);
		// import1.setImportStatus(CreateIdUtil.getTranslation(import1.getImportStatus()));
//		import1.setPaymentType(CreateIdUtil.getTranslation(import1.getPaymentType()));
		return import1;
	}

}
