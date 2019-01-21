package com.zyt.cxfq.service.server;

public interface UserSignService {
/**
 * 返回某人当月的签到日期列表，和全部的签到日期总数
 *签到
 */
public String selectDateandTotal();
/**
 * 
 * 签到
 */
public String usersign();
}
