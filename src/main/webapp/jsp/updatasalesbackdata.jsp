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
				<span class="input-group-addon" style="background-color: #1abc9c;">退货时间:</span>
				<input type="text" class="form-control" placeholder=""
					value="<fmt:formatDate value="${salesback.salesbackTime }" pattern="yyyy-MM-dd"/>" style="font: bolder;">
				<span class="input-group-addon" style="background-color: #1abc9c;">业务员名称:</span>
				<input type="text" class="form-control" value="${salesback.employeeName }">
			</div>
			<div class="input-group col-xs-10 col-md-offset-1">
				<span class="input-group-addon" style="background-color: #1abc9c;">客户名称:</span>
				<input type="text" class="form-control" value="${salesback.customerName }">
				<span class="input-group-addon" style="background-color: #1abc9c;">仓库名称:</span>
				<input type="text" class="form-control" value="${salesback.storehouseName }">
			</div>
			<div class="input-group col-xs-10 col-md-offset-1">
				<span class="input-group-addon" style="background-color: #1abc9c;">退货类型：</span>
				<select class="form-control" value="请选择入库状态" tabindex="1" name="salesbackType" id="salesbackType">
                	<c:if test="${salesback.salesbackType=='退货' }">
                		<option value="<%=Constants.BackType.BACKGOODS %>"><%=Constants.BackType.BACKGOODS01 %></option>
                		<option value="<%=Constants.BackType.CHANGEGOODS %>"><%=Constants.BackType.CHANGEGOODS01 %></option>
                	</c:if>
                	<c:if test="${salesback.salesbackType=='换货' }">
                		<option value="<%=Constants.BackType.CHANGEGOODS %>"><%=Constants.BackType.CHANGEGOODS01 %></option>
                		<option value="<%=Constants.BackType.BACKGOODS %>"><%=Constants.BackType.BACKGOODS01 %></option>
                	</c:if>
                </select>
				<span class="input-group-addon" style="background-color: #1abc9c;">退货原因</span>
				<input type="text" class="form-control" value="${salesback.salesbackReason }" id="salesbackReason">
			</div>
		</div>
		<div class="row placeholders" id="addgoodstb">
            <div class="row">
              <div class="table-responsive col-xs-12">
                <table class="table table-striped" id="addGoodsTab">
                  <thead>
                    <tr>
                      <th>销售退货流水号</th>
                      <th>商品名称</th>
                      <th>退货类型</th>
                      <th>换货数量</th>
                    </tr>
                  </thead>
                  <tbody>
                  	<c:forEach items="${salesbackGoodsList }" var="salesbackGoods" varStatus="status">
                  		<tr>
                  			<td style="display: none">${salesbackGoods.storageId }</td>
                  			<td>${salesbackGoods.salesbackSerialNumber }</td>
                  			<td>${salesbackGoods.goodsName }</td>
                  			<td>${salesback.salesbackType }</td>
                  			<td>
                  				<input type="text" id="goodsAmount${status.index }" value="${salesbackGoods.goodsAmount }">
                  			</td>
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
		function suerUpdate(){
			var salesbackSerialNumber="${salesback.salesbackSerialNumber}";
			var salesbackType=$("#salesbackType").val();
			var salesbackReason=$("#salesbackReason").val();
			var goodsAmountList="";
			var storageIdList="";
			var i=0;
			$('#addGoodsTab tbody tr').find('td').each(function(){
				if ($(this).index() == "0") {
					storageIdList=storageIdList+$(this).text()+",";
					goodsAmountList=goodsAmountList+$("#goodsAmount"+i).val()+",";
					i++;
		        }
			});
			 var url="<%=_base %>/backGoodsController/updataImprotGoodsList.do?salesbackSerialNumber="
					+ salesbackSerialNumber + "&storageIdList="
					+ storageIdList + "&salesbackReason="
					+ salesbackReason + "&salesbackType="
					+ salesbackType + "&goodsAmountList="
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