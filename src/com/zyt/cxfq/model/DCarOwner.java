package com.zyt.cxfq.model;

import java.io.Serializable;
import java.util.Date;

public class DCarOwner implements Serializable {
    /**
     * 主键
     */
    private String carOwnersId;

    /**
     * 邮箱
     */
    private String emailAddress;

    /**
     * 证件号码
     */
    private String identifyNumber;

    /**
     * 证件类型
     */
    private String identifyType;

    /**
     * 地址
     */
    private String insuredAddress;

    /**
     * 名称ID
     */
    private String insuredCode;

    /**
     * 角色Code
     */
    private String insuredFlag;

    /**
     * 角色名称
     */
    private String insuredFlagname;

    /**
     * 用户名称
     */
    private String insuredName;

    /**
     * 类型
     */
    private String insuredType;

    /**
     * 类型ID
     */
    private String insuredTypeName;

    /**
     * 移动电话
     */
    private String mobileNo;

    /**
     * 固定电话
     */
    private String phoneNumber;

    /**
     * 单位性质
     */
    private String unitType;

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
     * d_car_owner
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     * @return car_owners_id 主键
     */
    public String getCarOwnersId() {
        return carOwnersId;
    }

    /**
     * 主键
     * @param carOwnersId 主键
     */
    public void setCarOwnersId(String carOwnersId) {
        this.carOwnersId = carOwnersId == null ? null : carOwnersId.trim();
    }

    /**
     * 邮箱
     * @return email_address 邮箱
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * 邮箱
     * @param emailAddress 邮箱
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress == null ? null : emailAddress.trim();
    }

    /**
     * 证件号码
     * @return identify_number 证件号码
     */
    public String getIdentifyNumber() {
        return identifyNumber;
    }

    /**
     * 证件号码
     * @param identifyNumber 证件号码
     */
    public void setIdentifyNumber(String identifyNumber) {
        this.identifyNumber = identifyNumber == null ? null : identifyNumber.trim();
    }

    /**
     * 证件类型
     * @return identify_type 证件类型
     */
    public String getIdentifyType() {
        return identifyType;
    }

    /**
     * 证件类型
     * @param identifyType 证件类型
     */
    public void setIdentifyType(String identifyType) {
        this.identifyType = identifyType == null ? null : identifyType.trim();
    }

    /**
     * 地址
     * @return insured_address 地址
     */
    public String getInsuredAddress() {
        return insuredAddress;
    }

    /**
     * 地址
     * @param insuredAddress 地址
     */
    public void setInsuredAddress(String insuredAddress) {
        this.insuredAddress = insuredAddress == null ? null : insuredAddress.trim();
    }

    /**
     * 名称ID
     * @return insured_code 名称ID
     */
    public String getInsuredCode() {
        return insuredCode;
    }

    /**
     * 名称ID
     * @param insuredCode 名称ID
     */
    public void setInsuredCode(String insuredCode) {
        this.insuredCode = insuredCode == null ? null : insuredCode.trim();
    }

    /**
     * 角色Code
     * @return insured_flag 角色Code
     */
    public String getInsuredFlag() {
        return insuredFlag;
    }

    /**
     * 角色Code
     * @param insuredFlag 角色Code
     */
    public void setInsuredFlag(String insuredFlag) {
        this.insuredFlag = insuredFlag == null ? null : insuredFlag.trim();
    }

    /**
     * 角色名称
     * @return insured_flagName 角色名称
     */
    public String getInsuredFlagname() {
        return insuredFlagname;
    }

    /**
     * 角色名称
     * @param insuredFlagname 角色名称
     */
    public void setInsuredFlagname(String insuredFlagname) {
        this.insuredFlagname = insuredFlagname == null ? null : insuredFlagname.trim();
    }

    /**
     * 用户名称
     * @return insured_name 用户名称
     */
    public String getInsuredName() {
        return insuredName;
    }

    /**
     * 用户名称
     * @param insuredName 用户名称
     */
    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName == null ? null : insuredName.trim();
    }

    /**
     * 类型
     * @return insured_type 类型
     */
    public String getInsuredType() {
        return insuredType;
    }

    /**
     * 类型
     * @param insuredType 类型
     */
    public void setInsuredType(String insuredType) {
        this.insuredType = insuredType == null ? null : insuredType.trim();
    }

    /**
     * 类型ID
     * @return insured_type_name 类型ID
     */
    public String getInsuredTypeName() {
        return insuredTypeName;
    }

    /**
     * 类型ID
     * @param insuredTypeName 类型ID
     */
    public void setInsuredTypeName(String insuredTypeName) {
        this.insuredTypeName = insuredTypeName == null ? null : insuredTypeName.trim();
    }

    /**
     * 移动电话
     * @return mobile_no 移动电话
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * 移动电话
     * @param mobileNo 移动电话
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    /**
     * 固定电话
     * @return phone_number 固定电话
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 固定电话
     * @param phoneNumber 固定电话
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * 单位性质
     * @return unit_type 单位性质
     */
    public String getUnitType() {
        return unitType;
    }

    /**
     * 单位性质
     * @param unitType 单位性质
     */
    public void setUnitType(String unitType) {
        this.unitType = unitType == null ? null : unitType.trim();
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

	@Override
	public String toString() {
		return "DCarOwner [carOwnersId=" + carOwnersId + ", emailAddress=" + emailAddress + ", identifyNumber="
				+ identifyNumber + ", identifyType=" + identifyType + ", insuredAddress=" + insuredAddress
				+ ", insuredCode=" + insuredCode + ", insuredFlag=" + insuredFlag + ", insuredFlagname="
				+ insuredFlagname + ", insuredName=" + insuredName + ", insuredType=" + insuredType
				+ ", insuredTypeName=" + insuredTypeName + ", mobileNo=" + mobileNo + ", phoneNumber=" + phoneNumber
				+ ", unitType=" + unitType + ", createTime=" + createTime + ", updateUserId=" + updateUserId
				+ ", updateTime=" + updateTime + "]";
	}
    
}