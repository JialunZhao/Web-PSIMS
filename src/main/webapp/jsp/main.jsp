<%@ include file="all.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

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
                  <li class="prod"><a href="#" data-toggle="modal" data-target="#goods-10">10天内过期产品共10件</a></li>
                  <li class="admin">10~30天内过期产品共40件</li>
                  <li class="ship">30~90天内过期产品共20件</li>
                  <li class="rework">保质期大于90天的产品30件</li>
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
                  <li class="prod">存量小于10件共20种</li>
                  <li class="admin">存量小于50件共10种</li>
                  <li class="ship">存量小于100件共50种</li>
                  <li class="rework">存量大于100件共20种</li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>


    <!-- 模态框（Modal） -->
    <!-- 小于十天模态框（Modal） -->
    <div class="modal fade" id="goods-10" tabindex="-1" role="dialog" 
       aria-labelledby="addgoods" aria-hidden="true">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="myModalLabel">保质期小于10天的商品</h4>
          </div>
          <div class="modal-body">
            <div class="row">
              <div class="table-responsive">
                <table class="table table-striped">
                  <thead>
                    <tr>
                      <th>商品名称</th>
                      <th>商品编码</th>
                      <th>保质期剩余（天）</th>
                      <th>数量</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>百威红瓶9.7度500ml</td>
                      <td>001</td>
                      <td>9</td>
                      <td>231</td>
                    </tr>
                    <tr>
                      <td>酸梅汤原浆</td>
                      <td>299</td>
                      <td>7</td>
                      <td>14</td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->




    <!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
    <script src="./js/vendor/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="./js/vendor/video.js"></script>
    <script src="./js/flat-ui.min.js"></script>
    <script src="./js/Chart.min.js"></script>
    <script src="http://cdn.bootcss.com/modernizr/2.8.2/modernizr.min.js"></script>

    <script type="text/javascript">
    $(document).ready(function(){
      //Get context with jQuery - using jQuery's .get() method.
      var ctx = $("#myChart").get(0).getContext("2d");
      //This will get the first returned node in the jQuery collection.
      var myNewChart = new Chart(ctx);
      var data = [
        {
            value: 20,
            color:"#637b85"
        },
        {
            value : 30,
            color : "#2c9c69"
        },
        {
            value : 40,
            color : "#dbba34"
        },
        {
            value : 10,
            color : "#c62f29"
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
            value: 50,
            color:"#637b85"
        },
        {
            value : 20,
            color : "#2c9c69"
        },
        {
            value : 10,
            color : "#dbba34"
        },
        {
            value : 20,
            color : "#c62f29"
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
