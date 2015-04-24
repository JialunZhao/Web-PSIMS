package com.ai.psims.web.model;

public class AddSalesbackData {
	private String storageIdList;
	private String changeCountList;
	private String salesSerialNumber;
	private String backReson;
	private String backgoodsTime;

	public AddSalesbackData(String storageIdList, String changeCountList,
			String salesSerialNumber, String backReson, String backgoodsTime) {
		super();
		this.storageIdList = storageIdList;
		this.changeCountList = changeCountList;
		this.salesSerialNumber = salesSerialNumber;
		this.backReson = backReson;
		this.backgoodsTime = backgoodsTime;
	}

	public String getStorageIdList() {
		return storageIdList;
	}

	public void setStorageIdList(String storageIdList) {
		this.storageIdList = storageIdList;
	}

	public String getChangeCountList() {
		return changeCountList;
	}

	public void setChangeCountList(String changeCountList) {
		this.changeCountList = changeCountList;
	}

	public String getSalesSerialNumber() {
		return salesSerialNumber;
	}

	public void setSalesSerialNumber(String salesSerialNumber) {
		this.salesSerialNumber = salesSerialNumber;
	}

	public String getBackReson() {
		return backReson;
	}

	public void setBackReson(String backReson) {
		this.backReson = backReson;
	}

	public String getBackgoodsTime() {
		return backgoodsTime;
	}

	public void setBackgoodsTime(String backgoodsTime) {
		this.backgoodsTime = backgoodsTime;
	}

}
