<%@ include file="all.jsp"%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h3 class="page-header">系统设置管理</h3>
	<ul id="myTab" class="nav nav-tabs">
		<li class="active"><a href="#p_ee" data-toggle="tab">奖金池</a></li>
		<li><a href="#p_aa" data-toggle="tab">基本单位</a></li>
		<li><a href="#p_bb" data-toggle="tab">商品类型</a></li>
		<li><a href="#p_cc" data-toggle="tab">支付方式</a></li>
		<li><a href="#p_dd" data-toggle="tab">收款方式</a></li>
		<li><a href="#p_ff" data-toggle="tab">结账方式</a></li>
	</ul>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade" id="p_aa">
			<button type="button" class="btn btn-primary"
				onclick="add('GoodsUnit')">新增基本单位</button>
			<table class="table table-striped">
				<thead>
					<tr>
						<th class="chk" style="display: none"><input type="checkbox"
							aria-label="..."></th>
						<th>编号</th>
						<th>基本单位名称</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:set value="0" var="seq"></c:set>
					<c:forEach items="${sitting}" var="s" step="1">
						<c:if test="${s.pValue == 'GoodsUnit' }">
							<tr>
								<c:set value="${seq + 1}" var="seq"></c:set>
								<td class="chk" style="display: none"><input
									type="checkbox" aria-label="..."></td>
								<td><c:out value="${seq}" /></td>
								<td><c:out value="${s.ppDesc}" /></td>
								<td><a href="#" data-toggle="modal"
									onclick="chenge(${s.paramId},'GoodsUnit')">修改</a>/ <a
									href="${s.paramId}/delete.do">删除</a></td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="tab-pane fade" id="p_bb">
			<button type="button" class="btn btn-primary"
				onclick="add('GoodsType')">新增商品类型</button>
			<table class="table table-striped">
				<thead>
					<tr>
						<th class="chk" style="display: none"><input type="checkbox"
							aria-label="..."></th>
						<th>编号</th>
						<th>商品类型名称</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:set value="0" var="sqe1"></c:set>
					<c:forEach items="${sitting}" var="s" step="1">
						<c:if test="${s.pValue == 'GoodsType' }">
							<tr>
								<c:set value="${seq1 + 1}" var="seq1"></c:set>
								<td class="chk" style="display: none"><input
									type="checkbox" aria-label="..."></td>
								<td><c:out value="${seq1}" /></td>
								<td><c:out value="${s.ppDesc}" /></td>
								<td><a href="#" data-toggle="modal"
									onclick="chenge(${s.paramId},'GoodsType')">修改</a></td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="tab-pane fade" id="p_cc">
			<button type="button" class="btn btn-primary"
				onclick="add('PaymentType')">新增支付方式</button>
			<table class="table table-striped">
				<thead>
					<tr>
						<th class="chk" style="display: none"><input type="checkbox"
							aria-label="..."></th>
						<th>编号</th>
						<th>支付方式名称</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:set value="0" var="sqe2"></c:set>
					<c:forEach items="${sitting}" var="s" step="1">
						<c:if test="${s.pValue == 'PaymentType' }">
							<tr>
								<c:set value="${sqe2 + 1}" var="sqe2"></c:set>
								<td class="chk" style="display: none"><input
									type="checkbox" aria-label="..."></td>
								<td><c:out value="${sqe2}" /></td>
								<td><c:out value="${s.ppDesc}" /></td>
								<td><a href="#" data-toggle="modal"
									onclick="chenge(${s.paramId},'PaymentType')">修改</a>/ <a
									href="${s.paramId}/delete.do">删除</a></td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="tab-pane fade" id="p_dd">
			<button type="button" class="btn btn-primary"
				onclick="add('IncomeType')">新增收款方式</button>
			<table class="table table-striped">
				<thead>
					<tr>
						<th class="chk" style="display: none"><input type="checkbox"
							aria-label="..."></th>
						<th>编号</th>
						<th>收款方式名称</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:set value="0" var="sqe3"></c:set>
					<c:forEach items="${sitting}" var="s" step="1">
						<c:if test="${s.pValue == 'IncomeType' }">
							<tr>
								<c:set value="${sqe3 + 1}" var="sqe3"></c:set>
								<td class="chk" style="display: none"><input
									type="checkbox" aria-label="..."></td>
								<td><c:out value="${sqe3}" /></td>
								<td><c:out value="${s.ppDesc}" /></td>
								<td><a href="#" data-toggle="modal"
									onclick="chenge(${s.paramId},'IncomeType')">修改</a>/ <a
									href="${s.paramId}/delete.do">删除</a></td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="tab-pane fade in active" id="p_ee">
			<button type="button" class="btn btn-primary"
				onclick="add('PrizePool')">新增奖金池</button>
			<table class="table table-striped">
				<thead>
					<tr>
						<th class="chk" style="display: none"><input type="checkbox"
							aria-label="..."></th>
						<th>编号</th>
						<th>奖金池名称</th>
						<th>奖金池额度</th>
						<!-- 						<th>手动增加奖金池</th> -->
						<!-- 						<th>手动降低奖金池</th> -->
						<th>奖金池历史</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:set value="0" var="sqe3"></c:set>
					<c:forEach items="${sitting}" var="s" step="1">
						<c:if test="${s.pValue == 'PrizePool' }">
							<tr>
								<c:set value="${sqe3 + 1}" var="sqe3"></c:set>
								<td class="chk" style="display: none"><input
									type="checkbox" aria-label="..."></td>
								<td><c:out value="${sqe3}" /></td>
								<td><c:out value="${s.ppDesc}" /></td>
								<td><c:out value="${s.ppValue}" /></td>
								<!-- 								<td><input type="text" class="form-control" placeholder="+" value="+"></td> -->
								<!-- 								<td><input type="text" class="form-control" placeholder="-" value="-"></td> -->
								<td><a href="#" data-toggle="modal"
									onclick="detail(${s.paramId},'p_ee')" data-target="#goods-10">详情</a>/
									<a href="#" data-toggle="modal"
									onclick="delcommit(${s.paramId},'p_ee')">导出</a></td>
								<td><a href="#" data-toggle="modal"
									onclick="chenge(${s.paramId},'p_ee')">修改</a>/ <a href="#"
									data-toggle="modal" onclick="deleted(${s.paramId})">删除</a></td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="modal fade" id="goods-10" tabindex="-1" role="dialog"
			aria-labelledby="addgoods" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">奖金池历史列表</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="table-responsive" id="tbA">
								<table class="table table-striped" id="tableGood">
									<tr>
										<th>编号</th>
										<th>奖金池名称</th>
										<th>修改时间</th>
										<th>原始奖金</th>
										<th>增加</th>
										<th>减少</th>
										<th>最终余额</th>
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
		<div class="tab-pane fade" id="p_ff">
			<button type="button" class="btn btn-primary"
				onclick="add('CheckoutType')">新增结账方式</button>
			<table class="table table-striped">
				<thead>
					<tr>
						<th class="chk" style="display: none"><input type="checkbox"
							aria-label="..."></th>
						<th>编号</th>
						<th>结账方式</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:set value="0" var="sqe3"></c:set>
					<c:forEach items="${sitting}" var="s" step="1">
						<c:if test="${s.pValue == 'CheckoutType' }">
							<tr>
								<c:set value="${sqe3 + 1}" var="sqe3"></c:set>
								<td class="chk" style="display: none"><input
									type="checkbox" aria-label="..."></td>
								<td><c:out value="${sqe3}" /></td>
								<%-- 								<td><c:out value="${s.ppDesc}" /></td> --%>
								<td><c:out value="${s.ppDesc}" /></td>
								<td><a href="#" data-toggle="modal"
									onclick="chenge(${s.paramId},'CheckoutType')">修改</a>/ <a
									href="${s.paramId}/delete.do">删除</a></td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>

</div>


<div class="modal fade" id="addrecoveryimport" tabindex="-1"
	role="dialog" aria-labelledby="addrecoveryimport" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="addmyModalLabel">新增系统参数</h4>
			</div>
			<form id="formA" action="${ctx}/sys/add.do" method="post">
				<div class="modal-body">
					<div class="row">
						<div class="input-group col-xs-6 col-md-offset-3">
							<input type="hidden" name="pValue" id="addpValue"> <input
								type="hidden" name="pDesc" id="addpDesc"> <span id="pram"
								class="input-group-addon" style="background-color: #1abc9c;">参数名称:</span>
							<input id="ppDesc" name="ppDesc" type="text" class="form-control"
								placeholder="参数名称" value="">
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="submit" class="btn btn-primary" onclick="addv()">确认新增</button>
				</div>
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<div class="modal fade" id="addrecoveryimport1" tabindex="-1"
	role="dialog" aria-labelledby="addrecoveryimport" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel2">新增系统参数</h4>
			</div>
			<form id="formB" action="${ctx}/sys/add.do" method="post">
				<div class="modal-body">
					<div class="row">
						<div class="input-group col-xs-6 col-md-offset-3">
							<input type="hidden" name="pValue" id="pValue1"> <input
								type="hidden" name="pDesc" id="pDesc2">
							<!-- 							<input type="hidden" name="ppDesc" id="ppDesc2" > -->
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">奖金池名称:</span> <input
								id="ppDesc2" name="ppDesc" type="text" class="form-control"
								placeholder="奖金池名称">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">奖金池额度:</span> <input
								id="ppValue2" name="ppValue" type="text" class="form-control"
								onKeyUp="clearNoNum(event,this)" onBlur="checkNum(this)"
								placeholder="奖金池额度" value="">
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="submit" class="btn btn-primary">确认新增</button>
				</div>
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>

<!-- 模态框（Modal） -->
<!-- 修改回收物模态框（Modal） -->
<div class="modal fade" id="modifyrecoveryimport" tabindex="-1"
	role="dialog" aria-labelledby="modifyrecoveryimport" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="modmyModalLabel">修改系统参数</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="input-group col-xs-6 col-md-offset-3">
						<span id ="modpram" class="input-group-addon" style="background-color: #1abc9c;">参数名称:</span>
						<input id="ppDesc1" name="ppDesc1" type="text"
							class="form-control" placeholder="参数名称"> <input
							id="paramId1" name="paramId1" type="hidden" class="form-control"
							placeholder="参数名称"> <input id="pValue12" name="pValue1"
							type="hidden" class="form-control" placeholder="参数名称"> <input
							id="pDesc1" name="pDesc1" type="hidden" class="form-control"
							placeholder="参数名称">
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				<button type="button" class="btn btn-primary" onclick="update()">确认修改</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<div class="modal fade" id="modifyrecoveryimport1" tabindex="-1"
	role="dialog" aria-labelledby="modifyrecoveryimport" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel1">修改奖金池</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="input-group col-xs-6 col-md-offset-3">
						<input id="paramId3" name="paramId3" type="hidden"
							class="form-control" placeholder="参数名称"> <input
							id="pValue3" name="pValue3" type="hidden" class="form-control"
							placeholder="参数名称"> <input id="pDesc3" name="pDesc3"
							type="hidden" class="form-control" placeholder="参数名称">
					</div>
					<div class="input-group col-xs-6 col-md-offset-3">
						<span class="input-group-addon" style="background-color: #1abc9c;">奖金池名称:</span>
						<input id="ppDesc3" name="ppDesc3" type="text"
							class="form-control" placeholder="奖金池名称">
					</div>
					<div class="input-group col-xs-6 col-md-offset-3">
						<span class="input-group-addon" style="background-color: #1abc9c;">奖金池额度:</span>
						<input id="ppValueint3" name="ppValueint3" type="text"
							class="form-control"  AUTOCOMPLETE="off"  placeholder="奖金池额度"
							onKeyUp="clearNoNum(event,this)" onBlur="checkNum(this)";">
					</div>
					<div class="input-group col-xs-6 col-md-offset-3">
						<span class="input-group-addon" style="background-color: #1abc9c;">+
							:</span> <input id="addval" name="addval" type="text"
							class="form-control" placeholder="新增额度"
							onKeyUp="clearNoNum(event,this)" onBlur="checkNum(this)";">
					</div>
					<div class="input-group col-xs-6 col-md-offset-3">
						<span class="input-group-addon" style="background-color: #1abc9c;">—:</span>
						<input id="cutval" name="cutval" type="text" class="form-control"
							placeholder="减少额度" onKeyUp="clearNoNum(event,this)"
							onBlur="checkNum(this)";">
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				<button type="button" class="btn btn-primary"
					onclick="update('p_ee')">确认修改</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>



<!-- /.modal -->
<!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
<script src="${ctx}/js/vendor/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${ctx}/js/vendor/video.js"></script>
<script src="${ctx}/js/flat-ui.min.js"></script>
<script type="text/javascript" src="${ctx}/js/dialog/lhgdialog.min.js"></script>
<script type="text/javascript">
	function clearNoNum(event,obj){ 
	    //响应鼠标事件，允许左右方向键移动 
	    event = window.event||event; 
	    if(event.keyCode == 37 | event.keyCode == 39){ 
	        return; 
	    } 
	    //先把非数字的都替换掉，除了数字和. 
	    obj.value = obj.value.replace(/[^\d.]/g,""); 
	    //必须保证第一个为数字而不是. 
	    obj.value = obj.value.replace(/^\./g,""); 
	    //保证只有出现一个.而没有多个. 
	    obj.value = obj.value.replace(/\.{2,}/g,"."); 
	    //保证.只出现一次，而不能出现两次以上 
	    obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$","."); 
	   
	} 
	function checkNum(obj){ 
	    //为了去除最后一个. 
	    obj.value = obj.value.replace(/\.$/g,""); 
	} 
	
	function deleted(paramId){
		var id = paramId;
// 		alert("dfdfd");
		var flag=false;
        $.dialog.confirm("您确定要执行操作吗？", function () {
        	   $.dialog.tips('执行确定操作');
        	   next(id);
//         	   alert(flag);
        }, function(){
            $.dialog.tips('执行取消操作');
            flag=false;
        });
	}
	function next(paramId){
		var id = paramId;
		$.ajax({
			url : '${ctx}/providerController/'+id+'/delQue.do',
			type : 'get',
				success : function(messageInfor) {
// 	 				alert(messageInfor);
					if(messageInfor!=null && messageInfor.length>0){
						for(var i= 0; i< messageInfor.length;i++){
							alert("已经有"+"'"+messageInfor[i].providerName+"'"+"关联当前奖金池");
						}
						alert("不能删除");
						return;
					}else{
						document.location.href = "${ctx}/sys/"+id+"/delete.do";
					}
					
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) {
	                alert(XMLHttpRequest.status);
	                alert(XMLHttpRequest.readyState);
	                alert(textStatus);
	            }
		})
	}
	function delcommit(paramId){
		var id = paramId;
// 		$.ajax({
// 			url: '${ctx}/sys/'+id+'/execl.do',
// 			type: 'get',
// 			success: function(messageRespon){
// 				alert("已导出");
// 			}
// 		})	
		window.location.href = '${ctx}/sys/'+id+'/execl';
	}
	function detail(paramId){
		var id = paramId;
		$("#tableGood tr:gt(0)").remove();
		$.ajax({
			url: '${ctx}/sys/'+id+'/showPrizePool.do',
			type: 'get',
			success: function(messageRespon){
				var vv = Math.pow(10,2);
// 				alert(messageRespon.length);
				var length=messageRespon.length;
				for (var i = 0; i <length; i++) {
					var tr = $("<tr></tr>");
					var j=i+1;
					var num = parseFloat(messageRespon[i].ppValue)-parseFloat(messageRespon[i].pRemark);
					var mun = parseFloat(messageRespon[i].pRemark)-parseFloat(messageRespon[i].ppValue);
					num = Math.round(num*vv)/vv;
					mun = Math.round(mun*vv)/vv;
					var td = $("<td>"+ j +"</td>"+ "<td>"+ messageRespon[i].ppDesc +
							"</td>"+"<td>"+ messageRespon[i].ppKey +"</td>"+ 
							"<td>"+ messageRespon[i].ppValue +"</td>"+ "<td>"+ mun  +
							"</td>" + "<td>"+ num+
							"</td>" + "<td>"+ messageRespon[i].pRemark +
							"</td>")
					tr.append(td);
					$("#tableGood").append(tr);
				}
			}
		})
	}
	
	function chenge(paramId,pValue) {
		
		var id = paramId;
		$("#ppDesc").val(paramId);
// 		alert(id);
		var pValue = pValue;
// 		alert(pValue);
		if(pValue=="GoodsUnit"){
			$("#modmyModalLabel").html("修改基本单位");
			modparm(id);
			$("#modpram").html("基本单位名称");
		}
		if(pValue=="GoodsType"){
			$("#modmyModalLabel").html("修改商品类型");
			modparm(id);
			$("#modpram").html("商品类型名称");
		}
		if(pValue=="PaymentType"){
			$("#modmyModalLabel").html("修改支付方式");
			modparm(id);
			$("#modpram").html("支付方式名称");
		}
		if(pValue=="IncomeType"){
			$("#modmyModalLabel").html("修改收款方式");
			modparm(id);
			$("#modpram").html("收款方式名称");
		}
		if(pValue=="CheckoutType"){
			$("#modmyModalLabel").html("修改结账方式");
			modparm(id);
			$("#modpram").html("结账方式名称");
		}
		if(pValue=="p_ee"){
			$("#modifyrecoveryimport1").modal(id);
			$.ajax({
				url : '${ctx}/sys/'+id+'/toUpdate.do',
				type : 'get',
					success : function(messageInfor) {
// 	 				alert(messageInfor.ppValueint);
						
// 						$("#ppDesc3").attr("value",messageInfor.ppDesc);
						$("#paramId3").attr("value",messageInfor.paramId);
						$("#pValue3").attr("value",messageInfor.pValue);
						$("#pDesc3").attr("value",messageInfor.pDesc);
						$("#ppDesc3").attr("value",messageInfor.ppDesc);
						$("#ppValueint3").val(messageInfor.ppValue);
					}
			})
		}
	}
	function modparm(paramId){
		var id = paramId;
// 		alert(id);
		$("#modifyrecoveryimport").modal(id);
		$.ajax({
			url : '${ctx}/sys/'+id+'/toUpdate.do',
			type : 'get',
				success : function(messageInfor) {
// 				alert(messageInfor.ppDesc);
					
					$("#ppDesc1").attr("value",messageInfor.ppDesc);
					$("#paramId1").attr("value",messageInfor.paramId);
					$("#pValue1").attr("value",messageInfor.pValue);
					$("#pDesc1").attr("value",messageInfor.pDesc);
					
				},
				
		})
	}
	
	
	function add(pValue) {
// 		alert(pValue);
		if(pValue=="PrizePool"){
			$("#addrecoveryimport1").modal();
			
			$("#myModalLabel2").html("新增奖金池");
			$("#pValue1").attr("value",pValue);
			$("#pDesc2").attr("value","奖金池");
// 			$("#ppDesc2").attr("value","百威奖金池");
// 			alert("dfdfd");
// 			return false;
		}
		if(pValue=="GoodsUnit"){
			$("#addrecoveryimport").modal();
			$("#addmyModalLabel").html("新增基本单位");
			$("#addpValue").attr("value",pValue);
			$("#addpDesc").attr("value","基本单位");
			$("#pram").html("基本单位名称");
		}
		if(pValue=="GoodsType"){
			$("#addrecoveryimport").modal();
			$("#addmyModalLabel").html("新增商品类型");
			$("#addpValue").attr("value",pValue);
			$("#addpDesc").attr("value","商品类型");
			$("#pram").html("商品类型名称");
		}
		if(pValue=="PaymentType"){
			$("#addrecoveryimport").modal();
			$("#addmyModalLabel").html("新增支付方式");
			$("#addpValue").attr("value",pValue);
			$("#addpDesc").attr("value","支付方式");
			$("#pram").html("支付方式名称");
		}
		if(pValue=="IncomeType"){
			$("#addrecoveryimport").modal();
			$("#addmyModalLabel").html("新增收款方式");
			$("#addpValue").attr("value",pValue);
			$("#addpDesc").attr("value","收款方式");
			$("#pram").html("收款方式名称");
		}
		if(pValue=="CheckoutType"){
			$("#addrecoveryimport").modal();
			$("#addmyModalLabel").html("新增结账方式");
			$("#addpValue").attr("value",pValue);
			$("#addpDesc").attr("value","结账方式");
			$("#pram").html("结账方式名称");
		}
// 		$("#addrecoveryimport").modal();
// 		$("#pValue").attr("value",pValue);
// 		$("#pDesc").attr("value",value);
// 		alert("fdf");
	}
	function addv(){
		if($("#ppDesc").val()==null){
			alert("请输入正确参数");
		}
	}
	function update(pValue){
// 		alert(pValue);
		
		var addval = $("#addval").val();
		if($("#addval").val()=="" || $("#addval").val().length==0){
			addval = 0;
		}
// 		alert(addval);
		var cutval = $("#cutval").val();
		if($("#cutval").val()=="" || $("#cutval").val().length==0){
			cutval = 0;
		}
// 		alert(cutval);
		var ppValueint3 = $("#ppValueint3").val();
		
		var finalval = parseFloat(ppValueint3)+parseFloat(addval)-parseFloat(cutval);
// 		alert(finalval);
		
// 		alert(parseInt(addval));
		if(pValue=="p_ee"){
			var obj = {
					ppDesc : $("#ppDesc3").val(),
					paramId : $("#paramId3").val(),
					pValue : $("#pValue3").val(),
					pDesc : $("#pDesc3").val(),
					ppValue : finalval,
					pKey : "SYS",
			};
			$.ajax({
				url : '${ctx}/sys/update.do',
				type : 'post',
				data : obj,
				success : function(messageInfor) {
					
//						var messageInfor = eval("(" + messageRespon + ")");
// 					alert(messageInfor.status);
					if (messageInfor.status) {
//							messageLabel.html("<div style='color:limegreen'>"
//									+ messageInfor.message + "</div>");
						document.location.href = "${ctx}/sys/show.do";
					} else {
						messageLabel.html("<div style='color:red'>"
								+ messageInfor.message + "</div>");
					}
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) {
	                alert(XMLHttpRequest.status);
	                alert(XMLHttpRequest.readyState);
	                alert(textStatus);
	            },
			})
			return false;
		}
		var obj = {
				ppDesc : $("#ppDesc1").val(),
				paramId : $("#paramId1").val(),
				pValue : $("#pValue12").val(),
				pDesc : $("#pDesc1").val(),
		};
		$.ajax({
			url : '${ctx}/sys/update.do',
			type : 'post',
			data : obj,
			success : function(messageInfor) {
				
//					var messageInfor = eval("(" + messageRespon + ")");
				if (messageInfor.status) {
//						messageLabel.html("<div style='color:limegreen'>"
//								+ messageInfor.message + "</div>");
					document.location.href = "${ctx}/sys/show.do";
				} else {
					messageLabel.html("<div style='color:red'>"
							+ messageInfor.message + "</div>");
				}
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            },
		})
	}
	
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
      $("#needsigninchk").change(function(){
        if ($("#needsigninchk").is(':checked')){
          $("#needsignindiv").show();
        }else{
          $("#needsignindiv").hide();
        };        
      });
      $("#needsigninmodifychk").change(function(){
        if ($("#needsigninmodifychk").is(':checked')){
          $("#needsigninmodifydiv").show();
        }else{
          $("#needsigninmodifydiv").hide();
        };        
      });    

    });
    </script>
</body>
</html>
