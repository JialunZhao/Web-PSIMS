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
				<h3 class="page-header">货品入库</h3>

				<div class="row placeholders">
					<form class="form-inline">
						<div class="form-group">
							<label for="exampleInputEmail2">入库流水号</label> <input type="text"
								class="form-control" id="queImportSerialNumber"
								placeholder="入库流水号">
						</div>
						<button type="button" class="btn btn-primary"
							onclick="queryImportList()">搜索</button>
					</form>
				</div>

				<h4 class="sub-header">入库清单</h4>
				<div class="table-responsive">
					<table class="table table-striped" id="importGoodListTab">
						<thead>
							<tr>
								<th class="chk" style="display: none"><input
									type="checkbox" aria-label="..."></th>
								<th>入库流水号</th>
								<th>供应商名称</th>
								<th>入库下单日期</th>
								<th>入库批次号</th>
								<th>支付方式</th>
								<th>入库状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="imports" items="${importList}" varStatus="status">
								<tr>
									<td class="chk" style="display: none"><input
										type="checkbox" aria-label="..."></td>
									<td>${imports.importSerialNumber }</td>
									<td>${imports.providerName }</td>
									<td><fmt:formatDate value="${imports.importDatetime }"
											pattern="yyyy-MM-dd" /></td>
									<td>${imports.importBatchNumber }</td>
									<td>${imports.paymentType }</td>
									<td>${imports.importStatus }</td>
									<td><a href="#"
										onclick="goodsImport(${imports.importSerialNumber })">入库</a></td>
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
					<h4 class="modal-title" id="myModalLabel">商品入库</h4>
				</div>
				<div class="modal-body" id="importgoodsform">
					<div class="row placeholders">
						<div class="input-group col-xs-10 col-md-offset-1">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">入库流水号:</span> <input
								type="text" class="form-control" value=""
								name="importSerialNumber" id="importSerialNumber"> <span
								class="input-group-addon" style="background-color: #1abc9c;">存储仓库:</span>
							<select class="form-control" value="请选择仓库" tabindex="1"
								name="storeName" id="storeName">
								<option value="">请选择仓库</option>
								<c:forEach var="storehouse" items="${storehouseList}"
									varStatus="status">
									<option value="${storehouse.storehouseId }">${storehouse.storehouseName }</option>
								</c:forEach>
							</select>
						</div>
						<div class="input-group col-xs-10 col-md-offset-1">
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
										<th>入库数量</th>
										<th>生产日期</th>
										<th>失效日期</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>

						<div class="input-group col-xs-1">
							<button type="button" class="btn btn-primary" id="suerAdd">确认入库</button>
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
	checkTbLen();
		function checkIsNull(str){
	  	  if(str==null||str==""){
	  		  return true;
	  	  }
	  	  return false;
	    }
		
		function checkTbLen(){
			var _len = $("#addGoodsTab tbody tr").length;
      		if(_len==0){
      	        $("#addgoodstb").hide();
      		}
		}
	
	
		function goodsImport(importSerialNumber){
			var selOpt = $("#goodsName option");  
    		selOpt.remove();
    		$("#goodsName").append( "<option value=''>请选择商品</option>" );
    		$("#importSerialNumber").val(importSerialNumber);
			$.ajax(  
                    {  
                        url:'<%=_base%>/importController/goodsImport.do',  
                        type:"post",  
                        async:true,  
                        data:{'importSerialNumber':importSerialNumber},
                        success:function(data)  
                                {   
                        		var json = $.parseJSON(data);
								var goodsName=$.parseJSON(json.RES_DATA.goodsName);
								for (var i = 0; i < goodsName.length; i++) {
									$("#goodsName").append( "<option value='"+goodsName[i]+"'>"+goodsName[i]+"</option>" );
								}
								$("#importgoods").modal("show");
							}
                                
                    }  
                );      
		}
		
		
		function queryImportList() {
      		var selOpt = $("#importGoodListTab tbody tr");  
    		selOpt.remove();
			var importSerialNumber=$("#queImportSerialNumber").val();
			$.ajax(  
                    {  
                        url:'<%=_base %>/importController/queryImport.do',  
                        type:"post",  
                        async:true,
                        data:{'importSerialNumber':importSerialNumber},
                        success:function(data){  
                        			var json = $.parseJSON(data);
    								var goodsList=$.parseJSON(json.RES_DATA.goods);
    								for (var i = 0; i < goodsList.length; i++) {
	    										$("#importGoodListTab tbody").append( '<tr><td class="chk" style="display:none"><input type="checkbox" aria-label="..."></td>'
	    					                  	+'<td>'+isNull(goodsList[i].importSerialNumber)+'</td>'
	    					                  	+'<td>'+isNull(goodsList[i].providerName)+'</td>'
	    					                  	+'<td>'+getLocalTime(goodsList[i].importDatetime)+'</td>'
	    					                  	+'<td>'+isNull(goodsList[i].importBatchNumber)+'</td>'
	    					                  	+'<td>'+isNull(goodsList[i].paymentType)+'</td>'
	    					                  	+'<td>'+isNull(goodsList[i].importStatus)+'</td>'
	    					                  	+'<td><a href="#" onclick="goodsImport('+isNull(goodsList[i].importSerialNumber)+')">入库</a></td>' );
	        								
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
		
		function getLocalTime(nS) {
    		if(nS==null){
				return "";
			}
    		var t=new Date(nS);
    		y = t.getFullYear();
    		m = t.getMonth()+1;
    		d = t.getDate();
    		return y+"-"+m+"-"+d;
    	} 
	
		function showTable(goodsName){
			var importSerialNumber=$("#importSerialNumber").val();
			if (!checkIsNull(goodsName)) {
			var url='<%=_base%>/importController/showImportGoods.do?importSerialNumber='+importSerialNumber+'&goodsName='+encodeURI(encodeURI(goodsName));
    		$.dialog({
    			title:'修改入库单',
    			width:900,
    			height:700,
    			max:false,
    			min:false,
    			content:'url:'+url
    		});
			}
		}
		
		function addImportGoodsTab(goodsName,importCount,goodsProductionDate,goodsExpirationDate){
			$("#addGoodsTab tbody").append("<tr id="+len+">"
					+"<td>"+goodsName+"</td>"
					+"<td>"+importCount+"</td>"
					+"<td>"+goodsProductionDate+"</td>"
					+"<td>"+goodsExpirationDate+"</td>"
					+"<td><a href=\'#\' onclick=\'deteleGoods("+len+")\' >删除商品</a></td>"
					+"</tr>");
        len++;
        $("#addgoodstb").show();
		}
		
		function deteleGoods(len){
      		$("#addGoodsTab tbody tr[id='"+len+"']").remove();
      		var _len = $("#addGoodsTab tbody tr").length;
      		if(_len==0){
      			$("#addgoodstb").hide();
      		}
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
      
      
      function checkIsNull(str){
    	  if(str===null||str===""){
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
      
      $("#modifyaddgoodsbtn").click(function(){
        $("#modifyaddgoods").show();
        $("#modifyaddgoodsbtn").hide();
        $("#importgoodsmodifyform").hide();
      }); 
      $("#modifyaddgoodsokbtn").click(function(){
        $("#modifyaddgoods").hide();
        $("#modifyaddgoodsbtn").show();
        $("#modifyaddgoodstb").show();
        $("#importgoodsmodifyform").show();
      });
      $("#delgoodstb").click(function(){
        $("#modifyaddgoodstb").hide();
      });
      
      $("#suerAdd").click(function(){
    	  var goodList="";
    	  var storeName=$("#storeName").find("option:selected").text();
    	  var storeId=$("#storeName").val();
    	  var importSerialNumber=$("#importSerialNumber").val();
    	  if (checkIsNull(storeId)) {
			alert("请选择入库的仓库");
			return;
		  }
    	  $('#addGoodsTab tbody tr').find('td').each(function() {
    		  goodList=goodList+$(this).text() + ',';
          });
    	  $.ajax(  
                  {  
                      url:'<%=_base%>/importController/addImprotList.do',  
                      type:"post",  
                      async:false,
                      traditional:true,
                      data:{'goodList':goodList,
                    	    'storeName':storeName,
                    	    'storeId':storeId,
                    	    'importSerialNumber':importSerialNumber},
                      success:function(data){
                    	  if($.parseJSON(data).RES_RESULT=="SUCCESS"){
                    		  alert("货品成功入库");
                    		  location.reload();
                    	  }else{
                    		  alert("货品入库失败");
                    	  }
                    	  var selOpt = $("#addGoodsTab tbody tr");  
                  		  selOpt.remove();
                    	  $("#importgoods").hide();
                  	  }  
                  });      
      });
      
      $("#getBack").click(function(){
    	  var impIsHidden=$("#importgoodsform").is(":hidden");
    	  var addbtnIsHidden=$("#addgoodstb").is(":hidden");
    	  var addGoodIsHidden=$("#addgoods").is(":hidden");
    	  if (!impIsHidden) {
    		  $("#importgoods").hide();
		  }
    	  if(!addbtnIsHidden){
    		  $("#addgoods").show();
    	      $("#addgoodstb").hide();
    	  }
		  if(!addGoodIsHidden){
			  $("#addgoods").hide();
		      $("#addgoodsbtn").show();
		      $("#importgoodsform").show();
    	  }
        }); 
     
    });
    </script>	
</body>
</html>