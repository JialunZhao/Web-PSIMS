package com.ai.psims.web.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.StoragecheckLogMapper;
import com.ai.psims.web.dao.StoragecheckMapper;
import com.ai.psims.web.model.Storagecheck;
import com.ai.psims.web.model.StoragecheckExample;
import com.ai.psims.web.model.StoragecheckLog;
import com.ai.psims.web.service.IStoragecheckService;

@Service
public class StoragecheckServiceImpl implements IStoragecheckService {
	@Resource(name = "storagecheckMapper")
	private StoragecheckMapper storagecheckMapper;
	@Resource(name = "storagecheckLogMapper")
	private StoragecheckLogMapper storagecheckLogMapper;

	@Override
	public int insert(Storagecheck storagecheck) {
		return storagecheckMapper.insert(storagecheck);
	}

	@Override
	public List<Storagecheck> selectByExample(StoragecheckExample example) {
		return storagecheckMapper.selectByExample(example);
	}

	@Override
	public Storagecheck selectByKey(Integer storageId) {
		return storagecheckMapper.selectByPrimaryKey(storageId);
	}

	@Override
	public int deleteStoragecheck(Integer storageId) {
		Storagecheck storagecheck = new Storagecheck();
		storagecheck = storagecheckMapper.selectByPrimaryKey(storageId);
		insertToLog(storagecheck);
		storagecheck.setEndtime(new Date());
		return storagecheckMapper.updateByPrimaryKeySelective(storagecheck);
	}

	@Override
	public int updateStoragecheck(Storagecheck storagecheck) {
		insertToLog(storagecheck);
		return storagecheckMapper.updateByPrimaryKey(storagecheck);
	}

	@Override
	public int updateStoragecheckByKey(Storagecheck storagecheck) {
		insertToLog(storagecheck);
		return storagecheckMapper.updateByPrimaryKeySelective(storagecheck);
	}

	@Override
	public int insertToLog(Storagecheck storagecheck) {
		Storagecheck stora = new Storagecheck();
		stora = storagecheckMapper.selectByPrimaryKey(storagecheck
				.getStorageId());
		StoragecheckLog log = new StoragecheckLog();

		log.setCreatetime(stora.getCreatetime());
		log.setEndtime(stora.getEndtime());
		log.setGoodsBarCode(stora.getGoodsBarCode());
		log.setGoodsExpirationDate(stora.getGoodsExpirationDate());
		log.setGoodsId(stora.getGoodsId());
		log.setGoodsName(stora.getGoodsName());
		log.setGoodsPrice(stora.getGoodsPrice());
		log.setGoodsProductionDate(stora.getGoodsProductionDate());
		log.setGoodsShelfLife(stora.getGoodsShelfLife());
		log.setGoodsStatus(stora.getGoodsStatus());
		log.setImportGoodsUnit(stora.getImportGoodsUnit());
		log.setImportSerialNumber(stora.getImportSerialNumber());
		log.setLogDatetime(new Date());
		log.setModifytime(stora.getModifytime());
		log.setProviderId(stora.getProviderId());
		log.setProviderName(stora.getProviderName());
		log.setRemark(stora.getRemark());
		log.setShelfLifeWarning(stora.getShelfLifeWarning());
		log.setStorageId(stora.getStorageId());
		log.setStorageRateCurrent(stora.getStorageRateCurrent());
		log.setStorageRateTotal(stora.getStorageRateTotal());
		log.setStorageType(stora.getStorageType());
		log.setStorageWarning(stora.getStorageWarning());

		return storagecheckLogMapper.insertSelective(log);
	}

}
