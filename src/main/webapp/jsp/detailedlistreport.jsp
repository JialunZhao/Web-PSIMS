<!DOCTYPE html>
<html>
<head lang="zh">
<meta charset="utf-8">
<%@ page pageEncoding="UTF-8"%>

<%@ include file="all2.jsp"%>
</head>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h3 class="page-header">流水明细报表</h3>

	<div class="row placeholders">
		<form class="form-inline" action="detailedListReport" method="get">
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
					<option value="1">啤酒</option>
					<option value="2">白酒</option>
					<option value="3">饮料</option>
					<option value="4">原料</option>
				</select>
			</div>
			<div class="form-group">
				<label for="query_contactName">商品编号：</label> <input type="text"
					class="form-control" id="goodsCode"
					name="goodsCode" placeholder="商品编号">
			</div>
			<div class="form-group">
				<label for="query_contactTel">客户名称：</label> <input type="text"
					class="form-control" id="customerName" name="customerName"
					placeholder="客户名称：">
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
					<th>月</th>
					<th>日</th>
					<th>客户名称</th>
					<th>分店</th>
					<th>产品分类</th>
					<th>产品名称</th>
					<th>数量</th>
					<th>单价</th>
					<th>金额</th>
					<th>进价</th>
					<th>厂家投入</th>
					<th>厂家退盖</th>
					<th>单箱返利</th>
					<th>加权平均返利</th>
					<th>单箱季返</th>
					<th>进货奖励</th>
					<th>售点奖励</th>
					<th>单箱年返</th>
					<th>店方回瓶</th>
					<th>店方回盖</th>
					<th>单箱成本</th>
					<th>单箱毛利</th>
					<th>合计毛利</th>
					<th>批号</th>
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
			window.location.href = "detailedListReportExecl?goodsName=${goodsName}&goodsType=${goodsType}&goodsCode=${goodsCode}&customerName=${customerName}";
		});
	});
</script>
</body>
</html>