//新增客户 
//1.提交数据
$("#addGoodsSubmit").click(function Goodsadd() {
	$.ajax({
		type : 'POST',
		async : true,
		url : 'addGoods.do',
		data : $('#addGoodsForm').serialize(),
		success : function(data) {
			$('#addGoods').modal('hide');
			window.location.href = "goods";
		},
	});
});
// 2.刷新列表

// 删除客户信息
function delCurrentGoods(obj) {
	// console.dir(obj);
	// 获取选中行的id
	var goodsId = $(obj).parent().parent().children("td").get(1).innerHTML;
	$.ajax({
		type : 'POST',
		async : true,
		url : 'deleteGoods.do',
		// data : $('#addcustomerForm').serialize(),
		data : {
			'goodsId' : goodsId
		},
		success : function(data) {
			$(obj).parent().parent().remove();
		},
	});
}

// 修改客户信息
// 1.修改模态框数据获取
function modifyCurrentGoods(obj) {
	// console.dir(obj);
	var goodsId = $(obj).parent().parent().children("td").get(1).innerHTML;
	$.ajax({
		type : 'POST',
		async : false,
		url : 'queryGoods.do',
		dataType : 'json',
		data : {
			'goodsId' : goodsId
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
function modifyCurrentGoodsInfo(obj) {
	// console.dir(obj);
	// 获取选中行的id
	$.ajax({
		type : 'POST',
		async : false,
		url : 'modify.do',
		data : $('#modify_customerForm').serialize(),
		success : function(data) {
			$('#modifycustomer').modal('hide');
			window.location.href = "customer";
		},
	});
}
