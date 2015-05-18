package com.ai.psims.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbGoods2customerLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbGoods2customerLogExample() {
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

        public Criteria andGoods2customerIdIsNull() {
            addCriterion("goods2customer_id is null");
            return (Criteria) this;
        }

        public Criteria andGoods2customerIdIsNotNull() {
            addCriterion("goods2customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoods2customerIdEqualTo(Integer value) {
            addCriterion("goods2customer_id =", value, "goods2customerId");
            return (Criteria) this;
        }

        public Criteria andGoods2customerIdNotEqualTo(Integer value) {
            addCriterion("goods2customer_id <>", value, "goods2customerId");
            return (Criteria) this;
        }

        public Criteria andGoods2customerIdGreaterThan(Integer value) {
            addCriterion("goods2customer_id >", value, "goods2customerId");
            return (Criteria) this;
        }

        public Criteria andGoods2customerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods2customer_id >=", value, "goods2customerId");
            return (Criteria) this;
        }

        public Criteria andGoods2customerIdLessThan(Integer value) {
            addCriterion("goods2customer_id <", value, "goods2customerId");
            return (Criteria) this;
        }

        public Criteria andGoods2customerIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods2customer_id <=", value, "goods2customerId");
            return (Criteria) this;
        }

        public Criteria andGoods2customerIdIn(List<Integer> values) {
            addCriterion("goods2customer_id in", values, "goods2customerId");
            return (Criteria) this;
        }

        public Criteria andGoods2customerIdNotIn(List<Integer> values) {
            addCriterion("goods2customer_id not in", values, "goods2customerId");
            return (Criteria) this;
        }

        public Criteria andGoods2customerIdBetween(Integer value1, Integer value2) {
            addCriterion("goods2customer_id between", value1, value2, "goods2customerId");
            return (Criteria) this;
        }

        public Criteria andGoods2customerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods2customer_id not between", value1, value2, "goods2customerId");
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

        public Criteria andGoodsCodeIsNull() {
            addCriterion("goods_code is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeIsNotNull() {
            addCriterion("goods_code is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeEqualTo(String value) {
            addCriterion("goods_code =", value, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeNotEqualTo(String value) {
            addCriterion("goods_code <>", value, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeGreaterThan(String value) {
            addCriterion("goods_code >", value, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeGreaterThanOrEqualTo(String value) {
            addCriterion("goods_code >=", value, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeLessThan(String value) {
            addCriterion("goods_code <", value, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeLessThanOrEqualTo(String value) {
            addCriterion("goods_code <=", value, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeLike(String value) {
            addCriterion("goods_code like", value, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeNotLike(String value) {
            addCriterion("goods_code not like", value, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeIn(List<String> values) {
            addCriterion("goods_code in", values, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeNotIn(List<String> values) {
            addCriterion("goods_code not in", values, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeBetween(String value1, String value2) {
            addCriterion("goods_code between", value1, value2, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeNotBetween(String value1, String value2) {
            addCriterion("goods_code not between", value1, value2, "goodsCode");
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

        public Criteria andCustomerCodeIsNull() {
            addCriterion("customer_code is null");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeIsNotNull() {
            addCriterion("customer_code is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeEqualTo(String value) {
            addCriterion("customer_code =", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeNotEqualTo(String value) {
            addCriterion("customer_code <>", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeGreaterThan(String value) {
            addCriterion("customer_code >", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeGreaterThanOrEqualTo(String value) {
            addCriterion("customer_code >=", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeLessThan(String value) {
            addCriterion("customer_code <", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeLessThanOrEqualTo(String value) {
            addCriterion("customer_code <=", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeLike(String value) {
            addCriterion("customer_code like", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeNotLike(String value) {
            addCriterion("customer_code not like", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeIn(List<String> values) {
            addCriterion("customer_code in", values, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeNotIn(List<String> values) {
            addCriterion("customer_code not in", values, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeBetween(String value1, String value2) {
            addCriterion("customer_code between", value1, value2, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeNotBetween(String value1, String value2) {
            addCriterion("customer_code not between", value1, value2, "customerCode");
            return (Criteria) this;
        }

        public Criteria andGoodsVersionIsNull() {
            addCriterion("goods_version is null");
            return (Criteria) this;
        }

        public Criteria andGoodsVersionIsNotNull() {
            addCriterion("goods_version is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsVersionEqualTo(Integer value) {
            addCriterion("goods_version =", value, "goodsVersion");
            return (Criteria) this;
        }

        public Criteria andGoodsVersionNotEqualTo(Integer value) {
            addCriterion("goods_version <>", value, "goodsVersion");
            return (Criteria) this;
        }

        public Criteria andGoodsVersionGreaterThan(Integer value) {
            addCriterion("goods_version >", value, "goodsVersion");
            return (Criteria) this;
        }

        public Criteria andGoodsVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_version >=", value, "goodsVersion");
            return (Criteria) this;
        }

        public Criteria andGoodsVersionLessThan(Integer value) {
            addCriterion("goods_version <", value, "goodsVersion");
            return (Criteria) this;
        }

        public Criteria andGoodsVersionLessThanOrEqualTo(Integer value) {
            addCriterion("goods_version <=", value, "goodsVersion");
            return (Criteria) this;
        }

        public Criteria andGoodsVersionIn(List<Integer> values) {
            addCriterion("goods_version in", values, "goodsVersion");
            return (Criteria) this;
        }

        public Criteria andGoodsVersionNotIn(List<Integer> values) {
            addCriterion("goods_version not in", values, "goodsVersion");
            return (Criteria) this;
        }

        public Criteria andGoodsVersionBetween(Integer value1, Integer value2) {
            addCriterion("goods_version between", value1, value2, "goodsVersion");
            return (Criteria) this;
        }

        public Criteria andGoodsVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_version not between", value1, value2, "goodsVersion");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitIsNull() {
            addCriterion("goods_unit is null");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitIsNotNull() {
            addCriterion("goods_unit is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitEqualTo(String value) {
            addCriterion("goods_unit =", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitNotEqualTo(String value) {
            addCriterion("goods_unit <>", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitGreaterThan(String value) {
            addCriterion("goods_unit >", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitGreaterThanOrEqualTo(String value) {
            addCriterion("goods_unit >=", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitLessThan(String value) {
            addCriterion("goods_unit <", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitLessThanOrEqualTo(String value) {
            addCriterion("goods_unit <=", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitLike(String value) {
            addCriterion("goods_unit like", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitNotLike(String value) {
            addCriterion("goods_unit not like", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitIn(List<String> values) {
            addCriterion("goods_unit in", values, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitNotIn(List<String> values) {
            addCriterion("goods_unit not in", values, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitBetween(String value1, String value2) {
            addCriterion("goods_unit between", value1, value2, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitNotBetween(String value1, String value2) {
            addCriterion("goods_unit not between", value1, value2, "goodsUnit");
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

        public Criteria andGoodsCurrentStockIsNull() {
            addCriterion("goods_current_stock is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCurrentStockIsNotNull() {
            addCriterion("goods_current_stock is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCurrentStockEqualTo(Integer value) {
            addCriterion("goods_current_stock =", value, "goodsCurrentStock");
            return (Criteria) this;
        }

        public Criteria andGoodsCurrentStockNotEqualTo(Integer value) {
            addCriterion("goods_current_stock <>", value, "goodsCurrentStock");
            return (Criteria) this;
        }

        public Criteria andGoodsCurrentStockGreaterThan(Integer value) {
            addCriterion("goods_current_stock >", value, "goodsCurrentStock");
            return (Criteria) this;
        }

        public Criteria andGoodsCurrentStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_current_stock >=", value, "goodsCurrentStock");
            return (Criteria) this;
        }

        public Criteria andGoodsCurrentStockLessThan(Integer value) {
            addCriterion("goods_current_stock <", value, "goodsCurrentStock");
            return (Criteria) this;
        }

        public Criteria andGoodsCurrentStockLessThanOrEqualTo(Integer value) {
            addCriterion("goods_current_stock <=", value, "goodsCurrentStock");
            return (Criteria) this;
        }

        public Criteria andGoodsCurrentStockIn(List<Integer> values) {
            addCriterion("goods_current_stock in", values, "goodsCurrentStock");
            return (Criteria) this;
        }

        public Criteria andGoodsCurrentStockNotIn(List<Integer> values) {
            addCriterion("goods_current_stock not in", values, "goodsCurrentStock");
            return (Criteria) this;
        }

        public Criteria andGoodsCurrentStockBetween(Integer value1, Integer value2) {
            addCriterion("goods_current_stock between", value1, value2, "goodsCurrentStock");
            return (Criteria) this;
        }

        public Criteria andGoodsCurrentStockNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_current_stock not between", value1, value2, "goodsCurrentStock");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalStockIsNull() {
            addCriterion("goods_total_stock is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalStockIsNotNull() {
            addCriterion("goods_total_stock is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalStockEqualTo(Integer value) {
            addCriterion("goods_total_stock =", value, "goodsTotalStock");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalStockNotEqualTo(Integer value) {
            addCriterion("goods_total_stock <>", value, "goodsTotalStock");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalStockGreaterThan(Integer value) {
            addCriterion("goods_total_stock >", value, "goodsTotalStock");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_total_stock >=", value, "goodsTotalStock");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalStockLessThan(Integer value) {
            addCriterion("goods_total_stock <", value, "goodsTotalStock");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalStockLessThanOrEqualTo(Integer value) {
            addCriterion("goods_total_stock <=", value, "goodsTotalStock");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalStockIn(List<Integer> values) {
            addCriterion("goods_total_stock in", values, "goodsTotalStock");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalStockNotIn(List<Integer> values) {
            addCriterion("goods_total_stock not in", values, "goodsTotalStock");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalStockBetween(Integer value1, Integer value2) {
            addCriterion("goods_total_stock between", value1, value2, "goodsTotalStock");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalStockNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_total_stock not between", value1, value2, "goodsTotalStock");
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
            addCriterion("goods_production_date =", value, "goodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionDateNotEqualTo(Date value) {
            addCriterion("goods_production_date <>", value, "goodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionDateGreaterThan(Date value) {
            addCriterion("goods_production_date >", value, "goodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionDateGreaterThanOrEqualTo(Date value) {
            addCriterion("goods_production_date >=", value, "goodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionDateLessThan(Date value) {
            addCriterion("goods_production_date <", value, "goodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionDateLessThanOrEqualTo(Date value) {
            addCriterion("goods_production_date <=", value, "goodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionDateIn(List<Date> values) {
            addCriterion("goods_production_date in", values, "goodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionDateNotIn(List<Date> values) {
            addCriterion("goods_production_date not in", values, "goodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionDateBetween(Date value1, Date value2) {
            addCriterion("goods_production_date between", value1, value2, "goodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andGoodsProductionDateNotBetween(Date value1, Date value2) {
            addCriterion("goods_production_date not between", value1, value2, "goodsProductionDate");
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
            addCriterion("goods_expiration_date =", value, "goodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andGoodsExpirationDateNotEqualTo(Date value) {
            addCriterion("goods_expiration_date <>", value, "goodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andGoodsExpirationDateGreaterThan(Date value) {
            addCriterion("goods_expiration_date >", value, "goodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andGoodsExpirationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("goods_expiration_date >=", value, "goodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andGoodsExpirationDateLessThan(Date value) {
            addCriterion("goods_expiration_date <", value, "goodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andGoodsExpirationDateLessThanOrEqualTo(Date value) {
            addCriterion("goods_expiration_date <=", value, "goodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andGoodsExpirationDateIn(List<Date> values) {
            addCriterion("goods_expiration_date in", values, "goodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andGoodsExpirationDateNotIn(List<Date> values) {
            addCriterion("goods_expiration_date not in", values, "goodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andGoodsExpirationDateBetween(Date value1, Date value2) {
            addCriterion("goods_expiration_date between", value1, value2, "goodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andGoodsExpirationDateNotBetween(Date value1, Date value2) {
            addCriterion("goods_expiration_date not between", value1, value2, "goodsExpirationDate");
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

        public Criteria andGoodsActualCostIsNull() {
            addCriterion("goods_actual_cost is null");
            return (Criteria) this;
        }

        public Criteria andGoodsActualCostIsNotNull() {
            addCriterion("goods_actual_cost is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsActualCostEqualTo(String value) {
            addCriterion("goods_actual_cost =", value, "goodsActualCost");
            return (Criteria) this;
        }

        public Criteria andGoodsActualCostNotEqualTo(String value) {
            addCriterion("goods_actual_cost <>", value, "goodsActualCost");
            return (Criteria) this;
        }

        public Criteria andGoodsActualCostGreaterThan(String value) {
            addCriterion("goods_actual_cost >", value, "goodsActualCost");
            return (Criteria) this;
        }

        public Criteria andGoodsActualCostGreaterThanOrEqualTo(String value) {
            addCriterion("goods_actual_cost >=", value, "goodsActualCost");
            return (Criteria) this;
        }

        public Criteria andGoodsActualCostLessThan(String value) {
            addCriterion("goods_actual_cost <", value, "goodsActualCost");
            return (Criteria) this;
        }

        public Criteria andGoodsActualCostLessThanOrEqualTo(String value) {
            addCriterion("goods_actual_cost <=", value, "goodsActualCost");
            return (Criteria) this;
        }

        public Criteria andGoodsActualCostLike(String value) {
            addCriterion("goods_actual_cost like", value, "goodsActualCost");
            return (Criteria) this;
        }

        public Criteria andGoodsActualCostNotLike(String value) {
            addCriterion("goods_actual_cost not like", value, "goodsActualCost");
            return (Criteria) this;
        }

        public Criteria andGoodsActualCostIn(List<String> values) {
            addCriterion("goods_actual_cost in", values, "goodsActualCost");
            return (Criteria) this;
        }

        public Criteria andGoodsActualCostNotIn(List<String> values) {
            addCriterion("goods_actual_cost not in", values, "goodsActualCost");
            return (Criteria) this;
        }

        public Criteria andGoodsActualCostBetween(String value1, String value2) {
            addCriterion("goods_actual_cost between", value1, value2, "goodsActualCost");
            return (Criteria) this;
        }

        public Criteria andGoodsActualCostNotBetween(String value1, String value2) {
            addCriterion("goods_actual_cost not between", value1, value2, "goodsActualCost");
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

        public Criteria andGoodsPriceEqualTo(String value) {
            addCriterion("goods_price =", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotEqualTo(String value) {
            addCriterion("goods_price <>", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThan(String value) {
            addCriterion("goods_price >", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThanOrEqualTo(String value) {
            addCriterion("goods_price >=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThan(String value) {
            addCriterion("goods_price <", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThanOrEqualTo(String value) {
            addCriterion("goods_price <=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLike(String value) {
            addCriterion("goods_price like", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotLike(String value) {
            addCriterion("goods_price not like", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIn(List<String> values) {
            addCriterion("goods_price in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotIn(List<String> values) {
            addCriterion("goods_price not in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceBetween(String value1, String value2) {
            addCriterion("goods_price between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotBetween(String value1, String value2) {
            addCriterion("goods_price not between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsProfitIsNull() {
            addCriterion("goods_profit is null");
            return (Criteria) this;
        }

        public Criteria andGoodsProfitIsNotNull() {
            addCriterion("goods_profit is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsProfitEqualTo(String value) {
            addCriterion("goods_profit =", value, "goodsProfit");
            return (Criteria) this;
        }

        public Criteria andGoodsProfitNotEqualTo(String value) {
            addCriterion("goods_profit <>", value, "goodsProfit");
            return (Criteria) this;
        }

        public Criteria andGoodsProfitGreaterThan(String value) {
            addCriterion("goods_profit >", value, "goodsProfit");
            return (Criteria) this;
        }

        public Criteria andGoodsProfitGreaterThanOrEqualTo(String value) {
            addCriterion("goods_profit >=", value, "goodsProfit");
            return (Criteria) this;
        }

        public Criteria andGoodsProfitLessThan(String value) {
            addCriterion("goods_profit <", value, "goodsProfit");
            return (Criteria) this;
        }

        public Criteria andGoodsProfitLessThanOrEqualTo(String value) {
            addCriterion("goods_profit <=", value, "goodsProfit");
            return (Criteria) this;
        }

        public Criteria andGoodsProfitLike(String value) {
            addCriterion("goods_profit like", value, "goodsProfit");
            return (Criteria) this;
        }

        public Criteria andGoodsProfitNotLike(String value) {
            addCriterion("goods_profit not like", value, "goodsProfit");
            return (Criteria) this;
        }

        public Criteria andGoodsProfitIn(List<String> values) {
            addCriterion("goods_profit in", values, "goodsProfit");
            return (Criteria) this;
        }

        public Criteria andGoodsProfitNotIn(List<String> values) {
            addCriterion("goods_profit not in", values, "goodsProfit");
            return (Criteria) this;
        }

        public Criteria andGoodsProfitBetween(String value1, String value2) {
            addCriterion("goods_profit between", value1, value2, "goodsProfit");
            return (Criteria) this;
        }

        public Criteria andGoodsProfitNotBetween(String value1, String value2) {
            addCriterion("goods_profit not between", value1, value2, "goodsProfit");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountAmountIsNull() {
            addCriterion("goods_discount_amount is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountAmountIsNotNull() {
            addCriterion("goods_discount_amount is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountAmountEqualTo(String value) {
            addCriterion("goods_discount_amount =", value, "goodsDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountAmountNotEqualTo(String value) {
            addCriterion("goods_discount_amount <>", value, "goodsDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountAmountGreaterThan(String value) {
            addCriterion("goods_discount_amount >", value, "goodsDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountAmountGreaterThanOrEqualTo(String value) {
            addCriterion("goods_discount_amount >=", value, "goodsDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountAmountLessThan(String value) {
            addCriterion("goods_discount_amount <", value, "goodsDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountAmountLessThanOrEqualTo(String value) {
            addCriterion("goods_discount_amount <=", value, "goodsDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountAmountLike(String value) {
            addCriterion("goods_discount_amount like", value, "goodsDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountAmountNotLike(String value) {
            addCriterion("goods_discount_amount not like", value, "goodsDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountAmountIn(List<String> values) {
            addCriterion("goods_discount_amount in", values, "goodsDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountAmountNotIn(List<String> values) {
            addCriterion("goods_discount_amount not in", values, "goodsDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountAmountBetween(String value1, String value2) {
            addCriterion("goods_discount_amount between", value1, value2, "goodsDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountAmountNotBetween(String value1, String value2) {
            addCriterion("goods_discount_amount not between", value1, value2, "goodsDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNull() {
            addCriterion("goods_type is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNotNull() {
            addCriterion("goods_type is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeEqualTo(String value) {
            addCriterion("goods_type =", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotEqualTo(String value) {
            addCriterion("goods_type <>", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThan(String value) {
            addCriterion("goods_type >", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("goods_type >=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThan(String value) {
            addCriterion("goods_type <", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThanOrEqualTo(String value) {
            addCriterion("goods_type <=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLike(String value) {
            addCriterion("goods_type like", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotLike(String value) {
            addCriterion("goods_type not like", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIn(List<String> values) {
            addCriterion("goods_type in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotIn(List<String> values) {
            addCriterion("goods_type not in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeBetween(String value1, String value2) {
            addCriterion("goods_type between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotBetween(String value1, String value2) {
            addCriterion("goods_type not between", value1, value2, "goodsType");
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

        public Criteria andGoodsCreatetimeIsNull() {
            addCriterion("goods_createtime is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatetimeIsNotNull() {
            addCriterion("goods_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatetimeEqualTo(Date value) {
            addCriterion("goods_createtime =", value, "goodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatetimeNotEqualTo(Date value) {
            addCriterion("goods_createtime <>", value, "goodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatetimeGreaterThan(Date value) {
            addCriterion("goods_createtime >", value, "goodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("goods_createtime >=", value, "goodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatetimeLessThan(Date value) {
            addCriterion("goods_createtime <", value, "goodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("goods_createtime <=", value, "goodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatetimeIn(List<Date> values) {
            addCriterion("goods_createtime in", values, "goodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatetimeNotIn(List<Date> values) {
            addCriterion("goods_createtime not in", values, "goodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatetimeBetween(Date value1, Date value2) {
            addCriterion("goods_createtime between", value1, value2, "goodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("goods_createtime not between", value1, value2, "goodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andGoodsModifytimeIsNull() {
            addCriterion("goods_modifytime is null");
            return (Criteria) this;
        }

        public Criteria andGoodsModifytimeIsNotNull() {
            addCriterion("goods_modifytime is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsModifytimeEqualTo(Date value) {
            addCriterion("goods_modifytime =", value, "goodsModifytime");
            return (Criteria) this;
        }

        public Criteria andGoodsModifytimeNotEqualTo(Date value) {
            addCriterion("goods_modifytime <>", value, "goodsModifytime");
            return (Criteria) this;
        }

        public Criteria andGoodsModifytimeGreaterThan(Date value) {
            addCriterion("goods_modifytime >", value, "goodsModifytime");
            return (Criteria) this;
        }

        public Criteria andGoodsModifytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("goods_modifytime >=", value, "goodsModifytime");
            return (Criteria) this;
        }

        public Criteria andGoodsModifytimeLessThan(Date value) {
            addCriterion("goods_modifytime <", value, "goodsModifytime");
            return (Criteria) this;
        }

        public Criteria andGoodsModifytimeLessThanOrEqualTo(Date value) {
            addCriterion("goods_modifytime <=", value, "goodsModifytime");
            return (Criteria) this;
        }

        public Criteria andGoodsModifytimeIn(List<Date> values) {
            addCriterion("goods_modifytime in", values, "goodsModifytime");
            return (Criteria) this;
        }

        public Criteria andGoodsModifytimeNotIn(List<Date> values) {
            addCriterion("goods_modifytime not in", values, "goodsModifytime");
            return (Criteria) this;
        }

        public Criteria andGoodsModifytimeBetween(Date value1, Date value2) {
            addCriterion("goods_modifytime between", value1, value2, "goodsModifytime");
            return (Criteria) this;
        }

        public Criteria andGoodsModifytimeNotBetween(Date value1, Date value2) {
            addCriterion("goods_modifytime not between", value1, value2, "goodsModifytime");
            return (Criteria) this;
        }

        public Criteria andGoodsEndtimeIsNull() {
            addCriterion("goods_endtime is null");
            return (Criteria) this;
        }

        public Criteria andGoodsEndtimeIsNotNull() {
            addCriterion("goods_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsEndtimeEqualTo(Date value) {
            addCriterion("goods_endtime =", value, "goodsEndtime");
            return (Criteria) this;
        }

        public Criteria andGoodsEndtimeNotEqualTo(Date value) {
            addCriterion("goods_endtime <>", value, "goodsEndtime");
            return (Criteria) this;
        }

        public Criteria andGoodsEndtimeGreaterThan(Date value) {
            addCriterion("goods_endtime >", value, "goodsEndtime");
            return (Criteria) this;
        }

        public Criteria andGoodsEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("goods_endtime >=", value, "goodsEndtime");
            return (Criteria) this;
        }

        public Criteria andGoodsEndtimeLessThan(Date value) {
            addCriterion("goods_endtime <", value, "goodsEndtime");
            return (Criteria) this;
        }

        public Criteria andGoodsEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("goods_endtime <=", value, "goodsEndtime");
            return (Criteria) this;
        }

        public Criteria andGoodsEndtimeIn(List<Date> values) {
            addCriterion("goods_endtime in", values, "goodsEndtime");
            return (Criteria) this;
        }

        public Criteria andGoodsEndtimeNotIn(List<Date> values) {
            addCriterion("goods_endtime not in", values, "goodsEndtime");
            return (Criteria) this;
        }

        public Criteria andGoodsEndtimeBetween(Date value1, Date value2) {
            addCriterion("goods_endtime between", value1, value2, "goodsEndtime");
            return (Criteria) this;
        }

        public Criteria andGoodsEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("goods_endtime not between", value1, value2, "goodsEndtime");
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

        public Criteria andProviderCodeIsNull() {
            addCriterion("provider_code is null");
            return (Criteria) this;
        }

        public Criteria andProviderCodeIsNotNull() {
            addCriterion("provider_code is not null");
            return (Criteria) this;
        }

        public Criteria andProviderCodeEqualTo(String value) {
            addCriterion("provider_code =", value, "providerCode");
            return (Criteria) this;
        }

        public Criteria andProviderCodeNotEqualTo(String value) {
            addCriterion("provider_code <>", value, "providerCode");
            return (Criteria) this;
        }

        public Criteria andProviderCodeGreaterThan(String value) {
            addCriterion("provider_code >", value, "providerCode");
            return (Criteria) this;
        }

        public Criteria andProviderCodeGreaterThanOrEqualTo(String value) {
            addCriterion("provider_code >=", value, "providerCode");
            return (Criteria) this;
        }

        public Criteria andProviderCodeLessThan(String value) {
            addCriterion("provider_code <", value, "providerCode");
            return (Criteria) this;
        }

        public Criteria andProviderCodeLessThanOrEqualTo(String value) {
            addCriterion("provider_code <=", value, "providerCode");
            return (Criteria) this;
        }

        public Criteria andProviderCodeLike(String value) {
            addCriterion("provider_code like", value, "providerCode");
            return (Criteria) this;
        }

        public Criteria andProviderCodeNotLike(String value) {
            addCriterion("provider_code not like", value, "providerCode");
            return (Criteria) this;
        }

        public Criteria andProviderCodeIn(List<String> values) {
            addCriterion("provider_code in", values, "providerCode");
            return (Criteria) this;
        }

        public Criteria andProviderCodeNotIn(List<String> values) {
            addCriterion("provider_code not in", values, "providerCode");
            return (Criteria) this;
        }

        public Criteria andProviderCodeBetween(String value1, String value2) {
            addCriterion("provider_code between", value1, value2, "providerCode");
            return (Criteria) this;
        }

        public Criteria andProviderCodeNotBetween(String value1, String value2) {
            addCriterion("provider_code not between", value1, value2, "providerCode");
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

        public Criteria andGoodsDiscountIsNull() {
            addCriterion("goods_discount is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountIsNotNull() {
            addCriterion("goods_discount is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountEqualTo(String value) {
            addCriterion("goods_discount =", value, "goodsDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountNotEqualTo(String value) {
            addCriterion("goods_discount <>", value, "goodsDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountGreaterThan(String value) {
            addCriterion("goods_discount >", value, "goodsDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountGreaterThanOrEqualTo(String value) {
            addCriterion("goods_discount >=", value, "goodsDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountLessThan(String value) {
            addCriterion("goods_discount <", value, "goodsDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountLessThanOrEqualTo(String value) {
            addCriterion("goods_discount <=", value, "goodsDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountLike(String value) {
            addCriterion("goods_discount like", value, "goodsDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountNotLike(String value) {
            addCriterion("goods_discount not like", value, "goodsDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountIn(List<String> values) {
            addCriterion("goods_discount in", values, "goodsDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountNotIn(List<String> values) {
            addCriterion("goods_discount not in", values, "goodsDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountBetween(String value1, String value2) {
            addCriterion("goods_discount between", value1, value2, "goodsDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountNotBetween(String value1, String value2) {
            addCriterion("goods_discount not between", value1, value2, "goodsDiscount");
            return (Criteria) this;
        }

        public Criteria andSingleRebateIsNull() {
            addCriterion("single_rebate is null");
            return (Criteria) this;
        }

        public Criteria andSingleRebateIsNotNull() {
            addCriterion("single_rebate is not null");
            return (Criteria) this;
        }

        public Criteria andSingleRebateEqualTo(String value) {
            addCriterion("single_rebate =", value, "singleRebate");
            return (Criteria) this;
        }

        public Criteria andSingleRebateNotEqualTo(String value) {
            addCriterion("single_rebate <>", value, "singleRebate");
            return (Criteria) this;
        }

        public Criteria andSingleRebateGreaterThan(String value) {
            addCriterion("single_rebate >", value, "singleRebate");
            return (Criteria) this;
        }

        public Criteria andSingleRebateGreaterThanOrEqualTo(String value) {
            addCriterion("single_rebate >=", value, "singleRebate");
            return (Criteria) this;
        }

        public Criteria andSingleRebateLessThan(String value) {
            addCriterion("single_rebate <", value, "singleRebate");
            return (Criteria) this;
        }

        public Criteria andSingleRebateLessThanOrEqualTo(String value) {
            addCriterion("single_rebate <=", value, "singleRebate");
            return (Criteria) this;
        }

        public Criteria andSingleRebateLike(String value) {
            addCriterion("single_rebate like", value, "singleRebate");
            return (Criteria) this;
        }

        public Criteria andSingleRebateNotLike(String value) {
            addCriterion("single_rebate not like", value, "singleRebate");
            return (Criteria) this;
        }

        public Criteria andSingleRebateIn(List<String> values) {
            addCriterion("single_rebate in", values, "singleRebate");
            return (Criteria) this;
        }

        public Criteria andSingleRebateNotIn(List<String> values) {
            addCriterion("single_rebate not in", values, "singleRebate");
            return (Criteria) this;
        }

        public Criteria andSingleRebateBetween(String value1, String value2) {
            addCriterion("single_rebate between", value1, value2, "singleRebate");
            return (Criteria) this;
        }

        public Criteria andSingleRebateNotBetween(String value1, String value2) {
            addCriterion("single_rebate not between", value1, value2, "singleRebate");
            return (Criteria) this;
        }

        public Criteria andQuarterRebateIsNull() {
            addCriterion("quarter_rebate is null");
            return (Criteria) this;
        }

        public Criteria andQuarterRebateIsNotNull() {
            addCriterion("quarter_rebate is not null");
            return (Criteria) this;
        }

        public Criteria andQuarterRebateEqualTo(String value) {
            addCriterion("quarter_rebate =", value, "quarterRebate");
            return (Criteria) this;
        }

        public Criteria andQuarterRebateNotEqualTo(String value) {
            addCriterion("quarter_rebate <>", value, "quarterRebate");
            return (Criteria) this;
        }

        public Criteria andQuarterRebateGreaterThan(String value) {
            addCriterion("quarter_rebate >", value, "quarterRebate");
            return (Criteria) this;
        }

        public Criteria andQuarterRebateGreaterThanOrEqualTo(String value) {
            addCriterion("quarter_rebate >=", value, "quarterRebate");
            return (Criteria) this;
        }

        public Criteria andQuarterRebateLessThan(String value) {
            addCriterion("quarter_rebate <", value, "quarterRebate");
            return (Criteria) this;
        }

        public Criteria andQuarterRebateLessThanOrEqualTo(String value) {
            addCriterion("quarter_rebate <=", value, "quarterRebate");
            return (Criteria) this;
        }

        public Criteria andQuarterRebateLike(String value) {
            addCriterion("quarter_rebate like", value, "quarterRebate");
            return (Criteria) this;
        }

        public Criteria andQuarterRebateNotLike(String value) {
            addCriterion("quarter_rebate not like", value, "quarterRebate");
            return (Criteria) this;
        }

        public Criteria andQuarterRebateIn(List<String> values) {
            addCriterion("quarter_rebate in", values, "quarterRebate");
            return (Criteria) this;
        }

        public Criteria andQuarterRebateNotIn(List<String> values) {
            addCriterion("quarter_rebate not in", values, "quarterRebate");
            return (Criteria) this;
        }

        public Criteria andQuarterRebateBetween(String value1, String value2) {
            addCriterion("quarter_rebate between", value1, value2, "quarterRebate");
            return (Criteria) this;
        }

        public Criteria andQuarterRebateNotBetween(String value1, String value2) {
            addCriterion("quarter_rebate not between", value1, value2, "quarterRebate");
            return (Criteria) this;
        }

        public Criteria andAnnualRebateIsNull() {
            addCriterion("annual_rebate is null");
            return (Criteria) this;
        }

        public Criteria andAnnualRebateIsNotNull() {
            addCriterion("annual_rebate is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualRebateEqualTo(String value) {
            addCriterion("annual_rebate =", value, "annualRebate");
            return (Criteria) this;
        }

        public Criteria andAnnualRebateNotEqualTo(String value) {
            addCriterion("annual_rebate <>", value, "annualRebate");
            return (Criteria) this;
        }

        public Criteria andAnnualRebateGreaterThan(String value) {
            addCriterion("annual_rebate >", value, "annualRebate");
            return (Criteria) this;
        }

        public Criteria andAnnualRebateGreaterThanOrEqualTo(String value) {
            addCriterion("annual_rebate >=", value, "annualRebate");
            return (Criteria) this;
        }

        public Criteria andAnnualRebateLessThan(String value) {
            addCriterion("annual_rebate <", value, "annualRebate");
            return (Criteria) this;
        }

        public Criteria andAnnualRebateLessThanOrEqualTo(String value) {
            addCriterion("annual_rebate <=", value, "annualRebate");
            return (Criteria) this;
        }

        public Criteria andAnnualRebateLike(String value) {
            addCriterion("annual_rebate like", value, "annualRebate");
            return (Criteria) this;
        }

        public Criteria andAnnualRebateNotLike(String value) {
            addCriterion("annual_rebate not like", value, "annualRebate");
            return (Criteria) this;
        }

        public Criteria andAnnualRebateIn(List<String> values) {
            addCriterion("annual_rebate in", values, "annualRebate");
            return (Criteria) this;
        }

        public Criteria andAnnualRebateNotIn(List<String> values) {
            addCriterion("annual_rebate not in", values, "annualRebate");
            return (Criteria) this;
        }

        public Criteria andAnnualRebateBetween(String value1, String value2) {
            addCriterion("annual_rebate between", value1, value2, "annualRebate");
            return (Criteria) this;
        }

        public Criteria andAnnualRebateNotBetween(String value1, String value2) {
            addCriterion("annual_rebate not between", value1, value2, "annualRebate");
            return (Criteria) this;
        }

        public Criteria andPurchaseRebateIsNull() {
            addCriterion("purchase_rebate is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseRebateIsNotNull() {
            addCriterion("purchase_rebate is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseRebateEqualTo(String value) {
            addCriterion("purchase_rebate =", value, "purchaseRebate");
            return (Criteria) this;
        }

        public Criteria andPurchaseRebateNotEqualTo(String value) {
            addCriterion("purchase_rebate <>", value, "purchaseRebate");
            return (Criteria) this;
        }

        public Criteria andPurchaseRebateGreaterThan(String value) {
            addCriterion("purchase_rebate >", value, "purchaseRebate");
            return (Criteria) this;
        }

        public Criteria andPurchaseRebateGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_rebate >=", value, "purchaseRebate");
            return (Criteria) this;
        }

        public Criteria andPurchaseRebateLessThan(String value) {
            addCriterion("purchase_rebate <", value, "purchaseRebate");
            return (Criteria) this;
        }

        public Criteria andPurchaseRebateLessThanOrEqualTo(String value) {
            addCriterion("purchase_rebate <=", value, "purchaseRebate");
            return (Criteria) this;
        }

        public Criteria andPurchaseRebateLike(String value) {
            addCriterion("purchase_rebate like", value, "purchaseRebate");
            return (Criteria) this;
        }

        public Criteria andPurchaseRebateNotLike(String value) {
            addCriterion("purchase_rebate not like", value, "purchaseRebate");
            return (Criteria) this;
        }

        public Criteria andPurchaseRebateIn(List<String> values) {
            addCriterion("purchase_rebate in", values, "purchaseRebate");
            return (Criteria) this;
        }

        public Criteria andPurchaseRebateNotIn(List<String> values) {
            addCriterion("purchase_rebate not in", values, "purchaseRebate");
            return (Criteria) this;
        }

        public Criteria andPurchaseRebateBetween(String value1, String value2) {
            addCriterion("purchase_rebate between", value1, value2, "purchaseRebate");
            return (Criteria) this;
        }

        public Criteria andPurchaseRebateNotBetween(String value1, String value2) {
            addCriterion("purchase_rebate not between", value1, value2, "purchaseRebate");
            return (Criteria) this;
        }

        public Criteria andPromotionRebateIsNull() {
            addCriterion("promotion_rebate is null");
            return (Criteria) this;
        }

        public Criteria andPromotionRebateIsNotNull() {
            addCriterion("promotion_rebate is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionRebateEqualTo(String value) {
            addCriterion("promotion_rebate =", value, "promotionRebate");
            return (Criteria) this;
        }

        public Criteria andPromotionRebateNotEqualTo(String value) {
            addCriterion("promotion_rebate <>", value, "promotionRebate");
            return (Criteria) this;
        }

        public Criteria andPromotionRebateGreaterThan(String value) {
            addCriterion("promotion_rebate >", value, "promotionRebate");
            return (Criteria) this;
        }

        public Criteria andPromotionRebateGreaterThanOrEqualTo(String value) {
            addCriterion("promotion_rebate >=", value, "promotionRebate");
            return (Criteria) this;
        }

        public Criteria andPromotionRebateLessThan(String value) {
            addCriterion("promotion_rebate <", value, "promotionRebate");
            return (Criteria) this;
        }

        public Criteria andPromotionRebateLessThanOrEqualTo(String value) {
            addCriterion("promotion_rebate <=", value, "promotionRebate");
            return (Criteria) this;
        }

        public Criteria andPromotionRebateLike(String value) {
            addCriterion("promotion_rebate like", value, "promotionRebate");
            return (Criteria) this;
        }

        public Criteria andPromotionRebateNotLike(String value) {
            addCriterion("promotion_rebate not like", value, "promotionRebate");
            return (Criteria) this;
        }

        public Criteria andPromotionRebateIn(List<String> values) {
            addCriterion("promotion_rebate in", values, "promotionRebate");
            return (Criteria) this;
        }

        public Criteria andPromotionRebateNotIn(List<String> values) {
            addCriterion("promotion_rebate not in", values, "promotionRebate");
            return (Criteria) this;
        }

        public Criteria andPromotionRebateBetween(String value1, String value2) {
            addCriterion("promotion_rebate between", value1, value2, "promotionRebate");
            return (Criteria) this;
        }

        public Criteria andPromotionRebateNotBetween(String value1, String value2) {
            addCriterion("promotion_rebate not between", value1, value2, "promotionRebate");
            return (Criteria) this;
        }

        public Criteria andProviderSubsidyIsNull() {
            addCriterion("provider_subsidy is null");
            return (Criteria) this;
        }

        public Criteria andProviderSubsidyIsNotNull() {
            addCriterion("provider_subsidy is not null");
            return (Criteria) this;
        }

        public Criteria andProviderSubsidyEqualTo(String value) {
            addCriterion("provider_subsidy =", value, "providerSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderSubsidyNotEqualTo(String value) {
            addCriterion("provider_subsidy <>", value, "providerSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderSubsidyGreaterThan(String value) {
            addCriterion("provider_subsidy >", value, "providerSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderSubsidyGreaterThanOrEqualTo(String value) {
            addCriterion("provider_subsidy >=", value, "providerSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderSubsidyLessThan(String value) {
            addCriterion("provider_subsidy <", value, "providerSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderSubsidyLessThanOrEqualTo(String value) {
            addCriterion("provider_subsidy <=", value, "providerSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderSubsidyLike(String value) {
            addCriterion("provider_subsidy like", value, "providerSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderSubsidyNotLike(String value) {
            addCriterion("provider_subsidy not like", value, "providerSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderSubsidyIn(List<String> values) {
            addCriterion("provider_subsidy in", values, "providerSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderSubsidyNotIn(List<String> values) {
            addCriterion("provider_subsidy not in", values, "providerSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderSubsidyBetween(String value1, String value2) {
            addCriterion("provider_subsidy between", value1, value2, "providerSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderSubsidyNotBetween(String value1, String value2) {
            addCriterion("provider_subsidy not between", value1, value2, "providerSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerBottleSubsidyIsNull() {
            addCriterion("customer_bottle_subsidy is null");
            return (Criteria) this;
        }

        public Criteria andCustomerBottleSubsidyIsNotNull() {
            addCriterion("customer_bottle_subsidy is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerBottleSubsidyEqualTo(String value) {
            addCriterion("customer_bottle_subsidy =", value, "customerBottleSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerBottleSubsidyNotEqualTo(String value) {
            addCriterion("customer_bottle_subsidy <>", value, "customerBottleSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerBottleSubsidyGreaterThan(String value) {
            addCriterion("customer_bottle_subsidy >", value, "customerBottleSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerBottleSubsidyGreaterThanOrEqualTo(String value) {
            addCriterion("customer_bottle_subsidy >=", value, "customerBottleSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerBottleSubsidyLessThan(String value) {
            addCriterion("customer_bottle_subsidy <", value, "customerBottleSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerBottleSubsidyLessThanOrEqualTo(String value) {
            addCriterion("customer_bottle_subsidy <=", value, "customerBottleSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerBottleSubsidyLike(String value) {
            addCriterion("customer_bottle_subsidy like", value, "customerBottleSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerBottleSubsidyNotLike(String value) {
            addCriterion("customer_bottle_subsidy not like", value, "customerBottleSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerBottleSubsidyIn(List<String> values) {
            addCriterion("customer_bottle_subsidy in", values, "customerBottleSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerBottleSubsidyNotIn(List<String> values) {
            addCriterion("customer_bottle_subsidy not in", values, "customerBottleSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerBottleSubsidyBetween(String value1, String value2) {
            addCriterion("customer_bottle_subsidy between", value1, value2, "customerBottleSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerBottleSubsidyNotBetween(String value1, String value2) {
            addCriterion("customer_bottle_subsidy not between", value1, value2, "customerBottleSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerPackageSubsidyIsNull() {
            addCriterion("customer_package_subsidy is null");
            return (Criteria) this;
        }

        public Criteria andCustomerPackageSubsidyIsNotNull() {
            addCriterion("customer_package_subsidy is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerPackageSubsidyEqualTo(String value) {
            addCriterion("customer_package_subsidy =", value, "customerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerPackageSubsidyNotEqualTo(String value) {
            addCriterion("customer_package_subsidy <>", value, "customerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerPackageSubsidyGreaterThan(String value) {
            addCriterion("customer_package_subsidy >", value, "customerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerPackageSubsidyGreaterThanOrEqualTo(String value) {
            addCriterion("customer_package_subsidy >=", value, "customerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerPackageSubsidyLessThan(String value) {
            addCriterion("customer_package_subsidy <", value, "customerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerPackageSubsidyLessThanOrEqualTo(String value) {
            addCriterion("customer_package_subsidy <=", value, "customerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerPackageSubsidyLike(String value) {
            addCriterion("customer_package_subsidy like", value, "customerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerPackageSubsidyNotLike(String value) {
            addCriterion("customer_package_subsidy not like", value, "customerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerPackageSubsidyIn(List<String> values) {
            addCriterion("customer_package_subsidy in", values, "customerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerPackageSubsidyNotIn(List<String> values) {
            addCriterion("customer_package_subsidy not in", values, "customerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerPackageSubsidyBetween(String value1, String value2) {
            addCriterion("customer_package_subsidy between", value1, value2, "customerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerPackageSubsidyNotBetween(String value1, String value2) {
            addCriterion("customer_package_subsidy not between", value1, value2, "customerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderPackageSubsidyIsNull() {
            addCriterion("provider_package_subsidy is null");
            return (Criteria) this;
        }

        public Criteria andProviderPackageSubsidyIsNotNull() {
            addCriterion("provider_package_subsidy is not null");
            return (Criteria) this;
        }

        public Criteria andProviderPackageSubsidyEqualTo(String value) {
            addCriterion("provider_package_subsidy =", value, "providerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderPackageSubsidyNotEqualTo(String value) {
            addCriterion("provider_package_subsidy <>", value, "providerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderPackageSubsidyGreaterThan(String value) {
            addCriterion("provider_package_subsidy >", value, "providerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderPackageSubsidyGreaterThanOrEqualTo(String value) {
            addCriterion("provider_package_subsidy >=", value, "providerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderPackageSubsidyLessThan(String value) {
            addCriterion("provider_package_subsidy <", value, "providerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderPackageSubsidyLessThanOrEqualTo(String value) {
            addCriterion("provider_package_subsidy <=", value, "providerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderPackageSubsidyLike(String value) {
            addCriterion("provider_package_subsidy like", value, "providerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderPackageSubsidyNotLike(String value) {
            addCriterion("provider_package_subsidy not like", value, "providerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderPackageSubsidyIn(List<String> values) {
            addCriterion("provider_package_subsidy in", values, "providerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderPackageSubsidyNotIn(List<String> values) {
            addCriterion("provider_package_subsidy not in", values, "providerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderPackageSubsidyBetween(String value1, String value2) {
            addCriterion("provider_package_subsidy between", value1, value2, "providerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderPackageSubsidyNotBetween(String value1, String value2) {
            addCriterion("provider_package_subsidy not between", value1, value2, "providerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerSubsidyIsNull() {
            addCriterion("customer_subsidy is null");
            return (Criteria) this;
        }

        public Criteria andCustomerSubsidyIsNotNull() {
            addCriterion("customer_subsidy is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerSubsidyEqualTo(String value) {
            addCriterion("customer_subsidy =", value, "customerSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerSubsidyNotEqualTo(String value) {
            addCriterion("customer_subsidy <>", value, "customerSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerSubsidyGreaterThan(String value) {
            addCriterion("customer_subsidy >", value, "customerSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerSubsidyGreaterThanOrEqualTo(String value) {
            addCriterion("customer_subsidy >=", value, "customerSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerSubsidyLessThan(String value) {
            addCriterion("customer_subsidy <", value, "customerSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerSubsidyLessThanOrEqualTo(String value) {
            addCriterion("customer_subsidy <=", value, "customerSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerSubsidyLike(String value) {
            addCriterion("customer_subsidy like", value, "customerSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerSubsidyNotLike(String value) {
            addCriterion("customer_subsidy not like", value, "customerSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerSubsidyIn(List<String> values) {
            addCriterion("customer_subsidy in", values, "customerSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerSubsidyNotIn(List<String> values) {
            addCriterion("customer_subsidy not in", values, "customerSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerSubsidyBetween(String value1, String value2) {
            addCriterion("customer_subsidy between", value1, value2, "customerSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerSubsidyNotBetween(String value1, String value2) {
            addCriterion("customer_subsidy not between", value1, value2, "customerSubsidy");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidyIsNull() {
            addCriterion("other_subsidy is null");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidyIsNotNull() {
            addCriterion("other_subsidy is not null");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidyEqualTo(String value) {
            addCriterion("other_subsidy =", value, "otherSubsidy");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidyNotEqualTo(String value) {
            addCriterion("other_subsidy <>", value, "otherSubsidy");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidyGreaterThan(String value) {
            addCriterion("other_subsidy >", value, "otherSubsidy");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidyGreaterThanOrEqualTo(String value) {
            addCriterion("other_subsidy >=", value, "otherSubsidy");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidyLessThan(String value) {
            addCriterion("other_subsidy <", value, "otherSubsidy");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidyLessThanOrEqualTo(String value) {
            addCriterion("other_subsidy <=", value, "otherSubsidy");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidyLike(String value) {
            addCriterion("other_subsidy like", value, "otherSubsidy");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidyNotLike(String value) {
            addCriterion("other_subsidy not like", value, "otherSubsidy");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidyIn(List<String> values) {
            addCriterion("other_subsidy in", values, "otherSubsidy");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidyNotIn(List<String> values) {
            addCriterion("other_subsidy not in", values, "otherSubsidy");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidyBetween(String value1, String value2) {
            addCriterion("other_subsidy between", value1, value2, "otherSubsidy");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidyNotBetween(String value1, String value2) {
            addCriterion("other_subsidy not between", value1, value2, "otherSubsidy");
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

        public Criteria andSingleFinalCostIsNull() {
            addCriterion("single_final_cost is null");
            return (Criteria) this;
        }

        public Criteria andSingleFinalCostIsNotNull() {
            addCriterion("single_final_cost is not null");
            return (Criteria) this;
        }

        public Criteria andSingleFinalCostEqualTo(String value) {
            addCriterion("single_final_cost =", value, "singleFinalCost");
            return (Criteria) this;
        }

        public Criteria andSingleFinalCostNotEqualTo(String value) {
            addCriterion("single_final_cost <>", value, "singleFinalCost");
            return (Criteria) this;
        }

        public Criteria andSingleFinalCostGreaterThan(String value) {
            addCriterion("single_final_cost >", value, "singleFinalCost");
            return (Criteria) this;
        }

        public Criteria andSingleFinalCostGreaterThanOrEqualTo(String value) {
            addCriterion("single_final_cost >=", value, "singleFinalCost");
            return (Criteria) this;
        }

        public Criteria andSingleFinalCostLessThan(String value) {
            addCriterion("single_final_cost <", value, "singleFinalCost");
            return (Criteria) this;
        }

        public Criteria andSingleFinalCostLessThanOrEqualTo(String value) {
            addCriterion("single_final_cost <=", value, "singleFinalCost");
            return (Criteria) this;
        }

        public Criteria andSingleFinalCostLike(String value) {
            addCriterion("single_final_cost like", value, "singleFinalCost");
            return (Criteria) this;
        }

        public Criteria andSingleFinalCostNotLike(String value) {
            addCriterion("single_final_cost not like", value, "singleFinalCost");
            return (Criteria) this;
        }

        public Criteria andSingleFinalCostIn(List<String> values) {
            addCriterion("single_final_cost in", values, "singleFinalCost");
            return (Criteria) this;
        }

        public Criteria andSingleFinalCostNotIn(List<String> values) {
            addCriterion("single_final_cost not in", values, "singleFinalCost");
            return (Criteria) this;
        }

        public Criteria andSingleFinalCostBetween(String value1, String value2) {
            addCriterion("single_final_cost between", value1, value2, "singleFinalCost");
            return (Criteria) this;
        }

        public Criteria andSingleFinalCostNotBetween(String value1, String value2) {
            addCriterion("single_final_cost not between", value1, value2, "singleFinalCost");
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