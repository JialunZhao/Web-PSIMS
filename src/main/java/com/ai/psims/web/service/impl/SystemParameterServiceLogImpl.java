package com.ai.psims.web.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.TbSystemParameterLogMapper;
import com.ai.psims.web.model.TbSystemParameter;
import com.ai.psims.web.model.TbSystemParameterLog;
import com.ai.psims.web.model.TbSystemParameterLogExample;
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
		systemParameterLog.setPpDesc(systemParameter.getPpDesc());
		systemParameterLog.setPpValue(systemParameter.getPpValue());
		systemParameterLog.setpRemark(systemParameter.getpRemark());
		systemParameterLogMapper.insert(systemParameterLog);
	}

	@Override
	public List<TbSystemParameterLog> getSysByLogId(int paramId) {
		TbSystemParameterLogExample example = new TbSystemParameterLogExample();
		example.createCriteria().andParamIdEqualTo(paramId);
		return systemParameterLogMapper.selectByExample(example);
	}

	@Override
	public void updateByPid(TbSystemParameter systemParameter) {
		TbSystemParameterLog log = new TbSystemParameterLog();
		log.setpValue(systemParameter.getPpValue().toString());
		systemParameterLogMapper.updateByPrimaryKey(log);
	}

	


}
