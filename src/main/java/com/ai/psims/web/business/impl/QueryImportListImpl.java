package com.ai.psims.web.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.business.IQueryImportList;
import com.ai.psims.web.model.TbImport;
import com.ai.psims.web.model.TbImportExample;
import com.ai.psims.web.service.IImportService;
import com.ai.psims.web.util.CreateIdUtil;

@Service
public class QueryImportListImpl implements IQueryImportList {
	@Resource(name = "importServiceImpl")
	private IImportService importService;

	public List<TbImport> queryImportByColum(TbImportExample example) {
		List<TbImport> importList = new ArrayList<TbImport>();
		importList = importService.selectByExample(example);
		for (TbImport import1 : importList) {
			import1.setImportStatus(CreateIdUtil.getTranslation(import1.getImportStatus()));
			import1.setPaymentType(CreateIdUtil.getTranslation(import1.getPaymentType()));
		}
		return importList;
	}

	public TbImport selectByPrimaryKey(String importSerialNumber) {
		TbImport import1=new TbImport();
		import1=importService.selectByPrimaryKey(importSerialNumber);
		// import1.setImportStatus(CreateIdUtil.getTranslation(import1.getImportStatus()));
//		import1.setPaymentType(CreateIdUtil.getTranslation(import1.getPaymentType()));
		return import1;
	}

}
