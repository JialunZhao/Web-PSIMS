//新增客户提交
$("#addcustomersubmit").click(function customeradd() {
	// alert($("#addcustomerForm").serialize());

	$.ajax({
		type : 'POST',
		async : true,
		url : 'addcustomer.do',
		data : $('#addcustomerForm').serialize(),

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
			$('#addcustomer').modal('hide');

		},
	});
});
// 删除客户信息
function delCurrentCustomer(obj) {
	// console.dir(obj);
	// 获取选中行的id
	var customer_id = $(obj).parent().parent().children("td").get(1).innerHTML;
	$.ajax({
		type : 'POST',
		async : true,
		url : 'deleteCustomer.do',
		// data : $('#addcustomerForm').serialize(),
		data : {
			'customer_id' : customer_id
		},
		success : function(data) {
			$(obj).parent().parent().remove();

		},
	});
}
// 修改客户信息
// 1.修改模态框数据获取
function modifyCurrentCustomer(obj) {
	// console.dir(obj);
	var customer_id = $(obj).parent().parent().children("td").get(1).innerHTML;
	$.ajax({
		type : 'POST',
		async : false,
		url : 'queryCustomer.do',
		dataType : 'json',
		data : {
			'customer_id' : customer_id
		},
		success : function(data) {
			console.dir(data);
			$('#modify_customerId').val(data[0].customerId)
			$('#modify_customerName').val(data[0].customerName)
			$('#modify_customerType').val(data[0].customerType)
			$('#modify_contactName').val(data[0].contactName)
			$('#modify_contactTel').val(data[0].contactTel)
			$('#modify_contactAddr').val(data[0].contactAddr)
			$('#modify_email').val(data[0].email)
			$('#modify_area').val(data[0].area)
			$('#modify_remark').val(data[0].remark)
			$('#modifycustomer').modal('show');
		},
	});

};

// 2.修改后信息传输
function modifyCurrentCustomerInfo(obj) {
	// console.dir(obj);
	// 获取选中行的id
	$.ajax({
		type : 'POST',
		async : false,
		url : 'modify.do',
		data : $('#modify_customerForm').serialize(),
		success : function(data) {
			alert("1");
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
