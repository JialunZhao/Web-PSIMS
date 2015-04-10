package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.SalesGoods;
import com.ai.psims.web.model.SalesGoodsExample;

public interface ISalesGoodsService {
	public int insertSelective(SalesGoods salesGoods);

	public List<SalesGoods> selectSalesGoods(SalesGoodsExample example);

	public SalesGoods selectSalesGoodsByKey(Integer salesGoodsId);

	public int updateSalesGoods(SalesGoods salesGoods);

	public int updateSalesGoodsByKey(SalesGoods salesGoods);

	public int deleteByPrimaryKey(Integer salesGoodsId);

	public int insertToLog(SalesGoods salesGoods);
}
