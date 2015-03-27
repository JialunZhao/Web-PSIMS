package com.ai.psims.web.model;

public class AddGoodsBean {
	private String goodList;
	private String providerName;
	private String storeName;
	private String discountMed;
	private String payMed;
	private String payStatus;
	private String importcreatetime;

	public AddGoodsBean(String goodList, String providerName, String storeName,
			String discountMed, String payMed, String payStatus,
			String importcreatetime) {
		super();
		this.goodList = goodList;
		this.providerName = providerName;
		this.storeName = storeName;
		this.discountMed = discountMed;
		this.payMed = payMed;
		this.payStatus = payStatus;
		this.setImportcreatetime(importcreatetime);
	}

	public String getGoodList() {
		return goodList;
	}

	public void setGoodList(String goodList) {
		this.goodList = goodList;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getDiscountMed() {
		return discountMed;
	}

	public void setDiscountMed(String discountMed) {
		this.discountMed = discountMed;
	}

	public String getPayMed() {
		return payMed;
	}

	public void setPayMed(String payMed) {
		this.payMed = payMed;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getImportcreatetime() {
		return importcreatetime;
	}

	public void setImportcreatetime(String importcreatetime) {
		this.importcreatetime = importcreatetime;
	}

}
