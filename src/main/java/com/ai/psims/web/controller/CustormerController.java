package com.ai.psims.web.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/custormer")
public class CustormerController {

	private static final Logger logger = LoggerFactory
			.getLogger(CustormerController.class);

	/**
	 * 客户管理页面跳转
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String customerRedirect(Locale locale, Model model) {
		logger.info("------------Welcome customer!-------------");
		
		logger.info("------------Bye customer!-------------");
		return "customer";
	}

	/**
	 * 客户管理新增客户信息
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String customerAdd(Locale locale, Model model) {
		logger.info("------------Welcome customer!-------------");
		
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
}
