package com.ai.psims.web.service;

import com.ai.psims.web.model.StorehouseLog;

public interface IStorehouseLogService {
	public StorehouseLog queryStorehouseLogByKey(Integer id);
	
	public int deleteStorehouseLogByKey(Integer id);
	
	public int updateStorehouseLogByKey(StorehouseLog StorehouseLog);
	
	public int insertStorehouseLog(StorehouseLog StorehouseLog);
}
