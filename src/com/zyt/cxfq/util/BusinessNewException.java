package com.zyt.cxfq.util;

import java.util.HashMap;
import java.util.Map;

public class BusinessNewException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6971716908203238516L;

	/**
	 * 自定义属性
	 */
	private Map<String, Object> resultMap = new HashMap<String, Object>();
	
	private String[] dynamicParam = null;
	
	public BusinessNewException(String message) {
		super(message);
	}
	
	public BusinessNewException(Throwable cause) {
		super(cause);
	}
	
	public BusinessNewException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public BusinessNewException(String message, Map<String, Object> resultMap) {
		super(message);
		this.resultMap = resultMap;
	}
	
	public BusinessNewException(String message, Map<String, Object> resultMap, Throwable cause) {
		super(message, cause);
		this.resultMap = resultMap;
	}

	public Map<String, Object> getResultMap() {
		return resultMap;
	}

    
    /**
    * @param dynamicParam
    */
    	
    public BusinessNewException(String message,String... dynamicParam) {
        super(message);
        this.dynamicParam = dynamicParam;
    }

    public String[] getDynamicParam() {
        return dynamicParam;
    }
	
}
