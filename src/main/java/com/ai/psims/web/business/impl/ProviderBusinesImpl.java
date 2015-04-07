package com.ai.psims.web.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.psims.web.business.IProviderBusiness;
import com.ai.psims.web.model.TbProvider;
import com.ai.psims.web.model.TbProviderExample;
import com.ai.psims.web.service.IProviderService;

@Service
public class ProviderBusinesImpl implements IProviderBusiness {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ProviderBusinesImpl.class);
	
	@Resource(name = "providerServiceImpl")
	private IProviderService providerService;

	@Override
	public List<TbProvider> providerQuery(TbProviderExample providerQuery) {
		// 查询客户信息业务
		logger.info("providerQuery");
		return providerService.queryProvider(providerQuery);
	}

	@Override
	public int providerAdd(TbProvider providerAdd) {
		// 新增客户信息业务
		logger.info("providerAdd");
		return providerService.insertProviderInfo(providerAdd);
	}

	@Override
	public int providerDelete(TbProvider providerDelete) {
		// 删除客户信息业务
		providerService.backupProviderInfo(providerDelete);
		logger.info("providerDelete");
		return providerService.deleteProviderInfo(providerDelete);
	}

	@Override
	public int providerModify(TbProvider providerModify) {
		// 修改客户信息业务
		providerService.backupProviderInfo(providerModify);
		logger.info("providerModify");
		return providerService.modifyProviderInfo(providerModify);
	}

}
