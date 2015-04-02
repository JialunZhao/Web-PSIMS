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
import com.ai.psims.web.util.CreateIdUtil;

@Service
public class QueryBus implements IQueryBus {
	@Resource(name = "providerServiceImpl")
	private IProviderService providerService;
	@Resource(name = "storehouseServiceImpl")
	private IStorehouseService storehouseService;
	@Resource(name = "goodsServiceImpl")
	private IGoodsService goodsService;
	@Resource(name = "importMapper")
	private ImportMapper importMapper;

	public List<Provider> queryProvider() {
		List<Provider> pList = new ArrayList<Provider>();
		pList = providerService.queryProvider();
		return pList;
	}

	public List<Storehouse> queryStorehouse() {
		return storehouseService.queryStorehouse();
	}

	public List<Goods> queryGoodsByName(String goodsName) {
		return goodsService.queryGoodsByName(goodsName);
	}

	public List<Import> queryImport() {
		List<Import> importList = new ArrayList<Import>();
		importList =importMapper.selectAll();
		for (Import import1 : importList) {
			import1.setImportStatus(CreateIdUtil.getTranslation(import1.getImportStatus()));
			import1.setPaymentType(CreateIdUtil.getTranslation(import1.getPaymentType()));
		}
		return importList;
	}
}
