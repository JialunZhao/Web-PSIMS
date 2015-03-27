<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String _base=path;
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
String date=sdf.format(new Date());

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

    <!-- Loading Bootstrap -->
       
    <link href="<%=_base %>/css/bootstrap/bootstrap.min.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="<%=_base %>/css/flatUI/flat-ui.min.css" rel="stylesheet">
    <link href="<%=_base %>/css/dashboard.css" rel="stylesheet">
    <link href="<%=_base %>/css/index.css" rel="stylesheet">

	
    <link rel="shortcut icon" href="img/favicon.ico">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
      <script src="./js/vendor/html5shiv.js"></script>
      <script src="./js/vendor/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
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
              	<option>请选择供货商</option>
              	<c:forEach var="providerName" items="${providerList}" varStatus="status">
                  <option>${providerName }</option>
                </c:forEach>                  
              	</select>
              </div>    
              <div class="input-group col-xs-10 col-md-offset-1">
                <span class="input-group-addon" style="background-color: #1abc9c;">存储仓库:</span>
               <select class="form-control" value="请选择仓库" tabindex="1" name="storeName" id="storeName">
              	<option>请选择仓库</option>
              	  <c:forEach var="storehouseName" items="${storehouseList}" varStatus="status">
                  	<option>${storehouseName }</option>
                  </c:forEach>                  
              </select>
              <span class="input-group-addon" style="background-color: #1abc9c;">折扣方式：</span>
                <select class="form-control" value="请选择折扣方式" tabindex="1" name="discountMed" id="discountMed">
                  <option>请选择折扣方式</option>
                  <option>无折扣</option>
                  <option>奖金池</option>
                </select>
              </div>
              <div class="input-group col-xs-10 col-md-offset-1">
                <span class="input-group-addon" style="background-color: #1abc9c;">支付方式：</span>
                <select class="form-control" value="请选择支付方式" tabindex="1" name="payMed" id="payMed">
                  <option>请选择支付方式</option>
                  <option>现金</option>
                  <option>转账</option>
                  <option>支票</option>
                  <option>赊账</option>
                </select>
                <span class="input-group-addon" style="background-color: #1abc9c;">支付状态：</span>
                <select class="form-control" value="请选择支付状态" tabindex="1" name="payStatus" id="payStatus">
                  <option value="0">请选择支付状态</option>
                  <option value="1">未付款</option>
                  <option value="2">已付款</option>
                </select>
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
              <div class="table-responsive col-xs-12">
                <table class="table table-striped" id="addGoodsTab">
                  <thead>
                    <tr>
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
               	<button type="button" class="btn btn-primary" id="suerAdd" >确认新增</button>
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

    
    <!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
    <script src="<%=_base %>/js/vendor/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<%=_base %>/js/vendor/video.js"></script>
    <script src="<%=_base %>/js/flat-ui.min.js"></script>
    <script src="<%=_base %>/js/lhgdialog.min.js"></script>
    <script type="text/javascript">
    	function showTable(){
    		var goodsName=$("#goodsName").val();
    		var providerName=$("#providerName").val();
    		$.ajax(  
                    {  
                        url:'<%=_base %>/accountController/queryGoodsDemo.do',  
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
    	
    	function selectGoods(){
    		var selOpt = $("#goodsName option");  
    		selOpt.remove();
    		$("#goodsName").append( "<option>请选择商品</option>" );
    		var providerName=$("#providerName").val();
    		$.ajax(  
                    {  
                        url:'<%=_base %>/accountController/queryGoods.do',  
                        type:"post",  
                        async:false,
                        modal : true,
                        showBusi : false,
                        data:{'providerName':providerName},
                        success:function(data)  
                                {  
                        			var json = $.parseJSON(data);
    								var goodsList=$.parseJSON(json.RES_DATA.list);
    									for (var i = 0; i < goodsList.length; i++) {
        									$("#goodsName").append( "<option>"+goodsList[i].goodsName+"</option>" );
        								}
    									$("#addgoods").show();
    							        $("#addgoodsbtn").hide();
    							        $("#importgoodsform").hide();
    								}
                                
                    }  
                );       
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
        
        selectGoods();
        
      }); 
      $("#addgoodsokbtn").click(function(){
        
        var goodsName=$("#goodsName").val();
        var goodsUnit=$("#goodsUnit").val();
        var goodsPrice=$("#goodsPrice").val();
        var goodsProductionDate=$("#goodsProductionDate").val();
        var goodsExpirationDate=$("#goodsExpirationDate").val();
        var goodsCount=$("#goodsCount").val();
        var goodsAllPay=$("#goodsAllPay").val();
        $("#addGoodsTab tbody").append("<tr id="+len+">"
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
    	  var storeName=$("#storeName").val();
    	  var providerName=$("#providerName").val();
    	  var discountMed=$("#discountMed").val();
    	  var importcreatetime=$("#importcreatetime").val();
    	  var payMed=$("#payMed").val();
    	  var payStatus=$("#payStatus").val();
    	  $('#addGoodsTab tbody tr').find('td').each(function() {
    		  goodList=goodList+$(this).text() + ',';
          });
    	  $.ajax(  
                  {  
                      url:'<%=_base %>/accountController/addImprotGoodsList.do',  
                      type:"post",  
                      async:false,
                      traditional:true,
                      data:{'goodList':goodList,
                    	    'storeName':storeName,
                    	    'providerName':providerName,
                    	    'discountMed':discountMed,
                    	    'payMed':payMed,
                    	    'importcreatetime':importcreatetime,
                    	    'payStatus':payStatus,},
                      success:function(data){
                    	  if($.parseJSON(data).RES_RESULT=="SUCCESS"){
                    		  alert("成功添加入库单");
                    	  }else{
                    		  alert("添加入库单失败");
                    	  }
                    	  alert(data);
                    	  
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
    	  var goodsName=$("#goodsName").val();
          var goodsUnit=$("#goodsUnit").val();
          var goodsPrice=$("#goodsPrice").val();
          var goodsProductionDate=$("#goodsProductionDate").val();
          var goodsExpirationDate=$("#goodsExpirationDate").val();
          var goodsCount=$("#goodsCount").val();
          var goodsAllPay=$("#goodsAllPay").val();
          $("#addGoodsTab tbody").append("<tr id="+len+">"
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

      </script>
  </body>
</html>