package com.ai.psims.web.util;

public class Constants {
	
	// 全局状态通用配置
	public static class CommonStatus {
		public static final String Invalid_Code = "00";// 失效
		public static final String Invalid_Str = "失效";
		public static final String Normal_Code = "01";// 正常
		public static final String Normal_Str = "正常";
		public static final String Exception_Code = "99";// 异常
		public static final String Exception_Str = "异常";
	} 
	
	// 支付方式
	public static class PayMed {
		public static final String CASH = "00";// 现金
		public static final String TRANSFERS = "01";// 转账
		public static final String CHEQUE = "02";// 支票
		public static final String TICK = "03";// 赊账
		public static final String CASH01 = "现金";
		public static final String TRANSFERS01 = "转账";
		public static final String CHEQUE01 = "支票";
		public static final String TICK01 = "赊账";
	}

	// 支付状态
	public static class PayStatus {
		public static final String NOPAY = "10";// 未付款
		public static final String YESPAY = "11";// 已付款
		public static final String NOPAY01 = "未付款";
		public static final String YESPAY01 = "已付款";
	}

	// 折扣方式
	public static class DiscountMed {
		public static final String NODISCOUNT = "20";// 无折扣
		public static final String AWARDFONT = "21";// 奖金池
		public static final String NODISCOUNT01 = "无折扣";
		public static final String AWARDFONT01 = "奖金池";
	}

	// 入库存状态
	public static class ImportStatus {
		public static final String ORDERNOPAY = "30";// 下单未付款
		public static final String ORDERYESPAY = "31";// 下单已付款
		public static final String GOODSARRIVAL = "32";// 商品到货
		public static final String GOODSIMPORT = "33";// 商品入库
		public static final String ORDERNOPAY01 = "下单未付款";
		public static final String ORDERYESPAY01 = "下单已付款";
		public static final String GOODSARRIVAL01 = "商品到货";
		public static final String GOODSIMPORT01 = "商品入库";
	}

	// 入库商品状态
	public static class ImportGoodsStatus {
		public static final String CANSALE = "Y";// 可售
		public static final String NOTSALE = "N";// 不可售
		public static final String CANSALE01 = "可售";
		public static final String NOTSALE01 = "不可售";
	}
	// 销售表库存状态
		public static class SalesStatus {
			public static final String DOWNORDER = "DO";// 下单
			public static final String OUTORDER = "OO";// 出单
			public static final String OUTSTORE = "OS";// 出库
			public static final String SQUARE = "S";// 结清
			public static final String CREDIT = "C";// 赊账

			public static final String DOWNORDER01 = "下单";
			public static final String OUTORDER01 = "出单";
			public static final String OUTSTORE01 = "出库";
			public static final String SQUARE01 = "结清";
			public static final String CREDIT01 = "赊账";

		}

}
