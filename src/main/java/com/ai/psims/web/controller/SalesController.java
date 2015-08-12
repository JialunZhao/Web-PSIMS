package com.ai.psims.web.controller;

import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.ai.psims.web.business.ICustomerBusiness;
import com.ai.psims.web.business.IEmployeeBusiness;
import com.ai.psims.web.business.ISalesBusiness;
import com.ai.psims.web.common.interfaces.IQueryBus;
import com.ai.psims.web.model.AddSalesGoodsBean;
import com.ai.psims.web.model.Sales;
import com.ai.psims.web.model.SalesExample;
import com.ai.psims.web.model.SalesGoods;
import com.ai.psims.web.model.SalesGoodsExample;
import com.ai.psims.web.model.SalesUpdataGoods;
import com.ai.psims.web.model.SalesUpdateData;
import com.ai.psims.web.model.Storagecheck;
import com.ai.psims.web.model.StoragecheckExample;
import com.ai.psims.web.model.StoragecheckExample.Criteria;
import com.ai.psims.web.model.TbCustomer;
import com.ai.psims.web.model.TbCustomerExample;
import com.ai.psims.web.model.TbEmployee;
import com.ai.psims.web.model.TbEmployeeExample;
import com.ai.psims.web.model.TbStoragecheck;
import com.ai.psims.web.model.TbStoragecheckExample;
import com.ai.psims.web.model.TbStorehouse;
import com.ai.psims.web.service.ISalesService;
import com.ai.psims.web.service.IStoragecheckService;
import com.ai.psims.web.util.Constants;
import com.ai.psims.web.util.NumToFont;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@SuppressWarnings("deprecation")
@Controller
@RequestMapping("/salesController")
public class SalesController extends BaseController {

	private static final Logger logger = LoggerFactory
			.getLogger(SalesController.class);
	@Resource(name = "customerBusinessImpl")
	private ICustomerBusiness customerBusiness;
	@Resource(name = "employeeBusinessImpl")
	private IEmployeeBusiness employeeBusiness;
	@Resource(name = "queryBus")
	private IQueryBus queryBus;
	@Resource(name = "salesBusinessImpl")
	private ISalesBusiness salesBusiness;
	@Resource(name = "storagecheckServiceImpl")
	private IStoragecheckService storagecheckService;
	@Resource(name = "salesServiceImpl")
	private ISalesService salesService;

	@RequestMapping("/init")
	public String init(HttpServletRequest request) throws Exception {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String salesSerialNumber = sdf.format(date);

		List<TbCustomer> customersList = new ArrayList<TbCustomer>();
		List<TbEmployee> employeesList = new ArrayList<TbEmployee>();
		List<Sales> salesList = new ArrayList<Sales>();
		SalesExample salesExample = new SalesExample();
		com.ai.psims.web.model.SalesExample.Criteria criteria = salesExample
				.createCriteria();
		criteria.andSalesStatusNotEqualTo("00");
		criteria.andSalesSerialNumberLike("%" + salesSerialNumber + "%");
		salesExample.setOrderByClause("sales_serial_number desc");

		TbCustomerExample customerExample = new TbCustomerExample();
		customerExample.createCriteria().andEndtimeIsNull();

		TbEmployeeExample employeeExample = new TbEmployeeExample();
		employeeExample.createCriteria().andEndtimeIsNull();

		SalesGoodsExample salesGoodsExample = new SalesGoodsExample();
		com.ai.psims.web.model.SalesGoodsExample.Criteria c = salesGoodsExample
				.createCriteria();
		c.andSalesGoodsEndtimeIsNull();
		c.andSalesSerialNumberLike("%" + salesSerialNumber + "%");

		List<SalesGoods> salesGoodsList = new ArrayList<SalesGoods>();
		List<TbStorehouse> storehouse = new ArrayList<TbStorehouse>();

		salesGoodsList = salesBusiness.selectSalesGoods(salesGoodsExample);
		salesList = salesBusiness.selectByExample(salesExample);
		employeesList = queryBus.queryEmployee(employeeExample);
		customersList = queryBus.queryCustomer(customerExample);
		storehouse = queryBus.queryStorehouse();
		request.setAttribute("storehouseList", storehouse);
		request.setAttribute("customersList", customersList);
		request.setAttribute("employeesList", employeesList);
		request.setAttribute("salesList", salesList);
		request.setAttribute("salesGoodsList", salesGoodsList);
		return "sales";

	}

	@SuppressWarnings("unused")
	@RequestMapping("/queryGoods")
	public void queryGoods(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JSONObject data = new JSONObject();
		List<Storagecheck> storagechecksList = new ArrayList<Storagecheck>();
		StoragecheckExample storagecheckExample = new StoragecheckExample();
		Criteria criteria = storagecheckExample.createCriteria();
		criteria.andGoodsStatusEqualTo(Constants.ImportGoodsStatus.CANSALE);
		criteria.andEndtimeIsNull();
		storagechecksList = salesBusiness
				.queryStrStoragechecks(storagecheckExample);
		Set<String> goodsNameSet = new HashSet<String>();
		for (Storagecheck storagecheck : storagechecksList) {
			goodsNameSet.add(storagecheck.getGoodsName());
		}
		if (storagechecksList == null && storagechecksList.size() == 0) {
			responseFailed(response, "ERROR", data);
		} else {
			// data.put("list", JSON.toJSONString(storagechecksList));
			data.put("goodsNameSet", JSON.toJSONString(goodsNameSet));
			responseSuccess(response, "SUCCESS", data);
		}
	}

	@RequestMapping("/getGoodTab")
	public void getGoodTab(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JSONObject data = new JSONObject();
		String storageId = request.getParameter("storageId");
		Storagecheck storagechecks = new Storagecheck();
		storagechecks = salesBusiness.selectByKey(Integer.parseInt(storageId));
		if (storagechecks == null) {
			responseFailed(response, "ERROR", data);
		} else {
			// data.put("list", JSON.toJSONString(storagechecksList));
			data.put("storagechecks", JSON.toJSONString(storagechecks));
			responseSuccess(response, "SUCCESS", data);
		}
	}

	@RequestMapping("/queryImportList")
	public void queryImportList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String customerId = request.getParameter("customerId");
		String storehouseId = request.getParameter("storehouseId");
		String payMed = request.getParameter("payMed");
		String employeeId = request.getParameter("employeeId");
		String salesSerialNumber = request.getParameter("salesSerialNumber");
		JSONObject data = new JSONObject();
		SalesExample salesExample = new SalesExample();
		com.ai.psims.web.model.SalesExample.Criteria criteria = salesExample
				.createCriteria();
		List<Sales> salesList = new ArrayList<Sales>();
		if (customerId != null && customerId != "") {
			criteria.andCustomerIdEqualTo(Integer.parseInt(customerId));
		}
		if (storehouseId != null && storehouseId != "") {
			criteria.andStorehouseIdEqualTo(Integer.parseInt(storehouseId));
		}
		if (payMed != null && payMed != "") {
			criteria.andIncomeTypeEqualTo(payMed);
		}
		if (employeeId != null && employeeId != "") {
			criteria.andEmployeeIdEqualTo(Integer.parseInt(employeeId));
		}
		if (salesSerialNumber != null && salesSerialNumber != "") {
			criteria.andSalesSerialNumberLike("%" + salesSerialNumber + "%");
		}
		criteria.andSalesStatusNotEqualTo("00");
		salesExample.setOrderByClause("sales_serial_number desc");
		salesList = salesBusiness.selectByExample(salesExample);
		if (salesList == null) {
			responseFailed(response, "ERROR", data);
		} else {
			List<SalesGoods> salesGoodsList = new ArrayList<SalesGoods>();
			for (Sales sales : salesList) {
				List<SalesGoods> salesGoodList = new ArrayList<SalesGoods>();
				SalesGoodsExample salesGoodsExample = new SalesGoodsExample();
				com.ai.psims.web.model.SalesGoodsExample.Criteria c = salesGoodsExample
						.createCriteria();
				c.andSalesGoodsEndtimeIsNull();
				c.andSalesSerialNumberLike("%" + sales.getSalesSerialNumber()
						+ "%");
				salesGoodList = salesBusiness
						.selectSalesGoods(salesGoodsExample);
				for (SalesGoods salesGoods : salesGoodList) {
					salesGoodsList.add(salesGoods);
				}
			}
			data.put("salesList", JSON.toJSONString(salesList));
			data.put("salesGoodsList", JSON.toJSONString(salesGoodsList));
			responseSuccess(response, "SUCCESS", data);
		}
	}

	@RequestMapping("/queryGoodsDemo")
	public String queryGoodsDemo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String goodsName = request.getParameter("goodName");
		String goodsCount = request.getParameter("goodsCount");
		TbStoragecheck storagechecks = new TbStoragecheck();
		TbStoragecheckExample storagecheckExample = new TbStoragecheckExample();
		com.ai.psims.web.model.TbStoragecheckExample.Criteria criteria = storagecheckExample
				.createCriteria();
		// criteria.andGoodsStatusEqualTo(Constants.ImportGoodsStatus.CANSALE);
//		if (goodsName != null && goodsName != "") {
//			goodsName = URLDecoder.decode(goodsName);			
//		}
		criteria.andGoodsNameEqualTo(goodsName);
		criteria.andEndtimeIsNull();
		storagechecks = salesBusiness.queryStoragecheck(storagecheckExample,
				goodsName);
		request.setAttribute("storagechecks", storagechecks);
		request.setAttribute("goodsCount", goodsCount);
		return "salesgoodstab";
	}

	@RequestMapping("/updateImprotGoodsList")
	public String updateImprotGoodsList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String salesSerialNumber = request.getParameter("salesSerialNumber");
		Sales sales = new Sales();
		List<SalesGoods> salesGoodsList = new ArrayList<SalesGoods>();
		List<SalesUpdataGoods> salesUpdataGoodsList = new ArrayList<SalesUpdataGoods>();
		sales = salesBusiness.selectSalesByKey(salesSerialNumber);
		SalesGoodsExample example = new SalesGoodsExample();
		com.ai.psims.web.model.SalesGoodsExample.Criteria criteria = example
				.createCriteria();
		criteria.andSalesSerialNumberEqualTo(salesSerialNumber);
		criteria.andSalesGoodsEndtimeIsNull();
		salesGoodsList = salesBusiness.selectSalesGoods(example);

		for (SalesGoods salesGoods : salesGoodsList) {
			SalesUpdataGoods saUpdataGoods = new SalesUpdataGoods();
			int storeRateCrrent = storagecheckService
					.selectStorageRateCurrentByName(salesGoods.getGoodsName());
//			storagecheck = storagecheckService.selectByKey(salesGoods
//					.getStorageId());
			saUpdataGoods.setGoodsName(salesGoods.getGoodsName());
			saUpdataGoods.setSalesGoodsAmount(salesGoods.getSalesGoodsAmount());
			saUpdataGoods.setSalesGoodsId(salesGoods.getSalesGoodsId());
			saUpdataGoods.setSalesGoodsPrice(salesGoods.getSalesGoodsPrice());
			saUpdataGoods.setSalesGoodsTotalPrice(salesGoods
					.getSalesGoodsTotalPrice());
			saUpdataGoods.setSalesSerialNumber(salesGoods
					.getSalesSerialNumber());
			saUpdataGoods.setStorageRateCurrent(storeRateCrrent);
			salesUpdataGoodsList.add(saUpdataGoods);
		}

		request.setAttribute("salesGoodsList", salesUpdataGoodsList);
		request.setAttribute("sales", sales);
		return "updatasalesdata";
	}

	@RequestMapping("/addImprotGoodsList")
	public void addImprotGoodsList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String storageIdList = request.getParameter("storageIdList");
		String salesCountList = request.getParameter("salesCountList");
		String salesPriceList = request.getParameter("salesPriceList");
		String storeName = request.getParameter("storeName");
		String storeId = request.getParameter("storeId");
		String customerName = request.getParameter("customerName");
		String customerId = request.getParameter("customerId");
		String salesListCreateTime = request
				.getParameter("salesListCreateTime");
		String employeeName = request.getParameter("employeeName");
		String employeeId = request.getParameter("employeeId");

		AddSalesGoodsBean addGoodsBean = new AddSalesGoodsBean(storageIdList,
				customerName, storeName, customerId, salesListCreateTime,
				employeeName, storeId, employeeId, salesCountList,
				salesPriceList);
		String result = salesBusiness.addSalesList(addGoodsBean);
		JSONObject data = new JSONObject();
		if (result == null) {
			responseFailed(response, "ERROR", data);
		} else if (result == "ERROR") {
			responseFailed(response, "ERRORS", data);
		} else {
			responseSuccess(response, "SUCCESS", data);
		}

	}

	@RequestMapping("/deleteImportData")
	public void deleteImportData(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String salesSerialNumber = request.getParameter("salesSerialNumber");
		String result = salesBusiness.deleteSalesData(salesSerialNumber);
		JSONObject data = new JSONObject();
		if (result == null) {
			responseFailed(response, "ERROR", data);
		} else {
			responseSuccess(response, "SUCCESS", data);
		}

	}
	
	
	@RequestMapping("/printSales")
	public String printSales(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String salesSerialNumber = request
				.getParameter("salesSerialNumber");

		Sales sales = new Sales();
		List<SalesGoods> salesGoodsList = new ArrayList<SalesGoods>();
		sales = salesBusiness.selectSalesByKey(salesSerialNumber);	
		request.setAttribute("sales", sales);
		sales.setSalesStatus(Constants.SalesStatus.OUTORDER);
		salesService.updateSalesByKey(sales);
		SalesGoodsExample example = new SalesGoodsExample();
		com.ai.psims.web.model.SalesGoodsExample.Criteria criteria = example
				.createCriteria();
		criteria.andSalesSerialNumberEqualTo(salesSerialNumber);
		criteria.andSalesGoodsEndtimeIsNull();
		salesGoodsList = salesBusiness.selectSalesGoods(example);
		TbCustomer customer = new TbCustomer();
		customer = customerBusiness.customerById(sales.getCustomerId());
		logger.info("------------获取当前登录的员工名称-------------");
		TbEmployee tbEmployee = (TbEmployee) request.getSession()
				.getAttribute("mysession");

		logger.info("------------根据销售数量判断销售还是退货-------------");
		String title=null;
		if (salesGoodsList!=null) {
			if (salesGoodsList.get(0).getSalesGoodsAmount()<0) {
				title="北京市金瑞超达商贸有限公司商品退货单";
			}else {
				title="北京市金瑞超达商贸有限公司商品销售单";
			}
		}
		request.setAttribute("salesGoodsList", salesGoodsList);
		request.setAttribute("customer", customer);
		request.setAttribute("tbEmployee", tbEmployee);
		request.setAttribute("title", title);
		request.setAttribute("salesSerialNumber", salesSerialNumber);
		
		
		return "salesdetail";
		
	}

	@RequestMapping("/printSalesData")
	public View printSalesData(Model model, HttpServletRequest request)
			throws Exception {
		logger.info("------------销售下单打印----------------");
		View view = new AbstractExcelView() {
			@Override
			public void buildExcelDocument(
					@SuppressWarnings("rawtypes") Map map,
					HSSFWorkbook workbook, HttpServletRequest request,
					HttpServletResponse response) throws Exception {
				String salesSerialNumber = request
						.getParameter("salesSerialNumber");

				Sales sales = new Sales();
				List<SalesGoods> salesGoodsList = new ArrayList<SalesGoods>();
				sales = salesBusiness.selectSalesByKey(salesSerialNumber);
				SalesGoodsExample example = new SalesGoodsExample();
				com.ai.psims.web.model.SalesGoodsExample.Criteria criteria = example
						.createCriteria();
				criteria.andSalesSerialNumberEqualTo(salesSerialNumber);
				criteria.andSalesGoodsEndtimeIsNull();
				salesGoodsList = salesBusiness.selectSalesGoods(example);
				TbCustomer customer = new TbCustomer();
				customer = customerBusiness.customerById(sales.getCustomerId());
				TbEmployee employee = new TbEmployee();
				employee = employeeBusiness.getEmployeeById(sales
						.getEmployeeId());
				logger.info("------------获取当前登录的员工名称-------------");
				TbEmployee tbEmployee = (TbEmployee) request.getSession()
						.getAttribute("mysession");

				logger.info("------------建立 Excel -Sheet-------------");
				boolean falg=true;
				if (salesGoodsList!=null) {
					if (salesGoodsList.get(0).getSalesGoodsAmount()<0) {
						falg=false;
					}
				}
				HSSFSheet sheet;
				if (falg) {
					logger.info("------------打印销售单-------------");
					sheet = workbook.createSheet("北京市金瑞超达商贸有限公司商品销售单");
				}else {
					logger.info("------------打印退货单-------------");
					sheet = workbook.createSheet("北京市金瑞超达商贸有限公司商品退货单");
				}
				
				logger.info("------------设置行列的默认宽度和高度-------------");
				sheet.setColumnWidth(0, 32 * 80);// 对A列设置宽度为180像素
				sheet.setColumnWidth(1, 32 * 80);
				sheet.setColumnWidth(2, 32 * 80);
				sheet.setColumnWidth(3, 32 * 80);
				sheet.setColumnWidth(4, 32 * 80);
				sheet.setColumnWidth(5, 32 * 80);
				sheet.setColumnWidth(6, 32 * 80);
				sheet.setColumnWidth(7, 32 * 80);
				sheet.setColumnWidth(8, 32 * 80);
				sheet.setColumnWidth(9, 32 * 80);

				int rowNum = 0;
				int idx = 0;
				HSSFRow row;
				row = sheet.createRow(rowNum);
				row.createCell(idx++).setCellValue("电话");
				sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum,
						(short) 2));
				HSSFRichTextString context = new HSSFRichTextString(
						employee.getContactTel());
				row.createCell(idx++).setCellValue(context);
				idx++;
				row.createCell(idx++).setCellValue("地址");
				sheet.addMergedRegion(new Region(rowNum, (short) 4, rowNum,
						(short) 5));
				row.createCell(idx++).setCellValue(employee.getContactAddr());
				idx++;
				row.createCell(idx++).setCellValue("单据编号");
				sheet.addMergedRegion(new Region(rowNum, (short) 7, rowNum,
						(short) 8));
				sheet.addMergedRegion(new Region(rowNum, (short) 7, rowNum,
						(short) 9));
				row.createCell(idx++).setCellValue(salesSerialNumber);

				rowNum++;
				idx = 0;
				row = sheet.createRow(rowNum);
				row.createCell(idx++).setCellValue("客户");
				sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum,
						(short) 2));
				sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum,
						(short) 3));
				sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum,
						(short) 4));
				row.createCell(idx++).setCellValue(customer.getCustomerName());
				idx += 3;
				row.createCell(idx++).setCellValue("客户地址");
				sheet.addMergedRegion(new Region(rowNum, (short) 6, rowNum,
						(short) 7));
				sheet.addMergedRegion(new Region(rowNum, (short) 6, rowNum,
						(short) 8));
				sheet.addMergedRegion(new Region(rowNum, (short) 6, rowNum,
						(short) 9));
				row.createCell(idx++).setCellValue(customer.getContactAddr());

				rowNum++;
				idx = 0;
				row = sheet.createRow(rowNum);
				row.createCell(idx++).setCellValue("联系电话");
				sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum,
						(short) 2));
				row.createCell(idx++).setCellValue(customer.getContactTel());
				idx++;
				row.createCell(idx++).setCellValue("联系人");
				row.createCell(idx++).setCellValue(customer.getEmployeeName());
				row.createCell(idx++).setCellValue("结账方式");
				sheet.addMergedRegion(new Region(rowNum, (short) 6, rowNum,
						(short) 7));
				sheet.addMergedRegion(new Region(rowNum, (short) 6, rowNum,
						(short) 8));
				sheet.addMergedRegion(new Region(rowNum, (short) 6, rowNum,
						(short) 9));
				row.createCell(idx++).setCellValue(customer.getCheckoutName());

				rowNum++;
				idx = 0;
				row = sheet.createRow(rowNum);
				row.createCell(idx++).setCellValue("商品编号");
				sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum,
						(short) 2));
				sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum,
						(short) 3));
				row.createCell(idx++).setCellValue("商品全名");
				idx += 2;
				sheet.addMergedRegion(new Region(rowNum, (short) 4, rowNum,
						(short) 5));
				row.createCell(idx++).setCellValue("规格");
				idx++;
				row.createCell(idx++).setCellValue("单位");
				row.createCell(idx++).setCellValue("数量");
				row.createCell(idx++).setCellValue("单价");
				row.createCell(idx++).setCellValue("金额");

				float totalPrice = 0.0f;
				for (SalesGoods salesGoods : salesGoodsList) {
					rowNum++;
					idx = 0;
					row = sheet.createRow(rowNum);
					row.createCell(idx++).setCellValue(salesGoods.getGoodsId());
					sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum,
							(short) 2));
					sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum,
							(short) 3));
					row.createCell(idx++).setCellValue(
							salesGoods.getGoodsName());
					idx += 2;
					sheet.addMergedRegion(new Region(rowNum, (short) 4, rowNum,
							(short) 5));
					row.createCell(idx++).setCellValue("");
					idx++;
					row.createCell(idx++).setCellValue(
							salesGoods.getSalesGoodsUnit());
					// row.createCell(idx++).setCellValue("");
					row.createCell(idx++).setCellValue(
							salesGoods.getSalesGoodsAmount());
					row.createCell(idx++).setCellValue(
							salesGoods.getSalesGoodsPrice());
					// row.createCell(idx++).setCellValue("");
					row.createCell(idx++).setCellValue(
							salesGoods.getSalesGoodsTotalPrice());
					totalPrice += Float.parseFloat(salesGoods
							.getSalesGoodsTotalPrice());
				}

				rowNum++;
				idx = 0;
				row = sheet.createRow(rowNum);
				row.createCell(idx++).setCellValue("总计");
				sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum,
						(short) 2));
				sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum,
						(short) 3));
				row.createCell(idx++).setCellValue("");
				idx += 2;
				sheet.addMergedRegion(new Region(rowNum, (short) 4, rowNum,
						(short) 5));
				row.createCell(idx++).setCellValue("");
				idx++;
				row.createCell(idx++).setCellValue("");
				row.createCell(idx++).setCellValue("");
				row.createCell(idx++).setCellValue("");
				row.createCell(idx++).setCellValue(totalPrice);

				rowNum++;
				idx = 0;
				row = sheet.createRow(rowNum);
				row.createCell(idx++).setCellValue("联系人");
				sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum,
						(short) 2));
				sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum,
						(short) 3));
				sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum,
						(short) 4));
				row.createCell(idx++).setCellValue("");
				idx += 3;
				sheet.addMergedRegion(new Region(rowNum, (short) 5, rowNum,
						(short) 6));
				row.createCell(idx++).setCellValue("余额大写");
				idx++;
				sheet.addMergedRegion(new Region(rowNum, (short) 7, rowNum,
						(short) 8));
				sheet.addMergedRegion(new Region(rowNum, (short) 7, rowNum,
						(short) 9));
				/*row.createCell(idx++).setCellValue(
						NumToFont.number2CNMontrayUnit(BigDecimal
								.valueOf(totalPrice)));*/

				rowNum++;
				idx = 0;
				row = sheet.createRow(rowNum);
				row.createCell(idx++).setCellValue("收货人");
				row.createCell(idx++).setCellValue("");
				row.createCell(idx++).setCellValue("送货人");
				row.createCell(idx++).setCellValue("");
				row.createCell(idx++).setCellValue("核单人");
				row.createCell(idx++)
						.setCellValue(tbEmployee.getEmployeeName());
				row.createCell(idx++).setCellValue("发车时间");
				row.createCell(idx++).setCellValue("");
				row.createCell(idx++).setCellValue("还车时间");
				row.createCell(idx++).setCellValue("");

				rowNum++;
				idx = 0;
				row = sheet.createRow(rowNum);
				row.createCell(idx++).setCellValue("库管");
				row.createCell(idx++).setCellValue("");
				row.createCell(idx++).setCellValue("车牌号");
				row.createCell(idx++).setCellValue("");
				row.createCell(idx++).setCellValue("起始油表数");
				sheet.addMergedRegion(new Region(rowNum, (short) 5, rowNum,
						(short) 6));
				row.createCell(idx++).setCellValue("");
				idx++;
				row.createCell(idx++).setCellValue("返回油表数");
				sheet.addMergedRegion(new Region(rowNum, (short) 8, rowNum,
						(short) 9));
				row.createCell(idx++).setCellValue("");

				rowNum++;
				idx = 0;
				row = sheet.createRow(rowNum);
				row.createCell(idx++).setCellValue("备注");
				sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum,
						(short) 2));
				sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum,
						(short) 3));
				sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum,
						(short) 4));
				sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum,
						(short) 5));
				sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum,
						(short) 6));
				sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum,
						(short) 7));
				sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum,
						(short) 8));
				sheet.addMergedRegion(new Region(rowNum, (short) 1, rowNum,
						(short) 9));
				row.createCell(idx++).setCellValue("");
			}
		};

		return view;
	}

	@RequestMapping("/updataImprotGoodsList")
	public String updataImprotGoodsList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String salesGoodsIdList = request.getParameter("salesGoodsIdList");
		String goodsAmountList = request.getParameter("goodsAmountList");
		String salesSerialNumber = request.getParameter("salesSerialNumber");
		String salesStatus = request.getParameter("salesStatus");
		String payMed = request.getParameter("payMed");
		String creditCount = request.getParameter("creditCount");
		String payTime = request.getParameter("payTime");

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

		String storeManager = request.getParameter("storemanager") == "" ? null
				: request.getParameter("storemanager");
		String touchManager = request.getParameter("touchmanager") == "" ? null
				: request.getParameter("touchmanager");
		String receiver = request.getParameter("receiver") == "" ? null
				: request.getParameter("receiver");
		String sender = request.getParameter("sender") == "" ? null : request
				.getParameter("sender");
		String carNumber = request.getParameter("carnumber") == "" ? null
				: request.getParameter("carnumber");
		String totalSettlementAmount = request
				.getParameter("totalsettlementamount") == "" ? null : request
				.getParameter("totalsettlementamount");
		String departureTime = request.getParameter("departuretime") == "" ? null
				: request.getParameter("departuretime");
		String stillTime = request.getParameter("stilltime") == "" ? null
				: request.getParameter("stilltime");
		String startOilNum = request.getParameter("startoilnum") == "" ? null
				: request.getParameter("startoilnum");
		String returnOilNum = request.getParameter("returnoilnum") == "" ? null
				: request.getParameter("returnoilnum");
		Sales sales = new Sales();
		sales.setStorehouseManager(storeManager);
		sales.setTouchingManager(touchManager);
		sales.setReceiver(receiver);
		sales.setSender(sender);
		sales.setCarNumber(carNumber);
		sales.setTotalSettlementAmount(totalSettlementAmount);
		sales.setStartOilNumber(startOilNum);
		sales.setReturnOilNumber(returnOilNum);
		if (departureTime != null) {
			sales.setDepartureTime(sdf.parse(departureTime));
		}
		if (stillTime != null) {
			sales.setStillTime(sdf.parse(stillTime));
		}

		SalesUpdateData salesUpdateData = new SalesUpdateData(salesGoodsIdList,
				goodsAmountList, salesSerialNumber, salesStatus, payMed,
				creditCount, payTime);
		String result = salesBusiness.updateSalesData(salesUpdateData, sales);
		request.setAttribute("result", result);
		return "import";
	}

	@ExceptionHandler(Exception.class)
	public String exception(Exception e, HttpServletRequest request) {
		request.setAttribute("exception", e);
		return "error";
	}

}
