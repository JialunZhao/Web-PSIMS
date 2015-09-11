package com.ai.psims;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.psims.web.model.TbCustomer;
import com.ai.psims.web.model.TbCustomerExample;
import com.ai.psims.web.service.ICustomerService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
	
	
//	private ApplicationContext ac = null;
	@Resource
	private ICustomerService customerService ;

//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (IUserService) ac.getBean("userService");
//	}

	@Test
	public void test1() {
		TbCustomerExample tbCustomerExample = new TbCustomerExample();
		PageHelper.startPage(1, 10);
		PageHelper.orderBy("customer_id");
		List<TbCustomer> tbCustomers = new ArrayList<TbCustomer>();
		tbCustomers = customerService.queryCustomer(tbCustomerExample);
		//用PageInfo对结果进行包装
		PageInfo page = new PageInfo(tbCustomers);
		//测试PageInfo全部属性
		//PageInfo包含了非常全面的分页属性
//		assertEquals(1, page.getPageNum());
//		assertEquals(2, page.getPageSize());
//		assertEquals(1, page.getStartRow());
//		assertEquals(2, page.getEndRow());
//		assertEquals(570, page.getTotal());
//		assertEquals(285, page.getPages());
//		assertEquals(1, page.getFirstPage());
//		assertEquals(8, page.getLastPage());
//		assertEquals(true, page.isIsFirstPage());
//		assertEquals(false, page.isIsLastPage());
//		assertEquals(false, page.isHasPreviousPage());
//		assertEquals(true, page.isHasNextPage());
		
		for (int i = 0; i < tbCustomers.size(); i++) {
			logger.info(tbCustomers.get(i).getCustomerId());
		}
		
		PageHelper.startPage(2, 10);
		PageHelper.orderBy("customer_id");
		tbCustomers = customerService.queryCustomer(tbCustomerExample);
		logger.info("------------------");

		for (int i = 0; i < tbCustomers.size(); i++) {
			logger.info(tbCustomers.get(i).getCustomerId());
		}
//		logger.info(JSON.toJSONString(tbCustomers));
	}
}
