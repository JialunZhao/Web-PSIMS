package com.ai.psims.web.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.psims.web.business.IGoodsBusiness;
import com.ai.psims.web.model.TbGoods;
import com.ai.psims.web.model.TbGoodsExample;
import com.ai.psims.web.model.TbProvider;
import com.ai.psims.web.service.IGoods2CustomerService;
import com.ai.psims.web.service.IGoodsService;
import com.ai.psims.web.service.IProviderService;

@Service
public class GoodsBusinessImpl implements IGoodsBusiness {
	
	private static final Logger logger = LoggerFactory
			.getLogger(GoodsBusinessImpl.class);
	
	@Resource(name = "goodsServiceImpl")
	private IGoodsService goodsService;
	
	@Resource(name = "goods2CustomerServiceImpl")
	private IGoods2CustomerService goods2CustomerService;

	@Resource(name = "providerServiceImpl")
	private IProviderService providerServiceImpl;

	@Override
	public List<TbGoods> goodsQuery(TbGoodsExample goodsQuery) {
		// 查询商品信息业务
		logger.info("goodsQuery");
		return goodsService.queryGoods(goodsQuery);
	}

	@Override
	public int goodsAdd(TbGoods goodsAdd) {
		// 新增商品信息业务
		logger.info("goodsAdd");
		//补全供应商信息
		TbProvider tbProvider = new  TbProvider();
		tbProvider = providerServiceImpl.selectProvider(goodsAdd.getProviderId());
		goodsAdd.setProviderName(tbProvider.getProviderName());
		goodsAdd.setProviderCode(tbProvider.getProviderCode());
		return goodsService.insertGoodsInfo(goodsAdd);
	}

	@Override
	public int goodsDelete(TbGoods goodsDelete) {
		// 删除商品信息业务
		goodsService.backupGoodsInfo(goodsDelete);
		logger.info("goodsDelete");
		return goodsService.deleteGoodsInfo(goodsDelete);
	}

	@Override
	public int goodsModify(TbGoods goodsModify) {
		// 修改商品信息业务
		goodsService.backupGoodsInfo(goodsModify);
		logger.info("goodsModify");
		//补全供应商信息
		TbProvider tbProvider = new  TbProvider();
		tbProvider = providerServiceImpl.selectProvider(goodsModify.getProviderId());
		goodsModify.setProviderName(tbProvider.getProviderName());
		goodsModify.setProviderCode(tbProvider.getProviderCode());
		return goodsService.modifyGoodsInfo(goodsModify);
	}

}
