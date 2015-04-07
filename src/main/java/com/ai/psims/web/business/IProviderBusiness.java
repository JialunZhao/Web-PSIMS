package com.ai.psims.web.business;

import java.util.List;

import com.ai.psims.web.model.TbProvider;
import com.ai.psims.web.model.TbProviderExample;

public interface IProviderBusiness {
	public int providerAdd(TbProvider provideradd);

	public int providerDelete(TbProvider providerDelete);

	public int providerModify(TbProvider providerModify);

	public List<TbProvider> providerQuery(TbProviderExample providerQuery);
}
