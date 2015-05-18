package com.ai.psims.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.ai.psims.web.business.IStorageCheckBusiness;
import com.ai.psims.web.model.TbStoragecheck;
import com.ai.psims.web.model.TbStoragecheckExample;

/**
 * 详单报表Controller
 */
@Controller
@RequestMapping("/detailedListReportController")
public class DetailedListReportController extends BaseController {

	private static final Logger logger = LoggerFactory
			.getLogger(DetailedListReportController.class);

	@Resource(name = "storageCheckBusinessImpl")
	private IStorageCheckBusiness storageCheckBusinessImpl;

	/**
	 * 详单报表页面跳转
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String storageCheckRedirectGET(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "redirect:/detailedListReportController/detailedListReport";
	}

	/**
	 * 详单报表页面跳转
	 */
	@RequestMapping(value = "/detailedListReport", method = RequestMethod.GET)
	public String detailedListReport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("------------Welcome storageCheckReport page!-------------");
		logger.info("------------1.初始化-------------");
		List<TbStoragecheck> tbStoragechecks = new ArrayList<TbStoragecheck>();
		TbStoragecheckExample tbStoragecheckExample = new TbStoragecheckExample();
		TbStoragecheckExample.Criteria criteria = tbStoragecheckExample.createCriteria();
		logger.info("------------2.获取参数-------------");
		String goodsName = request.getParameter("goodsName") == "" ? null
				: request.getParameter("goodsName");
		String goodsType = request.getParameter("goodsType") == "" ? null
				: request.getParameter("goodsType");
		String goodsCode = request.getParameter("goodsCode") == "" ? null
				: request.getParameter("goodsCode");
		String customerName = request.getParameter("customerName") == "" ? null
				: request.getParameter("storehouseName");
		logger.info("------------3.数据校验-------------");
		if (goodsName != null && goodsName.length() > 0) {
			goodsName = "%" + goodsName + "%";
			criteria.andGoodsNameLike(goodsName);
		}
		if (goodsType != null && goodsType.length() > 0) {
			if (!goodsType.equals("0")) {
				criteria.andGoodsTypeEqualTo(goodsType);
			}
		}
		if (goodsCode != null && goodsCode.length() > 0) {
			goodsCode = "%" + goodsCode + "%";
			criteria.andGoodsCodeLike(goodsCode);
		}
		if (customerName != null && customerName.length() > 0) {
			customerName = "%" + customerName + "%";
			criteria.andStorehouseNameLike(customerName);
		}
		logger.info("------------4.业务处理-------------");
		// 只查询状态为正常的记录 00-失效 01-正常 99-异常
		criteria.andGoodsStatusNotEqualTo("00");
		tbStoragechecks = storageCheckBusinessImpl.selectStoragecheck(tbStoragecheckExample);
		logger.info("------------4.1.转译用户类型-------------");
//		 for (TbStoragecheck tbStoragecheck : tbStoragechecks) {
//
//		 }
//		row.createCell(idx++).setCellValue(sdf.format(tbStoragecheck.getCreatetime()));
//		row.createCell(idx++).setCellValue(sdf.format(tbStoragecheck.getGoodsExpirationDate()));
//	
		//		for (TbStoragecheck tbStoragecheck : tbStoragechecks) {
//			if (tbStoragecheck.getCustomerType() == null) {
//			} else {
//				tbStoragecheck.setCustomerType(CreateIdUtil.getCustomerType(customer
//						.getCustomerType()));
//			}
//		}
		logger.info("------------5.返回结果-------------");
		request.setAttribute("tbStoragechecks", tbStoragechecks);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodsType", goodsType);
		request.setAttribute("goodsCode", goodsCode);
		request.setAttribute("customerName", customerName);
		logger.info("------------Bye storageCheckReport page!-------------");
		return "detailedlistreport";
	}

	@RequestMapping(value = "/detailedListReportExecl")
	public View detailedListReportExecl(Model model, HttpServletRequest request) {
		logger.info("------------Welcome detailedListReportExecl page!-------------");
		logger.info("------------以 Apache POI 实现 AbstractExcelView-------------");
		View view = new AbstractExcelView() {
			@Override
			public void buildExcelDocument(@SuppressWarnings("rawtypes") Map map, HSSFWorkbook workbook,
					HttpServletRequest request, HttpServletResponse response)
					throws Exception {
				logger.info("------------1.初始化-------------");
				List<TbStoragecheck> tbStoragechecks = new ArrayList<TbStoragecheck>();
				TbStoragecheckExample tbStoragecheckExample = new TbStoragecheckExample();
				TbStoragecheckExample.Criteria criteria = tbStoragecheckExample.createCriteria();
				logger.info("------------2.获取参数-------------");
				String goodsName = request.getParameter("goodsName") == "" ? null
						: request.getParameter("goodsName");
				String goodsType = request.getParameter("goodsType") == "" ? null
						: request.getParameter("goodsType");
				String goodsCode = request.getParameter("goodsCode") == "" ? null
						: request.getParameter("goodsCode");
				String storehouseName = request.getParameter("storehouseName") == "" ? null
						: request.getParameter("storehouseName");
				logger.info("------------3.数据校验-------------");
				if (goodsName != null && goodsName.length() > 0) {
					goodsName = "%" + goodsName + "%";
					criteria.andGoodsNameLike(goodsName);
				}
				if (goodsType != null && goodsType.length() > 0) {
					if (!goodsType.equals("0")) {
						criteria.andGoodsTypeEqualTo(goodsType);
					}
				}
				if (goodsCode != null && goodsCode.length() > 0) {
					goodsCode = "%" + goodsCode + "%";
					criteria.andGoodsCodeLike(goodsCode);
				}
				if (storehouseName != null && storehouseName.length() > 0) {
					storehouseName = "%" + storehouseName + "%";
					criteria.andStorehouseNameLike(storehouseName);
				}
				logger.info("------------4.业务处理-------------");
				// 只查询状态为正常的记录 00-失效 01-正常 99-异常
				criteria.andGoodsStatusNotEqualTo("00");
				tbStoragechecks = storageCheckBusinessImpl.selectStoragecheck(tbStoragecheckExample);

				logger.info("------------建立 Excel -Sheet-------------");
				HSSFSheet sheet = workbook.createSheet("详单报表");
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
				sheet.setColumnWidth(idx++, 32 * 180);
				sheet.setColumnWidth(idx++, 32 * 180);
				sheet.setColumnWidth(idx++, 32 * 180);
				sheet.setColumnWidth(idx++, 32 * 180);
				sheet.setColumnWidth(idx++, 32 * 180);
				sheet.setColumnWidth(idx++, 32 * 180);
				sheet.setColumnWidth(idx++, 32 * 180);
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
				header.createCell(idx++).setCellValue("月");
				header.createCell(idx++).setCellValue("日");
				header.createCell(idx++).setCellValue("客户名称");
				header.createCell(idx++).setCellValue("分店");
				header.createCell(idx++).setCellValue("产品分类");
				header.createCell(idx++).setCellValue("产品名称");
				header.createCell(idx++).setCellValue("数量");
				header.createCell(idx++).setCellValue("单价");
				header.createCell(idx++).setCellValue("金额");
				header.createCell(idx++).setCellValue("进价");
				header.createCell(idx++).setCellValue("厂家投入");
				header.createCell(idx++).setCellValue("厂家退盖");
				header.createCell(idx++).setCellValue("单箱返利");
				header.createCell(idx++).setCellValue("单箱季返");
				header.createCell(idx++).setCellValue("单箱年返");
				header.createCell(idx++).setCellValue("店方回瓶");
				header.createCell(idx++).setCellValue("店方回盖");
				header.createCell(idx++).setCellValue("店方投入");
				header.createCell(idx++).setCellValue("单箱成本");
				header.createCell(idx++).setCellValue("单箱毛利");
				header.createCell(idx++).setCellValue("合计毛利");
				header.createCell(idx++).setCellValue("批号");
				header.createCell(idx++).setCellValue("备注");
				logger.info("------------输出内容-------------");
				HSSFRow row;
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  

				for (TbStoragecheck tbStoragecheck : tbStoragechecks) {
					idx = 0;
					row = sheet.createRow(rowNum++);
					row.createCell(idx++).setCellValue(tbStoragecheck.getStorageId());
					row.createCell(idx++).setCellValue(tbStoragecheck.getGoodsName());
					row.createCell(idx++).setCellValue(tbStoragecheck.getGoodsCode());
					row.createCell(idx++).setCellValue(tbStoragecheck.getGoodsType());
					row.createCell(idx++).setCellValue(tbStoragecheck.getStorageRateCurrent());
					row.createCell(idx++).setCellValue(tbStoragecheck.getStorageRateTotal());
					row.createCell(idx++).setCellValue(tbStoragecheck.getImportGoodsUnit());
					row.createCell(idx++).setCellValue(tbStoragecheck.getProviderName());
					row.createCell(idx++).setCellValue(sdf.format(tbStoragecheck.getCreatetime()));
					row.createCell(idx++).setCellValue(sdf.format(tbStoragecheck.getGoodsExpirationDate()));
					row.createCell(idx++).setCellValue(tbStoragecheck.getRemark());
				}
			}
		};
		logger.info("------------5.返回结果-------------");
		logger.info("------------回传 View 对象，返回生成的 Excel 档-------------");
		logger.info("------------Bye detailedListReportExecl page!-------------");
		return view;
	}

	@ExceptionHandler(Exception.class)
	public String exception(Exception e, HttpServletRequest request) {
		request.setAttribute("exception", e);
		return "error";
	}

}
