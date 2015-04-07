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

import com.ai.psims.web.business.IAddGoodsImportList;
import com.ai.psims.web.business.IQueryImportList;
import com.ai.psims.web.business.ISalesBusiness;
import com.ai.psims.web.common.interfaces.IQueryBus;
import com.ai.psims.web.model.AddSalesGoodsBean;
import com.ai.psims.web.model.Employee;
import com.ai.psims.web.model.EmployeeExample;
import com.ai.psims.web.model.ImportGoods;
import com.ai.psims.web.model.Sales;
import com.ai.psims.web.model.SalesExample;
import com.ai.psims.web.model.SalesGoods;
import com.ai.psims.web.model.SalesGoodsExample;
import com.ai.psims.web.model.Storagecheck;
import com.ai.psims.web.model.StoragecheckExample;
import com.ai.psims.web.model.StoragecheckExample.Criteria;
import com.ai.psims.web.model.Storehouse;
import com.ai.psims.web.model.TbCustomer;
import com.ai.psims.web.model.TbCustomerExample;
import com.ai.psims.web.model.UpdateImportDemo;
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
	@Resource(name = "addGoodsImportListImpl")
	private IAddGoodsImportList addGoodsImportList;
	@Resource(name = "queryImportListImpl")
	private IQueryImportList queryImportList;

	@RequestMapping("/init")
	public String showProvider(HttpServletRequest request) throws Exception {
		List<TbCustomer> customersList = new ArrayList<TbCustomer>();
		List<Employee> employeesList = new ArrayList<Employee>();
		List<Sales> salesList = new ArrayList<Sales>();
		SalesExample salesExample = new SalesExample();
		TbCustomerExample customerExample = new TbCustomerExample();
		EmployeeExample employeeExample = new EmployeeExample();
		List<Storehouse> storehouse = new ArrayList<Storehouse>();
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
		storagecheckExample.createCriteria().andGoodsStatusEqualTo(
				Constants.ImportGoodsStatus.CANSALE);
		storagechecksList = salesBusiness
				.queryStrStoragechecks(storagecheckExample);
		Set<String> goodsNameSet = new HashSet<String>();
		for (Storagecheck storagecheck : storagechecksList) {
			goodsNameSet.add(storagecheck.getGoodsName());
		}
		if (storagechecksList == null && storagechecksList.size() == 0) {
			responseFailed(response, "....", data);
		} else {
			// data.put("list", JSON.toJSONString(storagechecksList));
			data.put("goodsNameSet", JSON.toJSONString(goodsNameSet));
			responseSuccess(response, "*****", data);
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
			responseFailed(response, "....", data);
		} else {
			// data.put("list", JSON.toJSONString(storagechecksList));
			data.put("storagechecks", JSON.toJSONString(storagechecks));
			responseSuccess(response, "*****", data);
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
		salesList = salesBusiness.selectByExample(salesExample);
		if (salesList == null) {
			responseFailed(response, "....", data);
		} else {
			data.put("salesList", JSON.toJSONString(salesList));
			responseSuccess(response, "*****", data);
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
		sales = salesBusiness.selectSalesByKey(salesSerialNumber);
		SalesGoodsExample example = new SalesGoodsExample();
		example.createCriteria().andSalesSerialNumberEqualTo(salesSerialNumber);
		salesGoodsList = salesBusiness.selectSalesGoods(example);

		request.setAttribute("salesGoodsList", salesGoodsList);
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
		String payMed = request.getParameter("payMed");
		String salesListCreateTime = request
				.getParameter("salesListCreateTime");
		String employeeName = request.getParameter("employeeName");
		String payStatus = request.getParameter("payStatus");
		String employeeId = request.getParameter("employeeId");
		String payTime = request.getParameter("payTime");
		String discountMed = request.getParameter("discountMed");

		AddSalesGoodsBean addGoodsBean = new AddSalesGoodsBean(storageIdList,
				customerName, storeName, customerId, payMed, payStatus,
				salesListCreateTime, payTime, employeeName, storeId,
				employeeId, salesCountList, salesPriceList, discountMed);
		String result = salesBusiness.addSalesList(addGoodsBean);
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
