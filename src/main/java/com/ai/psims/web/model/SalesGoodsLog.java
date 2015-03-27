package com.ai.psims.web.model;

import java.util.Date;

public class SalesGoodsLog {
    private Integer logId;

    private Date logDatetime;

    private Integer salesGoodsId;

    private String salesSerialNumber;

    private Integer goodsId;

    private String goodsName;

    private String salesGoodsType;

    private Integer salesGoodsAmount;

    private String salesGoodsUnit;

    private Long salesGoodsPrice;

    private Date salesGoodsProductionDate;

    private Date salesGoodsExpirationDate;

    private Long salesGoodsTotalPrice;

    private Long salesDiscountAmount;

    private Long salesFinalAmount;

    private Date salesGoodsCreatetime;

    private Date salesGoodsModifytime;

    private Date salesGoodsEndtime;

    private String salesGoodsRemark;

    private Integer storageId;

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

    public Integer getSalesGoodsId() {
        return salesGoodsId;
    }

    public void setSalesGoodsId(Integer salesGoodsId) {
        this.salesGoodsId = salesGoodsId;
    }

    public String getSalesSerialNumber() {
        return salesSerialNumber;
    }

    public void setSalesSerialNumber(String salesSerialNumber) {
        this.salesSerialNumber = salesSerialNumber == null ? null : salesSerialNumber.trim();
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getSalesGoodsType() {
        return salesGoodsType;
    }

    public void setSalesGoodsType(String salesGoodsType) {
        this.salesGoodsType = salesGoodsType == null ? null : salesGoodsType.trim();
    }

    public Integer getSalesGoodsAmount() {
        return salesGoodsAmount;
    }

    public void setSalesGoodsAmount(Integer salesGoodsAmount) {
        this.salesGoodsAmount = salesGoodsAmount;
    }

    public String getSalesGoodsUnit() {
        return salesGoodsUnit;
    }

    public void setSalesGoodsUnit(String salesGoodsUnit) {
        this.salesGoodsUnit = salesGoodsUnit == null ? null : salesGoodsUnit.trim();
    }

    public Long getSalesGoodsPrice() {
        return salesGoodsPrice;
    }

    public void setSalesGoodsPrice(Long salesGoodsPrice) {
        this.salesGoodsPrice = salesGoodsPrice;
    }

    public Date getSalesGoodsProductionDate() {
        return salesGoodsProductionDate;
    }

    public void setSalesGoodsProductionDate(Date salesGoodsProductionDate) {
        this.salesGoodsProductionDate = salesGoodsProductionDate;
    }

    public Date getSalesGoodsExpirationDate() {
        return salesGoodsExpirationDate;
    }

    public void setSalesGoodsExpirationDate(Date salesGoodsExpirationDate) {
        this.salesGoodsExpirationDate = salesGoodsExpirationDate;
    }

    public Long getSalesGoodsTotalPrice() {
        return salesGoodsTotalPrice;
    }

    public void setSalesGoodsTotalPrice(Long salesGoodsTotalPrice) {
        this.salesGoodsTotalPrice = salesGoodsTotalPrice;
    }

    public Long getSalesDiscountAmount() {
        return salesDiscountAmount;
    }

    public void setSalesDiscountAmount(Long salesDiscountAmount) {
        this.salesDiscountAmount = salesDiscountAmount;
    }

    public Long getSalesFinalAmount() {
        return salesFinalAmount;
    }

    public void setSalesFinalAmount(Long salesFinalAmount) {
        this.salesFinalAmount = salesFinalAmount;
    }

    public Date getSalesGoodsCreatetime() {
        return salesGoodsCreatetime;
    }

    public void setSalesGoodsCreatetime(Date salesGoodsCreatetime) {
        this.salesGoodsCreatetime = salesGoodsCreatetime;
    }

    public Date getSalesGoodsModifytime() {
        return salesGoodsModifytime;
    }

    public void setSalesGoodsModifytime(Date salesGoodsModifytime) {
        this.salesGoodsModifytime = salesGoodsModifytime;
    }

    public Date getSalesGoodsEndtime() {
        return salesGoodsEndtime;
    }

    public void setSalesGoodsEndtime(Date salesGoodsEndtime) {
        this.salesGoodsEndtime = salesGoodsEndtime;
    }

    public String getSalesGoodsRemark() {
        return salesGoodsRemark;
    }

    public void setSalesGoodsRemark(String salesGoodsRemark) {
        this.salesGoodsRemark = salesGoodsRemark == null ? null : salesGoodsRemark.trim();
    }

    public Integer getStorageId() {
        return storageId;
    }

    public void setStorageId(Integer storageId) {
        this.storageId = storageId;
    }
}