package com.ai.psims.web.controller;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.ai.psims.web.business.IProviderBusiness;
import com.ai.psims.web.business.ISystemParameterBussiness;
import com.ai.psims.web.model.TbProvider;
import com.ai.psims.web.model.TbProviderExample;
import com.ai.psims.web.model.TbSystemParameter;
import com.ai.psims.web.model.TbSystemParameterExample;
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
	private ISystemParameterBussiness systemParameterBussinessImpl;

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
		logger.info("------------4.1.转译供应商类型-------------");
		for (TbProvider tbProvider : providers) {
			if (tbProvider.getProviderType() == null) {
			} else {
				tbProvider.setProviderType(CreateIdUtil
						.getProviderType(tbProvider.getProviderType()));
			}
		}
		logger.info("------------4.2.获取奖金池-------------");
		for (TbProvider tbProvider : providers) {
			if (null != tbProvider.getProviderPrizePool() && !"".equals(tbProvider.getProviderPrizePool())) {
			tbProvider.setProviderPrizePool(systemParameterBussinessImpl
					.getSystemParameterPrizePool(
							Integer.parseInt(tbProvider.getProviderPrizePool()))
					.getPpValueint().toString());
			}else {
				tbProvider.setProviderPrizePool("未关联奖金池");
			}
		}
		logger.info("------------5.返回结果-------------");
		request.setAttribute("providers", providers);
		request.setAttribute("provider_name", provider_name);
		request.setAttribute("provider_type", provider_type);
		request.setAttribute("contact_name", contact_name);
		request.setAttribute("contact_tel", contact_tel);
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
		provideradd.setProviderPrizePool(provider_prizepool);
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
				.getParameter("modify_providerCode") == null ? request
				.getParameter("modify_providerName") : request
				.getParameter("modify_providerCode");
		String provider_prizepool = request.getParameter("modify_provider_prizepool");

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
		String modify_providerRemark = request
				.getParameter("modify_providerRemark");
		Date modifytime = new Date();

		logger.info("------------3.数据校验-------------");
		if (modify_providerId != null && modify_providerId.length() > 0) {
			tbProvider.setProviderId(Integer.parseInt(modify_providerId));
		}
		tbProvider.setProviderName(modify_providerName);
		tbProvider.setProviderCode(modify_Provider_code);
		tbProvider.setProviderPrizePool(provider_prizepool);
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
		TbProviderExample.Criteria criteria = tbProviderExample
				.createCriteria();
		logger.info("------------2.获取参数-------------");
		String provider_id = request.getParameter("provider_id");
		logger.info("------------3.数据校验-------------");
		if (provider_id != null && provider_id.length() > 0) {
			criteria.andProviderIdEqualTo(Integer.parseInt(provider_id));
		}
		logger.info("------------4.业务处理-------------");
		// 只查询状态为正常的记录 （00-失效 01-正常 99-异常）
		criteria.andProviderStatusEqualTo("01");
		tbProviders = ProviderBusiness.providerQuery(tbProviderExample);
		request.setAttribute("tbProviders", tbProviders);
		logger.info("------------5.返回结果-------------");
		logger.info("------------Bye queryProvider!-------------");
		return tbProviders;
	}

	/**
	 * 新增供应商查询奖金池信息
	 */
	@RequestMapping(value = "/getProviderPrizePool", method = RequestMethod.POST)
	public @ResponseBody List<TbSystemParameter> getProviderPrizePool(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("------------Welcome queryProvider!-------------");
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
		criteria.andPValueEqualTo("PrizePool");
		tbSystemParameters = systemParameterBussinessImpl
				.getSystemParameterPrizePool(tbSystemParameterExample);
		request.setAttribute("tbSystemParameters", tbSystemParameters);
		logger.info("------------5.返回结果-------------");
		logger.info("------------Bye queryProvider!-------------");
		return tbSystemParameters;
	}
	
	/**
	 * 查询奖金池信息
	 */
	@RequestMapping(value = "/{id}/delQue.do", method = RequestMethod.GET)
	@ResponseBody
    public List<TbProvider> delQue(@PathVariable int id) {
		TbProviderExample tbProviderExample = new TbProviderExample();
		TbProviderExample.Criteria criteria = tbProviderExample
				.createCriteria();
		String prizePool = String.valueOf(id);
		criteria.andProviderPrizePoolEqualTo(prizePool);
		List<TbProvider> lists = ProviderBusiness.providerQuery(tbProviderExample);
		return lists;
	}
	

	@RequestMapping(value = "/providerReportExecl")
	public View providerReportExecl(Model model, HttpServletRequest request) {
		logger.info("------------Welcome providerReportExecl page!-------------");
		logger.info("------------以 Apache POI 实现 AbstractExcelView-------------");
		View Excelview = new AbstractExcelView() {
			@Override
			public void buildExcelDocument(@SuppressWarnings("rawtypes") Map map, HSSFWorkbook workbook,
					HttpServletRequest request, HttpServletResponse response)
					throws Exception {
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
				logger.info("------------4.1.转译供应商类型-------------");
				for (TbProvider tbProvider : providers) {
					if (tbProvider.getProviderType() == null) {
					} else {
						tbProvider.setProviderType(CreateIdUtil
								.getProviderType(tbProvider.getProviderType()));
					}
				}


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
				header.createCell(idx++).setCellValue("供应商名称");
				header.createCell(idx++).setCellValue("供应商代码");
				header.createCell(idx++).setCellValue("供应商类型");
				header.createCell(idx++).setCellValue("奖金池名称");
				header.createCell(idx++).setCellValue("奖金池金额");
				header.createCell(idx++).setCellValue("联系人名称");
				header.createCell(idx++).setCellValue("联系人电话");
				header.createCell(idx++).setCellValue("联系人传真");
				header.createCell(idx++).setCellValue("供应商地址");
				header.createCell(idx++).setCellValue("供应商E-mail");
				header.createCell(idx++).setCellValue("供应商地域");
				header.createCell(idx++).setCellValue("供应商添加时间");
				header.createCell(idx++).setCellValue("供应商修改时间");
				header.createCell(idx++).setCellValue("备注");
				logger.info("------------输出内容-------------");
				HSSFRow row;
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");  

				for (TbProvider tbProvider : providers) {
					idx = 0;
					row = sheet.createRow(rowNum++);
					row.createCell(idx++).setCellValue(tbProvider.getProviderId());
					row.createCell(idx++).setCellValue(tbProvider.getProviderName());
					row.createCell(idx++).setCellValue(tbProvider.getProviderCode());
					row.createCell(idx++).setCellValue(tbProvider.getProviderType());
					if (null != tbProvider.getProviderPrizePool() && !"".equals(tbProvider.getProviderPrizePool()))
					{
					row.createCell(idx++).setCellValue(systemParameterBussinessImpl
							.getSystemParameterPrizePool(
									Integer.parseInt(tbProvider.getProviderPrizePool()))
							.getPpDesc());
					row.createCell(idx++).setCellValue(systemParameterBussinessImpl
							.getSystemParameterPrizePool(
									Integer.parseInt(tbProvider.getProviderPrizePool()))
							.getPpValueint());
					}else {
						row.createCell(idx++).setCellValue("未关联奖金池");
						row.createCell(idx++).setCellValue("未关联奖金池");
					}
					row.createCell(idx++).setCellValue(tbProvider.getProviderContactName());
					row.createCell(idx++).setCellValue(tbProvider.getProviderContactTel());
					row.createCell(idx++).setCellValue(tbProvider.getProviderContactFax());
					row.createCell(idx++).setCellValue(tbProvider.getProviderContactAddress());
					row.createCell(idx++).setCellValue(tbProvider.getProviderContactEmail());
					row.createCell(idx++).setCellValue(tbProvider.getProviderArea());
					row.createCell(idx++).setCellValue(sdf.format(tbProvider.getProviderCreatetime()));
					if (null !=tbProvider.getProviderModifytime()) {						
						row.createCell(idx++).setCellValue(sdf.format(tbProvider.getProviderModifytime()));
					}else {
						row.createCell(idx++).setCellValue("无");
					}
					row.createCell(idx++).setCellValue(tbProvider.getProviderRemark());
//					row.createCell(idx++).setCellValue(tbProvider.get);
//					row.createCell(idx++).setCellValue(tbProvider.get);
				}
			}
		};
		logger.info("------------5.返回结果-------------");
		logger.info("------------回传 View 对象，返回生成的 Excel 档-------------");
		logger.info("------------Bye providerReportExecl page!-------------");
		return Excelview;
	}
	

	@ExceptionHandler(Exception.class)
	public String exception(Exception e, HttpServletRequest request) {
		request.setAttribute("exception", e);
		return "error";
	}

}
