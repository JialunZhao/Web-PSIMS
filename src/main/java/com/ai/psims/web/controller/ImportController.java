package com.ai.psims.web.controller;

import java.net.URLDecoder;
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

import com.ai.psims.web.business.IAddGoodsImportList;
import com.ai.psims.web.business.IQueryImportList;
import com.ai.psims.web.common.interfaces.IQueryBus;
import com.ai.psims.web.model.AddGoodsBean;
import com.ai.psims.web.model.Goods;
import com.ai.psims.web.model.GoodsExample;
import com.ai.psims.web.model.Import;
import com.ai.psims.web.model.ImportGoods;
import com.ai.psims.web.model.Provider;
import com.ai.psims.web.model.Storehouse;
import com.ai.psims.web.model.UpdateImportDemo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/accountController")
public class ImportController extends BaseController {
	@Resource(name = "queryBus")
	private IQueryBus queryBus;
	@Resource(name = "addGoodsImportListImpl")
	private IAddGoodsImportList addGoodsImportList;
	@Resource(name = "queryImportListImpl")
	private IQueryImportList queryImportList;

	@RequestMapping("/showProvider")
	public String showProvider(HttpServletRequest request) throws Exception {
		List<Provider> provider = new ArrayList<Provider>();
		List<Storehouse> storehouse = new ArrayList<Storehouse>();
		List<Import> importList = new ArrayList<Import>();
		importList = queryBus.queryImport();
		provider = queryBus.queryProvider();
		storehouse = queryBus.queryStorehouse();
		request.setAttribute("providerList", provider);
		request.setAttribute("storehouseList", storehouse);
		request.setAttribute("importList", importList);
		return "import";

	}

	@SuppressWarnings("null")
	@RequestMapping("/queryGoods")
	public void queryGoods(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String providerName = request.getParameter("providerName");
		GoodsExample goodsExample = new GoodsExample();
		JSONObject data = new JSONObject();
		List<Goods> goodsList = new ArrayList<Goods>();
		if (providerName != null || providerName != "") {
			goodsExample.createCriteria().andProviderNameEqualTo(providerName);
		}
		goodsList = queryBus.queryGoodsByName(goodsExample);
		if (goodsList == null && goodsList.size() == 0) {
			responseFailed(response, "....", data);
		} else {
			data.put("list", JSON.toJSONString(goodsList));
			responseSuccess(response, "*****", data);
		}
	}

	@RequestMapping("/queryImportList")
	public void queryImportList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String providerId = request.getParameter("providerId");
		String storeId = request.getParameter("storeId");
		String payMed = request.getParameter("payMed");
		String importSerialNumber = request.getParameter("importSerialNumber");
		Map<String, String> m = new HashMap<String, String>();
		JSONObject data = new JSONObject();
		m.put("providerId", providerId);
		m.put("storeId", storeId);
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
		GoodsExample goodsExample = new GoodsExample();
		List<Goods> goodsList = new ArrayList<Goods>();
		JSONObject data = new JSONObject();
		Goods goods = new Goods();
		if (goodsName != null && goodsName != "") {
			goodsExample.createCriteria().andGoodsNameEqualTo(goodsName);
		}
		if (providerName != null || providerName != "") {
			goodsExample.createCriteria().andProviderNameEqualTo(providerName);
		}
		goodsList = queryBus.queryGoodsByName(goodsExample);
		goods = goodsList.get(0);
		if (goods == null) {
			responseFailed(response, "....", data);
		} else {
			data.put("goods", JSON.toJSONString(goods));
			responseSuccess(response, "*****", data);
		}
	}

	@RequestMapping("/updateImprotGoodsList")
	public String updateImprotGoodsList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String importSerialNumber = request.getParameter("importSerialNumber");
		Import import1 = new Import();
		List<ImportGoods> importGoodsList = new ArrayList<ImportGoods>();
		importGoodsList = addGoodsImportList.selBySerNum(importSerialNumber);
		import1 = queryImportList.selectByPrimaryKey(importSerialNumber);
		List<Provider> provider = new ArrayList<Provider>();
		List<Storehouse> storehouse = new ArrayList<Storehouse>();
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
			HttpServletResponse response) throws Exception {
		String goodList = request.getParameter("goodList");
		String providerName = request.getParameter("providerName");
		String storeName = request.getParameter("storeName");
		String discountMed = request.getParameter("discountMed");
		String payMed = request.getParameter("payMed");
		String payStatus = request.getParameter("payStatus");
		String importcreatetime = request.getParameter("importcreatetime");
		String payTime = request.getParameter("payTime");
		String providerId = request.getParameter("providerId");
		String storeId = request.getParameter("storeId");

		AddGoodsBean addGoodsBean = new AddGoodsBean(goodList, providerName,
				storeName, discountMed, payMed, payStatus, importcreatetime,
				payTime, providerId, storeId);
		String result = addGoodsImportList.addGoodsList(addGoodsBean);
		JSONObject data = new JSONObject();
		if (result == null) {
			responseFailed(response, "....", data);
		} else {
			responseSuccess(response, "****", data);
		}

	}

	@RequestMapping("/deleteImportData")
	public void deleteImportData(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String importSerialNumber = request.getParameter("importSerialNumber");
		String result = addGoodsImportList.deleteImportData(importSerialNumber);
		JSONObject data = new JSONObject();
		if (result == null) {
			responseFailed(response, "....", data);
		} else {
			responseSuccess(response, "****", data);
		}

	}

	@SuppressWarnings("deprecation")
	@RequestMapping("/updataImprotGoodsList")
	public String updataImprotGoodsList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String goodsAmountList = request.getParameter("goodsAmountList");
		String goodsTotalPriceList = request
				.getParameter("goodsTotalPriceList");
		String importGoodsIdList = request.getParameter("importGoodsIdList");
		String providerId = request.getParameter("providerId");
		String storehouseId = request.getParameter("storehouseId");
		String paymentType = request.getParameter("paymentType");
		String importStatus = request.getParameter("importStatus");
		String payTime = request.getParameter("payTime");
		String importSerialNumber = request.getParameter("importSerialNumber");
		String storehouseName = request.getParameter("storehouseName");
		String providerName = request.getParameter("providerName");
		storehouseName = URLDecoder.decode(storehouseName);
		providerName = URLDecoder.decode(providerName);
		String goodsAmounts[] = goodsAmountList.split(",");
		String goodsTotalPrices[] = goodsTotalPriceList.split(",");
		String importGoodsIds[] = importGoodsIdList.split(",");
		List<ImportGoods> importGoodsLists = new ArrayList<ImportGoods>();
		for (int i = 0; i < importGoodsIds.length; i++) {
			ImportGoods importGoods = new ImportGoods();
			importGoods.setImportGoodsId(Integer.parseInt(importGoodsIds[i]));
			importGoods.setImportGoodsTotalPrice(Long
					.parseLong(goodsTotalPrices[i]));
			importGoods.setImportGoodsAmount(Integer.parseInt(goodsAmounts[i]));
			importGoodsLists.add(importGoods);
		}
		UpdateImportDemo updateImportDemo = new UpdateImportDemo(
				importGoodsLists, providerId, storehouseId, paymentType,
				importStatus, payTime, importSerialNumber, storehouseName,
				providerName);
		String result = addGoodsImportList.updateImportGoods(updateImportDemo);
		request.setAttribute("result", result);
		return "import";
	}

	@ExceptionHandler(Exception.class)
	public String exception(Exception e, HttpServletRequest request) {
		request.setAttribute("exception", e);
		return "error";
	}

}
