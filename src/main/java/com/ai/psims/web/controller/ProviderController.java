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

import com.ai.psims.web.business.IProviderBusiness;
import com.ai.psims.web.business.ISystemParameterBussiness;
import com.ai.psims.web.model.TbProvider;
import com.ai.psims.web.model.TbProviderExample;
import com.ai.psims.web.util.CreateIdUtil;

;

/**
 * 供应商管理Controller
 */
@Controller
@RequestMapping("/providerController")
public class ProviderController extends BaseController {

	private static final Logger logger = LoggerFactory
			.getLogger(ProviderController.class);

	@Resource(name = "providerBusinessImpl")
	private IProviderBusiness ProviderBusiness;

	@Resource(name = "systemParameterBussinessImpl")
	private ISystemParameterBussiness systemParameterBussiness;

	/**
	 * 供应商管理页面跳转
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String providerRedirectGET(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "redirect:/providerController/provider";
	}

	/**
	 * 供应商管理页面跳转
	 */
	@RequestMapping(value = "/provider", method = RequestMethod.GET)
	public String providerRedirect(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("------------Welcome Provider page!-------------");
		logger.info("------------1.初始化-------------");
		List<TbProvider> providers;
		TbProviderExample tbProviderExample = new TbProviderExample();
		TbProviderExample.Criteria criteria = tbProviderExample
				.createCriteria();
		logger.info("------------2.获取参数-------------");
		String provider_name = request.getParameter("query_providerName") == "" ? null
				: request.getParameter("query_providerName");
		String provider_type = request.getParameter("query_providerType") == "" ? null
				: request.getParameter("query_providerType");
		String contact_name = request.getParameter("query_contactName") == "" ? null
				: request.getParameter("query_contactName");
		String contact_tel = request.getParameter("query_contactTel") == "" ? null
				: request.getParameter("query_contactTel");
		logger.info("------------3.数据校验-------------");
		if (provider_name != null && provider_name.length() > 0) {
			provider_name = "%" + provider_name + "%";
			criteria.andProviderNameLike(provider_name);
		}
		if (provider_type != null && provider_type.length() > 0) {
			if (!provider_type.equals("0")) {
				criteria.andProviderTypeEqualTo(provider_type);
			}
		}
		if (contact_name != null && contact_name.length() > 0) {
			contact_name = "%" + contact_name + "%";
			criteria.andProviderContactNameLike(contact_name);
		}
		if (contact_tel != null && contact_tel.length() > 0) {
			contact_tel = "%" + contact_tel + "%";
			criteria.andProviderContactTelLike(contact_tel);
		}
		logger.info("------------4.业务处理-------------");
		// 只查询状态为正常的记录 00-失效 01-正常 99-异常
		criteria.andProviderStatusEqualTo("01");
		providers = ProviderBusiness.providerQuery(tbProviderExample);
		logger.info("------------4.1.转译用户类型-------------");
		for (TbProvider tbProvider : providers) {
			if (tbProvider.getProviderType() == null) {
			} else {
				tbProvider.setProviderType(CreateIdUtil
						.getProviderType(tbProvider.getProviderType()));
			}
		}
		logger.info("------------4.2.获取奖金池-------------");
		for (TbProvider tbProvider : providers) {
			systemParameterBussiness.getSystemParameterPrizePool(tbProvider
					.getProviderPrizePool());

		}
		logger.info("------------5.返回结果-------------");
		request.setAttribute("providers", providers);
		logger.info("------------Bye Provider page!-------------");
		return "provider";
	}

	/**
	 * 供应商管理新增供应商信息
	 */
	@RequestMapping(value = "/addProvider", method = RequestMethod.POST)
	public String TbProvider(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("------------Welcome Provider add info!-------------");
		logger.info("------------1.初始化-------------");
		TbProvider provideradd = new TbProvider();
		logger.info("------------2.获取参数-------------");
		String provider_name = request.getParameter("provider_name");
		String provider_code = request.getParameter("provider_code") == null ? request
				.getParameter("provider_name") : request
				.getParameter("provider_name");
		String provider_prizepool = request.getParameter("provider_prizepool");
		String contact_name = request.getParameter("contact_name");
		String contact_tel = request.getParameter("contact_tel");
		String contact_addr = request.getParameter("contact_addr");
		String contact_fax = request.getParameter("contact_fax");
		String email = request.getParameter("email");
		String area = request.getParameter("area");
		String provider_type = request.getParameter("provider_type");
		// String createtime_str = request.getParameter("createtime");
		// String modifytime_str = request.getParameter("modifytime");
		// String endtime_str = request.getParameter("endtime");
		// String status = request.getParameter("status");
		String remark = request.getParameter("remark");
		Date createtime = new Date();
		logger.info("------------3.数据校验-------------");
		provideradd.setProviderName(provider_name);
		provideradd.setProviderCode(provider_code);
		provideradd.setProviderPrizePool(Integer.parseInt(provider_prizepool));
		provideradd.setProviderContactName(contact_name);
		provideradd.setProviderContactTel(contact_tel);
		provideradd.setProviderContactFax(contact_fax);
		provideradd.setProviderContactAddress(contact_addr);
		provideradd.setProviderContactEmail(email);
		provideradd.setProviderArea(area);
		provideradd.setProviderType(provider_type);
		provideradd.setProviderCreatetime(createtime);
		provideradd.setProviderStatus("01"); // 新增状态为正常的记录 00-失效 01-正常 99-异常
		provideradd.setProviderRemark(remark);
		logger.info("------------4.业务处理-------------");
		int res = ProviderBusiness.providerAdd(provideradd);
		toString();
		logger.info(String.valueOf(res));
		logger.info("------------5.返回结果-------------");
		logger.info("------------Bye Provider add info! -------------");
		return "provider";
	}

	/**
	 * 供应商管理删除供应商信息
	 */
	@RequestMapping(value = "/deleteProvider", method = RequestMethod.POST)
	public String ProviderDelete(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("------------Welcome deleteProvider! -------------");
		logger.info("------------1.初始化-------------");
		TbProvider TbProvider = new TbProvider();
		logger.info("------------2.获取参数-------------");
		String Provider_id = request.getParameter("provider_id");
		logger.info("------------3.数据校验-------------");
		if (Provider_id != null && Provider_id.length() > 0) {
			TbProvider.setProviderId(Integer.parseInt(Provider_id));
		}
		logger.info("------------4.业务处理-------------");
		// 逻辑删除 修改状态为 00-失效 （记录状态 00-失效 01-正常 99-异常）
		TbProvider.setProviderStatus("00");
		int res = ProviderBusiness.providerModify(TbProvider);
		toString();
		logger.info(String.valueOf(res));

		// --弃用-- 改为逻辑删除
		// int res = ProviderBusiness.ProviderDelete(TbProviderExample);
		// toString();
		// logger.info(String.valueOf(res));
		logger.info("------------5.返回结果-------------");
		logger.info("------------Bye deleteProvider! -------------");
		return "provider";
	}

	/**
	 * 供应商管理修改供应商信息
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String ProviderModify(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("------------Welcome Provider!-------------");
		logger.info("------------1.初始化-------------");
		TbProvider tbProvider = new TbProvider();

		logger.info("------------2.获取参数-------------");
		String modify_providerId = request.getParameter("modify_providerId");
		String modify_providerName = request
				.getParameter("modify_providerName");
		String modify_Provider_code = request
				.getParameter("modify_Provider_code") == null ? request
				.getParameter("modify_providerName") : request
				.getParameter("modify_Provider_code");
		String modify_providerContactName = request
				.getParameter("modify_providerContactName");
		String modify_providerContactTel = request
				.getParameter("modify_providerContactTel");
		String modify_providerContactAddress = request
				.getParameter("modify_providerContactAddress");
		String modify_providerContactEmail = request
				.getParameter("modify_providerContactEmail");
		String modify_providerArea = request
				.getParameter("modify_providerArea");
		String modify_providerType = request
				.getParameter("modify_providerType");
		// String createtime_str = request.getParameter("createtime");
		// String modifytime_str = request.getParameter("modifytime");
		// String endtime_str = request.getParameter("endtime");
		// String status = request.getParameter("modify_status");
		String modify_providerRemark = request
				.getParameter("modify_providerRemark");
		Date modifytime = new Date();

		logger.info("------------3.数据校验-------------");
		if (modify_providerId != null && modify_providerId.length() > 0) {
			tbProvider.setProviderId(Integer.parseInt(modify_providerId));
		}
		tbProvider.setProviderName(modify_providerName);
		tbProvider.setProviderCode(modify_Provider_code);
		tbProvider.setProviderContactName(modify_providerContactName);
		tbProvider.setProviderContactTel(modify_providerContactTel);
		tbProvider.setProviderContactAddress(modify_providerContactAddress);
		tbProvider.setProviderContactEmail(modify_providerContactEmail);
		tbProvider.setProviderArea(modify_providerArea);
		tbProvider.setProviderType(modify_providerType);
		tbProvider.setProviderModifytime(modifytime);
		// tbProvider.setStatus("01");
		tbProvider.setProviderRemark(modify_providerRemark);
		logger.info("------------4.业务处理-------------");
		int res = ProviderBusiness.providerModify(tbProvider);
		toString();
		logger.info(String.valueOf(res));
		logger.info("------------5.返回结果-------------");
		logger.info("------------Bye Provider!-------------");
		return "provider";
	}

	/**
	 * 供应商管理修改查询供应商信息
	 */
	@RequestMapping(value = "/queryProvider", method = RequestMethod.POST)
	public @ResponseBody List<TbProvider> ProviderQuery(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("------------Welcome queryProvider!-------------");
		logger.info("------------1.初始化-------------");
		List<TbProvider> tbProviders;
		TbProviderExample tbProviderExample = new TbProviderExample();
		int Providerid = 0;
		logger.info("------------2.获取参数-------------");
		String Provider_id = request.getParameter("Provider_id");
		String Provider_name = request.getParameter("Provider_name");
		String Provider_type = request.getParameter("Provider_type");
		String contact_name = request.getParameter("contact_name");
		String contact_tel = request.getParameter("contact_tel");
		logger.info("------------3.数据校验-------------");
		if (Provider_id != null && Provider_id.length() > 0) {
			Providerid = Integer.parseInt(Provider_id);
			tbProviderExample.createCriteria().andProviderIdEqualTo(Providerid);
		}
		if (Provider_name != null && Provider_name.length() > 0) {
			tbProviderExample.createCriteria().andProviderNameEqualTo(
					contact_name);
		}
		if (Provider_type != null && Provider_type.length() > 0) {
			tbProviderExample.createCriteria().andProviderTypeEqualTo(
					Provider_type);
		}
		if (contact_name != null && contact_name.length() > 0) {
			tbProviderExample.createCriteria().andProviderContactNameEqualTo(
					contact_name);
		}
		if (contact_tel != null && contact_tel.length() > 0) {
			tbProviderExample.createCriteria().andProviderContactTelEqualTo(
					contact_tel);
		}
		logger.info("------------4.业务处理-------------");
		// 只查询状态为正常的记录 （00-失效 01-正常 99-异常）
		tbProviderExample.createCriteria().andProviderStatusEqualTo("01");
		tbProviders = ProviderBusiness.providerQuery(tbProviderExample);
		request.setAttribute("tbProviders", tbProviders);
		logger.info("------------5.返回结果-------------");
		logger.info("------------Bye queryProvider!-------------");
		return tbProviders;
	}

	@ExceptionHandler(Exception.class)
	public String exception(Exception e, HttpServletRequest request) {
		request.setAttribute("exception", e);
		return "error";
	}

}
