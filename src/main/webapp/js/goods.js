//新增商品 
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

// 删除商品信息
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
		url : 'queryGoods.do',
		dataType : 'json',
		data : {
			'goodsId' : goodsId
		},
		success : function(data) {
			console.dir(data);
			$('#modify_goodsId').val(data[0].goodsId)
			$('#modify_goodsName').val(data[0].goodsName)
			$('#modify_goodsType').val(data[0].goodsType)
			$('#modify_goodsUnit').val(data[0].goodsUnit)
			$('#modify_goodsActualCost').val(data[0].goodsActualCost)
			$('#modify_goodsPrice').val(data[0].goodsPrice)
			$('#modify_goodsProfit').val(data[0].goodsProfit)
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
	var goodsActualCost = $(obj).parent().parent().children("td").get(5).innerHTML;
	var goodsPrice = $(obj).parent().parent().children("td").get(6).innerHTML;

	$.ajax({
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

			$('#tmpGoodId').val(goodsId);
			$('#tmpGoodsName').val(goodsName);
			$('#tmpGoodsActualCost').val(goodsActualCost);
			$('#tmpGoodsPrice').val(goodsPrice);

			$('#goods2customer').modal('show');
		},
	});
};

//新增商品和客户关系--查询客户信息
function addgoods2customer(obj) {
	// console.dir(obj);
	var goodsId = $('#tmpGoodId').val();

	var goodsId = $
			.ajax({
				type : 'POST',
				async : false,
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
											+ '<select name="addGoods2Customer_select"><option value="0">请选择客户：</option></select>'
											+ '</td><td>'
											+ $('#tmpGoodsActualCost').val()
											+ '</td><td>'
											+ $('#tmpGoodsPrice').val()
											+ '</td><td><input class="control-group" type="text" value="'
											+ $('#tmpGoodsPrice').val()
											+ '"placeholder="商品优惠销售价格"></td>'
											+ '<td><a>保存</a></td></tr>');

					for (var i = 0; i < data.length; i++) {
						$("select:last").append(
								'<option value="' + data[i].customerId + '">'
										+ data[i].customerName + '</option>');
					}

				},
			});
};