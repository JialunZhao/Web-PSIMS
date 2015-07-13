package com.ai.psims.web.model;

import java.io.Serializable;
import java.util.List;

public class AddGoodsBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<TbImportGoods> goodList;
	private TbImport tbImport;
	private Integer providerId;
	private String payMed;
	private String payStatus;
	private String importcreatetime;
	private String payTime;

	public AddGoodsBean(List<TbImportGoods> goodList, TbImport tbImport ,String payMed,
			String payStatus, String importcreatetime, String payTime,
			Integer providerId) {
		super();
		this.tbImport = tbImport;
		this.goodList = goodList;
		this.payMed = payMed;
		this.payStatus = payStatus;
		this.importcreatetime = importcreatetime;
		this.payTime = payTime;
		this.providerId = providerId;
	}

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public List<TbImportGoods> getGoodList() {
		return goodList;
	}

	public void setGoodList(List<TbImportGoods> goodList) {
		this.goodList = goodList;
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

	public TbImport getTbImport() {
		return tbImport;
	}

	public void setTbImport(TbImport tbImport) {
		this.tbImport = tbImport;
	}

}
