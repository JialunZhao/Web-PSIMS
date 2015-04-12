<%@page import="com.ai.psims.web.util.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String _base = path;
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=_base%>/css/bootstrap/bootstrap.min.css"
	rel="stylesheet">

<!-- Loading Flat UI -->
<link href="<%=_base%>/css/flatUI/flat-ui.min.css" rel="stylesheet">
<link href="<%=_base%>/css/dashboard.css" rel="stylesheet">
<link href="<%=_base%>/css/index.css" rel="stylesheet">
<script src="<%=_base%>/js/vendor/video.js"></script>
<%-- <script src="<%=_base %>/js/flat-ui.min.js"></script> --%>
<script type="text/javascript" src="<%=_base%>/js/vendor/jquery.min.js"></script>
<script type="text/javascript" src="<%=_base%>/js/dialog/lhgdialog.min.js"></script>

</head>
<body>
	<div class="col-sm-offset-1">
		<div class="row placeholders">
			<div class="input-group col-xs-10 col-md-offset-1">
				<span class="input-group-addon" style="background-color: #1abc9c;">出库时间:</span>
				<input type="text" class="form-control" placeholder=""
					value="<fmt:formatDate value="${sales.salesDate }" pattern="yyyy-MM-dd"/>" readonly="readonly" style="font: bolder;">
				<span class="input-group-addon" style="background-color: #1abc9c;">业务员名称:</span>
				<input type="text" class="form-control" value="${sales.employeeName }" readonly="readonly">
			</div>
			<div class="input-group col-xs-10 col-md-offset-1">
				<span class="input-group-addon" style="background-color: #1abc9c;">客户名称:</span>
				<input type="text" class="form-control" value="${sales.customerName }" readonly="readonly">
				<span class="input-group-addon" style="background-color: #1abc9c;">仓库名称:</span>
				<input type="text" class="form-control" value="${sales.storehouseName }" readonly="readonly">
			</div>
			<div class="input-group col-xs-10 col-md-offset-1" id="payM" style="display: none">
				<span class="input-group-addon" style="background-color: #1abc9c;">支付方式：</span>
				<input type="text" class="form-control" value="${sales.incomeType }" readonly="readonly">
				<span class="input-group-addon" style="background-color: #1abc9c;">支付时间</span>
				<input type="text" class="form-control" value="<fmt:formatDate value="${sales.incomeTime }" pattern="yyyy-MM-dd"/>" readonly="readonly">
			</div>
		</div>
		<div class="row placeholders" id="addgoodstb">
            <div class="row">
              <div class="table-responsive col-xs-12">
                <table class="table table-striped" id="addGoodsTab">
                  <thead>
                    <tr>
                      <th>销售流水号</th>
                      <th>商品名称</th>
                      <th>商品单价</th>
                      <th>进货数量</th>
                      <th>商品总价</th>
                    </tr>
                  </thead>
                  <tbody>
                  	<c:forEach items="${salesGoodsList }" var="salesGoods" varStatus="status">
                  		<tr>
                  			<td style="display: none;">${salesGoods.salesGoodsId }</td>
                  			<td>${salesGoods.salesSerialNumber }</td>
                  			<td>${salesGoods.goodsName }</td>
                  			<td id="goodsPrice${status.index }">${salesGoods.salesGoodsPrice }</td>
                  			<td>
                  				<input type="text" id="goodsAmount${status.index }" value="${salesGoods.salesGoodsAmount }" onblur="getTotalPrict(${status.index })">
                  			</td>
                  			<td id="totalPrice${status.index }">${salesGoods.salesGoodsTotalPrice }</td>
                  		</tr>
                  	</c:forEach>
                  </tbody>
                </table>
              </div>
              
              <div class="input-group col-xs-1">
               	<button type="button" class="btn btn-primary" onclick="suerUpdate()">确认修改</button>
              </div>
            </div>
          </div>
	</div>
	
	<script type="text/javascript">
	var api = frameElement.api, W = api.opener;
		showPayMet('${sales.incomeType }');
		function suerUpdate(){
			var salesSerialNumber="${sales.salesSerialNumber}";
			var salesGoodsIdList="";
			var goodsAmountList="";
			var i=0;
			$('#addGoodsTab tbody tr').find('td').each(function(){
				if ($(this).index() == "0") {
					salesGoodsIdList=salesGoodsIdList+$(this).text()+",";
					goodsAmountList=goodsAmountList+$("#goodsAmount"+i).val()+",";
					i++;
		        }
			});
			 var url="<%=_base %>/salesController/updataImprotGoodsList.do?salesGoodsIdList="
					+ salesGoodsIdList + "&salesSerialNumber="
					+ salesSerialNumber + "&goodsAmountList="
					+ goodsAmountList;
			api.reload(this, url);
			W.location.reload();
			api.close();
		}
		
		function getTotalPrict(index){
			var goodsPrice=$("#goodsPrice"+index).text();
			var goodsAmount=$("#goodsAmount"+index).val();
			$("#totalPrice"+index).text(goodsPrice*goodsAmount);
		}
		
		function showPayMet(val){
			if(val!=null&&val!=""){
				$("#payM").show();
			}else {
				$("#payM").hide();
			}
		}
		
		function checkDataFomat(data){
	    	  var a = /^(\d{4})-(\d{2})-(\d{2})$/;
	    	  if (!a.test(data)) { 
	    		  alert("日期格式不正确!正确格式为:yyyy-mm-dd");
	    	  };
	      }

	</script>
	
</body>
</html>