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
<title>供销存系统DEMO</title>

<!-- Loading Bootstrap -->
<link href="${ctx}/css/bootstrap/bootstrap.min.css" rel="stylesheet">

<!-- Loading Flat UI -->
<link href="${ctx}/css/flatUI/flat-ui.min.css" rel="stylesheet">
<link href="${ctx}/css/signin.css" rel="stylesheet">


<link rel="shortcut icon" href="${ctx}/img/favicon.ico">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
<!--[if lt IE 9]>
      <script src="./js/vendor/html5shiv.js"></script>
      <script src="./js/vendor/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="container">

		<form class="form-signin">
			<h2 class="form-signin-heading">用户登录</h2>
			<label for="inputEmail" class="sr-only">用户名</label> <input
				type="text" id="inputEmail" class="form-control" placeholder="用户名"
				required autofocus> <label for="inputPassword"
				class="sr-only">密码</label> <input type="password" id="inputPassword"
				class="form-control" placeholder="密码" required>
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">记住密码
				</label>
			</div>
			<a class="btn btn-lg btn-primary btn-block" onclick="login()">登录</a>
		</form>
		<h5 id="errorcontent"></h5>


	</div>
	<!-- /container -->
	<!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
	<script src="${ctx}/js/vendor/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${ctx}/js/vendor/video.js"></script>
	<script src="${ctx}/js/flat-ui.min.js"></script>
	<script type="text/javascript">
		<script type="text/javascript">
		function login() {
			var messageLabel = $("#errorcontent");
			alert(messageLabel);
			messageLabel.html("");

			/*
			 *$("form").serializeArray()

			 [{"name":"username","value":""},{"name":"password","value":""}]

			 $("form").serializeObject()
			 {"username":"","password":""}

			 serializeObject仅适用于name值不重复的情况,若name值重复,则取第一个,转换成json对象
			 *
			 * */
			var obj = {
				username : $("#username").val(),
				password : $("#password").val()
			};
			//        alert(obj);

			//     OR

			//            var o = $("#loginForm").serializeObject();
			//        var obj = {};
			//        var obj = {};
			//        obj.username = $("[name=username]").val();
			//        obj.password = $("[name=password]").val();

			//          JSON.parse将 JSON 字符串转换成对象。
			//         JSON.stringify将一个对象转换为JSON字符串
			//        var obj = JSON.stringify({username: $('#username').val(), password: $('#password').val()});
			//alert(obj);

			if (obj.username == '') {
				messageLabel.html("<div style='color:red'>*用户名不能为空</div>");
				return false;
			}
			if (obj.password == '') {
				messageLabel.html("<div style='color:red'>*密码不能为空</div>");
				return false;
			}

			$.ajax({
				url : '${ctx}/Login.do',
				type : 'post',
				//            dataType: 'json',
				//            contentType:'application/json',
				data : obj,
				success : function(messageRespon) {
					var messageInfor = eval("(" + messageRespon + ")");
					//      			alert(messageInfor.status);
					if (messageInfor.status) {
						messageLabel.html("<div style='color:limegreen'>"
								+ messageInfor.message + "</div>");
						document.location.href = "${ctx}/reLogin.do";
					} else {
						messageLabel.html("<div style='color:red'>"
								+ messageInfor.message + "</div>");
					}
				},
				error : function(messageRespon) {

				}
			})
		}
	</script>
</body>
</html>
