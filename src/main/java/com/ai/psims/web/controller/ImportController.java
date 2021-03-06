package com.ai.psims.web.controller;

import java.net.URLDecoder;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.ai.psims.web.business.IImporBusiness;
import com.ai.psims.web.business.IQueryImportList;
import com.ai.psims.web.business.ISystemParameterBussiness;
import com.ai.psims.web.common.interfaces.IQueryBus;
import com.ai.psims.web.model.AddGoodsBean;
import com.ai.psims.web.model.TbGoods;
import com.ai.psims.web.model.TbGoodsExample;
import com.ai.psims.web.model.TbImport;
import com.ai.psims.web.model.TbImportExample;
import com.ai.psims.web.model.TbSystemParameter;
import com.ai.psims.web.model.TbSystemParameterExample;
import com.ai.psims.web.model.TbImportExample.Criteria;
import com.ai.psims.web.model.TbImportGoods;
import com.ai.psims.web.model.TbImportGoodsExample;
import com.ai.psims.web.model.TbProvider;
import com.ai.psims.web.model.TbProviderExample;
import com.ai.psims.web.model.TbStorehouse;
import com.ai.psims.web.model.UpdateImportDemo;
import com.ai.psims.web.util.Constants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/importController")
public class ImportController extends BaseController {
	private static final Logger logger = LoggerFactory
			.getLogger(ImportController.class);
	
	@Resource(name = "queryBus")
	private IQueryBus queryBus;

	@Resource(name = "imporBusinessImpl")
	private IImporBusiness imporBusinessImpl;
	
	@Resource(name = "queryImportListImpl")
	private IQueryImportList queryImportList;
	

	@Resource(name = "systemParameterBussinessImpl")
	private ISystemParameterBussiness systemParameterBussinessImpl;

	
	@RequestMapping("/init")
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
		TbImportGoodsExample.Criteria tbImportGoodsExampleCriteria = tbImportGoodsExample.createCriteria();

		logger.info("------------2.获取参数-------------");
		
		logger.info("------------3.数据校验-------------");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");  
		Date date=new Date();  
		String todayMonth=sdf.format(date) + "%";  
		criteria.andImportStatusNotEqualTo("00");
		criteria.andImportSerialNumberLike(todayMonth);
		tbImportExample.setOrderByClause("import_serial_number desc");
		logger.info("------------4.业务处理-------------");
		importList = queryBus.queryImport(tbImportExample);
		provider = queryBus.queryProvider();
		storehouse = queryBus.queryStorehouse();
		tbImportGoodsList = imporBusinessImpl.queryImportGoods(tbImportGoodsExample);

		logger.info("------------5.返回结果-------------");
		request.setAttribute("providerList", provider);
		request.setAttribute("storehouseList", storehouse);
		request.setAttribute("importList", importList);
		request.setAttribute("tbImportGoodsList", tbImportGoodsList);
		logger.info("------------Bye importOrder page!-------------");
		return "importorder";

	}

	@RequestMapping("/importInit")
	public String importInit(HttpServletRequest request) throws Exception {
		List<TbImport> importList = new ArrayList<TbImport>();
		List<TbStorehouse> storehouse = new ArrayList<TbStorehouse>();
		List<TbImportGoods> importGoodsList=new ArrayList<TbImportGoods>();
		storehouse = queryBus.queryStorehouse();
		List<String> importStatusList = new ArrayList<String>();
		importStatusList.add(Constants.ImportStatus.ORDERNOPAY);
		importStatusList.add(Constants.ImportStatus.ORDERYESPAY);
		importStatusList.add(Constants.ImportStatus.GOODSLITARRIVAL);
		importStatusList.add(Constants.ImportStatus.GOODSARRIVAL);
		
		TbImportExample example = new TbImportExample();
		Criteria criteria = example.createCriteria();
		criteria.andImportStatusNotEqualTo("00");
		criteria.andImportStatusIn(importStatusList);
		importList = queryBus.queryImport(example);
		if(importList!=null){
			for (TbImport tbImport : importList) {
				List<TbImportGoods> importGoodList=new ArrayList<TbImportGoods>();
				importGoodList=imporBusinessImpl.selBySerNum(tbImport.getImportSerialNumber());
				for (TbImportGoods tbImportGoods : importGoodList) {
					importGoodsList.add(tbImportGoods);
				}
			}
		}
		
		request.setAttribute("importGoodsList", importGoodsList);
		request.setAttribute("importList", importList);
		request.setAttribute("storehouseList", storehouse);
		return "import";

	}

	@RequestMapping("/queryGoods")
	public void queryGoods(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String providerId = request.getParameter("providerId");
		TbGoodsExample tbGoodsExample = new TbGoodsExample();
		JSONObject data = new JSONObject();
		List<TbGoods> goodsList = new ArrayList<TbGoods>();
		TbGoodsExample.Criteria criteria = tbGoodsExample
				.createCriteria();
		if (providerId != null && providerId != "") {
			criteria.andProviderIdEqualTo(Integer.parseInt(providerId));
		}
		criteria.andGoodsEndtimeIsNull();
		criteria.andGoodsStatusEqualTo("01");
		goodsList = queryBus.queryGoodsByName(tbGoodsExample);
		if (null == goodsList || goodsList.size() ==0) {
			responseFailed(response, "ERROR", data);
		} else {
			data.put("list", JSON.toJSONString(goodsList));
			responseSuccess(response, "SUCCESS", data);
		}
	}

	@RequestMapping("/queryImportList")
	public void queryImportList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String providerId = request.getParameter("providerId");
		String payMed = request.getParameter("payMed");
		String importSerialNumber = request.getParameter("importSerialNumber");
		String importStatus = request.getParameter("importStatus");
		TbImportExample example = new TbImportExample();
		Criteria criteria = example.createCriteria();
		JSONObject data = new JSONObject();
		if (providerId != null && providerId != "") {
			criteria.andProviderIdEqualTo(Integer.parseInt(providerId));
		}
		if (payMed != null && payMed != "") {
			criteria.andPaymentTypeEqualTo(payMed);
		}
		if (importStatus != null && importStatus != "") {
			criteria.andImportStatusEqualTo(importStatus);
		}
		if (importSerialNumber != null && importSerialNumber != "") {
			criteria.andImportSerialNumberLike("%" + importSerialNumber + "%");
		}
		criteria.andImportStatusNotEqualTo("00");
		example.setOrderByClause("import_serial_number desc");

		List<TbImport> importList = new ArrayList<TbImport>();
		importList = queryImportList.queryImportByColum(example);
		if (importList == null) {
			responseFailed(response, "ERROR", data);
		} else {
			data.put("goods", JSON.toJSONString(importList));
			responseSuccess(response, "SUCCESS", data);
		}
	}

	@RequestMapping("/queryImport")
	public void queryImport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String importSerialNumber = request.getParameter("importSerialNumber");
		TbImportExample example = new TbImportExample();
		Criteria criteria = example.createCriteria();
		
		List<String> importStatusList = new ArrayList<String>();
		importStatusList.add(Constants.ImportStatus.ORDERNOPAY);
		importStatusList.add(Constants.ImportStatus.ORDERYESPAY);
		importStatusList.add(Constants.ImportStatus.GOODSLITARRIVAL);
		
		JSONObject data = new JSONObject();
		if (importSerialNumber != null && importSerialNumber != "") {
			criteria.andImportSerialNumberLike("%" + importSerialNumber + "%");
		}
		criteria.andImportStatusNotEqualTo("00");
		criteria.andImportStatusIn(importStatusList);
		List<TbImport> importList = new ArrayList<TbImport>();
		importList = queryImportList.queryImportByColum(example);
		if (importList == null) {
			responseFailed(response, "ERROR", data);
		} else {
			List<TbImportGoods> importGoodsList=new ArrayList<TbImportGoods>();
			for (TbImport tbImport : importList) {
				List<TbImportGoods> importGoodList=new ArrayList<TbImportGoods>();
				importGoodList=imporBusinessImpl.selBySerNum(tbImport.getImportSerialNumber());
				for (TbImportGoods tbImportGoods : importGoodList) {
					importGoodsList.add(tbImportGoods);
				}
			}
			data.put("importGoodsList", JSON.toJSONString(importGoodsList));
			data.put("goods", JSON.toJSONString(importList));
			responseSuccess(response, "SUCCESS", data);
		}
	}


	
	
	
	@RequestMapping("/queryPrizePool")
	public void queryPrizePool(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String providerId = request.getParameter("providerId");
		JSONObject data = new JSONObject();
		TbProvider tbProvider=new TbProvider();
		tbProvider=queryBus.queryProviderById(Integer.parseInt(providerId));
		if (tbProvider == null) {
			responseFailed(response, "ERROR", data);
		} else {
			if (null != tbProvider.getProviderPrizePool() && !"".equals(tbProvider.getProviderPrizePool())) {
				tbProvider.setProviderPrizePool(systemParameterBussinessImpl
						.getSystemParameterPrizePool(
								Integer.parseInt(tbProvider.getProviderPrizePool()))
								.getPpValue());
			}else {
				tbProvider.setProviderPrizePool("未关联奖金池");
			}
			data.put("prizePool", JSON.toJSONString(tbProvider.getProviderPrizePool()));
			responseSuccess(response, "SUCCESS", data);
		}
	}

	@RequestMapping("/queryGoodsDemo")
	public void queryGoodsDemo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<TbSystemParameter> tbSystemParameters = new ArrayList<TbSystemParameter>();
		TbSystemParameterExample tbSystemParameterExample =new TbSystemParameterExample();
		TbSystemParameterExample.Criteria tbSystemParameterCriteria = tbSystemParameterExample.createCriteria();
		
		
		String goodsName = request.getParameter("goodsName");
		String providerName = request.getParameter("providerName");
		TbGoodsExample tbGoodsExample = new TbGoodsExample();
		TbGoodsExample.Criteria criteria = tbGoodsExample
				.createCriteria();
		List<TbGoods> goodsList = new ArrayList<TbGoods>();
		JSONObject data = new JSONObject();
		TbGoods goods = new TbGoods();
		if (goodsName != null && goodsName != "") {
			criteria.andGoodsNameEqualTo(goodsName);
		}
		if (providerName != null && providerName != "") {
			criteria.andProviderNameEqualTo(providerName);
		}
		criteria.andGoodsEndtimeIsNull();
		criteria.andGoodsStatusEqualTo("01");
		goodsList = queryBus.queryGoodsByName(tbGoodsExample);
		goods = goodsList.get(0);

		if (goods == null) {
			responseFailed(response, "ERROR", data);
		} else {
			logger.info("------------4.3.获取商品基本单位-------------");
//			tbSystemParameterCriteria.andPStatusEqualTo("01");
			tbSystemParameterCriteria.andPValueEqualTo("GoodsUnit");
			tbSystemParameterCriteria.andParamIdEqualTo(Integer.parseInt(goods.getGoodsUnit()));
			tbSystemParameters = systemParameterBussinessImpl.selectByExample(tbSystemParameterExample);
			goods.setGoodsUnit(tbSystemParameters.get(0).getPpValue());
			data.put("goods", JSON.toJSONString(goods));
			responseSuccess(response, "SUCCESS", data);
		}
	}

	@RequestMapping("/updateImprotGoodsList")
	public String updateImprotGoodsList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String importSerialNumber = request.getParameter("importSerialNumber");
		TbImport import1 = new TbImport();
		List<TbImportGoods> importGoodsList = new ArrayList<TbImportGoods>();
		importGoodsList = imporBusinessImpl.selBySerNum(importSerialNumber);
		import1 = queryImportList.selectByPrimaryKey(importSerialNumber);
		List<TbProvider> provider = new ArrayList<TbProvider>();
		List<TbStorehouse> storehouse = new ArrayList<TbStorehouse>();
		provider = queryBus.queryProvider();
		storehouse = queryBus.queryStorehouse();
		request.setAttribute("providerList", provider);
		request.setAttribute("storehouseList", storehouse);
		request.setAttribute("import1", import1);
		request.setAttribute("importGoodsList", importGoodsList);
		return "updataimportdata";
	}

	@RequestMapping("/addImprotGoodsList")
	public void addImprotGoodsList(HttpServletRequest request,
			HttpServletResponse response) throws  Exception {
		logger.info("------------Welcome importOrder page!-------------");
		logger.info("------------1.初始化！-------------");
		List<TbImportGoods> goodsList = new ArrayList<TbImportGoods>();
		AddGoodsBean addGoodsBean = null;
		TbImport tbImport = new TbImport();
		
		logger.info("------------2.获取参数-------------");
		String importcreatetime = request.getParameter("importcreatetime");
		Integer providerId = Integer.parseInt(request.getParameter("providerId"));
//		String prizePool = request.getParameter("prizePool");
		String payStatus = request.getParameter("payStatus"); 
		String payMed = request.getParameter("payMed");
		String payTime = request.getParameter("payTime");
		String importRemark = request.getParameter("importRemark");
		String importBatchNumber = request.getParameter("importBatchNumber");
		
		String[] goodsId = request.getParameterValues("goodsId");
		String[] goodsName = request.getParameterValues("goodsName");
		String[] goodsCode = request.getParameterValues("goodsCode");
		String[] goodsUnit = request.getParameterValues("goodsUnit");
		String[] goodsPrice = request.getParameterValues("goodsPrice");
		String[] goodsShelfLife = request.getParameterValues("goodsShelfLife");
		String[] discountRate = request.getParameterValues("discountRate");
		String[] totalPrice = request.getParameterValues("totalPrice");
		String[] discountDutyTotalPrice = request.getParameterValues("discountDutyTotalPrice");
		String[] prizePoolUsed = request.getParameterValues("prizePoolUsed");
		String[] goodsCount = request.getParameterValues("goodsCount");

		for (int i = 0; i < goodsId.length; i++) {
			TbImportGoods tbImportGoods =new TbImportGoods();
			tbImportGoods.setGoodsId(Integer.parseInt(goodsId[i])); 
			tbImportGoods.setGoodsName(goodsName[i]);
			tbImportGoods.setGoodsCode(goodsCode[i]);
			tbImportGoods.setImportGoodsUnit(goodsUnit[i]);
			tbImportGoods.setGoodsShelfLife(Integer.parseInt(goodsShelfLife[i]));
			tbImportGoods.setImportGoodsAmount(Integer.parseInt(goodsCount[i]));
			tbImportGoods.setImportGoodsPrice(goodsPrice[i]);
			tbImportGoods.setImportDiscountRate(discountRate[i]);
			tbImportGoods.setImportTotalPrice(totalPrice[i]);
			tbImportGoods.setDiscountDutyTotalPrice(discountDutyTotalPrice[i]);
			tbImportGoods.setDiscountGoodsTotalPrice(prizePoolUsed[i]);
			goodsList.add(tbImportGoods);
		}
		logger.info("------------3.数据校验-------------");
		logger.info("------------4.业务处理开始-------------");
		tbImport.setProviderId(providerId);
		tbImport.setPaymentStatus(payStatus);
		tbImport.setPaymentType(payMed);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		ParsePosition pos = new ParsePosition(0);
		java.util.Date strtodate = formatter.parse(payTime, pos);
		tbImport.setPaymentTime(strtodate);
		tbImport.setImportDatetime(new Date());
		tbImport.setImportRemark(importRemark);
		tbImport.setImportBatchNumber(importBatchNumber);
		addGoodsBean = new AddGoodsBean(goodsList,tbImport, payMed, payStatus, importcreatetime, payTime, providerId);


		String result = imporBusinessImpl.addGoodsList(addGoodsBean);
		logger.info("------------5.返回结果-------------" +result);
		JSONObject data = new JSONObject();
		if (result == "SUCCESS") {
			logger.info("------------importOrder page finished!-------------");
			responseSuccess(response, "SUCCESS", data);
		} else {
			logger.info("------------importOrder page finished!-------------");
			responseFailed(response, result, data);
		}
	}

	@RequestMapping("/addImprotList")
	public void addImprotList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String goodList = request.getParameter("goodList");
		String importSerialNumber = request.getParameter("importSerialNumber");
		String storeName = request.getParameter("storeName");
		String storeId = request.getParameter("storeId");

		String result = imporBusinessImpl.goodsImport(goodList,
				importSerialNumber, storeName, storeId);
		JSONObject data = new JSONObject();
		if (result == null) {
			responseFailed(response, "ERROR", data);
		} else {
			responseSuccess(response, "SUCCESS", data);
		}

	}

	@RequestMapping("/deleteImportData")
	public void deleteImportData(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String importSerialNumber = request.getParameter("importSerialNumber");
		String result = imporBusinessImpl.deleteImportData(importSerialNumber);
		JSONObject data = new JSONObject();
		if (result == null) {
			responseFailed(response, "ERROR", data);
		} else {
			responseSuccess(response, "SUCCESS", data);
		}

	}

	@RequestMapping("/goodsImport")
	public void goodsImport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String importSerialNumber = request.getParameter("importSerialNumber");
		List<String> goodsName = new ArrayList<String>();
		goodsName = imporBusinessImpl.getGoodsName(importSerialNumber);
		JSONObject data = new JSONObject();
		if (goodsName == null) {
			responseFailed(response, "ERROR", data);
		} else {
			data.put("goodsName", JSON.toJSONString(goodsName));
			responseSuccess(response, "SUCCESS", data);
		}
	}

	@RequestMapping("/showImportGoods")
	public String showImportGoods(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String importSerialNumber = request.getParameter("importSerialNumber");
		String goodName = request.getParameter("goodsName");
		
		List<TbImportGoods> importGoodsList = new ArrayList<TbImportGoods>();
		TbImportGoodsExample example = new TbImportGoodsExample();
		com.ai.psims.web.model.TbImportGoodsExample.Criteria criteria = example
				.createCriteria();
		criteria.andImportSerialNumberEqualTo(importSerialNumber);
		if (goodName != null && goodName != "") {
			goodName = URLDecoder.decode(goodName);
		}
		criteria.andGoodsNameEqualTo(goodName);
		importGoodsList = imporBusinessImpl.queryImportGoods(example);
		TbImportGoods importGoods=new TbImportGoods();
		if (importGoodsList.size()>0) {
			importGoods=importGoodsList.get(0);
		}		
		request.setAttribute("importGoods", importGoods);
		return "goodsimport";
	}

	@RequestMapping("/updataImprotGoodsList")
	public String updataImprotGoodsList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String goodsAmountList = request.getParameter("goodsAmountList");
		String importGoodsIdList = request.getParameter("importGoodsIdList");
		String providerId = request.getParameter("providerId");
		String paymentType = request.getParameter("paymentType");
		String importStatus = request.getParameter("importStatus");
		
		String payTime = request.getParameter("payTime");
		String importSerialNumber = request.getParameter("importSerialNumber");
		String providerName = request.getParameter("providerName");
		String goodsAmounts[] = goodsAmountList.split(",");
		String importGoodsIds[] = importGoodsIdList.split(",");
		List<TbImportGoods> importGoodsLists = new ArrayList<TbImportGoods>();
		for (int i = 0; i < importGoodsIds.length; i++) {
			TbImportGoods importGoods = new TbImportGoods();
			importGoods.setImportGoodsId(Integer.parseInt(importGoodsIds[i]));
			importGoods.setImportGoodsAmount(Integer.parseInt(goodsAmounts[i]));
			importGoodsLists.add(importGoods);
		}
		UpdateImportDemo updateImportDemo = new UpdateImportDemo(importGoodsLists, providerId, paymentType, importStatus, payTime, importSerialNumber, providerName);
//		UpdateImportDemo updateImportDemo = new UpdateImportDemo(
//				importGoodsLists, providerId, paymentType, importStatus,
//				payTime, importSerialNumber, providerName);
		
		updateImportDemo.setImportGoodsList(importGoodsLists);
		String result = imporBusinessImpl.updateImportGoods(updateImportDemo);
		request.setAttribute("result", result);
		return "import";
	}

	// @RequestMapping("/importgoodsprint")
	// public void importgoodsprint(HttpServletRequest request,
	// HttpServletResponse response) throws Exception {
	// String importSerialNumber = request.getParameter("importSerialNumber");
	// List<TbImportGoods>
	// importGoodsList=imporBusinessImpl.selBySerNum(importSerialNumber);
	// TbImport import1=queryImportList.selectByPrimaryKey(importSerialNumber);
	//
	// List<String> topList = new ArrayList<String>();
	// topList.add("采购订单号");
	// topList.add("采购日期");
	// topList.add("订单状态");
	// topList.add("产品代码");
	// topList.add("产品名称");
	// topList.add("数量");
	// topList.add("正品单价(含税)");
	// topList.add("折扣率");
	// topList.add("正价销售总额(含税)");
	// topList.add("折扣销售总额(含税)");
	// topList.add("折扣销售总额(未税)");
	// topList.add("箱皮压箱金额");
	// topList.add("备注");
	//
	// response.reset();
	// response.setContentType("application/msexcel");
	// response.setHeader(
	// "Content-disposition",
	// "inline;filename=订单明细.xls");// 定义文件名
	//
	// HSSFWorkbook wb=new HSSFWorkbook();
	//
	// HSSFFont fontTitle = wb.createFont();// 设置标题单元格字体
	// fontTitle.setFontName("黑体");
	// fontTitle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 字体粗细
	// fontTitle.setFontHeightInPoints((short) 18);// 字体大小
	//
	// HSSFFont fontHead1 = wb.createFont();// 设置表头单元格字体大
	// fontHead1.setFontName("黑体");
	// fontHead1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	// fontHead1.setFontHeightInPoints((short) 12);
	// HSSFFont fontHead2 = wb.createFont();// 设置表头单元格字体小
	// fontHead2.setFontName("黑体");
	// fontHead2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	// fontHead2.setFontHeightInPoints((short) 11);
	//
	// HSSFFont fontCell = wb.createFont();// 主体内容字体
	// fontCell.setFontName("宋体");
	// fontCell.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
	// fontCell.setFontHeightInPoints((short) 12);
	//
	// HSSFCellStyle styleTitle = wb.createCellStyle();// 标题单元格样式
	// styleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 对齐方式
	// styleTitle.setFont(fontTitle);
	//
	// HSSFCellStyle style2 = wb.createCellStyle();// 表头前的统计时间显示样式
	// style2.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
	// style2.setFont(fontCell);
	//
	// HSSFCellStyle styleHead1 = wb.createCellStyle();// 表头样式大
	// styleHead1.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 对齐方式
	// styleHead1.setBorderBottom(styleHead1.BORDER_THIN); // 设置边框
	// styleHead1.setBorderLeft(styleHead1.BORDER_THIN);
	// styleHead1.setBorderRight(styleHead1.BORDER_THIN);
	// styleHead1.setBorderTop(styleHead1.BORDER_THIN);
	// styleHead1.setFont(fontHead1);
	//
	// HSSFCellStyle styleHead2 = wb.createCellStyle();// 表头样式小
	// styleHead2.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 对齐方式
	// styleHead2.setBorderBottom(styleHead2.BORDER_THIN); // 设置边框
	// styleHead2.setBorderLeft(styleHead2.BORDER_THIN);
	// styleHead2.setBorderRight(styleHead2.BORDER_THIN);
	// styleHead2.setBorderTop(styleHead2.BORDER_THIN);
	// styleHead2.setFont(fontHead2);
	//
	// HSSFCellStyle styleCell = wb.createCellStyle();// 主体内容样式
	// styleCell.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	// styleCell.setBorderBottom(styleCell.BORDER_THIN); // 设置边框
	// styleCell.setBorderLeft(styleCell.BORDER_THIN);
	// styleCell.setBorderRight(styleCell.BORDER_THIN);
	// styleCell.setBorderTop(styleCell.BORDER_THIN);
	// styleCell.setFont(fontCell);
	//
	// try {
	// HSSFRow row;
	// HSSFCell cell;
	//
	// HSSFSheet sheet=wb.createSheet("打印订单"+1);
	// sheet.setDefaultColumnWidth((short)25);
	// //表头行
	// row=sheet.createRow(0);
	// for (int i = 0; i < topList.size(); i++) {
	// String str=topList.get(i);
	// cell=row.createCell((short)i);
	// cell.setEncoding(HSSFCell.ENCODING_UTF_16);
	// cell.setCellStyle(styleHead1);
	// cell.setCellValue(str);
	// }
	// //主体内容
	// for (int i = 0; i < importGoodsList.size(); i++) {
	// TbImportGoods importGoods=importGoodsList.get(i);
	// row=sheet.createRow(i+1);
	//
	// cell=row.createCell((short) 0);
	// cell.setEncoding(HSSFCell.ENCODING_UTF_16);
	// cell.setCellStyle(styleCell);
	// cell.setCellValue(importGoods.getImportSerialNumber());// 采购订单号
	//
	// cell=row.createCell((short) 1);
	// cell.setEncoding(HSSFCell.ENCODING_UTF_16);
	// cell.setCellStyle(styleCell);
	// cell.setCellValue(importGoods.getImportGoodsCreatetime());// 采购日期
	//
	// cell=row.createCell((short) 2);
	// cell.setEncoding(HSSFCell.ENCODING_UTF_16);
	// cell.setCellStyle(styleCell);
	// cell.setCellValue(import1.getImportStatus());// 订单状态
	//
	// cell=row.createCell((short) 0);
	// cell.setEncoding(HSSFCell.ENCODING_UTF_16);
	// cell.setCellStyle(styleCell);
	// cell.setCellValue(importGoods.getGoodsId());// 产品代码
	//
	// cell=row.createCell((short) 0);
	// cell.setEncoding(HSSFCell.ENCODING_UTF_16);
	// cell.setCellStyle(styleCell);
	// cell.setCellValue(importGoods.getGoodsName());// 产品名称
	//
	// cell=row.createCell((short) 0);
	// cell.setEncoding(HSSFCell.ENCODING_UTF_16);
	// cell.setCellStyle(styleCell);
	// cell.setCellValue(importGoods.getImportGoodsAmount());// 数量
	// cell=row.createCell((short) 0);
	//
	// cell.setEncoding(HSSFCell.ENCODING_UTF_16);
	// cell.setCellStyle(styleCell);
	// cell.setCellValue(importGoods.getImportGoodsPrice()/1000);// 正品单价(含税)
	//
	// cell=row.createCell((short) 0);
	// cell.setEncoding(HSSFCell.ENCODING_UTF_16);
	// cell.setCellStyle(styleCell);
	// cell.setCellValue(importGoods.getDiscountRate()/1000);// 折扣率
	//
	// cell=row.createCell((short) 0);
	// cell.setEncoding(HSSFCell.ENCODING_UTF_16);
	// cell.setCellStyle(styleCell);
	// cell.setCellValue(importGoods.getTotalPrice()/1000);// 正价销售总额(含税)
	//
	// cell=row.createCell((short) 0);
	// cell.setEncoding(HSSFCell.ENCODING_UTF_16);
	// cell.setCellStyle(styleCell);
	// cell.setCellValue(importGoods.getDiscountDutyTotalPrice()/1000);//
	// 折扣销售总额(含税)
	//
	// cell=row.createCell((short) 0);
	// cell.setEncoding(HSSFCell.ENCODING_UTF_16);
	// cell.setCellStyle(styleCell);
	// cell.setCellValue(importGoods.getDiscountTotalPrice()/1000);// 折扣销售总额(未税)
	// cell=row.createCell((short) 0);
	//
	// cell.setEncoding(HSSFCell.ENCODING_UTF_16);
	// cell.setCellStyle(styleCell);
	// cell.setCellValue(importGoods.getBoxBottleTotalPrice()/1000);// 箱皮压箱金额
	//
	// cell=row.createCell((short) 0);
	// cell.setEncoding(HSSFCell.ENCODING_UTF_16);
	// cell.setCellStyle(styleCell);
	// cell.setCellValue("");// 备注
	// }
	//
	// } catch (Exception e) {
	// // TODO: handle exception
	// }
	// wb.write(response.getOutputStream());
	// response.getOutputStream().flush();
	// response.getOutputStream().close();
	// }

	@ExceptionHandler(Exception.class)
	public String exception(Exception e, HttpServletRequest request) {
		request.setAttribute("exception", e);
		return "error";
	}

}
