//新增客户 
//1.提交数据
$("#addcustomerForm").submit(function(e) {
	// $('#addcustomer').modal('hide');
});
function addcustomercheckNull() {
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
		return true;
	}
}

// 删除客户信息
// 1.弹出提示
// 2.执行删除
function delCurrentCustomer(obj) {
	// console.dir(obj);
	// 获取选中行的id
	var customer_id = $(obj).parent().parent().children("td").get(1).innerHTML;
	if (confirm("确定删除么?")) {
		// 删除
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

}
// 修改客户信息
// 1.修改模态框数据获取
function modifyCurrentCustomer(obj) {
	// console.dir(obj);
	var employeeId = $(obj).parent().parent().children("td").get(1).innerHTML;

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
			$('#modify_customerCode').val(data[0].customerCode)
			$('#modify_customerType').val(data[0].customerType)
			$('#modify_checkout_code').val(data[0].checkoutCode)
			$('#modify_contactName').val(data[0].contactName)
			$('#modify_contactTel').val(data[0].contactTel)
			$('#modify_contactAddr').val(data[0].contactAddr)
			$('#modify_area').val(data[0].area)
			$('#modify_email').val(data[0].email)
			$('#modify_employeeId').val(data[0].employeeId)
			$('#modify_checkoutWarning').val(data[0].checkoutWarning)
			$('#modify_remark').val(data[0].remark)
			$('#modifycustomer').modal('show');
		},
	});

};

// 2.修改后信息传输

function modifyCurrentCustomerInfo(obj) {
	// console.dir(obj);
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
}
