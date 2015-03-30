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
