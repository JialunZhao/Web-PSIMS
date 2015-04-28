package com.ai.psims.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ai.psims.web.model.Employee;
import com.ai.psims.web.model.TbPrivilege;
import com.ai.psims.web.service.IEmployeeService;
import com.ai.psims.web.service.IPrivilegeService;
import com.ai.psims.web.util.MD5keyBean;





/**
 * 
 * @author kqiteeq
 *
 */
@Controller
@SessionAttributes("mysession")
@RequestMapping("/user")
public class EmployeeController {

	@Resource(name="employeeServiceImpl")
    private IEmployeeService employeeServiceImpl;
	
	@Resource(name="privilegeServiceImpl")
	private IPrivilegeService privilegeServiceImpl;

	@RequestMapping(value="/check.do")
	@ResponseBody
	public Boolean check(@RequestParam("name") String name){
		List<Employee> emList = employeeServiceImpl.getEmployee(name);
		if(emList==null||emList.size()==0){
			return true;
		}
		return false;
	}
	
	@RequestMapping(value="/getPriv.do")
	@ResponseBody
	public TbPrivilege check(@RequestParam("userId") Integer userId){
		TbPrivilege privilege = new  TbPrivilege();
		privilege.setUserId(userId); 
		List<TbPrivilege> emList = privilegeServiceImpl.selectByExample(privilege);
		return emList==null||emList.size()==0?null:emList.get(0);
	}
	

    //添加方法
    @RequestMapping(value = "/add.do", method = RequestMethod.POST)
    public String add(Employee employee,HttpServletRequest request) {
    	String LoginPassword = employee.getLoginPassword();
        MD5keyBean md5keyBean = new MD5keyBean();
        LoginPassword = md5keyBean.getkeyBeanofStr(LoginPassword);
        employee.setLoginPassword(LoginPassword);
    	employee.setStatus("01");
    	employeeServiceImpl.add(employee);
    	String[] privilegeBut = request.getParameterValues("privilegeBut");
        String[] privilegeMen = request.getParameterValues("privilegeMen");
        TbPrivilege pri = new TbPrivilege();
        String priv = "";
        if(privilegeMen!=null&&privilegeMen.length!=0){
        	 for(int i = 0 ; i < privilegeMen.length ; i++){
             	if(i==privilegeMen.length-1){
             		priv += privilegeMen[i];
             	}else{
             		priv += privilegeMen[i]+",";
             	}
             	
             }
        }
    	if(privilegeBut!=null&&privilegeBut.length!=0){
    		if(priv!=null&&priv.length()!=0){
    			priv += ",";
    		}
            for(int i = 0 ; i < privilegeBut.length ; i++){
            	if(i==privilegeBut.length-1){
            		priv += privilegeBut[i];
            	}else{
            		priv += privilegeBut[i]+",";
            	}
            }
    	}
    	if(priv!=null&&priv.length()!=0){
	    	pri.setPrivilege(priv);
			List<Employee> emList = employeeServiceImpl.getEmployee(employee.getEmployeeCode());
			Employee em = emList.get(0);
			pri.setUserId(em.getEmployeeId());
			privilegeServiceImpl.add(pri);
    	}
        return "redirect:/user/show.do";
    }
    //显示所有用
    @RequestMapping(value = "/show.do", method = RequestMethod.GET)
    public String showEmployee(ModelMap modelMap) {
        List<Employee> list = employeeServiceImpl.getlAllEmployee();
        modelMap.addAttribute("user", list);
        return "user";
    }
    //根据条件查找
    @RequestMapping(value = "/seek.do", method = RequestMethod.POST)
    public String seekEmployee(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap) {
    	String employeeName = request.getParameter("employeeName1");
        String sex = request.getParameter("sex1");
        String role = request.getParameter("role1");
        String contactTel = request.getParameter("contactTel1");
        if(employeeName=="" && sex=="" && role=="" && contactTel==""){
        	List<Employee> list1 = employeeServiceImpl.getlAllEmployee();
        	modelMap.addAttribute("user", list1);
        	return "user";
        }
    	List<Employee> list = employeeServiceImpl.getEmployee(employeeName,sex,role,contactTel);
    	modelMap.addAttribute("user", list);
    	return "user";
    }

    @RequestMapping(value = "/{id}/delete.do", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable int id) {
    	Employee employee = employeeServiceImpl.getEmployee(id);
    	employee.setStatus("00");
    	employeeServiceImpl.delete(employee);
        return "redirect:/user/show.do";
    }

    //服务器查询到数据把数据放到对象中，再通过键值来取
    @RequestMapping(value = "/{employeeId}/toUpdate.do", method = RequestMethod.GET)
    @ResponseBody
    public Employee toUpdate(@PathVariable int employeeId) {
    	Employee employee = employeeServiceImpl.getUserById(employeeId);
        return employee;

    }

    //修改方法
    @RequestMapping(value = "/update.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response) {
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	Integer employeeId = Integer.parseInt(request.getParameter("employeeId"));
    	String employeeName = request.getParameter("employeeName");
        String sex = request.getParameter("sex");
        String role = request.getParameter("role");
        String contactTel = request.getParameter("contactTel");
        String contactAddr = request.getParameter("contactAddr");
        String remark = request.getParameter("remark");
        String employeeCode = request.getParameter("employeeCode");
        String loginPassword = request.getParameter("loginPassword");
        Employee employee = new Employee();
        employee.setEmployeeName(employeeName);
        employee.setEmployeeId(employeeId);
        employee.setSex(sex);
        employee.setRole(role);
        employee.setContactTel(contactTel);
        employee.setContactAddr(contactAddr);
        employee.setRemark(remark);
        employee.setEmployeeCode(employeeCode);
        if(loginPassword.length()>20){
        	employee.setLoginPassword(loginPassword);
        }else{
        	MD5keyBean md5keyBean = new MD5keyBean();
            loginPassword = md5keyBean.getkeyBeanofStr(loginPassword);
            employee.setLoginPassword(loginPassword);
        }
        employeeServiceImpl.update(employee);
        resultMap.put("status", Boolean.TRUE);
        String needsigninmodifychk = request.getParameter("needsigninmodifychk");
        String privId = request.getParameter("privId");
        if(needsigninmodifychk!=null&&needsigninmodifychk.equals("false")){
        	if(privId!=null&&privId.length()!=0){
        		TbPrivilege privilege = new TbPrivilege();
        		privilege.setId(Integer.parseInt(privId));
        		privilegeServiceImpl.delete(privilege);
        	}
        }else if(needsigninmodifychk!=null&&needsigninmodifychk.equals("true")){
        	String privilege = request.getParameter("privilege");
        	 if(privilege!=null&&privilege.length()!=0){
        		 if(privId!=null&&privId.length()!=0){
             		TbPrivilege priv = privilegeServiceImpl.getPrivilege(Integer.parseInt(privId));
             		if(priv!=null){
             			priv.setPrivilege(privilege);
             		}
             		privilegeServiceImpl.update(priv);
             	}else{
             		TbPrivilege priv = new TbPrivilege();
             		priv.setPrivilege(privilege);
             		priv.setUserId(employee.getEmployeeId());;
             		privilegeServiceImpl.add(priv);
             	}
             }else{
            	 if(privId!=null&&privId.length()!=0){
             		TbPrivilege priv = new TbPrivilege();
             		priv.setId(Integer.parseInt(privId));
             		privilegeServiceImpl.delete(priv);
             	}
             }
        }
       
        return resultMap;
    }




}
