package com.zyt.cxfq.model;

import java.io.Serializable;
import java.util.Date;

public class DQuote implements Serializable {
    /**
     * 
     */
    private String quoteId;

    /**
     * 车id
     */
    private String carId;

    /**
     * 交强险data
     */
    private String jqData;

    /**
     * 车船税data
     */
    private String taxData;

    /**
     * 商业险开始时间
     */
    private String syStartDate;

    /**
     * 商业险结束时间
     */
    private String syEndDate;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String updateUserId;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * d_quote
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * @return quote_id 
     */
    public String getQuoteId() {
        return quoteId;
    }

    /**
     * 
     * @param quoteId 
     */
    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId == null ? null : quoteId.trim();
    }

    /**
     * 车id
     * @return car_id 车id
     */
    public String getCarId() {
        return carId;
    }

    /**
     * 车id
     * @param carId 车id
     */
    public void setCarId(String carId) {
        this.carId = carId == null ? null : carId.trim();
    }

    /**
     * 交强险data
     * @return jq_data 交强险data
     */
    public String getJqData() {
        return jqData;
    }

    /**
     * 交强险data
     * @param jqData 交强险data
     */
    public void setJqData(String jqData) {
        this.jqData = jqData == null ? null : jqData.trim();
    }

    /**
     * 车船税data
     * @return tax_data 车船税data
     */
    public String getTaxData() {
        return taxData;
    }

    /**
     * 车船税data
     * @param taxData 车船税data
     */
    public void setTaxData(String taxData) {
        this.taxData = taxData == null ? null : taxData.trim();
    }

    /**
     * 商业险开始时间
     * @return sy_start_date 商业险开始时间
     */
    public String getSyStartDate() {
        return syStartDate;
    }

    /**
     * 商业险开始时间
     * @param syStartDate 商业险开始时间
     */
    public void setSyStartDate(String syStartDate) {
        this.syStartDate = syStartDate == null ? null : syStartDate.trim();
    }

    /**
     * 商业险结束时间
     * @return sy_end_date 商业险结束时间
     */
    public String getSyEndDate() {
        return syEndDate;
    }

    /**
     * 商业险结束时间
     * @param syEndDate 商业险结束时间
     */
    public void setSyEndDate(String syEndDate) {
        this.syEndDate = syEndDate == null ? null : syEndDate.trim();
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改人
     * @return update_user_id 修改人
     */
    public String getUpdateUserId() {
        return updateUserId;
    }

    /**
     * 修改人
     * @param updateUserId 修改人
     */
    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId == null ? null : updateUserId.trim();
    }

    /**
     * 修改时间
     * @return update_time 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}