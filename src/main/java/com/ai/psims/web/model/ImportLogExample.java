package com.ai.psims.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ImportLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImportLogExample() {
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

        public Criteria andImportSerialNumberIsNull() {
            addCriterion("import_serial_number is null");
            return (Criteria) this;
        }

        public Criteria andImportSerialNumberIsNotNull() {
            addCriterion("import_serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andImportSerialNumberEqualTo(String value) {
            addCriterion("import_serial_number =", value, "importSerialNumber");
            return (Criteria) this;
        }

        public Criteria andImportSerialNumberNotEqualTo(String value) {
            addCriterion("import_serial_number <>", value, "importSerialNumber");
            return (Criteria) this;
        }

        public Criteria andImportSerialNumberGreaterThan(String value) {
            addCriterion("import_serial_number >", value, "importSerialNumber");
            return (Criteria) this;
        }

        public Criteria andImportSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("import_serial_number >=", value, "importSerialNumber");
            return (Criteria) this;
        }

        public Criteria andImportSerialNumberLessThan(String value) {
            addCriterion("import_serial_number <", value, "importSerialNumber");
            return (Criteria) this;
        }

        public Criteria andImportSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("import_serial_number <=", value, "importSerialNumber");
            return (Criteria) this;
        }

        public Criteria andImportSerialNumberLike(String value) {
            addCriterion("import_serial_number like", value, "importSerialNumber");
            return (Criteria) this;
        }

        public Criteria andImportSerialNumberNotLike(String value) {
            addCriterion("import_serial_number not like", value, "importSerialNumber");
            return (Criteria) this;
        }

        public Criteria andImportSerialNumberIn(List<String> values) {
            addCriterion("import_serial_number in", values, "importSerialNumber");
            return (Criteria) this;
        }

        public Criteria andImportSerialNumberNotIn(List<String> values) {
            addCriterion("import_serial_number not in", values, "importSerialNumber");
            return (Criteria) this;
        }

        public Criteria andImportSerialNumberBetween(String value1, String value2) {
            addCriterion("import_serial_number between", value1, value2, "importSerialNumber");
            return (Criteria) this;
        }

        public Criteria andImportSerialNumberNotBetween(String value1, String value2) {
            addCriterion("import_serial_number not between", value1, value2, "importSerialNumber");
            return (Criteria) this;
        }

        public Criteria andImportDatetimeIsNull() {
            addCriterion("import_datetime is null");
            return (Criteria) this;
        }

        public Criteria andImportDatetimeIsNotNull() {
            addCriterion("import_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andImportDatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("import_datetime =", value, "importDatetime");
            return (Criteria) this;
        }

        public Criteria andImportDatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("import_datetime <>", value, "importDatetime");
            return (Criteria) this;
        }

        public Criteria andImportDatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("import_datetime >", value, "importDatetime");
            return (Criteria) this;
        }

        public Criteria andImportDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("import_datetime >=", value, "importDatetime");
            return (Criteria) this;
        }

        public Criteria andImportDatetimeLessThan(Date value) {
            addCriterionForJDBCDate("import_datetime <", value, "importDatetime");
            return (Criteria) this;
        }

        public Criteria andImportDatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("import_datetime <=", value, "importDatetime");
            return (Criteria) this;
        }

        public Criteria andImportDatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("import_datetime in", values, "importDatetime");
            return (Criteria) this;
        }

        public Criteria andImportDatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("import_datetime not in", values, "importDatetime");
            return (Criteria) this;
        }

        public Criteria andImportDatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("import_datetime between", value1, value2, "importDatetime");
            return (Criteria) this;
        }

        public Criteria andImportDatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("import_datetime not between", value1, value2, "importDatetime");
            return (Criteria) this;
        }

        public Criteria andImportBatchNumberIsNull() {
            addCriterion("import_batch_number is null");
            return (Criteria) this;
        }

        public Criteria andImportBatchNumberIsNotNull() {
            addCriterion("import_batch_number is not null");
            return (Criteria) this;
        }

        public Criteria andImportBatchNumberEqualTo(String value) {
            addCriterion("import_batch_number =", value, "importBatchNumber");
            return (Criteria) this;
        }

        public Criteria andImportBatchNumberNotEqualTo(String value) {
            addCriterion("import_batch_number <>", value, "importBatchNumber");
            return (Criteria) this;
        }

        public Criteria andImportBatchNumberGreaterThan(String value) {
            addCriterion("import_batch_number >", value, "importBatchNumber");
            return (Criteria) this;
        }

        public Criteria andImportBatchNumberGreaterThanOrEqualTo(String value) {
            addCriterion("import_batch_number >=", value, "importBatchNumber");
            return (Criteria) this;
        }

        public Criteria andImportBatchNumberLessThan(String value) {
            addCriterion("import_batch_number <", value, "importBatchNumber");
            return (Criteria) this;
        }

        public Criteria andImportBatchNumberLessThanOrEqualTo(String value) {
            addCriterion("import_batch_number <=", value, "importBatchNumber");
            return (Criteria) this;
        }

        public Criteria andImportBatchNumberLike(String value) {
            addCriterion("import_batch_number like", value, "importBatchNumber");
            return (Criteria) this;
        }

        public Criteria andImportBatchNumberNotLike(String value) {
            addCriterion("import_batch_number not like", value, "importBatchNumber");
            return (Criteria) this;
        }

        public Criteria andImportBatchNumberIn(List<String> values) {
            addCriterion("import_batch_number in", values, "importBatchNumber");
            return (Criteria) this;
        }

        public Criteria andImportBatchNumberNotIn(List<String> values) {
            addCriterion("import_batch_number not in", values, "importBatchNumber");
            return (Criteria) this;
        }

        public Criteria andImportBatchNumberBetween(String value1, String value2) {
            addCriterion("import_batch_number between", value1, value2, "importBatchNumber");
            return (Criteria) this;
        }

        public Criteria andImportBatchNumberNotBetween(String value1, String value2) {
            addCriterion("import_batch_number not between", value1, value2, "importBatchNumber");
            return (Criteria) this;
        }

        public Criteria andImportTotalPriceIsNull() {
            addCriterion("import_total_price is null");
            return (Criteria) this;
        }

        public Criteria andImportTotalPriceIsNotNull() {
            addCriterion("import_total_price is not null");
            return (Criteria) this;
        }

        public Criteria andImportTotalPriceEqualTo(Long value) {
            addCriterion("import_total_price =", value, "importTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportTotalPriceNotEqualTo(Long value) {
            addCriterion("import_total_price <>", value, "importTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportTotalPriceGreaterThan(Long value) {
            addCriterion("import_total_price >", value, "importTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportTotalPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("import_total_price >=", value, "importTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportTotalPriceLessThan(Long value) {
            addCriterion("import_total_price <", value, "importTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportTotalPriceLessThanOrEqualTo(Long value) {
            addCriterion("import_total_price <=", value, "importTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportTotalPriceIn(List<Long> values) {
            addCriterion("import_total_price in", values, "importTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportTotalPriceNotIn(List<Long> values) {
            addCriterion("import_total_price not in", values, "importTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportTotalPriceBetween(Long value1, Long value2) {
            addCriterion("import_total_price between", value1, value2, "importTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportTotalPriceNotBetween(Long value1, Long value2) {
            addCriterion("import_total_price not between", value1, value2, "importTotalPrice");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIsNull() {
            addCriterion("payment_type is null");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIsNotNull() {
            addCriterion("payment_type is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeEqualTo(String value) {
            addCriterion("payment_type =", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotEqualTo(String value) {
            addCriterion("payment_type <>", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeGreaterThan(String value) {
            addCriterion("payment_type >", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("payment_type >=", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLessThan(String value) {
            addCriterion("payment_type <", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLessThanOrEqualTo(String value) {
            addCriterion("payment_type <=", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLike(String value) {
            addCriterion("payment_type like", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotLike(String value) {
            addCriterion("payment_type not like", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIn(List<String> values) {
            addCriterion("payment_type in", values, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotIn(List<String> values) {
            addCriterion("payment_type not in", values, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeBetween(String value1, String value2) {
            addCriterion("payment_type between", value1, value2, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotBetween(String value1, String value2) {
            addCriterion("payment_type not between", value1, value2, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIsNull() {
            addCriterion("payment_time is null");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIsNotNull() {
            addCriterion("payment_time is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeEqualTo(Date value) {
            addCriterionForJDBCDate("payment_time =", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("payment_time <>", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("payment_time >", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("payment_time >=", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeLessThan(Date value) {
            addCriterionForJDBCDate("payment_time <", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("payment_time <=", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIn(List<Date> values) {
            addCriterionForJDBCDate("payment_time in", values, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("payment_time not in", values, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("payment_time between", value1, value2, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("payment_time not between", value1, value2, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andImportTypeIsNull() {
            addCriterion("import_type is null");
            return (Criteria) this;
        }

        public Criteria andImportTypeIsNotNull() {
            addCriterion("import_type is not null");
            return (Criteria) this;
        }

        public Criteria andImportTypeEqualTo(String value) {
            addCriterion("import_type =", value, "importType");
            return (Criteria) this;
        }

        public Criteria andImportTypeNotEqualTo(String value) {
            addCriterion("import_type <>", value, "importType");
            return (Criteria) this;
        }

        public Criteria andImportTypeGreaterThan(String value) {
            addCriterion("import_type >", value, "importType");
            return (Criteria) this;
        }

        public Criteria andImportTypeGreaterThanOrEqualTo(String value) {
            addCriterion("import_type >=", value, "importType");
            return (Criteria) this;
        }

        public Criteria andImportTypeLessThan(String value) {
            addCriterion("import_type <", value, "importType");
            return (Criteria) this;
        }

        public Criteria andImportTypeLessThanOrEqualTo(String value) {
            addCriterion("import_type <=", value, "importType");
            return (Criteria) this;
        }

        public Criteria andImportTypeLike(String value) {
            addCriterion("import_type like", value, "importType");
            return (Criteria) this;
        }

        public Criteria andImportTypeNotLike(String value) {
            addCriterion("import_type not like", value, "importType");
            return (Criteria) this;
        }

        public Criteria andImportTypeIn(List<String> values) {
            addCriterion("import_type in", values, "importType");
            return (Criteria) this;
        }

        public Criteria andImportTypeNotIn(List<String> values) {
            addCriterion("import_type not in", values, "importType");
            return (Criteria) this;
        }

        public Criteria andImportTypeBetween(String value1, String value2) {
            addCriterion("import_type between", value1, value2, "importType");
            return (Criteria) this;
        }

        public Criteria andImportTypeNotBetween(String value1, String value2) {
            addCriterion("import_type not between", value1, value2, "importType");
            return (Criteria) this;
        }

        public Criteria andImportStatusIsNull() {
            addCriterion("import_status is null");
            return (Criteria) this;
        }

        public Criteria andImportStatusIsNotNull() {
            addCriterion("import_status is not null");
            return (Criteria) this;
        }

        public Criteria andImportStatusEqualTo(String value) {
            addCriterion("import_status =", value, "importStatus");
            return (Criteria) this;
        }

        public Criteria andImportStatusNotEqualTo(String value) {
            addCriterion("import_status <>", value, "importStatus");
            return (Criteria) this;
        }

        public Criteria andImportStatusGreaterThan(String value) {
            addCriterion("import_status >", value, "importStatus");
            return (Criteria) this;
        }

        public Criteria andImportStatusGreaterThanOrEqualTo(String value) {
            addCriterion("import_status >=", value, "importStatus");
            return (Criteria) this;
        }

        public Criteria andImportStatusLessThan(String value) {
            addCriterion("import_status <", value, "importStatus");
            return (Criteria) this;
        }

        public Criteria andImportStatusLessThanOrEqualTo(String value) {
            addCriterion("import_status <=", value, "importStatus");
            return (Criteria) this;
        }

        public Criteria andImportStatusLike(String value) {
            addCriterion("import_status like", value, "importStatus");
            return (Criteria) this;
        }

        public Criteria andImportStatusNotLike(String value) {
            addCriterion("import_status not like", value, "importStatus");
            return (Criteria) this;
        }

        public Criteria andImportStatusIn(List<String> values) {
            addCriterion("import_status in", values, "importStatus");
            return (Criteria) this;
        }

        public Criteria andImportStatusNotIn(List<String> values) {
            addCriterion("import_status not in", values, "importStatus");
            return (Criteria) this;
        }

        public Criteria andImportStatusBetween(String value1, String value2) {
            addCriterion("import_status between", value1, value2, "importStatus");
            return (Criteria) this;
        }

        public Criteria andImportStatusNotBetween(String value1, String value2) {
            addCriterion("import_status not between", value1, value2, "importStatus");
            return (Criteria) this;
        }

        public Criteria andImportRemarkIsNull() {
            addCriterion("import_remark is null");
            return (Criteria) this;
        }

        public Criteria andImportRemarkIsNotNull() {
            addCriterion("import_remark is not null");
            return (Criteria) this;
        }

        public Criteria andImportRemarkEqualTo(String value) {
            addCriterion("import_remark =", value, "importRemark");
            return (Criteria) this;
        }

        public Criteria andImportRemarkNotEqualTo(String value) {
            addCriterion("import_remark <>", value, "importRemark");
            return (Criteria) this;
        }

        public Criteria andImportRemarkGreaterThan(String value) {
            addCriterion("import_remark >", value, "importRemark");
            return (Criteria) this;
        }

        public Criteria andImportRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("import_remark >=", value, "importRemark");
            return (Criteria) this;
        }

        public Criteria andImportRemarkLessThan(String value) {
            addCriterion("import_remark <", value, "importRemark");
            return (Criteria) this;
        }

        public Criteria andImportRemarkLessThanOrEqualTo(String value) {
            addCriterion("import_remark <=", value, "importRemark");
            return (Criteria) this;
        }

        public Criteria andImportRemarkLike(String value) {
            addCriterion("import_remark like", value, "importRemark");
            return (Criteria) this;
        }

        public Criteria andImportRemarkNotLike(String value) {
            addCriterion("import_remark not like", value, "importRemark");
            return (Criteria) this;
        }

        public Criteria andImportRemarkIn(List<String> values) {
            addCriterion("import_remark in", values, "importRemark");
            return (Criteria) this;
        }

        public Criteria andImportRemarkNotIn(List<String> values) {
            addCriterion("import_remark not in", values, "importRemark");
            return (Criteria) this;
        }

        public Criteria andImportRemarkBetween(String value1, String value2) {
            addCriterion("import_remark between", value1, value2, "importRemark");
            return (Criteria) this;
        }

        public Criteria andImportRemarkNotBetween(String value1, String value2) {
            addCriterion("import_remark not between", value1, value2, "importRemark");
            return (Criteria) this;
        }

        public Criteria andProviderIdIsNull() {
            addCriterion("provider_id is null");
            return (Criteria) this;
        }

        public Criteria andProviderIdIsNotNull() {
            addCriterion("provider_id is not null");
            return (Criteria) this;
        }

        public Criteria andProviderIdEqualTo(Integer value) {
            addCriterion("provider_id =", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotEqualTo(Integer value) {
            addCriterion("provider_id <>", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdGreaterThan(Integer value) {
            addCriterion("provider_id >", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("provider_id >=", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdLessThan(Integer value) {
            addCriterion("provider_id <", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdLessThanOrEqualTo(Integer value) {
            addCriterion("provider_id <=", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdIn(List<Integer> values) {
            addCriterion("provider_id in", values, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotIn(List<Integer> values) {
            addCriterion("provider_id not in", values, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdBetween(Integer value1, Integer value2) {
            addCriterion("provider_id between", value1, value2, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("provider_id not between", value1, value2, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderNameIsNull() {
            addCriterion("provider_name is null");
            return (Criteria) this;
        }

        public Criteria andProviderNameIsNotNull() {
            addCriterion("provider_name is not null");
            return (Criteria) this;
        }

        public Criteria andProviderNameEqualTo(String value) {
            addCriterion("provider_name =", value, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameNotEqualTo(String value) {
            addCriterion("provider_name <>", value, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameGreaterThan(String value) {
            addCriterion("provider_name >", value, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameGreaterThanOrEqualTo(String value) {
            addCriterion("provider_name >=", value, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameLessThan(String value) {
            addCriterion("provider_name <", value, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameLessThanOrEqualTo(String value) {
            addCriterion("provider_name <=", value, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameLike(String value) {
            addCriterion("provider_name like", value, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameNotLike(String value) {
            addCriterion("provider_name not like", value, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameIn(List<String> values) {
            addCriterion("provider_name in", values, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameNotIn(List<String> values) {
            addCriterion("provider_name not in", values, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameBetween(String value1, String value2) {
            addCriterion("provider_name between", value1, value2, "providerName");
            return (Criteria) this;
        }

        public Criteria andProviderNameNotBetween(String value1, String value2) {
            addCriterion("provider_name not between", value1, value2, "providerName");
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