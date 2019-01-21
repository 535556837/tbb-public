package com.zyt.cxfq.common.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

import com.zyt.cxfq.util.EncryptUntil;

public class CommonUtil {

    /*public static void main(String[] args) throws Exception  {
		String s =post("170815dac68c48819111e78f4700ff88f2be10","13333333333","upload/headpic/avatar.png");
		System.out.println(s);
   	}*/
 // Bean --> Map 1: 利用Introspector和PropertyDescriptor 将Bean --> Map
 	public static Map<String, Object> transBean2Map(Object obj) {  
 		  
         if(obj == null){  
             return null;  
         }          
         Map<String, Object> map = new HashMap<String, Object>();  
         try {  
             BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
             PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
             for (PropertyDescriptor property : propertyDescriptors) {  
                 String key = property.getName();  
   
                 // 过滤class属性  
                 if (!key.equals("class")) {  
                     // 得到property对应的getter方法  
                     Method getter = property.getReadMethod();  
                     Object value = getter.invoke(obj);  
   
                     map.put(key, value);  
                 }  
   
             }  
         } catch (Exception e) {  
             System.out.println("transBean2Map Error " + e);  
         }  
   
         return map;  
   
     }  

}
