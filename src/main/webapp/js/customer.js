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
			alert("jQueryForm得到返回值: " + data);

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
			alert(customer_id);
		},
	});
}
// 修改客户信息
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
			alert(customer_id);
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
