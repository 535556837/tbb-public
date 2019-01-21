package com.zyt.cxfq.common.util;

import com.zyt.cxfq.util.BusinessException;

import java.io.InputStreamReader;
import java.util.Properties;
import java.util.ResourceBundle;


/**
 * @author lzp
 *
 */
public class ConfigManager {
	

	private static Object lock              = new Object();
	private static ConfigManager config     = null;
	private static ResourceBundle rb        = null;
	private static Properties pro        = null;
	private static final String CONFIG_FILE = "config/config";
	
	private ConfigManager() {
		rb = ResourceBundle.getBundle(CONFIG_FILE);
		pro = new Properties();
		try {
			pro.load(new InputStreamReader(ConfigManager.class.getClassLoader().getResourceAsStream("config/config.properties"),"utf-8"));
		} catch (Exception e) {
			throw new BusinessException("未找到config.properties配置文件");
		}
	}
	
	public static ConfigManager getInstance() {
		synchronized(lock) {
			if(null == config) {
				config = new ConfigManager();
			}
		}
		return (config);
	}
	
	public String getValue(String key) {
		return (pro.getProperty(key));
	}
	/*
	public static void main(String[] args) {
		System.out.println(ConfigManager.getInstance().getValue("delploy_network"));
	}
	*/
}

