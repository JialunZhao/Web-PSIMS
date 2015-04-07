package com.ai.psims.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.SalesGoodsMapper;
import com.ai.psims.web.model.SalesGoods;
import com.ai.psims.web.model.SalesGoodsExample;
import com.ai.psims.web.service.ISalesGoodsService;

@Service
public class SalesGoodsServiceImpl implements ISalesGoodsService {
	@Resource(name = "salesGoodsMapper")
	public SalesGoodsMapper salesGoodsMapper;

	@Override
	public int insertSelective(SalesGoods salesGoods) {
		return salesGoodsMapper.insertSelective(salesGoods);
	}

	@Override
	public List<SalesGoods> selectSalesGoods(SalesGoodsExample example) {
		return salesGoodsMapper.selectByExample(example);
	}

}
