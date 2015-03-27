package com.ai.psims.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.StorehouseMapper;
import com.ai.psims.web.model.Storehouse;
import com.ai.psims.web.service.IStorehouseService;

@Service
public class StorehouseServiceImpl implements IStorehouseService {
	@Resource(name = "storehouseMapper")
	private StorehouseMapper storehouseMapper;

	public Storehouse queryStorehouseByKey(Integer id) {
		return storehouseMapper.selectByPrimaryKey(id);
	}

	public int deleteStorehouseByKey(Integer id) {
		return storehouseMapper.deleteByPrimaryKey(id);
	}

	public int updateStorehouseByKey(Storehouse Storehouse) {
		return storehouseMapper.updateByPrimaryKey(Storehouse);
	}

	public int insertStorehouse(Storehouse Storehouse) {
		return storehouseMapper.insertSelective(Storehouse);
	}
	
	public List<Storehouse> queryStorehouse() {
		return storehouseMapper.select();
	}

}
