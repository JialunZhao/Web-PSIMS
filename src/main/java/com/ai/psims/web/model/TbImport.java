package com.ai.psims.web.model;

import java.util.Date;

public class TbImport {
    private String importSerialNumber;

    private Date importDatetime;

    private String importBatchNumber;

    private Long importTotalPrice;

    private String paymentType;

    private Date paymentTime;

    private String importType;

    private String importStatus;

    private String importRemark;

    private Integer providerId;

    private String providerName;

    public String getImportSerialNumber() {
        return importSerialNumber;
    }

    public void setImportSerialNumber(String importSerialNumber) {
        this.importSerialNumber = importSerialNumber == null ? null : importSerialNumber.trim();
    }

    public Date getImportDatetime() {
        return importDatetime;
    }

    public void setImportDatetime(Date importDatetime) {
        this.importDatetime = importDatetime;
    }

    public String getImportBatchNumber() {
        return importBatchNumber;
    }

    public void setImportBatchNumber(String importBatchNumber) {
        this.importBatchNumber = importBatchNumber == null ? null : importBatchNumber.trim();
    }

    public Long getImportTotalPrice() {
        return importTotalPrice;
    }

    public void setImportTotalPrice(Long importTotalPrice) {
        this.importTotalPrice = importTotalPrice;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType == null ? null : paymentType.trim();
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getImportType() {
        return importType;
    }

    public void setImportType(String importType) {
        this.importType = importType == null ? null : importType.trim();
    }

    public String getImportStatus() {
        return importStatus;
    }

    public void setImportStatus(String importStatus) {
        this.importStatus = importStatus == null ? null : importStatus.trim();
    }

    public String getImportRemark() {
        return importRemark;
    }

    public void setImportRemark(String importRemark) {
        this.importRemark = importRemark == null ? null : importRemark.trim();
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
}