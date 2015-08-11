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
import com.ai.psims.web.business.ISystemParameterBussiness;
import com.ai.psims.web.model.TbGoods;
import com.ai.psims.web.model.TbStoragecheck;
import com.ai.psims.web.model.TbStoragecheckExample;

/**
 * 库存报表Controller
 */
@Controller
@RequestMapping("/storageCheckReportController")
public class StorageCheckReportController extends BaseController {

	private static final Logger logger = LoggerFactory
			.getLogger(StorageCheckReportController.class);

	@Resource(name = "storageCheckBusinessImpl")
	private IStorageCheckBusiness storageCheckBusinessImpl;

	@Resource(name = "systemParameterBussinessImpl")
	private ISystemParameterBussiness systemParameterBussinessImpl;

	
	/**
	 * 库存报表页面跳转
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String storageCheckRedirectGET(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "redirect:/storageCheckReportController/storageCheckReport";
	}

	/**
	 * 库存报表页面跳转
	 */
	@RequestMapping(value = "/storageCheckReport", method = RequestMethod.GET)
	public String storageCheckReport(HttpServletRequest request,
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
		logger.info("------------4.1.转译商品单位-------------");
		 for (TbStoragecheck tbStoragecheck : tbStoragechecks) {
			 if (tbStoragecheck.getImportGoodsUnit() != null)
				tbStoragecheck
						.setImportGoodsUnit(systemParameterBussinessImpl
								.getSystemParameterPrizePool(
										Integer.parseInt(tbStoragecheck
												.getImportGoodsUnit())).getPpDesc());

		 }
		logger.info("------------4.2.转译商品类型-------------");
		 for (TbStoragecheck tbStoragecheck : tbStoragechecks) {
			 if (tbStoragecheck.getGoodsType() != null)
				tbStoragecheck
						.setGoodsType(systemParameterBussinessImpl
								.getSystemParameterPrizePool(
										Integer.parseInt(tbStoragecheck
												.getGoodsType())).getPpDesc());

		 }
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
		request.setAttribute("storehouseName", storehouseName);
		logger.info("------------Bye storageCheckReport page!-------------");
		return "storagecheckreport";
	}

	@RequestMapping(value = "/storageCheckReportExecl")
	public View storagecheckReportExecl(Model model, HttpServletRequest request) {
		logger.info("------------Welcome storagecheckReportExecl page!-------------");
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
				logger.info("------------4.1.转译商品单位-------------");
				 for (TbStoragecheck tbStoragecheck : tbStoragechecks) {
					 if (tbStoragecheck.getImportGoodsUnit() != null)
						tbStoragecheck
								.setImportGoodsUnit(systemParameterBussinessImpl
										.getSystemParameterPrizePool(
												Integer.parseInt(tbStoragecheck
														.getImportGoodsUnit())).getPpDesc());

				 }
				 
				 
				logger.info("------------建立 Excel -Sheet-------------");
				HSSFSheet sheet = workbook.createSheet("库存清单");
				logger.info("------------设置行列的默认宽度和高度-------------");
				sheet.setColumnWidth(0, 32 * 80);// 对A列设置宽度为180像素
				sheet.setColumnWidth(1, 32 * 180);
				sheet.setColumnWidth(2, 32 * 80);
				sheet.setColumnWidth(3, 32 * 80);
				sheet.setColumnWidth(4, 32 * 80);
				sheet.setColumnWidth(5, 32 * 80);
				sheet.setColumnWidth(6, 32 * 80);
				sheet.setColumnWidth(7, 32 * 180);
				sheet.setColumnWidth(8, 32 * 180);
				sheet.setColumnWidth(9, 32 * 180);
				
				int rowNum = 0;
				int idx = 0;
				logger.info("------------建立标题-------------");
				HSSFRow header = sheet.createRow(rowNum++);
				header.createCell(idx++).setCellValue("编号");
				header.createCell(idx++).setCellValue("商品名称");
				header.createCell(idx++).setCellValue("商品代码");
				header.createCell(idx++).setCellValue("商品类型");
				header.createCell(idx++).setCellValue("剩余库存");
				header.createCell(idx++).setCellValue("库存总量");
				header.createCell(idx++).setCellValue("单位");
				header.createCell(idx++).setCellValue("供应商");
				header.createCell(idx++).setCellValue("入库时间");
				header.createCell(idx++).setCellValue("商品失效日期");
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
		logger.info("------------Bye storagecheckReportExecl page!-------------");
		return view;
	}

	@ExceptionHandler(Exception.class)
	public String exception(Exception e, HttpServletRequest request) {
		request.setAttribute("exception", e);
		return "error";
	}

}
