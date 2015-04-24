package com.ai.psims.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbImportGoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbImportGoodsExample() {
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

        public Criteria andImportGoodsIdIsNull() {
            addCriterion("import_goods_id is null");
            return (Criteria) this;
        }

        public Criteria andImportGoodsIdIsNotNull() {
            addCriterion("import_goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andImportGoodsIdEqualTo(Integer value) {
            addCriterion("import_goods_id =", value, "importGoodsId");
            return (Criteria) this;
        }

        public Criteria andImportGoodsIdNotEqualTo(Integer value) {
            addCriterion("import_goods_id <>", value, "importGoodsId");
            return (Criteria) this;
        }

        public Criteria andImportGoodsIdGreaterThan(Integer value) {
            addCriterion("import_goods_id >", value, "importGoodsId");
            return (Criteria) this;
        }

        public Criteria andImportGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("import_goods_id >=", value, "importGoodsId");
            return (Criteria) this;
        }

        public Criteria andImportGoodsIdLessThan(Integer value) {
            addCriterion("import_goods_id <", value, "importGoodsId");
            return (Criteria) this;
        }

        public Criteria andImportGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("import_goods_id <=", value, "importGoodsId");
            return (Criteria) this;
        }

        public Criteria andImportGoodsIdIn(List<Integer> values) {
            addCriterion("import_goods_id in", values, "importGoodsId");
            return (Criteria) this;
        }

        public Criteria andImportGoodsIdNotIn(List<Integer> values) {
            addCriterion("import_goods_id not in", values, "importGoodsId");
            return (Criteria) this;
        }

        public Criteria andImportGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("import_goods_id between", value1, value2, "importGoodsId");
            return (Criteria) this;
        }

        public Criteria andImportGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("import_goods_id not between", value1, value2, "importGoodsId");
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

        public Criteria andImportGoodsTypeIsNull() {
            addCriterion("import_goods_type is null");
            return (Criteria) this;
        }

        public Criteria andImportGoodsTypeIsNotNull() {
            addCriterion("import_goods_type is not null");
            return (Criteria) this;
        }

        public Criteria andImportGoodsTypeEqualTo(String value) {
            addCriterion("import_goods_type =", value, "importGoodsType");
            return (Criteria) this;
        }

        public Criteria andImportGoodsTypeNotEqualTo(String value) {
            addCriterion("import_goods_type <>", value, "importGoodsType");
            return (Criteria) this;
        }

        public Criteria andImportGoodsTypeGreaterThan(String value) {
            addCriterion("import_goods_type >", value, "importGoodsType");
            return (Criteria) this;
        }

        public Criteria andImportGoodsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("import_goods_type >=", value, "importGoodsType");
            return (Criteria) this;
        }

        public Criteria andImportGoodsTypeLessThan(String value) {
            addCriterion("import_goods_type <", value, "importGoodsType");
            return (Criteria) this;
        }

        public Criteria andImportGoodsTypeLessThanOrEqualTo(String value) {
            addCriterion("import_goods_type <=", value, "importGoodsType");
            return (Criteria) this;
        }

        public Criteria andImportGoodsTypeLike(String value) {
            addCriterion("import_goods_type like", value, "importGoodsType");
            return (Criteria) this;
        }

        public Criteria andImportGoodsTypeNotLike(String value) {
            addCriterion("import_goods_type not like", value, "importGoodsType");
            return (Criteria) this;
        }

        public Criteria andImportGoodsTypeIn(List<String> values) {
            addCriterion("import_goods_type in", values, "importGoodsType");
            return (Criteria) this;
        }

        public Criteria andImportGoodsTypeNotIn(List<String> values) {
            addCriterion("import_goods_type not in", values, "importGoodsType");
            return (Criteria) this;
        }

        public Criteria andImportGoodsTypeBetween(String value1, String value2) {
            addCriterion("import_goods_type between", value1, value2, "importGoodsType");
            return (Criteria) this;
        }

        public Criteria andImportGoodsTypeNotBetween(String value1, String value2) {
            addCriterion("import_goods_type not between", value1, value2, "importGoodsType");
            return (Criteria) this;
        }

        public Criteria andImportGoodsAmountIsNull() {
            addCriterion("import_goods_amount is null");
            return (Criteria) this;
        }

        public Criteria andImportGoodsAmountIsNotNull() {
            addCriterion("import_goods_amount is not null");
            return (Criteria) this;
        }

        public Criteria andImportGoodsAmountEqualTo(Integer value) {
            addCriterion("import_goods_amount =", value, "importGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andImportGoodsAmountNotEqualTo(Integer value) {
            addCriterion("import_goods_amount <>", value, "importGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andImportGoodsAmountGreaterThan(Integer value) {
            addCriterion("import_goods_amount >", value, "importGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andImportGoodsAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("import_goods_amount >=", value, "importGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andImportGoodsAmountLessThan(Integer value) {
            addCriterion("import_goods_amount <", value, "importGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andImportGoodsAmountLessThanOrEqualTo(Integer value) {
            addCriterion("import_goods_amount <=", value, "importGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andImportGoodsAmountIn(List<Integer> values) {
            addCriterion("import_goods_amount in", values, "importGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andImportGoodsAmountNotIn(List<Integer> values) {
            addCriterion("import_goods_amount not in", values, "importGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andImportGoodsAmountBetween(Integer value1, Integer value2) {
            addCriterion("import_goods_amount between", value1, value2, "importGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andImportGoodsAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("import_goods_amount not between", value1, value2, "importGoodsAmount");
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

        public Criteria andImportGoodsPriceIsNull() {
            addCriterion("import_goods_price is null");
            return (Criteria) this;
        }

        public Criteria andImportGoodsPriceIsNotNull() {
            addCriterion("import_goods_price is not null");
            return (Criteria) this;
        }

        public Criteria andImportGoodsPriceEqualTo(Long value) {
            addCriterion("import_goods_price =", value, "importGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsPriceNotEqualTo(Long value) {
            addCriterion("import_goods_price <>", value, "importGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsPriceGreaterThan(Long value) {
            addCriterion("import_goods_price >", value, "importGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("import_goods_price >=", value, "importGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsPriceLessThan(Long value) {
            addCriterion("import_goods_price <", value, "importGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsPriceLessThanOrEqualTo(Long value) {
            addCriterion("import_goods_price <=", value, "importGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsPriceIn(List<Long> values) {
            addCriterion("import_goods_price in", values, "importGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsPriceNotIn(List<Long> values) {
            addCriterion("import_goods_price not in", values, "importGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsPriceBetween(Long value1, Long value2) {
            addCriterion("import_goods_price between", value1, value2, "importGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsPriceNotBetween(Long value1, Long value2) {
            addCriterion("import_goods_price not between", value1, value2, "importGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportDiscountAmountIsNull() {
            addCriterion("import_discount_amount is null");
            return (Criteria) this;
        }

        public Criteria andImportDiscountAmountIsNotNull() {
            addCriterion("import_discount_amount is not null");
            return (Criteria) this;
        }

        public Criteria andImportDiscountAmountEqualTo(Long value) {
            addCriterion("import_discount_amount =", value, "importDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andImportDiscountAmountNotEqualTo(Long value) {
            addCriterion("import_discount_amount <>", value, "importDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andImportDiscountAmountGreaterThan(Long value) {
            addCriterion("import_discount_amount >", value, "importDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andImportDiscountAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("import_discount_amount >=", value, "importDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andImportDiscountAmountLessThan(Long value) {
            addCriterion("import_discount_amount <", value, "importDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andImportDiscountAmountLessThanOrEqualTo(Long value) {
            addCriterion("import_discount_amount <=", value, "importDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andImportDiscountAmountIn(List<Long> values) {
            addCriterion("import_discount_amount in", values, "importDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andImportDiscountAmountNotIn(List<Long> values) {
            addCriterion("import_discount_amount not in", values, "importDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andImportDiscountAmountBetween(Long value1, Long value2) {
            addCriterion("import_discount_amount between", value1, value2, "importDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andImportDiscountAmountNotBetween(Long value1, Long value2) {
            addCriterion("import_discount_amount not between", value1, value2, "importDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andImportGoodsCreatetimeIsNull() {
            addCriterion("import_goods_createtime is null");
            return (Criteria) this;
        }

        public Criteria andImportGoodsCreatetimeIsNotNull() {
            addCriterion("import_goods_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andImportGoodsCreatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("import_goods_createtime =", value, "importGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsCreatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("import_goods_createtime <>", value, "importGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsCreatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("import_goods_createtime >", value, "importGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("import_goods_createtime >=", value, "importGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsCreatetimeLessThan(Date value) {
            addCriterionForJDBCDate("import_goods_createtime <", value, "importGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsCreatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("import_goods_createtime <=", value, "importGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsCreatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("import_goods_createtime in", values, "importGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsCreatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("import_goods_createtime not in", values, "importGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsCreatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("import_goods_createtime between", value1, value2, "importGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsCreatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("import_goods_createtime not between", value1, value2, "importGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsModifytimeIsNull() {
            addCriterion("import_goods_modifytime is null");
            return (Criteria) this;
        }

        public Criteria andImportGoodsModifytimeIsNotNull() {
            addCriterion("import_goods_modifytime is not null");
            return (Criteria) this;
        }

        public Criteria andImportGoodsModifytimeEqualTo(Date value) {
            addCriterionForJDBCDate("import_goods_modifytime =", value, "importGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsModifytimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("import_goods_modifytime <>", value, "importGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsModifytimeGreaterThan(Date value) {
            addCriterionForJDBCDate("import_goods_modifytime >", value, "importGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsModifytimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("import_goods_modifytime >=", value, "importGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsModifytimeLessThan(Date value) {
            addCriterionForJDBCDate("import_goods_modifytime <", value, "importGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsModifytimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("import_goods_modifytime <=", value, "importGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsModifytimeIn(List<Date> values) {
            addCriterionForJDBCDate("import_goods_modifytime in", values, "importGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsModifytimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("import_goods_modifytime not in", values, "importGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsModifytimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("import_goods_modifytime between", value1, value2, "importGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsModifytimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("import_goods_modifytime not between", value1, value2, "importGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsEndtimeIsNull() {
            addCriterion("import_goods_endtime is null");
            return (Criteria) this;
        }

        public Criteria andImportGoodsEndtimeIsNotNull() {
            addCriterion("import_goods_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andImportGoodsEndtimeEqualTo(Date value) {
            addCriterionForJDBCDate("import_goods_endtime =", value, "importGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsEndtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("import_goods_endtime <>", value, "importGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsEndtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("import_goods_endtime >", value, "importGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("import_goods_endtime >=", value, "importGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsEndtimeLessThan(Date value) {
            addCriterionForJDBCDate("import_goods_endtime <", value, "importGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsEndtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("import_goods_endtime <=", value, "importGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsEndtimeIn(List<Date> values) {
            addCriterionForJDBCDate("import_goods_endtime in", values, "importGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsEndtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("import_goods_endtime not in", values, "importGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsEndtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("import_goods_endtime between", value1, value2, "importGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsEndtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("import_goods_endtime not between", value1, value2, "importGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsRemarkIsNull() {
            addCriterion("import_goods_remark is null");
            return (Criteria) this;
        }

        public Criteria andImportGoodsRemarkIsNotNull() {
            addCriterion("import_goods_remark is not null");
            return (Criteria) this;
        }

        public Criteria andImportGoodsRemarkEqualTo(String value) {
            addCriterion("import_goods_remark =", value, "importGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andImportGoodsRemarkNotEqualTo(String value) {
            addCriterion("import_goods_remark <>", value, "importGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andImportGoodsRemarkGreaterThan(String value) {
            addCriterion("import_goods_remark >", value, "importGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andImportGoodsRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("import_goods_remark >=", value, "importGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andImportGoodsRemarkLessThan(String value) {
            addCriterion("import_goods_remark <", value, "importGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andImportGoodsRemarkLessThanOrEqualTo(String value) {
            addCriterion("import_goods_remark <=", value, "importGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andImportGoodsRemarkLike(String value) {
            addCriterion("import_goods_remark like", value, "importGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andImportGoodsRemarkNotLike(String value) {
            addCriterion("import_goods_remark not like", value, "importGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andImportGoodsRemarkIn(List<String> values) {
            addCriterion("import_goods_remark in", values, "importGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andImportGoodsRemarkNotIn(List<String> values) {
            addCriterion("import_goods_remark not in", values, "importGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andImportGoodsRemarkBetween(String value1, String value2) {
            addCriterion("import_goods_remark between", value1, value2, "importGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andImportGoodsRemarkNotBetween(String value1, String value2) {
            addCriterion("import_goods_remark not between", value1, value2, "importGoodsRemark");
            return (Criteria) this;
        }

        public Criteria andIsDiscountIsNull() {
            addCriterion("is_discount is null");
            return (Criteria) this;
        }

        public Criteria andIsDiscountIsNotNull() {
            addCriterion("is_discount is not null");
            return (Criteria) this;
        }

        public Criteria andIsDiscountEqualTo(String value) {
            addCriterion("is_discount =", value, "isDiscount");
            return (Criteria) this;
        }

        public Criteria andIsDiscountNotEqualTo(String value) {
            addCriterion("is_discount <>", value, "isDiscount");
            return (Criteria) this;
        }

        public Criteria andIsDiscountGreaterThan(String value) {
            addCriterion("is_discount >", value, "isDiscount");
            return (Criteria) this;
        }

        public Criteria andIsDiscountGreaterThanOrEqualTo(String value) {
            addCriterion("is_discount >=", value, "isDiscount");
            return (Criteria) this;
        }

        public Criteria andIsDiscountLessThan(String value) {
            addCriterion("is_discount <", value, "isDiscount");
            return (Criteria) this;
        }

        public Criteria andIsDiscountLessThanOrEqualTo(String value) {
            addCriterion("is_discount <=", value, "isDiscount");
            return (Criteria) this;
        }

        public Criteria andIsDiscountLike(String value) {
            addCriterion("is_discount like", value, "isDiscount");
            return (Criteria) this;
        }

        public Criteria andIsDiscountNotLike(String value) {
            addCriterion("is_discount not like", value, "isDiscount");
            return (Criteria) this;
        }

        public Criteria andIsDiscountIn(List<String> values) {
            addCriterion("is_discount in", values, "isDiscount");
            return (Criteria) this;
        }

        public Criteria andIsDiscountNotIn(List<String> values) {
            addCriterion("is_discount not in", values, "isDiscount");
            return (Criteria) this;
        }

        public Criteria andIsDiscountBetween(String value1, String value2) {
            addCriterion("is_discount between", value1, value2, "isDiscount");
            return (Criteria) this;
        }

        public Criteria andIsDiscountNotBetween(String value1, String value2) {
            addCriterion("is_discount not between", value1, value2, "isDiscount");
            return (Criteria) this;
        }

        public Criteria andIsBoxBottleIsNull() {
            addCriterion("is_box_bottle is null");
            return (Criteria) this;
        }

        public Criteria andIsBoxBottleIsNotNull() {
            addCriterion("is_box_bottle is not null");
            return (Criteria) this;
        }

        public Criteria andIsBoxBottleEqualTo(String value) {
            addCriterion("is_box_bottle =", value, "isBoxBottle");
            return (Criteria) this;
        }

        public Criteria andIsBoxBottleNotEqualTo(String value) {
            addCriterion("is_box_bottle <>", value, "isBoxBottle");
            return (Criteria) this;
        }

        public Criteria andIsBoxBottleGreaterThan(String value) {
            addCriterion("is_box_bottle >", value, "isBoxBottle");
            return (Criteria) this;
        }

        public Criteria andIsBoxBottleGreaterThanOrEqualTo(String value) {
            addCriterion("is_box_bottle >=", value, "isBoxBottle");
            return (Criteria) this;
        }

        public Criteria andIsBoxBottleLessThan(String value) {
            addCriterion("is_box_bottle <", value, "isBoxBottle");
            return (Criteria) this;
        }

        public Criteria andIsBoxBottleLessThanOrEqualTo(String value) {
            addCriterion("is_box_bottle <=", value, "isBoxBottle");
            return (Criteria) this;
        }

        public Criteria andIsBoxBottleLike(String value) {
            addCriterion("is_box_bottle like", value, "isBoxBottle");
            return (Criteria) this;
        }

        public Criteria andIsBoxBottleNotLike(String value) {
            addCriterion("is_box_bottle not like", value, "isBoxBottle");
            return (Criteria) this;
        }

        public Criteria andIsBoxBottleIn(List<String> values) {
            addCriterion("is_box_bottle in", values, "isBoxBottle");
            return (Criteria) this;
        }

        public Criteria andIsBoxBottleNotIn(List<String> values) {
            addCriterion("is_box_bottle not in", values, "isBoxBottle");
            return (Criteria) this;
        }

        public Criteria andIsBoxBottleBetween(String value1, String value2) {
            addCriterion("is_box_bottle between", value1, value2, "isBoxBottle");
            return (Criteria) this;
        }

        public Criteria andIsBoxBottleNotBetween(String value1, String value2) {
            addCriterion("is_box_bottle not between", value1, value2, "isBoxBottle");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(Long value) {
            addCriterion("total_price =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(Long value) {
            addCriterion("total_price <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(Long value) {
            addCriterion("total_price >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("total_price >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(Long value) {
            addCriterion("total_price <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(Long value) {
            addCriterion("total_price <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<Long> values) {
            addCriterion("total_price in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<Long> values) {
            addCriterion("total_price not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(Long value1, Long value2) {
            addCriterion("total_price between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(Long value1, Long value2) {
            addCriterion("total_price not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountDutyTotalPriceIsNull() {
            addCriterion("discount_duty_total_price is null");
            return (Criteria) this;
        }

        public Criteria andDiscountDutyTotalPriceIsNotNull() {
            addCriterion("discount_duty_total_price is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountDutyTotalPriceEqualTo(Long value) {
            addCriterion("discount_duty_total_price =", value, "discountDutyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountDutyTotalPriceNotEqualTo(Long value) {
            addCriterion("discount_duty_total_price <>", value, "discountDutyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountDutyTotalPriceGreaterThan(Long value) {
            addCriterion("discount_duty_total_price >", value, "discountDutyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountDutyTotalPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("discount_duty_total_price >=", value, "discountDutyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountDutyTotalPriceLessThan(Long value) {
            addCriterion("discount_duty_total_price <", value, "discountDutyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountDutyTotalPriceLessThanOrEqualTo(Long value) {
            addCriterion("discount_duty_total_price <=", value, "discountDutyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountDutyTotalPriceIn(List<Long> values) {
            addCriterion("discount_duty_total_price in", values, "discountDutyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountDutyTotalPriceNotIn(List<Long> values) {
            addCriterion("discount_duty_total_price not in", values, "discountDutyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountDutyTotalPriceBetween(Long value1, Long value2) {
            addCriterion("discount_duty_total_price between", value1, value2, "discountDutyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountDutyTotalPriceNotBetween(Long value1, Long value2) {
            addCriterion("discount_duty_total_price not between", value1, value2, "discountDutyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountTotalPriceIsNull() {
            addCriterion("discount_total_price is null");
            return (Criteria) this;
        }

        public Criteria andDiscountTotalPriceIsNotNull() {
            addCriterion("discount_total_price is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountTotalPriceEqualTo(Long value) {
            addCriterion("discount_total_price =", value, "discountTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountTotalPriceNotEqualTo(Long value) {
            addCriterion("discount_total_price <>", value, "discountTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountTotalPriceGreaterThan(Long value) {
            addCriterion("discount_total_price >", value, "discountTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountTotalPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("discount_total_price >=", value, "discountTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountTotalPriceLessThan(Long value) {
            addCriterion("discount_total_price <", value, "discountTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountTotalPriceLessThanOrEqualTo(Long value) {
            addCriterion("discount_total_price <=", value, "discountTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountTotalPriceIn(List<Long> values) {
            addCriterion("discount_total_price in", values, "discountTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountTotalPriceNotIn(List<Long> values) {
            addCriterion("discount_total_price not in", values, "discountTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountTotalPriceBetween(Long value1, Long value2) {
            addCriterion("discount_total_price between", value1, value2, "discountTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountTotalPriceNotBetween(Long value1, Long value2) {
            addCriterion("discount_total_price not between", value1, value2, "discountTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountRateIsNull() {
            addCriterion("discount_rate is null");
            return (Criteria) this;
        }

        public Criteria andDiscountRateIsNotNull() {
            addCriterion("discount_rate is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountRateEqualTo(Long value) {
            addCriterion("discount_rate =", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateNotEqualTo(Long value) {
            addCriterion("discount_rate <>", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateGreaterThan(Long value) {
            addCriterion("discount_rate >", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateGreaterThanOrEqualTo(Long value) {
            addCriterion("discount_rate >=", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateLessThan(Long value) {
            addCriterion("discount_rate <", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateLessThanOrEqualTo(Long value) {
            addCriterion("discount_rate <=", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateIn(List<Long> values) {
            addCriterion("discount_rate in", values, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateNotIn(List<Long> values) {
            addCriterion("discount_rate not in", values, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateBetween(Long value1, Long value2) {
            addCriterion("discount_rate between", value1, value2, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateNotBetween(Long value1, Long value2) {
            addCriterion("discount_rate not between", value1, value2, "discountRate");
            return (Criteria) this;
        }

        public Criteria andBoxBottlePriceIsNull() {
            addCriterion("box_bottle_price is null");
            return (Criteria) this;
        }

        public Criteria andBoxBottlePriceIsNotNull() {
            addCriterion("box_bottle_price is not null");
            return (Criteria) this;
        }

        public Criteria andBoxBottlePriceEqualTo(Long value) {
            addCriterion("box_bottle_price =", value, "boxBottlePrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottlePriceNotEqualTo(Long value) {
            addCriterion("box_bottle_price <>", value, "boxBottlePrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottlePriceGreaterThan(Long value) {
            addCriterion("box_bottle_price >", value, "boxBottlePrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottlePriceGreaterThanOrEqualTo(Long value) {
            addCriterion("box_bottle_price >=", value, "boxBottlePrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottlePriceLessThan(Long value) {
            addCriterion("box_bottle_price <", value, "boxBottlePrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottlePriceLessThanOrEqualTo(Long value) {
            addCriterion("box_bottle_price <=", value, "boxBottlePrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottlePriceIn(List<Long> values) {
            addCriterion("box_bottle_price in", values, "boxBottlePrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottlePriceNotIn(List<Long> values) {
            addCriterion("box_bottle_price not in", values, "boxBottlePrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottlePriceBetween(Long value1, Long value2) {
            addCriterion("box_bottle_price between", value1, value2, "boxBottlePrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottlePriceNotBetween(Long value1, Long value2) {
            addCriterion("box_bottle_price not between", value1, value2, "boxBottlePrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottleTotalPriceIsNull() {
            addCriterion("box_bottle_total_price is null");
            return (Criteria) this;
        }

        public Criteria andBoxBottleTotalPriceIsNotNull() {
            addCriterion("box_bottle_total_price is not null");
            return (Criteria) this;
        }

        public Criteria andBoxBottleTotalPriceEqualTo(Long value) {
            addCriterion("box_bottle_total_price =", value, "boxBottleTotalPrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottleTotalPriceNotEqualTo(Long value) {
            addCriterion("box_bottle_total_price <>", value, "boxBottleTotalPrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottleTotalPriceGreaterThan(Long value) {
            addCriterion("box_bottle_total_price >", value, "boxBottleTotalPrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottleTotalPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("box_bottle_total_price >=", value, "boxBottleTotalPrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottleTotalPriceLessThan(Long value) {
            addCriterion("box_bottle_total_price <", value, "boxBottleTotalPrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottleTotalPriceLessThanOrEqualTo(Long value) {
            addCriterion("box_bottle_total_price <=", value, "boxBottleTotalPrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottleTotalPriceIn(List<Long> values) {
            addCriterion("box_bottle_total_price in", values, "boxBottleTotalPrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottleTotalPriceNotIn(List<Long> values) {
            addCriterion("box_bottle_total_price not in", values, "boxBottleTotalPrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottleTotalPriceBetween(Long value1, Long value2) {
            addCriterion("box_bottle_total_price between", value1, value2, "boxBottleTotalPrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottleTotalPriceNotBetween(Long value1, Long value2) {
            addCriterion("box_bottle_total_price not between", value1, value2, "boxBottleTotalPrice");
            return (Criteria) this;
        }

        public Criteria andResImportGoodsAmountIsNull() {
            addCriterion("res_import_goods_amount is null");
            return (Criteria) this;
        }

        public Criteria andResImportGoodsAmountIsNotNull() {
            addCriterion("res_import_goods_amount is not null");
            return (Criteria) this;
        }

        public Criteria andResImportGoodsAmountEqualTo(Integer value) {
            addCriterion("res_import_goods_amount =", value, "resImportGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andResImportGoodsAmountNotEqualTo(Integer value) {
            addCriterion("res_import_goods_amount <>", value, "resImportGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andResImportGoodsAmountGreaterThan(Integer value) {
            addCriterion("res_import_goods_amount >", value, "resImportGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andResImportGoodsAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("res_import_goods_amount >=", value, "resImportGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andResImportGoodsAmountLessThan(Integer value) {
            addCriterion("res_import_goods_amount <", value, "resImportGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andResImportGoodsAmountLessThanOrEqualTo(Integer value) {
            addCriterion("res_import_goods_amount <=", value, "resImportGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andResImportGoodsAmountIn(List<Integer> values) {
            addCriterion("res_import_goods_amount in", values, "resImportGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andResImportGoodsAmountNotIn(List<Integer> values) {
            addCriterion("res_import_goods_amount not in", values, "resImportGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andResImportGoodsAmountBetween(Integer value1, Integer value2) {
            addCriterion("res_import_goods_amount between", value1, value2, "resImportGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andResImportGoodsAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("res_import_goods_amount not between", value1, value2, "resImportGoodsAmount");
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