package com.ai.psims.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ImportbackExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImportbackExample() {
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

        public Criteria andImportbackSerialNumberIsNull() {
            addCriterion("importback_serial_number is null");
            return (Criteria) this;
        }

        public Criteria andImportbackSerialNumberIsNotNull() {
            addCriterion("importback_serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andImportbackSerialNumberEqualTo(String value) {
            addCriterion("importback_serial_number =", value, "importbackSerialNumber");
            return (Criteria) this;
        }

        public Criteria andImportbackSerialNumberNotEqualTo(String value) {
            addCriterion("importback_serial_number <>", value, "importbackSerialNumber");
            return (Criteria) this;
        }

        public Criteria andImportbackSerialNumberGreaterThan(String value) {
            addCriterion("importback_serial_number >", value, "importbackSerialNumber");
            return (Criteria) this;
        }

        public Criteria andImportbackSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("importback_serial_number >=", value, "importbackSerialNumber");
            return (Criteria) this;
        }

        public Criteria andImportbackSerialNumberLessThan(String value) {
            addCriterion("importback_serial_number <", value, "importbackSerialNumber");
            return (Criteria) this;
        }

        public Criteria andImportbackSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("importback_serial_number <=", value, "importbackSerialNumber");
            return (Criteria) this;
        }

        public Criteria andImportbackSerialNumberLike(String value) {
            addCriterion("importback_serial_number like", value, "importbackSerialNumber");
            return (Criteria) this;
        }

        public Criteria andImportbackSerialNumberNotLike(String value) {
            addCriterion("importback_serial_number not like", value, "importbackSerialNumber");
            return (Criteria) this;
        }

        public Criteria andImportbackSerialNumberIn(List<String> values) {
            addCriterion("importback_serial_number in", values, "importbackSerialNumber");
            return (Criteria) this;
        }

        public Criteria andImportbackSerialNumberNotIn(List<String> values) {
            addCriterion("importback_serial_number not in", values, "importbackSerialNumber");
            return (Criteria) this;
        }

        public Criteria andImportbackSerialNumberBetween(String value1, String value2) {
            addCriterion("importback_serial_number between", value1, value2, "importbackSerialNumber");
            return (Criteria) this;
        }

        public Criteria andImportbackSerialNumberNotBetween(String value1, String value2) {
            addCriterion("importback_serial_number not between", value1, value2, "importbackSerialNumber");
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

        public Criteria andImportbackTypeIsNull() {
            addCriterion("importback_type is null");
            return (Criteria) this;
        }

        public Criteria andImportbackTypeIsNotNull() {
            addCriterion("importback_type is not null");
            return (Criteria) this;
        }

        public Criteria andImportbackTypeEqualTo(String value) {
            addCriterion("importback_type =", value, "importbackType");
            return (Criteria) this;
        }

        public Criteria andImportbackTypeNotEqualTo(String value) {
            addCriterion("importback_type <>", value, "importbackType");
            return (Criteria) this;
        }

        public Criteria andImportbackTypeGreaterThan(String value) {
            addCriterion("importback_type >", value, "importbackType");
            return (Criteria) this;
        }

        public Criteria andImportbackTypeGreaterThanOrEqualTo(String value) {
            addCriterion("importback_type >=", value, "importbackType");
            return (Criteria) this;
        }

        public Criteria andImportbackTypeLessThan(String value) {
            addCriterion("importback_type <", value, "importbackType");
            return (Criteria) this;
        }

        public Criteria andImportbackTypeLessThanOrEqualTo(String value) {
            addCriterion("importback_type <=", value, "importbackType");
            return (Criteria) this;
        }

        public Criteria andImportbackTypeLike(String value) {
            addCriterion("importback_type like", value, "importbackType");
            return (Criteria) this;
        }

        public Criteria andImportbackTypeNotLike(String value) {
            addCriterion("importback_type not like", value, "importbackType");
            return (Criteria) this;
        }

        public Criteria andImportbackTypeIn(List<String> values) {
            addCriterion("importback_type in", values, "importbackType");
            return (Criteria) this;
        }

        public Criteria andImportbackTypeNotIn(List<String> values) {
            addCriterion("importback_type not in", values, "importbackType");
            return (Criteria) this;
        }

        public Criteria andImportbackTypeBetween(String value1, String value2) {
            addCriterion("importback_type between", value1, value2, "importbackType");
            return (Criteria) this;
        }

        public Criteria andImportbackTypeNotBetween(String value1, String value2) {
            addCriterion("importback_type not between", value1, value2, "importbackType");
            return (Criteria) this;
        }

        public Criteria andImportbackReasonIsNull() {
            addCriterion("importback_reason is null");
            return (Criteria) this;
        }

        public Criteria andImportbackReasonIsNotNull() {
            addCriterion("importback_reason is not null");
            return (Criteria) this;
        }

        public Criteria andImportbackReasonEqualTo(String value) {
            addCriterion("importback_reason =", value, "importbackReason");
            return (Criteria) this;
        }

        public Criteria andImportbackReasonNotEqualTo(String value) {
            addCriterion("importback_reason <>", value, "importbackReason");
            return (Criteria) this;
        }

        public Criteria andImportbackReasonGreaterThan(String value) {
            addCriterion("importback_reason >", value, "importbackReason");
            return (Criteria) this;
        }

        public Criteria andImportbackReasonGreaterThanOrEqualTo(String value) {
            addCriterion("importback_reason >=", value, "importbackReason");
            return (Criteria) this;
        }

        public Criteria andImportbackReasonLessThan(String value) {
            addCriterion("importback_reason <", value, "importbackReason");
            return (Criteria) this;
        }

        public Criteria andImportbackReasonLessThanOrEqualTo(String value) {
            addCriterion("importback_reason <=", value, "importbackReason");
            return (Criteria) this;
        }

        public Criteria andImportbackReasonLike(String value) {
            addCriterion("importback_reason like", value, "importbackReason");
            return (Criteria) this;
        }

        public Criteria andImportbackReasonNotLike(String value) {
            addCriterion("importback_reason not like", value, "importbackReason");
            return (Criteria) this;
        }

        public Criteria andImportbackReasonIn(List<String> values) {
            addCriterion("importback_reason in", values, "importbackReason");
            return (Criteria) this;
        }

        public Criteria andImportbackReasonNotIn(List<String> values) {
            addCriterion("importback_reason not in", values, "importbackReason");
            return (Criteria) this;
        }

        public Criteria andImportbackReasonBetween(String value1, String value2) {
            addCriterion("importback_reason between", value1, value2, "importbackReason");
            return (Criteria) this;
        }

        public Criteria andImportbackReasonNotBetween(String value1, String value2) {
            addCriterion("importback_reason not between", value1, value2, "importbackReason");
            return (Criteria) this;
        }

        public Criteria andImportbackTimeIsNull() {
            addCriterion("importback_time is null");
            return (Criteria) this;
        }

        public Criteria andImportbackTimeIsNotNull() {
            addCriterion("importback_time is not null");
            return (Criteria) this;
        }

        public Criteria andImportbackTimeEqualTo(Date value) {
            addCriterionForJDBCDate("importback_time =", value, "importbackTime");
            return (Criteria) this;
        }

        public Criteria andImportbackTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("importback_time <>", value, "importbackTime");
            return (Criteria) this;
        }

        public Criteria andImportbackTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("importback_time >", value, "importbackTime");
            return (Criteria) this;
        }

        public Criteria andImportbackTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("importback_time >=", value, "importbackTime");
            return (Criteria) this;
        }

        public Criteria andImportbackTimeLessThan(Date value) {
            addCriterionForJDBCDate("importback_time <", value, "importbackTime");
            return (Criteria) this;
        }

        public Criteria andImportbackTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("importback_time <=", value, "importbackTime");
            return (Criteria) this;
        }

        public Criteria andImportbackTimeIn(List<Date> values) {
            addCriterionForJDBCDate("importback_time in", values, "importbackTime");
            return (Criteria) this;
        }

        public Criteria andImportbackTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("importback_time not in", values, "importbackTime");
            return (Criteria) this;
        }

        public Criteria andImportbackTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("importback_time between", value1, value2, "importbackTime");
            return (Criteria) this;
        }

        public Criteria andImportbackTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("importback_time not between", value1, value2, "importbackTime");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundIsNull() {
            addCriterion("importback_refund is null");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundIsNotNull() {
            addCriterion("importback_refund is not null");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundEqualTo(Long value) {
            addCriterion("importback_refund =", value, "importbackRefund");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundNotEqualTo(Long value) {
            addCriterion("importback_refund <>", value, "importbackRefund");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundGreaterThan(Long value) {
            addCriterion("importback_refund >", value, "importbackRefund");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundGreaterThanOrEqualTo(Long value) {
            addCriterion("importback_refund >=", value, "importbackRefund");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundLessThan(Long value) {
            addCriterion("importback_refund <", value, "importbackRefund");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundLessThanOrEqualTo(Long value) {
            addCriterion("importback_refund <=", value, "importbackRefund");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundIn(List<Long> values) {
            addCriterion("importback_refund in", values, "importbackRefund");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundNotIn(List<Long> values) {
            addCriterion("importback_refund not in", values, "importbackRefund");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundBetween(Long value1, Long value2) {
            addCriterion("importback_refund between", value1, value2, "importbackRefund");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundNotBetween(Long value1, Long value2) {
            addCriterion("importback_refund not between", value1, value2, "importbackRefund");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundTypeIsNull() {
            addCriterion("importback_refund_type is null");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundTypeIsNotNull() {
            addCriterion("importback_refund_type is not null");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundTypeEqualTo(String value) {
            addCriterion("importback_refund_type =", value, "importbackRefundType");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundTypeNotEqualTo(String value) {
            addCriterion("importback_refund_type <>", value, "importbackRefundType");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundTypeGreaterThan(String value) {
            addCriterion("importback_refund_type >", value, "importbackRefundType");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundTypeGreaterThanOrEqualTo(String value) {
            addCriterion("importback_refund_type >=", value, "importbackRefundType");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundTypeLessThan(String value) {
            addCriterion("importback_refund_type <", value, "importbackRefundType");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundTypeLessThanOrEqualTo(String value) {
            addCriterion("importback_refund_type <=", value, "importbackRefundType");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundTypeLike(String value) {
            addCriterion("importback_refund_type like", value, "importbackRefundType");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundTypeNotLike(String value) {
            addCriterion("importback_refund_type not like", value, "importbackRefundType");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundTypeIn(List<String> values) {
            addCriterion("importback_refund_type in", values, "importbackRefundType");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundTypeNotIn(List<String> values) {
            addCriterion("importback_refund_type not in", values, "importbackRefundType");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundTypeBetween(String value1, String value2) {
            addCriterion("importback_refund_type between", value1, value2, "importbackRefundType");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundTypeNotBetween(String value1, String value2) {
            addCriterion("importback_refund_type not between", value1, value2, "importbackRefundType");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundTimeIsNull() {
            addCriterion("importback_refund_time is null");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundTimeIsNotNull() {
            addCriterion("importback_refund_time is not null");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundTimeEqualTo(Date value) {
            addCriterionForJDBCDate("importback_refund_time =", value, "importbackRefundTime");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("importback_refund_time <>", value, "importbackRefundTime");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("importback_refund_time >", value, "importbackRefundTime");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("importback_refund_time >=", value, "importbackRefundTime");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundTimeLessThan(Date value) {
            addCriterionForJDBCDate("importback_refund_time <", value, "importbackRefundTime");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("importback_refund_time <=", value, "importbackRefundTime");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundTimeIn(List<Date> values) {
            addCriterionForJDBCDate("importback_refund_time in", values, "importbackRefundTime");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("importback_refund_time not in", values, "importbackRefundTime");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("importback_refund_time between", value1, value2, "importbackRefundTime");
            return (Criteria) this;
        }

        public Criteria andImportbackRefundTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("importback_refund_time not between", value1, value2, "importbackRefundTime");
            return (Criteria) this;
        }

        public Criteria andImportbackRemarkIsNull() {
            addCriterion("importback_remark is null");
            return (Criteria) this;
        }

        public Criteria andImportbackRemarkIsNotNull() {
            addCriterion("importback_remark is not null");
            return (Criteria) this;
        }

        public Criteria andImportbackRemarkEqualTo(String value) {
            addCriterion("importback_remark =", value, "importbackRemark");
            return (Criteria) this;
        }

        public Criteria andImportbackRemarkNotEqualTo(String value) {
            addCriterion("importback_remark <>", value, "importbackRemark");
            return (Criteria) this;
        }

        public Criteria andImportbackRemarkGreaterThan(String value) {
            addCriterion("importback_remark >", value, "importbackRemark");
            return (Criteria) this;
        }

        public Criteria andImportbackRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("importback_remark >=", value, "importbackRemark");
            return (Criteria) this;
        }

        public Criteria andImportbackRemarkLessThan(String value) {
            addCriterion("importback_remark <", value, "importbackRemark");
            return (Criteria) this;
        }

        public Criteria andImportbackRemarkLessThanOrEqualTo(String value) {
            addCriterion("importback_remark <=", value, "importbackRemark");
            return (Criteria) this;
        }

        public Criteria andImportbackRemarkLike(String value) {
            addCriterion("importback_remark like", value, "importbackRemark");
            return (Criteria) this;
        }

        public Criteria andImportbackRemarkNotLike(String value) {
            addCriterion("importback_remark not like", value, "importbackRemark");
            return (Criteria) this;
        }

        public Criteria andImportbackRemarkIn(List<String> values) {
            addCriterion("importback_remark in", values, "importbackRemark");
            return (Criteria) this;
        }

        public Criteria andImportbackRemarkNotIn(List<String> values) {
            addCriterion("importback_remark not in", values, "importbackRemark");
            return (Criteria) this;
        }

        public Criteria andImportbackRemarkBetween(String value1, String value2) {
            addCriterion("importback_remark between", value1, value2, "importbackRemark");
            return (Criteria) this;
        }

        public Criteria andImportbackRemarkNotBetween(String value1, String value2) {
            addCriterion("importback_remark not between", value1, value2, "importbackRemark");
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