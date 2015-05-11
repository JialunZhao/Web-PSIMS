package com.ai.psims.web.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.TbSystemParameterLogMapper;
import com.ai.psims.web.model.TbSystemParameter;
import com.ai.psims.web.model.TbSystemParameterLog;
import com.ai.psims.web.service.ISystemParameterServiceLog;

@Service
public class SystemParameterServiceLogImpl implements ISystemParameterServiceLog {
	
	@Resource
	private TbSystemParameterLogMapper systemParameterLogMapper;
	
	@Override
	public void addRecord(TbSystemParameter systemParameter) {
		TbSystemParameterLog systemParameterLog = new TbSystemParameterLog();
		systemParameterLog.setLogDatetime(new Date());
		systemParameterLog.setParamId(systemParameter.getParamId());
		systemParameterLog.setpCreatetime(systemParameter.getpCreatetime());
		systemParameterLog.setpDesc(systemParameter.getpDesc());
		systemParameterLog.setpKey(systemParameter.getpKey());
		systemParameterLog.setpValue(systemParameter.getpValue());
		systemParameterLog.setPpDesc(systemParameter.getPpValue());
		systemParameterLog.setPpValue(systemParameter.getPpValue());
		systemParameterLogMapper.insert(systemParameterLog);
	}


}
