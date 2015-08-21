package com.ai.psims.web.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.StoragecheckMapper;
import com.ai.psims.web.dao.TbStoragecheckMapper;
import com.ai.psims.web.model.Storagecheck;
import com.ai.psims.web.model.StoragecheckExample;
import com.ai.psims.web.model.TbStoragecheck;
import com.ai.psims.web.model.TbStoragecheckExample;
import com.ai.psims.web.service.IStoragecheckService;

@Service
public class StoragecheckServiceImpl implements IStoragecheckService {
	private static final Logger logger = LoggerFactory
			.getLogger(StoragecheckServiceImpl.class);
	@Resource(name = "tbStoragecheckMapper")
	private TbStoragecheckMapper tbStoragecheckMapper;

	@Resource(name = "storagecheckMapper")
	private StoragecheckMapper storagecheckMapper;

	@Override
	public int insert(Storagecheck storagecheck) {
		return storagecheckMapper.insertSelective(storagecheck);
	}

	public int insert(TbStoragecheck storagecheck) {
		return tbStoragecheckMapper.insertSelective(storagecheck);
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
		Date date = null;
		List<Storagecheck> storagechecks = storagecheckMapper
				.selectByExample(example);
		List<Storagecheck> newstoragecheck = new ArrayList<Storagecheck>();
		if (storagechecks.size() > 0 && storagechecks != null) {
			for (Storagecheck storagecheck : storagechecks) {
				Integer shelfLifeWarning = storagecheck.getShelfLifeWarning();
				if (shelfLifeWarning != null) {
					Calendar calendari = Calendar.getInstance();
					calendari.add(Calendar.DAY_OF_MONTH, +shelfLifeWarning);
					date = calendari.getTime();
					Date goodsExpirationDate = storagecheck
							.getGoodsExpirationDate();
					if (goodsExpirationDate.compareTo(date) <= 0 && storagecheck.getStorageRateCurrent()>0) {
						newstoragecheck.add(storagecheck);
					}
				}
			}
		}
		return newstoragecheck;
	}

	@Override
	public List<Storagecheck> seekBExpiration() {
		StoragecheckExample example = new StoragecheckExample();
		Date date = null;
		Date date1 = null;
		List<Storagecheck> storagechecks = storagecheckMapper
				.selectByExample(example);
		List<Storagecheck> newstoragecheck = new ArrayList<Storagecheck>();
		if (storagechecks.size() > 0 && storagechecks != null) {
			for (Storagecheck storagecheck : storagechecks) {
				Integer shelfLifeWarning = storagecheck.getShelfLifeWarning();
				if (shelfLifeWarning != null) {
					Calendar calendari = Calendar.getInstance();
					Calendar calendarj = Calendar.getInstance();
					calendari
							.add(Calendar.DAY_OF_MONTH, +shelfLifeWarning + 10);
					date = calendari.getTime();
					calendarj.add(Calendar.DAY_OF_MONTH, +shelfLifeWarning);
					date1 = calendarj.getTime();
					Date goodsExpirationDate = storagecheck
							.getGoodsExpirationDate();
					if (goodsExpirationDate.compareTo(date) < 0
							&& goodsExpirationDate.compareTo(date1) > 0 && storagecheck.getStorageRateCurrent()>0) {
						newstoragecheck.add(storagecheck);
					}
				}
			}
		}

		return newstoragecheck;
	}

	@Override
	public List<Storagecheck> seekCExpiration() {
		StoragecheckExample example = new StoragecheckExample();
		Date date = null;
		Date date1 = null;
		List<Storagecheck> storagechecks = storagecheckMapper
				.selectByExample(example);
		List<Storagecheck> newstoragecheck = new ArrayList<Storagecheck>();
		if (storagechecks.size() > 0 && storagechecks != null) {
			for (Storagecheck storagecheck : storagechecks) {
				Integer shelfLifeWarning = storagecheck.getShelfLifeWarning();
				if (shelfLifeWarning != null) {
					Calendar calendari = Calendar.getInstance();
					Calendar calendarj = Calendar.getInstance();
					calendari
							.add(Calendar.DAY_OF_MONTH, +shelfLifeWarning + 90);
					date = calendari.getTime();
					calendarj
							.add(Calendar.DAY_OF_MONTH, +shelfLifeWarning + 10);
					date1 = calendarj.getTime();
					Date goodsExpirationDate = storagecheck
							.getGoodsExpirationDate();
					if (goodsExpirationDate.compareTo(date) <= 0
							&& goodsExpirationDate.compareTo(date1) >= 0 && storagecheck.getStorageRateCurrent()>0) {
						newstoragecheck.add(storagecheck);
					}
				}
			}
		}
		return newstoragecheck;
	}

	@Override
	public List<Storagecheck> seekDExpiration() {
		StoragecheckExample example = new StoragecheckExample();
		Date date = null;
		List<Storagecheck> storagechecks = storagecheckMapper
				.selectByExample(example);
		List<Storagecheck> newstoragecheck = new ArrayList<Storagecheck>();
		if (storagechecks.size() > 0 && storagechecks != null) {
			for (Storagecheck storagecheck : storagechecks) {
				Integer shelfLifeWarning = storagecheck.getShelfLifeWarning();
				if (shelfLifeWarning != null) {
					Calendar calendari = Calendar.getInstance();
					calendari
							.add(Calendar.DAY_OF_MONTH, +shelfLifeWarning + 90);
					date = calendari.getTime();
					Date goodsExpirationDate = storagecheck
							.getGoodsExpirationDate();
					if (goodsExpirationDate.compareTo(date) > 0 && storagecheck.getStorageRateCurrent()>0) {
						newstoragecheck.add(storagecheck);
					}
				}
			}
		}
		return newstoragecheck;
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

	
	public List<TbStoragecheck> selectTbStoragecheck(
			TbStoragecheckExample tbStoragecheckExample) {
		logger.info("selectTbStoragecheck");
		return tbStoragecheckMapper.selectByExample(tbStoragecheckExample);
	}
	

	@Override
	public List<TbStoragecheck> selectTbStoragecheckByName(String goodsName){
		logger.info("selectTbStoragecheckByName");
		return tbStoragecheckMapper.selectTbStoragecheckByName(goodsName);
	};

	@Override
	public int selectStorageRateCurrentByName(String goodsName) {
		logger.info("selectStorageRateCurrentByName");
		return tbStoragecheckMapper.selectStorageRateCurrentByName(goodsName);
	}
	
	@Override
	public int selectStorageRateCurrentById(int goodsId) {
		logger.info("selectStorageRateCurrentByName");
		return tbStoragecheckMapper.selectStorageRateCurrentById(goodsId);
	}

	@Override
	public int updateTbStoragecheck(TbStoragecheck storagecheck) {
		logger.info("selectStorageRateCurrentByName");
		return tbStoragecheckMapper.updateByPrimaryKeySelective(storagecheck);
	}

}
