<!DOCTYPE html>
<html>
<head lang="zh">
<meta charset="utf-8">
<%@ page pageEncoding="UTF-8"%>

<%@ include file="all2.jsp"%>
</head>
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
				<button type="button" id="delbtn" class="btn btn-primary">批量删除客户</button>
			</priv:privilege>
			<button type="button" id="delcommit" class="btn btn-primary"
				style="display: none">确认删除客户</button>
			<button type="button" id="delcancle" class="btn btn-primary"
				style="display: none">取消</button>
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
					<th>客户地域</th>
					<th>客户地址</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="customers" items="${customers}">
					<tr>
						<td class="chk" style="display: none"><input type="checkbox"
							aria-label="..."></td>
						<td>${customers.customerId}</td>
						<td>${customers.customerName}</td>
						<td>${customers.customerType}</td>
						<td>${customers.contactName}</td>
						<td>${customers.contactTel}</td>
						<td>${customers.area}</td>
						<td>${customers.contactAddr}</td>
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
			<form id="addcustomerForm" action="addCustomer.do"  method="post" onsubmit="location.href='customer';">
			
			<div class="modal-body">
				<div class="row">
					

						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">客户名称:</span> <input
								type="text" class="form-control" placeholder="客户名称"
								name="customer_name" maxlength="200">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">客户类型:</span> <select
								class="form-control" tabindex="1" name="customer_type">
								<option value="0">请选择客户类型：</option>
								<option value="1">连锁</option>
								<option value="2">商户</option>
								<option value="3">散户</option>
								<option value="4">其它</option>
							</select>
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">联系人名称:</span> <input
								type="text" class="form-control" name="contact_name"
								placeholder="联系人名称" maxlength="20">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">联系人电话:</span> <input
								type="text" class="form-control" name="contact_tel"
								placeholder="联系人电话" maxlength="20">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">客户地址:</span> <input
								type="text" class="form-control" name="contact_addr"
								placeholder="客户地址" maxlength="200">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">客户电子邮箱:</span> <input
								type="email" class="form-control" name="email"
								placeholder="客户电子邮箱">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">客户地域：</span> <input
								type="text" class="form-control" name="area" placeholder="客户地域：">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">备注：</span> <input type="text"
								class="form-control" name="remark" placeholder="备注：">
						</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				<button type="submit" class="btn btn-primary" >确认新增</button>
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
								type="text" class="form-control" id="modify_customerName"
								name="modify_customerName" placeholder="客户名称" value="张老坎">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">客户类型:</span> <select
								class="form-control" tabindex="1" id="modify_customerType"
								name="modify_customerType">
								<option value="0">请选择客户类型：</option>
								<option value="1" selected>连锁</option>
								<option value="2">商户</option>
								<option value="3">散户</option>
								<option value="4">其它</option>
							</select>
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">联系人名称:</span> <input
								type="text" class="form-control" id="modify_contactName"
								name="modify_contactName" placeholder="联系人名称" value="老张">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">联系人电话:</span> <input
								type="text" class="form-control" id="modify_contactTel"
								name="modify_contactTel" placeholder="联系人电话"
								value="139012345678">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">客户地址:</span> <input
								type="text" class="form-control" id="modify_contactAddr"
								name="modify_contactAddr" placeholder="客户地址" value="朝阳区朝阳路18号">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">客户电子邮箱:</span> <input
								type="text" class="form-control" id="modify_email"
								name="modify_email" placeholder="客户电子邮箱" value="zhanglk@163.com">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">客户地域：</span> <input
								type="text" class="form-control" id="modify_area"
								name="modify_area" placeholder="客户地域：" value="朝阳">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">备注：</span> <input type="text"
								class="form-control" id="modify_remark" name="modify_remark"
								placeholder="备注：" value=" 张老坎 连锁 老张 139012345678 朝阳 朝阳区朝阳路18号 ">
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
<!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
<script src="<%=path%>/js/vendor/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<%=path%>/js/vendor/video.js"></script>
<script src="<%=path%>/js/flat-ui.min.js"></script>
<script src="<%=path%>/js/customer.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
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
	});
</script>
</body>
</html>