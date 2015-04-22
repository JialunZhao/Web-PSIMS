<%@page import="com.ai.psims.web.util.Constants"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
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

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String date = sdf.format(new Date());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<title>北京市金瑞超达商贸有限公司-食品库存管理系统DEMO</title>
<%-- <jsp:include page="updataimportdata.jsp" flush="true"></jsp:include> --%>
<%-- <jsp:include page="common.jsp" flush="true"></jsp:include> --%>

<!-- Loading Bootstrap -->

<link href="<%=_base%>/css/bootstrap/bootstrap.min.css" rel="stylesheet">

<!-- Loading Flat UI -->
<link href="<%=_base%>/css/flatUI/flat-ui.min.css" rel="stylesheet">
<link href="<%=_base%>/css/dashboard.css" rel="stylesheet">
<link href="<%=_base%>/css/index.css" rel="stylesheet">
<script type="text/javascript" src="<%=_base%>/js/vendor/jquery.min.js"></script>
<script type="text/javascript" src="<%=_base%>/js/dialog/lhgdialog.min.js"></script>


<link rel="shortcut icon" href="img/favicon.ico">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
<!--[if lt IE 9]>
      <script src="./js/vendor/html5shiv.js"></script>
      <script src="./js/vendor/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<%=_base%>/index.html">北京市金瑞超达商贸有限公司-食品库存管理系统DEMO</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="<%=path%>/sitting.html">系统设置</a></li>
				<li><a href="<%=path%>/user.html">员工权限</a></li>
				<li><a href="#">帮助</a></li>
			</ul>
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search...">
			</form>
		</div>
	</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a href="<%=path%>/customer.html">客户管理</a></li>
					<li><a href="<%=path%>/provider.html">供应商</a></li>
					<li><a href="<%=path%>/goods.html">商品管理</a></li>
					<li><a href="<%=path%>/storehouse.html">仓库管理</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="<%=path %>/importController/init.do">货品入库下单</a></li>
					<li><a href="<%=path %>/importController/importInit.do">货品入库</a></li>
					<li><a href="<%=path %>/salesController/init.do">销售出库</a></li>
					<li><a
						href="<%=path%>/backGoodsController/providerBackInit.do">供应商退货</a></li>
					<li><a href="<%=path%>/backGoodsController/salesBackInit.do">客户退货</a></li>
					<!-- <li><a href="#">有效期调整</a></li>
					<li><a href="#">销毁出库</a></li> -->
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="<%=path%>/recoveryimport.html">回收物入库</a></li>
					<li><a href="<%=path%>/recoveryexport.html">回收物出库</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="#">统计报表</a></li>
				</ul>
			</div>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h3 class="page-header">客户货品退货</h3>

				<div class="row placeholders">
					<form class="form-inline">
						<div class="form-group">
							<label for="exampleInputName2">客户名称：</label> <select
								class="form-control" value="请选择客户名称" tabindex="1"
								name="customerName" id="customerName">
								<option value="">请选择客户名称</option>
								<c:forEach var="customers" items="${customersList}"
									varStatus="status">
									<option value="${customers.customerId }">${customers.customerName }</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail2">仓库名称：</label> <select
								class="form-control" value="请选仓库" tabindex="1"
								name="storehouseName" id="storehouseName">
								<option value="">请选择仓库</option>
								<c:forEach var="storehouse" items="${storehouseList}"
									varStatus="status">
									<option value="${storehouse.storehouseId }">${storehouse.storehouseName }</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail2">销售人员：</label> <select
								class="form-control" value="请选仓库" tabindex="1"
								name="employeeName" id="employeeName">
								<option value="">请选择销售人员</option>
								<c:forEach var="employees" items="${employeesList}"
									varStatus="status">
									<option value="${employees.employeeId }">${employees.employeeName }</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail2">销售退货流水号</label> <input
								type="text" class="form-control" id="salesbackSerialNumber"
								placeholder="销售退货流水号">
						</div>
						<button type="button" class="btn btn-primary"
							onclick="queryImportList()">搜索</button>
					</form>
				</div>

				<div class="row placeholders ">
					<div class="col-sm-2">
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#importgoods">新增客户退货单</button>
						<!-- <button type="button" class="btn btn-primary" onclick="showAddDialog()">新增入库单</button> -->
						<!--  <button type="button" id="delbtn" class="btn btn-primary">批量删除入库单</button>
            <button type="button" id="delcommit" class="btn btn-primary" style="display:none">确认删除选中的入库单</button>
            <button type="button" id="delcancle" class="btn btn-primary" style="display:none">取消</button> -->
					</div>
				</div>
				<h4 class="sub-header">客户退货清单</h4>
				<div class="table-responsive">
					<table class="table table-striped" id="importGoodListTab">
						<thead>
							<tr>
								<th class="chk" style="display: none"><input
									type="checkbox" aria-label="..."></th>
								<th>退货流水号</th>
								<th>销售流水号</th>
								<th>退货时间</th>
								<th>退货类型</th>
								<th>退货状态</th>
								<th>退货原因</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="salesBacks" items="${salesbackList}"
								varStatus="status">
								<tr>
									<td class="chk" style="display: none"><input
										type="checkbox" aria-label="..."></td>
									<td>${salesBacks.salesbackSerialNumber}</td>
									<td>${salesBacks.salesSerialNumber}</td>
									<td><fmt:formatDate value="${salesBacks.salesbackTime}"
											pattern="yyyy-MM-dd" /></td>
									<td>${salesBacks.salesbackType}</td>
									<td></td>
									<td>${salesBacks.salesbackReason}</td>
									<td><a href="#" data-toggle="modal"
										data-target="#importgoodsprint">打印</a>/<a href="#"
										onclick="updateSalesbackData(${salesBacks.salesbackSerialNumber})">修改</a>/<a href="#"
										onclick="deleteImportData(${salesBacks.salesbackSerialNumber})">删除</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>




	<!-- 模态框（Modal） -->
	<!-- 添加入库单模态框（Modal） -->
	<div class="modal fade" id="importgoods" tabindex="-1" role="dialog"
		aria-labelledby="importgoods" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">新增客户退货单</h4>
				</div>
				<div class="modal-body" id="importgoodsform">
					<div class="row placeholders">
						<div class="input-group col-xs-10 col-md-offset-1">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">销售流水号:</span> <input
								type="text" class="form-control" value="" id="salesSerialNumber">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">退货时间:</span> <input
								type="text" class="form-control" value="<%=date%>"
								id="backgoodsTime">
						</div>
						<div class="input-group col-xs-10 col-md-offset-1">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">退货类型：</span> <select
								class="form-control" value="请选择折扣方式" tabindex="1"
								name="backType" id="backType">
								<option value="<%=Constants.BackType.CHANGEGOODS%>"><%=Constants.BackType.CHANGEGOODS01%></option>
								<option value="<%=Constants.BackType.BACKGOODS%>"><%=Constants.BackType.BACKGOODS01%></option>
							</select>
							<span class="input-group-addon"
								style="background-color: #1abc9c;">退货原因:</span> <input
								type="text" class="form-control" value="" id="backReson">
						</div>
						<div class="input-group col-xs-1 col-md-offset-1">
							<button type="button" class="btn btn-primary" id="addgoodsbtn">添加商品</button>
						</div>
					</div>
				</div>
				<div class="modal-body" id="addgoods" style="display: none">
					<div class="row placeholders">
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">商品名称:</span> <select
								class="form-control" value="请选择商品" tabindex="1" name="goodsName"
								id="goodsName" onChange="showTable(this.value)">

							</select>
						</div>
					</div>
				</div>

				<div class="modal-body" id="addgoodstb" style="display: none">
					<div class="row">
						<div class="table-responsive col-xs-15">
							<table class="table table-striped" id="addGoodsTab">
								<thead>
									<tr>
										<th>商品名称</th>
										<th>基本单位</th>
										<th>生产日期</th>
										<th>换货数量</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>

						<div class="input-group col-xs-1">
							<button type="button" class="btn btn-primary" id="suerAdd">确认新增</button>
						</div>
					</div>
				</div>


				<div class="modal-footer">
					<!-- <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button type="button" class="btn btn-primary" id="sureAdd">确认新增</button> -->
					<button type="button" class="btn btn-primary" id="getBack">返回</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->


	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<%=_base%>/js/vendor/video.js"></script>
	<script src="<%=_base%>/js/flat-ui.min.js"></script>
	<script type="text/javascript">
	
	function deleteImportData(salesbackSerialNumber){
		$.ajax({  
            url:'<%=_base %>/backGoodsController/deleteImportData.do',  
            type:"post",  
            async:false,
            modal : true,
            showBusi : false,
            data:{'salesbackSerialNumber':salesbackSerialNumber},
            success:function(data){  
            	if($.parseJSON(data).RES_RESULT=="SUCCESS"){
          		  alert("成功删除入库单");
          		  location.reload();
          	  	}else{
          		  alert("添加删除单失败");
          	  	}
			}
                    
        });       
	}
	
	function selectGoods(salesSerialNumber){
		var selOpt = $("#goodsName option");  
		selOpt.remove();
		$("#goodsName").append( "<option value=''>请选择商品</option>" );		
		$.ajax({  
                    url:'<%=_base%>/backGoodsController/queryGoods.do',  
                    type:"post",  
                    async:false,
                    modal : true,
                    showBusi : false,
                    data:{'salesSerialNumber':salesSerialNumber},
                    success:function(data){  
                    			var json = $.parseJSON(data);
                    			if(json.RES_RESULT=="SUCCESS"){
                    				var goodsName=$.parseJSON(json.RES_DATA.goodsNameSet);
    									for (var i = 0; i < goodsName.length; i++) {
        									$("#goodsName").append( "<option>"+goodsName[i]+"</option>" );
        								}
    									$("#addgoods").show();
    							        $("#addgoodsbtn").hide();
    							        $("#importgoodsform").hide();
    								
    							}else{
    								alert("该流水号下没有对应的商品信息");
    							}      
                    			}
								                      
                });       
	}
	
	function checkIsNull(str){
	  	  if(str==null||str==""){
	  		  return true;
	  	  }
	  	  return false;
	}
	
	function queryImportList() {
  		var selOpt = $("#importGoodListTab tbody tr");  
		selOpt.remove();
		var customerId=$("#customerName").val();
		var storehouseId=$("#storehouseName").val();
		var salesbackSerialNumber=$("#salesbackSerialNumber").val();
		var employeeId=$("#employeeName").val();
		$.ajax(  
                {  
                    url:'<%=_base%>/backGoodsController/querySalesbackList.do',  
                    type:"post",  
                    async:true,
                    data:{'customerId':customerId,
                    	'storehouseId':storehouseId,
                    	'employeeId':employeeId,
                    	'salesbackSerialNumber':salesbackSerialNumber
                    	},
                    success:function(data){  
                    			var json = $.parseJSON(data);
								var salesList=$.parseJSON(json.RES_DATA.salesList);
								for (var i = 0; i < salesList.length; i++) {
    										$("#importGoodListTab tbody").append( '<tr><td class="chk" style="display:none"><input type="checkbox" aria-label="..."></td>'
    					                  	+'<td>'+isNull(salesList[i].salesbackSerialNumber)+'</td>'
    					                  	+'<td>'+isNull(salesList[i].salesSerialNumber)+'</td>'
    					                  	+'<td>'+getLocalTime(salesList[i].salesbackTime)+'</td>'
    					                  	+'<td>'+isNull(salesList[i].salesbackType)+'</td>'
    					                  	+'<td></td>'
    					                  	+'<td>'+isNull(salesList[i].salesbackReason)+'</td>'
    					                  	+'<td><a href="#">打印</a>/<a href="#" data-toggle="modal" data-target="#salesgoodsmodify" onclick="updateSalesData('+isNull(salesList[i].salesSerialNumber)+')">修改</a>/<a href="#" onclick="deleteSalesData('+isNull(salesList[i].salesSerialNumber)+')" >删除</a></td></tr>' );
        								
    										
								}
                            
                }  
                }); 
	}
	
	function isNull(str) {
		if(str==null){
			str="";
		}
		return str;
	}
	
	function addSalesGoods(storageId,changeSalesCount,goodsName,goodsUnit,goodsProductionDate) {
		$("#addGoodsTab tbody").append("<tr id="+len+">"
				+"<td  style='display:none'>"+storageId+"</td>"
				+"<td>"+goodsName+"</td>"
				+"<td>"+goodsUnit+"</td>"
				+"<td>"+goodsProductionDate+"</td>"
				+"<td>"+changeSalesCount+"</td>"
				+"<td><a href=\'#\' onclick=\'deteleGoods("+len+")\' >删除商品</a></td>"
				+"</tr>");
			len++;
		 	$("#addgoods").hide();
			$("#addgoodstb").show();
	}
	
	function continueAddSalesGoods(storageId,changeSalesCount,goodsName,goodsUnit,goodsProductionDate) {    	
		$("#addGoodsTab tbody").append("<tr id="+len+">"
				+"<td  style='display:none'>"+storageId+"</td>"
				+"<td>"+goodsName+"</td>"
				+"<td>"+goodsUnit+"</td>"
				+"<td>"+goodsProductionDate+"</td>"
				+"<td>"+changeSalesCount+"</td>"
				+"<td><a href=\'#\' onclick=\'deteleGoods("+len+")\' >删除商品</a></td>"
				+"</tr>");
		len++;    	
	}
	
	 function deteleGoods(len){
	  		$("#addGoodsTab tbody tr[id='"+len+"']").remove();
	  		var _len = $("#addGoodsTab tbody tr").length;
	  		if(_len==0){
	  			$("#addgoodstb").hide();
	  			$("#importgoodsform").show();
	  			$("#addgoodsbtn").show();
	  		}
	  	}
	
	function showTable(goodName){    	
    	if (!checkIsNull(goodName)) {
    		var backType=$("#backType").val();
    		var salesSerialNumber=$("#salesSerialNumber").val();
    		var url='<%=_base%>/backGoodsController/queryGoodsDemo.do?goodName='+encodeURI(encodeURI(goodName))+'&backType='+backType+'&salesSerialNumber='+salesSerialNumber;
    		$.dialog({
    			title:'可换货商品',
    			width:1200,
    			height:700,
    			max:false,
    			min:false,
    			content:'url:'+url
    		});
		}		
	}
	
	function updateSalesbackData(salesbackSerialNumber) {
    	var url='<%=_base%>/backGoodsController/updateSalesbackGoodsList.do?salesbackSerialNumber='+salesbackSerialNumber;
		$.dialog({
			title:'修改客户退货单',
			width:900,
			height:700,
			max:false,
			min:false,
			content:'url:'+url
		});
	}
	
	function getLocalTime(nS) {
		if(nS==null){
			return "";
		}
		var t=new Date(nS);
		y = t.getFullYear();
		m = t.getMonth()+1;
		d = t.getDate();
		if(d<10){
			d='0'+d;
		}
		if(m<10){
			m='0'+m;
		}
		return y+"-"+m+"-"+d;
	} 
    </script>
	<script type="text/javascript">
    var len=$("#addGoodsTab tbody tr").length;
    $(document).ready(function(){
      $("#delbtn").click(function(){
        $("#delbtn").hide();
        $("#delcommit").show();
        $("#delcancle").show();
        $(".chk").show();
      });
      $("#delcommit").click(function(){
        $("#delbtn").show();
        $("#delcommit").hide();
        $("#delcancle").hide();
        $(".chk").hide();
      });
      $("#delcancle").click(function(){
        $("#delbtn").show();
        $("#delcommit").hide();
        $("#delcancle").hide();
        $(".chk").hide();
      });  
      
      $("#getBack").click(function(){
    	  var salIsHidden=$("#importgoodsform").is(":hidden");
    	  var addbtnIsHidden=$("#addgoodstb").is(":hidden");
    	  var addGoodIsHidden=$("#addgoods").is(":hidden");
    	  if (!salIsHidden) {
    		  $("#importgoods").hide();
		  }
    	  if(!addbtnIsHidden){
    		  $("#addgoods").show();
    	      $("#addgoodstb").hide();
    	  }
		  if(!addGoodIsHidden){
			  $("#addgoods").hide();
		      $("#addgoodsbtn").show();
		      $("#salesgoodsform").show();
    	  }
        }); 
      
      $("#suerAdd").click(function(){
    	  var storageIdList="";
    	  var changeCountList="";
    	  var salesSerialNumber=$("#salesSerialNumber").val();
    	  var backReson=$("#backReson").val();
    	  var backgoodsTime=$("#backgoodsTime").val();
    	  $('#addGoodsTab tbody tr').find('td').each(function() {
    		  if ($(this).index() == "0") {
    			  storageIdList=storageIdList+$(this).text()+",";
		      }
    		  if ($(this).index() == "4") {
    			  changeCountList=changeCountList+$(this).text()+",";
		      }
          });
    	  $.ajax(  
                  {  
                      url:'<%=_base%>/backGoodsController/addSalesbackList.do',  
                      type:"post",  
                      async:false,
                      traditional:true,
                      data:{'storageIdList':storageIdList,
                    	    'changeCountList':changeCountList,
                    	    'salesSerialNumber':salesSerialNumber,
                    	    'backReson':backReson,
                    	    'backgoodsTime':backgoodsTime},
                      success:function(data){
                    	  if($.parseJSON(data).RES_RESULT=="SUCCESS"){
                    		  alert("成功添加销售单");
                    		  location.reload();
                    	  }else{
                    		  alert("添加销售单失败");
                    	  }
                    	  var selOpt = $("#addGoodsTab tbody tr");  
                  		  selOpt.remove();
                    	  $("#importgoods").hide();
                    	  $("#addgoodstb").hide();
                    	  $("#importgoodsform").show();
                    	  $("#addgoodsbtn").show();
                  	  }  
                  });      
      });
      $("#addgoodsbtn").click(function(){
    	  var salesSerialNumber=$("#salesSerialNumber").val();
    	  var backReson=$("#backReson").val();
        	if (checkIsNull(salesSerialNumber)) {
    			alert("请填写销售流水号");
    			return;
    		}	
        	if (checkIsNull(backReson)) {
    			alert("请填写退货原因");
    			return;
    		}	
            selectGoods(salesSerialNumber);
        }); 
      
      function checkIsNull(str){
    	  if(str==null||str==""){
    		  return true;
    	  }
    	  return false;
      }
      
      function checkDataFomat(data){
    	  var a = /^(\d{4})-(\d{2})-(\d{2})$/;
    	  if (!a.test(data)) { 
    		  alert("日期格式不正确!正确格式为:yyyy-mm-dd"); 
    		  return true;
    	  };
    	  return false;
      }
      
      
    });						
	</script>
	<script type="text/javascript">
		function getGoodsExpirationDate(goodsProductionDate) {
			if (checkDataFomat(goodsProductionDate)) {
				return;
			}
			var goodsShelfLife = $("#goodsShelfLife").val();
			var goodsExpirationDate = getthedate(goodsProductionDate,
					goodsShelfLife);
			$("#goodsExpirationDate").val(goodsExpirationDate);
		}

		function getthedate(dd, dadd) {
			//可以加上错误处理
			var a = new Date(dd);
			a = a.valueOf();
			a = a + dadd * 24 * 60 * 60 * 1000;
			a = new Date(a);
			var m = a.getMonth() + 1;
			if (m.toString().length == 1) {
				m = '0' + m;
			}
			var d = a.getDate();
			if (d.toString().length == 1) {
				d = '0' + d;
			}
			return a.getFullYear() + "-" + m + "-" + d;

		}
		function getGoodsAllPay(goodsCount) {
			var goodsPrice = $("#goodsPrice").val();
			var goodsAllPay = goodsCount * goodsPrice;
			$("#goodsAllPay").val(goodsAllPay);
		}

		function checkDataFomat(data) {
			var a = /^(\d{4})-(\d{2})-(\d{2})$/;
			if (!a.test(data)) {
				alert("日期格式不正确!正确格式为:yyyy-mm-dd");
				return true;
			}
			;
			return false;
		}
	</script>
</body>
</html>