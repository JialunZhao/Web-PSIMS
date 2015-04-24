package com.ai.psims.web.model;

public class SalesUpdataGoods {
	private int salesGoodsId;
	private String salesSerialNumber;
	private String goodsName;
	private long salesGoodsPrice;
	private int salesGoodsAmount;
	private long salesGoodsTotalPrice;
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

	public long getSalesGoodsPrice() {
		return salesGoodsPrice;
	}

	public void setSalesGoodsPrice(long salesGoodsPrice) {
		this.salesGoodsPrice = salesGoodsPrice;
	}

	public int getSalesGoodsAmount() {
		return salesGoodsAmount;
	}

	public void setSalesGoodsAmount(int salesGoodsAmount) {
		this.salesGoodsAmount = salesGoodsAmount;
	}

	public long getSalesGoodsTotalPrice() {
		return salesGoodsTotalPrice;
	}

	public void setSalesGoodsTotalPrice(long salesGoodsTotalPrice) {
		this.salesGoodsTotalPrice = salesGoodsTotalPrice;
	}

}
