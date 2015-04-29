<%@page import="com.ai.psims.web.util.Constants"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
String date=sdf.format(new Date());

%>
<%@ include file="all.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<div class="col-sm-offset-3">
		<div class="row placeholders">



			<div class="input-group col-xs-10 col-md-offset-1">
				<span class="input-group-addon" style="background-color: #1abc9c;">入库商品名称:</span>
				<input type="text" class="form-control"
					value="${importGoods.goodsName }" id="goodsName">
			</div>

			<div class="input-group col-xs-10 col-md-offset-1">
				<span class="input-group-addon" style="background-color: #1abc9c;">入库商品单位:</span>
				<input type="text" class="form-control"
					value="${importGoods.importGoodsUnit }" id="importGoodsUnit">
			</div>

			<div class="input-group col-xs-10 col-md-offset-1">
				<span class="input-group-addon" style="background-color: #1abc9c;">入库商品保质期:</span>
				<input type="text" class="form-control"
					value="${importGoods.goodsShelfLife }" id="goodsShelfLife">
			</div>

			<div class="input-group col-xs-10 col-md-offset-1">
				<span class="input-group-addon" style="background-color: #1abc9c;">下单数量:</span>
				<input type="text" class="form-control"
					value="${importGoods.importGoodsAmount }" id="importGoodsAmount">
			</div>

			<div class="input-group col-xs-10 col-md-offset-1">
				<span class="input-group-addon" style="background-color: #1abc9c;">剩余入库数量:</span>
				<input type="text" class="form-control"
					value="${importGoods.resImportGoodsAmount }"
					id="resImportGoodsAmount">
			</div>

			<div class="input-group col-xs-10 col-md-offset-1">
				<span class="input-group-addon" style="background-color: #1abc9c;">入库数量:</span>
				<input type="text" class="form-control" value="" id="importCount" onblur="checkCount(this.value)">
			</div>

			<div class="input-group col-xs-10 col-md-offset-1">
				<span class="input-group-addon" style="background-color: #1abc9c;">生产日期:</span>
				<input type="text" class="form-control" value="2015-01-01"
					id="goodsProductionDate" onblur="getGoodsExpirationDate(this.value)">
			</div>

			<div class="input-group col-xs-10 col-md-offset-1">
				<span class="input-group-addon" style="background-color: #1abc9c;">失效日期:</span>
				<input type="text" class="form-control" value=""
					id="goodsExpirationDate">
			</div>

		</div>
		 <div class="row placeholders" id="addgoodstb">
			<div class="row">
				<div class="input-group col-xs-13 col-md-offset-3" id="addSalesBtn">
					<button type="button" class="btn btn-primary" id="addgoodsokbtn"
						onclick="sureAddSales()">确认入库</button>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		var api = frameElement.api, W = api.opener;
		
		function checkCount(importCount){
			var resImportGoodsAmount=$("#resImportGoodsAmount").val();
			if(parseInt(importCount)>parseInt(resImportGoodsAmount)){
				alert("入库数量大于订单剩余入库数量，请重新填写");
				$("#importCount").val("");
			}
		}

		function checkDataFomat(data){
			  var a = /^(\d{4})-(\d{2})-(\d{2})$/;
			  if (!a.test(data)) { 
				  alert("日期格式不正确!正确格式为:yyyy-mm-dd");
				  return true;
			  };
			  return false;
		  }
		 
		
		function getGoodsExpirationDate(goodsProductionDate){
  			if (checkDataFomat(goodsProductionDate)) {
				return;
			}
  			var goodsShelfLife=$("#goodsShelfLife").val();
  			var goodsExpirationDate=getthedate(goodsProductionDate, goodsShelfLife);
  			$("#goodsExpirationDate").val(goodsExpirationDate);
  		}
  		
  		
  		
  		function getthedate(dd,dadd)
  		 {
  		 //可以加上错误处理
  		 var a = new Date(dd);
  		 a = a.valueOf();
  		 a = a + dadd * 24 * 60 * 60 * 1000;
  		 a = new Date(a);
  		 var m = a.getMonth() + 1;
  		 if(m.toString().length == 1){
  		     m='0'+m;
  		 }
  		 var d = a.getDate();
  		 if(d.toString().length == 1){
  		     d='0'+d;
  		 }
  		 return a.getFullYear() + "-" + m + "-" + d;
  		 
  		}
		
		function sureAddSales() {
			var goodsName = $("#goodsName").val();
			var importCount = $("#importCount").val();
			var goodsProductionDate = $("#goodsProductionDate").val();
			var goodsExpirationDate = $("#goodsExpirationDate").val();
			if(checkIsNull(importCount)){
				alert("请填写入库数量");
				return;
			}else {
				var resImportGoodsAmount=$("#resImportGoodsAmount").val();
				if(parseInt(importCount)>parseInt(resImportGoodsAmount)){
					alert("入库数量大于订单剩余入库数量，请重新填写");
					$("#importCount").val("");
					return;
				}
			}
			if(checkIsNull(goodsProductionDate)){
				alert("请填写生产日期");
				return;
			}else {
				if (checkDataFomat(goodsProductionDate)) {
					return;
				}
	  			var goodsShelfLife=$("#goodsShelfLife").val();
	  			goodsExpirationDate=getthedate(goodsProductionDate, goodsShelfLife);
	  			$("#goodsExpirationDate").val(goodsExpirationDate);
			}
			W.addImportGoodsTab(goodsName,importCount,goodsProductionDate,goodsExpirationDate);
			api.close();
		}
		
		function checkIsNull(str){
	    	  if(str===null||str===""){
	    		  return true;
	    	  }
	    	  return false;
	      }

		
	</script>
