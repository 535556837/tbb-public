package com.zyt.cxfq.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class MakeId {
	/**
	 * 生成ID
	 * @return
	 */
	public static String getId() {
		String id = new SimpleDateFormat("yyMMdd").format(new Date())+UUID.randomUUID().toString().replaceAll("-", "");
		return id;
	}
}
