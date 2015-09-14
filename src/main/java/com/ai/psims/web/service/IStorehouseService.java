package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.TbStorehouse;
import com.ai.psims.web.model.TbStorehouseExample;

public interface IStorehouseService {

	public int insertStorehouseInfo(TbStorehouse storehouseAdd);

	public int deleteStorehouseInfo(TbStorehouse storehouseDelete);

	public int modifyStorehouseInfo(TbStorehouse storehouseModify);

	public int backupStorehouseInfo(TbStorehouse storehouseBackup);

	public List<TbStorehouse> queryStorehouse(
			TbStorehouseExample storehouseQuery);
	
	public TbStorehouse selectByPrimaryKey(Integer storehouseId);
}
