package com.ai.psims.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ai.psims.web.model.Employee;
import com.ai.psims.web.service.IEmployeeService;
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



    //添加方法
    @RequestMapping(value = "/add.do", method = RequestMethod.POST)
    public String add(Employee employee) {
    	String LoginPassword = employee.getLoginPassword();
        MD5keyBean md5keyBean = new MD5keyBean();
        LoginPassword = md5keyBean.getkeyBeanofStr(LoginPassword);
        employee.setLoginPassword(LoginPassword);
    	employee.setStatus("01");
    	employeeServiceImpl.add(employee);
        //System.out.println("========================="+user);
        return "redirect:/user/show.do";
    }
    //显示所有用
    @RequestMapping(value = "/show.do", method = RequestMethod.GET)
    public String showEmployee(ModelMap modelMap) {
        List<Employee> list = employeeServiceImpl.getlAllEmployee();
        modelMap.addAttribute("user", list);
        return "user";
    }

    //删除方法使用Restful风格
    @RequestMapping(value = "/{id}/delete.do", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable int id) {
    	Employee employee = employeeServiceImpl.getEmployee(id);
    	employee.setStatus("00");
    	employeeServiceImpl.delete(employee);
        return "redirect:/user/show.do";
    }

    //此方法用于修改前的查询，用id来查询，使用Restful风格
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
        employee.setLoginPassword(loginPassword);
        employeeServiceImpl.update(employee);
        resultMap.put("status", Boolean.TRUE);
        return resultMap;
    }




}
