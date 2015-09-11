package com.ai.psims.web.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.TbStoragecheckMapper;
import com.ai.psims.web.model.TbStoragecheck;
import com.ai.psims.web.model.TbStoragecheckExample;
import com.ai.psims.web.service.IStoragecheckService;

@Service
public class StoragecheckServiceImpl implements IStoragecheckService {
	private static final Logger logger = LoggerFactory
			.getLogger(StoragecheckServiceImpl.class);
	@Resource(name = "tbStoragecheckMapper")
	private TbStoragecheckMapper tbStoragecheckMapper;

	@Override
	public int insert(TbStoragecheck storagecheck) {
		return tbStoragecheckMapper.insertSelective(storagecheck);
	}

	@Override
	public List<TbStoragecheck> selectByExample(TbStoragecheckExample example) {
		return tbStoragecheckMapper.selectByExample(example);
	}

	@Override
	public TbStoragecheck selectByKey(Integer storageId) {
		return tbStoragecheckMapper.selectByPrimaryKey(storageId);
	}

//	@Override
//	public int deleteStoragecheck(Integer storageId) {
//		return tbStoragecheckMapper.deleteByPrimaryKey(storageId);
//	}

	@Override
	public List<TbStoragecheck> seekExpiration() {
		TbStoragecheckExample example = new TbStoragecheckExample();
		Date date = null;
		List<TbStoragecheck> storagechecks = tbStoragecheckMapper
				.selectByExample(example);
		List<TbStoragecheck> newstoragecheck = new ArrayList<TbStoragecheck>();
		if (storagechecks.size() > 0 && storagechecks != null) {
			for (TbStoragecheck storagecheck : storagechecks) {
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
	public List<TbStoragecheck> seekBExpiration() {
		TbStoragecheckExample example = new TbStoragecheckExample();
		Date date = null;
		Date date1 = null;
		List<TbStoragecheck> storagechecks = tbStoragecheckMapper
				.selectByExample(example);
		List<TbStoragecheck> newstoragecheck = new ArrayList<TbStoragecheck>();
		if (storagechecks.size() > 0 && storagechecks != null) {
			for (TbStoragecheck storagecheck : storagechecks) {
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
	public List<TbStoragecheck> seekCExpiration() {
		TbStoragecheckExample example = new TbStoragecheckExample();
		Date date = null;
		Date date1 = null;
		List<TbStoragecheck> storagechecks = tbStoragecheckMapper
				.selectByExample(example);
		List<TbStoragecheck> newstoragecheck = new ArrayList<TbStoragecheck>();
		if (storagechecks.size() > 0 && storagechecks != null) {
			for (TbStoragecheck storagecheck : storagechecks) {
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
	public List<TbStoragecheck> seekDExpiration() {
		TbStoragecheckExample example = new TbStoragecheckExample();
		Date date = null;
		List<TbStoragecheck> storagechecks = tbStoragecheckMapper
				.selectByExample(example);
		List<TbStoragecheck> newstoragecheck = new ArrayList<TbStoragecheck>();
		if (storagechecks.size() > 0 && storagechecks != null) {
			for (TbStoragecheck storagecheck : storagechecks) {
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
	public List<TbStoragecheck> seekStore() {
		return tbStoragecheckMapper.seekStore();
	}

	@Override
	public List<TbStoragecheck> seekBStore() {
		return tbStoragecheckMapper.seekBStore();
	}

	@Override
	public List<TbStoragecheck> seekCStore() {
		return tbStoragecheckMapper.seekCStore();
	}

	@Override
	public List<TbStoragecheck> seekDStore() {
		return tbStoragecheckMapper.seekDStore();
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

	@Override
	public int deleteTbStoragecheck(TbStoragecheck tbStoragecheck) {
		// TODO Auto-generated method stub
		tbStoragecheck.setStorageType("00");
		return tbStoragecheckMapper.updateByPrimaryKeySelective(tbStoragecheck);
	}

}
