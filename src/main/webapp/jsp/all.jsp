<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="${ctx}/img/favicon.ico">
    <title>北京市金瑞超达商贸有限公司-食品库存管理系统DEMO</title>
	<META HTTP-EQUIV="pragma" CONTENT="no-cache"> 
	<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate"> 
	<META HTTP-EQUIV="expires" CONTENT="Wed, 26 Feb 1997 08:21:57 GMT"> 
    <!-- Loading Bootstrap -->
    <link href="${ctx}/css/bootstrap/bootstrap.min.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="${ctx}/css/flatUI/flat-ui.min.css" rel="stylesheet">
    <link href="${ctx}/css/dashboard.css" rel="stylesheet">
    <link href="${ctx}/css/index.css" rel="stylesheet">

	
    <link rel="shortcut icon" href="${ctx}/img/favicon.ico">
    <script type="text/javascript" src="${ctx}/js/vendor/jquery.min.js"></script>

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
      <script src="./js/vendor/html5shiv.js"></script>
      <script src="./js/vendor/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
    	$(document).ready(function(){
    	  	$.ajax({
    	  		url : '${ctx}/menu.do',
    	  		type : 'get',
    	  	})
    	});
        function emAu() {
        	document.location.href = "${ctx}/user/show.do";
        	
//             $.ajax({
//                 url: '${ctx}/user/show.do',
//                 type: 'get'
                
//             })
        }
        function sysSet() {
        	document.location.href = "${ctx}/sys/show.do";
        }
        function main() {
        	document.location.href = "${ctx}/reLogin.do";
        }
    </script>
  </head>
  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#" onclick="main()">北京市金瑞超达商贸有限公司-食品库存管理系统DEMO</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">;
            <li><a href="#" onclick="sysSet()">系统设置</a></li>
            <li><a href="#" onclick="emAu()">员工权限</a></li>
            <li><a href="#">帮助</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li><a href="./customer.html">客户管理</a></li>
            <li><a href="./provider.html">供应商</a></li>
            <li><a href="./goods.html">商品管理</a></li>
            <li><a href="./storehouse.html">仓库管理</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="./import.html">货品入库</a></li>
            <li><a href="./sales.html">销售出库</a></li>
            <li><a href="#">退货管理</a></li>
            <li><a href="#">有效期调整</a></li>
            <li><a href="#">销毁出库</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="./recoveryimport.html">回收物入库</a></li>
            <li><a href="./recoveryexport.html">回收物出库</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="#">统计报表</a></li>
          </ul>
        </div>
        
        </body>
</html>