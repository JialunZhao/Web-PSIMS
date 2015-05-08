<!DOCTYPE html>
<html>
<head lang="zh">
<meta charset="utf-8">
<%@ page pageEncoding="UTF-8"%>

<%@ include file="all2.jsp"%>
</head>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h3 class="page-header">库存报表</h3>

	<div class="row placeholders">
		<form class="form-inline" action="storageCheckReport" method="get">
			<div class="form-group">
				<label for="query_customerName">商品名称：</label> <input type="text"
					class="form-control" id="goodsName"
					name="goodsName" placeholder="商品名称">
			</div>
			<div class="form-group">
				<label for="query_customerType">商品类型：</label> <select
					class="form-control" tabindex="1" id="goodsType"
					name="goodsType">
					<option value="0">请选择商品类型：</option>
					<option value="1">连锁</option>
					<option value="2">商户</option>
					<option value="3">散户</option>
					<option value="4">其它</option>
				</select>
			</div>
			<div class="form-group">
				<label for="query_contactName">商品编号：</label> <input type="text"
					class="form-control" id="goodsCode"
					name="goodsCode" placeholder="商品编号">
			</div>
			<div class="form-group">
				<label for="query_contactTel">仓库名称：</label> <input type="text"
					class="form-control" id="storehouseName" name="storehouseName"
					placeholder="仓库名称：">
			</div>
			<button type="submit" class="btn btn-primary">搜索</button>
		</form>
	</div>

	<div class="row placeholders ">
		<div class="col-sm-5">
			<priv:privilege power="客户管理.增删改">
				<button type="button" id="excel" class="btn btn-primary"  >导出为Excel</button>
			</priv:privilege>
		</div>
	</div>

	<h4 class="sub-header">库存清单</h4>
	<div class="table-responsive">
		<table class="table table-striped">
			<thead>
				<tr>
					<th class="chk" style="display: none"><input type="checkbox"
						aria-label="..."></th>
					<th>编号</th>
					<th>商品名称</th>
					<th>商品代码</th>
					<th>商品类型</th>
					<th>剩余库存</th>
					<th>库存总量</th>
					<th>单位</th>
					<th>供应商</th>
					<th>入库时间</th>
					<th>商品失效日期</th>
					<th>备注</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tbStoragechecks" items="${tbStoragechecks}">
					<tr>
						<td class="chk" style="display: none"><input type="checkbox"
							aria-label="..."></td>
						<td>${tbStoragechecks.storageId}</td>
						<td>${tbStoragechecks.goodsName}</td>
						<td>${tbStoragechecks.goodsCode}</td>
						<td>${tbStoragechecks.goodsType}</td>
						<td>${tbStoragechecks.storageRateCurrent}</td>
						<td>${tbStoragechecks.storageRateTotal}</td>
						<td>${tbStoragechecks.importGoodsUnit}</td>
						<td>${tbStoragechecks.providerName}</td>
						<td><fmt:formatDate value="${tbStoragechecks.createtime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><fmt:formatDate value="${tbStoragechecks.goodsExpirationDate}" pattern="yyyy-MM-dd" /> </td>
						<td>${tbStoragechecks.remark}</td>
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

<!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
<script src="<%=path%>/js/vendor/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<%=path%>/js/vendor/video.js"></script>
<script src="<%=path%>/js/flat-ui.min.js"></script>
<script src="<%=path%>/js/customer.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#excel").click(function() {
			window.location.href = "storageCheckReportExecl?goodsName=${goodsName}&goodsType=${goodsType}&goodsCode=${goodsCode}&storehouseName=${storehouseName}";
		});
	});
</script>
</body>
</html>