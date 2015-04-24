package com.ai.psims.web.service;

import java.util.List;

import com.ai.psims.web.model.SalesbackGoods;
import com.ai.psims.web.model.SalesbackGoodsExample;

public interface ISalesbackGoodsService {
	int deleteByExample(SalesbackGoodsExample example);

	int deleteByPrimaryKey(Integer salesbackGoodsId);

	int insert(SalesbackGoods record);

	int insertSelective(SalesbackGoods record);

	List<SalesbackGoods> selectByExample(SalesbackGoodsExample example);

	SalesbackGoods selectByPrimaryKey(Integer salesbackGoodsId);

	int updateByPrimaryKey(SalesbackGoods record);

	int update(SalesbackGoods record);

	int insertToLog(SalesbackGoods salesbackGoods);
}
