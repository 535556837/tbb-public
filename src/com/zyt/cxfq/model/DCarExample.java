package com.zyt.cxfq.model;

import com.zyt.cxfq.plugin.page.BootPage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DCarExample {
    /**
     * d_car
     */
    protected String orderByClause;

    /**
     * d_car
     */
    protected boolean distinct;

    /**
     * d_car
     */
    protected List<Criteria> oredCriteria;

    /**
     * d_car
     */
    protected BootPage page;

    /**
     *
     * @mbggenerated 2019-01-17
     */
    public DCarExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbggenerated 2019-01-17
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbggenerated 2019-01-17
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbggenerated 2019-01-17
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbggenerated 2019-01-17
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbggenerated 2019-01-17
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbggenerated 2019-01-17
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbggenerated 2019-01-17
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbggenerated 2019-01-17
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
     * @mbggenerated 2019-01-17
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbggenerated 2019-01-17
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     *
     * @mbggenerated 2019-01-17
     */
    public void setPage(BootPage page) {
        this.page=page;
    }

    /**
     *
     * @mbggenerated 2019-01-17
     */
    public BootPage getPage() {
        return page;
    }

    /**
     * d_car 2019-01-17
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

        public Criteria andCarIdIsNull() {
            addCriterion("car_id is null");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNotNull() {
            addCriterion("car_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarIdEqualTo(String value) {
            addCriterion("car_id =", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotEqualTo(String value) {
            addCriterion("car_id <>", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThan(String value) {
            addCriterion("car_id >", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThanOrEqualTo(String value) {
            addCriterion("car_id >=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThan(String value) {
            addCriterion("car_id <", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThanOrEqualTo(String value) {
            addCriterion("car_id <=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLike(String value) {
            addCriterion("car_id like", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotLike(String value) {
            addCriterion("car_id not like", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdIn(List<String> values) {
            addCriterion("car_id in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotIn(List<String> values) {
            addCriterion("car_id not in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdBetween(String value1, String value2) {
            addCriterion("car_id between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotBetween(String value1, String value2) {
            addCriterion("car_id not between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNull() {
            addCriterion("client_id is null");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNotNull() {
            addCriterion("client_id is not null");
            return (Criteria) this;
        }

        public Criteria andClientIdEqualTo(String value) {
            addCriterion("client_id =", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotEqualTo(String value) {
            addCriterion("client_id <>", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThan(String value) {
            addCriterion("client_id >", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThanOrEqualTo(String value) {
            addCriterion("client_id >=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThan(String value) {
            addCriterion("client_id <", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThanOrEqualTo(String value) {
            addCriterion("client_id <=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLike(String value) {
            addCriterion("client_id like", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotLike(String value) {
            addCriterion("client_id not like", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdIn(List<String> values) {
            addCriterion("client_id in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotIn(List<String> values) {
            addCriterion("client_id not in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdBetween(String value1, String value2) {
            addCriterion("client_id between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotBetween(String value1, String value2) {
            addCriterion("client_id not between", value1, value2, "clientId");
            return (Criteria) this;
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

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andLicenseNoIsNull() {
            addCriterion("license_no is null");
            return (Criteria) this;
        }

        public Criteria andLicenseNoIsNotNull() {
            addCriterion("license_no is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseNoEqualTo(String value) {
            addCriterion("license_no =", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotEqualTo(String value) {
            addCriterion("license_no <>", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoGreaterThan(String value) {
            addCriterion("license_no >", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoGreaterThanOrEqualTo(String value) {
            addCriterion("license_no >=", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoLessThan(String value) {
            addCriterion("license_no <", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoLessThanOrEqualTo(String value) {
            addCriterion("license_no <=", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoLike(String value) {
            addCriterion("license_no like", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotLike(String value) {
            addCriterion("license_no not like", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoIn(List<String> values) {
            addCriterion("license_no in", values, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotIn(List<String> values) {
            addCriterion("license_no not in", values, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoBetween(String value1, String value2) {
            addCriterion("license_no between", value1, value2, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotBetween(String value1, String value2) {
            addCriterion("license_no not between", value1, value2, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andActualValueIsNull() {
            addCriterion("actual_value is null");
            return (Criteria) this;
        }

        public Criteria andActualValueIsNotNull() {
            addCriterion("actual_value is not null");
            return (Criteria) this;
        }

        public Criteria andActualValueEqualTo(String value) {
            addCriterion("actual_value =", value, "actualValue");
            return (Criteria) this;
        }

        public Criteria andActualValueNotEqualTo(String value) {
            addCriterion("actual_value <>", value, "actualValue");
            return (Criteria) this;
        }

        public Criteria andActualValueGreaterThan(String value) {
            addCriterion("actual_value >", value, "actualValue");
            return (Criteria) this;
        }

        public Criteria andActualValueGreaterThanOrEqualTo(String value) {
            addCriterion("actual_value >=", value, "actualValue");
            return (Criteria) this;
        }

        public Criteria andActualValueLessThan(String value) {
            addCriterion("actual_value <", value, "actualValue");
            return (Criteria) this;
        }

        public Criteria andActualValueLessThanOrEqualTo(String value) {
            addCriterion("actual_value <=", value, "actualValue");
            return (Criteria) this;
        }

        public Criteria andActualValueLike(String value) {
            addCriterion("actual_value like", value, "actualValue");
            return (Criteria) this;
        }

        public Criteria andActualValueNotLike(String value) {
            addCriterion("actual_value not like", value, "actualValue");
            return (Criteria) this;
        }

        public Criteria andActualValueIn(List<String> values) {
            addCriterion("actual_value in", values, "actualValue");
            return (Criteria) this;
        }

        public Criteria andActualValueNotIn(List<String> values) {
            addCriterion("actual_value not in", values, "actualValue");
            return (Criteria) this;
        }

        public Criteria andActualValueBetween(String value1, String value2) {
            addCriterion("actual_value between", value1, value2, "actualValue");
            return (Criteria) this;
        }

        public Criteria andActualValueNotBetween(String value1, String value2) {
            addCriterion("actual_value not between", value1, value2, "actualValue");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNull() {
            addCriterion("brand_name is null");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNotNull() {
            addCriterion("brand_name is not null");
            return (Criteria) this;
        }

        public Criteria andBrandNameEqualTo(String value) {
            addCriterion("brand_name =", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotEqualTo(String value) {
            addCriterion("brand_name <>", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThan(String value) {
            addCriterion("brand_name >", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThanOrEqualTo(String value) {
            addCriterion("brand_name >=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThan(String value) {
            addCriterion("brand_name <", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThanOrEqualTo(String value) {
            addCriterion("brand_name <=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLike(String value) {
            addCriterion("brand_name like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotLike(String value) {
            addCriterion("brand_name not like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameIn(List<String> values) {
            addCriterion("brand_name in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotIn(List<String> values) {
            addCriterion("brand_name not in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameBetween(String value1, String value2) {
            addCriterion("brand_name between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotBetween(String value1, String value2) {
            addCriterion("brand_name not between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andCarInsuredRelationIsNull() {
            addCriterion("car_insured_relation is null");
            return (Criteria) this;
        }

        public Criteria andCarInsuredRelationIsNotNull() {
            addCriterion("car_insured_relation is not null");
            return (Criteria) this;
        }

        public Criteria andCarInsuredRelationEqualTo(String value) {
            addCriterion("car_insured_relation =", value, "carInsuredRelation");
            return (Criteria) this;
        }

        public Criteria andCarInsuredRelationNotEqualTo(String value) {
            addCriterion("car_insured_relation <>", value, "carInsuredRelation");
            return (Criteria) this;
        }

        public Criteria andCarInsuredRelationGreaterThan(String value) {
            addCriterion("car_insured_relation >", value, "carInsuredRelation");
            return (Criteria) this;
        }

        public Criteria andCarInsuredRelationGreaterThanOrEqualTo(String value) {
            addCriterion("car_insured_relation >=", value, "carInsuredRelation");
            return (Criteria) this;
        }

        public Criteria andCarInsuredRelationLessThan(String value) {
            addCriterion("car_insured_relation <", value, "carInsuredRelation");
            return (Criteria) this;
        }

        public Criteria andCarInsuredRelationLessThanOrEqualTo(String value) {
            addCriterion("car_insured_relation <=", value, "carInsuredRelation");
            return (Criteria) this;
        }

        public Criteria andCarInsuredRelationLike(String value) {
            addCriterion("car_insured_relation like", value, "carInsuredRelation");
            return (Criteria) this;
        }

        public Criteria andCarInsuredRelationNotLike(String value) {
            addCriterion("car_insured_relation not like", value, "carInsuredRelation");
            return (Criteria) this;
        }

        public Criteria andCarInsuredRelationIn(List<String> values) {
            addCriterion("car_insured_relation in", values, "carInsuredRelation");
            return (Criteria) this;
        }

        public Criteria andCarInsuredRelationNotIn(List<String> values) {
            addCriterion("car_insured_relation not in", values, "carInsuredRelation");
            return (Criteria) this;
        }

        public Criteria andCarInsuredRelationBetween(String value1, String value2) {
            addCriterion("car_insured_relation between", value1, value2, "carInsuredRelation");
            return (Criteria) this;
        }

        public Criteria andCarInsuredRelationNotBetween(String value1, String value2) {
            addCriterion("car_insured_relation not between", value1, value2, "carInsuredRelation");
            return (Criteria) this;
        }

        public Criteria andCarKindCodeIsNull() {
            addCriterion("car_kind_code is null");
            return (Criteria) this;
        }

        public Criteria andCarKindCodeIsNotNull() {
            addCriterion("car_kind_code is not null");
            return (Criteria) this;
        }

        public Criteria andCarKindCodeEqualTo(String value) {
            addCriterion("car_kind_code =", value, "carKindCode");
            return (Criteria) this;
        }

        public Criteria andCarKindCodeNotEqualTo(String value) {
            addCriterion("car_kind_code <>", value, "carKindCode");
            return (Criteria) this;
        }

        public Criteria andCarKindCodeGreaterThan(String value) {
            addCriterion("car_kind_code >", value, "carKindCode");
            return (Criteria) this;
        }

        public Criteria andCarKindCodeGreaterThanOrEqualTo(String value) {
            addCriterion("car_kind_code >=", value, "carKindCode");
            return (Criteria) this;
        }

        public Criteria andCarKindCodeLessThan(String value) {
            addCriterion("car_kind_code <", value, "carKindCode");
            return (Criteria) this;
        }

        public Criteria andCarKindCodeLessThanOrEqualTo(String value) {
            addCriterion("car_kind_code <=", value, "carKindCode");
            return (Criteria) this;
        }

        public Criteria andCarKindCodeLike(String value) {
            addCriterion("car_kind_code like", value, "carKindCode");
            return (Criteria) this;
        }

        public Criteria andCarKindCodeNotLike(String value) {
            addCriterion("car_kind_code not like", value, "carKindCode");
            return (Criteria) this;
        }

        public Criteria andCarKindCodeIn(List<String> values) {
            addCriterion("car_kind_code in", values, "carKindCode");
            return (Criteria) this;
        }

        public Criteria andCarKindCodeNotIn(List<String> values) {
            addCriterion("car_kind_code not in", values, "carKindCode");
            return (Criteria) this;
        }

        public Criteria andCarKindCodeBetween(String value1, String value2) {
            addCriterion("car_kind_code between", value1, value2, "carKindCode");
            return (Criteria) this;
        }

        public Criteria andCarKindCodeNotBetween(String value1, String value2) {
            addCriterion("car_kind_code not between", value1, value2, "carKindCode");
            return (Criteria) this;
        }

        public Criteria andCarKindCodeDesIsNull() {
            addCriterion("car_kind_code_des is null");
            return (Criteria) this;
        }

        public Criteria andCarKindCodeDesIsNotNull() {
            addCriterion("car_kind_code_des is not null");
            return (Criteria) this;
        }

        public Criteria andCarKindCodeDesEqualTo(String value) {
            addCriterion("car_kind_code_des =", value, "carKindCodeDes");
            return (Criteria) this;
        }

        public Criteria andCarKindCodeDesNotEqualTo(String value) {
            addCriterion("car_kind_code_des <>", value, "carKindCodeDes");
            return (Criteria) this;
        }

        public Criteria andCarKindCodeDesGreaterThan(String value) {
            addCriterion("car_kind_code_des >", value, "carKindCodeDes");
            return (Criteria) this;
        }

        public Criteria andCarKindCodeDesGreaterThanOrEqualTo(String value) {
            addCriterion("car_kind_code_des >=", value, "carKindCodeDes");
            return (Criteria) this;
        }

        public Criteria andCarKindCodeDesLessThan(String value) {
            addCriterion("car_kind_code_des <", value, "carKindCodeDes");
            return (Criteria) this;
        }

        public Criteria andCarKindCodeDesLessThanOrEqualTo(String value) {
            addCriterion("car_kind_code_des <=", value, "carKindCodeDes");
            return (Criteria) this;
        }

        public Criteria andCarKindCodeDesLike(String value) {
            addCriterion("car_kind_code_des like", value, "carKindCodeDes");
            return (Criteria) this;
        }

        public Criteria andCarKindCodeDesNotLike(String value) {
            addCriterion("car_kind_code_des not like", value, "carKindCodeDes");
            return (Criteria) this;
        }

        public Criteria andCarKindCodeDesIn(List<String> values) {
            addCriterion("car_kind_code_des in", values, "carKindCodeDes");
            return (Criteria) this;
        }

        public Criteria andCarKindCodeDesNotIn(List<String> values) {
            addCriterion("car_kind_code_des not in", values, "carKindCodeDes");
            return (Criteria) this;
        }

        public Criteria andCarKindCodeDesBetween(String value1, String value2) {
            addCriterion("car_kind_code_des between", value1, value2, "carKindCodeDes");
            return (Criteria) this;
        }

        public Criteria andCarKindCodeDesNotBetween(String value1, String value2) {
            addCriterion("car_kind_code_des not between", value1, value2, "carKindCodeDes");
            return (Criteria) this;
        }

        public Criteria andCarLotEquQualityIsNull() {
            addCriterion("car_lot_equ_quality is null");
            return (Criteria) this;
        }

        public Criteria andCarLotEquQualityIsNotNull() {
            addCriterion("car_lot_equ_quality is not null");
            return (Criteria) this;
        }

        public Criteria andCarLotEquQualityEqualTo(String value) {
            addCriterion("car_lot_equ_quality =", value, "carLotEquQuality");
            return (Criteria) this;
        }

        public Criteria andCarLotEquQualityNotEqualTo(String value) {
            addCriterion("car_lot_equ_quality <>", value, "carLotEquQuality");
            return (Criteria) this;
        }

        public Criteria andCarLotEquQualityGreaterThan(String value) {
            addCriterion("car_lot_equ_quality >", value, "carLotEquQuality");
            return (Criteria) this;
        }

        public Criteria andCarLotEquQualityGreaterThanOrEqualTo(String value) {
            addCriterion("car_lot_equ_quality >=", value, "carLotEquQuality");
            return (Criteria) this;
        }

        public Criteria andCarLotEquQualityLessThan(String value) {
            addCriterion("car_lot_equ_quality <", value, "carLotEquQuality");
            return (Criteria) this;
        }

        public Criteria andCarLotEquQualityLessThanOrEqualTo(String value) {
            addCriterion("car_lot_equ_quality <=", value, "carLotEquQuality");
            return (Criteria) this;
        }

        public Criteria andCarLotEquQualityLike(String value) {
            addCriterion("car_lot_equ_quality like", value, "carLotEquQuality");
            return (Criteria) this;
        }

        public Criteria andCarLotEquQualityNotLike(String value) {
            addCriterion("car_lot_equ_quality not like", value, "carLotEquQuality");
            return (Criteria) this;
        }

        public Criteria andCarLotEquQualityIn(List<String> values) {
            addCriterion("car_lot_equ_quality in", values, "carLotEquQuality");
            return (Criteria) this;
        }

        public Criteria andCarLotEquQualityNotIn(List<String> values) {
            addCriterion("car_lot_equ_quality not in", values, "carLotEquQuality");
            return (Criteria) this;
        }

        public Criteria andCarLotEquQualityBetween(String value1, String value2) {
            addCriterion("car_lot_equ_quality between", value1, value2, "carLotEquQuality");
            return (Criteria) this;
        }

        public Criteria andCarLotEquQualityNotBetween(String value1, String value2) {
            addCriterion("car_lot_equ_quality not between", value1, value2, "carLotEquQuality");
            return (Criteria) this;
        }

        public Criteria andClauseTypeIsNull() {
            addCriterion("clause_type is null");
            return (Criteria) this;
        }

        public Criteria andClauseTypeIsNotNull() {
            addCriterion("clause_type is not null");
            return (Criteria) this;
        }

        public Criteria andClauseTypeEqualTo(String value) {
            addCriterion("clause_type =", value, "clauseType");
            return (Criteria) this;
        }

        public Criteria andClauseTypeNotEqualTo(String value) {
            addCriterion("clause_type <>", value, "clauseType");
            return (Criteria) this;
        }

        public Criteria andClauseTypeGreaterThan(String value) {
            addCriterion("clause_type >", value, "clauseType");
            return (Criteria) this;
        }

        public Criteria andClauseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("clause_type >=", value, "clauseType");
            return (Criteria) this;
        }

        public Criteria andClauseTypeLessThan(String value) {
            addCriterion("clause_type <", value, "clauseType");
            return (Criteria) this;
        }

        public Criteria andClauseTypeLessThanOrEqualTo(String value) {
            addCriterion("clause_type <=", value, "clauseType");
            return (Criteria) this;
        }

        public Criteria andClauseTypeLike(String value) {
            addCriterion("clause_type like", value, "clauseType");
            return (Criteria) this;
        }

        public Criteria andClauseTypeNotLike(String value) {
            addCriterion("clause_type not like", value, "clauseType");
            return (Criteria) this;
        }

        public Criteria andClauseTypeIn(List<String> values) {
            addCriterion("clause_type in", values, "clauseType");
            return (Criteria) this;
        }

        public Criteria andClauseTypeNotIn(List<String> values) {
            addCriterion("clause_type not in", values, "clauseType");
            return (Criteria) this;
        }

        public Criteria andClauseTypeBetween(String value1, String value2) {
            addCriterion("clause_type between", value1, value2, "clauseType");
            return (Criteria) this;
        }

        public Criteria andClauseTypeNotBetween(String value1, String value2) {
            addCriterion("clause_type not between", value1, value2, "clauseType");
            return (Criteria) this;
        }

        public Criteria andCountryNatureIsNull() {
            addCriterion("country_nature is null");
            return (Criteria) this;
        }

        public Criteria andCountryNatureIsNotNull() {
            addCriterion("country_nature is not null");
            return (Criteria) this;
        }

        public Criteria andCountryNatureEqualTo(String value) {
            addCriterion("country_nature =", value, "countryNature");
            return (Criteria) this;
        }

        public Criteria andCountryNatureNotEqualTo(String value) {
            addCriterion("country_nature <>", value, "countryNature");
            return (Criteria) this;
        }

        public Criteria andCountryNatureGreaterThan(String value) {
            addCriterion("country_nature >", value, "countryNature");
            return (Criteria) this;
        }

        public Criteria andCountryNatureGreaterThanOrEqualTo(String value) {
            addCriterion("country_nature >=", value, "countryNature");
            return (Criteria) this;
        }

        public Criteria andCountryNatureLessThan(String value) {
            addCriterion("country_nature <", value, "countryNature");
            return (Criteria) this;
        }

        public Criteria andCountryNatureLessThanOrEqualTo(String value) {
            addCriterion("country_nature <=", value, "countryNature");
            return (Criteria) this;
        }

        public Criteria andCountryNatureLike(String value) {
            addCriterion("country_nature like", value, "countryNature");
            return (Criteria) this;
        }

        public Criteria andCountryNatureNotLike(String value) {
            addCriterion("country_nature not like", value, "countryNature");
            return (Criteria) this;
        }

        public Criteria andCountryNatureIn(List<String> values) {
            addCriterion("country_nature in", values, "countryNature");
            return (Criteria) this;
        }

        public Criteria andCountryNatureNotIn(List<String> values) {
            addCriterion("country_nature not in", values, "countryNature");
            return (Criteria) this;
        }

        public Criteria andCountryNatureBetween(String value1, String value2) {
            addCriterion("country_nature between", value1, value2, "countryNature");
            return (Criteria) this;
        }

        public Criteria andCountryNatureNotBetween(String value1, String value2) {
            addCriterion("country_nature not between", value1, value2, "countryNature");
            return (Criteria) this;
        }

        public Criteria andEnergyType1IsNull() {
            addCriterion("energy_type1 is null");
            return (Criteria) this;
        }

        public Criteria andEnergyType1IsNotNull() {
            addCriterion("energy_type1 is not null");
            return (Criteria) this;
        }

        public Criteria andEnergyType1EqualTo(String value) {
            addCriterion("energy_type1 =", value, "energyType1");
            return (Criteria) this;
        }

        public Criteria andEnergyType1NotEqualTo(String value) {
            addCriterion("energy_type1 <>", value, "energyType1");
            return (Criteria) this;
        }

        public Criteria andEnergyType1GreaterThan(String value) {
            addCriterion("energy_type1 >", value, "energyType1");
            return (Criteria) this;
        }

        public Criteria andEnergyType1GreaterThanOrEqualTo(String value) {
            addCriterion("energy_type1 >=", value, "energyType1");
            return (Criteria) this;
        }

        public Criteria andEnergyType1LessThan(String value) {
            addCriterion("energy_type1 <", value, "energyType1");
            return (Criteria) this;
        }

        public Criteria andEnergyType1LessThanOrEqualTo(String value) {
            addCriterion("energy_type1 <=", value, "energyType1");
            return (Criteria) this;
        }

        public Criteria andEnergyType1Like(String value) {
            addCriterion("energy_type1 like", value, "energyType1");
            return (Criteria) this;
        }

        public Criteria andEnergyType1NotLike(String value) {
            addCriterion("energy_type1 not like", value, "energyType1");
            return (Criteria) this;
        }

        public Criteria andEnergyType1In(List<String> values) {
            addCriterion("energy_type1 in", values, "energyType1");
            return (Criteria) this;
        }

        public Criteria andEnergyType1NotIn(List<String> values) {
            addCriterion("energy_type1 not in", values, "energyType1");
            return (Criteria) this;
        }

        public Criteria andEnergyType1Between(String value1, String value2) {
            addCriterion("energy_type1 between", value1, value2, "energyType1");
            return (Criteria) this;
        }

        public Criteria andEnergyType1NotBetween(String value1, String value2) {
            addCriterion("energy_type1 not between", value1, value2, "energyType1");
            return (Criteria) this;
        }

        public Criteria andEnrollDateIsNull() {
            addCriterion("enroll_date is null");
            return (Criteria) this;
        }

        public Criteria andEnrollDateIsNotNull() {
            addCriterion("enroll_date is not null");
            return (Criteria) this;
        }

        public Criteria andEnrollDateEqualTo(String value) {
            addCriterion("enroll_date =", value, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateNotEqualTo(String value) {
            addCriterion("enroll_date <>", value, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateGreaterThan(String value) {
            addCriterion("enroll_date >", value, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateGreaterThanOrEqualTo(String value) {
            addCriterion("enroll_date >=", value, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateLessThan(String value) {
            addCriterion("enroll_date <", value, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateLessThanOrEqualTo(String value) {
            addCriterion("enroll_date <=", value, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateLike(String value) {
            addCriterion("enroll_date like", value, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateNotLike(String value) {
            addCriterion("enroll_date not like", value, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateIn(List<String> values) {
            addCriterion("enroll_date in", values, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateNotIn(List<String> values) {
            addCriterion("enroll_date not in", values, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateBetween(String value1, String value2) {
            addCriterion("enroll_date between", value1, value2, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateNotBetween(String value1, String value2) {
            addCriterion("enroll_date not between", value1, value2, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andExhaustScaleIsNull() {
            addCriterion("exhaust_scale is null");
            return (Criteria) this;
        }

        public Criteria andExhaustScaleIsNotNull() {
            addCriterion("exhaust_scale is not null");
            return (Criteria) this;
        }

        public Criteria andExhaustScaleEqualTo(String value) {
            addCriterion("exhaust_scale =", value, "exhaustScale");
            return (Criteria) this;
        }

        public Criteria andExhaustScaleNotEqualTo(String value) {
            addCriterion("exhaust_scale <>", value, "exhaustScale");
            return (Criteria) this;
        }

        public Criteria andExhaustScaleGreaterThan(String value) {
            addCriterion("exhaust_scale >", value, "exhaustScale");
            return (Criteria) this;
        }

        public Criteria andExhaustScaleGreaterThanOrEqualTo(String value) {
            addCriterion("exhaust_scale >=", value, "exhaustScale");
            return (Criteria) this;
        }

        public Criteria andExhaustScaleLessThan(String value) {
            addCriterion("exhaust_scale <", value, "exhaustScale");
            return (Criteria) this;
        }

        public Criteria andExhaustScaleLessThanOrEqualTo(String value) {
            addCriterion("exhaust_scale <=", value, "exhaustScale");
            return (Criteria) this;
        }

        public Criteria andExhaustScaleLike(String value) {
            addCriterion("exhaust_scale like", value, "exhaustScale");
            return (Criteria) this;
        }

        public Criteria andExhaustScaleNotLike(String value) {
            addCriterion("exhaust_scale not like", value, "exhaustScale");
            return (Criteria) this;
        }

        public Criteria andExhaustScaleIn(List<String> values) {
            addCriterion("exhaust_scale in", values, "exhaustScale");
            return (Criteria) this;
        }

        public Criteria andExhaustScaleNotIn(List<String> values) {
            addCriterion("exhaust_scale not in", values, "exhaustScale");
            return (Criteria) this;
        }

        public Criteria andExhaustScaleBetween(String value1, String value2) {
            addCriterion("exhaust_scale between", value1, value2, "exhaustScale");
            return (Criteria) this;
        }

        public Criteria andExhaustScaleNotBetween(String value1, String value2) {
            addCriterion("exhaust_scale not between", value1, value2, "exhaustScale");
            return (Criteria) this;
        }

        public Criteria andFrameNoIsNull() {
            addCriterion("frame_no is null");
            return (Criteria) this;
        }

        public Criteria andFrameNoIsNotNull() {
            addCriterion("frame_no is not null");
            return (Criteria) this;
        }

        public Criteria andFrameNoEqualTo(String value) {
            addCriterion("frame_no =", value, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoNotEqualTo(String value) {
            addCriterion("frame_no <>", value, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoGreaterThan(String value) {
            addCriterion("frame_no >", value, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoGreaterThanOrEqualTo(String value) {
            addCriterion("frame_no >=", value, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoLessThan(String value) {
            addCriterion("frame_no <", value, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoLessThanOrEqualTo(String value) {
            addCriterion("frame_no <=", value, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoLike(String value) {
            addCriterion("frame_no like", value, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoNotLike(String value) {
            addCriterion("frame_no not like", value, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoIn(List<String> values) {
            addCriterion("frame_no in", values, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoNotIn(List<String> values) {
            addCriterion("frame_no not in", values, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoBetween(String value1, String value2) {
            addCriterion("frame_no between", value1, value2, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoNotBetween(String value1, String value2) {
            addCriterion("frame_no not between", value1, value2, "frameNo");
            return (Criteria) this;
        }

        public Criteria andHiddenEngineNoIsNull() {
            addCriterion("hidden_engine_no is null");
            return (Criteria) this;
        }

        public Criteria andHiddenEngineNoIsNotNull() {
            addCriterion("hidden_engine_no is not null");
            return (Criteria) this;
        }

        public Criteria andHiddenEngineNoEqualTo(String value) {
            addCriterion("hidden_engine_no =", value, "hiddenEngineNo");
            return (Criteria) this;
        }

        public Criteria andHiddenEngineNoNotEqualTo(String value) {
            addCriterion("hidden_engine_no <>", value, "hiddenEngineNo");
            return (Criteria) this;
        }

        public Criteria andHiddenEngineNoGreaterThan(String value) {
            addCriterion("hidden_engine_no >", value, "hiddenEngineNo");
            return (Criteria) this;
        }

        public Criteria andHiddenEngineNoGreaterThanOrEqualTo(String value) {
            addCriterion("hidden_engine_no >=", value, "hiddenEngineNo");
            return (Criteria) this;
        }

        public Criteria andHiddenEngineNoLessThan(String value) {
            addCriterion("hidden_engine_no <", value, "hiddenEngineNo");
            return (Criteria) this;
        }

        public Criteria andHiddenEngineNoLessThanOrEqualTo(String value) {
            addCriterion("hidden_engine_no <=", value, "hiddenEngineNo");
            return (Criteria) this;
        }

        public Criteria andHiddenEngineNoLike(String value) {
            addCriterion("hidden_engine_no like", value, "hiddenEngineNo");
            return (Criteria) this;
        }

        public Criteria andHiddenEngineNoNotLike(String value) {
            addCriterion("hidden_engine_no not like", value, "hiddenEngineNo");
            return (Criteria) this;
        }

        public Criteria andHiddenEngineNoIn(List<String> values) {
            addCriterion("hidden_engine_no in", values, "hiddenEngineNo");
            return (Criteria) this;
        }

        public Criteria andHiddenEngineNoNotIn(List<String> values) {
            addCriterion("hidden_engine_no not in", values, "hiddenEngineNo");
            return (Criteria) this;
        }

        public Criteria andHiddenEngineNoBetween(String value1, String value2) {
            addCriterion("hidden_engine_no between", value1, value2, "hiddenEngineNo");
            return (Criteria) this;
        }

        public Criteria andHiddenEngineNoNotBetween(String value1, String value2) {
            addCriterion("hidden_engine_no not between", value1, value2, "hiddenEngineNo");
            return (Criteria) this;
        }

        public Criteria andIsEnergyCarIsNull() {
            addCriterion("is_energy_car is null");
            return (Criteria) this;
        }

        public Criteria andIsEnergyCarIsNotNull() {
            addCriterion("is_energy_car is not null");
            return (Criteria) this;
        }

        public Criteria andIsEnergyCarEqualTo(String value) {
            addCriterion("is_energy_car =", value, "isEnergyCar");
            return (Criteria) this;
        }

        public Criteria andIsEnergyCarNotEqualTo(String value) {
            addCriterion("is_energy_car <>", value, "isEnergyCar");
            return (Criteria) this;
        }

        public Criteria andIsEnergyCarGreaterThan(String value) {
            addCriterion("is_energy_car >", value, "isEnergyCar");
            return (Criteria) this;
        }

        public Criteria andIsEnergyCarGreaterThanOrEqualTo(String value) {
            addCriterion("is_energy_car >=", value, "isEnergyCar");
            return (Criteria) this;
        }

        public Criteria andIsEnergyCarLessThan(String value) {
            addCriterion("is_energy_car <", value, "isEnergyCar");
            return (Criteria) this;
        }

        public Criteria andIsEnergyCarLessThanOrEqualTo(String value) {
            addCriterion("is_energy_car <=", value, "isEnergyCar");
            return (Criteria) this;
        }

        public Criteria andIsEnergyCarLike(String value) {
            addCriterion("is_energy_car like", value, "isEnergyCar");
            return (Criteria) this;
        }

        public Criteria andIsEnergyCarNotLike(String value) {
            addCriterion("is_energy_car not like", value, "isEnergyCar");
            return (Criteria) this;
        }

        public Criteria andIsEnergyCarIn(List<String> values) {
            addCriterion("is_energy_car in", values, "isEnergyCar");
            return (Criteria) this;
        }

        public Criteria andIsEnergyCarNotIn(List<String> values) {
            addCriterion("is_energy_car not in", values, "isEnergyCar");
            return (Criteria) this;
        }

        public Criteria andIsEnergyCarBetween(String value1, String value2) {
            addCriterion("is_energy_car between", value1, value2, "isEnergyCar");
            return (Criteria) this;
        }

        public Criteria andIsEnergyCarNotBetween(String value1, String value2) {
            addCriterion("is_energy_car not between", value1, value2, "isEnergyCar");
            return (Criteria) this;
        }

        public Criteria andLicenseColorCodeDesIsNull() {
            addCriterion("license_color_code_des is null");
            return (Criteria) this;
        }

        public Criteria andLicenseColorCodeDesIsNotNull() {
            addCriterion("license_color_code_des is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseColorCodeDesEqualTo(String value) {
            addCriterion("license_color_code_des =", value, "licenseColorCodeDes");
            return (Criteria) this;
        }

        public Criteria andLicenseColorCodeDesNotEqualTo(String value) {
            addCriterion("license_color_code_des <>", value, "licenseColorCodeDes");
            return (Criteria) this;
        }

        public Criteria andLicenseColorCodeDesGreaterThan(String value) {
            addCriterion("license_color_code_des >", value, "licenseColorCodeDes");
            return (Criteria) this;
        }

        public Criteria andLicenseColorCodeDesGreaterThanOrEqualTo(String value) {
            addCriterion("license_color_code_des >=", value, "licenseColorCodeDes");
            return (Criteria) this;
        }

        public Criteria andLicenseColorCodeDesLessThan(String value) {
            addCriterion("license_color_code_des <", value, "licenseColorCodeDes");
            return (Criteria) this;
        }

        public Criteria andLicenseColorCodeDesLessThanOrEqualTo(String value) {
            addCriterion("license_color_code_des <=", value, "licenseColorCodeDes");
            return (Criteria) this;
        }

        public Criteria andLicenseColorCodeDesLike(String value) {
            addCriterion("license_color_code_des like", value, "licenseColorCodeDes");
            return (Criteria) this;
        }

        public Criteria andLicenseColorCodeDesNotLike(String value) {
            addCriterion("license_color_code_des not like", value, "licenseColorCodeDes");
            return (Criteria) this;
        }

        public Criteria andLicenseColorCodeDesIn(List<String> values) {
            addCriterion("license_color_code_des in", values, "licenseColorCodeDes");
            return (Criteria) this;
        }

        public Criteria andLicenseColorCodeDesNotIn(List<String> values) {
            addCriterion("license_color_code_des not in", values, "licenseColorCodeDes");
            return (Criteria) this;
        }

        public Criteria andLicenseColorCodeDesBetween(String value1, String value2) {
            addCriterion("license_color_code_des between", value1, value2, "licenseColorCodeDes");
            return (Criteria) this;
        }

        public Criteria andLicenseColorCodeDesNotBetween(String value1, String value2) {
            addCriterion("license_color_code_des not between", value1, value2, "licenseColorCodeDes");
            return (Criteria) this;
        }

        public Criteria andLicenseFlagIsNull() {
            addCriterion("license_flag is null");
            return (Criteria) this;
        }

        public Criteria andLicenseFlagIsNotNull() {
            addCriterion("license_flag is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseFlagEqualTo(String value) {
            addCriterion("license_flag =", value, "licenseFlag");
            return (Criteria) this;
        }

        public Criteria andLicenseFlagNotEqualTo(String value) {
            addCriterion("license_flag <>", value, "licenseFlag");
            return (Criteria) this;
        }

        public Criteria andLicenseFlagGreaterThan(String value) {
            addCriterion("license_flag >", value, "licenseFlag");
            return (Criteria) this;
        }

        public Criteria andLicenseFlagGreaterThanOrEqualTo(String value) {
            addCriterion("license_flag >=", value, "licenseFlag");
            return (Criteria) this;
        }

        public Criteria andLicenseFlagLessThan(String value) {
            addCriterion("license_flag <", value, "licenseFlag");
            return (Criteria) this;
        }

        public Criteria andLicenseFlagLessThanOrEqualTo(String value) {
            addCriterion("license_flag <=", value, "licenseFlag");
            return (Criteria) this;
        }

        public Criteria andLicenseFlagLike(String value) {
            addCriterion("license_flag like", value, "licenseFlag");
            return (Criteria) this;
        }

        public Criteria andLicenseFlagNotLike(String value) {
            addCriterion("license_flag not like", value, "licenseFlag");
            return (Criteria) this;
        }

        public Criteria andLicenseFlagIn(List<String> values) {
            addCriterion("license_flag in", values, "licenseFlag");
            return (Criteria) this;
        }

        public Criteria andLicenseFlagNotIn(List<String> values) {
            addCriterion("license_flag not in", values, "licenseFlag");
            return (Criteria) this;
        }

        public Criteria andLicenseFlagBetween(String value1, String value2) {
            addCriterion("license_flag between", value1, value2, "licenseFlag");
            return (Criteria) this;
        }

        public Criteria andLicenseFlagNotBetween(String value1, String value2) {
            addCriterion("license_flag not between", value1, value2, "licenseFlag");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeDesIsNull() {
            addCriterion("license_type_des is null");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeDesIsNotNull() {
            addCriterion("license_type_des is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeDesEqualTo(String value) {
            addCriterion("license_type_des =", value, "licenseTypeDes");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeDesNotEqualTo(String value) {
            addCriterion("license_type_des <>", value, "licenseTypeDes");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeDesGreaterThan(String value) {
            addCriterion("license_type_des >", value, "licenseTypeDes");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeDesGreaterThanOrEqualTo(String value) {
            addCriterion("license_type_des >=", value, "licenseTypeDes");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeDesLessThan(String value) {
            addCriterion("license_type_des <", value, "licenseTypeDes");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeDesLessThanOrEqualTo(String value) {
            addCriterion("license_type_des <=", value, "licenseTypeDes");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeDesLike(String value) {
            addCriterion("license_type_des like", value, "licenseTypeDes");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeDesNotLike(String value) {
            addCriterion("license_type_des not like", value, "licenseTypeDes");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeDesIn(List<String> values) {
            addCriterion("license_type_des in", values, "licenseTypeDes");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeDesNotIn(List<String> values) {
            addCriterion("license_type_des not in", values, "licenseTypeDes");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeDesBetween(String value1, String value2) {
            addCriterion("license_type_des between", value1, value2, "licenseTypeDes");
            return (Criteria) this;
        }

        public Criteria andLicenseTypeDesNotBetween(String value1, String value2) {
            addCriterion("license_type_des not between", value1, value2, "licenseTypeDes");
            return (Criteria) this;
        }

        public Criteria andLoanVehicleFlagIsNull() {
            addCriterion("loan_vehicle_flag is null");
            return (Criteria) this;
        }

        public Criteria andLoanVehicleFlagIsNotNull() {
            addCriterion("loan_vehicle_flag is not null");
            return (Criteria) this;
        }

        public Criteria andLoanVehicleFlagEqualTo(String value) {
            addCriterion("loan_vehicle_flag =", value, "loanVehicleFlag");
            return (Criteria) this;
        }

        public Criteria andLoanVehicleFlagNotEqualTo(String value) {
            addCriterion("loan_vehicle_flag <>", value, "loanVehicleFlag");
            return (Criteria) this;
        }

        public Criteria andLoanVehicleFlagGreaterThan(String value) {
            addCriterion("loan_vehicle_flag >", value, "loanVehicleFlag");
            return (Criteria) this;
        }

        public Criteria andLoanVehicleFlagGreaterThanOrEqualTo(String value) {
            addCriterion("loan_vehicle_flag >=", value, "loanVehicleFlag");
            return (Criteria) this;
        }

        public Criteria andLoanVehicleFlagLessThan(String value) {
            addCriterion("loan_vehicle_flag <", value, "loanVehicleFlag");
            return (Criteria) this;
        }

        public Criteria andLoanVehicleFlagLessThanOrEqualTo(String value) {
            addCriterion("loan_vehicle_flag <=", value, "loanVehicleFlag");
            return (Criteria) this;
        }

        public Criteria andLoanVehicleFlagLike(String value) {
            addCriterion("loan_vehicle_flag like", value, "loanVehicleFlag");
            return (Criteria) this;
        }

        public Criteria andLoanVehicleFlagNotLike(String value) {
            addCriterion("loan_vehicle_flag not like", value, "loanVehicleFlag");
            return (Criteria) this;
        }

        public Criteria andLoanVehicleFlagIn(List<String> values) {
            addCriterion("loan_vehicle_flag in", values, "loanVehicleFlag");
            return (Criteria) this;
        }

        public Criteria andLoanVehicleFlagNotIn(List<String> values) {
            addCriterion("loan_vehicle_flag not in", values, "loanVehicleFlag");
            return (Criteria) this;
        }

        public Criteria andLoanVehicleFlagBetween(String value1, String value2) {
            addCriterion("loan_vehicle_flag between", value1, value2, "loanVehicleFlag");
            return (Criteria) this;
        }

        public Criteria andLoanVehicleFlagNotBetween(String value1, String value2) {
            addCriterion("loan_vehicle_flag not between", value1, value2, "loanVehicleFlag");
            return (Criteria) this;
        }

        public Criteria andModelCodeIsNull() {
            addCriterion("model_code is null");
            return (Criteria) this;
        }

        public Criteria andModelCodeIsNotNull() {
            addCriterion("model_code is not null");
            return (Criteria) this;
        }

        public Criteria andModelCodeEqualTo(String value) {
            addCriterion("model_code =", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeNotEqualTo(String value) {
            addCriterion("model_code <>", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeGreaterThan(String value) {
            addCriterion("model_code >", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("model_code >=", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeLessThan(String value) {
            addCriterion("model_code <", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeLessThanOrEqualTo(String value) {
            addCriterion("model_code <=", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeLike(String value) {
            addCriterion("model_code like", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeNotLike(String value) {
            addCriterion("model_code not like", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeIn(List<String> values) {
            addCriterion("model_code in", values, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeNotIn(List<String> values) {
            addCriterion("model_code not in", values, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeBetween(String value1, String value2) {
            addCriterion("model_code between", value1, value2, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeNotBetween(String value1, String value2) {
            addCriterion("model_code not between", value1, value2, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeAliasIsNull() {
            addCriterion("model_code_alias is null");
            return (Criteria) this;
        }

        public Criteria andModelCodeAliasIsNotNull() {
            addCriterion("model_code_alias is not null");
            return (Criteria) this;
        }

        public Criteria andModelCodeAliasEqualTo(String value) {
            addCriterion("model_code_alias =", value, "modelCodeAlias");
            return (Criteria) this;
        }

        public Criteria andModelCodeAliasNotEqualTo(String value) {
            addCriterion("model_code_alias <>", value, "modelCodeAlias");
            return (Criteria) this;
        }

        public Criteria andModelCodeAliasGreaterThan(String value) {
            addCriterion("model_code_alias >", value, "modelCodeAlias");
            return (Criteria) this;
        }

        public Criteria andModelCodeAliasGreaterThanOrEqualTo(String value) {
            addCriterion("model_code_alias >=", value, "modelCodeAlias");
            return (Criteria) this;
        }

        public Criteria andModelCodeAliasLessThan(String value) {
            addCriterion("model_code_alias <", value, "modelCodeAlias");
            return (Criteria) this;
        }

        public Criteria andModelCodeAliasLessThanOrEqualTo(String value) {
            addCriterion("model_code_alias <=", value, "modelCodeAlias");
            return (Criteria) this;
        }

        public Criteria andModelCodeAliasLike(String value) {
            addCriterion("model_code_alias like", value, "modelCodeAlias");
            return (Criteria) this;
        }

        public Criteria andModelCodeAliasNotLike(String value) {
            addCriterion("model_code_alias not like", value, "modelCodeAlias");
            return (Criteria) this;
        }

        public Criteria andModelCodeAliasIn(List<String> values) {
            addCriterion("model_code_alias in", values, "modelCodeAlias");
            return (Criteria) this;
        }

        public Criteria andModelCodeAliasNotIn(List<String> values) {
            addCriterion("model_code_alias not in", values, "modelCodeAlias");
            return (Criteria) this;
        }

        public Criteria andModelCodeAliasBetween(String value1, String value2) {
            addCriterion("model_code_alias between", value1, value2, "modelCodeAlias");
            return (Criteria) this;
        }

        public Criteria andModelCodeAliasNotBetween(String value1, String value2) {
            addCriterion("model_code_alias not between", value1, value2, "modelCodeAlias");
            return (Criteria) this;
        }

        public Criteria andMonopolyCodeIsNull() {
            addCriterion("monopoly_code is null");
            return (Criteria) this;
        }

        public Criteria andMonopolyCodeIsNotNull() {
            addCriterion("monopoly_code is not null");
            return (Criteria) this;
        }

        public Criteria andMonopolyCodeEqualTo(String value) {
            addCriterion("monopoly_code =", value, "monopolyCode");
            return (Criteria) this;
        }

        public Criteria andMonopolyCodeNotEqualTo(String value) {
            addCriterion("monopoly_code <>", value, "monopolyCode");
            return (Criteria) this;
        }

        public Criteria andMonopolyCodeGreaterThan(String value) {
            addCriterion("monopoly_code >", value, "monopolyCode");
            return (Criteria) this;
        }

        public Criteria andMonopolyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("monopoly_code >=", value, "monopolyCode");
            return (Criteria) this;
        }

        public Criteria andMonopolyCodeLessThan(String value) {
            addCriterion("monopoly_code <", value, "monopolyCode");
            return (Criteria) this;
        }

        public Criteria andMonopolyCodeLessThanOrEqualTo(String value) {
            addCriterion("monopoly_code <=", value, "monopolyCode");
            return (Criteria) this;
        }

        public Criteria andMonopolyCodeLike(String value) {
            addCriterion("monopoly_code like", value, "monopolyCode");
            return (Criteria) this;
        }

        public Criteria andMonopolyCodeNotLike(String value) {
            addCriterion("monopoly_code not like", value, "monopolyCode");
            return (Criteria) this;
        }

        public Criteria andMonopolyCodeIn(List<String> values) {
            addCriterion("monopoly_code in", values, "monopolyCode");
            return (Criteria) this;
        }

        public Criteria andMonopolyCodeNotIn(List<String> values) {
            addCriterion("monopoly_code not in", values, "monopolyCode");
            return (Criteria) this;
        }

        public Criteria andMonopolyCodeBetween(String value1, String value2) {
            addCriterion("monopoly_code between", value1, value2, "monopolyCode");
            return (Criteria) this;
        }

        public Criteria andMonopolyCodeNotBetween(String value1, String value2) {
            addCriterion("monopoly_code not between", value1, value2, "monopolyCode");
            return (Criteria) this;
        }

        public Criteria andMonopolyFlagIsNull() {
            addCriterion("monopoly_flag is null");
            return (Criteria) this;
        }

        public Criteria andMonopolyFlagIsNotNull() {
            addCriterion("monopoly_flag is not null");
            return (Criteria) this;
        }

        public Criteria andMonopolyFlagEqualTo(String value) {
            addCriterion("monopoly_flag =", value, "monopolyFlag");
            return (Criteria) this;
        }

        public Criteria andMonopolyFlagNotEqualTo(String value) {
            addCriterion("monopoly_flag <>", value, "monopolyFlag");
            return (Criteria) this;
        }

        public Criteria andMonopolyFlagGreaterThan(String value) {
            addCriterion("monopoly_flag >", value, "monopolyFlag");
            return (Criteria) this;
        }

        public Criteria andMonopolyFlagGreaterThanOrEqualTo(String value) {
            addCriterion("monopoly_flag >=", value, "monopolyFlag");
            return (Criteria) this;
        }

        public Criteria andMonopolyFlagLessThan(String value) {
            addCriterion("monopoly_flag <", value, "monopolyFlag");
            return (Criteria) this;
        }

        public Criteria andMonopolyFlagLessThanOrEqualTo(String value) {
            addCriterion("monopoly_flag <=", value, "monopolyFlag");
            return (Criteria) this;
        }

        public Criteria andMonopolyFlagLike(String value) {
            addCriterion("monopoly_flag like", value, "monopolyFlag");
            return (Criteria) this;
        }

        public Criteria andMonopolyFlagNotLike(String value) {
            addCriterion("monopoly_flag not like", value, "monopolyFlag");
            return (Criteria) this;
        }

        public Criteria andMonopolyFlagIn(List<String> values) {
            addCriterion("monopoly_flag in", values, "monopolyFlag");
            return (Criteria) this;
        }

        public Criteria andMonopolyFlagNotIn(List<String> values) {
            addCriterion("monopoly_flag not in", values, "monopolyFlag");
            return (Criteria) this;
        }

        public Criteria andMonopolyFlagBetween(String value1, String value2) {
            addCriterion("monopoly_flag between", value1, value2, "monopolyFlag");
            return (Criteria) this;
        }

        public Criteria andMonopolyFlagNotBetween(String value1, String value2) {
            addCriterion("monopoly_flag not between", value1, value2, "monopolyFlag");
            return (Criteria) this;
        }

        public Criteria andMonopolyNameIsNull() {
            addCriterion("monopoly_name is null");
            return (Criteria) this;
        }

        public Criteria andMonopolyNameIsNotNull() {
            addCriterion("monopoly_name is not null");
            return (Criteria) this;
        }

        public Criteria andMonopolyNameEqualTo(String value) {
            addCriterion("monopoly_name =", value, "monopolyName");
            return (Criteria) this;
        }

        public Criteria andMonopolyNameNotEqualTo(String value) {
            addCriterion("monopoly_name <>", value, "monopolyName");
            return (Criteria) this;
        }

        public Criteria andMonopolyNameGreaterThan(String value) {
            addCriterion("monopoly_name >", value, "monopolyName");
            return (Criteria) this;
        }

        public Criteria andMonopolyNameGreaterThanOrEqualTo(String value) {
            addCriterion("monopoly_name >=", value, "monopolyName");
            return (Criteria) this;
        }

        public Criteria andMonopolyNameLessThan(String value) {
            addCriterion("monopoly_name <", value, "monopolyName");
            return (Criteria) this;
        }

        public Criteria andMonopolyNameLessThanOrEqualTo(String value) {
            addCriterion("monopoly_name <=", value, "monopolyName");
            return (Criteria) this;
        }

        public Criteria andMonopolyNameLike(String value) {
            addCriterion("monopoly_name like", value, "monopolyName");
            return (Criteria) this;
        }

        public Criteria andMonopolyNameNotLike(String value) {
            addCriterion("monopoly_name not like", value, "monopolyName");
            return (Criteria) this;
        }

        public Criteria andMonopolyNameIn(List<String> values) {
            addCriterion("monopoly_name in", values, "monopolyName");
            return (Criteria) this;
        }

        public Criteria andMonopolyNameNotIn(List<String> values) {
            addCriterion("monopoly_name not in", values, "monopolyName");
            return (Criteria) this;
        }

        public Criteria andMonopolyNameBetween(String value1, String value2) {
            addCriterion("monopoly_name between", value1, value2, "monopolyName");
            return (Criteria) this;
        }

        public Criteria andMonopolyNameNotBetween(String value1, String value2) {
            addCriterion("monopoly_name not between", value1, value2, "monopolyName");
            return (Criteria) this;
        }

        public Criteria andNewCarFlagIsNull() {
            addCriterion("new_car_flag is null");
            return (Criteria) this;
        }

        public Criteria andNewCarFlagIsNotNull() {
            addCriterion("new_car_flag is not null");
            return (Criteria) this;
        }

        public Criteria andNewCarFlagEqualTo(String value) {
            addCriterion("new_car_flag =", value, "newCarFlag");
            return (Criteria) this;
        }

        public Criteria andNewCarFlagNotEqualTo(String value) {
            addCriterion("new_car_flag <>", value, "newCarFlag");
            return (Criteria) this;
        }

        public Criteria andNewCarFlagGreaterThan(String value) {
            addCriterion("new_car_flag >", value, "newCarFlag");
            return (Criteria) this;
        }

        public Criteria andNewCarFlagGreaterThanOrEqualTo(String value) {
            addCriterion("new_car_flag >=", value, "newCarFlag");
            return (Criteria) this;
        }

        public Criteria andNewCarFlagLessThan(String value) {
            addCriterion("new_car_flag <", value, "newCarFlag");
            return (Criteria) this;
        }

        public Criteria andNewCarFlagLessThanOrEqualTo(String value) {
            addCriterion("new_car_flag <=", value, "newCarFlag");
            return (Criteria) this;
        }

        public Criteria andNewCarFlagLike(String value) {
            addCriterion("new_car_flag like", value, "newCarFlag");
            return (Criteria) this;
        }

        public Criteria andNewCarFlagNotLike(String value) {
            addCriterion("new_car_flag not like", value, "newCarFlag");
            return (Criteria) this;
        }

        public Criteria andNewCarFlagIn(List<String> values) {
            addCriterion("new_car_flag in", values, "newCarFlag");
            return (Criteria) this;
        }

        public Criteria andNewCarFlagNotIn(List<String> values) {
            addCriterion("new_car_flag not in", values, "newCarFlag");
            return (Criteria) this;
        }

        public Criteria andNewCarFlagBetween(String value1, String value2) {
            addCriterion("new_car_flag between", value1, value2, "newCarFlag");
            return (Criteria) this;
        }

        public Criteria andNewCarFlagNotBetween(String value1, String value2) {
            addCriterion("new_car_flag not between", value1, value2, "newCarFlag");
            return (Criteria) this;
        }

        public Criteria andNoNlocalFlagIsNull() {
            addCriterion("no_nlocal_flag is null");
            return (Criteria) this;
        }

        public Criteria andNoNlocalFlagIsNotNull() {
            addCriterion("no_nlocal_flag is not null");
            return (Criteria) this;
        }

        public Criteria andNoNlocalFlagEqualTo(String value) {
            addCriterion("no_nlocal_flag =", value, "noNlocalFlag");
            return (Criteria) this;
        }

        public Criteria andNoNlocalFlagNotEqualTo(String value) {
            addCriterion("no_nlocal_flag <>", value, "noNlocalFlag");
            return (Criteria) this;
        }

        public Criteria andNoNlocalFlagGreaterThan(String value) {
            addCriterion("no_nlocal_flag >", value, "noNlocalFlag");
            return (Criteria) this;
        }

        public Criteria andNoNlocalFlagGreaterThanOrEqualTo(String value) {
            addCriterion("no_nlocal_flag >=", value, "noNlocalFlag");
            return (Criteria) this;
        }

        public Criteria andNoNlocalFlagLessThan(String value) {
            addCriterion("no_nlocal_flag <", value, "noNlocalFlag");
            return (Criteria) this;
        }

        public Criteria andNoNlocalFlagLessThanOrEqualTo(String value) {
            addCriterion("no_nlocal_flag <=", value, "noNlocalFlag");
            return (Criteria) this;
        }

        public Criteria andNoNlocalFlagLike(String value) {
            addCriterion("no_nlocal_flag like", value, "noNlocalFlag");
            return (Criteria) this;
        }

        public Criteria andNoNlocalFlagNotLike(String value) {
            addCriterion("no_nlocal_flag not like", value, "noNlocalFlag");
            return (Criteria) this;
        }

        public Criteria andNoNlocalFlagIn(List<String> values) {
            addCriterion("no_nlocal_flag in", values, "noNlocalFlag");
            return (Criteria) this;
        }

        public Criteria andNoNlocalFlagNotIn(List<String> values) {
            addCriterion("no_nlocal_flag not in", values, "noNlocalFlag");
            return (Criteria) this;
        }

        public Criteria andNoNlocalFlagBetween(String value1, String value2) {
            addCriterion("no_nlocal_flag between", value1, value2, "noNlocalFlag");
            return (Criteria) this;
        }

        public Criteria andNoNlocalFlagNotBetween(String value1, String value2) {
            addCriterion("no_nlocal_flag not between", value1, value2, "noNlocalFlag");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceIsNull() {
            addCriterion("purchase_price is null");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceIsNotNull() {
            addCriterion("purchase_price is not null");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceEqualTo(String value) {
            addCriterion("purchase_price =", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceNotEqualTo(String value) {
            addCriterion("purchase_price <>", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceGreaterThan(String value) {
            addCriterion("purchase_price >", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_price >=", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceLessThan(String value) {
            addCriterion("purchase_price <", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceLessThanOrEqualTo(String value) {
            addCriterion("purchase_price <=", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceLike(String value) {
            addCriterion("purchase_price like", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceNotLike(String value) {
            addCriterion("purchase_price not like", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceIn(List<String> values) {
            addCriterion("purchase_price in", values, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceNotIn(List<String> values) {
            addCriterion("purchase_price not in", values, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceBetween(String value1, String value2) {
            addCriterion("purchase_price between", value1, value2, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceNotBetween(String value1, String value2) {
            addCriterion("purchase_price not between", value1, value2, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andQueryAreaCodeIsNull() {
            addCriterion("query_area_code is null");
            return (Criteria) this;
        }

        public Criteria andQueryAreaCodeIsNotNull() {
            addCriterion("query_area_code is not null");
            return (Criteria) this;
        }

        public Criteria andQueryAreaCodeEqualTo(String value) {
            addCriterion("query_area_code =", value, "queryAreaCode");
            return (Criteria) this;
        }

        public Criteria andQueryAreaCodeNotEqualTo(String value) {
            addCriterion("query_area_code <>", value, "queryAreaCode");
            return (Criteria) this;
        }

        public Criteria andQueryAreaCodeGreaterThan(String value) {
            addCriterion("query_area_code >", value, "queryAreaCode");
            return (Criteria) this;
        }

        public Criteria andQueryAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("query_area_code >=", value, "queryAreaCode");
            return (Criteria) this;
        }

        public Criteria andQueryAreaCodeLessThan(String value) {
            addCriterion("query_area_code <", value, "queryAreaCode");
            return (Criteria) this;
        }

        public Criteria andQueryAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("query_area_code <=", value, "queryAreaCode");
            return (Criteria) this;
        }

        public Criteria andQueryAreaCodeLike(String value) {
            addCriterion("query_area_code like", value, "queryAreaCode");
            return (Criteria) this;
        }

        public Criteria andQueryAreaCodeNotLike(String value) {
            addCriterion("query_area_code not like", value, "queryAreaCode");
            return (Criteria) this;
        }

        public Criteria andQueryAreaCodeIn(List<String> values) {
            addCriterion("query_area_code in", values, "queryAreaCode");
            return (Criteria) this;
        }

        public Criteria andQueryAreaCodeNotIn(List<String> values) {
            addCriterion("query_area_code not in", values, "queryAreaCode");
            return (Criteria) this;
        }

        public Criteria andQueryAreaCodeBetween(String value1, String value2) {
            addCriterion("query_area_code between", value1, value2, "queryAreaCode");
            return (Criteria) this;
        }

        public Criteria andQueryAreaCodeNotBetween(String value1, String value2) {
            addCriterion("query_area_code not between", value1, value2, "queryAreaCode");
            return (Criteria) this;
        }

        public Criteria andQueryAreaNameIsNull() {
            addCriterion("query_area_name is null");
            return (Criteria) this;
        }

        public Criteria andQueryAreaNameIsNotNull() {
            addCriterion("query_area_name is not null");
            return (Criteria) this;
        }

        public Criteria andQueryAreaNameEqualTo(String value) {
            addCriterion("query_area_name =", value, "queryAreaName");
            return (Criteria) this;
        }

        public Criteria andQueryAreaNameNotEqualTo(String value) {
            addCriterion("query_area_name <>", value, "queryAreaName");
            return (Criteria) this;
        }

        public Criteria andQueryAreaNameGreaterThan(String value) {
            addCriterion("query_area_name >", value, "queryAreaName");
            return (Criteria) this;
        }

        public Criteria andQueryAreaNameGreaterThanOrEqualTo(String value) {
            addCriterion("query_area_name >=", value, "queryAreaName");
            return (Criteria) this;
        }

        public Criteria andQueryAreaNameLessThan(String value) {
            addCriterion("query_area_name <", value, "queryAreaName");
            return (Criteria) this;
        }

        public Criteria andQueryAreaNameLessThanOrEqualTo(String value) {
            addCriterion("query_area_name <=", value, "queryAreaName");
            return (Criteria) this;
        }

        public Criteria andQueryAreaNameLike(String value) {
            addCriterion("query_area_name like", value, "queryAreaName");
            return (Criteria) this;
        }

        public Criteria andQueryAreaNameNotLike(String value) {
            addCriterion("query_area_name not like", value, "queryAreaName");
            return (Criteria) this;
        }

        public Criteria andQueryAreaNameIn(List<String> values) {
            addCriterion("query_area_name in", values, "queryAreaName");
            return (Criteria) this;
        }

        public Criteria andQueryAreaNameNotIn(List<String> values) {
            addCriterion("query_area_name not in", values, "queryAreaName");
            return (Criteria) this;
        }

        public Criteria andQueryAreaNameBetween(String value1, String value2) {
            addCriterion("query_area_name between", value1, value2, "queryAreaName");
            return (Criteria) this;
        }

        public Criteria andQueryAreaNameNotBetween(String value1, String value2) {
            addCriterion("query_area_name not between", value1, value2, "queryAreaName");
            return (Criteria) this;
        }

        public Criteria andQueryArvehiclePricereaNameIsNull() {
            addCriterion("query_arvehicle_pricerea_name is null");
            return (Criteria) this;
        }

        public Criteria andQueryArvehiclePricereaNameIsNotNull() {
            addCriterion("query_arvehicle_pricerea_name is not null");
            return (Criteria) this;
        }

        public Criteria andQueryArvehiclePricereaNameEqualTo(String value) {
            addCriterion("query_arvehicle_pricerea_name =", value, "queryArvehiclePricereaName");
            return (Criteria) this;
        }

        public Criteria andQueryArvehiclePricereaNameNotEqualTo(String value) {
            addCriterion("query_arvehicle_pricerea_name <>", value, "queryArvehiclePricereaName");
            return (Criteria) this;
        }

        public Criteria andQueryArvehiclePricereaNameGreaterThan(String value) {
            addCriterion("query_arvehicle_pricerea_name >", value, "queryArvehiclePricereaName");
            return (Criteria) this;
        }

        public Criteria andQueryArvehiclePricereaNameGreaterThanOrEqualTo(String value) {
            addCriterion("query_arvehicle_pricerea_name >=", value, "queryArvehiclePricereaName");
            return (Criteria) this;
        }

        public Criteria andQueryArvehiclePricereaNameLessThan(String value) {
            addCriterion("query_arvehicle_pricerea_name <", value, "queryArvehiclePricereaName");
            return (Criteria) this;
        }

        public Criteria andQueryArvehiclePricereaNameLessThanOrEqualTo(String value) {
            addCriterion("query_arvehicle_pricerea_name <=", value, "queryArvehiclePricereaName");
            return (Criteria) this;
        }

        public Criteria andQueryArvehiclePricereaNameLike(String value) {
            addCriterion("query_arvehicle_pricerea_name like", value, "queryArvehiclePricereaName");
            return (Criteria) this;
        }

        public Criteria andQueryArvehiclePricereaNameNotLike(String value) {
            addCriterion("query_arvehicle_pricerea_name not like", value, "queryArvehiclePricereaName");
            return (Criteria) this;
        }

        public Criteria andQueryArvehiclePricereaNameIn(List<String> values) {
            addCriterion("query_arvehicle_pricerea_name in", values, "queryArvehiclePricereaName");
            return (Criteria) this;
        }

        public Criteria andQueryArvehiclePricereaNameNotIn(List<String> values) {
            addCriterion("query_arvehicle_pricerea_name not in", values, "queryArvehiclePricereaName");
            return (Criteria) this;
        }

        public Criteria andQueryArvehiclePricereaNameBetween(String value1, String value2) {
            addCriterion("query_arvehicle_pricerea_name between", value1, value2, "queryArvehiclePricereaName");
            return (Criteria) this;
        }

        public Criteria andQueryArvehiclePricereaNameNotBetween(String value1, String value2) {
            addCriterion("query_arvehicle_pricerea_name not between", value1, value2, "queryArvehiclePricereaName");
            return (Criteria) this;
        }

        public Criteria andRunAreaCodeIsNull() {
            addCriterion("run_area_code is null");
            return (Criteria) this;
        }

        public Criteria andRunAreaCodeIsNotNull() {
            addCriterion("run_area_code is not null");
            return (Criteria) this;
        }

        public Criteria andRunAreaCodeEqualTo(String value) {
            addCriterion("run_area_code =", value, "runAreaCode");
            return (Criteria) this;
        }

        public Criteria andRunAreaCodeNotEqualTo(String value) {
            addCriterion("run_area_code <>", value, "runAreaCode");
            return (Criteria) this;
        }

        public Criteria andRunAreaCodeGreaterThan(String value) {
            addCriterion("run_area_code >", value, "runAreaCode");
            return (Criteria) this;
        }

        public Criteria andRunAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("run_area_code >=", value, "runAreaCode");
            return (Criteria) this;
        }

        public Criteria andRunAreaCodeLessThan(String value) {
            addCriterion("run_area_code <", value, "runAreaCode");
            return (Criteria) this;
        }

        public Criteria andRunAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("run_area_code <=", value, "runAreaCode");
            return (Criteria) this;
        }

        public Criteria andRunAreaCodeLike(String value) {
            addCriterion("run_area_code like", value, "runAreaCode");
            return (Criteria) this;
        }

        public Criteria andRunAreaCodeNotLike(String value) {
            addCriterion("run_area_code not like", value, "runAreaCode");
            return (Criteria) this;
        }

        public Criteria andRunAreaCodeIn(List<String> values) {
            addCriterion("run_area_code in", values, "runAreaCode");
            return (Criteria) this;
        }

        public Criteria andRunAreaCodeNotIn(List<String> values) {
            addCriterion("run_area_code not in", values, "runAreaCode");
            return (Criteria) this;
        }

        public Criteria andRunAreaCodeBetween(String value1, String value2) {
            addCriterion("run_area_code between", value1, value2, "runAreaCode");
            return (Criteria) this;
        }

        public Criteria andRunAreaCodeNotBetween(String value1, String value2) {
            addCriterion("run_area_code not between", value1, value2, "runAreaCode");
            return (Criteria) this;
        }

        public Criteria andRunMilesIsNull() {
            addCriterion("run_miles is null");
            return (Criteria) this;
        }

        public Criteria andRunMilesIsNotNull() {
            addCriterion("run_miles is not null");
            return (Criteria) this;
        }

        public Criteria andRunMilesEqualTo(String value) {
            addCriterion("run_miles =", value, "runMiles");
            return (Criteria) this;
        }

        public Criteria andRunMilesNotEqualTo(String value) {
            addCriterion("run_miles <>", value, "runMiles");
            return (Criteria) this;
        }

        public Criteria andRunMilesGreaterThan(String value) {
            addCriterion("run_miles >", value, "runMiles");
            return (Criteria) this;
        }

        public Criteria andRunMilesGreaterThanOrEqualTo(String value) {
            addCriterion("run_miles >=", value, "runMiles");
            return (Criteria) this;
        }

        public Criteria andRunMilesLessThan(String value) {
            addCriterion("run_miles <", value, "runMiles");
            return (Criteria) this;
        }

        public Criteria andRunMilesLessThanOrEqualTo(String value) {
            addCriterion("run_miles <=", value, "runMiles");
            return (Criteria) this;
        }

        public Criteria andRunMilesLike(String value) {
            addCriterion("run_miles like", value, "runMiles");
            return (Criteria) this;
        }

        public Criteria andRunMilesNotLike(String value) {
            addCriterion("run_miles not like", value, "runMiles");
            return (Criteria) this;
        }

        public Criteria andRunMilesIn(List<String> values) {
            addCriterion("run_miles in", values, "runMiles");
            return (Criteria) this;
        }

        public Criteria andRunMilesNotIn(List<String> values) {
            addCriterion("run_miles not in", values, "runMiles");
            return (Criteria) this;
        }

        public Criteria andRunMilesBetween(String value1, String value2) {
            addCriterion("run_miles between", value1, value2, "runMiles");
            return (Criteria) this;
        }

        public Criteria andRunMilesNotBetween(String value1, String value2) {
            addCriterion("run_miles not between", value1, value2, "runMiles");
            return (Criteria) this;
        }

        public Criteria andSeatCountIsNull() {
            addCriterion("seat_count is null");
            return (Criteria) this;
        }

        public Criteria andSeatCountIsNotNull() {
            addCriterion("seat_count is not null");
            return (Criteria) this;
        }

        public Criteria andSeatCountEqualTo(String value) {
            addCriterion("seat_count =", value, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountNotEqualTo(String value) {
            addCriterion("seat_count <>", value, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountGreaterThan(String value) {
            addCriterion("seat_count >", value, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountGreaterThanOrEqualTo(String value) {
            addCriterion("seat_count >=", value, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountLessThan(String value) {
            addCriterion("seat_count <", value, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountLessThanOrEqualTo(String value) {
            addCriterion("seat_count <=", value, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountLike(String value) {
            addCriterion("seat_count like", value, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountNotLike(String value) {
            addCriterion("seat_count not like", value, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountIn(List<String> values) {
            addCriterion("seat_count in", values, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountNotIn(List<String> values) {
            addCriterion("seat_count not in", values, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountBetween(String value1, String value2) {
            addCriterion("seat_count between", value1, value2, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountNotBetween(String value1, String value2) {
            addCriterion("seat_count not between", value1, value2, "seatCount");
            return (Criteria) this;
        }

        public Criteria andTonCountIsNull() {
            addCriterion("ton_count is null");
            return (Criteria) this;
        }

        public Criteria andTonCountIsNotNull() {
            addCriterion("ton_count is not null");
            return (Criteria) this;
        }

        public Criteria andTonCountEqualTo(String value) {
            addCriterion("ton_count =", value, "tonCount");
            return (Criteria) this;
        }

        public Criteria andTonCountNotEqualTo(String value) {
            addCriterion("ton_count <>", value, "tonCount");
            return (Criteria) this;
        }

        public Criteria andTonCountGreaterThan(String value) {
            addCriterion("ton_count >", value, "tonCount");
            return (Criteria) this;
        }

        public Criteria andTonCountGreaterThanOrEqualTo(String value) {
            addCriterion("ton_count >=", value, "tonCount");
            return (Criteria) this;
        }

        public Criteria andTonCountLessThan(String value) {
            addCriterion("ton_count <", value, "tonCount");
            return (Criteria) this;
        }

        public Criteria andTonCountLessThanOrEqualTo(String value) {
            addCriterion("ton_count <=", value, "tonCount");
            return (Criteria) this;
        }

        public Criteria andTonCountLike(String value) {
            addCriterion("ton_count like", value, "tonCount");
            return (Criteria) this;
        }

        public Criteria andTonCountNotLike(String value) {
            addCriterion("ton_count not like", value, "tonCount");
            return (Criteria) this;
        }

        public Criteria andTonCountIn(List<String> values) {
            addCriterion("ton_count in", values, "tonCount");
            return (Criteria) this;
        }

        public Criteria andTonCountNotIn(List<String> values) {
            addCriterion("ton_count not in", values, "tonCount");
            return (Criteria) this;
        }

        public Criteria andTonCountBetween(String value1, String value2) {
            addCriterion("ton_count between", value1, value2, "tonCount");
            return (Criteria) this;
        }

        public Criteria andTonCountNotBetween(String value1, String value2) {
            addCriterion("ton_count not between", value1, value2, "tonCount");
            return (Criteria) this;
        }

        public Criteria andTransferDateIsNull() {
            addCriterion("transfer_date is null");
            return (Criteria) this;
        }

        public Criteria andTransferDateIsNotNull() {
            addCriterion("transfer_date is not null");
            return (Criteria) this;
        }

        public Criteria andTransferDateEqualTo(String value) {
            addCriterion("transfer_date =", value, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateNotEqualTo(String value) {
            addCriterion("transfer_date <>", value, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateGreaterThan(String value) {
            addCriterion("transfer_date >", value, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateGreaterThanOrEqualTo(String value) {
            addCriterion("transfer_date >=", value, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateLessThan(String value) {
            addCriterion("transfer_date <", value, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateLessThanOrEqualTo(String value) {
            addCriterion("transfer_date <=", value, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateLike(String value) {
            addCriterion("transfer_date like", value, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateNotLike(String value) {
            addCriterion("transfer_date not like", value, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateIn(List<String> values) {
            addCriterion("transfer_date in", values, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateNotIn(List<String> values) {
            addCriterion("transfer_date not in", values, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateBetween(String value1, String value2) {
            addCriterion("transfer_date between", value1, value2, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateNotBetween(String value1, String value2) {
            addCriterion("transfer_date not between", value1, value2, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferVehicleFlagIsNull() {
            addCriterion("transfer_vehicle_flag is null");
            return (Criteria) this;
        }

        public Criteria andTransferVehicleFlagIsNotNull() {
            addCriterion("transfer_vehicle_flag is not null");
            return (Criteria) this;
        }

        public Criteria andTransferVehicleFlagEqualTo(String value) {
            addCriterion("transfer_vehicle_flag =", value, "transferVehicleFlag");
            return (Criteria) this;
        }

        public Criteria andTransferVehicleFlagNotEqualTo(String value) {
            addCriterion("transfer_vehicle_flag <>", value, "transferVehicleFlag");
            return (Criteria) this;
        }

        public Criteria andTransferVehicleFlagGreaterThan(String value) {
            addCriterion("transfer_vehicle_flag >", value, "transferVehicleFlag");
            return (Criteria) this;
        }

        public Criteria andTransferVehicleFlagGreaterThanOrEqualTo(String value) {
            addCriterion("transfer_vehicle_flag >=", value, "transferVehicleFlag");
            return (Criteria) this;
        }

        public Criteria andTransferVehicleFlagLessThan(String value) {
            addCriterion("transfer_vehicle_flag <", value, "transferVehicleFlag");
            return (Criteria) this;
        }

        public Criteria andTransferVehicleFlagLessThanOrEqualTo(String value) {
            addCriterion("transfer_vehicle_flag <=", value, "transferVehicleFlag");
            return (Criteria) this;
        }

        public Criteria andTransferVehicleFlagLike(String value) {
            addCriterion("transfer_vehicle_flag like", value, "transferVehicleFlag");
            return (Criteria) this;
        }

        public Criteria andTransferVehicleFlagNotLike(String value) {
            addCriterion("transfer_vehicle_flag not like", value, "transferVehicleFlag");
            return (Criteria) this;
        }

        public Criteria andTransferVehicleFlagIn(List<String> values) {
            addCriterion("transfer_vehicle_flag in", values, "transferVehicleFlag");
            return (Criteria) this;
        }

        public Criteria andTransferVehicleFlagNotIn(List<String> values) {
            addCriterion("transfer_vehicle_flag not in", values, "transferVehicleFlag");
            return (Criteria) this;
        }

        public Criteria andTransferVehicleFlagBetween(String value1, String value2) {
            addCriterion("transfer_vehicle_flag between", value1, value2, "transferVehicleFlag");
            return (Criteria) this;
        }

        public Criteria andTransferVehicleFlagNotBetween(String value1, String value2) {
            addCriterion("transfer_vehicle_flag not between", value1, value2, "transferVehicleFlag");
            return (Criteria) this;
        }

        public Criteria andUseNatureCodeIsNull() {
            addCriterion("use_nature_code is null");
            return (Criteria) this;
        }

        public Criteria andUseNatureCodeIsNotNull() {
            addCriterion("use_nature_code is not null");
            return (Criteria) this;
        }

        public Criteria andUseNatureCodeEqualTo(String value) {
            addCriterion("use_nature_code =", value, "useNatureCode");
            return (Criteria) this;
        }

        public Criteria andUseNatureCodeNotEqualTo(String value) {
            addCriterion("use_nature_code <>", value, "useNatureCode");
            return (Criteria) this;
        }

        public Criteria andUseNatureCodeGreaterThan(String value) {
            addCriterion("use_nature_code >", value, "useNatureCode");
            return (Criteria) this;
        }

        public Criteria andUseNatureCodeGreaterThanOrEqualTo(String value) {
            addCriterion("use_nature_code >=", value, "useNatureCode");
            return (Criteria) this;
        }

        public Criteria andUseNatureCodeLessThan(String value) {
            addCriterion("use_nature_code <", value, "useNatureCode");
            return (Criteria) this;
        }

        public Criteria andUseNatureCodeLessThanOrEqualTo(String value) {
            addCriterion("use_nature_code <=", value, "useNatureCode");
            return (Criteria) this;
        }

        public Criteria andUseNatureCodeLike(String value) {
            addCriterion("use_nature_code like", value, "useNatureCode");
            return (Criteria) this;
        }

        public Criteria andUseNatureCodeNotLike(String value) {
            addCriterion("use_nature_code not like", value, "useNatureCode");
            return (Criteria) this;
        }

        public Criteria andUseNatureCodeIn(List<String> values) {
            addCriterion("use_nature_code in", values, "useNatureCode");
            return (Criteria) this;
        }

        public Criteria andUseNatureCodeNotIn(List<String> values) {
            addCriterion("use_nature_code not in", values, "useNatureCode");
            return (Criteria) this;
        }

        public Criteria andUseNatureCodeBetween(String value1, String value2) {
            addCriterion("use_nature_code between", value1, value2, "useNatureCode");
            return (Criteria) this;
        }

        public Criteria andUseNatureCodeNotBetween(String value1, String value2) {
            addCriterion("use_nature_code not between", value1, value2, "useNatureCode");
            return (Criteria) this;
        }

        public Criteria andUseYearsIsNull() {
            addCriterion("use_years is null");
            return (Criteria) this;
        }

        public Criteria andUseYearsIsNotNull() {
            addCriterion("use_years is not null");
            return (Criteria) this;
        }

        public Criteria andUseYearsEqualTo(String value) {
            addCriterion("use_years =", value, "useYears");
            return (Criteria) this;
        }

        public Criteria andUseYearsNotEqualTo(String value) {
            addCriterion("use_years <>", value, "useYears");
            return (Criteria) this;
        }

        public Criteria andUseYearsGreaterThan(String value) {
            addCriterion("use_years >", value, "useYears");
            return (Criteria) this;
        }

        public Criteria andUseYearsGreaterThanOrEqualTo(String value) {
            addCriterion("use_years >=", value, "useYears");
            return (Criteria) this;
        }

        public Criteria andUseYearsLessThan(String value) {
            addCriterion("use_years <", value, "useYears");
            return (Criteria) this;
        }

        public Criteria andUseYearsLessThanOrEqualTo(String value) {
            addCriterion("use_years <=", value, "useYears");
            return (Criteria) this;
        }

        public Criteria andUseYearsLike(String value) {
            addCriterion("use_years like", value, "useYears");
            return (Criteria) this;
        }

        public Criteria andUseYearsNotLike(String value) {
            addCriterion("use_years not like", value, "useYears");
            return (Criteria) this;
        }

        public Criteria andUseYearsIn(List<String> values) {
            addCriterion("use_years in", values, "useYears");
            return (Criteria) this;
        }

        public Criteria andUseYearsNotIn(List<String> values) {
            addCriterion("use_years not in", values, "useYears");
            return (Criteria) this;
        }

        public Criteria andUseYearsBetween(String value1, String value2) {
            addCriterion("use_years between", value1, value2, "useYears");
            return (Criteria) this;
        }

        public Criteria andUseYearsNotBetween(String value1, String value2) {
            addCriterion("use_years not between", value1, value2, "useYears");
            return (Criteria) this;
        }

        public Criteria andVinNoIsNull() {
            addCriterion("vin_no is null");
            return (Criteria) this;
        }

        public Criteria andVinNoIsNotNull() {
            addCriterion("vin_no is not null");
            return (Criteria) this;
        }

        public Criteria andVinNoEqualTo(String value) {
            addCriterion("vin_no =", value, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoNotEqualTo(String value) {
            addCriterion("vin_no <>", value, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoGreaterThan(String value) {
            addCriterion("vin_no >", value, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoGreaterThanOrEqualTo(String value) {
            addCriterion("vin_no >=", value, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoLessThan(String value) {
            addCriterion("vin_no <", value, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoLessThanOrEqualTo(String value) {
            addCriterion("vin_no <=", value, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoLike(String value) {
            addCriterion("vin_no like", value, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoNotLike(String value) {
            addCriterion("vin_no not like", value, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoIn(List<String> values) {
            addCriterion("vin_no in", values, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoNotIn(List<String> values) {
            addCriterion("vin_no not in", values, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoBetween(String value1, String value2) {
            addCriterion("vin_no between", value1, value2, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoNotBetween(String value1, String value2) {
            addCriterion("vin_no not between", value1, value2, "vinNo");
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
     * d_car
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * d_car 2019-01-17
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