package com.ai.psims.web.service.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.*;

import org.junit.Test;
import org.springframework.stereotype.Service;

import com.ai.psims.web.dao.TbImportLogMapper;
import com.ai.psims.web.dao.TbImportMapper;
import com.ai.psims.web.model.TbImport;
import com.ai.psims.web.model.TbImportExample;
import com.ai.psims.web.model.TbImportLog;
import com.ai.psims.web.service.IImportService;

@Service
public class ImportServiceImpl implements IImportService {
	@Resource(name = "tbImportMapper")
	private TbImportMapper tbImportMapper;
	@Resource(name = "tbImportLogMapper")
	private TbImportLogMapper tbImportLogMapper;

    private static SqlSessionFactory sqlSessionFactory;
    
    /**
     * 获取Session
     *
     * @return
     */
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

    /**
     * 使用Mapper接口调用时，使用PageHelper.startPage效果更好，不需要添加Mapper接口参数
     */
    @Test
    public void testNavigatePages() {
        SqlSession sqlSession = getSqlSession();
        TbImportMapper countryMapper = sqlSession.getMapper(TbImportMapper.class);
        try {
            //获取第1页，10条内容，默认查询总数count
            PageHelper.startPage(1, 10);
            TbImportExample example = new TbImportExample();
            List<TbImport> list = countryMapper.selectByExample(example);
            PageInfo page = new PageInfo(list, 20);
            assertEquals(1, page.getPageNum());
            assertEquals(10, page.getPageSize());
            assertEquals(1, page.getStartRow());
            assertEquals(10, page.getEndRow());
            assertEquals(183, page.getTotal());
            assertEquals(19, page.getPages());
            assertEquals(1, page.getFirstPage());
            assertEquals(19, page.getLastPage());
            assertEquals(true, page.isIsFirstPage());
            assertEquals(false, page.isIsLastPage());
            assertEquals(false, page.isHasPreviousPage());
            assertEquals(true, page.isHasNextPage());

            //获取第2页，50条内容，默认查询总数count
            PageHelper.startPage(2, 50);
            list = countryMapper.selectByExample(example);
            page = new PageInfo(list, 2);
            assertEquals(2, page.getPageNum());
            assertEquals(50, page.getPageSize());
            assertEquals(51, page.getStartRow());
            assertEquals(100, page.getEndRow());
            assertEquals(183, page.getTotal());
            assertEquals(4, page.getPages());
            assertEquals(1, page.getFirstPage());
            assertEquals(2, page.getLastPage());
            assertEquals(false, page.isIsFirstPage());
            assertEquals(false, page.isIsLastPage());
            assertEquals(true, page.isHasPreviousPage());
            assertEquals(true, page.isHasNextPage());
        } finally {
            sqlSession.close();
        }
    }

	
	public int InsertImport(TbImport import1) {
		return tbImportMapper.insert(import1);
	}

	public TbImport selectByPrimaryKey(String importSerialNumber) {
		return tbImportMapper.selectBySerialNumber(importSerialNumber);
	}

	public int updateImport(TbImport import1) {
		insertToLog(import1);
		return tbImportMapper.updateByPrimaryKey(import1);
	}

	public int updateByKey(TbImport import1) {
		insertToLog(import1);
		return tbImportMapper.updateByPrimaryKeySelective(import1);
	}

	public int deleteImport(String importSerialNumber) {
		TbImport import1 = new TbImport();
		import1 = tbImportMapper.selectBySerialNumber(importSerialNumber);
		insertToLog(import1);
		// 00-失效；01-有效
		import1.setImportStatus("00");
		return tbImportMapper.updateByPrimaryKeySelective(import1);
	}

	@Override
	public int insertToLog(TbImport import1) {
		TbImport imports = new TbImport();
		imports = tbImportMapper.selectBySerialNumber(import1
				.getImportSerialNumber());
		TbImportLog log = new TbImportLog();
		log.setLogDatetime(new Date());
		log.setImportId(imports.getImportId());
		log.setImportSerialNumber(imports.getImportSerialNumber());
		log.setImportDatetime(imports.getImportDatetime());
		log.setImportBatchNumber(imports.getImportBatchNumber());
		log.setImportTotalPrice(imports.getImportTotalPrice());
		log.setPaymentStatus(imports.getPaymentStatus());
		log.setPaymentType(imports.getPaymentType());
		log.setPaymentTime(imports.getPaymentTime());
//		log.setPaymentPrice(imports.getPaymentPrice());
		log.setImportType(imports.getImportType());
		log.setImportStatus(imports.getImportStatus());
		log.setImportRemark(imports.getImportRemark());
		log.setProviderId(imports.getProviderId());
		log.setProviderName(imports.getProviderName());
		log.setProviderCode(imports.getProviderCode());

		return tbImportLogMapper.insertSelective(log);
	}

	@Override
	public List<TbImport> selectByExample(TbImportExample example) {
		return tbImportMapper.selectByExample(example);
	}

	@Override
	public String getImportSerialNumber(String importSerialNumber) {
		return tbImportMapper.getImportSerialNumber(importSerialNumber);
	}

}
