package com.zyt.cxfq.common.util;

import com.zyt.cxfq.util.BusinessException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by tpc on 2017/7/26.
 */
public class Arith {

    /**
     * 提供精确加法计算的add方法
     * @param value1 被加数
     * @param value2 加数
     * @return 两个参数的和
     */
    public static double add(double value1,double value2){
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1).toString());
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2).toString());
        return b1.add(b2).doubleValue();
    }
    /**
     * 提供精确加法计算的add方法
     * @param value1 被加数
     * @param value2 加数
     * @return 两个参数的和
     */
    public static BigDecimal addToBig(double value1,double value2){
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1).toString());
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2).toString());
        return b1.add(b2);
    }
    /**
     *
     * 提供精确减法运算的sub方法
     * @param value1 被减数
     * @param value2 减数
     * @return 两个参数的差
     */
    public static double sub(double value1,double value2){
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1).toString());
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2).toString());
        return b1.subtract(b2).doubleValue();
    }
    /**
     * 提供精确乘法运算的mul方法
     * @param value1 被乘数
     * @param value2 乘数
     * @return 两个参数的积 double类型
     */
    public static double mul(double value1,double value2){
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1).toString());
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2).toString());
        return b1.multiply(b2).doubleValue();
    }
    /**
     * 提供精确乘法运算的mul方法
     * @param value1 被乘数
     * @param value2 乘数
     * @return 两个参数的积 BigDecimal类型
     */
    public static BigDecimal mulToBig(double value1,double value2){
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1).toString());
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2).toString());
        return b1.multiply(b2);
    }
    /**
     * 提供精确的除法运算方法div,默认四舍五入
     * @param value1 被除数
     * @param value2 除数
     * @param scale 精确范围
     * @return 两个参数的商
     */
    public static double div(double value1,double value2,int scale){
        //如果精确范围小于0，抛出异常信息
        if(scale<0){
            throw new BusinessException("精确度不能小于0");
        }
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1).toString());
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2).toString());
        return b1.divide(b2, scale, RoundingMode.UP).doubleValue();
    }

    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.MONTH,0);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()));
    }

}
