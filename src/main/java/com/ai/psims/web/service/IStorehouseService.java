package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.Storehouse;
import com.ai.psims.web.model.TbStorehouse;
import com.ai.psims.web.model.TbStorehouseExample;

public interface IStorehouseService {
	public Storehouse queryStorehouseByKey(Integer id);
	
	public int deleteStorehouseByKey(Integer id);
	
	public int updateStorehouseByKey(Storehouse Storehouse);
	
	public int insertStorehouse(Storehouse Storehouse);
	
	public List<Storehouse> queryStorehouse();
	/////////////////////////////////////////////////////
	
	public int insertStorehouseInfo(TbStorehouse storehouseAdd);

	public int deleteStorehouseInfo(TbStorehouse storehouseDelete);

	public int modifyStorehouseInfo(TbStorehouse storehouseModify);
	
	public int backupStorehouseInfo(TbStorehouse storehouseBackup);

	public List<TbStorehouse> queryStorehouse(TbStorehouseExample storehouseQuery);
}
