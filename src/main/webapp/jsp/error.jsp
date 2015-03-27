<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Error Page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
	<H2>Exception: ${exception }</H2> 
	<a href="javascript:document.getElementById('show').style.display = 'block';void(0);">
		详细信息
	</a> 
	<div id="show" style="color: red; display: none;">
		<% Exception ex = (Exception)request.getAttribute("exception"); %> 
		
		<% ex.printStackTrace(new java.io.PrintWriter(out)); %>
	</div> 
  </body>
</html>
