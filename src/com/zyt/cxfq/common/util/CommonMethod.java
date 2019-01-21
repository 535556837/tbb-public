/**
 * 
 */
package com.zyt.cxfq.common.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.zyt.cxfq.util.EncryptUntil;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 明兴网络
 * 
 */
public class CommonMethod
{
    /**
     * JPush masterSecret
     */
    public final static String masterSecret = "25a4725b14e8d7e822f522d4";
    
    /**
     * JPush appKey
     */
    public final static String appKey = "f705050b57d3be290de96fa7";
    public final static String ORDERMACH="order\\s*by[\\w|\\W|\\s|\\S]*";
    public final static String U300="//r|//n|//u3000";
    public final static String BOL="^(//s)*$";
    public final static String EMPTY="";
    
    /**
     * 获取当前时间
     * 
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getDate()
    {
        String returnStr = null;
        returnStr = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new Date() );
        return returnStr;
    }
    
    /**
     * 获取当前时间戳yyyyMMddHHmmssSSS
     * 
     * @return
     */
    public static String getCurrentSystemDate()
    {
        String returnStr = null;
        returnStr = new SimpleDateFormat( "yyyyMMddHHmmssSSS" ).format( new Date() );
        return returnStr;
    }
    
    /**
     * 获取订单编号 JZG-yyyMMddHHmmssSSS
     * 
     * @return
     */
    public static String getOrderNo(){
    	return "JZG-"+getCurrentSystemDate();
    }
    
    /**
     * 获取当前时间数字yyMMdd（6位）的16进制字符串5位
     * 
     * @return
     */
    public static String getCurrentYMD()
    {
        String returnStr = null;
        returnStr = new SimpleDateFormat( "yyMMdd" ).format( new Date() );
        return Integer.toHexString( Integer.parseInt( returnStr ) );
    }
    
    /**
     * 获取当前时间
     * 
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static Date getTime()
    {
        String returnStr = null;
        returnStr = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( new Date() );
        // System.out.println(returnStr);
        try
        {
            return new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).parse( returnStr );
        }
        catch ( ParseException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * 获取当前时间
     * 
     * @return yyyy-MM-dd
     */
    public static String getCurrentDate()
    {
        String returnStr = null;
        returnStr = new SimpleDateFormat( "yyyy-MM-dd" ).format( new Date() );
        // System.out.println(returnStr);
        try
        {
            return returnStr;
        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * 获取当前月
     * 
     * @return yyyy-MM
     */
    public static String getCurrentMonth()
    {
        String returnStr = null;
        returnStr = new SimpleDateFormat( "yyyy-MM" ).format( new Date() );
        try
        {
            return returnStr;
        }
        catch ( Exception e )
        {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * 获取当前时间
     * 
     * @return yyyy-MM-dd HH:mm:ss
     */
    public final static Timestamp getTimeStamp()
    {
        Timestamp dateTime = new Timestamp( getTime().getTime() );// Timestamp类型,timeDate.getTime()返回一个long型
        return dateTime;
    }

    /**
     * 将时间转换为字段yyyy-MM-dd
     *
     * @param s
     * @return
     * @throws ParseException
     */
    public static Date stringToDate( String s )
    {
        try
        {
            if ( s == null )
            {    s = "";}
            return ! s.trim().equals( "" ) ? new SimpleDateFormat( "yyyy-MM-dd" ).parse( s ) : null;
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * method 将字符串类型的日期转换为一个timestamp（时间戳记java.sql.Timestamp）
     *
     * @param dateString
     *            需要转换为timestamp的字符串 yyyy-MM-dd kk:mm:ss.SSS
     * @return dataTime timestamp
     */
    public final static Timestamp string2Time( String dateString )
    {
        try
        {
            DateFormat dateFormat;
            dateFormat = new SimpleDateFormat( "yyyy-MM-dd kk:mm:ss.SSS", Locale.ENGLISH );// 设定格式
            // dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss",
            // Locale.ENGLISH);
            // dateFormat.setLenient(false);
            Date timeDate = ( Date ) dateFormat.parse( dateString );// util类型
            Timestamp dateTime = new Timestamp( timeDate.getTime() );// Timestamp类型,timeDate.getTime()返回一个long型
            return dateTime;
        }
        catch ( Exception e )
        {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    /**
     * method 将字符串类型的日期转换为一个timestamp（时间戳记java.sql.Timestamp）
     *
     * @param dateString
     *            需要转换为timestamp的字符串yyyy-MM-dd kk:mm:ss
     * @return dataTime timestamp
     */
    public final static Timestamp string2Time1( String dateString )
    {
        try
        {
            // logger.debug("日期0: "+dateString);
            // DateFormat dateFormat;
            // dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss", Locale.ENGLISH);// 设定格式
            if ( ! dateString.contains( ":" ) )
            {
                dateString += " 00:00:00";
            }
            Date dt = new Date();
            String[] parts = dateString.replace( " ", "-" ).replace( ":", "-" ).replace( ".", "-" ).split( "-" );

            if ( parts.length >= 3 )
            {
                int years = Integer.parseInt( parts[0] );
                int months = Integer.parseInt( parts[1] ) - 1;
                int days = Integer.parseInt( parts[2] );
                int hours = Integer.parseInt( parts[3] );
                int minutes = Integer.parseInt( parts[4] );
                int seconds = Integer.parseInt( parts[5] );

                GregorianCalendar gc = new GregorianCalendar( years, months, days, hours, minutes, seconds );

                dt = gc.getTime();
            }
            // return dt;
            // dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss",
            // Locale.ENGLISH);
            // dateFormat.setLenient(false);
            // java.util.Date timeDate = dateFormat.parse(dateString);// util类型
            // java.sql.Timestamp dateTime = new java.sql.Timestamp(timeDate.getTime());// Timestamp类型,timeDate.getTime()返回一个long型
            Timestamp dateTime = new Timestamp( dt.getTime() );// Timestamp类型,timeDate.getTime()返回一个long型
            return dateTime;
        }
        catch ( Exception e )
        {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    /**
     * yyyy-MM-dd 00:00:00
     *
     * @param submitTimeFrom
     * @return
     */
    public static Timestamp toStartTime( Timestamp submitTimeFrom )
    {
        submitTimeFrom.setHours( 00 );
        submitTimeFrom.setMinutes( 00 );
        submitTimeFrom.setSeconds( 00 );
        return submitTimeFrom;
    }

    /**
     * yyyy-MM-dd 23:59:59
     *
     * @param submitTimeFrom
     * @return
     */
    public static Timestamp toEndTime( Timestamp submitTimeFrom )
    {
        submitTimeFrom.setHours( 23 );
        submitTimeFrom.setMinutes( 59 );
        submitTimeFrom.setSeconds( 59 );
        return submitTimeFrom;
    }

    public static Date toEndDate(Date date){
	     Calendar   calendar   =   new   GregorianCalendar();
	     calendar.setTime(date);
	     calendar.add(Calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
	     return calendar.getTime();   //这个时间就是日期往后推一天的结果
	}

    /**
     * yyyy-MM-dd HH:mm:ss method 将字符串类型的日期转换为一个Date（java.sql.Date）
     *
     * @param s
     *            需要转换为Date的字符串
     * @return dataTime Date
     */
    public final static Date string2Date( String s )
    {
        try
        {
            if ( s == null )
            {  s = "";}
            return ! s.trim().equals( "" ) ? new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).parse( s ) : null;
        }
        catch ( Exception e )
        {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @param d
     *            yyyy-MM-dd
     * @return yyyy-MM-dd
     */
    public static String dateToString( Date d )
    {
        String result = null;
        if ( d != null )
        {
            SimpleDateFormat bartDateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
            result = bartDateFormat.format( d );
        }
        return result;
    }

    /**
     *
     * @param d
     *            yyyy-MM-dd HH:mm:ss
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String dateToString2( Date d )
    {
        String result = null;
        if ( d != null )
        {
            SimpleDateFormat bartDateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
            result = bartDateFormat.format( d );
        }
        return result;
    }

    /**
     *
     * @param t
     *            yyyy-MM-dd
     * @return yyyy-MM-dd
     */
    public static String timeToString( Timestamp t )
    {
        Date d = new Date( t.getTime() );
        Calendar cal = Calendar.getInstance();
        cal.setTime( d );
        String dStr = dateToString( cal.getTime() );
        return dStr;
    }

    /**
     *
     * @param t
     *            yyyy-MM-dd HH:mm:ss
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String timeToString2( Timestamp t )
    {
        Date d = new Date( t.getTime() );
        Calendar cal = Calendar.getInstance();
        cal.setTime( d );
        String dStr = dateToString2( cal.getTime() );
        return dStr;
    }

    /**
     *
     * @param input
     * @return 空返回true，非空返回false
     */
    public static boolean isNull( String input )
    {
        if ( input != null && ! input.trim().equals( "" ) )
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
     *
     * @param input
     * @return 空或0返回true，非空返回false
     */
    public static boolean isNull( Long input )
    {
        if ( input != null && input != 0 )
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
     *
     * @param input
     * @return 空或0返回true，非空返回false
     */
    public static boolean isNull( Integer input )
    {
        if ( input != null && input != 0 )
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
     *
     * @param input
     * @return 空或0返回true，非空返回false
     */
    public static boolean isNull( Double input )
    {
        if ( input != null && input != 0 )
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
     * 时间增加n天
     *
     * @param s
     *            初始时间
     * @param n
     *            增加天数
     * @return
     */
    public static String addDay( String s, int n )
    {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );

            Calendar cd = Calendar.getInstance();
            cd.setTime( sdf.parse( s ) );
            cd.add( Calendar.DATE, n );// 增加一天
            // cd.add(Calendar.MONTH, n);//增加一个月
            return sdf.format( cd.getTime() );
        }
        catch ( Exception e )
        {
            return null;
        }

    }

    /**
     * 时间增加n年
     *
     * @param s
     *            初始时间
     * @param n
     *            增加天数
     * @return
     */
    public static String addYear( String s, int n )
    {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );

            Calendar cd = Calendar.getInstance();
            cd.setTime( sdf.parse( s ) );
            cd.add( Calendar.YEAR, n );// 增加一年
            // cd.add(Calendar.MONTH, n);//增加一个月
            return sdf.format( cd.getTime() );
        }
        catch ( Exception e )
        {
            return null;
        }

    }

    /**
     * 时间增加n年
     *
     * @param s
     *            初始时间
     * @param n
     *            增加月份
     * @return
     */
    public static String addMonth( String s, int n )
    {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );

            Calendar cd = Calendar.getInstance();
            cd.setTime( sdf.parse( s ) );
            cd.add( Calendar.MONTH, n );// 增加一个月
            return sdf.format( cd.getTime() );
        }
        catch ( Exception e )
        {
            return null;
        }

    }

    /**
     * 时间增加n天
     *
     * @param s
     *            初始时间
     * @param n
     *            增加天数
     * @return
     */
    public static Timestamp addDay( Timestamp s, int n )
    {
        try
        {

            Calendar cd = Calendar.getInstance();
            cd.setTime( s );
            cd.add( Calendar.DATE, n );// 增加一天
            // cd.add(Calendar.MONTH, n);//增加一个月
            return string2Time( dateToString( cd.getTime() ) + " 00:00:00.0" );
        }
        catch ( Exception e )
        {
            return null;
        }

    }

    /**
     * 时间增加n秒
     *
     * @param s
     *            初始时间
     * @param n
     *            增加秒数
     * @return
     */
    public static String addSecond( Timestamp s, int n )
    {
        try
        {

            Calendar cd = Calendar.getInstance();
            cd.setTime( s );
            cd.add( Calendar.SECOND, n );// 增加N秒
            // cd.add(Calendar.MONTH, n);//增加一个月
            return dateToString2( cd.getTime() );
        }
        catch ( Exception e )
        {
            return null;
        }

    }

    /**
     * 时间增加n分
     *
     * @param s
     *            初始时间
     * @param n
     *            增加分钟数
     * @return
     */
    public static String addMinute( Timestamp s, int n )
    {
        try
        {

            Calendar cd = Calendar.getInstance();
            cd.setTime( s );
            cd.add( Calendar.MINUTE, n );// 增加N分
            return dateToString2( cd.getTime() );
        }
        catch ( Exception e )
        {
            return null;
        }

    }

    /**
     * 时间增加n天
     *
     * @param s
     *            初始时间
     * @param n
     *            增加月份数
     * @return
     */
    public static Timestamp addMonth( Timestamp s, int n )
    {
        try
        {

            Calendar cd = Calendar.getInstance();
            cd.setTime( s );
            cd.add( Calendar.MONTH, n );// 增加一个月
            return string2Time( dateToString( cd.getTime() ) + " 00:00:00.0" );
        }
        catch ( Exception e )
        {
            return null;
        }

    }

    public static String addHour( String s, int n )
    {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );

            if ( ! s.contains( ":" ) )
            {
                s += " 00:00:00";
            }

            Calendar cd = Calendar.getInstance();
            cd.setTime( sdf.parse( s ) );
            cd.add( Calendar.HOUR, n );// 增加一小时
            // cd.add(Calendar.MONTH, n);//增加一个月
            return sdf.format( cd.getTime() );
        }
        catch ( Exception e )
        {
            return null;
        }

    }
    /**
     * 增加小时
     * @param s 时间
     * @param n 增加数量
     * @return
     */
    public static Timestamp addHour( Timestamp s, int n )
    {
        try
        {

        	Calendar cd = Calendar.getInstance();
            cd.setTime( s );
            cd.add( Calendar.HOUR, n );// 增加小时
            return string2Time1( dateToString2( cd.getTime() ));
        }
        catch ( Exception e )
        {
            return null;
        }

    }

    /**
     * 计算两个时间相差？小时
     *
     * @param startT
     * @param endT
     * @return
     */
    public static Long diffHour( Timestamp startT, Timestamp endT )
    {

        long l = endT.getTime() - startT.getTime();
        long hour = ( l / ( 60 * 60 * 1000 ) );

        return hour;
    }

    /**
     * 计算两个时间相差？分
     *
     * @param startT
     * @param endT
     * @return
     */
    public static Long diffMin( Timestamp startT, Timestamp endT )
    {

        long l = endT.getTime() - startT.getTime();
        long min = l / ( 60 * 1000 );

        return min;
    }

    /**
     * 比较两个日期之间的大小
     *
     * @param d1
     * @param d2
     * @return 前者大于后者返回true 反之false
     */
    public static boolean compareDate(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);

        int result = c1.compareTo(c2);
        if (result >= 0)
        { return true;}
        else
            {return false;}
    }

    public static List getSelectList( String listName )
    {
        HashMap< String, List > hs = new HashMap< String, List >();
        if ( hs.get( listName ) == null )
        {
            setSelectList( listName );
        }
        return hs.get( listName );
    }

    private static void setSelectList( String listName )
    {

    }

    /**
     *
     * @param hj
     *            被加数字，会被修改
     * @param obj
     *            加数 不会被修改
     * @return 和
     */
    public static BigDecimal getSumByDecimal( BigDecimal hj, Object obj )
    {
        if ( obj != null && ! obj.equals( "" ) )
        {
            hj = hj.add( new BigDecimal( obj.toString() ) );
        }
        return hj;
    }

    /**
     * 验证是否整数
     *
     * @param str
     * @return
     */
    public static boolean isNumber( String str )
    {
        if ( str == null || "".equals( str ) )
        {
            return false;
        }
        for ( int i = str.length(); -- i >= 0; )
        {
            if ( ! Character.isDigit( str.charAt( i ) ) )
            {
                return false;
            }
        }
        return true;
    }

    public static List copyObject( List target, List source )
    {
        for ( int i = 0; i < source.size(); i++ )
        {
            target.add( source.get( i ) );
        }
        return target;
    }

    public static String getClassFields( Object msg )
    {
        try
        {
            java.lang.reflect.Field[] flds = msg.getClass().getSuperclass().getDeclaredFields();
            String returnValue = "";
            if ( flds != null )
            {
                int values = 0;
                for ( int i = 0; i < flds.length; i++ )
                {
                    String getMethod = "get" + flds[i].getName().substring( 0, 1 ).toUpperCase() + flds[i].getName().substring( 1 );
                    Class[] methodParam = null;
                    Object[] params = {};
                    Object retValue = null;
                    // 这里就是调用Bean的get方法，很爽哦，适合写在基类里！！！
                    try
                    {
                        retValue = msg.getClass().getMethod( getMethod, methodParam ).invoke( msg, params );
                        if ( retValue == null )
                        {
                            continue;
                        }
                        else
                        {
                        	String className = retValue.getClass().getName();
                            if(className.contains("$$_javassist") || className.contains("PersistentSet")){
                            	returnValue += flds[i].getName() + ":" + className + ",";
                                values++;
                            	continue;
                            }
                            returnValue += flds[i].getName() + ":" + retValue + ",";
                            values++;
                        }
                    }
                    catch ( Exception e )
                    {
                    }
                    if ( values == 40 )
                    {
                        break;
                    }
                }
            }
            return returnValue;
        }
        catch ( Exception e )
        {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 为null的话返回""
     *
     * @param text
     * @return
     */
    public static String formatString( String text )
    {
        if ( text == null )
        {
            return "";
        }
        return text;
    }

    /**
     * double四舍五入保留2位小数
     *
     * @param d
     * @return
     */
    public static String format2db( double d )
    {
        DecimalFormat df = new DecimalFormat( "#0.00" );
        return df.format( d );
    }

    /**
     * double四舍五入保留3位小数
     *
     * @param d
     * @return
     */
    public static String format3db( double d )
    {
        DecimalFormat df = new DecimalFormat( "#0.000" );
        return df.format( d );
    }

    /**
     * 转换字符编码格式,原字符必须为utf-8
     *
     * @param s
     * @param charset
     * @return
     */
    public static String getNewString( String s, String charset )
    {
        try
        {
            return new String( s.getBytes( "utf-8" ), charset );
        }
        catch ( Exception e )
        {
            return s;
        }
    }

    /**
     * 将字符串类型的日期转换为一个timestamp（时间戳记java.sql.Timestamp）
     *
     * @param dateString 需要转换为timestamp的字符串yyyyMMddkkmmss
     * @return
     */
    public static Timestamp string2Time3( String dateString )
    {
        try
        {
            DateFormat dateFormat;
            dateFormat = new SimpleDateFormat( "yyyyMMddkkmmss", Locale.ENGLISH );// 设定格式
            // dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss",
            // Locale.ENGLISH);
            dateFormat.setLenient( false );
            if ( ! dateString.contains( ":" ) )
            {
                dateString += " 00:00:00";
            }
            Date timeDate = dateFormat.parse( dateString );// util类型
            Timestamp dateTime = new Timestamp( timeDate.getTime() );// Timestamp类型,timeDate.getTime()返回一个long型
            return dateTime;
        }
        catch ( Exception e )
        {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * 统一易宝支付宝参数格式
     * 
     * @param notify_time yyyy-mm-dd kk:mm:ss
     * @return yyyyMMddkkmmss
     */
    public static String formartNotifyTime( String notify_time )
    {
        return notify_time.replaceAll( ":", "" ).replaceAll( "-", "" ).replaceAll( " ", "" );
    }
    
    /**
     * 计算日期为星期几
     * 
     * @param t
     * @return 1.星期日、2.星期一、3.星期二、4.星期三、5.星期四、6.星期五、7.星期六、
     */
    public static int getWeekByTimeStamp( Timestamp t )
    {
        Date d = new Date( t.getTime() );
        Calendar cal = Calendar.getInstance();
        cal.setTime( d );
        int w = cal.get( Calendar.DAY_OF_WEEK );
        return w;
    }
    
    /**
     * 获取时间段中间的所有日期
     * 
     * @param startT
     * @param endT
     */
    public static List< Timestamp > getTimeStampList( Timestamp startT, Timestamp endT )
    {
        
        List< Timestamp > tList = new ArrayList< Timestamp >();
        startT = toStartTime( startT );
        endT = toEndTime( endT );
        
        Timestamp tempT = startT;
        boolean tag = tempT.before( endT );
        
        while ( tag )
        {
            
            tList.add( tempT );
            
            Date d = new Date( tempT.getTime() );
            Calendar cal = Calendar.getInstance();
            cal.setTime( d );
            cal.add( Calendar.DATE, 1 );
            String dStr = dateToString( cal.getTime() );
            tempT = string2Time1( dStr );
            
            tag = tempT.before( endT );
        }
        ;
        
        return tList;
    }
    
    /**
     * 去除select 到from
     * 
     * @param sql
     * @return
     */
    public static String removeSelect( String sql )
    {
        final int beginPos = sql.toLowerCase().indexOf( "from" );
        return sql.substring( beginPos );
    }
    
    private static String removeOrders( String sql )
    {
        Pattern p = Pattern.compile( ORDERMACH, Pattern.CASE_INSENSITIVE );
        Matcher m = p.matcher( sql );
        StringBuffer sb = new StringBuffer();
        while ( m.find() )
        {
            m.appendReplacement( sb, "" );
        }
        m.appendTail( sb );
        return sb.toString();
    }
    
    public static String getSend( String strUrl, String param )
    {
        URL url = null;
        HttpURLConnection connection = null;
        
        try
        {
            url = new URL( strUrl + "?" + param );
            connection = ( HttpURLConnection ) url.openConnection();
            connection.setDoOutput( true );
            connection.setDoInput( true );
            connection.setRequestMethod( "GET" );
            connection.setUseCaches( false );
            connection.connect();
            
            BufferedReader reader = new BufferedReader( new InputStreamReader( connection.getInputStream(), "utf-8" ) );
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ( ( line = reader.readLine() ) != null )
            {
                buffer.append( line );
            }
            
            reader.close();
            return buffer.toString();
        }
        catch ( IOException e )
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            if ( connection != null )
            {
                connection.disconnect();
            }
        }
    }
    
    public static String postSend( String strUrl, String param )
    {
        
        URL url = null;
        HttpURLConnection connection = null;
        
        try
        {
            url = new URL( strUrl );
            connection = ( HttpURLConnection ) url.openConnection();
            connection.setDoOutput( true );
            connection.setDoInput( true );
            connection.setRequestMethod( "POST" );
            connection.setUseCaches( false );
            connection.connect();
            
            // POST方法时使用
            DataOutputStream out = new DataOutputStream( connection.getOutputStream() );
            out.writeBytes( param );
            out.flush();
            out.close();
            
            BufferedReader reader = new BufferedReader( new InputStreamReader( connection.getInputStream(), "utf-8" ) );
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ( ( line = reader.readLine() ) != null )
            {
                buffer.append( line );
            }
            
            reader.close();
            return buffer.toString();
        }
        catch ( IOException e )
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            if ( connection != null )
            {
                connection.disconnect();
            }
        }
        
    }
    
    /**
     * 转为16进制方法
     * 
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String paraTo16( String str ) throws UnsupportedEncodingException
    {
        String hs = "";
        
        byte[] byStr = str.getBytes( "UTF-8" );
        for ( int i = 0; i < byStr.length; i++ )
        {
            String temp = "";
            temp = ( Integer.toHexString( byStr[i] & 0xFF ) );
            if ( temp.length() == 1 )
                {temp = "%0" + temp;}
            else
            {temp = "%" + temp;}
            hs = hs + temp;
        }
        return hs.toUpperCase();
        
    }
    
    private static void fsSms( String Mobile, String Content, String send_time )
    {
        try
        {
            
            String url = "http://114.80.224.73:8088/smshttp/infoSend";
            
            String params = "account=hyxxi" + "&password=hy@123" + "&phonelist=" + Mobile + "&content="
                + URLEncoder.encode( Content, "utf-8" ) + "&sendtime=" + send_time + "&taskId=" + "hyxxi" + "_"
                + new SimpleDateFormat( "yyyyMMddHHss" ).format( new Date() ) + "_http_" + Math.round( ( Math.random() ) * 100000 );
//            System.out.println( url );
//            System.out.println( params );
//            System.out.println( CommonMethod.postSend( url, params ) );
            
        }
        catch ( Exception e )
        {
            System.out.println( "发送短信出错，错误原因：" + e.getMessage() );
            e.printStackTrace();
        }
    }
    
    public static String getTableName( String tn )
    {
        String tableName = "";
        if ( tn.length() == 0 )
        {
            return tableName;
        }
        int stratIndex = 0;
        for ( int i = 0; i < tn.length(); i++ )
        {
            if ( tn.charAt( i ) >= 'A' && tn.charAt( i ) <= 'Z' )
            {
                if ( i != 0 )
                {
                    tableName = tableName + tn.substring( stratIndex, i );
                    tableName = tableName + "_";
                    stratIndex = i;
                }
            }
        }
        tableName = tableName + tn.substring( stratIndex, tn.length() );
        return tableName;
    }
    
    /**
     * 空值检查
     * 
     * @param pInput
     *            要检查的字符串<br>
     * @return boolean 返回检查结果,但传入的字符串为空的场合,返回真
     */
    public static boolean isNull( Object pInput )
    {
        // 判断参数是否为空或者''
        if ( pInput == null || "".equals( pInput ) )
        {
            return true;
        }
        else if ( "java.lang.String".equals( pInput.getClass().getName() ) )
        {
            // 判断传入的参数的String类型的
            // 替换各种空格
            String tmpInput = Pattern.compile( U300 ).matcher( ( String ) pInput ).replaceAll( EMPTY );
            // 匹配空
            return Pattern.compile( BOL ).matcher( tmpInput ).matches();
        }
        else
        {
            // 方法类
            Method method = null;
            String newInput = "";
            try
            {
                // 访问传入参数的size方法
                method = pInput.getClass().getMethod( "size" );
                // 判断size大小
                // 转换为String类型
                newInput = String.valueOf( method.invoke( pInput ) );
                // size为0的场合
                if ( Integer.parseInt( newInput ) == 0 )
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            catch ( Exception e )
            {
                // 访问失败
                try
                {
                    // 访问传入参数的getItemCount方法
                    method = pInput.getClass().getMethod( "getItemCount" );
                    // 判断size大小
                    // 转换为String类型
                    newInput = String.valueOf( method.invoke( pInput ) );
                    // getItemCount为0的场合
                    if ( Integer.parseInt( newInput ) == 0 )
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                catch ( Exception ex )
                {
                    // 访问失败
                    try
                    {
                        // 判断传入参数的长度
                        // 长度为0的场合
                        if ( Array.getLength( pInput ) == 0 )
                        {
                            return true;
                        }
                        else
                        {
                            return false;
                        }
                    }
                    catch ( Exception exx )
                    {
                        // 访问失败
                        try
                        {
                            // 访问传入参数的hasNext方法
                            method = Iterator.class.getMethod( "hasNext" );
                            // 转换String类型
                            newInput = String.valueOf( method.invoke( pInput ) );
                            // 转换hasNext的值
                            if ( ! Boolean.valueOf( newInput ) )
                            {
                                return true;
                            }
                            else
                            {
                                return false;
                            }
                        }
                        catch ( Exception exxx )
                        {
                            // 以上场合不满足
                            return false;
                        }
                    }
                }
            }
        }
    }
    
    public static String getField( String tf )
    {
        String field = "";
        String lowerTf = tf.toLowerCase();
        int end = 0;
        int count = 0;
        while ( end != - 1 )
        {
            end = lowerTf.indexOf( "_" );
            if ( end != - 1 )
            {
                if ( count == 0 )
                {
                    field = field + lowerTf.substring( 0, end );
                }
                else if ( end == 1 )
                {
                    field = field + lowerTf.substring( 0, 1 ).toUpperCase();
                }
                else if ( end > 1 )
                {
                    field = field + lowerTf.substring( 0, 1 ).toUpperCase() + lowerTf.substring( 1, end );
                }
                lowerTf = lowerTf.substring( end + 1, lowerTf.length() );
            }
            else
            {
                if ( count == 0 )
                {
                    field = field + lowerTf;
                }
                else
                {
                    field = field + lowerTf.substring( 0, 1 ).toUpperCase() + lowerTf.substring( 1, lowerTf.length() );
                }
            }
            count++;
        }
        
        return field;
    }
    
    
	public static String getCheckCode(){
		String checkCode = "";
		for (int i = 0; i < 6; i++) {
			Random rand = new Random();
			int ri = rand.nextInt(9); // 生成0-9以内的随机数
			checkCode = checkCode + String.valueOf(ri);
		}
		return checkCode;
	}
	
	/**
	 * @Title: generateNonceStr 
	 * @Description: 生成随机字符串0-10000的MD5码
	 * @return
	 * @author 黄聪  hc  
	 * @date 2015年11月21日 上午10:44:09
	 */
	public static String generateNonceStr() {
		Random rand = new Random();
		int i = rand.nextInt(10000); // 生成0-10000以内的随机数
		return EncryptUntil.md5(String.valueOf(i));
	}
	
	/**
	 * 生成二维码
	 * @param str
	 * @return
	 */
	public static String generateCode(String str){
		try {
			CommonMethod commonMethod = new CommonMethod();
		    //取得根目录路径  
//		     String rootPath=commonMethod.getClass().getResource("").getFile().toString(); 
//		     logger.error("路径1"+rootPath);
//		     String newpath=rootPath.replace("WEB-INF/classes/com/lzp/common/","");
//		     String path = newpath+"orCode/";
			 String path = "D:/";
//		     logger.error("路径2"+path);
		     MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
		     Map hints = new HashMap();
		     hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		     BitMatrix bitMatrix = multiFormatWriter.encode(str, BarcodeFormat.QR_CODE, 400, 400,hints);
		     UUID uuid = UUID.randomUUID();
		     String fileName = uuid.toString();
		     File file1 = new File(path,fileName+".jpg");
//		     logger.error("文件名称"+fileName);
		     MatrixToImageWriter.writeToFile(bitMatrix, "jpg", file1);
//		     logger.error("完成二维码生成");
		     return fileName;
		 } catch (Exception e) {
		     e.printStackTrace();
		     return null;
		 }
	}
	
	
	
	private final static String X36 ="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	/** 
	 * @Title: convertTo10 
	 * @Description: 36进制转10进制 
	 * @param num
	 * @param base
	 * @return
	 * @author 李志鹏  lzp  
	 * @date 2015年12月3日 下午4:19:33 
	 */
	public static String convertTo10(int num, int base) {
		String str = "";
		if (num == 0) {
			return "";
		} else {
			str = convertTo10(num / base, base);
			return str + X36.charAt(num % base);
		}
	}

	/** 
	 * @Title: convertTo36 
	 * @Description: 10进制转36 
	 * @param num
	 * @param base
	 * @return
	 * @author 李志鹏  lzp  
	 * @date 2015年12月3日 下午4:19:50 
	 */
	public static String convertTo36(BigInteger num, int base) {
		String str = "";
		if (num.shortValue() == 0) {
			return "";
		} else {
			BigInteger valueOf = BigInteger.valueOf(base);
			str = convertTo36(num.divide(valueOf), base);
			return str + X36.charAt(num.mod(valueOf).shortValue());
		}
	}
	
	/**
     * @description 将xml字符串转换成map
     * @param xml
     * @return Map
     */
	public static TreeMap<String, String> readStringXmlOut(String xml) {
		TreeMap<String, String> map = new TreeMap<String, String>();
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(xml); // 将字符串转为XML
			Element rootElt = doc.getRootElement(); // 获取根节点
			Iterator iter = rootElt.elementIterator(); // 获取根节点下的子节点head
			
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				map.put(recordEle.getName(), recordEle.getText());
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	/**
	 * 将开如20151016185849转化为2015-10-16 18:58:49
	 * @return
	 */
	public static String stringToDateString(String operatingTime){
		String yyyy = operatingTime.substring(0,4);
		String MM = operatingTime.substring(4,6);
		String dd = operatingTime.substring(6,8);
		String kk = operatingTime.substring(8,10);
		String mm = operatingTime.substring(10,12);
		String ss = operatingTime.substring(12,14);
		operatingTime = yyyy + '-' + MM + '-' + dd + ' '  + kk + ':'  + mm + ':'  + ss;
		return operatingTime;
	}
	//获取用户IP
	public static String getIpAddress(HttpServletRequest request) { 
	    String ip = request.getHeader("x-forwarded-for"); 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("WL-Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("HTTP_CLIENT_IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getRemoteAddr(); 
	    } 
	    return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip; 
	  }

    /**
     * 获取随机字符串
     * @param length 字符串长度
     * @return
     */
    public static String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
