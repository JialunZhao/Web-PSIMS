//新增客户 
//1.提交数据
$("#addStorehouseSubmit").click(function addStorehouseSubmit() {
	$.ajax({
		type : 'POST',
		async : true,
		url : 'addStorehouse.do',
		data : $('#addStorehouseForm').serialize(),
		// data : {
		// 'customer_name' : customer_name,
		// 'customer_type' : customer_type,
		// 'contact_name' : contact_name,
		// 'contact_tel' : contact_tel,
		// 'contact_addr' : contact_addr,
		// 'email' : email,
		// 'area' : area,
		// 'remark' : remark
		// },
		success : function(data) {
			$('#addStorehouse').modal('hide');
			window.location.href = "storehouse";
		},
	});
});
// 2.刷新列表

// 删除客户信息
function delCurrentStorehouse(obj) {
	// console.dir(obj);
	// 获取选中行的id
	var storehouseId = $(obj).parent().parent().children("td").get(1).innerHTML;
	$.ajax({
		type : 'POST',
		async : true,
		url : 'deleteStorehouse.do',
		// data : $('#addcustomerForm').serialize(),
		data : {
			'storehouseId' : storehouseId
		},
		success : function(data) {
			$(obj).parent().parent().remove();

		},
	});
}
// 修改客户信息
// 1.修改模态框数据获取
function modifyCurrentStorehouse(obj) {
	// console.dir(obj);
	var storehouseId = $(obj).parent().parent().children("td").get(1).innerHTML;
	$.ajax({
		type : 'POST',
		async : false,
		url : 'queryStorehouse.do',
		dataType : 'json',
		data : {
			'storehouseId' : storehouseId
		},
		success : function(data) {
			console.dir(data);
			$('#modify_storehouseId').val(data[0].storehouseId)
			$('#modify_storehouseName').val(data[0].storehouseName)
			$('#modify_type').val(data[0].type)
			$('#modify_contactName').val(data[0].contactName)
			$('#modify_contactTel').val(data[0].contactTel)
			$('#modify_contactAddress').val(data[0].contactAddress)
			$('#modify_status').val(data[0].contactEmail)
			$('#modify_area').val(data[0].area)
			$('#modify_remark').val(data[0].remark)
			$('#modify_storehouse').modal('show');
		},
	});

};

// 2.修改后信息传输
function modifyCurrentStorehuseInfo(obj) {
	// console.dir(obj);
	// 获取选中行的id
	$.ajax({
		type : 'POST',
		async : false,
		url : 'modify.do',
		data : $('#modify_storehouseForm').serialize(),
		success : function(data) {
			$('#modify_storehouse').modal('hide');
			window.location.href = "storehouse";
		},
	});
}

// 查询客户信息

// function delCurrentRow(obj) {
// alert(obj.innerHTML);
// alert(obj.parent());
// console.dir(obj);
// $(obj).parent().remove();
// obj.parents().css({
// "color" : "red",
// "border" : "2px solid red"
// });
// var id = obj.parent().parent().children("td").get(0).innerHTML;
// alert("id=" + id);
// alert(obj.parentNode);
// alert(obj.children().eq(1).text());
//
// obj.closest('tr').remove();
//
// }

// function delCurrentRow(obj){
// if(confirm("确定删除当前议程?")){
// if(document.all.batch_add_table.rows.length>2){
// var clickedRow=obj;
// while(clickedRow.tagName!="TR"){
// clickedRow=clickedRow.parentNode;
// }
// clickedRow.parentNode.removeChild(clickedRow);
// }else{
// alert("此行不能进行删除！");
// return;
// }
// }
// }
