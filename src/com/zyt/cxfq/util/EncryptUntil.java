package com.zyt.cxfq.util;


import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 密码加密静态工具类，MD5去符号加密
 * @author Created by Ivan on 2017/7/20.
 */
public class EncryptUntil {
    /**
     *
     * @param str
     * @return ret 加密后的字符串
     * ------------------------------------
     * 用于密码加密处理
     */
    public static String md5(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] output = md.digest(str.getBytes());
//			return new String(output);
            String ret = Base64.encode(output).replaceAll("\\-|\\+|\\*|\\/|\\=","");
            return ret;
        } catch (NoSuchAlgorithmException e) {
            throw new BusinessException("加密失败", e);
        }
    }

    public static void main(String[] args) {
        System.out.println( md5("777777"));
    }
}
