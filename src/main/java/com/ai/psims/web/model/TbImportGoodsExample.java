package com.ai.psims.web.model;

import java.util.ArrayList;
import java.util.Date;
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

        public Criteria andImportGoodsPriceIsNull() {
            addCriterion("import_goods_price is null");
            return (Criteria) this;
        }

        public Criteria andImportGoodsPriceIsNotNull() {
            addCriterion("import_goods_price is not null");
            return (Criteria) this;
        }

        public Criteria andImportGoodsPriceEqualTo(String value) {
            addCriterion("import_goods_price =", value, "importGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsPriceNotEqualTo(String value) {
            addCriterion("import_goods_price <>", value, "importGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsPriceGreaterThan(String value) {
            addCriterion("import_goods_price >", value, "importGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsPriceGreaterThanOrEqualTo(String value) {
            addCriterion("import_goods_price >=", value, "importGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsPriceLessThan(String value) {
            addCriterion("import_goods_price <", value, "importGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsPriceLessThanOrEqualTo(String value) {
            addCriterion("import_goods_price <=", value, "importGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsPriceLike(String value) {
            addCriterion("import_goods_price like", value, "importGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsPriceNotLike(String value) {
            addCriterion("import_goods_price not like", value, "importGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsPriceIn(List<String> values) {
            addCriterion("import_goods_price in", values, "importGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsPriceNotIn(List<String> values) {
            addCriterion("import_goods_price not in", values, "importGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsPriceBetween(String value1, String value2) {
            addCriterion("import_goods_price between", value1, value2, "importGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsPriceNotBetween(String value1, String value2) {
            addCriterion("import_goods_price not between", value1, value2, "importGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andImportDiscountRateIsNull() {
            addCriterion("import_discount_rate is null");
            return (Criteria) this;
        }

        public Criteria andImportDiscountRateIsNotNull() {
            addCriterion("import_discount_rate is not null");
            return (Criteria) this;
        }

        public Criteria andImportDiscountRateEqualTo(String value) {
            addCriterion("import_discount_rate =", value, "importDiscountRate");
            return (Criteria) this;
        }

        public Criteria andImportDiscountRateNotEqualTo(String value) {
            addCriterion("import_discount_rate <>", value, "importDiscountRate");
            return (Criteria) this;
        }

        public Criteria andImportDiscountRateGreaterThan(String value) {
            addCriterion("import_discount_rate >", value, "importDiscountRate");
            return (Criteria) this;
        }

        public Criteria andImportDiscountRateGreaterThanOrEqualTo(String value) {
            addCriterion("import_discount_rate >=", value, "importDiscountRate");
            return (Criteria) this;
        }

        public Criteria andImportDiscountRateLessThan(String value) {
            addCriterion("import_discount_rate <", value, "importDiscountRate");
            return (Criteria) this;
        }

        public Criteria andImportDiscountRateLessThanOrEqualTo(String value) {
            addCriterion("import_discount_rate <=", value, "importDiscountRate");
            return (Criteria) this;
        }

        public Criteria andImportDiscountRateLike(String value) {
            addCriterion("import_discount_rate like", value, "importDiscountRate");
            return (Criteria) this;
        }

        public Criteria andImportDiscountRateNotLike(String value) {
            addCriterion("import_discount_rate not like", value, "importDiscountRate");
            return (Criteria) this;
        }

        public Criteria andImportDiscountRateIn(List<String> values) {
            addCriterion("import_discount_rate in", values, "importDiscountRate");
            return (Criteria) this;
        }

        public Criteria andImportDiscountRateNotIn(List<String> values) {
            addCriterion("import_discount_rate not in", values, "importDiscountRate");
            return (Criteria) this;
        }

        public Criteria andImportDiscountRateBetween(String value1, String value2) {
            addCriterion("import_discount_rate between", value1, value2, "importDiscountRate");
            return (Criteria) this;
        }

        public Criteria andImportDiscountRateNotBetween(String value1, String value2) {
            addCriterion("import_discount_rate not between", value1, value2, "importDiscountRate");
            return (Criteria) this;
        }

        public Criteria andImportDiscountPriceIsNull() {
            addCriterion("import_discount_price is null");
            return (Criteria) this;
        }

        public Criteria andImportDiscountPriceIsNotNull() {
            addCriterion("import_discount_price is not null");
            return (Criteria) this;
        }

        public Criteria andImportDiscountPriceEqualTo(String value) {
            addCriterion("import_discount_price =", value, "importDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andImportDiscountPriceNotEqualTo(String value) {
            addCriterion("import_discount_price <>", value, "importDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andImportDiscountPriceGreaterThan(String value) {
            addCriterion("import_discount_price >", value, "importDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andImportDiscountPriceGreaterThanOrEqualTo(String value) {
            addCriterion("import_discount_price >=", value, "importDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andImportDiscountPriceLessThan(String value) {
            addCriterion("import_discount_price <", value, "importDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andImportDiscountPriceLessThanOrEqualTo(String value) {
            addCriterion("import_discount_price <=", value, "importDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andImportDiscountPriceLike(String value) {
            addCriterion("import_discount_price like", value, "importDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andImportDiscountPriceNotLike(String value) {
            addCriterion("import_discount_price not like", value, "importDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andImportDiscountPriceIn(List<String> values) {
            addCriterion("import_discount_price in", values, "importDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andImportDiscountPriceNotIn(List<String> values) {
            addCriterion("import_discount_price not in", values, "importDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andImportDiscountPriceBetween(String value1, String value2) {
            addCriterion("import_discount_price between", value1, value2, "importDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andImportDiscountPriceNotBetween(String value1, String value2) {
            addCriterion("import_discount_price not between", value1, value2, "importDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsTotalPriceIsNull() {
            addCriterion("import_goods_total_price is null");
            return (Criteria) this;
        }

        public Criteria andImportGoodsTotalPriceIsNotNull() {
            addCriterion("import_goods_total_price is not null");
            return (Criteria) this;
        }

        public Criteria andImportGoodsTotalPriceEqualTo(String value) {
            addCriterion("import_goods_total_price =", value, "importGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsTotalPriceNotEqualTo(String value) {
            addCriterion("import_goods_total_price <>", value, "importGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsTotalPriceGreaterThan(String value) {
            addCriterion("import_goods_total_price >", value, "importGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsTotalPriceGreaterThanOrEqualTo(String value) {
            addCriterion("import_goods_total_price >=", value, "importGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsTotalPriceLessThan(String value) {
            addCriterion("import_goods_total_price <", value, "importGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsTotalPriceLessThanOrEqualTo(String value) {
            addCriterion("import_goods_total_price <=", value, "importGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsTotalPriceLike(String value) {
            addCriterion("import_goods_total_price like", value, "importGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsTotalPriceNotLike(String value) {
            addCriterion("import_goods_total_price not like", value, "importGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsTotalPriceIn(List<String> values) {
            addCriterion("import_goods_total_price in", values, "importGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsTotalPriceNotIn(List<String> values) {
            addCriterion("import_goods_total_price not in", values, "importGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsTotalPriceBetween(String value1, String value2) {
            addCriterion("import_goods_total_price between", value1, value2, "importGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportGoodsTotalPriceNotBetween(String value1, String value2) {
            addCriterion("import_goods_total_price not between", value1, value2, "importGoodsTotalPrice");
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

        public Criteria andDiscountDutyTotalPriceEqualTo(String value) {
            addCriterion("discount_duty_total_price =", value, "discountDutyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountDutyTotalPriceNotEqualTo(String value) {
            addCriterion("discount_duty_total_price <>", value, "discountDutyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountDutyTotalPriceGreaterThan(String value) {
            addCriterion("discount_duty_total_price >", value, "discountDutyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountDutyTotalPriceGreaterThanOrEqualTo(String value) {
            addCriterion("discount_duty_total_price >=", value, "discountDutyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountDutyTotalPriceLessThan(String value) {
            addCriterion("discount_duty_total_price <", value, "discountDutyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountDutyTotalPriceLessThanOrEqualTo(String value) {
            addCriterion("discount_duty_total_price <=", value, "discountDutyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountDutyTotalPriceLike(String value) {
            addCriterion("discount_duty_total_price like", value, "discountDutyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountDutyTotalPriceNotLike(String value) {
            addCriterion("discount_duty_total_price not like", value, "discountDutyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountDutyTotalPriceIn(List<String> values) {
            addCriterion("discount_duty_total_price in", values, "discountDutyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountDutyTotalPriceNotIn(List<String> values) {
            addCriterion("discount_duty_total_price not in", values, "discountDutyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountDutyTotalPriceBetween(String value1, String value2) {
            addCriterion("discount_duty_total_price between", value1, value2, "discountDutyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountDutyTotalPriceNotBetween(String value1, String value2) {
            addCriterion("discount_duty_total_price not between", value1, value2, "discountDutyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountGoodsTotalPriceIsNull() {
            addCriterion("discount_goods_total_price is null");
            return (Criteria) this;
        }

        public Criteria andDiscountGoodsTotalPriceIsNotNull() {
            addCriterion("discount_goods_total_price is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountGoodsTotalPriceEqualTo(String value) {
            addCriterion("discount_goods_total_price =", value, "discountGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountGoodsTotalPriceNotEqualTo(String value) {
            addCriterion("discount_goods_total_price <>", value, "discountGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountGoodsTotalPriceGreaterThan(String value) {
            addCriterion("discount_goods_total_price >", value, "discountGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountGoodsTotalPriceGreaterThanOrEqualTo(String value) {
            addCriterion("discount_goods_total_price >=", value, "discountGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountGoodsTotalPriceLessThan(String value) {
            addCriterion("discount_goods_total_price <", value, "discountGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountGoodsTotalPriceLessThanOrEqualTo(String value) {
            addCriterion("discount_goods_total_price <=", value, "discountGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountGoodsTotalPriceLike(String value) {
            addCriterion("discount_goods_total_price like", value, "discountGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountGoodsTotalPriceNotLike(String value) {
            addCriterion("discount_goods_total_price not like", value, "discountGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountGoodsTotalPriceIn(List<String> values) {
            addCriterion("discount_goods_total_price in", values, "discountGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountGoodsTotalPriceNotIn(List<String> values) {
            addCriterion("discount_goods_total_price not in", values, "discountGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountGoodsTotalPriceBetween(String value1, String value2) {
            addCriterion("discount_goods_total_price between", value1, value2, "discountGoodsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountGoodsTotalPriceNotBetween(String value1, String value2) {
            addCriterion("discount_goods_total_price not between", value1, value2, "discountGoodsTotalPrice");
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
            addCriterion("import_goods_createtime =", value, "importGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsCreatetimeNotEqualTo(Date value) {
            addCriterion("import_goods_createtime <>", value, "importGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsCreatetimeGreaterThan(Date value) {
            addCriterion("import_goods_createtime >", value, "importGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("import_goods_createtime >=", value, "importGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsCreatetimeLessThan(Date value) {
            addCriterion("import_goods_createtime <", value, "importGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("import_goods_createtime <=", value, "importGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsCreatetimeIn(List<Date> values) {
            addCriterion("import_goods_createtime in", values, "importGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsCreatetimeNotIn(List<Date> values) {
            addCriterion("import_goods_createtime not in", values, "importGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsCreatetimeBetween(Date value1, Date value2) {
            addCriterion("import_goods_createtime between", value1, value2, "importGoodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("import_goods_createtime not between", value1, value2, "importGoodsCreatetime");
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
            addCriterion("import_goods_modifytime =", value, "importGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsModifytimeNotEqualTo(Date value) {
            addCriterion("import_goods_modifytime <>", value, "importGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsModifytimeGreaterThan(Date value) {
            addCriterion("import_goods_modifytime >", value, "importGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsModifytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("import_goods_modifytime >=", value, "importGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsModifytimeLessThan(Date value) {
            addCriterion("import_goods_modifytime <", value, "importGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsModifytimeLessThanOrEqualTo(Date value) {
            addCriterion("import_goods_modifytime <=", value, "importGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsModifytimeIn(List<Date> values) {
            addCriterion("import_goods_modifytime in", values, "importGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsModifytimeNotIn(List<Date> values) {
            addCriterion("import_goods_modifytime not in", values, "importGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsModifytimeBetween(Date value1, Date value2) {
            addCriterion("import_goods_modifytime between", value1, value2, "importGoodsModifytime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsModifytimeNotBetween(Date value1, Date value2) {
            addCriterion("import_goods_modifytime not between", value1, value2, "importGoodsModifytime");
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
            addCriterion("import_goods_endtime =", value, "importGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsEndtimeNotEqualTo(Date value) {
            addCriterion("import_goods_endtime <>", value, "importGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsEndtimeGreaterThan(Date value) {
            addCriterion("import_goods_endtime >", value, "importGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("import_goods_endtime >=", value, "importGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsEndtimeLessThan(Date value) {
            addCriterion("import_goods_endtime <", value, "importGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("import_goods_endtime <=", value, "importGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsEndtimeIn(List<Date> values) {
            addCriterion("import_goods_endtime in", values, "importGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsEndtimeNotIn(List<Date> values) {
            addCriterion("import_goods_endtime not in", values, "importGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsEndtimeBetween(Date value1, Date value2) {
            addCriterion("import_goods_endtime between", value1, value2, "importGoodsEndtime");
            return (Criteria) this;
        }

        public Criteria andImportGoodsEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("import_goods_endtime not between", value1, value2, "importGoodsEndtime");
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

        public Criteria andImportIdIsNull() {
            addCriterion("import_id is null");
            return (Criteria) this;
        }

        public Criteria andImportIdIsNotNull() {
            addCriterion("import_id is not null");
            return (Criteria) this;
        }

        public Criteria andImportIdEqualTo(Integer value) {
            addCriterion("import_id =", value, "importId");
            return (Criteria) this;
        }

        public Criteria andImportIdNotEqualTo(Integer value) {
            addCriterion("import_id <>", value, "importId");
            return (Criteria) this;
        }

        public Criteria andImportIdGreaterThan(Integer value) {
            addCriterion("import_id >", value, "importId");
            return (Criteria) this;
        }

        public Criteria andImportIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("import_id >=", value, "importId");
            return (Criteria) this;
        }

        public Criteria andImportIdLessThan(Integer value) {
            addCriterion("import_id <", value, "importId");
            return (Criteria) this;
        }

        public Criteria andImportIdLessThanOrEqualTo(Integer value) {
            addCriterion("import_id <=", value, "importId");
            return (Criteria) this;
        }

        public Criteria andImportIdIn(List<Integer> values) {
            addCriterion("import_id in", values, "importId");
            return (Criteria) this;
        }

        public Criteria andImportIdNotIn(List<Integer> values) {
            addCriterion("import_id not in", values, "importId");
            return (Criteria) this;
        }

        public Criteria andImportIdBetween(Integer value1, Integer value2) {
            addCriterion("import_id between", value1, value2, "importId");
            return (Criteria) this;
        }

        public Criteria andImportIdNotBetween(Integer value1, Integer value2) {
            addCriterion("import_id not between", value1, value2, "importId");
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
            addCriterion("import_datetime =", value, "importDatetime");
            return (Criteria) this;
        }

        public Criteria andImportDatetimeNotEqualTo(Date value) {
            addCriterion("import_datetime <>", value, "importDatetime");
            return (Criteria) this;
        }

        public Criteria andImportDatetimeGreaterThan(Date value) {
            addCriterion("import_datetime >", value, "importDatetime");
            return (Criteria) this;
        }

        public Criteria andImportDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("import_datetime >=", value, "importDatetime");
            return (Criteria) this;
        }

        public Criteria andImportDatetimeLessThan(Date value) {
            addCriterion("import_datetime <", value, "importDatetime");
            return (Criteria) this;
        }

        public Criteria andImportDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("import_datetime <=", value, "importDatetime");
            return (Criteria) this;
        }

        public Criteria andImportDatetimeIn(List<Date> values) {
            addCriterion("import_datetime in", values, "importDatetime");
            return (Criteria) this;
        }

        public Criteria andImportDatetimeNotIn(List<Date> values) {
            addCriterion("import_datetime not in", values, "importDatetime");
            return (Criteria) this;
        }

        public Criteria andImportDatetimeBetween(Date value1, Date value2) {
            addCriterion("import_datetime between", value1, value2, "importDatetime");
            return (Criteria) this;
        }

        public Criteria andImportDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("import_datetime not between", value1, value2, "importDatetime");
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

        public Criteria andImportTotalPriceEqualTo(String value) {
            addCriterion("import_total_price =", value, "importTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportTotalPriceNotEqualTo(String value) {
            addCriterion("import_total_price <>", value, "importTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportTotalPriceGreaterThan(String value) {
            addCriterion("import_total_price >", value, "importTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportTotalPriceGreaterThanOrEqualTo(String value) {
            addCriterion("import_total_price >=", value, "importTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportTotalPriceLessThan(String value) {
            addCriterion("import_total_price <", value, "importTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportTotalPriceLessThanOrEqualTo(String value) {
            addCriterion("import_total_price <=", value, "importTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportTotalPriceLike(String value) {
            addCriterion("import_total_price like", value, "importTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportTotalPriceNotLike(String value) {
            addCriterion("import_total_price not like", value, "importTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportTotalPriceIn(List<String> values) {
            addCriterion("import_total_price in", values, "importTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportTotalPriceNotIn(List<String> values) {
            addCriterion("import_total_price not in", values, "importTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportTotalPriceBetween(String value1, String value2) {
            addCriterion("import_total_price between", value1, value2, "importTotalPrice");
            return (Criteria) this;
        }

        public Criteria andImportTotalPriceNotBetween(String value1, String value2) {
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
            addCriterion("payment_time =", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotEqualTo(Date value) {
            addCriterion("payment_time <>", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeGreaterThan(Date value) {
            addCriterion("payment_time >", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("payment_time >=", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeLessThan(Date value) {
            addCriterion("payment_time <", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeLessThanOrEqualTo(Date value) {
            addCriterion("payment_time <=", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIn(List<Date> values) {
            addCriterion("payment_time in", values, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotIn(List<Date> values) {
            addCriterion("payment_time not in", values, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeBetween(Date value1, Date value2) {
            addCriterion("payment_time between", value1, value2, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotBetween(Date value1, Date value2) {
            addCriterion("payment_time not between", value1, value2, "paymentTime");
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

        public Criteria andBoxBottlePriceIsNull() {
            addCriterion("box_bottle_price is null");
            return (Criteria) this;
        }

        public Criteria andBoxBottlePriceIsNotNull() {
            addCriterion("box_bottle_price is not null");
            return (Criteria) this;
        }

        public Criteria andBoxBottlePriceEqualTo(String value) {
            addCriterion("box_bottle_price =", value, "boxBottlePrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottlePriceNotEqualTo(String value) {
            addCriterion("box_bottle_price <>", value, "boxBottlePrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottlePriceGreaterThan(String value) {
            addCriterion("box_bottle_price >", value, "boxBottlePrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottlePriceGreaterThanOrEqualTo(String value) {
            addCriterion("box_bottle_price >=", value, "boxBottlePrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottlePriceLessThan(String value) {
            addCriterion("box_bottle_price <", value, "boxBottlePrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottlePriceLessThanOrEqualTo(String value) {
            addCriterion("box_bottle_price <=", value, "boxBottlePrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottlePriceLike(String value) {
            addCriterion("box_bottle_price like", value, "boxBottlePrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottlePriceNotLike(String value) {
            addCriterion("box_bottle_price not like", value, "boxBottlePrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottlePriceIn(List<String> values) {
            addCriterion("box_bottle_price in", values, "boxBottlePrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottlePriceNotIn(List<String> values) {
            addCriterion("box_bottle_price not in", values, "boxBottlePrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottlePriceBetween(String value1, String value2) {
            addCriterion("box_bottle_price between", value1, value2, "boxBottlePrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottlePriceNotBetween(String value1, String value2) {
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

        public Criteria andBoxBottleTotalPriceEqualTo(String value) {
            addCriterion("box_bottle_total_price =", value, "boxBottleTotalPrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottleTotalPriceNotEqualTo(String value) {
            addCriterion("box_bottle_total_price <>", value, "boxBottleTotalPrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottleTotalPriceGreaterThan(String value) {
            addCriterion("box_bottle_total_price >", value, "boxBottleTotalPrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottleTotalPriceGreaterThanOrEqualTo(String value) {
            addCriterion("box_bottle_total_price >=", value, "boxBottleTotalPrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottleTotalPriceLessThan(String value) {
            addCriterion("box_bottle_total_price <", value, "boxBottleTotalPrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottleTotalPriceLessThanOrEqualTo(String value) {
            addCriterion("box_bottle_total_price <=", value, "boxBottleTotalPrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottleTotalPriceLike(String value) {
            addCriterion("box_bottle_total_price like", value, "boxBottleTotalPrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottleTotalPriceNotLike(String value) {
            addCriterion("box_bottle_total_price not like", value, "boxBottleTotalPrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottleTotalPriceIn(List<String> values) {
            addCriterion("box_bottle_total_price in", values, "boxBottleTotalPrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottleTotalPriceNotIn(List<String> values) {
            addCriterion("box_bottle_total_price not in", values, "boxBottleTotalPrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottleTotalPriceBetween(String value1, String value2) {
            addCriterion("box_bottle_total_price between", value1, value2, "boxBottleTotalPrice");
            return (Criteria) this;
        }

        public Criteria andBoxBottleTotalPriceNotBetween(String value1, String value2) {
            addCriterion("box_bottle_total_price not between", value1, value2, "boxBottleTotalPrice");
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