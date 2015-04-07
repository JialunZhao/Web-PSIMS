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
	private String payMed;
	private String payStatus;
	private String salesListCreateTime;
	private String payTime;
	private String employeeName;
	private String storeId;
	private String employeeId;
	private String salesCountList;
	private String salesPriceList;
	private String discountMed;

	public AddSalesGoodsBean(String storageIdList, String customerName,
			String storeName, String customerId, String payMed,
			String payStatus, String salesListCreateTime, String payTime,
			String employeeName, String storeId, String employeeId,
			String salesCountList, String salesPriceList, String discountMed) {
		super();
		this.storageIdList = storageIdList;
		this.customerName = customerName;
		this.storeName = storeName;
		this.customerId = customerId;
		this.payMed = payMed;
		this.payStatus = payStatus;
		this.salesListCreateTime = salesListCreateTime;
		this.payTime = payTime;
		this.employeeName = employeeName;
		this.storeId = storeId;
		this.employeeId = employeeId;
		this.salesCountList = salesCountList;
		this.salesPriceList = salesPriceList;
		this.discountMed = discountMed;
	}

	public String getDiscountMed() {
		return discountMed;
	}

	public void setDiscountMed(String discountMed) {
		this.discountMed = discountMed;
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

	public String getSalesListCreateTime() {
		return salesListCreateTime;
	}

	public void setSalesListCreateTime(String salesListCreateTime) {
		this.salesListCreateTime = salesListCreateTime;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
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
