<%@page import="com.ai.psims.web.util.Constants"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	String date = sdf.format(new Date());
%>
<%@ include file="all.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h3 class="page-header">货品入库下单报表</h3>

	<div class="row placeholders">
		<form class="form-inline" action="importOrderReport" method="get">
			<div class="form-group">
				<label for="exampleInputName2">供应商名称：</label> <select
					class="form-control" tabindex="1" name="queProviderId"
					id="queProviderName">
					<option value="">请选择供货商</option>
					<c:forEach var="provider" items="${providerList}"
						varStatus="status">
						<option value="${provider.providerId}">${provider.providerName}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail2">支付方式：</label> <select
					class="form-control" tabindex="1" name="quePayMed" id="quePayMed">
					<option value="">请选择支付方式</option>
					<option value="00">现金</option>
					<option value="01">转账</option>
					<option value="02">支票</option>
					<option value="03">赊账</option>
				</select>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail2">库存状态：</label> <select
					class="form-control" tabindex="1" name="queImportStatus"
					id="queImportStatus">
					<option value="">请选择库存状态</option>
					<option value="<%=Constants.ImportStatus.GOODSARRIVAL%>"><%=Constants.ImportStatus.GOODSARRIVAL01%></option>
					<option value="<%=Constants.ImportStatus.GOODSIMPORT%>"><%=Constants.ImportStatus.GOODSIMPORT01%></option>
					<option value="<%=Constants.ImportStatus.GOODSLITARRIVAL%>"><%=Constants.ImportStatus.GOODSLITARRIVAL01%></option>
					<option value="<%=Constants.ImportStatus.ORDERNOPAY%>"><%=Constants.ImportStatus.ORDERNOPAY01%></option>
					<option value="<%=Constants.ImportStatus.ORDERYESPAY%>"><%=Constants.ImportStatus.ORDERYESPAY01%></option>
				</select>
			</div>

			<div class="form-group">
				<label for="exampleInputEmail2">入库流水号</label> <input type="text"
					class="form-control" id="queImportSerialNumber" name="queImportSerialNumber"  placeholder="入库流水号">
			</div>
			<button type="submit" class="btn btn-primary">搜索</button>
		</form>
	</div>

	<div class="row placeholders ">
		<div class="col-sm-2">
			<priv:privilege power="货品入库下单.增删改">
				<button type="button" id="excel" class="btn btn-primary"  >导出为Excel</button>

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
					<th class="chk" style="display: none"><input type="checkbox"
						aria-label="..."></th>
					<th>入库流水号</th>
					<th>供应商名称</th>
					<th>入库下单日期</th>
					<th>入库批次号</th>
					<th>备注</th>
					<th>入库状态</th>
				</tr>
			</thead>
			<tbody id="accordion">
				<c:forEach var="imports" items="${importList}" varStatus="status">
					<tr>
						<td class="chk" style="display: none"><input type="checkbox"
							aria-label="..."></td>
						<td><font color="#16a085">${imports.importSerialNumber}</font></td>
						<td><font size="4" color="#16a085">${imports.providerName}</font></td>
						<td><font size="4" color="#16a085"><fmt:formatDate value="${imports.importDatetime}"
								pattern="yyyy-MM-dd" /></font></td>
						<td><font size="4" color="#16a085">${imports.importBatchNumber}</font></td>
						<td><font size="4" color="#16a085">${imports.importRemark}</font></td>
						<td><font size="4" color="#16a085">${imports.importStatus}</font></td>
					</tr>
					<tr>
						<td>商品名称</td>
						<td>商品单价</td>
						<td>商品数量</td>
						<td>总价</td>
						<td>奖金池支付总额</td>
						<td>现金支付总额</td>
					</tr>
					<c:forEach var="tbImportGoodsList" items="${tbImportGoodsList}"
						varStatus="status">
						<c:if
							test="${tbImportGoodsList.importSerialNumber==imports.importSerialNumber}">
							<tr id="#collapse${tbImportGoodsList.importSerialNumber}">
								<td>${tbImportGoodsList.goodsName}</td>
								<td>${tbImportGoodsList.importGoodsPrice}</td>
								<td>${tbImportGoodsList.importGoodsAmount}</td>
								<td>${tbImportGoodsList.importGoodsTotalPrice}</td>
								<td>${tbImportGoodsList.discountDutyTotalPrice}</td>
								<td>${tbImportGoodsList.discountGoodsTotalPrice}</td>
							</tr>
						</c:if>
					</c:forEach>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>



<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<%=path%>/js/vendor/video.js"></script>
<script src="<%=path%>/js/flat-ui.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#excel").click(function() {
		window.location.href = "importOrderReportExecl?queProviderId=${queProviderId}&quePayMed=${quePayMed}&queImportStatus=${queImportStatus}&queImportSerialNumber=${queImportSerialNumber}";
	});
});
	function showImportGoods(importSerialNumber){
		$.ajax({  
            url:'<%=path%>/importController/queryPrizePool.do',  
            type:"post",
            async:false,
            modal : true,
            showBusi : false,
            data:{'importSerialNumber':importSerialNumber},
            success:function(data){
            	var json = $.parseJSON(data);
				var prizePool=$.parseJSON(json.RES_DATA.prizePool);
				$("#prizePool").val(prizePool);
				$("#prizePool").attr('readonly');
			}
        }); 
	}

	function showPrizePoolUsed(){
		//奖金池使用量=进货价格*数量*折扣率/1.17
		var goodsPrice = $("#goodsPrice").val();
		var goodsCount = $("#goodsCount").val();
		var discountRate = $("#discountRate").val();
		var prizePool = $("#prizePool").val();
		
		var prizePoolUsed = goodsPrice*goodsCount*discountRate/117;
		var totalPrice = goodsPrice*goodsCount;
		var discountDutyTotalPrice = goodsPrice*goodsCount-(prizePool*1.17);
		var discountDutyTotalPrice2 = goodsPrice*goodsCount*(100-discountRate)/100;
		
		if (prizePool<=prizePoolUsed) {
			$("#prizePoolUsed").val(prizePool);
			$("#totalPrice").val(totalPrice);
			$("#discountDutyTotalPrice").val(discountDutyTotalPrice);
		}else{
			$("#prizePoolUsed").val(prizePoolUsed);
			$("#totalPrice").val(totalPrice);
			$("#discountDutyTotalPrice").val(discountDutyTotalPrice2);
		}
	}
	
	
	function grantToZero(str){
		var count=parseFloat(str);
		if (count>=0) {
			return true;
		}else {
			return false;
		}
	}
	
    	function isPay(payStatus){
    		if (payStatus=="<%=Constants.PayStatus.YESPAY%>") {
				$("#isPay").show();
			}else {
				$("#isPay").hide();
			}
    	}
    	function isDiscount(discountMed){
    		if (discountMed=='<%=Constants.DiscountMed.YES%>') {
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
    		if (providerId == 0) {
				$("#prizePool").val("0");
    		}else {
    		$.ajax({  
                url:'<%=path%>/importController/queryPrizePool.do',  
                type:"post",
                async:false,
                modal : true,
                showBusi : false,
                data:{'providerId':providerId},
                success:function(data){
                	var json = $.parseJSON(data);
					var prizePool=$.parseJSON(json.RES_DATA.prizePool);
					$("#prizePool").val(prizePool);
					$("#prizePool").attr('readonly');
				}
            }); 
			}
		}
    	
    	function importgoodsprint(importSerialNumber){
    		$.ajax({  
                url:'<%=path%>/importController/importgoodsprint.do',  
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
    		if (haveBoxVal=='<%=Constants.DiscountMed.YES%>') {
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
                        url:'<%=path%>/importController/queryGoodsDemo.do',  
                        type:"post",  
                        async:true,  
                        data:{'goodsName':goodsName,
                        	'providerName':providerName},
                        success:function(data)  
                                {   
                        			var jsonData=$.parseJSON(data);
                					var goods=$.parseJSON(jsonData.RES_DATA.goods);
                					$("#goodsCode").val(goods.goodsCode);
                					$("#goodsUnit").val(goods.goodsUnit);
                					$("#goodsPrice").val(goods.goodsActualCost);
                					$("#discountRate").val(goods.goodsPrizePoolRatio);
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
			var payMed=$("#quePayMed").val();
			var importSerialNumber=$("#queImportSerialNumber").val();
			var importStatus=$("#queImportStatus").val();
			$.ajax(  
                    {  
                        url:'<%=path%>/importController/queryImportList.do',  
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
	    					                  	+'<td><a href="#" data-toggle="modal" data-target="#importgoodsprint">打印</a>/<a href="#" onclick="updateImportData('+isNull(goodsList[i].importSerialNumber)+')" >修改</a>/<a href="#" onclick="deleteImportData('+isNull(goodsList[i].importSerialNumber)+',\''+isNull(goodsList[i].importStatus)+'\')">删除</a></td></tr>' );
	        								
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
    		var providerId=$("#providerName").val();
    		$.ajax({  
                        url:'<%=path%>/importController/queryGoods.do',  
                        type:"post",  
                        async:false,
                        modal : true,
                        showBusi : false,
                        data:{'providerId':providerId},
                        success:function(data){    
//                         			console.dir(data);
                        			var json = $.parseJSON(data);
									if (json.RES_RESULT=="FAILED") {
										alert("此供应商下无商品");
										return
									}
    								var goodsList=$.parseJSON(json.RES_DATA.list);
    									for (var i = 0; i < goodsList.length; i++) {
        									$("#goodsName").append( "<option value='"+goodsList[i].goodsId+"'>"+goodsList[i].goodsName+"</option>" );
        								}
    									$("#addgoods").show();
    							        $("#addgoodsbtn").hide();
    							        $("#importgoodsform").show();
    								}
                                
                    });       
    	}
    	
    	function updateImportData(importSerialNumber) {
    		var url='<%=path%>/importController/updateImprotGoodsList.do?importSerialNumber='+importSerialNumber;
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
    		alert(importSerialNumber+importStatus);
    		if (importStatus=='<%=Constants.ImportStatus.GOODSLITARRIVAL01%>') {
				alert("商品部分到货，该订单不能删除。");
			}else {
				$.ajax({  
	                url:'<%=path%>/importController/deleteImportData.do',  
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
    	  $("#providerName").attr("readonly");
    	var providerName=$("#providerName").val();
    	var payStatus=$("#payStatus").val();
    	if (checkIsNull(providerName) || providerName =="0" ) {
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
        var discountRate=$("#discountRate").val();
        var totalPrice=$("#totalPrice").val();
        var discountDutyTotalPrice=$("#discountDutyTotalPrice").val();
        var prizePoolUsed=$("#prizePoolUsed").val();
        if (checkIsNull(goodsName)) {
			alert("请选择入库商品名称");
			return;
		}
        if (checkIsNull(goodsCount)) {
			alert("请输入进货商品数量");
			return;
		}else {
			if (!grantToZero(goodsCount)) {
				$("#goodsCount").val("");
				alert("进货商品数量不能小于0");
				return;
			}
		} 
        $("#addGoodsTab tbody").append("<tr id="+len+">"
					+"<td style='display:none' ><input type='hidden'  name='goodsId' value='"+goodsId+"'>"+goodsId+"</td>"
					+"<td><input type='hidden' name='goodsCode' value='"+goodsCode+"'>"+goodsCode+"</td>"
					+"<td><input type='hidden' name='goodsName' value='"+goodsName+"'>"+goodsName+"</td>"
					+"<td><input type='hidden' name='goodsUnit' value='"+goodsUnit+"'>"+goodsUnit+"</td>"
					+"<td><input type='hidden' name='goodsShelfLife' value='"+goodsShelfLife+"'>"+goodsShelfLife+"</td>"
					+"<td><input type='hidden' name='goodsCount' value='"+goodsCount+"'>"+goodsCount+"</td>"
					+"<td><input type='hidden' name='goodsPrice' value='"+goodsPrice+"'>"+goodsPrice+"</td>"
					+"<td><input type='hidden' name='discountRate' value='"+discountRate+"'>"+discountRate+"</td>"
					+"<td><input type='hidden' name='totalPrice' value='"+totalPrice+"'>"+totalPrice+"</td>"
					+"<td><input type='hidden' name='discountDutyTotalPrice' value='"+discountDutyTotalPrice+"'>"+discountDutyTotalPrice+"</td>"
					+"<td><input type='hidden' name='prizePoolUsed' value='"+prizePoolUsed+"'>"+prizePoolUsed+"</td>"
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
        $("#prizePoolUsed").val("");
        $("#discountDutyTotalPrice").val("");
        $("#totalPrice").val("");
        $("#addgoods").hide();
        $("#addgoodstb").show();
        $("#addgoodsbtn").show();
        $("#importgoodsform").show();
        $("#suerAdd").show();
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
    	  if (payStatus==<%=Constants.PayStatus.NOPAY%>) {
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
                      url:'<%=path%>/importController/addImprotGoodsList.do',  
                      type:"post",  
                      async:false,
                      traditional:true,
			data : $('#addGoodsTabForm').serialize(),

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
                          $("#suerAdd").hide();
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
          var discountRate=$("#discountRate").val();
          var totalPrice=$("#totalPrice").val();
          var discountDutyTotalPrice=$("#discountDutyTotalPrice").val();
          var prizePoolUsed=$("#prizePoolUsed").val();
          if (checkIsNull(goodsName)) {
  			alert("请选择进货商品名称");
  			return;
  		}
          if (checkIsNull(haveBox)) {
  			alert("请选择是否有箱瓶");
  			return;
  		}else if(haveBox=='<%=Constants.DiscountMed.YES%>'){
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
          if (isDiscount=='<%=Constants.DiscountMed.YES%>') {
          	if (checkIsNull(discountRate)) {
      			alert("请填写折扣率");
      			return;
      		} else {
      			if (parseInt(discountRate)<0||parseInt(discountRate)>100) {
      				$("#discountRate").val("");
      				alert("折扣率应在0~100之间！");
      				return;
      			}else{
// 					var prize=parseInt((parseFloat(goodsCount)*parseFloat(goodsPrice)*parseFloat(discountRate)/117)*1000);
// 					prizePool=parseInt(prizePool)*1000;
					var prize=parseInt((parseFloat(goodsCount)*parseFloat(goodsPrice)*parseFloat(discountRate)/117));
					prizePool=parseInt(prizePool);
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
          if (haveBox=='<%=Constants.DiscountMed.YES%>') {
          	if (checkIsNull(haveBoxPrice)) {
      			alert("请填写折扣率");
      			return;
      		}
  		}else {
  			haveBoxPrice='0';
  			$("#haveBoxPrice").val("");
  		}
          if (checkIsNull(goodsCount)) {
  			alert("请选择进货商品数量");
  			return;
  		}else {
  			if (!grantToZero(goodsCount)) {
  				$("#goodsCount").val("");
  				alert("进货商品数量不能小于0");
  				return;
  			}
  		}
          $("#addGoodsTab tbody").append("<tr id="+len+">"
					+"<td style='display:none' ><input type='hidden'  name='goodsId' value='"+goodsId+"'>"+goodsId+"</td>"
					+"<td><input type='hidden' name='goodsCode' value='"+goodsCode+"'>"+goodsCode+"</td>"
					+"<td><input type='hidden' name='goodsName' value='"+goodsName+"'>"+goodsName+"</td>"
					+"<td><input type='hidden' name='goodsUnit' value='"+goodsUnit+"'>"+goodsUnit+"</td>"
					+"<td><input type='hidden' name='goodsShelfLife' value='"+goodsShelfLife+"'>"+goodsShelfLife+"</td>"
					+"<td><input type='hidden' name='goodsCount' value='"+goodsCount+"'>"+goodsCount+"</td>"
					+"<td><input type='hidden' name='goodsPrice' value='"+goodsPrice+"'>"+goodsPrice+"</td>"
					+"<td><input type='hidden' name='discountRate' value='"+discountRate+"'>"+discountRate+"</td>"
					+"<td><input type='hidden' name='totalPrice' value='"+totalPrice+"'>"+totalPrice+"</td>"
					+"<td><input type='hidden' name='discountDutyTotalPrice' value='"+discountDutyTotalPrice+"'>"+discountDutyTotalPrice+"</td>"
					+"<td><input type='hidden' name='prizePoolUsed' value='"+prizePoolUsed+"'>"+prizePoolUsed+"</td>"
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
          $("#prizePoolUsed").val("");
          $("#discountDutyTotalPrice").val("");
          $("#totalPrice").val("");
          $("#importgoodsform").show();
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
