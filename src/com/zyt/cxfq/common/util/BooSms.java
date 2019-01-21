package com.zyt.cxfq.common.util;



import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class BooSms {

	/*public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File file=new File("D://aaaaaa2.jpg");
            post("17380489861",SmsService.getRandom());
	}*/
	
	// 此方法是POST请求上传的参数中包含本地图片信息File类型
    public static String post(String phone, String code) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String result = null;
        // HttpClient请求的相关设置，可以不用配置，用默认的参数，这里设置连接和超时时长(毫秒)
        RequestConfig config = RequestConfig.custom().setConnectTimeout(30000).setSocketTimeout(30000).build();
        try {
            HttpPost httppost = new HttpPost(ConfigManager.getInstance().getValue("dxyzmServerUrl"));
            // StringBody封装String类型的参数
           /* StringBody keyBody = new StringBody("54c7300982b45ce5a56fc5f3b9452f65", ContentType.TEXT_PLAIN);
            StringBody typeBody = new StringBody(type, ContentType.TEXT_PLAIN);*/
            
            // addPart将参数传入，并指定参数名称
            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    .addPart("apikey", new StringBody("92f5b8359c8428bbfb36519fab9576d4",ContentType.TEXT_PLAIN))
                    .addPart("mobile", new StringBody(phone,ContentType.TEXT_PLAIN))
                    .addPart("tpl_id", new StringBody("2054242",ContentType.TEXT_PLAIN))
                    .addPart("tpl_value", new StringBody(URLEncoder.encode("#code#="+code),ContentType.TEXT_PLAIN))
                    
                    .build();
            httppost.setEntity(reqEntity);
            httppost.setConfig(config);
            // 执行网络请求并返回结果
            response = httpClient.execute(httppost);
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                result = ConvertStreamToString(resEntity.getContent(), "UTF-8");
            }
            EntityUtils.consume(resEntity);
        } finally {
            response.close();
            httpClient.close();
        }
        // 得到的是JSON类型的数据需要第三方解析JSON的jar包来解析
         System.out.println(result);
        return result;
    }
 
    // 此方法是把传进的字节流转化为相应的字符串并返回，此方法一般在网络请求中用到
    public static String ConvertStreamToString(InputStream is, String charset)
            throws Exception {
        StringBuilder sb = new StringBuilder();
        try (InputStreamReader inputStreamReader = new InputStreamReader(is,charset)) {
            try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\r\n");
                }
            }
        }
        return sb.toString();
    }
    //调用谷歌的二维码生成接口
    public static String QRfromGoogle(String chl) throws Exception {  
        int widhtHeight = 300;  
        String EC_level = "L";  
        int margin = 0;  
        chl = UrlEncode(chl);  
        String QRfromGoogle = "http://chart.apis.google.com/chart?chs=" + widhtHeight + "x" + widhtHeight  
                + "&cht=qr&chld=" + EC_level + "|" + margin + "&chl=" + chl;  
      
        return QRfromGoogle;  
    } 
 // 特殊字符处理  
    public static String UrlEncode(String src)  throws UnsupportedEncodingException {  
        return URLEncoder.encode(src, "UTF-8").replace("+", "%20");  
    }

}
