<!DOCTYPE html>
<html>
<head lang="zh">
<meta charset="utf-8">
<%@ page pageEncoding="UTF-8"%>

<%@ include file="all2.jsp"%>
</head>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h3 class="page-header">销售明细报表</h3>

	<div class="row placeholders">
		<form class="form-inline" action="salesCheckReport" method="get">
			<div class="form-group">
				<label for="query_customerName">销售流水号：</label> <input type="text"
					class="form-control" id="salesSerialNumber"
					name="salesSerialNumber" placeholder="销售流水号">
			</div>			
			<button type="submit" class="btn btn-primary">销售报表导出</button>
		</form>
	</div>
	<h4 class="sub-header">销售清单</h4>
	<div class="table-responsive">
		<table class="table table-striped" id="saleTab">
						<thead>
							<tr>
								<th class="chk" style="display: none"><input
									type="checkbox" aria-label="..."></th>
								<th>销售流水号</th>
								<th>销售时间</th>
								<th>业务员名称</th>
								<th>客户名称</th>
								<th>仓库名称</th>
								<th>应收总价</th>
								<th>销售状态</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="sales" items="${salesList}" varStatus="status">
								<tr>
									<td class="chk" style="display: none"><input
										type="checkbox" aria-label="..."></td>
									<td><font color="#16a085">${sales.salesSerialNumber }</font></td>
									<td><font size="4" color="#16a085"><fmt:formatDate value="${sales.salesDate }"
											pattern="yyyy-MM-dd" /></font></td>
									<td><font size="4" color="#16a085">${sales.employeeName }</font></td>
									<td><font size="4" color="#16a085">${sales.customerName }</font></td>
									<td><font size="4" color="#16a085">${sales.storehouseName }</font></td>
									<td><font size="4" color="#16a085">${sales.totalSalesAmount }</font></td>
									<td><font size="4" color="#16a085">${sales.salesStatus }</font></td>
								</tr>
								<tr>
									<td>订单详情</td>
									<td>商品名称</td>
									<td>商品单价</td>
									<td>商品数量</td>
									<td>总价</td>
								</tr>
								<c:forEach var="salesGoods" items="${salesGoodsList}"
									varStatus="status">
								<c:if
									test="${salesGoods.salesSerialNumber==sales.salesSerialNumber}">
								<tr id="#collapse${salesGoods.salesSerialNumber}">
									<td>订单详情</td>
									<td>${salesGoods.goodsName}</td>
									<td>${salesGoods.salesGoodsPrice}</td>
									<td>${salesGoods.salesGoodsAmount}</td>
									<td>${salesGoods.salesGoodsTotalPrice}</td>
								</tr>
						</c:if>
					</c:forEach>
							</c:forEach>
						</tbody>
					</table>
	</div>
	<input type="button" value="打印" onclick="javascript:window.print();"/>
</div>

<!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
<script src="<%=path%>/js/vendor/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<%=path%>/js/vendor/video.js"></script>
<script src="<%=path%>/js/flat-ui.min.js"></script>
<script src="<%=path%>/js/customer.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
	});
</script>
</body>
</html>