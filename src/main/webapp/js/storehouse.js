//新增客户 
//1.提交数据
$("#addStorehouseSubmit").click(function addStorehouseSubmit() {
	var num = 0;
	var str = "";
	$(".add").each(function(n) {
		if ($(this).val() == "") {
			num++;
			str += $(this).attr("placeholder") + "不能为空！\r\n";
		}
	});
	$(".addselect").each(function(n) {
		if ($(this).val() == "0") {
			num++;
			str += "请选择" + $(this).attr("placeholder") + "！\r\n";
		}
	});
	if (num > 0) {
		alert(str);
		return false;
	} else {
		$.ajax({
			type : 'POST',
			async : true,
			url : 'addStorehouse.do',
			data : $('#addStorehouseForm').serialize(),
			success : function(data) {
				$('#addStorehouse').modal('hide');
				window.location.href = "storehouse";
			},
		});
	}
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
			$('#modify_storehouseType').val(data[0].type)
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
	var num = 0;
	var str = "";
	$(".modify").each(function(n) {
		if ($(this).val() == "") {
			num++;
			str += $(this).attr("placeholder") + "不能为空！\r\n";
		}
	});
	$(".modifyselect").each(function(n) {
		if ($(this).val() == "0") {
			num++;
			str += "请选择" + $(this).attr("placeholder") + "！\r\n";
		}
	});
	if (num > 0) {
		alert(str);
		return false;
	} else {
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
}
