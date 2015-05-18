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
		return tbCustomerMapper.selectByExample(tbCustomerExample);
	}

	@Override
	public int deleteCustomerInfo(TbCustomer customerDelete) {
		// 1.客户状态变更
		logger.info("deleteCustomerInfo");
		customerDelete.setEndtime(new Date());
		customerDelete.setStatus("00");
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
		tbCustomerLog.setEmployeeId(tbCustomerbackup.get(0).getEmployeeId());
		tbCustomerLog.setEmployeeCode(tbCustomerbackup.get(0).getEmployeeCode());
		tbCustomerLog.setEmployeeName(tbCustomerbackup.get(0).getEmployeeName());
		tbCustomerLog.setCheckoutCode(tbCustomerbackup.get(0).getCheckoutCode());
		tbCustomerLog.setCheckoutName(tbCustomerbackup.get(0).getCheckoutName());
		tbCustomerLog.setCheckoutWarning(tbCustomerbackup.get(0).getCheckoutWarning());
		tbCustomerLog.setCreditCount(tbCustomerbackup.get(0).getCreditCount());
		return tbCustomerLogMapper.insert(tbCustomerLog);
	}
	
	@Override
	public int backupCustomerInfoByPrimaryKey(Integer customerId) {
		logger.info("backDeleteCustomerInfo");
		// 1.备份数据
		// 1.1获取需备份数据内容。
		TbCustomer tbCustomer =new TbCustomer();
		tbCustomer =tbCustomerMapper.selectByPrimaryKey(customerId);
		// 1.2备份到LOG表
		TbCustomerLog tbCustomerLog = new TbCustomerLog();
		tbCustomerLog.setLogDatetime(new Date());
		tbCustomerLog.setArea(tbCustomer.getArea());
		tbCustomerLog.setCustomerId(tbCustomer.getCustomerId());
		tbCustomerLog.setCustomerName(tbCustomer.getCustomerName());
		tbCustomerLog.setCustomerCode(tbCustomer.getCustomerCode());
		tbCustomerLog.setCustomerType(tbCustomer.getCustomerType());
		tbCustomerLog.setContactAddr(tbCustomer.getContactAddr());
		tbCustomerLog.setContactTel(tbCustomer.getContactTel());
		tbCustomerLog.setContactName(tbCustomer.getContactName());
		tbCustomerLog.setEmail(tbCustomer.getEmail());
		tbCustomerLog.setCreatetime(tbCustomer.getCreatetime());
		tbCustomerLog.setEndtime(tbCustomer.getEndtime());
		tbCustomerLog.setModifytime(tbCustomer.getModifytime());
		tbCustomerLog.setStatus(tbCustomer.getStatus());
		tbCustomerLog.setRemark(tbCustomer.getRemark());
		tbCustomerLog.setEmployeeId(tbCustomer.getEmployeeId());
		tbCustomerLog.setEmployeeCode(tbCustomer.getEmployeeCode());
		tbCustomerLog.setEmployeeName(tbCustomer.getEmployeeName());
		tbCustomerLog.setCheckoutCode(tbCustomer.getCheckoutCode());
		tbCustomerLog.setCheckoutName(tbCustomer.getCheckoutName());
		tbCustomerLog.setCheckoutWarning(tbCustomer.getCheckoutWarning());
		tbCustomerLog.setCreditCount(tbCustomer.getCreditCount());
		return tbCustomerLogMapper.insert(tbCustomerLog);
	}

	@Override
	public TbCustomer selectCustomerInfo(Integer customerId) {
		return tbCustomerMapper.selectByPrimaryKey(customerId);
	}

}
