package com.ai.psims.web.model;

import java.util.Date;

public class Inportback {
    private String importbackSerialNumber;

    private String importSerialNumber;

    private Integer providerId;

    private String providerName;

    private Integer storehouseId;

    private String storehouseName;

    private String importbackType;

    private String importbackReason;

    private Date importbackTime;

    private Long importbackRefund;

    private String importbackRefundType;

    private Date importbackRefundTime;

    private String importbackRemark;

    public String getImportbackSerialNumber() {
        return importbackSerialNumber;
    }

    public void setImportbackSerialNumber(String importbackSerialNumber) {
        this.importbackSerialNumber = importbackSerialNumber == null ? null : importbackSerialNumber.trim();
    }

    public String getImportSerialNumber() {
        return importSerialNumber;
    }

    public void setImportSerialNumber(String importSerialNumber) {
        this.importSerialNumber = importSerialNumber == null ? null : importSerialNumber.trim();
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName == null ? null : providerName.trim();
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

    public String getImportbackType() {
        return importbackType;
    }

    public void setImportbackType(String importbackType) {
        this.importbackType = importbackType == null ? null : importbackType.trim();
    }

    public String getImportbackReason() {
        return importbackReason;
    }

    public void setImportbackReason(String importbackReason) {
        this.importbackReason = importbackReason == null ? null : importbackReason.trim();
    }

    public Date getImportbackTime() {
        return importbackTime;
    }

    public void setImportbackTime(Date importbackTime) {
        this.importbackTime = importbackTime;
    }

    public Long getImportbackRefund() {
        return importbackRefund;
    }

    public void setImportbackRefund(Long importbackRefund) {
        this.importbackRefund = importbackRefund;
    }

    public String getImportbackRefundType() {
        return importbackRefundType;
    }

    public void setImportbackRefundType(String importbackRefundType) {
        this.importbackRefundType = importbackRefundType == null ? null : importbackRefundType.trim();
    }

    public Date getImportbackRefundTime() {
        return importbackRefundTime;
    }

    public void setImportbackRefundTime(Date importbackRefundTime) {
        this.importbackRefundTime = importbackRefundTime;
    }

    public String getImportbackRemark() {
        return importbackRemark;
    }

    public void setImportbackRemark(String importbackRemark) {
        this.importbackRemark = importbackRemark == null ? null : importbackRemark.trim();
    }
}