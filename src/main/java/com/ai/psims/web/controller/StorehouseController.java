package com.ai.psims.web.controller;

import java.text.SimpleDateFormat;
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

import com.ai.psims.web.business.IStorehouseBusiness;
import com.ai.psims.web.model.TbStorehouse;
import com.ai.psims.web.model.TbStorehouseExample;
import com.ai.psims.web.util.CreateIdUtil;

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
		logger.info("------------1.初始化-------------");
		List<TbStorehouse> storehouses;
		TbStorehouseExample tbStorehouseExample = new TbStorehouseExample();
		TbStorehouseExample.Criteria criteria = tbStorehouseExample.createCriteria();
		logger.info("------------2.获取参数-------------");
		String storehouse_name = request.getParameter("query_storehouseName") == "" ? null
				: request.getParameter("query_storehouseName");
		String storehouse_type = request.getParameter("query_storehouseType") == "" ? null
				: request.getParameter("query_storehouseType");
		String contact_name = request.getParameter("query_contactName") == "" ? null
				: request.getParameter("query_contactName");
		String contact_tel = request.getParameter("query_contactTel") == "" ? null
				: request.getParameter("query_contactTel");
		logger.info("------------3.数据校验-------------");
		if (storehouse_name != null && storehouse_name.length() > 0) {
			storehouse_name = "%" + storehouse_name + "%";
			criteria.andStorehouseNameLike(
					storehouse_name);
		}
		if (storehouse_type != null && storehouse_type.length() > 0) {
			if (!storehouse_type.equals("0")) {
				criteria.andTypeEqualTo(
						storehouse_type);
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
		criteria.andStatusEqualTo("01");
		storehouses = storehouseBusiness.storehouseQuery(tbStorehouseExample);
		logger.info("------------4.1.转译仓库类型-------------");
		for (TbStorehouse storehouse : storehouses) {
			if (storehouse.getType() == null) {
			} else {
				storehouse.setType(CreateIdUtil
						.getStorehouseType(storehouse.getType()));
			}
		}
		logger.info("------------5.返回结果-------------");
		request.setAttribute("storehouses", storehouses);
		request.setAttribute("storehouse_name", storehouse_name);
		request.setAttribute("storehouse_type", storehouse_type);
		request.setAttribute("contact_name", contact_name);
		request.setAttribute("contact_tel", contact_tel);

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
		logger.info("------------1.初始化-------------");
		TbStorehouse storehouseadd = new TbStorehouse();
		logger.info("------------2.获取参数-------------");
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

		logger.info("------------3.数据校验-------------");
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

		logger.info("------------4.业务处理-------------");
		int res = storehouseBusiness.storehouseAdd(storehouseadd);
		toString();
		logger.info(String.valueOf(res));
		logger.info("------------5.返回结果-------------");
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
		logger.info("------------1.初始化-------------");
		TbStorehouse tbStorehouse = new TbStorehouse();
		logger.info("------------2.获取参数-------------");
		String storehouseId = request.getParameter("storehouseId");
		logger.info("------------3.数据校验-------------");
		if (storehouseId != null && storehouseId.length() > 0) {
			tbStorehouse.setStorehouseId(Integer.parseInt(storehouseId));
		}
		logger.info("------------4.业务处理-------------");
		// 逻辑删除 修改状态为 00-失效 （记录状态 00-失效 01-正常 99-异常）
		tbStorehouse.setStatus("00");
		int res = storehouseBusiness.storehouseModify(tbStorehouse);
		toString();
		logger.info(String.valueOf(res));
		logger.info("------------5.返回结果-------------");
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
		logger.info("------------1.初始化-------------");
		TbStorehouse tbStorehouse = new TbStorehouse();

		logger.info("------------2.获取参数-------------");
		String storehouse_id = request.getParameter("modify_storehouseId");
		String storehouse_name = request.getParameter("modify_storehouseName");
		String storehouse_code = request.getParameter("modify_storehouse_code") == null ? request
				.getParameter("modify_storehouseName") : request
				.getParameter("modify_storehouse_code");
		String contact_name = request.getParameter("modify_contactName");
		String contact_tel = request.getParameter("modify_contactTel");
		String contact_addr = request.getParameter("modify_contactAddress");
		String email = request.getParameter("modify_email");
		String area = request.getParameter("modify_area");
		String storehouse_type = request.getParameter("modify_storehouseType");
		// String createtime_str = request.getParameter("createtime");
		// String modifytime_str = request.getParameter("modifytime");
		// String endtime_str = request.getParameter("endtime");
		// String status = request.getParameter("modify_status");
		String remark = request.getParameter("modify_remark");
		Date modifytime = new Date();

		logger.info("------------3.数据校验-------------");
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
		logger.info("------------4.业务处理-------------");
		int res = storehouseBusiness.storehouseModify(tbStorehouse);
		toString();
		logger.info(String.valueOf(res));
		logger.info("------------5.返回结果-------------");
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
		logger.info("------------1.初始化-------------");
		List<TbStorehouse> tbStorehouses;
		TbStorehouseExample tbStorehouseExample = new TbStorehouseExample();
		TbStorehouseExample.Criteria criteria = tbStorehouseExample.createCriteria();
		int storehouseid = 0;
		logger.info("------------2.获取参数-------------");
		String storehouseId = request.getParameter("storehouseId");
		logger.info("------------3.数据校验-------------");
		if (storehouseId != null && storehouseId.length() > 0) {
			storehouseid = Integer.parseInt(storehouseId);
			criteria.andStorehouseIdEqualTo(storehouseid);
		}
		logger.info("------------4.业务处理-------------");
		// 只查询状态为正常的记录 （00-失效 01-正常 99-异常）
		criteria.andStatusNotEqualTo("00");
		tbStorehouses = storehouseBusiness.storehouseQuery(tbStorehouseExample);
		request.setAttribute("tbStorehouses", tbStorehouses);
		logger.info("------------5.返回结果-------------");
		logger.info("------------Bye queryStorehouse!-------------");
		return tbStorehouses;
	}
	
	

	@RequestMapping(value = "/storehouseReportExecl")
	public View storehouseReportExecl(Model model, HttpServletRequest request) {
		logger.info("------------Welcome storehouseReportExecl page!-------------");
		logger.info("------------以 Apache POI 实现 AbstractExcelView-------------");
		View Excelview = new AbstractExcelView() {
			@Override
			public void buildExcelDocument(@SuppressWarnings("rawtypes") Map map, HSSFWorkbook workbook,
					HttpServletRequest request, HttpServletResponse response)
					throws Exception {
				logger.info("------------1.初始化-------------");
				List<TbStorehouse> storehouses;
				TbStorehouseExample tbStorehouseExample = new TbStorehouseExample();
				TbStorehouseExample.Criteria criteria = tbStorehouseExample.createCriteria();
				logger.info("------------2.获取参数-------------");
				String storehouse_name = request.getParameter("query_storehouseName") == "" ? null
						: request.getParameter("query_storehouseName");
				String storehouse_type = request.getParameter("query_storehouseType") == "" ? null
						: request.getParameter("query_storehouseType");
				String contact_name = request.getParameter("query_contactName") == "" ? null
						: request.getParameter("query_contactName");
				String contact_tel = request.getParameter("query_contactTel") == "" ? null
						: request.getParameter("query_contactTel");
				logger.info("------------3.数据校验-------------");
				if (storehouse_name != null && storehouse_name.length() > 0) {
					storehouse_name = "%" + storehouse_name + "%";
					criteria.andStorehouseNameLike(
							storehouse_name);
				}
				if (storehouse_type != null && storehouse_type.length() > 0) {
					if (!storehouse_type.equals("0")) {
						criteria.andTypeEqualTo(
								storehouse_type);
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
				criteria.andStatusEqualTo("01");
				storehouses = storehouseBusiness.storehouseQuery(tbStorehouseExample);
				logger.info("------------4.1.转译仓库类型-------------");
				for (TbStorehouse storehouse : storehouses) {
					if (storehouse.getType() == null) {
					} else {
						storehouse.setType(CreateIdUtil
								.getStorehouseType(storehouse.getType()));
					}
				}
				logger.info("------------5.返回结果-------------");

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
				header.createCell(idx++).setCellValue("仓库名称");
				header.createCell(idx++).setCellValue("仓库代码");
				header.createCell(idx++).setCellValue("仓库类型");
				header.createCell(idx++).setCellValue("联系人名称");
				header.createCell(idx++).setCellValue("联系人电话");
				header.createCell(idx++).setCellValue("仓库地址");
				header.createCell(idx++).setCellValue("仓库添加时间");
				header.createCell(idx++).setCellValue("仓库修改时间");
				header.createCell(idx++).setCellValue("备注");
				logger.info("------------输出内容-------------");
				HSSFRow row;
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");  
				for (TbStorehouse tbStorehouse : storehouses) {
					idx = 0;
					row = sheet.createRow(rowNum++);
					row.createCell(idx++).setCellValue(tbStorehouse.getStorehouseId());
					row.createCell(idx++).setCellValue(tbStorehouse.getStorehouseName());
					row.createCell(idx++).setCellValue(tbStorehouse.getStorehouseCode());
					row.createCell(idx++).setCellValue(tbStorehouse.getType());
					row.createCell(idx++).setCellValue(tbStorehouse.getContactName());
					row.createCell(idx++).setCellValue(tbStorehouse.getContactTel());
					row.createCell(idx++).setCellValue(tbStorehouse.getContactAddress());

					row.createCell(idx++).setCellValue(sdf.format(tbStorehouse.getCreatetime()));
					if (null !=tbStorehouse.getModifytime()) {						
						row.createCell(idx++).setCellValue(sdf.format(tbStorehouse.getModifytime()));
					}else {
						row.createCell(idx++).setCellValue("无");
					}
					row.createCell(idx++).setCellValue(tbStorehouse.getRemark());
//					row.createCell(idx++).setCellValue(tbStorehouse.get);
//					row.createCell(idx++).setCellValue(tbStorehouse.get);
				}
			}
		};
		logger.info("------------5.返回结果-------------");
		logger.info("------------回传 View 对象，返回生成的 Excel 档-------------");
		logger.info("------------Bye storehouseReportExecl page!-------------");
		return Excelview;
	}

	@ExceptionHandler(Exception.class)
	public String exception(Exception e, HttpServletRequest request) {
		request.setAttribute("exception", e);
		return "error";
	}

}
