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
import com.ai.psims.web.service.ISystemParameterServiceLog;

@Service
public class SystemParameterBussinessImpl implements ISystemParameterBussiness {

	private static final Logger logger = LoggerFactory
			.getLogger(SystemParameterBussinessImpl.class);
	
	@Resource(name = "systemParameterServiceImpl")
	private ISystemParameterService systemParameterService;
	
	@Resource(name = "systemParameterServiceLogImpl")
	private ISystemParameterServiceLog systemParameterServiceLog;
	
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
	@Override
	public void add(TbSystemParameter sysParamete) {
		systemParameterService.add(sysParamete);
	}
	@Override
	public TbSystemParameter getSysById(int paramId) {
		return systemParameterService.getSysById(paramId);
	}
	@Override
	public void update(TbSystemParameter systemParameter) {
		systemParameterService.update(systemParameter);
		
	}
	@Override
	public void addRecord(TbSystemParameter systemParameter) {
		systemParameterServiceLog.addRecord(systemParameter);
	}
	@Override
	public void delete(TbSystemParameter sysParamete) {
		systemParameterService.delete(sysParamete);
	}
	@Override
	public List<TbSystemParameter> getlAllParameter() {
		return systemParameterService.getlAllParameter();
	}
	@Override
	public List<TbSystemParameter> selectByExample(
			TbSystemParameterExample tbSystemParameterExample) {
		//按条件查询参数列表
		logger.info("selectByExample");
		return systemParameterService.selectByExample(tbSystemParameterExample);
	}
}
