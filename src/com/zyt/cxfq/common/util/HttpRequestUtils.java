package com.zyt.cxfq.common.util;

import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLDecoder;

public class HttpRequestUtils {
	private static Logger logger = LoggerFactory
			.getLogger(HttpRequestUtils.class); // 日志记录

	/**
	 * httpPost
	 * 
	 * @param url
	 *            路径
	 * @param jsonParam
	 *            参数
	 * @return
	 */
	public static JSONObject httpPost(String url, String jsonParam) {
		return httpPost(url, jsonParam, false);
	}

	/**
	 * post请求
	 * 
	 * @param url
	 *            url地址
	 * @param jsonParam
	 *            参数
	 * @param noNeedResponse
	 *            不需要返回结果
	 * @return
	 */
	public static JSONObject httpPost(String url, String jsonParam,
			boolean noNeedResponse) {
		// post请求返回结果
		CloseableHttpClient  httpClient =  HttpClients.createDefault();
		JSONObject jsonResult = null;
		HttpPost method = new HttpPost(url);
		try {
			if (null != jsonParam) {
				// 解决中文乱码问题
				StringEntity entity = new StringEntity(jsonParam,
						"utf-8");
				entity.setContentEncoding("UTF-8");
				entity.setContentType("application/json");
				method.setEntity(entity);
			}
			CloseableHttpResponse result = httpClient.execute(method);
			url = URLDecoder.decode(url, "UTF-8");
			/** 请求发送成功，并得到响应 **/
			if (result.getStatusLine().getStatusCode() == 200) {
				String str = "";
				try {
					/** 读取服务器返回过来的json字符串数据 **/
					str = EntityUtils.toString(result.getEntity());
					if (noNeedResponse) {
						return null;
					}
					jsonResult = JSONObject.fromObject(str);
				} catch (Exception e) {
					logger.error("post请求提交失败:" + url, e);
				}
			}
		} catch (IOException e) {
			logger.error("post请求提交失败:" + url, e);
		}
		return jsonResult;
	}
	public static String httpPostxml(String url, String xmlParam
			 ) {
		// post请求返回结果
		CloseableHttpClient  httpClient =  HttpClients.createDefault();
		String jsonResult = null;
		HttpPost method = new HttpPost(url);
		try {
			if (null != xmlParam) {
				// 解决中文乱码问题
				StringEntity entity = new StringEntity(xmlParam,
						"utf-8");
				entity.setContentEncoding("UTF-8");
				entity.setContentType("application/xml");
				method.setEntity(entity);
			}
			CloseableHttpResponse result = httpClient.execute(method);
			url = URLDecoder.decode(url, "UTF-8");
			/** 请求发送成功，并得到响应 **/
			System.out.println(result.getStatusLine().getStatusCode());
			
			if (result.getStatusLine().getStatusCode() == 200) {
				String str = "";
				try {
					/** 读取服务器返回过来的json字符串数据 **/
					str = EntityUtils.toString(result.getEntity(),"utf-8");
					
					jsonResult = str;
				} catch (Exception e) {
					logger.error("post请求提交失败:" + url, e);
				}
			}
		} catch (IOException e) {
			logger.error("post请求提交失败:" + url, e);
		}
		return jsonResult;
	}
	/**
	 * 请求apicloud接口发送手机推送消息
	 * @param title 标题
	 * @param content 内容
	 * @param userIds 接收人,多个用逗号(,)隔开
	 * @return
	 * 此处调用apicloud接口,是官方文档有问题,传过去的参数应该是下面这样的
	 * {
        "title" : "消息标题",
        "content" : "消息内容",
        "type" : 1, //– 消息类型，1:消息 2:通知
        "platform" : 0, //0:全部平台，1：ios, 2：android
        "groupName" : "department", //推送组名，多个组用英文逗号隔开.默认:全部组。eg.group1,group2 .
       	"userIds" : "testId" //推送用户id, 多个用户用英文逗号分隔，eg. user1,user2。
        }

	 */
	public static JSONObject sendAPICloudMsg(String title,String content,String userIds) {
		//地址
		String url = "https://p.apicloud.com/api/push/message";
		//头
		String appId = "A6921489786910";
		String appKey = "8F4B0575-3361-F23D-9013-3D43BFC7957F";
		long millis = System.currentTimeMillis();
		String appKeySha1 = DigestUtils.sha1Hex(appId+"UZ"+appKey+"UZ"+millis)+"."+millis;
		
		// post请求返回结果
		CloseableHttpClient  httpClient =  HttpClients.createDefault();
		JSONObject jsonResult = null;
		HttpPost method = new HttpPost(url);
		method.setHeader("X-APICloud-AppId", appId);
		method.setHeader("X-APICloud-AppKey", appKeySha1);
		//数据
		JSONObject values = new JSONObject();
		values.put("title", title);
		values.put("content", content);
		values.put("type", 2);
		values.put("platform", 0);
		//values.put("groupName", "");
		values.put("userIds", userIds);
		System.out.println("推送消息参数为:"+values);
		
		try {
			// 解决中文乱码问题
			StringEntity entity = new StringEntity(values.toString(),"utf-8");
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
			method.setEntity(entity);
			
			CloseableHttpResponse result = httpClient.execute(method);
			url = URLDecoder.decode(url, "UTF-8");
			/** 请求发送成功，并得到响应 **/
			if (result.getStatusLine().getStatusCode() == 200) {
				String str = "";
				try {
					/** 读取服务器返回过来的json字符串数据 **/
					str = EntityUtils.toString(result.getEntity());
					jsonResult = JSONObject.fromObject(str);
				} catch (Exception e) {
					logger.error("post请求提交失败:" + url, e);
				}
			}
		} catch (IOException e) {
			logger.error("post请求提交失败:" + url, e);
		}
		System.out.println("推送消息返回内容为:"+jsonResult);
		return jsonResult;
	}

	/**
	 * 发送get请求
	 * 
	 * @param url
	 *            路径
	 * @return
	 */
	public static String httpGet(String url) {
		// get请求返回结果
//		JSONObject jsonResult = null;
		String strResult=null;
		try {
			CloseableHttpClient  httpClient =  HttpClients.createDefault();
			// 发送get请求
			HttpGet request = new HttpGet(url);
			CloseableHttpResponse response = httpClient.execute(request);

			/** 请求发送成功，并得到响应 **/
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				/** 读取服务器返回过来的json字符串数据 **/
				strResult = EntityUtils.toString(response.getEntity());
				/** 把json字符串转换成json对象 **/
//				jsonResult = JSONObject.fromObject(strResult);
				url = URLDecoder.decode(url, "UTF-8");
			} else {
				logger.error("get请求提交失败:" + url);
			}
		} catch (IOException e) {
			logger.error("get请求提交失败:" + url, e);
		}
		return strResult;
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

	/*public static JSONObject httpGet(String url, String jsonParam) {
		// post请求返回结果
		CloseableHttpClient  httpClient =  HttpClients.createDefault();
		JSONObject jsonResult = null;
		HttpGet method = new HttpGet(url);
		try {
			if (null != jsonParam) {
				// 解决中文乱码问题
				StringEntity entity = new StringEntity(jsonParam,
						"utf-8");
				entity.setContentEncoding("UTF-8");
				entity.setContentType("application/json");
				method.setEntity(entity);
			}
			CloseableHttpResponse result = httpClient.execute(method);
			url = URLDecoder.decode(url, "UTF-8");
			*//** 请求发送成功，并得到响应 **//*
			if (result.getStatusLine().getStatusCode() == 200) {
				String str = "";
				try {
					*//** 读取服务器返回过来的json字符串数据 **//*
					str = EntityUtils.toString(result.getEntity());
					if (noNeedResponse) {
						return null;
					}
					jsonResult = JSONObject.fromObject(str);
				} catch (Exception e) {
					logger.error("post请求提交失败:" + url, e);
				}
			}
		} catch (IOException e) {
			logger.error("post请求提交失败:" + url, e);
		}
		return jsonResult;
	}*/
}
