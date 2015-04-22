package com.ai.psims.web.model;

import java.io.Serializable;

public class AddGoodsBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String goodList;
	private String providerName;
	private String payMed;
	private String payStatus;
	private String importcreatetime;
	private String payTime;
	private String providerId;

	public AddGoodsBean(String goodList, String providerName, String payMed,
			String payStatus, String importcreatetime, String payTime,
			String providerId) {
		super();
		this.goodList = goodList;
		this.providerName = providerName;
		this.payMed = payMed;
		this.payStatus = payStatus;
		this.importcreatetime = importcreatetime;
		this.payTime = payTime;
		this.providerId = providerId;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
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
