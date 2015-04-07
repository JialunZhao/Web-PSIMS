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

import com.ai.psims.web.business.IStorehouseBusiness;
import com.ai.psims.web.model.TbStorehouse;
import com.ai.psims.web.model.TbStorehouseExample;

/**
 * 仓库管理Controller
 */
@Controller
@RequestMapping("/storehouseController")
public class StorehouseController extends BaseController {

	private static final Logger logger = LoggerFactory
			.getLogger(StorehouseController.class);
	
	@Resource(name = "storehouseBusinessImpl")
	private IStorehouseBusiness storehouseBusiness;

	/**
	 * 仓库管理页面跳转
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String storehouseRedirectGET(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "redirect:/storehouseController/storehouse";
	} 
	/**
	 * 仓库管理页面跳转
	 */
	@RequestMapping(value = "/storehouse", method = RequestMethod.GET)
	public String storehouseRedirect(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("------------Welcome storehouse page!-------------");
		// 1.初始化
		List<TbStorehouse> storehouses;
		TbStorehouseExample tbStorehouseExample = new TbStorehouseExample();
		// 2.获取参数
		String storehouse_name = request.getParameter("query_storehouseName") == "" ? null
				: request.getParameter("query_storehouseName");
		String storehouse_type = request.getParameter("query_storehouseType") == "" ? null
				: request.getParameter("query_storehouseType");
		String contact_name = request.getParameter("query_contactName") == "" ? null
				: request.getParameter("query_contactName");
		String contact_tel = request.getParameter("query_contactTel") == "" ? null
				: request.getParameter("query_contactTel");
		// 3.数据校验
		if (storehouse_name != null && storehouse_name.length() > 0) {
			storehouse_name = "%" + storehouse_name + "%";
			tbStorehouseExample.createCriteria().andStorehouseNameLike(
					storehouse_name);
		}
		if (storehouse_type != null && storehouse_type.length() > 0) {
			if (!storehouse_type.equals("0")) {
				tbStorehouseExample.createCriteria().andTypeEqualTo(
						storehouse_type);
			}
		}
		if (contact_name != null && contact_name.length() > 0) {
			contact_name = "%" + contact_name + "%";
			tbStorehouseExample.createCriteria().andContactNameLike(contact_name);
		}
		if (contact_tel != null && contact_tel.length() > 0) {
			contact_tel = "%" + contact_tel + "%";
			tbStorehouseExample.createCriteria().andContactTelLike(contact_tel);
		}

		// 4.业务处理
		// 只查询状态为正常的记录 00-失效 01-正常 99-异常
		tbStorehouseExample.createCriteria().andStatusEqualTo("01");
		storehouses = storehouseBusiness.storehouseQuery(tbStorehouseExample);
		// 5.返回结果
		request.setAttribute("storehouses", storehouses);

		logger.info("------------Bye storehouse page!-------------");
		return "storehouse";
	}

	/**
	 * 仓库管理新增仓库信息
	 */
	@RequestMapping(value = "/addStorehouse", method = RequestMethod.POST)
	public String tbStorehouse(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("------------Welcome storehouse add info!-------------");
		// 1.初始化
		TbStorehouse storehouseadd = new TbStorehouse();
		// 2.获取参数
		String storehouseName = request.getParameter("storehouseName");
		String storehouseCode = request.getParameter("storehouseCode") == null ? request
				.getParameter("storehouseName") : request
				.getParameter("storehouseName");
		String contactName = request.getParameter("contactName");
		String contactTel = request.getParameter("contactTel");
		String contactAddress = request.getParameter("contactAddress");
		String contactEmail = request.getParameter("contactEmail");
		String area = request.getParameter("area");
		String storehouse_type = request.getParameter("type");
		// String createtime_str = request.getParameter("createtime");
		// String modifytime_str = request.getParameter("modifytime");
		// String endtime_str = request.getParameter("endtime");
		String status = request.getParameter("status");
		String remark = request.getParameter("remark");
		Date createtime = new Date();

		// 3.数据校验
		storehouseadd.setStorehouseName(storehouseName);
		storehouseadd.setStorehouseCode(storehouseCode);
		storehouseadd.setContactName(contactName);
		storehouseadd.setContactTel(contactTel);
		storehouseadd.setContactAddress(contactAddress);
		storehouseadd.setContactEmail(contactEmail);
		storehouseadd.setArea(area);
		storehouseadd.setStatus(status);
		storehouseadd.setType(storehouse_type);
		storehouseadd.setCreatetime(createtime);
		storehouseadd.setStatus("01"); // 新增状态为正常的记录 00-失效 01-正常 99-异常

		storehouseadd.setRemark(remark);

		// 4.业务处理
		int res = storehouseBusiness.storehouseAdd(storehouseadd);
		toString();
		logger.info(String.valueOf(res));
		// 5.返回结果
		logger.info("------------Bye storehouse add info! -------------");
		return "storehouse";
	}

	/**
	 * 仓库管理删除仓库信息
	 */
	@RequestMapping(value = "/deleteStorehouse", method = RequestMethod.POST)
	public String storehouseDelete(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("------------Welcome deletestorehouse! -------------");
		// 1.初始化
		TbStorehouse tbStorehouse = new TbStorehouse();
		// 2.获取参数
		String storehouse_id = request.getParameter("storehouse_id");
		// 3.数据校验
		if (storehouse_id != null && storehouse_id.length() > 0) {
			tbStorehouse.setStorehouseId(Integer.parseInt(storehouse_id));
		}
		// 4.业务处理
		// 逻辑删除 修改状态为 00-失效 （记录状态 00-失效 01-正常 99-异常）
		tbStorehouse.setStatus("00");
		int res = storehouseBusiness.storehouseModify(tbStorehouse);
		toString();
		logger.info(String.valueOf(res));

		// --弃用-- 改为逻辑删除
		// int res = storehouseBusiness.storehouseDelete(tbStorehouseExample);
		// toString();
		// logger.info(String.valueOf(res));
		// 5.返回结果
		logger.info("------------Bye deletestorehouse! -------------");
		return "storehouse";
	}

	/**
	 * 仓库管理修改仓库信息
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String storehouseModify(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("------------Welcome storehouse!-------------");
		// 1.初始化
		TbStorehouse tbStorehouse = new TbStorehouse();

		// 2.获取参数
		String storehouse_id = request.getParameter("modify_storehouseId");
		String storehouse_name = request.getParameter("modify_storehouseName");
		String storehouse_code = request.getParameter("modify_storehouse_code") == null ? request
				.getParameter("modify_storehouseName") : request
				.getParameter("modify_storehouse_code");
		String contact_name = request.getParameter("modify_contactName");
		String contact_tel = request.getParameter("modify_contactTel");
		String contact_addr = request.getParameter("modify_contactAddr");
		String email = request.getParameter("modify_email");
		String area = request.getParameter("modify_area");
		String storehouse_type = request.getParameter("modify_storehouseType");
		// String createtime_str = request.getParameter("createtime");
		// String modifytime_str = request.getParameter("modifytime");
		// String endtime_str = request.getParameter("endtime");
		// String status = request.getParameter("modify_status");
		String remark = request.getParameter("modify_remark");
		Date modifytime = new Date();

		// 3.数据校验
		if (storehouse_id != null && storehouse_id.length() > 0) {
			tbStorehouse.setStorehouseId(Integer.parseInt(storehouse_id));
		}
		tbStorehouse.setStorehouseName(storehouse_name);
		tbStorehouse.setStorehouseCode(storehouse_code);
		tbStorehouse.setContactName(contact_name);
		tbStorehouse.setContactTel(contact_tel);
		tbStorehouse.setContactAddress(contact_addr);
		tbStorehouse.setContactEmail(email);
		tbStorehouse.setArea(area);
		tbStorehouse.setType(storehouse_type);
		tbStorehouse.setModifytime(modifytime);
		// tbStorehouse.setStatus("01");
		tbStorehouse.setRemark(remark);
		// 4.业务处理
		int res = storehouseBusiness.storehouseModify(tbStorehouse);
		toString();
		logger.info(String.valueOf(res));
		// 5.返回结果
		logger.info("------------Bye storehouse!-------------");
		return "storehouse";
	}

	/**
	 * 仓库管理修改查询仓库信息
	 */
	@RequestMapping(value = "/queryStorehouse", method = RequestMethod.POST)
	public @ResponseBody List<TbStorehouse> storehouseQuery(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("------------Welcome queryStorehouse!-------------");
		// 1.初始化
		List<TbStorehouse> tbStorehouses;
		TbStorehouseExample tbStorehouseExample = new TbStorehouseExample();
		int storehouseid = 0;
		// 2.获取参数
		String storehouse_id = request.getParameter("storehouse_id");
		String storehouse_name = request.getParameter("storehouse_name");
		String storehouse_type = request.getParameter("storehouse_type");
		String contact_name = request.getParameter("contact_name");
		String contact_tel = request.getParameter("contact_tel");
		// 3.数据校验
		if (storehouse_id != null && storehouse_id.length() > 0) {
			storehouseid = Integer.parseInt(storehouse_id);
			tbStorehouseExample.createCriteria().andStorehouseIdEqualTo(storehouseid);
		}
		if (storehouse_name != null && storehouse_name.length() > 0) {
			tbStorehouseExample.createCriteria().andStorehouseNameEqualTo(
					contact_name);
		}
		if (storehouse_type != null && storehouse_type.length() > 0) {
			tbStorehouseExample.createCriteria().andTypeEqualTo(
					storehouse_type);
		}
		if (contact_name != null && contact_name.length() > 0) {
			tbStorehouseExample.createCriteria().andContactNameEqualTo(
					contact_name);
		}
		if (contact_tel != null && contact_tel.length() > 0) {
			tbStorehouseExample.createCriteria()
					.andContactTelEqualTo(contact_tel);
		}
		// 4.业务处理
		// 只查询状态为正常的记录 （00-失效 01-正常 99-异常）
		tbStorehouseExample.createCriteria().andStatusEqualTo("01");
		tbStorehouses = storehouseBusiness.storehouseQuery(tbStorehouseExample);
		request.setAttribute("tbStorehouses", tbStorehouses);
		// 5.返回结果
		logger.info("------------Bye queryStorehouse!-------------");
		return tbStorehouses;
	}

	@ExceptionHandler(Exception.class)
	public String exception(Exception e, HttpServletRequest request) {
		request.setAttribute("exception", e);
		return "error";
	}

}
