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
//import com.ai.psims.web.model.TbGoodsExample.Criteria;

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
		TbGoodsExample.Criteria criteria = tbGoodsExample.createCriteria();

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
			criteria.andGoodsNameLike(query_goodsName);
		}
		if (query_goodsType != null && query_goodsType.length() > 0) {
			if (!query_goodsType.equals("0")) {
				criteria.andGoodsTypeEqualTo(query_goodsType);
			}
		}
		if (query_goodsPrice != null && query_goodsPrice.length() > 0) {
			criteria.andGoodsPriceEqualTo(
					Long.parseLong(query_goodsPrice));
		}
		if (query_goodsShelfLife != null && query_goodsShelfLife.length() > 0) {
			criteria.andGoodsShelfLifeEqualTo(
					Integer.parseInt(query_goodsShelfLife));
		}

		// 4.业务处理
		// 只查询状态为正常的记录 00-失效 01-正常 99-异常
		criteria.andGoodsStatusEqualTo("01");
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
		String storagePrewarning = request.getParameter("storagePrewarning") == "" ? null : request.getParameter("storagePrewarning");
		String shelfLifePrewarning = request.getParameter("shelfLifePrewarning") == "" ? null : request.getParameter("shelfLifePrewarning");

		Date goodsCreatetime = new Date();

		// 3.数据校验
		goodsadd.setGoodsName(goodsName);
		goodsadd.setGoodsCode(goodsCode);
		if (goodsVersion != null && goodsVersion.length() > 0) {
			goodsadd.setGoodsVersion(Integer.parseInt(goodsVersion));
		}
		goodsadd.setGoodsUnit(goodsUnit);
		goodsadd.setGoodsBarCode(goodsBarCode);
		if (goodsCurrentStock != null && goodsCurrentStock.length() > 0) {
			goodsadd.setGoodsCurrentStock(Integer.parseInt(goodsCurrentStock));
		}
		if (goodsTotalStock != null && goodsTotalStock.length() > 0) {
			goodsadd.setGoodsTotalStock(Integer.parseInt(goodsTotalStock));
		}
//		goodsadd.setGoodsProductionDate(Date.parse(goodsProductionDate));
//		goodsadd.setGoodsExpirationDate(Date.parse(goodsExpirationDate);
		if (goodsShelfLife != null && goodsShelfLife.length() > 0) {
			goodsadd.setGoodsShelfLife(Integer.parseInt(goodsShelfLife));
		}
		if (goodsProfit != null && goodsProfit.length() > 0) {
			goodsadd.setGoodsProfit(Long.parseLong(goodsProfit));
		}
		if (goodsPrice != null && goodsPrice.length() > 0) {
			goodsadd.setGoodsPrice(Long.parseLong(goodsPrice));
		}
		if (goodsDiscountAmount != null && goodsDiscountAmount.length() > 0) {
			goodsadd.setGoodsDiscountAmount(Long.parseLong(goodsDiscountAmount));
		}
		goodsadd.setGoodsType(goodsType);
		goodsadd.setGoodsStatus(goodsStatus);
		goodsadd.setGoodsCreatetime(goodsCreatetime);
//		goodsadd.setGoodsModifytime(goodsModifytime);
//		goodsadd.setGoodsEndtime(goodsEndtime);
		if (providerId != null && providerId.length() > 0) {
			goodsadd.setProviderId(Integer.parseInt(providerId));
		}
		goodsadd.setProviderName(providerName);
		goodsadd.setProviderCode(providerCode);
		goodsadd.setRemark(remark);
		if (goodsDiscount != null && goodsDiscount.length() > 0) {
			goodsadd.setGoodsDiscount(Integer.parseInt(goodsDiscount));
		}
		if (quarterRebate != null && quarterRebate.length() > 0) {
			goodsadd.setQuarterRebate(Long.parseLong(quarterRebate));
		}
		if (annualRebate != null && annualRebate.length() > 0) {
			goodsadd.setAnnualRebate(Long.parseLong(annualRebate));
		}
		if (providerSubsidy != null && providerSubsidy.length() > 0) {
			goodsadd.setProviderSubsidy(Long.parseLong(providerSubsidy));
		}
		if (providerPackageSubsidy != null && providerPackageSubsidy.length() > 0) {
			goodsadd.setProviderPackageSubsidy(Long.parseLong(providerPackageSubsidy));
		}
		if (customerSubsidy != null && customerSubsidy.length() > 0) {
			goodsadd.setCustomerSubsidy(Long.parseLong(customerSubsidy));
		}
		if (otherSubsidy != null && otherSubsidy.length() > 0) {
			goodsadd.setOtherSubsidy(Long.parseLong(otherSubsidy));
		}
		if (goodsActualCost != null && goodsActualCost.length() > 0) {
			goodsadd.setGoodsActualCost(Long.parseLong(goodsActualCost));
		}
		if (storagePrewarning != null && storagePrewarning.length() > 0) {
			goodsadd.setStoragePrewarning(Integer.parseInt(storagePrewarning));
		}
		if (shelfLifePrewarning != null && shelfLifePrewarning.length() > 0) {
			goodsadd.setShelfLifePrewarning(Integer.parseInt(shelfLifePrewarning));
		}
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
		String goodsId = request.getParameter("goodsId");
		// 3.数据校验
		if (goodsId != null && goodsId.length() > 0) {
			tbGoods.setGoodsId(Integer.parseInt(goodsId));
		}
		// 4.业务处理
		// 逻辑删除 修改状态为 00-失效 （记录状态 00-失效 01-正常 99-异常）
		tbGoods.setGoodsStatus("00");
		int res = goodsBusiness.goodsModify(tbGoods);
		toString();
		logger.info(String.valueOf(res));
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
				String goodsName = request.getParameter("goodsName") == "" ? null : request.getParameter("goodsName");
				String goodsCode = request.getParameter("goodsCode") == null ? request.getParameter("goodsName") : request.getParameter("goodsCode");
				String goodsVersion = request.getParameter("goodsVersion") == "" ? null : request.getParameter("goodsVersion");
				String goodsUnit = request.getParameter("goodsUnit") == "" ? null : request.getParameter("goodsUnit");
				String goodsBarCode = request.getParameter("goodsBarCode") == "" ? null : request.getParameter("goodsBarCode");
				String goodsCurrentStock = request.getParameter("goodsCurrentStock") == "" ? null : request.getParameter("goodsCurrentStock");
				String goodsTotalStock = request.getParameter("goodsTotalStock") == "" ? null : request.getParameter("goodsTotalStock");
//				String goodsProductionDate = request.getParameter("goodsProductionDate") == "" ? null : request.getParameter("goodsProductionDate");
//				String goodsExpirationDate = request.getParameter("goodsExpirationDate") == "" ? null : request.getParameter("goodsExpirationDate");
				String goodsShelfLife = request.getParameter("goodsShelfLife") == "" ? null : request.getParameter("goodsShelfLife");
				String goodsProfit = request.getParameter("goodsProfit") == "" ? null : request.getParameter("goodsProfit");
				String goodsPrice = request.getParameter("goodsPrice") == "" ? null : request.getParameter("goodsPrice");
				String goodsDiscountAmount = request.getParameter("goodsDiscountAmount") == "" ? null : request.getParameter("goodsDiscountAmount");
				String goodsType = request.getParameter("goodsType") == "" ? null : request.getParameter("goodsType");
				String goodsStatus = request.getParameter("goodsStatus") == "" ? null : request.getParameter("goodsStatus");
//				String goodsCreatetime = request.getParameter("goodsCreatetime") == "" ? null : request.getParameter("goodsCreatetime");
//				String goodsModifytime = request.getParameter("goodsModifytime") == "" ? null : request.getParameter("goodsModifytime");
//				String goodsEndtime = request.getParameter("goodsEndtime") == "" ? null : request.getParameter("goodsEndtime");
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


				// 3.数据校验
				tbGoods.setGoodsName(goodsName);
				tbGoods.setGoodsCode(goodsCode);
				if (goodsVersion != null && goodsVersion.length() > 0) {
					tbGoods.setGoodsVersion(Integer.parseInt(goodsVersion));
				}
				tbGoods.setGoodsUnit(goodsUnit);
				tbGoods.setGoodsBarCode(goodsBarCode);
				if (goodsCurrentStock != null && goodsCurrentStock.length() > 0) {
					tbGoods.setGoodsCurrentStock(Integer.parseInt(goodsCurrentStock));
				}
				if (goodsTotalStock != null && goodsTotalStock.length() > 0) {
					tbGoods.setGoodsTotalStock(Integer.parseInt(goodsTotalStock));
				}
//				tbGoods.setGoodsProductionDate(Date.parse(goodsProductionDate));
//				tbGoods.setGoodsExpirationDate(Date.parse(goodsExpirationDate);
				if (goodsShelfLife != null && goodsShelfLife.length() > 0) {
					tbGoods.setGoodsShelfLife(Integer.parseInt(goodsShelfLife));
				}
				if (goodsProfit != null && goodsProfit.length() > 0) {
					tbGoods.setGoodsProfit(Long.parseLong(goodsProfit));
				}
				if (goodsPrice != null && goodsPrice.length() > 0) {
					tbGoods.setGoodsPrice(Long.parseLong(goodsPrice));
				}
				if (goodsDiscountAmount != null && goodsDiscountAmount.length() > 0) {
					tbGoods.setGoodsDiscountAmount(Long.parseLong(goodsDiscountAmount));
				}
				tbGoods.setGoodsType(goodsType);
				tbGoods.setGoodsStatus(goodsStatus);
				tbGoods.setGoodsCreatetime(goodsCreatetime);
//				tbGoods.setGoodsModifytime(goodsModifytime);
//				tbGoods.setGoodsEndtime(goodsEndtime);
				if (providerId != null && providerId.length() > 0) {
					tbGoods.setProviderId(Integer.parseInt(providerId));
				}
				tbGoods.setProviderName(providerName);
				tbGoods.setProviderCode(providerCode);
				tbGoods.setRemark(remark);
				if (goodsDiscount != null && goodsDiscount.length() > 0) {
					tbGoods.setGoodsDiscount(Integer.parseInt(goodsDiscount));
				}
				if (quarterRebate != null && quarterRebate.length() > 0) {
					tbGoods.setQuarterRebate(Long.parseLong(quarterRebate));
				}
				if (annualRebate != null && annualRebate.length() > 0) {
					tbGoods.setAnnualRebate(Long.parseLong(annualRebate));
				}
				if (providerSubsidy != null && providerSubsidy.length() > 0) {
					tbGoods.setProviderSubsidy(Long.parseLong(providerSubsidy));
				}
				if (providerPackageSubsidy != null && providerPackageSubsidy.length() > 0) {
					tbGoods.setProviderPackageSubsidy(Long.parseLong(providerPackageSubsidy));
				}
				if (customerSubsidy != null && customerSubsidy.length() > 0) {
					tbGoods.setCustomerSubsidy(Long.parseLong(customerSubsidy));
				}
				if (otherSubsidy != null && otherSubsidy.length() > 0) {
					tbGoods.setOtherSubsidy(Long.parseLong(otherSubsidy));
				}
				if (goodsActualCost != null && goodsActualCost.length() > 0) {
					tbGoods.setGoodsActualCost(Long.parseLong(goodsActualCost));
				}
				if (storagePrewarning != null && storagePrewarning.length() > 0) {
					tbGoods.setStoragePrewarning(Integer.parseInt(storagePrewarning));
				}
				if (shelfLifePrewarning != null && shelfLifePrewarning.length() > 0) {
					tbGoods.setShelfLifePrewarning(Integer.parseInt(shelfLifePrewarning));
				}
				tbGoods.setGoodsStatus("01"); // 新增状态为正常的记录 00-失效 01-正常 99-异常
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
		TbGoodsExample.Criteria criteria = tbGoodsExample.createCriteria();

		// 2.获取参数
		String goodsId = request.getParameter("goodsId");
		// 3.数据校验
		if (goodsId != null && goodsId.length() > 0) {
			criteria.andGoodsIdEqualTo(Integer.parseInt(goodsId));
		}
		// 4.业务处理
		// 只查询状态为正常的记录 （00-失效 01-正常 99-异常）
		criteria.andGoodsStatusEqualTo("01");
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
