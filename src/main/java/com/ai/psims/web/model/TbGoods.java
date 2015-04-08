package com.ai.psims.web.model;

import java.util.Date;

public class TbGoods {
    private Integer goodsId;

    private String goodsName;

    private String goodsCode;

    private Integer goodsVersion;

    private String goodsUnit;

    private String goodsBarCode;

    private Integer goodsCurrentStock;

    private Integer goodsTotalStock;

    private Date goodsProductionDate;

    private Date goodsExpirationDate;

    private Integer goodsShelfLife;

    private Long goodsProfit;

    private Long goodsPrice;

    private Long goodsDiscountAmount;

    private String goodsType;

    private String goodsStatus;

    private Date goodsCreatetime;

    private Date goodsModifytime;

    private Date goodsEndtime;

    private Integer providerId;

    private String providerName;

    private String providerCode;

    private String remark;

    private Integer goodsDiscount;

    private Long quarterRebate;

    private Long annualRebate;

    private Long providerSubsidy;

    private Long providerPackageSubsidy;

    private Long customerSubsidy;

    private Long otherSubsidy;

    private Long goodsActualCost;

    private Integer storageWarning;

    private Integer shelfLifeWarning;

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

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode == null ? null : goodsCode.trim();
    }

    public Integer getGoodsVersion() {
        return goodsVersion;
    }

    public void setGoodsVersion(Integer goodsVersion) {
        this.goodsVersion = goodsVersion;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit == null ? null : goodsUnit.trim();
    }

    public String getGoodsBarCode() {
        return goodsBarCode;
    }

    public void setGoodsBarCode(String goodsBarCode) {
        this.goodsBarCode = goodsBarCode == null ? null : goodsBarCode.trim();
    }

    public Integer getGoodsCurrentStock() {
        return goodsCurrentStock;
    }

    public void setGoodsCurrentStock(Integer goodsCurrentStock) {
        this.goodsCurrentStock = goodsCurrentStock;
    }

    public Integer getGoodsTotalStock() {
        return goodsTotalStock;
    }

    public void setGoodsTotalStock(Integer goodsTotalStock) {
        this.goodsTotalStock = goodsTotalStock;
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

    public Long getGoodsProfit() {
        return goodsProfit;
    }

    public void setGoodsProfit(Long goodsProfit) {
        this.goodsProfit = goodsProfit;
    }

    public Long getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Long goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Long getGoodsDiscountAmount() {
        return goodsDiscountAmount;
    }

    public void setGoodsDiscountAmount(Long goodsDiscountAmount) {
        this.goodsDiscountAmount = goodsDiscountAmount;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }

    public String getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(String goodsStatus) {
        this.goodsStatus = goodsStatus == null ? null : goodsStatus.trim();
    }

    public Date getGoodsCreatetime() {
        return goodsCreatetime;
    }

    public void setGoodsCreatetime(Date goodsCreatetime) {
        this.goodsCreatetime = goodsCreatetime;
    }

    public Date getGoodsModifytime() {
        return goodsModifytime;
    }

    public void setGoodsModifytime(Date goodsModifytime) {
        this.goodsModifytime = goodsModifytime;
    }

    public Date getGoodsEndtime() {
        return goodsEndtime;
    }

    public void setGoodsEndtime(Date goodsEndtime) {
        this.goodsEndtime = goodsEndtime;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getGoodsDiscount() {
        return goodsDiscount;
    }

    public void setGoodsDiscount(Integer goodsDiscount) {
        this.goodsDiscount = goodsDiscount;
    }

    public Long getQuarterRebate() {
        return quarterRebate;
    }

    public void setQuarterRebate(Long quarterRebate) {
        this.quarterRebate = quarterRebate;
    }

    public Long getAnnualRebate() {
        return annualRebate;
    }

    public void setAnnualRebate(Long annualRebate) {
        this.annualRebate = annualRebate;
    }

    public Long getProviderSubsidy() {
        return providerSubsidy;
    }

    public void setProviderSubsidy(Long providerSubsidy) {
        this.providerSubsidy = providerSubsidy;
    }

    public Long getProviderPackageSubsidy() {
        return providerPackageSubsidy;
    }

    public void setProviderPackageSubsidy(Long providerPackageSubsidy) {
        this.providerPackageSubsidy = providerPackageSubsidy;
    }

    public Long getCustomerSubsidy() {
        return customerSubsidy;
    }

    public void setCustomerSubsidy(Long customerSubsidy) {
        this.customerSubsidy = customerSubsidy;
    }

    public Long getOtherSubsidy() {
        return otherSubsidy;
    }

    public void setOtherSubsidy(Long otherSubsidy) {
        this.otherSubsidy = otherSubsidy;
    }

    public Long getGoodsActualCost() {
        return goodsActualCost;
    }

    public void setGoodsActualCost(Long goodsActualCost) {
        this.goodsActualCost = goodsActualCost;
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
}