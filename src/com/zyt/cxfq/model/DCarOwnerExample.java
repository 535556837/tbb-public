package com.zyt.cxfq.model;

import com.zyt.cxfq.plugin.page.BootPage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DCarOwnerExample {
    /**
     * d_car_owner
     */
    protected String orderByClause;

    /**
     * d_car_owner
     */
    protected boolean distinct;

    /**
     * d_car_owner
     */
    protected List<Criteria> oredCriteria;

    /**
     * d_car_owner
     */
    protected BootPage page;

    /**
     *
     * @mbggenerated 2019-01-14
     */
    public DCarOwnerExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbggenerated 2019-01-14
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbggenerated 2019-01-14
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbggenerated 2019-01-14
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbggenerated 2019-01-14
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbggenerated 2019-01-14
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbggenerated 2019-01-14
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbggenerated 2019-01-14
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbggenerated 2019-01-14
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *
     * @mbggenerated 2019-01-14
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbggenerated 2019-01-14
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     *
     * @mbggenerated 2019-01-14
     */
    public void setPage(BootPage page) {
        this.page=page;
    }

    /**
     *
     * @mbggenerated 2019-01-14
     */
    public BootPage getPage() {
        return page;
    }

    /**
     * d_car_owner 2019-01-14
     */
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

        public Criteria andCarOwnersIdIsNull() {
            addCriterion("car_owners_id is null");
            return (Criteria) this;
        }

        public Criteria andCarOwnersIdIsNotNull() {
            addCriterion("car_owners_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarOwnersIdEqualTo(String value) {
            addCriterion("car_owners_id =", value, "carOwnersId");
            return (Criteria) this;
        }

        public Criteria andCarOwnersIdNotEqualTo(String value) {
            addCriterion("car_owners_id <>", value, "carOwnersId");
            return (Criteria) this;
        }

        public Criteria andCarOwnersIdGreaterThan(String value) {
            addCriterion("car_owners_id >", value, "carOwnersId");
            return (Criteria) this;
        }

        public Criteria andCarOwnersIdGreaterThanOrEqualTo(String value) {
            addCriterion("car_owners_id >=", value, "carOwnersId");
            return (Criteria) this;
        }

        public Criteria andCarOwnersIdLessThan(String value) {
            addCriterion("car_owners_id <", value, "carOwnersId");
            return (Criteria) this;
        }

        public Criteria andCarOwnersIdLessThanOrEqualTo(String value) {
            addCriterion("car_owners_id <=", value, "carOwnersId");
            return (Criteria) this;
        }

        public Criteria andCarOwnersIdLike(String value) {
            addCriterion("car_owners_id like", value, "carOwnersId");
            return (Criteria) this;
        }

        public Criteria andCarOwnersIdNotLike(String value) {
            addCriterion("car_owners_id not like", value, "carOwnersId");
            return (Criteria) this;
        }

        public Criteria andCarOwnersIdIn(List<String> values) {
            addCriterion("car_owners_id in", values, "carOwnersId");
            return (Criteria) this;
        }

        public Criteria andCarOwnersIdNotIn(List<String> values) {
            addCriterion("car_owners_id not in", values, "carOwnersId");
            return (Criteria) this;
        }

        public Criteria andCarOwnersIdBetween(String value1, String value2) {
            addCriterion("car_owners_id between", value1, value2, "carOwnersId");
            return (Criteria) this;
        }

        public Criteria andCarOwnersIdNotBetween(String value1, String value2) {
            addCriterion("car_owners_id not between", value1, value2, "carOwnersId");
            return (Criteria) this;
        }

        public Criteria andEmailAddressIsNull() {
            addCriterion("email_address is null");
            return (Criteria) this;
        }

        public Criteria andEmailAddressIsNotNull() {
            addCriterion("email_address is not null");
            return (Criteria) this;
        }

        public Criteria andEmailAddressEqualTo(String value) {
            addCriterion("email_address =", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressNotEqualTo(String value) {
            addCriterion("email_address <>", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressGreaterThan(String value) {
            addCriterion("email_address >", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressGreaterThanOrEqualTo(String value) {
            addCriterion("email_address >=", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressLessThan(String value) {
            addCriterion("email_address <", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressLessThanOrEqualTo(String value) {
            addCriterion("email_address <=", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressLike(String value) {
            addCriterion("email_address like", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressNotLike(String value) {
            addCriterion("email_address not like", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressIn(List<String> values) {
            addCriterion("email_address in", values, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressNotIn(List<String> values) {
            addCriterion("email_address not in", values, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressBetween(String value1, String value2) {
            addCriterion("email_address between", value1, value2, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressNotBetween(String value1, String value2) {
            addCriterion("email_address not between", value1, value2, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andIdentifyNumberIsNull() {
            addCriterion("identify_number is null");
            return (Criteria) this;
        }

        public Criteria andIdentifyNumberIsNotNull() {
            addCriterion("identify_number is not null");
            return (Criteria) this;
        }

        public Criteria andIdentifyNumberEqualTo(String value) {
            addCriterion("identify_number =", value, "identifyNumber");
            return (Criteria) this;
        }

        public Criteria andIdentifyNumberNotEqualTo(String value) {
            addCriterion("identify_number <>", value, "identifyNumber");
            return (Criteria) this;
        }

        public Criteria andIdentifyNumberGreaterThan(String value) {
            addCriterion("identify_number >", value, "identifyNumber");
            return (Criteria) this;
        }

        public Criteria andIdentifyNumberGreaterThanOrEqualTo(String value) {
            addCriterion("identify_number >=", value, "identifyNumber");
            return (Criteria) this;
        }

        public Criteria andIdentifyNumberLessThan(String value) {
            addCriterion("identify_number <", value, "identifyNumber");
            return (Criteria) this;
        }

        public Criteria andIdentifyNumberLessThanOrEqualTo(String value) {
            addCriterion("identify_number <=", value, "identifyNumber");
            return (Criteria) this;
        }

        public Criteria andIdentifyNumberLike(String value) {
            addCriterion("identify_number like", value, "identifyNumber");
            return (Criteria) this;
        }

        public Criteria andIdentifyNumberNotLike(String value) {
            addCriterion("identify_number not like", value, "identifyNumber");
            return (Criteria) this;
        }

        public Criteria andIdentifyNumberIn(List<String> values) {
            addCriterion("identify_number in", values, "identifyNumber");
            return (Criteria) this;
        }

        public Criteria andIdentifyNumberNotIn(List<String> values) {
            addCriterion("identify_number not in", values, "identifyNumber");
            return (Criteria) this;
        }

        public Criteria andIdentifyNumberBetween(String value1, String value2) {
            addCriterion("identify_number between", value1, value2, "identifyNumber");
            return (Criteria) this;
        }

        public Criteria andIdentifyNumberNotBetween(String value1, String value2) {
            addCriterion("identify_number not between", value1, value2, "identifyNumber");
            return (Criteria) this;
        }

        public Criteria andIdentifyTypeIsNull() {
            addCriterion("identify_type is null");
            return (Criteria) this;
        }

        public Criteria andIdentifyTypeIsNotNull() {
            addCriterion("identify_type is not null");
            return (Criteria) this;
        }

        public Criteria andIdentifyTypeEqualTo(String value) {
            addCriterion("identify_type =", value, "identifyType");
            return (Criteria) this;
        }

        public Criteria andIdentifyTypeNotEqualTo(String value) {
            addCriterion("identify_type <>", value, "identifyType");
            return (Criteria) this;
        }

        public Criteria andIdentifyTypeGreaterThan(String value) {
            addCriterion("identify_type >", value, "identifyType");
            return (Criteria) this;
        }

        public Criteria andIdentifyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("identify_type >=", value, "identifyType");
            return (Criteria) this;
        }

        public Criteria andIdentifyTypeLessThan(String value) {
            addCriterion("identify_type <", value, "identifyType");
            return (Criteria) this;
        }

        public Criteria andIdentifyTypeLessThanOrEqualTo(String value) {
            addCriterion("identify_type <=", value, "identifyType");
            return (Criteria) this;
        }

        public Criteria andIdentifyTypeLike(String value) {
            addCriterion("identify_type like", value, "identifyType");
            return (Criteria) this;
        }

        public Criteria andIdentifyTypeNotLike(String value) {
            addCriterion("identify_type not like", value, "identifyType");
            return (Criteria) this;
        }

        public Criteria andIdentifyTypeIn(List<String> values) {
            addCriterion("identify_type in", values, "identifyType");
            return (Criteria) this;
        }

        public Criteria andIdentifyTypeNotIn(List<String> values) {
            addCriterion("identify_type not in", values, "identifyType");
            return (Criteria) this;
        }

        public Criteria andIdentifyTypeBetween(String value1, String value2) {
            addCriterion("identify_type between", value1, value2, "identifyType");
            return (Criteria) this;
        }

        public Criteria andIdentifyTypeNotBetween(String value1, String value2) {
            addCriterion("identify_type not between", value1, value2, "identifyType");
            return (Criteria) this;
        }

        public Criteria andInsuredAddressIsNull() {
            addCriterion("insured_address is null");
            return (Criteria) this;
        }

        public Criteria andInsuredAddressIsNotNull() {
            addCriterion("insured_address is not null");
            return (Criteria) this;
        }

        public Criteria andInsuredAddressEqualTo(String value) {
            addCriterion("insured_address =", value, "insuredAddress");
            return (Criteria) this;
        }

        public Criteria andInsuredAddressNotEqualTo(String value) {
            addCriterion("insured_address <>", value, "insuredAddress");
            return (Criteria) this;
        }

        public Criteria andInsuredAddressGreaterThan(String value) {
            addCriterion("insured_address >", value, "insuredAddress");
            return (Criteria) this;
        }

        public Criteria andInsuredAddressGreaterThanOrEqualTo(String value) {
            addCriterion("insured_address >=", value, "insuredAddress");
            return (Criteria) this;
        }

        public Criteria andInsuredAddressLessThan(String value) {
            addCriterion("insured_address <", value, "insuredAddress");
            return (Criteria) this;
        }

        public Criteria andInsuredAddressLessThanOrEqualTo(String value) {
            addCriterion("insured_address <=", value, "insuredAddress");
            return (Criteria) this;
        }

        public Criteria andInsuredAddressLike(String value) {
            addCriterion("insured_address like", value, "insuredAddress");
            return (Criteria) this;
        }

        public Criteria andInsuredAddressNotLike(String value) {
            addCriterion("insured_address not like", value, "insuredAddress");
            return (Criteria) this;
        }

        public Criteria andInsuredAddressIn(List<String> values) {
            addCriterion("insured_address in", values, "insuredAddress");
            return (Criteria) this;
        }

        public Criteria andInsuredAddressNotIn(List<String> values) {
            addCriterion("insured_address not in", values, "insuredAddress");
            return (Criteria) this;
        }

        public Criteria andInsuredAddressBetween(String value1, String value2) {
            addCriterion("insured_address between", value1, value2, "insuredAddress");
            return (Criteria) this;
        }

        public Criteria andInsuredAddressNotBetween(String value1, String value2) {
            addCriterion("insured_address not between", value1, value2, "insuredAddress");
            return (Criteria) this;
        }

        public Criteria andInsuredCodeIsNull() {
            addCriterion("insured_code is null");
            return (Criteria) this;
        }

        public Criteria andInsuredCodeIsNotNull() {
            addCriterion("insured_code is not null");
            return (Criteria) this;
        }

        public Criteria andInsuredCodeEqualTo(String value) {
            addCriterion("insured_code =", value, "insuredCode");
            return (Criteria) this;
        }

        public Criteria andInsuredCodeNotEqualTo(String value) {
            addCriterion("insured_code <>", value, "insuredCode");
            return (Criteria) this;
        }

        public Criteria andInsuredCodeGreaterThan(String value) {
            addCriterion("insured_code >", value, "insuredCode");
            return (Criteria) this;
        }

        public Criteria andInsuredCodeGreaterThanOrEqualTo(String value) {
            addCriterion("insured_code >=", value, "insuredCode");
            return (Criteria) this;
        }

        public Criteria andInsuredCodeLessThan(String value) {
            addCriterion("insured_code <", value, "insuredCode");
            return (Criteria) this;
        }

        public Criteria andInsuredCodeLessThanOrEqualTo(String value) {
            addCriterion("insured_code <=", value, "insuredCode");
            return (Criteria) this;
        }

        public Criteria andInsuredCodeLike(String value) {
            addCriterion("insured_code like", value, "insuredCode");
            return (Criteria) this;
        }

        public Criteria andInsuredCodeNotLike(String value) {
            addCriterion("insured_code not like", value, "insuredCode");
            return (Criteria) this;
        }

        public Criteria andInsuredCodeIn(List<String> values) {
            addCriterion("insured_code in", values, "insuredCode");
            return (Criteria) this;
        }

        public Criteria andInsuredCodeNotIn(List<String> values) {
            addCriterion("insured_code not in", values, "insuredCode");
            return (Criteria) this;
        }

        public Criteria andInsuredCodeBetween(String value1, String value2) {
            addCriterion("insured_code between", value1, value2, "insuredCode");
            return (Criteria) this;
        }

        public Criteria andInsuredCodeNotBetween(String value1, String value2) {
            addCriterion("insured_code not between", value1, value2, "insuredCode");
            return (Criteria) this;
        }

        public Criteria andInsuredFlagIsNull() {
            addCriterion("insured_flag is null");
            return (Criteria) this;
        }

        public Criteria andInsuredFlagIsNotNull() {
            addCriterion("insured_flag is not null");
            return (Criteria) this;
        }

        public Criteria andInsuredFlagEqualTo(String value) {
            addCriterion("insured_flag =", value, "insuredFlag");
            return (Criteria) this;
        }

        public Criteria andInsuredFlagNotEqualTo(String value) {
            addCriterion("insured_flag <>", value, "insuredFlag");
            return (Criteria) this;
        }

        public Criteria andInsuredFlagGreaterThan(String value) {
            addCriterion("insured_flag >", value, "insuredFlag");
            return (Criteria) this;
        }

        public Criteria andInsuredFlagGreaterThanOrEqualTo(String value) {
            addCriterion("insured_flag >=", value, "insuredFlag");
            return (Criteria) this;
        }

        public Criteria andInsuredFlagLessThan(String value) {
            addCriterion("insured_flag <", value, "insuredFlag");
            return (Criteria) this;
        }

        public Criteria andInsuredFlagLessThanOrEqualTo(String value) {
            addCriterion("insured_flag <=", value, "insuredFlag");
            return (Criteria) this;
        }

        public Criteria andInsuredFlagLike(String value) {
            addCriterion("insured_flag like", value, "insuredFlag");
            return (Criteria) this;
        }

        public Criteria andInsuredFlagNotLike(String value) {
            addCriterion("insured_flag not like", value, "insuredFlag");
            return (Criteria) this;
        }

        public Criteria andInsuredFlagIn(List<String> values) {
            addCriterion("insured_flag in", values, "insuredFlag");
            return (Criteria) this;
        }

        public Criteria andInsuredFlagNotIn(List<String> values) {
            addCriterion("insured_flag not in", values, "insuredFlag");
            return (Criteria) this;
        }

        public Criteria andInsuredFlagBetween(String value1, String value2) {
            addCriterion("insured_flag between", value1, value2, "insuredFlag");
            return (Criteria) this;
        }

        public Criteria andInsuredFlagNotBetween(String value1, String value2) {
            addCriterion("insured_flag not between", value1, value2, "insuredFlag");
            return (Criteria) this;
        }

        public Criteria andInsuredFlagnameIsNull() {
            addCriterion("insured_flagName is null");
            return (Criteria) this;
        }

        public Criteria andInsuredFlagnameIsNotNull() {
            addCriterion("insured_flagName is not null");
            return (Criteria) this;
        }

        public Criteria andInsuredFlagnameEqualTo(String value) {
            addCriterion("insured_flagName =", value, "insuredFlagname");
            return (Criteria) this;
        }

        public Criteria andInsuredFlagnameNotEqualTo(String value) {
            addCriterion("insured_flagName <>", value, "insuredFlagname");
            return (Criteria) this;
        }

        public Criteria andInsuredFlagnameGreaterThan(String value) {
            addCriterion("insured_flagName >", value, "insuredFlagname");
            return (Criteria) this;
        }

        public Criteria andInsuredFlagnameGreaterThanOrEqualTo(String value) {
            addCriterion("insured_flagName >=", value, "insuredFlagname");
            return (Criteria) this;
        }

        public Criteria andInsuredFlagnameLessThan(String value) {
            addCriterion("insured_flagName <", value, "insuredFlagname");
            return (Criteria) this;
        }

        public Criteria andInsuredFlagnameLessThanOrEqualTo(String value) {
            addCriterion("insured_flagName <=", value, "insuredFlagname");
            return (Criteria) this;
        }

        public Criteria andInsuredFlagnameLike(String value) {
            addCriterion("insured_flagName like", value, "insuredFlagname");
            return (Criteria) this;
        }

        public Criteria andInsuredFlagnameNotLike(String value) {
            addCriterion("insured_flagName not like", value, "insuredFlagname");
            return (Criteria) this;
        }

        public Criteria andInsuredFlagnameIn(List<String> values) {
            addCriterion("insured_flagName in", values, "insuredFlagname");
            return (Criteria) this;
        }

        public Criteria andInsuredFlagnameNotIn(List<String> values) {
            addCriterion("insured_flagName not in", values, "insuredFlagname");
            return (Criteria) this;
        }

        public Criteria andInsuredFlagnameBetween(String value1, String value2) {
            addCriterion("insured_flagName between", value1, value2, "insuredFlagname");
            return (Criteria) this;
        }

        public Criteria andInsuredFlagnameNotBetween(String value1, String value2) {
            addCriterion("insured_flagName not between", value1, value2, "insuredFlagname");
            return (Criteria) this;
        }

        public Criteria andInsuredNameIsNull() {
            addCriterion("insured_name is null");
            return (Criteria) this;
        }

        public Criteria andInsuredNameIsNotNull() {
            addCriterion("insured_name is not null");
            return (Criteria) this;
        }

        public Criteria andInsuredNameEqualTo(String value) {
            addCriterion("insured_name =", value, "insuredName");
            return (Criteria) this;
        }

        public Criteria andInsuredNameNotEqualTo(String value) {
            addCriterion("insured_name <>", value, "insuredName");
            return (Criteria) this;
        }

        public Criteria andInsuredNameGreaterThan(String value) {
            addCriterion("insured_name >", value, "insuredName");
            return (Criteria) this;
        }

        public Criteria andInsuredNameGreaterThanOrEqualTo(String value) {
            addCriterion("insured_name >=", value, "insuredName");
            return (Criteria) this;
        }

        public Criteria andInsuredNameLessThan(String value) {
            addCriterion("insured_name <", value, "insuredName");
            return (Criteria) this;
        }

        public Criteria andInsuredNameLessThanOrEqualTo(String value) {
            addCriterion("insured_name <=", value, "insuredName");
            return (Criteria) this;
        }

        public Criteria andInsuredNameLike(String value) {
            addCriterion("insured_name like", value, "insuredName");
            return (Criteria) this;
        }

        public Criteria andInsuredNameNotLike(String value) {
            addCriterion("insured_name not like", value, "insuredName");
            return (Criteria) this;
        }

        public Criteria andInsuredNameIn(List<String> values) {
            addCriterion("insured_name in", values, "insuredName");
            return (Criteria) this;
        }

        public Criteria andInsuredNameNotIn(List<String> values) {
            addCriterion("insured_name not in", values, "insuredName");
            return (Criteria) this;
        }

        public Criteria andInsuredNameBetween(String value1, String value2) {
            addCriterion("insured_name between", value1, value2, "insuredName");
            return (Criteria) this;
        }

        public Criteria andInsuredNameNotBetween(String value1, String value2) {
            addCriterion("insured_name not between", value1, value2, "insuredName");
            return (Criteria) this;
        }

        public Criteria andInsuredTypeIsNull() {
            addCriterion("insured_type is null");
            return (Criteria) this;
        }

        public Criteria andInsuredTypeIsNotNull() {
            addCriterion("insured_type is not null");
            return (Criteria) this;
        }

        public Criteria andInsuredTypeEqualTo(String value) {
            addCriterion("insured_type =", value, "insuredType");
            return (Criteria) this;
        }

        public Criteria andInsuredTypeNotEqualTo(String value) {
            addCriterion("insured_type <>", value, "insuredType");
            return (Criteria) this;
        }

        public Criteria andInsuredTypeGreaterThan(String value) {
            addCriterion("insured_type >", value, "insuredType");
            return (Criteria) this;
        }

        public Criteria andInsuredTypeGreaterThanOrEqualTo(String value) {
            addCriterion("insured_type >=", value, "insuredType");
            return (Criteria) this;
        }

        public Criteria andInsuredTypeLessThan(String value) {
            addCriterion("insured_type <", value, "insuredType");
            return (Criteria) this;
        }

        public Criteria andInsuredTypeLessThanOrEqualTo(String value) {
            addCriterion("insured_type <=", value, "insuredType");
            return (Criteria) this;
        }

        public Criteria andInsuredTypeLike(String value) {
            addCriterion("insured_type like", value, "insuredType");
            return (Criteria) this;
        }

        public Criteria andInsuredTypeNotLike(String value) {
            addCriterion("insured_type not like", value, "insuredType");
            return (Criteria) this;
        }

        public Criteria andInsuredTypeIn(List<String> values) {
            addCriterion("insured_type in", values, "insuredType");
            return (Criteria) this;
        }

        public Criteria andInsuredTypeNotIn(List<String> values) {
            addCriterion("insured_type not in", values, "insuredType");
            return (Criteria) this;
        }

        public Criteria andInsuredTypeBetween(String value1, String value2) {
            addCriterion("insured_type between", value1, value2, "insuredType");
            return (Criteria) this;
        }

        public Criteria andInsuredTypeNotBetween(String value1, String value2) {
            addCriterion("insured_type not between", value1, value2, "insuredType");
            return (Criteria) this;
        }

        public Criteria andInsuredTypeNameIsNull() {
            addCriterion("insured_type_name is null");
            return (Criteria) this;
        }

        public Criteria andInsuredTypeNameIsNotNull() {
            addCriterion("insured_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andInsuredTypeNameEqualTo(String value) {
            addCriterion("insured_type_name =", value, "insuredTypeName");
            return (Criteria) this;
        }

        public Criteria andInsuredTypeNameNotEqualTo(String value) {
            addCriterion("insured_type_name <>", value, "insuredTypeName");
            return (Criteria) this;
        }

        public Criteria andInsuredTypeNameGreaterThan(String value) {
            addCriterion("insured_type_name >", value, "insuredTypeName");
            return (Criteria) this;
        }

        public Criteria andInsuredTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("insured_type_name >=", value, "insuredTypeName");
            return (Criteria) this;
        }

        public Criteria andInsuredTypeNameLessThan(String value) {
            addCriterion("insured_type_name <", value, "insuredTypeName");
            return (Criteria) this;
        }

        public Criteria andInsuredTypeNameLessThanOrEqualTo(String value) {
            addCriterion("insured_type_name <=", value, "insuredTypeName");
            return (Criteria) this;
        }

        public Criteria andInsuredTypeNameLike(String value) {
            addCriterion("insured_type_name like", value, "insuredTypeName");
            return (Criteria) this;
        }

        public Criteria andInsuredTypeNameNotLike(String value) {
            addCriterion("insured_type_name not like", value, "insuredTypeName");
            return (Criteria) this;
        }

        public Criteria andInsuredTypeNameIn(List<String> values) {
            addCriterion("insured_type_name in", values, "insuredTypeName");
            return (Criteria) this;
        }

        public Criteria andInsuredTypeNameNotIn(List<String> values) {
            addCriterion("insured_type_name not in", values, "insuredTypeName");
            return (Criteria) this;
        }

        public Criteria andInsuredTypeNameBetween(String value1, String value2) {
            addCriterion("insured_type_name between", value1, value2, "insuredTypeName");
            return (Criteria) this;
        }

        public Criteria andInsuredTypeNameNotBetween(String value1, String value2) {
            addCriterion("insured_type_name not between", value1, value2, "insuredTypeName");
            return (Criteria) this;
        }

        public Criteria andMobileNoIsNull() {
            addCriterion("mobile_no is null");
            return (Criteria) this;
        }

        public Criteria andMobileNoIsNotNull() {
            addCriterion("mobile_no is not null");
            return (Criteria) this;
        }

        public Criteria andMobileNoEqualTo(String value) {
            addCriterion("mobile_no =", value, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoNotEqualTo(String value) {
            addCriterion("mobile_no <>", value, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoGreaterThan(String value) {
            addCriterion("mobile_no >", value, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoGreaterThanOrEqualTo(String value) {
            addCriterion("mobile_no >=", value, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoLessThan(String value) {
            addCriterion("mobile_no <", value, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoLessThanOrEqualTo(String value) {
            addCriterion("mobile_no <=", value, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoLike(String value) {
            addCriterion("mobile_no like", value, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoNotLike(String value) {
            addCriterion("mobile_no not like", value, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoIn(List<String> values) {
            addCriterion("mobile_no in", values, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoNotIn(List<String> values) {
            addCriterion("mobile_no not in", values, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoBetween(String value1, String value2) {
            addCriterion("mobile_no between", value1, value2, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoNotBetween(String value1, String value2) {
            addCriterion("mobile_no not between", value1, value2, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNull() {
            addCriterion("phone_number is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNotNull() {
            addCriterion("phone_number is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberEqualTo(String value) {
            addCriterion("phone_number =", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotEqualTo(String value) {
            addCriterion("phone_number <>", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThan(String value) {
            addCriterion("phone_number >", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThanOrEqualTo(String value) {
            addCriterion("phone_number >=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThan(String value) {
            addCriterion("phone_number <", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThanOrEqualTo(String value) {
            addCriterion("phone_number <=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLike(String value) {
            addCriterion("phone_number like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotLike(String value) {
            addCriterion("phone_number not like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIn(List<String> values) {
            addCriterion("phone_number in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotIn(List<String> values) {
            addCriterion("phone_number not in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberBetween(String value1, String value2) {
            addCriterion("phone_number between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotBetween(String value1, String value2) {
            addCriterion("phone_number not between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andUnitTypeIsNull() {
            addCriterion("unit_type is null");
            return (Criteria) this;
        }

        public Criteria andUnitTypeIsNotNull() {
            addCriterion("unit_type is not null");
            return (Criteria) this;
        }

        public Criteria andUnitTypeEqualTo(String value) {
            addCriterion("unit_type =", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeNotEqualTo(String value) {
            addCriterion("unit_type <>", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeGreaterThan(String value) {
            addCriterion("unit_type >", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeGreaterThanOrEqualTo(String value) {
            addCriterion("unit_type >=", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeLessThan(String value) {
            addCriterion("unit_type <", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeLessThanOrEqualTo(String value) {
            addCriterion("unit_type <=", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeLike(String value) {
            addCriterion("unit_type like", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeNotLike(String value) {
            addCriterion("unit_type not like", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeIn(List<String> values) {
            addCriterion("unit_type in", values, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeNotIn(List<String> values) {
            addCriterion("unit_type not in", values, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeBetween(String value1, String value2) {
            addCriterion("unit_type between", value1, value2, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeNotBetween(String value1, String value2) {
            addCriterion("unit_type not between", value1, value2, "unitType");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNull() {
            addCriterion("update_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNotNull() {
            addCriterion("update_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdEqualTo(String value) {
            addCriterion("update_user_id =", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotEqualTo(String value) {
            addCriterion("update_user_id <>", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThan(String value) {
            addCriterion("update_user_id >", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("update_user_id >=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThan(String value) {
            addCriterion("update_user_id <", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThanOrEqualTo(String value) {
            addCriterion("update_user_id <=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLike(String value) {
            addCriterion("update_user_id like", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotLike(String value) {
            addCriterion("update_user_id not like", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIn(List<String> values) {
            addCriterion("update_user_id in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotIn(List<String> values) {
            addCriterion("update_user_id not in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdBetween(String value1, String value2) {
            addCriterion("update_user_id between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotBetween(String value1, String value2) {
            addCriterion("update_user_id not between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    /**
     * d_car_owner
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * d_car_owner 2019-01-14
     */
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