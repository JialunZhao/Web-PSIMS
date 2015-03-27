package com.ai.psims.web.model;

import java.util.Date;

public class SalesbackGoods {
    private Integer salesbackGoodsId;

    private String salesbackSerialNumber;

    private Integer goodsId;

    private String goodsName;

    private String goodsType;

    private Integer goodsAmount;

    private String goodsUnit;

    private Long goodsPrice;

    private Date goodsProduction;

    private Date goodsExpiration;

    private Long discountAmount;

    private Date createtime;

    private Date modifytime;

    private Date endtime;

    private String remark;

    private Integer storageId;

    public Integer getSalesbackGoodsId() {
        return salesbackGoodsId;
    }

    public void setSalesbackGoodsId(Integer salesbackGoodsId) {
        this.salesbackGoodsId = salesbackGoodsId;
    }

    public String getSalesbackSerialNumber() {
        return salesbackSerialNumber;
    }

    public void setSalesbackSerialNumber(String salesbackSerialNumber) {
        this.salesbackSerialNumber = salesbackSerialNumber == null ? null : salesbackSerialNumber.trim();
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

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }

    public Integer getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(Integer goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit == null ? null : goodsUnit.trim();
    }

    public Long getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Long goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Date getGoodsProduction() {
        return goodsProduction;
    }

    public void setGoodsProduction(Date goodsProduction) {
        this.goodsProduction = goodsProduction;
    }

    public Date getGoodsExpiration() {
        return goodsExpiration;
    }

    public void setGoodsExpiration(Date goodsExpiration) {
        this.goodsExpiration = goodsExpiration;
    }

    public Long getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Long discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getStorageId() {
        return storageId;
    }

    public void setStorageId(Integer storageId) {
        this.storageId = storageId;
    }
}