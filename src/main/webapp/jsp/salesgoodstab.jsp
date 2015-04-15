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
	    	  if (!a.test(data)) { 
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
	
</body>
</html>