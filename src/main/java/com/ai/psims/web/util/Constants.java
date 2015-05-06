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

		// 是否
		public static class DiscountMed {
			public static final String NO = "N";// 否
			public static final String YES = "Y";// 是
			public static final String NO01 = "否";
			public static final String YES01 = "是";
		}

		// 入库存状态
		public static class ImportStatus {
			public static final String ORDERNOPAY = "30";// 下单未付款
			public static final String ORDERYESPAY = "31";// 下单已付款
			public static final String GOODSLITARRIVAL = "35";// 商品部分到货
			public static final String GOODSARRIVAL = "32";// 商品到货
			public static final String GOODSIMPORT = "33";// 商品入库
			public static final String ORDERNOPAY01 = "下单未付款";
			public static final String ORDERYESPAY01 = "下单已付款";
			public static final String GOODSARRIVAL01 = "商品到货";
			public static final String GOODSIMPORT01 = "商品入库";
			public static final String GOODSLITARRIVAL01 = "商品部分到货";
		}

		// 入库商品状态
		public static class ImportGoodsStatus {
			public static final String CANSALE = "Y";// 可售
			public static final String NOTSALE = "N";// 不可售
			public static final String CANSALE01 = "可售";
			public static final String NOTSALE01 = "不可售";
		}

		// 退货商品状态
		public static class BackGoodsTpye {
			public static final String BACKNOOUT = "BN";// 下单未出库
			public static final String BACKYESOUT = "BY";// 下单已出库
			public static final String BACKNOOUT01 = "下单已出库";
			public static final String BACKYESOUT01 = "下单已出库";
		}

		// 退货状态
		public static class ImportBackStatus {
			public static final String ORDERNOPAY = "34";// 下单未退款
			public static final String ORDERPAY = "35";// 下单已退款
			public static final String GOODSOUT = "36";// 商品出库
			public static final String GOODSINPUT = "37";// 商品入库
			public static final String ORDERNOPAY01 = "下单未退款";
			public static final String ORDERPAY01 = "下单已退款";
			public static final String GOODSOUT01 = "商品出库";
			public static final String GOODSINPUT01 = "商品入库";
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

		// 退货类型
		public static class BackType {
			public static final String CHANGEGOODS = "CG";// 换货
			public static final String BACKGOODS = "BG";// 退货

			public static final String CHANGEGOODS01 = "换货";
			public static final String BACKGOODS01 = "退货";
		}
		
		// 客户类型
		public static class CustomerType {
			public static final String CustomerType01Code = "1";// 连锁
			public static final String CustomerType02Code = "2";// 商户
			public static final String CustomerType03Code = "3";// 散户
			public static final String CustomerType04Code = "4";// 其它
			
			public static final String CustomerType01Name = "连锁";//01
			public static final String CustomerType02Name = "商户";//02
			public static final String CustomerType03Name = "散户";//03
			public static final String CustomerType04Name = "其它";//04
		}
		
		// 供应商类型
		public static class ProviderType {
			public static final String ProviderType01Code = "1";// 连锁
			public static final String ProviderType02Code = "2";// 商户
			public static final String ProviderType03Code = "3";// 散户
			public static final String ProviderType04Code = "4";// 其它
			
			public static final String ProviderType01Name = "连锁";//01
			public static final String ProviderType02Name = "商户";//02
			public static final String ProviderType03Name = "散户";//03
			public static final String ProviderType04Name = "其它";//04
		}
		
		// 商品类型
		public static class GoodsType {
			public static final String GoodsType01Code = "1";// 啤酒
			public static final String GoodsType02Code = "2";// 白酒
			public static final String GoodsType03Code = "3";// 饮料
			public static final String GoodsType04Code = "4";// 原料
			
			public static final String GoodsType01Name = "啤酒";//01
			public static final String GoodsType02Name = "白酒";//02
			public static final String GoodsType03Name = "饮料";//03
			public static final String GoodsType04Name = "原料";//04
		}

}
