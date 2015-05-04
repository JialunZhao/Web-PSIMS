package com.ai.psims.web.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.psims.web.business.ISystemParameterBussiness;
import com.ai.psims.web.model.TbSystemParameter;
import com.ai.psims.web.model.TbSystemParameterExample;
import com.ai.psims.web.service.ISystemParameterService;

@Service
public class SystemParameterBussinessImpl implements ISystemParameterBussiness {

	private static final Logger logger = LoggerFactory
			.getLogger(SystemParameterBussinessImpl.class);
	
	@Resource(name = "systemParameterServiceImpl")
	private ISystemParameterService systemParameterService;
	
	@Override
	public List<TbSystemParameter> getSystemParameterPrizePool (TbSystemParameterExample tbSystemParameterExample) {
		// 查询供应商奖金池信息业务
		logger.info("getSystemParameterPrizePool");
		return systemParameterService.getSystemParameterPrizePool(tbSystemParameterExample);
	}
	@Override
	public TbSystemParameter getSystemParameterPrizePool (int paramId) {
		// 查询供应商奖金池信息业务
		logger.info("getSystemParameterPrizePool");
		return systemParameterService.getSystemParameterPrizePool(paramId);
	}
}
