<!DOCTYPE html>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.ai.psims.web.util.NumToFont"%>
<html>
<head lang="zh">
<meta charset="utf-8">
<%@ page pageEncoding="UTF-8"%>

<%@ include file="all4.jsp"%>
<!-- <style type="text/css" media="print"> -->
<style type="text/css" media="print">
page {
	margin: 0.5cm;
	padding: 1pt;
}

h1 {
	font-size: 16pt;
	margin-bottom: 0px;
	text-align: center;
	margin-top: -100px;
}

h1.page-header {
	margin-top: -100px;
	margin-bottom: 0px;
	padding-bottom: 0px;
}

.table-responsive table {
	font-size: 6pt;
	padding: 1pt !important;
	border: 1pt solid black !important;
}

table th {
	font-size: 6pt;
	padding: 1pt !important;
}

table tr {
	font-size: 6pt;
	padding: 1pt !important;
}

.table-responsive table td {
	font-size: 6pt;
	padding: 1pt !important;
	border: 1pt solid black !important;
}

.navbar {
	min-height: 0px;
	margin-bottom: 0px;
	font-size: 16px;
	border: none;
	border-radius: 6px;
}

.main {
	padding-top: 0px;
}
</style>
<style type="text/css">
h1 {
	text-align: center;
}
</style>
</head>
<div class="col-sm-12 col-md-12  main">
	<h1 class="page-header" id="titles">${title}</h1>
	<c:if test="${sales.salesStatus eq 'DO' }">
		<button type="button" class="btn btn-primary hidden-print"
			data-toggle="modal" data-target="#salesgoods" id="change">修改</button>
	</c:if>
	<div class="modal fade hidden-print" id="salesgoods" tabindex="-1"
		role="dialog" aria-labelledby="importgoods" aria-hidden="true">
		<label for="exampleInputEmail2">输入抬头名称：</label> <input type="text"
			class="form-control" id="titleName" placeholder="${title}">
		<button type="button" class="btn" id="addgoodsbtn">确认修改</button>
	</div>
	<div class="table-responsive">
		<table class="table table-bordered" id="saleTab">
			<tr>
				<td class="aa">公司电话</td>
				<td colspan="2">4000305919</td>
				<td>公司地址</td>
				<td colspan="2">北京市朝阳区王四营北路华能电厂正对面百富公寓左侧23号配房</td>
				<td>单据编号</td>
				<td colspan="3">${salesSerialNumber}</td>
			</tr>
			<tr>
				<td>客户</td>
				<td colspan="4">${customer.customerName}</td>
				<td>客户地址</td>
				<td colspan="4">${customer.contactAddr}</td>
			</tr>
			<tr>
				<td>客户电话</td>
				<td colspan="2">${customer.contactTel}</td>
				<td>业务员</td>
				<td>${customer.employeeName}</td>
				<td>经手人</td>
				<td>${tbEmployee.employeeName}</td>
				<td>结账方式</td>
				<td colspan="2">${customer.checkoutName}</td>
			</tr>
			<tr>
				<td>商品编号</td>
				<td colspan="4">商品全名</td>
				<td>商品类型</td>
				<td>单位</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
			</tr>
			<c:set value="0" var="sum" />
			<c:set value="0" var="row" />
			<c:forEach var="salesGoodsList" items="${salesGoodsList}" varStatus="status">
				<tr>
					<td>${salesGoodsList.goodsId}</td>
					<td colspan="4">${salesGoodsList.goodsName}</td>
					<td>${salesGoodsList.salesGoodsType}</td>
					<td>${salesGoodsList.salesGoodsUnit}</td>
					<td>${salesGoodsList.salesGoodsAmount}</td>
					<td>${salesGoodsList.salesGoodsPrice}</td>
					<td>${salesGoodsList.salesGoodsTotalPrice}</td>
				</tr>
				<c:set value="${sum + salesGoodsList.salesGoodsTotalPrice}" var="sum" />
				<c:set value="${row + 1}" var="row" />
			</c:forEach>
			<c:forEach var="row" begin="${row}" end="7">
				<c:set value="${row + 1}" var="row" />
				<tr>
					<td>&nbsp;</td>
					<td colspan="4"></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</c:forEach>
			<tr>
				<td>总计</td>
				<td colspan="4"></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>${sum}</td>
			</tr>
			<tr>
				<td>备注</td>
				<td colspan="6"></td>
				<td colspan="1">金额大写</td>
				<td colspan="2"><%=NumToFont.number2CNMontrayUnit(pageContext.getAttribute(
					"sum").toString())%></td>
			</tr>
			<tr>
				<td>收货人</td>
				<td colspan="1" style="width: 75px"></td>
				<td>送货人</td>
				<td colspan="1"></td>
				<td>发车时间</td>
				<td colspan="2"></td>
				<td>还车时间</td>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td>库管</td>
				<td colspan="1" style="width: 75px"></td>
				<td>车牌号</td>
				<td colspan="1"></td>
				<td>起始油表数</td>
				<td colspan="2"></td>
				<td>返回油表数</td>
				<td colspan="2"></td>
			</tr>
		</table>
	</div>
	<c:if test="${sales.salesStatus eq 'DO' }">
		<input class="hidden-print" type="button" id="print" value="打印"
			onclick="javascript:window.print(); printSalesData()" />
	</c:if>

	<c:if test="${sales.salesStatus ne 'DO' }">
		<input class="hidden-print" type="button" value="已打印"
			onclick="javascript:window.print();" disabled="disabled"
			style="background-color: gray" />
	</c:if>
	<input class="hidden-print" type="button" value="返 回" name="btBack"
		onclick="history.go(-1)">
</div>

<!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
<script src="<%=path%>/js/vendor/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<%=path%>/js/vendor/video.js"></script>
<script src="<%=path%>/js/flat-ui.min.js"></script>
<script src="<%=path%>/js/customer.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#addgoodsbtn").click(function(){
			titleName=$("#titleName").val();
			$("#titles").text(titleName);
			$("#salesgoods").hide();
		})
	});
	function printSalesData(){
		var salesSerialNumber='${salesSerialNumber}';
		var titleName=$("#titles").text();
		$("#print").attr('disabled','disabled');
		$("#print").css("background-color","gray");
		$.ajax({ 
            url:'<%=path%>/salesController/changeStatus.do',
			type : "post",
			async : false,
			modal : true,
			showBusi : false,
			data : {
				'salesSerialNumber' : salesSerialNumber,
				'titleName' : titleName
			},
			success : function(data) {
				$("#change").hide();
			}

		});
	}
	function printpreview() {
		wb.execwb(7, 1);
	}
</script>
</body>
</html>
