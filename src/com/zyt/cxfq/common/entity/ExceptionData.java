package com.zyt.cxfq.common.entity;

import java.util.Date;

public class ExceptionData  {
    /**
     * 主键
     */
    private String exceptionrecordid;
    
    /**
     * 用户电话
     */
    private String phone;

    /**
     * 用户id
     */
    private String bmemberid;

    /**
     * 请求地址
     */
    private String requesturl;

    /**
     * 用户ip
     */
    private String ipaddr;
    
    /**
     * 异常信息
     */
    private String emsg;

    /**
     * 异常类型
     */
    private String classname;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 请求来源（1.微信端，2.app,3.pc,4.pc管理）
     */
    private Integer resource;


    /**
     * 主键
     * @return exceptionrecordid 主键
     */
    public String getExceptionrecordid() {
        return exceptionrecordid;
    }

    /**
     * 主键
     * @param exceptionrecordid 主键
     */
    public void setExceptionrecordid(String exceptionrecordid) {
        this.exceptionrecordid = exceptionrecordid == null ? null : exceptionrecordid.trim();
    }

    /**
     * 用户id
     * @return bmemberid 用户id
     */
    public String getBmemberid() {
        return bmemberid;
    }
    

    public String getEmsg() {
		return emsg;
	}

	public void setEmsg(String emsg) {
		this.emsg = emsg;
	}

	/**
     * 用户id
     * @param bmemberid 用户id
     */
    public void setBmemberid(String bmemberid) {
        this.bmemberid = bmemberid == null ? null : bmemberid.trim();
    }

    /**
     * 请求地址
     * @return requesturl 请求地址
     */
    public String getRequesturl() {
        return requesturl;
    }

    /**
     * 请求地址
     * @param requesturl 请求地址
     */
    public void setRequesturl(String requesturl) {
        this.requesturl = requesturl == null ? null : requesturl.trim();
    }

    /**
     * 用户ip
     * @return ipaddr 用户ip
     */
    public String getIpaddr() {
        return ipaddr;
    }

    /**
     * 用户ip
     * @param ipaddr 用户ip
     */
    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr == null ? null : ipaddr.trim();
    }

    /**
     * 异常类型
     * @return classname 异常类型
     */
    public String getClassname() {
        return classname;
    }

    /**
     * 异常类型
     * @param classname 异常类型
     */
    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    /**
     * 创建时间
     * @return createtime 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 创建时间
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 请求来源（1.微信端，2.app,3.pc,4.pc管理）
     * @return resource 请求来源（1.微信端，2.app,3.pc,4.pc管理）
     */
    public Integer getResource() {
        return resource;
    }

    /**
     * 请求来源（1.微信端，2.app,3.pc,4.pc管理）
     * @param resource 请求来源（1.微信端，2.app,3.pc,4.pc管理）
     */
    public void setResource(Integer resource) {
        this.resource = resource;
    }
    /**
     * 用户电话
     * @param phone 用户电话
     */
	public String getPhone() {
		return phone;
	}
	/**
     * 用户电话
     * @param phone 用户电话
     */
	public void setPhone(String phone) {
		this.phone = phone;
	}
    
}

