package com.ai.psims.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SystemParameterLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemParameterLogExample() {
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

        public Criteria andParamIdIsNull() {
            addCriterion("param_id is null");
            return (Criteria) this;
        }

        public Criteria andParamIdIsNotNull() {
            addCriterion("param_id is not null");
            return (Criteria) this;
        }

        public Criteria andParamIdEqualTo(Integer value) {
            addCriterion("param_id =", value, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdNotEqualTo(Integer value) {
            addCriterion("param_id <>", value, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdGreaterThan(Integer value) {
            addCriterion("param_id >", value, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("param_id >=", value, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdLessThan(Integer value) {
            addCriterion("param_id <", value, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdLessThanOrEqualTo(Integer value) {
            addCriterion("param_id <=", value, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdIn(List<Integer> values) {
            addCriterion("param_id in", values, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdNotIn(List<Integer> values) {
            addCriterion("param_id not in", values, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdBetween(Integer value1, Integer value2) {
            addCriterion("param_id between", value1, value2, "paramId");
            return (Criteria) this;
        }

        public Criteria andParamIdNotBetween(Integer value1, Integer value2) {
            addCriterion("param_id not between", value1, value2, "paramId");
            return (Criteria) this;
        }

        public Criteria andPKeyIsNull() {
            addCriterion("p_key is null");
            return (Criteria) this;
        }

        public Criteria andPKeyIsNotNull() {
            addCriterion("p_key is not null");
            return (Criteria) this;
        }

        public Criteria andPKeyEqualTo(String value) {
            addCriterion("p_key =", value, "pKey");
            return (Criteria) this;
        }

        public Criteria andPKeyNotEqualTo(String value) {
            addCriterion("p_key <>", value, "pKey");
            return (Criteria) this;
        }

        public Criteria andPKeyGreaterThan(String value) {
            addCriterion("p_key >", value, "pKey");
            return (Criteria) this;
        }

        public Criteria andPKeyGreaterThanOrEqualTo(String value) {
            addCriterion("p_key >=", value, "pKey");
            return (Criteria) this;
        }

        public Criteria andPKeyLessThan(String value) {
            addCriterion("p_key <", value, "pKey");
            return (Criteria) this;
        }

        public Criteria andPKeyLessThanOrEqualTo(String value) {
            addCriterion("p_key <=", value, "pKey");
            return (Criteria) this;
        }

        public Criteria andPKeyLike(String value) {
            addCriterion("p_key like", value, "pKey");
            return (Criteria) this;
        }

        public Criteria andPKeyNotLike(String value) {
            addCriterion("p_key not like", value, "pKey");
            return (Criteria) this;
        }

        public Criteria andPKeyIn(List<String> values) {
            addCriterion("p_key in", values, "pKey");
            return (Criteria) this;
        }

        public Criteria andPKeyNotIn(List<String> values) {
            addCriterion("p_key not in", values, "pKey");
            return (Criteria) this;
        }

        public Criteria andPKeyBetween(String value1, String value2) {
            addCriterion("p_key between", value1, value2, "pKey");
            return (Criteria) this;
        }

        public Criteria andPKeyNotBetween(String value1, String value2) {
            addCriterion("p_key not between", value1, value2, "pKey");
            return (Criteria) this;
        }

        public Criteria andPDescIsNull() {
            addCriterion("p_desc is null");
            return (Criteria) this;
        }

        public Criteria andPDescIsNotNull() {
            addCriterion("p_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPDescEqualTo(String value) {
            addCriterion("p_desc =", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescNotEqualTo(String value) {
            addCriterion("p_desc <>", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescGreaterThan(String value) {
            addCriterion("p_desc >", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescGreaterThanOrEqualTo(String value) {
            addCriterion("p_desc >=", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescLessThan(String value) {
            addCriterion("p_desc <", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescLessThanOrEqualTo(String value) {
            addCriterion("p_desc <=", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescLike(String value) {
            addCriterion("p_desc like", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescNotLike(String value) {
            addCriterion("p_desc not like", value, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescIn(List<String> values) {
            addCriterion("p_desc in", values, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescNotIn(List<String> values) {
            addCriterion("p_desc not in", values, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescBetween(String value1, String value2) {
            addCriterion("p_desc between", value1, value2, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPDescNotBetween(String value1, String value2) {
            addCriterion("p_desc not between", value1, value2, "pDesc");
            return (Criteria) this;
        }

        public Criteria andPValueIsNull() {
            addCriterion("p_value is null");
            return (Criteria) this;
        }

        public Criteria andPValueIsNotNull() {
            addCriterion("p_value is not null");
            return (Criteria) this;
        }

        public Criteria andPValueEqualTo(String value) {
            addCriterion("p_value =", value, "pValue");
            return (Criteria) this;
        }

        public Criteria andPValueNotEqualTo(String value) {
            addCriterion("p_value <>", value, "pValue");
            return (Criteria) this;
        }

        public Criteria andPValueGreaterThan(String value) {
            addCriterion("p_value >", value, "pValue");
            return (Criteria) this;
        }

        public Criteria andPValueGreaterThanOrEqualTo(String value) {
            addCriterion("p_value >=", value, "pValue");
            return (Criteria) this;
        }

        public Criteria andPValueLessThan(String value) {
            addCriterion("p_value <", value, "pValue");
            return (Criteria) this;
        }

        public Criteria andPValueLessThanOrEqualTo(String value) {
            addCriterion("p_value <=", value, "pValue");
            return (Criteria) this;
        }

        public Criteria andPValueLike(String value) {
            addCriterion("p_value like", value, "pValue");
            return (Criteria) this;
        }

        public Criteria andPValueNotLike(String value) {
            addCriterion("p_value not like", value, "pValue");
            return (Criteria) this;
        }

        public Criteria andPValueIn(List<String> values) {
            addCriterion("p_value in", values, "pValue");
            return (Criteria) this;
        }

        public Criteria andPValueNotIn(List<String> values) {
            addCriterion("p_value not in", values, "pValue");
            return (Criteria) this;
        }

        public Criteria andPValueBetween(String value1, String value2) {
            addCriterion("p_value between", value1, value2, "pValue");
            return (Criteria) this;
        }

        public Criteria andPValueNotBetween(String value1, String value2) {
            addCriterion("p_value not between", value1, value2, "pValue");
            return (Criteria) this;
        }

        public Criteria andPpKeyIsNull() {
            addCriterion("pp_key is null");
            return (Criteria) this;
        }

        public Criteria andPpKeyIsNotNull() {
            addCriterion("pp_key is not null");
            return (Criteria) this;
        }

        public Criteria andPpKeyEqualTo(String value) {
            addCriterion("pp_key =", value, "ppKey");
            return (Criteria) this;
        }

        public Criteria andPpKeyNotEqualTo(String value) {
            addCriterion("pp_key <>", value, "ppKey");
            return (Criteria) this;
        }

        public Criteria andPpKeyGreaterThan(String value) {
            addCriterion("pp_key >", value, "ppKey");
            return (Criteria) this;
        }

        public Criteria andPpKeyGreaterThanOrEqualTo(String value) {
            addCriterion("pp_key >=", value, "ppKey");
            return (Criteria) this;
        }

        public Criteria andPpKeyLessThan(String value) {
            addCriterion("pp_key <", value, "ppKey");
            return (Criteria) this;
        }

        public Criteria andPpKeyLessThanOrEqualTo(String value) {
            addCriterion("pp_key <=", value, "ppKey");
            return (Criteria) this;
        }

        public Criteria andPpKeyLike(String value) {
            addCriterion("pp_key like", value, "ppKey");
            return (Criteria) this;
        }

        public Criteria andPpKeyNotLike(String value) {
            addCriterion("pp_key not like", value, "ppKey");
            return (Criteria) this;
        }

        public Criteria andPpKeyIn(List<String> values) {
            addCriterion("pp_key in", values, "ppKey");
            return (Criteria) this;
        }

        public Criteria andPpKeyNotIn(List<String> values) {
            addCriterion("pp_key not in", values, "ppKey");
            return (Criteria) this;
        }

        public Criteria andPpKeyBetween(String value1, String value2) {
            addCriterion("pp_key between", value1, value2, "ppKey");
            return (Criteria) this;
        }

        public Criteria andPpKeyNotBetween(String value1, String value2) {
            addCriterion("pp_key not between", value1, value2, "ppKey");
            return (Criteria) this;
        }

        public Criteria andPpDescIsNull() {
            addCriterion("pp_desc is null");
            return (Criteria) this;
        }

        public Criteria andPpDescIsNotNull() {
            addCriterion("pp_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPpDescEqualTo(String value) {
            addCriterion("pp_desc =", value, "ppDesc");
            return (Criteria) this;
        }

        public Criteria andPpDescNotEqualTo(String value) {
            addCriterion("pp_desc <>", value, "ppDesc");
            return (Criteria) this;
        }

        public Criteria andPpDescGreaterThan(String value) {
            addCriterion("pp_desc >", value, "ppDesc");
            return (Criteria) this;
        }

        public Criteria andPpDescGreaterThanOrEqualTo(String value) {
            addCriterion("pp_desc >=", value, "ppDesc");
            return (Criteria) this;
        }

        public Criteria andPpDescLessThan(String value) {
            addCriterion("pp_desc <", value, "ppDesc");
            return (Criteria) this;
        }

        public Criteria andPpDescLessThanOrEqualTo(String value) {
            addCriterion("pp_desc <=", value, "ppDesc");
            return (Criteria) this;
        }

        public Criteria andPpDescLike(String value) {
            addCriterion("pp_desc like", value, "ppDesc");
            return (Criteria) this;
        }

        public Criteria andPpDescNotLike(String value) {
            addCriterion("pp_desc not like", value, "ppDesc");
            return (Criteria) this;
        }

        public Criteria andPpDescIn(List<String> values) {
            addCriterion("pp_desc in", values, "ppDesc");
            return (Criteria) this;
        }

        public Criteria andPpDescNotIn(List<String> values) {
            addCriterion("pp_desc not in", values, "ppDesc");
            return (Criteria) this;
        }

        public Criteria andPpDescBetween(String value1, String value2) {
            addCriterion("pp_desc between", value1, value2, "ppDesc");
            return (Criteria) this;
        }

        public Criteria andPpDescNotBetween(String value1, String value2) {
            addCriterion("pp_desc not between", value1, value2, "ppDesc");
            return (Criteria) this;
        }

        public Criteria andPpValueIsNull() {
            addCriterion("pp_value is null");
            return (Criteria) this;
        }

        public Criteria andPpValueIsNotNull() {
            addCriterion("pp_value is not null");
            return (Criteria) this;
        }

        public Criteria andPpValueEqualTo(String value) {
            addCriterion("pp_value =", value, "ppValue");
            return (Criteria) this;
        }

        public Criteria andPpValueNotEqualTo(String value) {
            addCriterion("pp_value <>", value, "ppValue");
            return (Criteria) this;
        }

        public Criteria andPpValueGreaterThan(String value) {
            addCriterion("pp_value >", value, "ppValue");
            return (Criteria) this;
        }

        public Criteria andPpValueGreaterThanOrEqualTo(String value) {
            addCriterion("pp_value >=", value, "ppValue");
            return (Criteria) this;
        }

        public Criteria andPpValueLessThan(String value) {
            addCriterion("pp_value <", value, "ppValue");
            return (Criteria) this;
        }

        public Criteria andPpValueLessThanOrEqualTo(String value) {
            addCriterion("pp_value <=", value, "ppValue");
            return (Criteria) this;
        }

        public Criteria andPpValueLike(String value) {
            addCriterion("pp_value like", value, "ppValue");
            return (Criteria) this;
        }

        public Criteria andPpValueNotLike(String value) {
            addCriterion("pp_value not like", value, "ppValue");
            return (Criteria) this;
        }

        public Criteria andPpValueIn(List<String> values) {
            addCriterion("pp_value in", values, "ppValue");
            return (Criteria) this;
        }

        public Criteria andPpValueNotIn(List<String> values) {
            addCriterion("pp_value not in", values, "ppValue");
            return (Criteria) this;
        }

        public Criteria andPpValueBetween(String value1, String value2) {
            addCriterion("pp_value between", value1, value2, "ppValue");
            return (Criteria) this;
        }

        public Criteria andPpValueNotBetween(String value1, String value2) {
            addCriterion("pp_value not between", value1, value2, "ppValue");
            return (Criteria) this;
        }

        public Criteria andPRemarkIsNull() {
            addCriterion("p_remark is null");
            return (Criteria) this;
        }

        public Criteria andPRemarkIsNotNull() {
            addCriterion("p_remark is not null");
            return (Criteria) this;
        }

        public Criteria andPRemarkEqualTo(String value) {
            addCriterion("p_remark =", value, "pRemark");
            return (Criteria) this;
        }

        public Criteria andPRemarkNotEqualTo(String value) {
            addCriterion("p_remark <>", value, "pRemark");
            return (Criteria) this;
        }

        public Criteria andPRemarkGreaterThan(String value) {
            addCriterion("p_remark >", value, "pRemark");
            return (Criteria) this;
        }

        public Criteria andPRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("p_remark >=", value, "pRemark");
            return (Criteria) this;
        }

        public Criteria andPRemarkLessThan(String value) {
            addCriterion("p_remark <", value, "pRemark");
            return (Criteria) this;
        }

        public Criteria andPRemarkLessThanOrEqualTo(String value) {
            addCriterion("p_remark <=", value, "pRemark");
            return (Criteria) this;
        }

        public Criteria andPRemarkLike(String value) {
            addCriterion("p_remark like", value, "pRemark");
            return (Criteria) this;
        }

        public Criteria andPRemarkNotLike(String value) {
            addCriterion("p_remark not like", value, "pRemark");
            return (Criteria) this;
        }

        public Criteria andPRemarkIn(List<String> values) {
            addCriterion("p_remark in", values, "pRemark");
            return (Criteria) this;
        }

        public Criteria andPRemarkNotIn(List<String> values) {
            addCriterion("p_remark not in", values, "pRemark");
            return (Criteria) this;
        }

        public Criteria andPRemarkBetween(String value1, String value2) {
            addCriterion("p_remark between", value1, value2, "pRemark");
            return (Criteria) this;
        }

        public Criteria andPRemarkNotBetween(String value1, String value2) {
            addCriterion("p_remark not between", value1, value2, "pRemark");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeIsNull() {
            addCriterion("p_createtime is null");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeIsNotNull() {
            addCriterion("p_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeEqualTo(Date value) {
            addCriterion("p_createtime =", value, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeNotEqualTo(Date value) {
            addCriterion("p_createtime <>", value, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeGreaterThan(Date value) {
            addCriterion("p_createtime >", value, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("p_createtime >=", value, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeLessThan(Date value) {
            addCriterion("p_createtime <", value, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("p_createtime <=", value, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeIn(List<Date> values) {
            addCriterion("p_createtime in", values, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeNotIn(List<Date> values) {
            addCriterion("p_createtime not in", values, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeBetween(Date value1, Date value2) {
            addCriterion("p_createtime between", value1, value2, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("p_createtime not between", value1, value2, "pCreatetime");
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