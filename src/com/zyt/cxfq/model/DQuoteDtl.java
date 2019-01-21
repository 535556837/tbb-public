package com.zyt.cxfq.model;

import java.io.Serializable;

public class DQuoteDtl implements Serializable {
    /**
     * 
     */
    private String quoteDelId;

    /**
     * 父级id
     */
    private String quoteId;

    /**
     * 编号
     */
    private String kindCode;

    /**
     * 保险名称
     */
    private String kindName;

    /**
     * 价格
     */
    private String premium;

    /**
     * 税费
     */
    private String taxPremium;

    /**
     * 原价
     */
    private String benchMarkPremium;

    /**
     * 折扣率
     */
    private String disCount;

    /**
     * 保额
     */
    private String amount;

    /**
     * d_quote_dtl
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * @return quote_del_id 
     */
    public String getQuoteDelId() {
        return quoteDelId;
    }

    /**
     * 
     * @param quoteDelId 
     */
    public void setQuoteDelId(String quoteDelId) {
        this.quoteDelId = quoteDelId == null ? null : quoteDelId.trim();
    }

    /**
     * 父级id
     * @return quote_id 父级id
     */
    public String getQuoteId() {
        return quoteId;
    }

    /**
     * 父级id
     * @param quoteId 父级id
     */
    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId == null ? null : quoteId.trim();
    }

    /**
     * 编号
     * @return kind_code 编号
     */
    public String getKindCode() {
        return kindCode;
    }

    /**
     * 编号
     * @param kindCode 编号
     */
    public void setKindCode(String kindCode) {
        this.kindCode = kindCode == null ? null : kindCode.trim();
    }

    /**
     * 保险名称
     * @return kind_name 保险名称
     */
    public String getKindName() {
        return kindName;
    }

    /**
     * 保险名称
     * @param kindName 保险名称
     */
    public void setKindName(String kindName) {
        this.kindName = kindName == null ? null : kindName.trim();
    }

    /**
     * 价格
     * @return premium 价格
     */
    public String getPremium() {
        return premium;
    }

    /**
     * 价格
     * @param premium 价格
     */
    public void setPremium(String premium) {
        this.premium = premium == null ? null : premium.trim();
    }

    /**
     * 税费
     * @return tax_premium 税费
     */
    public String getTaxPremium() {
        return taxPremium;
    }

    /**
     * 税费
     * @param taxPremium 税费
     */
    public void setTaxPremium(String taxPremium) {
        this.taxPremium = taxPremium == null ? null : taxPremium.trim();
    }

    /**
     * 原价
     * @return bench_mark_premium 原价
     */
    public String getBenchMarkPremium() {
        return benchMarkPremium;
    }

    /**
     * 原价
     * @param benchMarkPremium 原价
     */
    public void setBenchMarkPremium(String benchMarkPremium) {
        this.benchMarkPremium = benchMarkPremium == null ? null : benchMarkPremium.trim();
    }

    /**
     * 折扣率
     * @return dis_count 折扣率
     */
    public String getDisCount() {
        return disCount;
    }

    /**
     * 折扣率
     * @param disCount 折扣率
     */
    public void setDisCount(String disCount) {
        this.disCount = disCount == null ? null : disCount.trim();
    }

    /**
     * 保额
     * @return amount 保额
     */
    public String getAmount() {
        return amount;
    }

    /**
     * 保额
     * @param amount 保额
     */
    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }
}