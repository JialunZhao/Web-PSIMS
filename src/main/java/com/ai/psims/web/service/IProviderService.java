package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.Provider;

public interface IProviderService {
	public Provider queryProviderByKey(Integer id);
	
	public List<Provider> queryProvider();
	
	public int deleteProviderByKey(Integer id);
	
	public int updateProviderByKey(Provider Provider);
	
	public int insertProvider(Provider Provider);
}
