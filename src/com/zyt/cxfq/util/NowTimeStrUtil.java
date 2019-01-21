package com.zyt.cxfq.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NowTimeStrUtil {
	
	public static String getNowStr() {
		new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String now =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
		return now;
	}
}
