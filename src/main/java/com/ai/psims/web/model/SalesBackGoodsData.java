package com.ai.psims.web.model;

import java.util.Date;

public class SalesBackGoodsData {
	private Integer storageId;
	private String goodsName;
	private String importGoodsUnit;
	private Date goodsProductionDate;
	private Date goodsExpirationDate;
	private Integer storageRateCurrent;
	private Integer salesCount;
	private Integer salesGoodsId;

	public SalesBackGoodsData() {
		super();
	}

	public SalesBackGoodsData(Integer storageId, String goodsName,
			String importGoodsUnit, Date goodsProductionDate,
			Date goodsExpirationDate, Integer storageRateCurrent,
			Integer salesCount, Integer salesGoodsId) {
		super();
		this.storageId = storageId;
		this.goodsName = goodsName;
		this.importGoodsUnit = importGoodsUnit;
		this.goodsProductionDate = goodsProductionDate;
		this.goodsExpirationDate = goodsExpirationDate;
		this.storageRateCurrent = storageRateCurrent;
		this.salesCount = salesCount;
		this.salesGoodsId = salesGoodsId;
	}

	public Integer getSalesGoodsId() {
		return salesGoodsId;
	}

	public void setSalesGoodsId(Integer salesGoodsId) {
		this.salesGoodsId = salesGoodsId;
	}

	public Integer getStorageId() {
		return storageId;
	}

	public void setStorageId(Integer storageId) {
		this.storageId = storageId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getImportGoodsUnit() {
		return importGoodsUnit;
	}

	public void setImportGoodsUnit(String importGoodsUnit) {
		this.importGoodsUnit = importGoodsUnit;
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

	public void setGoodsExpirationDate(Date date) {
		this.goodsExpirationDate = date;
	}

	public Integer getStorageRateCurrent() {
		return storageRateCurrent;
	}

	public void setStorageRateCurrent(Integer storageRateCurrent) {
		this.storageRateCurrent = storageRateCurrent;
	}

	public Integer getSalesCount() {
		return salesCount;
	}

	public void setSalesCount(Integer salesCount) {
		this.salesCount = salesCount;
	}

}
