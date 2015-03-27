package com.ai.psims.web.model;

import java.util.Date;

public class ImportGoods {
    private Integer importGoodsId;

    private String importSerialNumber;

    private Integer goodsId;

    private String goodsName;

    private String importGoodsType;

    private Integer importGoodsAmount;

    private String importGoodsUnit;

    private Long importGoodsPrice;

    private Date importGoodsProductionDate;

    private Date importGoodsExpirationDate;

    private Long importDiscountAmount;

    private Date importGoodsCreatetime;

    private Date importGoodsModifytime;

    private Date importGoodsEndtime;

    private String importGoodsRemark;

    public Integer getImportGoodsId() {
        return importGoodsId;
    }

    public void setImportGoodsId(Integer importGoodsId) {
        this.importGoodsId = importGoodsId;
    }

    public String getImportSerialNumber() {
        return importSerialNumber;
    }

    public void setImportSerialNumber(String importSerialNumber) {
        this.importSerialNumber = importSerialNumber == null ? null : importSerialNumber.trim();
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

    public String getImportGoodsType() {
        return importGoodsType;
    }

    public void setImportGoodsType(String importGoodsType) {
        this.importGoodsType = importGoodsType == null ? null : importGoodsType.trim();
    }

    public Integer getImportGoodsAmount() {
        return importGoodsAmount;
    }

    public void setImportGoodsAmount(Integer importGoodsAmount) {
        this.importGoodsAmount = importGoodsAmount;
    }

    public String getImportGoodsUnit() {
        return importGoodsUnit;
    }

    public void setImportGoodsUnit(String importGoodsUnit) {
        this.importGoodsUnit = importGoodsUnit == null ? null : importGoodsUnit.trim();
    }

    public Long getImportGoodsPrice() {
        return importGoodsPrice;
    }

    public void setImportGoodsPrice(Long importGoodsPrice) {
        this.importGoodsPrice = importGoodsPrice;
    }

    public Date getImportGoodsProductionDate() {
        return importGoodsProductionDate;
    }

    public void setImportGoodsProductionDate(Date importGoodsProductionDate) {
        this.importGoodsProductionDate = importGoodsProductionDate;
    }

    public Date getImportGoodsExpirationDate() {
        return importGoodsExpirationDate;
    }

    public void setImportGoodsExpirationDate(Date importGoodsExpirationDate) {
        this.importGoodsExpirationDate = importGoodsExpirationDate;
    }

    public Long getImportDiscountAmount() {
        return importDiscountAmount;
    }

    public void setImportDiscountAmount(Long importDiscountAmount) {
        this.importDiscountAmount = importDiscountAmount;
    }

    public Date getImportGoodsCreatetime() {
        return importGoodsCreatetime;
    }

    public void setImportGoodsCreatetime(Date importGoodsCreatetime) {
        this.importGoodsCreatetime = importGoodsCreatetime;
    }

    public Date getImportGoodsModifytime() {
        return importGoodsModifytime;
    }

    public void setImportGoodsModifytime(Date importGoodsModifytime) {
        this.importGoodsModifytime = importGoodsModifytime;
    }

    public Date getImportGoodsEndtime() {
        return importGoodsEndtime;
    }

    public void setImportGoodsEndtime(Date importGoodsEndtime) {
        this.importGoodsEndtime = importGoodsEndtime;
    }

    public String getImportGoodsRemark() {
        return importGoodsRemark;
    }

    public void setImportGoodsRemark(String importGoodsRemark) {
        this.importGoodsRemark = importGoodsRemark == null ? null : importGoodsRemark.trim();
    }
}