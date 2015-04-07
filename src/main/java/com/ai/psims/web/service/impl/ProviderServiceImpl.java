package com.ai.psims.web.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.TbProviderMapper;
import com.ai.psims.web.dao.TbProviderLogMapper;
import com.ai.psims.web.model.TbProvider;
import com.ai.psims.web.model.TbProviderExample;
import com.ai.psims.web.model.TbProviderLog;
import com.ai.psims.web.service.IProviderService;

@Service
public class ProviderServiceImpl implements IProviderService {
	@Resource(name = "tbProviderMapper")
	private TbProviderMapper tbProviderMapper;

	@Resource(name = "tbProviderLogMapper")
	private TbProviderLogMapper tbProviderLogMapper;

	private static final Logger logger = LoggerFactory
			.getLogger(ProviderServiceImpl.class);

	@Override
	public int insertProviderInfo(TbProvider provideraddinfo) {
		logger.info("insertProviderInfo");
		return tbProviderMapper.insert(provideraddinfo);
	}

	@Override
	public List<TbProvider> queryProvider(TbProviderExample tbProviderExample) {
		logger.info("queryProvider");
		List<TbProvider> providersList = null;
		providersList = tbProviderMapper.selectByExample(tbProviderExample);
		return providersList;
	}

	@Override
	public int deleteProviderInfo(TbProvider providerDelete) {
//		logger.info("backDeleteProviderInfo");
//		// 1.备份数据
//		// 1.1获取需备份数据内容。
//		TbProviderExample tbProviderExample = new TbProviderExample();
//		tbProviderExample.createCriteria().andProviderIdEqualTo(
//				providerDelete.getProviderId());
//		List<TbProvider> tbProviderbackup = tbProviderMapper
//				.selectByExample(tbProviderExample);
//		// 1.2备份到LOG表
//		TbProviderLog tbProviderLog = new TbProviderLog();
//		tbProviderLog.setArea(tbProviderbackup.get(0).getArea());
//		tbProviderLog.setContactAddr(tbProviderbackup.get(0).getContactAddr());
//		tbProviderLog.setContactName(tbProviderbackup.get(0).getContactName());
//		tbProviderLog.setContactTel(tbProviderbackup.get(0).getContactTel());
//		tbProviderLog.setCreatetime(tbProviderbackup.get(0).getCreatetime());
//		tbProviderLog.setProviderCode(tbProviderbackup.get(0).getProviderCode());
//		tbProviderLog.setProviderId(tbProviderbackup.get(0).getProviderId());
//		tbProviderLog.setProviderName(tbProviderbackup.get(0).getProviderName());
//		tbProviderLog.setProviderType(tbProviderbackup.get(0).getProviderType());
//		tbProviderLog.setEmail(tbProviderbackup.get(0).getEmail());
//		tbProviderLog.setEndtime(tbProviderbackup.get(0).getEndtime());
//		tbProviderLog.setLogDatetime(new Date());
//		tbProviderLog.setEndtime(new Date());
//		tbProviderLog.setModifytime(tbProviderbackup.get(0).getModifytime());
//		tbProviderLog.setRemark(tbProviderbackup.get(0).getRemark());
//		tbProviderLog.setStatus(tbProviderbackup.get(0).getStatus());
//		tbProviderLogMapper.insert(tbProviderLog);
		// 2.客户状态变更
		logger.info("deleteProviderInfo");
		providerDelete.setProviderEndtime(new Date());
		return tbProviderMapper.updateByPrimaryKeySelective(providerDelete);
	}

	@Override
	public int modifyProviderInfo(TbProvider providerModify) {
		logger.info("modifyProviderInfo");
		return tbProviderMapper.updateByPrimaryKeySelective(providerModify);
	}

	@Override
	public int backupProviderInfo(TbProvider providerBackup) {
		logger.info("backDeleteProviderInfo");
		// 1.备份数据m
		// 1.1获取需备份数据内容。
		TbProviderExample tbProviderExample = new TbProviderExample();
		tbProviderExample.createCriteria().andProviderIdEqualTo(
				providerBackup.getProviderId());
		List<TbProvider> tbProviderbackup = tbProviderMapper
				.selectByExample(tbProviderExample);
		// 1.2备份到LOG表
		TbProviderLog tbProviderLog = new TbProviderLog();
		tbProviderLog.setLogDatetime(new Date());
		tbProviderLog.setProviderArea(tbProviderbackup.get(0).getProviderArea());
		tbProviderLog.setProviderId(tbProviderbackup.get(0).getProviderId());
		tbProviderLog.setProviderName(tbProviderbackup.get(0).getProviderName());
		tbProviderLog.setProviderCode(tbProviderbackup.get(0).getProviderCode());
		tbProviderLog.setProviderType(tbProviderbackup.get(0).getProviderType());
		tbProviderLog.setProviderContactAddress(tbProviderbackup.get(0).getProviderContactAddress());
		tbProviderLog.setProviderContactTel(tbProviderbackup.get(0).getProviderContactTel());
		tbProviderLog.setProviderContactName(tbProviderbackup.get(0).getProviderContactName());
		tbProviderLog.setProviderContactEmail(tbProviderbackup.get(0).getProviderContactEmail());
		tbProviderLog.setProviderCreatetime(tbProviderbackup.get(0).getProviderCreatetime());
		tbProviderLog.setProviderEndtime(tbProviderbackup.get(0).getProviderEndtime());
		tbProviderLog.setProviderModifytime(tbProviderbackup.get(0).getProviderModifytime());
		tbProviderLog.setProviderStatus(tbProviderbackup.get(0).getProviderStatus());
		tbProviderLog.setProviderRemark(tbProviderbackup.get(0).getProviderRemark());
		return tbProviderLogMapper.insert(tbProviderLog);
	}

}
