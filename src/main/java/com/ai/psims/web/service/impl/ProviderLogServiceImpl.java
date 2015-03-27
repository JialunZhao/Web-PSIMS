package com.ai.psims.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.ProviderLogMapper;
import com.ai.psims.web.model.ProviderLog;
import com.ai.psims.web.service.IProviderLogService;
@Service
public class ProviderLogServiceImpl implements IProviderLogService{
	@Resource(name="providerLogMapper")
	private ProviderLogMapper providerLogMapper;
	
	public ProviderLog queryProviderLogByKey(Integer id) {
		return providerLogMapper.selectByPrimaryKey(id);
	}

	public int deleteProviderLogByKey(Integer id) {
		return providerLogMapper.deleteByPrimaryKey(id);
	}

	public int updateProviderLogByKey(ProviderLog ProviderLog) {
		return providerLogMapper.updateByPrimaryKey(ProviderLog);
	}

	public int insertProviderLog(ProviderLog ProviderLog) {
		return providerLogMapper.insertSelective(ProviderLog);
	}

}
