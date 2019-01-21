package com.zyt.cxfq.service.impl;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.zyt.cxfq.common.interceptor.CheckLoginInterceptor;
import com.zyt.cxfq.util.BusinessException;

/**
 * Created by tpc on 2017/7/26.
 */
public class BaseServiceImpl {

    @Autowired
    protected HttpSession session;

    protected String getUserId(){
    	return "1";
        /*if(isLogin()){
            return session.getAttribute(CheckLoginInterceptor.USERID_KEY).toString();
        }else{
            throw new BusinessException("用户未登录");
        }*/
    }
    protected String getShiroUserId(){
    	SecurityUtils.getSubject().getSession().getAttribute("");
        if(isLogin()){
            return session.getAttribute(CheckLoginInterceptor.USERID_KEY).toString();
        }else{
            throw new BusinessException("用户未登录");
        }
    }

    protected String getSessionId() {
        return (String) session.getAttribute(CheckLoginInterceptor.SESSION_ID);
    }
    protected Boolean isLogin(){
        return session.getAttribute(CheckLoginInterceptor.USERID_KEY) != null;
    }

}
