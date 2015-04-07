package com.ai.psims.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SalesGoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SalesGoodsExample() {
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

        public Criteria andSalesGoodsIdIsNull() {
            addCriterion("sales_goods_id is null");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsIdIsNotNull() {
            addCriterion("sales_goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsIdEqualTo(Integer value) {
            addCriterion("sales_goods_id =", value, "salesGoodsId");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsIdNotEqualTo(Integer value) {
            addCriterion("sales_goods_id <>", value, "salesGoodsId");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsIdGreaterThan(Integer value) {
            addCriterion("sales_goods_id >", value, "salesGoodsId");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sales_goods_id >=", value, "salesGoodsId");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsIdLessThan(Integer value) {
            addCriterion("sales_goods_id <", value, "salesGoodsId");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("sales_goods_id <=", value, "salesGoodsId");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsIdIn(List<Integer> values) {
            addCriterion("sales_goods_id in", values, "salesGoodsId");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsIdNotIn(List<Integer> values) {
            addCriterion("sales_goods_id not in", values, "salesGoodsId");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("sales_goods_id between", value1, value2, "salesGoodsId");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sales_goods_id not between", value1, value2, "salesGoodsId");
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

        public Criteria andSalesGoodsTypeIsNull() {
            addCriterion("sales_goods_type is null");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsTypeIsNotNull() {
            addCriterion("sales_goods_type is not null");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsTypeEqualTo(String value) {
            addCriterion("sales_goods_type =", value, "salesGoodsType");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsTypeNotEqualTo(String value) {
            addCriterion("sales_goods_type <>", value, "salesGoodsType");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsTypeGreaterThan(String value) {
            addCriterion("sales_goods_type >", value, "salesGoodsType");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sales_goods_type >=", value, "salesGoodsType");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsTypeLessThan(String value) {
            addCriterion("sales_goods_type <", value, "salesGoodsType");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsTypeLessThanOrEqualTo(String value) {
            addCriterion("sales_goods_type <=", value, "salesGoodsType");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsTypeLike(String value) {
            addCriterion("sales_goods_type like", value, "salesGoodsType");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsTypeNotLike(String value) {
            addCriterion("sales_goods_type not like", value, "salesGoodsType");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsTypeIn(List<String> values) {
            addCriterion("sales_goods_type in", values, "salesGoodsType");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsTypeNotIn(List<String> values) {
            addCriterion("sales_goods_type not in", values, "salesGoodsType");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsTypeBetween(String value1, String value2) {
            addCriterion("sales_goods_type between", value1, value2, "salesGoodsType");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsTypeNotBetween(String value1, String value2) {
            addCriterion("sales_goods_type not between", value1, value2, "salesGoodsType");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsAmountIsNull() {
            addCriterion("sales_goods_amount is null");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsAmountIsNotNull() {
            addCriterion("sales_goods_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsAmountEqualTo(Integer value) {
            addCriterion("sales_goods_amount =", value, "salesGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsAmountNotEqualTo(Integer value) {
            addCriterion("sales_goods_amount <>", value, "salesGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsAmountGreaterThan(Integer value) {
            addCriterion("sales_goods_amount >", value, "salesGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("sales_goods_amount >=", value, "salesGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsAmountLessThan(Integer value) {
            addCriterion("sales_goods_amount <", value, "salesGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsAmountLessThanOrEqualTo(Integer value) {
            addCriterion("sales_goods_amount <=", value, "salesGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsAmountIn(List<Integer> values) {
            addCriterion("sales_goods_amount in", values, "salesGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsAmountNotIn(List<Integer> values) {
            addCriterion("sales_goods_amount not in", values, "salesGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsAmountBetween(Integer value1, Integer value2) {
            addCriterion("sales_goods_amount between", value1, value2, "salesGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("sales_goods_amount not between", value1, value2, "salesGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsUnitIsNull() {
            addCriterion("sales_goods_unit is null");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsUnitIsNotNull() {
            addCriterion("sales_goods_unit is not null");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsUnitEqualTo(String value) {
            addCriterion("sales_goods_unit =", value, "salesGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsUnitNotEqualTo(String value) {
            addCriterion("sales_goods_unit <>", value, "salesGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsUnitGreaterThan(String value) {
            addCriterion("sales_goods_unit >", value, "salesGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsUnitGreaterThanOrEqualTo(String value) {
            addCriterion("sales_goods_unit >=", value, "salesGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsUnitLessThan(String value) {
            addCriterion("sales_goods_unit <", value, "salesGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsUnitLessThanOrEqualTo(String value) {
            addCriterion("sales_goods_unit <=", value, "salesGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsUnitLike(String value) {
            addCriterion("sales_goods_unit like", value, "salesGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsUnitNotLike(String value) {
            addCriterion("sales_goods_unit not like", value, "salesGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsUnitIn(List<String> values) {
            addCriterion("sales_goods_unit in", values, "salesGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsUnitNotIn(List<String> values) {
            addCriterion("sales_goods_unit not in", values, "salesGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsUnitBetween(String value1, String value2) {
            addCriterion("sales_goods_unit between", value1, value2, "salesGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsUnitNotBetween(String value1, String value2) {
            addCriterion("sales_goods_unit not between", value1, value2, "salesGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsPriceIsNull() {
            addCriterion("sales_goods_price is null");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsPriceIsNotNull() {
            addCriterion("sales_goods_price is not null");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsPriceEqualTo(Long value) {
            addCriterion("sales_goods_price =", value, "salesGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsPriceNotEqualTo(Long value) {
            addCriterion("sales_goods_price <>", value, "salesGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsPriceGreaterThan(Long value) {
            addCriterion("sales_goods_price >", value, "salesGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("sales_goods_price >=", value, "salesGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsPriceLessThan(Long value) {
            addCriterion("sales_goods_price <", value, "salesGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsPriceLessThanOrEqualTo(Long value) {
            addCriterion("sales_goods_price <=", value, "salesGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsPriceIn(List<Long> values) {
            addCriterion("sales_goods_price in", values, "salesGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsPriceNotIn(List<Long> values) {
            addCriterion("sales_goods_price not in", values, "salesGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsPriceBetween(Long value1, Long value2) {
            addCriterion("sales_goods_price between", value1, value2, "salesGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsPriceNotBetween(Long value1, Long value2) {
            addCriterion("sales_goods_price not between", value1, value2, "salesGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsProductionDateIsNull() {
            addCriterion("sales_goods_production_date is null");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsProductionDateIsNotNull() {
            addCriterion("sales_goods_production_date is not null");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsProductionDateEqualTo(Date value) {
            addCriterionForJDBCDate("sales_goods_production_date =", value, "salesGoodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsProductionDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("sales_goods_production_date <>", value, "salesGoodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsProductionDateGreaterThan(Date value) {
            addCriterionForJDBCDate("sales_goods_production_date >", value, "salesGoodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsProductionDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sales_goods_production_date >=", value, "salesGoodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsProductionDateLessThan(Date value) {
            addCriterionForJDBCDate("sales_goods_production_date <", value, "salesGoodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsProductionDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sales_goods_production_date <=", value, "salesGoodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsProductionDateIn(List<Date> values) {
            addCriterionForJDBCDate("sales_goods_production_date in", values, "salesGoodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsProductionDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("sales_goods_production_date not in", values, "salesGoodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsProductionDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sales_goods_production_date between", value1, value2, "salesGoodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsProductionDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sales_goods_production_date not between", value1, value2, "salesGoodsProductionDate");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsExpirationDateIsNull() {
            addCriterion("sales_goods_expiration_date is null");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsExpirationDateIsNotNull() {
            addCriterion("sales_goods_expiration_date is not null");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsExpirationDateEqualTo(Date value) {
            addCriterionForJDBCDate("sales_goods_expiration_date =", value, "salesGoodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsExpirationDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("sales_goods_expiration_date <>", value, "salesGoodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsExpirationDateGreaterThan(Date value) {
            addCriterionForJDBCDate("sales_goods_expiration_date >", value, "salesGoodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsExpirationDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sales_goods_expiration_date >=", value, "salesGoodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsExpirationDateLessThan(Date value) {
            addCriterionForJDBCDate("sales_goods_expiration_date <", value, "salesGoodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsExpirationDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sales_goods_expiration_date <=", value, "salesGoodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsExpirationDateIn(List<Date> values) {
            addCriterionForJDBCDate("sales_goods_expiration_date in", values, "salesGoodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsExpirationDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("sales_goods_expiration_date not in", values, "salesGoodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsExpirationDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sales_goods_expiration_date between", value1, value2, "salesGoodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsExpirationDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sales_goods_expiration_date not between", value1, value2, "salesGoodsExpirationDate");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsTotalPriceIsNull() {
            addCriterion("sales_goods_total_price is null");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsTotalPriceIsNotNull() {
            addCriterion("sales_goods_total_price is not null");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsTotalPriceEqualTo(Long value) {
            addCriterion("sales_goods_total_price =", value, "salesGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsTotalPriceNotEqualTo(Long value) {
            addCriterion("sales_goods_total_price <>", value, "salesGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsTotalPriceGreaterThan(Long value) {
            addCriterion("sales_goods_total_price >", value, "salesGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsTotalPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("sales_goods_total_price >=", value, "salesGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsTotalPriceLessThan(Long value) {
            addCriterion("sales_goods_total_price <", value, "salesGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsTotalPriceLessThanOrEqualTo(Long value) {
            addCriterion("sales_goods_total_price <=", value, "salesGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsTotalPriceIn(List<Long> values) {
            addCriterion("sales_goods_total_price in", values, "salesGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsTotalPriceNotIn(List<Long> values) {
            addCriterion("sales_goods_total_price not in", values, "salesGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsTotalPriceBetween(Long value1, Long value2) {
            addCriterion("sales_goods_total_price between", value1, value2, "salesGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsTotalPriceNotBetween(Long value1, Long value2) {
            addCriterion("sales_goods_total_price not between", value1, value2, "salesGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andSalesDiscountAmountIsNull() {
            addCriterion("sales_discount_amount is null");
            return (Criteria) this;
        }

        public Criteria andSalesDiscountAmountIsNotNull() {
            addCriterion("sales_discount_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSalesDiscountAmountEqualTo(Long value) {
            addCriterion("sales_discount_amount =", value, "salesDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andSalesDiscountAmountNotEqualTo(Long value) {
            addCriterion("sales_discount_amount <>", value, "salesDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andSalesDiscountAmountGreaterThan(Long value) {
            addCriterion("sales_discount_amount >", value, "salesDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andSalesDiscountAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("sales_discount_amount >=", value, "salesDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andSalesDiscountAmountLessThan(Long value) {
            addCriterion("sales_discount_amount <", value, "salesDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andSalesDiscountAmountLessThanOrEqualTo(Long value) {
            addCriterion("sales_discount_amount <=", value, "salesDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andSalesDiscountAmountIn(List<Long> values) {
            addCriterion("sales_discount_amount in", values, "salesDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andSalesDiscountAmountNotIn(List<Long> values) {
            addCriterion("sales_discount_amount not in", values, "salesDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andSalesDiscountAmountBetween(Long value1, Long value2) {
            addCriterion("sales_discount_amount between", value1, value2, "salesDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andSalesDiscountAmountNotBetween(Long value1, Long value2) {
            addCriterion("sales_discount_amount not between", value1, value2, "salesDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andSalesFinalAmountIsNull() {
            addCriterion("sales_final_amount is null");
            return (Criteria) this;
        }

        public Criteria andSalesFinalAmountIsNotNull() {
            addCriterion("sales_final_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSalesFinalAmountEqualTo(Long value) {
            addCriterion("sales_final_amount =", value, "salesFinalAmount");
            return (Criteria) this;
        }

        public Criteria andSalesFinalAmountNotEqualTo(Long value) {
            addCriterion("sales_final_amount <>", value, "salesFinalAmount");
            return (Criteria) this;
        }

        public Criteria andSalesFinalAmountGreaterThan(Long value) {
            addCriterion("sales_final_amount >", value, "salesFinalAmount");
            return (Criteria) this;
        }

        public Criteria andSalesFinalAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("sales_final_amount >=", value, "salesFinalAmount");
            return (Criteria) this;
        }

        public Criteria andSalesFinalAmountLessThan(Long value) {
            addCriterion("sales_final_amount <", value, "salesFinalAmount");
            return (Criteria) this;
        }

        public Criteria andSalesFinalAmountLessThanOrEqualTo(Long value) {
            addCriterion("sales_final_amount <=", value, "salesFinalAmount");
            return (Criteria) this;
        }

        public Criteria andSalesFinalAmountIn(List<Long> values) {
            addCriterion("sales_final_amount in", values, "salesFinalAmount");
            return (Criteria) this;
        }

        public Criteria andSalesFinalAmountNotIn(List<Long> values) {
            addCriterion("sales_final_amount not in", values, "salesFinalAmount");
            return (Criteria) this;
        }

        public Criteria andSalesFinalAmountBetween(Long value1, Long value2) {
            addCriterion("sales_final_amount between", value1, value2, "salesFinalAmount");
            return (Criteria) this;
        }

        public Criteria andSalesFinalAmountNotBetween(Long value1, Long value2) {
            addCriterion("sales_final_amount not between", value1, value2, "salesFinalAmount");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsCreatetimeIsNull() {
            addCriterion("sales_goods_createtime is null");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsCreatetimeIsNotNull() {
            addCriterion("sales_goods_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsCreatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("sales_goods_createtime =", value, "salesGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsCreatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("sales_goods_createtime <>", value, "salesGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsCreatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("sales_goods_createtime >", value, "salesGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sales_goods_createtime >=", value, "salesGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsCreatetimeLessThan(Date value) {
            addCriterionForJDBCDate("sales_goods_createtime <", value, "salesGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsCreatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sales_goods_createtime <=", value, "salesGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsCreatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("sales_goods_createtime in", values, "salesGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsCreatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("sales_goods_createtime not in", values, "salesGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsCreatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sales_goods_createtime between", value1, value2, "salesGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsCreatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sales_goods_createtime not between", value1, value2, "salesGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsModifytimeIsNull() {
            addCriterion("sales_goods_modifytime is null");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsModifytimeIsNotNull() {
            addCriterion("sales_goods_modifytime is not null");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsModifytimeEqualTo(Date value) {
            addCriterionForJDBCDate("sales_goods_modifytime =", value, "salesGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsModifytimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("sales_goods_modifytime <>", value, "salesGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsModifytimeGreaterThan(Date value) {
            addCriterionForJDBCDate("sales_goods_modifytime >", value, "salesGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsModifytimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sales_goods_modifytime >=", value, "salesGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsModifytimeLessThan(Date value) {
            addCriterionForJDBCDate("sales_goods_modifytime <", value, "salesGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsModifytimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sales_goods_modifytime <=", value, "salesGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsModifytimeIn(List<Date> values) {
            addCriterionForJDBCDate("sales_goods_modifytime in", values, "salesGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsModifytimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("sales_goods_modifytime not in", values, "salesGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsModifytimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sales_goods_modifytime between", value1, value2, "salesGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsModifytimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sales_goods_modifytime not between", value1, value2, "salesGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsEndtimeIsNull() {
            addCriterion("sales_goods_endtime is null");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsEndtimeIsNotNull() {
            addCriterion("sales_goods_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsEndtimeEqualTo(Date value) {
            addCriterionForJDBCDate("sales_goods_endtime =", value, "salesGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsEndtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("sales_goods_endtime <>", value, "salesGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsEndtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("sales_goods_endtime >", value, "salesGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sales_goods_endtime >=", value, "salesGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsEndtimeLessThan(Date value) {
            addCriterionForJDBCDate("sales_goods_endtime <", value, "salesGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsEndtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sales_goods_endtime <=", value, "salesGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsEndtimeIn(List<Date> values) {
            addCriterionForJDBCDate("sales_goods_endtime in", values, "salesGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsEndtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("sales_goods_endtime not in", values, "salesGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsEndtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sales_goods_endtime between", value1, value2, "salesGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsEndtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sales_goods_endtime not between", value1, value2, "salesGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsRemarkIsNull() {
            addCriterion("sales_goods_remark is null");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsRemarkIsNotNull() {
            addCriterion("sales_goods_remark is not null");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsRemarkEqualTo(String value) {
            addCriterion("sales_goods_remark =", value, "salesGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsRemarkNotEqualTo(String value) {
            addCriterion("sales_goods_remark <>", value, "salesGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsRemarkGreaterThan(String value) {
            addCriterion("sales_goods_remark >", value, "salesGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("sales_goods_remark >=", value, "salesGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsRemarkLessThan(String value) {
            addCriterion("sales_goods_remark <", value, "salesGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsRemarkLessThanOrEqualTo(String value) {
            addCriterion("sales_goods_remark <=", value, "salesGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsRemarkLike(String value) {
            addCriterion("sales_goods_remark like", value, "salesGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsRemarkNotLike(String value) {
            addCriterion("sales_goods_remark not like", value, "salesGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsRemarkIn(List<String> values) {
            addCriterion("sales_goods_remark in", values, "salesGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsRemarkNotIn(List<String> values) {
            addCriterion("sales_goods_remark not in", values, "salesGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsRemarkBetween(String value1, String value2) {
            addCriterion("sales_goods_remark between", value1, value2, "salesGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andSalesGoodsRemarkNotBetween(String value1, String value2) {
            addCriterion("sales_goods_remark not between", value1, value2, "salesGoodsRemark");
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