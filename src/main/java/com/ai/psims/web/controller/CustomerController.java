package com.ai.psims.web.controller;

import java.util.Date;
import java.util.List;
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
import com.ai.psims.web.model.TbCustomer;
import com.ai.psims.web.model.TbCustomerExample;

;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/customerController")
public class CustomerController extends BaseController {

	private static final Logger logger = LoggerFactory
			.getLogger(CustomerController.class);

	@Resource(name = "customerBusinesImpl")
	private ICustomerBusiness customerBusiness;

	/**
	 * 客户管理页面跳转
	 */
	@SuppressWarnings("null")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String customerRedirect(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("------------Welcome customer page!-------------");
		// 1.初始化
		List<TbCustomer> customers;
		TbCustomerExample tbCustomerExample = null;
		// 2.获取参数
		String customer_name = request.getParameter("customer_name");
		String customer_type = request.getParameter("customer_type");
		String contact_name = request.getParameter("contact_name");
		String contact_tel = request.getParameter("contact_tel");
		// 3.数据校验
		if (customer_name != null &&customer_name.length() > 0) {
			tbCustomerExample.createCriteria().andCustomerNameEqualTo(contact_name);
		}
		if (customer_type != null && customer_type.length() > 0) {
			tbCustomerExample.createCriteria().andCustomerTypeEqualTo(customer_type);
		}
		if (contact_name != null && contact_name.length() > 0) {
			tbCustomerExample.createCriteria().andContactNameEqualTo(contact_name);
		}
		if (contact_tel != null && contact_tel.length() > 0) {
			tbCustomerExample.createCriteria().andContactTelEqualTo(contact_tel);
		}

		// 4.业务处理
		customers = customerBusiness.customerQuery(tbCustomerExample);
		// 5.返回结果
		request.setAttribute("customers", customers);

		logger.info("------------Bye customer page!-------------");
		return "customer";
	}

	/**
	 * 客户管理新增客户信息
	 */
	@RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
	public String tbCustomer(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("------------Welcome customer add info!-------------");
		// 1.初始化
		TbCustomer customeradd = new TbCustomer();
		// 2.获取参数
		String customer_name = request.getParameter("customer_name");
		String customer_code = request.getParameter("customer_code") == null ? request
				.getParameter("customer_name") : request
				.getParameter("customer_name");
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
		int res = customerBusiness.customerAdd(customeradd);
		toString();
		logger.info(String.valueOf(res));
		// 5.返回结果
		logger.info("------------Bye customer add info! -------------");
		return "customer";
	}

	/**
	 * 客户管理删除客户信息
	 */
	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.POST)
	public String customerDelete(Locale locale, Model model) {
		logger.info("------------Welcome deletecustomer! -------------");
		// 1.初始化
		TbCustomerExample tbCustomerExample = null;
		// 2.获取参数
		String customer_id = request.getParameter("customer_id");
		// 3.数据校验
		if (customer_id != "") {
			tbCustomerExample.createCriteria().andCustomerIdEqualTo(
					Integer.parseInt(customer_id));
		}
		// 4.业务处理
		int res = customerBusiness.customerDelete(tbCustomerExample);
		toString();
		logger.info(String.valueOf(res));
		// 5.返回结果
		logger.info("------------Bye deletecustomer! -------------");
		return "customer";
	}

	/**
	 * 客户管理修改客户信息
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String customerModify(Locale locale, Model model) {
		logger.info("------------Welcome customer!-------------");
		// 1.初始化
		TbCustomer tbCustomer = null;

		// 2.获取参数
		String customer_id = request.getParameter("customer_id");
		String customer_name = request.getParameter("customer_name");
		String customer_code = request.getParameter("customer_code") == null ? request
				.getParameter("customer_name") : request
				.getParameter("customer_name");
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
		if (customer_id != "") {
			tbCustomer.setCustomerId(Integer.parseInt(customer_id));
		}
		tbCustomer.setCustomerName(customer_name);
		tbCustomer.setCustomerCode(customer_code);
		tbCustomer.setContactName(contact_name);
		tbCustomer.setContactTel(contact_tel);
		tbCustomer.setContactAddr(contact_addr);
		tbCustomer.setEmail(email);
		tbCustomer.setArea(area);
		tbCustomer.setCustomerType(customer_type);
		tbCustomer.setCreatetime(createtime);
		tbCustomer.setStatus(status);
		tbCustomer.setRemark(remark);
		// 4.业务处理
		int res = customerBusiness.customerModify(tbCustomer);
		toString();
		logger.info(String.valueOf(res));
		// 5.返回结果
		logger.info("------------Bye customer!-------------");
		return "customer";
	}

	/**
	 * 客户管理查询客户信息
	 */
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public String customerQuery(HttpServletRequest request,
			HttpServletResponse response) {
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
