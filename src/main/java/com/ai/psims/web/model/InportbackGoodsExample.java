package com.ai.psims.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class InportbackGoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InportbackGoodsExample() {
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

        public Criteria andImportbackGoodsIdIsNull() {
            addCriterion("importback_goods_id is null");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsIdIsNotNull() {
            addCriterion("importback_goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsIdEqualTo(String value) {
            addCriterion("importback_goods_id =", value, "importbackGoodsId");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsIdNotEqualTo(String value) {
            addCriterion("importback_goods_id <>", value, "importbackGoodsId");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsIdGreaterThan(String value) {
            addCriterion("importback_goods_id >", value, "importbackGoodsId");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsIdGreaterThanOrEqualTo(String value) {
            addCriterion("importback_goods_id >=", value, "importbackGoodsId");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsIdLessThan(String value) {
            addCriterion("importback_goods_id <", value, "importbackGoodsId");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsIdLessThanOrEqualTo(String value) {
            addCriterion("importback_goods_id <=", value, "importbackGoodsId");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsIdLike(String value) {
            addCriterion("importback_goods_id like", value, "importbackGoodsId");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsIdNotLike(String value) {
            addCriterion("importback_goods_id not like", value, "importbackGoodsId");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsIdIn(List<String> values) {
            addCriterion("importback_goods_id in", values, "importbackGoodsId");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsIdNotIn(List<String> values) {
            addCriterion("importback_goods_id not in", values, "importbackGoodsId");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsIdBetween(String value1, String value2) {
            addCriterion("importback_goods_id between", value1, value2, "importbackGoodsId");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsIdNotBetween(String value1, String value2) {
            addCriterion("importback_goods_id not between", value1, value2, "importbackGoodsId");
            return (Criteria) this;
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

        public Criteria andImportbackGoodsTypeIsNull() {
            addCriterion("importback_goods_type is null");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsTypeIsNotNull() {
            addCriterion("importback_goods_type is not null");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsTypeEqualTo(String value) {
            addCriterion("importback_goods_type =", value, "importbackGoodsType");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsTypeNotEqualTo(String value) {
            addCriterion("importback_goods_type <>", value, "importbackGoodsType");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsTypeGreaterThan(String value) {
            addCriterion("importback_goods_type >", value, "importbackGoodsType");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("importback_goods_type >=", value, "importbackGoodsType");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsTypeLessThan(String value) {
            addCriterion("importback_goods_type <", value, "importbackGoodsType");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsTypeLessThanOrEqualTo(String value) {
            addCriterion("importback_goods_type <=", value, "importbackGoodsType");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsTypeLike(String value) {
            addCriterion("importback_goods_type like", value, "importbackGoodsType");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsTypeNotLike(String value) {
            addCriterion("importback_goods_type not like", value, "importbackGoodsType");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsTypeIn(List<String> values) {
            addCriterion("importback_goods_type in", values, "importbackGoodsType");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsTypeNotIn(List<String> values) {
            addCriterion("importback_goods_type not in", values, "importbackGoodsType");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsTypeBetween(String value1, String value2) {
            addCriterion("importback_goods_type between", value1, value2, "importbackGoodsType");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsTypeNotBetween(String value1, String value2) {
            addCriterion("importback_goods_type not between", value1, value2, "importbackGoodsType");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsAmountIsNull() {
            addCriterion("importback_goods_amount is null");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsAmountIsNotNull() {
            addCriterion("importback_goods_amount is not null");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsAmountEqualTo(Integer value) {
            addCriterion("importback_goods_amount =", value, "importbackGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsAmountNotEqualTo(Integer value) {
            addCriterion("importback_goods_amount <>", value, "importbackGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsAmountGreaterThan(Integer value) {
            addCriterion("importback_goods_amount >", value, "importbackGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("importback_goods_amount >=", value, "importbackGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsAmountLessThan(Integer value) {
            addCriterion("importback_goods_amount <", value, "importbackGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsAmountLessThanOrEqualTo(Integer value) {
            addCriterion("importback_goods_amount <=", value, "importbackGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsAmountIn(List<Integer> values) {
            addCriterion("importback_goods_amount in", values, "importbackGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsAmountNotIn(List<Integer> values) {
            addCriterion("importback_goods_amount not in", values, "importbackGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsAmountBetween(Integer value1, Integer value2) {
            addCriterion("importback_goods_amount between", value1, value2, "importbackGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("importback_goods_amount not between", value1, value2, "importbackGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsUnitIsNull() {
            addCriterion("importback_goods_unit is null");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsUnitIsNotNull() {
            addCriterion("importback_goods_unit is not null");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsUnitEqualTo(String value) {
            addCriterion("importback_goods_unit =", value, "importbackGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsUnitNotEqualTo(String value) {
            addCriterion("importback_goods_unit <>", value, "importbackGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsUnitGreaterThan(String value) {
            addCriterion("importback_goods_unit >", value, "importbackGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsUnitGreaterThanOrEqualTo(String value) {
            addCriterion("importback_goods_unit >=", value, "importbackGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsUnitLessThan(String value) {
            addCriterion("importback_goods_unit <", value, "importbackGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsUnitLessThanOrEqualTo(String value) {
            addCriterion("importback_goods_unit <=", value, "importbackGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsUnitLike(String value) {
            addCriterion("importback_goods_unit like", value, "importbackGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsUnitNotLike(String value) {
            addCriterion("importback_goods_unit not like", value, "importbackGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsUnitIn(List<String> values) {
            addCriterion("importback_goods_unit in", values, "importbackGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsUnitNotIn(List<String> values) {
            addCriterion("importback_goods_unit not in", values, "importbackGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsUnitBetween(String value1, String value2) {
            addCriterion("importback_goods_unit between", value1, value2, "importbackGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsUnitNotBetween(String value1, String value2) {
            addCriterion("importback_goods_unit not between", value1, value2, "importbackGoodsUnit");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsPriceIsNull() {
            addCriterion("importback_goods_price is null");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsPriceIsNotNull() {
            addCriterion("importback_goods_price is not null");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsPriceEqualTo(Long value) {
            addCriterion("importback_goods_price =", value, "importbackGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsPriceNotEqualTo(Long value) {
            addCriterion("importback_goods_price <>", value, "importbackGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsPriceGreaterThan(Long value) {
            addCriterion("importback_goods_price >", value, "importbackGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("importback_goods_price >=", value, "importbackGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsPriceLessThan(Long value) {
            addCriterion("importback_goods_price <", value, "importbackGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsPriceLessThanOrEqualTo(Long value) {
            addCriterion("importback_goods_price <=", value, "importbackGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsPriceIn(List<Long> values) {
            addCriterion("importback_goods_price in", values, "importbackGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsPriceNotIn(List<Long> values) {
            addCriterion("importback_goods_price not in", values, "importbackGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsPriceBetween(Long value1, Long value2) {
            addCriterion("importback_goods_price between", value1, value2, "importbackGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsPriceNotBetween(Long value1, Long value2) {
            addCriterion("importback_goods_price not between", value1, value2, "importbackGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsProductionIsNull() {
            addCriterion("importback_goods_production is null");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsProductionIsNotNull() {
            addCriterion("importback_goods_production is not null");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsProductionEqualTo(Date value) {
            addCriterionForJDBCDate("importback_goods_production =", value, "importbackGoodsProduction");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsProductionNotEqualTo(Date value) {
            addCriterionForJDBCDate("importback_goods_production <>", value, "importbackGoodsProduction");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsProductionGreaterThan(Date value) {
            addCriterionForJDBCDate("importback_goods_production >", value, "importbackGoodsProduction");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsProductionGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("importback_goods_production >=", value, "importbackGoodsProduction");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsProductionLessThan(Date value) {
            addCriterionForJDBCDate("importback_goods_production <", value, "importbackGoodsProduction");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsProductionLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("importback_goods_production <=", value, "importbackGoodsProduction");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsProductionIn(List<Date> values) {
            addCriterionForJDBCDate("importback_goods_production in", values, "importbackGoodsProduction");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsProductionNotIn(List<Date> values) {
            addCriterionForJDBCDate("importback_goods_production not in", values, "importbackGoodsProduction");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsProductionBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("importback_goods_production between", value1, value2, "importbackGoodsProduction");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsProductionNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("importback_goods_production not between", value1, value2, "importbackGoodsProduction");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsExpirationIsNull() {
            addCriterion("importback_goods_expiration is null");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsExpirationIsNotNull() {
            addCriterion("importback_goods_expiration is not null");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsExpirationEqualTo(Date value) {
            addCriterionForJDBCDate("importback_goods_expiration =", value, "importbackGoodsExpiration");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsExpirationNotEqualTo(Date value) {
            addCriterionForJDBCDate("importback_goods_expiration <>", value, "importbackGoodsExpiration");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsExpirationGreaterThan(Date value) {
            addCriterionForJDBCDate("importback_goods_expiration >", value, "importbackGoodsExpiration");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsExpirationGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("importback_goods_expiration >=", value, "importbackGoodsExpiration");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsExpirationLessThan(Date value) {
            addCriterionForJDBCDate("importback_goods_expiration <", value, "importbackGoodsExpiration");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsExpirationLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("importback_goods_expiration <=", value, "importbackGoodsExpiration");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsExpirationIn(List<Date> values) {
            addCriterionForJDBCDate("importback_goods_expiration in", values, "importbackGoodsExpiration");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsExpirationNotIn(List<Date> values) {
            addCriterionForJDBCDate("importback_goods_expiration not in", values, "importbackGoodsExpiration");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsExpirationBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("importback_goods_expiration between", value1, value2, "importbackGoodsExpiration");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsExpirationNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("importback_goods_expiration not between", value1, value2, "importbackGoodsExpiration");
            return (Criteria) this;
        }

        public Criteria andImportbackDiscountAmountIsNull() {
            addCriterion("importback_discount_amount is null");
            return (Criteria) this;
        }

        public Criteria andImportbackDiscountAmountIsNotNull() {
            addCriterion("importback_discount_amount is not null");
            return (Criteria) this;
        }

        public Criteria andImportbackDiscountAmountEqualTo(Long value) {
            addCriterion("importback_discount_amount =", value, "importbackDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andImportbackDiscountAmountNotEqualTo(Long value) {
            addCriterion("importback_discount_amount <>", value, "importbackDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andImportbackDiscountAmountGreaterThan(Long value) {
            addCriterion("importback_discount_amount >", value, "importbackDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andImportbackDiscountAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("importback_discount_amount >=", value, "importbackDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andImportbackDiscountAmountLessThan(Long value) {
            addCriterion("importback_discount_amount <", value, "importbackDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andImportbackDiscountAmountLessThanOrEqualTo(Long value) {
            addCriterion("importback_discount_amount <=", value, "importbackDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andImportbackDiscountAmountIn(List<Long> values) {
            addCriterion("importback_discount_amount in", values, "importbackDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andImportbackDiscountAmountNotIn(List<Long> values) {
            addCriterion("importback_discount_amount not in", values, "importbackDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andImportbackDiscountAmountBetween(Long value1, Long value2) {
            addCriterion("importback_discount_amount between", value1, value2, "importbackDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andImportbackDiscountAmountNotBetween(Long value1, Long value2) {
            addCriterion("importback_discount_amount not between", value1, value2, "importbackDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsCreatetimeIsNull() {
            addCriterion("importback_goods_createtime is null");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsCreatetimeIsNotNull() {
            addCriterion("importback_goods_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsCreatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("importback_goods_createtime =", value, "importbackGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsCreatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("importback_goods_createtime <>", value, "importbackGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsCreatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("importback_goods_createtime >", value, "importbackGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("importback_goods_createtime >=", value, "importbackGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsCreatetimeLessThan(Date value) {
            addCriterionForJDBCDate("importback_goods_createtime <", value, "importbackGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsCreatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("importback_goods_createtime <=", value, "importbackGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsCreatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("importback_goods_createtime in", values, "importbackGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsCreatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("importback_goods_createtime not in", values, "importbackGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsCreatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("importback_goods_createtime between", value1, value2, "importbackGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsCreatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("importback_goods_createtime not between", value1, value2, "importbackGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsModifytimeIsNull() {
            addCriterion("importback_goods_modifytime is null");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsModifytimeIsNotNull() {
            addCriterion("importback_goods_modifytime is not null");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsModifytimeEqualTo(Date value) {
            addCriterionForJDBCDate("importback_goods_modifytime =", value, "importbackGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsModifytimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("importback_goods_modifytime <>", value, "importbackGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsModifytimeGreaterThan(Date value) {
            addCriterionForJDBCDate("importback_goods_modifytime >", value, "importbackGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsModifytimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("importback_goods_modifytime >=", value, "importbackGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsModifytimeLessThan(Date value) {
            addCriterionForJDBCDate("importback_goods_modifytime <", value, "importbackGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsModifytimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("importback_goods_modifytime <=", value, "importbackGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsModifytimeIn(List<Date> values) {
            addCriterionForJDBCDate("importback_goods_modifytime in", values, "importbackGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsModifytimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("importback_goods_modifytime not in", values, "importbackGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsModifytimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("importback_goods_modifytime between", value1, value2, "importbackGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsModifytimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("importback_goods_modifytime not between", value1, value2, "importbackGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsEndtimeIsNull() {
            addCriterion("importback_goods_endtime is null");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsEndtimeIsNotNull() {
            addCriterion("importback_goods_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsEndtimeEqualTo(Date value) {
            addCriterionForJDBCDate("importback_goods_endtime =", value, "importbackGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsEndtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("importback_goods_endtime <>", value, "importbackGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsEndtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("importback_goods_endtime >", value, "importbackGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("importback_goods_endtime >=", value, "importbackGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsEndtimeLessThan(Date value) {
            addCriterionForJDBCDate("importback_goods_endtime <", value, "importbackGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsEndtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("importback_goods_endtime <=", value, "importbackGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsEndtimeIn(List<Date> values) {
            addCriterionForJDBCDate("importback_goods_endtime in", values, "importbackGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsEndtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("importback_goods_endtime not in", values, "importbackGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsEndtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("importback_goods_endtime between", value1, value2, "importbackGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsEndtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("importback_goods_endtime not between", value1, value2, "importbackGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsRemarkIsNull() {
            addCriterion("importback_goods_remark is null");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsRemarkIsNotNull() {
            addCriterion("importback_goods_remark is not null");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsRemarkEqualTo(String value) {
            addCriterion("importback_goods_remark =", value, "importbackGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsRemarkNotEqualTo(String value) {
            addCriterion("importback_goods_remark <>", value, "importbackGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsRemarkGreaterThan(String value) {
            addCriterion("importback_goods_remark >", value, "importbackGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("importback_goods_remark >=", value, "importbackGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsRemarkLessThan(String value) {
            addCriterion("importback_goods_remark <", value, "importbackGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsRemarkLessThanOrEqualTo(String value) {
            addCriterion("importback_goods_remark <=", value, "importbackGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsRemarkLike(String value) {
            addCriterion("importback_goods_remark like", value, "importbackGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsRemarkNotLike(String value) {
            addCriterion("importback_goods_remark not like", value, "importbackGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsRemarkIn(List<String> values) {
            addCriterion("importback_goods_remark in", values, "importbackGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsRemarkNotIn(List<String> values) {
            addCriterion("importback_goods_remark not in", values, "importbackGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsRemarkBetween(String value1, String value2) {
            addCriterion("importback_goods_remark between", value1, value2, "importbackGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andImportbackGoodsRemarkNotBetween(String value1, String value2) {
            addCriterion("importback_goods_remark not between", value1, value2, "importbackGoodsRemark");
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