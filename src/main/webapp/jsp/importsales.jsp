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

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h3 class="page-header">货品入库下单</h3>

				<div class="row placeholders">
					<form class="form-inline">
						<div class="form-group">
							<label for="exampleInputName2">供应商名称：</label> <select
								class="form-control" value="请选择供货商" tabindex="1"
								name="providerlist" id="queProviderName">
								<option value="">请选择供货商</option>
								<c:forEach var="provider" items="${providerList}"
									varStatus="status">
									<option value="${provider.providerId }">${provider.providerName }</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail2">支付方式：</label> <select
								class="form-control" value="请选择支付方式" tabindex="1"
								name="quePayMed" id="quePayMed">
								<option value="">请选择支付方式</option>
								<option value="00">现金</option>
								<option value="01">转账</option>
								<option value="02">支票</option>
								<option value="03">赊账</option>
							</select>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail2">库存状态：</label> <select
								class="form-control" value="请选择库存状态" tabindex="1"
								name="queImportStatus" id="queImportStatus">
								<option value="">请选择库存状态</option>
								<option value="<%=Constants.ImportStatus.GOODSARRIVAL %>"><%=Constants.ImportStatus.GOODSARRIVAL01 %></option>
								<option value="<%=Constants.ImportStatus.GOODSIMPORT %>"><%=Constants.ImportStatus.GOODSIMPORT01 %></option>
								<option value="<%=Constants.ImportStatus.GOODSLITARRIVAL %>"><%=Constants.ImportStatus.GOODSLITARRIVAL01 %></option>
								<option value="<%=Constants.ImportStatus.ORDERNOPAY %>"><%=Constants.ImportStatus.ORDERNOPAY01 %></option>
								<option value="<%=Constants.ImportStatus.ORDERYESPAY %>"><%=Constants.ImportStatus.ORDERYESPAY01 %></option>
							</select>
						</div>
						
						<div class="form-group">
							<label for="exampleInputEmail2">入库流水号</label> <input type="text"
								class="form-control" id="queImportSerialNumber"
								placeholder="入库流水号">
						</div>
						<button type="button" class="btn btn-primary"
							onclick="queryImportList()">搜索</button>
					</form>
				</div>

				<div class="row placeholders ">
					<div class="col-sm-2">
					<priv:privilege power="货品入库下单.增删改">
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#importgoods">新增入库单</button>
						<!-- <button type="button" class="btn btn-primary" onclick="showAddDialog()">新增入库单</button> -->
						<!--  <button type="button" id="delbtn" class="btn btn-primary">批量删除入库单</button>
            <button type="button" id="delcommit" class="btn btn-primary" style="display:none">确认删除选中的入库单</button>
            <button type="button" id="delcancle" class="btn btn-primary" style="display:none">取消</button> -->
            		</priv:privilege>
					</div>
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
									<priv:privilege power="货品入库下单.增删改">
									<td><a href="#" onclick="importgoodsprint(${imports.importSerialNumber })">打印</a>/<a href="#"
										onclick="updateImportData(${imports.importSerialNumber })">修改</a>/<a
										href="#"
										onclick="deleteImportData(${imports.importSerialNumber },${imports.importStatus })">删除</a></td>
									</priv:privilege>
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
					<h4 class="modal-title" id="myModalLabel">新增入库单</h4>
				</div>
				<div class="modal-body" id="importgoodsform">
					<div class="row placeholders">
						<div class="input-group col-xs-10 col-md-offset-1">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">采购下单时间:</span> <input
								type="text" class="form-control" placeholder="2015-03-03"
								value="<%=date %>" name="importcreatetime" id="importcreatetime">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">供货商名称:</span> <select
								class="form-control" value="请选择供货商" tabindex="1"
								name="providerName" id="providerName" onchange="queryPrizePool(this.value)">
								<option value="">请选择供货商</option>
								<c:forEach var="provider" items="${providerList}"
									varStatus="status">
									<option value="${provider.providerId }">${provider.providerName }</option>
								</c:forEach>
							</select>
						</div>
						<div class="input-group col-xs-10 col-md-offset-1">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">奖金池数量：</span><input
								type="text" class="form-control" placeholder="0"
								value="" name="prizePool" id="prizePool">
						</div>	
						<div class="input-group col-xs-10 col-md-offset-1">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">支付状态：</span> <select
								class="form-control" value="请选择支付状态" tabindex="1"
								name="payStatus" id="payStatus" onchange="isPay(this.value)">
								<option value="">请选择支付状态</option>
								<option value="10">未付款</option>
								<option value="11">已付款</option>
							</select>
						</div>						
						<div class="input-group col-xs-10 col-md-offset-1" id="isPay"
							style="display: none">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">支付方式：</span> <select
								class="form-control" value="请选择支付方式" tabindex="1" name="payMed"
								id="payMed">
								<option value="">请选择支付方式</option>
								<option value="00">现金</option>
								<option value="01">转账</option>
								<option value="02">支票</option>
								<option value="03">赊账</option>
							</select> <span class="input-group-addon"
								style="background-color: #1abc9c;">支付时间：</span> <input
								type="text" class="form-control" placeholder="2015-03-03"
								value="2015-03-03" name="payTime" id="payTime">
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
								id="goodsName" onChange="showTable()">

							</select>
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">商品编码:</span> <input
								type="text" id="goodsCode" class="form-control"
								placeholder="商品编码" value="">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">基本单位:</span> <input
								type="text" id="goodsUnit" class="form-control"
								placeholder="基本单位" value="">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">进货价格:</span> <input
								type="text" id="goodsPrice" class="form-control"
								placeholder="进货价格" value=""> <span
								class="input-group-addon">元</span>
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">保质期：</span> <input
								type="text" id="goodsShelfLife" class="form-control"
								placeholder="保质期" value=""> <span
								class="input-group-addon">（天）</span>
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">是否有箱皮:</span> <select
								class="form-control" value="请选择是否有箱瓶" tabindex="1"
								name="haveBox" id="haveBox" onchange="haveBox(this.value)">
								<option value="">请选择是否有箱皮</option>
								<option value="N">否</option>
								<option value="Y">是</option>
							</select>
						</div>
						<div class="input-group col-xs-6 col-md-offset-3" id="haveBoxPrices" style="display: none">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">箱皮价格:</span> <input
								type="text" id="haveBoxPrice" class="form-control"
								placeholder="箱皮价格" value="">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">是否折扣：</span> <select
								class="form-control" value="请选择折扣方式" tabindex="1"
								name="isDiscount" id="isDiscount" onchange="isDiscount(this.value)">
								<option value="">请选择折扣方式</option>
								<option value="N">否</option>
								<option value="Y">是</option>
							</select>
						</div>							
						<div class="input-group col-xs-6 col-md-offset-3" id="discountRates" style="display: none">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">折扣率:</span> <input
								type="text" id="discountRate" class="form-control"
								placeholder="折扣率" value=""><span
								class="input-group-addon">%</span>
						</div>						
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">入库数量：</span><input
								type="text" id="goodsCount" class="form-control"
								placeholder="入库数量"> 
						</div>
						<div class="input-group col-xs-10 col-md-offset-3">
							<button type="button" class="btn btn-primary" id="addgoodsokbtn">确认添加</button>
							<button type="button" class="btn btn-primary"
								id="continAddgoodsokbtn">继续添加</button>
						</div>
					</div>
				</div>

				<div class="modal-body" id="addgoodstb" style="display: none">
					<div class="row">
						<div class="table-responsive col-xs-15">
							<table class="table table-striped" id="addGoodsTab">
								<thead>
									<tr>
										<th>商品编码</th>
										<th>商品名称</th>
										<th>基本单位</th>
										<th>保质期</th>
										<th>入库数量</th>
										<th>进货价格</th>
										<th>是否打折</th>
										<th>折扣率</th>
										<th>是否有箱皮</th>
										<th>箱皮价格</th>
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
	<script src="<%=path %>/js/vendor/video.js"></script>
	<script src="<%=path %>/js/flat-ui.min.js"></script>
	<script type="text/javascript">
	
	function grantToZero(str){
		var count=parseFloat(str);
		if (count>=0) {
			return true;
		}else {
			return false;
		}
	}
	
    	function isPay(payStatus){
    		if (payStatus=="<%=Constants.PayStatus.YESPAY %>") {
				$("#isPay").show();
			}else {
				$("#isPay").hide();
			}
    	}
    	function isDiscount(discountMed){
    		if (discountMed=='<%=Constants.DiscountMed.YES %>') {
    			$("#discountRates").show();
			}else{
				$("#discountRates").hide();
			}    		
    	}
    	
    	
    	function queryPrizePool(providerId) {
    		var _len = $("#addGoodsTab tbody tr").length;
    		if(_len>0){
    			$("#addGoodsTab tbody tr").remove();
    			$("#addgoodstb").hide();
    		}
    		$.ajax({  
                url:'<%=path %>/importController/queryPrizePool.do',  
                type:"post",  
                async:false,
                modal : true,
                showBusi : false,
                data:{'providerId':providerId},
                success:function(data){  
                	var json = $.parseJSON(data);
					var prizePool=$.parseJSON(json.RES_DATA.prizePool);
					$("#prizePool").val(prizePool);
				}
                        
            });     
		}
    	
    	function importgoodsprint(importSerialNumber){
    		$.ajax({  
                url:'<%=path %>/importController/importgoodsprint.do',  
                type:"post",  
                async:false,
                modal : true,
                showBusi : false,
                data:{'importSerialNumber':importSerialNumber},
                success:function(data){  
                	
				}
                        
            });     
		}
    	
    	
    	function haveBox(haveBoxVal){
    		if (haveBoxVal=='<%=Constants.DiscountMed.YES %>') {
    			$("#haveBoxPrices").show();
			}else{
				$("#haveBoxPrices").hide();
			}    		
    	}
    	function showTable(){
    		var goodsName=$("#goodsName").find("option:selected").text();
    		var providerName=$("#providerName").find("option:selected").text();
    		$.ajax(  
                    {  
                        url:'<%=path %>/importController/queryGoodsDemo.do',  
                        type:"post",  
                        async:true,  
                        data:{'goodsName':goodsName,
                        	'providerName':providerName},
                        success:function(data)  
                                {   
                        			var jsonData=$.parseJSON(data);
                					var goods=$.parseJSON(jsonData.RES_DATA.goods);
                					$("#goodsUnit").val(goods.goodsUnit);
                					$("#goodsPrice").val(goods.goodsPrice);
                					$("#price").val(goods.goodsPrice);
                					$("#goodsShelfLife").val(goods.goodsShelfLife);
                					$("#goodsCode").val(goods.goodsCode);
                                }  
                    }  
                );           
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
    	
    	function queryImportList() {
      		var selOpt = $("#importGoodListTab tbody tr");  
    		selOpt.remove();
			var providerId=$("#queProviderName").val();
			var payMed=$("#quePayMed").val();
			var importSerialNumber=$("#queImportSerialNumber").val();
			var importStatus=$("#queImportStatus").val();
			$.ajax(  
                    {  
                        url:'<%=path %>/importController/queryImportList.do',  
                        type:"post",  
                        async:true,
                        data:{'providerId':providerId,
                        	'payMed':payMed,
                        	'importStatus':importStatus,
                        	'importSerialNumber':importSerialNumber
                        	},
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
	    					                  	+'<td><a href="#" data-toggle="modal" data-target="#importgoodsprint">打印</a>/<a href="#" onclick="updateImportData('+isNull(goodsList[i].importSerialNumber)+')" >修改</a>/<a href="#" onclick="deleteImportData('+isNull(goodsList[i].importSerialNumber)+','+isNull(goodsList[i].importStatus)+')">删除</a></td></tr>' );
	        								
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
    	
    	function selectGoods(){
    		var selOpt = $("#goodsName option");  
    		selOpt.remove();
    		$("#goodsName").append( "<option value=''>请选择商品</option>" );
    		var providerName=$("#providerName").find("option:selected").text();
    		$.ajax({  
                        url:'<%=path %>/importController/queryGoods.do',  
                        type:"post",  
                        async:false,
                        modal : true,
                        showBusi : false,
                        data:{'providerName':providerName},
                        success:function(data){  
                        			var json = $.parseJSON(data);
    								var goodsList=$.parseJSON(json.RES_DATA.list);
    									for (var i = 0; i < goodsList.length; i++) {
        									$("#goodsName").append( "<option value='"+goodsList[i].goodsId+"'>"+goodsList[i].goodsName+"</option>" );
        								}
    									$("#addgoods").show();
    							        $("#addgoodsbtn").hide();
    							        $("#importgoodsform").hide();
    								}
                                
                    });       
    	}
    	
    	function updateImportData(importSerialNumber) {
    		var url='<%=path %>/importController/updateImprotGoodsList.do?importSerialNumber='+importSerialNumber;
    		$.dialog({
    			title:'修改入库单',
    			width:900,
    			height:700,
    			max:false,
    			min:false,
    			content:'url:'+url
    		});
		}
    	
    	function deleteImportData(importSerialNumber,importStatus){
    		if (importStatus=='<%=Constants.ImportStatus.GOODSLITARRIVAL01 %>') {
				alert("商品部分到货，该订单不能删除。");
			}else {
				$.ajax({  
	                url:'<%=path %>/importController/deleteImportData.do',  
	                type:"post",  
	                async:false,
	                modal : true,
	                showBusi : false,
	                data:{'importSerialNumber':importSerialNumber},
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
      $("#addgoodsbtn").click(function(){
    	var providerName=$("#providerName").val();
    	var payStatus=$("#payStatus").val();
    	if (checkIsNull(providerName)) {
			alert("请选择供应商");
			return;
		}
    	if (checkIsNull(payStatus)) {
			alert("请选择支付状态");
			return;
		}
    	if (payStatus=="11") {
    		var payMed=$("#payMed").val();
    		var payTime=$("#payTime").val();
    		if (checkIsNull(payMed)) {
    			alert("请选择支付方式");
    			return;
    		}
    		if (checkIsNull(payTime)) {
    			alert("请选择支付时间");
    			return;
    		}else if(checkDataFomat(payTime)){
				return;
			};
		}
        selectGoods();
        
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
      
      $("#addgoodsokbtn").click(function(){
    	var goodsId=$("#goodsName").val();
        var goodsName=$("#goodsName").find("option:selected").text();
        var goodsUnit=$("#goodsUnit").val();
        var goodsPrice=$("#goodsPrice").val();
        var goodsCount=$("#goodsCount").val();
        var goodsCode=$("#goodsCode").val();
        var haveBox=$("#haveBox").val();
        var haveBoxName=$("#haveBox").find("option:selected").text();
        var isDiscount=$("#isDiscount").val();
        var isDiscountName=$("#isDiscount").find("option:selected").text();
        var discountRate=$("#discountRate").val();
        var haveBoxPrice=$("#haveBoxPrice").val();
        var goodsShelfLife=$("#goodsShelfLife").val();
        var prizePool=$("#prizePool").val();
        if (checkIsNull(goodsName)) {
			alert("请选择入库商品名称");
			return;
		}
        if (checkIsNull(haveBox)) {
			alert("请选择是否有箱瓶");
			return;
		}else if(haveBox=='<%=Constants.DiscountMed.YES %>'){
			if (!grantToZero(haveBoxPrice)) {
				$("#haveBoxPrice").val("");
				alert("箱皮价格小于0，请重新填写！");
				return;
			}
		} 
        if (checkIsNull(isDiscount)) {
			alert("请选择是否有折扣");
			return;
		}
        if (isDiscount=='<%=Constants.DiscountMed.YES %>') {
        	if (checkIsNull(discountRate)) {
    			alert("请填写折扣率");
    			return;
    		} else {
    			if (parseInt(discountRate)<0||parseInt(discountRate)>100) {
    				$("#discountRate").val("");
    				alert("折扣率应在0~100之间！");
    				return;
    			}else{
					var prize=parseInt((parseFloat(goodsCount)*parseFloat(goodsPrice)*parseFloat(discountRate)/117)*1000);
					prizePool=parseInt(prizePool)*1000;
					if (prize>prizePool) {
						$("#discountRate").val("");
						alert("奖金池金额不够，请从新选择折扣方式！");
						return;
					}
				}
    		}
		}else {
			discountRate='0';
			$("#discountRate").val("");
		}
        if (haveBox=='<%=Constants.DiscountMed.YES %>') {
        	if (checkIsNull(haveBoxPrice)) {
    			alert("请填写折扣率");
    			return;
    		}
		}else {
			haveBoxPrice='0';
			$("#haveBoxPrice").val("");
		}
        if (checkIsNull(goodsCount)) {
			alert("请选择入库商品数量");
			return;
		}else {
			if (!grantToZero(goodsCount)) {
				$("#goodsCount").val("");
				alert("入库商品数量不能小于0");
				return;
			}
		}
        $("#addGoodsTab tbody").append("<tr id="+len+">"
					+"<td style='display:none'>"+goodsId+"</td>"
					+"<td>"+goodsCode+"</td>"
					+"<td>"+goodsName+"</td>"
					+"<td>"+goodsUnit+"</td>"
					+"<td>"+goodsShelfLife+"</td>"
					+"<td>"+goodsCount+"</td>"
					+"<td>"+goodsPrice+"</td>"
					+"<td>"+isDiscountName+"</td>"
					+"<td>"+discountRate+"</td>"
					+"<td>"+haveBoxName+"</td>"
					+"<td>"+haveBoxPrice+"</td>"
					+"<td><a href=\'#\' onclick=\'deteleGoods("+len+")\' >删除商品</a></td>"
					+"</tr>");
        len++;
        $("#goodsName").val("");
        $("#goodsUnit").val("");
        $("#goodsPrice").val("");
        $("#price").val("");
        $("#goodsShelfLife").val("");
        $("#goodsCount").val("");
        $("#discountRate").val("");
        $("#haveBoxPrice").val("");
        $("#goodsCode").val("");
        $("#addgoods").hide();
        $("#addgoodstb").show();
        $("#addgoodsbtn").show();
        $("#importgoodsform").show();
      });
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
    	  var providerName=$("#providerName").find("option:selected").text();
    	  var providerId=$("#providerName").val();
    	  var importcreatetime=$("#importcreatetime").val();
    	  var payMed,payTime;
    	  var payStatus=$("#payStatus").val();    	  
    	  if (payStatus==<%=Constants.PayStatus.NOPAY %>) {
    		  payMed="";
    		  payTime="";
		  }else {
			  payMed=$("#payMed").val();
			  payTime=$("#payTime").val();
		  }
    	  
    	  $('#addGoodsTab tbody tr').find('td').each(function() {
    		  goodList=goodList+$(this).text() + ',';
          });
    	  $.ajax(  
                  {  
                      url:'<%=path %>/importController/addImprotGoodsList.do',  
                      type:"post",  
                      async:false,
                      traditional:true,
                      data:{'goodList':goodList,
                    	    'providerName':providerName,
                    	    'payMed':payMed,
                    	    'importcreatetime':importcreatetime,
                    	    'providerId':providerId,
                    	    'payStatus':payStatus,
                    	    'payTime':payTime},
                      success:function(data){
                    	  if($.parseJSON(data).RES_RESULT=="SUCCESS"){
                    		  alert("成功添加入库单");
                    		  location.reload();
                    	  }else{
                    		  alert("添加入库单失败");
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
      $("#continAddgoodsokbtn").click(function(){
    	  var goodsId=$("#goodsName").val();
          var goodsName=$("#goodsName").find("option:selected").text();
          var goodsUnit=$("#goodsUnit").val();
          var goodsPrice=$("#goodsPrice").val();
          var goodsCount=$("#goodsCount").val();
          var goodsCode=$("#goodsCode").val();
          var haveBox=$("#haveBox").val();
          var haveBoxName=$("#haveBox").find("option:selected").text();
          var isDiscount=$("#isDiscount").val();
          var isDiscountName=$("#isDiscount").find("option:selected").text();
          var discountRate=$("#discountRate").val();
          var haveBoxPrice=$("#haveBoxPrice").val();
          var goodsShelfLife=$("#goodsShelfLife").val();
          var prizePool=$("#prizePool").val();
          if (checkIsNull(goodsName)) {
  			alert("请选择入库商品名称");
  			return;
  		}
          if (checkIsNull(haveBox)) {
  			alert("请选择是否有箱瓶");
  			return;
  		}else if(haveBox=='<%=Constants.DiscountMed.YES %>'){
  			if (!grantToZero(haveBoxPrice)) {
  				$("#haveBoxPrice").val("");
  				alert("箱皮价格小于0，请重新填写！");
  				return;
  			}
  		} 
          if (checkIsNull(isDiscount)) {
  			alert("请选择是否有折扣");
  			return;
  		}
          if (isDiscount=='<%=Constants.DiscountMed.YES %>') {
          	if (checkIsNull(discountRate)) {
      			alert("请填写折扣率");
      			return;
      		} else {
      			if (parseInt(discountRate)<0||parseInt(discountRate)>100) {
      				$("#discountRate").val("");
      				alert("折扣率应在0~100之间！");
      				return;
      			}else{
					var prize=parseInt((parseFloat(goodsCount)*parseFloat(goodsPrice)*parseFloat(discountRate)/117)*1000);
					prizePool=parseInt(prizePool)*1000;
					if (prize>prizePool) {
						$("#discountRate").val("");
						alert("奖金池金额不够，请从新选择折扣方式！");
						return;
					}
				}
      		}
  		}else {
  			discountRate='0';
  			$("#discountRate").val("");
  		}
          if (haveBox=='<%=Constants.DiscountMed.YES %>') {
          	if (checkIsNull(haveBoxPrice)) {
      			alert("请填写折扣率");
      			return;
      		}
  		}else {
  			haveBoxPrice='0';
  			$("#haveBoxPrice").val("");
  		}
          if (checkIsNull(goodsCount)) {
  			alert("请选择入库商品数量");
  			return;
  		}else {
  			if (!grantToZero(goodsCount)) {
  				$("#goodsCount").val("");
  				alert("入库商品数量不能小于0");
  				return;
  			}
  		}
          $("#addGoodsTab tbody").append("<tr id="+len+">"
  					+"<td style='display:none'>"+goodsId+"</td>"
  					+"<td>"+goodsCode+"</td>"
  					+"<td>"+goodsName+"</td>"
  					+"<td>"+goodsUnit+"</td>"
  					+"<td>"+goodsShelfLife+"</td>"
  					+"<td>"+goodsCount+"</td>"
  					+"<td>"+goodsPrice+"</td>"
  					+"<td>"+isDiscountName+"</td>"
  					+"<td>"+discountRate+"</td>"
  					+"<td>"+haveBoxName+"</td>"
  					+"<td>"+haveBoxPrice+"</td>"
  					+"<td><a href=\'#\' onclick=\'deteleGoods("+len+")\' >删除商品</a></td>"
  					+"</tr>");
          len++;
          $("#goodsName").val("");
          $("#goodsUnit").val("");
          $("#goodsPrice").val("");
          $("#price").val("");
          $("#goodsShelfLife").val("");
          $("#goodsCount").val("");
          $("#discountRate").val("");
          $("#haveBoxPrice").val("");
          $("#goodsCode").val("");
        });
      
      
      
      
    });
    </script>
	<script type="text/javascript">
              		function getGoodsExpirationDate(goodsProductionDate){
              			if (checkDataFomat(goodsProductionDate)) {
							return;
						}
              			var goodsShelfLife=$("#goodsShelfLife").val();
              			var goodsExpirationDate=getthedate(goodsProductionDate, goodsShelfLife);
              			$("#goodsExpirationDate").val(goodsExpirationDate);
              		}
              		
              		
              		
              		function getthedate(dd,dadd)
              		 {
              		 //可以加上错误处理
              		 var a = new Date(dd);
              		 a = a.valueOf();
              		 a = a + dadd * 24 * 60 * 60 * 1000;
              		 a = new Date(a);
              		 var m = a.getMonth() + 1;
              		 if(m.toString().length == 1){
              		     m='0'+m;
              		 }
              		 var d = a.getDate();
              		 if(d.toString().length == 1){
              		     d='0'+d;
              		 }
              		 return a.getFullYear() + "-" + m + "-" + d;
              		 
              		}
              		function getGoodsAllPay(goodsCount){
              			var goodsPrice=$("#goodsPrice").val();
              			var goodsAllPay=goodsCount*goodsPrice;
              			$("#goodsAllPay").val(goodsAllPay);
              		}
              		
              		function checkDataFomat(data){
                  	  var a = /^(\d{4})-(\d{2})-(\d{2})$/;
                  	  if (!a.test(data)) { 
                  		  alert("日期格式不正确!正确格式为:yyyy-mm-dd"); 
                  		  return true;
                  	  };
                  	  return false;
                    }

      </script>
