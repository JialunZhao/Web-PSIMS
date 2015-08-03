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
<link href="<%=_base%>/css/bootstrap/bootstrap.min.css" rel="stylesheet">

<!-- Loading Flat UI -->
<link href="<%=_base%>/css/flatUI/flat-ui.min.css" rel="stylesheet">
<link href="<%=_base%>/css/dashboard.css" rel="stylesheet">
<link href="<%=_base%>/css/index.css" rel="stylesheet">
<script src="<%=_base%>/js/vendor/video.js"></script>
<%-- <script src="<%=_base %>/js/flat-ui.min.js"></script> --%>
<script type="text/javascript" src="<%=_base%>/js/vendor/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=_base%>/js/dialog/lhgdialog.min.js"></script>

</head>
<body>
	<div class="col-sm-offset-1">
		<div class="row placeholders">
			<div class="input-group col-xs-10 col-md-offset-1">
				<span class="input-group-addon" style="background-color: #1abc9c;">入库时间:</span>
				<input type="text" class="form-control" placeholder=""
					value="<fmt:formatDate value="${import1.importDatetime }" pattern="yyyy-MM-dd"/>">
				<span class="input-group-addon" style="background-color: #1abc9c;">供货商名称:</span>
				<select class="form-control" value="${import1.providerName }"
					tabindex="1" name="providerName" id="providerName">
					<option value="${import1.providerId }">${import1.providerName }</option>
					<c:forEach var="provider" items="${providerList}"
						varStatus="status">
						<c:if test="${provider.providerName!=import1.providerName }">
							<option value="${provider.providerId }">${provider.providerName }</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
			<div class="input-group col-xs-10 col-md-offset-1">
				<span class="input-group-addon" style="background-color: #1abc9c;">库存状态：</span>
				<select class="form-control" value="请选择入库状态" tabindex="1"
					name="importStatus" id="importStatus"
					onchange="showPayMet(this.value)">
					<c:if test="${import1.importStatus==32 }">
						<option value="<%=Constants.ImportStatus.GOODSARRIVAL%>"><%=Constants.ImportStatus.GOODSARRIVAL01%></option>
						<option value="<%=Constants.ImportStatus.GOODSIMPORT%>"><%=Constants.ImportStatus.GOODSIMPORT01%></option>
						<option value="<%=Constants.ImportStatus.ORDERNOPAY%>"><%=Constants.ImportStatus.ORDERNOPAY01%></option>
						<option value="<%=Constants.ImportStatus.ORDERYESPAY%>"><%=Constants.ImportStatus.ORDERYESPAY01%></option>
					</c:if>
					<c:if test="${import1.importStatus==33 }">
						<option value="<%=Constants.ImportStatus.GOODSIMPORT%>"><%=Constants.ImportStatus.GOODSIMPORT01%></option>
						<option value="<%=Constants.ImportStatus.ORDERNOPAY%>"><%=Constants.ImportStatus.ORDERNOPAY01%></option>
						<option value="<%=Constants.ImportStatus.ORDERYESPAY%>"><%=Constants.ImportStatus.ORDERYESPAY01%></option>
					</c:if>
					<c:if test="${import1.importStatus==30 }">
						<option value="<%=Constants.ImportStatus.ORDERNOPAY%>"><%=Constants.ImportStatus.ORDERNOPAY01%></option>
						<option value="<%=Constants.ImportStatus.GOODSIMPORT%>"><%=Constants.ImportStatus.GOODSIMPORT01%></option>
						<option value="<%=Constants.ImportStatus.ORDERYESPAY%>"><%=Constants.ImportStatus.ORDERYESPAY01%></option>
					</c:if>
					<c:if test="${import1.importStatus==31 }">
						<option value="<%=Constants.ImportStatus.ORDERYESPAY%>"><%=Constants.ImportStatus.ORDERYESPAY01%></option>
						<option value="<%=Constants.ImportStatus.GOODSIMPORT%>"><%=Constants.ImportStatus.GOODSIMPORT01%></option>
						<option value="<%=Constants.ImportStatus.ORDERNOPAY%>"><%=Constants.ImportStatus.ORDERNOPAY01%></option>
					</c:if>
				</select>
			</div>
			<div class="input-group col-xs-10 col-md-offset-1" id="payM"
				style="display: none">
				<span class="input-group-addon" style="background-color: #1abc9c;">支付方式：</span>
				<select class="form-control" value="请选择支付方式" tabindex="1"
					name="paymentType" id="paymentType">
					<c:if test="${import1.paymentType==null||import1.paymentType=='' }">
						<option value="">请选择支付方式</option>
						<option value="<%=Constants.PayMed.CASH%>"><%=Constants.PayMed.CASH01%></option>
						<option value="<%=Constants.PayMed.CHEQUE%>"><%=Constants.PayMed.CHEQUE01%></option>
						<option value="<%=Constants.PayMed.TICK%>"><%=Constants.PayMed.TICK01%></option>
						<option value="<%=Constants.PayMed.TRANSFERS%>"><%=Constants.PayMed.TRANSFERS01%></option>
					</c:if>
					<c:if test="${import1.paymentType=='02' }">
						<option value="<%=Constants.PayMed.CHEQUE%>"><%=Constants.PayMed.CHEQUE01%></option>
					</c:if>
					<c:if test="${import1.paymentType=='03' }">
						<option value="<%=Constants.PayMed.TICK%>"><%=Constants.PayMed.TICK01%></option>
					</c:if>
					<c:if test="${import1.paymentType=='01' }">
						<option value="<%=Constants.PayMed.TRANSFERS%>"><%=Constants.PayMed.TRANSFERS01%></option>
					</c:if>
					<c:if test="${import1.paymentType=='00' }">
						<option value="<%=Constants.PayMed.CASH%>"><%=Constants.PayMed.CASH01%></option>
					</c:if>
				</select> <span class="input-group-addon" style="background-color: #1abc9c;">支付时间</span>
				<input type="text" class="form-control" placeholder="2015-03-03"
					value="2015-03-03" onblur="checkDataFomat(this.value)" id="payTime"
					name="payTime">
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
								<th>商品单价</th>
								<th>进货数量</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${importGoodsList }" var="importGoods"
								varStatus="status">
								<tr>
									<td>${importGoods.importSerialNumber }</td>
									<td>${importGoods.goodsName }</td>
									<td style="display: none">${importGoods.goodsId}</td>
									<td>${importGoods.importGoodsPrice}</td>
									<td><input type="text" name="goodsAmount"
										value="${importGoods.importGoodsAmount }"></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<div class="input-group col-xs-1">
					<button type="button" class="btn btn-primary"
						onclick="suerUpdate()">确认修改</button>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
	var api = frameElement.api, W = api.opener;
		showPayMet('${import1.importStatus}');
		function suerUpdate(){
			var providerId=$("#providerName").val();
			var providerName=$("#providerName").find("option:selected").text();
			var importStatus=$("#importStatus").val();
			var paymentType=$("#paymentType").val();
			var importSerialNumber=null;
			var payTime=$("#payTime").val();
			var importGoodsIdList="";
			var goodsAmountList="";
			if (importStatus == <%=Constants.ImportStatus.ORDERNOPAY%>) {
				payTime="";
				paymentType="";
			}
			$('#addGoodsTab tbody tr').find('td').each(function(){
				if ($(this).index() == "0") {
					importSerialNumber=$(this).text();
		         }
				 if ($(this).index() == "2") {
					 importGoodsIdList=importGoodsIdList+$(this).text()+",";
		         }
			});
			$("input[name=goodsAmount]").each(function(){
				goodsAmountList=goodsAmountList+$(this).val()+",";
			});
			alert(goodsAmountList);
			 var url="<%=_base%>/importController/updataImprotGoodsList.do?providerId="
					+ providerId
					+ "&providerName="
					+ providerName
					+ "&importStatus="
					+ importStatus
					+ "&payTime="
					+ payTime
					+ "&paymentType="
					+ paymentType
					+ "&goodsAmountList="
					+ goodsAmountList
					+ "&importGoodsIdList="
					+ importGoodsIdList
					+ "&importSerialNumber=" + importSerialNumber;
				alert(url);

			api.reload(this, url);
			W.location.reload();
			api.close();
		}

		/* function getTotalPrict(){
			var importGoodsPrice;
			var importGoodsAmount=new Array();
			var i=0;
			$("input[name=goodsAmount]").each(function(){
				importGoodsAmount.push($(this).val());
			})
			$('#addGoodsTab tbody tr').find('td').each(function(){
				if ($(this).index() == "3") {
					importGoodsPrice=$(this).text();
		         }
				 if ($(this).index() == "5") { 
					 this.innerHTML=importGoodsPrice*importGoodsAmount[i++];
		         }
			});
		}
		 */
		function showPayMet(val) {
			if (val != <%=Constants.ImportStatus.ORDERNOPAY%>) {
				$("#payM").show();
			} else {
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