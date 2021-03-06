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

<div class="container-fluid hidden-print">
	<div class="row hidden-print">
		<div class="col-sm-3 col-md-2 sidebar hidden-print">
			<ul id='tree' class="nav nav-sidebar hidden-print">
			</ul>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(
			function() {
				$.post("${ctx}/menu.do", function(resp) {
					if (resp != null) {
						var title = resp.title;
						for (var i = 0; i < title.length; i++) {
							$("#title").html(
									"<li><a href='${ctx}"+title[i].menuUrl+"' >"
											+ title[i].menuName + "</a></li>"
											+ $("#title").html());
						}
						var tree = resp.tree;
						for (var i = 0; i < tree.length; i++) {
							$("#tree").html(
									"<li><a href='${ctx}"+tree[i].menuUrl+"' >"
											+ tree[i].menuName + "</a></li>"
											+ $("#tree").html());
						}
					}
				});
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
	function out() {
		document.location.href = "${ctx}/LogOut.do";
	}
	function main() {
		document.location.href = "${ctx}/reLogin.do";
	}
	function clearNoNum(obj) {
		//先把非数字的都替换掉，除了数字和.
		obj.value = obj.value.replace(/[^\d.-]/g, "");
		//必须保证第一个为数字而不是.
		obj.value = obj.value.replace(/^\./g, "");
		//保证只有出现一个.而没有多个.
		obj.value = obj.value.replace(/\.{2,}/g, ".");
		obj.value = obj.value.replace(/\-{2,}/g, "-");
		//保证.只出现一次，而不能出现两次以上
		obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");
		obj.value = obj.value.replace("-", "$#$").replace(/\-/g, "").replace("$#$", "-");
	}
</script>
