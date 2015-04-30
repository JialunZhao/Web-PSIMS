package com.ai.psims.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.document.AbstractExcelView;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


/**
 * Excel处理控制器
 * 
 * @author zhaojl5
 * 
 */
@Controller
@RequestMapping("/excelController")
public class ExcelController extends AbstractController {
	
//	@Resource(name = "excelRevenueReportView")
//	private ExcelRevenueReportView excelRevenueReportView;

	@Override
	@RequestMapping(value = "/export")
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String output = ServletRequestUtils.getStringParameter(request,
				"output");

		Map<String, String> revenueData = new HashMap<String, String>();
		revenueData.put("Jan-2010", "$100,000,000");
		revenueData.put("Feb-2010", "$110,000,000");
		revenueData.put("Mar-2010", "$130,000,000");
		revenueData.put("Apr-2010", "$140,000,000");
		revenueData.put("May-2010", "$200,000,000");

		if (output == null || "".equals(output)) {
			// return normal view
			return new ModelAndView("RevenueSummary", "revenueData",
					revenueData);

		} else if ("EXCEL".equals(output.toUpperCase())) {
			// return excel view

			return new ModelAndView("ExcelRevenueSummary", "revenueData",
					revenueData);
			
		} else if ("EXCEL2007".equals(output.toUpperCase())) {
			// return excel view

			return new ModelAndView("Excel2007RevenueSummary", "revenueData",
					revenueData);

		} else {
			// return normal view
			return new ModelAndView("RevenueSummary", "revenueData",
					revenueData);

		}

	}

	@RequestMapping(value = "/export2")
	public View export(Model model, HttpServletRequest request) {

		final Map<String, String> revenueData = new HashMap<String, String>();
		revenueData.put("Jan-2010", "$100,000,000");
		revenueData.put("Feb-2010", "$110,000,000");
		revenueData.put("Mar-2010", "$130,000,000");
		revenueData.put("Apr-2010", "$140,000,000");
		revenueData.put("May-2010", "$200,000,000");
		
		// 以 Apache POI 实现 AbstractExcelView
		View view = new AbstractExcelView() {
			
			
			@Override
			protected void buildExcelDocument(@SuppressWarnings("rawtypes") Map map, HSSFWorkbook workbook,
					HttpServletRequest request, HttpServletResponse response)
					throws Exception {

				// 建立 Sheet
				HSSFSheet sheet = workbook.createSheet("客户资料");

	
				// 设置行列的默认宽度和高度
				sheet.setColumnWidth(0, 32 * 180);// 对A列设置宽度为80像素
				sheet.setColumnWidth(1, 32 * 80);
				sheet.setColumnWidth(2, 32 * 180);
				sheet.setColumnWidth(3, 32 * 80);
				sheet.setColumnWidth(4, 32 * 180);
				sheet.setColumnWidth(5, 32 * 80);
				
				int rowNum = 0;
				int idx = 0;

				// 建立标题
				HSSFRow header = sheet.createRow(rowNum++);
				header.createCell(idx++).setCellValue("流水号");
				header.createCell(idx++).setCellValue("名称");
				header.createCell(idx++).setCellValue("电话");
				header.createCell(idx++).setCellValue("手机");
				header.createCell(idx++).setCellValue("Email");
				header.createCell(idx++).setCellValue("地址");

				// 输出内容
//				List list = null; // 取得客户资料
				HSSFRow row;
				idx = 0;
				row = sheet.createRow(rowNum++);
				row.createCell(idx++).setCellValue("1");
				row.createCell(idx++).setCellValue("2");
				row.createCell(idx++).setCellValue("3");
				row.createCell(idx++).setCellValue("4");
				row.createCell(idx++).setCellValue("5");
				row.createCell(idx++).setCellValue("6");
				
				for (Map.Entry<String, String> entry : revenueData.entrySet()) {
					//create the row data
					idx = 0;
					row = sheet.createRow(rowNum++);
					row.createCell(idx++).setCellValue(entry.getKey());
					row.createCell(idx++).setCellValue(entry.getValue());
					row.createCell(idx++).setCellValue(entry.getKey());
					row.createCell(idx++).setCellValue(entry.getValue());
					row.createCell(idx++).setCellValue(entry.getKey());
					row.createCell(idx++).setCellValue(entry.getValue());
		                }	
			}
		};

		// 直接回传 View 对象，返回生成的 Excel 档
		return view;
	}

}