package com.ai.psims.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.TbGoods2customerLogMapper;
import com.ai.psims.web.dao.TbGoods2customerMapper;
import com.ai.psims.web.model.TbGoods2customer;
import com.ai.psims.web.model.TbGoods2customerExample;
import com.ai.psims.web.service.IGoods2CustomerService;

@Service
public class Goods2CustomerServiceImpl implements IGoods2CustomerService {

	@Resource(name = "tbGoods2customerMapper")
	private TbGoods2customerMapper tbGoods2customerMapper;

	@Resource(name = "tbGoods2customerLogMapper")
	private TbGoods2customerLogMapper tbGoods2customerLogMapper;

	private static final Logger logger = LoggerFactory
			.getLogger(Goods2CustomerServiceImpl.class);

	@Override
	public List<TbGoods2customer> queryGoods2Customer(
			TbGoods2customerExample goods2CustomerQuery) {
		logger.info("------------1.商品与客户关系查询服务-------------");
		return tbGoods2customerMapper.selectByExample(goods2CustomerQuery);
	}

	@Override
	public int insertGoods2CustomerInfo(TbGoods2customer tbGoods2customer) {
		logger.info("------------1.商品与客户关系保存服务-------------");
		return tbGoods2customerMapper.insert(tbGoods2customer);
	}

	@Override
	public int updateGoods2CustomerInfo(TbGoods2customer tbGoods2customer) {
		logger.info("------------1.商品与客户关系更新服务-------------");
		return tbGoods2customerMapper.updateByPrimaryKeySelective(tbGoods2customer);
	}
}
