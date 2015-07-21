package com.ai.psims.web.model;

public class SalesUpdataGoods {
	private int salesGoodsId;
	private String salesSerialNumber;
	private String goodsName;
	private String salesGoodsPrice;
	private int salesGoodsAmount;
	private String salesGoodsTotalPrice;
	private int storageRateCurrent;

	public int getStorageRateCurrent() {
		return storageRateCurrent;
	}

	public void setStorageRateCurrent(int storageRateCurrent) {
		this.storageRateCurrent = storageRateCurrent;
	}

	public int getSalesGoodsId() {
		return salesGoodsId;
	}

	public void setSalesGoodsId(int salesGoodsId) {
		this.salesGoodsId = salesGoodsId;
	}

	public String getSalesSerialNumber() {
		return salesSerialNumber;
	}

	public void setSalesSerialNumber(String salesSerialNumber) {
		this.salesSerialNumber = salesSerialNumber;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getSalesGoodsPrice() {
		return salesGoodsPrice;
	}

	public void setSalesGoodsPrice(String salesGoodsPrice) {
		this.salesGoodsPrice = salesGoodsPrice;
	}

	public int getSalesGoodsAmount() {
		return salesGoodsAmount;
	}

	public void setSalesGoodsAmount(int salesGoodsAmount) {
		this.salesGoodsAmount = salesGoodsAmount;
	}

	public String getSalesGoodsTotalPrice() {
		return salesGoodsTotalPrice;
	}

	public void setSalesGoodsTotalPrice(String salesGoodsTotalPrice) {
		this.salesGoodsTotalPrice = salesGoodsTotalPrice;
	}

}
