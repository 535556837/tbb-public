package com.zyt.cxfq.model;

import com.zyt.cxfq.plugin.page.BootPage;
import java.util.ArrayList;
import java.util.List;

public class DQuoteDtlExample {
    /**
     * d_quote_dtl
     */
    protected String orderByClause;

    /**
     * d_quote_dtl
     */
    protected boolean distinct;

    /**
     * d_quote_dtl
     */
    protected List<Criteria> oredCriteria;

    /**
     * d_quote_dtl
     */
    protected BootPage page;

    /**
     *
     * @mbggenerated 2019-01-17
     */
    public DQuoteDtlExample() {
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
     * d_quote_dtl 2019-01-17
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

        public Criteria andQuoteDelIdIsNull() {
            addCriterion("quote_del_id is null");
            return (Criteria) this;
        }

        public Criteria andQuoteDelIdIsNotNull() {
            addCriterion("quote_del_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuoteDelIdEqualTo(String value) {
            addCriterion("quote_del_id =", value, "quoteDelId");
            return (Criteria) this;
        }

        public Criteria andQuoteDelIdNotEqualTo(String value) {
            addCriterion("quote_del_id <>", value, "quoteDelId");
            return (Criteria) this;
        }

        public Criteria andQuoteDelIdGreaterThan(String value) {
            addCriterion("quote_del_id >", value, "quoteDelId");
            return (Criteria) this;
        }

        public Criteria andQuoteDelIdGreaterThanOrEqualTo(String value) {
            addCriterion("quote_del_id >=", value, "quoteDelId");
            return (Criteria) this;
        }

        public Criteria andQuoteDelIdLessThan(String value) {
            addCriterion("quote_del_id <", value, "quoteDelId");
            return (Criteria) this;
        }

        public Criteria andQuoteDelIdLessThanOrEqualTo(String value) {
            addCriterion("quote_del_id <=", value, "quoteDelId");
            return (Criteria) this;
        }

        public Criteria andQuoteDelIdLike(String value) {
            addCriterion("quote_del_id like", value, "quoteDelId");
            return (Criteria) this;
        }

        public Criteria andQuoteDelIdNotLike(String value) {
            addCriterion("quote_del_id not like", value, "quoteDelId");
            return (Criteria) this;
        }

        public Criteria andQuoteDelIdIn(List<String> values) {
            addCriterion("quote_del_id in", values, "quoteDelId");
            return (Criteria) this;
        }

        public Criteria andQuoteDelIdNotIn(List<String> values) {
            addCriterion("quote_del_id not in", values, "quoteDelId");
            return (Criteria) this;
        }

        public Criteria andQuoteDelIdBetween(String value1, String value2) {
            addCriterion("quote_del_id between", value1, value2, "quoteDelId");
            return (Criteria) this;
        }

        public Criteria andQuoteDelIdNotBetween(String value1, String value2) {
            addCriterion("quote_del_id not between", value1, value2, "quoteDelId");
            return (Criteria) this;
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

        public Criteria andKindCodeIsNull() {
            addCriterion("kind_code is null");
            return (Criteria) this;
        }

        public Criteria andKindCodeIsNotNull() {
            addCriterion("kind_code is not null");
            return (Criteria) this;
        }

        public Criteria andKindCodeEqualTo(String value) {
            addCriterion("kind_code =", value, "kindCode");
            return (Criteria) this;
        }

        public Criteria andKindCodeNotEqualTo(String value) {
            addCriterion("kind_code <>", value, "kindCode");
            return (Criteria) this;
        }

        public Criteria andKindCodeGreaterThan(String value) {
            addCriterion("kind_code >", value, "kindCode");
            return (Criteria) this;
        }

        public Criteria andKindCodeGreaterThanOrEqualTo(String value) {
            addCriterion("kind_code >=", value, "kindCode");
            return (Criteria) this;
        }

        public Criteria andKindCodeLessThan(String value) {
            addCriterion("kind_code <", value, "kindCode");
            return (Criteria) this;
        }

        public Criteria andKindCodeLessThanOrEqualTo(String value) {
            addCriterion("kind_code <=", value, "kindCode");
            return (Criteria) this;
        }

        public Criteria andKindCodeLike(String value) {
            addCriterion("kind_code like", value, "kindCode");
            return (Criteria) this;
        }

        public Criteria andKindCodeNotLike(String value) {
            addCriterion("kind_code not like", value, "kindCode");
            return (Criteria) this;
        }

        public Criteria andKindCodeIn(List<String> values) {
            addCriterion("kind_code in", values, "kindCode");
            return (Criteria) this;
        }

        public Criteria andKindCodeNotIn(List<String> values) {
            addCriterion("kind_code not in", values, "kindCode");
            return (Criteria) this;
        }

        public Criteria andKindCodeBetween(String value1, String value2) {
            addCriterion("kind_code between", value1, value2, "kindCode");
            return (Criteria) this;
        }

        public Criteria andKindCodeNotBetween(String value1, String value2) {
            addCriterion("kind_code not between", value1, value2, "kindCode");
            return (Criteria) this;
        }

        public Criteria andKindNameIsNull() {
            addCriterion("kind_name is null");
            return (Criteria) this;
        }

        public Criteria andKindNameIsNotNull() {
            addCriterion("kind_name is not null");
            return (Criteria) this;
        }

        public Criteria andKindNameEqualTo(String value) {
            addCriterion("kind_name =", value, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameNotEqualTo(String value) {
            addCriterion("kind_name <>", value, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameGreaterThan(String value) {
            addCriterion("kind_name >", value, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameGreaterThanOrEqualTo(String value) {
            addCriterion("kind_name >=", value, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameLessThan(String value) {
            addCriterion("kind_name <", value, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameLessThanOrEqualTo(String value) {
            addCriterion("kind_name <=", value, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameLike(String value) {
            addCriterion("kind_name like", value, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameNotLike(String value) {
            addCriterion("kind_name not like", value, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameIn(List<String> values) {
            addCriterion("kind_name in", values, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameNotIn(List<String> values) {
            addCriterion("kind_name not in", values, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameBetween(String value1, String value2) {
            addCriterion("kind_name between", value1, value2, "kindName");
            return (Criteria) this;
        }

        public Criteria andKindNameNotBetween(String value1, String value2) {
            addCriterion("kind_name not between", value1, value2, "kindName");
            return (Criteria) this;
        }

        public Criteria andPremiumIsNull() {
            addCriterion("premium is null");
            return (Criteria) this;
        }

        public Criteria andPremiumIsNotNull() {
            addCriterion("premium is not null");
            return (Criteria) this;
        }

        public Criteria andPremiumEqualTo(String value) {
            addCriterion("premium =", value, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumNotEqualTo(String value) {
            addCriterion("premium <>", value, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumGreaterThan(String value) {
            addCriterion("premium >", value, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumGreaterThanOrEqualTo(String value) {
            addCriterion("premium >=", value, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumLessThan(String value) {
            addCriterion("premium <", value, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumLessThanOrEqualTo(String value) {
            addCriterion("premium <=", value, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumLike(String value) {
            addCriterion("premium like", value, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumNotLike(String value) {
            addCriterion("premium not like", value, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumIn(List<String> values) {
            addCriterion("premium in", values, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumNotIn(List<String> values) {
            addCriterion("premium not in", values, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumBetween(String value1, String value2) {
            addCriterion("premium between", value1, value2, "premium");
            return (Criteria) this;
        }

        public Criteria andPremiumNotBetween(String value1, String value2) {
            addCriterion("premium not between", value1, value2, "premium");
            return (Criteria) this;
        }

        public Criteria andTaxPremiumIsNull() {
            addCriterion("tax_premium is null");
            return (Criteria) this;
        }

        public Criteria andTaxPremiumIsNotNull() {
            addCriterion("tax_premium is not null");
            return (Criteria) this;
        }

        public Criteria andTaxPremiumEqualTo(String value) {
            addCriterion("tax_premium =", value, "taxPremium");
            return (Criteria) this;
        }

        public Criteria andTaxPremiumNotEqualTo(String value) {
            addCriterion("tax_premium <>", value, "taxPremium");
            return (Criteria) this;
        }

        public Criteria andTaxPremiumGreaterThan(String value) {
            addCriterion("tax_premium >", value, "taxPremium");
            return (Criteria) this;
        }

        public Criteria andTaxPremiumGreaterThanOrEqualTo(String value) {
            addCriterion("tax_premium >=", value, "taxPremium");
            return (Criteria) this;
        }

        public Criteria andTaxPremiumLessThan(String value) {
            addCriterion("tax_premium <", value, "taxPremium");
            return (Criteria) this;
        }

        public Criteria andTaxPremiumLessThanOrEqualTo(String value) {
            addCriterion("tax_premium <=", value, "taxPremium");
            return (Criteria) this;
        }

        public Criteria andTaxPremiumLike(String value) {
            addCriterion("tax_premium like", value, "taxPremium");
            return (Criteria) this;
        }

        public Criteria andTaxPremiumNotLike(String value) {
            addCriterion("tax_premium not like", value, "taxPremium");
            return (Criteria) this;
        }

        public Criteria andTaxPremiumIn(List<String> values) {
            addCriterion("tax_premium in", values, "taxPremium");
            return (Criteria) this;
        }

        public Criteria andTaxPremiumNotIn(List<String> values) {
            addCriterion("tax_premium not in", values, "taxPremium");
            return (Criteria) this;
        }

        public Criteria andTaxPremiumBetween(String value1, String value2) {
            addCriterion("tax_premium between", value1, value2, "taxPremium");
            return (Criteria) this;
        }

        public Criteria andTaxPremiumNotBetween(String value1, String value2) {
            addCriterion("tax_premium not between", value1, value2, "taxPremium");
            return (Criteria) this;
        }

        public Criteria andBenchMarkPremiumIsNull() {
            addCriterion("bench_mark_premium is null");
            return (Criteria) this;
        }

        public Criteria andBenchMarkPremiumIsNotNull() {
            addCriterion("bench_mark_premium is not null");
            return (Criteria) this;
        }

        public Criteria andBenchMarkPremiumEqualTo(String value) {
            addCriterion("bench_mark_premium =", value, "benchMarkPremium");
            return (Criteria) this;
        }

        public Criteria andBenchMarkPremiumNotEqualTo(String value) {
            addCriterion("bench_mark_premium <>", value, "benchMarkPremium");
            return (Criteria) this;
        }

        public Criteria andBenchMarkPremiumGreaterThan(String value) {
            addCriterion("bench_mark_premium >", value, "benchMarkPremium");
            return (Criteria) this;
        }

        public Criteria andBenchMarkPremiumGreaterThanOrEqualTo(String value) {
            addCriterion("bench_mark_premium >=", value, "benchMarkPremium");
            return (Criteria) this;
        }

        public Criteria andBenchMarkPremiumLessThan(String value) {
            addCriterion("bench_mark_premium <", value, "benchMarkPremium");
            return (Criteria) this;
        }

        public Criteria andBenchMarkPremiumLessThanOrEqualTo(String value) {
            addCriterion("bench_mark_premium <=", value, "benchMarkPremium");
            return (Criteria) this;
        }

        public Criteria andBenchMarkPremiumLike(String value) {
            addCriterion("bench_mark_premium like", value, "benchMarkPremium");
            return (Criteria) this;
        }

        public Criteria andBenchMarkPremiumNotLike(String value) {
            addCriterion("bench_mark_premium not like", value, "benchMarkPremium");
            return (Criteria) this;
        }

        public Criteria andBenchMarkPremiumIn(List<String> values) {
            addCriterion("bench_mark_premium in", values, "benchMarkPremium");
            return (Criteria) this;
        }

        public Criteria andBenchMarkPremiumNotIn(List<String> values) {
            addCriterion("bench_mark_premium not in", values, "benchMarkPremium");
            return (Criteria) this;
        }

        public Criteria andBenchMarkPremiumBetween(String value1, String value2) {
            addCriterion("bench_mark_premium between", value1, value2, "benchMarkPremium");
            return (Criteria) this;
        }

        public Criteria andBenchMarkPremiumNotBetween(String value1, String value2) {
            addCriterion("bench_mark_premium not between", value1, value2, "benchMarkPremium");
            return (Criteria) this;
        }

        public Criteria andDisCountIsNull() {
            addCriterion("dis_count is null");
            return (Criteria) this;
        }

        public Criteria andDisCountIsNotNull() {
            addCriterion("dis_count is not null");
            return (Criteria) this;
        }

        public Criteria andDisCountEqualTo(String value) {
            addCriterion("dis_count =", value, "disCount");
            return (Criteria) this;
        }

        public Criteria andDisCountNotEqualTo(String value) {
            addCriterion("dis_count <>", value, "disCount");
            return (Criteria) this;
        }

        public Criteria andDisCountGreaterThan(String value) {
            addCriterion("dis_count >", value, "disCount");
            return (Criteria) this;
        }

        public Criteria andDisCountGreaterThanOrEqualTo(String value) {
            addCriterion("dis_count >=", value, "disCount");
            return (Criteria) this;
        }

        public Criteria andDisCountLessThan(String value) {
            addCriterion("dis_count <", value, "disCount");
            return (Criteria) this;
        }

        public Criteria andDisCountLessThanOrEqualTo(String value) {
            addCriterion("dis_count <=", value, "disCount");
            return (Criteria) this;
        }

        public Criteria andDisCountLike(String value) {
            addCriterion("dis_count like", value, "disCount");
            return (Criteria) this;
        }

        public Criteria andDisCountNotLike(String value) {
            addCriterion("dis_count not like", value, "disCount");
            return (Criteria) this;
        }

        public Criteria andDisCountIn(List<String> values) {
            addCriterion("dis_count in", values, "disCount");
            return (Criteria) this;
        }

        public Criteria andDisCountNotIn(List<String> values) {
            addCriterion("dis_count not in", values, "disCount");
            return (Criteria) this;
        }

        public Criteria andDisCountBetween(String value1, String value2) {
            addCriterion("dis_count between", value1, value2, "disCount");
            return (Criteria) this;
        }

        public Criteria andDisCountNotBetween(String value1, String value2) {
            addCriterion("dis_count not between", value1, value2, "disCount");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(String value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(String value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(String value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(String value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(String value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(String value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLike(String value) {
            addCriterion("amount like", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotLike(String value) {
            addCriterion("amount not like", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<String> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<String> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(String value1, String value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(String value1, String value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }
    }

    /**
     * d_quote_dtl
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * d_quote_dtl 2019-01-17
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