package com.zyt.cxfq.model;

import java.io.Serializable;
import java.util.Date;

public class DEmpClient implements Serializable {
    /**
     * 销售代表客户对应关系主键
     */
    private String empClientId;

    /**
     * 客户主键
     */
    private String clientId;

    /**
     * 车id
     */
    private String uId;

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
     * d_emp_client
     */
    private static final long serialVersionUID = 1L;

    /**
     * 销售代表客户对应关系主键
     * @return emp_client_id 销售代表客户对应关系主键
     */
    public String getEmpClientId() {
        return empClientId;
    }

    /**
     * 销售代表客户对应关系主键
     * @param empClientId 销售代表客户对应关系主键
     */
    public void setEmpClientId(String empClientId) {
        this.empClientId = empClientId == null ? null : empClientId.trim();
    }

    /**
     * 客户主键
     * @return client_id 客户主键
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * 客户主键
     * @param clientId 客户主键
     */
    public void setClientId(String clientId) {
        this.clientId = clientId == null ? null : clientId.trim();
    }

    /**
     * 车id
     * @return u_id 车id
     */
    public String getuId() {
        return uId;
    }

    /**
     * 车id
     * @param uId 车id
     */
    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
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