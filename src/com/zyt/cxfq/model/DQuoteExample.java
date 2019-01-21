package com.zyt.cxfq.model;

import com.zyt.cxfq.plugin.page.BootPage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DQuoteExample {
    /**
     * d_quote
     */
    protected String orderByClause;

    /**
     * d_quote
     */
    protected boolean distinct;

    /**
     * d_quote
     */
    protected List<Criteria> oredCriteria;

    /**
     * d_quote
     */
    protected BootPage page;

    /**
     *
     * @mbggenerated 2019-01-17
     */
    public DQuoteExample() {
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
     * d_quote 2019-01-17
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

        public Criteria andQuoteIdIsNull() {
            addCriterion("quote_id is null");
            return (Criteria) this;
        }

        public Criteria andQuoteIdIsNotNull() {
            addCriterion("quote_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuoteIdEqualTo(String value) {
            addCriterion("quote_id =", value, "quoteId");
            return (Criteria) this;
        }

        public Criteria andQuoteIdNotEqualTo(String value) {
            addCriterion("quote_id <>", value, "quoteId");
            return (Criteria) this;
        }

        public Criteria andQuoteIdGreaterThan(String value) {
            addCriterion("quote_id >", value, "quoteId");
            return (Criteria) this;
        }

        public Criteria andQuoteIdGreaterThanOrEqualTo(String value) {
            addCriterion("quote_id >=", value, "quoteId");
            return (Criteria) this;
        }

        public Criteria andQuoteIdLessThan(String value) {
            addCriterion("quote_id <", value, "quoteId");
            return (Criteria) this;
        }

        public Criteria andQuoteIdLessThanOrEqualTo(String value) {
            addCriterion("quote_id <=", value, "quoteId");
            return (Criteria) this;
        }

        public Criteria andQuoteIdLike(String value) {
            addCriterion("quote_id like", value, "quoteId");
            return (Criteria) this;
        }

        public Criteria andQuoteIdNotLike(String value) {
            addCriterion("quote_id not like", value, "quoteId");
            return (Criteria) this;
        }

        public Criteria andQuoteIdIn(List<String> values) {
            addCriterion("quote_id in", values, "quoteId");
            return (Criteria) this;
        }

        public Criteria andQuoteIdNotIn(List<String> values) {
            addCriterion("quote_id not in", values, "quoteId");
            return (Criteria) this;
        }

        public Criteria andQuoteIdBetween(String value1, String value2) {
            addCriterion("quote_id between", value1, value2, "quoteId");
            return (Criteria) this;
        }

        public Criteria andQuoteIdNotBetween(String value1, String value2) {
            addCriterion("quote_id not between", value1, value2, "quoteId");
            return (Criteria) this;
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

        public Criteria andJqDataIsNull() {
            addCriterion("jq_data is null");
            return (Criteria) this;
        }

        public Criteria andJqDataIsNotNull() {
            addCriterion("jq_data is not null");
            return (Criteria) this;
        }

        public Criteria andJqDataEqualTo(String value) {
            addCriterion("jq_data =", value, "jqData");
            return (Criteria) this;
        }

        public Criteria andJqDataNotEqualTo(String value) {
            addCriterion("jq_data <>", value, "jqData");
            return (Criteria) this;
        }

        public Criteria andJqDataGreaterThan(String value) {
            addCriterion("jq_data >", value, "jqData");
            return (Criteria) this;
        }

        public Criteria andJqDataGreaterThanOrEqualTo(String value) {
            addCriterion("jq_data >=", value, "jqData");
            return (Criteria) this;
        }

        public Criteria andJqDataLessThan(String value) {
            addCriterion("jq_data <", value, "jqData");
            return (Criteria) this;
        }

        public Criteria andJqDataLessThanOrEqualTo(String value) {
            addCriterion("jq_data <=", value, "jqData");
            return (Criteria) this;
        }

        public Criteria andJqDataLike(String value) {
            addCriterion("jq_data like", value, "jqData");
            return (Criteria) this;
        }

        public Criteria andJqDataNotLike(String value) {
            addCriterion("jq_data not like", value, "jqData");
            return (Criteria) this;
        }

        public Criteria andJqDataIn(List<String> values) {
            addCriterion("jq_data in", values, "jqData");
            return (Criteria) this;
        }

        public Criteria andJqDataNotIn(List<String> values) {
            addCriterion("jq_data not in", values, "jqData");
            return (Criteria) this;
        }

        public Criteria andJqDataBetween(String value1, String value2) {
            addCriterion("jq_data between", value1, value2, "jqData");
            return (Criteria) this;
        }

        public Criteria andJqDataNotBetween(String value1, String value2) {
            addCriterion("jq_data not between", value1, value2, "jqData");
            return (Criteria) this;
        }

        public Criteria andTaxDataIsNull() {
            addCriterion("tax_data is null");
            return (Criteria) this;
        }

        public Criteria andTaxDataIsNotNull() {
            addCriterion("tax_data is not null");
            return (Criteria) this;
        }

        public Criteria andTaxDataEqualTo(String value) {
            addCriterion("tax_data =", value, "taxData");
            return (Criteria) this;
        }

        public Criteria andTaxDataNotEqualTo(String value) {
            addCriterion("tax_data <>", value, "taxData");
            return (Criteria) this;
        }

        public Criteria andTaxDataGreaterThan(String value) {
            addCriterion("tax_data >", value, "taxData");
            return (Criteria) this;
        }

        public Criteria andTaxDataGreaterThanOrEqualTo(String value) {
            addCriterion("tax_data >=", value, "taxData");
            return (Criteria) this;
        }

        public Criteria andTaxDataLessThan(String value) {
            addCriterion("tax_data <", value, "taxData");
            return (Criteria) this;
        }

        public Criteria andTaxDataLessThanOrEqualTo(String value) {
            addCriterion("tax_data <=", value, "taxData");
            return (Criteria) this;
        }

        public Criteria andTaxDataLike(String value) {
            addCriterion("tax_data like", value, "taxData");
            return (Criteria) this;
        }

        public Criteria andTaxDataNotLike(String value) {
            addCriterion("tax_data not like", value, "taxData");
            return (Criteria) this;
        }

        public Criteria andTaxDataIn(List<String> values) {
            addCriterion("tax_data in", values, "taxData");
            return (Criteria) this;
        }

        public Criteria andTaxDataNotIn(List<String> values) {
            addCriterion("tax_data not in", values, "taxData");
            return (Criteria) this;
        }

        public Criteria andTaxDataBetween(String value1, String value2) {
            addCriterion("tax_data between", value1, value2, "taxData");
            return (Criteria) this;
        }

        public Criteria andTaxDataNotBetween(String value1, String value2) {
            addCriterion("tax_data not between", value1, value2, "taxData");
            return (Criteria) this;
        }

        public Criteria andSyStartDateIsNull() {
            addCriterion("sy_start_date is null");
            return (Criteria) this;
        }

        public Criteria andSyStartDateIsNotNull() {
            addCriterion("sy_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andSyStartDateEqualTo(String value) {
            addCriterion("sy_start_date =", value, "syStartDate");
            return (Criteria) this;
        }

        public Criteria andSyStartDateNotEqualTo(String value) {
            addCriterion("sy_start_date <>", value, "syStartDate");
            return (Criteria) this;
        }

        public Criteria andSyStartDateGreaterThan(String value) {
            addCriterion("sy_start_date >", value, "syStartDate");
            return (Criteria) this;
        }

        public Criteria andSyStartDateGreaterThanOrEqualTo(String value) {
            addCriterion("sy_start_date >=", value, "syStartDate");
            return (Criteria) this;
        }

        public Criteria andSyStartDateLessThan(String value) {
            addCriterion("sy_start_date <", value, "syStartDate");
            return (Criteria) this;
        }

        public Criteria andSyStartDateLessThanOrEqualTo(String value) {
            addCriterion("sy_start_date <=", value, "syStartDate");
            return (Criteria) this;
        }

        public Criteria andSyStartDateLike(String value) {
            addCriterion("sy_start_date like", value, "syStartDate");
            return (Criteria) this;
        }

        public Criteria andSyStartDateNotLike(String value) {
            addCriterion("sy_start_date not like", value, "syStartDate");
            return (Criteria) this;
        }

        public Criteria andSyStartDateIn(List<String> values) {
            addCriterion("sy_start_date in", values, "syStartDate");
            return (Criteria) this;
        }

        public Criteria andSyStartDateNotIn(List<String> values) {
            addCriterion("sy_start_date not in", values, "syStartDate");
            return (Criteria) this;
        }

        public Criteria andSyStartDateBetween(String value1, String value2) {
            addCriterion("sy_start_date between", value1, value2, "syStartDate");
            return (Criteria) this;
        }

        public Criteria andSyStartDateNotBetween(String value1, String value2) {
            addCriterion("sy_start_date not between", value1, value2, "syStartDate");
            return (Criteria) this;
        }

        public Criteria andSyEndDateIsNull() {
            addCriterion("sy_end_date is null");
            return (Criteria) this;
        }

        public Criteria andSyEndDateIsNotNull() {
            addCriterion("sy_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andSyEndDateEqualTo(String value) {
            addCriterion("sy_end_date =", value, "syEndDate");
            return (Criteria) this;
        }

        public Criteria andSyEndDateNotEqualTo(String value) {
            addCriterion("sy_end_date <>", value, "syEndDate");
            return (Criteria) this;
        }

        public Criteria andSyEndDateGreaterThan(String value) {
            addCriterion("sy_end_date >", value, "syEndDate");
            return (Criteria) this;
        }

        public Criteria andSyEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("sy_end_date >=", value, "syEndDate");
            return (Criteria) this;
        }

        public Criteria andSyEndDateLessThan(String value) {
            addCriterion("sy_end_date <", value, "syEndDate");
            return (Criteria) this;
        }

        public Criteria andSyEndDateLessThanOrEqualTo(String value) {
            addCriterion("sy_end_date <=", value, "syEndDate");
            return (Criteria) this;
        }

        public Criteria andSyEndDateLike(String value) {
            addCriterion("sy_end_date like", value, "syEndDate");
            return (Criteria) this;
        }

        public Criteria andSyEndDateNotLike(String value) {
            addCriterion("sy_end_date not like", value, "syEndDate");
            return (Criteria) this;
        }

        public Criteria andSyEndDateIn(List<String> values) {
            addCriterion("sy_end_date in", values, "syEndDate");
            return (Criteria) this;
        }

        public Criteria andSyEndDateNotIn(List<String> values) {
            addCriterion("sy_end_date not in", values, "syEndDate");
            return (Criteria) this;
        }

        public Criteria andSyEndDateBetween(String value1, String value2) {
            addCriterion("sy_end_date between", value1, value2, "syEndDate");
            return (Criteria) this;
        }

        public Criteria andSyEndDateNotBetween(String value1, String value2) {
            addCriterion("sy_end_date not between", value1, value2, "syEndDate");
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
     * d_quote
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * d_quote 2019-01-17
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