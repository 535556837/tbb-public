package com.zyt.cxfq.model;

import com.zyt.cxfq.plugin.page.BootPage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DShortMsgExample {
    /**
     * d_short_msg
     */
    protected String orderByClause;

    /**
     * d_short_msg
     */
    protected boolean distinct;

    /**
     * d_short_msg
     */
    protected List<Criteria> oredCriteria;

    /**
     * d_short_msg
     */
    protected BootPage page;

    /**
     *
     * @mbggenerated 2019-01-11
     */
    public DShortMsgExample() {
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
     * d_short_msg 2019-01-11
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

        public Criteria andTMessagemanageridIsNull() {
            addCriterion("T_MessageManagerID is null");
            return (Criteria) this;
        }

        public Criteria andTMessagemanageridIsNotNull() {
            addCriterion("T_MessageManagerID is not null");
            return (Criteria) this;
        }

        public Criteria andTMessagemanageridEqualTo(String value) {
            addCriterion("T_MessageManagerID =", value, "tMessagemanagerid");
            return (Criteria) this;
        }

        public Criteria andTMessagemanageridNotEqualTo(String value) {
            addCriterion("T_MessageManagerID <>", value, "tMessagemanagerid");
            return (Criteria) this;
        }

        public Criteria andTMessagemanageridGreaterThan(String value) {
            addCriterion("T_MessageManagerID >", value, "tMessagemanagerid");
            return (Criteria) this;
        }

        public Criteria andTMessagemanageridGreaterThanOrEqualTo(String value) {
            addCriterion("T_MessageManagerID >=", value, "tMessagemanagerid");
            return (Criteria) this;
        }

        public Criteria andTMessagemanageridLessThan(String value) {
            addCriterion("T_MessageManagerID <", value, "tMessagemanagerid");
            return (Criteria) this;
        }

        public Criteria andTMessagemanageridLessThanOrEqualTo(String value) {
            addCriterion("T_MessageManagerID <=", value, "tMessagemanagerid");
            return (Criteria) this;
        }

        public Criteria andTMessagemanageridLike(String value) {
            addCriterion("T_MessageManagerID like", value, "tMessagemanagerid");
            return (Criteria) this;
        }

        public Criteria andTMessagemanageridNotLike(String value) {
            addCriterion("T_MessageManagerID not like", value, "tMessagemanagerid");
            return (Criteria) this;
        }

        public Criteria andTMessagemanageridIn(List<String> values) {
            addCriterion("T_MessageManagerID in", values, "tMessagemanagerid");
            return (Criteria) this;
        }

        public Criteria andTMessagemanageridNotIn(List<String> values) {
            addCriterion("T_MessageManagerID not in", values, "tMessagemanagerid");
            return (Criteria) this;
        }

        public Criteria andTMessagemanageridBetween(String value1, String value2) {
            addCriterion("T_MessageManagerID between", value1, value2, "tMessagemanagerid");
            return (Criteria) this;
        }

        public Criteria andTMessagemanageridNotBetween(String value1, String value2) {
            addCriterion("T_MessageManagerID not between", value1, value2, "tMessagemanagerid");
            return (Criteria) this;
        }

        public Criteria andMsgtypeIsNull() {
            addCriterion("MsgType is null");
            return (Criteria) this;
        }

        public Criteria andMsgtypeIsNotNull() {
            addCriterion("MsgType is not null");
            return (Criteria) this;
        }

        public Criteria andMsgtypeEqualTo(Integer value) {
            addCriterion("MsgType =", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotEqualTo(Integer value) {
            addCriterion("MsgType <>", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeGreaterThan(Integer value) {
            addCriterion("MsgType >", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("MsgType >=", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeLessThan(Integer value) {
            addCriterion("MsgType <", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeLessThanOrEqualTo(Integer value) {
            addCriterion("MsgType <=", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeIn(List<Integer> values) {
            addCriterion("MsgType in", values, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotIn(List<Integer> values) {
            addCriterion("MsgType not in", values, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeBetween(Integer value1, Integer value2) {
            addCriterion("MsgType between", value1, value2, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("MsgType not between", value1, value2, "msgtype");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("Title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("Title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("Title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("Title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("Title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("Title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("Title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("Title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("Title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("Title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("Title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("Title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("Title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("Title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("Content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("Content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("Content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("Content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("Content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("Content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("Content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("Content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("Content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("Content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("Content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("Content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("Content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("Content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andMessagetypeIsNull() {
            addCriterion("MessageType is null");
            return (Criteria) this;
        }

        public Criteria andMessagetypeIsNotNull() {
            addCriterion("MessageType is not null");
            return (Criteria) this;
        }

        public Criteria andMessagetypeEqualTo(Integer value) {
            addCriterion("MessageType =", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeNotEqualTo(Integer value) {
            addCriterion("MessageType <>", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeGreaterThan(Integer value) {
            addCriterion("MessageType >", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("MessageType >=", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeLessThan(Integer value) {
            addCriterion("MessageType <", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeLessThanOrEqualTo(Integer value) {
            addCriterion("MessageType <=", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeIn(List<Integer> values) {
            addCriterion("MessageType in", values, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeNotIn(List<Integer> values) {
            addCriterion("MessageType not in", values, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeBetween(Integer value1, Integer value2) {
            addCriterion("MessageType between", value1, value2, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("MessageType not between", value1, value2, "messagetype");
            return (Criteria) this;
        }

        public Criteria andSendtypeIsNull() {
            addCriterion("sendtype is null");
            return (Criteria) this;
        }

        public Criteria andSendtypeIsNotNull() {
            addCriterion("sendtype is not null");
            return (Criteria) this;
        }

        public Criteria andSendtypeEqualTo(String value) {
            addCriterion("sendtype =", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeNotEqualTo(String value) {
            addCriterion("sendtype <>", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeGreaterThan(String value) {
            addCriterion("sendtype >", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeGreaterThanOrEqualTo(String value) {
            addCriterion("sendtype >=", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeLessThan(String value) {
            addCriterion("sendtype <", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeLessThanOrEqualTo(String value) {
            addCriterion("sendtype <=", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeLike(String value) {
            addCriterion("sendtype like", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeNotLike(String value) {
            addCriterion("sendtype not like", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeIn(List<String> values) {
            addCriterion("sendtype in", values, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeNotIn(List<String> values) {
            addCriterion("sendtype not in", values, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeBetween(String value1, String value2) {
            addCriterion("sendtype between", value1, value2, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeNotBetween(String value1, String value2) {
            addCriterion("sendtype not between", value1, value2, "sendtype");
            return (Criteria) this;
        }

        public Criteria andRelesedateIsNull() {
            addCriterion("ReleseDate is null");
            return (Criteria) this;
        }

        public Criteria andRelesedateIsNotNull() {
            addCriterion("ReleseDate is not null");
            return (Criteria) this;
        }

        public Criteria andRelesedateEqualTo(Date value) {
            addCriterion("ReleseDate =", value, "relesedate");
            return (Criteria) this;
        }

        public Criteria andRelesedateNotEqualTo(Date value) {
            addCriterion("ReleseDate <>", value, "relesedate");
            return (Criteria) this;
        }

        public Criteria andRelesedateGreaterThan(Date value) {
            addCriterion("ReleseDate >", value, "relesedate");
            return (Criteria) this;
        }

        public Criteria andRelesedateGreaterThanOrEqualTo(Date value) {
            addCriterion("ReleseDate >=", value, "relesedate");
            return (Criteria) this;
        }

        public Criteria andRelesedateLessThan(Date value) {
            addCriterion("ReleseDate <", value, "relesedate");
            return (Criteria) this;
        }

        public Criteria andRelesedateLessThanOrEqualTo(Date value) {
            addCriterion("ReleseDate <=", value, "relesedate");
            return (Criteria) this;
        }

        public Criteria andRelesedateIn(List<Date> values) {
            addCriterion("ReleseDate in", values, "relesedate");
            return (Criteria) this;
        }

        public Criteria andRelesedateNotIn(List<Date> values) {
            addCriterion("ReleseDate not in", values, "relesedate");
            return (Criteria) this;
        }

        public Criteria andRelesedateBetween(Date value1, Date value2) {
            addCriterion("ReleseDate between", value1, value2, "relesedate");
            return (Criteria) this;
        }

        public Criteria andRelesedateNotBetween(Date value1, Date value2) {
            addCriterion("ReleseDate not between", value1, value2, "relesedate");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CreateTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CreateTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CreateTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CreateTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CreateTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CreateTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CreateTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CreateTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CreateTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CreateTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }
    }

    /**
     * d_short_msg
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * d_short_msg 2019-01-11
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