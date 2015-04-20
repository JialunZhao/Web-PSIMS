package com.ai.psims.web.model;

import java.io.Serializable;

public class AddGoodsBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String goodList;
	private String providerName;
	private String storeName;
	private String discountMed;
	private String payMed;
	private String payStatus;
	private String importcreatetime;
	private String payTime;
	private String providerId;
	private String storeId;

	public AddGoodsBean(String goodList, String providerName, String storeName,
			String discountMed, String payMed, String payStatus,
			String importcreatetime, String payTime, String providerId,
			String storeId) {
		super();
		this.goodList = goodList;
		this.providerName = providerName;
		this.storeName = storeName;
		this.discountMed = discountMed;
		this.payMed = payMed;
		this.payStatus = payStatus;
		this.payTime = payTime;
		this.providerId = providerId;
		this.storeId = storeId;
		this.setImportcreatetime(importcreatetime);
	}

	public AddGoodsBean(String goodList2, String providerName2, String payMed2,
			String payStatus2, String importcreatetime2, String payTime2,
			String providerId2) {
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
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
