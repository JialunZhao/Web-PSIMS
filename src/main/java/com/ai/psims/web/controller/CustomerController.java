package com.ai.psims.web.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.psims.web.business.ICustomerBusiness;
import com.ai.psims.web.model.TbCustomer;
import com.ai.psims.web.model.TbCustomerExample;
import com.ai.psims.web.util.CreateIdUtil;

/**
 * 客户管理Controller
 */
@Controller
@RequestMapping("/customerController")
public class CustomerController extends BaseController {

	private static final Logger logger = LoggerFactory
			.getLogger(CustomerController.class);

	@Resource(name = "customerBusinessImpl")
	private ICustomerBusiness customerBusiness;

	/**
	 * 客户管理页面跳转
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String customerRedirectGET(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "redirect:/customerController/customer";
	}

	/**
	 * 客户管理页面跳转
	 */
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String customerRedirect(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("------------Welcome customer page!-------------");
		logger.info("------------1.初始化-------------");
		List<TbCustomer> customers;
		TbCustomerExample tbCustomerExample = new TbCustomerExample();
		TbCustomerExample.Criteria criteria = tbCustomerExample.createCriteria();
		logger.info("------------2.获取参数-------------");
		String customer_name = request.getParameter("query_customerName") == "" ? null
				: request.getParameter("query_customerName");
		String customer_type = request.getParameter("query_customerType") == "" ? null
				: request.getParameter("query_customerType");
		String contact_name = request.getParameter("query_contactName") == "" ? null
				: request.getParameter("query_contactName");
		String contact_tel = request.getParameter("query_contactTel") == "" ? null
				: request.getParameter("query_contactTel");
		logger.info("------------3.数据校验-------------");
		if (customer_name != null && customer_name.length() > 0) {
			customer_name = "%" + customer_name + "%";
			criteria.andCustomerNameLike(customer_name);
		}
		if (customer_type != null && customer_type.length() > 0) {
			if (!customer_type.equals("0")) {
				criteria.andCustomerTypeEqualTo(customer_type);
			}
		}
		if (contact_name != null && contact_name.length() > 0) {
			contact_name = "%" + contact_name + "%";
			criteria.andContactNameLike(contact_name);
		}
		if (contact_tel != null && contact_tel.length() > 0) {
			contact_tel = "%" + contact_tel + "%";
			criteria.andContactTelLike(contact_tel);
		}
		logger.info("------------4.业务处理-------------");
		// 只查询状态为正常的记录 00-失效 01-正常 99-异常
		criteria.andStatusNotEqualTo("00");
		customers = customerBusiness.customerQuery(tbCustomerExample);
		logger.info("------------4.1.转译用户类型-------------");
		for (TbCustomer customer : customers) {
			if (customer.getCustomerType() == null) {
			} else {
				customer.setCustomerType(CreateIdUtil.getCustomerType(customer
						.getCustomerType()));
			}
		}
		logger.info("------------5.返回结果-------------");
		request.setAttribute("customers", customers);
		logger.info("------------Bye customer page!-------------");
		return "customer";
	}

	/**
	 * 客户管理新增客户信息
	 */
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String tbCustomer(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("------------Welcome customer add info!-------------");
		logger.info("------------1.初始化-------------");
		TbCustomer customeradd = new TbCustomer();
		logger.info("------------2.获取参数-------------");
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
		// String status = request.getParameter("status");
		String remark = request.getParameter("remark");
		Date createtime = new Date();
		logger.info("------------3.数据校验-------------");
		customeradd.setCustomerName(customer_name);
		customeradd.setCustomerCode(customer_code);
		customeradd.setContactName(contact_name);
		customeradd.setContactTel(contact_tel);
		customeradd.setContactAddr(contact_addr);
		customeradd.setEmail(email);
		customeradd.setArea(area);
		customeradd.setCustomerType(customer_type);
		customeradd.setCreatetime(createtime);
		customeradd.setStatus("01"); // 新增状态为正常的记录 00-失效 01-正常 99-异常
		customeradd.setRemark(remark);
		logger.info("------------4.业务处理-------------");
		int res = customerBusiness.customerAdd(customeradd);
		toString();
		logger.info(String.valueOf(res));
		logger.info("------------5.返回结果-------------");
		logger.info("------------Bye customer add info! -------------");
		return "redirect:/customerController/customer";
	}

	/**
	 * 客户管理删除客户信息
	 */
	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.POST)
	public String customerDelete(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("------------Welcome deletecustomer! -------------");
		logger.info("------------1.初始化-------------");
		TbCustomer tbCustomer = new TbCustomer();
		logger.info("------------2.获取参数-------------");
		String customer_id = request.getParameter("customer_id");
		logger.info("------------3.数据校验-------------");
		if (customer_id != null && customer_id.length() > 0) {
			tbCustomer.setCustomerId(Integer.parseInt(customer_id));
		}
		logger.info("------------4.业务处理-------------");
		// 逻辑删除 修改状态为 00-失效 （记录状态 00-失效 01-正常 99-异常）
		tbCustomer.setStatus("00");
		int res = customerBusiness.customerModify(tbCustomer);
		toString();
		logger.info(String.valueOf(res));
		logger.info("------------5.返回结果-------------");
		logger.info("------------Bye deletecustomer! -------------");
		return "customer";
	}

	/**
	 * 客户管理修改客户信息
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String customerModify(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("------------Welcome customer!-------------");
		logger.info("------------1.初始化-------------");
		TbCustomer tbCustomer = new TbCustomer();
		logger.info("------------2.获取参数-------------");
		String customer_id = request.getParameter("modify_customerId");
		String customer_name = request.getParameter("modify_customerName");
		String customer_code = request.getParameter("modify_customer_code") == null ? request
				.getParameter("modify_customerName") : request
				.getParameter("modify_customer_code");
		String contact_name = request.getParameter("modify_contactName");
		String contact_tel = request.getParameter("modify_contactTel");
		String contact_addr = request.getParameter("modify_contactAddr");
		String email = request.getParameter("modify_email");
		String area = request.getParameter("modify_area");
		String customer_type = request.getParameter("modify_customerType");
		// String createtime_str = request.getParameter("createtime");
		// String modifytime_str = request.getParameter("modifytime");
		// String endtime_str = request.getParameter("endtime");
		// String status = request.getParameter("modify_status");
		String remark = request.getParameter("modify_remark");
		Date modifytime = new Date();
		logger.info("------------3.数据校验-------------");
		if (customer_id != null && customer_id.length() > 0) {
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
		tbCustomer.setModifytime(modifytime);
		// tbCustomer.setStatus("01");
		tbCustomer.setRemark(remark);
		logger.info("------------4.业务处理-------------");
		int res = customerBusiness.customerModify(tbCustomer);
		toString();
		logger.info(String.valueOf(res));
		logger.info("------------5.返回结果-------------");
		logger.info("------------Bye customer!-------------");
		return "customer";
	}

	/**
	 * 客户管理修改查询客户信息
	 */
	@RequestMapping(value = "/queryCustomer", method = RequestMethod.POST)
	public @ResponseBody List<TbCustomer> customerQuery(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("------------Welcome queryCustomer!-------------");
		logger.info("------------1.初始化-------------");
		List<TbCustomer> tbCustomers;
		TbCustomerExample tbCustomerExample = new TbCustomerExample();
		int customerid = 0;
		logger.info("------------2.获取参数-------------");
		String customer_id = request.getParameter("customer_id");
		String customer_name = request.getParameter("customer_name");
		String customer_type = request.getParameter("customer_type");
		String contact_name = request.getParameter("contact_name");
		String contact_tel = request.getParameter("contact_tel");
		logger.info("------------3.数据校验-------------");
		if (customer_id != null && customer_id.length() > 0) {
			customerid = Integer.parseInt(customer_id);
			tbCustomerExample.createCriteria().andCustomerIdEqualTo(customerid);
		}
		if (customer_name != null && customer_name.length() > 0) {
			tbCustomerExample.createCriteria().andCustomerNameEqualTo(
					contact_name);
		}
		if (customer_type != null && customer_type.length() > 0) {
			tbCustomerExample.createCriteria().andCustomerTypeEqualTo(
					customer_type);
		}
		if (contact_name != null && contact_name.length() > 0) {
			tbCustomerExample.createCriteria().andContactNameEqualTo(
					contact_name);
		}
		if (contact_tel != null && contact_tel.length() > 0) {
			tbCustomerExample.createCriteria()
					.andContactTelEqualTo(contact_tel);
		}
		logger.info("------------4.业务处理-------------");
		// 只查询状态为正常的记录 （00-失效 01-正常 99-异常）
		tbCustomerExample.createCriteria().andStatusEqualTo("01");
		tbCustomers = customerBusiness.customerQuery(tbCustomerExample);
		request.setAttribute("tbCustomers", tbCustomers);
		logger.info("------------5.返回结果-------------");
		logger.info("------------Bye queryCustomer!-------------");
		return tbCustomers;
	}

	@ExceptionHandler(Exception.class)
	public String exception(Exception e, HttpServletRequest request) {
		request.setAttribute("exception", e);
		return "error";
	}

}
