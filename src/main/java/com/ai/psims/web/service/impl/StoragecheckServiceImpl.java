package com.ai.psims.web.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.StoragecheckMapper;
import com.ai.psims.web.model.Storagecheck;
import com.ai.psims.web.model.StoragecheckExample;
import com.ai.psims.web.service.IStoragecheckService;

@Service
public class StoragecheckServiceImpl implements IStoragecheckService {
	@Resource(name = "storagecheckMapper")
	private StoragecheckMapper storagecheckMapper;

	@Override
	public int insert(Storagecheck storagecheck) {
		return storagecheckMapper.insertSelective(storagecheck);
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
		return storagecheckMapper.deleteByPrimaryKey(storageId);
	}

	@Override
	public int updateStoragecheck(Storagecheck storagecheck) {
		return storagecheckMapper.updateByPrimaryKeySelective(storagecheck);
	}

	@Override
	public List<Storagecheck> seekExpiration() {
		StoragecheckExample example = new StoragecheckExample();
		Calendar calendar=Calendar.getInstance();
		calendar.add( Calendar.DAY_OF_MONTH, +10); 
		Date date = calendar.getTime();
		example.createCriteria().andGoodsExpirationDateLessThanOrEqualTo(date);
		return storagecheckMapper.selectByExample(example);
	}

	@Override
	public List<Storagecheck> seekBExpiration() {
		StoragecheckExample example = new StoragecheckExample();
		Calendar calendar=Calendar.getInstance();
		calendar.add( Calendar.DAY_OF_MONTH, +10); 
		Date date1 = calendar.getTime();
		calendar.add( Calendar.DAY_OF_MONTH, +20); 
		Date date2 = calendar.getTime();
		example.createCriteria().andGoodsExpirationDateBetween(date1, date2);
		return storagecheckMapper.selectByExample(example);
	}

	@Override
	public List<Storagecheck> seekCExpiration() {
		StoragecheckExample example = new StoragecheckExample();
		Calendar calendar=Calendar.getInstance();
		calendar.add( Calendar.DAY_OF_MONTH, +30); 
		Date date1 = calendar.getTime();
		calendar.add( Calendar.DAY_OF_MONTH, +60); 
		Date date2 = calendar.getTime();
		example.createCriteria().andGoodsExpirationDateBetween(date1, date2);
		return storagecheckMapper.selectByExample(example);
	}

	@Override
	public List<Storagecheck> seekDExpiration() {
		StoragecheckExample example = new StoragecheckExample();
		Calendar calendar=Calendar.getInstance();
		calendar.add( Calendar.DAY_OF_MONTH, +90); 
		Date date = calendar.getTime();
		example.createCriteria().andGoodsExpirationDateGreaterThan(date);
		return storagecheckMapper.selectByExample(example);
	}

	@Override
	public List<Storagecheck> seekStore() {
		return storagecheckMapper.seekStore();
	}

	@Override
	public List<Storagecheck> seekBStore() {
		return storagecheckMapper.seekBStore();
	}

	@Override
	public List<Storagecheck> seekCStore() {
		return storagecheckMapper.seekCStore();
	}

	@Override
	public List<Storagecheck> seekDStore() {
		return storagecheckMapper.seekDStore();
	}

}
