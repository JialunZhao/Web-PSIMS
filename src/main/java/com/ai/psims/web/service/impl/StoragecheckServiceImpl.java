package com.ai.psims.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.StoragecheckMapper;
import com.ai.psims.web.model.Storagecheck;
import com.ai.psims.web.model.StoragecheckExample;
import com.ai.psims.web.service.IStoragecheckService;

@Service
public class StoragecheckServiceImpl implements IStoragecheckService {
	@Resource(name = "storagecheckMapper")
	private StoragecheckMapper storagecheckMapper;

	@Override
	public int insert(Storagecheck storagecheck) {
		return storagecheckMapper.insertSelective(storagecheck);
	}

	@Override
	public List<Storagecheck> selectByExample(StoragecheckExample example) {
		return storagecheckMapper.selectByExample(example);
	}

	@Override
	public Storagecheck selectByKey(Integer storageId) {
		return storagecheckMapper.selectByPrimaryKey(storageId);
	}

	@Override
	public int deleteStoragecheck(Integer storageId) {
		return storagecheckMapper.deleteByPrimaryKey(storageId);
	}

	@Override
	public int updateStoragecheck(Storagecheck storagecheck) {
		return storagecheckMapper.updateByPrimaryKeySelective(storagecheck);
	}

}
