package com.ai.psims.web.model;

import java.util.Date;

public class SalesGoodsLog {
    private Integer logId;

    private Date logDatetime;

    private Integer salesGoodsId;

    private String salesSerialNumber;

    private String salesGoodsType;

    private Integer salesGoodsAmount;

    private String salesGoodsUnit;

    private String salesGoodsPrice;

    private Date salesGoodsProductionDate;

    private Date salesGoodsExpirationDate;

    private String salesGoodsTotalPrice;

    private String salesDiscountAmount;

    private String salesFinalAmount;

    private Date salesGoodsCreatetime;

    private Date salesGoodsModifytime;

    private Date salesGoodsEndtime;

    private String salesGoodsRemark;

    private Integer storageId;

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

    private String goodsActualCost;

    private String goodsPrice;

    private String goodsProfit;

    private String goodsDiscountAmount;

    private String goodsType;

    private String goodsStatus;

    private Date goodsCreatetime;

    private Date goodsModifytime;

    private Date goodsEndtime;

    private Integer providerId;

    private String providerName;

    private String providerCode;

    private String remark;

    private String goodsDiscount;

    private String singleRebate;

    private String quarterRebate;

    private String annualRebate;

    private String purchaseRebate;

    private String promotionRebate;

    private String providerSubsidy;

    private String customerBottleSubsidy;

    private String customerPackageSubsidy;

    private String providerPackageSubsidy;

    private String customerSubsidy;

    private String otherSubsidy;

    private String singleFinalCost;

    private Integer storageWarning;

    private Integer shelfLifeWarning;

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

    public String getSalesGoodsPrice() {
        return salesGoodsPrice;
    }

    public void setSalesGoodsPrice(String salesGoodsPrice) {
        this.salesGoodsPrice = salesGoodsPrice == null ? null : salesGoodsPrice.trim();
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

    public String getSalesGoodsTotalPrice() {
        return salesGoodsTotalPrice;
    }

    public void setSalesGoodsTotalPrice(String salesGoodsTotalPrice) {
        this.salesGoodsTotalPrice = salesGoodsTotalPrice == null ? null : salesGoodsTotalPrice.trim();
    }

    public String getSalesDiscountAmount() {
        return salesDiscountAmount;
    }

    public void setSalesDiscountAmount(String salesDiscountAmount) {
        this.salesDiscountAmount = salesDiscountAmount == null ? null : salesDiscountAmount.trim();
    }

    public String getSalesFinalAmount() {
        return salesFinalAmount;
    }

    public void setSalesFinalAmount(String salesFinalAmount) {
        this.salesFinalAmount = salesFinalAmount == null ? null : salesFinalAmount.trim();
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

    public String getGoodsActualCost() {
        return goodsActualCost;
    }

    public void setGoodsActualCost(String goodsActualCost) {
        this.goodsActualCost = goodsActualCost == null ? null : goodsActualCost.trim();
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice == null ? null : goodsPrice.trim();
    }

    public String getGoodsProfit() {
        return goodsProfit;
    }

    public void setGoodsProfit(String goodsProfit) {
        this.goodsProfit = goodsProfit == null ? null : goodsProfit.trim();
    }

    public String getGoodsDiscountAmount() {
        return goodsDiscountAmount;
    }

    public void setGoodsDiscountAmount(String goodsDiscountAmount) {
        this.goodsDiscountAmount = goodsDiscountAmount == null ? null : goodsDiscountAmount.trim();
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

    public String getGoodsDiscount() {
        return goodsDiscount;
    }

    public void setGoodsDiscount(String goodsDiscount) {
        this.goodsDiscount = goodsDiscount == null ? null : goodsDiscount.trim();
    }

    public String getSingleRebate() {
        return singleRebate;
    }

    public void setSingleRebate(String singleRebate) {
        this.singleRebate = singleRebate == null ? null : singleRebate.trim();
    }

    public String getQuarterRebate() {
        return quarterRebate;
    }

    public void setQuarterRebate(String quarterRebate) {
        this.quarterRebate = quarterRebate == null ? null : quarterRebate.trim();
    }

    public String getAnnualRebate() {
        return annualRebate;
    }

    public void setAnnualRebate(String annualRebate) {
        this.annualRebate = annualRebate == null ? null : annualRebate.trim();
    }

    public String getPurchaseRebate() {
        return purchaseRebate;
    }

    public void setPurchaseRebate(String purchaseRebate) {
        this.purchaseRebate = purchaseRebate == null ? null : purchaseRebate.trim();
    }

    public String getPromotionRebate() {
        return promotionRebate;
    }

    public void setPromotionRebate(String promotionRebate) {
        this.promotionRebate = promotionRebate == null ? null : promotionRebate.trim();
    }

    public String getProviderSubsidy() {
        return providerSubsidy;
    }

    public void setProviderSubsidy(String providerSubsidy) {
        this.providerSubsidy = providerSubsidy == null ? null : providerSubsidy.trim();
    }

    public String getCustomerBottleSubsidy() {
        return customerBottleSubsidy;
    }

    public void setCustomerBottleSubsidy(String customerBottleSubsidy) {
        this.customerBottleSubsidy = customerBottleSubsidy == null ? null : customerBottleSubsidy.trim();
    }

    public String getCustomerPackageSubsidy() {
        return customerPackageSubsidy;
    }

    public void setCustomerPackageSubsidy(String customerPackageSubsidy) {
        this.customerPackageSubsidy = customerPackageSubsidy == null ? null : customerPackageSubsidy.trim();
    }

    public String getProviderPackageSubsidy() {
        return providerPackageSubsidy;
    }

    public void setProviderPackageSubsidy(String providerPackageSubsidy) {
        this.providerPackageSubsidy = providerPackageSubsidy == null ? null : providerPackageSubsidy.trim();
    }

    public String getCustomerSubsidy() {
        return customerSubsidy;
    }

    public void setCustomerSubsidy(String customerSubsidy) {
        this.customerSubsidy = customerSubsidy == null ? null : customerSubsidy.trim();
    }

    public String getOtherSubsidy() {
        return otherSubsidy;
    }

    public void setOtherSubsidy(String otherSubsidy) {
        this.otherSubsidy = otherSubsidy == null ? null : otherSubsidy.trim();
    }

    public String getSingleFinalCost() {
        return singleFinalCost;
    }

    public void setSingleFinalCost(String singleFinalCost) {
        this.singleFinalCost = singleFinalCost == null ? null : singleFinalCost.trim();
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