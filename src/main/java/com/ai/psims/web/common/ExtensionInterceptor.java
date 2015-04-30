package com.ai.psims.web.common;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 扩展名命名处理拦截器
 * 
 * @author Nanlei
 * 
 */
public class ExtensionInterceptor extends HandlerInterceptorAdapter {
	/**
	 * 用在流程处理之后
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 获取Controller过来的Model对象
		Map model = modelAndView.getModel();
		// 获取请求URI
		String uri = request.getRequestURI();
		// 生成文件的名称
		String exportFileName = null;
		if (uri.endsWith("excel.do")) {
			String time = new SimpleDateFormat("yyyyMMddHHmmss")
					.format(new Date());
			exportFileName = "报表" + time + ".xls";
		}
		if (!exportFileName.isEmpty()) {
			response.setHeader("Content-Disposition", "attachment; filename="
					+ URLEncoder.encode(exportFileName, "UTF-8"));
		}
		super.postHandle(request, response, handler, modelAndView);
	}
}