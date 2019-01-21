package com.zyt.cxfq.model;

import com.zyt.cxfq.plugin.page.BootPage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UCommentExample {
    /**
     * u_comment
     */
    protected String orderByClause;

    /**
     * u_comment
     */
    protected boolean distinct;

    /**
     * u_comment
     */
    protected List<Criteria> oredCriteria;

    /**
     * u_comment
     */
    protected BootPage page;

    /**
     *
     * @mbggenerated 2017-12-11
     */
    public UCommentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbggenerated 2017-12-11
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbggenerated 2017-12-11
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbggenerated 2017-12-11
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbggenerated 2017-12-11
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbggenerated 2017-12-11
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbggenerated 2017-12-11
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbggenerated 2017-12-11
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbggenerated 2017-12-11
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
     * @mbggenerated 2017-12-11
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbggenerated 2017-12-11
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     *
     * @mbggenerated 2017-12-11
     */
    public void setPage(BootPage page) {
        this.page=page;
    }

    /**
     *
     * @mbggenerated 2017-12-11
     */
    public BootPage getPage() {
        return page;
    }

    /**
     * u_comment 2017-12-11
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

        public Criteria andCommentidIsNull() {
            addCriterion("commentId is null");
            return (Criteria) this;
        }

        public Criteria andCommentidIsNotNull() {
            addCriterion("commentId is not null");
            return (Criteria) this;
        }

        public Criteria andCommentidEqualTo(String value) {
            addCriterion("commentId =", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidNotEqualTo(String value) {
            addCriterion("commentId <>", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidGreaterThan(String value) {
            addCriterion("commentId >", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidGreaterThanOrEqualTo(String value) {
            addCriterion("commentId >=", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidLessThan(String value) {
            addCriterion("commentId <", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidLessThanOrEqualTo(String value) {
            addCriterion("commentId <=", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidLike(String value) {
            addCriterion("commentId like", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidNotLike(String value) {
            addCriterion("commentId not like", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidIn(List<String> values) {
            addCriterion("commentId in", values, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidNotIn(List<String> values) {
            addCriterion("commentId not in", values, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidBetween(String value1, String value2) {
            addCriterion("commentId between", value1, value2, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidNotBetween(String value1, String value2) {
            addCriterion("commentId not between", value1, value2, "commentid");
            return (Criteria) this;
        }

        public Criteria andAuthoridIsNull() {
            addCriterion("authorId is null");
            return (Criteria) this;
        }

        public Criteria andAuthoridIsNotNull() {
            addCriterion("authorId is not null");
            return (Criteria) this;
        }

        public Criteria andAuthoridEqualTo(String value) {
            addCriterion("authorId =", value, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridNotEqualTo(String value) {
            addCriterion("authorId <>", value, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridGreaterThan(String value) {
            addCriterion("authorId >", value, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridGreaterThanOrEqualTo(String value) {
            addCriterion("authorId >=", value, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridLessThan(String value) {
            addCriterion("authorId <", value, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridLessThanOrEqualTo(String value) {
            addCriterion("authorId <=", value, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridLike(String value) {
            addCriterion("authorId like", value, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridNotLike(String value) {
            addCriterion("authorId not like", value, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridIn(List<String> values) {
            addCriterion("authorId in", values, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridNotIn(List<String> values) {
            addCriterion("authorId not in", values, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridBetween(String value1, String value2) {
            addCriterion("authorId between", value1, value2, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridNotBetween(String value1, String value2) {
            addCriterion("authorId not between", value1, value2, "authorid");
            return (Criteria) this;
        }

        public Criteria andCriticidIsNull() {
            addCriterion("criticId is null");
            return (Criteria) this;
        }

        public Criteria andCriticidIsNotNull() {
            addCriterion("criticId is not null");
            return (Criteria) this;
        }

        public Criteria andCriticidEqualTo(String value) {
            addCriterion("criticId =", value, "criticid");
            return (Criteria) this;
        }

        public Criteria andCriticidNotEqualTo(String value) {
            addCriterion("criticId <>", value, "criticid");
            return (Criteria) this;
        }

        public Criteria andCriticidGreaterThan(String value) {
            addCriterion("criticId >", value, "criticid");
            return (Criteria) this;
        }

        public Criteria andCriticidGreaterThanOrEqualTo(String value) {
            addCriterion("criticId >=", value, "criticid");
            return (Criteria) this;
        }

        public Criteria andCriticidLessThan(String value) {
            addCriterion("criticId <", value, "criticid");
            return (Criteria) this;
        }

        public Criteria andCriticidLessThanOrEqualTo(String value) {
            addCriterion("criticId <=", value, "criticid");
            return (Criteria) this;
        }

        public Criteria andCriticidLike(String value) {
            addCriterion("criticId like", value, "criticid");
            return (Criteria) this;
        }

        public Criteria andCriticidNotLike(String value) {
            addCriterion("criticId not like", value, "criticid");
            return (Criteria) this;
        }

        public Criteria andCriticidIn(List<String> values) {
            addCriterion("criticId in", values, "criticid");
            return (Criteria) this;
        }

        public Criteria andCriticidNotIn(List<String> values) {
            addCriterion("criticId not in", values, "criticid");
            return (Criteria) this;
        }

        public Criteria andCriticidBetween(String value1, String value2) {
            addCriterion("criticId between", value1, value2, "criticid");
            return (Criteria) this;
        }

        public Criteria andCriticidNotBetween(String value1, String value2) {
            addCriterion("criticId not between", value1, value2, "criticid");
            return (Criteria) this;
        }

        public Criteria andCircleidIsNull() {
            addCriterion("circleId is null");
            return (Criteria) this;
        }

        public Criteria andCircleidIsNotNull() {
            addCriterion("circleId is not null");
            return (Criteria) this;
        }

        public Criteria andCircleidEqualTo(String value) {
            addCriterion("circleId =", value, "circleid");
            return (Criteria) this;
        }

        public Criteria andCircleidNotEqualTo(String value) {
            addCriterion("circleId <>", value, "circleid");
            return (Criteria) this;
        }

        public Criteria andCircleidGreaterThan(String value) {
            addCriterion("circleId >", value, "circleid");
            return (Criteria) this;
        }

        public Criteria andCircleidGreaterThanOrEqualTo(String value) {
            addCriterion("circleId >=", value, "circleid");
            return (Criteria) this;
        }

        public Criteria andCircleidLessThan(String value) {
            addCriterion("circleId <", value, "circleid");
            return (Criteria) this;
        }

        public Criteria andCircleidLessThanOrEqualTo(String value) {
            addCriterion("circleId <=", value, "circleid");
            return (Criteria) this;
        }

        public Criteria andCircleidLike(String value) {
            addCriterion("circleId like", value, "circleid");
            return (Criteria) this;
        }

        public Criteria andCircleidNotLike(String value) {
            addCriterion("circleId not like", value, "circleid");
            return (Criteria) this;
        }

        public Criteria andCircleidIn(List<String> values) {
            addCriterion("circleId in", values, "circleid");
            return (Criteria) this;
        }

        public Criteria andCircleidNotIn(List<String> values) {
            addCriterion("circleId not in", values, "circleid");
            return (Criteria) this;
        }

        public Criteria andCircleidBetween(String value1, String value2) {
            addCriterion("circleId between", value1, value2, "circleid");
            return (Criteria) this;
        }

        public Criteria andCircleidNotBetween(String value1, String value2) {
            addCriterion("circleId not between", value1, value2, "circleid");
            return (Criteria) this;
        }

        public Criteria andCommenttimeIsNull() {
            addCriterion("commentTime is null");
            return (Criteria) this;
        }

        public Criteria andCommenttimeIsNotNull() {
            addCriterion("commentTime is not null");
            return (Criteria) this;
        }

        public Criteria andCommenttimeEqualTo(Date value) {
            addCriterion("commentTime =", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeNotEqualTo(Date value) {
            addCriterion("commentTime <>", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeGreaterThan(Date value) {
            addCriterion("commentTime >", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("commentTime >=", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeLessThan(Date value) {
            addCriterion("commentTime <", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeLessThanOrEqualTo(Date value) {
            addCriterion("commentTime <=", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeIn(List<Date> values) {
            addCriterion("commentTime in", values, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeNotIn(List<Date> values) {
            addCriterion("commentTime not in", values, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeBetween(Date value1, Date value2) {
            addCriterion("commentTime between", value1, value2, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeNotBetween(Date value1, Date value2) {
            addCriterion("commentTime not between", value1, value2, "commenttime");
            return (Criteria) this;
        }

        public Criteria andParentcommentidIsNull() {
            addCriterion("parentcommentid is null");
            return (Criteria) this;
        }

        public Criteria andParentcommentidIsNotNull() {
            addCriterion("parentcommentid is not null");
            return (Criteria) this;
        }

        public Criteria andParentcommentidEqualTo(String value) {
            addCriterion("parentcommentid =", value, "parentcommentid");
            return (Criteria) this;
        }

        public Criteria andParentcommentidNotEqualTo(String value) {
            addCriterion("parentcommentid <>", value, "parentcommentid");
            return (Criteria) this;
        }

        public Criteria andParentcommentidGreaterThan(String value) {
            addCriterion("parentcommentid >", value, "parentcommentid");
            return (Criteria) this;
        }

        public Criteria andParentcommentidGreaterThanOrEqualTo(String value) {
            addCriterion("parentcommentid >=", value, "parentcommentid");
            return (Criteria) this;
        }

        public Criteria andParentcommentidLessThan(String value) {
            addCriterion("parentcommentid <", value, "parentcommentid");
            return (Criteria) this;
        }

        public Criteria andParentcommentidLessThanOrEqualTo(String value) {
            addCriterion("parentcommentid <=", value, "parentcommentid");
            return (Criteria) this;
        }

        public Criteria andParentcommentidLike(String value) {
            addCriterion("parentcommentid like", value, "parentcommentid");
            return (Criteria) this;
        }

        public Criteria andParentcommentidNotLike(String value) {
            addCriterion("parentcommentid not like", value, "parentcommentid");
            return (Criteria) this;
        }

        public Criteria andParentcommentidIn(List<String> values) {
            addCriterion("parentcommentid in", values, "parentcommentid");
            return (Criteria) this;
        }

        public Criteria andParentcommentidNotIn(List<String> values) {
            addCriterion("parentcommentid not in", values, "parentcommentid");
            return (Criteria) this;
        }

        public Criteria andParentcommentidBetween(String value1, String value2) {
            addCriterion("parentcommentid between", value1, value2, "parentcommentid");
            return (Criteria) this;
        }

        public Criteria andParentcommentidNotBetween(String value1, String value2) {
            addCriterion("parentcommentid not between", value1, value2, "parentcommentid");
            return (Criteria) this;
        }
    }

    /**
     * u_comment
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * u_comment 2017-12-11
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