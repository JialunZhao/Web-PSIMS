package com.ai.psims.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.GoodsLogMapper;
import com.ai.psims.web.model.GoodsLog;
import com.ai.psims.web.service.IGoodsLogService;

@Service
public class GoodsLogServiceImpl implements IGoodsLogService {
	@Resource(name="goodsLogMapper")
	private GoodsLogMapper goodsLogMapper;

	public GoodsLog queryGoodsLogByKey(Integer id) {
		return goodsLogMapper.selectByPrimaryKey(id);
	}

	public int deleteGoodsLogByKey(Integer id) {
		return goodsLogMapper.deleteByPrimaryKey(id);
	}

	public int updateGoodsLogByKey(GoodsLog goodsLog) {
		return goodsLogMapper.updateByPrimaryKey(goodsLog);
	}

	public int insertGoodsLog(GoodsLog goodsLog) {
		return goodsLogMapper.insertSelective(goodsLog);
	}

}
