package com.zyt.cxfq.common.entity;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tpc on 2017/9/15.
 */
public class DateConvert implements Converter<String, Date> {

    @Override
    public Date convert(String stringDate) {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (stringDate.length() ==10) {
                return format2.parse(stringDate);
            } else if (stringDate.length() == 19) {
                return format1.parse(stringDate);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
