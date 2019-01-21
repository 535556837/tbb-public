package com.zyt.cxfq.model;

import java.io.Serializable;
import java.util.Date;

public class DEmployee implements Serializable {
    /**
     * x销售代表主键
     */
    private String uId;

    /**
     * 真实姓名
     */
    private String uName;

    /**
     * 电话
     */
    private String uPhone;

    /**
     * 昵称
     */
    private String uNickName;

    /**
     * 密码
     */
    private String uPwd;

    /**
     * 头像
     */
    private String uPic;

    /**
     * 公司
     */
    private String uCompany;

    /**
     * 备注
     */
    private String uRemark;

    /**
     * 邀请码
     */
    private String uProCode;

    /**
     * 来源邀请码
     */
    private String uFromPro;

    /**
     * 创建人
     */
    private String createUserId;

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
     * d_employee
     */
    private static final long serialVersionUID = 1L;

    /**
     * x销售代表主键
     * @return u_id x销售代表主键
     */
    public String getuId() {
        return uId;
    }

    /**
     * x销售代表主键
     * @param uId x销售代表主键
     */
    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }

    /**
     * 真实姓名
     * @return u_name 真实姓名
     */
    public String getuName() {
        return uName;
    }

    /**
     * 真实姓名
     * @param uName 真实姓名
     */
    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    /**
     * 电话
     * @return u_phone 电话
     */
    public String getuPhone() {
        return uPhone;
    }

    /**
     * 电话
     * @param uPhone 电话
     */
    public void setuPhone(String uPhone) {
        this.uPhone = uPhone == null ? null : uPhone.trim();
    }

    /**
     * 昵称
     * @return u_nick_name 昵称
     */
    public String getuNickName() {
        return uNickName;
    }

    /**
     * 昵称
     * @param uNickName 昵称
     */
    public void setuNickName(String uNickName) {
        this.uNickName = uNickName == null ? null : uNickName.trim();
    }

    /**
     * 密码
     * @return u_pwd 密码
     */
    public String getuPwd() {
        return uPwd;
    }

    /**
     * 密码
     * @param uPwd 密码
     */
    public void setuPwd(String uPwd) {
        this.uPwd = uPwd == null ? null : uPwd.trim();
    }

    /**
     * 头像
     * @return u_pic 头像
     */
    public String getuPic() {
        return uPic;
    }

    /**
     * 头像
     * @param uPic 头像
     */
    public void setuPic(String uPic) {
        this.uPic = uPic == null ? null : uPic.trim();
    }

    /**
     * 公司
     * @return u_company 公司
     */
    public String getuCompany() {
        return uCompany;
    }

    /**
     * 公司
     * @param uCompany 公司
     */
    public void setuCompany(String uCompany) {
        this.uCompany = uCompany == null ? null : uCompany.trim();
    }

    /**
     * 备注
     * @return u_remark 备注
     */
    public String getuRemark() {
        return uRemark;
    }

    /**
     * 备注
     * @param uRemark 备注
     */
    public void setuRemark(String uRemark) {
        this.uRemark = uRemark == null ? null : uRemark.trim();
    }

    /**
     * 邀请码
     * @return u_pro_code 邀请码
     */
    public String getuProCode() {
        return uProCode;
    }

    /**
     * 邀请码
     * @param uProCode 邀请码
     */
    public void setuProCode(String uProCode) {
        this.uProCode = uProCode == null ? null : uProCode.trim();
    }

    /**
     * 来源邀请码
     * @return u_from_pro 来源邀请码
     */
    public String getuFromPro() {
        return uFromPro;
    }

    /**
     * 来源邀请码
     * @param uFromPro 来源邀请码
     */
    public void setuFromPro(String uFromPro) {
        this.uFromPro = uFromPro == null ? null : uFromPro.trim();
    }

    /**
     * 创建人
     * @return create_user_id 创建人
     */
    public String getCreateUserId() {
        return createUserId;
    }

    /**
     * 创建人
     * @param createUserId 创建人
     */
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
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