package com.zyt.cxfq.common.interceptor;


import com.zyt.cxfq.mapper.DExceptionRecordMapper;
import com.zyt.cxfq.model.DExceptionRecordWithBLOBs;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by tpc on 2017/10/26.
 */
public class MyExceptionHandler implements HandlerExceptionResolver {

	@Autowired
	private DExceptionRecordMapper exceptionrecordMapper;
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
  		String userId = (String)request.getSession().getAttribute(CheckLoginInterceptor.USERID_KEY);
		request.getRequestURL().toString();
		
		DExceptionRecordWithBLOBs ep=new DExceptionRecordWithBLOBs();
		ep.setBmemberid(userId);
		ep.setRequesturl(request.getRequestURL().toString());
		ep.setClassname(ex.getClass().getName());
		ep.setIpaddr(getIpAddress(request));
		ep.setResource(1);
		ep.setEmsg(ex.getMessage());
		ep.setRequest(showParams(request));
		ep.setStackmsg(ExceptionUtils.getFullStackTrace(ex));
		exceptionrecordMapper.insert(ep);
        return null;
    }
	public static String getIpAddress(HttpServletRequest request) { 
	    String ip = request.getHeader("x-forwarded-for"); 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("WL-Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("HTTP_CLIENT_IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getRemoteAddr(); 
	    } 
	    return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip; 
	  } 
	private String showParams(HttpServletRequest request) {
        Map map = new HashMap();
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();

            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() != 0) {
                    map.put(paramName, paramValue);
                }
            }
        }

        Set<Map.Entry<String, String>> set = map.entrySet();
        String str="";
        for (Map.Entry entry : set) {
            str+=entry.getKey() + ":" + entry.getValue()+",";
        }
       return str;
    }
}
