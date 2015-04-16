package com.ai.psims.web.model;

import java.io.Serializable;
import java.util.List;

public class UpdateImportDemo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<TbImportGoods> importGoodsList;
	public String providerId;
	public String storehouseId;
	public String paymentType;
	public String importStatus;
	public String payTime;
	public String importSerialNumber;
	public String storehouseName;
	public String providerName;

	public UpdateImportDemo(List<TbImportGoods> importGoodsList,
			String providerId, String storehouseId, String paymentType,
			String importStatus, String payTime, String importSerialNumber,
			String storehouseName, String providerName) {
		super();
		this.importGoodsList = importGoodsList;
		this.providerId = providerId;
		this.storehouseId = storehouseId;
		this.paymentType = paymentType;
		this.importStatus = importStatus;
		this.payTime = payTime;
		this.importSerialNumber = importSerialNumber;
		this.storehouseName = storehouseName;
		this.providerName = providerName;
	}

	public UpdateImportDemo(List<TbImportGoods> importGoodsLists,
			String providerId2, String paymentType2, String importStatus2,
			String payTime2, String importSerialNumber2, String providerName2) {
		// TODO Auto-generated constructor stub
	}

	public String getStorehouseName() {
		return storehouseName;
	}

	public void setStorehouseName(String storehouseName) {
		this.storehouseName = storehouseName;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public List<TbImportGoods> getImportGoodsList() {
		return importGoodsList;
	}

	public void setImportGoodsList(List<TbImportGoods> importGoodsList) {
		this.importGoodsList = importGoodsList;
	}

	public String getImportSerialNumber() {
		return importSerialNumber;
	}

	public void setImportSerialNumber(String importSerialNumber) {
		this.importSerialNumber = importSerialNumber;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getStorehouseId() {
		return storehouseId;
	}

	public void setStorehouseId(String storehouseId) {
		this.storehouseId = storehouseId;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getImportStatus() {
		return importStatus;
	}

	public void setImportStatus(String importStatus) {
		this.importStatus = importStatus;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

}
