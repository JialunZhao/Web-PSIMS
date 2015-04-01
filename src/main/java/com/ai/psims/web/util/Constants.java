package com.ai.psims.web.util;

public class Constants {
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
}
