package com.ai.psims.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.ai.psims.web.model.Employee;
import com.ai.psims.web.service.IEmployeeService;
import com.ai.psims.web.util.MD5keyBean;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author kqiteeq
 *
 */
@Controller
@SessionAttributes("mysession")
@RequestMapping("/")
public class LoginController {

	@Resource(name="employeeServiceImpl")
    private IEmployeeService employeeServiceImpl;
	
	@RequestMapping(value = "/reLogin.do", method = RequestMethod.GET)
	public String reLogin() {
		return "main";
	}

    @RequestMapping(value = "/Login.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> userLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password, ModelMap modelMap,
            HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        MD5keyBean md5keyBean = new MD5keyBean();
        password = md5keyBean.getkeyBeanofStr(password);
        List<Employee> employeeList = employeeServiceImpl.getEmployee(username, password);
        System.out.println("===========================================" + username);
        System.out.println("======================================================" + password);

        if (employeeList.size() != 1) {
            resultMap.put("status", Boolean.FALSE);
            resultMap.put("message", "用户名密码不匹配，请重新输入");
            return resultMap;
        }
	 // 当验证都通过后，把用户信息放在session里
	    Employee employee = employeeList.get(0);
//		request.getSession().setAttribute("userSession", employee);
//		request.getSession().setAttribute("userSessionId", employee.getEmployeeId());
//        if (employee.getStatus()!="2") {
//            resultMap.put("status", Boolean.FALSE);
//            resultMap.put("message", "该用户已被禁用，请联系管理员");
//            return resultMap;
//        }
		//如果登录成功的话，就会创建session这个时候mysession所对应的值就是那个sessionid，
		//如果没有登录的话就不会创建session时候mysession所对应的值就是一个NULL
        resultMap.put("status", Boolean.TRUE);
        resultMap.put("message", "登录成功");
        return resultMap;
    }


    //退出系统LogOut.do
    @RequestMapping(value = "/LogOut.do")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "login";
    }

}
