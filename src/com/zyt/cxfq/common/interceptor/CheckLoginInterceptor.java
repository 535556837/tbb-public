package com.zyt.cxfq.common.interceptor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zyt.cxfq.mapper.DEmployeeMapper;
import com.zyt.cxfq.model.DEmployee;
import com.zyt.cxfq.service.impl.EmployeeServiceImpl;


public class CheckLoginInterceptor implements HandlerInterceptor{

	@Autowired
	private DEmployeeMapper dEMapper;
	@Autowired
	private EmployeeServiceImpl  dEService;
	
	private List<String> mustLoginQuest = Arrays.asList(new String[]{
		"/BCarinformationService/queryViolation"
	});

	public static final String USERID_KEY = "uId";
	public static final String USER_CODE = "userCode";
	public static final String SESSION_ID = "sessionId";

	private static final String LOGIN_URL="../index.html";
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2, ModelAndView arg3) throws Exception {
		response.setHeader("Cache-Control","no-cache");
		//syslogManager.insert(request);//记录日志
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		System.out.println("ContentType:"+request.getContentType());
		System.out.println("Origin:"+request.getHeader("Origin"));
		System.out.println("sessionid:"+request.getSession().getId());
		System.out.println("guid:"+request.getParameter("guid"));
		System.out.println("userid:"+request.getParameter("userid"));
		System.out.println("openid:"+request.getParameter("openid"));
		String origin = request.getHeader("Origin");
		//设置允许跨域
				if(origin != null){
					response.setHeader("Access-Control-Allow-Origin", origin);
				}else{
					response.setHeader("Access-Control-Allow-Origin", "*");
				}
				//设置允许跨域传送cookie
				response.setHeader("Access-Control-Allow-Credentials","true");
				Object sessionId = request.getParameter("sessionId");
				if (sessionId != null && !StringUtils.isEmpty(sessionId.toString())) {
					request.getSession().setAttribute(SESSION_ID,sessionId);
				}
				DEmployee empl = null;
				//如果请求没有userid并且不是获取资源的请求
				String userid = request.getParameter("uId");
				if (StringUtils.isEmpty(userid) && request.getHeader("Origin") != null) {
//					request.getSession().removeAttribute(USERID_KEY);
				}else {
					if ((empl = checkUserid(userid)) != null) {
						dEService.setUserSession(empl);
					} else if(!StringUtils.isEmpty(userid)){
						return false;
					}
				}
				String requesttype="url";
				if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){ //如果是ajax请求响应头会有x-requested-with  			
					requesttype="ajax";

		        }
				String userId = (String)request.getSession().getAttribute(USERID_KEY);
				//某些请求如果未登录就不让通过
				String questUrl = request.getServletPath();
				if (mustLoginQuest.contains(questUrl) && StringUtils.isEmpty(userId)) {
					return false;
				}
//		        if(request.getParameter("guid") == null ){
//					if( request.getSession().getAttribute(USERID_KEY)==null){
//						return false;
//					}
//				}
				requesttype +=":mobile="+request.getParameter("guid");
				System.out.println(request.getRequestURL()+";userid="+userId+";reqtype="+requesttype);
				return true;
		
	}

	private DEmployee checkUserid(String userid){
		return  dEMapper.selectByPrimaryKey(userid);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
