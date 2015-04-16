package com.ai.psims.web.controller;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

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
import com.ai.psims.web.model.TbImport;
import com.ai.psims.web.model.TbImportExample;
import com.ai.psims.web.model.TbImportGoodsExample;
import com.ai.psims.web.model.TbImportExample.Criteria;
import com.ai.psims.web.model.TbImportGoods;
import com.ai.psims.web.model.TbProvider;
import com.ai.psims.web.model.TbStorehouse;
import com.ai.psims.web.model.UpdateImportDemo;
import com.ai.psims.web.util.Constants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/importController")
public class ImportController extends BaseController {
	@Resource(name = "queryBus")
	private IQueryBus queryBus;

	@Resource(name = "addGoodsImportListImpl")
	private IAddGoodsImportList addGoodsImportList;
	@Resource(name = "queryImportListImpl")
	private IQueryImportList queryImportList;

	@RequestMapping("/init")
	public String init(HttpServletRequest request) throws Exception {
		List<TbProvider> provider = new ArrayList<TbProvider>();
		List<TbStorehouse> storehouse = new ArrayList<TbStorehouse>();
		TbImportExample example = new TbImportExample();
		example.createCriteria().andImportStatusNotEqualTo("00");
		List<TbImport> importList = new ArrayList<TbImport>();
		importList = queryBus.queryImport(example);
		provider = queryBus.queryProvider();
		storehouse = queryBus.queryStorehouse();
		request.setAttribute("providerList", provider);
		request.setAttribute("storehouseList", storehouse);
		request.setAttribute("importList", importList);
		return "importsales";

	}

	@RequestMapping("/importInit")
	public String importInit(HttpServletRequest request) throws Exception {
		List<TbImport> importList = new ArrayList<TbImport>();
		List<TbStorehouse> storehouse = new ArrayList<TbStorehouse>();
		storehouse = queryBus.queryStorehouse();
		List<String> importStatusList = new ArrayList<String>();
		importStatusList.add(Constants.ImportStatus.ORDERNOPAY);
		importStatusList.add(Constants.ImportStatus.ORDERYESPAY);
		importStatusList.add(Constants.ImportStatus.GOODSLITARRIVAL);
		TbImportExample example = new TbImportExample();
		Criteria criteria = example.createCriteria();
		criteria.andImportStatusNotEqualTo("00");
		criteria.andImportStatusIn(importStatusList);
		importList = queryBus.queryImport(example);
		request.setAttribute("importList", importList);
		request.setAttribute("storehouseList", storehouse);
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
		com.ai.psims.web.model.GoodsExample.Criteria criteria = goodsExample
				.createCriteria();
		if (providerName != null && providerName != "") {
			criteria.andProviderNameEqualTo(providerName);
		}
		criteria.andGoodsEndtimeIsNull();
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
		List<TbImport> importList = new ArrayList<TbImport>();
		importList = queryImportList.queryImportByColum(example);
		if (importList == null) {
			responseFailed(response, "....", data);
		} else {
			data.put("goods", JSON.toJSONString(importList));
			responseSuccess(response, "*****", data);
		}
	}
	
	@RequestMapping("/queryImport")
	public void queryImport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String importSerialNumber = request.getParameter("importSerialNumber");
		TbImportExample example = new TbImportExample();
		Criteria criteria = example.createCriteria();
		JSONObject data = new JSONObject();
		if (importSerialNumber != null && importSerialNumber != "") {
			criteria.andImportSerialNumberLike("%" + importSerialNumber + "%");
		}
		criteria.andImportStatusNotEqualTo("00");
		List<TbImport> importList = new ArrayList<TbImport>();
		importList = queryImportList.queryImportByColum(example);
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
		com.ai.psims.web.model.GoodsExample.Criteria criteria = goodsExample
				.createCriteria();
		List<Goods> goodsList = new ArrayList<Goods>();
		JSONObject data = new JSONObject();
		Goods goods = new Goods();
		if (goodsName != null && goodsName != "") {
			criteria.andGoodsNameEqualTo(goodsName);
		}
		if (providerName != null && providerName != "") {
			criteria.andProviderNameEqualTo(providerName);
		}
		criteria.andGoodsEndtimeIsNull();
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
		TbImport import1 = new TbImport();
		List<TbImportGoods> importGoodsList = new ArrayList<TbImportGoods>();
		importGoodsList = addGoodsImportList.selBySerNum(importSerialNumber);
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
			HttpServletResponse response) throws Exception {
		String goodList = request.getParameter("goodList");
		String providerName = request.getParameter("providerName");
		String payMed = request.getParameter("payMed");
		String payStatus = request.getParameter("payStatus");
		String importcreatetime = request.getParameter("importcreatetime");
		String payTime = request.getParameter("payTime");
		String providerId = request.getParameter("providerId");

		AddGoodsBean addGoodsBean = new AddGoodsBean(goodList, providerName,
				payMed, payStatus, importcreatetime, payTime, providerId);
		String result = addGoodsImportList.addGoodsList(addGoodsBean);
		JSONObject data = new JSONObject();
		if (result == null) {
			responseFailed(response, "....", data);
		} else {
			responseSuccess(response, "****", data);
		}

	}

	@RequestMapping("/addImprotList")
	public void addImprotList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String goodList = request.getParameter("goodList");
		String importSerialNumber = request.getParameter("importSerialNumber");
		String storeName = request.getParameter("storeName");
		String storeId = request.getParameter("storeId");

		String result = addGoodsImportList.goodsImport(goodList,
				importSerialNumber, storeName, storeId);
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

	@RequestMapping("/goodsImport")
	public void goodsImport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String importSerialNumber = request.getParameter("importSerialNumber");
		List<String> goodsName = new ArrayList<String>();
		goodsName = addGoodsImportList.getGoodsName(importSerialNumber);
		JSONObject data = new JSONObject();
		if (goodsName == null) {
			responseFailed(response, "....", data);
		} else {
			data.put("goodsName", JSON.toJSONString(goodsName));
			responseSuccess(response, "****", data);
		}
	}

	@SuppressWarnings("deprecation")
	@RequestMapping("/showImportGoods")
	public String showImportGoods(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String importSerialNumber = request.getParameter("importSerialNumber");
		String goodName = request.getParameter("goodsName");
		if (goodName != null) {
			goodName = URLDecoder.decode(goodName);
		}
		List<TbImportGoods> importGoodsList = new ArrayList<TbImportGoods>();
		TbImportGoodsExample example = new TbImportGoodsExample();
		com.ai.psims.web.model.TbImportGoodsExample.Criteria criteria = example
				.createCriteria();
		criteria.andImportSerialNumberEqualTo(importSerialNumber);
		criteria.andGoodsNameEqualTo(goodName);
		importGoodsList = addGoodsImportList.queryImportGoods(example);
		request.setAttribute("importGoods", importGoodsList.get(0));
		return "goodsimport";
	}

	@SuppressWarnings("deprecation")
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
		providerName = URLDecoder.decode(providerName);
		String goodsAmounts[] = goodsAmountList.split(",");
		String importGoodsIds[] = importGoodsIdList.split(",");
		List<TbImportGoods> importGoodsLists = new ArrayList<TbImportGoods>();
		for (int i = 0; i < importGoodsIds.length; i++) {
			TbImportGoods importGoods = new TbImportGoods();
			importGoods.setImportGoodsId(Integer.parseInt(importGoodsIds[i]));
			importGoods.setImportGoodsAmount(Integer.parseInt(goodsAmounts[i]));
			importGoodsLists.add(importGoods);
		}
		UpdateImportDemo updateImportDemo = new UpdateImportDemo(
				importGoodsLists, providerId, paymentType, importStatus,
				payTime, importSerialNumber, providerName);
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
