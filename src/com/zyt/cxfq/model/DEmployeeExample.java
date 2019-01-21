package com.zyt.cxfq.model;

import com.zyt.cxfq.plugin.page.BootPage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DEmployeeExample {
    /**
     * d_employee
     */
    protected String orderByClause;

    /**
     * d_employee
     */
    protected boolean distinct;

    /**
     * d_employee
     */
    protected List<Criteria> oredCriteria;

    /**
     * d_employee
     */
    protected BootPage page;

    /**
     *
     * @mbggenerated 2019-01-11
     */
    public DEmployeeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbggenerated 2019-01-11
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbggenerated 2019-01-11
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbggenerated 2019-01-11
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbggenerated 2019-01-11
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbggenerated 2019-01-11
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbggenerated 2019-01-11
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbggenerated 2019-01-11
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbggenerated 2019-01-11
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
     * @mbggenerated 2019-01-11
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbggenerated 2019-01-11
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     *
     * @mbggenerated 2019-01-11
     */
    public void setPage(BootPage page) {
        this.page=page;
    }

    /**
     *
     * @mbggenerated 2019-01-11
     */
    public BootPage getPage() {
        return page;
    }

    /**
     * d_employee 2019-01-11
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

        public Criteria andUIdIsNull() {
            addCriterion("u_id is null");
            return (Criteria) this;
        }

        public Criteria andUIdIsNotNull() {
            addCriterion("u_id is not null");
            return (Criteria) this;
        }

        public Criteria andUIdEqualTo(String value) {
            addCriterion("u_id =", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotEqualTo(String value) {
            addCriterion("u_id <>", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThan(String value) {
            addCriterion("u_id >", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThanOrEqualTo(String value) {
            addCriterion("u_id >=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThan(String value) {
            addCriterion("u_id <", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThanOrEqualTo(String value) {
            addCriterion("u_id <=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLike(String value) {
            addCriterion("u_id like", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotLike(String value) {
            addCriterion("u_id not like", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdIn(List<String> values) {
            addCriterion("u_id in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotIn(List<String> values) {
            addCriterion("u_id not in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdBetween(String value1, String value2) {
            addCriterion("u_id between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotBetween(String value1, String value2) {
            addCriterion("u_id not between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUNameIsNull() {
            addCriterion("u_name is null");
            return (Criteria) this;
        }

        public Criteria andUNameIsNotNull() {
            addCriterion("u_name is not null");
            return (Criteria) this;
        }

        public Criteria andUNameEqualTo(String value) {
            addCriterion("u_name =", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotEqualTo(String value) {
            addCriterion("u_name <>", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameGreaterThan(String value) {
            addCriterion("u_name >", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameGreaterThanOrEqualTo(String value) {
            addCriterion("u_name >=", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLessThan(String value) {
            addCriterion("u_name <", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLessThanOrEqualTo(String value) {
            addCriterion("u_name <=", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLike(String value) {
            addCriterion("u_name like", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotLike(String value) {
            addCriterion("u_name not like", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameIn(List<String> values) {
            addCriterion("u_name in", values, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotIn(List<String> values) {
            addCriterion("u_name not in", values, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameBetween(String value1, String value2) {
            addCriterion("u_name between", value1, value2, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotBetween(String value1, String value2) {
            addCriterion("u_name not between", value1, value2, "uName");
            return (Criteria) this;
        }

        public Criteria andUPhoneIsNull() {
            addCriterion("u_phone is null");
            return (Criteria) this;
        }

        public Criteria andUPhoneIsNotNull() {
            addCriterion("u_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUPhoneEqualTo(String value) {
            addCriterion("u_phone =", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneNotEqualTo(String value) {
            addCriterion("u_phone <>", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneGreaterThan(String value) {
            addCriterion("u_phone >", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("u_phone >=", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneLessThan(String value) {
            addCriterion("u_phone <", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneLessThanOrEqualTo(String value) {
            addCriterion("u_phone <=", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneLike(String value) {
            addCriterion("u_phone like", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneNotLike(String value) {
            addCriterion("u_phone not like", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneIn(List<String> values) {
            addCriterion("u_phone in", values, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneNotIn(List<String> values) {
            addCriterion("u_phone not in", values, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneBetween(String value1, String value2) {
            addCriterion("u_phone between", value1, value2, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneNotBetween(String value1, String value2) {
            addCriterion("u_phone not between", value1, value2, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUNickNameIsNull() {
            addCriterion("u_nick_name is null");
            return (Criteria) this;
        }

        public Criteria andUNickNameIsNotNull() {
            addCriterion("u_nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andUNickNameEqualTo(String value) {
            addCriterion("u_nick_name =", value, "uNickName");
            return (Criteria) this;
        }

        public Criteria andUNickNameNotEqualTo(String value) {
            addCriterion("u_nick_name <>", value, "uNickName");
            return (Criteria) this;
        }

        public Criteria andUNickNameGreaterThan(String value) {
            addCriterion("u_nick_name >", value, "uNickName");
            return (Criteria) this;
        }

        public Criteria andUNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("u_nick_name >=", value, "uNickName");
            return (Criteria) this;
        }

        public Criteria andUNickNameLessThan(String value) {
            addCriterion("u_nick_name <", value, "uNickName");
            return (Criteria) this;
        }

        public Criteria andUNickNameLessThanOrEqualTo(String value) {
            addCriterion("u_nick_name <=", value, "uNickName");
            return (Criteria) this;
        }

        public Criteria andUNickNameLike(String value) {
            addCriterion("u_nick_name like", value, "uNickName");
            return (Criteria) this;
        }

        public Criteria andUNickNameNotLike(String value) {
            addCriterion("u_nick_name not like", value, "uNickName");
            return (Criteria) this;
        }

        public Criteria andUNickNameIn(List<String> values) {
            addCriterion("u_nick_name in", values, "uNickName");
            return (Criteria) this;
        }

        public Criteria andUNickNameNotIn(List<String> values) {
            addCriterion("u_nick_name not in", values, "uNickName");
            return (Criteria) this;
        }

        public Criteria andUNickNameBetween(String value1, String value2) {
            addCriterion("u_nick_name between", value1, value2, "uNickName");
            return (Criteria) this;
        }

        public Criteria andUNickNameNotBetween(String value1, String value2) {
            addCriterion("u_nick_name not between", value1, value2, "uNickName");
            return (Criteria) this;
        }

        public Criteria andUPwdIsNull() {
            addCriterion("u_pwd is null");
            return (Criteria) this;
        }

        public Criteria andUPwdIsNotNull() {
            addCriterion("u_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andUPwdEqualTo(String value) {
            addCriterion("u_pwd =", value, "uPwd");
            return (Criteria) this;
        }

        public Criteria andUPwdNotEqualTo(String value) {
            addCriterion("u_pwd <>", value, "uPwd");
            return (Criteria) this;
        }

        public Criteria andUPwdGreaterThan(String value) {
            addCriterion("u_pwd >", value, "uPwd");
            return (Criteria) this;
        }

        public Criteria andUPwdGreaterThanOrEqualTo(String value) {
            addCriterion("u_pwd >=", value, "uPwd");
            return (Criteria) this;
        }

        public Criteria andUPwdLessThan(String value) {
            addCriterion("u_pwd <", value, "uPwd");
            return (Criteria) this;
        }

        public Criteria andUPwdLessThanOrEqualTo(String value) {
            addCriterion("u_pwd <=", value, "uPwd");
            return (Criteria) this;
        }

        public Criteria andUPwdLike(String value) {
            addCriterion("u_pwd like", value, "uPwd");
            return (Criteria) this;
        }

        public Criteria andUPwdNotLike(String value) {
            addCriterion("u_pwd not like", value, "uPwd");
            return (Criteria) this;
        }

        public Criteria andUPwdIn(List<String> values) {
            addCriterion("u_pwd in", values, "uPwd");
            return (Criteria) this;
        }

        public Criteria andUPwdNotIn(List<String> values) {
            addCriterion("u_pwd not in", values, "uPwd");
            return (Criteria) this;
        }

        public Criteria andUPwdBetween(String value1, String value2) {
            addCriterion("u_pwd between", value1, value2, "uPwd");
            return (Criteria) this;
        }

        public Criteria andUPwdNotBetween(String value1, String value2) {
            addCriterion("u_pwd not between", value1, value2, "uPwd");
            return (Criteria) this;
        }

        public Criteria andUPicIsNull() {
            addCriterion("u_pic is null");
            return (Criteria) this;
        }

        public Criteria andUPicIsNotNull() {
            addCriterion("u_pic is not null");
            return (Criteria) this;
        }

        public Criteria andUPicEqualTo(String value) {
            addCriterion("u_pic =", value, "uPic");
            return (Criteria) this;
        }

        public Criteria andUPicNotEqualTo(String value) {
            addCriterion("u_pic <>", value, "uPic");
            return (Criteria) this;
        }

        public Criteria andUPicGreaterThan(String value) {
            addCriterion("u_pic >", value, "uPic");
            return (Criteria) this;
        }

        public Criteria andUPicGreaterThanOrEqualTo(String value) {
            addCriterion("u_pic >=", value, "uPic");
            return (Criteria) this;
        }

        public Criteria andUPicLessThan(String value) {
            addCriterion("u_pic <", value, "uPic");
            return (Criteria) this;
        }

        public Criteria andUPicLessThanOrEqualTo(String value) {
            addCriterion("u_pic <=", value, "uPic");
            return (Criteria) this;
        }

        public Criteria andUPicLike(String value) {
            addCriterion("u_pic like", value, "uPic");
            return (Criteria) this;
        }

        public Criteria andUPicNotLike(String value) {
            addCriterion("u_pic not like", value, "uPic");
            return (Criteria) this;
        }

        public Criteria andUPicIn(List<String> values) {
            addCriterion("u_pic in", values, "uPic");
            return (Criteria) this;
        }

        public Criteria andUPicNotIn(List<String> values) {
            addCriterion("u_pic not in", values, "uPic");
            return (Criteria) this;
        }

        public Criteria andUPicBetween(String value1, String value2) {
            addCriterion("u_pic between", value1, value2, "uPic");
            return (Criteria) this;
        }

        public Criteria andUPicNotBetween(String value1, String value2) {
            addCriterion("u_pic not between", value1, value2, "uPic");
            return (Criteria) this;
        }

        public Criteria andUCompanyIsNull() {
            addCriterion("u_company is null");
            return (Criteria) this;
        }

        public Criteria andUCompanyIsNotNull() {
            addCriterion("u_company is not null");
            return (Criteria) this;
        }

        public Criteria andUCompanyEqualTo(String value) {
            addCriterion("u_company =", value, "uCompany");
            return (Criteria) this;
        }

        public Criteria andUCompanyNotEqualTo(String value) {
            addCriterion("u_company <>", value, "uCompany");
            return (Criteria) this;
        }

        public Criteria andUCompanyGreaterThan(String value) {
            addCriterion("u_company >", value, "uCompany");
            return (Criteria) this;
        }

        public Criteria andUCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("u_company >=", value, "uCompany");
            return (Criteria) this;
        }

        public Criteria andUCompanyLessThan(String value) {
            addCriterion("u_company <", value, "uCompany");
            return (Criteria) this;
        }

        public Criteria andUCompanyLessThanOrEqualTo(String value) {
            addCriterion("u_company <=", value, "uCompany");
            return (Criteria) this;
        }

        public Criteria andUCompanyLike(String value) {
            addCriterion("u_company like", value, "uCompany");
            return (Criteria) this;
        }

        public Criteria andUCompanyNotLike(String value) {
            addCriterion("u_company not like", value, "uCompany");
            return (Criteria) this;
        }

        public Criteria andUCompanyIn(List<String> values) {
            addCriterion("u_company in", values, "uCompany");
            return (Criteria) this;
        }

        public Criteria andUCompanyNotIn(List<String> values) {
            addCriterion("u_company not in", values, "uCompany");
            return (Criteria) this;
        }

        public Criteria andUCompanyBetween(String value1, String value2) {
            addCriterion("u_company between", value1, value2, "uCompany");
            return (Criteria) this;
        }

        public Criteria andUCompanyNotBetween(String value1, String value2) {
            addCriterion("u_company not between", value1, value2, "uCompany");
            return (Criteria) this;
        }

        public Criteria andURemarkIsNull() {
            addCriterion("u_remark is null");
            return (Criteria) this;
        }

        public Criteria andURemarkIsNotNull() {
            addCriterion("u_remark is not null");
            return (Criteria) this;
        }

        public Criteria andURemarkEqualTo(String value) {
            addCriterion("u_remark =", value, "uRemark");
            return (Criteria) this;
        }

        public Criteria andURemarkNotEqualTo(String value) {
            addCriterion("u_remark <>", value, "uRemark");
            return (Criteria) this;
        }

        public Criteria andURemarkGreaterThan(String value) {
            addCriterion("u_remark >", value, "uRemark");
            return (Criteria) this;
        }

        public Criteria andURemarkGreaterThanOrEqualTo(String value) {
            addCriterion("u_remark >=", value, "uRemark");
            return (Criteria) this;
        }

        public Criteria andURemarkLessThan(String value) {
            addCriterion("u_remark <", value, "uRemark");
            return (Criteria) this;
        }

        public Criteria andURemarkLessThanOrEqualTo(String value) {
            addCriterion("u_remark <=", value, "uRemark");
            return (Criteria) this;
        }

        public Criteria andURemarkLike(String value) {
            addCriterion("u_remark like", value, "uRemark");
            return (Criteria) this;
        }

        public Criteria andURemarkNotLike(String value) {
            addCriterion("u_remark not like", value, "uRemark");
            return (Criteria) this;
        }

        public Criteria andURemarkIn(List<String> values) {
            addCriterion("u_remark in", values, "uRemark");
            return (Criteria) this;
        }

        public Criteria andURemarkNotIn(List<String> values) {
            addCriterion("u_remark not in", values, "uRemark");
            return (Criteria) this;
        }

        public Criteria andURemarkBetween(String value1, String value2) {
            addCriterion("u_remark between", value1, value2, "uRemark");
            return (Criteria) this;
        }

        public Criteria andURemarkNotBetween(String value1, String value2) {
            addCriterion("u_remark not between", value1, value2, "uRemark");
            return (Criteria) this;
        }

        public Criteria andUProCodeIsNull() {
            addCriterion("u_pro_code is null");
            return (Criteria) this;
        }

        public Criteria andUProCodeIsNotNull() {
            addCriterion("u_pro_code is not null");
            return (Criteria) this;
        }

        public Criteria andUProCodeEqualTo(String value) {
            addCriterion("u_pro_code =", value, "uProCode");
            return (Criteria) this;
        }

        public Criteria andUProCodeNotEqualTo(String value) {
            addCriterion("u_pro_code <>", value, "uProCode");
            return (Criteria) this;
        }

        public Criteria andUProCodeGreaterThan(String value) {
            addCriterion("u_pro_code >", value, "uProCode");
            return (Criteria) this;
        }

        public Criteria andUProCodeGreaterThanOrEqualTo(String value) {
            addCriterion("u_pro_code >=", value, "uProCode");
            return (Criteria) this;
        }

        public Criteria andUProCodeLessThan(String value) {
            addCriterion("u_pro_code <", value, "uProCode");
            return (Criteria) this;
        }

        public Criteria andUProCodeLessThanOrEqualTo(String value) {
            addCriterion("u_pro_code <=", value, "uProCode");
            return (Criteria) this;
        }

        public Criteria andUProCodeLike(String value) {
            addCriterion("u_pro_code like", value, "uProCode");
            return (Criteria) this;
        }

        public Criteria andUProCodeNotLike(String value) {
            addCriterion("u_pro_code not like", value, "uProCode");
            return (Criteria) this;
        }

        public Criteria andUProCodeIn(List<String> values) {
            addCriterion("u_pro_code in", values, "uProCode");
            return (Criteria) this;
        }

        public Criteria andUProCodeNotIn(List<String> values) {
            addCriterion("u_pro_code not in", values, "uProCode");
            return (Criteria) this;
        }

        public Criteria andUProCodeBetween(String value1, String value2) {
            addCriterion("u_pro_code between", value1, value2, "uProCode");
            return (Criteria) this;
        }

        public Criteria andUProCodeNotBetween(String value1, String value2) {
            addCriterion("u_pro_code not between", value1, value2, "uProCode");
            return (Criteria) this;
        }

        public Criteria andUFromProIsNull() {
            addCriterion("u_from_pro is null");
            return (Criteria) this;
        }

        public Criteria andUFromProIsNotNull() {
            addCriterion("u_from_pro is not null");
            return (Criteria) this;
        }

        public Criteria andUFromProEqualTo(String value) {
            addCriterion("u_from_pro =", value, "uFromPro");
            return (Criteria) this;
        }

        public Criteria andUFromProNotEqualTo(String value) {
            addCriterion("u_from_pro <>", value, "uFromPro");
            return (Criteria) this;
        }

        public Criteria andUFromProGreaterThan(String value) {
            addCriterion("u_from_pro >", value, "uFromPro");
            return (Criteria) this;
        }

        public Criteria andUFromProGreaterThanOrEqualTo(String value) {
            addCriterion("u_from_pro >=", value, "uFromPro");
            return (Criteria) this;
        }

        public Criteria andUFromProLessThan(String value) {
            addCriterion("u_from_pro <", value, "uFromPro");
            return (Criteria) this;
        }

        public Criteria andUFromProLessThanOrEqualTo(String value) {
            addCriterion("u_from_pro <=", value, "uFromPro");
            return (Criteria) this;
        }

        public Criteria andUFromProLike(String value) {
            addCriterion("u_from_pro like", value, "uFromPro");
            return (Criteria) this;
        }

        public Criteria andUFromProNotLike(String value) {
            addCriterion("u_from_pro not like", value, "uFromPro");
            return (Criteria) this;
        }

        public Criteria andUFromProIn(List<String> values) {
            addCriterion("u_from_pro in", values, "uFromPro");
            return (Criteria) this;
        }

        public Criteria andUFromProNotIn(List<String> values) {
            addCriterion("u_from_pro not in", values, "uFromPro");
            return (Criteria) this;
        }

        public Criteria andUFromProBetween(String value1, String value2) {
            addCriterion("u_from_pro between", value1, value2, "uFromPro");
            return (Criteria) this;
        }

        public Criteria andUFromProNotBetween(String value1, String value2) {
            addCriterion("u_from_pro not between", value1, value2, "uFromPro");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(String value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(String value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(String value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(String value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(String value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLike(String value) {
            addCriterion("create_user_id like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotLike(String value) {
            addCriterion("create_user_id not like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<String> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<String> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(String value1, String value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(String value1, String value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
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
     * d_employee
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * d_employee 2019-01-11
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