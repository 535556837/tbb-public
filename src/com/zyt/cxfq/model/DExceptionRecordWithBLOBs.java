package com.zyt.cxfq.model;

import java.io.Serializable;

public class DExceptionRecordWithBLOBs extends DExceptionRecord implements Serializable {
    /**
     * 请求参数
     */
    private String request;

    /**
     * 异常信息
     */
    private String emsg;

    /**
     * 异常堆栈信息
     */
    private String stackmsg;

    /**
     * d_exception_record
     */
    private static final long serialVersionUID = 1L;

    /**
     * 请求参数
     * @return request 请求参数
     */
    public String getRequest() {
        return request;
    }

    /**
     * 请求参数
     * @param request 请求参数
     */
    public void setRequest(String request) {
        this.request = request == null ? null : request.trim();
    }

    /**
     * 异常信息
     * @return emsg 异常信息
     */
    public String getEmsg() {
        return emsg;
    }

    /**
     * 异常信息
     * @param emsg 异常信息
     */
    public void setEmsg(String emsg) {
        this.emsg = emsg == null ? null : emsg.trim();
    }

    /**
     * 异常堆栈信息
     * @return stackmsg 异常堆栈信息
     */
    public String getStackmsg() {
        return stackmsg;
    }

    /**
     * 异常堆栈信息
     * @param stackmsg 异常堆栈信息
     */
    public void setStackmsg(String stackmsg) {
        this.stackmsg = stackmsg == null ? null : stackmsg.trim();
    }
}