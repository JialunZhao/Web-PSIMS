package com.ai.psims.web.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.TbStorehouseLogMapper;
import com.ai.psims.web.dao.TbStorehouseMapper;
import com.ai.psims.web.model.TbStorehouse;
import com.ai.psims.web.model.TbStorehouseExample;
import com.ai.psims.web.model.TbStorehouseLog;
import com.ai.psims.web.service.IStorehouseService;

@Service
public class StorehouseServiceImpl implements IStorehouseService {
	@Resource(name = "tbStorehouseMapper")
	private TbStorehouseMapper tbStorehouseMapper;

	@Resource(name = "tbStorehouseLogMapper")
	private TbStorehouseLogMapper tbStorehouseLogMapper;

	private static final Logger logger = LoggerFactory
			.getLogger(StorehouseServiceImpl.class);

	// /////////////////////////////////////////////////

	@Override
	public int insertStorehouseInfo(TbStorehouse storehouseaddinfo) {
		logger.info("insertStorehouseInfo");
		return tbStorehouseMapper.insert(storehouseaddinfo);
	}

	@Override
	public List<TbStorehouse> queryStorehouse(
			TbStorehouseExample tbStorehouseExample) {
		logger.info("queryStorehouse");
		List<TbStorehouse> storehousesList = null;
		storehousesList = tbStorehouseMapper
				.selectByExample(tbStorehouseExample);
		return storehousesList;
	}

	@Override
	public int deleteStorehouseInfo(TbStorehouse storehouseDelete) {
		// logger.info("backDeleteStorehouseInfo");
		// // 1.备份数据
		// // 1.1获取需备份数据内容。
		// TbStorehouseExample tbStorehouseExample = new TbStorehouseExample();
		// tbStorehouseExample.createCriteria().andStorehouseIdEqualTo(
		// storehouseDelete.getStorehouseId());
		// List<TbStorehouse> tbStorehousebackup = tbStorehouseMapper
		// .selectByExample(tbStorehouseExample);
		// // 1.2备份到LOG表
		// TbStorehouseLog tbStorehouseLog = new TbStorehouseLog();
		// tbStorehouseLog.setArea(tbStorehousebackup.get(0).getArea());
		// tbStorehouseLog.setContactAddr(tbStorehousebackup.get(0).getContactAddr());
		// tbStorehouseLog.setContactName(tbStorehousebackup.get(0).getContactName());
		// tbStorehouseLog.setContactTel(tbStorehousebackup.get(0).getContactTel());
		// tbStorehouseLog.setCreatetime(tbStorehousebackup.get(0).getCreatetime());
		// tbStorehouseLog.setStorehouseCode(tbStorehousebackup.get(0).getStorehouseCode());
		// tbStorehouseLog.setStorehouseId(tbStorehousebackup.get(0).getStorehouseId());
		// tbStorehouseLog.setStorehouseName(tbStorehousebackup.get(0).getStorehouseName());
		// tbStorehouseLog.setStorehouseType(tbStorehousebackup.get(0).getStorehouseType());
		// tbStorehouseLog.setEmail(tbStorehousebackup.get(0).getEmail());
		// tbStorehouseLog.setEndtime(tbStorehousebackup.get(0).getEndtime());
		// tbStorehouseLog.setLogDatetime(new Date());
		// tbStorehouseLog.setEndtime(new Date());
		// tbStorehouseLog.setModifytime(tbStorehousebackup.get(0).getModifytime());
		// tbStorehouseLog.setRemark(tbStorehousebackup.get(0).getRemark());
		// tbStorehouseLog.setStatus(tbStorehousebackup.get(0).getStatus());
		// tbStorehouseLogMapper.insert(tbStorehouseLog);
		// 2.客户状态变更
		logger.info("deleteStorehouseInfo");
		storehouseDelete.setEndtime(new Date());
		return tbStorehouseMapper.updateByPrimaryKeySelective(storehouseDelete);
	}

	@Override
	public int modifyStorehouseInfo(TbStorehouse storehouseModify) {
		logger.info("modifyStorehouseInfo");
		return tbStorehouseMapper.updateByPrimaryKeySelective(storehouseModify);
	}

	@Override
	public int backupStorehouseInfo(TbStorehouse storehouseBackup) {
		logger.info("backDeleteStorehouseInfo");
		// 1.备份数据m
		// 1.1获取需备份数据内容。
		TbStorehouseExample tbStorehouseExample = new TbStorehouseExample();
		tbStorehouseExample.createCriteria().andStorehouseIdEqualTo(
				storehouseBackup.getStorehouseId());
		List<TbStorehouse> tbStorehousebackup = tbStorehouseMapper
				.selectByExample(tbStorehouseExample);
		// 1.2备份到LOG表
		TbStorehouseLog tbStorehouseLog = new TbStorehouseLog();
		tbStorehouseLog.setLogDatetime(new Date());
		tbStorehouseLog.setArea(tbStorehousebackup.get(0).getArea());
		tbStorehouseLog.setStorehouseId(tbStorehousebackup.get(0)
				.getStorehouseId());
		tbStorehouseLog.setStorehouseName(tbStorehousebackup.get(0)
				.getStorehouseName());
		tbStorehouseLog.setStorehouseCode(tbStorehousebackup.get(0)
				.getStorehouseCode());
		tbStorehouseLog.setType(tbStorehousebackup.get(0).getType());
		tbStorehouseLog.setContactAddress(tbStorehousebackup.get(0)
				.getContactAddress());
		tbStorehouseLog
				.setContactTel(tbStorehousebackup.get(0).getContactTel());
		tbStorehouseLog
				.setContactFax(tbStorehousebackup.get(0).getContactFax());
		tbStorehouseLog.setContactName(tbStorehousebackup.get(0)
				.getContactName());
		tbStorehouseLog.setContactEmail(tbStorehousebackup.get(0)
				.getContactEmail());
		tbStorehouseLog
				.setCreatetime(tbStorehousebackup.get(0).getCreatetime());
		tbStorehouseLog.setEndtime(tbStorehousebackup.get(0).getEndtime());
		tbStorehouseLog
				.setModifytime(tbStorehousebackup.get(0).getModifytime());
		tbStorehouseLog.setStatus(tbStorehousebackup.get(0).getStatus());
		tbStorehouseLog.setRemark(tbStorehousebackup.get(0).getRemark());
		return tbStorehouseLogMapper.insert(tbStorehouseLog);
	}

	@Override
	public TbStorehouse selectByPrimaryKey(Integer storehouseId) {
		return tbStorehouseMapper.selectByPrimaryKey(storehouseId);
	}

}
