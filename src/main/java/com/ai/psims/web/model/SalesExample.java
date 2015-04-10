package com.ai.psims.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SalesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SalesExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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
            addCriterionForJDBCDate("sales_date =", value, "salesDate");
            return (Criteria) this;
        }

        public Criteria andSalesDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("sales_date <>", value, "salesDate");
            return (Criteria) this;
        }

        public Criteria andSalesDateGreaterThan(Date value) {
            addCriterionForJDBCDate("sales_date >", value, "salesDate");
            return (Criteria) this;
        }

        public Criteria andSalesDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sales_date >=", value, "salesDate");
            return (Criteria) this;
        }

        public Criteria andSalesDateLessThan(Date value) {
            addCriterionForJDBCDate("sales_date <", value, "salesDate");
            return (Criteria) this;
        }

        public Criteria andSalesDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sales_date <=", value, "salesDate");
            return (Criteria) this;
        }

        public Criteria andSalesDateIn(List<Date> values) {
            addCriterionForJDBCDate("sales_date in", values, "salesDate");
            return (Criteria) this;
        }

        public Criteria andSalesDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("sales_date not in", values, "salesDate");
            return (Criteria) this;
        }

        public Criteria andSalesDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sales_date between", value1, value2, "salesDate");
            return (Criteria) this;
        }

        public Criteria andSalesDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sales_date not between", value1, value2, "salesDate");
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
            addCriterionForJDBCDate("income_time =", value, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("income_time <>", value, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("income_time >", value, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("income_time >=", value, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeLessThan(Date value) {
            addCriterionForJDBCDate("income_time <", value, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("income_time <=", value, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeIn(List<Date> values) {
            addCriterionForJDBCDate("income_time in", values, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("income_time not in", values, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("income_time between", value1, value2, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("income_time not between", value1, value2, "incomeTime");
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

        public Criteria andSalesTotalPriceIsNull() {
            addCriterion("sales_total_price is null");
            return (Criteria) this;
        }

        public Criteria andSalesTotalPriceIsNotNull() {
            addCriterion("sales_total_price is not null");
            return (Criteria) this;
        }

        public Criteria andSalesTotalPriceEqualTo(Long value) {
            addCriterion("sales_total_price =", value, "salesTotalPrice");
            return (Criteria) this;
        }

        public Criteria andSalesTotalPriceNotEqualTo(Long value) {
            addCriterion("sales_total_price <>", value, "salesTotalPrice");
            return (Criteria) this;
        }

        public Criteria andSalesTotalPriceGreaterThan(Long value) {
            addCriterion("sales_total_price >", value, "salesTotalPrice");
            return (Criteria) this;
        }

        public Criteria andSalesTotalPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("sales_total_price >=", value, "salesTotalPrice");
            return (Criteria) this;
        }

        public Criteria andSalesTotalPriceLessThan(Long value) {
            addCriterion("sales_total_price <", value, "salesTotalPrice");
            return (Criteria) this;
        }

        public Criteria andSalesTotalPriceLessThanOrEqualTo(Long value) {
            addCriterion("sales_total_price <=", value, "salesTotalPrice");
            return (Criteria) this;
        }

        public Criteria andSalesTotalPriceIn(List<Long> values) {
            addCriterion("sales_total_price in", values, "salesTotalPrice");
            return (Criteria) this;
        }

        public Criteria andSalesTotalPriceNotIn(List<Long> values) {
            addCriterion("sales_total_price not in", values, "salesTotalPrice");
            return (Criteria) this;
        }

        public Criteria andSalesTotalPriceBetween(Long value1, Long value2) {
            addCriterion("sales_total_price between", value1, value2, "salesTotalPrice");
            return (Criteria) this;
        }

        public Criteria andSalesTotalPriceNotBetween(Long value1, Long value2) {
            addCriterion("sales_total_price not between", value1, value2, "salesTotalPrice");
            return (Criteria) this;
        }

        public Criteria andCreditCountIsNull() {
            addCriterion("credit_count is null");
            return (Criteria) this;
        }

        public Criteria andCreditCountIsNotNull() {
            addCriterion("credit_count is not null");
            return (Criteria) this;
        }

        public Criteria andCreditCountEqualTo(Long value) {
            addCriterion("credit_count =", value, "creditCount");
            return (Criteria) this;
        }

        public Criteria andCreditCountNotEqualTo(Long value) {
            addCriterion("credit_count <>", value, "creditCount");
            return (Criteria) this;
        }

        public Criteria andCreditCountGreaterThan(Long value) {
            addCriterion("credit_count >", value, "creditCount");
            return (Criteria) this;
        }

        public Criteria andCreditCountGreaterThanOrEqualTo(Long value) {
            addCriterion("credit_count >=", value, "creditCount");
            return (Criteria) this;
        }

        public Criteria andCreditCountLessThan(Long value) {
            addCriterion("credit_count <", value, "creditCount");
            return (Criteria) this;
        }

        public Criteria andCreditCountLessThanOrEqualTo(Long value) {
            addCriterion("credit_count <=", value, "creditCount");
            return (Criteria) this;
        }

        public Criteria andCreditCountIn(List<Long> values) {
            addCriterion("credit_count in", values, "creditCount");
            return (Criteria) this;
        }

        public Criteria andCreditCountNotIn(List<Long> values) {
            addCriterion("credit_count not in", values, "creditCount");
            return (Criteria) this;
        }

        public Criteria andCreditCountBetween(Long value1, Long value2) {
            addCriterion("credit_count between", value1, value2, "creditCount");
            return (Criteria) this;
        }

        public Criteria andCreditCountNotBetween(Long value1, Long value2) {
            addCriterion("credit_count not between", value1, value2, "creditCount");
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