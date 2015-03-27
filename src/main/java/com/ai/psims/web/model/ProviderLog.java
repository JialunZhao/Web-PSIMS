package com.ai.psims.web.model;

import java.util.Date;

public class ProviderLog {
    private Integer logId;

    private Date logDatetime;

    private Integer providerId;

    private String providerName;

    private String providerCode;

    private String providerContactName;

    private String providerContactTel;

    private String providerContactFax;

    private String providerContactEmail;

    private String providerContactAddress;

    private String providerBankName;

    private String providerBankAccountName;

    private String providerBankAccountCode;

    private String providerTaxid;

    private String providerArea;

    private String providerStatus;

    private Date providerCreatetime;

    private Date providerModifytime;

    private Date providerEndtime;

    private String providerRemark;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Date getLogDatetime() {
        return logDatetime;
    }

    public void setLogDatetime(Date logDatetime) {
        this.logDatetime = logDatetime;
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

    public String getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode == null ? null : providerCode.trim();
    }

    public String getProviderContactName() {
        return providerContactName;
    }

    public void setProviderContactName(String providerContactName) {
        this.providerContactName = providerContactName == null ? null : providerContactName.trim();
    }

    public String getProviderContactTel() {
        return providerContactTel;
    }

    public void setProviderContactTel(String providerContactTel) {
        this.providerContactTel = providerContactTel == null ? null : providerContactTel.trim();
    }

    public String getProviderContactFax() {
        return providerContactFax;
    }

    public void setProviderContactFax(String providerContactFax) {
        this.providerContactFax = providerContactFax == null ? null : providerContactFax.trim();
    }

    public String getProviderContactEmail() {
        return providerContactEmail;
    }

    public void setProviderContactEmail(String providerContactEmail) {
        this.providerContactEmail = providerContactEmail == null ? null : providerContactEmail.trim();
    }

    public String getProviderContactAddress() {
        return providerContactAddress;
    }

    public void setProviderContactAddress(String providerContactAddress) {
        this.providerContactAddress = providerContactAddress == null ? null : providerContactAddress.trim();
    }

    public String getProviderBankName() {
        return providerBankName;
    }

    public void setProviderBankName(String providerBankName) {
        this.providerBankName = providerBankName == null ? null : providerBankName.trim();
    }

    public String getProviderBankAccountName() {
        return providerBankAccountName;
    }

    public void setProviderBankAccountName(String providerBankAccountName) {
        this.providerBankAccountName = providerBankAccountName == null ? null : providerBankAccountName.trim();
    }

    public String getProviderBankAccountCode() {
        return providerBankAccountCode;
    }

    public void setProviderBankAccountCode(String providerBankAccountCode) {
        this.providerBankAccountCode = providerBankAccountCode == null ? null : providerBankAccountCode.trim();
    }

    public String getProviderTaxid() {
        return providerTaxid;
    }

    public void setProviderTaxid(String providerTaxid) {
        this.providerTaxid = providerTaxid == null ? null : providerTaxid.trim();
    }

    public String getProviderArea() {
        return providerArea;
    }

    public void setProviderArea(String providerArea) {
        this.providerArea = providerArea == null ? null : providerArea.trim();
    }

    public String getProviderStatus() {
        return providerStatus;
    }

    public void setProviderStatus(String providerStatus) {
        this.providerStatus = providerStatus == null ? null : providerStatus.trim();
    }

    public Date getProviderCreatetime() {
        return providerCreatetime;
    }

    public void setProviderCreatetime(Date providerCreatetime) {
        this.providerCreatetime = providerCreatetime;
    }

    public Date getProviderModifytime() {
        return providerModifytime;
    }

    public void setProviderModifytime(Date providerModifytime) {
        this.providerModifytime = providerModifytime;
    }

    public Date getProviderEndtime() {
        return providerEndtime;
    }

    public void setProviderEndtime(Date providerEndtime) {
        this.providerEndtime = providerEndtime;
    }

    public String getProviderRemark() {
        return providerRemark;
    }

    public void setProviderRemark(String providerRemark) {
        this.providerRemark = providerRemark == null ? null : providerRemark.trim();
    }
}