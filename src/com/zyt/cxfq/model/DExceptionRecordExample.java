package com.zyt.cxfq.model;

import com.zyt.cxfq.plugin.page.BootPage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DExceptionRecordExample {
    /**
     * d_exception_record
     */
    protected String orderByClause;

    /**
     * d_exception_record
     */
    protected boolean distinct;

    /**
     * d_exception_record
     */
    protected List<Criteria> oredCriteria;

    /**
     * d_exception_record
     */
    protected BootPage page;

    /**
     *
     * @mbggenerated 2019-01-10
     */
    public DExceptionRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbggenerated 2019-01-10
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbggenerated 2019-01-10
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbggenerated 2019-01-10
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbggenerated 2019-01-10
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbggenerated 2019-01-10
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbggenerated 2019-01-10
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbggenerated 2019-01-10
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbggenerated 2019-01-10
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
     * @mbggenerated 2019-01-10
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbggenerated 2019-01-10
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     *
     * @mbggenerated 2019-01-10
     */
    public void setPage(BootPage page) {
        this.page=page;
    }

    /**
     *
     * @mbggenerated 2019-01-10
     */
    public BootPage getPage() {
        return page;
    }

    /**
     * d_exception_record 2019-01-10
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

        public Criteria andExceptionrecordidIsNull() {
            addCriterion("exceptionrecordid is null");
            return (Criteria) this;
        }

        public Criteria andExceptionrecordidIsNotNull() {
            addCriterion("exceptionrecordid is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionrecordidEqualTo(String value) {
            addCriterion("exceptionrecordid =", value, "exceptionrecordid");
            return (Criteria) this;
        }

        public Criteria andExceptionrecordidNotEqualTo(String value) {
            addCriterion("exceptionrecordid <>", value, "exceptionrecordid");
            return (Criteria) this;
        }

        public Criteria andExceptionrecordidGreaterThan(String value) {
            addCriterion("exceptionrecordid >", value, "exceptionrecordid");
            return (Criteria) this;
        }

        public Criteria andExceptionrecordidGreaterThanOrEqualTo(String value) {
            addCriterion("exceptionrecordid >=", value, "exceptionrecordid");
            return (Criteria) this;
        }

        public Criteria andExceptionrecordidLessThan(String value) {
            addCriterion("exceptionrecordid <", value, "exceptionrecordid");
            return (Criteria) this;
        }

        public Criteria andExceptionrecordidLessThanOrEqualTo(String value) {
            addCriterion("exceptionrecordid <=", value, "exceptionrecordid");
            return (Criteria) this;
        }

        public Criteria andExceptionrecordidLike(String value) {
            addCriterion("exceptionrecordid like", value, "exceptionrecordid");
            return (Criteria) this;
        }

        public Criteria andExceptionrecordidNotLike(String value) {
            addCriterion("exceptionrecordid not like", value, "exceptionrecordid");
            return (Criteria) this;
        }

        public Criteria andExceptionrecordidIn(List<String> values) {
            addCriterion("exceptionrecordid in", values, "exceptionrecordid");
            return (Criteria) this;
        }

        public Criteria andExceptionrecordidNotIn(List<String> values) {
            addCriterion("exceptionrecordid not in", values, "exceptionrecordid");
            return (Criteria) this;
        }

        public Criteria andExceptionrecordidBetween(String value1, String value2) {
            addCriterion("exceptionrecordid between", value1, value2, "exceptionrecordid");
            return (Criteria) this;
        }

        public Criteria andExceptionrecordidNotBetween(String value1, String value2) {
            addCriterion("exceptionrecordid not between", value1, value2, "exceptionrecordid");
            return (Criteria) this;
        }

        public Criteria andBmemberidIsNull() {
            addCriterion("bmemberid is null");
            return (Criteria) this;
        }

        public Criteria andBmemberidIsNotNull() {
            addCriterion("bmemberid is not null");
            return (Criteria) this;
        }

        public Criteria andBmemberidEqualTo(String value) {
            addCriterion("bmemberid =", value, "bmemberid");
            return (Criteria) this;
        }

        public Criteria andBmemberidNotEqualTo(String value) {
            addCriterion("bmemberid <>", value, "bmemberid");
            return (Criteria) this;
        }

        public Criteria andBmemberidGreaterThan(String value) {
            addCriterion("bmemberid >", value, "bmemberid");
            return (Criteria) this;
        }

        public Criteria andBmemberidGreaterThanOrEqualTo(String value) {
            addCriterion("bmemberid >=", value, "bmemberid");
            return (Criteria) this;
        }

        public Criteria andBmemberidLessThan(String value) {
            addCriterion("bmemberid <", value, "bmemberid");
            return (Criteria) this;
        }

        public Criteria andBmemberidLessThanOrEqualTo(String value) {
            addCriterion("bmemberid <=", value, "bmemberid");
            return (Criteria) this;
        }

        public Criteria andBmemberidLike(String value) {
            addCriterion("bmemberid like", value, "bmemberid");
            return (Criteria) this;
        }

        public Criteria andBmemberidNotLike(String value) {
            addCriterion("bmemberid not like", value, "bmemberid");
            return (Criteria) this;
        }

        public Criteria andBmemberidIn(List<String> values) {
            addCriterion("bmemberid in", values, "bmemberid");
            return (Criteria) this;
        }

        public Criteria andBmemberidNotIn(List<String> values) {
            addCriterion("bmemberid not in", values, "bmemberid");
            return (Criteria) this;
        }

        public Criteria andBmemberidBetween(String value1, String value2) {
            addCriterion("bmemberid between", value1, value2, "bmemberid");
            return (Criteria) this;
        }

        public Criteria andBmemberidNotBetween(String value1, String value2) {
            addCriterion("bmemberid not between", value1, value2, "bmemberid");
            return (Criteria) this;
        }

        public Criteria andRequesturlIsNull() {
            addCriterion("requesturl is null");
            return (Criteria) this;
        }

        public Criteria andRequesturlIsNotNull() {
            addCriterion("requesturl is not null");
            return (Criteria) this;
        }

        public Criteria andRequesturlEqualTo(String value) {
            addCriterion("requesturl =", value, "requesturl");
            return (Criteria) this;
        }

        public Criteria andRequesturlNotEqualTo(String value) {
            addCriterion("requesturl <>", value, "requesturl");
            return (Criteria) this;
        }

        public Criteria andRequesturlGreaterThan(String value) {
            addCriterion("requesturl >", value, "requesturl");
            return (Criteria) this;
        }

        public Criteria andRequesturlGreaterThanOrEqualTo(String value) {
            addCriterion("requesturl >=", value, "requesturl");
            return (Criteria) this;
        }

        public Criteria andRequesturlLessThan(String value) {
            addCriterion("requesturl <", value, "requesturl");
            return (Criteria) this;
        }

        public Criteria andRequesturlLessThanOrEqualTo(String value) {
            addCriterion("requesturl <=", value, "requesturl");
            return (Criteria) this;
        }

        public Criteria andRequesturlLike(String value) {
            addCriterion("requesturl like", value, "requesturl");
            return (Criteria) this;
        }

        public Criteria andRequesturlNotLike(String value) {
            addCriterion("requesturl not like", value, "requesturl");
            return (Criteria) this;
        }

        public Criteria andRequesturlIn(List<String> values) {
            addCriterion("requesturl in", values, "requesturl");
            return (Criteria) this;
        }

        public Criteria andRequesturlNotIn(List<String> values) {
            addCriterion("requesturl not in", values, "requesturl");
            return (Criteria) this;
        }

        public Criteria andRequesturlBetween(String value1, String value2) {
            addCriterion("requesturl between", value1, value2, "requesturl");
            return (Criteria) this;
        }

        public Criteria andRequesturlNotBetween(String value1, String value2) {
            addCriterion("requesturl not between", value1, value2, "requesturl");
            return (Criteria) this;
        }

        public Criteria andIpaddrIsNull() {
            addCriterion("ipaddr is null");
            return (Criteria) this;
        }

        public Criteria andIpaddrIsNotNull() {
            addCriterion("ipaddr is not null");
            return (Criteria) this;
        }

        public Criteria andIpaddrEqualTo(String value) {
            addCriterion("ipaddr =", value, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrNotEqualTo(String value) {
            addCriterion("ipaddr <>", value, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrGreaterThan(String value) {
            addCriterion("ipaddr >", value, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrGreaterThanOrEqualTo(String value) {
            addCriterion("ipaddr >=", value, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrLessThan(String value) {
            addCriterion("ipaddr <", value, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrLessThanOrEqualTo(String value) {
            addCriterion("ipaddr <=", value, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrLike(String value) {
            addCriterion("ipaddr like", value, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrNotLike(String value) {
            addCriterion("ipaddr not like", value, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrIn(List<String> values) {
            addCriterion("ipaddr in", values, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrNotIn(List<String> values) {
            addCriterion("ipaddr not in", values, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrBetween(String value1, String value2) {
            addCriterion("ipaddr between", value1, value2, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrNotBetween(String value1, String value2) {
            addCriterion("ipaddr not between", value1, value2, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andClassnameIsNull() {
            addCriterion("classname is null");
            return (Criteria) this;
        }

        public Criteria andClassnameIsNotNull() {
            addCriterion("classname is not null");
            return (Criteria) this;
        }

        public Criteria andClassnameEqualTo(String value) {
            addCriterion("classname =", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotEqualTo(String value) {
            addCriterion("classname <>", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameGreaterThan(String value) {
            addCriterion("classname >", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameGreaterThanOrEqualTo(String value) {
            addCriterion("classname >=", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLessThan(String value) {
            addCriterion("classname <", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLessThanOrEqualTo(String value) {
            addCriterion("classname <=", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLike(String value) {
            addCriterion("classname like", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotLike(String value) {
            addCriterion("classname not like", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameIn(List<String> values) {
            addCriterion("classname in", values, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotIn(List<String> values) {
            addCriterion("classname not in", values, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameBetween(String value1, String value2) {
            addCriterion("classname between", value1, value2, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotBetween(String value1, String value2) {
            addCriterion("classname not between", value1, value2, "classname");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andResourceIsNull() {
            addCriterion("resource is null");
            return (Criteria) this;
        }

        public Criteria andResourceIsNotNull() {
            addCriterion("resource is not null");
            return (Criteria) this;
        }

        public Criteria andResourceEqualTo(Integer value) {
            addCriterion("resource =", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceNotEqualTo(Integer value) {
            addCriterion("resource <>", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceGreaterThan(Integer value) {
            addCriterion("resource >", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("resource >=", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceLessThan(Integer value) {
            addCriterion("resource <", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceLessThanOrEqualTo(Integer value) {
            addCriterion("resource <=", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceIn(List<Integer> values) {
            addCriterion("resource in", values, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceNotIn(List<Integer> values) {
            addCriterion("resource not in", values, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceBetween(Integer value1, Integer value2) {
            addCriterion("resource between", value1, value2, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceNotBetween(Integer value1, Integer value2) {
            addCriterion("resource not between", value1, value2, "resource");
            return (Criteria) this;
        }
    }

    /**
     * d_exception_record
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * d_exception_record 2019-01-10
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