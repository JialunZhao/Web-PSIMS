<!DOCTYPE html>
<html>
<head lang="zh">
<meta charset="utf-8">
<%@ page pageEncoding="UTF-8"%>

<%@ include file="all2.jsp"%>
</head>
<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h3 class="page-header">供应商</h3>

		<div class="row placeholders">
			<form class="form-inline" action="provider" method="get">
				<div class="form-group">
					<label for="query_providerName">供应商名称：</label> <input type="text"
						class="form-control" id="query_providerName"
						name="query_providerName" placeholder="供应商名称">
				</div>
				<div class="form-group">
					<label for="query_providerType">供应商类型：</label> <select
						class="form-control" tabindex="1" id="query_providerType"
						name="query_providerType">
						<option value="0">请选择供应商类型：</option>
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
				<priv:privilege power="供应商.增删改">
					<button type="button" class="btn btn-primary" id="addprovider_btn">新增供应商</button>
					<button type="button" id="excel" class="btn btn-primary">供应商清单Excel导出</button>
				</priv:privilege>
			</div>
		</div>

		<h4 class="sub-header">供应商清单</h4>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th class="chk" style="display: none"><input type="checkbox"
							aria-label="..."></th>
						<th>编号</th>
						<th>供应商名称</th>
						<th>类型</th>
						<th>供应商奖金池</th>
						<th>联系人名称</th>
						<th>联系人电话</th>
						<th>供应商地址</th>
						<th>供应商区域</th>
						<th>操作</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="providers" items="${providers}">
						<tr data-toggle="tooltip" data-animation="false"
							data-placement="auto" title="备注：${providers.providerRemark}">
							<td class="chk" style="display: none"><input type="checkbox"
								aria-label="..."></td>
							<td>${providers.providerId}</td>
							<td>${providers.providerName}</td>
							<td>${providers.providerType}</td>
							<td>${providers.providerPrizePool}</td>
							<td>${providers.providerContactName}</td>
							<td>${providers.providerContactTel}</td>
							<td>${providers.providerContactAddress}</td>
							<td>${providers.providerArea}</td>
							<priv:privilege power="供应商.增删改">
								<td><a href="javascript:void(0);"
									onClick="modifyCurrentProvider(this)">修改</a>/<a
									href="javascript:void(0);" onClick="delCurrentProvider(this);">删除</a></td>
							</priv:privilege>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>


	<!-- 模态框（Modal） -->
	<!-- 添加供应商模态框（Modal） -->
	<div class="modal fade" id="addprovider" tabindex="-1" role="dialog"
		aria-labelledby="addprovider" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">新增供应商资料</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<form id="addproviderForm">
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">供应商名称:</span> <input
									type="text" class="form-control add" name="provider_name"
									placeholder="供应商名称" maxlength="200">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">供应商代码:</span> <input
									type="text" class="form-control" name="provider_code"
									placeholder="供应商代码" maxlength="20">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">供应商类型:</span> <select
									class="form-control addselect" name="provider_type"
									tabindex="1" placeholder="供应商类型">
									<option value="0">请选择供应商类型：</option>
									<option value="1">连锁</option>
									<option value="2">商户</option>
									<option value="3">散户</option>
									<option value="4">其它</option>
								</select>
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">供应商奖金池:</span> <select
									class="form-control" name="provider_prizepool" tabindex="1"
									id="add_provider_prizepool" onchange="selectChange()">

								</select><input type="text" class="form-control"
									id="add_provider_prizepool_prize" readonly
									placeholder="供应商奖金池金额"> <span class="input-group-addon">元</span>
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">联系人名称:</span> <input
									type="text" class="form-control add" name="contact_name"
									placeholder="联系人名称" maxlength="10">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">联系人电话:</span> <input
									type="text" class="form-control add" name="contact_tel"
									placeholder="联系人电话" maxlength="20">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">联系人传真:</span> <input
									type="text" class="form-control" name="contact_fax"
									placeholder="联系人传真" maxlength="20">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">供应商地址:</span> <input
									type="text" class="form-control  add" name="contact_addr"
									placeholder="供应商地址" maxlength="200">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">供应商电子邮箱:</span> <input
									type="text" class="form-control" name="email"
									placeholder="供应商电子邮箱" maxlength="100">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">供应商地域：</span> <input
									type="text" class="form-control" name="area"
									placeholder="供应商地域："maxlength="20">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">备注：</span> <input
									type="text" class="form-control" name="remark"
									placeholder="备注：" maxlength="200">
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary"
						id="addprovidersubmit">确认新增</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->


	<!-- 模态框（Modal） -->
	<!-- 修改供应商模态框（Modal） -->
	<div class="modal fade" id="modifyprovider" tabindex="-1" role="dialog"
		aria-labelledby="modifyprovider" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">修改供应商资料</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<form id="modify_providerForm" action="action.aspx" method="post">
							<input type="hidden" id="modify_providerId"
								name="modify_providerId" value="">
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">供应商名称:</span> <input
									type="text" id="modify_providerName" name="modify_providerName"
									class="form-control modify" placeholder="供应商名称" maxlength="200">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">供应商名称:</span> <input
									type="text" id="modify_providerCode" name="modify_providerCode"
									class="form-control" placeholder="供应商代码" maxlength="20">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">供应商类型:</span> <select
									class="form-control modifyselect" tabindex="1" id="modify_providerType"
									name="modify_providerType" placeholder="供应商类型">
									<option value="0">请选择供应商类型：</option>
									<option value="1">连锁</option>
									<option value="2">商户</option>
									<option value="3">散户</option>
									<option value="4">其它</option>
								</select>
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">供应商奖金池:</span> <select
									class="form-control" name="modify_provider_prizepool"
									tabindex="1" id="modify_providerPrizePool"
									onchange="modifyselectChange()">

								</select><input type="text" class="form-control"
									id="modify_providerPrizePool_prize" readonly
									placeholder="供应商奖金池金额"> <span class="input-group-addon">元</span>
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">联系人名称:</span> <input
									type="text" class="form-control modify"
									id="modify_providerContactName"
									name="modify_providerContactName" placeholder="联系人名称"maxlength="10">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">联系人电话:</span> <input
									type="text" class="form-control modify" id="modify_providerContactTel"
									name="modify_providerContactTel" placeholder="联系人电话"maxlength="20">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">联系人传真:</span> <input
									type="text" class="form-control" id="modify_providerContactFax"
									name="modify_providerContactFax" placeholder="联系人传真"maxlength="20">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">供应商地址:</span> <input
									type="text" class="form-control modify"
									id="modify_providerContactAddress"
									name="modify_providerContactAddress" placeholder="供应商地址" maxlength="200">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">供应商电子邮箱:</span> <input
									type="text" class="form-control"
									id="modify_providerContactEmail"
									name="modify_providerContactEmail" placeholder="供应商电子邮箱"maxlength="100">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">供应商地域：</span> <input
									type="text" class="form-control" id="modify_providerArea"
									name="modify_providerArea" placeholder="供应商地域："maxlength="20">
							</div>
							<div class="input-group col-xs-6 col-md-offset-3">
								<span class="input-group-addon"
									style="background-color: #1abc9c;">备注：</span> <input
									type="text" class="form-control" id="modify_providerRemark"
									name="modify_providerRemark" placeholder="备注："maxlength="200">
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary"
						onClick="modifyCurrentProviderInfo(this)">确认修改</button>
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
	<script src="<%=path%>/js/provider.js"></script>
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
												window.location.href = "providerReportExecl?query_providerName=${provider_name}&query_providerType=${provider_type}&query_contactName=${contact_name}&query_contactTel=${contact_tel}";
											});
							$(function() {
								$('[data-toggle="tooltip"]').tooltip()
							})
						});
	</script>
</body>
</html>