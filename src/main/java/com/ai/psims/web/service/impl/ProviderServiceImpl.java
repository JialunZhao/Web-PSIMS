package com.ai.psims.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.ProviderMapper;
import com.ai.psims.web.model.Provider;
import com.ai.psims.web.service.IProviderService;

@Service
public class ProviderServiceImpl implements IProviderService {
	@Resource(name = "providerMapper")
	private ProviderMapper providerMapper;

	public Provider queryProviderByKey(Integer id) {
		return providerMapper.selectByPrimaryKey(id);
	}

	public int deleteProviderByKey(Integer id) {
		return providerMapper.deleteByPrimaryKey(id);
	}

	public int updateProviderByKey(Provider Provider) {
		return providerMapper.updateByPrimaryKey(Provider);
	}

	public int insertProvider(Provider Provider) {
		return providerMapper.insertSelective(Provider);
	}

	public List<Provider> queryProvider() {
		return providerMapper.select();
	}

}
