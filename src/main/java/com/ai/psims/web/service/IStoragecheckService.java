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

	public List<Storagecheck> seekExpiration();

	public List<Storagecheck> seekBExpiration();

	public List<Storagecheck> seekCExpiration();

	public List<Storagecheck> seekDExpiration();

	public List<Storagecheck> seekStore();

	public List<Storagecheck> seekBStore();

	public List<Storagecheck> seekCStore();

	public List<Storagecheck> seekDStore();
}
