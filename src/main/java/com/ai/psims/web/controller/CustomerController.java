package com.ai.psims.web.controller;

import java.util.Date;
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
@RequestMapping("/custormerController")
public class CustomerController extends BaseController {

	private static final Logger logger = LoggerFactory
			.getLogger(CustomerController.class);

	@Resource(name = "customerBusinesImpl")
	private ICustomerBusiness customerBusiness;

	/**
	 * 客户管理页面跳转
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String customerRedirect(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("------------Welcome customer page!-------------");
		// 1.查询客户信息列表
		// ArrayList<String> customerList = new ArrayList<String>();

		logger.info("------------Bye customer page!-------------");
		return "customer";
	}

	/**
	 * 客户管理新增客户信息
	 */
	@RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
	public String customerAdd(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("------------Welcome customer add info!-------------");
		// 1.初始化
		Customer customeradd = new Customer();
		// 2.获取参数
		String customer_name = request.getParameter("customer_name");
		String customer_code = request.getParameter("customer_code")==null?request.getParameter("customer_name"):request.getParameter("customer_name");
		String contact_name = request.getParameter("contact_name");
		String contact_tel = request.getParameter("contact_tel");
		String contact_addr = request.getParameter("contact_addr");
		String email = request.getParameter("email");
		String area = request.getParameter("area");
		String customer_type = request.getParameter("customer_type");
		// String createtime_str = request.getParameter("createtime");
		// String modifytime_str = request.getParameter("modifytime");
		// String endtime_str = request.getParameter("endtime");
		String status = request.getParameter("status");
		String remark = request.getParameter("remark");
		Date createtime = new Date();

		// 3.数据校验
		customeradd.setCustomerName(customer_name);
		customeradd.setCustomerCode(customer_code);
		customeradd.setContactName(contact_name);
		customeradd.setContactTel(contact_tel);
		customeradd.setContactAddr(contact_addr);
		customeradd.setEmail(email);
		customeradd.setArea(area);
		customeradd.setCustomerType(customer_type);
		customeradd.setCreatetime(createtime);
		customeradd.setStatus(status);
		customeradd.setRemark(remark);

		// 4.业务处理
		int res = customerBusiness.customeradd(customeradd);
		toString();
		logger.info(String.valueOf(res));
		// 5.返回结果
		logger.info("------------Bye customer add info! -------------");
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
