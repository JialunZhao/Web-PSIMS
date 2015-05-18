<%@page import="com.ai.psims.web.util.Constants"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String date = sdf.format(new Date());
%>
<%@ include file="all.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

	<h3 class="page-header">商品管理</h3>

	<div class="row placeholders col-sm-12">
		<form class="form-inline" action="goods" method="get">
			<div class="form-group">
				<label for="query_goodsName">商品名称：</label> <input type="text"
					class="form-control" id="query_goodsName" name="query_goodsName"
					placeholder="商品名称" maxlength="200">
			</div>
			<div class="form-group">
				<label for="query_goodsType">商品类型：</label> <select
					class="form-control" id="query_goodsType" name="query_goodsType"
					tabindex="1">
					<option value="0">请选择商品类型：</option>
					<option value="1">啤酒</option>
					<option value="2">白酒</option>
					<option value="3">饮料</option>
					<option value="4">原料</option>
				</select>
			</div>
			<div class="form-group">
				<label for="query_goodsPrice">销售价格：</label> <input type="text"
					class="form-control" id="query_goodsPrice" name="query_goodsPrice"
					placeholder="商品价格" maxlength="20" onkeyup="clearNoNum(this)"
					style="ime-mode: Disabled">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail2">保质期：</label> <input type="text"
					class="form-control" id="query_goodsShelfLife"
					name="query_goodsShelfLife" placeholder="保质期（天）" maxlength="20">
			</div>
			<button type="submit" class="btn btn-primary">搜索</button>
		</form>
	</div>

	<div class="row placeholders ">
		<div class="col-sm-5">
			<priv:privilege power="商品管理.增删改">
				<button type="button" class="btn btn-primary" id="addGoods_btn">新增商品</button>
			</priv:privilege>
		</div>
	</div>

	<h4 class="sub-header">商品清单</h4>
	<div class="table-responsive">
		<table class="table table-striped">
			<thead>
				<tr>
					<th class="chk" style="display: none"><input type="checkbox"
						aria-label="..."></th>
					<th>编号</th>
					<th>名称</th>
					<th>编码</th>
					<th>类型</th>
					<th>基本单位</th>
					<th>成本价格</th>
					<th>销售价格</th>
					<th>销售利润</th>
					<th>保质期（天）</th>
					<th>库存量预警值</th>
					<th>保质期预警值</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="goodss" items="${goodss}">
					<tr>
						<td class="chk" style="display: none"><input type="checkbox"
							aria-label="..."></td>
						<td>${goodss.goodsId}</td>
						<td><a href="javascript:void(0);"
							onClick="goods2customer(this)">${goodss.goodsName}</a></td>
						<td>${goodss.goodsCode}</td>
						<td>${goodss.goodsType}</td>
						<td>${goodss.goodsUnit}</td>
						<td>${goodss.goodsActualCost}</td>
						<td>${goodss.goodsPrice}</td>
						<td>${goodss.goodsProfit}</td>
						<td>${goodss.goodsShelfLife}</td>
						<td>${goodss.storageWarning}</td>
						<td>${goodss.shelfLifeWarning}</td>
						<priv:privilege power="商品管理.增删改">
							<c:if test="${goodss.goodsStatus==01}">
								<td><a href="javascript:void(0);"
									onClick="offShelvesCurrentGoods(this)">下架</a></td>
							</c:if>
							<c:if test="${goodss.goodsStatus==02}">
								<td><a href="javascript:void(0);"
									onClick="modifyCurrentGoods(this)">修改</a>/<a
									href="javascript:void(0);" onClick="delCurrentGoods(this);">删除</a>/<a
									href="javascript:void(0);"
									onClick="onShelvesCurrentGoods(this)">上架</a></td>
							</c:if>
						</priv:privilege>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>


<!-- 模态框（Modal） -->
<!-- 添加商品模态框（Modal） -->
<div class="modal fade" id="addGoods" tabindex="-1" role="dialog"
	aria-labelledby="addGoods" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="addGoodsModalLabel">新增商品</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<form id="addGoodsForm">
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">商品名称:</span> <input
								type="text" class="form-control" name="goodsName"
								placeholder="商品名称" maxlength="200">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">商品编码:</span> <input
								type="text" class="form-control" name="goodsCode"
								placeholder="商品编码" maxlength="20">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">商品类型:</span> <select
								class="form-control" tabindex="1" name="goodsType">
								<option value="0">请选择商品类型：</option>
								<option value="1">啤酒</option>
								<option value="2">白酒</option>
								<option value="3">饮料</option>
								<option value="4">原料</option>
							</select>
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">商品供应商:</span> <select
								class="form-control" tabindex="1" name="providerId"
								id="add_providers">
								<option value="0">请选择商品供应商：</option>
							</select>
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">基本单位:</span> <select
								class="form-control" tabindex="1" name="goodsUnit"
								id="add_goodsUnit">
								<option value="0">请选择商品基本单位：</option>
							</select>
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">进货价格:</span> <input
								type="text" class="form-control" name="goodsActualCost"
								placeholder="进货价格" maxlength="20"> <span
								class="input-group-addon">元</span>
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">销售价格:</span> <input
								type="text" class="form-control" name="goodsPrice"
								placeholder="销售价格" maxlength="20"> <span
								class="input-group-addon">元</span>
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">商品利润:</span> <input
								type="text" class="form-control" name="goodsProfit"
								placeholder="商品利润" maxlength="20"> <span
								class="input-group-addon">%</span>
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">保质期：</span> <input
								type="text" class="form-control" name="goodsShelfLife"
								placeholder="保质期" maxlength="20"> <span
								class="input-group-addon">（天）</span>
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">保质期预警值：</span> <input
								type="text" class="form-control" name="shelfLifePrewarning"
								placeholder="保质期预警值" maxlength="20"> <span
								class="input-group-addon">（天）</span>
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">库存量预警值：</span> <input
								type="text" class="form-control" name="storagePrewarning"
								placeholder="库存量预警值" maxlength="20"> <span
								class="input-group-addon">（天）</span>
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">备注：</span> <input type="text"
								class="form-control" id="remark" name="remark" placeholder="备注："
								value="" maxlength="200">
						</div>
					</form>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				<button type="button" class="btn btn-primary" id="addGoodsSubmit">确认新增</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->


<!-- 模态框（Modal） -->
<!-- 修改商品模态框（Modal） -->
<div class="modal fade" id="modifygoods" tabindex="-1" role="dialog"
	aria-labelledby="addgoods" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">修改商品</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<form id="modifyGoodsForm">
						<input type="hidden" id="modify_goodsId" name="modify_goodsId"
							value="">
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">商品名称:</span> <input
								type="text" class="form-control" id="modify_goodsName" value=""
								name="modify_goodsName" placeholder="商品名称" maxlength="200">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">商品编码:</span> <input
								type="text" class="form-control" id="modify_goodsCode" value=""
								name="modify_goodsCode" placeholder="商品编码" maxlength="20">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">商品类型:</span> <select
								class="form-control" tabindex="1" id="modify_goodsType"
								name="modify_goodsType">
								<option value="0">请选择商品类型：</option>
								<option value="1">啤酒</option>
								<option value="2">白酒</option>
								<option value="3">饮料</option>
								<option value="4">原料</option>
							</select>
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">商品供应商:</span> <select
								class="form-control" tabindex="1" name="modify_providerId"
								id="modify_providers">
								<option value="0">请选择商品供应商：</option>
							</select>
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">基本单位:</span> <select
								class="form-control" tabindex="1" name="modify_goodsUnit"
								id="modify_goodsUnit">
								<option value="0">请选择商品基本单位：</option>
							</select>
						</div>

						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">进货价格:</span> <input
								type="text" class="form-control" id="modify_goodsActualCost"
								value="" name="modify_goodsActualCost" placeholder="进货价格"
								maxlength="20"> <span class="input-group-addon">元</span>
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">销售价格:</span> <input
								type="text" class="form-control" id="modify_goodsPrice" value=""
								name="modify_goodsPrice" placeholder="销售价格"> <span
								class="input-group-addon">元</span>
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">商品利润:</span> <input
								type="text" class="form-control" id="modify_goodsProfit"
								value="" name="modify_goodsProfit" placeholder="商品利润"
								maxlength="20"> <span class="input-group-addon">%</span>
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">保质期：</span> <input
								type="text" class="form-control" id="modify_goodsShelfLife"
								value="" name="modify_goodsShelfLife" placeholder="保质期"
								maxlength="20"> <span class="input-group-addon">（天）</span>
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">保质期预警值：</span> <input
								type="text" class="form-control" id="modify_shelfLifePrewarning"
								value="" name="modify_shelfLifePrewarning" placeholder="保质期预警值"
								maxlength="20"> <span class="input-group-addon">（天）</span>
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">库存量预警值：</span> <input
								type="text" class="form-control" id="modify_storagePrewarning"
								value="" name="modify_storagePrewarning" placeholder="库存量预警值"
								maxlength="20"> <span class="input-group-addon">（天）</span>
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">备注：</span> <input type="text"
								class="form-control" id="modify_remark" name="modify_remark"
								placeholder="备注：" value="" maxlength="200">
						</div>
					</form>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				<button type="button" class="btn btn-primary"
					onClick="modifyCurrentGoodsInfo(this)">确认修改</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->


<!-- 配置商品对应客户折扣模态框（Modal） -->
<div class="modal fade" id="goods2customer" tabindex="-1" role="dialog"
	aria-labelledby="goods2customer" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="g2cGoodsName"></h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<form id="goods2CustomerForm">
						<input type="hidden" id="goodsId" name="goodsId">

						<div class="table-responsive col-sm-12">

							<table class="table table-striped">
								<thead>
									<tr>
										<th>客户名称</th>
										<th>成本价格</th>
										<th>标准销售价格</th>
										<th>优惠销售价格</th>
										<th>利润</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody id="tb">
								</tbody>
							</table>
						</div>
					</form>
				</div>
				<div class="row">
					<div class="row placeholders ">
						<div class="col-sm-2">
							<priv:privilege power="商品管理.增删改">
								<button type="button" class="btn btn-primary"
									onClick="addgoods2customer(this)">新增折扣</button>
							</priv:privilege>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				<priv:privilege power="商品管理.增删改">
					<button type="button" class="btn btn-primary"
						onClick="savegoods2customer(this)">保存</button>
				</priv:privilege>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->
<input type="hidden" id="tmpGoodId">
<input type="hidden" id="tmpGoodsName">
<input type="hidden" id="tmpGoodsActualCost">
<input type="hidden" id="tmpGoodsPrice">
<input type="hidden" id="tmpGoodsProfit">

<!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
<script src="<%=path%>/js/vendor/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<%=path%>/js/vendor/video.js"></script>
<script src="<%=path%>/js/flat-ui.min.js"></script>
<script src="<%=path%>/js/goods.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#delbtn").click(function() {
			$("#delbtn").hide();
			$("#delcommit").show();
			$("#delcancle").show();
			$(".chk").show();
		});
		$("#delcommit").click(function() {
			$("#delbtn").show();
			$("#delcommit").hide();
			$("#delcancle").hide();
			$(".chk").hide();
		});
		$("#delcancle").click(function() {
			$("#delbtn").show();
			$("#delcommit").hide();
			$("#delcancle").hide();
			$(".chk").hide();
		});
	});

</script>
