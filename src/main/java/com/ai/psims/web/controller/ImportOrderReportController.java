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
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.ai.psims.web.business.IImporBusiness;
import com.ai.psims.web.business.IQueryImportList;
import com.ai.psims.web.business.ISystemParameterBussiness;
import com.ai.psims.web.common.interfaces.IQueryBus;
import com.ai.psims.web.model.TbImport;
import com.ai.psims.web.model.TbImportExample;
import com.ai.psims.web.model.TbImportGoods;
import com.ai.psims.web.model.TbImportGoodsExample;
import com.ai.psims.web.model.TbProvider;
import com.ai.psims.web.model.TbStoragecheck;
import com.ai.psims.web.model.TbStoragecheckExample;
import com.ai.psims.web.model.TbStorehouse;

@Controller
@RequestMapping("/importOrderReportController")
public class ImportOrderReportController extends BaseController {

	private static final Logger logger = LoggerFactory
			.getLogger(ImportOrderReportController.class);

	@Resource(name = "queryBus")
	private IQueryBus queryBus;

	@Resource(name = "imporBusinessImpl")
	private IImporBusiness imporBusinessImpl;

	@Resource(name = "queryImportListImpl")
	private IQueryImportList queryImportList;

	@Resource(name = "systemParameterBussinessImpl")
	private ISystemParameterBussiness systemParameterBussinessImpl;

	/**
	 * 入库下单报表页面跳转
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String storageCheckRedirectGET(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "redirect:/importOrderReportController/importOrderReport";
	}

	@RequestMapping(value = "/importOrderReport", method = RequestMethod.GET)
	public String init(HttpServletRequest request) throws Exception {
		logger.info("------------Welcome importOrder page!-------------");
		logger.info("------------1.初始化-------------");
		List<TbProvider> provider = new ArrayList<TbProvider>();
		List<TbStorehouse> storehouse = new ArrayList<TbStorehouse>();
		List<TbImport> importList = new ArrayList<TbImport>();
		TbImportExample tbImportExample = new TbImportExample();
		TbImportExample.Criteria criteria = tbImportExample.createCriteria();
		List<TbImportGoods> tbImportGoodsList = new ArrayList<TbImportGoods>();
		TbImportGoodsExample tbImportGoodsExample = new TbImportGoodsExample();
		TbImportGoodsExample.Criteria tbImportGoodsExampleCriteria = tbImportGoodsExample
				.createCriteria();
		logger.info("------------2.获取参数-------------");
		String queProviderId = request.getParameter("queProviderId") == "" ? null
				: request.getParameter("queProviderId");
		String quePayMed = request.getParameter("quePayMed") == "" ? null
				: request.getParameter("quePayMed");
		String queImportStatus = request.getParameter("queImportStatus") == "" ? null
				: request.getParameter("queImportStatus");
		String queImportSerialNumber = request
				.getParameter("queImportSerialNumber") == "" ? null : request
				.getParameter("queImportSerialNumber");
		logger.info("------------3.数据校验-------------");
		if (queProviderId != null && queProviderId.length() > 0) {
			criteria.andProviderIdEqualTo(Integer.parseInt(queProviderId));
		}
		if (quePayMed != null && quePayMed.length() > 0) {
			criteria.andPaymentTypeEqualTo(quePayMed);
		}
		if (queImportStatus != null && queImportStatus.length() > 0) {
			criteria.andImportStatusEqualTo(queImportStatus);
		}
		if (queImportSerialNumber != null && queImportSerialNumber.length() > 0) {
			queImportSerialNumber = "%" + queImportSerialNumber + "%";
			criteria.andImportSerialNumberLike(queImportSerialNumber);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		// Date date = new Date();
		// String todayMonth = sdf.format(date) + "%";
		criteria.andImportStatusNotEqualTo("00");
		// criteria.andImportSerialNumberLike(todayMonth);
		tbImportExample.setOrderByClause("import_serial_number desc");
		logger.info("------------4.业务处理-------------");
		importList = queryBus.queryImport(tbImportExample);
		provider = queryBus.queryProvider();
		storehouse = queryBus.queryStorehouse();
		tbImportGoodsList = imporBusinessImpl
				.queryImportGoods(tbImportGoodsExample);
		logger.info("------------5.返回结果-------------");
		request.setAttribute("providerList", provider);
		request.setAttribute("storehouseList", storehouse);
		request.setAttribute("importList", importList);
		request.setAttribute("tbImportGoodsList", tbImportGoodsList);
		
		request.setAttribute("queProviderId", queProviderId);
		request.setAttribute("quePayMed", quePayMed);
		request.setAttribute("queImportStatus", queImportStatus);
		request.setAttribute("queImportSerialNumber", queImportSerialNumber);
		
		logger.info("------------Bye importOrder page!-------------");
		return "importorderreport";

	}

	@RequestMapping(value = "/importOrderReportExecl")
	public View importOrderReportExecl(Model model, HttpServletRequest request) {
		logger.info("------------Welcome importOrderReportExecl page!-------------");
		logger.info("------------以 Apache POI 实现 AbstractExcelView-------------");
		View view = new AbstractExcelView() {
			@Override
			public void buildExcelDocument(
					@SuppressWarnings("rawtypes") Map map,
					HSSFWorkbook workbook, HttpServletRequest request,
					HttpServletResponse response) throws Exception {
				logger.info("------------1.初始化-------------");
				List<TbProvider> provider = new ArrayList<TbProvider>();
				List<TbStorehouse> storehouse = new ArrayList<TbStorehouse>();
				List<TbImport> importList = new ArrayList<TbImport>();
				TbImportExample tbImportExample = new TbImportExample();
				TbImportExample.Criteria criteria = tbImportExample
						.createCriteria();
				List<TbImportGoods> tbImportGoodsList = new ArrayList<TbImportGoods>();
				TbImportGoodsExample tbImportGoodsExample = new TbImportGoodsExample();
				TbImportGoodsExample.Criteria tbImportGoodsExampleCriteria = tbImportGoodsExample
						.createCriteria();
				logger.info("------------2.获取参数-------------");
				String queProviderId = request.getParameter("queProviderId") == "" ? null
						: request.getParameter("queProviderId");
				String quePayMed = request.getParameter("quePayMed") == "" ? null
						: request.getParameter("quePayMed");
				String queImportStatus = request
						.getParameter("queImportStatus") == "" ? null : request
						.getParameter("queImportStatus");
				String queImportSerialNumber = request
						.getParameter("queImportSerialNumber") == "" ? null
						: request.getParameter("queImportSerialNumber");
				logger.info("------------3.数据校验-------------");
				if (queProviderId != null && queProviderId.length() > 0) {
					criteria.andProviderIdEqualTo(Integer
							.parseInt(queProviderId));
				}
				if (quePayMed != null && quePayMed.length() > 0) {
					criteria.andPaymentTypeEqualTo(quePayMed);
				}
				if (queImportStatus != null && queImportStatus.length() > 0) {
					criteria.andImportStatusEqualTo(queImportStatus);
				}
				if (queImportSerialNumber != null
						&& queImportSerialNumber.length() > 0) {
					queImportSerialNumber = "%" + queImportSerialNumber + "%";
					criteria.andImportSerialNumberLike(queImportSerialNumber);
				}

				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
				Date date = new Date();
				String todayMonth = sdf.format(date) + "%";
				criteria.andImportStatusNotEqualTo("00");
				// criteria.andImportSerialNumberLike(todayMonth);
				tbImportExample.setOrderByClause("import_serial_number desc");
				logger.info("------------4.业务处理-------------");
				importList = queryBus.queryImport(tbImportExample);
				provider = queryBus.queryProvider();
				storehouse = queryBus.queryStorehouse();
				tbImportGoodsList = imporBusinessImpl
						.queryImportGoods(tbImportGoodsExample);

				logger.info("------------建立 Excel -Sheet-------------");
				HSSFSheet sheet = workbook.createSheet("入库下单清单");
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
				header.createCell(idx++).setCellValue("入库流水号");
				header.createCell(idx++).setCellValue("供应商名称");
				header.createCell(idx++).setCellValue("入库下单日期");
				header.createCell(idx++).setCellValue("入库批次号");
				header.createCell(idx++).setCellValue("备注");
				header.createCell(idx++).setCellValue("入库状态");
				logger.info("------------输出内容-------------");
				HSSFRow row;
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

				for (TbImport tbImport : importList) {
					idx = 0;
					row = sheet.createRow(rowNum++);
					row.createCell(idx++).setCellValue(tbImport.getImportId());
					row.createCell(idx++).setCellValue(
							tbImport.getImportSerialNumber());
					row.createCell(idx++).setCellValue(
							tbImport.getProviderName());
					row.createCell(idx++).setCellValue(
							tbImport.getImportDatetime());
					row.createCell(idx++).setCellValue(
							tbImport.getImportBatchNumber());
					row.createCell(idx++).setCellValue(
							tbImport.getImportRemark());
					row.createCell(idx++).setCellValue(
							tbImport.getImportStatus());
					idx = 0;
					row = sheet.createRow(rowNum++);
					row.createCell(idx++).setCellValue("商品详情");
					row.createCell(idx++).setCellValue("商品名称");
					row.createCell(idx++).setCellValue("商品单价");
					row.createCell(idx++).setCellValue("商品数量");
					row.createCell(idx++).setCellValue("总价");
					row.createCell(idx++).setCellValue("奖金池支付总额");
					row.createCell(idx++).setCellValue("现金支付总额");
					for (TbImportGoods tbImportGoods : tbImportGoodsList) {
						if (tbImportGoods.getImportSerialNumber().equals(
								tbImport.getImportSerialNumber())) {
							idx = 0;
							row = sheet.createRow(rowNum++);
							row.createCell(idx++).setCellValue("商品详情");
							row.createCell(idx++).setCellValue(tbImportGoods.getGoodsName());
							row.createCell(idx++).setCellValue(tbImportGoods.getImportGoodsPrice());
							row.createCell(idx++).setCellValue(tbImportGoods.getImportGoodsAmount());
							row.createCell(idx++).setCellValue(tbImportGoods.getImportGoodsTotalPrice());
							row.createCell(idx++).setCellValue(tbImportGoods.getDiscountDutyTotalPrice());
							row.createCell(idx++).setCellValue(tbImportGoods.getDiscountGoodsTotalPrice());
						}
					}
					row = sheet.createRow(rowNum++);
				}
			}
		};
		logger.info("------------5.返回结果-------------");
		logger.info("------------回传 View 对象，返回生成的 Excel 档-------------");
		logger.info("------------Bye importOrderReportExecl page!-------------");
		return view;
	}

	@ExceptionHandler(Exception.class)
	public String exception(Exception e, HttpServletRequest request) {
		request.setAttribute("exception", e);
		return "error";
	}

}
