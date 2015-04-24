package com.ai.psims.web.model;

import java.util.Date;

public class TbImportGoodsLog {
    private Integer logId;

    private Date logDatetime;

    private Integer importGoodsId;

    private String importSerialNumber;

    private Integer goodsId;

    private String goodsName;

    private String importGoodsType;

    private Integer importGoodsAmount;

    private String importGoodsUnit;

    private Long importGoodsPrice;

    private Long importDiscountAmount;

    private Date importGoodsCreatetime;

    private Date importGoodsModifytime;

    private Date importGoodsEndtime;

    private String importGoodsRemark;

    private String isDiscount;

    private String isBoxBottle;

    private Long totalPrice;

    private Long discountDutyTotalPrice;

    private Long discountTotalPrice;

    private Long discountRate;

    private Long boxBottlePrice;

    private Long boxBottleTotalPrice;

    private Integer resImportGoodsAmount;

    private Integer goodsShelfLife;

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

    public String getIsDiscount() {
        return isDiscount;
    }

    public void setIsDiscount(String isDiscount) {
        this.isDiscount = isDiscount == null ? null : isDiscount.trim();
    }

    public String getIsBoxBottle() {
        return isBoxBottle;
    }

    public void setIsBoxBottle(String isBoxBottle) {
        this.isBoxBottle = isBoxBottle == null ? null : isBoxBottle.trim();
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getDiscountDutyTotalPrice() {
        return discountDutyTotalPrice;
    }

    public void setDiscountDutyTotalPrice(Long discountDutyTotalPrice) {
        this.discountDutyTotalPrice = discountDutyTotalPrice;
    }

    public Long getDiscountTotalPrice() {
        return discountTotalPrice;
    }

    public void setDiscountTotalPrice(Long discountTotalPrice) {
        this.discountTotalPrice = discountTotalPrice;
    }

    public Long getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Long discountRate) {
        this.discountRate = discountRate;
    }

    public Long getBoxBottlePrice() {
        return boxBottlePrice;
    }

    public void setBoxBottlePrice(Long boxBottlePrice) {
        this.boxBottlePrice = boxBottlePrice;
    }

    public Long getBoxBottleTotalPrice() {
        return boxBottleTotalPrice;
    }

    public void setBoxBottleTotalPrice(Long boxBottleTotalPrice) {
        this.boxBottleTotalPrice = boxBottleTotalPrice;
    }

    public Integer getResImportGoodsAmount() {
        return resImportGoodsAmount;
    }

    public void setResImportGoodsAmount(Integer resImportGoodsAmount) {
        this.resImportGoodsAmount = resImportGoodsAmount;
    }

    public Integer getGoodsShelfLife() {
        return goodsShelfLife;
    }

    public void setGoodsShelfLife(Integer goodsShelfLife) {
        this.goodsShelfLife = goodsShelfLife;
    }
}