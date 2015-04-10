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
			$('#modify_shelfLifePrewarning').val(data[0].shelfLifePrewarning)
			$('#modify_storagePrewarning').val(data[0].storagePrewarning)
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


//添加商品和客户关系--查询
function goods2customer(obj) {
	// console.dir(obj);
	var goodsId = $(obj).parent().parent().children("td").get(1).innerHTML;
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
			$('#modify_goodsId').val(data[0].goodsId)
			$('#modify_goodsName').val(data[0].goodsName)
			$('#modify_goodsType').val(data[0].goodsType)
			$('#modify_goodsUnit').val(data[0].goodsUnit)
			$('#modify_goodsActualCost').val(data[0].goodsActualCost)
			$('#modify_goodsPrice').val(data[0].goodsPrice)
			$('#modify_goodsProfit').val(data[0].goodsProfit)
			$('#modify_goodsShelfLife').val(data[0].goodsShelfLife)
			$('#modify_shelfLifePrewarning').val(data[0].shelfLifePrewarning)
			$('#modify_storagePrewarning').val(data[0].storagePrewarning)
			$('#modify_remark').val(data[0].remark)
			$('#modifygoods').modal('show');
		},
	});
};
