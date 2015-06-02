package com.ai.psims.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.ai.psims.web.model.TbSystemParameterLog;


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
    //奖金池历史查询
    @RequestMapping(value = "/{paramId}/showPrizePool.do", method = RequestMethod.GET)
    @ResponseBody
    public List<TbSystemParameterLog> showPrizePool(@PathVariable int paramId) throws ParseException {
    	List<TbSystemParameterLog> list = new ArrayList<TbSystemParameterLog>();
    	List<TbSystemParameterLog> sysParamete = systemParameterBussinessImpl.getSysByLogId(paramId);
    	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
    	if(sysParamete.size()>0){
    		for(TbSystemParameterLog log : sysParamete){
    			Date logDatetime = log.getLogDatetime();
    			String format = df.format(logDatetime);
    			log.setPpKey(format);
    			list.add(log);
    		}
    	}
    	return list;
    }
    
    @RequestMapping(value = "/{paramId}/toUpdate.do", method = RequestMethod.GET)
    @ResponseBody
    public TbSystemParameter toUpdate(@PathVariable int paramId) {
    	TbSystemParameter sysParamete = systemParameterBussinessImpl.getSysById(paramId);
//    	systemParameterBussinessImpl.addRecord(sysParamete);
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
    	String ppValue = request.getParameter("ppValue");
    	TbSystemParameter systemParameter = new TbSystemParameter();
    	systemParameter.setPpDesc(ppDesc);
    	systemParameter.setpDesc(pDesc);
    	systemParameter.setParamId(paramId);
    	systemParameter.setpKey(pKey);
    	systemParameter.setPpValue(ppValue);
    	systemParameterBussinessImpl.update(systemParameter);
    	if(systemParameter.getPpValue()!=null){
    		TbSystemParameter sysParamete = systemParameterBussinessImpl.getSysById(paramId);
    		systemParameterBussinessImpl.addRecord(sysParamete);
    	}
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