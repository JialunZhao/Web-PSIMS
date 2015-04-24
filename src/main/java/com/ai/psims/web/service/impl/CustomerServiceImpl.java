package com.ai.psims.web.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.psims.web.dao.TbCustomerLogMapper;
import com.ai.psims.web.dao.TbCustomerMapper;
import com.ai.psims.web.model.TbCustomer;
import com.ai.psims.web.model.TbCustomerExample;
import com.ai.psims.web.model.TbCustomerLog;
import com.ai.psims.web.service.ICustomerService;

@Service
@Transactional(readOnly = false)
public class CustomerServiceImpl implements ICustomerService {
	@Resource(name = "tbCustomerMapper")
	private TbCustomerMapper tbCustomerMapper;

	@Resource(name = "tbCustomerLogMapper")
	private TbCustomerLogMapper tbCustomerLogMapper;

	private static final Logger logger = LoggerFactory
			.getLogger(CustomerServiceImpl.class);

	@Override
	public int insertCustomerInfo(TbCustomer customeraddinfo) {
		logger.info("insertCustomerInfo");
		return tbCustomerMapper.insert(customeraddinfo);
	}

	@Override
	public List<TbCustomer> queryCustomer(TbCustomerExample tbCustomerExample) {
		logger.info("queryCustomer");
		List<TbCustomer> customersList = null;
		customersList = tbCustomerMapper.selectByExample(tbCustomerExample);
		return customersList;
	}

	@Override
	public int deleteCustomerInfo(TbCustomer customerDelete) {
//		logger.info("backDeleteCustomerInfo");
//		// 1.备份数据
//		// 1.1获取需备份数据内容。
//		TbCustomerExample tbCustomerExample = new TbCustomerExample();
//		tbCustomerExample.createCriteria().andCustomerIdEqualTo(
//				customerDelete.getCustomerId());
//		List<TbCustomer> tbCustomerbackup = tbCustomerMapper
//				.selectByExample(tbCustomerExample);
//		// 1.2备份到LOG表
//		TbCustomerLog tbCustomerLog = new TbCustomerLog();
//		tbCustomerLog.setArea(tbCustomerbackup.get(0).getArea());
//		tbCustomerLog.setContactAddr(tbCustomerbackup.get(0).getContactAddr());
//		tbCustomerLog.setContactName(tbCustomerbackup.get(0).getContactName());
//		tbCustomerLog.setContactTel(tbCustomerbackup.get(0).getContactTel());
//		tbCustomerLog.setCreatetime(tbCustomerbackup.get(0).getCreatetime());
//		tbCustomerLog.setCustomerCode(tbCustomerbackup.get(0).getCustomerCode());
//		tbCustomerLog.setCustomerId(tbCustomerbackup.get(0).getCustomerId());
//		tbCustomerLog.setCustomerName(tbCustomerbackup.get(0).getCustomerName());
//		tbCustomerLog.setCustomerType(tbCustomerbackup.get(0).getCustomerType());
//		tbCustomerLog.setEmail(tbCustomerbackup.get(0).getEmail());
//		tbCustomerLog.setEndtime(tbCustomerbackup.get(0).getEndtime());
//		tbCustomerLog.setLogDatetime(new Date());
//		tbCustomerLog.setEndtime(new Date());
//		tbCustomerLog.setModifytime(tbCustomerbackup.get(0).getModifytime());
//		tbCustomerLog.setRemark(tbCustomerbackup.get(0).getRemark());
//		tbCustomerLog.setStatus(tbCustomerbackup.get(0).getStatus());
//		tbCustomerLogMapper.insert(tbCustomerLog);
		// 2.客户状态变更
		logger.info("deleteCustomerInfo");
		customerDelete.setEndtime(new Date());
		return tbCustomerMapper.updateByPrimaryKeySelective(customerDelete);
	}

	@Override
	public int modifyCustomerInfo(TbCustomer customerModify) {
		logger.info("modifyCustomerInfo");
		return tbCustomerMapper.updateByPrimaryKeySelective(customerModify);
	}

	@Override
	public int backupCustomerInfo(TbCustomer customerBackup) {
		logger.info("backDeleteCustomerInfo");
		// 1.备份数据m
		// 1.1获取需备份数据内容。
		TbCustomerExample tbCustomerExample = new TbCustomerExample();
		tbCustomerExample.createCriteria().andCustomerIdEqualTo(
				customerBackup.getCustomerId());
		List<TbCustomer> tbCustomerbackup = tbCustomerMapper
				.selectByExample(tbCustomerExample);
		// 1.2备份到LOG表
		TbCustomerLog tbCustomerLog = new TbCustomerLog();
		tbCustomerLog.setLogDatetime(new Date());
		tbCustomerLog.setArea(tbCustomerbackup.get(0).getArea());
		tbCustomerLog.setCustomerId(tbCustomerbackup.get(0).getCustomerId());
		tbCustomerLog.setCustomerName(tbCustomerbackup.get(0).getCustomerName());
		tbCustomerLog.setCustomerCode(tbCustomerbackup.get(0).getCustomerCode());
		tbCustomerLog.setCustomerType(tbCustomerbackup.get(0).getCustomerType());
		tbCustomerLog.setContactAddr(tbCustomerbackup.get(0).getContactAddr());
		tbCustomerLog.setContactTel(tbCustomerbackup.get(0).getContactTel());
		tbCustomerLog.setContactName(tbCustomerbackup.get(0).getContactName());
		tbCustomerLog.setEmail(tbCustomerbackup.get(0).getEmail());
		tbCustomerLog.setCreatetime(tbCustomerbackup.get(0).getCreatetime());
		tbCustomerLog.setEndtime(tbCustomerbackup.get(0).getEndtime());
		tbCustomerLog.setModifytime(tbCustomerbackup.get(0).getModifytime());
		tbCustomerLog.setStatus(tbCustomerbackup.get(0).getStatus());
		tbCustomerLog.setRemark(tbCustomerbackup.get(0).getRemark());
		return tbCustomerLogMapper.insert(tbCustomerLog);
	}

	@Override
	public TbCustomer selectCustomerInfo(Integer customerId) {
		return tbCustomerMapper.selectByPrimaryKey(customerId);
	}

}
