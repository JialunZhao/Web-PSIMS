package com.ai.psims.web.common.interfaces;

import java.util.List;

import com.ai.psims.web.model.Goods;
import com.ai.psims.web.model.Import;
import com.ai.psims.web.model.Provider;
import com.ai.psims.web.model.Storehouse;

public interface IQueryBus {
	public List<Provider> queryProvider();

	public List<Storehouse> queryStorehouse();

	public List<Goods> queryGoodsByName(String goodsName);

	public List<Import> queryImport();
}
