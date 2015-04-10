package com.ai.psims.web.model;

import java.io.Serializable;

public class AddSalesGoodsBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String storageIdList;
	private String customerName;
	private String storeName;
	private String customerId;
	private String salesListCreateTime;
	private String employeeName;
	private String storeId;
	private String employeeId;
	private String salesCountList;
	private String salesPriceList;

	public AddSalesGoodsBean(String storageIdList, String customerName,
			String storeName, String customerId, String salesListCreateTime,
			String employeeName, String storeId, String employeeId,
			String salesCountList, String salesPriceList) {
		super();
		this.storageIdList = storageIdList;
		this.customerName = customerName;
		this.storeName = storeName;
		this.customerId = customerId;
		this.salesListCreateTime = salesListCreateTime;
		this.employeeName = employeeName;
		this.storeId = storeId;
		this.employeeId = employeeId;
		this.salesCountList = salesCountList;
		this.salesPriceList = salesPriceList;
	}

	public String getStorageIdList() {
		return storageIdList;
	}

	public void setStorageIdList(String storageIdList) {
		this.storageIdList = storageIdList;
	}

	public String getSalesCountList() {
		return salesCountList;
	}

	public void setSalesCountList(String salesCountList) {
		this.salesCountList = salesCountList;
	}

	public String getSalesPriceList() {
		return salesPriceList;
	}

	public void setSalesPriceList(String salesPriceList) {
		this.salesPriceList = salesPriceList;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getSalesListCreateTime() {
		return salesListCreateTime;
	}

	public void setSalesListCreateTime(String salesListCreateTime) {
		this.salesListCreateTime = salesListCreateTime;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

}
