package com.ai.psims.web.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.business.IImportBackBusiness;
import com.ai.psims.web.model.Importback;
import com.ai.psims.web.model.ImportbackExample;
import com.ai.psims.web.service.IImportbackService;

@Service
public class ImportBackBusinessImpl implements IImportBackBusiness {
	@Resource(name = "importbackServiceImpl")
	private IImportbackService importbackService;

	@Override
	public List<Importback> queryImportback() {
		ImportbackExample example = new ImportbackExample();
		return importbackService.selectByExample(example);
	}

}
