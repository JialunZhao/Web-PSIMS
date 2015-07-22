package com.ai.psims.web.model;

public class TbSalesKey {
    private Integer salesId;

    private String salesSerialNumber;

    public Integer getSalesId() {
        return salesId;
    }

    public void setSalesId(Integer salesId) {
        this.salesId = salesId;
    }

    public String getSalesSerialNumber() {
        return salesSerialNumber;
    }

    public void setSalesSerialNumber(String salesSerialNumber) {
        this.salesSerialNumber = salesSerialNumber == null ? null : salesSerialNumber.trim();
    }
}