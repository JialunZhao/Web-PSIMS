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
		<div class="row placeholders">
			<div class="input-group col-xs-10 col-md-offset-1">
				<span class="input-group-addon" style="background-color: #1abc9c;">出库时间:</span>
				<input type="text" class="form-control" placeholder=""
					value="<fmt:formatDate value="${sales.salesDate }" pattern="yyyy-MM-dd"/>">
				<span class="input-group-addon" style="background-color: #1abc9c;">业务员名称:</span>
				<select class="form-control" value="${sales.employeeName }" tabindex="1" name="employeeName" id="employeeName">
					<option value="${sales.employeeId }">${sales.employeeName }</option>
				</select>
			</div>
			<div class="input-group col-xs-10 col-md-offset-1">
				<span class="input-group-addon" style="background-color: #1abc9c;">客户名称:</span>
				<select class="form-control" value="${sales.customerName }" tabindex="1" name="customerName" id="customerName">
					<option value="${sales.customerId }">${sales.customerName }</option>
				</select>
				<span class="input-group-addon" style="background-color: #1abc9c;">仓库名称:</span>
				<select class="form-control" value="${sales.storehouseName }" tabindex="1" name="storehouseName" id="storehouseName">
					<option value="${sales.storehouseId }">${sales.storehouseName }</option>
				</select>
			</div>
			<div class="input-group col-xs-10 col-md-offset-1">
				<span class="input-group-addon" style="background-color: #1abc9c;">销售状态:</span>
				<select class="form-control" value="请选择销售状态" tabindex="1"	name="salesStatus" id="salesStatus"	onchange="showPayMet(this.value)">
					<c:if test="${sales.salesStatus eq 'DO' }">
						<option value="<%=Constants.SalesStatus.DOWNORDER%>"><%=Constants.SalesStatus.DOWNORDER01%></option>
						<option value="<%=Constants.SalesStatus.CREDIT%>"><%=Constants.SalesStatus.CREDIT01%></option>
						<option value="<%=Constants.SalesStatus.OUTORDER%>"><%=Constants.SalesStatus.OUTORDER01%></option>
						<option value="<%=Constants.SalesStatus.OUTSTORE%>"><%=Constants.SalesStatus.OUTSTORE01%></option>
						<option value="<%=Constants.SalesStatus.SQUARE%>"><%=Constants.SalesStatus.SQUARE01%></option>
					</c:if>
					<c:if test="${sales.salesStatus eq 'C' }">
						<option value="<%=Constants.SalesStatus.CREDIT%>"><%=Constants.SalesStatus.CREDIT01%></option>
						<option value="<%=Constants.SalesStatus.DOWNORDER%>"><%=Constants.SalesStatus.DOWNORDER01%></option>
						<option value="<%=Constants.SalesStatus.OUTORDER%>"><%=Constants.SalesStatus.OUTORDER01%></option>
						<option value="<%=Constants.SalesStatus.OUTSTORE%>"><%=Constants.SalesStatus.OUTSTORE01%></option>
						<option value="<%=Constants.SalesStatus.SQUARE%>"><%=Constants.SalesStatus.SQUARE01%></option>
					</c:if>
					<c:if test="${sales.salesStatus eq 'OO' }">
						<option value="<%=Constants.SalesStatus.OUTORDER%>"><%=Constants.SalesStatus.OUTORDER01%></option>
						<option value="<%=Constants.SalesStatus.DOWNORDER%>"><%=Constants.SalesStatus.DOWNORDER01%></option>
						<option value="<%=Constants.SalesStatus.CREDIT%>"><%=Constants.SalesStatus.CREDIT01%></option>
						<option value="<%=Constants.SalesStatus.OUTSTORE%>"><%=Constants.SalesStatus.OUTSTORE01%></option>
						<option value="<%=Constants.SalesStatus.SQUARE%>"><%=Constants.SalesStatus.SQUARE01%></option>
					</c:if>
					<c:if test="${sales.salesStatus eq 'OS' }">
						<option value="<%=Constants.SalesStatus.OUTSTORE%>"><%=Constants.SalesStatus.OUTSTORE01%></option>
						<option value="<%=Constants.SalesStatus.DOWNORDER%>"><%=Constants.SalesStatus.DOWNORDER01%></option>
						<option value="<%=Constants.SalesStatus.CREDIT%>"><%=Constants.SalesStatus.CREDIT01%></option>
						<option value="<%=Constants.SalesStatus.OUTORDER%>"><%=Constants.SalesStatus.OUTORDER01%></option>
						<option value="<%=Constants.SalesStatus.SQUARE%>"><%=Constants.SalesStatus.SQUARE01%></option>
					</c:if>
					<c:if test="${sales.salesStatus eq 'S' }">
						<option value="<%=Constants.SalesStatus.SQUARE%>"><%=Constants.SalesStatus.SQUARE01%></option>
						<option value="<%=Constants.SalesStatus.DOWNORDER%>"><%=Constants.SalesStatus.DOWNORDER01%></option>
						<option value="<%=Constants.SalesStatus.CREDIT%>"><%=Constants.SalesStatus.CREDIT01%></option>
						<option value="<%=Constants.SalesStatus.OUTORDER%>"><%=Constants.SalesStatus.OUTORDER01%></option>
						<option value="<%=Constants.SalesStatus.OUTSTORE%>"><%=Constants.SalesStatus.OUTSTORE01%></option>
					</c:if>
				</select>
			</div>
			<div class="input-group col-xs-10 col-md-offset-1" id="payM" style="display: none">
				<span class="input-group-addon" style="background-color: #1abc9c;">支付方式：</span>
				<select class="form-control" value="请选择支付方式" tabindex="1" name="payMed" id="payMed">
					<option value="<%=Constants.PayMed.CASH %>"><%=Constants.PayMed.CASH01 %></option>
					<option value="<%=Constants.PayMed.CHEQUE %>"><%=Constants.PayMed.CHEQUE01 %></option>
					<option value="<%=Constants.PayMed.TICK %>"><%=Constants.PayMed.TICK01 %></option>
					<option value="<%=Constants.PayMed.TRANSFERS %>"><%=Constants.PayMed.TRANSFERS01 %></option>
				</select>
				<span class="input-group-addon" style="background-color: #1abc9c;">支付时间</span>
				<input type="text" class="form-control" value="2015-01-01" id="payTime">
			</div>
			<div class="input-group col-xs-10 col-md-offset-1" id="creditC" style="display: none">
				<span class="input-group-addon" style="background-color: #1abc9c;">赊账金额：</span>
				<input type="text" class="form-control" value="" id="creditCount">
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
                      <th>原始库存量</th>
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
                  			<td id="goodsAmountRate${status.index }">${salesGoods.storageRateCurrent+salesGoods.salesGoodsAmount }</td>
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
		showPayMet('${sales.salesStatus }');
		function suerUpdate(){
			var salesSerialNumber="${sales.salesSerialNumber}";
			var salesGoodsIdList="";
			var goodsAmountList="";
			var salesStatus=$("#salesStatus").val();
			var payMed="";
			var payTime="";
			var creditCount="";
			var i=0;
			
			if(salesStatus=='<%=Constants.SalesStatus.SQUARE%>'){
				payMed=$("#payMed").val();
				payTime=$("#payTime").val();
			}
			if (salesStatus=='<%=Constants.SalesStatus.CREDIT%>') {
				creditCount=$("#creditCount").val();
			}
			
			$('#addGoodsTab tbody tr').find('td').each(function(){
				if ($(this).index() == "0") {
					salesGoodsIdList=salesGoodsIdList+$(this).text()+",";
					goodsAmountList=goodsAmountList+$("#goodsAmount"+i).val()+",";
					i++;
		        }
			});
			
			var url="<%=path %>/salesController/updataImprotGoodsList.do?salesGoodsIdList="
					+ salesGoodsIdList + "&salesStatus="
					+ salesStatus + "&payMed="
					+ payMed + "&creditCount="
					+ creditCount + "&payTime="
					+ payTime + "&salesSerialNumber="
					+ salesSerialNumber + "&goodsAmountList="
					+ goodsAmountList;
			api.reload(this, url);
			W.location.reload();
			api.close();
		}
		
		function getTotalPrict(index){
			var goodsPrice=$("#goodsPrice"+index).text();
			var goodsAmount=$("#goodsAmount"+index).val();
			var goodsAmountRate=$("#goodsAmountRate"+index).text();
			if(parseInt(goodsAmount)>parseInt(goodsAmountRate)){
				alert("库存不足");
				return;
			}
			$("#totalPrice"+index).text(goodsPrice*goodsAmount);
		}
		
		function showPayMet(value){
			if(value=='<%=Constants.SalesStatus.SQUARE%>'){
				$("#payM").show();
				$("#creditC").hide();
			}else if (value=='<%=Constants.SalesStatus.CREDIT%>') {
				$("#creditC").show();
				$("#payM").hide();
			}else {
				$("#creditC").hide();
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
