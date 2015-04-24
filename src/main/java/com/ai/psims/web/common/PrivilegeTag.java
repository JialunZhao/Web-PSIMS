package com.ai.psims.web.common;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class PrivilegeTag extends TagSupport {
	
	private static final long serialVersionUID = 1L;
	
	private String power;  
	  
	    public String getPower() {  
	        return power;  
	    }  
	  
	    public void setPower(String power) {  
	        this.power = power;  
	    }  
	  
	    @Override  
	    public int doAfterBody() throws JspException {  
	        return super.doAfterBody();  
	    }  
	  
	    @Override  
	    public int doEndTag() throws JspException {  
	        return super.doEndTag();  
	    }  
	  
	    @Override  
	    public int doStartTag() throws JspException {  
	        HttpSession session = pageContext.getSession();  
	        String privilege = (String) session.getAttribute("privilege"); 
	        if(privilege!=null){
	        	String[] privileges = privilege.split(",");
	        	for(String p : privileges){
	        		if(p!=null&&p.length()!=0&&p.equals(power)){
	        			return EVAL_PAGE;  
	        		}
	        	}
	        }
	        return SKIP_BODY;  
	    }  
	
}
