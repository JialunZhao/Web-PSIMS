package com.ai.psims.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.ai.psims.web.model.Employee;
import com.ai.psims.web.model.Menu;
import com.ai.psims.web.service.IEmployeeService;
import com.ai.psims.web.service.IMenuService;
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
public class MenuController {

	@Resource(name="menuServiceImpl")
    private IMenuService menuServiceImpl;
	

    @RequestMapping(value = "/menu.do", method = RequestMethod.GET)
    public String getMenu(ModelMap modelMap) {
    	List<Menu> list = menuServiceImpl.getMenu();
    	modelMap.put("menu", list);
        return "all";
    }


}
