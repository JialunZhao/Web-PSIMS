package com.ai.psims.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
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

        public Criteria andGoodsProfitIsNull() {
            addCriterion("goods_profit is null");
            return (Criteria) this;
        }

        public Criteria andGoodsProfitIsNotNull() {
            addCriterion("goods_profit is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsProfitEqualTo(Long value) {
            addCriterion("goods_profit =", value, "goodsProfit");
            return (Criteria) this;
        }

        public Criteria andGoodsProfitNotEqualTo(Long value) {
            addCriterion("goods_profit <>", value, "goodsProfit");
            return (Criteria) this;
        }

        public Criteria andGoodsProfitGreaterThan(Long value) {
            addCriterion("goods_profit >", value, "goodsProfit");
            return (Criteria) this;
        }

        public Criteria andGoodsProfitGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_profit >=", value, "goodsProfit");
            return (Criteria) this;
        }

        public Criteria andGoodsProfitLessThan(Long value) {
            addCriterion("goods_profit <", value, "goodsProfit");
            return (Criteria) this;
        }

        public Criteria andGoodsProfitLessThanOrEqualTo(Long value) {
            addCriterion("goods_profit <=", value, "goodsProfit");
            return (Criteria) this;
        }

        public Criteria andGoodsProfitIn(List<Long> values) {
            addCriterion("goods_profit in", values, "goodsProfit");
            return (Criteria) this;
        }

        public Criteria andGoodsProfitNotIn(List<Long> values) {
            addCriterion("goods_profit not in", values, "goodsProfit");
            return (Criteria) this;
        }

        public Criteria andGoodsProfitBetween(Long value1, Long value2) {
            addCriterion("goods_profit between", value1, value2, "goodsProfit");
            return (Criteria) this;
        }

        public Criteria andGoodsProfitNotBetween(Long value1, Long value2) {
            addCriterion("goods_profit not between", value1, value2, "goodsProfit");
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

        public Criteria andGoodsDiscountAmountIsNull() {
            addCriterion("goods_discount_amount is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountAmountIsNotNull() {
            addCriterion("goods_discount_amount is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountAmountEqualTo(Long value) {
            addCriterion("goods_discount_amount =", value, "goodsDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountAmountNotEqualTo(Long value) {
            addCriterion("goods_discount_amount <>", value, "goodsDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountAmountGreaterThan(Long value) {
            addCriterion("goods_discount_amount >", value, "goodsDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_discount_amount >=", value, "goodsDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountAmountLessThan(Long value) {
            addCriterion("goods_discount_amount <", value, "goodsDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountAmountLessThanOrEqualTo(Long value) {
            addCriterion("goods_discount_amount <=", value, "goodsDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountAmountIn(List<Long> values) {
            addCriterion("goods_discount_amount in", values, "goodsDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountAmountNotIn(List<Long> values) {
            addCriterion("goods_discount_amount not in", values, "goodsDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountAmountBetween(Long value1, Long value2) {
            addCriterion("goods_discount_amount between", value1, value2, "goodsDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountAmountNotBetween(Long value1, Long value2) {
            addCriterion("goods_discount_amount not between", value1, value2, "goodsDiscountAmount");
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
            addCriterionForJDBCDate("goods_createtime =", value, "goodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("goods_createtime <>", value, "goodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("goods_createtime >", value, "goodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("goods_createtime >=", value, "goodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatetimeLessThan(Date value) {
            addCriterionForJDBCDate("goods_createtime <", value, "goodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("goods_createtime <=", value, "goodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("goods_createtime in", values, "goodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("goods_createtime not in", values, "goodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("goods_createtime between", value1, value2, "goodsCreatetime");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("goods_createtime not between", value1, value2, "goodsCreatetime");
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
            addCriterionForJDBCDate("goods_modifytime =", value, "goodsModifytime");
            return (Criteria) this;
        }

        public Criteria andGoodsModifytimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("goods_modifytime <>", value, "goodsModifytime");
            return (Criteria) this;
        }

        public Criteria andGoodsModifytimeGreaterThan(Date value) {
            addCriterionForJDBCDate("goods_modifytime >", value, "goodsModifytime");
            return (Criteria) this;
        }

        public Criteria andGoodsModifytimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("goods_modifytime >=", value, "goodsModifytime");
            return (Criteria) this;
        }

        public Criteria andGoodsModifytimeLessThan(Date value) {
            addCriterionForJDBCDate("goods_modifytime <", value, "goodsModifytime");
            return (Criteria) this;
        }

        public Criteria andGoodsModifytimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("goods_modifytime <=", value, "goodsModifytime");
            return (Criteria) this;
        }

        public Criteria andGoodsModifytimeIn(List<Date> values) {
            addCriterionForJDBCDate("goods_modifytime in", values, "goodsModifytime");
            return (Criteria) this;
        }

        public Criteria andGoodsModifytimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("goods_modifytime not in", values, "goodsModifytime");
            return (Criteria) this;
        }

        public Criteria andGoodsModifytimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("goods_modifytime between", value1, value2, "goodsModifytime");
            return (Criteria) this;
        }

        public Criteria andGoodsModifytimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("goods_modifytime not between", value1, value2, "goodsModifytime");
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
            addCriterionForJDBCDate("goods_endtime =", value, "goodsEndtime");
            return (Criteria) this;
        }

        public Criteria andGoodsEndtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("goods_endtime <>", value, "goodsEndtime");
            return (Criteria) this;
        }

        public Criteria andGoodsEndtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("goods_endtime >", value, "goodsEndtime");
            return (Criteria) this;
        }

        public Criteria andGoodsEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("goods_endtime >=", value, "goodsEndtime");
            return (Criteria) this;
        }

        public Criteria andGoodsEndtimeLessThan(Date value) {
            addCriterionForJDBCDate("goods_endtime <", value, "goodsEndtime");
            return (Criteria) this;
        }

        public Criteria andGoodsEndtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("goods_endtime <=", value, "goodsEndtime");
            return (Criteria) this;
        }

        public Criteria andGoodsEndtimeIn(List<Date> values) {
            addCriterionForJDBCDate("goods_endtime in", values, "goodsEndtime");
            return (Criteria) this;
        }

        public Criteria andGoodsEndtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("goods_endtime not in", values, "goodsEndtime");
            return (Criteria) this;
        }

        public Criteria andGoodsEndtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("goods_endtime between", value1, value2, "goodsEndtime");
            return (Criteria) this;
        }

        public Criteria andGoodsEndtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("goods_endtime not between", value1, value2, "goodsEndtime");
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

        public Criteria andGoodsDiscountEqualTo(Integer value) {
            addCriterion("goods_discount =", value, "goodsDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountNotEqualTo(Integer value) {
            addCriterion("goods_discount <>", value, "goodsDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountGreaterThan(Integer value) {
            addCriterion("goods_discount >", value, "goodsDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_discount >=", value, "goodsDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountLessThan(Integer value) {
            addCriterion("goods_discount <", value, "goodsDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountLessThanOrEqualTo(Integer value) {
            addCriterion("goods_discount <=", value, "goodsDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountIn(List<Integer> values) {
            addCriterion("goods_discount in", values, "goodsDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountNotIn(List<Integer> values) {
            addCriterion("goods_discount not in", values, "goodsDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountBetween(Integer value1, Integer value2) {
            addCriterion("goods_discount between", value1, value2, "goodsDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodsDiscountNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_discount not between", value1, value2, "goodsDiscount");
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

        public Criteria andQuarterRebateEqualTo(Long value) {
            addCriterion("quarter_rebate =", value, "quarterRebate");
            return (Criteria) this;
        }

        public Criteria andQuarterRebateNotEqualTo(Long value) {
            addCriterion("quarter_rebate <>", value, "quarterRebate");
            return (Criteria) this;
        }

        public Criteria andQuarterRebateGreaterThan(Long value) {
            addCriterion("quarter_rebate >", value, "quarterRebate");
            return (Criteria) this;
        }

        public Criteria andQuarterRebateGreaterThanOrEqualTo(Long value) {
            addCriterion("quarter_rebate >=", value, "quarterRebate");
            return (Criteria) this;
        }

        public Criteria andQuarterRebateLessThan(Long value) {
            addCriterion("quarter_rebate <", value, "quarterRebate");
            return (Criteria) this;
        }

        public Criteria andQuarterRebateLessThanOrEqualTo(Long value) {
            addCriterion("quarter_rebate <=", value, "quarterRebate");
            return (Criteria) this;
        }

        public Criteria andQuarterRebateIn(List<Long> values) {
            addCriterion("quarter_rebate in", values, "quarterRebate");
            return (Criteria) this;
        }

        public Criteria andQuarterRebateNotIn(List<Long> values) {
            addCriterion("quarter_rebate not in", values, "quarterRebate");
            return (Criteria) this;
        }

        public Criteria andQuarterRebateBetween(Long value1, Long value2) {
            addCriterion("quarter_rebate between", value1, value2, "quarterRebate");
            return (Criteria) this;
        }

        public Criteria andQuarterRebateNotBetween(Long value1, Long value2) {
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

        public Criteria andAnnualRebateEqualTo(Long value) {
            addCriterion("annual_rebate =", value, "annualRebate");
            return (Criteria) this;
        }

        public Criteria andAnnualRebateNotEqualTo(Long value) {
            addCriterion("annual_rebate <>", value, "annualRebate");
            return (Criteria) this;
        }

        public Criteria andAnnualRebateGreaterThan(Long value) {
            addCriterion("annual_rebate >", value, "annualRebate");
            return (Criteria) this;
        }

        public Criteria andAnnualRebateGreaterThanOrEqualTo(Long value) {
            addCriterion("annual_rebate >=", value, "annualRebate");
            return (Criteria) this;
        }

        public Criteria andAnnualRebateLessThan(Long value) {
            addCriterion("annual_rebate <", value, "annualRebate");
            return (Criteria) this;
        }

        public Criteria andAnnualRebateLessThanOrEqualTo(Long value) {
            addCriterion("annual_rebate <=", value, "annualRebate");
            return (Criteria) this;
        }

        public Criteria andAnnualRebateIn(List<Long> values) {
            addCriterion("annual_rebate in", values, "annualRebate");
            return (Criteria) this;
        }

        public Criteria andAnnualRebateNotIn(List<Long> values) {
            addCriterion("annual_rebate not in", values, "annualRebate");
            return (Criteria) this;
        }

        public Criteria andAnnualRebateBetween(Long value1, Long value2) {
            addCriterion("annual_rebate between", value1, value2, "annualRebate");
            return (Criteria) this;
        }

        public Criteria andAnnualRebateNotBetween(Long value1, Long value2) {
            addCriterion("annual_rebate not between", value1, value2, "annualRebate");
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

        public Criteria andProviderSubsidyEqualTo(Long value) {
            addCriterion("provider_subsidy =", value, "providerSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderSubsidyNotEqualTo(Long value) {
            addCriterion("provider_subsidy <>", value, "providerSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderSubsidyGreaterThan(Long value) {
            addCriterion("provider_subsidy >", value, "providerSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderSubsidyGreaterThanOrEqualTo(Long value) {
            addCriterion("provider_subsidy >=", value, "providerSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderSubsidyLessThan(Long value) {
            addCriterion("provider_subsidy <", value, "providerSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderSubsidyLessThanOrEqualTo(Long value) {
            addCriterion("provider_subsidy <=", value, "providerSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderSubsidyIn(List<Long> values) {
            addCriterion("provider_subsidy in", values, "providerSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderSubsidyNotIn(List<Long> values) {
            addCriterion("provider_subsidy not in", values, "providerSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderSubsidyBetween(Long value1, Long value2) {
            addCriterion("provider_subsidy between", value1, value2, "providerSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderSubsidyNotBetween(Long value1, Long value2) {
            addCriterion("provider_subsidy not between", value1, value2, "providerSubsidy");
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

        public Criteria andProviderPackageSubsidyEqualTo(Long value) {
            addCriterion("provider_package_subsidy =", value, "providerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderPackageSubsidyNotEqualTo(Long value) {
            addCriterion("provider_package_subsidy <>", value, "providerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderPackageSubsidyGreaterThan(Long value) {
            addCriterion("provider_package_subsidy >", value, "providerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderPackageSubsidyGreaterThanOrEqualTo(Long value) {
            addCriterion("provider_package_subsidy >=", value, "providerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderPackageSubsidyLessThan(Long value) {
            addCriterion("provider_package_subsidy <", value, "providerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderPackageSubsidyLessThanOrEqualTo(Long value) {
            addCriterion("provider_package_subsidy <=", value, "providerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderPackageSubsidyIn(List<Long> values) {
            addCriterion("provider_package_subsidy in", values, "providerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderPackageSubsidyNotIn(List<Long> values) {
            addCriterion("provider_package_subsidy not in", values, "providerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderPackageSubsidyBetween(Long value1, Long value2) {
            addCriterion("provider_package_subsidy between", value1, value2, "providerPackageSubsidy");
            return (Criteria) this;
        }

        public Criteria andProviderPackageSubsidyNotBetween(Long value1, Long value2) {
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

        public Criteria andCustomerSubsidyEqualTo(Long value) {
            addCriterion("customer_subsidy =", value, "customerSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerSubsidyNotEqualTo(Long value) {
            addCriterion("customer_subsidy <>", value, "customerSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerSubsidyGreaterThan(Long value) {
            addCriterion("customer_subsidy >", value, "customerSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerSubsidyGreaterThanOrEqualTo(Long value) {
            addCriterion("customer_subsidy >=", value, "customerSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerSubsidyLessThan(Long value) {
            addCriterion("customer_subsidy <", value, "customerSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerSubsidyLessThanOrEqualTo(Long value) {
            addCriterion("customer_subsidy <=", value, "customerSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerSubsidyIn(List<Long> values) {
            addCriterion("customer_subsidy in", values, "customerSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerSubsidyNotIn(List<Long> values) {
            addCriterion("customer_subsidy not in", values, "customerSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerSubsidyBetween(Long value1, Long value2) {
            addCriterion("customer_subsidy between", value1, value2, "customerSubsidy");
            return (Criteria) this;
        }

        public Criteria andCustomerSubsidyNotBetween(Long value1, Long value2) {
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

        public Criteria andOtherSubsidyEqualTo(Long value) {
            addCriterion("other_subsidy =", value, "otherSubsidy");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidyNotEqualTo(Long value) {
            addCriterion("other_subsidy <>", value, "otherSubsidy");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidyGreaterThan(Long value) {
            addCriterion("other_subsidy >", value, "otherSubsidy");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidyGreaterThanOrEqualTo(Long value) {
            addCriterion("other_subsidy >=", value, "otherSubsidy");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidyLessThan(Long value) {
            addCriterion("other_subsidy <", value, "otherSubsidy");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidyLessThanOrEqualTo(Long value) {
            addCriterion("other_subsidy <=", value, "otherSubsidy");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidyIn(List<Long> values) {
            addCriterion("other_subsidy in", values, "otherSubsidy");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidyNotIn(List<Long> values) {
            addCriterion("other_subsidy not in", values, "otherSubsidy");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidyBetween(Long value1, Long value2) {
            addCriterion("other_subsidy between", value1, value2, "otherSubsidy");
            return (Criteria) this;
        }

        public Criteria andOtherSubsidyNotBetween(Long value1, Long value2) {
            addCriterion("other_subsidy not between", value1, value2, "otherSubsidy");
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

        public Criteria andGoodsActualCostEqualTo(Long value) {
            addCriterion("goods_actual_cost =", value, "goodsActualCost");
            return (Criteria) this;
        }

        public Criteria andGoodsActualCostNotEqualTo(Long value) {
            addCriterion("goods_actual_cost <>", value, "goodsActualCost");
            return (Criteria) this;
        }

        public Criteria andGoodsActualCostGreaterThan(Long value) {
            addCriterion("goods_actual_cost >", value, "goodsActualCost");
            return (Criteria) this;
        }

        public Criteria andGoodsActualCostGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_actual_cost >=", value, "goodsActualCost");
            return (Criteria) this;
        }

        public Criteria andGoodsActualCostLessThan(Long value) {
            addCriterion("goods_actual_cost <", value, "goodsActualCost");
            return (Criteria) this;
        }

        public Criteria andGoodsActualCostLessThanOrEqualTo(Long value) {
            addCriterion("goods_actual_cost <=", value, "goodsActualCost");
            return (Criteria) this;
        }

        public Criteria andGoodsActualCostIn(List<Long> values) {
            addCriterion("goods_actual_cost in", values, "goodsActualCost");
            return (Criteria) this;
        }

        public Criteria andGoodsActualCostNotIn(List<Long> values) {
            addCriterion("goods_actual_cost not in", values, "goodsActualCost");
            return (Criteria) this;
        }

        public Criteria andGoodsActualCostBetween(Long value1, Long value2) {
            addCriterion("goods_actual_cost between", value1, value2, "goodsActualCost");
            return (Criteria) this;
        }

        public Criteria andGoodsActualCostNotBetween(Long value1, Long value2) {
            addCriterion("goods_actual_cost not between", value1, value2, "goodsActualCost");
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