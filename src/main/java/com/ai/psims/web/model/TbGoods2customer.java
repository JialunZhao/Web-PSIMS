package com.ai.psims.web.model;

import java.util.Date;

public class TbGoods2customer {
    private Integer goods2customerId;

    private Integer goodsId;

    private String goodsName;

    private String goodsCode;

    private Integer customerId;

    private String customerName;

    private String customerCode;

    private Integer goodsVersion;

    private String goodsUnit;

    private String goodsBarCode;

    private Integer goodsShelfLife;

    private Long goodsPrice;

    private Integer goodsDiscount;

    private Long goodsDiscountAmount;

    private String goodsType;

    private String goodsStatus;

    private Date goodsCreatetime;

    private Date goodsModifytime;

    private Date goodsEndtime;

    private Integer providerId;

    private String providerName;

    private String providerCode;

    private Long quarterRebate;

    private Long annualRebate;

    private Long providerSubsidy;

    private Long providerPackageSubsidy;

    private Long customerSubsidy;

    private Long otherSubsidy;

    private Long goodsActualCost;

    private Long goodsProfit;

    private String remark;

    public Integer getGoods2customerId() {
        return goods2customerId;
    }

    public void setGoods2customerId(Integer goods2customerId) {
        this.goods2customerId = goods2customerId;
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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode == null ? null : customerCode.trim();
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

    public Integer getGoodsShelfLife() {
        return goodsShelfLife;
    }

    public void setGoodsShelfLife(Integer goodsShelfLife) {
        this.goodsShelfLife = goodsShelfLife;
    }

    public Long getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Long goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsDiscount() {
        return goodsDiscount;
    }

    public void setGoodsDiscount(Integer goodsDiscount) {
        this.goodsDiscount = goodsDiscount;
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

    public Long getGoodsProfit() {
        return goodsProfit;
    }

    public void setGoodsProfit(Long goodsProfit) {
        this.goodsProfit = goodsProfit;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}