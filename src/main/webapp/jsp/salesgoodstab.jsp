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
                      <th>销售数量</th>
                      <th>销售价格</th>
                      <th>应付总金额</th>
                    </tr>
                  </thead>
                  <tbody>
                  	<c:forEach items="${storagechecksList }" var="storagechecks" varStatus="status">
                  		<tr>
                  			<td style="display: none">${storagechecks.storageId }</td>
                  			<td>${storagechecks.goodsName }</td>
                  			<td>${storagechecks.importGoodsUnit }</td>
                  			<td>
                  				<fmt:formatDate value="${storagechecks.goodsProductionDate }" pattern="yyyy-MM-dd"/>
                  			</td>
                  			<td>
                  				<fmt:formatDate value="${storagechecks.goodsExpirationDate }" pattern="yyyy-MM-dd"/>
                  			</td>
                  			<td id="storeCount${status.index }">${storagechecks.storageRateCurrent }</td>
                  			<td><input type="text" id="salesCount${status.index }"></td>
                  			<td><input type="text" id="salesPrice${status.index }"></td>
                  			<td><input type="text" id="goodsTotalPay${status.index }" onfocus="getGoodsAllPay(${status.index })"></td>
                  		</tr>
                  	</c:forEach>
                  </tbody>
                </table>
              </div>
              
              <div class="input-group col-xs-13 col-md-offset-3" id="addSalesBtn">
               	<button type="button" class="btn btn-primary" id="addgoodsokbtn" onclick="sureAddSales()">确认添加</button>
                <button type="button" class="btn btn-primary" id="continAddgoodsokbtn" onclick="continueAdd()">继续添加</button>
              </div>
            </div>
          </div>
	</div>
	
	<script type="text/javascript">
	var api = frameElement.api, W = api.opener;
		function checkDataFomat(data){
	    	  var a = /^(\d{4})-(\d{2})-(\d{2})$/;
	    	  if (!a.test(data)){ 
	    		  alert("日期格式不正确!正确格式为:yyyy-mm-dd");
	    	  };
	      }
		
		
		function getGoodsAllPay(index){
			var salesPrice=$("#salesPrice"+index).val();
			var salesCount=$("#salesCount"+index).val();
			var storeCount=$("#storeCount"+index).text();
			var salesCountIsNull=(salesCount==null||salesCount=="");
			var salesPriceIsNull=(salesPrice==null||salesPrice=="");
			if(!(salesCountIsNull||salesPriceIsNull)){
				if (parseInt(salesCount) > parseInt(storeCount)) {
					 $("#salesCount"+i).val("");
					 alert("库存不足");
					 return;
				}
				$("#goodsTotalPay"+index).val(salesCount*salesPrice);
			}
		}
		
		function sureAddSales(){
			var i=0;
			var j=0;
			var k=0;
			var salesCount=null;
			var salesPrice=null;
			var storageId=null;
			var storeCount=null;
			var falg=true;
			
			$('#salesGoodsTab tbody tr').find('td').each(function(){
				if ($(this).index() == "0") {
					salesCount=$("#salesCount"+k).val();
					salesPrice=$("#salesPrice"+k).val();
					storeCount=$("#storeCount"+k).text();
					if(!(salesCount==null||salesCount==""||salesPrice==null||salesPrice=="")){
						if (parseInt(salesCount) > parseInt(storeCount)) {
							alert("库存不足");
							$("#salesCount"+k).val("");
							falg=false;
							j++;
						}						
					}
					k++;
		        }
				
			});
			if(falg){
				$('#salesGoodsTab tbody tr').find('td').each(function(){
					if ($(this).index() == "0") {
						salesCount=$("#salesCount"+i).val();
						salesPrice=$("#salesPrice"+i).val();
						storeCount=$("#storeCount"+i).text();
						goodsTotalPay=$("#goodsTotalPay"+i).val();
						storageId=$(this).text();
						if(!(salesCount==null||salesCount==""||salesPrice==null||salesPrice=="")){
							if(goodsTotalPay==null||goodsTotalPay==""){
								$("#goodsTotalPay"+i).val(salesCount*salesPrice);
							}
							W.addSalesGoods(storageId,salesCount,salesPrice);
							j++;
						}
						i++;
			        }
					
				});
			}else {
				return;
			}
			alert(j);
			if (j==0) {
				alert("请选择销售数量或价格");
			}else {
				api.close();
			}
		}
		
		function continueAdd(){
			var i=0;
			var j=0;
			var k=0;
			var salesCount=null;
			var salesPrice=null;
			var storageId=null;
			var storeCount=null;
			var falg=true;
			
			$('#salesGoodsTab tbody tr').find('td').each(function(){
				if ($(this).index() == "0") {
					salesCount=$("#salesCount"+k).val();
					salesPrice=$("#salesPrice"+k).val();
					storeCount=$("#storeCount"+k).text();
					if(!(salesCount==null||salesCount==""||salesPrice==null||salesPrice=="")){
						if (parseInt(salesCount) > parseInt(storeCount)) {
							alert("库存不足");
							$("#salesCount"+k).val("");
							falg=false;
							j++;
						}						
					}
					k++;
		        }
				
			});
			if(falg){
				$('#salesGoodsTab tbody tr').find('td').each(function(){
					salesCount=$("#salesCount"+i).val();
					salesPrice=$("#salesPrice"+i).val();
					storeCount=$("#storeCount"+i).text();
					goodsTotalPay=$("#goodsTotalPay"+i).val();
					if ($(this).index() == "0") {
						storageId=$(this).text();
						if(!(salesCount==null||salesCount==""||salesPrice==null||salesPrice=="")){
							if(goodsTotalPay==null||goodsTotalPay==""){
								$("#goodsTotalPay"+i).val(salesCount*salesPrice);
							}
							W.continueAddSalesGoods(storageId,salesCount,salesPrice);
							j++;
						}
						i++;
			        }
					
				});
			}else {
				return;
			}
			
			if (j==0) {
				alert("请选择销售数量或价格");
			}else {
				api.close();
			}
		}

	</script>
