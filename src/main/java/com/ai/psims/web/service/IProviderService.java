package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.TbProvider;
import com.ai.psims.web.model.TbProviderExample;

public interface IProviderService {
	public int insertProviderInfo(TbProvider providerAdd);

	public int deleteProviderInfo(TbProvider providerDelete);

	public int modifyProviderInfo(TbProvider providerModify);
	
	public int backupProviderInfo(TbProvider providerBackup);

	public List<TbProvider> queryProvider(TbProviderExample providerQuery);
	
	public TbProvider selectProvider(Integer providerId);
}
