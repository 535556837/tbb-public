package com.zyt.cxfq.common.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.zyt.cxfq.util.BusinessException;

import net.sf.json.JSONObject;
 
/**
*二手车价值评估调用示例代码 － 聚合数据
*在线接口文档：http://www.juhe.cn/docs/71
**/
 
public class SecondHardCarMoney {
    public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
 
    //配置您申请的KEY
    public static final String APPKEY ="3298da6567495372b3b6ed8d8799ce86";
 
    //1.城市列表
    public static void getRequest1(){
        String result =null;
        String url ="http://op.juhe.cn/che300/query";//请求接口地址
        Map params = new HashMap();//请求参数
            params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
            params.put("dtype","");//返回数据的格式,xml或json，默认json
            params.put("method","");//固定值：getAllCity
 
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
 
    //2.品牌列表
    public static void getRequest2(){
        String result =null;
        String url ="http://op.juhe.cn/che300/query";//请求接口地址
        Map params = new HashMap();//请求参数
            params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
            params.put("dtype","");//返回数据的格式,xml或json，默认json
            params.put("method","");//固定值：getCarBrandList
 
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
 
    //3.车系列表
    public static JSONObject getseries(String brand){
        String result =null;
        String url ="http://v.juhe.cn/usedcar/series";//请求接口地址
        Map params = new HashMap();//请求参数
            params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
            params.put("brand",brand);//品牌标识，可以通过车三百品牌数据接口拿回所有的品牌信息，从而提取品牌标识。
           
        try {
            result =net(url, params, "GET");
            JSONObject object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                System.out.println(object.get("result"));
                return object;
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
              throw  new BusinessException(object.getString("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
 
    //4.车型列表
    public static JSONObject getCarType(String series){
        String result =null;
        String url ="http://v.juhe.cn/usedcar/car";//请求接口地址
        Map params = new HashMap();//请求参数
            params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
             params.put("series",series);//车系标识，可以通过车三百车系数据接口拿回车系信息，从而提前车系标识。
 
        try {
            result =net(url, params, "GET");
            JSONObject object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                System.out.println(object.get("result"));
                return object;
            }else{
            	 throw  new BusinessException(object.getString("reason"));
                //System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
 
    //7.精确估值
    public static JSONObject getCarPrice(String carstatus,String purpose,String city,
    		String car,String useddate,String useddateMonth,String mileage,String price,String province){
        String result =null;
        String url ="http://v.juhe.cn/usedcar/assess";//请求接口地址
        Map params = new HashMap();//请求参数
            params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
            params.put("carstatus",carstatus);//车型标识，可以通过车三百车型列表数据接口拿回车三百所支持的所有车型相关信息，也可以申请合作成功之后提供网站自己的车型信息进行两者之间的映射。
            params.put("purpose",purpose);//待估车辆的上牌时间（格式：yyyy-MM）。
            params.put("city",city);//待估车辆的公里数，单位万公里。
            params.put("car",car);//城市标识，可以通过车三百城市列表数据接口拿回车三百所支持的所有城市相关信息，也可以申请合作成功之后提供网站自己的城市信息进行两者之间的映射。
            params.put("useddate",useddate);//待估车辆的标题信息，可选参数。
            params.put("useddateMonth",useddateMonth);//待估车辆在贵网站上面的卖价（不是指导价，是用户标的价格），可选参数。
            params.put("mileage",mileage);//城市标识，可以通过车三百城市列表数据接口拿回车三百所支持的所有城市相关信息，也可以申请合作成功之后提供网站自己的城市信息进行两者之间的映射。
            params.put("price",price);//待估车辆的标题信息，可选参数。
            params.put("province",province);//待估车辆在贵网站上面的卖价（不是指导价，是用户标的价格），可选参数。
 
        try {
            result =net(url, params, "GET");
            JSONObject object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                System.out.println(object.get("result"));
                return object;
            }else{
            	 throw  new BusinessException(object.getString("reason"));
                //System.out.println(object.get("error_code")+":"+object.get("reason"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
 

 
 
 
    public static void main(String[] args) {
 
    	getseries("2000419");
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
                try {
                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                        out.writeBytes(urlencode(params));
                } catch (Exception e) {
                    // TODO: handle exception
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
    public static String urlencode(Map<String,Object>data) {
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
