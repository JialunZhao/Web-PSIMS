package com.ai.psims.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.StorehouseLogMapper;
import com.ai.psims.web.model.StorehouseLog;
import com.ai.psims.web.service.IStorehouseLogService;

@Service
public class StorehouseLogServiceImpl implements IStorehouseLogService {
	@Resource(name = "storehouseLogMapper")
	private StorehouseLogMapper storehouseLogMapper;

	public StorehouseLog queryStorehouseLogByKey(Integer id) {
		return storehouseLogMapper.selectByPrimaryKey(id);
	}

	public int deleteStorehouseLogByKey(Integer id) {
		return storehouseLogMapper.deleteByPrimaryKey(id);
	}

	public int updateStorehouseLogByKey(StorehouseLog StorehouseLog) {
		return storehouseLogMapper.updateByPrimaryKey(StorehouseLog);
	}

	public int insertStorehouseLog(StorehouseLog StorehouseLog) {
		return storehouseLogMapper.insertSelective(StorehouseLog);
	}

}
