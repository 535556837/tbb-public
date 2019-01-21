package com.zyt.cxfq.common.util;


import net.sf.json.JSONObject;
import org.apache.commons.io.IOUtils;
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

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
/**
*验证码识别调用示例代码 － 聚合数据
*在线接口文档：http://www.juhe.cn/docs/60
**/
 
public class yzmsb {
    public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
 
    //配置您申请的KEY
    public static final String APPKEY ="8bff62ae10db757ee0db122784379ae4";
 
    public static void main(String[] args) throws Exception {
     /* byte[] img = HttpUtils.getImg("http://m.ecpic.com.cn/automobile/sales/mobileAuto/generateCaptcha?1509610870901");
        File file = new File("yzmsb/"+System.currentTimeMillis() + ".jpg");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(img);
        fos.close();*/
        File file=new File("c:\\tessdata\\3.jpg");
        String out=getYzm(file);
        System.out.println(out);
    	
    }

    /**
     * {"reason":"成功的返回","result":"skxn","error_code":0}
     * @param file
     * @return
     * @throws Exception
     */
    public static String getYzm(File file) throws Exception{
        String type="1004";
        String post = post(type, file);
        JSONObject respObj = JSONObject.fromObject(post);
        if (respObj.getInt("error_code") == 0) {
            return respObj.getString("result");
        }
        return null;
    }
    //1.识别验证码
  public static String post(String type,File file) throws Exception{
      CloseableHttpClient httpClient = HttpClients.createDefault();
      CloseableHttpResponse response = null;
      String result =null;
      try {
          RequestConfig config = RequestConfig.custom().setConnectTimeout(30000).setSocketTimeout(30000).build();
          HttpPost httppost = new HttpPost("http://op.juhe.cn/vercode/index");
          StringBody keyBody = new StringBody(APPKEY , ContentType.TEXT_PLAIN);
          StringBody typeBody = new StringBody(type, ContentType.TEXT_PLAIN);
          HttpEntity reqEntity = MultipartEntityBuilder.create()
                  .addBinaryBody("image",file,ContentType.create("image/jpeg"),file.getName())
//                    .addBinaryBody("image", img, ContentType.create("image/jpeg"), "tupianyanzhengma")
                  .addPart("key", keyBody)
                  .addPart("codeType", typeBody).build();
          httppost.setEntity(reqEntity);
          httppost.setConfig(config);
          response = httpClient.execute(httppost);
          HttpEntity resEntity = response.getEntity();
          if (resEntity != null) {
              result =IOUtils.toString(resEntity.getContent(), "UTF-8");
          }
          EntityUtils.consume(resEntity);
      }catch(Exception e){
          e.printStackTrace();
      }
      finally {
          response.close();
          httpClient.close();
      }
      return result;
   }
 
    //2.查询验证码类型代码
    public static void getRequest2(){
        String result =null;
        String url ="http://op.juhe.cn/vercode/codeType";//请求接口地址
        Map params = new HashMap();//请求参数
            params.put("key",APPKEY);//您申请到的APPKEY
            params.put("dtype","");//返回的数据的格式，json或xml，默认为json
 
        try {
            result =net(url, params, "GET");
            JSONObject object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                System.out.println(object.get("result"));
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
 
 

 
    /**
     *
     * @param strUrl 请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return  网络请求字符串
     * @throws Exception
     */
    public static String net(String strUrl, Map params,String method) throws Exception {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuffer sb = new StringBuffer();
            if(method==null || method.equals("GET")){
                strUrl = strUrl+"?"+urlencode(params);
            }
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            if(method==null || method.equals("GET")){
                conn.setRequestMethod("GET");
            }else{
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
            }
            conn.setRequestProperty("User-agent", userAgent);
            conn.setUseCaches(false);
            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
            conn.setReadTimeout(DEF_READ_TIMEOUT);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if (params!= null && method.equals("POST")) {
                try (DataOutputStream out = new DataOutputStream(conn.getOutputStream())) {
                    out.writeBytes(urlencode(params));
                }
            }
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }
 
    //将map型转为请求参数型
    public static String urlencode(Map<String,String> data) {
        StringBuilder sb = new StringBuilder();
       
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
     
}