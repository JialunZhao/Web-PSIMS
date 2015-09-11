package com.ai.psims.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.ai.psims.web.model.TbEmployee;
import com.ai.psims.web.model.TbEmployeeExample;
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
public class EmployeeController extends BaseController{
	
	private static final Logger logger = LoggerFactory
			.getLogger(StorageCheckReportController.class);

	@Resource(name="employeeServiceImpl")
    private IEmployeeService employeeServiceImpl;
	
	@Resource(name="privilegeServiceImpl")
	private IPrivilegeService privilegeServiceImpl;

	@RequestMapping(value="/check.do")
	@ResponseBody
	public Boolean check(@RequestParam("name") String name){
		List<TbEmployee> emList = employeeServiceImpl.getEmployee(name);
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
    public String add(TbEmployee employee,HttpServletRequest request) {
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
			List<TbEmployee> emList = employeeServiceImpl.getEmployee(employee.getEmployeeCode());
			TbEmployee em = emList.get(0);
			pri.setUserId(em.getEmployeeId());
			privilegeServiceImpl.add(pri);
    	}
        return "redirect:/user/show.do";
    }
    //显示所有用
    @RequestMapping(value = "/show.do", method = RequestMethod.GET)
    public String showEmployee(ModelMap modelMap) {
        List<TbEmployee> list = employeeServiceImpl.getlAllEmployee();
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
        	List<TbEmployee> list1 = employeeServiceImpl.getlAllEmployee();
        	modelMap.addAttribute("user", list1);
        	return "user";
        }
    	List<TbEmployee> list = employeeServiceImpl.getEmployee(employeeName,sex,role,contactTel);
    	modelMap.addAttribute("user", list);
    	return "user";
    }

    @RequestMapping(value = "/{id}/delete.do", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable int id) {
    	TbEmployee employee = employeeServiceImpl.getEmployee(id);
    	employee.setStatus("00");
    	employeeServiceImpl.delete(employee);
        return "redirect:/user/show.do";
    }
    

    //服务器查询到数据把数据放到对象中，再通过键值来取
    @RequestMapping(value = "/{employeeId}/toUpdate.do", method = RequestMethod.GET)
    @ResponseBody
    public TbEmployee toUpdate(@PathVariable int employeeId) {
    	TbEmployee employee = employeeServiceImpl.getUserById(employeeId);
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
        TbEmployee employee = new TbEmployee();
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
    
    @RequestMapping(value = "/execl")
	public View execl(Model model, HttpServletRequest request) {
		logger.info("------------以 Apache POI 实现 AbstractExcelView-------------");
		View view = new AbstractExcelView() {
			@Override
			public void buildExcelDocument(@SuppressWarnings("rawtypes") Map map, HSSFWorkbook workbook,
					HttpServletRequest request, HttpServletResponse response)
					throws Exception {
				logger.info("------------1.初始化-------------");
				List<TbEmployee> tbEmployees = new ArrayList<TbEmployee>();
				TbEmployeeExample tbEmployeeExample = new TbEmployeeExample();
				TbEmployeeExample.Criteria criteria = tbEmployeeExample.createCriteria();
				
				logger.info("------------4.业务处理-------------");
				criteria.andStatusEqualTo("01");
				tbEmployees = employeeServiceImpl.selectByExample(tbEmployeeExample);
				
				logger.info("------------建立 Excel -Sheet-------------");
				HSSFSheet sheet = workbook.createSheet("库存清单");
				logger.info("------------设置行列的默认宽度和高度-------------");
				sheet.setColumnWidth(0, 32 * 80);// 对A列设置宽度为180像素
				sheet.setColumnWidth(1, 32 * 80);
				sheet.setColumnWidth(2, 32 * 80);
				sheet.setColumnWidth(3, 32 * 120);
				sheet.setColumnWidth(4, 32 * 120);
				sheet.setColumnWidth(5, 32 * 120);
				sheet.setColumnWidth(6, 32 * 80);
				sheet.setColumnWidth(7, 32 * 180);
//				sheet.setColumnWidth(8, 32 * 180);
//				sheet.setColumnWidth(9, 32 * 180);
				
				int rowNum = 0;
				int idx = 0;
				logger.info("------------建立标题-------------");
				HSSFRow header = sheet.createRow(rowNum++);
				header.createCell(idx++).setCellValue("编号");
				header.createCell(idx++).setCellValue("员工姓名");
				header.createCell(idx++).setCellValue("员工性别");
				header.createCell(idx++).setCellValue("身份证号");
				header.createCell(idx++).setCellValue("联系电话");
				header.createCell(idx++).setCellValue("联络地址");
				header.createCell(idx++).setCellValue("职务");
				header.createCell(idx++).setCellValue("备注");
				logger.info("------------输出内容-------------");
				HSSFRow row;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  

				for (TbEmployee tbEmployee : tbEmployees) {
					idx = 0;
					row = sheet.createRow(rowNum++);
					row.createCell(idx++).setCellValue(tbEmployee.getEmployeeId().equals(null)||tbEmployee.getEmployeeId().equals("") ? "无" : tbEmployee.getEmployeeId().toString());
					row.createCell(idx++).setCellValue(tbEmployee.getEmployeeName().equals(null)||tbEmployee.getEmployeeName().equals("") ? "无" : tbEmployee.getEmployeeName());
					if(tbEmployee.getSex().equals("1")){
						row.createCell(idx++).setCellValue("男");
					}
					if(tbEmployee.getSex().equals("2")){
						row.createCell(idx++).setCellValue("女");
					}
					if(tbEmployee.getSex().equals(null)||tbEmployee.getSex().equals("")){
						row.createCell(idx++).setCellValue("无");
					}
					row.createCell(idx++).setCellValue(tbEmployee.getIdcard().equals(null)||tbEmployee.getIdcard().equals("")? "无" : tbEmployee.getIdcard().toString());
					row.createCell(idx++).setCellValue(tbEmployee.getContactTel().equals(null)||tbEmployee.getContactTel().equals("") ? "无" : tbEmployee.getContactTel().toString());
					row.createCell(idx++).setCellValue(tbEmployee.getContactAddr().equals(null)||tbEmployee.getContactAddr().equals("") ? "无" : tbEmployee.getContactAddr().toString());
					if(tbEmployee.getRole().equals("1")){
						row.createCell(idx++).setCellValue("销售");
					}
					if(tbEmployee.getRole().equals("2")){
						row.createCell(idx++).setCellValue("管理");
					}
					if(tbEmployee.getRole().equals("3")){
						row.createCell(idx++).setCellValue("财务");
					}
					if(tbEmployee.getRole().equals("4")){
						row.createCell(idx++).setCellValue("物流");
					}
					if(tbEmployee.getRole().equals("5")){
						row.createCell(idx++).setCellValue("其它");
					}
					if(tbEmployee.getRole().equals(null)||tbEmployee.getRole().equals("")){
						row.createCell(idx++).setCellValue("无");
					}
					row.createCell(idx++).setCellValue(tbEmployee.getRemark().equals(null)||tbEmployee.getRemark().equals("") ? "无" : tbEmployee.getRemark().toString());
				}
			}
		};
		logger.info("------------5.返回结果-------------");
		logger.info("------------回传 View 对象，返回生成的 Excel 档-------------");
		return view;
	}



}
