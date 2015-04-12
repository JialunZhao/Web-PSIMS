package com.ai.psims.web.model;

import java.util.Date;

public class ImportbackGoods {
    private Integer importbackGoodsId;

    private String importbackSerialNumber;

    private Integer goodsId;

    private String goodsName;

    private String importbackGoodsType;

    private Integer importbackGoodsAmount;

    private String importbackGoodsUnit;

    private Long importbackGoodsPrice;

    private Date importbackGoodsProduction;

    private Date importbackGoodsExpiration;

    private Long importbackDiscountAmount;

    private Date importbackGoodsCreatetime;

    private Date importbackGoodsModifytime;

    private Date importbackGoodsEndtime;

    private String importbackGoodsRemark;

    public Integer getImportbackGoodsId() {
        return importbackGoodsId;
    }

    public void setImportbackGoodsId(Integer importbackGoodsId) {
        this.importbackGoodsId = importbackGoodsId;
    }

    public String getImportbackSerialNumber() {
        return importbackSerialNumber;
    }

    public void setImportbackSerialNumber(String importbackSerialNumber) {
        this.importbackSerialNumber = importbackSerialNumber == null ? null : importbackSerialNumber.trim();
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

    public String getImportbackGoodsType() {
        return importbackGoodsType;
    }

    public void setImportbackGoodsType(String importbackGoodsType) {
        this.importbackGoodsType = importbackGoodsType == null ? null : importbackGoodsType.trim();
    }

    public Integer getImportbackGoodsAmount() {
        return importbackGoodsAmount;
    }

    public void setImportbackGoodsAmount(Integer importbackGoodsAmount) {
        this.importbackGoodsAmount = importbackGoodsAmount;
    }

    public String getImportbackGoodsUnit() {
        return importbackGoodsUnit;
    }

    public void setImportbackGoodsUnit(String importbackGoodsUnit) {
        this.importbackGoodsUnit = importbackGoodsUnit == null ? null : importbackGoodsUnit.trim();
    }

    public Long getImportbackGoodsPrice() {
        return importbackGoodsPrice;
    }

    public void setImportbackGoodsPrice(Long importbackGoodsPrice) {
        this.importbackGoodsPrice = importbackGoodsPrice;
    }

    public Date getImportbackGoodsProduction() {
        return importbackGoodsProduction;
    }

    public void setImportbackGoodsProduction(Date importbackGoodsProduction) {
        this.importbackGoodsProduction = importbackGoodsProduction;
    }

    public Date getImportbackGoodsExpiration() {
        return importbackGoodsExpiration;
    }

    public void setImportbackGoodsExpiration(Date importbackGoodsExpiration) {
        this.importbackGoodsExpiration = importbackGoodsExpiration;
    }

    public Long getImportbackDiscountAmount() {
        return importbackDiscountAmount;
    }

    public void setImportbackDiscountAmount(Long importbackDiscountAmount) {
        this.importbackDiscountAmount = importbackDiscountAmount;
    }

    public Date getImportbackGoodsCreatetime() {
        return importbackGoodsCreatetime;
    }

    public void setImportbackGoodsCreatetime(Date importbackGoodsCreatetime) {
        this.importbackGoodsCreatetime = importbackGoodsCreatetime;
    }

    public Date getImportbackGoodsModifytime() {
        return importbackGoodsModifytime;
    }

    public void setImportbackGoodsModifytime(Date importbackGoodsModifytime) {
        this.importbackGoodsModifytime = importbackGoodsModifytime;
    }

    public Date getImportbackGoodsEndtime() {
        return importbackGoodsEndtime;
    }

    public void setImportbackGoodsEndtime(Date importbackGoodsEndtime) {
        this.importbackGoodsEndtime = importbackGoodsEndtime;
    }

    public String getImportbackGoodsRemark() {
        return importbackGoodsRemark;
    }

    public void setImportbackGoodsRemark(String importbackGoodsRemark) {
        this.importbackGoodsRemark = importbackGoodsRemark == null ? null : importbackGoodsRemark.trim();
    }
}