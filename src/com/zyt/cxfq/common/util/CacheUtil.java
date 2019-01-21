package com.zyt.cxfq.common.util;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by tpc on 2017/10/13.
 */
public class CacheUtil {

    public static Map<String, Map<String, Object>> cacheData = new ConcurrentHashMap<>();

    private static Long LIVE = 1000L*60*60*2;//2个小时

    private static String START_TIME_KEY = "CacheUtil_start_time_key";
    private static String LIVE_KEY = "CacheUtil_live_key";

    public static void setData(String id, String key,Object data) {
        if (StringUtils.isEmpty(id)) {
            return;
        }
        Map<String, Object> stringObjectMap = cacheData.get(id);
        if (stringObjectMap == null) {
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put(key,data);
            cacheData.put(id, dataMap);
            stringObjectMap = dataMap;
            stringObjectMap.put(LIVE_KEY, LIVE);
        } else {
            stringObjectMap.put(key, data);
        }
        stringObjectMap.put(START_TIME_KEY, System.currentTimeMillis());
    }

    public static Map<String,Object> getData(String id) {
        if (StringUtils.isEmpty(id)) {
            return null;
        }
        Map<String, Object> stringObjectMap = cacheData.get(id);
        return stringObjectMap;
    }

    public void checkTask() {
        int size = cacheData.size();
        System.out.println("开始CacheUtil清理任务,清理前缓存大小:"+size);
        for (Map.Entry<String, Map<String, Object>> stringMapEntry : cacheData.entrySet()) {
            String key = stringMapEntry.getKey();
            Map<String,Object> value = stringMapEntry.getValue();
            Long live = (Long) value.get(LIVE_KEY);
            Long startTime = (Long) value.get(START_TIME_KEY);
            Long now = System.currentTimeMillis();
            if ((now - startTime) > live) {
                cacheData.remove(key);
            }
        }
        size = cacheData.size();
        System.out.println("完成CacheUtil清理任务,清理后缓存大小:"+size);
    }

}
