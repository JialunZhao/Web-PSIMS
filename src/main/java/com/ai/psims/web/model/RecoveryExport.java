package com.ai.psims.web.model;

import java.util.Date;

public class RecoveryExport {
    private Integer recoveryExportId;

    private String recoveryExportName;

    private String recoveryExportType;

    private Integer recoveryExportCount;

    private String providerName;

    private String providerCode;

    private Date recoveryExportTime;

    private String recoveryExportStatus;

    public Integer getRecoveryExportId() {
        return recoveryExportId;
    }

    public void setRecoveryExportId(Integer recoveryExportId) {
        this.recoveryExportId = recoveryExportId;
    }

    public String getRecoveryExportName() {
        return recoveryExportName;
    }

    public void setRecoveryExportName(String recoveryExportName) {
        this.recoveryExportName = recoveryExportName == null ? null : recoveryExportName.trim();
    }

    public String getRecoveryExportType() {
        return recoveryExportType;
    }

    public void setRecoveryExportType(String recoveryExportType) {
        this.recoveryExportType = recoveryExportType == null ? null : recoveryExportType.trim();
    }

    public Integer getRecoveryExportCount() {
        return recoveryExportCount;
    }

    public void setRecoveryExportCount(Integer recoveryExportCount) {
        this.recoveryExportCount = recoveryExportCount;
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

    public Date getRecoveryExportTime() {
        return recoveryExportTime;
    }

    public void setRecoveryExportTime(Date recoveryExportTime) {
        this.recoveryExportTime = recoveryExportTime;
    }

    public String getRecoveryExportStatus() {
        return recoveryExportStatus;
    }

    public void setRecoveryExportStatus(String recoveryExportStatus) {
        this.recoveryExportStatus = recoveryExportStatus == null ? null : recoveryExportStatus.trim();
    }
}