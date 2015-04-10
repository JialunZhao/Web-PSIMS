package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.Storagecheck;
import com.ai.psims.web.model.StoragecheckExample;

public interface IStoragecheckService {
	public int insert(Storagecheck storagecheck);

	public List<Storagecheck> selectByExample(StoragecheckExample example);

	public Storagecheck selectByKey(Integer storageId);

	public int deleteStoragecheck(Integer storageId);

	public int updateStoragecheck(Storagecheck storagecheck);

	public int updateStoragecheckByKey(Storagecheck storagecheck);

	public int insertToLog(Storagecheck storagecheck);
}
