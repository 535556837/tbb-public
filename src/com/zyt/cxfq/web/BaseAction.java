package com.zyt.cxfq.web;

import com.zyt.cxfq.common.interceptor.CheckLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * controller基类,所有action都要继承此类
 * Created by tpc on 2017/7/20.
 */
public abstract class BaseAction {

    @Autowired
    private HttpSession session;

    @Autowired
    HttpServletRequest request;

    public HttpSession getSession() {
        return session;
    }

    public String getUserId() {
        return session.getAttribute(CheckLoginInterceptor.USERID_KEY) == null?"":session.getAttribute(CheckLoginInterceptor.USERID_KEY).toString();
    }

    List<Map<String,Object>> getDBData(String interfaceName,Map args){
    	
    	return null;
    }
}
