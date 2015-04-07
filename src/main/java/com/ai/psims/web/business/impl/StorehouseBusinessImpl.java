package com.ai.psims.web.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.psims.web.business.IStorehouseBusiness;
import com.ai.psims.web.model.TbStorehouse;
import com.ai.psims.web.model.TbStorehouseExample;
import com.ai.psims.web.service.IStorehouseService;

@Service
public class StorehouseBusinessImpl implements IStorehouseBusiness {
	
	private static final Logger logger = LoggerFactory
			.getLogger(StorehouseBusinessImpl.class);
	
	@Resource(name = "storehouseServiceImpl")
	private IStorehouseService storehouseService;

	@Override
	public List<TbStorehouse> storehouseQuery(TbStorehouseExample storehouseQuery) {
		// 查询客户信息业务
		logger.info("storehouseQuery");
		return storehouseService.queryStorehouse(storehouseQuery);
	}

	@Override
	public int storehouseAdd(TbStorehouse storehouseAdd) {
		// 新增客户信息业务
		logger.info("storehouseAdd");
		return storehouseService.insertStorehouseInfo(storehouseAdd);
	}

	@Override
	public int storehouseDelete(TbStorehouse storehouseDelete) {
		// 删除客户信息业务
		storehouseService.backupStorehouseInfo(storehouseDelete);
		logger.info("storehouseDelete");
		return storehouseService.deleteStorehouseInfo(storehouseDelete);
	}

	@Override
	public int storehouseModify(TbStorehouse storehouseModify) {
		// 修改客户信息业务
		storehouseService.backupStorehouseInfo(storehouseModify);
		logger.info("storehouseModify");
		return storehouseService.modifyStorehouseInfo(storehouseModify);
	}

}
