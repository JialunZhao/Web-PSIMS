package com.ai.psims.web.model;

import java.util.Date;

public class Salesback {
    private String salesbackSerialNumber;

    private String salesSerialNumber;

    private Integer customerId;

    private String customerName;

    private Integer storehouseId;

    private String storehouseName;

    private Integer employeeId;

    private String employeeName;

    private String salesbackType;

    private String salesbackReason;

    private Date salesbackTime;

    private Long salesbackRefund;

    private String salesbackRefundType;

    private Date salesbackRefundTime;

    private String salesbackRemark;

    public String getSalesbackSerialNumber() {
        return salesbackSerialNumber;
    }

    public void setSalesbackSerialNumber(String salesbackSerialNumber) {
        this.salesbackSerialNumber = salesbackSerialNumber == null ? null : salesbackSerialNumber.trim();
    }

    public String getSalesSerialNumber() {
        return salesSerialNumber;
    }

    public void setSalesSerialNumber(String salesSerialNumber) {
        this.salesSerialNumber = salesSerialNumber == null ? null : salesSerialNumber.trim();
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public Integer getStorehouseId() {
        return storehouseId;
    }

    public void setStorehouseId(Integer storehouseId) {
        this.storehouseId = storehouseId;
    }

    public String getStorehouseName() {
        return storehouseName;
    }

    public void setStorehouseName(String storehouseName) {
        this.storehouseName = storehouseName == null ? null : storehouseName.trim();
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? null : employeeName.trim();
    }

    public String getSalesbackType() {
        return salesbackType;
    }

    public void setSalesbackType(String salesbackType) {
        this.salesbackType = salesbackType == null ? null : salesbackType.trim();
    }

    public String getSalesbackReason() {
        return salesbackReason;
    }

    public void setSalesbackReason(String salesbackReason) {
        this.salesbackReason = salesbackReason == null ? null : salesbackReason.trim();
    }

    public Date getSalesbackTime() {
        return salesbackTime;
    }

    public void setSalesbackTime(Date salesbackTime) {
        this.salesbackTime = salesbackTime;
    }

    public Long getSalesbackRefund() {
        return salesbackRefund;
    }

    public void setSalesbackRefund(Long salesbackRefund) {
        this.salesbackRefund = salesbackRefund;
    }

    public String getSalesbackRefundType() {
        return salesbackRefundType;
    }

    public void setSalesbackRefundType(String salesbackRefundType) {
        this.salesbackRefundType = salesbackRefundType == null ? null : salesbackRefundType.trim();
    }

    public Date getSalesbackRefundTime() {
        return salesbackRefundTime;
    }

    public void setSalesbackRefundTime(Date salesbackRefundTime) {
        this.salesbackRefundTime = salesbackRefundTime;
    }

    public String getSalesbackRemark() {
        return salesbackRemark;
    }

    public void setSalesbackRemark(String salesbackRemark) {
        this.salesbackRemark = salesbackRemark == null ? null : salesbackRemark.trim();
    }
}