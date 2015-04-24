package com.ai.psims.web.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



/**
 * 
 * @author kqiteeq
 *
 */
public class LoginInteceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	HttpSession session = request.getSession();
    	String contextPath = request.getContextPath();
    	String servletPath = request.getServletPath();


        if (servletPath.equals("/")) {
            response.sendRedirect(contextPath + "/Login.do");
            return false;
        }
        Object mysession = session.getAttribute("mysession");
        if (mysession==null||mysession=="") {
            response.sendRedirect(contextPath + "/LogOut.do");
//            request.getRequestDispatcher(contextPath + "/index.jsp").forward(request,response);
        }
        
//        
//        if (servletPath.equals("/user/show.do")) {
//        	response.sendRedirect(contextPath);
//        	return true;
//        }
//        if (servletPath.equals("/user/add.do")) {
//        	response.sendRedirect(contextPath);
//        	return true;
//        }
//        if (servletPath.equals("/user/toUpdate.do")) {
//        	response.sendRedirect(contextPath);
//        	return true;
//        }
//        if (servletPath.equals("/user/update.do")) {
//        	response.sendRedirect(contextPath);
//        	return true;
//        }
//        if (servletPath.equals("/sys/show.do")) {
//        	response.sendRedirect(contextPath);
//        	return true;
//        }
//        if (servletPath.equals("/sys/add.do")) {
//        	response.sendRedirect(contextPath);
//        	return true;
//        }
//        if (servletPath.equals("/sys/toUpdate.do")) {
//        	response.sendRedirect(contextPath);
//        	return true;
//        }
//        if (servletPath.equals("/sys/update.do")) {
//        	response.sendRedirect(contextPath);
//        	return true;
//        }



        if (servletPath.equals("/Login.do")) {
            if (mysession != null) {
                response.sendRedirect(contextPath + "/reLogin.do");
//                request.getRequestDispatcher(contextPath + "/index.jsp").forward(request,response);
            }


        }


        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//    	HttpSession session = request.getSession();
//    	String contextPath = request.getContextPath();
//    	Employee mysession = (Employee) session.getAttribute("mysession");
//    	if (mysession != null) {
////            response.sendRedirect(contextPath + "/reLogin.do");
//            request.getRequestDispatcher(contextPath + "/reLogin.do").forward(request,response);
//        }
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
