package com.ai.psims.web.common;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ai.psims.web.model.TbEmployee;

public class SystemFilter implements Filter {

	//定义在没有Session之前，可以放行的连接
	List<String> list = new ArrayList<String>();
	
	/**web容器启动的时候，初始化*/
	public void init(FilterConfig config) throws ServletException {
		//定义存放在没有Session之前，可以放行的连接
		list.add("/login.jsp");
		list.add("/Login.do");
//		list.add("/system/elecMenuAction_menuHome.do");
//		
//		list.add("/error.jsp");
//		list.add("/system/elecMenuAction_logout.do");
	}

	/**每次执行url链接的时候，都会执行的方法*/
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		//获取访问的url路径
		String path = request.getServletPath();
		this.forwordIndexPage(path,request);
		//当没有Session之前，可以放行的连接
		if(list.contains(path)){
			//放行
			chain.doFilter(request, response);
			return;
		}
		if(path.contains("LogOut.do")){
			//放行
			chain.doFilter(request, response);
			return;
		}
			
		//获取Session，完成粗颗粒权限控制，从Session中获取用户信息
		TbEmployee employee = (TbEmployee)request.getSession().getAttribute("mysession");
		//说明当前操作存在Session，需要放行
		if(employee!=null){
			//放行
			chain.doFilter(request, response);
			return;
		}
		//重定向到登陆页面（error.jsp实现5秒后跳转到登录页面）
		response.sendRedirect(request.getContextPath()+"/error.jsp");
	}

	

	/**关闭的时候销毁*/
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	/**在跳转到login.jsp页面之前，先执行从Cookie中获取name和password的操作*/
	private void forwordIndexPage(String path, HttpServletRequest request) {
		if(path.equals("/LogOut.do")||path.equals("/Login.do")){
			//登录名
			String name = "";
			//密码
			String password = "";
			//如果登录名和密码在Cookie中存在，默认让记住我的复选框选中
			String checked = "";
			Cookie [] cookies = request.getCookies();
			if(cookies!=null && cookies.length>0){
				for(Cookie cookie:cookies){
					if(cookie.getName().equals("name")){
						name = cookie.getValue();
						//如果name存在中文，进行解码
						try {
							name = URLDecoder.decode(name, "UTF-8");
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
						checked = "checked";
					}
					if(cookie.getName().equals("password")){
						password = cookie.getValue();
					}
				}
			}
			request.setAttribute("name", name);
			request.setAttribute("password", password);
			request.setAttribute("checked", checked);
		}
		
	}

}
