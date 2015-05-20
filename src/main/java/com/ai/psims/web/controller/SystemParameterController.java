package com.ai.psims.web.controller;

import java.util.Date;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ai.psims.web.business.ISystemParameterBussiness;
import com.ai.psims.web.model.TbSystemParameter;


/**
 * 
 * @author kqiteeq
 *
 */
@Controller
@SessionAttributes("mysession")
@RequestMapping("/sys")
public class SystemParameterController {

	
	@Resource(name="systemParameterBussinessImpl")
	private ISystemParameterBussiness systemParameterBussinessImpl;
	
	
	//添加方法
    @RequestMapping(value = "/add.do", method = RequestMethod.POST)
    public String add(TbSystemParameter sysParamete) {
    	if(sysParamete.getPpDesc()!=null && sysParamete.getPpDesc().length()>0){
	    	sysParamete.setpStatus("01");
	    	sysParamete.setpKey("SYS");
	    	sysParamete.setpCreatetime(new Date());
	    	sysParamete.setPpValue(sysParamete.getPpDesc());
	    	systemParameterBussinessImpl.add(sysParamete);
	//    	systemParameterServiceImpl.add(sysParamete);
	        //System.out.println("========================="+user);
    	}
    	return "redirect:/sys/show.do";
    }
	//显示所有
    @RequestMapping(value = "/show.do", method = RequestMethod.GET)
    public String showParameter(ModelMap modelMap) {
        List<TbSystemParameter> list = systemParameterBussinessImpl.getlAllParameter();
//        List<TbSystemParameter> list1 = systemParameterServiceImpl.getParameter();
        modelMap.addAttribute("sitting", list);
//        modelMap.addAttribute("parame", list1);
        return "sitting";
    }
    
    @RequestMapping(value = "/{paramId}/toUpdate.do", method = RequestMethod.GET)
    @ResponseBody
    public TbSystemParameter toUpdate(@PathVariable int paramId) {
    	TbSystemParameter sysParamete = systemParameterBussinessImpl.getSysById(paramId);
    	systemParameterBussinessImpl.addRecord(sysParamete);
        return sysParamete;
    }
  //修改方法
    @RequestMapping(value = "/update.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response) {
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	String ppDesc = request.getParameter("ppDesc");
    	String pDesc = request.getParameter("pDesc");
    	int paramId = Integer.parseInt(request.getParameter("paramId"));
    	String pKey = request.getParameter("pKey");
    	String ppValueint1 = request.getParameter("ppValueint");
    	long ppValueint = 0;
    	if(ppValueint1!=null && ppValueint1!=""){
    		ppValueint = Long.parseLong(ppValueint1);
    	}
    	TbSystemParameter systemParameter = new TbSystemParameter();
    	systemParameter.setPpDesc(ppDesc);
    	systemParameter.setpDesc(pDesc);
    	systemParameter.setParamId(paramId);
    	systemParameter.setpKey(pKey);
    	systemParameter.setPpValueint(ppValueint);
    	systemParameterBussinessImpl.update(systemParameter);
        resultMap.put("status", Boolean.TRUE);
        return resultMap;
    }
    
    @RequestMapping(value = "/{id}/delete.do", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable int id) {
    	TbSystemParameter sysParamete = systemParameterBussinessImpl.getSysById(id);
    	sysParamete.setpStatus("00");
    	systemParameterBussinessImpl.delete(sysParamete);
    	systemParameterBussinessImpl.addRecord(sysParamete);
        return "redirect:/sys/show.do";
    }
}