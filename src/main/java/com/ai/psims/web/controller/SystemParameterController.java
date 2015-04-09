package com.ai.psims.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ai.psims.web.model.Employee;
import com.ai.psims.web.model.SystemParameter;
import com.ai.psims.web.service.ISystemParameterService;
import com.ai.psims.web.util.MD5keyBean;


/**
 * 
 * @author kqiteeq
 *
 */
@Controller
@SessionAttributes("mysession")
@RequestMapping("/sys")
public class SystemParameterController {

	@Resource(name="systemParameterServiceImpl")
    private ISystemParameterService systemParameterServiceImpl;
	
	//添加方法
    @RequestMapping(value = "/add.do", method = RequestMethod.POST)
    public String add(SystemParameter sysParamete) {
    	systemParameterServiceImpl.add(sysParamete);
        //System.out.println("========================="+user);
        return "redirect:/sys/show.do";
    }
	//显示所有
    @RequestMapping(value = "/show.do", method = RequestMethod.GET)
    public String showParameter(ModelMap modelMap) {
        List<SystemParameter> list = systemParameterServiceImpl.getlAllParameter();
//        List<SystemParameter> list1 = systemParameterServiceImpl.getParameter();
        modelMap.addAttribute("sitting", list);
//        modelMap.addAttribute("parame", list1);
        return "sitting";
    }
}