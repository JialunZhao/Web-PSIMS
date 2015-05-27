package com.ai.psims.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.ai.psims.web.business.ICustomerBusiness;
import com.ai.psims.web.business.IEmployeeBusiness;
import com.ai.psims.web.business.ISystemParameterBussiness;
import com.ai.psims.web.model.TbCustomer;
import com.ai.psims.web.model.TbCustomerExample;
import com.ai.psims.web.model.TbEmployee;
import com.ai.psims.web.model.TbEmployeeExample;
import com.ai.psims.web.model.TbSystemParameter;
import com.ai.psims.web.model.TbSystemParameterExample;
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
	
	@Resource(name = "employeeBusinessImpl")
	private IEmployeeBusiness employeeBusinessImpl;
	
	@Resource(name = "systemParameterBussinessImpl")
	private ISystemParameterBussiness systemParameterBussinessImpl;

	
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
		List<TbCustomer> tbCustomers = new ArrayList<TbCustomer>();
		TbCustomerExample tbCustomerExample = new TbCustomerExample();
		TbCustomerExample.Criteria customerCriteria = tbCustomerExample.createCriteria();
		List<TbEmployee> tbEmployees = new ArrayList<TbEmployee>();
		TbEmployeeExample tbEmployeeExample =new TbEmployeeExample();
		TbEmployeeExample.Criteria employeeCriteria = tbEmployeeExample.createCriteria();
		List<TbSystemParameter> tbSystemParameters = new ArrayList<TbSystemParameter>();
		TbSystemParameterExample tbSystemParameterExample =new TbSystemParameterExample();
		TbSystemParameterExample.Criteria tbSystemParameterCriteria = tbSystemParameterExample.createCriteria();
		
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
			customerCriteria.andCustomerNameLike(customer_name);
		}
		if (customer_type != null && customer_type.length() > 0) {
			if (!customer_type.equals("0")) {
				customerCriteria.andCustomerTypeEqualTo(customer_type);
			}
		}
		if (contact_name != null && contact_name.length() > 0) {
			contact_name = "%" + contact_name + "%";
			customerCriteria.andContactNameLike(contact_name);
		}
		if (contact_tel != null && contact_tel.length() > 0) {
			contact_tel = "%" + contact_tel + "%";
			customerCriteria.andContactTelLike(contact_tel);
		}
		logger.info("------------4.业务处理-------------");
		// 只查询状态为正常的记录 00-失效 01-正常 99-异常
		customerCriteria.andStatusNotEqualTo("00");
		tbCustomers = customerBusiness.customerQuery(tbCustomerExample);
		logger.info("------------4.1.转译用户类型-------------");
		for (TbCustomer customer : tbCustomers) {
			if (customer.getCustomerType() == null) {
			} else {
				customer.setCustomerType(CreateIdUtil.getCustomerType(customer
						.getCustomerType()));
			}
		}
		logger.info("------------4.2.关联销售员工信息获取-------------");
		employeeCriteria.andStatusEqualTo("01");
		tbEmployees = employeeBusinessImpl.getEmployees(tbEmployeeExample);
		logger.info("------------4.3.关联结账方式信息获取-------------");
		tbSystemParameterCriteria.andPStatusEqualTo("01");
		tbSystemParameterCriteria.andPValueEqualTo("CheckoutType");
		tbSystemParameters = systemParameterBussinessImpl.selectByExample(tbSystemParameterExample);
		
		logger.info("------------5.返回结果-------------");
		request.setAttribute("tbEmployees", tbEmployees);
		request.setAttribute("tbCustomers", tbCustomers);
		request.setAttribute("tbSystemParameters", tbSystemParameters);
		
		request.setAttribute("customer_name", customer_name);
		request.setAttribute("customer_type", customer_type);
		request.setAttribute("contact_name", contact_name);
		request.setAttribute("contact_tel", contact_tel);
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
		String employeeId = request.getParameter("employeeId");
		String customer_type = request.getParameter("customer_type");
		String checkout_code = request.getParameter("checkout_code");
		String checkoutWarning = request.getParameter("checkoutWarning");
		String remark = request.getParameter("remark");
		Date createtime = new Date();
		logger.info("------------3.数据校验-------------");
		customeradd.setCustomerName(customer_name);
		customeradd.setCustomerCode(customer_code);
		customeradd.setContactName(contact_name);
		customeradd.setContactTel(contact_tel);
		customeradd.setContactAddr(contact_addr);
		customeradd.setEmail(email);
		customeradd.setCheckoutCode(checkout_code);
		customeradd.setCheckoutWarning(checkoutWarning);
		if (null != employeeId && employeeId.length() > 0) {
			customeradd.setEmployeeId(Integer.parseInt(employeeId));
		}
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
		String employeeId = request.getParameter("modify_employeeId");
		String customer_type = request.getParameter("modify_customerType");
		String checkout_code = request.getParameter("modify_checkout_code");
		String checkoutWarning = request.getParameter("modify_checkoutWarning");
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
		tbCustomer.setCheckoutCode(checkout_code);
		tbCustomer.setCheckoutWarning(checkoutWarning);
		if (null != employeeId && employeeId.length() > 0) {
			tbCustomer.setEmployeeId(Integer.parseInt(employeeId));
		}
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
		TbCustomerExample.Criteria criteria = tbCustomerExample.createCriteria();
		int customerid = 0;
		logger.info("------------2.获取参数-------------");
		String customer_id = request.getParameter("customer_id");
		logger.info("------------3.数据校验-------------");
		if (customer_id != null && customer_id.length() > 0) {
			customerid = Integer.parseInt(customer_id);
			criteria.andCustomerIdEqualTo(customerid);
		}
		logger.info("------------4.业务处理-------------");
		// 只查询状态为正常的记录 （00-失效 01-正常 99-异常）
		criteria.andStatusEqualTo("01");
		tbCustomers = customerBusiness.customerQuery(tbCustomerExample);
		
		request.setAttribute("tbCustomers", tbCustomers);
		logger.info("------------5.返回结果-------------");
		logger.info("------------Bye queryCustomer!-------------");
		return tbCustomers;
	}

	@RequestMapping(value = "/customerReportExecl")
	public View customerReportExecl(Model model, HttpServletRequest request) {
		logger.info("------------Welcome customerReportExecl page!-------------");
		logger.info("------------以 Apache POI 实现 AbstractExcelView-------------");
		View Excelview = new AbstractExcelView() {
			@Override
			public void buildExcelDocument(@SuppressWarnings("rawtypes") Map map, HSSFWorkbook workbook,
					HttpServletRequest request, HttpServletResponse response)
					throws Exception {
				
				logger.info("------------1.初始化-------------");
				List<TbCustomer> tbCustomers = new ArrayList<TbCustomer>();
				TbCustomerExample tbCustomerExample = new TbCustomerExample();
				TbCustomerExample.Criteria customerCriteria = tbCustomerExample.createCriteria();
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
					customerCriteria.andCustomerNameLike(customer_name);
				}
				if (customer_type != null && customer_type.length() > 0) {
					if (!customer_type.equals("0")) {
						customerCriteria.andCustomerTypeEqualTo(customer_type);
					}
				}
				if (contact_name != null && contact_name.length() > 0) {
					contact_name = "%" + contact_name + "%";
					customerCriteria.andContactNameLike(contact_name);
				}
				if (contact_tel != null && contact_tel.length() > 0) {
					contact_tel = "%" + contact_tel + "%";
					customerCriteria.andContactTelLike(contact_tel);
				}
				logger.info("------------4.业务处理-------------");
				// 只查询状态为正常的记录 00-失效 01-正常 99-异常
				customerCriteria.andStatusNotEqualTo("00");
				tbCustomers = customerBusiness.customerQuery(tbCustomerExample);
				logger.info("------------4.1.转译用户类型-------------");
				for (TbCustomer customer : tbCustomers) {
					if (customer.getCustomerType() == null) {
					} else {
						customer.setCustomerType(CreateIdUtil.getCustomerType(customer
								.getCustomerType()));
					}
				}

				logger.info("------------建立 Excel -Sheet-------------");
				HSSFSheet sheet = workbook.createSheet("客户清单");
				logger.info("------------设置行列的默认宽度和高度-------------");
				int idx = 0;
				sheet.setColumnWidth(idx++, 32 * 80);// 对A列设置宽度为180像素
				sheet.setColumnWidth(idx++, 32 * 180);
				sheet.setColumnWidth(idx++, 32 * 80);
				sheet.setColumnWidth(idx++, 32 * 80);
				sheet.setColumnWidth(idx++, 32 * 80);
				sheet.setColumnWidth(idx++, 32 * 80);
				sheet.setColumnWidth(idx++, 32 * 80);
				sheet.setColumnWidth(idx++, 32 * 180);
				sheet.setColumnWidth(idx++, 32 * 180);
				sheet.setColumnWidth(idx++, 32 * 180);
				sheet.setColumnWidth(idx++, 32 * 180);
				sheet.setColumnWidth(idx++, 32 * 180);
				
				int rowNum = 0;
				idx = 0;
				logger.info("------------建立标题-------------");
				HSSFRow header = sheet.createRow(rowNum++);
				header.createCell(idx++).setCellValue("编号");
				header.createCell(idx++).setCellValue("客户名称");
				header.createCell(idx++).setCellValue("客户代码");
				header.createCell(idx++).setCellValue("客户类别");
				header.createCell(idx++).setCellValue("联系人名称");
				header.createCell(idx++).setCellValue("联系人电话");
				header.createCell(idx++).setCellValue("客户地址");
				header.createCell(idx++).setCellValue("E-mail");
				header.createCell(idx++).setCellValue("业务员");
				header.createCell(idx++).setCellValue("结账方式");
				header.createCell(idx++).setCellValue("结账到期提醒(天)");
				header.createCell(idx++).setCellValue("客户添加时间");
				header.createCell(idx++).setCellValue("客户修改时间");
				header.createCell(idx++).setCellValue("备注");
				logger.info("------------输出内容-------------");
				HSSFRow row;
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");  

				for (TbCustomer tbCustomer : tbCustomers) {
					idx = 0;
					row = sheet.createRow(rowNum++);
					row.createCell(idx++).setCellValue(tbCustomer.getCustomerId());
					row.createCell(idx++).setCellValue(tbCustomer.getCustomerName());
					row.createCell(idx++).setCellValue(tbCustomer.getCustomerCode());
					row.createCell(idx++).setCellValue(tbCustomer.getCustomerType());
					row.createCell(idx++).setCellValue(tbCustomer.getContactName());
					row.createCell(idx++).setCellValue(tbCustomer.getContactTel());
					row.createCell(idx++).setCellValue(tbCustomer.getContactAddr());
					row.createCell(idx++).setCellValue(tbCustomer.getEmail());
					row.createCell(idx++).setCellValue(tbCustomer.getEmployeeName());
					row.createCell(idx++).setCellValue(tbCustomer.getCheckoutName());
					row.createCell(idx++).setCellValue(tbCustomer.getCheckoutWarning());
					row.createCell(idx++).setCellValue(sdf.format(tbCustomer.getCreatetime()));
					if (null !=tbCustomer.getModifytime()) {						
						row.createCell(idx++).setCellValue(sdf.format(tbCustomer.getModifytime()));
					}else {
						row.createCell(idx++).setCellValue("无");
					}
					row.createCell(idx++).setCellValue(tbCustomer.getRemark());
//					row.createCell(idx++).setCellValue(tbCustomer.get);
//					row.createCell(idx++).setCellValue(tbCustomer.get);
				}
			}
		};
		logger.info("------------5.返回结果-------------");
		logger.info("------------回传 View 对象，返回生成的 Excel 档-------------");
		logger.info("------------Bye storagecheckReportExecl page!-------------");
		return Excelview;
	}
	
	@ExceptionHandler(Exception.class)
	public String exception(Exception e, HttpServletRequest request) {
		request.setAttribute("exception", e);
		return "error";
	}

}
