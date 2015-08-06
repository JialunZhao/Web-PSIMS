<!DOCTYPE html>
<html>
<head lang="zh">
<meta charset="utf-8">
<%@ page pageEncoding="UTF-8"%>

<%@ include file="all2.jsp"%>
</head>
<body>

	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h3 class="page-header">客户管理</h3>

		<div class="row placeholders">
			<form class="form-inline" action="customer" method="get">
				<div class="form-group">
					<label for="query_customerName">客户名称：</label> <input type="text"
						class="form-control" id="query_customerName"
						name="query_customerName" placeholder="客户名称">
				</div>
				<div class="form-group">
					<label for="query_customerType">客户类型：</label> <select
						class="form-control" tabindex="1" id="query_customerType"
						name="query_customerType">
						<option value="0">请选择客户类型：</option>
						<option value="1">连锁</option>
						<option value="2">商户</option>
						<option value="3">散户</option>
						<option value="4">其它</option>
					</select>
				</div>
				<div class="form-group">
					<label for="query_contactName">联系人名称：</label> <input type="text"
						class="form-control" id="query_contactName"
						name="query_contactName" placeholder="联系人名称">
				</div>
				<div class="form-group">
					<label for="query_contactTel">联系人电话：</label> <input type="text"
						class="form-control" id="query_contactTel" name="query_contactTel"
						placeholder="联系人电话：">
				</div>
				<button type="submit" class="btn btn-primary">搜索</button>
			</form>
		</div>

		<div class="row placeholders ">
			<div class="col-sm-5">
				<priv:privilege power="客户管理.增删改">
					<button type="button" class="btn btn-primary" data-toggle="modal"
						data-target="#addcustomer">新增客户</button>
					<button type="button" id="excel" class="btn btn-primary">客户清单Excel导出</button>
				</priv:privilege>
			</div>
		</div>

		<h4 class="sub-header">客户清单</h4>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th class="chk" style="display: none"><input type="checkbox"
							aria-label="..."></th>
						<th>编号</th>
						<th>客户名称</th>
						<th>类型</th>
						<th>联系人名称</th>
						<th>联系人电话</th>
						<th>业务员</th>
						<th>客户地址</th>
						<th>区域</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="tbCustomers" items="${tbCustomers}">
						<tr data-toggle="tooltip" data-animation="false"
							data-placement="auto" title="备注：${tbCustomers.remark}">
							<td class="chk" style="display: none"><input type="checkbox"
								aria-label="..."></td>
							<td>${tbCustomers.customerId}</td>
							<td>${tbCustomers.customerName}</td>
							<td>${tbCustomers.customerType}</td>
							<td>${tbCustomers.contactName}</td>
							<td>${tbCustomers.contactTel}</td>
							<td>${tbCustomers.employeeName}</td>
							<td>${tbCustomers.contactAddr}</td>
							<td>${tbCustomers.area}</td>
							<priv:privilege power="客户管理.增删改">
								<td><a href="javascript:void(0);"
									onClick="modifyCurrentCustomer(this)">修改</a>/<a
									href="javascript:void(0);" onClick="delCurrentCustomer(this);">删除</a></td>
							</priv:privilege>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>



	<!-- 模态框（Modal） -->
	<!-- 添加客户模态框（Modal） -->
	<div class="modal fade" id="addcustomer" tabindex="-1" role="dialog"
		aria-labelledby="addcustomer" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">新增客户资料</h4>
				</div>
				<form id="addcustomerForm" action="addCustomer.do" method="post"
					onsubmit="return addcustomercheckNull();">
					<div class="modal-body">
						<div class="row">


							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">客户名称:</span> <input
									type="text" class="form-control add" placeholder="客户名称"
									name="customer_name" maxlength="200">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">客户编码:</span> <input
									type="text" class="form-control add" placeholder="客户编码"
									name="customer_code" maxlength="200">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">客户类型:</span> <select
									class="form-control addselect" tabindex="1"
									name="customer_type" placeholder="客户类型">
									<option value="0">请选择客户类型：</option>
									<option value="1">连锁</option>
									<option value="2">商户</option>
									<option value="3">散户</option>
									<option value="4">其它</option>
								</select>
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">结账方式:</span> <select
									class="form-control addselect" tabindex="1"
									name="checkout_code" placeholder="结账方式">
									<option value="0">请选择结账方式：</option>
									<c:forEach var="tbSystemParameters"
										items="${tbSystemParameters}">
										<option value="${tbSystemParameters.paramId}">${tbSystemParameters.ppValue}</option>
									</c:forEach>
								</select>
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">联系人名称:</span> <input
									type="text" class="form-control add" name="contact_name"
									placeholder="联系人名称" maxlength="20">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">联系人电话:</span> <input
									type="text" class="form-control add" name="contact_tel"
									placeholder="联系人电话" maxlength="20">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">客户地址:</span> <input
									type="text" class="form-control add" name="contact_addr"
									placeholder="客户地址" maxlength="200">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">客户区域:</span> <input
									type="text" class="form-control add" name="area"
									placeholder="客户区域" maxlength="20">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">客户电子邮箱:</span> <input
									type="email" class="form-control" name="email"
									placeholder="客户电子邮箱">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">业务员：</span> <select
									class="form-control addselect" name="employeeId" tabindex="1"
									id="employeeId" placeholder="业务员">
									<option value="0">请选择业务员：</option>
									<c:forEach var="tbEmployees" items="${tbEmployees}">
										<option value="${tbEmployees.employeeId}">${tbEmployees.employeeName}</option>
									</c:forEach>
								</select>
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">结账到期提醒：</span> <input
									type="text" class="form-control add" name="checkoutWarning"
									placeholder="结账到期提醒："><span class="input-group-addon">天</span>
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">备注：</span> <input
									type="text" class="form-control" name="remark"
									placeholder="备注：">
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="submit" class="btn btn-primary">确认新增</button>
					</div>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->


	<!-- 模态框（Modal） -->
	<!-- 修改客户模态框（Modal） -->
	<div class="modal fade" id="modifycustomer" tabindex="-1" role="dialog"
		aria-labelledby="modifycustomer" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">修改客户资料</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<form id="modify_customerForm" action="action.aspx" method="post">
							<input type="hidden" id="modify_customerId"
								name="modify_customerId" value="">
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">客户名称:</span> <input
									type="text" class="form-control modify"
									id="modify_customerName" name="modify_customerName"
									placeholder="客户名称" value="">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">客户编码:</span> <input
									type="text" class="form-control" id="modify_customerCode"
									name="modify_customerCode" placeholder="客户编码" value="">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">客户类型:</span> <select
									class="form-control modifyselect" tabindex="1"
									id="modify_customerType" name="modify_customerType">
									<option value="0">请选择客户类型：</option>
									<option value="1" selected>连锁</option>
									<option value="2">商户</option>
									<option value="3">散户</option>
									<option value="4">其它</option>
								</select>
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">结账方式:</span> <select
									class="form-control modifyselect" tabindex="1"
									name="modify_checkout_code" id="modify_checkout_code"
									placeholder="结账方式">
									<option value="0">请选择结账方式：</option>
									<c:forEach var="tbSystemParameters"
										items="${tbSystemParameters}">
										<option value="${tbSystemParameters.paramId}">${tbSystemParameters.ppValue}</option>
									</c:forEach>
								</select>
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">联系人名称:</span> <input
									type="text" class="form-control modify" id="modify_contactName"
									name="modify_contactName" placeholder="联系人名称" value="">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">联系人电话:</span> <input
									type="text" class="form-control modify" id="modify_contactTel"
									name="modify_contactTel" placeholder="联系人电话" value="">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">客户地址:</span> <input
									type="text" class="form-control modify" id="modify_contactAddr"
									name="modify_contactAddr" placeholder="客户地址" value="">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">客户区域:</span> <input
									type="text" class="form-control modify" name="modify_area"
									id="modify_area"
									placeholder="客户区域" maxlength="20">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">客户电子邮箱:</span> <input
									type="text" class="form-control" id="modify_email"
									name="modify_email" placeholder="客户电子邮箱" value="">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">业务员：</span> <select
									class="form-control modifyselect" name="modify_employeeId"
									tabindex="1" id="modify_employeeId">
									<option value="0">请选择业务员：</option>
									<c:forEach var="tbEmployees" items="${tbEmployees}">
										<option value="${tbEmployees.employeeId}">${tbEmployees.employeeName}</option>
									</c:forEach>
								</select>
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">结账到期提醒：</span> <input
									type="text" class="form-control modify"
									name="modify_checkoutWarning" id="modify_checkoutWarning"
									placeholder="结账到期提醒："><span class="input-group-addon">天</span>
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">备注：</span> <input
									type="text" class="form-control" id="modify_remark"
									name="modify_remark" placeholder="备注：" value="">
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary"
						onClick="modifyCurrentCustomerInfo(this)">确认修改</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<!-- 模态框（Modal） -->
	<!-- 修改客户模态框（Modal） -->
	<div class="modal fade" id="deletecustomer" tabindex="-1" role="dialog"
		aria-labelledby="modifycustomer" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">删除客户资料</h4>
				</div>
				<div class="modal-body">
					请确认是否删除
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary"
						onClick="modifyCurrentCustomerInfo(this)">确认删除</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
	<script src="<%=path%>/js/vendor/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<%=path%>/js/vendor/video.js"></script>
	<script src="<%=path%>/js/flat-ui.min.js"></script>
	<script src="<%=path%>/js/customer.js"></script>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$("#delbtn").click(function() {
								$("#delbtn").hide();
								$("#delcommit").show();
								$("#delcancle").show();
								$(".chk").show();
							});
							$("#delcommit").click(function() {
								$("#delbtn").show();
								$("#delcommit").hide();
								$("#delcancle").hide();
								$(".chk").hide();
							});
							$("#delcancle").click(function() {
								$("#delbtn").show();
								$("#delcommit").hide();
								$("#delcancle").hide();
								$(".chk").hide();
							});
							$("#excel")
									.click(
											function() {
												window.location.href = "customerReportExecl?query_customerName=${customer_name}&query_customerType=${customer_type}&query_contactName=${contact_name}&query_contactTel=${contact_tel}";
											});
							$(function() {
								$('[data-toggle="tooltip"]').tooltip()
							})
						});
	</script>



</body>
</html>