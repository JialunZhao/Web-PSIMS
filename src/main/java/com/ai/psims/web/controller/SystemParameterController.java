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

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.document.AbstractExcelView;

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
    	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
    	TbSystemParameter sysParamete = systemParameterBussinessImpl.getSysById(paramId);
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
    		sysParamete.setpRemark(ppValue);
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
    @RequestMapping(value = "/{paramId}/execl")
   	public View execl(@PathVariable int paramId,Model model, HttpServletRequest request) {
    	final List<TbSystemParameterLog> sysParametep = systemParameterBussinessImpl.getSysByLogId(paramId);
   		View view = new AbstractExcelView() {
   			@Override
   			public void buildExcelDocument(@SuppressWarnings("rawtypes") Map map, HSSFWorkbook workbook,
   					HttpServletRequest request, HttpServletResponse response)
   					throws Exception {
   				logger.info("------------1.初始化-------------");
   				List<TbSystemParameterLog> tbSystemParameterLogs = new ArrayList<TbSystemParameterLog>();
   		    	List<TbSystemParameterLog> sysParamete = sysParametep;
   		    	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   		    	if(sysParamete.size()>0){
   		    		for(TbSystemParameterLog log : sysParamete){
   		    			Date logDatetime = log.getLogDatetime();
   		    			String format = df.format(logDatetime);
   		    			log.setPpKey(format);
   		    			tbSystemParameterLogs.add(log);
   		    		}
   		    	}
   				
   				logger.info("------------建立 Excel -Sheet-------------");
   				HSSFSheet sheet = workbook.createSheet("库存清单");
   				logger.info("------------设置行列的默认宽度和高度-------------");
   				sheet.setColumnWidth(0, 32 * 80);// 对A列设置宽度为180像素
   				sheet.setColumnWidth(1, 32 * 180);
   				sheet.setColumnWidth(2, 32 * 180);
   				sheet.setColumnWidth(3, 32 * 120);
   				sheet.setColumnWidth(4, 32 * 120);
   				sheet.setColumnWidth(5, 32 * 120);
   				sheet.setColumnWidth(6, 32 * 120);
   				
   				int rowNum = 0;
   				int idx = 0;
   				logger.info("------------建立标题-------------");
   				HSSFRow header = sheet.createRow(rowNum++);
   				header.createCell(idx++).setCellValue("编号");
   				header.createCell(idx++).setCellValue("奖金池名称");
   				header.createCell(idx++).setCellValue("修改时间");
   				header.createCell(idx++).setCellValue("原始奖金");
   				header.createCell(idx++).setCellValue("增加");
   				header.createCell(idx++).setCellValue("减少");
   				header.createCell(idx++).setCellValue("最终余额");
   				HSSFRow row;
   				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  

   				for (TbSystemParameterLog systemParameterLog : tbSystemParameterLogs) {
   					idx = 0;
   					row = sheet.createRow(rowNum++);
   					row.createCell(idx++).setCellValue(systemParameterLog.getLogId().toString().equals(null) ? "无" : systemParameterLog.getLogId().toString());
   					row.createCell(idx++).setCellValue(systemParameterLog.getPpDesc().toString().equals(null) ? "无" : systemParameterLog.getPpDesc().toString());
   					row.createCell(idx++).setCellValue(systemParameterLog.getPpKey().toString().equals(null) ? "无" : systemParameterLog.getPpKey().toString());
   					row.createCell(idx++).setCellValue(systemParameterLog.getPpValue().toString().equals(null) ? "无" : systemParameterLog.getPpValue().toString());
   					float pRemark = Float.parseFloat(systemParameterLog.getpRemark());
   					float PpValue = Float.parseFloat(systemParameterLog.getPpValue());
   					row.createCell(idx++).setCellValue(pRemark-PpValue);
   					row.createCell(idx++).setCellValue(PpValue-pRemark);
   					row.createCell(idx++).setCellValue(systemParameterLog.getpRemark().toString().equals(null) ? "无" : systemParameterLog.getpRemark().toString());
   				}
   			}
   		};
   		return view;
   	}

}