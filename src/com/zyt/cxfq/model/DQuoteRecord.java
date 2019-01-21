package com.zyt.cxfq.model;

import java.io.Serializable;
import java.util.Date;

public class DQuoteRecord implements Serializable {
    /**
     * 报价记录id
     */
    private String quoteRecordId;

    /**
     * 全价id
     */
    private String quoteId;

    /**
     * 员工id
     */
    private String empId;

    /**
     * 数据
     */
    private String msg;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 车牌
     */
    private String licenseNo;

    /**
     * 保单到期时间
     */
    private String policyEndTime;

    /**
     * 来源保险公司
     */
    private String source;

    /**
     * 是否核保 0 否，1 是
     */
    private String isCheck;

    /**
     * d_quote_record
     */
    private static final long serialVersionUID = 1L;

    /**
     * 报价记录id
     * @return quote_record_id 报价记录id
     */
    public String getQuoteRecordId() {
        return quoteRecordId;
    }

    /**
     * 报价记录id
     * @param quoteRecordId 报价记录id
     */
    public void setQuoteRecordId(String quoteRecordId) {
        this.quoteRecordId = quoteRecordId == null ? null : quoteRecordId.trim();
    }

    /**
     * 全价id
     * @return quote_id 全价id
     */
    public String getQuoteId() {
        return quoteId;
    }

    /**
     * 全价id
     * @param quoteId 全价id
     */
    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId == null ? null : quoteId.trim();
    }

    /**
     * 员工id
     * @return emp_id 员工id
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * 员工id
     * @param empId 员工id
     */
    public void setEmpId(String empId) {
        this.empId = empId == null ? null : empId.trim();
    }

    /**
     * 数据
     * @return msg 数据
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 数据
     * @param msg 数据
     */
    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
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
     * 车牌
     * @return license_no 车牌
     */
    public String getLicenseNo() {
        return licenseNo;
    }

    /**
     * 车牌
     * @param licenseNo 车牌
     */
    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo == null ? null : licenseNo.trim();
    }

    /**
     * 保单到期时间
     * @return policy_end_time 保单到期时间
     */
    public String getPolicyEndTime() {
        return policyEndTime;
    }

    /**
     * 保单到期时间
     * @param policyEndTime 保单到期时间
     */
    public void setPolicyEndTime(String policyEndTime) {
        this.policyEndTime = policyEndTime == null ? null : policyEndTime.trim();
    }

    /**
     * 来源保险公司
     * @return source 来源保险公司
     */
    public String getSource() {
        return source;
    }

    /**
     * 来源保险公司
     * @param source 来源保险公司
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * 是否核保 0 否，1 是
     * @return is_check 是否核保 0 否，1 是
     */
    public String getIsCheck() {
        return isCheck;
    }

    /**
     * 是否核保 0 否，1 是
     * @param isCheck 是否核保 0 否，1 是
     */
    public void setIsCheck(String isCheck) {
        this.isCheck = isCheck == null ? null : isCheck.trim();
    }
}