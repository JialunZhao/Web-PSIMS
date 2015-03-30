package com.ai.psims.web.controller;

import java.util.ArrayList;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ai.psims.web.business.ICustomerBusiness;
import com.ai.psims.web.model.Customer;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/custormer")
public class CustomerController extends BaseController {

	private static final Logger logger = LoggerFactory
			.getLogger(CustomerController.class);

	@Resource(name = "customerBusinesImpl")
	private ICustomerBusiness customerBusiness;
	
	
	/**
	 * 客户管理页面跳转
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String customerRedirect(HttpServletRequest request , HttpServletResponse response)  throws Exception {
		logger.info("------------Welcome customer page!-------------");
		//1.查询客户信息列表
//		ArrayList<String> customerList = new ArrayList<String>();
		
		logger.info("------------Bye customer page!-------------");
		return "customer";
	}

	/**
	 * 客户管理新增客户信息
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String customerAdd(Locale locale, Model model) {
		logger.info("------------Welcome customer!-------------");
		Customer customeradd =new Customer();
		customeradd.setArea("123");
		customeradd.setCustomerId(123);
		customerBusiness.customeradd(customeradd);
		logger.info("------------Bye customer!-------------");
		return "customer";
	}

	/**
	 * 客户管理删除客户信息
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String customerDelete(Locale locale, Model model) {
		logger.info("------------Welcome customer!-------------");

		logger.info("------------Bye customer!-------------");
		return "customer";
	}

	/**
	 * 客户管理修改客户信息
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String customerModify(Locale locale, Model model) {
		logger.info("------------Welcome customer!-------------");

		logger.info("------------Bye customer!-------------");
		return "customer";
	}

	/**
	 * 客户管理查询客户信息
	 */
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public String customerQuery(Locale locale, Model model) {
		logger.info("------------Welcome customer!-------------");
		logger.info("------------Bye customer!-------------");
		return "customer";
	}

	@ExceptionHandler(Exception.class)
	public String exception(Exception e, HttpServletRequest request) {
		request.setAttribute("exception", e);
		return "error";
	}
}
