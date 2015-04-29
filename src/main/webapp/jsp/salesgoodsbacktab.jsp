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
	<div class="col-sm-offset-1">
		<div class="row placeholders" id="addgoodstb">
			<div class="row">
				<div class="table-responsive col-xs-16">
					<table class="table table-striped" id="salesGoodsTab">
						<thead>
							<tr>
								<th>商品名称</th>
								<th>基本单位</th>
								<th>生产日期</th>
								<th>失效日期</th>
								<th>库存数量</th>
								<th>销售总量</th>
								<th>换货数量</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${salesBackGoodsDatasList }" var="storagechecks"
								varStatus="status">
								<tr>
									<td style="display: none">${storagechecks.storageId }</td>
									<td id="goodsName${status.index }">${storagechecks.goodsName }</td>
									<td id="goodsUnit${status.index }">${storagechecks.importGoodsUnit }</td>
									<td id="goodsProductionDate${status.index }"><fmt:formatDate
											value="${storagechecks.goodsProductionDate }"
											pattern="yyyy-MM-dd" /></td>
									<td id="goodsExpirationDate${status.index }"><fmt:formatDate
											value="${storagechecks.goodsExpirationDate }"
											pattern="yyyy-MM-dd" /></td>
									<td id="storeCount${status.index }">${storagechecks.storageRateCurrent }</td>
									<td id="salesCount${status.index }">${storagechecks.salesCount }</td>
									<td><input type="text" id="changeSalesCount${status.index }"></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<div class="input-group col-xs-13 col-md-offset-3" id="addSalesBtn">
					<button type="button" class="btn btn-primary" id="addgoodsokbtn"
						onclick="sureAddSales()">确认换货</button>
					<button type="button" class="btn btn-primary"
						id="continAddgoodsokbtn" onclick="continueAdd()">继续添加</button>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
	var api = frameElement.api, W = api.opener;
		
		function sureAddSales(){
			var i=0;
			var j=0;
			var changeSalesCount=null;
			var storageId=null;
			var goodsName=null;
			var goodsUnit=null;
			var salesCount=null;
			var storeCount=null;
			var goodsProductionDate=null;
			$('#salesGoodsTab tbody tr').find('td').each(function(){
				changeSalesCount=$("#changeSalesCount"+i).val();
				goodsName=$("#goodsName"+i).text();
				goodsUnit=$("#goodsUnit"+i).text();
				goodsProductionDate=$("#goodsProductionDate"+i).text();
				salesCount=$("#salesCount"+i).text();
				storeCount=$("#storeCount"+i).text();
				if (parseInt(salesCount)<parseInt(changeSalesCount)) {
					alert("换货数量大于销售数量");
					$("#changeSalesCount"+i).val("");
					j++;
					return;
				}
				if (parseInt(changeSalesCount)>parseInt(storeCount)) {
					alert("库存不足");
					$("#changeSalesCount"+i).val("");
					j++;
					return;
				}
				if ($(this).index() == "0") {
					storageId=$(this).text();
					if(!(changeSalesCount==null||changeSalesCount=="")){
						W.addSalesGoods(storageId,changeSalesCount,goodsName,goodsUnit,goodsProductionDate);
						j++;
					}
					i++;
		        }
				
			});
			if (j==0) {
				alert("请选择销售数量或价格");
			}else {
				api.close();
			}
		}
		
		function continueAdd(){
			var i=0;
			var j=0;
			var changeSalesCount=null;
			var storageId=null;
			var goodsName=null;
			var salesCount=null;
			var goodsUnit=null;
			var storeCount=null;
			var goodsProductionDate=null;
			$('#salesGoodsTab tbody tr').find('td').each(function(){
				changeSalesCount=$("#changeSalesCount"+i).val();
				goodsName=$("#goodsName"+i).text();
				goodsUnit=$("#goodsUnit"+i).text();
				goodsProductionDate=$("#goodsProductionDate"+i).text();
				salesCount=$("#salesCount"+i).text();
				storeCount=$("#storeCount"+i).text();
				if (parseInt(salesCount)<parseInt(changeSalesCount)) {
					alert("换货数量大于销售数量");
					$("#changeSalesCount"+i).val("");
					j++;
					return;
				}
				if (parseInt(changeSalesCount)>parseInt(storeCount)) {
					alert("库存不足");
					$("#changeSalesCount"+i).val("");
					j++;
					return;
				}
				if ($(this).index() == "0") {
					storageId=$(this).text();
					if(!(changeSalesCount==null||changeSalesCount=="")){
						W.continueAddSalesGoods(storageId,changeSalesCount,goodsName,goodsUnit,goodsProductionDate);
						j++;
					}
					i++;
		        }
				
			});
			if (j==0) {
				alert("请选择销售数量或价格");
			}else {
				api.close();
			}
		}

	</script>

