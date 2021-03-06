<%@page import="com.ai.psims.web.util.Constants"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String date = sdf.format(new Date());
%>
<%@ include file="all.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h3 class="page-header">仓库管理</h3>

	<div class="row placeholders">
		<form class="form-inline" action="storehouse" method="get">
			<div class="form-group">
				<label for="query_storehouseName">仓库名称：</label> <input type="text"
					class="form-control" id="query_storehouseName"
					name="query_storehouseName" placeholder="仓库名称">
			</div>
			<div class="form-group">
				<label for="query_type">仓库类型：</label> <select class="form-control"
					id="query_type" name="query_storehouseType" tabindex="1">
					<option value="0">请选择仓库类型：</option>
					<option value="1">通用仓库</option>
					<option value="2">专用仓库</option>
					<option value="3">中转仓库</option>
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
			<priv:privilege power="仓库管理.增删改">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#addStorehouse">新增仓库</button>
				<button type="button" id="excel" class="btn btn-primary">仓库清单Excel导出</button>
			</priv:privilege>
		</div>
	</div>

	<h4 class="sub-header">仓库清单</h4>
	<div class="table-responsive">
		<table class="table table-striped">
			<thead>
				<tr>
					<th class="chk" style="display: none"><input type="checkbox"
						aria-label="..."></th>
					<th>编号</th>
					<th>仓库名称</th>
					<th>类型</th>
					<th>联系人名称</th>
					<th>联系人电话</th>
					<th>仓库地地址</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="storehouses" items="${storehouses}">
					<tr data-toggle="tooltip" data-animation="false"
							data-placement="auto" title="备注：${storehouses.remark}">
						<td class="chk" style="display: none"><input type="checkbox"
							aria-label="..."></td>
						<td>${storehouses.storehouseId}</td>
						<td>${storehouses.storehouseName}</td>
						<td>${storehouses.type}</td>
						<td>${storehouses.contactName}</td>
						<td>${storehouses.contactTel}</td>
						<td>${storehouses.contactAddress}</td>
						<priv:privilege power="仓库管理.增删改">
							<td><a href="javascript:void(0);"
								onClick="modifyCurrentStorehouse(this)">修改</a>/<a
								href="javascript:void(0);" onClick="delCurrentStorehouse(this);">删除</a></td>

						</priv:privilege>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</div>
</div>


<!-- 模态框（Modal） -->
<!-- 添加仓库模态框（Modal） -->
<div class="modal fade" id="addStorehouse" tabindex="-1" role="dialog"
	aria-labelledby="addStorehouse" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">新增仓库资料</h4>
			</div>
			<form id="addStorehouseForm">
				<div class="modal-body">
					<div class="row">

						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">仓库名称:</span> <input
								type="text" class="form-control add" name="storehouseName"
								placeholder="仓库名称" maxlength="200">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">仓库类型:</span> <select
								class="form-control  addselect" name="type" tabindex="1" placeholder="仓库类型">
								<option value="0">请选择仓库类型：</option>
								<option value="1">通用仓库</option>
								<option value="2">专用仓库</option>
								<option value="3">中转仓库</option>
								<option value="4">其它</option>
							</select>
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">联系人名称:</span> <input
								type="text" class="form-control add" name="contactName"
								placeholder="联系人名称" maxlength="10">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">联系人电话:</span> <input
								type="text" class="form-control" name="contactTel"
								placeholder="联系人电话" maxlength="20">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">仓库地址:</span> <input
								type="text" class="form-control add" name="contactAddress"
								placeholder="仓库地址" maxlength="200">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">仓库所属地域：</span> <input
								type="text" class="form-control" name="area"
								placeholder="仓库所属地域" maxlength="20">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">备注：</span> <input type="text"
								class="form-control" name="remark" placeholder="备注" maxlength="200">
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary"
						id="addStorehouseSubmit">确认新增</button>
				</div>
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->


<!-- 模态框（Modal） -->
<!-- 修改仓库模态框（Modal） -->
<div class="modal fade" id="modify_storehouse" tabindex="-1"
	role="dialog" aria-labelledby="modify_storehouse" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">修改仓库资料</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<form id="modify_storehouseForm">
						<input type="hidden" id="modify_storehouseId"
							name="modify_storehouseId" value="">
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">仓库名称:</span> <input
								type="text" class="form-control modify" id="modify_storehouseName"
								name="modify_storehouseName" placeholder="仓库名称" maxlength="200">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">仓库类型:</span> <select
								class="form-control modifyselect" id="modify_storehouseType" name="modify_storehouseType"
								tabindex="1" placeholder="仓库类型">
								<option value="0">请选择仓库类型：</option>
								<option value="1">通用仓库</option>
								<option value="2">专用仓库</option>
								<option value="3">中转仓库</option>
								<option value="4">其它</option>
							</select>
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">联系人名称:</span> <input
								type="text" class="form-control modify" id="modify_contactName"
								name="modify_contactName" placeholder="联系人名称" maxlength="10">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">联系人电话:</span> <input
								type="text" class="form-control modify" id="modify_contactTel"
								name="modify_contactTel" placeholder="联系人电话" maxlength="20">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">仓库地址:</span> <input
								type="text" class="form-control modify" id="modify_contactAddress"
								name="modify_contactAddress" placeholder="仓库地址" maxlength="200">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">仓库所属地域：</span> <input
								type="text" class="form-control" id="modify_area"
								name="modify_area" placeholder="仓库所属地域" maxlength="20">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">备注：</span> <input type="text"
								class="form-control" id="modify_remark" name="modify_remark"
								placeholder="备注：" maxlength="200">
						</div>
					</form>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				<button type="button" class="btn btn-primary"
					onClick="modifyCurrentStorehuseInfo(this)">确认修改</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->
<!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
<!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
<script src="<%=path%>/js/vendor/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<%=path%>/js/vendor/video.js"></script>
<script src="<%=path%>/js/flat-ui.min.js"></script>
<script src="<%=path%>/js/storehouse.js"></script>
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
											window.location.href = "storehouseReportExecl?query_storehouseName=${storehouse_name}&query_storehouseType=${storehouse_type}&query_contactName=${contact_name}&query_contactTel=${contact_tel}";
										});
						$(function() {
							$('[data-toggle="tooltip"]').tooltip()

						});
					});
</script>
