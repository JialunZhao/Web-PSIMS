package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.Storehouse;

public interface IStorehouseService {
	public Storehouse queryStorehouseByKey(Integer id);
	
	public int deleteStorehouseByKey(Integer id);
	
	public int updateStorehouseByKey(Storehouse Storehouse);
	
	public int insertStorehouse(Storehouse Storehouse);
	
	public List<Storehouse> queryStorehouse();
}
