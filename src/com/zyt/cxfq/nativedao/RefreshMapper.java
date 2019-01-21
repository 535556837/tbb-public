package com.zyt.cxfq.nativedao;

import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.session.Configuration;
import org.springframework.core.NestedIOException;  
public class RefreshMapper {

	//private static Configuration configuration;    
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 String template =  XmlPaser.class.getResource("CommonDao.xml").getFile().substring(1);
		//refresh(template);
	}
	public static void refresh(Configuration configuration,String filePath) throws Exception {  
		  
        // 本次刷新时间  
        Long refrehTime = System.currentTimeMillis();  
        File f=new File(filePath);
        InputStream inputStream = new FileInputStream(f);  
        
        String resource = f.getAbsolutePath();  
       
              
            // 清理原有资源，更新为自己的StrictMap方便，增量重新加载  
            String[] mapFieldNames = new String[]{  
                "mappedStatements", "caches",  
                "resultMaps", "parameterMaps",  
                "keyGenerators", "sqlFragments"  
            };  
            for (String fieldName : mapFieldNames){  
                Field field = configuration.getClass().getDeclaredField(fieldName);  
                field.setAccessible(true);  
                Map map = ((Map)field.get(configuration));  
                if (!(map instanceof StrictMap)){  
                    Map newMap = new StrictMap(upperCase(fieldName) + "collection");  
                    for (Object key : map.keySet()){  
                        try {  
                            newMap.put(key, map.get(key));  
                        }catch(IllegalArgumentException ex){  
                            newMap.put(key, ex.getMessage());  
                        }  
                    }  
                    field.set(configuration, newMap);  
                }  
            }  
              
            // 清理已加载的资源标识，方便让它重新加载。  
            Field loadedResourcesField = configuration.getClass().getDeclaredField("loadedResources");  
            loadedResourcesField.setAccessible(true);  
            Set loadedResourcesSet = ((Set)loadedResourcesField.get(configuration));  
            loadedResourcesSet.remove(resource);  
              
            //重新编译加载资源文件。  
            XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(inputStream, configuration,   
                    resource, configuration.getSqlFragments());  
            xmlMapperBuilder.parse();  
       
        System.out.println("Refresh file: " +filePath);  
/*        if (log.isDebugEnabled()) {  
            log.debug("Refresh file: " + fileList.get(i).getAbsolutePath());  
            log.debug("Refresh filename: " + fileList.get(i).getName());  
        }  */
 

    }  
	public static String upperCase(String str) {  
	    return str.substring(0, 1).toUpperCase() + str.substring(1);  
	}  
/*    public static boolean isRefresh() {  
        return refresh;  
    }  */
	/** 
     * 重写 org.apache.ibatis.session.Configuration.StrictMap 类 
     * 来自 MyBatis3.4.0版本，修改 put 方法，允许反复 put更新。 
     */  
    public static class StrictMap<V> extends HashMap<String, V> {  
  
        private static final long serialVersionUID = -4950446264854982944L;  
        private String name;  
  
        public StrictMap(String name, int initialCapacity, float loadFactor) {  
            super(initialCapacity, loadFactor);  
            this.name = name;  
        }  
  
        public StrictMap(String name, int initialCapacity) {  
            super(initialCapacity);  
            this.name = name;  
        }  
  
        public StrictMap(String name) {  
            super();  
            this.name = name;  
        }  
  
        public StrictMap(String name, Map<String, ? extends V> m) {  
            super(m);  
            this.name = name;  
        }  
  
        @SuppressWarnings("unchecked")  
        @Override
        public V put(String key, V value) {  
            // ThinkGem 如果现在状态为刷新，则刷新(先删除后添加)  
          //  if (RefreshMapper.isRefresh()) {  
                remove(key);  
               // RefreshMapper.log.debug("refresh key:" + key.substring(key.lastIndexOf(".") + 1));  
          //  }  
            // ThinkGem end  
            if (containsKey(key)) {  
                throw new IllegalArgumentException(name + " already contains value for " + key);  
            }  
            if (key.contains(".")) {  
                final String shortKey = getShortName(key);  
                if (super.get(shortKey) == null) {  
                    super.put(shortKey, value);  
                } else {  
                    super.put(shortKey, (V) new Ambiguity(shortKey));  
                }  
            }  
            return super.put(key, value);  
        }  
        @Override
        public V get(Object key) {  
            V value = super.get(key);  
            if (value == null) {  
                throw new IllegalArgumentException(name + " does not contain value for " + key);  
            }  
            if (value instanceof Ambiguity) {  
                throw new IllegalArgumentException(((Ambiguity) value).getSubject() + " is ambiguous in " + name  
                        + " (try using the full name including the namespace, or rename one of the entries)");  
            }  
            return value;  
        }  
  
        private String getShortName(String key) {  
            final String[] keyparts = key.split("\\.");  
            return keyparts[keyparts.length - 1];  
        }  
  
        protected static class Ambiguity {  
            private String subject;  
  
            public Ambiguity(String subject) {  
                this.subject = subject;  
            }  
  
            public String getSubject() {  
                return subject;  
            }  
        }  
    }  

}
