package com.ai.psims.web.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.psims.web.model.Storagecheck;
import com.ai.psims.web.service.IStoragecheckService;


/**
 * 
 * @author kqiteeq
 *
 */
@Controller
@RequestMapping("/")
public class StorageCheckController {

	@Resource(name="storagecheckServiceImpl")
	private IStoragecheckService storagecheckServiceImpl;
	
    
   /**
    * 查询过期商品列表
    * @param request
    * @return
    */
    @RequestMapping(value = "/tenAll.do", method = RequestMethod.GET)
    @ResponseBody
    public List<Storagecheck> seek(HttpServletRequest request, HttpServletResponse response){
    	List<Storagecheck> list=new ArrayList<Storagecheck>();
    	List<Storagecheck> storagecheckList=new ArrayList<Storagecheck>();
    	String number = request.getParameter("number");
    	if(number.equals("1")){
    		 storagecheckList = storagecheckServiceImpl.seekExpiration();
    	}else if(number.equals("2")){
    		storagecheckList = storagecheckServiceImpl.seekBExpiration();
    	}else if(number.equals("3")){
    		 storagecheckList = storagecheckServiceImpl.seekCExpiration();
    	}else if(number.equals("4")){
    		 storagecheckList = storagecheckServiceImpl.seekDExpiration();
    	}
    	for(Storagecheck storagecheck : storagecheckList){
	    	 Date goodsExpirationDate = storagecheck.getGoodsExpirationDate();
	    	 String days = daysBetween(new Date(),goodsExpirationDate);
	    	 storagecheck.setOverDate(days);
	    	 list.add(storagecheck);
    	}
    	return list;
    }
    /**
     * 查询商品库存列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/tensAll.do", method = RequestMethod.GET)
    @ResponseBody
    public List<Storagecheck> seeks(HttpServletRequest request, HttpServletResponse response){
    	List<Storagecheck> list=new ArrayList<Storagecheck>();
    	String number = request.getParameter("number");
    	if(number.equals("1")){
    		list = storagecheckServiceImpl.seekStore();
    	}else if(number.equals("2")){
    		list = storagecheckServiceImpl.seekBStore();
    	}else if(number.equals("3")){
    		list = storagecheckServiceImpl.seekCStore();
    	}else if(number.equals("4")){
    		list = storagecheckServiceImpl.seekDStore();
    	}
    	return list;
    }

    public String daysBetween(Date date1,Date date2)  
    {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date1);  
        long time1 = cal.getTimeInMillis();               
        cal.setTime(date2);  
        long time2 = cal.getTimeInMillis();       
        long between_days=(time2-time1)/(1000*3600*24);  
        long between_hours=((time2-time1)/(1000*3600))%24;  
          
       return between_days+"天"+between_hours+"小时";         
    }  

}
