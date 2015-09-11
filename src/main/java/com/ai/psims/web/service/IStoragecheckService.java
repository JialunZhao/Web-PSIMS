package com.ai.psims.web.service;

import java.util.List;


import com.ai.psims.web.model.TbStoragecheck;
import com.ai.psims.web.model.TbStoragecheckExample;

public interface IStoragecheckService {
	
	public int insert(TbStoragecheck storagecheck) ;

	public List<TbStoragecheck> selectByExample(TbStoragecheckExample example);

	public TbStoragecheck selectByKey(Integer storageId);

	public int deleteTbStoragecheck(TbStoragecheck tbStoragecheck);

	public int updateTbStoragecheck(TbStoragecheck storagecheck);
	
	public List<TbStoragecheck> seekExpiration();

	public List<TbStoragecheck> seekBExpiration();

	public List<TbStoragecheck> seekCExpiration();

	public List<TbStoragecheck> seekDExpiration();

	public List<TbStoragecheck> seekStore();

	public List<TbStoragecheck> seekBStore();

	public List<TbStoragecheck> seekCStore();

	public List<TbStoragecheck> seekDStore();
	
	public List<TbStoragecheck> selectTbStoragecheck(TbStoragecheckExample tbStoragecheckExample);
	
	public List<TbStoragecheck> selectTbStoragecheckByName(String goodsName);
	
	public int selectStorageRateCurrentByName(String goodsName);
	
	public int selectStorageRateCurrentById(int goodsId);

}
