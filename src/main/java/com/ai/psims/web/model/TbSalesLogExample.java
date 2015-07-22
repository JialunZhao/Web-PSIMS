package com.ai.psims.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbSalesLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSalesLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andLogIdIsNull() {
            addCriterion("log_id is null");
            return (Criteria) this;
        }

        public Criteria andLogIdIsNotNull() {
            addCriterion("log_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogIdEqualTo(Integer value) {
            addCriterion("log_id =", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotEqualTo(Integer value) {
            addCriterion("log_id <>", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThan(Integer value) {
            addCriterion("log_id >", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("log_id >=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThan(Integer value) {
            addCriterion("log_id <", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThanOrEqualTo(Integer value) {
            addCriterion("log_id <=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdIn(List<Integer> values) {
            addCriterion("log_id in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotIn(List<Integer> values) {
            addCriterion("log_id not in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdBetween(Integer value1, Integer value2) {
            addCriterion("log_id between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("log_id not between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogDatetimeIsNull() {
            addCriterion("log_datetime is null");
            return (Criteria) this;
        }

        public Criteria andLogDatetimeIsNotNull() {
            addCriterion("log_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andLogDatetimeEqualTo(Date value) {
            addCriterion("log_datetime =", value, "logDatetime");
            return (Criteria) this;
        }

        public Criteria andLogDatetimeNotEqualTo(Date value) {
            addCriterion("log_datetime <>", value, "logDatetime");
            return (Criteria) this;
        }

        public Criteria andLogDatetimeGreaterThan(Date value) {
            addCriterion("log_datetime >", value, "logDatetime");
            return (Criteria) this;
        }

        public Criteria andLogDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("log_datetime >=", value, "logDatetime");
            return (Criteria) this;
        }

        public Criteria andLogDatetimeLessThan(Date value) {
            addCriterion("log_datetime <", value, "logDatetime");
            return (Criteria) this;
        }

        public Criteria andLogDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("log_datetime <=", value, "logDatetime");
            return (Criteria) this;
        }

        public Criteria andLogDatetimeIn(List<Date> values) {
            addCriterion("log_datetime in", values, "logDatetime");
            return (Criteria) this;
        }

        public Criteria andLogDatetimeNotIn(List<Date> values) {
            addCriterion("log_datetime not in", values, "logDatetime");
            return (Criteria) this;
        }

        public Criteria andLogDatetimeBetween(Date value1, Date value2) {
            addCriterion("log_datetime between", value1, value2, "logDatetime");
            return (Criteria) this;
        }

        public Criteria andLogDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("log_datetime not between", value1, value2, "logDatetime");
            return (Criteria) this;
        }

        public Criteria andSalesIdIsNull() {
            addCriterion("sales_id is null");
            return (Criteria) this;
        }

        public Criteria andSalesIdIsNotNull() {
            addCriterion("sales_id is not null");
            return (Criteria) this;
        }

        public Criteria andSalesIdEqualTo(Integer value) {
            addCriterion("sales_id =", value, "salesId");
            return (Criteria) this;
        }

        public Criteria andSalesIdNotEqualTo(Integer value) {
            addCriterion("sales_id <>", value, "salesId");
            return (Criteria) this;
        }

        public Criteria andSalesIdGreaterThan(Integer value) {
            addCriterion("sales_id >", value, "salesId");
            return (Criteria) this;
        }

        public Criteria andSalesIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sales_id >=", value, "salesId");
            return (Criteria) this;
        }

        public Criteria andSalesIdLessThan(Integer value) {
            addCriterion("sales_id <", value, "salesId");
            return (Criteria) this;
        }

        public Criteria andSalesIdLessThanOrEqualTo(Integer value) {
            addCriterion("sales_id <=", value, "salesId");
            return (Criteria) this;
        }

        public Criteria andSalesIdIn(List<Integer> values) {
            addCriterion("sales_id in", values, "salesId");
            return (Criteria) this;
        }

        public Criteria andSalesIdNotIn(List<Integer> values) {
            addCriterion("sales_id not in", values, "salesId");
            return (Criteria) this;
        }

        public Criteria andSalesIdBetween(Integer value1, Integer value2) {
            addCriterion("sales_id between", value1, value2, "salesId");
            return (Criteria) this;
        }

        public Criteria andSalesIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sales_id not between", value1, value2, "salesId");
            return (Criteria) this;
        }

        public Criteria andSalesSerialNumberIsNull() {
            addCriterion("sales_serial_number is null");
            return (Criteria) this;
        }

        public Criteria andSalesSerialNumberIsNotNull() {
            addCriterion("sales_serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andSalesSerialNumberEqualTo(String value) {
            addCriterion("sales_serial_number =", value, "salesSerialNumber");
            return (Criteria) this;
        }

        public Criteria andSalesSerialNumberNotEqualTo(String value) {
            addCriterion("sales_serial_number <>", value, "salesSerialNumber");
            return (Criteria) this;
        }

        public Criteria andSalesSerialNumberGreaterThan(String value) {
            addCriterion("sales_serial_number >", value, "salesSerialNumber");
            return (Criteria) this;
        }

        public Criteria andSalesSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("sales_serial_number >=", value, "salesSerialNumber");
            return (Criteria) this;
        }

        public Criteria andSalesSerialNumberLessThan(String value) {
            addCriterion("sales_serial_number <", value, "salesSerialNumber");
            return (Criteria) this;
        }

        public Criteria andSalesSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("sales_serial_number <=", value, "salesSerialNumber");
            return (Criteria) this;
        }

        public Criteria andSalesSerialNumberLike(String value) {
            addCriterion("sales_serial_number like", value, "salesSerialNumber");
            return (Criteria) this;
        }

        public Criteria andSalesSerialNumberNotLike(String value) {
            addCriterion("sales_serial_number not like", value, "salesSerialNumber");
            return (Criteria) this;
        }

        public Criteria andSalesSerialNumberIn(List<String> values) {
            addCriterion("sales_serial_number in", values, "salesSerialNumber");
            return (Criteria) this;
        }

        public Criteria andSalesSerialNumberNotIn(List<String> values) {
            addCriterion("sales_serial_number not in", values, "salesSerialNumber");
            return (Criteria) this;
        }

        public Criteria andSalesSerialNumberBetween(String value1, String value2) {
            addCriterion("sales_serial_number between", value1, value2, "salesSerialNumber");
            return (Criteria) this;
        }

        public Criteria andSalesSerialNumberNotBetween(String value1, String value2) {
            addCriterion("sales_serial_number not between", value1, value2, "salesSerialNumber");
            return (Criteria) this;
        }

        public Criteria andSalesDateIsNull() {
            addCriterion("sales_date is null");
            return (Criteria) this;
        }

        public Criteria andSalesDateIsNotNull() {
            addCriterion("sales_date is not null");
            return (Criteria) this;
        }

        public Criteria andSalesDateEqualTo(Date value) {
            addCriterion("sales_date =", value, "salesDate");
            return (Criteria) this;
        }

        public Criteria andSalesDateNotEqualTo(Date value) {
            addCriterion("sales_date <>", value, "salesDate");
            return (Criteria) this;
        }

        public Criteria andSalesDateGreaterThan(Date value) {
            addCriterion("sales_date >", value, "salesDate");
            return (Criteria) this;
        }

        public Criteria andSalesDateGreaterThanOrEqualTo(Date value) {
            addCriterion("sales_date >=", value, "salesDate");
            return (Criteria) this;
        }

        public Criteria andSalesDateLessThan(Date value) {
            addCriterion("sales_date <", value, "salesDate");
            return (Criteria) this;
        }

        public Criteria andSalesDateLessThanOrEqualTo(Date value) {
            addCriterion("sales_date <=", value, "salesDate");
            return (Criteria) this;
        }

        public Criteria andSalesDateIn(List<Date> values) {
            addCriterion("sales_date in", values, "salesDate");
            return (Criteria) this;
        }

        public Criteria andSalesDateNotIn(List<Date> values) {
            addCriterion("sales_date not in", values, "salesDate");
            return (Criteria) this;
        }

        public Criteria andSalesDateBetween(Date value1, Date value2) {
            addCriterion("sales_date between", value1, value2, "salesDate");
            return (Criteria) this;
        }

        public Criteria andSalesDateNotBetween(Date value1, Date value2) {
            addCriterion("sales_date not between", value1, value2, "salesDate");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Integer value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Integer value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Integer value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Integer value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Integer value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Integer> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Integer> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Integer value1, Integer value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNull() {
            addCriterion("customer_name is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNotNull() {
            addCriterion("customer_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameEqualTo(String value) {
            addCriterion("customer_name =", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotEqualTo(String value) {
            addCriterion("customer_name <>", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThan(String value) {
            addCriterion("customer_name >", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThanOrEqualTo(String value) {
            addCriterion("customer_name >=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThan(String value) {
            addCriterion("customer_name <", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThanOrEqualTo(String value) {
            addCriterion("customer_name <=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLike(String value) {
            addCriterion("customer_name like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotLike(String value) {
            addCriterion("customer_name not like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIn(List<String> values) {
            addCriterion("customer_name in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotIn(List<String> values) {
            addCriterion("customer_name not in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameBetween(String value1, String value2) {
            addCriterion("customer_name between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotBetween(String value1, String value2) {
            addCriterion("customer_name not between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdIsNull() {
            addCriterion("storehouse_id is null");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdIsNotNull() {
            addCriterion("storehouse_id is not null");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdEqualTo(Integer value) {
            addCriterion("storehouse_id =", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdNotEqualTo(Integer value) {
            addCriterion("storehouse_id <>", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdGreaterThan(Integer value) {
            addCriterion("storehouse_id >", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("storehouse_id >=", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdLessThan(Integer value) {
            addCriterion("storehouse_id <", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdLessThanOrEqualTo(Integer value) {
            addCriterion("storehouse_id <=", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdIn(List<Integer> values) {
            addCriterion("storehouse_id in", values, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdNotIn(List<Integer> values) {
            addCriterion("storehouse_id not in", values, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdBetween(Integer value1, Integer value2) {
            addCriterion("storehouse_id between", value1, value2, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("storehouse_id not between", value1, value2, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseNameIsNull() {
            addCriterion("storehouse_name is null");
            return (Criteria) this;
        }

        public Criteria andStorehouseNameIsNotNull() {
            addCriterion("storehouse_name is not null");
            return (Criteria) this;
        }

        public Criteria andStorehouseNameEqualTo(String value) {
            addCriterion("storehouse_name =", value, "storehouseName");
            return (Criteria) this;
        }

        public Criteria andStorehouseNameNotEqualTo(String value) {
            addCriterion("storehouse_name <>", value, "storehouseName");
            return (Criteria) this;
        }

        public Criteria andStorehouseNameGreaterThan(String value) {
            addCriterion("storehouse_name >", value, "storehouseName");
            return (Criteria) this;
        }

        public Criteria andStorehouseNameGreaterThanOrEqualTo(String value) {
            addCriterion("storehouse_name >=", value, "storehouseName");
            return (Criteria) this;
        }

        public Criteria andStorehouseNameLessThan(String value) {
            addCriterion("storehouse_name <", value, "storehouseName");
            return (Criteria) this;
        }

        public Criteria andStorehouseNameLessThanOrEqualTo(String value) {
            addCriterion("storehouse_name <=", value, "storehouseName");
            return (Criteria) this;
        }

        public Criteria andStorehouseNameLike(String value) {
            addCriterion("storehouse_name like", value, "storehouseName");
            return (Criteria) this;
        }

        public Criteria andStorehouseNameNotLike(String value) {
            addCriterion("storehouse_name not like", value, "storehouseName");
            return (Criteria) this;
        }

        public Criteria andStorehouseNameIn(List<String> values) {
            addCriterion("storehouse_name in", values, "storehouseName");
            return (Criteria) this;
        }

        public Criteria andStorehouseNameNotIn(List<String> values) {
            addCriterion("storehouse_name not in", values, "storehouseName");
            return (Criteria) this;
        }

        public Criteria andStorehouseNameBetween(String value1, String value2) {
            addCriterion("storehouse_name between", value1, value2, "storehouseName");
            return (Criteria) this;
        }

        public Criteria andStorehouseNameNotBetween(String value1, String value2) {
            addCriterion("storehouse_name not between", value1, value2, "storehouseName");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIsNull() {
            addCriterion("employee_id is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIsNotNull() {
            addCriterion("employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdEqualTo(Integer value) {
            addCriterion("employee_id =", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotEqualTo(Integer value) {
            addCriterion("employee_id <>", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThan(Integer value) {
            addCriterion("employee_id >", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("employee_id >=", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThan(Integer value) {
            addCriterion("employee_id <", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThanOrEqualTo(Integer value) {
            addCriterion("employee_id <=", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIn(List<Integer> values) {
            addCriterion("employee_id in", values, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotIn(List<Integer> values) {
            addCriterion("employee_id not in", values, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdBetween(Integer value1, Integer value2) {
            addCriterion("employee_id between", value1, value2, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("employee_id not between", value1, value2, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIsNull() {
            addCriterion("employee_name is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIsNotNull() {
            addCriterion("employee_name is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameEqualTo(String value) {
            addCriterion("employee_name =", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotEqualTo(String value) {
            addCriterion("employee_name <>", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameGreaterThan(String value) {
            addCriterion("employee_name >", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameGreaterThanOrEqualTo(String value) {
            addCriterion("employee_name >=", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLessThan(String value) {
            addCriterion("employee_name <", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLessThanOrEqualTo(String value) {
            addCriterion("employee_name <=", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLike(String value) {
            addCriterion("employee_name like", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotLike(String value) {
            addCriterion("employee_name not like", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIn(List<String> values) {
            addCriterion("employee_name in", values, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotIn(List<String> values) {
            addCriterion("employee_name not in", values, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameBetween(String value1, String value2) {
            addCriterion("employee_name between", value1, value2, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotBetween(String value1, String value2) {
            addCriterion("employee_name not between", value1, value2, "employeeName");
            return (Criteria) this;
        }

        public Criteria andIncomeTypeIsNull() {
            addCriterion("income_type is null");
            return (Criteria) this;
        }

        public Criteria andIncomeTypeIsNotNull() {
            addCriterion("income_type is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeTypeEqualTo(String value) {
            addCriterion("income_type =", value, "incomeType");
            return (Criteria) this;
        }

        public Criteria andIncomeTypeNotEqualTo(String value) {
            addCriterion("income_type <>", value, "incomeType");
            return (Criteria) this;
        }

        public Criteria andIncomeTypeGreaterThan(String value) {
            addCriterion("income_type >", value, "incomeType");
            return (Criteria) this;
        }

        public Criteria andIncomeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("income_type >=", value, "incomeType");
            return (Criteria) this;
        }

        public Criteria andIncomeTypeLessThan(String value) {
            addCriterion("income_type <", value, "incomeType");
            return (Criteria) this;
        }

        public Criteria andIncomeTypeLessThanOrEqualTo(String value) {
            addCriterion("income_type <=", value, "incomeType");
            return (Criteria) this;
        }

        public Criteria andIncomeTypeLike(String value) {
            addCriterion("income_type like", value, "incomeType");
            return (Criteria) this;
        }

        public Criteria andIncomeTypeNotLike(String value) {
            addCriterion("income_type not like", value, "incomeType");
            return (Criteria) this;
        }

        public Criteria andIncomeTypeIn(List<String> values) {
            addCriterion("income_type in", values, "incomeType");
            return (Criteria) this;
        }

        public Criteria andIncomeTypeNotIn(List<String> values) {
            addCriterion("income_type not in", values, "incomeType");
            return (Criteria) this;
        }

        public Criteria andIncomeTypeBetween(String value1, String value2) {
            addCriterion("income_type between", value1, value2, "incomeType");
            return (Criteria) this;
        }

        public Criteria andIncomeTypeNotBetween(String value1, String value2) {
            addCriterion("income_type not between", value1, value2, "incomeType");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeIsNull() {
            addCriterion("income_time is null");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeIsNotNull() {
            addCriterion("income_time is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeEqualTo(Date value) {
            addCriterion("income_time =", value, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeNotEqualTo(Date value) {
            addCriterion("income_time <>", value, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeGreaterThan(Date value) {
            addCriterion("income_time >", value, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("income_time >=", value, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeLessThan(Date value) {
            addCriterion("income_time <", value, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeLessThanOrEqualTo(Date value) {
            addCriterion("income_time <=", value, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeIn(List<Date> values) {
            addCriterion("income_time in", values, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeNotIn(List<Date> values) {
            addCriterion("income_time not in", values, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeBetween(Date value1, Date value2) {
            addCriterion("income_time between", value1, value2, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeNotBetween(Date value1, Date value2) {
            addCriterion("income_time not between", value1, value2, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andTotalSalesAmountIsNull() {
            addCriterion("total_sales_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalSalesAmountIsNotNull() {
            addCriterion("total_sales_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSalesAmountEqualTo(String value) {
            addCriterion("total_sales_amount =", value, "totalSalesAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSalesAmountNotEqualTo(String value) {
            addCriterion("total_sales_amount <>", value, "totalSalesAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSalesAmountGreaterThan(String value) {
            addCriterion("total_sales_amount >", value, "totalSalesAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSalesAmountGreaterThanOrEqualTo(String value) {
            addCriterion("total_sales_amount >=", value, "totalSalesAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSalesAmountLessThan(String value) {
            addCriterion("total_sales_amount <", value, "totalSalesAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSalesAmountLessThanOrEqualTo(String value) {
            addCriterion("total_sales_amount <=", value, "totalSalesAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSalesAmountLike(String value) {
            addCriterion("total_sales_amount like", value, "totalSalesAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSalesAmountNotLike(String value) {
            addCriterion("total_sales_amount not like", value, "totalSalesAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSalesAmountIn(List<String> values) {
            addCriterion("total_sales_amount in", values, "totalSalesAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSalesAmountNotIn(List<String> values) {
            addCriterion("total_sales_amount not in", values, "totalSalesAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSalesAmountBetween(String value1, String value2) {
            addCriterion("total_sales_amount between", value1, value2, "totalSalesAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSalesAmountNotBetween(String value1, String value2) {
            addCriterion("total_sales_amount not between", value1, value2, "totalSalesAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSettlementAmountIsNull() {
            addCriterion("total_settlement_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalSettlementAmountIsNotNull() {
            addCriterion("total_settlement_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSettlementAmountEqualTo(String value) {
            addCriterion("total_settlement_amount =", value, "totalSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSettlementAmountNotEqualTo(String value) {
            addCriterion("total_settlement_amount <>", value, "totalSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSettlementAmountGreaterThan(String value) {
            addCriterion("total_settlement_amount >", value, "totalSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSettlementAmountGreaterThanOrEqualTo(String value) {
            addCriterion("total_settlement_amount >=", value, "totalSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSettlementAmountLessThan(String value) {
            addCriterion("total_settlement_amount <", value, "totalSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSettlementAmountLessThanOrEqualTo(String value) {
            addCriterion("total_settlement_amount <=", value, "totalSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSettlementAmountLike(String value) {
            addCriterion("total_settlement_amount like", value, "totalSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSettlementAmountNotLike(String value) {
            addCriterion("total_settlement_amount not like", value, "totalSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSettlementAmountIn(List<String> values) {
            addCriterion("total_settlement_amount in", values, "totalSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSettlementAmountNotIn(List<String> values) {
            addCriterion("total_settlement_amount not in", values, "totalSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSettlementAmountBetween(String value1, String value2) {
            addCriterion("total_settlement_amount between", value1, value2, "totalSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andTotalSettlementAmountNotBetween(String value1, String value2) {
            addCriterion("total_settlement_amount not between", value1, value2, "totalSettlementAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCreditAmountIsNull() {
            addCriterion("total_credit_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalCreditAmountIsNotNull() {
            addCriterion("total_credit_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCreditAmountEqualTo(String value) {
            addCriterion("total_credit_amount =", value, "totalCreditAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCreditAmountNotEqualTo(String value) {
            addCriterion("total_credit_amount <>", value, "totalCreditAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCreditAmountGreaterThan(String value) {
            addCriterion("total_credit_amount >", value, "totalCreditAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCreditAmountGreaterThanOrEqualTo(String value) {
            addCriterion("total_credit_amount >=", value, "totalCreditAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCreditAmountLessThan(String value) {
            addCriterion("total_credit_amount <", value, "totalCreditAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCreditAmountLessThanOrEqualTo(String value) {
            addCriterion("total_credit_amount <=", value, "totalCreditAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCreditAmountLike(String value) {
            addCriterion("total_credit_amount like", value, "totalCreditAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCreditAmountNotLike(String value) {
            addCriterion("total_credit_amount not like", value, "totalCreditAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCreditAmountIn(List<String> values) {
            addCriterion("total_credit_amount in", values, "totalCreditAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCreditAmountNotIn(List<String> values) {
            addCriterion("total_credit_amount not in", values, "totalCreditAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCreditAmountBetween(String value1, String value2) {
            addCriterion("total_credit_amount between", value1, value2, "totalCreditAmount");
            return (Criteria) this;
        }

        public Criteria andTotalCreditAmountNotBetween(String value1, String value2) {
            addCriterion("total_credit_amount not between", value1, value2, "totalCreditAmount");
            return (Criteria) this;
        }

        public Criteria andSalesStatusIsNull() {
            addCriterion("sales_status is null");
            return (Criteria) this;
        }

        public Criteria andSalesStatusIsNotNull() {
            addCriterion("sales_status is not null");
            return (Criteria) this;
        }

        public Criteria andSalesStatusEqualTo(String value) {
            addCriterion("sales_status =", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusNotEqualTo(String value) {
            addCriterion("sales_status <>", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusGreaterThan(String value) {
            addCriterion("sales_status >", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusGreaterThanOrEqualTo(String value) {
            addCriterion("sales_status >=", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusLessThan(String value) {
            addCriterion("sales_status <", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusLessThanOrEqualTo(String value) {
            addCriterion("sales_status <=", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusLike(String value) {
            addCriterion("sales_status like", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusNotLike(String value) {
            addCriterion("sales_status not like", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusIn(List<String> values) {
            addCriterion("sales_status in", values, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusNotIn(List<String> values) {
            addCriterion("sales_status not in", values, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusBetween(String value1, String value2) {
            addCriterion("sales_status between", value1, value2, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusNotBetween(String value1, String value2) {
            addCriterion("sales_status not between", value1, value2, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesTypeIsNull() {
            addCriterion("sales_type is null");
            return (Criteria) this;
        }

        public Criteria andSalesTypeIsNotNull() {
            addCriterion("sales_type is not null");
            return (Criteria) this;
        }

        public Criteria andSalesTypeEqualTo(String value) {
            addCriterion("sales_type =", value, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeNotEqualTo(String value) {
            addCriterion("sales_type <>", value, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeGreaterThan(String value) {
            addCriterion("sales_type >", value, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sales_type >=", value, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeLessThan(String value) {
            addCriterion("sales_type <", value, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeLessThanOrEqualTo(String value) {
            addCriterion("sales_type <=", value, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeLike(String value) {
            addCriterion("sales_type like", value, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeNotLike(String value) {
            addCriterion("sales_type not like", value, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeIn(List<String> values) {
            addCriterion("sales_type in", values, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeNotIn(List<String> values) {
            addCriterion("sales_type not in", values, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeBetween(String value1, String value2) {
            addCriterion("sales_type between", value1, value2, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeNotBetween(String value1, String value2) {
            addCriterion("sales_type not between", value1, value2, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesRemarkIsNull() {
            addCriterion("sales_remark is null");
            return (Criteria) this;
        }

        public Criteria andSalesRemarkIsNotNull() {
            addCriterion("sales_remark is not null");
            return (Criteria) this;
        }

        public Criteria andSalesRemarkEqualTo(String value) {
            addCriterion("sales_remark =", value, "salesRemark");
            return (Criteria) this;
        }

        public Criteria andSalesRemarkNotEqualTo(String value) {
            addCriterion("sales_remark <>", value, "salesRemark");
            return (Criteria) this;
        }

        public Criteria andSalesRemarkGreaterThan(String value) {
            addCriterion("sales_remark >", value, "salesRemark");
            return (Criteria) this;
        }

        public Criteria andSalesRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("sales_remark >=", value, "salesRemark");
            return (Criteria) this;
        }

        public Criteria andSalesRemarkLessThan(String value) {
            addCriterion("sales_remark <", value, "salesRemark");
            return (Criteria) this;
        }

        public Criteria andSalesRemarkLessThanOrEqualTo(String value) {
            addCriterion("sales_remark <=", value, "salesRemark");
            return (Criteria) this;
        }

        public Criteria andSalesRemarkLike(String value) {
            addCriterion("sales_remark like", value, "salesRemark");
            return (Criteria) this;
        }

        public Criteria andSalesRemarkNotLike(String value) {
            addCriterion("sales_remark not like", value, "salesRemark");
            return (Criteria) this;
        }

        public Criteria andSalesRemarkIn(List<String> values) {
            addCriterion("sales_remark in", values, "salesRemark");
            return (Criteria) this;
        }

        public Criteria andSalesRemarkNotIn(List<String> values) {
            addCriterion("sales_remark not in", values, "salesRemark");
            return (Criteria) this;
        }

        public Criteria andSalesRemarkBetween(String value1, String value2) {
            addCriterion("sales_remark between", value1, value2, "salesRemark");
            return (Criteria) this;
        }

        public Criteria andSalesRemarkNotBetween(String value1, String value2) {
            addCriterion("sales_remark not between", value1, value2, "salesRemark");
            return (Criteria) this;
        }

        public Criteria andStorehouseManagerIsNull() {
            addCriterion("storehouse_manager is null");
            return (Criteria) this;
        }

        public Criteria andStorehouseManagerIsNotNull() {
            addCriterion("storehouse_manager is not null");
            return (Criteria) this;
        }

        public Criteria andStorehouseManagerEqualTo(String value) {
            addCriterion("storehouse_manager =", value, "storehouseManager");
            return (Criteria) this;
        }

        public Criteria andStorehouseManagerNotEqualTo(String value) {
            addCriterion("storehouse_manager <>", value, "storehouseManager");
            return (Criteria) this;
        }

        public Criteria andStorehouseManagerGreaterThan(String value) {
            addCriterion("storehouse_manager >", value, "storehouseManager");
            return (Criteria) this;
        }

        public Criteria andStorehouseManagerGreaterThanOrEqualTo(String value) {
            addCriterion("storehouse_manager >=", value, "storehouseManager");
            return (Criteria) this;
        }

        public Criteria andStorehouseManagerLessThan(String value) {
            addCriterion("storehouse_manager <", value, "storehouseManager");
            return (Criteria) this;
        }

        public Criteria andStorehouseManagerLessThanOrEqualTo(String value) {
            addCriterion("storehouse_manager <=", value, "storehouseManager");
            return (Criteria) this;
        }

        public Criteria andStorehouseManagerLike(String value) {
            addCriterion("storehouse_manager like", value, "storehouseManager");
            return (Criteria) this;
        }

        public Criteria andStorehouseManagerNotLike(String value) {
            addCriterion("storehouse_manager not like", value, "storehouseManager");
            return (Criteria) this;
        }

        public Criteria andStorehouseManagerIn(List<String> values) {
            addCriterion("storehouse_manager in", values, "storehouseManager");
            return (Criteria) this;
        }

        public Criteria andStorehouseManagerNotIn(List<String> values) {
            addCriterion("storehouse_manager not in", values, "storehouseManager");
            return (Criteria) this;
        }

        public Criteria andStorehouseManagerBetween(String value1, String value2) {
            addCriterion("storehouse_manager between", value1, value2, "storehouseManager");
            return (Criteria) this;
        }

        public Criteria andStorehouseManagerNotBetween(String value1, String value2) {
            addCriterion("storehouse_manager not between", value1, value2, "storehouseManager");
            return (Criteria) this;
        }

        public Criteria andTouchingManagerIsNull() {
            addCriterion("touching_manager is null");
            return (Criteria) this;
        }

        public Criteria andTouchingManagerIsNotNull() {
            addCriterion("touching_manager is not null");
            return (Criteria) this;
        }

        public Criteria andTouchingManagerEqualTo(String value) {
            addCriterion("touching_manager =", value, "touchingManager");
            return (Criteria) this;
        }

        public Criteria andTouchingManagerNotEqualTo(String value) {
            addCriterion("touching_manager <>", value, "touchingManager");
            return (Criteria) this;
        }

        public Criteria andTouchingManagerGreaterThan(String value) {
            addCriterion("touching_manager >", value, "touchingManager");
            return (Criteria) this;
        }

        public Criteria andTouchingManagerGreaterThanOrEqualTo(String value) {
            addCriterion("touching_manager >=", value, "touchingManager");
            return (Criteria) this;
        }

        public Criteria andTouchingManagerLessThan(String value) {
            addCriterion("touching_manager <", value, "touchingManager");
            return (Criteria) this;
        }

        public Criteria andTouchingManagerLessThanOrEqualTo(String value) {
            addCriterion("touching_manager <=", value, "touchingManager");
            return (Criteria) this;
        }

        public Criteria andTouchingManagerLike(String value) {
            addCriterion("touching_manager like", value, "touchingManager");
            return (Criteria) this;
        }

        public Criteria andTouchingManagerNotLike(String value) {
            addCriterion("touching_manager not like", value, "touchingManager");
            return (Criteria) this;
        }

        public Criteria andTouchingManagerIn(List<String> values) {
            addCriterion("touching_manager in", values, "touchingManager");
            return (Criteria) this;
        }

        public Criteria andTouchingManagerNotIn(List<String> values) {
            addCriterion("touching_manager not in", values, "touchingManager");
            return (Criteria) this;
        }

        public Criteria andTouchingManagerBetween(String value1, String value2) {
            addCriterion("touching_manager between", value1, value2, "touchingManager");
            return (Criteria) this;
        }

        public Criteria andTouchingManagerNotBetween(String value1, String value2) {
            addCriterion("touching_manager not between", value1, value2, "touchingManager");
            return (Criteria) this;
        }

        public Criteria andReceiverIsNull() {
            addCriterion("receiver is null");
            return (Criteria) this;
        }

        public Criteria andReceiverIsNotNull() {
            addCriterion("receiver is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverEqualTo(String value) {
            addCriterion("receiver =", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotEqualTo(String value) {
            addCriterion("receiver <>", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverGreaterThan(String value) {
            addCriterion("receiver >", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverGreaterThanOrEqualTo(String value) {
            addCriterion("receiver >=", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLessThan(String value) {
            addCriterion("receiver <", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLessThanOrEqualTo(String value) {
            addCriterion("receiver <=", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLike(String value) {
            addCriterion("receiver like", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotLike(String value) {
            addCriterion("receiver not like", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverIn(List<String> values) {
            addCriterion("receiver in", values, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotIn(List<String> values) {
            addCriterion("receiver not in", values, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverBetween(String value1, String value2) {
            addCriterion("receiver between", value1, value2, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotBetween(String value1, String value2) {
            addCriterion("receiver not between", value1, value2, "receiver");
            return (Criteria) this;
        }

        public Criteria andSenderIsNull() {
            addCriterion("sender is null");
            return (Criteria) this;
        }

        public Criteria andSenderIsNotNull() {
            addCriterion("sender is not null");
            return (Criteria) this;
        }

        public Criteria andSenderEqualTo(String value) {
            addCriterion("sender =", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotEqualTo(String value) {
            addCriterion("sender <>", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderGreaterThan(String value) {
            addCriterion("sender >", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderGreaterThanOrEqualTo(String value) {
            addCriterion("sender >=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLessThan(String value) {
            addCriterion("sender <", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLessThanOrEqualTo(String value) {
            addCriterion("sender <=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLike(String value) {
            addCriterion("sender like", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotLike(String value) {
            addCriterion("sender not like", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderIn(List<String> values) {
            addCriterion("sender in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotIn(List<String> values) {
            addCriterion("sender not in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderBetween(String value1, String value2) {
            addCriterion("sender between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotBetween(String value1, String value2) {
            addCriterion("sender not between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andCarNumberIsNull() {
            addCriterion("car_number is null");
            return (Criteria) this;
        }

        public Criteria andCarNumberIsNotNull() {
            addCriterion("car_number is not null");
            return (Criteria) this;
        }

        public Criteria andCarNumberEqualTo(String value) {
            addCriterion("car_number =", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotEqualTo(String value) {
            addCriterion("car_number <>", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberGreaterThan(String value) {
            addCriterion("car_number >", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberGreaterThanOrEqualTo(String value) {
            addCriterion("car_number >=", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLessThan(String value) {
            addCriterion("car_number <", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLessThanOrEqualTo(String value) {
            addCriterion("car_number <=", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLike(String value) {
            addCriterion("car_number like", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotLike(String value) {
            addCriterion("car_number not like", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberIn(List<String> values) {
            addCriterion("car_number in", values, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotIn(List<String> values) {
            addCriterion("car_number not in", values, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberBetween(String value1, String value2) {
            addCriterion("car_number between", value1, value2, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotBetween(String value1, String value2) {
            addCriterion("car_number not between", value1, value2, "carNumber");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeIsNull() {
            addCriterion("departure_time is null");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeIsNotNull() {
            addCriterion("departure_time is not null");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeEqualTo(Date value) {
            addCriterion("departure_time =", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeNotEqualTo(Date value) {
            addCriterion("departure_time <>", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeGreaterThan(Date value) {
            addCriterion("departure_time >", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("departure_time >=", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeLessThan(Date value) {
            addCriterion("departure_time <", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeLessThanOrEqualTo(Date value) {
            addCriterion("departure_time <=", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeIn(List<Date> values) {
            addCriterion("departure_time in", values, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeNotIn(List<Date> values) {
            addCriterion("departure_time not in", values, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeBetween(Date value1, Date value2) {
            addCriterion("departure_time between", value1, value2, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeNotBetween(Date value1, Date value2) {
            addCriterion("departure_time not between", value1, value2, "departureTime");
            return (Criteria) this;
        }

        public Criteria andStillTimeIsNull() {
            addCriterion("still_time is null");
            return (Criteria) this;
        }

        public Criteria andStillTimeIsNotNull() {
            addCriterion("still_time is not null");
            return (Criteria) this;
        }

        public Criteria andStillTimeEqualTo(Date value) {
            addCriterion("still_time =", value, "stillTime");
            return (Criteria) this;
        }

        public Criteria andStillTimeNotEqualTo(Date value) {
            addCriterion("still_time <>", value, "stillTime");
            return (Criteria) this;
        }

        public Criteria andStillTimeGreaterThan(Date value) {
            addCriterion("still_time >", value, "stillTime");
            return (Criteria) this;
        }

        public Criteria andStillTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("still_time >=", value, "stillTime");
            return (Criteria) this;
        }

        public Criteria andStillTimeLessThan(Date value) {
            addCriterion("still_time <", value, "stillTime");
            return (Criteria) this;
        }

        public Criteria andStillTimeLessThanOrEqualTo(Date value) {
            addCriterion("still_time <=", value, "stillTime");
            return (Criteria) this;
        }

        public Criteria andStillTimeIn(List<Date> values) {
            addCriterion("still_time in", values, "stillTime");
            return (Criteria) this;
        }

        public Criteria andStillTimeNotIn(List<Date> values) {
            addCriterion("still_time not in", values, "stillTime");
            return (Criteria) this;
        }

        public Criteria andStillTimeBetween(Date value1, Date value2) {
            addCriterion("still_time between", value1, value2, "stillTime");
            return (Criteria) this;
        }

        public Criteria andStillTimeNotBetween(Date value1, Date value2) {
            addCriterion("still_time not between", value1, value2, "stillTime");
            return (Criteria) this;
        }

        public Criteria andStartOilNumberIsNull() {
            addCriterion("start_oil_number is null");
            return (Criteria) this;
        }

        public Criteria andStartOilNumberIsNotNull() {
            addCriterion("start_oil_number is not null");
            return (Criteria) this;
        }

        public Criteria andStartOilNumberEqualTo(String value) {
            addCriterion("start_oil_number =", value, "startOilNumber");
            return (Criteria) this;
        }

        public Criteria andStartOilNumberNotEqualTo(String value) {
            addCriterion("start_oil_number <>", value, "startOilNumber");
            return (Criteria) this;
        }

        public Criteria andStartOilNumberGreaterThan(String value) {
            addCriterion("start_oil_number >", value, "startOilNumber");
            return (Criteria) this;
        }

        public Criteria andStartOilNumberGreaterThanOrEqualTo(String value) {
            addCriterion("start_oil_number >=", value, "startOilNumber");
            return (Criteria) this;
        }

        public Criteria andStartOilNumberLessThan(String value) {
            addCriterion("start_oil_number <", value, "startOilNumber");
            return (Criteria) this;
        }

        public Criteria andStartOilNumberLessThanOrEqualTo(String value) {
            addCriterion("start_oil_number <=", value, "startOilNumber");
            return (Criteria) this;
        }

        public Criteria andStartOilNumberLike(String value) {
            addCriterion("start_oil_number like", value, "startOilNumber");
            return (Criteria) this;
        }

        public Criteria andStartOilNumberNotLike(String value) {
            addCriterion("start_oil_number not like", value, "startOilNumber");
            return (Criteria) this;
        }

        public Criteria andStartOilNumberIn(List<String> values) {
            addCriterion("start_oil_number in", values, "startOilNumber");
            return (Criteria) this;
        }

        public Criteria andStartOilNumberNotIn(List<String> values) {
            addCriterion("start_oil_number not in", values, "startOilNumber");
            return (Criteria) this;
        }

        public Criteria andStartOilNumberBetween(String value1, String value2) {
            addCriterion("start_oil_number between", value1, value2, "startOilNumber");
            return (Criteria) this;
        }

        public Criteria andStartOilNumberNotBetween(String value1, String value2) {
            addCriterion("start_oil_number not between", value1, value2, "startOilNumber");
            return (Criteria) this;
        }

        public Criteria andReturnOilNumberIsNull() {
            addCriterion("return_oil_number is null");
            return (Criteria) this;
        }

        public Criteria andReturnOilNumberIsNotNull() {
            addCriterion("return_oil_number is not null");
            return (Criteria) this;
        }

        public Criteria andReturnOilNumberEqualTo(String value) {
            addCriterion("return_oil_number =", value, "returnOilNumber");
            return (Criteria) this;
        }

        public Criteria andReturnOilNumberNotEqualTo(String value) {
            addCriterion("return_oil_number <>", value, "returnOilNumber");
            return (Criteria) this;
        }

        public Criteria andReturnOilNumberGreaterThan(String value) {
            addCriterion("return_oil_number >", value, "returnOilNumber");
            return (Criteria) this;
        }

        public Criteria andReturnOilNumberGreaterThanOrEqualTo(String value) {
            addCriterion("return_oil_number >=", value, "returnOilNumber");
            return (Criteria) this;
        }

        public Criteria andReturnOilNumberLessThan(String value) {
            addCriterion("return_oil_number <", value, "returnOilNumber");
            return (Criteria) this;
        }

        public Criteria andReturnOilNumberLessThanOrEqualTo(String value) {
            addCriterion("return_oil_number <=", value, "returnOilNumber");
            return (Criteria) this;
        }

        public Criteria andReturnOilNumberLike(String value) {
            addCriterion("return_oil_number like", value, "returnOilNumber");
            return (Criteria) this;
        }

        public Criteria andReturnOilNumberNotLike(String value) {
            addCriterion("return_oil_number not like", value, "returnOilNumber");
            return (Criteria) this;
        }

        public Criteria andReturnOilNumberIn(List<String> values) {
            addCriterion("return_oil_number in", values, "returnOilNumber");
            return (Criteria) this;
        }

        public Criteria andReturnOilNumberNotIn(List<String> values) {
            addCriterion("return_oil_number not in", values, "returnOilNumber");
            return (Criteria) this;
        }

        public Criteria andReturnOilNumberBetween(String value1, String value2) {
            addCriterion("return_oil_number between", value1, value2, "returnOilNumber");
            return (Criteria) this;
        }

        public Criteria andReturnOilNumberNotBetween(String value1, String value2) {
            addCriterion("return_oil_number not between", value1, value2, "returnOilNumber");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}