<%@ page import="com.ai.psims.web.util.Constants"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://psims.ai.com/" prefix="priv"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String date = sdf.format(new Date());
%>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="${ctx}/img/favicon.ico">
<title>北京市金瑞超达商贸有限公司-食品库存管理系统</title>
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


<nav class="navbar navbar-inverse navbar-fixed-top hidden-print">
	<div class="container-fluid hidden-print">
		<div class="navbar-header hidden-print">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand hidden-print" href="#" onclick="main()">北京市金瑞超达商贸有限公司-食品库存管理系统</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse hidden-print">
			<ul id='title' class="nav navbar-nav navbar-right hidden-print">
				<li><a href="#" onclick="out()">退出</a></li>
				<li><a href="#">帮助</a></li>
			</ul>
		</div>
	</div>
</nav>
<script>
	function main() {
		document.location.href = "${ctx}/reLogin.do";
	}
</script>


