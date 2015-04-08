package com.ai.psims.web.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.psims.web.business.IGoodsBusiness;
import com.ai.psims.web.model.TbGoods;
import com.ai.psims.web.model.TbGoodsExample;

/**
 * 客户管理Controller
 */
@Controller
@RequestMapping("/goodsController")
public class GoodsController extends BaseController {

	private static final Logger logger = LoggerFactory
			.getLogger(GoodsController.class);

	@Resource(name = "goodsBusinessImpl")
	private IGoodsBusiness goodsBusiness;

	/**
	 * 客户管理页面跳转
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goodsRedirectGET(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "redirect:/goodsController/goods";
	}

	/**
	 * 客户管理页面跳转
	 */
	@RequestMapping(value = "/goods", method = RequestMethod.GET)
	public String goodsRedirect(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("------------Welcome goods page!-------------");
		// 1.初始化
		List<TbGoods> goodss;
		TbGoodsExample tbGoodsExample = new TbGoodsExample();
		// 2.获取参数
		String query_goodsName = request.getParameter("query_goodsName") == "" ? null
				: request.getParameter("query_goodsName");
		String query_goodsType = request.getParameter("query_goodsType") == "" ? null
				: request.getParameter("query_goodsType");
		String query_goodsPrice = request.getParameter("query_goodsPrice") == "" ? null
				: request.getParameter("query_goodsPrice");
		String query_goodsShelfLife = request
				.getParameter("query_goodsShelfLife") == "" ? null : request
				.getParameter("query_goodsShelfLife");
		// 3.数据校验
		if (query_goodsName != null && query_goodsName.length() > 0) {
			query_goodsName = "%" + query_goodsName + "%";
			tbGoodsExample.createCriteria().andGoodsNameLike(query_goodsName);
		}
		if (query_goodsType != null && query_goodsType.length() > 0) {
			if (!query_goodsType.equals("0")) {
				tbGoodsExample.createCriteria().andGoodsTypeEqualTo(
						query_goodsType);
			}
		}
		if (query_goodsPrice != null && query_goodsPrice.length() > 0) {
			tbGoodsExample.createCriteria().andGoodsPriceEqualTo(
					Long.parseLong(query_goodsPrice));
		}
		if (query_goodsShelfLife != null && query_goodsShelfLife.length() > 0) {
			tbGoodsExample.createCriteria().andGoodsShelfLifeEqualTo(
					Integer.parseInt(query_goodsShelfLife));
		}

		// 4.业务处理
		// 只查询状态为正常的记录 00-失效 01-正常 99-异常
		tbGoodsExample.createCriteria().andGoodsStatusEqualTo("01");
		goodss = goodsBusiness.goodsQuery(tbGoodsExample);
		// 5.返回结果
		request.setAttribute("goodss", goodss);

		logger.info("------------Bye goods page!-------------");
		return "goods";
	}

	/**
	 * 客户管理新增客户信息
	 */
	@RequestMapping(value = "/addGoods", method = RequestMethod.POST)
	public String tbGoods(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("------------Welcome goods add info!-------------");
		// 1.初始化
		TbGoods goodsadd = new TbGoods();
		// 2.获取参数
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
		String goodsDiscountAmount = request.getParameter("goodsDiscountAmount") == "" ? null : request.getParameter("goodsDiscountAmount");
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
		String storageWarning = request.getParameter("storageWarning") == "" ? null : request.getParameter("storageWarning");
		String shelfLifeWarning = request.getParameter("shelfLifeWarning") == "" ? null : request.getParameter("shelfLifeWarning");

		Date goodsCreatetime = new Date();

		// 3.数据校验
		goodsadd.setGoodsName(goodsName);
		goodsadd.setGoodsCode(goodsCode);
		goodsadd.setGoodsVersion(Integer.parseInt(goodsVersion));
		goodsadd.setGoodsUnit(goodsUnit);
		goodsadd.setGoodsBarCode(goodsBarCode);
		goodsadd.setGoodsCurrentStock(Integer.parseInt(goodsCurrentStock));
		goodsadd.setGoodsTotalStock(Integer.parseInt(goodsTotalStock));
//		goodsadd.setGoodsProductionDate(Date.parse(goodsProductionDate));
//		goodsadd.setGoodsExpirationDate(Date.parse(goodsExpirationDate);
		goodsadd.setGoodsShelfLife(Integer.parseInt(goodsShelfLife));
		goodsadd.setGoodsProfit(Long.parseLong(goodsProfit));
		goodsadd.setGoodsPrice(Long.parseLong(goodsPrice));
		goodsadd.setGoodsDiscountAmount(Long.parseLong(goodsDiscountAmount));
		goodsadd.setGoodsType(goodsType);
		goodsadd.setGoodsStatus(goodsStatus);
		goodsadd.setGoodsCreatetime(goodsCreatetime);
//		goodsadd.setGoodsModifytime(goodsModifytime);
//		goodsadd.setGoodsEndtime(goodsEndtime);
		goodsadd.setProviderId(Integer.parseInt(providerId));
		goodsadd.setProviderName(providerName);
		goodsadd.setProviderCode(providerCode);
		goodsadd.setRemark(remark);
		goodsadd.setGoodsDiscount(Integer.parseInt(goodsDiscount));
		goodsadd.setQuarterRebate(Long.parseLong(quarterRebate));
		goodsadd.setAnnualRebate(Long.parseLong(annualRebate));
		goodsadd.setProviderSubsidy(Long.parseLong(providerSubsidy));
		goodsadd.setProviderPackageSubsidy(Long.parseLong(providerPackageSubsidy));
		goodsadd.setCustomerSubsidy(Long.parseLong(customerSubsidy));
		goodsadd.setOtherSubsidy(Long.parseLong(otherSubsidy));
		goodsadd.setGoodsActualCost(Long.parseLong(goodsActualCost));
		goodsadd.setStorageWarning(Integer.parseInt(storageWarning));
		goodsadd.setShelfLifeWarning(Integer.parseInt(shelfLifeWarning));
		goodsadd.setGoodsStatus("01"); // 新增状态为正常的记录 00-失效 01-正常 99-异常
		// 4.业务处理
		int res = goodsBusiness.goodsAdd(goodsadd);
		toString();
		logger.info(String.valueOf(res));
		// 5.返回结果
		logger.info("------------Bye goods add info! -------------");
		return "goods";
	}

	/**
	 * 客户管理删除客户信息
	 */
	@RequestMapping(value = "/deleteGoods", method = RequestMethod.POST)
	public String goodsDelete(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("------------Welcome deletegoods! -------------");
		// 1.初始化
		TbGoods tbGoods = new TbGoods();
		// 2.获取参数
		String goods_id = request.getParameter("goods_id");
		// 3.数据校验
		if (goods_id != null && goods_id.length() > 0) {
			tbGoods.setGoodsId(Integer.parseInt(goods_id));
		}
		// 4.业务处理
		// 逻辑删除 修改状态为 00-失效 （记录状态 00-失效 01-正常 99-异常）
		tbGoods.setGoodsStatus("00");
		int res = goodsBusiness.goodsModify(tbGoods);
		toString();
		logger.info(String.valueOf(res));

		// --弃用-- 改为逻辑删除
		// int res = goodsBusiness.goodsDelete(tbGoodsExample);
		// toString();
		// logger.info(String.valueOf(res));
		// 5.返回结果
		logger.info("------------Bye deletegoods! -------------");
		return "goods";
	}

	/**
	 * 客户管理修改客户信息
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String goodsModify(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("------------Welcome goods!-------------");
		// 1.初始化
		TbGoods tbGoods = new TbGoods();

		// 2.获取参数
		String goods_id = request.getParameter("modify_goodsId");
		String goods_name = request.getParameter("modify_goodsName");
		String goods_code = request.getParameter("modify_goods_code") == null ? request
				.getParameter("modify_goodsName") : request
				.getParameter("modify_goods_code");
		String contact_name = request.getParameter("modify_contactName");
		String contact_tel = request.getParameter("modify_contactTel");
		String contact_addr = request.getParameter("modify_contactAddr");
		String email = request.getParameter("modify_email");
		String area = request.getParameter("modify_area");
		String goods_type = request.getParameter("modify_goodsType");
		// String createtime_str = request.getParameter("createtime");
		// String modifytime_str = request.getParameter("modifytime");
		// String endtime_str = request.getParameter("endtime");
		// String status = request.getParameter("modify_status");
		String remark = request.getParameter("modify_remark");
		Date modifytime = new Date();

		// 3.数据校验
		if (goods_id != null && goods_id.length() > 0) {
			tbGoods.setGoodsId(Integer.parseInt(goods_id));
		}
		tbGoods.setGoodsName(goods_name);
		tbGoods.setGoodsCode(goods_code);
//		tbGoods.setContactName(contact_name);
//		tbGoods.setContactTel(contact_tel);
//		tbGoods.setContactAddr(contact_addr);
//		tbGoods.setEmail(email);
//		tbGoods.setArea(area);
//		tbGoods.setGoodsType(goods_type);
//		tbGoods.setModifytime(modifytime);
		// tbGoods.setStatus("01");
		tbGoods.setRemark(remark);
		// 4.业务处理
		int res = goodsBusiness.goodsModify(tbGoods);
		toString();
		logger.info(String.valueOf(res));
		// 5.返回结果
		logger.info("------------Bye goods!-------------");
		return "goods";
	}

	/**
	 * 客户管理修改查询客户信息
	 */
	@RequestMapping(value = "/queryGoods", method = RequestMethod.POST)
	public @ResponseBody List<TbGoods> goodsQuery(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("------------Welcome queryGoods!-------------");
		// 1.初始化
		List<TbGoods> tbGoodss;
		TbGoodsExample tbGoodsExample = new TbGoodsExample();
		int goodsid = 0;
		// 2.获取参数
		String goods_id = request.getParameter("goods_id");
		// 3.数据校验
		if (goods_id != null && goods_id.length() > 0) {
			goodsid = Integer.parseInt(goods_id);
			tbGoodsExample.createCriteria().andGoodsIdEqualTo(goodsid);
		}
		// 4.业务处理
		// 只查询状态为正常的记录 （00-失效 01-正常 99-异常）
		tbGoodsExample.createCriteria().andGoodsStatusEqualTo("01");
		tbGoodss = goodsBusiness.goodsQuery(tbGoodsExample);
		request.setAttribute("tbGoodss", tbGoodss);
		// 5.返回结果
		logger.info("------------Bye queryGoods!-------------");
		return tbGoodss;
	}

	@ExceptionHandler(Exception.class)
	public String exception(Exception e, HttpServletRequest request) {
		request.setAttribute("exception", e);
		return "error";
	}

}
