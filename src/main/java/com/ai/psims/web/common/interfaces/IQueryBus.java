package com.ai.psims.web.common.interfaces;

import java.util.List;

import com.ai.psims.web.model.Goods;
import com.ai.psims.web.model.Import;

public interface IQueryBus {
	public List<String> queryProvider();
	
	public List<String> queryStorehouse();
	
	public List<Goods> queryGoodsByName(String goodsName);
	
	public List<Import> queryImport();
}
