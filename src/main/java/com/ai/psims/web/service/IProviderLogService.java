package com.ai.psims.web.service;

import com.ai.psims.web.model.ProviderLog;

public interface IProviderLogService {
	public ProviderLog queryProviderLogByKey(Integer id);

	public int deleteProviderLogByKey(Integer id);

	public int updateProviderLogByKey(ProviderLog ProviderLog);

	public int insertProviderLog(ProviderLog ProviderLog);
}
