package com.ai.psims.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.ai.psims.web.model.TbMenu;
import com.ai.psims.web.service.IMenuService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
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
	

    @RequestMapping(value = "/menu.do")
    @ResponseBody
    public Map<String,List<TbMenu>> getMenu(ModelMap modelMap,HttpSession session) {
    	String privilege = (String)session.getAttribute("privilege");
    	if(privilege==null||privilege.length()==0){
    		return null;
    	}else{
    		List<TbMenu> list = menuServiceImpl.getMenu();
    		List<TbMenu> menusTit = new ArrayList<TbMenu>();
    		List<TbMenu> menusTree = new ArrayList<TbMenu>();
    		String[] privs = privilege.split(",");
    		for(TbMenu m : list){
        		String priv = m.getPriv();
        		for(String pri : privs){
        			if(pri.equals(priv)){
        				String menu = m.getMenuStatus();
        				if(menu==null||!menu.equals("01")){
        					menusTree.add(m);
        					continue;
        				}
        				menusTit.add(m);
        				continue;
        			}
        		}
        	}
    		Map<String,List<TbMenu>> map = new HashMap<String,List<TbMenu>>();
    		map.put("title", menusTit);
    		map.put("tree", menusTree);
    		return map;
    	}
    }


}
