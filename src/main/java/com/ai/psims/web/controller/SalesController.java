package com.ai.psims.web.controller;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

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
import com.ai.psims.web.model.TbStorehouse;
import com.ai.psims.web.service.IStoragecheckService;
import com.ai.psims.web.util.Constants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/salesController")
public class SalesController extends BaseController {
	@Resource(name = "queryBus")
	private IQueryBus queryBus;
	@Resource(name = "salesBusinessImpl")
	private ISalesBusiness salesBusiness;
	@Resource(name = "storagecheckServiceImpl")
	private IStoragecheckService storagecheckService;

	@RequestMapping("/init")
	public String init(HttpServletRequest request) throws Exception {
		List<TbCustomer> customersList = new ArrayList<TbCustomer>();
		List<TbEmployee> employeesList = new ArrayList<TbEmployee>();
		List<Sales> salesList = new ArrayList<Sales>();
		SalesExample salesExample = new SalesExample();
		salesExample.createCriteria().andSalesStatusNotEqualTo("00");
		TbCustomerExample customerExample = new TbCustomerExample();
		customerExample.createCriteria().andEndtimeIsNull();
		TbEmployeeExample employeeExample = new TbEmployeeExample();
		employeeExample.createCriteria().andEndtimeIsNull();
		List<TbStorehouse> storehouse = new ArrayList<TbStorehouse>();
		salesList = salesBusiness.selectByExample(salesExample);
		employeesList = queryBus.queryEmployee(employeeExample);
		customersList = queryBus.queryCustomer(customerExample);
		storehouse = queryBus.queryStorehouse();
		request.setAttribute("storehouseList", storehouse);
		request.setAttribute("customersList", customersList);
		request.setAttribute("employeesList", employeesList);
		request.setAttribute("salesList", salesList);
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
			responseSuccess(response, "SUCCESS*", data);
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
			responseSuccess(response, "SUCCESS*", data);
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
		salesList = salesBusiness.selectByExample(salesExample);
		if (salesList == null) {
			responseFailed(response, "ERROR", data);
		} else {
			data.put("salesList", JSON.toJSONString(salesList));
			responseSuccess(response, "SUCCESS*", data);
		}
	}

	@SuppressWarnings("deprecation")
	@RequestMapping("/queryGoodsDemo")
	public String queryGoodsDemo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String goodsName = request.getParameter("goodName");
		List<Storagecheck> storagechecksList = new ArrayList<Storagecheck>();
		StoragecheckExample storagecheckExample = new StoragecheckExample();
		Criteria criteria = storagecheckExample.createCriteria();
		criteria.andGoodsStatusEqualTo(Constants.ImportGoodsStatus.CANSALE);
		if (goodsName != null && goodsName != "") {
			goodsName = URLDecoder.decode(goodsName);
			criteria.andGoodsNameEqualTo(goodsName);
		}
		criteria.andEndtimeIsNull();
		storagechecksList = salesBusiness
				.queryStrStoragechecks(storagecheckExample);
		request.setAttribute("storagechecksList", storagechecksList);
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
			Storagecheck storagecheck = new Storagecheck();
			storagecheck = storagecheckService.selectByKey(salesGoods
					.getStorageId());
			saUpdataGoods.setGoodsName(salesGoods.getGoodsName());
			saUpdataGoods.setSalesGoodsAmount(salesGoods.getSalesGoodsAmount());
			saUpdataGoods.setSalesGoodsId(salesGoods.getSalesGoodsId());
			saUpdataGoods.setSalesGoodsPrice(salesGoods.getSalesGoodsPrice());
			saUpdataGoods.setSalesGoodsTotalPrice(salesGoods
					.getSalesGoodsTotalPrice());
			saUpdataGoods.setSalesSerialNumber(salesGoods
					.getSalesSerialNumber());
			saUpdataGoods.setStorageRateCurrent(storagecheck
					.getStorageRateCurrent());
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
		SalesUpdateData salesUpdateData = new SalesUpdateData(salesGoodsIdList,
				goodsAmountList, salesSerialNumber, salesStatus, payMed,
				creditCount, payTime);
		String result = salesBusiness.updateSalesData(salesUpdateData);
		request.setAttribute("result", result);
		return "import";
	}

	@ExceptionHandler(Exception.class)
	public String exception(Exception e, HttpServletRequest request) {
		request.setAttribute("exception", e);
		return "error";
	}

}
