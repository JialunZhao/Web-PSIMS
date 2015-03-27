package com.ai.psims.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ai.psims.web.business.IAddGoodsImportList;
import com.ai.psims.web.business.IQueryGoodsDemoByProvider;
import com.ai.psims.web.business.IQueryImportList;
import com.ai.psims.web.common.interfaces.IQueryBus;
import com.ai.psims.web.model.AddGoodsBean;
import com.ai.psims.web.model.GoodsDemo;
import com.ai.psims.web.model.Import;

@Controller
@RequestMapping("/accountController")
public class ImportController extends BaseController {
	@Resource(name = "queryBus")
	private IQueryBus queryBus;
	@Resource(name = "queryGoodsDemoByProviderImpl")
	private IQueryGoodsDemoByProvider queryGoodsDemoByProvider;
	@Resource(name = "addGoodsImportListImpl")
	private IAddGoodsImportList addGoodsImportList;
	@Resource(name = "queryImportListImpl")
	private IQueryImportList queryImportList;

	@RequestMapping("/showProvider")
	public String showProvider(HttpServletRequest request) throws Exception {
		List<String> providerName = new ArrayList<String>();
		List<String> storehouseName = new ArrayList<String>();
		List<Import> importList = new ArrayList<Import>();
		importList = queryBus.queryImport();
		providerName = queryBus.queryProvider();
		storehouseName = queryBus.queryStorehouse();
		request.setAttribute("providerList", providerName);
		request.setAttribute("storehouseList", storehouseName);
		request.setAttribute("importList", importList);
		return "import";

	}

	@RequestMapping("/queryGoods")
	public void queryGoods(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String providerName = request.getParameter("providerName");
		JSONObject data = new JSONObject();
		List<GoodsDemo> goodsList = new ArrayList<GoodsDemo>();
		goodsList = queryGoodsDemoByProvider.queryGoodsDemo(providerName);
		if (goodsList == null || goodsList.size() == 0) {
			responseFailed(response, "....", data);
		} else {
			data.put("list", JSON.toJSONString(goodsList));
			responseSuccess(response, "*****", data);
		}
	}

	@RequestMapping("/queryImportList")
	public void queryImportList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String providerName = request.getParameter("providerName");
		String storeName = request.getParameter("storeName");
		String payMed = request.getParameter("payMed");
		String importSerialNumber = request.getParameter("importSerialNumber");
		Map<String, String> m = new HashMap<String, String>();
		JSONObject data = new JSONObject();
		m.put("providerName", providerName);
		m.put("storehouseName", storeName);
		m.put("paymentType", payMed);
		m.put("importSerialNumber", importSerialNumber);
		List<Import> importList = new ArrayList<Import>();
		importList = queryImportList.queryImportByColum(m);
		if (importList == null) {
			responseFailed(response, "....", data);
		} else {
			data.put("goods", JSON.toJSONString(importList));
			responseSuccess(response, "*****", data);
		}
	}

	@RequestMapping("/queryGoodsDemo")
	public void queryGoodsDemo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String goodsName = request.getParameter("goodsName");
		String providerName = request.getParameter("providerName");
		System.err.println(goodsName + ":" + providerName);
		JSONObject data = new JSONObject();
		GoodsDemo goods = new GoodsDemo();
		goods = queryGoodsDemoByProvider.select(goodsName, providerName);
		if (goods == null) {
			responseFailed(response, "....", data);
		} else {
			data.put("goods", JSON.toJSONString(goods));
			responseSuccess(response, "*****", data);
		}
	}

	@RequestMapping("/addImprotGoodsList")
	public void addImprotGoodsList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String goodList = request.getParameter("goodList");
		String providerName = request.getParameter("providerName");
		String storeName = request.getParameter("storeName");
		String discountMed = request.getParameter("discountMed");
		String payMed = request.getParameter("payMed");
		String payStatus = request.getParameter("payStatus");
		String importcreatetime = request.getParameter("importcreatetime");

		AddGoodsBean addGoodsBean = new AddGoodsBean(goodList, providerName,
				storeName, discountMed, payMed, payStatus, importcreatetime);
		String result = addGoodsImportList.addGoodsList(addGoodsBean);
		JSONObject data = new JSONObject();
		if (result == null) {
			responseFailed(response, "....", data);
		} else {
			responseSuccess(response, "****", data);
		}

	}

	@ExceptionHandler(Exception.class)
	public String exception(Exception e, HttpServletRequest request) {
		request.setAttribute("exception", e);
		return "error";
	}

}
