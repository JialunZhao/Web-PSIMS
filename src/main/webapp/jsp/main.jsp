<%@ include file="all.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h2 class="page-header">风险监控</h2>
	<div class="row placeholders">
		<div class="col-sm-6">
			<div class="half">
				<h4>商品过期风险预警</h4>
				<h4></h4>
			</div>
			<div class="canvasWrapper">
				<canvas id="myChart" width="200" height="200"></canvas>
			</div>
			<div class="chart-legend">
				<ul>
					<li class="prod"><a href="" id="ten" data-toggle="modal"
						onclick="ten(1)" data-target="#goods-10"></a></li>
					<li class="admin"><a href="" id="thirty" data-toggle="modal"
						onclick="ten(2)" data-target="#goods-10"></a></li>
					<li class="ship"><a href="" id="sixty" data-toggle="modal"
						onclick="ten(3)" data-target="#goods-10"></a></li>
					<li class="rework"><a href="" id="ninety" data-toggle="modal"
						onclick="ten(4)" data-target="#goods-10"></a></li>
				</ul>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="half">
				<h4>库存量风险预警</h4>
				<h4></h4>
			</div>
			<div class="canvasWrapper">
				<canvas id="myChart2" width="200" height="200"></canvas>
			</div>
			<div class="chart-legend">
				<ul>
					<li class="prod"><a href="" id="tens" data-toggle="modal"
						onclick="tens(1)" data-target="#storage-10"></a></li>
					<li class="admin"><a href="" id="fifty" data-toggle="modal"
						onclick="tens(2)" data-target="#storage-10"></a></li>
					<li class="ship"><a href="" id="hundred" data-toggle="modal"
						onclick="tens(3)" data-target="#storage-10"></a></li>
					<li class="rework"><a href="" id="hundreds"
						data-toggle="modal" onclick="tens(4)" data-target="#storage-10"></a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
</div>
</div>


<!-- 模态框（Modal） -->
<!-- 保持期模态框（Modal） -->
<div class="modal fade" id="goods-10" tabindex="-1" role="dialog"
	aria-labelledby="addgoods" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">商品保质期列表</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="table-responsive" id="tbA">
						<table class="table table-striped" id="tableGood">
							<tr>
								<th>商品名称</th>
								<th>商品编码</th>
								<th>入库日期</th>
								<th>生产日期</th>
								<th>预警值</th>
								<th>保质期剩余（天）</th>
								<th>数量</th>
							</tr>
							<tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->
<!-- 模态框（Modal） -->
<!-- 库存预警模态框（Modal） -->
<div class="modal fade" id="storage-10" tabindex="-1" role="dialog"
	aria-labelledby="addgoods" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabelB">库存量种类列表</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="table-responsive" id="tbB">
						<table class="table table-striped" id="tableGoodB">
							<tr>
								<th>商品名称</th>
								<th>商品编码</th>
								<th>剩余存量</th>
							</tr>
							<tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->



<!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
<script src="./js/vendor/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="./js/vendor/video.js"></script>
<script src="./js/flat-ui.min.js"></script>
<script src="./js/Chart.min.js"></script>
<script src="http://cdn.bootcss.com/modernizr/2.8.2/modernizr.min.js"></script>

<script type="text/javascript">
    
    function ten(str){
    	
    	$("#tableGood tr:gt(0)").remove();
    	$.ajax({
    		url : '${ctx}/tenAll.do?number='+str,
    		type : 'get',
    		success : function(messageRespon){
    			
//     			alert(messageRespon.length);
    			
    			var length=messageRespon.length;
    			for (var i = 0; i <length; i++) {
    			//	alert(messageRespon[i].goodsName);
    				var tr=$("<tr></tr>");
    				var td=$("<td>"+messageRespon[i].goodsName+"</td>"+
   	                     "<td>"+messageRespon[i].goodsId+"</td>"+"<td>"+messageRespon[i].strcreatetime+"</td>"+
   	                  	 "<td>"+messageRespon[i].strgoodsProductionDate+"</td>"+"<td>"+messageRespon[i].shelfLifeWarning+"天</td>"+
   	                       "<td>"+messageRespon[i].overDate+"</td><td>"+messageRespon[i].storageRateCurrent+"</td>");
   	                tr.append(td);
    				$("#tableGood").append(tr);
				}
    			  
    		}
    	})
//     	var num = str;
//     	switch (num)
// 		{
// 		case 1:
// 			$("#myModalLabel").html("10天内过期产品共"+messageRespon.ten+"件");
// 		  break;
// 		case 2:
// 			$("#thirty").html("10~30天内过期产品共"+messageRespon.thirty+"件");
// 		  break;
// 		case 3:
// 			$("#sixty").html("30~90天内过期产品共"+messageRespon.sixty+"件");
// 		  break;
// 		case 4:
// 			$("#ninety").html("保质期大于90天的产品共"+messageRespon.ninety+"件");
// 		  break;
// 		}
    	
    }
    function tens(str){
    	$("#tableGoodB tr:gt(0)").remove();
    	$.ajax({
    		url : '${ctx}/tensAll.do?number='+str,
    		type : 'get',
    		success : function(messageRespon){
    			
//     			alert(messageRespon.length);
    			
    			var length=messageRespon.length;
    			for (var i = 0; i <length; i++) {
    			//	alert(messageRespon[i].goodsName);
    				var tr=$("<tr></tr>");
    				var td=$("<td>"+messageRespon[i].goodsName+"</td>"+
   	                     "<td>"+messageRespon[i].goodsId+"</td>"+
   	                       "<td>"+messageRespon[i].storageCurrentTotal+"</td>");
   	                tr.append(td);
    				$("#tableGoodB").append(tr);
				}
    			  
    		}
    	})
    	
    }
    var A =0;
    var B =0;
    var C =0;
    var D =0;
    var A1 =0;
    var B1 =0;
    var C1 =0;
    var D1 =0;
    
    var ctx; 
    $(document).ready(function(){
    	$.ajax({
				url : '${ctx}/seek.do',
				type : 'get',
				success : function(messageRespon) {
// 					alert(messageRespon.ten);
					$("#ten").html("已到达保质期预警阈值的产品共"+messageRespon.ten+"件");
					$("#thirty").html("10天内到达保质期预警阈值产品共"+messageRespon.thirty+"件");
					$("#sixty").html("10~90天内到达保质期预警阈值产品共"+messageRespon.sixty+"件");
					$("#ninety").html("大于90天到达保质期预警阈值共"+messageRespon.ninety+"件");
					$("#tens").html("已到达库存量预警阈值共"+messageRespon.tens+"种");
					$("#fifty").html("库存量介于预警阈值100%-200%共"+messageRespon.fifty+"种");
					$("#hundred").html("库存量介于预警阈值200%-300%共"+messageRespon.hundred+"种");
					$("#hundreds").html("库存量大于预警阈值300%共"+messageRespon.hundreds+"种");
					
					A = messageRespon.ten;
					B = messageRespon.thirty;
					C = messageRespon.sixty;
					D = messageRespon.ninety;
					A1 = messageRespon.tens;
					B1 = messageRespon.fifty;
					C1 = messageRespon.hundred;
					D1 = messageRespon.hundreds;
					
					 //Get context with jQuery - using jQuery's .get() method.
				      ctx = $("#myChart").get(0).getContext("2d");
				      //This will get the first returned node in the jQuery collection.
				      var myNewChart = new Chart(ctx);
				       
// 					A1 = messageRespon.ten;
// 					var a = messageRespon.ten;
// 					var b = messageRespon.thirty;
// 					var c = messageRespon.sixty;
// 					var d = messageRespon.ninety;
// 					alert(a);
// 					var all = a+b+c+d;
// 					A1 = 10;
// 					B1 = 80;
// 					C1 = 5;
// 					D1 = 5;

					 var data = [
					        {
					            value: A,
					            color:"#c62f29"
					        },
					        {
					            value : B,
					            color : "#dbba34"
					        },
					        {
					            value : C,
					            color : "#637b85"
					        },
					        {
					            value : D,
					            color : "#2c9c69"
					        }
					      ]
			
			      var options = {
			        //Boolean - Whether we should show a stroke on each segment
			        segmentShowStroke : true,
			        
			        //String - The colour of each segment stroke
			        segmentStrokeColor : "#fff",
			        
			        //Number - The width of each segment stroke
			        segmentStrokeWidth : 2,
			        
			        //The percentage of the chart that we cut out of the middle.
			        percentageInnerCutout : 50,
			        
			        //Boolean - Whether we should animate the chart 
			        animation : true,
			        
			        //Number - Amount of animation steps
			        animationSteps : 100,
			        
			        //String - Animation easing effect
			        animationEasing : "easeOutBounce",
			        
			        //Boolean - Whether we animate the rotation of the Doughnut
			        animateRotate : true,
			
			        //Boolean - Whether we animate scaling the Doughnut from the centre
			        animateScale : false,
			        
			        //Function - Will fire on animation completion.
			        onAnimationComplete : null
			      }
 					new Chart(ctx).Doughnut(data);
					 
					 var ctx2 = $("#myChart2").get(0).getContext("2d");
				      //This will get the first returned node in the jQuery collection.
				      var myNewChart2 = new Chart(ctx2);
				      var data2 = [
				        {
				            value: A1,
				            color:"#c62f29"
				        },
				        {
				            value : B1,
				            color : "#dbba34"
				        },
				        {
				            value : C1,
				            color : "#637b85"
				        },
				        {
				            value : D1,
				            color : "#2c9c69"
				        }
				      ]

				      var options2 = {
				        //Boolean - Whether we should show a stroke on each segment
				        segmentShowStroke : true,
				        
				        //String - The colour of each segment stroke
				        segmentStrokeColor : "#fff",
				        
				        //Number - The width of each segment stroke
				        segmentStrokeWidth : 2,
				        
				        //The percentage of the chart that we cut out of the middle.
				        percentageInnerCutout : 50,
				        
				        //Boolean - Whether we should animate the chart 
				        animation : true,
				        
				        //Number - Amount of animation steps
				        animationSteps : 100,
				        
				        //String - Animation easing effect
				        animationEasing : "easeOutBounce",
				        
				        //Boolean - Whether we animate the rotation of the Doughnut
				        animateRotate : true,

				        //Boolean - Whether we animate scaling the Doughnut from the centre
				        animateScale : false,
				        
				        //Function - Will fire on animation completion.
				        onAnimationComplete : null
				      }

				      new Chart(ctx2).Doughnut(data2);
					 
				},
				error : function(messageRespon) {

				}
			}) 
      

      


    });
    </script>


<script type="text/javascript">
    $(document).ready(function(){
      var doughnutChartData = [
        {
          value: 30,
          color:"#F7464A"
        },
        {
          value : 50,
          color : "#46BFBD"
        },
        {
          value : 100,
          color : "#FDB45C"
        },
        {
          value : 40,
          color : "#949FB1"
        },
        {
          value : 120,
          color : "#4D5360"
        }
      ];

      var globalGraphSettings = {animation : Modernizr.canvas};

      function showDoughnutChart(){
        var ctx = document.getElementById("doughnutChartCanvas").getContext("2d");
        new Chart(ctx).Doughnut(doughnutChartData,globalGraphSettings);
      };


      $("#doughnutChart").on("inview",function(){
        var $this = $(this);
        $this.removeClass("hidden").off("inview");
        setTimeout(showDoughnutChart,graphInitDelay);     
      });
    });    
    </script>


</body>
</html>
