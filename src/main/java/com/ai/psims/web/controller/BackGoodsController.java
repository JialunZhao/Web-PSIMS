package com.ai.psims.web.controller;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ai.psims.web.business.IImportBackBusiness;
import com.ai.psims.web.business.ISalesbackBusiness;
import com.ai.psims.web.common.interfaces.IQueryBus;
import com.ai.psims.web.model.AddSalesbackData;
import com.ai.psims.web.model.Employee;
import com.ai.psims.web.model.EmployeeExample;
import com.ai.psims.web.model.Importback;
import com.ai.psims.web.model.SalesBackGoodsData;
import com.ai.psims.web.model.Salesback;
import com.ai.psims.web.model.SalesbackExample;
import com.ai.psims.web.model.SalesbackGoods;
import com.ai.psims.web.model.SalesbackGoodsExample;
import com.ai.psims.web.model.TbCustomer;
import com.ai.psims.web.model.TbCustomerExample;
import com.ai.psims.web.model.TbProvider;
import com.ai.psims.web.model.TbStorehouse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/backGoodsController")
public class BackGoodsController extends BaseController {
	@Resource(name = "queryBus")
	private IQueryBus queryBus;
	@Resource(name = "salesbackBusinessImpl")
	private ISalesbackBusiness salesbackBusiness;
	@Resource(name = "importBackBusinessImpl")
	private IImportBackBusiness importBackBusiness;

	@RequestMapping("/providerBackInit")
	public String providerBackInit(HttpServletRequest request) throws Exception {
		List<TbProvider> provider = new ArrayList<TbProvider>();
		List<TbStorehouse> storehouse = new ArrayList<TbStorehouse>();
		List<Importback> importbacksList = new ArrayList<Importback>();
		importbacksList = importBackBusiness.queryImportback();
		provider = queryBus.queryProvider();
		storehouse = queryBus.queryStorehouse();
		request.setAttribute("providerList", provider);
		request.setAttribute("storehouseList", storehouse);
		request.setAttribute("importbacksList", importbacksList);
		return "importbackgoods";
	}

	@RequestMapping("/salesBackInit")
	public String salesBackInit(HttpServletRequest request) throws Exception {
		List<TbCustomer> customersList = new ArrayList<TbCustomer>();
		List<Employee> employeesList = new ArrayList<Employee>();
		List<Salesback> salesbackList = new ArrayList<Salesback>();
		SalesbackExample salesbackExample = new SalesbackExample();
		salesbackExample.createCriteria().andSalesbackTypeNotEqualTo("00");
		TbCustomerExample customerExample = new TbCustomerExample();
		customerExample.createCriteria().andEndtimeIsNull();
		EmployeeExample employeeExample = new EmployeeExample();
		employeeExample.createCriteria().andEndtimeIsNull();
		List<TbStorehouse> storehouse = new ArrayList<TbStorehouse>();
		salesbackList = salesbackBusiness.selectSalesback();
		employeesList = queryBus.queryEmployee(employeeExample);
		customersList = queryBus.queryCustomer(customerExample);
		storehouse = queryBus.queryStorehouse();
		request.setAttribute("storehouseList", storehouse);
		request.setAttribute("customersList", customersList);
		request.setAttribute("employeesList", employeesList);
		request.setAttribute("salesbackList", salesbackList);
		return "salesbackgoods";
	}

	@RequestMapping("/queryGoods")
	public void queryGoods(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JSONObject data = new JSONObject();
		String salesSerialNumber = request.getParameter("salesSerialNumber");
		Set<String> goodsNameSet = salesbackBusiness
				.queryGoodsName(salesSerialNumber);
		if (goodsNameSet == null || goodsNameSet.size() == 0) {
			responseFailed(response, "ERROR", data);
		} else {
			data.put("goodsNameSet", JSON.toJSONString(goodsNameSet));
			responseSuccess(response, "SUCCESS", data);
		}
	}

	// @RequestMapping("/getGoodTab")
	// public void getGoodTab(HttpServletRequest request,
	// HttpServletResponse response) throws Exception {
	// JSONObject data = new JSONObject();
	// String storageId = request.getParameter("storageId");
	// Storagecheck storagechecks = new Storagecheck();
	// storagechecks = salesBusiness.selectByKey(Integer.parseInt(storageId));
	// if (storagechecks == null) {
	// responseFailed(response, "ERROR", data);
	// } else {
	// // data.put("list", JSON.toJSONString(storagechecksList));
	// data.put("storagechecks", JSON.toJSONString(storagechecks));
	// responseSuccess(response, "SUCCESS", data);
	// }
	// }

	@RequestMapping("/querySalesbackList")
	public void querySalesbackList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String customerId = request.getParameter("customerId");
		String storehouseId = request.getParameter("storehouseId");
		String employeeId = request.getParameter("employeeId");
		String salesbackSerialNumber = request
				.getParameter("salesbackSerialNumber");
		JSONObject data = new JSONObject();
		SalesbackExample salesbackExample = new SalesbackExample();
		com.ai.psims.web.model.SalesbackExample.Criteria criteria = salesbackExample
				.createCriteria();
		List<Salesback> salesList = new ArrayList<Salesback>();
		if (customerId != null && customerId != "") {
			criteria.andCustomerIdEqualTo(Integer.parseInt(customerId));
		}
		if (storehouseId != null && storehouseId != "") {
			criteria.andStorehouseIdEqualTo(Integer.parseInt(storehouseId));
		}
		if (employeeId != null && employeeId != "") {
			criteria.andEmployeeIdEqualTo(Integer.parseInt(employeeId));
		}
		if (salesbackSerialNumber != null && salesbackSerialNumber != "") {
			criteria.andSalesbackSerialNumberLike("%" + salesbackSerialNumber
					+ "%");
		}
		salesList = salesbackBusiness.querySalesbacks(salesbackExample);
		if (salesList == null) {
			responseFailed(response, "ERROR", data);
		} else {
			data.put("salesList", JSON.toJSONString(salesList));
			responseSuccess(response, "SUCCESS", data);
		}
	}

	@RequestMapping("/queryGoodsDemo")
	public String queryGoodsDemo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		@SuppressWarnings("deprecation")
		String goodsName = URLDecoder.decode(request.getParameter("goodName"));
		String backType = request.getParameter("backType");
		String salesSerialNumber = request.getParameter("salesSerialNumber");

		List<SalesBackGoodsData> salesBackGoodsDatasList = new ArrayList<SalesBackGoodsData>();
		salesBackGoodsDatasList = salesbackBusiness.getSalesBackGoodsData(
				goodsName, backType, salesSerialNumber);
		request.setAttribute("salesBackGoodsDatasList", salesBackGoodsDatasList);
		request.setAttribute("backType", backType);
		return "salesgoodsbacktab";
	}

	@RequestMapping("/updateSalesbackGoodsList")
	public String updateSalesbackGoodsList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String salesbackSerialNumber = request
				.getParameter("salesbackSerialNumber");
		Salesback salesback = new Salesback();
		List<SalesbackGoods> salesbackGoodsList = new ArrayList<SalesbackGoods>();
		salesback = salesbackBusiness
				.selectSalesbackByKey(salesbackSerialNumber);
		SalesbackGoodsExample example = new SalesbackGoodsExample();
		example.createCriteria().andSalesbackSerialNumberEqualTo(
				salesbackSerialNumber);
		salesbackGoodsList = salesbackBusiness.selectSalesbackGoods(example);

		request.setAttribute("salesbackGoodsList", salesbackGoodsList);
		request.setAttribute("salesback", salesback);
		return "updatasalesbackdata";
	}

	@RequestMapping("/addSalesbackList")
	public void addSalesbackList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String storageIdList = request.getParameter("storageIdList");
		String changeCountList = request.getParameter("changeCountList");
		String salesSerialNumber = request.getParameter("salesSerialNumber");
		String backReson = request.getParameter("backReson");
		String backgoodsTime = request.getParameter("backgoodsTime");

		AddSalesbackData addSalesbackData = new AddSalesbackData(storageIdList,
				changeCountList, salesSerialNumber, backReson, backgoodsTime);
		String result = salesbackBusiness.addSalesbackList(addSalesbackData);
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
		String salesbackSerialNumber = request.getParameter("salesbackSerialNumber");
		String result = salesbackBusiness
				.deleteSalesbackData(salesbackSerialNumber);
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
		String goodsAmountList = request.getParameter("goodsAmountList");
		String salesbackSerialNumber = request
				.getParameter("salesbackSerialNumber");
		String salesbackType = request.getParameter("salesbackType");
		String salesbackReason = request.getParameter("salesbackReason");
		String storageIdList = request.getParameter("storageIdList");
		String result = salesbackBusiness.updateSalesbackInfo(goodsAmountList,
				salesbackSerialNumber, salesbackType, salesbackReason,
				storageIdList);
		request.setAttribute("result", result);
		return "salesbackgoods";
	}

	@ExceptionHandler(Exception.class)
	public String exception(Exception e, HttpServletRequest request) {
		request.setAttribute("exception", e);
		return "error";
	}

}
