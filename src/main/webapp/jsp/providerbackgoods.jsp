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
          <h3 class="page-header">供货商货品退货</h3>

          <div class="row placeholders">
          <form class="form-inline">          	
            <div class="form-group">
              <label for="exampleInputName2">供应商名称：</label>
              <select class="form-control" value="请选择供货商" tabindex="1" name="providerlist" id="queProviderName">
              	<option value="">请选择供货商</option>
              	<c:forEach var="provider" items="${providerList}" varStatus="status">
                  <option value="${provider.providerId }">${provider.providerName }</option>
                </c:forEach>                  
              </select>
            </div>
            <div class="form-group">
              <label for="exampleInputEmail2">仓库名称：</label>
              <select class="form-control" value="请选择仓库" tabindex="1" name="storelist" id="queStoreName">
              	<option value="">请选择仓库</option>
              	  <c:forEach var="storehouse" items="${storehouseList}" varStatus="status">
                  	<option value="${storehouse.storehouseId }">${storehouse.storehouseName }</option>
                  </c:forEach>                  
              </select>
            </div>            
            <div class="form-group">
              <label for="exampleInputEmail2">入库退货流水号</label>
              <input type="text" class="form-control" id="queImportSerialNumber" placeholder="入库流水号">
            </div>
            <button type="button" class="btn btn-primary" onclick="queryImportList()">搜索</button>
          </form>
          </div>
          
          <div class="row placeholders ">
            <div class="col-sm-2">
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#importgoods">新增入库单</button>
            <!-- <button type="button" class="btn btn-primary" onclick="showAddDialog()">新增入库单</button> -->
           <!--  <button type="button" id="delbtn" class="btn btn-primary">批量删除入库单</button>
            <button type="button" id="delcommit" class="btn btn-primary" style="display:none">确认删除选中的入库单</button>
            <button type="button" id="delcancle" class="btn btn-primary" style="display:none">取消</button> -->
            </div>
          </div>
          <h4 class="sub-header">入库清单</h4>
          <div class="table-responsive">
            <table class="table table-striped" id="importGoodListTab">
              <thead>
                <tr>
                  <th class="chk" style="display:none"><input type="checkbox" aria-label="..."></th>
                  <th>入库流水号</th>
                  <th>供应商名称</th>
                  <th>仓库名称</th>
                  <th>入库日期</th>
                  <th>入库批次号</th>
                  <th>支付方式</th>
                  <th>入库状态</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach var="imports" items="${importList}" varStatus="status">
                  <tr>
                  	<td class="chk" style="display:none"><input type="checkbox" aria-label="..."></td>
                  	<td>${imports.importSerialNumber }</td>
                  	<td>${imports.providerName }</td>
                  	<td>${imports.storehouseName }</td>
                  	<td>
                  		<fmt:formatDate value="${imports.importDatetime }" pattern="yyyy-MM-dd"/>
                  	</td>
                  	<td>${imports.importBatchNumber }</td>
                  	<td>${imports.paymentType }</td>
                  	<td>${imports.importStatus }</td>
                  	<td><a href="#" data-toggle="modal" data-target="#importgoodsprint">打印</a>/<a href="#" onclick="updateImportData(${imports.importSerialNumber })" >修改</a>/<a href="#" onclick="deleteImportData(${imports.importSerialNumber })" >删除</a></td>
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
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="myModalLabel">新增入库单</h4>
          </div>
          <div class="modal-body" id="importgoodsform">
            <div class="row placeholders">
              <div class="input-group col-xs-10 col-md-offset-1">
                <span class="input-group-addon" style="background-color: #1abc9c;">入库时间:</span>
                <input type="text" class="form-control" placeholder="2015-03-03" value="<%=date %>" name="importcreatetime" id="importcreatetime">
                <span class="input-group-addon" style="background-color: #1abc9c;">供货商名称:</span>
                <select class="form-control" value="请选择供货商" tabindex="1" name="providerName" id="providerName">
              	<option value="">请选择供货商</option>
              	<c:forEach var="provider" items="${providerList}" varStatus="status">
                  <option value="${provider.providerId }">${provider.providerName }</option>
                </c:forEach>                    
              	</select>
              </div>    
              <div class="input-group col-xs-10 col-md-offset-1">
                <span class="input-group-addon" style="background-color: #1abc9c;">存储仓库:</span>
               <select class="form-control" value="请选择仓库" tabindex="1" name="storeName" id="storeName">
              	<option value="">请选择仓库</option>
              	  <c:forEach var="storehouse" items="${storehouseList}" varStatus="status">
                  	<option value="${storehouse.storehouseId }">${storehouse.storehouseName }</option>
                  </c:forEach>                  
              </select>
              <span class="input-group-addon" style="background-color: #1abc9c;">折扣方式：</span>
                <select class="form-control" value="请选择折扣方式" tabindex="1" name="discountMed" id="discountMed">
                  <option value="">请选择折扣方式</option>
                  <option value="20">无折扣</option>
                  <option value="21">奖金池</option>
                </select>
              </div>
              <div class="input-group col-xs-10 col-md-offset-1">                
                <span class="input-group-addon" style="background-color: #1abc9c;">支付状态：</span>
                <select class="form-control" value="请选择支付状态" tabindex="1" name="payStatus" id="payStatus" onchange="isPay(this.value)">
                  <option value="">请选择支付状态</option>
                  <option value="10">未付款</option>
                  <option value="11">已付款</option>
                </select>
              </div>
              <div class="input-group col-xs-10 col-md-offset-1" id="isPay" style="display: none">               
                <span class="input-group-addon" style="background-color: #1abc9c;">支付方式：</span>
                <select class="form-control" value="请选择支付方式" tabindex="1" name="payMed" id="payMed">
                  <option value="">请选择支付方式</option>
                  <option value="00">现金</option>
                  <option value="01">转账</option>
                  <option value="02">支票</option>
                  <option value="03">赊账</option>
                </select>
                <span class="input-group-addon" style="background-color: #1abc9c;">支付时间：</span>
                <input type="text" class="form-control" placeholder="2015-03-03" value="2015-03-03" name="payTime" id="payTime">
              </div>   
              <div class="input-group col-xs-1 col-md-offset-1">
                <button type="button" class="btn btn-primary" id="addgoodsbtn" >添加商品</button>
              </div>
            </div>
          </div>
          <div class="modal-body" id="addgoods" style="display:none">
            <div class="row placeholders">          
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">商品名称:</span>
                <select class="form-control" value="请选择商品" tabindex="1" name="goodsName" id="goodsName" onChange="showTable()">
                	
                </select>
              </div>  
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">基本单位:</span>
                <input type="text" id="goodsUnit" class="form-control" placeholder="基本单位" value="">
              </div>           
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">进货价格:</span>
                <input type="text" id="goodsPrice" class="form-control" placeholder="进货价格" value="">
                <span class="input-group-addon">元</span>
              </div>
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">销售价格:</span>
                <input type="text" id="price" class="form-control" placeholder="无折扣销售价格" value="">
                <span class="input-group-addon">元</span>
              </div>
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">保质期：</span>
                <input type="text" id="goodsShelfLife" class="form-control" placeholder="保质期" value="">
                <span class="input-group-addon">（天）</span>
              </div>
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">生产日期：</span>
                <input type="text" id="goodsProductionDate" class="form-control" placeholder="生产日期" value="2015-01-01" onblur="getGoodsExpirationDate(this.value)">
              </div>
              
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">失效日期：</span>
                <input type="text" id="goodsExpirationDate" class="form-control" placeholder="失效日期" value="" readonly="true">
              </div>
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">入库数量：</span>
                <input type="text" id="goodsCount" class="form-control" placeholder="入库数量" onblur="getGoodsAllPay(this.value)">
              </div>
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">应付总金额</span>
                <input type="text" id="goodsAllPay" class="form-control" placeholder="应付总金额" readonly="true">
                <span class="input-group-addon">元</span>
              </div> 
              <div class="input-group col-xs-10 col-md-offset-3">
               	<button type="button" class="btn btn-primary" id="addgoodsokbtn" >确认添加</button>
                <button type="button" class="btn btn-primary" id="continAddgoodsokbtn" >继续添加</button>
              </div>
            </div>
          </div>

          <div class="modal-body" id="addgoodstb" style="display:none">
            <div class="row">
              <div class="table-responsive col-xs-15">
                <table class="table table-striped" id="addGoodsTab">
                  <thead>
                    <tr>
                      <th>商品ID</th>
                      <th>商品名称</th>
                      <th>基本单位</th>
                      <th>入库数量</th>
                      <th>进货价格</th>
                      <th>生产日期</th>
                      <th>失效日期</th>
                      <th>应付总金额</th>
                      <th>操作</th>
                    </tr>
                  </thead>
                  <tbody>
                  </tbody>
                </table>
              </div>
              
              <div class="input-group col-xs-1">
               	<button type="submit" class="btn btn-primary" id="suerAdd" >确认新增</button>
              </div>
            </div>
          </div>


          <div class="modal-footer">
            <!-- <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button type="button" class="btn btn-primary" id="sureAdd">确认新增</button> -->
            <button type="button" class="btn btn-primary" id="getBack">返回</button>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

    
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<%=path %>/js/vendor/video.js"></script>
    <script src="<%=path %>/js/flat-ui.min.js"></script>
    <script type="text/javascript">
    	function isPay(payStatus){
    		if (payStatus=="<%=Constants.PayStatus.YESPAY %>") {
				$("#isPay").show();
			}else {
				$("#isPay").hide();
			}
    	}
    
    	function showTable(){
    		var goodsCode=$("#goodsName").val();
    		var goodsName=$("#goodsName").find("option:selected").text();
    		var providerName=$("#providerName").find("option:selected").text();
    		$.ajax(  
                    {  
                        url:'<%=path %>/accountController/queryGoodsDemo.do',  
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
			var storeId=$("#queStoreName").val();
			var payMed=$("#quePayMed").val();
			var importSerialNumber=$("#queImportSerialNumber").val();
			$.ajax(  
                    {  
                        url:'<%=path %>/accountController/queryImportList.do',  
                        type:"post",  
                        async:true,
                        data:{'providerId':providerId,
                        	'storeId':storeId,
                        	'payMed':payMed,
                        	'importSerialNumber':importSerialNumber
                        	},
                        success:function(data){  
                        			var json = $.parseJSON(data);
    								var goodsList=$.parseJSON(json.RES_DATA.goods);
    								for (var i = 0; i < goodsList.length; i++) {
	    										$("#importGoodListTab tbody").append( '<tr><td class="chk" style="display:none"><input type="checkbox" aria-label="..."></td>'
	    					                  	+'<td>'+isNull(goodsList[i].importSerialNumber)+'</td>'
	    					                  	+'<td>'+isNull(goodsList[i].providerName)+'</td>'
	    					                  	+'<td>'+isNull(goodsList[i].storehouseName)+'</td>'
	    					                  	+'<td>'+getLocalTime(goodsList[i].importDatetime)+'</td>'
	    					                  	+'<td>'+isNull(goodsList[i].importBatchNumber)+'</td>'
	    					                  	+'<td>'+isNull(goodsList[i].paymentType)+'</td>'
	    					                  	+'<td>'+isNull(goodsList[i].importStatus)+'</td>'
	    					                  	+'<td><a href="#" data-toggle="modal" data-target="#importgoodsprint">打印</a>/<a href="#" onclick="updateImportData('+isNull(goodsList[i].importSerialNumber)+')" >修改</a></td></tr>' );
	        								
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
                        url:'<%=path %>/accountController/queryGoods.do',  
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
    		var url='<%=path %>/accountController/updateImprotGoodsList.do?importSerialNumber='+importSerialNumber;
    		$.dialog({
    			title:'修改入库单',
    			width:900,
    			height:700,
    			max:false,
    			min:false,
    			content:'url:'+url
    		});
		}
    	
    	function deleteImportData(importSerialNumber){
    		$.ajax({  
                url:'<%=path %>/accountController/deleteImportData.do',  
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
    	var storeName=$("#storeName").val();
    	var discountMed=$("#discountMed").val();
    	var payStatus=$("#payStatus").val();
    	if (checkIsNull(providerName)) {
			alert("请选择供应商");
			return;
		}
    	if (checkIsNull(storeName)) {
			alert("请选择仓库");
			return;
		}
    	if (checkIsNull(discountMed)) {
			alert("请选择折扣方式");
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
        var goodsPrice=$("#goodsPrice").val();
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
    	  var providerName=$("#providerName").find("option:selected").text();
    	  var providerId=$("#providerName").val();
    	  var discountMed=$("#discountMed").val();
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
                      url:'<%=path %>/accountController/addImprotGoodsList.do',  
                      type:"post",  
                      async:false,
                      traditional:true,
                      data:{'goodList':goodList,
                    	    'storeName':storeName,
                    	    'providerName':providerName,
                    	    'discountMed':discountMed,
                    	    'payMed':payMed,
                    	    'importcreatetime':importcreatetime,
                    	    'storeId':storeId,
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
