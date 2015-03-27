<!DOCTYPE html>
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
    <link href="./css/bootstrap/bootstrap.min.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="./css/flatUI/flat-ui.min.css" rel="stylesheet">
    <link href="./css/dashboard.css" rel="stylesheet">

	
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
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="./index.html">北京市金瑞超达商贸有限公司-食品库存管理系统DEMO</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="./sitting.html">系统设置</a></li>
            <li><a href="./user.html">员工权限</a></li>
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
            <li><a href="./customer.html">客户管理</a></li>
            <li><a href="./provider.html">供应商</a></li>
            <li class="active"><a href="./goods.html">商品管理</a></li>
            <li><a href="./storehouse.html">仓库管理</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="./import.html">货品入库</a></li>
            <li><a href="./sales.html">销售出库</a></li>
            <li><a href="#">退货管理</a></li>
            <li><a href="#">有效期调整</a></li>
            <li><a href="#">销毁出库</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="./recoveryimport.html">回收物入库</a></li>
            <li><a href="./recoveryexport.html">回收物出库</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="#">统计报表</a></li>
          </ul>
        </div>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h3 class="page-header">商品管理</h3>

          <div class="row placeholders">
          <form class="form-inline">
            <div class="form-group">
              <label for="exampleInputName2">商品名称：</label>
              <input type="text" class="form-control" id="exampleInputName2" placeholder="商品名称">
            </div>
            <div class="form-group">
              <label for="exampleInputEmail2">商品类型：</label>
              <select class="form-control" value="请选择商品类型：" tabindex="1" name="herolist">
                <option value="0">请选择商品类型：</option>
                <option value="1">啤酒</option>
                <option value="2">白酒</option>
                <option value="3">饮料</option>
                <option value="4">原料</option>
              </select>
            </div>
            <div class="form-group">
              <label for="exampleInputEmail2">商品价格：</label>
              <input type="text" class="form-control" id="exampleInputEmail2" placeholder="商品价格">
            </div>
            <div class="form-group">
              <label for="exampleInputEmail2">保质期：</label>
              <input type="text" class="form-control" id="exampleInputEmail2" placeholder="保质期（天）">
            </div>
            <button type="submit" class="btn btn-primary">搜索</button>
          </form>
          </div>

          <div class="row placeholders ">
            <div class="col-sm-5">
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addgoods">新增商品</button>
            <button type="button" id="delbtn" class="btn btn-primary">批量删除商品</button>
            <button type="button" id="delcommit" class="btn btn-primary" style="display:none">确认删除商品</button>
            <button type="button" id="delcancle" class="btn btn-primary" style="display:none">取消</button>
            </div>
          </div>

          <h4 class="sub-header">商品清单</h4>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th class="chk" style="display:none"><input type="checkbox" aria-label="..."></th>
                  <th>编号</th>
                  <th>名称</th>
                  <th>类型</th>
                  <th>基本单位</th>
                  <th>进货价格</th>
                  <th>进货折扣</th>
                  <th>销售价格</th>
                  <th>保质期（天）</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td class="chk" style="display:none"><input type="checkbox" aria-label="..."></td>
                  <td>1</td>
                  <td><a data-toggle="modal" data-target="#goods2customer" href="#">百威金樽500ml</a></td>
                  <td>啤酒</td>
                  <td>箱(12瓶)</td>
                  <td>99</td>
                  <td>30%</td>
                  <td>110</td>
                  <td>180</td>
                  <td><a href="#">下架</a></td>
                </tr>
                <tr>
                  <td class="chk" style="display:none"><input type="checkbox" aria-label="..."></td>
                  <td>2</td>
                  <td>听可乐330ml</td>
                  <td>饮料</td>
                  <td>箱(24瓶)</td>
                  <td>42</td>
                  <td>50%</td>
                  <td>60</td>
                  <td>180</td>
                  <td>下架</td>
                </tr>
                <tr>
                  <td class="chk" style="display:none"><input type="checkbox" aria-label="..."></td>
                  <td>3</td>
                  <td>百威红瓶9.7度500ml</td>
                  <td>啤酒</td>
                  <td>箱(12瓶)</td>
                  <td>63</td>
                  <td>30%</td>
                  <td>80</td>
                  <td>180</td>
                  <td>下架</td>
                </tr>
                <tr>
                  <td class="chk" style="display:none"><input type="checkbox" aria-label="..."></td>
                  <td>4</td>
                  <td>小糊涂仙52度（250ml）</td>
                  <td>白酒</td>
                  <td>瓶</td>
                  <td>57</td>
                  <td>15%</td>
                  <td>66</td>
                  <td>360</td>
                  <td><a href="#" data-toggle="modal" data-target="#modifygoods">修改</a>/上架</td>
                </tr>
                <tr>
                  <td class="chk" style="display:none"><input type="checkbox" aria-label="..."></td>
                  <td>5</td>
                  <td>酸梅汤原浆</td>
                  <td>调制品</td>
                  <td>桶</td>
                  <td>198</td>
                  <td>0%</td>
                  <td>210</td>
                  <td>30</td>
                  <td><a href="#" data-toggle="modal" data-target="#modifygoods">修改</a>/下架</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>


    <!-- 模态框（Modal） -->
    <!-- 添加商品模态框（Modal） -->
    <div class="modal fade" id="addgoods" tabindex="-1" role="dialog" 
       aria-labelledby="addgoods" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="myModalLabel">新增商品</h4>
          </div>
          <div class="modal-body">
            <div class="row">
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">商品名称:</span>
                <input type="text" class="form-control" placeholder="商品名称">
              </div>    
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">商品类型:</span>
                <input type="text" class="form-control" placeholder="商品类型">
              </div>           
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">基本单位:</span>
                <input type="text" class="form-control" placeholder="基本单位">
              </div>           
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">进货价格:</span>
                <input type="text" class="form-control" placeholder="进货价格">
                <span class="input-group-addon">元</span>
              </div>
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">进货折扣:</span>
                <input type="text" class="form-control" placeholder="进货折扣">
                <span class="input-group-addon">%</span>
              </div>              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">销售价格:</span>
                <input type="text" class="form-control" placeholder="无折扣销售价格">
                <span class="input-group-addon">元</span>
              </div>
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">保质期：</span>
                <input type="text" class="form-control" placeholder="保质期">
                <span class="input-group-addon">（天）</span>
              </div>

            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button type="button" class="btn btn-primary">确认新增</button>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

    <!-- 配置商品对应客户折扣模态框（Modal） -->
    <div class="modal fade" id="goods2customer" tabindex="-1" role="dialog" aria-labelledby="goods2customer" aria-hidden="true">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="myModalLabel">销售折扣配置（百威金樽500ml）</h4>
          </div>
          <div class="modal-body">
            <div class="row">
              <div class="table-responsive col-sm-12">
                <table class="table table-striped">
                  <thead>
                    <tr>
                      <th>客户名称</th>
                      <th>进货价格</th>
                      <th>标准销售价格</th>
                      <th>优惠销售价格</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>聚点串吧(东直门店)</td>
                      <td>99</td>
                      <td>110</td>
                      <td><input class="control-group" type="text" value="105" placeholder="商品优惠销售价格"> </td>
                    </tr>
                    <tr>
                      <td>聚点串吧(酒仙桥店)</td>
                      <td>99</td>
                      <td>110</td>
                      <td><input class="control-group" type="text" value="108" placeholder="商品优惠销售价格"> </td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
            <div class="row">
              <div class="row placeholders ">
                <div class="col-sm-2">
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#importgoods">新增折扣</button>
                </div>
              </div>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button type="button" class="btn btn-primary">
            确认
            </button>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->


    <!-- 模态框（Modal） -->
    <!-- 添加商品模态框（Modal） -->
    <div class="modal fade" id="modifygoods" tabindex="-1" role="dialog" 
       aria-labelledby="addgoods" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="myModalLabel">修改商品</h4>
          </div>
          <div class="modal-body">
            <div class="row">
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">商品名称:</span>
                <input type="text" class="form-control" placeholder="商品名称" value="百威金樽500ml">
              </div>    
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">商品类型:</span>
                <input type="text" class="form-control" placeholder="商品类型" value="啤酒">
              </div>           
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">基本单位:</span>
                <input type="text" class="form-control" placeholder="基本单位" value="箱(12瓶)">
              </div>           
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">进货价格:</span>
                <input type="text" class="form-control" placeholder="进货价格" value="99">
                <span class="input-group-addon">元</span>
              </div>
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">销售价格:</span>
                <input type="text" class="form-control" placeholder="无折扣销售价格" value="110">
                <span class="input-group-addon">元</span>
              </div>
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">保质期：</span>
                <input type="text" class="form-control" placeholder="保质期" value="180">
                <span class="input-group-addon">（天）</span>
              </div>

            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button type="button" class="btn btn-primary">确认修改</button>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
    <!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
    <script src="./js/vendor/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="./js/vendor/video.js"></script>
    <script src="./js/flat-ui.min.js"></script>
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
      });    });
    </script>
  </body>
</html>
