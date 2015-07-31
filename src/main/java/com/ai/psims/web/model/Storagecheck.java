package com.ai.psims.web.model;

import java.util.Date;

public class Storagecheck {
    private Integer storageId;

    private Integer goodsId;

    private String goodsName;

    private String goodsBarCode;

    private Integer providerId;

    private String providerName;

    private Integer storageRateCurrent;

    private Integer storageRateTotal;

    private Date goodsProductionDate;

    private Date goodsExpirationDate;

    private Integer goodsShelfLife;

    private String goodsPrice;

    private String goodsStatus;

    private String storageType;

    private Date createtime;

    private Date modifytime;

    private Date endtime;

    private String remark;

    private String importSerialNumber;

    private String importGoodsUnit;

    private Integer storageWarning;

    private Integer shelfLifeWarning;
    
    private String overDate;
    private Integer storageCurrentTotal;
    
    

    public Integer getStorageId() {
        return storageId;
    }

    public void setStorageId(Integer storageId) {
        this.storageId = storageId;
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

    public String getGoodsBarCode() {
        return goodsBarCode;
    }

    public void setGoodsBarCode(String goodsBarCode) {
        this.goodsBarCode = goodsBarCode == null ? null : goodsBarCode.trim();
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

    public Integer getStorageRateCurrent() {
        return storageRateCurrent;
    }

    public void setStorageRateCurrent(Integer storageRateCurrent) {
        this.storageRateCurrent = storageRateCurrent;
    }

    public Integer getStorageRateTotal() {
        return storageRateTotal;
    }

    public void setStorageRateTotal(Integer storageRateTotal) {
        this.storageRateTotal = storageRateTotal;
    }

    public Date getGoodsProductionDate() {
        return goodsProductionDate;
    }

    public void setGoodsProductionDate(Date goodsProductionDate) {
        this.goodsProductionDate = goodsProductionDate;
    }

    public Date getGoodsExpirationDate() {
        return goodsExpirationDate;
    }

    public void setGoodsExpirationDate(Date goodsExpirationDate) {
        this.goodsExpirationDate = goodsExpirationDate;
    }

    public Integer getGoodsShelfLife() {
        return goodsShelfLife;
    }

    public void setGoodsShelfLife(Integer goodsShelfLife) {
        this.goodsShelfLife = goodsShelfLife;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(String goodsStatus) {
        this.goodsStatus = goodsStatus == null ? null : goodsStatus.trim();
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType == null ? null : storageType.trim();
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

    public String getImportSerialNumber() {
        return importSerialNumber;
    }

    public void setImportSerialNumber(String importSerialNumber) {
        this.importSerialNumber = importSerialNumber == null ? null : importSerialNumber.trim();
    }

    public String getImportGoodsUnit() {
        return importGoodsUnit;
    }

    public void setImportGoodsUnit(String importGoodsUnit) {
        this.importGoodsUnit = importGoodsUnit == null ? null : importGoodsUnit.trim();
    }

    public Integer getStorageWarning() {
        return storageWarning;
    }

    public void setStorageWarning(Integer storageWarning) {
        this.storageWarning = storageWarning;
    }

    public Integer getShelfLifeWarning() {
        return shelfLifeWarning;
    }

    public void setShelfLifeWarning(Integer shelfLifeWarning) {
        this.shelfLifeWarning = shelfLifeWarning;
    }

	public Integer getStorageCurrentTotal() {
		return storageCurrentTotal;
	}

	public void setStorageCurrentTotal(Integer storageCurrentTotal) {
		this.storageCurrentTotal = storageCurrentTotal;
	}

	public String getOverDate() {
		return overDate;
	}

	public void setOverDate(String overDate) {
		this.overDate = overDate;
	}

}