package com.ai.psims.web.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ai.psims.web.model.Employee;
import com.ai.psims.web.model.TbPrivilege;
import com.ai.psims.web.model.Storagecheck;
import com.ai.psims.web.service.IEmployeeService;
import com.ai.psims.web.service.IStoragecheckService;
import com.ai.psims.web.service.IPrivilegeService;
import com.ai.psims.web.util.MD5keyBean;

/**
 * 
 * @author kqiteeq
 *
 */
@Controller
@SessionAttributes({"mysession","privilege"})
@RequestMapping("/")
public class LoginController {

	@Resource(name="employeeServiceImpl")
    private IEmployeeService employeeServiceImpl;
	@Resource(name="storagecheckServiceImpl")
	private IStoragecheckService storagecheckServiceImpl;
	
	@Resource(name="privilegeServiceImpl")
	private IPrivilegeService privilegeService;
	
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
	    String status = employee.getStatus();
	    if(!status.equals("01")){
	    	resultMap.put("status", Boolean.FALSE);
            resultMap.put("message", "用户名不存在");
            return resultMap;
	    }
//		request.getSession().setAttribute("userSession", employee);
//		request.getSession().setAttribute("userSessionId", employee.getEmployeeId());
//        if (employee.getStatus()!="2") {
//            resultMap.put("status", Boolean.FALSE);
//            resultMap.put("message", "该用户已被禁用，请联系管理员");
//            return resultMap;
//        }
		//如果登录成功的话，就会创建session这个时候mysession所对应的值就是那个sessionid，
		//如果没有登录的话就不会创建session时候mysession所对应的值就是一个NULL
	    modelMap.addAttribute("mysession", employee);
	    TbPrivilege privilege = new TbPrivilege();
	    privilege.setUserId(employee.getEmployeeId());
	    List<TbPrivilege> selectByExample = privilegeService.selectByExample(privilege);
	    if(selectByExample!=null&&selectByExample.size()!=0){
	    	modelMap.addAttribute("privilege",selectByExample.get(0).getPrivilege());
	    }
        resultMap.put("status", Boolean.TRUE);
        resultMap.put("message", "登录成功");
        return resultMap;
    }
    
   /**
    * 查询过期商品数量
    * @param request
    * @return
    */
    @RequestMapping(value = "/seek.do", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> seek(){
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	List<Storagecheck> storagecheck = storagecheckServiceImpl.seekExpiration();
    	List<Storagecheck> storagecheckB = storagecheckServiceImpl.seekBExpiration();
    	List<Storagecheck> storagecheckC = storagecheckServiceImpl.seekCExpiration();
    	List<Storagecheck> storagecheckD = storagecheckServiceImpl.seekDExpiration();
    	List<Storagecheck> storage = storagecheckServiceImpl.seekStore();
    	List<Storagecheck> storageB = storagecheckServiceImpl.seekBStore();
    	List<Storagecheck> storageC = storagecheckServiceImpl.seekCStore();
    	List<Storagecheck> storageD = storagecheckServiceImpl.seekDStore();
    	int date = storagecheck.size();
    	int dateB = storagecheckB.size();
    	int dateC = storagecheckC.size();
    	int dateD = storagecheckD.size();
    	int type = storage.size();
    	int typeB = storageB.size();
    	int typeC = storageC.size();
    	int typeD = storageD.size();
    	resultMap.put("ten", date);
    	resultMap.put("thirty", dateB);
    	resultMap.put("sixty", dateC);
    	resultMap.put("ninety", dateD);
    	resultMap.put("tens", type);
    	resultMap.put("fifty", typeB);
    	resultMap.put("hundred", typeC);
    	resultMap.put("hundreds", typeD);
    	return resultMap;
    }


    //退出系统LogOut.do
    @RequestMapping(value = "/LogOut.do")
    public String logout(HttpServletRequest request,ModelMap modelMap) {
    	HttpSession session = request.getSession();
    	Object mysession = session.getAttribute("mysession");
    	if(mysession!=null){
    		session.getAttribute("mysession");
    		modelMap.addAttribute("mysession", "");
    	}
    	mysession = session.getAttribute("privilege");
    	if(mysession!=null){
    		session.removeAttribute("privilege");
    		modelMap.addAttribute("privilege", "");
    	}
        return "login";
    }

}
