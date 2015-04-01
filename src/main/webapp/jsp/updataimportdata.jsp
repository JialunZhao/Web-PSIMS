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
<script type="text/javascript"
	src="<%=_base%>/js/vendor/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="<%=_base%>/js/vendor/jquery-migrate-1.1.0.js"></script>
<script type="text/javascript"
	src="<%=_base%>/js/dialog/lhgdialog.min.js"></script>

</head>
<body>
	<div class="col-sm-offset-1">
		<div class="row placeholders">
			<div class="input-group col-xs-10 col-md-offset-1">
				<span class="input-group-addon" style="background-color: #1abc9c;">入库时间:</span>
				<input type="text" class="form-control" placeholder=""
					value="<fmt:formatDate value="${import1.importDatetime }" pattern="yyyy-MM-dd"/>" readonly="readonly">
				<span class="input-group-addon" style="background-color: #1abc9c;">供货商名称:</span>
				<select class="form-control" value="${import1.providerName }"
					tabindex="1" name="providerName" id="providerName">
					<option>${import1.providerName }</option>
					<c:forEach var="provider" items="${providerList}"
						varStatus="status">
						<option value="${provider.providerId }">${provider.providerName }</option>
					</c:forEach>
				</select>
			</div>
			<div class="input-group col-xs-10 col-md-offset-1">
				<span class="input-group-addon" style="background-color: #1abc9c;">存储仓库:</span>
				<select class="form-control" value="${import1.storehouseName }"
					tabindex="1" name="storehouseName" id="storehouseName">
					<option>${import1.storehouseName }</option>
					<c:forEach var="storehouse" items="${storehouseList}"
						varStatus="status">
						<option value="${storehouse.storehouseId }">${storehouse.storehouseName }</option>
					</c:forEach>
				</select>
				<span class="input-group-addon" style="background-color: #1abc9c;">库存状态：</span>
                <select class="form-control" value="请选择支付状态" tabindex="1" name="payStatus" id="payStatus">
                  <option value="0">${import1.importStatus }</option>
                  <option>未付款</option>
                  <option>已付款</option>
                </select>
			</div>
			<div class="input-group col-xs-10 col-md-offset-1">
				<span class="input-group-addon" style="background-color: #1abc9c;">支付方式：</span>
				<select class="form-control" value="请选择支付方式" tabindex="1"
					name="paymentType" id="paymentType">
					<option>${import1.paymentType }</option>
					<option>现金</option>
					<option>转账</option>
					<option>支票</option>
					<option>赊账</option>
				</select> <span class="input-group-addon" style="background-color: #1abc9c;">支付时间</span>
				<input type="text" class="form-control"
					placeholder="2015-03-03 10:12:00" value="2015-03-03 10:12:00">
			</div>
		</div>
		<div class="row placeholders" id="addgoodstb">
            <div class="row">
              <div class="table-responsive col-xs-12">
                <table class="table table-striped" id="addGoodsTab">
                  <thead>
                    <tr>
                      <th>入库流水号</th>
                      <th>商品名称</th>
                      <th>进货数量</th>
                      <th>失效日期</th>
                    </tr>
                  </thead>
                  <tbody>
                  	<c:forEach items="${importGoodsList }" var="importGoods" varStatus="status">
                  		<tr>
                  			<td>${importGoods.importSerialNumber }</td>
                  			<td>${importGoods.goodsName }</td>
                  			<td>
                  				<input type="text" name="goodsAmount" value="${importGoods.importGoodsAmount }">
                  			</td>
                  			<td>
                  				<input type="text" name="goodsExpirationDate" value="<fmt:formatDate value="${importGoods.importGoodsExpirationDate }" pattern="yyyy-MM-dd"/>">
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
			var providerName=$("#providerName").val();
			var storehouseName=$("#storehouseName").val();
			var payStatus=$("#payStatus").val();
			var payStatusT=$("#payStatus").find("option:selected").text();
			alert(payStatus);
			alert(payStatusT);
			var paymentType=$("#paymentType").val();
			var goodsList="";
			 $('#addGoodsTab tbody tr').find('td').each(function(){
				goodsList=goodsList+$(this).text()+",";
			});
			 var url="<%=_base %>/accountController/updataImprotGoodsList.do?providerName="
					+ encodeURI(encodeURI(providerName)) + "&storehouseName="
					+ encodeURI(encodeURI(storehouseName))+ "&payStatus="
					+ encodeURI(encodeURI(payStatus))+ "&paymentType="
					+ encodeURI(encodeURI(paymentType))+ "&goodsList="
					+ encodeURI(encodeURI(goodsList));
			api.reload(this, url);
			api.close();
		}
	</script>
	
</body>
</html>