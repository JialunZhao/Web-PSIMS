//新增商品 
//1.获取供应商和基本单位信息
$("#addGoods_btn").click(
		function getProviderAndGoodsUnit() {
			$.ajax({
				type : 'POST',
				async : true,
				url : 'getProviderAddGoods.do',
				success : function(data) {
					console.dir(data);
					$("#add_providers").empty();
					$("#add_providers").append(
							'<option value="0">请选择商品供应商：</option>');

					for (var i = 0; i < data.length; i++) {
						$("#add_providers").append(
								'<option value="' + data[i].providerId + '">'
										+ data[i].providerName + '</option>');
					}
				},
			});
			$.ajax({
				type : 'POST',
				async : true,
				url : 'getGoodsUnit.do',
				success : function(data) {
					console.dir(data);
					$("#add_goodsUnit").empty();
					$("#add_goodsUnit").append(
							'<option value="0">请选择商品基本单位：</option>');

					for (var i = 0; i < data.length; i++) {
						$("#add_goodsUnit").append(
								'<option value="' + data[i].paramId + '">'
										+ data[i].ppDesc + '</option>');
					}
				},
			});
			$('#addGoods').modal('show');
		});

// 2.提交新增商品数据
function addGoodsCheckNull() {
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

$("#addGoodsSubmit").click(function Goodsadd() {
	if (addGoodsCheckNull()) {
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
	}
});
// 2.刷新列表

// 删除商品信息
function delCurrentGoods(obj) {
	// console.dir(obj);
	// 获取选中行的id
	var goodsId = $(obj).parent().parent().children("td").get(1).innerHTML;
	if (confirm("确定删除么?")) {
		// 删除
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
}

// 下架商品信息
function offShelvesCurrentGoods(obj) {
	// console.dir(obj);
	// 获取选中行的id
	var goodsId = $(obj).parent().parent().children("td").get(1).innerHTML;
	$
			.ajax({
				type : 'POST',
				async : true,
				url : 'offShelvesGoods.do',
				data : {
					'goodsId' : goodsId
				},
				success : function(data) {
					$(obj)
							.parent()
							.html(
									"<a href='javascript:void(0);'onClick='modifyCurrentGoods(this)'>修改</a>/<a href='javascript:void(0);' onClick='delCurrentGoods(this);'>删除</a>/<a href='javascript:void(0);'	onClick='onShelvesCurrentGoods(this)'>上架</a>");
				},
			});
}

// 上架商品信息
function onShelvesCurrentGoods(obj) {
	// console.dir(obj);
	// 获取选中行的id
	var goodsId = $(obj).parent().parent().children("td").get(1).innerHTML;
	$
			.ajax({
				type : 'POST',
				async : true,
				url : 'onShelvesGoods.do',
				data : {
					'goodsId' : goodsId
				},
				success : function(data) {
					$(obj)
							.parent()
							.html(
									'<a href="javascript:void(0);"onClick="offShelvesCurrentGoods(this)">下架</a>');
				},
			});
}

// 修改商品信息
// 1.修改模态框数据获取
function modifyCurrentGoods(obj) {
	// console.dir(obj);
	var goodsId = $(obj).parent().parent().children("td").get(1).innerHTML;
	$.ajax({
		type : 'POST',
		async : false,
		url : 'getProviderAddGoods.do',
		success : function(data) {
			console.dir(data);
			$("#modify_providers").empty();
			$("#modify_providers").append(
					'<option value="0">请选择商品供应商：</option>');

			for (var i = 0; i < data.length; i++) {
				$("#modify_providers").append(
						'<option value="' + data[i].providerId + '">'
								+ data[i].providerName + '</option>');
			}
		}
	});
	$.ajax({
		type : 'POST',
		async : true,
		url : 'getGoodsUnit.do',
		success : function(data) {
			console.dir(data);
			$("#modify_goodsUnit").empty();
			$("#modify_goodsUnit").append(
					'<option value="0">请选择商品基本单位：</option>');

			for (var i = 0; i < data.length; i++) {
				$("#modify_goodsUnit").append(
						'<option value="' + data[i].paramId + '">'
								+ data[i].ppDesc + '</option>');
			}
		},
	});
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
			$('#modify_goodsId').val(data[0].goodsId)
			$('#modify_goodsName').val(data[0].goodsName)
			$('#modify_goodsCode').val(data[0].goodsCode)
			$('#modify_goodsType').val(data[0].goodsType)
			$('#modify_providers').val(data[0].providerId)
			$('#modify_goodsUnit').val(data[0].goodsUnit)
			$('#modify_goodsActualCost').val(data[0].goodsActualCost)
			$('#modify_goodsPrice').val(data[0].goodsPrice)
			$('#modify_goodsPrizePoolRatio').val(data[0].goodsPrizePoolRatio)
			$('#modify_goodsShelfLife').val(data[0].goodsShelfLife)
			$('#modify_shelfLifePrewarning').val(data[0].shelfLifeWarning)
			$('#modify_storagePrewarning').val(data[0].storageWarning)
			$('#modify_remark').val(data[0].remark)
			$('#modifygoods').modal('show');
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
		data : $('#modifyGoodsForm').serialize(),
		success : function(data) {
			$('#modifygoods').modal('hide');
			window.location.href = "goods";
		},
	});
}

// 查询商品和客户关系--查询
function goods2customer(obj) {
	// console.dir(obj);
	var goodsId = $(obj).parent().parent().children("td").get(1).innerHTML;
	var goodsName = $(obj).parent().parent().children("td").get(2).innerHTML;
	var goodsUnit = $(obj).parent().parent().children("td").get(5).innerHTML;
	var goodsActualCost = $(obj).parent().parent().children("td").get(7).innerHTML;
	var goodsPrice = $(obj).parent().parent().children("td").get(8).innerHTML;
	var goodsPrizePoolRatio = $(obj).parent().parent().children("td").get(9).innerHTML;

	$
			.ajax({
				type : 'POST',
				async : false,
				url : 'queryGoods2Customer.do',
				dataType : 'json',
				data : {
					'goodsId' : goodsId
				},
				success : function(data) {
					console.dir(data);
					$('#g2cGoodsName').html(goodsName + "-销售价格配置");
					$("#tb").empty();
					$('#goodsId').val(goodsId);

					$('#tmpGoodId').val(goodsId);
					$('#tmpGoodsName').val(goodsName);
					$('#tmpGoodsUnit').val(goodsUnit);
					$('#tmpGoodsActualCost').val(goodsActualCost);
					$('#tmpGoodsPrice').val(goodsPrice);
					$('#tmpGoodsPrizePoolRatio').val(goodsPrizePoolRatio);

					if (data[0].customerName != "Error") {
						for (var i = 0; i < data.length; i++) {
							$("#tb")
									.append(
											'<tr><td>'
													+ '<input type="hidden" id="goods2customerId" name="goods2customerId" value="'
													+ data[i].goods2customerId
													+ '">'
													+ '<select class="saveg2cselect"  name="customerId" placeholder="客户名称"><option selected value="'
													+ data[i].customerId
													+ '">'
													+ data[i].customerName
													+ '</option></select>'
													+ '</td><td>'
													+ data[i].goodsActualCost
													+ '</td><td>'
													+ data[i].goodsNormalPrice
													+ '</td><td><input class="control-group saveg2c" name="goodsPrice" type="text" value="'
													+ data[i].goodsPrice
													+ '"placeholder="本客户优惠后价格"></td>'
													+ '<td><a onClick="deleteGoods2Customer(this)">删除</a></td></tr>');
						}
					}
					$('#goods2customer').modal('show');
				},
			});
};

// 新增商品和客户关系--查询客户信息
function addgoods2customerselect(customerIdSelect) {
	var repeatfalg = '1';
	$("select[name='customerId']").each(function() {
		// alert($(this).val() )
		if ($(this).val() == customerIdSelect) {
			repeatfalg = '0';
			// alert(0);
			// return '0' ;
		} else {
			// alert(1);
			// return '1';
		}
	});
	return repeatfalg;

}
function addgoods2customer(obj) {
	// console.dir(obj);
	var goodsId = $('#tmpGoodId').val();

	// $("select[name='customerId']").each(function() {
	// return $(this).val();
	// });

	$
			.ajax({
				type : 'POST',
				async : true,
				url : 'addGoods2Customer.do',
				dataType : 'json',
				data : {
					'goodsId' : goodsId
				},
				success : function(data) {
					console.dir(data);
					$("#tb")
							.append(
									'<tr><td>'
											+ '<input type="hidden" id="goods2customerId" name="goods2customerId">'
											+ '<select class="saveg2cselect" name="customerId"  placeholder="客户名称"><option value="0">请选择客户：</option></select>'
											+ '</td><td>'
											+ $('#tmpGoodsActualCost').val()
											+ '</td><td>'
											+ $('#tmpGoodsPrice').val()
											+ '</td><td><input class="control-group saveg2c" name="goodsPrice" type="text" value="'
											+ $('#tmpGoodsPrice').val()
											+ '"placeholder="本客户优惠后价格"></td>'
											+ '<td><a onClick="deleteGoods2Customer(this)" >删除</a></td></tr>');

					for (var i = 0; i < data.length; i++) {
						// $("select:last").append(
						// '<option value="' + data[i].customerId + '">'
						// + data[i].customerName + '</option>');

						if (addgoods2customerselect(data[i].customerId) == '1') {
							$("select:last").append(
									'<option value="' + data[i].customerId
											+ '">' + data[i].customerName
											+ '</option>');
						} else {
							// alert(data[i].customerId+"123zdas");
						}
					}
				},
			});
};

// 新增商品和客户关系--保存客户信息
function savegoods2customer(obj) {
	console.dir($('#goods2CustomerForm'));
	var num = 0;
	var str = "";
	$(".saveg2c").each(function(n) {
		if ($(this).val() == "") {
			num++;
			str += $(this).attr("placeholder") + "不能为空！\r\n";
		}
	});
	$(".saveg2cselect").each(function(n) {
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
			url : 'Goods2CustomerSave.do',
			data : $('#goods2CustomerForm').serialize(),
			success : function(data) {
				$('#goods2customer').modal('hide');
			},
		});
	}
}

// 删除商品和客户关系
function deleteGoods2Customer(obj) {
	// 获取选中行的goods2customerId
	if (confirm("确定删除么?")) {
		var goods2customerId = $(obj).parent().parent().children("td").find(
				"input").val();
		// alert(goods2customerId);
		//
		$.ajax({
			type : 'POST',
			async : true,
			url : 'deleteGoods2Customer.do',
			data : {
				'goods2customerId' : goods2customerId
			},
			success : function(data) {
				$(obj).parent().parent().remove();
			},
		});
	}
}
