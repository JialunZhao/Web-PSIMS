<!DOCTYPE html>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.ai.psims.web.util.NumToFont"%>
<html>
<head lang="zh">
<meta charset="utf-8">
<%@ page pageEncoding="UTF-8"%>

<%@ include file="all2.jsp"%>
<style type="text/css">
	table td{ height:20px; width:30px; border:#CCCCCC 1px solid;}
</style>
</head>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h5 class="page-header">${title}</h5>
	<div class="table-responsive">
		<table class="table table-bordered" id="saleTab">
						<tr>
							<td><font size="2">电话</font></td>
							<td colspan="2"><font size="2"></font></td>
							<td><font size="2">地址</font></td>
							<td colspan="2"><font size="2"></font></td>
							<td><font size="2">单据编号</font></td>
							<td colspan="3"><font size="2">${salesSerialNumber}</font></td>
						</tr>
						<tr>
							<td><font size="2">客户</font></td>
							<td colspan="4"><font size="2">${customer.customerName}</font></td>
							<td><font size="2">客户地址</font></td>
							<td colspan="4"><font size="2">${customer.contactAddr}</font></td>
						</tr>
						<tr>
							<td><font size="2">联系电话</font></td>
							<td colspan="2"><font size="2">${customer.contactTel}</font></td>
							<td><font size="2">联系人</font></td>
							<td><font size="2">${customer.employeeName}</font></td>
							<td><font size="2">结账方式</font></td>
							<td colspan="4"><font size="2">${customer.checkoutName}</font></td>
						</tr>
						<tr>
							<td><font size="2">商品编号</font></td>
							<td colspan="3"><font size="2">商品全名</font></td>
							<td colspan="2"><font size="2">规格</font></td>
							<td><font size="2">单位</font></td>
							<td><font size="2">数量</font></td>
							<td><font size="2">单价</font></td>
							<td><font size="2">金额</font></td>
						</tr>
						<c:set value="0" var="sum" />
						<c:forEach var="salesGoods" items="${salesGoodsList}" varStatus="status">
								<tr>
									<td><font size="2">${salesGoods.goodsId}</font></td>
									<td colspan="3"><font size="2">${salesGoods.goodsName}</font></td>
									<td colspan="2"><font size="2"></font></td>
									<td><font size="2">${salesGoods.salesGoodsUnit}</font></td>
									<td><font size="2">${salesGoods.salesGoodsAmount}</font></td>
									<td><font size="2">${salesGoods.salesGoodsPrice}</font></td>
									<td><font size="2">${salesGoods.salesGoodsTotalPrice}</font></td>
								</tr>
								<c:set value="${sum + salesGoods.salesGoodsTotalPrice}" var="sum" />
						</c:forEach>
						<tr>
							<td><font size="2"> </font></td>
							<td colspan="3"><font size="2"> </font></td>
							<td colspan="2"><font size="2"> </font></td>
							<td><font size="2"> </font></td>
							<td><font size="2"> </font></td>
							<td><font size="2"> </font></td>
							<td><font size="2"> </font></td>
						</tr>
						<tr>
							<td><font size="2"> </font></td>
							<td colspan="3"><font size="2"> </font></td>
							<td colspan="2"><font size="2"> </font></td>
							<td><font size="2"> </font></td>
							<td><font size="2"> </font></td>
							<td><font size="2"> </font></td>
							<td><font size="2"> </font></td>
						</tr>
						<tr>
							<td><font size="2">总计</font></td>
							<td colspan="3"><font size="2"></font></td>
							<td colspan="2"><font size="2"></font></td>
							<td><font size="2"></font></td>
							<td><font size="2"></font></td>
							<td><font size="2"></font></td>
							<td><font size="2">${sum }</font></td>
						</tr>
						<tr>
							<td><font size="2">联系人</font></td>
							<td colspan="4"><font size="2"></font></td>
							<td colspan="2"><font size="2">金额大写</font></td>
							<td colspan="3"><font size="2"><%=NumToFont.number2CNMontrayUnit(pageContext.getAttribute("sum").toString()) %></font></td>
						</tr>
						<tr>
							<td><font size="2">收货人</font></td>
							<td><font size="2"></font></td>
							<td><font size="2">送货人</font></td>
							<td><font size="2"></font></td>
							<td><font size="2">核单人</font></td>
							<td><font size="2">${tbEmployee.employeeName }</font></td>
							<td><font size="2">发车时间</font></td>
							<td><font size="2"></font></td>
							<td><font size="2">还车时间</font></td>
							<td><font size="2"></font></td>
						</tr>
						<tr>
							<td><font size="2">库管</font></td>
							<td><font size="2"></font></td>
							<td><font size="2">车牌号</font></td>
							<td><font size="2"></font></td>
							<td><font size="2">起始油表数</font></td>
							<td colspan="2"><font size="2"></font></td>
							<td><font size="2">返回油表数</font></td>
							<td colspan="2"><font size="2"></font></td>
						</tr>
						<tr>
							<td><font size="2">备注</font></td>
							<td colspan="9"><font size="2"></font></td>
						</tr>
					</table>
	</div>
	<input class="hidden-print" type="button" value="打印" onclick="javascript:window.print();"/>
						
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