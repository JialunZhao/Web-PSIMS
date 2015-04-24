package com.ai.psims.web.model;

public class SalesUpdateData {
	String salesGoodsIdList;
	String goodsAmountList;
	String salesSerialNumber;
	String salesStatus;
	String payMed;
	String creditCount;
	String payTime;

	public SalesUpdateData(String salesGoodsIdList, String goodsAmountList,
			String salesSerialNumber, String salesStatus, String payMed,
			String creditCount, String payTime) {
		super();
		this.salesGoodsIdList = salesGoodsIdList;
		this.goodsAmountList = goodsAmountList;
		this.salesSerialNumber = salesSerialNumber;
		this.salesStatus = salesStatus;
		this.payMed = payMed;
		this.creditCount = creditCount;
		this.payTime = payTime;
	}

	public String getSalesGoodsIdList() {
		return salesGoodsIdList;
	}

	public void setSalesGoodsIdList(String salesGoodsIdList) {
		this.salesGoodsIdList = salesGoodsIdList;
	}

	public String getGoodsAmountList() {
		return goodsAmountList;
	}

	public void setGoodsAmountList(String goodsAmountList) {
		this.goodsAmountList = goodsAmountList;
	}

	public String getSalesSerialNumber() {
		return salesSerialNumber;
	}

	public void setSalesSerialNumber(String salesSerialNumber) {
		this.salesSerialNumber = salesSerialNumber;
	}

	public String getSalesStatus() {
		return salesStatus;
	}

	public void setSalesStatus(String salesStatus) {
		this.salesStatus = salesStatus;
	}

	public String getPayMed() {
		return payMed;
	}

	public void setPayMed(String payMed) {
		this.payMed = payMed;
	}

	public String getCreditCount() {
		return creditCount;
	}

	public void setCreditCount(String creditCount) {
		this.creditCount = creditCount;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

}
