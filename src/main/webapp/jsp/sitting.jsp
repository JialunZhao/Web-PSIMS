<%@ include file="all.jsp"%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h3 class="page-header">系统设置管理</h3>
	<ul id="myTab" class="nav nav-tabs">
		<li class="active"><a href="#p_aa" data-toggle="tab">基本单位</a></li>
		<li><a href="#p_bb" data-toggle="tab">商品类型</a></li>
		<li><a href="#p_cc" data-toggle="tab">支付方式</a></li>
		<li><a href="#p_dd" data-toggle="tab">收款方式</a></li>
		<li><a href="#p_ee" data-toggle="tab">奖金池</a></li>
	</ul>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade in active" id="p_aa">
		<button type="button" class="btn btn-primary" onclick="add('GoodsUnit')">新增基本单位</button>
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
								<td>
									<a href="#" data-toggle="modal"
									onclick="chenge(${s.paramId})">修改</a>/ <a
									href="${s.paramId}/delete.do">删除</a></td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="tab-pane fade" id="p_bb">
		<button type="button" class="btn btn-primary" onclick="add('GoodsType')">新增商品类型</button>
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
								<td>
									<a href="#" data-toggle="modal"
									onclick="chenge(${s.paramId})">修改</a>/ <a
									href="${s.paramId}/delete.do">删除</a></td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="tab-pane fade" id="p_cc">
		<button type="button" class="btn btn-primary" onclick="add('PaymentType')">新增支付方式</button>
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
								<td>
									<a href="#" data-toggle="modal"
									onclick="chenge(${s.paramId})">修改</a>/ <a
									href="${s.paramId}/delete.do">删除</a></td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="tab-pane fade" id="p_dd">
		<button type="button" class="btn btn-primary" onclick="add('IncomeType')">新增收款方式</button>
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
								<td>
									<a href="#" data-toggle="modal"
									onclick="chenge(${s.paramId})">修改</a>/ <a
									href="${s.paramId}/delete.do">删除</a></td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="tab-pane fade" id="p_ee">
		<button type="button" class="btn btn-primary" onclick="add('PrizePool')">新增奖金池</button>
			<table class="table table-striped">
				<thead>
					<tr>
						<th class="chk" style="display: none"><input type="checkbox"
							aria-label="..."></th>
						<th>编号</th>
<!-- 						<th>奖金池公司</th> -->
						<th>奖金池额度</th>
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
<%-- 								<td><c:out value="${s.ppDesc}" /></td> --%>
								<td><c:out value="${s.ppValueint}" /></td>
								<td>
									<a href="#" data-toggle="modal" ="chenge(${s.paramId},'p_ee')">修改</a>/ <a
									href="#" onclick="deleted(${s.paramId})">删除</a></td>
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
				<h4 class="modal-title" id="myModalLabel">新增系统参数</h4>
			</div>
			<form id="formA" action="${ctx}/sys/add.do" method="post">
				<div class="modal-body">
					<div class="row">
						<div class="input-group col-xs-6 col-md-offset-3">
							<input type="hidden" name="pValue" id="pValue" >
							<input type="hidden" name="pDesc" id="pDesc" >
							<span class="input-group-addon"
								style="background-color: #1abc9c;">参数名称:</span> <input id="ppDesc"
								name="ppDesc" type="text" class="form-control"
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
			<form id="formA" action="${ctx}/sys/add.do" method="post">
				<div class="modal-body">
					<div class="row">
						<div class="input-group col-xs-6 col-md-offset-3">
							<input type="hidden" name="pValue" id="pValue1" >
							<input type="hidden" name="pDesc" id="pDesc2" >
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">奖金池额度:</span> <input id="ppValueint2"
								name="ppValueint" type="text" class="form-control"
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
				<h4 class="modal-title" id="myModalLabel">修改系统参数</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="input-group col-xs-6 col-md-offset-3">
						<span class="input-group-addon" style="background-color: #1abc9c;">参数名称:</span>
						<input id="ppDesc1" name="ppDesc1" type="text"
							class="form-control" placeholder="参数名称"> <input
							id="paramId1" name="paramId1" type="hidden" class="form-control"
							placeholder="参数名称"> <input id="pValue1" name="pValue1"
							type="hidden" class="form-control" placeholder="参数名称"> <input
							id="pDesc1" name="pDesc1" type="hidden" class="form-control"
							placeholder="参数名称">
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				<button type="submit" class="btn btn-primary" onclick="update()">确认修改</button>
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
				<h4 class="modal-title" id="myModalLabel1">修改系统参数</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="input-group col-xs-6 col-md-offset-3">
						<input
							id="paramId3" name="paramId3" type="hidden" class="form-control"
							placeholder="参数名称"> <input id="pValue3" name="pValue3"
							type="hidden" class="form-control" placeholder="参数名称"> <input
							id="pDesc3" name="pDesc3" type="hidden" class="form-control"
							placeholder="参数名称">
					</div>
					<div class="input-group col-xs-6 col-md-offset-3">
						<span class="input-group-addon" style="background-color: #1abc9c;">奖金池额度:</span>
						<input id="ppValueint3" name="ppValueint3" type="text"
							class="form-control" placeholder="奖金池额度"> 
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				<button type="submit" class="btn btn-primary" onclick="update('p_ee')">确认修改</button>
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
<script type="text/javascript">
	function deleted(paramId){
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
	function chenge(paramId,pValue) {
		
		var id = paramId;
		$("#ppDesc").val(paramId);
// 		alert(id);
		var pValue = pValue;
// 		alert(pValue);
		if(pValue=="p_ee"){
			$("#modifyrecoveryimport1").modal(id);
			$.ajax({
				url : '${ctx}/sys/'+id+'/toUpdate.do',
				type : 'get',
					success : function(messageInfor) {
// 	 				alert(messageInfor.ppValueint);
						
						$("#ppDesc3").attr("value",messageInfor.ppDesc);
						$("#paramId3").attr("value",messageInfor.paramId);
						$("#pValue3").attr("value",messageInfor.pValue);
						$("#pDesc3").attr("value",messageInfor.pDesc);
						$("#ppValueint3").attr("value",messageInfor.ppValueint);
						
					}
			})
			return false;
		}
		
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
			$("#pDesc2").attr("value","商品类型");
// 			$("#pValue1").attr("value",pValue);
// 			alert("dfdfd");
			return false;
		}
		if(pValue=="GoodsUnit"){
			$("#addrecoveryimport").modal();
			$("#myModalLabel").html("新增基本单位");
			$("#pValue").attr("value",pValue);
			$("#pDesc").attr("value","基本单位");
		}
		if(pValue=="GoodsType"){
			$("#addrecoveryimport").modal();
			$("#myModalLabel").html("新增商品类型");
			$("#pValue").attr("value",pValue);
			$("#pDesc").attr("value","商品类型");
		}
		if(pValue=="PaymentType"){
			$("#addrecoveryimport").modal();
			$("#myModalLabel").html("新增支付方式");
			$("#pValue").attr("value",pValue);
			$("#pDesc").attr("value","支付方式");
		}
		if(pValue=="IncomeType"){
			$("#addrecoveryimport").modal();
			$("#myModalLabel").html("新增收款方式");
			$("#pValue").attr("value",pValue);
			$("#pDesc").attr("value","收款方式");
		}
		$("#addrecoveryimport").modal();
		$("#pValue").attr("value",pValue);
		$("#pDesc").attr("value",value);
// 		alert("fdf");
	}
	function addv(){
		if($("#ppDesc").val()!=null || !$("#ppDesc").val().length()>0){
			alert("请输入正确参数");
		}
	}
	function update(pValue){
// 		alert(pValue);
		if(pValue=="p_ee"){
			var obj = {
					ppDesc : $("#ppDesc3").val(),
					paramId : $("#paramId3").val(),
					pValue : $("#pValue3").val(),
					pDesc : $("#pDesc3").val(),
					ppValueint : $("#ppValueint3").val()
			};
			$.ajax({
				url : '${ctx}/sys/update.do',
				type : 'post',
				data : obj,
				success : function(messageInfor) {
					
//						var messageInfor = eval("(" + messageRespon + ")");
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
				pValue : $("#pValue1").val(),
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
