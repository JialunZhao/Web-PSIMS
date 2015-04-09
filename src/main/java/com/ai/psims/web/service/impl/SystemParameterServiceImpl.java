package com.ai.psims.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.SystemParameterMapper;
import com.ai.psims.web.model.SystemParameter;
import com.ai.psims.web.model.SystemParameterExample;
import com.ai.psims.web.service.ISystemParameterService;
@Service
public class SystemParameterServiceImpl implements ISystemParameterService {
	
	@Resource
	private SystemParameterMapper systemParameterMapper;
	
	@Override
	public List<SystemParameter> getlAllParameter() {
		SystemParameterExample example = new SystemParameterExample();
		return systemParameterMapper.selectByExample(example);
	}

	@Override
	public void add(SystemParameter sysParamete) {
		systemParameterMapper.insertSelective(sysParamete);
	}
	
}
