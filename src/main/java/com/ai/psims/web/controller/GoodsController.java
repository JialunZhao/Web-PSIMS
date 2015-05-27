package com.ai.psims.web.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.ai.psims.web.business.IGoods2CustomerBusiness;
import com.ai.psims.web.business.IGoodsBusiness;
import com.ai.psims.web.business.IProviderBusiness;
import com.ai.psims.web.business.ISystemParameterBussiness;
import com.ai.psims.web.model.TbCustomer;
import com.ai.psims.web.model.TbCustomerExample;
import com.ai.psims.web.model.TbGoods;
import com.ai.psims.web.model.TbGoods2customer;
import com.ai.psims.web.model.TbGoods2customerExample;
import com.ai.psims.web.model.TbGoodsExample;
//import com.ai.psims.web.model.TbGoodsExample.Criteria;
import com.ai.psims.web.model.TbProvider;
import com.ai.psims.web.model.TbProviderExample;
import com.ai.psims.web.model.TbSystemParameter;
import com.ai.psims.web.model.TbSystemParameterExample;

/**
 * 商品管理Controller
 */
@Controller
@RequestMapping("/goodsController")
public class GoodsController extends BaseController {

	private static final Logger logger = LoggerFactory
			.getLogger(GoodsController.class);

	@Resource(name = "goodsBusinessImpl")
	private IGoodsBusiness goodsBusiness;

	@Resource(name = "goods2CustomerBusinessImpl")
	private IGoods2CustomerBusiness goods2CustomerBusiness;
	
	@Resource(name = "providerBusinessImpl")
	private IProviderBusiness providerBusinessImpl;
	
	@Resource(name = "systemParameterBussinessImpl")
	private ISystemParameterBussiness systemParameterBussinessImpl;

	/**
	 * 商品管理页面跳转
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goodsRedirectGET(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "redirect:/goodsController/goods";
	}

	/**
	 * 商品管理页面跳转
	 */
	@RequestMapping(value = "/goods", method = RequestMethod.GET)
	public String goodsRedirect(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("------------Welcome goods page!-------------");
		logger.info("------------0.权限管理！-------------");	
		logger.info("------------1.初始化！-------------");
		List<TbGoods> goodss =new ArrayList<TbGoods>();
		TbGoodsExample tbGoodsExample = new TbGoodsExample();
		TbGoodsExample.Criteria criteria = tbGoodsExample.createCriteria();
		List<TbSystemParameter> tbSystemParameters = new ArrayList<TbSystemParameter>();
		TbSystemParameterExample tbSystemParameterExample =new TbSystemParameterExample();
		TbSystemParameterExample.Criteria tbSystemParameterCriteria = tbSystemParameterExample.createCriteria();
		
		logger.info("------------2.获取参数-------------");
		String query_goodsName = request.getParameter("query_goodsName") == "" ? null
				: request.getParameter("query_goodsName");
		String query_goodsType = request.getParameter("query_goodsType") == "" ? null
				: request.getParameter("query_goodsType");
		String query_goodsPrice = request.getParameter("query_goodsPrice") == "" ? null
				: request.getParameter("query_goodsPrice");
		String query_goodsShelfLife = request
				.getParameter("query_goodsShelfLife") == "" ? null : request
				.getParameter("query_goodsShelfLife");
		logger.info("------------3.数据校验-------------");
		if ( null != query_goodsName && query_goodsName.length() > 0) {
			query_goodsName = "%" + query_goodsName + "%";
			criteria.andGoodsNameLike(query_goodsName);
		}
		if (null != query_goodsType && query_goodsType.length() > 0) {
			if (!query_goodsType.equals("0")) {
				criteria.andGoodsTypeEqualTo(query_goodsType);
			}
		}
		if (null != query_goodsPrice && query_goodsPrice.length() > 0) {
			criteria.andGoodsPriceEqualTo(query_goodsPrice);
		}
		if (null != query_goodsShelfLife && query_goodsShelfLife.length() > 0) {
			criteria.andGoodsShelfLifeEqualTo(
					Integer.parseInt(query_goodsShelfLife));
		}
		logger.info("------------4.业务处理开始-------------");
		// 只查询状态为正常的记录 00-失效 01-正常 99-异常
		criteria.andGoodsStatusNotEqualTo("00");
		goodss = goodsBusiness.goodsQuery(tbGoodsExample);
		logger.info("------------4.1.转译商品类型-------------");
		for (TbGoods tbGoods : goodss) {
			if (tbGoods.getGoodsType() == null && "".equals(tbGoods.getGoodsType()) ) {
			} else {
				tbGoods.setGoodsType(systemParameterBussinessImpl.getSystemParameterPrizePool(Integer.parseInt(tbGoods.getGoodsType())).getPpDesc());
			}
		}
		logger.info("------------4.2.转译基本单位-------------");
		for (TbGoods tbGoods : goodss) {
			if (tbGoods.getGoodsUnit() == null) {
			} else {
				tbGoods.setGoodsUnit(systemParameterBussinessImpl.getSystemParameterPrizePool(Integer.parseInt(tbGoods.getGoodsUnit())).getPpDesc());
			}
		}
		logger.info("------------4.3.获取商品类型-------------");
		tbSystemParameterCriteria.andPStatusEqualTo("01");
		tbSystemParameterCriteria.andPValueEqualTo("GoodsType");
		tbSystemParameters = systemParameterBussinessImpl.selectByExample(tbSystemParameterExample);
		
		logger.info("------------4.业务处理完成-------------");
		logger.info("------------5.返回结果-------------");
		request.setAttribute("goodss", goodss);
		request.setAttribute("tbSystemParameters", tbSystemParameters);
		request.setAttribute("goodsName", query_goodsName);
		request.setAttribute("goodsType", query_goodsType);
		request.setAttribute("goodsPrice", query_goodsPrice);
		request.setAttribute("goodsShelfLife", query_goodsShelfLife);
		logger.info("------------goods page finished!-------------");
		return "goods";
	}

	/**
	 * 商品管理-新增修改商品信息-获取商品信息
	 */
	@RequestMapping(value = "/getProviderAddGoods", method = RequestMethod.POST)
	public @ResponseBody List<TbProvider> tbProviders(
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("------------Welcome goods add info!-------------");
		logger.info("------------1.初始化-------------");
		List<TbProvider> tbProviders = new ArrayList<TbProvider>();
		TbProviderExample tbProviderExample = new TbProviderExample();
		TbProviderExample.Criteria criteria = tbProviderExample
				.createCriteria();
		logger.info("------------2.获取参数-------------");
		logger.info("------------3.数据校验-------------");
		// 查询状态为正常的记录 00-失效 01-正常 99-异常
		criteria.andProviderStatusEqualTo("01");
		logger.info("------------4.业务处理-------------");
		tbProviders = providerBusinessImpl.providerQuery(tbProviderExample);
		logger.info("------------5.返回结果-------------");
		logger.info("------------Bye goods add info! -------------");
		return tbProviders;
	}
	/**
	 * 商品管理-新增修改商品信息-获取基本单位信息
	 */
	@RequestMapping(value = "/getGoodsUnit", method = RequestMethod.POST)
	public @ResponseBody List<TbSystemParameter> getGoodsUnit(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("------------Welcome getGoodsUnit!-------------");
		logger.info("------------1.初始化-------------");
		List<TbSystemParameter> tbSystemParameters = new ArrayList<TbSystemParameter>();
		TbSystemParameterExample tbSystemParameterExample = new TbSystemParameterExample();
		TbSystemParameterExample.Criteria criteria = tbSystemParameterExample
				.createCriteria();
		logger.info("------------2.获取参数-------------");
		logger.info("------------3.数据校验-------------");
		logger.info("------------4.业务处理-------------");
		// 只查询状态为正常的记录 （00-失效 01-正常 99-异常）
		criteria.andPStatusEqualTo("01");
		criteria.andPValueEqualTo("GoodsUnit");
		tbSystemParameters = systemParameterBussinessImpl
				.getSystemParameterPrizePool(tbSystemParameterExample);
		request.setAttribute("tbSystemParameters", tbSystemParameters);
		logger.info("------------5.返回结果-------------");
		logger.info("------------Bye getGoodsUnit!-------------");
		return tbSystemParameters;
	}
	
	/**
	 * 商品管理新增商品信息
	 */
	@RequestMapping(value = "/addGoods", method = RequestMethod.POST)
	public String tbGoods(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("------------Welcome goods add info!-------------");
		logger.info("------------1.初始化-------------");
		TbGoods goodsadd = new TbGoods();
		logger.info("------------2.获取参数-------------");
		String goodsName = request.getParameter("goodsName") == "" ? null : request.getParameter("goodsName");
		String goodsCode = request.getParameter("goodsCode") == null ? request.getParameter("goodsName") : request.getParameter("goodsCode");
		String goodsVersion = request.getParameter("goodsVersion") == "" ? null : request.getParameter("goodsVersion");
		String goodsUnit = request.getParameter("goodsUnit") == "" ? null : request.getParameter("goodsUnit");
		String goodsBarCode = request.getParameter("goodsBarCode") == "" ? null : request.getParameter("goodsBarCode");
		String goodsCurrentStock = request.getParameter("goodsCurrentStock") == "" ? null : request.getParameter("goodsCurrentStock");
		String goodsTotalStock = request.getParameter("goodsTotalStock") == "" ? null : request.getParameter("goodsTotalStock");
//		String goodsProductionDate = request.getParameter("goodsProductionDate") == "" ? null : request.getParameter("goodsProductionDate");
//		String goodsExpirationDate = request.getParameter("goodsExpirationDate") == "" ? null : request.getParameter("goodsExpirationDate");
		String goodsShelfLife = request.getParameter("goodsShelfLife") == "" ? null : request.getParameter("goodsShelfLife");
		String goodsProfit = request.getParameter("goodsProfit") == "" ? null : request.getParameter("goodsProfit");
		String goodsPrice = request.getParameter("goodsPrice") == "" ? null : request.getParameter("goodsPrice");
		String goodsPrizePoolRatio = request.getParameter("goodsPrizePoolRatio") == "" ? null : request.getParameter("goodsPrizePoolRatio");
		String goodsType = request.getParameter("goodsType") == "" ? null : request.getParameter("goodsType");
		String goodsStatus = request.getParameter("goodsStatus") == "" ? null : request.getParameter("goodsStatus");
//		String goodsCreatetime = request.getParameter("goodsCreatetime") == "" ? null : request.getParameter("goodsCreatetime");
//		String goodsModifytime = request.getParameter("goodsModifytime") == "" ? null : request.getParameter("goodsModifytime");
//		String goodsEndtime = request.getParameter("goodsEndtime") == "" ? null : request.getParameter("goodsEndtime");
		String providerId = request.getParameter("providerId") == "" ? null : request.getParameter("providerId");
		String providerName = request.getParameter("providerName") == "" ? null : request.getParameter("providerName");
		String providerCode = request.getParameter("providerCode") == "" ? null : request.getParameter("providerCode");
		String remark = request.getParameter("remark") == "" ? null : request.getParameter("remark");
		String goodsDiscount = request.getParameter("goodsDiscount") == "" ? null : request.getParameter("goodsDiscount");
		String quarterRebate = request.getParameter("quarterRebate") == "" ? null : request.getParameter("quarterRebate");
		String annualRebate = request.getParameter("annualRebate") == "" ? null : request.getParameter("annualRebate");
		String providerSubsidy = request.getParameter("providerSubsidy") == "" ? null : request.getParameter("providerSubsidy");
		String providerPackageSubsidy = request.getParameter("providerPackageSubsidy") == "" ? null : request.getParameter("providerPackageSubsidy");
		String customerSubsidy = request.getParameter("customerSubsidy") == "" ? null : request.getParameter("customerSubsidy");
		String otherSubsidy = request.getParameter("otherSubsidy") == "" ? null : request.getParameter("otherSubsidy");
		String goodsActualCost = request.getParameter("goodsActualCost") == "" ? null : request.getParameter("goodsActualCost");
		String storagePrewarning = request.getParameter("storagePrewarning") == "" ? null : request.getParameter("storagePrewarning");
		String shelfLifePrewarning = request.getParameter("shelfLifePrewarning") == "" ? null : request.getParameter("shelfLifePrewarning");

		Date goodsCreatetime = new Date();
		logger.info("------------3.数据校验-------------");
		goodsadd.setGoodsName(goodsName);
		goodsadd.setGoodsCode(goodsCode);
		if (null != goodsVersion && goodsVersion.length() > 0) {
			goodsadd.setGoodsVersion(Integer.parseInt(goodsVersion));
		}
		goodsadd.setGoodsUnit(goodsUnit);
		goodsadd.setGoodsBarCode(goodsBarCode);
		if (null != goodsCurrentStock && goodsCurrentStock.length() > 0) {
			goodsadd.setGoodsCurrentStock(Integer.parseInt(goodsCurrentStock));
		}
		if (null != goodsTotalStock && goodsTotalStock.length() > 0) {
			goodsadd.setGoodsTotalStock(Integer.parseInt(goodsTotalStock));
		}
		if (null != goodsShelfLife && goodsShelfLife.length() > 0) {
			goodsadd.setGoodsShelfLife(Integer.parseInt(goodsShelfLife));
		}
		if (null != goodsProfit && goodsProfit.length() > 0) {
			goodsadd.setGoodsProfit(goodsProfit);
		}
//		金额改造 
		if (null != goodsPrice  && goodsPrice.length() > 0) {
			goodsadd.setGoodsPrice(new BigDecimal(goodsPrice).toString());
		}
		if (null != goodsPrizePoolRatio && goodsPrizePoolRatio.length() > 0) {
			goodsadd.setGoodsPrizePoolRatio(new BigDecimal(goodsPrizePoolRatio).toString());
		}
		goodsadd.setGoodsType(goodsType);
		goodsadd.setGoodsStatus(goodsStatus);
		goodsadd.setGoodsCreatetime(goodsCreatetime);
//		goodsadd.setGoodsModifytime(goodsModifytime);
//		goodsadd.setGoodsEndtime(goodsEndtime);
		if (null != providerId && providerId.length() > 0) {
			goodsadd.setProviderId(Integer.parseInt(providerId));
		}
		goodsadd.setProviderName(providerName);
		goodsadd.setProviderCode(providerCode);
		goodsadd.setRemark(remark);
		if (null != goodsDiscount && goodsDiscount.length() > 0) {
			goodsadd.setGoodsDiscount(new BigDecimal(goodsDiscount).toString());
		}
		if (null != quarterRebate && quarterRebate.length() > 0) {
			goodsadd.setQuarterRebate(new BigDecimal(quarterRebate).toString());
		}
		if (null != annualRebate && annualRebate.length() > 0) {
			goodsadd.setAnnualRebate(new BigDecimal(annualRebate).toString());
		}
		if (null != providerSubsidy && providerSubsidy.length() > 0) {
			goodsadd.setProviderSubsidy(new BigDecimal(providerSubsidy).toString());
		}
		if (null != providerPackageSubsidy && providerPackageSubsidy.length() > 0) {
			goodsadd.setProviderPackageSubsidy(new BigDecimal(providerPackageSubsidy).toString());
		}
		if (null != customerSubsidy && customerSubsidy.length() > 0) {
			goodsadd.setCustomerSubsidy(new BigDecimal(customerSubsidy).toString());
		}
		if (null != otherSubsidy && otherSubsidy.length() > 0) {
			goodsadd.setOtherSubsidy(new BigDecimal(otherSubsidy).toString());
		}
		if (null != goodsActualCost && goodsActualCost.length() > 0) {
			goodsadd.setGoodsActualCost(new BigDecimal(goodsActualCost).toString());
		}
		if (null != storagePrewarning && storagePrewarning.length() > 0) {
			goodsadd.setStorageWarning(Integer.parseInt(storagePrewarning));
		}
		if (null != shelfLifePrewarning && shelfLifePrewarning.length() > 0) {
			goodsadd.setShelfLifeWarning(Integer.parseInt(shelfLifePrewarning));
		}
		goodsadd.setGoodsStatus("01"); // 新增状态为正常的记录 00-失效 01-正常 99-异常
		logger.info("------------4.业务处理-------------");
		int res = goodsBusiness.goodsAdd(goodsadd);
		toString();
		logger.info(String.valueOf(res));
		logger.info("------------5.返回结果-------------");
		logger.info("------------Bye goods add info! -------------");
		return "goods";
	}

	/**
	 * 商品管理删除商品信息
	 */
	@RequestMapping(value = "/deleteGoods", method = RequestMethod.POST)
	public String goodsDelete(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("------------Welcome deletegoods! -------------");
		logger.info("------------1.初始化-------------");
		TbGoods tbGoods = new TbGoods();
		logger.info("------------2.获取参数-------------");
		String goodsId = request.getParameter("goodsId");
		logger.info("------------3.数据校验-------------");
		if (null != goodsId && goodsId.length() > 0) {
			tbGoods.setGoodsId(Integer.parseInt(goodsId));
		}
		logger.info("------------4.业务处理-------------");
		// 逻辑删除 修改状态为 00-失效 （00-失效 01-正常 02-下架 99-异常）
		tbGoods.setGoodsStatus("00");
		int res = goodsBusiness.goodsModify(tbGoods);
		toString();
		logger.info(String.valueOf(res));
		logger.info("------------5.返回结果-------------");
		logger.info("------------Bye deletegoods! -------------");
		return "goods";
	}
	
	/**
	 * 商品管理下架商品信息
	 */
	@RequestMapping(value = "/offShelvesGoods", method = RequestMethod.POST)
	public String offShelvesGoods(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("------------Welcome offShelvesGoods! -------------");
		logger.info("------------1.初始化-------------");
		TbGoods tbGoods = new TbGoods();
		logger.info("------------2.获取参数-------------");
		String goodsId = request.getParameter("goodsId");
		logger.info("------------3.数据校验-------------");
		if (null != goodsId && goodsId.length() > 0) {
			tbGoods.setGoodsId(Integer.parseInt(goodsId));
		}
		logger.info("------------4.业务处理-------------");
		// 逻辑删除 修改状态为 00-失效 （00-失效 01-正常 02-下架 99-异常）
		tbGoods.setGoodsStatus("02");
		int res = goodsBusiness.goodsModify(tbGoods);
		toString();
		logger.info(String.valueOf(res));
		logger.info("------------5.返回结果-------------");
		logger.info("------------Bye offShelvesGoods! -------------");
		return "goods";
	}

	/**
	 * 商品管理上架商品信息
	 */
	@RequestMapping(value = "/onShelvesGoods", method = RequestMethod.POST)
	public String onShelvesGoods(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("------------Welcome offShelvesGoods! -------------");
		logger.info("------------1.初始化-------------");
		TbGoods tbGoods = new TbGoods();
		logger.info("------------2.获取参数-------------");
		String goodsId = request.getParameter("goodsId");
		logger.info("------------3.数据校验-------------");
		if (null != goodsId && goodsId.length() > 0) {
			tbGoods.setGoodsId(Integer.parseInt(goodsId));
		}
		logger.info("------------4.业务处理-------------");
		// 逻辑删除 修改状态为 01-正常 （00-失效 01-正常 02-下架 99-异常）
		tbGoods.setGoodsStatus("01");
		int res = goodsBusiness.goodsModify(tbGoods);
		toString();
		logger.info(String.valueOf(res));
		logger.info("------------5.返回结果-------------");
		logger.info("------------Bye offShelvesGoods! -------------");
		return "goods";
	}
	
	/**
	 * 商品管理修改商品信息
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String goodsModify(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("------------Welcome goods!-------------");
		logger.info("------------1.初始化-------------");
		TbGoods tbGoods = new TbGoods();
		logger.info("------------2.获取参数-------------");
		String goodsId = request.getParameter("modify_goodsId") == "" ? null : request.getParameter("modify_goodsId");
		String goodsName = request.getParameter("modify_goodsName") == "" ? null : request.getParameter("modify_goodsName");
		String goodsCode = request.getParameter("modify_goodsCode") == null ? request.getParameter("modify_goodsName") : request.getParameter("modify_goodsCode");
		String goodsVersion = request.getParameter("modify_goodsVersion") == "" ? null : request.getParameter("modify_goodsVersion");
		String goodsUnit = request.getParameter("modify_goodsUnit") == "" ? null : request.getParameter("modify_goodsUnit");
		String goodsBarCode = request.getParameter("modify_goodsBarCode") == "" ? null : request.getParameter("modify_goodsBarCode");
		String goodsCurrentStock = request.getParameter("modify_goodsCurrentStock") == "" ? null : request.getParameter("modify_goodsCurrentStock");
		String goodsTotalStock = request.getParameter("modify_goodsTotalStock") == "" ? null : request.getParameter("modify_goodsTotalStock");
//				String goodsProductionDate = request.getParameter("modify_goodsProductionDate") == "" ? null : request.getParameter("modify_goodsProductionDate");
//				String goodsExpirationDate = request.getParameter("modify_goodsExpirationDate") == "" ? null : request.getParameter("modify_goodsExpirationDate");
		String goodsShelfLife = request.getParameter("modify_goodsShelfLife") == "" ? null : request.getParameter("modify_goodsShelfLife");
		String goodsProfit = request.getParameter("modify_goodsProfit") == "" ? null : request.getParameter("modify_goodsProfit");
		String goodsPrice = request.getParameter("modify_goodsPrice") == "" ? null : request.getParameter("modify_goodsPrice");
		String goodsPrizePoolRatio = request.getParameter("modify_goodsPrizePoolRatio") == "" ? null : request.getParameter("modify_goodsPrizePoolRatio");
		String goodsType = request.getParameter("modify_goodsType") == "" ? null : request.getParameter("modify_goodsType");
		String goodsStatus = request.getParameter("modify_goodsStatus") == "" ? null : request.getParameter("modify_goodsStatus");
//				String goodsCreatetime = request.getParameter("modify_goodsCreatetime") == "" ? null : request.getParameter("modify_goodsCreatetime");
//				String goodsModifytime = request.getParameter("modify_goodsModifytime") == "" ? null : request.getParameter("modify_goodsModifytime");
//				String goodsEndtime = request.getParameter("modify_goodsEndtime") == "" ? null : request.getParameter("modify_goodsEndtime");
		String providerId = request.getParameter("modify_providerId") == "" ? null : request.getParameter("modify_providerId");
		String providerName = request.getParameter("modify_providerName") == "" ? null : request.getParameter("modify_providerName");
		String providerCode = request.getParameter("modify_providerCode") == "" ? null : request.getParameter("modify_providerCode");
		String remark = request.getParameter("modify_remark") == "" ? null : request.getParameter("modify_remark");
		String goodsDiscount = request.getParameter("modify_goodsDiscount") == "" ? null : request.getParameter("modify_goodsDiscount");
		String quarterRebate = request.getParameter("modify_quarterRebate") == "" ? null : request.getParameter("modify_quarterRebate");
		String annualRebate = request.getParameter("modify_annualRebate") == "" ? null : request.getParameter("modify_annualRebate");
		String providerSubsidy = request.getParameter("modify_providerSubsidy") == "" ? null : request.getParameter("modify_providerSubsidy");
		String providerPackageSubsidy = request.getParameter("modify_providerPackageSubsidy") == "" ? null : request.getParameter("modify_providerPackageSubsidy");
		String customerSubsidy = request.getParameter("modify_customerSubsidy") == "" ? null : request.getParameter("modify_customerSubsidy");
		String otherSubsidy = request.getParameter("modify_otherSubsidy") == "" ? null : request.getParameter("modify_otherSubsidy");
		String goodsActualCost = request.getParameter("modify_goodsActualCost") == "" ? null : request.getParameter("modify_goodsActualCost");
		String storagePrewarning = request.getParameter("modify_storagePrewarning") == "" ? null : request.getParameter("modify_storagePrewarning");
		String shelfLifePrewarning = request.getParameter("modify_shelfLifePrewarning") == "" ? null : request.getParameter("modify_shelfLifePrewarning");

		Date goodsModifytime = new Date();


		logger.info("------------3.数据校验-------------");
		if (null != goodsId && goodsId.length() > 0) {
			tbGoods.setGoodsId(Integer.parseInt(goodsId));
		}
		tbGoods.setGoodsName(goodsName);
		tbGoods.setGoodsCode(goodsCode);
		if (null != goodsVersion && goodsVersion.length() > 0) {
			tbGoods.setGoodsVersion(Integer.parseInt(goodsVersion));
		}
		tbGoods.setGoodsUnit(goodsUnit);
		tbGoods.setGoodsBarCode(goodsBarCode);
		if (null != goodsCurrentStock && goodsCurrentStock.length() > 0) {
			tbGoods.setGoodsCurrentStock(Integer.parseInt(goodsCurrentStock));
		}
		if (null != goodsTotalStock && goodsTotalStock.length() > 0) {
			tbGoods.setGoodsTotalStock(Integer.parseInt(goodsTotalStock));
		}
		if (null != goodsShelfLife && goodsShelfLife.length() > 0) {
			tbGoods.setGoodsShelfLife(Integer.parseInt(goodsShelfLife));
		}
		if (null != goodsProfit && goodsProfit.length() > 0) {
			tbGoods.setGoodsProfit(goodsProfit);
		}
		if (null != goodsPrice && goodsPrice.length() > 0) {
			tbGoods.setGoodsPrice(goodsPrice);

		}
		if (null != goodsPrizePoolRatio && goodsPrizePoolRatio.length() > 0) {
			tbGoods.setGoodsPrizePoolRatio(goodsPrizePoolRatio);
		}
		tbGoods.setGoodsType(goodsType);
		tbGoods.setGoodsStatus(goodsStatus);
//				tbGoods.setGoodsCreatetime(goodsCreatetime);
		tbGoods.setGoodsModifytime(goodsModifytime);
//				tbGoods.setGoodsEndtime(goodsEndtime);
		if (null != providerId && providerId.length() > 0) {
			tbGoods.setProviderId(Integer.parseInt(providerId));
		}
		tbGoods.setProviderName(providerName);
		tbGoods.setProviderCode(providerCode);
		tbGoods.setRemark(remark);
		if (null != goodsDiscount && goodsDiscount.length() > 0) {
			tbGoods.setGoodsDiscount(goodsDiscount);
		}
		if (null != quarterRebate && quarterRebate.length() > 0) {
			tbGoods.setQuarterRebate(quarterRebate);
		}
		if (null != annualRebate && annualRebate.length() > 0) {
			tbGoods.setAnnualRebate(annualRebate);
		}
		if (null != providerSubsidy && providerSubsidy.length() > 0) {
			tbGoods.setProviderSubsidy(providerSubsidy);
		}
		if (null != providerPackageSubsidy && providerPackageSubsidy.length() > 0) {
			tbGoods.setProviderPackageSubsidy(providerPackageSubsidy);
		}
		if (null != customerSubsidy && customerSubsidy.length() > 0) {
			tbGoods.setCustomerSubsidy(customerSubsidy);
		}
		if (null != otherSubsidy && otherSubsidy.length() > 0) {
			tbGoods.setOtherSubsidy(otherSubsidy);
		}
		if (null != goodsActualCost && goodsActualCost.length() > 0) {
			tbGoods.setGoodsActualCost(goodsActualCost);
		}
		if (null != storagePrewarning && storagePrewarning.length() > 0) {
			tbGoods.setStorageWarning(Integer.parseInt(storagePrewarning));
		}
		if (null != shelfLifePrewarning && shelfLifePrewarning.length() > 0) {
			tbGoods.setShelfLifeWarning(Integer.parseInt(shelfLifePrewarning));
		}
		tbGoods.setGoodsStatus("01"); // 新增状态为正常的记录 00-失效 01-正常 99-异常
		logger.info("------------4.业务处理-------------");
		int res = goodsBusiness.goodsModify(tbGoods);
		toString();
		logger.info(String.valueOf(res));
		logger.info("------------5.返回结果-------------");
		logger.info("------------Bye goods!-------------");
		return "goods";
	}

	/**
	 * 商品管理修改查询商品信息
	 */
	@RequestMapping(value = "/queryGoods", method = RequestMethod.POST)
	public @ResponseBody List<TbGoods> goodsQuery(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("------------Welcome queryGoods!-------------");
		logger.info("------------1.初始化-------------");
		List<TbGoods> tbGoodss  = new ArrayList<TbGoods>();
		TbGoodsExample tbGoodsExample = new TbGoodsExample();
		TbGoodsExample.Criteria criteria = tbGoodsExample.createCriteria();
		logger.info("------------2.获取参数-------------");
		String goodsId = request.getParameter("goodsId");
		logger.info("------------3.数据校验-------------");
		if (null != goodsId && goodsId.length() > 0) {
			criteria.andGoodsIdEqualTo(Integer.parseInt(goodsId));
		}
		logger.info("------------4.业务处理-------------");
		// 只查询状态为正常的记录 （00-失效 01-正常 02-下架 99-异常）
		criteria.andGoodsStatusNotEqualTo("00");
		tbGoodss = goodsBusiness.goodsQuery(tbGoodsExample);
		request.setAttribute("tbGoodss", tbGoodss);
		logger.info("------------5.返回结果-------------");
		logger.info("------------Bye queryGoods!-------------");
		if(tbGoodss.isEmpty()){
			TbGoods tbGoods = new TbGoods();
			tbGoods.setGoodsId(0);
			tbGoodss.add(tbGoods);
			return tbGoodss;
		}
		return tbGoodss;
	}
	
	@RequestMapping(value = "/goodsReportExecl")
	public View goodsReportExecl(Model model, HttpServletRequest request) {
		logger.info("------------Welcome goodsReportExecl page!-------------");
		logger.info("------------以 Apache POI 实现 AbstractExcelView-------------");
		View Excelview = new AbstractExcelView() {
			@Override
			public void buildExcelDocument(@SuppressWarnings("rawtypes") Map map, HSSFWorkbook workbook,
					HttpServletRequest request, HttpServletResponse response)
					throws Exception {
				logger.info("------------Welcome goods page!-------------");
				logger.info("------------0.权限管理！-------------");	
				logger.info("------------1.初始化！-------------");
				List<TbGoods> goodss =new ArrayList<TbGoods>();
				TbGoodsExample tbGoodsExample = new TbGoodsExample();
				TbGoodsExample.Criteria criteria = tbGoodsExample.createCriteria();
				List<TbSystemParameter> tbSystemParameters = new ArrayList<TbSystemParameter>();
				TbSystemParameterExample tbSystemParameterExample =new TbSystemParameterExample();
				TbSystemParameterExample.Criteria tbSystemParameterCriteria = tbSystemParameterExample.createCriteria();
				
				logger.info("------------2.获取参数-------------");
				String query_goodsName = request.getParameter("query_goodsName") == "" ? null
						: request.getParameter("query_goodsName");
				String query_goodsType = request.getParameter("query_goodsType") == "" ? null
						: request.getParameter("query_goodsType");
				String query_goodsPrice = request.getParameter("query_goodsPrice") == "" ? null
						: request.getParameter("query_goodsPrice");
				String query_goodsShelfLife = request
						.getParameter("query_goodsShelfLife") == "" ? null : request
						.getParameter("query_goodsShelfLife");
				logger.info("------------3.数据校验-------------");
				if ( null != query_goodsName && query_goodsName.length() > 0) {
					query_goodsName = "%" + query_goodsName + "%";
					criteria.andGoodsNameLike(query_goodsName);
				}
				if (null != query_goodsType && query_goodsType.length() > 0) {
					if (!query_goodsType.equals("0")) {
						criteria.andGoodsTypeEqualTo(query_goodsType);
					}
				}
				if (null != query_goodsPrice && query_goodsPrice.length() > 0) {
					criteria.andGoodsPriceEqualTo(query_goodsPrice);
				}
				if (null != query_goodsShelfLife && query_goodsShelfLife.length() > 0) {
					criteria.andGoodsShelfLifeEqualTo(
							Integer.parseInt(query_goodsShelfLife));
				}
				logger.info("------------4.业务处理开始-------------");
				// 只查询状态为正常的记录 00-失效 01-正常 99-异常
				criteria.andGoodsStatusNotEqualTo("00");
				goodss = goodsBusiness.goodsQuery(tbGoodsExample);
				logger.info("------------4.1.转译商品类型-------------");
				for (TbGoods tbGoods : goodss) {
					if (tbGoods.getGoodsType() == null && "".equals(tbGoods.getGoodsType()) ) {
					} else {
						tbGoods.setGoodsType(systemParameterBussinessImpl.getSystemParameterPrizePool(Integer.parseInt(tbGoods.getGoodsType())).getPpDesc());
					}
				}
				logger.info("------------4.2.转译基本单位-------------");
				for (TbGoods tbGoods : goodss) {
					if (tbGoods.getGoodsUnit() == null) {
					} else {
						tbGoods.setGoodsUnit(systemParameterBussinessImpl.getSystemParameterPrizePool(Integer.parseInt(tbGoods.getGoodsUnit())).getPpDesc());
					}
				}
				logger.info("------------4.3.获取商品类型-------------");
				tbSystemParameterCriteria.andPStatusEqualTo("01");
				tbSystemParameterCriteria.andPValueEqualTo("GoodsType");
				tbSystemParameters = systemParameterBussinessImpl.selectByExample(tbSystemParameterExample);
				logger.info("------------4.业务处理完成-------------");
				logger.info("------------5.返回结果-------------");



				logger.info("------------建立 Excel -Sheet-------------");
				HSSFSheet sheet = workbook.createSheet("供应商清单");
				logger.info("------------设置行列的默认宽度和高度-------------");
				int idx = 0;
				sheet.setColumnWidth(idx++, 32 * 80);// 对A列设置宽度为180像素
				sheet.setColumnWidth(idx++, 32 * 180);
				sheet.setColumnWidth(idx++, 32 * 80);
				sheet.setColumnWidth(idx++, 32 * 80);
				sheet.setColumnWidth(idx++, 32 * 80);
				sheet.setColumnWidth(idx++, 32 * 80);
				sheet.setColumnWidth(idx++, 32 * 180);
				sheet.setColumnWidth(idx++, 32 * 180);
				sheet.setColumnWidth(idx++, 32 * 180);
				sheet.setColumnWidth(idx++, 32 * 180);
				sheet.setColumnWidth(idx++, 32 * 180);
				sheet.setColumnWidth(idx++, 32 * 180);
				
				int rowNum = 0;
				idx = 0;
				logger.info("------------建立标题-------------");
				HSSFRow header = sheet.createRow(rowNum++);
				header.createCell(idx++).setCellValue("编号");
				header.createCell(idx++).setCellValue("名称");
				header.createCell(idx++).setCellValue("编码");
				header.createCell(idx++).setCellValue("类型");
				header.createCell(idx++).setCellValue("基本单位");
				header.createCell(idx++).setCellValue("进货价格");
				header.createCell(idx++).setCellValue("销售价格");
				header.createCell(idx++).setCellValue("奖金池折扣（%）");
				header.createCell(idx++).setCellValue("保质期");
				header.createCell(idx++).setCellValue("保质期预警");
				header.createCell(idx++).setCellValue("库存量预警");
				header.createCell(idx++).setCellValue("当前状态");
				header.createCell(idx++).setCellValue("商品添加时间");
				header.createCell(idx++).setCellValue("商品修改时间");
				header.createCell(idx++).setCellValue("备注");
				logger.info("------------输出内容-------------");
				HSSFRow row;
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");  

				for (TbGoods tbGoods : goodss) {
					idx = 0;
					row = sheet.createRow(rowNum++);
					row.createCell(idx++).setCellValue(tbGoods.getGoodsId());
					row.createCell(idx++).setCellValue(tbGoods.getGoodsName());
					row.createCell(idx++).setCellValue(tbGoods.getGoodsCode());
					row.createCell(idx++).setCellValue(tbGoods.getGoodsType());
					row.createCell(idx++).setCellValue(tbGoods.getGoodsUnit());
					row.createCell(idx++).setCellValue(tbGoods.getGoodsActualCost());
					row.createCell(idx++).setCellValue(tbGoods.getGoodsPrice());
					row.createCell(idx++).setCellValue(tbGoods.getGoodsPrizePoolRatio());
					row.createCell(idx++).setCellValue(tbGoods.getGoodsShelfLife());
					row.createCell(idx++).setCellValue(tbGoods.getShelfLifeWarning());
					row.createCell(idx++).setCellValue(tbGoods.getStorageWarning());
					if ("01"==tbGoods.getGoodsStatus()) {
						row.createCell(idx++).setCellValue("上架销售中");
					} else if ("02"==tbGoods.getGoodsStatus()) {
						row.createCell(idx++).setCellValue("下架中");
					} 
					row.createCell(idx++).setCellValue(tbGoods.getGoodsStatus());
					row.createCell(idx++).setCellValue(sdf.format(tbGoods.getGoodsCreatetime()));
					if (null !=tbGoods.getGoodsCreatetime()) {						
						row.createCell(idx++).setCellValue(sdf.format(tbGoods.getGoodsModifytime()));
					}else {
						row.createCell(idx++).setCellValue("无");
					}
					row.createCell(idx++).setCellValue(tbGoods.getRemark());
//					row.createCell(idx++).setCellValue(tbGoods.get);
//					row.createCell(idx++).setCellValue(tbProvider.get);
				}
			}
		};
		logger.info("------------5.返回结果-------------");
		logger.info("------------回传 View 对象，返回生成的 Excel 档-------------");
		logger.info("------------Bye goodsReportExecl page!-------------");
		return Excelview;
	}
	
	
	/////////////////////////////////////
	/////////////////////////////////////
	/////////////////////////////////////
	/////////////////////////////////////
	/////////////////////////////////////
	/**
	 * 商品管理-查询商品与客户信息
	 */
	@RequestMapping(value = "/queryGoods2Customer", method = RequestMethod.POST)
	public @ResponseBody List<TbGoods2customer> queryGoods2Customer(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("------------Welcome queryGoods!-------------");
		logger.info("------------1.初始化-------------");
		List<TbGoods2customer> tbGoods2customers = new ArrayList<TbGoods2customer>();
		TbGoods2customerExample tbGoods2customerExample = new TbGoods2customerExample();
		TbGoods2customerExample.Criteria criteria = tbGoods2customerExample.createCriteria();
		logger.info("------------2.获取参数-------------");
		String goodsId = request.getParameter("goodsId");
		logger.info("------------3.数据校验-------------");
		if (null != goodsId && goodsId.length() > 0) {
			criteria.andGoodsIdEqualTo(Integer.parseInt(goodsId));
		}
		logger.info("------------4.业务处理-------------");
		// 只查询状态为正常的记录 （00-失效 01-正常 02-下架 99-异常）
//		criteria.andGoodsStatusNotEqualTo("00");
		tbGoods2customers = goods2CustomerBusiness.goods2CustomerQuery(tbGoods2customerExample);
		request.setAttribute("tbGoodss", tbGoods2customers);
		logger.info("------------5.返回结果-------------");
		if (tbGoods2customers == null || tbGoods2customers.isEmpty()) {
			TbGoods2customer tbGoods2customer = new TbGoods2customer();
			tbGoods2customer.setGoods2customerId(0);
			tbGoods2customer.setCustomerName("Error");
			tbGoods2customers = new ArrayList<TbGoods2customer>();
			tbGoods2customers.add(tbGoods2customer);
			logger.info("------------Bye queryGoods!-------------");
			return tbGoods2customers;
		}
		logger.info("------------Bye queryGoods!-------------");
		return tbGoods2customers;
	}
	
	
	/**
	 * 商品管理-添加商品与客户信息--1.查询客户信息
	 */
	@RequestMapping(value = "/addGoods2Customer", method = RequestMethod.POST)
	public @ResponseBody List<TbCustomer> addGoods2Customer(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("------------Welcome queryGoods!-------------");
		logger.info("------------1.初始化-------------");
		List<TbCustomer> tbCustomers = new ArrayList<TbCustomer>();
		TbCustomerExample tbCustomerExample = new TbCustomerExample();
		TbCustomerExample.Criteria criteria = tbCustomerExample.createCriteria();
		logger.info("------------2.获取参数-------------");

		logger.info("------------3.数据校验-------------");

		logger.info("------------4.业务处理-------------");
		// 只查询状态为正常的记录 （00-失效 01-正常 02-下架 99-异常）
		criteria.andStatusNotEqualTo("00");
		tbCustomers = goods2CustomerBusiness.customerListQuery(tbCustomerExample);
		logger.info("------------5.返回结果-------------");
		if (tbCustomers == null || tbCustomers.isEmpty()) {
			tbCustomers = new ArrayList<TbCustomer>();
			logger.info("------------Bye queryGoods!-------------");
			return tbCustomers;
		}	
		request.setAttribute("tbCustomers", tbCustomers);
		logger.info("------------Bye queryGoods!-------------");
		return tbCustomers;
	}
	
	
	/**
	 * 商品管理-添加商品与客户信息--2.保存新增或修改的商品与客户信息
	 */
	@RequestMapping(value = "/Goods2CustomerSave", method = RequestMethod.POST)
	public @ResponseBody int Goods2CustomerSave(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("------------Welcome Goods2CustomerSave!-------------");
		logger.info("------------1.初始化-------------");
		List<TbGoods2customer> tbGoods2CustomersInsert = new ArrayList<TbGoods2customer>();
		List<TbGoods2customer> tbGoods2CustomersUpdate = new ArrayList<TbGoods2customer>();
		int tbGoods2CustomersInsertnum = 0;
		int tbGoods2CustomersUpdatenum = 0;
		logger.info("------------2.获取参数-------------");
		String goodsId = request.getParameter("goodsId") == "" ? null : request.getParameter("goodsId");
		String[] goods2customerId = request.getParameterValues("goods2customerId");
		String[] customerId = request.getParameterValues("customerId");
		String[] goodsPrice = request.getParameterValues("goodsPrice");
		String[] goodsPrizePoolRatio = request.getParameterValues("goodsPrizePoolRatio");
		logger.info("------------3.数据校验-------------");
		logger.info("------------4.业务处理-------------");
		for (int i = 0; i < goods2customerId.length; i++) {
			TbGoods2customer tbGoods2customer = new TbGoods2customer();
			tbGoods2customer.setGoodsId(Integer.parseInt(goodsId));
			tbGoods2customer.setCustomerId(Integer.parseInt(customerId[i]));
			tbGoods2customer.setGoodsPrice(goodsPrice[i]);
			tbGoods2customer.setGoodsPrizePoolRatio(goodsPrizePoolRatio[i]);
			if (goods2customerId[i].isEmpty()) {
				tbGoods2CustomersInsert.add(tbGoods2customer);
			}else {
				tbGoods2customer.setGoods2customerId(Integer.parseInt(goods2customerId[i]));
				tbGoods2CustomersUpdate.add(tbGoods2customer);
			}
		}
		tbGoods2CustomersInsertnum = goods2CustomerBusiness.insertGoods2CustomerInfo(tbGoods2CustomersInsert);
		logger.info("------------新增了：+ "+tbGoods2CustomersInsertnum +"条记录-------------");
		tbGoods2CustomersUpdatenum = goods2CustomerBusiness.updateGoods2CustomerInfo(tbGoods2CustomersUpdate);
		logger.info("------------更新了：+ "+tbGoods2CustomersUpdatenum +"条记录-------------");

		logger.info("------------5.返回结果-------------");
		return tbGoods2CustomersUpdatenum+tbGoods2CustomersInsertnum;
	}

	/**
	 * 商品管理-删除商品与客户信息--1.查询客户信息
	 */
	@RequestMapping(value = "/deleteGoods2Customer", method = RequestMethod.POST)
	public @ResponseBody int deleteGoods2Customer(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("------------Welcome Goods2CustomerSave!-------------");
		logger.info("------------1.初始化-------------");
		TbGoods2customer tbGoods2customer = new TbGoods2customer();
		int tbGoods2CustomerDeleteNum = 0; 
		logger.info("------------2.获取参数-------------");
		String goods2customerId = request.getParameter("goods2customerId") == "" ? null : request
				.getParameter("goods2customerId");
		logger.info("------------3.数据校验-------------");
		
		logger.info("------------4.业务处理-------------");
		if (goods2customerId == null ||goods2customerId.isEmpty()) {
		} else {
			tbGoods2customer.setGoods2customerId(Integer.parseInt(goods2customerId));
		}
		tbGoods2CustomerDeleteNum= goods2CustomerBusiness.deleteGoods2CustomerInfo(tbGoods2customer);
		logger.info("------------删除了：+ " + tbGoods2CustomerDeleteNum+ "条记录-------------");
		logger.info("------------5.返回结果-------------");
		return tbGoods2CustomerDeleteNum;
	}
	
	@ExceptionHandler(Exception.class)
	public String exception(Exception e, HttpServletRequest request) {
		request.setAttribute("exception", e);
		return "error";
	}

}
