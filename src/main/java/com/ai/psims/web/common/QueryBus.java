package com.ai.psims.web.common;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.common.interfaces.IQueryBus;
import com.ai.psims.web.dao.ImportMapper;
import com.ai.psims.web.model.Goods;
import com.ai.psims.web.model.Import;
import com.ai.psims.web.model.Provider;
import com.ai.psims.web.model.Storehouse;
import com.ai.psims.web.service.IGoodsService;
import com.ai.psims.web.service.IProviderService;
import com.ai.psims.web.service.IStorehouseService;

@Service
public class QueryBus implements IQueryBus {
	@Resource(name = "providerServiceImpl")
	private IProviderService providerService;
	@Resource(name = "storehouseServiceImpl")
	private IStorehouseService storehouseService;
	@Resource(name="goodsServiceImpl")
	private IGoodsService goodsService;
	@Resource(name="importMapper")
	private ImportMapper importMapper;

	public List<String> queryProvider() {
		List<Provider> pList = new ArrayList<Provider>();
		List<String> providerName = new ArrayList<String>();
		pList = providerService.queryProvider();
		for (Provider provider : pList) {
			providerName.add(provider.getProviderName());
		}
		if (providerName.size() != 0) {
			return providerName;
		} else {
			return null;
		}

	}

	public List<String> queryStorehouse() {
		List<Storehouse> sList = new ArrayList<Storehouse>();
		List<String> storehouseName = new ArrayList<String>();
		sList = storehouseService.queryStorehouse();
		for (Storehouse storehouse : sList) {
			storehouseName.add(storehouse.getStorehouseName());
		}
		if (storehouseName.size() != 0) {
			return storehouseName;
		} else {
			return null;
		}
	}

	public List<Goods> queryGoodsByName(String goodsName) {
		return goodsService.queryGoodsByName(goodsName);
	}

	public List<Import> queryImport() {
		return importMapper.selectAll();
	}
}
