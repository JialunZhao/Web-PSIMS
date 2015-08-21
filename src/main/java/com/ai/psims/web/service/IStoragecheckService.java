package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.Storagecheck;
import com.ai.psims.web.model.StoragecheckExample;
import com.ai.psims.web.model.TbStoragecheck;
import com.ai.psims.web.model.TbStoragecheckExample;

public interface IStoragecheckService {
	public int insert(Storagecheck storagecheck);
	
	public int insert(TbStoragecheck storagecheck) ;

	public List<Storagecheck> selectByExample(StoragecheckExample example);

	public Storagecheck selectByKey(Integer storageId);

	public int deleteStoragecheck(Integer storageId);

	public int updateStoragecheck(Storagecheck storagecheck);
	
	public int updateTbStoragecheck(TbStoragecheck storagecheck);

	public List<Storagecheck> seekExpiration();

	public List<Storagecheck> seekBExpiration();

	public List<Storagecheck> seekCExpiration();

	public List<Storagecheck> seekDExpiration();

	public List<Storagecheck> seekStore();

	public List<Storagecheck> seekBStore();

	public List<Storagecheck> seekCStore();

	public List<Storagecheck> seekDStore();
	
	public List<TbStoragecheck> selectTbStoragecheck(TbStoragecheckExample tbStoragecheckExample);
	
	public List<TbStoragecheck> selectTbStoragecheckByName(String goodsName);
	
	public int selectStorageRateCurrentByName(String goodsName);
	
	public int selectStorageRateCurrentById(int goodsId);

}
