package com.ai.psims.web.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.psims.web.business.IStorageCheckBusiness;
import com.ai.psims.web.model.TbStoragecheck;
import com.ai.psims.web.model.TbStoragecheckExample;
import com.ai.psims.web.service.IStoragecheckService;

@Service
public class StorageCheckBusinessImpl implements IStorageCheckBusiness {
	
	private static final Logger logger = LoggerFactory
			.getLogger(StorageCheckBusinessImpl.class);

	@Resource(name = "storagecheckServiceImpl")
	private IStoragecheckService storagecheckServiceImpl;

	
	@Override
	public List<TbStoragecheck> selectStoragecheck(
			TbStoragecheckExample tbStoragecheckExample) {
		logger.info("selectStoragecheck");

		return storagecheckServiceImpl.selectTbStoragecheck(tbStoragecheckExample);
	}
	

}
