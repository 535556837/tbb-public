package com.zyt.cxfq.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 添加Map公共类，对BEAN和MAP进行数据对接复制
 * @author admin
 *
 */
public class MapUtils {

	
	//JavaBean转换为Map  
	public static Map<String,Object> bean2map(Object bean) throws Exception{  
	    Map<String,Object> map = new HashMap<>();  
	    //获取指定类（Person）的BeanInfo 对象  
	    BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());  
	    //获取所有的属性描述器  
	    PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();  
	    for(PropertyDescriptor pd:pds){  
	        String key = pd.getName();  
	        Method getter = pd.getReadMethod();  
	        Object value = getter.invoke(bean);  
	        map.put(key, value);  
	    }  
	    return map;  
	}  
	
	//Map转换为JavaBean  
	public static <T> T map2bean(Map<String,Object> map,Class<T> clz) throws Exception{  
	    //创建JavaBean对象  
	    T obj = clz.newInstance();  
	    //获取指定类的BeanInfo对象  
	    BeanInfo beanInfo = Introspector.getBeanInfo(clz, Object.class);  
	    //获取所有的属性描述器  
	    PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();  
	    for(PropertyDescriptor pd:pds){  
	        Object value = map.get(pd.getName());  
	        Method setter = pd.getWriteMethod();  
	        setter.invoke(obj, value);  
	    }  
	      
	    return  obj;  
	} 
	
	/**
	 * JAVA bean 转MAP
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> objectToMap(Object obj) throws Exception {    
        if(obj == null) {  
            return null; }     
  
        Map<String, Object> map = new HashMap<String, Object>();   
  
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());    
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();    
        for (PropertyDescriptor property : propertyDescriptors) {    
            String key = property.getName();    
            if (key.compareToIgnoreCase("class") == 0) {   
                continue;  
            }  
            Method getter = property.getReadMethod();  
            Object value = getter!=null ? getter.invoke(obj) : null;  
            map.put(key, value);  
        }    
  
        return map;  
    } 
	
	
	
	
}
