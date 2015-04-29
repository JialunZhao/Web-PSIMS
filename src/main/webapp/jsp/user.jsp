<%@ include file="all.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://psims.ai.com/" prefix="priv" %>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h3 class="page-header">员工权限管理</h3>

				<div class="row placeholders">
					<form class="form-inline" id="form1" action="${ctx}/user/seek.do" method="post">
						<div class="form-group">
							<label for="exampleInputName2">员工名称：</label> <input type="text" name="employeeName1"
								class="form-control" id="exampleInputName2"
								placeholder="员工名称">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail2">员工性别：</label> <select name="sex1"
								class="form-control" value="员工性别" tabindex="1" name="herolist">
								<option value="">请选择员工性别</option>
								<option value="1">男</option>
								<option value="2">女</option>
							</select>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail2">部门职务：</label> <select name="role1"
								class="form-control" value="员工类型" tabindex="1" name="herolist">
								<option value="">请选择员工类型</option>
								<option value="1">销售</option>
								<option value="2">管理</option>
								<option value="3">财务</option>
								<option value="4">物流</option>
								<option value="5">其它</option>
							</select>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail2">员工联系电话：</label> <input name="contactTel1"
								type="text" class="form-control" id="exampleInputEmail2"
								placeholder="员工联系电话">
						</div>
						<button type="submit" class="btn btn-primary">搜索</button>
					</form>
				</div>

				<div class="row placeholders ">
					<div class="col-sm-5">
						<priv:privilege power="员工权限.增删改">
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#addrecoveryimport">新增员工</button>
							</priv:privilege>
							<priv:privilege power="员工权限.增删改">
						<button type="button" id="delbtn" class="btn btn-primary">批量删除员工</button>
						</priv:privilege>
						<button type="button" id="delcommit" class="btn btn-primary"
							style="display: none">确认删除员工</button>
						<button type="button" id="delcancle" class="btn btn-primary"
							style="display: none">取消</button>
					</div>
				</div>

				<h4 class="sub-header">员工清单</h4>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th class="chk" style="display: none"><input
									type="checkbox" aria-label="..."></th>
								<th>编号</th>
								<th>员工名称</th>
								<th>登录账号</th>
								<th>部门职务</th>
								<th>联系电话</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:set value="0" var="seq"></c:set>
							<c:forEach items="${user}" var="u" >
								<c:set value="${seq + 1}" var="seq"></c:set>
								<tr>
								<th class="chk" style="display: none"><input
									type="checkbox" aria-label="..."></th>
									<td><c:out value="${seq}" /></td>
									<td><c:out value="${u.employeeName}" /></td>
									<td><c:out value="${u.employeeCode}" /></td>
									<td>
										<c:if test="${u.role==1}">
											<c:out value="销售" />
										</c:if>
										<c:if test="${u.role==2}">
											<c:out value="管理" />
										</c:if>
										<c:if test="${u.role==3}">
											<c:out value="财务" />
										</c:if>
										<c:if test="${u.role==4}">
											<c:out value="物流" />
										</c:if>
										<c:if test="${u.role==5}">
											<c:out value="其它" />
										</c:if>
									</td>
									<td><c:out value="${u.contactTel}" /></td>
									<td>
										<priv:privilege power="员工权限.增删改">
										<a href="#" data-toggle="modal" onclick="chenge(${u.employeeId})">修改</a>/
										<a href="${u.employeeId}/delete.do">删除</a>
										</priv:privilege>
									</td>
								</tr>

							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>


	<!-- 模态框（Modal） -->
	<!-- 添加回收物入库模态框（Modal） -->
	<div class="modal fade" id="addrecoveryimport" tabindex="-1"
		role="dialog" aria-labelledby="addrecoveryimport" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">新增员工</h4>
				</div>
				<form id="formA" action="${ctx}/user/add.do" method="post">
				<div class="modal-body">
					<div class="row">
						<input id="employeeId" type="hidden" value="1">
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">员工名称:</span> <input id="employeeName"
								name="employeeName" type="text" class="form-control" placeholder="员工名称">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">员工性别:</span> <select id="sex"
								class="form-control" value="请选择员工性别：" tabindex="1"
								name="sex">
								<option value="0">请选择员工性别</option>
								<option value="1">男</option>
								<option value="2">女</option>
							</select>
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">员工部门职务:</span> <select id="role"
								class="form-control" value="请选择员工部门职务：" tabindex="1"
								name="role">
								<option value="0">请选择员工部门职务：</option>
								<option value="1">销售</option>
								<option value="2">管理</option>
								<option value="3">财务</option>
								<option value="4">物流</option>
								<option value="5">其它</option>
							</select>
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">员工联系电话：</span> <input id="contactTel"
								name="contactTel" type="text" class="form-control" placeholder="员工联系电话">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">员工联系地址:</span> <input id="contactAddr"
								name="contactAddr" type="text" class="form-control" placeholder="员工联系地址">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">员工身份证号码:</span> <input  id="employeeCode111"
								name="employeeCode111" type="text" class="form-control" placeholder="员工身份证号码">
						</div>
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">备注：</span> <input type="text" id="remark"
								name="remark" class="form-control" placeholder="备注：">
						</div>
					</div>
					<span id="errorcontent" class="input-group col-xs-6 col-md-offset-3"></span>
					<div class="row ">
						<div class="col-xs-10 col-xs-offset-2 text-left">
							<div>
								是否登录系统 <input type="checkbox" id="needsigninchk"
									aria-label="...">
							</div>
						</div>
					</div>
					<div class="row" id="needsignindiv" style="display: none">
						<div class="input-group col-xs-6 col-md-offset-3">
		                	<span class="input-group-addon" style="background-color: #1abc9c;">登录账号:</span>
		                	<input   id="employeeCode" name="employeeCode" type="text" class="form-control" placeholder="登录账号">
		              	</div>
						
						<div class="input-group col-xs-6 col-md-offset-3">
							<span class="input-group-addon"
								style="background-color: #1abc9c;">登录密码:</span> <input id="loginPassword" 
								name="loginPassword" type="password" class="form-control" placeholder="登录密码">
						</div>
						<div class="table-responsive col-xs-10 col-xs-offset-1">
							<table class="table text-center">
								<thead class="text-left">
									<tr class="text-left">
										<th>模块名称</th>
										<th>查询权限 <input id="checkAll2" type="checkbox" aria-label="..."></th>
										<th>新增修改权限 <input id="checkAll3" type="checkbox" aria-label="..."></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td class="text-left">系统设置</td>
										<td><input name='privilegeMen'  value="系统设置.显示菜单" type="checkbox" aria-label="..."></td>
										<td><input name='privilegeBut'  value="系统设置.增删改" type="checkbox" aria-label="..."></td>
									</tr>
									<tr>
										<td class="text-left">员工权限</td>
										<td><input name='privilegeMen' value="员工权限.显示菜单" type="checkbox" aria-label="..."></td>
										<td><input name='privilegeBut' value="员工权限.增删改" type="checkbox" aria-label="..."></td>
									</tr>
									<tr>
										<td class="text-left">客户管理</td>
										<td><input name='privilegeMen' value="客户管理.显示菜单" type="checkbox" aria-label="..."></td>
										<td><input name='privilegeBut' value="客户管理.增删改" type="checkbox" aria-label="..."></td>
									</tr>
									<tr>
										<td class="text-left">供应商</td>
										<td><input name='privilegeMen' value="供应商.显示菜单" type="checkbox" aria-label="..."></td>
										<td><input name='privilegeBut' value="供应商.增删改" type="checkbox" aria-label="..."></td>
									</tr>
									<tr>
										<td class="text-left">商品管理</td>
										<td><input name='privilegeMen' value="商品管理.显示菜单" type="checkbox" aria-label="..."></td>
										<td><input name='privilegeBut' value="商品管理.增删改" type="checkbox" aria-label="..."></td>
									</tr>
									<tr>
										<td class="text-left">仓库管理</td>
										<td><input name='privilegeMen' value="仓库管理.显示菜单" type="checkbox" aria-label="..."></td>
										<td><input name='privilegeBut' value="仓库管理.增删改" type="checkbox" aria-label="..."></td>
									</tr>
									<tr>
										<td class="text-left">货品入库下单</td>
										<td><input name='privilegeMen' value="货品入库下单.显示菜单" type="checkbox" aria-label="..."></td>
										<td><input name='privilegeBut' value="货品入库下单.增删改" type="checkbox" aria-label="..."></td>
									</tr>
									<tr>
										<td class="text-left">货品入库</td>
										<td><input name='privilegeMen' value="货品入库.显示菜单" type="checkbox" aria-label="..."></td>
										<td><input name='privilegeBut' value="货品入库.增删改" type="checkbox" aria-label="..."></td>
									</tr>
									<tr>
										<td class="text-left">销售出库</td>
										<td><input name='privilegeMen' value="销售出库.显示菜单" type="checkbox" aria-label="..."></td>
										<td><input name='privilegeBut' value="销售出库.增删改" type="checkbox" aria-label="..."></td>
									</tr>
									<tr>
										<td class="text-left">供应商退货</td>
										<td><input name='privilegeMen' value="供应商退货.显示菜单" type="checkbox" aria-label="..."></td>
										<td><input name='privilegeBut' value="供应商退货.增删改" type="checkbox" aria-label="..."></td>
									</tr>
									<tr>
										<td class="text-left">客户退货</td>
										<td><input name='privilegeMen' value="客户退货.显示菜单" type="checkbox" aria-label="..."></td>
										<td><input name='privilegeBut' value="客户退货.增删改" type="checkbox" aria-label="..."></td>
									</tr>
									<tr>
										<td class="text-left">统计报表</td>
										<td><input name='privilegeMen' value="统计报表.显示菜单" type="checkbox" aria-label="..."></td>
										<td><input name='privilegeBut' value="统计报表.增删改" type="checkbox" aria-label="..."></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" id='submitFom1' class="btn btn-primary">确认新增</button>
				</div>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->


	<!-- 模态框（Modal） -->
    <!-- 修改回收物模态框（Modal） -->
    <div class="modal fade" id="modifyrecoveryimport" tabindex="-1" role="dialog" 
       aria-labelledby="modifyrecoveryimport" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="myModalLabel">修改员工信息</h4>
          </div>
          <div class="modal-body">
            <div class="row">
            <input type="hidden" value="" id="employeeId1"/>
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">员工名称:</span>
                <input id="employeeName1"type="text" class="form-control" placeholder="员工名称" value="">
              </div>
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">员工性别:</span>
                <select id="sex1" class="form-control" value="" tabindex="1" name="herolist">
                  <option value="0">请选择员工性别</option>
                  <option value="1">男</option>
                  <option value="2">女</option>
                </select>
              </div>                 
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">员工部门职务:</span>
                <select id="role1" class="form-control" value="" tabindex="1" name="herolist">
                  <option value="0">请选择员工部门职务：</option>
                  <option value="1">销售</option>
                  <option value="2">管理</option>
                  <option value="3">财务</option>
                  <option value="4">物流</option>
                  <option value="5">其它</option>
                </select>
              </div>           
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">员工联系电话：</span>
                <input id="contactTel1" type="text" class="form-control" placeholder="员工联系电话" value="">
              </div>           
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">员工联系地址:</span>
                <input id="contactAddr1" type="text" class="form-control" placeholder="员工联系地址" value="">
              </div>
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">员工身份证号码:</span>
                <input id="employeeCode11" type="text" class="form-control" placeholder="员工身份证号码" value="">
              </div>
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">备注：</span>
                <input id="remark1" type="text" class="form-control" placeholder="备注：" value="">
              </div>
            </div>
            <div class="row ">
              <div class="col-xs-10 col-xs-offset-2 text-left">
                <div>
                是否登录系统 <input type="checkbox" id="needsigninmodifychk" name='needsigninmodifychk' checked aria-label="...">
                </div>
              </div>
            </div>
            <div class="row" id="needsigninmodifydiv" >
              <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon"  style="background-color: #1abc9c;">登录账号:</span>
                <input id="employeeCode1"  disabled="disabled" type="text" class="form-control" placeholder="登录用户名" value="">
              </div>             <div class="input-group col-xs-6 col-md-offset-3">
                <span class="input-group-addon" style="background-color: #1abc9c;">登录密码:</span>
                <input id="loginPassword1" type="password" class="form-control" placeholder="登录密码" value="******">
              </div>
              <div class="table-responsive col-xs-10 col-xs-offset-1">
                <table class="table text-center">
                  <thead class="text-left">
                    <tr class="text-left">
                      <th>模块名称</th>
                      <th>查询权限 <input id="checkAll" type="checkbox" aria-label="..."></th>
                      <th>新增修改权限 <input id="checkAll1" type="checkbox" aria-label="..."></th>
                    </tr>
                  </thead>
                  <tbody>
                   <tr>
										<td class="text-left">系统设置</td>
										<td><input name='privilegeMenEdit'  value="系统设置.显示菜单" type="checkbox" aria-label="..."></td>
										<td><input name='privilegeButEdit'  value="系统设置.增删改" type="checkbox" aria-label="..."></td>
									</tr>
									<tr>
										<td class="text-left">员工权限</td>
										<td><input name='privilegeMenEdit' value="员工权限.显示菜单" type="checkbox" aria-label="..."></td>
										<td><input name='privilegeButEdit' value="员工权限.增删改" type="checkbox" aria-label="..."></td>
									</tr>
									<tr>
										<td class="text-left">客户管理</td>
										<td><input name='privilegeMenEdit' value="客户管理.显示菜单" type="checkbox" aria-label="..."></td>
										<td><input name='privilegeButEdit' value="客户管理.增删改" type="checkbox" aria-label="..."></td>
									</tr>
									<tr>
										<td class="text-left">供应商</td>
										<td><input name='privilegeMenEdit' value="供应商.显示菜单" type="checkbox" aria-label="..."></td>
										<td><input name='privilegeButEdit' value="供应商.增删改" type="checkbox" aria-label="..."></td>
									</tr>
									<tr>
										<td class="text-left">商品管理</td>
										<td><input name='privilegeMenEdit' value="商品管理.显示菜单" type="checkbox" aria-label="..."></td>
										<td><input name='privilegeButEdit' value="商品管理.增删改" type="checkbox" aria-label="..."></td>
									</tr>
									<tr>
										<td class="text-left">仓库管理</td>
										<td><input name='privilegeMenEdit' value="仓库管理.显示菜单" type="checkbox" aria-label="..."></td>
										<td><input name='privilegeButEdit' value="仓库管理.增删改" type="checkbox" aria-label="..."></td>
									</tr>
									<tr>
										<td class="text-left">货品入库下单</td>
										<td><input name='privilegeMenEdit' value="货品入库下单.显示菜单" type="checkbox" aria-label="..."></td>
										<td><input name='privilegeButEdit' value="货品入库下单.增删改" type="checkbox" aria-label="..."></td>
									</tr>
									<tr>
										<td class="text-left">货品入库</td>
										<td><input name='privilegeMenEdit' value="货品入库.显示菜单" type="checkbox" aria-label="..."></td>
										<td><input name='privilegeButEdit' value="货品入库.增删改" type="checkbox" aria-label="..."></td>
									</tr>
									<tr>
										<td class="text-left">销售出库</td>
										<td><input name='privilegeMenEdit' value="销售出库.显示菜单" type="checkbox" aria-label="..."></td>
										<td><input name='privilegeButEdit' value="销售出库.增删改" type="checkbox" aria-label="..."></td>
									</tr>
									<tr>
										<td class="text-left">供应商退货</td>
										<td><input name='privilegeMenEdit' value="供应商退货.显示菜单" type="checkbox" aria-label="..."></td>
										<td><input name='privilegeButEdit' value="供应商退货.增删改" type="checkbox" aria-label="..."></td>
									</tr>
									<tr>
										<td class="text-left">客户退货</td>
										<td><input name='privilegeMenEdit' value="客户退货.显示菜单" type="checkbox" aria-label="..."></td>
										<td><input name='privilegeButEdit' value="客户退货.增删改" type="checkbox" aria-label="..."></td>
									</tr>
									<tr>
										<td class="text-left">统计报表</td>
										<td><input name='privilegeMenEdit' value="统计报表.显示菜单" type="checkbox" aria-label="..."></td>
										<td><input name='privilegeButEdit' value="统计报表.增删改" type="checkbox" aria-label="..."></td>
									</tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button type="button" class="btn btn-primary" onclick="update()">确认修改</button>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
	<!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
	<script src="${ctx}/js/vendor/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${ctx}/js/vendor/video.js"></script>
	<script src="${ctx}/js/flat-ui.min.js"></script>
	
	<script type="text/javascript">
		$(function() {
	        $("#checkAll").click(function() {
	             $('input[name="subBox"]').attr("checked",this.checked); 
	         });
	         var $subBox = $("input[name='subBox']");
	         $subBox.click(function(){
	             $("#checkAll").attr("checked",$subBox.length == $("input[name='subBox']:checked").length ? true : false);
	         });
	        $("#checkAll1").click(function() {
	             $('input[name="subBox1"]').attr("checked",this.checked); 
	         });
	         var $subBox = $("input[name='subBox1']");
	         $subBox.click(function(){
	             $("#checkAll1").attr("checked",$subBox.length == $("input[name='subBox1']:checked").length ? true : false);
	         });
	        $("#checkAll3").click(function() {
	             $('input[name="subBox3"]').attr("checked",this.checked); 
	         });
	         var $subBox = $("input[name='subBox3']");
	         $subBox.click(function(){
	             $("#checkAll3").attr("checked",$subBox.length == $("input[name='subBox3']:checked").length ? true : false);
	         });
	        $("#checkAll2").click(function() {
	             $('input[name="subBox2"]').attr("checked",this.checked); 
	         });
	         var $subBox = $("input[name='subBox2']");
	         $subBox.click(function(){
	             $("#checkAll3").attr("checked",$subBox.length == $("input[name='subBox2']:checked").length ? true : false);
	         });
	     });
		function chenge(employeeId) {
			
			var id = employeeId;
			$("#employeeId1").val(employeeId);
			$("#modifyrecoveryimport").modal(id);
// 			alert(id);
// 			$("#modifyrecoveryimport").on("shown.bs.modal",function(e){
// 				$(this).removeData();
// // 				alert("fdfd");
// 			});
			
	//			var modifyrecoveryimport = $("#modifyrecoveryimport");
				$.ajax({
					url : '${ctx}/user/'+id+'/toUpdate.do',
					type : 'get',
						success : function(messageInfor) {
// 							var messageInfor = eval("("+employeeMessage+")");
							$("#employeeName1").attr("value",messageInfor.employeeName);
							if(messageInfor.sex==1){
								$("#sex1").find("option[value='1']").attr("selected",true);
							}else if(messageInfor.sex==2){
								$("#sex1").find("option[value='2']").attr("selected",true);
							}
							if(messageInfor.role==0){
								$("#role1").find("option[value='0']").attr("selected",true);
							}else if(messageInfor.role==1){
								$("#role1").find("option[value='1']").attr("selected",true);
							}else if(messageInfor.role==2){
								$("#role1").find("option[value='2']").attr("selected",true);
							}else if(messageInfor.role==3){
								$("#role1").find("option[value='3']").attr("selected",true);
							}else if(messageInfor.role==4){
								$("#role1").find("option[value='4']").attr("selected",true);
							}else if(messageInfor.role==5){
								$("#role1").find("option[value='5']").attr("selected",true);
							}	
							
							$("#contactTel1").attr("value",messageInfor.contactTel);
							$("#contactAddr1").attr("value",messageInfor.contactAddr);
							$("#employeeCode1").attr("value",messageInfor.employeeCode);
							$("#remark1").attr("value",messageInfor.remark);
							$("#employeeCode1").attr("value",messageInfor.employeeCode);
							$("#loginPassword1").attr("value",messageInfor.loginPassword);
						}
				});
				$("input[name='privilegeButEdit']").each(function(index,event){
							$(event).prop("checked",false);
				});
				$("input[name='privilegeMenEdit']").each(function(index,event){
							$(event).prop("checked",false);
				});
				$.post("${ctx}/user/getPriv.do",{userId:id},function(resp){
					psims = "";
					if(resp==null||resp==''){
						psims = resp.id;
					}else{
						var priv = resp.privilege;
						if(priv!=null&&priv!=''){
						var priArray = priv.split(",");
						$("input[name='privilegeButEdit']").each(function(index,event){
							var value = $(event).val();
							for(var i = 0 ; i < priArray.length ; i++){
								if(priArray[i]==value){
									$(event).prop("checked",true);
								}
							}
						});
						$("input[name='privilegeMenEdit']").each(function(index,event){
							var value = $(event).val();
							for(var i = 0 ; i < priArray.length ; i++){
								if(priArray[i]==value){
									$(event).prop("checked",true);
								}
							}
						});
						psims = resp.id;
					}
					}
				});
			
		}
		function update(){
			var	sex = $("#sex1").val();
			var obj = {
				employeeId:$("#employeeId1").val(),
				employeeName : $("#employeeName1").val(),
				sex : $("#sex1").val(),
				role : $("#role1").val(),
				contactTel : $("#contactTel1").val(),
				contactAddr : $("#contactAddr1").val(),
				remark : $("#remark1").val(),
				employeeCode : $("#employeeCode1").val(),
				loginPassword : $("#loginPassword1").val()
			};
			if($("#needsigninmodifychk").prop("checked")){
				obj.needsigninmodifychk = "true";
			}else{
				obj.needsigninmodifychk = "false";
			}
			var privilege = "";
			var privilegeButEditLength = $("input[name='privilegeButEdit']").length;
			$("input[name='privilegeButEdit']").each(function(index,event){
				if($(event).prop("checked")){
					var value = $(event).val();
					if(index==privilegeButEditLength-1){
						privilege += value;
					}else{
						privilege += value+",";
					}
				}
			});
			var privilegeMenEditLength = $("input[name='privilegeMenEdit']").length;
			$("input[name='privilegeMenEdit']").each(function(index,event){
				if(privilege!=null&&privilege!=''){
					privilege += ",";
				}
				if($(event).prop("checked")){
					var value = $(event).val();
					if(privilegeMenEditLength-1==index){
						privilege += value;
					}else{
						privilege += value+",";
					}
				}
			});
			obj.privilege = privilege;
			obj.privId = psims;
			$.ajax({
				url : '${ctx}/user/update.do',
				type : 'post',
				//                dataType: 'json',
				//                contentType:'application/json',
				data : obj,
				success : function(messageInfor) {
					
// 					var messageInfor = eval("(" + messageRespon + ")");
					if (messageInfor.status) {
// 						messageLabel.html("<div style='color:limegreen'>"
// 								+ messageInfor.message + "</div>");
						document.location.href = "${ctx}/user/show.do";
					} else {
						messageLabel.html("<div style='color:red'>"
								+ messageInfor.message + "</div>");
					}
					psims = "";
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.status);
                    alert(XMLHttpRequest.readyState);
                    alert(textStatus);
                    psims = "";
                },
			})
		}
		
		$(document).ready(function() {
			
			
			$("#checkAll2").click(function(event){
				if($(event.currentTarget).prop("checked")){
					$("input[name='privilegeMen']").prop("checked",true);
				}else{
					$("input[name='privilegeMen']").prop("checked",false);
				}
			});
			$("#checkAll3").click(function(){
				if($(event.currentTarget).prop("checked")){
					$("input[name='privilegeBut']").prop("checked",true);
				}else{
					$("input[name='privilegeBut']").prop("checked",false);
				}
			});
			$("#checkAll").click(function(event){
				if($(event.currentTarget).prop("checked")){
					$("input[name='privilegeMenEdit']").prop("checked",true);
				}else{
					$("input[name='privilegeMenEdit']").prop("checked",false);
				}
			});
			$("#checkAll1").click(function(){
				if($(event.currentTarget).prop("checked")){
					$("input[name='privilegeButEdit']").prop("checked",true);
				}else{
					$("input[name='privilegeButEdit']").prop("checked",false);
				}
			});
			
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
			$("#needsigninchk").change(function() {
				if ($("#needsigninchk").is(':checked')) {
					$("#needsignindiv").show();
				} else {
					$("#needsignindiv").hide();
				}
				;
			});
			$("#needsigninmodifychk").change(function() {
				if ($("#needsigninmodifychk").is(':checked')) {
					$("#needsigninmodifydiv").show();
				} else {
					$("#needsigninmodifydiv").hide();
				}
				;
			});
			
			$("#submitFom1").click(function(){
				if($("#needsigninchk").prop("checked")){
					if($("#employeeCode").val()==''){
						alert("用户名不能为空");
						return;
					}
					$.post("${ctx}/user/check.do",{name:$("#employeeCode").val()},function(resp){
						if(resp==false){
							alert("登录名已存在");
						}else{
							$("#formA").submit();
						}
					});
				}else{
					$("#formA").submit();
				}
			});

		});
	</script>
</body>
</html>
