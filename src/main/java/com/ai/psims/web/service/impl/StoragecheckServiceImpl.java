package com.ai.psims.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.StoragecheckMapper;
import com.ai.psims.web.model.Storagecheck;
import com.ai.psims.web.service.IStoragecheckService;
import com.ai.psims.web.util.CreateIdUtil;

@Service
public class StoragecheckServiceImpl implements IStoragecheckService {
	@Resource(name = "storagecheckMapper")
	private StoragecheckMapper storagecheckMapper;

	@Override
	public int insert(Storagecheck storagecheck) {
		storagecheck.setStorageId(CreateIdUtil.getNewId(storagecheckMapper));
		return storagecheckMapper.insertSelective(storagecheck);
	}

}
