package com.ai.psims.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SalesbackExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SalesbackExample() {
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

        public Criteria andSalesbackSerialNumberIsNull() {
            addCriterion("salesback_serial_number is null");
            return (Criteria) this;
        }

        public Criteria andSalesbackSerialNumberIsNotNull() {
            addCriterion("salesback_serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andSalesbackSerialNumberEqualTo(String value) {
            addCriterion("salesback_serial_number =", value, "salesbackSerialNumber");
            return (Criteria) this;
        }

        public Criteria andSalesbackSerialNumberNotEqualTo(String value) {
            addCriterion("salesback_serial_number <>", value, "salesbackSerialNumber");
            return (Criteria) this;
        }

        public Criteria andSalesbackSerialNumberGreaterThan(String value) {
            addCriterion("salesback_serial_number >", value, "salesbackSerialNumber");
            return (Criteria) this;
        }

        public Criteria andSalesbackSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("salesback_serial_number >=", value, "salesbackSerialNumber");
            return (Criteria) this;
        }

        public Criteria andSalesbackSerialNumberLessThan(String value) {
            addCriterion("salesback_serial_number <", value, "salesbackSerialNumber");
            return (Criteria) this;
        }

        public Criteria andSalesbackSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("salesback_serial_number <=", value, "salesbackSerialNumber");
            return (Criteria) this;
        }

        public Criteria andSalesbackSerialNumberLike(String value) {
            addCriterion("salesback_serial_number like", value, "salesbackSerialNumber");
            return (Criteria) this;
        }

        public Criteria andSalesbackSerialNumberNotLike(String value) {
            addCriterion("salesback_serial_number not like", value, "salesbackSerialNumber");
            return (Criteria) this;
        }

        public Criteria andSalesbackSerialNumberIn(List<String> values) {
            addCriterion("salesback_serial_number in", values, "salesbackSerialNumber");
            return (Criteria) this;
        }

        public Criteria andSalesbackSerialNumberNotIn(List<String> values) {
            addCriterion("salesback_serial_number not in", values, "salesbackSerialNumber");
            return (Criteria) this;
        }

        public Criteria andSalesbackSerialNumberBetween(String value1, String value2) {
            addCriterion("salesback_serial_number between", value1, value2, "salesbackSerialNumber");
            return (Criteria) this;
        }

        public Criteria andSalesbackSerialNumberNotBetween(String value1, String value2) {
            addCriterion("salesback_serial_number not between", value1, value2, "salesbackSerialNumber");
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

        public Criteria andSalesbackTypeIsNull() {
            addCriterion("salesback_type is null");
            return (Criteria) this;
        }

        public Criteria andSalesbackTypeIsNotNull() {
            addCriterion("salesback_type is not null");
            return (Criteria) this;
        }

        public Criteria andSalesbackTypeEqualTo(String value) {
            addCriterion("salesback_type =", value, "salesbackType");
            return (Criteria) this;
        }

        public Criteria andSalesbackTypeNotEqualTo(String value) {
            addCriterion("salesback_type <>", value, "salesbackType");
            return (Criteria) this;
        }

        public Criteria andSalesbackTypeGreaterThan(String value) {
            addCriterion("salesback_type >", value, "salesbackType");
            return (Criteria) this;
        }

        public Criteria andSalesbackTypeGreaterThanOrEqualTo(String value) {
            addCriterion("salesback_type >=", value, "salesbackType");
            return (Criteria) this;
        }

        public Criteria andSalesbackTypeLessThan(String value) {
            addCriterion("salesback_type <", value, "salesbackType");
            return (Criteria) this;
        }

        public Criteria andSalesbackTypeLessThanOrEqualTo(String value) {
            addCriterion("salesback_type <=", value, "salesbackType");
            return (Criteria) this;
        }

        public Criteria andSalesbackTypeLike(String value) {
            addCriterion("salesback_type like", value, "salesbackType");
            return (Criteria) this;
        }

        public Criteria andSalesbackTypeNotLike(String value) {
            addCriterion("salesback_type not like", value, "salesbackType");
            return (Criteria) this;
        }

        public Criteria andSalesbackTypeIn(List<String> values) {
            addCriterion("salesback_type in", values, "salesbackType");
            return (Criteria) this;
        }

        public Criteria andSalesbackTypeNotIn(List<String> values) {
            addCriterion("salesback_type not in", values, "salesbackType");
            return (Criteria) this;
        }

        public Criteria andSalesbackTypeBetween(String value1, String value2) {
            addCriterion("salesback_type between", value1, value2, "salesbackType");
            return (Criteria) this;
        }

        public Criteria andSalesbackTypeNotBetween(String value1, String value2) {
            addCriterion("salesback_type not between", value1, value2, "salesbackType");
            return (Criteria) this;
        }

        public Criteria andSalesbackReasonIsNull() {
            addCriterion("salesback_reason is null");
            return (Criteria) this;
        }

        public Criteria andSalesbackReasonIsNotNull() {
            addCriterion("salesback_reason is not null");
            return (Criteria) this;
        }

        public Criteria andSalesbackReasonEqualTo(String value) {
            addCriterion("salesback_reason =", value, "salesbackReason");
            return (Criteria) this;
        }

        public Criteria andSalesbackReasonNotEqualTo(String value) {
            addCriterion("salesback_reason <>", value, "salesbackReason");
            return (Criteria) this;
        }

        public Criteria andSalesbackReasonGreaterThan(String value) {
            addCriterion("salesback_reason >", value, "salesbackReason");
            return (Criteria) this;
        }

        public Criteria andSalesbackReasonGreaterThanOrEqualTo(String value) {
            addCriterion("salesback_reason >=", value, "salesbackReason");
            return (Criteria) this;
        }

        public Criteria andSalesbackReasonLessThan(String value) {
            addCriterion("salesback_reason <", value, "salesbackReason");
            return (Criteria) this;
        }

        public Criteria andSalesbackReasonLessThanOrEqualTo(String value) {
            addCriterion("salesback_reason <=", value, "salesbackReason");
            return (Criteria) this;
        }

        public Criteria andSalesbackReasonLike(String value) {
            addCriterion("salesback_reason like", value, "salesbackReason");
            return (Criteria) this;
        }

        public Criteria andSalesbackReasonNotLike(String value) {
            addCriterion("salesback_reason not like", value, "salesbackReason");
            return (Criteria) this;
        }

        public Criteria andSalesbackReasonIn(List<String> values) {
            addCriterion("salesback_reason in", values, "salesbackReason");
            return (Criteria) this;
        }

        public Criteria andSalesbackReasonNotIn(List<String> values) {
            addCriterion("salesback_reason not in", values, "salesbackReason");
            return (Criteria) this;
        }

        public Criteria andSalesbackReasonBetween(String value1, String value2) {
            addCriterion("salesback_reason between", value1, value2, "salesbackReason");
            return (Criteria) this;
        }

        public Criteria andSalesbackReasonNotBetween(String value1, String value2) {
            addCriterion("salesback_reason not between", value1, value2, "salesbackReason");
            return (Criteria) this;
        }

        public Criteria andSalesbackTimeIsNull() {
            addCriterion("salesback_time is null");
            return (Criteria) this;
        }

        public Criteria andSalesbackTimeIsNotNull() {
            addCriterion("salesback_time is not null");
            return (Criteria) this;
        }

        public Criteria andSalesbackTimeEqualTo(Date value) {
            addCriterionForJDBCDate("salesback_time =", value, "salesbackTime");
            return (Criteria) this;
        }

        public Criteria andSalesbackTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("salesback_time <>", value, "salesbackTime");
            return (Criteria) this;
        }

        public Criteria andSalesbackTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("salesback_time >", value, "salesbackTime");
            return (Criteria) this;
        }

        public Criteria andSalesbackTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("salesback_time >=", value, "salesbackTime");
            return (Criteria) this;
        }

        public Criteria andSalesbackTimeLessThan(Date value) {
            addCriterionForJDBCDate("salesback_time <", value, "salesbackTime");
            return (Criteria) this;
        }

        public Criteria andSalesbackTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("salesback_time <=", value, "salesbackTime");
            return (Criteria) this;
        }

        public Criteria andSalesbackTimeIn(List<Date> values) {
            addCriterionForJDBCDate("salesback_time in", values, "salesbackTime");
            return (Criteria) this;
        }

        public Criteria andSalesbackTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("salesback_time not in", values, "salesbackTime");
            return (Criteria) this;
        }

        public Criteria andSalesbackTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("salesback_time between", value1, value2, "salesbackTime");
            return (Criteria) this;
        }

        public Criteria andSalesbackTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("salesback_time not between", value1, value2, "salesbackTime");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundIsNull() {
            addCriterion("salesback_refund is null");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundIsNotNull() {
            addCriterion("salesback_refund is not null");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundEqualTo(Long value) {
            addCriterion("salesback_refund =", value, "salesbackRefund");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundNotEqualTo(Long value) {
            addCriterion("salesback_refund <>", value, "salesbackRefund");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundGreaterThan(Long value) {
            addCriterion("salesback_refund >", value, "salesbackRefund");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundGreaterThanOrEqualTo(Long value) {
            addCriterion("salesback_refund >=", value, "salesbackRefund");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundLessThan(Long value) {
            addCriterion("salesback_refund <", value, "salesbackRefund");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundLessThanOrEqualTo(Long value) {
            addCriterion("salesback_refund <=", value, "salesbackRefund");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundIn(List<Long> values) {
            addCriterion("salesback_refund in", values, "salesbackRefund");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundNotIn(List<Long> values) {
            addCriterion("salesback_refund not in", values, "salesbackRefund");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundBetween(Long value1, Long value2) {
            addCriterion("salesback_refund between", value1, value2, "salesbackRefund");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundNotBetween(Long value1, Long value2) {
            addCriterion("salesback_refund not between", value1, value2, "salesbackRefund");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundTypeIsNull() {
            addCriterion("salesback_refund_type is null");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundTypeIsNotNull() {
            addCriterion("salesback_refund_type is not null");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundTypeEqualTo(String value) {
            addCriterion("salesback_refund_type =", value, "salesbackRefundType");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundTypeNotEqualTo(String value) {
            addCriterion("salesback_refund_type <>", value, "salesbackRefundType");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundTypeGreaterThan(String value) {
            addCriterion("salesback_refund_type >", value, "salesbackRefundType");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundTypeGreaterThanOrEqualTo(String value) {
            addCriterion("salesback_refund_type >=", value, "salesbackRefundType");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundTypeLessThan(String value) {
            addCriterion("salesback_refund_type <", value, "salesbackRefundType");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundTypeLessThanOrEqualTo(String value) {
            addCriterion("salesback_refund_type <=", value, "salesbackRefundType");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundTypeLike(String value) {
            addCriterion("salesback_refund_type like", value, "salesbackRefundType");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundTypeNotLike(String value) {
            addCriterion("salesback_refund_type not like", value, "salesbackRefundType");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundTypeIn(List<String> values) {
            addCriterion("salesback_refund_type in", values, "salesbackRefundType");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundTypeNotIn(List<String> values) {
            addCriterion("salesback_refund_type not in", values, "salesbackRefundType");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundTypeBetween(String value1, String value2) {
            addCriterion("salesback_refund_type between", value1, value2, "salesbackRefundType");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundTypeNotBetween(String value1, String value2) {
            addCriterion("salesback_refund_type not between", value1, value2, "salesbackRefundType");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundTimeIsNull() {
            addCriterion("salesback_refund_time is null");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundTimeIsNotNull() {
            addCriterion("salesback_refund_time is not null");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundTimeEqualTo(Date value) {
            addCriterionForJDBCDate("salesback_refund_time =", value, "salesbackRefundTime");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("salesback_refund_time <>", value, "salesbackRefundTime");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("salesback_refund_time >", value, "salesbackRefundTime");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("salesback_refund_time >=", value, "salesbackRefundTime");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundTimeLessThan(Date value) {
            addCriterionForJDBCDate("salesback_refund_time <", value, "salesbackRefundTime");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("salesback_refund_time <=", value, "salesbackRefundTime");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundTimeIn(List<Date> values) {
            addCriterionForJDBCDate("salesback_refund_time in", values, "salesbackRefundTime");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("salesback_refund_time not in", values, "salesbackRefundTime");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("salesback_refund_time between", value1, value2, "salesbackRefundTime");
            return (Criteria) this;
        }

        public Criteria andSalesbackRefundTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("salesback_refund_time not between", value1, value2, "salesbackRefundTime");
            return (Criteria) this;
        }

        public Criteria andSalesbackRemarkIsNull() {
            addCriterion("salesback_remark is null");
            return (Criteria) this;
        }

        public Criteria andSalesbackRemarkIsNotNull() {
            addCriterion("salesback_remark is not null");
            return (Criteria) this;
        }

        public Criteria andSalesbackRemarkEqualTo(String value) {
            addCriterion("salesback_remark =", value, "salesbackRemark");
            return (Criteria) this;
        }

        public Criteria andSalesbackRemarkNotEqualTo(String value) {
            addCriterion("salesback_remark <>", value, "salesbackRemark");
            return (Criteria) this;
        }

        public Criteria andSalesbackRemarkGreaterThan(String value) {
            addCriterion("salesback_remark >", value, "salesbackRemark");
            return (Criteria) this;
        }

        public Criteria andSalesbackRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("salesback_remark >=", value, "salesbackRemark");
            return (Criteria) this;
        }

        public Criteria andSalesbackRemarkLessThan(String value) {
            addCriterion("salesback_remark <", value, "salesbackRemark");
            return (Criteria) this;
        }

        public Criteria andSalesbackRemarkLessThanOrEqualTo(String value) {
            addCriterion("salesback_remark <=", value, "salesbackRemark");
            return (Criteria) this;
        }

        public Criteria andSalesbackRemarkLike(String value) {
            addCriterion("salesback_remark like", value, "salesbackRemark");
            return (Criteria) this;
        }

        public Criteria andSalesbackRemarkNotLike(String value) {
            addCriterion("salesback_remark not like", value, "salesbackRemark");
            return (Criteria) this;
        }

        public Criteria andSalesbackRemarkIn(List<String> values) {
            addCriterion("salesback_remark in", values, "salesbackRemark");
            return (Criteria) this;
        }

        public Criteria andSalesbackRemarkNotIn(List<String> values) {
            addCriterion("salesback_remark not in", values, "salesbackRemark");
            return (Criteria) this;
        }

        public Criteria andSalesbackRemarkBetween(String value1, String value2) {
            addCriterion("salesback_remark between", value1, value2, "salesbackRemark");
            return (Criteria) this;
        }

        public Criteria andSalesbackRemarkNotBetween(String value1, String value2) {
            addCriterion("salesback_remark not between", value1, value2, "salesbackRemark");
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