package com.ai.psims.web.model;

import java.util.Date;

public class RecoveryImport {
    private Integer recoveryImportId;

    private String recoveryImportName;

    private String recoveryImportType;

    private Integer recoveryImportCount;

    private String providerName;

    private String providerCode;

    private Date recoveryImportTime;

    private String recoveryImportStatus;

    public Integer getRecoveryImportId() {
        return recoveryImportId;
    }

    public void setRecoveryImportId(Integer recoveryImportId) {
        this.recoveryImportId = recoveryImportId;
    }

    public String getRecoveryImportName() {
        return recoveryImportName;
    }

    public void setRecoveryImportName(String recoveryImportName) {
        this.recoveryImportName = recoveryImportName == null ? null : recoveryImportName.trim();
    }

    public String getRecoveryImportType() {
        return recoveryImportType;
    }

    public void setRecoveryImportType(String recoveryImportType) {
        this.recoveryImportType = recoveryImportType == null ? null : recoveryImportType.trim();
    }

    public Integer getRecoveryImportCount() {
        return recoveryImportCount;
    }

    public void setRecoveryImportCount(Integer recoveryImportCount) {
        this.recoveryImportCount = recoveryImportCount;
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

    public Date getRecoveryImportTime() {
        return recoveryImportTime;
    }

    public void setRecoveryImportTime(Date recoveryImportTime) {
        this.recoveryImportTime = recoveryImportTime;
    }

    public String getRecoveryImportStatus() {
        return recoveryImportStatus;
    }

    public void setRecoveryImportStatus(String recoveryImportStatus) {
        this.recoveryImportStatus = recoveryImportStatus == null ? null : recoveryImportStatus.trim();
    }
}