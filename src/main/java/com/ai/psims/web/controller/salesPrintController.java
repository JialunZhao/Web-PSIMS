package com.ai.psims.web.controller;

import java.math.BigDecimal;
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

import com.ai.psims.web.business.ISalesBusiness;
import com.ai.psims.web.model.SalesGoods;
import com.ai.psims.web.model.SalesGoodsExample;

/**
 * 库存报表Controller
 */
@Controller
@RequestMapping("/salesPrintController")
public class salesPrintController extends BaseController {

	private static final Logger logger = LoggerFactory
			.getLogger(salesPrintController.class);

	@Resource(name = "salesBusinessImpl")
	private ISalesBusiness salesBusiness;

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
	@RequestMapping(value = "/init")
	public String init(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return "saleslistreport";
	}

	@RequestMapping(value = "/salesCheckReport")
	public View salesCheckReport(Model model, HttpServletRequest request) {
		logger.info("------------Welcome storagecheckReportExecl page!-------------");
		logger.info("------------以 Apache POI 实现 AbstractExcelView-------------");
		View view = new AbstractExcelView() {
			@Override
			public void buildExcelDocument(
					@SuppressWarnings("rawtypes") Map map,
					HSSFWorkbook workbook, HttpServletRequest request,
					HttpServletResponse response) throws Exception {
				logger.info("------------1.初始化-------------");
				List<SalesGoods> salesGoodsList = new ArrayList<SalesGoods>();
				SalesGoodsExample salesGoodsExample = new SalesGoodsExample();
				SalesGoodsExample.Criteria criteria = salesGoodsExample
						.createCriteria();
				logger.info("------------2.获取参数-------------");
				String salesSerialNumber = request
						.getParameter("salesSerialNumber") == "" ? null
						: request.getParameter("salesSerialNumber");
				logger.info("------------3.数据校验-------------");
				if (salesSerialNumber != null && salesSerialNumber.length() > 0) {
					salesSerialNumber = "%" + salesSerialNumber + "%";
					criteria.andSalesSerialNumberLike(salesSerialNumber);
				}
				logger.info("------------4.业务处理-------------");
				// 只查询状态为正常的记录 00-失效 01-正常 99-异常
				criteria.andSalesGoodsEndtimeIsNull();
				salesGoodsList = salesBusiness
						.selectSalesGoods(salesGoodsExample);
				logger.info("------------4.1.转译商品单位-------------");

				logger.info("------------建立 Excel -Sheet-------------");
				HSSFSheet sheet = workbook.createSheet("库存清单");
				logger.info("------------设置行列的默认宽度和高度-------------");
				sheet.setColumnWidth(0, 32 * 180);// 对A列设置宽度为180像素
				sheet.setColumnWidth(1, 32 * 80);
				sheet.setColumnWidth(2, 32 * 180);
				sheet.setColumnWidth(3, 32 * 80);
				sheet.setColumnWidth(4, 32 * 180);
				sheet.setColumnWidth(5, 32 * 80);
				sheet.setColumnWidth(6, 32 * 180);
				sheet.setColumnWidth(7, 32 * 80);
				sheet.setColumnWidth(8, 32 * 180);
				sheet.setColumnWidth(9, 32 * 80);
				sheet.setColumnWidth(10, 32 * 180);
				sheet.setColumnWidth(11, 32 * 80);
				sheet.setColumnWidth(12, 32 * 180);
				sheet.setColumnWidth(13, 32 * 80);
				sheet.setColumnWidth(14, 32 * 180);
				sheet.setColumnWidth(15, 32 * 80);
				sheet.setColumnWidth(16, 32 * 180);
				sheet.setColumnWidth(17, 32 * 80);
				sheet.setColumnWidth(18, 32 * 180);

				int rowNum = 0;
				int idx = 0;
				logger.info("------------建立标题-------------");
				HSSFRow header = sheet.createRow(rowNum++);
				header.createCell(idx++).setCellValue("商品名称");
				header.createCell(idx++).setCellValue("数量");
				header.createCell(idx++).setCellValue("单价");
				header.createCell(idx++).setCellValue("金额");
				header.createCell(idx++).setCellValue("进价");
				header.createCell(idx++).setCellValue("厂家投入");
				header.createCell(idx++).setCellValue("厂家退盖");
				header.createCell(idx++).setCellValue("单箱返利");
				header.createCell(idx++).setCellValue("加权平均返利");
				header.createCell(idx++).setCellValue("单箱季反");
				header.createCell(idx++).setCellValue("进货奖励");
				header.createCell(idx++).setCellValue("售点促销");
				header.createCell(idx++).setCellValue("单箱年反");
				header.createCell(idx++).setCellValue("店方回瓶");
				header.createCell(idx++).setCellValue("店方回盖");
				header.createCell(idx++).setCellValue("店方投入");
				header.createCell(idx++).setCellValue("单箱成本");
				header.createCell(idx++).setCellValue("单箱毛利");
				header.createCell(idx++).setCellValue("合计毛利");
				logger.info("------------输出内容-------------");
				HSSFRow row;
				// SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				String singleRebate, goodsDiscount, goodsActualCost, providerSubsidy, providerPackageSubsidy, purchaseRebate, promotionRebate, annualRebate, salesGoodsPrice;
				for (SalesGoods salesGoods : salesGoodsList) {
					idx = 0;

					singleRebate = (salesGoods.getSingleRebate() == "" || salesGoods
							.getSingleRebate() == null) ? "0.00" : salesGoods
							.getSingleRebate();
					goodsDiscount = (salesGoods.getGoodsDiscount() == "" || salesGoods
							.getGoodsDiscount() == null) ? "0.00" : salesGoods
							.getGoodsDiscount();
					goodsActualCost = (salesGoods.getGoodsActualCost() == "" || salesGoods
							.getGoodsActualCost() == null) ? "0.00"
							: salesGoods.getGoodsActualCost();
					providerSubsidy = (salesGoods.getProviderSubsidy() == "" || salesGoods
							.getProviderSubsidy() == null) ? "0.00"
							: salesGoods.getProviderSubsidy();
					providerPackageSubsidy = (salesGoods
							.getProviderPackageSubsidy() == "" || salesGoods
							.getProviderPackageSubsidy() == null) ? "0.00"
							: salesGoods.getProviderPackageSubsidy();
					purchaseRebate = (salesGoods.getPurchaseRebate() == "" || salesGoods
							.getPurchaseRebate() == null) ? "0.00" : salesGoods
							.getPurchaseRebate();
					promotionRebate = (salesGoods.getPromotionRebate() == "" || salesGoods
							.getPromotionRebate() == null) ? "0.00"
							: salesGoods.getPromotionRebate();
					salesGoodsPrice = (salesGoods.getSalesGoodsPrice() == "" || salesGoods
							.getSalesGoodsPrice() == null) ? "0.00"
							: salesGoods.getSalesGoodsPrice();
					annualRebate = (salesGoods.getAnnualRebate() == "" || salesGoods
							.getAnnualRebate() == null) ? "0.00" : salesGoods
							.getAnnualRebate();

					row = sheet.createRow(rowNum++);
					row.createCell(idx++).setCellValue(
							salesGoods.getGoodsName());
					row.createCell(idx++).setCellValue(
							salesGoods.getSalesGoodsAmount());
					row.createCell(idx++).setCellValue(salesGoodsPrice);
					row.createCell(idx++).setCellValue(
							salesGoods.getSalesGoodsTotalPrice());
					row.createCell(idx++).setCellValue(goodsActualCost);
					row.createCell(idx++).setCellValue(providerSubsidy);
					row.createCell(idx++).setCellValue(providerPackageSubsidy);
					row.createCell(idx++).setCellValue(singleRebate);
					row.createCell(idx++).setCellValue(
							salesGoods.getGoodsDiscount());
					row.createCell(idx++).setCellValue(
							new BigDecimal(singleRebate)
									.multiply(new BigDecimal(goodsDiscount))
									.divide(new BigDecimal(1.17),
											BigDecimal.ROUND_CEILING)
									.toString());
					row.createCell(idx++).setCellValue(purchaseRebate);
					row.createCell(idx++).setCellValue(promotionRebate);
					row.createCell(idx++).setCellValue(annualRebate);
					row.createCell(idx++).setCellValue(
							salesGoods.getCustomerBottleSubsidy());
					row.createCell(idx++).setCellValue(
							salesGoods.getCustomerPackageSubsidy());
					row.createCell(idx++).setCellValue(
							salesGoods.getCustomerSubsidy());
					row.createCell(idx++)
							.setCellValue(
									(new BigDecimal(goodsActualCost)
											.subtract(
													new BigDecimal(
															providerSubsidy))
											.subtract(
													new BigDecimal(
															providerPackageSubsidy))
											.subtract(
													new BigDecimal(singleRebate)
															.multiply(
																	new BigDecimal(
																			goodsDiscount))
															.divide(new BigDecimal(
																	1.17)))
											.subtract(
													new BigDecimal(
															purchaseRebate))
											.subtract(
													new BigDecimal(
															promotionRebate))
											.subtract(new BigDecimal(
													annualRebate))).toString());
					row.createCell(idx++)
							.setCellValue(
									new BigDecimal(salesGoodsPrice).subtract(
											new BigDecimal(goodsActualCost))
											.toString());
					row.createCell(idx++).setCellValue(
							((new BigDecimal(salesGoodsPrice)
									.subtract(new BigDecimal(goodsActualCost)))
									.multiply(new BigDecimal(salesGoods
											.getSalesGoodsAmount())))
									.toString());
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
