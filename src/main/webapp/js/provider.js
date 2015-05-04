//新增客户 
//1.获取奖金池信息

//2.提交数据
$("#addprovidersubmit").click(function provideradd() {
	$.ajax({
		type : 'POST',
		async : true,
		url : 'addProvider.do',
		data : $('#addproviderForm').serialize(),
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
			$('#addprovider').modal('hide');
			window.location.href = "provider";
		},
	});
});
// 2.刷新列表

// 删除客户信息
function delCurrentProvider(obj) {
	// console.dir(obj);
	// 获取选中行的id
	var provider_id = $(obj).parent().parent().children("td").get(1).innerHTML;
	$.ajax({
		type : 'POST',
		async : true,
		url : 'deleteProvider.do',
		// data : $('#addcustomerForm').serialize(),
		data : {
			'provider_id' : provider_id
		},
		success : function(data) {
			$(obj).parent().parent().remove();

		},
	});
}
// 修改客户信息
// 1.修改模态框数据获取
function modifyCurrentProvider(obj) {
	// console.dir(obj);
	var provider_id = $(obj).parent().parent().children("td").get(1).innerHTML;
	$.ajax({
		type : 'POST',
		async : false,
		url : 'queryProvider.do',
		dataType : 'json',
		data : {
			'provider_id' : provider_id
		},
		success : function(data) {
			console.dir(data);
			$('#modify_providerId').val(data[0].providerId)
			$('#modify_providerName').val(data[0].providerName)
			$('#modify_providerType').val(data[0].providerType)
			$('#modify_providerPrizePool').val(data[0].providerPrizePool)
			$('#modify_providerContactName').val(data[0].providerContactName)
			$('#modify_providerContactTel').val(data[0].providerContactTel)
			$('#modify_providerContactAddress').val(data[0].providerContactAddress)
			$('#modify_providerContactEmail').val(data[0].providerContactEmail)
			$('#modify_providerArea').val(data[0].providerArea)
			$('#modify_providerRemark').val(data[0].providerRemark)
			$('#modifyprovider').modal('show');
		},
	});

};

// 2.修改后信息传输
function modifyCurrentProviderInfo(obj) {
	// console.dir(obj);
	// 获取选中行的id
	$.ajax({
		type : 'POST',
		async : false,
		url : 'modify.do',
		data : $('#modify_providerForm').serialize(),
		success : function(data) {
			$('#modifyprovider').modal('hide');
			window.location.href = "provider";
		},
	});
}

