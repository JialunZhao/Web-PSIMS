package com.ai.psims.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StoragecheckLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoragecheckLogExample() {
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

        public Criteria andStorageIdIsNull() {
            addCriterion("storage_id is null");
            return (Criteria) this;
        }

        public Criteria andStorageIdIsNotNull() {
            addCriterion("storage_id is not null");
            return (Criteria) this;
        }

        public Criteria andStorageIdEqualTo(Integer value) {
            addCriterion("storage_id =", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdNotEqualTo(Integer value) {
            addCriterion("storage_id <>", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdGreaterThan(Integer value) {
            addCriterion("storage_id >", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("storage_id >=", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdLessThan(Integer value) {
            addCriterion("storage_id <", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdLessThanOrEqualTo(Integer value) {
            addCriterion("storage_id <=", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdIn(List<Integer> values) {
            addCriterion("storage_id in", values, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdNotIn(List<Integer> values) {
            addCriterion("storage_id not in", values, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdBetween(Integer value1, Integer value2) {
            addCriterion("storage_id between", value1, value2, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("storage_id not between", value1, value2, "storageId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Integer value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Integer value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Integer value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Integer value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Integer> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Integer> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsBarCodeIsNull() {
            addCriterion("goods_bar_code is null");
            return (Criteria) this;
        }

        public Criteria andGoodsBarCodeIsNotNull() {
            addCriterion("goods_bar_code is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsBarCodeEqualTo(String value) {
            addCriterion("goods_bar_code =", value, "goodsBarCode");
            return (Criteria) this;
        }

        public Criteria andGoodsBarCodeNotEqualTo(String value) {
            addCriterion("goods_bar_code <>", value, "goodsBarCode");
            return (Criteria) this;
        }

        public Criteria andGoodsBarCodeGreaterThan(String value) {
            addCriterion("goods_bar_code >", value, "goodsBarCode");
            return (Criteria) this;
        }

        public Criteria andGoodsBarCodeGreaterThanOrEqualTo(String value) {
            addCriterion("goods_bar_code >=", value, "goodsBarCode");
            return (Criteria) this;
        }

        public Criteria andGoodsBarCodeLessThan(String value) {
            addCriterion("goods_bar_code <", value, "goodsBarCode");
            return (Criteria) this;
        }

        public Criteria andGoodsBarCodeLessThanOrEqualTo(String value) {
            addCriterion("goods_bar_code <=", value, "goodsBarCode");
            return (Criteria) this;
        }

        public Criteria andGoodsBarCodeLike(String value) {
            addCriterion("goods_bar_code like", value, "goodsBarCode");
            return (Criteria) this;
        }

        public Criteria andGoodsBarCodeNotLike(String value) {
            addCriterion("goods_bar_code not like", value, "goodsBarCode");
            return (Criteria) this;
        }

        public Criteria andGoodsBarCodeIn(List<String> values) {
            addCriterion("goods_bar_code in", values, "goodsBarCode");
            return (Criteria) this;
        }

        public Criteria andGoodsBarCodeNotIn(List<String> values) {
            addCriterion("goods_bar_code not in", values, "goodsBarCode");
            return (Criteria) this;
        }

        public Criteria andGoodsBarCodeBetween(String value1, String value2) {
            addCriterion("goods_bar_code between", value1, value2, "goodsBarCode");
            return (Criteria) this;
        }

        public Criteria andGoodsBarCodeNotBetween(String value1, String value2) {
            addCriterion("goods_bar_code not between", value1, value2, "goodsBarCode");
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

        public Criteria andStorageRateCurrentIsNull() {
            addCriterion("storage_rate_current is null");
            return (Criteria) this;
        }

        public Criteria andStorageRateCurrentIsNotNull() {
            addCriterion("storage_rate_current is not null");
            return (Criteria) this;
        }

        public Criteria andStorageRateCurrentEqualTo(Integer value) {
            addCriterion("storage_rate_current =", value, "storageRateCurrent");
            return (Criteria) this;
        }

        public Criteria andStorageRateCurrentNotEqualTo(Integer value) {
            addCriterion("storage_rate_current <>", value, "storageRateCurrent");
            return (Criteria) this;
        }

        public Criteria andStorageRateCurrentGreaterThan(Integer value) {
            addCriterion("storage_rate_current >", value, "storageRateCurrent");
            return (Criteria) this;
        }

        public Criteria andStorageRateCurrentGreaterThanOrEqualTo(Integer value) {
            addCriterion("storage_rate_current >=", value, "storageRateCurrent");
            return (Criteria) this;
        }

        public Criteria andStorageRateCurrentLessThan(Integer value) {
            addCriterion("storage_rate_current <", value, "storageRateCurrent");
            return (Criteria) this;
        }

        public Criteria andStorageRateCurrentLessThanOrEqualTo(Integer value) {
            addCriterion("storage_rate_current <=", value, "storageRateCurrent");
            return (Criteria) this;
        }

        public Criteria andStorageRateCurrentIn(List<Integer> values) {
            addCriterion("storage_rate_current in", values, "storageRateCurrent");
            return (Criteria) this;
        }

        public Criteria andStorageRateCurrentNotIn(List<Integer> values) {
            addCriterion("storage_rate_current not in", values, "storageRateCurrent");
            return (Criteria) this;
        }

        public Criteria andStorageRateCurrentBetween(Integer value1, Integer value2) {
            addCriterion("storage_rate_current between", value1, value2, "storageRateCurrent");
            return (Criteria) this;
        }

        public Criteria andStorageRateCurrentNotBetween(Integer value1, Integer value2) {
            addCriterion("storage_rate_current not between", value1, value2, "storageRateCurrent");
            return (Criteria) this;
        }

        public Criteria andStorageRateTotalIsNull() {
            addCriterion("storage_rate_total is null");
            return (Criteria) this;
        }

        public Criteria andStorageRateTotalIsNotNull() {
            addCriterion("storage_rate_total is not null");
            return (Criteria) this;
        }

        public Criteria andStorageRateTotalEqualTo(Integer value) {
            addCriterion("storage_rate_total =", value, "storageRateTotal");
            return (Criteria) this;
        }

        public Criteria andStorageRateTotalNotEqualTo(Integer value) {
            addCriterion("storage_rate_total <>", value, "storageRateTotal");
            return (Criteria) this;
        }

        public Criteria andStorageRateTotalGreaterThan(Integer value) {
            addCriterion("storage_rate_total >", value, "storageRateTotal");
            return (Criteria) this;
        }

        public Criteria andStorageRateTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("storage_rate_total >=", value, "storageRateTotal");
            return (Criteria) this;
        }

        public Criteria andStorageRateTotalLessThan(Integer value) {
            addCriterion("storage_rate_total <", value, "storageRateTotal");
            return (Criteria) this;
        }

        public Criteria andStorageRateTotalLessThanOrEqualTo(Integer value) {
            addCriterion("storage_rate_total <=", value, "storageRateTotal");
            return (Criteria) this;
        }

        public Criteria andStorageRateTotalIn(List<Integer> values) {
            addCriterion("storage_rate_total in", values, "storageRateTotal");
            return (Criteria) this;
        }

        public Criteria andStorageRateTotalNotIn(List<Integer> values) {
            addCriterion("storage_rate_total not in", values, "storageRateTotal");
            return (Criteria) this;
        }

        public Criteria andStorageRateTotalBetween(Integer value1, Integer value2) {
            addCriterion("storage_rate_total between", value1, value2, "storageRateTotal");
            return (Criteria) this;
        }

        public Criteria andStorageRateTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("storage_rate_total not between", value1, value2, "storageRateTotal");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionDateIsNull() {
            addCriterion("goods_production_date is null");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionDateIsNotNull() {
            addCriterion("goods_production_date is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionDateEqualTo(Date value) {
            addCriterionForJDBCDate("goods_production_date =", value, "goodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("goods_production_date <>", value, "goodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionDateGreaterThan(Date value) {
            addCriterionForJDBCDate("goods_production_date >", value, "goodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("goods_production_date >=", value, "goodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionDateLessThan(Date value) {
            addCriterionForJDBCDate("goods_production_date <", value, "goodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("goods_production_date <=", value, "goodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionDateIn(List<Date> values) {
            addCriterionForJDBCDate("goods_production_date in", values, "goodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("goods_production_date not in", values, "goodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("goods_production_date between", value1, value2, "goodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("goods_production_date not between", value1, value2, "goodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andGoodsExpirationDateIsNull() {
            addCriterion("goods_expiration_date is null");
            return (Criteria) this;
        }

        public Criteria andGoodsExpirationDateIsNotNull() {
            addCriterion("goods_expiration_date is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsExpirationDateEqualTo(Date value) {
            addCriterionForJDBCDate("goods_expiration_date =", value, "goodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andGoodsExpirationDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("goods_expiration_date <>", value, "goodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andGoodsExpirationDateGreaterThan(Date value) {
            addCriterionForJDBCDate("goods_expiration_date >", value, "goodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andGoodsExpirationDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("goods_expiration_date >=", value, "goodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andGoodsExpirationDateLessThan(Date value) {
            addCriterionForJDBCDate("goods_expiration_date <", value, "goodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andGoodsExpirationDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("goods_expiration_date <=", value, "goodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andGoodsExpirationDateIn(List<Date> values) {
            addCriterionForJDBCDate("goods_expiration_date in", values, "goodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andGoodsExpirationDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("goods_expiration_date not in", values, "goodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andGoodsExpirationDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("goods_expiration_date between", value1, value2, "goodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andGoodsExpirationDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("goods_expiration_date not between", value1, value2, "goodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andGoodsShelfLifeIsNull() {
            addCriterion("goods_shelf_life is null");
            return (Criteria) this;
        }

        public Criteria andGoodsShelfLifeIsNotNull() {
            addCriterion("goods_shelf_life is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsShelfLifeEqualTo(Integer value) {
            addCriterion("goods_shelf_life =", value, "goodsShelfLife");
            return (Criteria) this;
        }

        public Criteria andGoodsShelfLifeNotEqualTo(Integer value) {
            addCriterion("goods_shelf_life <>", value, "goodsShelfLife");
            return (Criteria) this;
        }

        public Criteria andGoodsShelfLifeGreaterThan(Integer value) {
            addCriterion("goods_shelf_life >", value, "goodsShelfLife");
            return (Criteria) this;
        }

        public Criteria andGoodsShelfLifeGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_shelf_life >=", value, "goodsShelfLife");
            return (Criteria) this;
        }

        public Criteria andGoodsShelfLifeLessThan(Integer value) {
            addCriterion("goods_shelf_life <", value, "goodsShelfLife");
            return (Criteria) this;
        }

        public Criteria andGoodsShelfLifeLessThanOrEqualTo(Integer value) {
            addCriterion("goods_shelf_life <=", value, "goodsShelfLife");
            return (Criteria) this;
        }

        public Criteria andGoodsShelfLifeIn(List<Integer> values) {
            addCriterion("goods_shelf_life in", values, "goodsShelfLife");
            return (Criteria) this;
        }

        public Criteria andGoodsShelfLifeNotIn(List<Integer> values) {
            addCriterion("goods_shelf_life not in", values, "goodsShelfLife");
            return (Criteria) this;
        }

        public Criteria andGoodsShelfLifeBetween(Integer value1, Integer value2) {
            addCriterion("goods_shelf_life between", value1, value2, "goodsShelfLife");
            return (Criteria) this;
        }

        public Criteria andGoodsShelfLifeNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_shelf_life not between", value1, value2, "goodsShelfLife");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNull() {
            addCriterion("goods_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNotNull() {
            addCriterion("goods_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceEqualTo(Long value) {
            addCriterion("goods_price =", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotEqualTo(Long value) {
            addCriterion("goods_price <>", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThan(Long value) {
            addCriterion("goods_price >", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_price >=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThan(Long value) {
            addCriterion("goods_price <", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThanOrEqualTo(Long value) {
            addCriterion("goods_price <=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIn(List<Long> values) {
            addCriterion("goods_price in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotIn(List<Long> values) {
            addCriterion("goods_price not in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceBetween(Long value1, Long value2) {
            addCriterion("goods_price between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotBetween(Long value1, Long value2) {
            addCriterion("goods_price not between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusIsNull() {
            addCriterion("goods_status is null");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusIsNotNull() {
            addCriterion("goods_status is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusEqualTo(String value) {
            addCriterion("goods_status =", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusNotEqualTo(String value) {
            addCriterion("goods_status <>", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusGreaterThan(String value) {
            addCriterion("goods_status >", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusGreaterThanOrEqualTo(String value) {
            addCriterion("goods_status >=", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusLessThan(String value) {
            addCriterion("goods_status <", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusLessThanOrEqualTo(String value) {
            addCriterion("goods_status <=", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusLike(String value) {
            addCriterion("goods_status like", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusNotLike(String value) {
            addCriterion("goods_status not like", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusIn(List<String> values) {
            addCriterion("goods_status in", values, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusNotIn(List<String> values) {
            addCriterion("goods_status not in", values, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusBetween(String value1, String value2) {
            addCriterion("goods_status between", value1, value2, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusNotBetween(String value1, String value2) {
            addCriterion("goods_status not between", value1, value2, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andStorageTypeIsNull() {
            addCriterion("storage_type is null");
            return (Criteria) this;
        }

        public Criteria andStorageTypeIsNotNull() {
            addCriterion("storage_type is not null");
            return (Criteria) this;
        }

        public Criteria andStorageTypeEqualTo(String value) {
            addCriterion("storage_type =", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeNotEqualTo(String value) {
            addCriterion("storage_type <>", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeGreaterThan(String value) {
            addCriterion("storage_type >", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeGreaterThanOrEqualTo(String value) {
            addCriterion("storage_type >=", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeLessThan(String value) {
            addCriterion("storage_type <", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeLessThanOrEqualTo(String value) {
            addCriterion("storage_type <=", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeLike(String value) {
            addCriterion("storage_type like", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeNotLike(String value) {
            addCriterion("storage_type not like", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeIn(List<String> values) {
            addCriterion("storage_type in", values, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeNotIn(List<String> values) {
            addCriterion("storage_type not in", values, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeBetween(String value1, String value2) {
            addCriterion("storage_type between", value1, value2, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeNotBetween(String value1, String value2) {
            addCriterion("storage_type not between", value1, value2, "storageType");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterionForJDBCDate("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andModifytimeIsNull() {
            addCriterion("modifytime is null");
            return (Criteria) this;
        }

        public Criteria andModifytimeIsNotNull() {
            addCriterion("modifytime is not null");
            return (Criteria) this;
        }

        public Criteria andModifytimeEqualTo(Date value) {
            addCriterionForJDBCDate("modifytime =", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("modifytime <>", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeGreaterThan(Date value) {
            addCriterionForJDBCDate("modifytime >", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("modifytime >=", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLessThan(Date value) {
            addCriterionForJDBCDate("modifytime <", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("modifytime <=", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeIn(List<Date> values) {
            addCriterionForJDBCDate("modifytime in", values, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("modifytime not in", values, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("modifytime between", value1, value2, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("modifytime not between", value1, value2, "modifytime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endtime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endtime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterionForJDBCDate("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterionForJDBCDate("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterionForJDBCDate("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("endtime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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

        public Criteria andStorageWarningIsNull() {
            addCriterion("storage_warning is null");
            return (Criteria) this;
        }

        public Criteria andStorageWarningIsNotNull() {
            addCriterion("storage_warning is not null");
            return (Criteria) this;
        }

        public Criteria andStorageWarningEqualTo(Integer value) {
            addCriterion("storage_warning =", value, "storageWarning");
            return (Criteria) this;
        }

        public Criteria andStorageWarningNotEqualTo(Integer value) {
            addCriterion("storage_warning <>", value, "storageWarning");
            return (Criteria) this;
        }

        public Criteria andStorageWarningGreaterThan(Integer value) {
            addCriterion("storage_warning >", value, "storageWarning");
            return (Criteria) this;
        }

        public Criteria andStorageWarningGreaterThanOrEqualTo(Integer value) {
            addCriterion("storage_warning >=", value, "storageWarning");
            return (Criteria) this;
        }

        public Criteria andStorageWarningLessThan(Integer value) {
            addCriterion("storage_warning <", value, "storageWarning");
            return (Criteria) this;
        }

        public Criteria andStorageWarningLessThanOrEqualTo(Integer value) {
            addCriterion("storage_warning <=", value, "storageWarning");
            return (Criteria) this;
        }

        public Criteria andStorageWarningIn(List<Integer> values) {
            addCriterion("storage_warning in", values, "storageWarning");
            return (Criteria) this;
        }

        public Criteria andStorageWarningNotIn(List<Integer> values) {
            addCriterion("storage_warning not in", values, "storageWarning");
            return (Criteria) this;
        }

        public Criteria andStorageWarningBetween(Integer value1, Integer value2) {
            addCriterion("storage_warning between", value1, value2, "storageWarning");
            return (Criteria) this;
        }

        public Criteria andStorageWarningNotBetween(Integer value1, Integer value2) {
            addCriterion("storage_warning not between", value1, value2, "storageWarning");
            return (Criteria) this;
        }

        public Criteria andShelfLifeWarningIsNull() {
            addCriterion("shelf_life_warning is null");
            return (Criteria) this;
        }

        public Criteria andShelfLifeWarningIsNotNull() {
            addCriterion("shelf_life_warning is not null");
            return (Criteria) this;
        }

        public Criteria andShelfLifeWarningEqualTo(Integer value) {
            addCriterion("shelf_life_warning =", value, "shelfLifeWarning");
            return (Criteria) this;
        }

        public Criteria andShelfLifeWarningNotEqualTo(Integer value) {
            addCriterion("shelf_life_warning <>", value, "shelfLifeWarning");
            return (Criteria) this;
        }

        public Criteria andShelfLifeWarningGreaterThan(Integer value) {
            addCriterion("shelf_life_warning >", value, "shelfLifeWarning");
            return (Criteria) this;
        }

        public Criteria andShelfLifeWarningGreaterThanOrEqualTo(Integer value) {
            addCriterion("shelf_life_warning >=", value, "shelfLifeWarning");
            return (Criteria) this;
        }

        public Criteria andShelfLifeWarningLessThan(Integer value) {
            addCriterion("shelf_life_warning <", value, "shelfLifeWarning");
            return (Criteria) this;
        }

        public Criteria andShelfLifeWarningLessThanOrEqualTo(Integer value) {
            addCriterion("shelf_life_warning <=", value, "shelfLifeWarning");
            return (Criteria) this;
        }

        public Criteria andShelfLifeWarningIn(List<Integer> values) {
            addCriterion("shelf_life_warning in", values, "shelfLifeWarning");
            return (Criteria) this;
        }

        public Criteria andShelfLifeWarningNotIn(List<Integer> values) {
            addCriterion("shelf_life_warning not in", values, "shelfLifeWarning");
            return (Criteria) this;
        }

        public Criteria andShelfLifeWarningBetween(Integer value1, Integer value2) {
            addCriterion("shelf_life_warning between", value1, value2, "shelfLifeWarning");
            return (Criteria) this;
        }

        public Criteria andShelfLifeWarningNotBetween(Integer value1, Integer value2) {
            addCriterion("shelf_life_warning not between", value1, value2, "shelfLifeWarning");
            return (Criteria) this;
        }

        public Criteria andImportGoodsUnitIsNull() {
            addCriterion("import_goods_unit is null");
            return (Criteria) this;
        }

        public Criteria andImportGoodsUnitIsNotNull() {
            addCriterion("import_goods_unit is not null");
            return (Criteria) this;
        }

        public Criteria andImportGoodsUnitEqualTo(String value) {
            addCriterion("import_goods_unit =", value, "importGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andImportGoodsUnitNotEqualTo(String value) {
            addCriterion("import_goods_unit <>", value, "importGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andImportGoodsUnitGreaterThan(String value) {
            addCriterion("import_goods_unit >", value, "importGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andImportGoodsUnitGreaterThanOrEqualTo(String value) {
            addCriterion("import_goods_unit >=", value, "importGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andImportGoodsUnitLessThan(String value) {
            addCriterion("import_goods_unit <", value, "importGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andImportGoodsUnitLessThanOrEqualTo(String value) {
            addCriterion("import_goods_unit <=", value, "importGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andImportGoodsUnitLike(String value) {
            addCriterion("import_goods_unit like", value, "importGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andImportGoodsUnitNotLike(String value) {
            addCriterion("import_goods_unit not like", value, "importGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andImportGoodsUnitIn(List<String> values) {
            addCriterion("import_goods_unit in", values, "importGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andImportGoodsUnitNotIn(List<String> values) {
            addCriterion("import_goods_unit not in", values, "importGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andImportGoodsUnitBetween(String value1, String value2) {
            addCriterion("import_goods_unit between", value1, value2, "importGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andImportGoodsUnitNotBetween(String value1, String value2) {
            addCriterion("import_goods_unit not between", value1, value2, "importGoodsUnit");
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