package com.ai.psims.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbProviderLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbProviderLogExample() {
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

        public Criteria andProviderContactNameIsNull() {
            addCriterion("provider_contact_name is null");
            return (Criteria) this;
        }

        public Criteria andProviderContactNameIsNotNull() {
            addCriterion("provider_contact_name is not null");
            return (Criteria) this;
        }

        public Criteria andProviderContactNameEqualTo(String value) {
            addCriterion("provider_contact_name =", value, "providerContactName");
            return (Criteria) this;
        }

        public Criteria andProviderContactNameNotEqualTo(String value) {
            addCriterion("provider_contact_name <>", value, "providerContactName");
            return (Criteria) this;
        }

        public Criteria andProviderContactNameGreaterThan(String value) {
            addCriterion("provider_contact_name >", value, "providerContactName");
            return (Criteria) this;
        }

        public Criteria andProviderContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("provider_contact_name >=", value, "providerContactName");
            return (Criteria) this;
        }

        public Criteria andProviderContactNameLessThan(String value) {
            addCriterion("provider_contact_name <", value, "providerContactName");
            return (Criteria) this;
        }

        public Criteria andProviderContactNameLessThanOrEqualTo(String value) {
            addCriterion("provider_contact_name <=", value, "providerContactName");
            return (Criteria) this;
        }

        public Criteria andProviderContactNameLike(String value) {
            addCriterion("provider_contact_name like", value, "providerContactName");
            return (Criteria) this;
        }

        public Criteria andProviderContactNameNotLike(String value) {
            addCriterion("provider_contact_name not like", value, "providerContactName");
            return (Criteria) this;
        }

        public Criteria andProviderContactNameIn(List<String> values) {
            addCriterion("provider_contact_name in", values, "providerContactName");
            return (Criteria) this;
        }

        public Criteria andProviderContactNameNotIn(List<String> values) {
            addCriterion("provider_contact_name not in", values, "providerContactName");
            return (Criteria) this;
        }

        public Criteria andProviderContactNameBetween(String value1, String value2) {
            addCriterion("provider_contact_name between", value1, value2, "providerContactName");
            return (Criteria) this;
        }

        public Criteria andProviderContactNameNotBetween(String value1, String value2) {
            addCriterion("provider_contact_name not between", value1, value2, "providerContactName");
            return (Criteria) this;
        }

        public Criteria andProviderContactTelIsNull() {
            addCriterion("provider_contact_tel is null");
            return (Criteria) this;
        }

        public Criteria andProviderContactTelIsNotNull() {
            addCriterion("provider_contact_tel is not null");
            return (Criteria) this;
        }

        public Criteria andProviderContactTelEqualTo(String value) {
            addCriterion("provider_contact_tel =", value, "providerContactTel");
            return (Criteria) this;
        }

        public Criteria andProviderContactTelNotEqualTo(String value) {
            addCriterion("provider_contact_tel <>", value, "providerContactTel");
            return (Criteria) this;
        }

        public Criteria andProviderContactTelGreaterThan(String value) {
            addCriterion("provider_contact_tel >", value, "providerContactTel");
            return (Criteria) this;
        }

        public Criteria andProviderContactTelGreaterThanOrEqualTo(String value) {
            addCriterion("provider_contact_tel >=", value, "providerContactTel");
            return (Criteria) this;
        }

        public Criteria andProviderContactTelLessThan(String value) {
            addCriterion("provider_contact_tel <", value, "providerContactTel");
            return (Criteria) this;
        }

        public Criteria andProviderContactTelLessThanOrEqualTo(String value) {
            addCriterion("provider_contact_tel <=", value, "providerContactTel");
            return (Criteria) this;
        }

        public Criteria andProviderContactTelLike(String value) {
            addCriterion("provider_contact_tel like", value, "providerContactTel");
            return (Criteria) this;
        }

        public Criteria andProviderContactTelNotLike(String value) {
            addCriterion("provider_contact_tel not like", value, "providerContactTel");
            return (Criteria) this;
        }

        public Criteria andProviderContactTelIn(List<String> values) {
            addCriterion("provider_contact_tel in", values, "providerContactTel");
            return (Criteria) this;
        }

        public Criteria andProviderContactTelNotIn(List<String> values) {
            addCriterion("provider_contact_tel not in", values, "providerContactTel");
            return (Criteria) this;
        }

        public Criteria andProviderContactTelBetween(String value1, String value2) {
            addCriterion("provider_contact_tel between", value1, value2, "providerContactTel");
            return (Criteria) this;
        }

        public Criteria andProviderContactTelNotBetween(String value1, String value2) {
            addCriterion("provider_contact_tel not between", value1, value2, "providerContactTel");
            return (Criteria) this;
        }

        public Criteria andProviderContactFaxIsNull() {
            addCriterion("provider_contact_fax is null");
            return (Criteria) this;
        }

        public Criteria andProviderContactFaxIsNotNull() {
            addCriterion("provider_contact_fax is not null");
            return (Criteria) this;
        }

        public Criteria andProviderContactFaxEqualTo(String value) {
            addCriterion("provider_contact_fax =", value, "providerContactFax");
            return (Criteria) this;
        }

        public Criteria andProviderContactFaxNotEqualTo(String value) {
            addCriterion("provider_contact_fax <>", value, "providerContactFax");
            return (Criteria) this;
        }

        public Criteria andProviderContactFaxGreaterThan(String value) {
            addCriterion("provider_contact_fax >", value, "providerContactFax");
            return (Criteria) this;
        }

        public Criteria andProviderContactFaxGreaterThanOrEqualTo(String value) {
            addCriterion("provider_contact_fax >=", value, "providerContactFax");
            return (Criteria) this;
        }

        public Criteria andProviderContactFaxLessThan(String value) {
            addCriterion("provider_contact_fax <", value, "providerContactFax");
            return (Criteria) this;
        }

        public Criteria andProviderContactFaxLessThanOrEqualTo(String value) {
            addCriterion("provider_contact_fax <=", value, "providerContactFax");
            return (Criteria) this;
        }

        public Criteria andProviderContactFaxLike(String value) {
            addCriterion("provider_contact_fax like", value, "providerContactFax");
            return (Criteria) this;
        }

        public Criteria andProviderContactFaxNotLike(String value) {
            addCriterion("provider_contact_fax not like", value, "providerContactFax");
            return (Criteria) this;
        }

        public Criteria andProviderContactFaxIn(List<String> values) {
            addCriterion("provider_contact_fax in", values, "providerContactFax");
            return (Criteria) this;
        }

        public Criteria andProviderContactFaxNotIn(List<String> values) {
            addCriterion("provider_contact_fax not in", values, "providerContactFax");
            return (Criteria) this;
        }

        public Criteria andProviderContactFaxBetween(String value1, String value2) {
            addCriterion("provider_contact_fax between", value1, value2, "providerContactFax");
            return (Criteria) this;
        }

        public Criteria andProviderContactFaxNotBetween(String value1, String value2) {
            addCriterion("provider_contact_fax not between", value1, value2, "providerContactFax");
            return (Criteria) this;
        }

        public Criteria andProviderContactEmailIsNull() {
            addCriterion("provider_contact_email is null");
            return (Criteria) this;
        }

        public Criteria andProviderContactEmailIsNotNull() {
            addCriterion("provider_contact_email is not null");
            return (Criteria) this;
        }

        public Criteria andProviderContactEmailEqualTo(String value) {
            addCriterion("provider_contact_email =", value, "providerContactEmail");
            return (Criteria) this;
        }

        public Criteria andProviderContactEmailNotEqualTo(String value) {
            addCriterion("provider_contact_email <>", value, "providerContactEmail");
            return (Criteria) this;
        }

        public Criteria andProviderContactEmailGreaterThan(String value) {
            addCriterion("provider_contact_email >", value, "providerContactEmail");
            return (Criteria) this;
        }

        public Criteria andProviderContactEmailGreaterThanOrEqualTo(String value) {
            addCriterion("provider_contact_email >=", value, "providerContactEmail");
            return (Criteria) this;
        }

        public Criteria andProviderContactEmailLessThan(String value) {
            addCriterion("provider_contact_email <", value, "providerContactEmail");
            return (Criteria) this;
        }

        public Criteria andProviderContactEmailLessThanOrEqualTo(String value) {
            addCriterion("provider_contact_email <=", value, "providerContactEmail");
            return (Criteria) this;
        }

        public Criteria andProviderContactEmailLike(String value) {
            addCriterion("provider_contact_email like", value, "providerContactEmail");
            return (Criteria) this;
        }

        public Criteria andProviderContactEmailNotLike(String value) {
            addCriterion("provider_contact_email not like", value, "providerContactEmail");
            return (Criteria) this;
        }

        public Criteria andProviderContactEmailIn(List<String> values) {
            addCriterion("provider_contact_email in", values, "providerContactEmail");
            return (Criteria) this;
        }

        public Criteria andProviderContactEmailNotIn(List<String> values) {
            addCriterion("provider_contact_email not in", values, "providerContactEmail");
            return (Criteria) this;
        }

        public Criteria andProviderContactEmailBetween(String value1, String value2) {
            addCriterion("provider_contact_email between", value1, value2, "providerContactEmail");
            return (Criteria) this;
        }

        public Criteria andProviderContactEmailNotBetween(String value1, String value2) {
            addCriterion("provider_contact_email not between", value1, value2, "providerContactEmail");
            return (Criteria) this;
        }

        public Criteria andProviderContactAddressIsNull() {
            addCriterion("provider_contact_address is null");
            return (Criteria) this;
        }

        public Criteria andProviderContactAddressIsNotNull() {
            addCriterion("provider_contact_address is not null");
            return (Criteria) this;
        }

        public Criteria andProviderContactAddressEqualTo(String value) {
            addCriterion("provider_contact_address =", value, "providerContactAddress");
            return (Criteria) this;
        }

        public Criteria andProviderContactAddressNotEqualTo(String value) {
            addCriterion("provider_contact_address <>", value, "providerContactAddress");
            return (Criteria) this;
        }

        public Criteria andProviderContactAddressGreaterThan(String value) {
            addCriterion("provider_contact_address >", value, "providerContactAddress");
            return (Criteria) this;
        }

        public Criteria andProviderContactAddressGreaterThanOrEqualTo(String value) {
            addCriterion("provider_contact_address >=", value, "providerContactAddress");
            return (Criteria) this;
        }

        public Criteria andProviderContactAddressLessThan(String value) {
            addCriterion("provider_contact_address <", value, "providerContactAddress");
            return (Criteria) this;
        }

        public Criteria andProviderContactAddressLessThanOrEqualTo(String value) {
            addCriterion("provider_contact_address <=", value, "providerContactAddress");
            return (Criteria) this;
        }

        public Criteria andProviderContactAddressLike(String value) {
            addCriterion("provider_contact_address like", value, "providerContactAddress");
            return (Criteria) this;
        }

        public Criteria andProviderContactAddressNotLike(String value) {
            addCriterion("provider_contact_address not like", value, "providerContactAddress");
            return (Criteria) this;
        }

        public Criteria andProviderContactAddressIn(List<String> values) {
            addCriterion("provider_contact_address in", values, "providerContactAddress");
            return (Criteria) this;
        }

        public Criteria andProviderContactAddressNotIn(List<String> values) {
            addCriterion("provider_contact_address not in", values, "providerContactAddress");
            return (Criteria) this;
        }

        public Criteria andProviderContactAddressBetween(String value1, String value2) {
            addCriterion("provider_contact_address between", value1, value2, "providerContactAddress");
            return (Criteria) this;
        }

        public Criteria andProviderContactAddressNotBetween(String value1, String value2) {
            addCriterion("provider_contact_address not between", value1, value2, "providerContactAddress");
            return (Criteria) this;
        }

        public Criteria andProviderBankNameIsNull() {
            addCriterion("provider_bank_name is null");
            return (Criteria) this;
        }

        public Criteria andProviderBankNameIsNotNull() {
            addCriterion("provider_bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andProviderBankNameEqualTo(String value) {
            addCriterion("provider_bank_name =", value, "providerBankName");
            return (Criteria) this;
        }

        public Criteria andProviderBankNameNotEqualTo(String value) {
            addCriterion("provider_bank_name <>", value, "providerBankName");
            return (Criteria) this;
        }

        public Criteria andProviderBankNameGreaterThan(String value) {
            addCriterion("provider_bank_name >", value, "providerBankName");
            return (Criteria) this;
        }

        public Criteria andProviderBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("provider_bank_name >=", value, "providerBankName");
            return (Criteria) this;
        }

        public Criteria andProviderBankNameLessThan(String value) {
            addCriterion("provider_bank_name <", value, "providerBankName");
            return (Criteria) this;
        }

        public Criteria andProviderBankNameLessThanOrEqualTo(String value) {
            addCriterion("provider_bank_name <=", value, "providerBankName");
            return (Criteria) this;
        }

        public Criteria andProviderBankNameLike(String value) {
            addCriterion("provider_bank_name like", value, "providerBankName");
            return (Criteria) this;
        }

        public Criteria andProviderBankNameNotLike(String value) {
            addCriterion("provider_bank_name not like", value, "providerBankName");
            return (Criteria) this;
        }

        public Criteria andProviderBankNameIn(List<String> values) {
            addCriterion("provider_bank_name in", values, "providerBankName");
            return (Criteria) this;
        }

        public Criteria andProviderBankNameNotIn(List<String> values) {
            addCriterion("provider_bank_name not in", values, "providerBankName");
            return (Criteria) this;
        }

        public Criteria andProviderBankNameBetween(String value1, String value2) {
            addCriterion("provider_bank_name between", value1, value2, "providerBankName");
            return (Criteria) this;
        }

        public Criteria andProviderBankNameNotBetween(String value1, String value2) {
            addCriterion("provider_bank_name not between", value1, value2, "providerBankName");
            return (Criteria) this;
        }

        public Criteria andProviderBankAccountNameIsNull() {
            addCriterion("provider_bank_account_name is null");
            return (Criteria) this;
        }

        public Criteria andProviderBankAccountNameIsNotNull() {
            addCriterion("provider_bank_account_name is not null");
            return (Criteria) this;
        }

        public Criteria andProviderBankAccountNameEqualTo(String value) {
            addCriterion("provider_bank_account_name =", value, "providerBankAccountName");
            return (Criteria) this;
        }

        public Criteria andProviderBankAccountNameNotEqualTo(String value) {
            addCriterion("provider_bank_account_name <>", value, "providerBankAccountName");
            return (Criteria) this;
        }

        public Criteria andProviderBankAccountNameGreaterThan(String value) {
            addCriterion("provider_bank_account_name >", value, "providerBankAccountName");
            return (Criteria) this;
        }

        public Criteria andProviderBankAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("provider_bank_account_name >=", value, "providerBankAccountName");
            return (Criteria) this;
        }

        public Criteria andProviderBankAccountNameLessThan(String value) {
            addCriterion("provider_bank_account_name <", value, "providerBankAccountName");
            return (Criteria) this;
        }

        public Criteria andProviderBankAccountNameLessThanOrEqualTo(String value) {
            addCriterion("provider_bank_account_name <=", value, "providerBankAccountName");
            return (Criteria) this;
        }

        public Criteria andProviderBankAccountNameLike(String value) {
            addCriterion("provider_bank_account_name like", value, "providerBankAccountName");
            return (Criteria) this;
        }

        public Criteria andProviderBankAccountNameNotLike(String value) {
            addCriterion("provider_bank_account_name not like", value, "providerBankAccountName");
            return (Criteria) this;
        }

        public Criteria andProviderBankAccountNameIn(List<String> values) {
            addCriterion("provider_bank_account_name in", values, "providerBankAccountName");
            return (Criteria) this;
        }

        public Criteria andProviderBankAccountNameNotIn(List<String> values) {
            addCriterion("provider_bank_account_name not in", values, "providerBankAccountName");
            return (Criteria) this;
        }

        public Criteria andProviderBankAccountNameBetween(String value1, String value2) {
            addCriterion("provider_bank_account_name between", value1, value2, "providerBankAccountName");
            return (Criteria) this;
        }

        public Criteria andProviderBankAccountNameNotBetween(String value1, String value2) {
            addCriterion("provider_bank_account_name not between", value1, value2, "providerBankAccountName");
            return (Criteria) this;
        }

        public Criteria andProviderBankAccountCodeIsNull() {
            addCriterion("provider_bank_account_code is null");
            return (Criteria) this;
        }

        public Criteria andProviderBankAccountCodeIsNotNull() {
            addCriterion("provider_bank_account_code is not null");
            return (Criteria) this;
        }

        public Criteria andProviderBankAccountCodeEqualTo(String value) {
            addCriterion("provider_bank_account_code =", value, "providerBankAccountCode");
            return (Criteria) this;
        }

        public Criteria andProviderBankAccountCodeNotEqualTo(String value) {
            addCriterion("provider_bank_account_code <>", value, "providerBankAccountCode");
            return (Criteria) this;
        }

        public Criteria andProviderBankAccountCodeGreaterThan(String value) {
            addCriterion("provider_bank_account_code >", value, "providerBankAccountCode");
            return (Criteria) this;
        }

        public Criteria andProviderBankAccountCodeGreaterThanOrEqualTo(String value) {
            addCriterion("provider_bank_account_code >=", value, "providerBankAccountCode");
            return (Criteria) this;
        }

        public Criteria andProviderBankAccountCodeLessThan(String value) {
            addCriterion("provider_bank_account_code <", value, "providerBankAccountCode");
            return (Criteria) this;
        }

        public Criteria andProviderBankAccountCodeLessThanOrEqualTo(String value) {
            addCriterion("provider_bank_account_code <=", value, "providerBankAccountCode");
            return (Criteria) this;
        }

        public Criteria andProviderBankAccountCodeLike(String value) {
            addCriterion("provider_bank_account_code like", value, "providerBankAccountCode");
            return (Criteria) this;
        }

        public Criteria andProviderBankAccountCodeNotLike(String value) {
            addCriterion("provider_bank_account_code not like", value, "providerBankAccountCode");
            return (Criteria) this;
        }

        public Criteria andProviderBankAccountCodeIn(List<String> values) {
            addCriterion("provider_bank_account_code in", values, "providerBankAccountCode");
            return (Criteria) this;
        }

        public Criteria andProviderBankAccountCodeNotIn(List<String> values) {
            addCriterion("provider_bank_account_code not in", values, "providerBankAccountCode");
            return (Criteria) this;
        }

        public Criteria andProviderBankAccountCodeBetween(String value1, String value2) {
            addCriterion("provider_bank_account_code between", value1, value2, "providerBankAccountCode");
            return (Criteria) this;
        }

        public Criteria andProviderBankAccountCodeNotBetween(String value1, String value2) {
            addCriterion("provider_bank_account_code not between", value1, value2, "providerBankAccountCode");
            return (Criteria) this;
        }

        public Criteria andProviderPrizePoolIsNull() {
            addCriterion("provider_prize_pool is null");
            return (Criteria) this;
        }

        public Criteria andProviderPrizePoolIsNotNull() {
            addCriterion("provider_prize_pool is not null");
            return (Criteria) this;
        }

        public Criteria andProviderPrizePoolEqualTo(String value) {
            addCriterion("provider_prize_pool =", value, "providerPrizePool");
            return (Criteria) this;
        }

        public Criteria andProviderPrizePoolNotEqualTo(String value) {
            addCriterion("provider_prize_pool <>", value, "providerPrizePool");
            return (Criteria) this;
        }

        public Criteria andProviderPrizePoolGreaterThan(String value) {
            addCriterion("provider_prize_pool >", value, "providerPrizePool");
            return (Criteria) this;
        }

        public Criteria andProviderPrizePoolGreaterThanOrEqualTo(String value) {
            addCriterion("provider_prize_pool >=", value, "providerPrizePool");
            return (Criteria) this;
        }

        public Criteria andProviderPrizePoolLessThan(String value) {
            addCriterion("provider_prize_pool <", value, "providerPrizePool");
            return (Criteria) this;
        }

        public Criteria andProviderPrizePoolLessThanOrEqualTo(String value) {
            addCriterion("provider_prize_pool <=", value, "providerPrizePool");
            return (Criteria) this;
        }

        public Criteria andProviderPrizePoolLike(String value) {
            addCriterion("provider_prize_pool like", value, "providerPrizePool");
            return (Criteria) this;
        }

        public Criteria andProviderPrizePoolNotLike(String value) {
            addCriterion("provider_prize_pool not like", value, "providerPrizePool");
            return (Criteria) this;
        }

        public Criteria andProviderPrizePoolIn(List<String> values) {
            addCriterion("provider_prize_pool in", values, "providerPrizePool");
            return (Criteria) this;
        }

        public Criteria andProviderPrizePoolNotIn(List<String> values) {
            addCriterion("provider_prize_pool not in", values, "providerPrizePool");
            return (Criteria) this;
        }

        public Criteria andProviderPrizePoolBetween(String value1, String value2) {
            addCriterion("provider_prize_pool between", value1, value2, "providerPrizePool");
            return (Criteria) this;
        }

        public Criteria andProviderPrizePoolNotBetween(String value1, String value2) {
            addCriterion("provider_prize_pool not between", value1, value2, "providerPrizePool");
            return (Criteria) this;
        }

        public Criteria andProviderTaxidIsNull() {
            addCriterion("provider_taxid is null");
            return (Criteria) this;
        }

        public Criteria andProviderTaxidIsNotNull() {
            addCriterion("provider_taxid is not null");
            return (Criteria) this;
        }

        public Criteria andProviderTaxidEqualTo(String value) {
            addCriterion("provider_taxid =", value, "providerTaxid");
            return (Criteria) this;
        }

        public Criteria andProviderTaxidNotEqualTo(String value) {
            addCriterion("provider_taxid <>", value, "providerTaxid");
            return (Criteria) this;
        }

        public Criteria andProviderTaxidGreaterThan(String value) {
            addCriterion("provider_taxid >", value, "providerTaxid");
            return (Criteria) this;
        }

        public Criteria andProviderTaxidGreaterThanOrEqualTo(String value) {
            addCriterion("provider_taxid >=", value, "providerTaxid");
            return (Criteria) this;
        }

        public Criteria andProviderTaxidLessThan(String value) {
            addCriterion("provider_taxid <", value, "providerTaxid");
            return (Criteria) this;
        }

        public Criteria andProviderTaxidLessThanOrEqualTo(String value) {
            addCriterion("provider_taxid <=", value, "providerTaxid");
            return (Criteria) this;
        }

        public Criteria andProviderTaxidLike(String value) {
            addCriterion("provider_taxid like", value, "providerTaxid");
            return (Criteria) this;
        }

        public Criteria andProviderTaxidNotLike(String value) {
            addCriterion("provider_taxid not like", value, "providerTaxid");
            return (Criteria) this;
        }

        public Criteria andProviderTaxidIn(List<String> values) {
            addCriterion("provider_taxid in", values, "providerTaxid");
            return (Criteria) this;
        }

        public Criteria andProviderTaxidNotIn(List<String> values) {
            addCriterion("provider_taxid not in", values, "providerTaxid");
            return (Criteria) this;
        }

        public Criteria andProviderTaxidBetween(String value1, String value2) {
            addCriterion("provider_taxid between", value1, value2, "providerTaxid");
            return (Criteria) this;
        }

        public Criteria andProviderTaxidNotBetween(String value1, String value2) {
            addCriterion("provider_taxid not between", value1, value2, "providerTaxid");
            return (Criteria) this;
        }

        public Criteria andProviderAreaIsNull() {
            addCriterion("provider_area is null");
            return (Criteria) this;
        }

        public Criteria andProviderAreaIsNotNull() {
            addCriterion("provider_area is not null");
            return (Criteria) this;
        }

        public Criteria andProviderAreaEqualTo(String value) {
            addCriterion("provider_area =", value, "providerArea");
            return (Criteria) this;
        }

        public Criteria andProviderAreaNotEqualTo(String value) {
            addCriterion("provider_area <>", value, "providerArea");
            return (Criteria) this;
        }

        public Criteria andProviderAreaGreaterThan(String value) {
            addCriterion("provider_area >", value, "providerArea");
            return (Criteria) this;
        }

        public Criteria andProviderAreaGreaterThanOrEqualTo(String value) {
            addCriterion("provider_area >=", value, "providerArea");
            return (Criteria) this;
        }

        public Criteria andProviderAreaLessThan(String value) {
            addCriterion("provider_area <", value, "providerArea");
            return (Criteria) this;
        }

        public Criteria andProviderAreaLessThanOrEqualTo(String value) {
            addCriterion("provider_area <=", value, "providerArea");
            return (Criteria) this;
        }

        public Criteria andProviderAreaLike(String value) {
            addCriterion("provider_area like", value, "providerArea");
            return (Criteria) this;
        }

        public Criteria andProviderAreaNotLike(String value) {
            addCriterion("provider_area not like", value, "providerArea");
            return (Criteria) this;
        }

        public Criteria andProviderAreaIn(List<String> values) {
            addCriterion("provider_area in", values, "providerArea");
            return (Criteria) this;
        }

        public Criteria andProviderAreaNotIn(List<String> values) {
            addCriterion("provider_area not in", values, "providerArea");
            return (Criteria) this;
        }

        public Criteria andProviderAreaBetween(String value1, String value2) {
            addCriterion("provider_area between", value1, value2, "providerArea");
            return (Criteria) this;
        }

        public Criteria andProviderAreaNotBetween(String value1, String value2) {
            addCriterion("provider_area not between", value1, value2, "providerArea");
            return (Criteria) this;
        }

        public Criteria andProviderTypeIsNull() {
            addCriterion("provider_type is null");
            return (Criteria) this;
        }

        public Criteria andProviderTypeIsNotNull() {
            addCriterion("provider_type is not null");
            return (Criteria) this;
        }

        public Criteria andProviderTypeEqualTo(String value) {
            addCriterion("provider_type =", value, "providerType");
            return (Criteria) this;
        }

        public Criteria andProviderTypeNotEqualTo(String value) {
            addCriterion("provider_type <>", value, "providerType");
            return (Criteria) this;
        }

        public Criteria andProviderTypeGreaterThan(String value) {
            addCriterion("provider_type >", value, "providerType");
            return (Criteria) this;
        }

        public Criteria andProviderTypeGreaterThanOrEqualTo(String value) {
            addCriterion("provider_type >=", value, "providerType");
            return (Criteria) this;
        }

        public Criteria andProviderTypeLessThan(String value) {
            addCriterion("provider_type <", value, "providerType");
            return (Criteria) this;
        }

        public Criteria andProviderTypeLessThanOrEqualTo(String value) {
            addCriterion("provider_type <=", value, "providerType");
            return (Criteria) this;
        }

        public Criteria andProviderTypeLike(String value) {
            addCriterion("provider_type like", value, "providerType");
            return (Criteria) this;
        }

        public Criteria andProviderTypeNotLike(String value) {
            addCriterion("provider_type not like", value, "providerType");
            return (Criteria) this;
        }

        public Criteria andProviderTypeIn(List<String> values) {
            addCriterion("provider_type in", values, "providerType");
            return (Criteria) this;
        }

        public Criteria andProviderTypeNotIn(List<String> values) {
            addCriterion("provider_type not in", values, "providerType");
            return (Criteria) this;
        }

        public Criteria andProviderTypeBetween(String value1, String value2) {
            addCriterion("provider_type between", value1, value2, "providerType");
            return (Criteria) this;
        }

        public Criteria andProviderTypeNotBetween(String value1, String value2) {
            addCriterion("provider_type not between", value1, value2, "providerType");
            return (Criteria) this;
        }

        public Criteria andProviderStatusIsNull() {
            addCriterion("provider_status is null");
            return (Criteria) this;
        }

        public Criteria andProviderStatusIsNotNull() {
            addCriterion("provider_status is not null");
            return (Criteria) this;
        }

        public Criteria andProviderStatusEqualTo(String value) {
            addCriterion("provider_status =", value, "providerStatus");
            return (Criteria) this;
        }

        public Criteria andProviderStatusNotEqualTo(String value) {
            addCriterion("provider_status <>", value, "providerStatus");
            return (Criteria) this;
        }

        public Criteria andProviderStatusGreaterThan(String value) {
            addCriterion("provider_status >", value, "providerStatus");
            return (Criteria) this;
        }

        public Criteria andProviderStatusGreaterThanOrEqualTo(String value) {
            addCriterion("provider_status >=", value, "providerStatus");
            return (Criteria) this;
        }

        public Criteria andProviderStatusLessThan(String value) {
            addCriterion("provider_status <", value, "providerStatus");
            return (Criteria) this;
        }

        public Criteria andProviderStatusLessThanOrEqualTo(String value) {
            addCriterion("provider_status <=", value, "providerStatus");
            return (Criteria) this;
        }

        public Criteria andProviderStatusLike(String value) {
            addCriterion("provider_status like", value, "providerStatus");
            return (Criteria) this;
        }

        public Criteria andProviderStatusNotLike(String value) {
            addCriterion("provider_status not like", value, "providerStatus");
            return (Criteria) this;
        }

        public Criteria andProviderStatusIn(List<String> values) {
            addCriterion("provider_status in", values, "providerStatus");
            return (Criteria) this;
        }

        public Criteria andProviderStatusNotIn(List<String> values) {
            addCriterion("provider_status not in", values, "providerStatus");
            return (Criteria) this;
        }

        public Criteria andProviderStatusBetween(String value1, String value2) {
            addCriterion("provider_status between", value1, value2, "providerStatus");
            return (Criteria) this;
        }

        public Criteria andProviderStatusNotBetween(String value1, String value2) {
            addCriterion("provider_status not between", value1, value2, "providerStatus");
            return (Criteria) this;
        }

        public Criteria andProviderCreatetimeIsNull() {
            addCriterion("provider_createtime is null");
            return (Criteria) this;
        }

        public Criteria andProviderCreatetimeIsNotNull() {
            addCriterion("provider_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andProviderCreatetimeEqualTo(Date value) {
            addCriterion("provider_createtime =", value, "providerCreatetime");
            return (Criteria) this;
        }

        public Criteria andProviderCreatetimeNotEqualTo(Date value) {
            addCriterion("provider_createtime <>", value, "providerCreatetime");
            return (Criteria) this;
        }

        public Criteria andProviderCreatetimeGreaterThan(Date value) {
            addCriterion("provider_createtime >", value, "providerCreatetime");
            return (Criteria) this;
        }

        public Criteria andProviderCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("provider_createtime >=", value, "providerCreatetime");
            return (Criteria) this;
        }

        public Criteria andProviderCreatetimeLessThan(Date value) {
            addCriterion("provider_createtime <", value, "providerCreatetime");
            return (Criteria) this;
        }

        public Criteria andProviderCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("provider_createtime <=", value, "providerCreatetime");
            return (Criteria) this;
        }

        public Criteria andProviderCreatetimeIn(List<Date> values) {
            addCriterion("provider_createtime in", values, "providerCreatetime");
            return (Criteria) this;
        }

        public Criteria andProviderCreatetimeNotIn(List<Date> values) {
            addCriterion("provider_createtime not in", values, "providerCreatetime");
            return (Criteria) this;
        }

        public Criteria andProviderCreatetimeBetween(Date value1, Date value2) {
            addCriterion("provider_createtime between", value1, value2, "providerCreatetime");
            return (Criteria) this;
        }

        public Criteria andProviderCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("provider_createtime not between", value1, value2, "providerCreatetime");
            return (Criteria) this;
        }

        public Criteria andProviderModifytimeIsNull() {
            addCriterion("provider_modifytime is null");
            return (Criteria) this;
        }

        public Criteria andProviderModifytimeIsNotNull() {
            addCriterion("provider_modifytime is not null");
            return (Criteria) this;
        }

        public Criteria andProviderModifytimeEqualTo(Date value) {
            addCriterion("provider_modifytime =", value, "providerModifytime");
            return (Criteria) this;
        }

        public Criteria andProviderModifytimeNotEqualTo(Date value) {
            addCriterion("provider_modifytime <>", value, "providerModifytime");
            return (Criteria) this;
        }

        public Criteria andProviderModifytimeGreaterThan(Date value) {
            addCriterion("provider_modifytime >", value, "providerModifytime");
            return (Criteria) this;
        }

        public Criteria andProviderModifytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("provider_modifytime >=", value, "providerModifytime");
            return (Criteria) this;
        }

        public Criteria andProviderModifytimeLessThan(Date value) {
            addCriterion("provider_modifytime <", value, "providerModifytime");
            return (Criteria) this;
        }

        public Criteria andProviderModifytimeLessThanOrEqualTo(Date value) {
            addCriterion("provider_modifytime <=", value, "providerModifytime");
            return (Criteria) this;
        }

        public Criteria andProviderModifytimeIn(List<Date> values) {
            addCriterion("provider_modifytime in", values, "providerModifytime");
            return (Criteria) this;
        }

        public Criteria andProviderModifytimeNotIn(List<Date> values) {
            addCriterion("provider_modifytime not in", values, "providerModifytime");
            return (Criteria) this;
        }

        public Criteria andProviderModifytimeBetween(Date value1, Date value2) {
            addCriterion("provider_modifytime between", value1, value2, "providerModifytime");
            return (Criteria) this;
        }

        public Criteria andProviderModifytimeNotBetween(Date value1, Date value2) {
            addCriterion("provider_modifytime not between", value1, value2, "providerModifytime");
            return (Criteria) this;
        }

        public Criteria andProviderEndtimeIsNull() {
            addCriterion("provider_endtime is null");
            return (Criteria) this;
        }

        public Criteria andProviderEndtimeIsNotNull() {
            addCriterion("provider_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andProviderEndtimeEqualTo(Date value) {
            addCriterion("provider_endtime =", value, "providerEndtime");
            return (Criteria) this;
        }

        public Criteria andProviderEndtimeNotEqualTo(Date value) {
            addCriterion("provider_endtime <>", value, "providerEndtime");
            return (Criteria) this;
        }

        public Criteria andProviderEndtimeGreaterThan(Date value) {
            addCriterion("provider_endtime >", value, "providerEndtime");
            return (Criteria) this;
        }

        public Criteria andProviderEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("provider_endtime >=", value, "providerEndtime");
            return (Criteria) this;
        }

        public Criteria andProviderEndtimeLessThan(Date value) {
            addCriterion("provider_endtime <", value, "providerEndtime");
            return (Criteria) this;
        }

        public Criteria andProviderEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("provider_endtime <=", value, "providerEndtime");
            return (Criteria) this;
        }

        public Criteria andProviderEndtimeIn(List<Date> values) {
            addCriterion("provider_endtime in", values, "providerEndtime");
            return (Criteria) this;
        }

        public Criteria andProviderEndtimeNotIn(List<Date> values) {
            addCriterion("provider_endtime not in", values, "providerEndtime");
            return (Criteria) this;
        }

        public Criteria andProviderEndtimeBetween(Date value1, Date value2) {
            addCriterion("provider_endtime between", value1, value2, "providerEndtime");
            return (Criteria) this;
        }

        public Criteria andProviderEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("provider_endtime not between", value1, value2, "providerEndtime");
            return (Criteria) this;
        }

        public Criteria andProviderRemarkIsNull() {
            addCriterion("provider_remark is null");
            return (Criteria) this;
        }

        public Criteria andProviderRemarkIsNotNull() {
            addCriterion("provider_remark is not null");
            return (Criteria) this;
        }

        public Criteria andProviderRemarkEqualTo(String value) {
            addCriterion("provider_remark =", value, "providerRemark");
            return (Criteria) this;
        }

        public Criteria andProviderRemarkNotEqualTo(String value) {
            addCriterion("provider_remark <>", value, "providerRemark");
            return (Criteria) this;
        }

        public Criteria andProviderRemarkGreaterThan(String value) {
            addCriterion("provider_remark >", value, "providerRemark");
            return (Criteria) this;
        }

        public Criteria andProviderRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("provider_remark >=", value, "providerRemark");
            return (Criteria) this;
        }

        public Criteria andProviderRemarkLessThan(String value) {
            addCriterion("provider_remark <", value, "providerRemark");
            return (Criteria) this;
        }

        public Criteria andProviderRemarkLessThanOrEqualTo(String value) {
            addCriterion("provider_remark <=", value, "providerRemark");
            return (Criteria) this;
        }

        public Criteria andProviderRemarkLike(String value) {
            addCriterion("provider_remark like", value, "providerRemark");
            return (Criteria) this;
        }

        public Criteria andProviderRemarkNotLike(String value) {
            addCriterion("provider_remark not like", value, "providerRemark");
            return (Criteria) this;
        }

        public Criteria andProviderRemarkIn(List<String> values) {
            addCriterion("provider_remark in", values, "providerRemark");
            return (Criteria) this;
        }

        public Criteria andProviderRemarkNotIn(List<String> values) {
            addCriterion("provider_remark not in", values, "providerRemark");
            return (Criteria) this;
        }

        public Criteria andProviderRemarkBetween(String value1, String value2) {
            addCriterion("provider_remark between", value1, value2, "providerRemark");
            return (Criteria) this;
        }

        public Criteria andProviderRemarkNotBetween(String value1, String value2) {
            addCriterion("provider_remark not between", value1, value2, "providerRemark");
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