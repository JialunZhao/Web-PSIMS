package com.ai.psims.web.model;

import java.util.Date;

public class Sales extends TbSalesKey {
    private Date salesDate;

    private Integer customerId;

    private String customerName;

    private Integer storehouseId;

    private String storehouseName;

    private Integer employeeId;

    private String employeeName;

    private String incomeType;

    private Date incomeTime;

    private String totalSalesAmount;

    private String totalSettlementAmount;

    private String totalCreditAmount;

    private String salesStatus;

    private String salesType;

    private String salesRemark;

    private String storehouseManager;

    private String touchingManager;

    private String receiver;

    private String sender;

    private String carNumber;

    private Date departureTime;

    private Date stillTime;

    private String startOilNumber;

    private String returnOilNumber;

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
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

    public Integer getStorehouseId() {
        return storehouseId;
    }

    public void setStorehouseId(Integer storehouseId) {
        this.storehouseId = storehouseId;
    }

    public String getStorehouseName() {
        return storehouseName;
    }

    public void setStorehouseName(String storehouseName) {
        this.storehouseName = storehouseName == null ? null : storehouseName.trim();
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? null : employeeName.trim();
    }

    public String getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType == null ? null : incomeType.trim();
    }

    public Date getIncomeTime() {
        return incomeTime;
    }

    public void setIncomeTime(Date incomeTime) {
        this.incomeTime = incomeTime;
    }

    public String getTotalSalesAmount() {
        return totalSalesAmount;
    }

    public void setTotalSalesAmount(String totalSalesAmount) {
        this.totalSalesAmount = totalSalesAmount == null ? null : totalSalesAmount.trim();
    }

    public String getTotalSettlementAmount() {
        return totalSettlementAmount;
    }

    public void setTotalSettlementAmount(String totalSettlementAmount) {
        this.totalSettlementAmount = totalSettlementAmount == null ? null : totalSettlementAmount.trim();
    }

    public String getTotalCreditAmount() {
        return totalCreditAmount;
    }

    public void setTotalCreditAmount(String totalCreditAmount) {
        this.totalCreditAmount = totalCreditAmount == null ? null : totalCreditAmount.trim();
    }

    public String getSalesStatus() {
        return salesStatus;
    }

    public void setSalesStatus(String salesStatus) {
        this.salesStatus = salesStatus == null ? null : salesStatus.trim();
    }

    public String getSalesType() {
        return salesType;
    }

    public void setSalesType(String salesType) {
        this.salesType = salesType == null ? null : salesType.trim();
    }

    public String getSalesRemark() {
        return salesRemark;
    }

    public void setSalesRemark(String salesRemark) {
        this.salesRemark = salesRemark == null ? null : salesRemark.trim();
    }

    public String getStorehouseManager() {
        return storehouseManager;
    }

    public void setStorehouseManager(String storehouseManager) {
        this.storehouseManager = storehouseManager == null ? null : storehouseManager.trim();
    }

    public String getTouchingManager() {
        return touchingManager;
    }

    public void setTouchingManager(String touchingManager) {
        this.touchingManager = touchingManager == null ? null : touchingManager.trim();
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber == null ? null : carNumber.trim();
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getStillTime() {
        return stillTime;
    }

    public void setStillTime(Date stillTime) {
        this.stillTime = stillTime;
    }

    public String getStartOilNumber() {
        return startOilNumber;
    }

    public void setStartOilNumber(String startOilNumber) {
        this.startOilNumber = startOilNumber == null ? null : startOilNumber.trim();
    }

    public String getReturnOilNumber() {
        return returnOilNumber;
    }

    public void setReturnOilNumber(String returnOilNumber) {
        this.returnOilNumber = returnOilNumber == null ? null : returnOilNumber.trim();
    }
}