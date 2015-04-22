<%@page import="com.ai.psims.web.util.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
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

<link href="<%=_base%>/css/bootstrap/bootstrap.min.css"
	rel="stylesheet">

<!-- Loading Flat UI -->
<link href="<%=_base%>/css/flatUI/flat-ui.min.css" rel="stylesheet">
<link href="<%=_base%>/css/dashboard.css" rel="stylesheet">
<link href="<%=_base%>/css/index.css" rel="stylesheet">
<script type="text/javascript" src="<%=_base%>/js/vendor/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=_base%>/js/dialog/lhgdialog.min.js"></script>


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
				<h3 class="page-header">销售出库</h3>

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
							<label for="exampleInputEmail2">收款方式：</label> <select
								class="form-control" value="请选择收款方式" tabindex="1"
								name="quyPayMed">
								<option value="">请选择收款方式</option>
								<option value="00">现金</option>
								<option value="01">转账</option>
								<option value="02">支票</option>
								<option value="03">赊账</option>
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
							<label for="exampleInputEmail2">销售流水号</label> <input type="text"
								class="form-control" id="qurSalesSerialNumber"
								placeholder="销售流水号">
						</div>
						<button type="button" class="btn btn-primary"
							onclick="queryImportList()">搜索</button>
					</form>
				</div>

				<div class="row placeholders ">
					<div class="col-sm-2">
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#salesgoods">新增销售单</button>
						<!-- <button type="button" id="delbtn" class="btn btn-primary">批量删除销售单</button>
            <button type="button" id="delcommit" class="btn btn-primary" style="display:none">确认删除选中的销售单</button>
            <button type="button" id="delcancle" class="btn btn-primary" style="display:none">取消</button> -->
					</div>
				</div>

				<h4 class="sub-header">销售清单</h4>
				<div class="table-responsive">
					<table class="table table-striped" id="saleTab">
						<thead>
							<tr>
								<th class="chk" style="display: none"><input
									type="checkbox" aria-label="..."></th>
								<th>销售流水号</th>
								<th>销售时间</th>
								<th>业务员名称</th>
								<th>客户名称</th>
								<th>仓库名称</th>
								<th>应收总价</th>
								<th>销售状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="sales" items="${salesList}" varStatus="status">
								<tr>
									<td class="chk" style="display: none"><input
										type="checkbox" aria-label="..."></td>
									<td>${sales.salesSerialNumber }</td>
									<td><fmt:formatDate value="${sales.salesDate }"
											pattern="yyyy-MM-dd" /></td>
									<td>${sales.employeeName }</td>
									<td>${sales.customerName }</td>
									<td>${sales.storehouseName }</td>
									<td>${sales.salesTotalPrice }</td>
									<td>${sales.salesStatus }</td>
									<td><a href="#">打印</a>/<a href="#" data-toggle="modal"
										data-target="#salesgoodsmodify"
										onclick="updateSalesData(${sales.salesSerialNumber })">修改</a>/<a
										href="#"
										onclick="deleteSalesData(${sales.salesSerialNumber })">删除</a></td>
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
	<div class="modal fade" id="salesgoods" tabindex="-1" role="dialog"
		aria-labelledby="importgoods" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">新增销售单</h4>
				</div>
				<div class="modal-body" id="salesgoodsform">
					<div class="row">
						<div class="input-group col-xs-10 col-md-offset-1">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">销售时间:</span> <input
								type="text" class="form-control"
								placeholder="2015-03-03 10:12:00" value="<%=date%>"
								id="salesTime"> <span class="input-group-addon"
								style="background-color: #1abc9c;">存储仓库:</span> <select
								class="form-control" value="请选仓库" tabindex="1"
								name="addStorehouseName" id="addStorehouseName">
								<option value="">请选择仓库</option>
								<c:forEach var="storehouse" items="${storehouseList}"
									varStatus="status">
									<option value="${storehouse.storehouseId }">${storehouse.storehouseName }</option>
								</c:forEach>
							</select>
						</div>
						<div class="input-group col-xs-10 col-md-offset-1">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">客户名称:</span> <select
								class="form-control" value="请选择客户名称" tabindex="1"
								name="addCustomerName" id="addCustomerName">
								<option value="">请选择客户名称</option>
								<c:forEach var="customers" items="${customersList}"
									varStatus="status">
									<option value="${customers.customerId }">${customers.customerName }</option>
								</c:forEach>
							</select> <span class="input-group-addon"
								style="background-color: #1abc9c;">销售人员：</span> <select
								class="form-control" value="请选仓库" tabindex="1"
								name="addEmployeeName" id="addEmployeeName">
								<option value="">请选择销售人员</option>
								<c:forEach var="employees" items="${employeesList}"
									varStatus="status">
									<option value="${employees.employeeId }">${employees.employeeName }</option>
								</c:forEach>
							</select>
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
										<th>销售数量</th>
										<th>销售价格</th>
										<th>应付总金额</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>

						<div class="input-group col-xs-1">
							<button type="submit" class="btn btn-primary" id="suerAdd">确认新增</button>
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
    var len=$("#addGoodsTab tbody tr").length;
    function isPay(payStatus){
		if (payStatus=="<%=Constants.PayStatus.YESPAY%>") {
			$("#isPay").show();
		}else {
			$("#isPay").hide();
		}
	}
    
    function checkIsNull(str){
  	  if(str==null||str==""){
  		  return true;
  	  }
  	  return false;
    }
    
    function deleteSalesData(salesSerialNumber){
		$.ajax({  
            url:'<%=_base%>/salesController/deleteImportData.do',  
            type:"post",  
            async:false,
            modal : true,
            showBusi : false,
            data:{'salesSerialNumber':salesSerialNumber},
            success:function(data){  
            	if($.parseJSON(data).RES_RESULT=="SUCCESS"){
          		  alert("成功删除销售单");
          		  location.reload();
          	  	}else{
          		  alert("删除销售单失败");
          	  	}
			}
                    
        });       
	}
    
    function queryImportList() {
  		var selOpt = $("#saleTab tbody tr");  
		selOpt.remove();
		var customerId=$("#customerName").val();
		var storehouseId=$("#storehouseName").val();
		var payMed=$("#quyPayMed").val();
		var employeeId=$("#employeeName").val();
		var salesSerialNumber=$("#qurSalesSerialNumber").val();
		$.ajax(  
                {  
                    url:'<%=_base%>/salesController/queryImportList.do',  
                    type:"post",  
                    async:true,
                    data:{'customerId':customerId,
                    	'storehouseId':storehouseId,
                    	'payMed':payMed,
                    	'employeeId':employeeId,
                    	'salesSerialNumber':salesSerialNumber
                    	},
                    success:function(data){  
                    			var json = $.parseJSON(data);
								var salesList=$.parseJSON(json.RES_DATA.salesList);
								for (var i = 0; i < salesList.length; i++) {
    										$("#saleTab tbody").append( '<tr><td class="chk" style="display:none"><input type="checkbox" aria-label="..."></td>'
    					                  	+'<td>'+isNull(salesList[i].salesSerialNumber)+'</td>'
    					                  	+'<td>'+getLocalTime(salesList[i].salesDate)+'</td>'
    					                  	+'<td>'+isNull(salesList[i].employeeName)+'</td>'
    					                  	+'<td>'+isNull(salesList[i].customerName)+'</td>'
    					                  	+'<td>'+isNull(salesList[i].storehouseName)+'</td>'
    					                  	+'<td>'+isNull(salesList[i].salesTotalPrice)+'</td>'
    					                  	+'<td>'+isNull(salesList[i].incomeType)+'</td>'
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
    
    function selectGoods(){
		var selOpt = $("#goodsName option");  
		selOpt.remove();
		$("#goodsName").append( "<option value=''>请选择商品</option>" );		
		$.ajax({  
                    url:'<%=_base%>/salesController/queryGoods.do',  
                    type:"post",  
                    async:false,
                    modal : true,
                    showBusi : false,
                    data:{},
                    success:function(data){  
                    			var json = $.parseJSON(data);
								var goodsName=$.parseJSON(json.RES_DATA.goodsNameSet);
									for (var i = 0; i < goodsName.length; i++) {
    									$("#goodsName").append( "<option>"+goodsName[i]+"</option>" );
    								}
									$("#addgoods").show();
							        /* $("#addgoodsbtn").hide();
							        $("#salesgoodsform").hide(); */
								}
                            
                });       
	}
    
    function showTable(goodName){
    	if (!checkIsNull(goodName)) {
    		var url='<%=_base%>/salesController/queryGoodsDemo.do?goodName='+encodeURI(encodeURI(goodName));
    		$.dialog({
    			title:'可销售商品',
    			width:1200,
    			height:700,
    			max:false,
    			min:false,
    			content:'url:'+url
    		});
		}		
	}
    
    function updateSalesData(salesSerialNumber) {
    	var url='<%=_base%>/salesController/updateImprotGoodsList.do?salesSerialNumber='+salesSerialNumber;
		$.dialog({
			title:'修改销售单',
			width:900,
			height:700,
			max:false,
			min:false,
			content:'url:'+url
		});
	}
    
    function addSalesGoods(storageId,salesCount,salesPrice) {
    	$.ajax({  
            url:'<%=_base%>/salesController/getGoodTab.do',  
            type:"post",  
            async:false,
            modal : true,
            showBusi : false,
            data:{'storageId':storageId},
            success:function(data){  
            			var json = $.parseJSON(data);
						var storagechecks=$.parseJSON(json.RES_DATA.storagechecks);
						$("#addGoodsTab tbody").append("<tr id="+len+">"
								+"<td  style='display:none'>"+storageId+"</td>"
								+"<td>"+storagechecks.goodsName+"</td>"
								+"<td>"+storagechecks.importGoodsUnit+"</td>"
								+"<td>"+getLocalTime(storagechecks.goodsProductionDate)+"</td>"
								+"<td>"+salesCount+"</td>"
								+"<td>"+salesPrice+"</td>"
								+"<td>"+salesPrice*salesCount+"</td>"
								+"<td><a href=\'#\' onclick=\'deteleGoods("+len+")\' >删除商品</a></td>"
								+"</tr>");
				    	len++;
				    	$("#addgoods").hide();
				    	$("#addgoodstb").show();
						}
                    
        });       
    	
	}
    
    function continueAddSalesGoods(storageId,salesCount,salesPrice) {
    	$.ajax({  
            url:'<%=_base%>/salesController/getGoodTab.do',  
            type:"post",  
            async:false,
            modal : true,
            showBusi : false,
            data:{'storageId':storageId},
            success:function(data){  
            			var json = $.parseJSON(data);
						var storagechecks=$.parseJSON(json.RES_DATA.storagechecks);
						$("#addGoodsTab tbody").append("<tr id="+len+">"
								+"<td  style='display:none'>"+storageId+"</td>"
								+"<td>"+storagechecks.goodsName+"</td>"
								+"<td>"+storagechecks.importGoodsUnit+"</td>"
								+"<td>"+getLocalTime(storagechecks.goodsProductionDate)+"</td>"
								+"<td>"+salesCount+"</td>"
								+"<td>"+salesPrice+"</td>"
								+"<td>"+salesPrice*salesCount+"</td>"
								+"<td><a href=\'#\' onclick=\'deteleGoods("+len+")\' >删除商品</a></td>"
								+"</tr>");
				    	len++;
						}
                    
        });       
    	
	}
    
    function deteleGoods(len){
  		$("#addGoodsTab tbody tr[id='"+len+"']").remove();
  		var _len = $("#addGoodsTab tbody tr").length;
  		if(_len==0){
  			$("#addgoodstb").hide();
  			$("#salesgoodsform").show();
  			$("#addgoodsbtn").show();
  		}
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
      
      $("#suerAdd").click(function(){
    	  var storageIdList="";
    	  var salesCountList="";
    	  var salesPriceList="";
    	  var storeName=$("#addStorehouseName").find("option:selected").text();
    	  var storeId=$("#addStorehouseName").val();
    	  var customerName=$("#addCustomerName").find("option:selected").text();
    	  var customerId=$("#addCustomerName").val();
    	  var employeeName=$("#addEmployeeName").find("option:selected").text();
    	  var employeeId=$("#addEmployeeName").val();
    	  var salesListCreateTime=$("#salesTime").val();
    	  $('#addGoodsTab tbody tr').find('td').each(function() {
    		  if ($(this).index() == "0") {
    			  storageIdList=storageIdList+$(this).text()+",";
		      }
    		  if ($(this).index() == "4") {
    			  salesCountList=salesCountList+$(this).text()+",";
		      }
    		  if ($(this).index() == "5") {
    			  salesPriceList=salesPriceList+$(this).text()+",";
		      }
          });
    	  $.ajax(  
                  {  
                      url:'<%=_base%>/salesController/addImprotGoodsList.do',  
                      type:"post",  
                      async:false,
                      traditional:true,
                      data:{'storageIdList':storageIdList,
                    	    'salesCountList':salesCountList,
                    	    'salesPriceList':salesPriceList,
                    	    'storeName':storeName,
                    	    'customerName':customerName,
                    	    'customerId':customerId,
                    	    'salesListCreateTime':salesListCreateTime,
                    	    'storeId':storeId,
                    	    'employeeName':employeeName,
                    	    'employeeId':employeeId},
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
      
      $("#getBack").click(function(){
    	  var salIsHidden=$("#salesgoodsform").is(":hidden");
    	  var addbtnIsHidden=$("#addgoodstb").is(":hidden");
    	  var addGoodIsHidden=$("#addgoods").is(":hidden");
    	  if (!salIsHidden) {
    		  $("#salesgoods").hide();
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
      
      $("#addgoodsbtn").click(function(){
    	var customerName=$("#addCustomerName").val();
      	var storeName=$("#addStorehouseName").val();
      	var employeeName=$("#addEmployeeName").val();
      	var payStatus=$("#payStatus").val();
      	if (checkIsNull(customerName)) {
  			alert("请选择客户");
  			return;
  		}
      	if (checkIsNull(storeName)) {
  			alert("请选择仓库");
  			return;
  		}
      	if (checkIsNull(employeeName)) {
  			alert("请选择销售人员");
  			return;
  		}      	
          selectGoods();
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
      $("#addgoodsokbtn").click(function(){
      	var goodsId=$("#goodsName").val();
        var goodsName=$("#goodsName").find("option:selected").text();
        var goodsUnit=$("#goodsUnit").val();
        var goodsPrice=$("#price").val();
        var goodsProductionDate=$("#goodsProductionDate").val();
        var goodsExpirationDate=$("#goodsExpirationDate").val();
        var goodsCount=$("#goodsCount").val();
        var goodsAllPay=$("#goodsAllPay").val();
        if (checkIsNull(goodsName)) {
  			alert("请选择入库商品名称");
  			return;
  		}
          if (checkIsNull(goodsProductionDate)) {
  			alert("请选择入库商品生产日期");
  			return;
  		}
          if (checkIsNull(goodsCount)) {
  			alert("请选择入库商品数量");
  			return;
  		}
          $("#addGoodsTab tbody").append("<tr id="+len+">"
  					+"<td>"+goodsId+"</td>"
  					+"<td>"+goodsName+"</td>"
  					+"<td>"+goodsUnit+"</td>"
  					+"<td>"+goodsCount+"</td>"
  					+"<td>"+goodsPrice+"</td>"
  					+"<td>"+goodsProductionDate+"</td>"
  					+"<td>"+goodsExpirationDate+"</td>"
  					+"<td>"+goodsAllPay+"</td>"
  					+"<td><a href=\'#\' onclick=\'deteleGoods("+len+")\' >删除商品</a></td>"
  					+"</tr>");
          len++;
          $("#goodsName").val("");
          $("#goodsUnit").val("");
          $("#goodsPrice").val("");
          $("#price").val("");
          $("#goodsShelfLife").val("");
          $("#goodsExpirationDate").val("");
          $("#goodsCount").val("");
          $("#goodsAllPay").val("");
          $("#addgoods").hide();
          $("#addgoodstb").show();
        });

    });
    </script>
</body>
</html>