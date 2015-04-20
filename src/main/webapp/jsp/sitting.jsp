<%@ include file="all.jsp"%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h3 class="page-header">系统设置管理</h3>
	<ul id="myTab" class="nav nav-tabs">
		<li class="active"><a href="#p_aa" data-toggle="tab">基本单位</a></li>
		<li><a href="#p_bb" data-toggle="tab">回收类型</a></li>
		<li><a href="#p_cc" data-toggle="tab">支付方式</a></li>
		<li><a href="#p_dd" data-toggle="tab">收款方式</a></li>
		<li><a href="#p_ee" data-toggle="tab">奖金池</a></li>
	</ul>
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade in active" id="p_aa">
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
					<c:forEach items="${sitting}" var="s" step="1">
						<c:if test="${s.pKey == 'p_aa' }">
							<tr>
								<td class="chk" style="display: none"><input
									type="checkbox" aria-label="..."></td>
								<td><c:out value="${s.paramId}" /></td>
								<td><c:out value="${s.ppDesc}" /></td>
								<td><a href="#" data-toggle="modal"
									onclick="add(${s.pKey})">新增</a>/
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
			<table class="table table-striped">
				<thead>
					<tr>
						<th class="chk" style="display: none"><input type="checkbox"
							aria-label="..."></th>
						<th>编号</th>
						<th>回收类型名称</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${sitting}" var="s" step="1">
						<c:if test="${s.pKey == 'p_bb' }">
							<tr>
								<td class="chk" style="display: none"><input
									type="checkbox" aria-label="..."></td>
								<td><c:out value="${s.paramId}" /></td>
								<td><c:out value="${s.ppDesc}" /></td>
								<td><a href="#" data-toggle="modal"
									onclick="add(${s.pKey})">新增</a>/
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
					<c:forEach items="${sitting}" var="s" step="1">
						<c:if test="${s.pKey == 'p_cc' }">
							<tr>
								<td class="chk" style="display: none"><input
									type="checkbox" aria-label="..."></td>
								<td><c:out value="${s.paramId}" /></td>
								<td><c:out value="${s.ppDesc}" /></td>
								<td><a href="#" data-toggle="modal"
									onclick="add(${s.pKey})">新增</a>/
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
					<c:forEach items="${sitting}" var="s" step="1">
						<c:if test="${s.pKey == 'p_dd' }">
							<tr>
								<td class="chk" style="display: none"><input
									type="checkbox" aria-label="..."></td>
								<td><c:out value="${s.paramId}" /></td>
								<td><c:out value="${s.ppDesc}" /></td>
								<td><a href="#" data-toggle="modal"
									onclick="add(${s.pKey})">新增</a>/
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
		</div>
		
	</div>

</div>
</div>
</div>

<!--

//-->
</script>

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
							<input type="hidden" name="pKey" id="pKey" >
							<span class="input-group-addon"
								style="background-color: #1abc9c;">参数名称:</span> <input id="ppDesc"
								name="ppDesc" type="text" class="form-control"
								placeholder="参数名称" value="">
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
							placeholder="参数名称"> <input id="pKey1" name="pKey1"
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



<!-- /.modal -->
<!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
<script src="${ctx}/js/vendor/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${ctx}/js/vendor/video.js"></script>
<script src="${ctx}/js/flat-ui.min.js"></script>
<script type="text/javascript">
	function chenge(paramId) {
		
		var id = paramId;
		$("#ppDesc").val(paramId);
		alert(id);
		
		$("#modifyrecoveryimport").modal(id);
		$.ajax({
			url : '${ctx}/sys/'+id+'/toUpdate.do',
			type : 'get',
				success : function(messageInfor) {
// 				alert(messageInfor.ppDesc);
					
					$("#ppDesc1").attr("value",messageInfor.ppDesc);
					$("#paramId1").attr("value",messageInfor.paramId);
					$("#pKey1").attr("value",messageInfor.pKey);
					$("#pDesc1").attr("value",messageInfor.pDesc);
					
				}
		})
	}
	function add(pKey) {
// 		alert("dfd");
		var id = pKey;
		$("#pKey").value=pKey;
		$("#addrecoveryimport").modal(pKey);
		alert(pKey);
	}
	function update(){
		var obj = {
				ppDesc : $("#ppDesc1").val(),
				paramId : $("#paramId1").val(),
				pKey : $("#pKey1").val(),
				pDesc : $("#pDesc1").val()
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
