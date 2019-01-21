package com.zyt.cxfq.model;

import java.io.Serializable;
import java.util.Date;

public class DShortMsg implements Serializable {
    /**
     * 主键
     */
    private String tMessagemanagerid;

    /**
     * 消息类型（1微信模版推送消息）
     */
    private Integer msgtype;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 消息方式（1手机）
     */
    private Integer messagetype;

    /**
     * 消息发送状态
     */
    private String sendtype;

    /**
     * 发布日期
     */
    private Date relesedate;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * d_short_msg
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     * @return T_MessageManagerID 主键
     */
    public String gettMessagemanagerid() {
        return tMessagemanagerid;
    }

    /**
     * 主键
     * @param tMessagemanagerid 主键
     */
    public void settMessagemanagerid(String tMessagemanagerid) {
        this.tMessagemanagerid = tMessagemanagerid == null ? null : tMessagemanagerid.trim();
    }

    /**
     * 消息类型（1微信模版推送消息）
     * @return MsgType 消息类型（1微信模版推送消息）
     */
    public Integer getMsgtype() {
        return msgtype;
    }

    /**
     * 消息类型（1微信模版推送消息）
     * @param msgtype 消息类型（1微信模版推送消息）
     */
    public void setMsgtype(Integer msgtype) {
        this.msgtype = msgtype;
    }

    /**
     * 标题
     * @return Title 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 内容
     * @return Content 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 消息方式（1手机）
     * @return MessageType 消息方式（1手机）
     */
    public Integer getMessagetype() {
        return messagetype;
    }

    /**
     * 消息方式（1手机）
     * @param messagetype 消息方式（1手机）
     */
    public void setMessagetype(Integer messagetype) {
        this.messagetype = messagetype;
    }

    /**
     * 消息发送状态
     * @return sendtype 消息发送状态
     */
    public String getSendtype() {
        return sendtype;
    }

    /**
     * 消息发送状态
     * @param sendtype 消息发送状态
     */
    public void setSendtype(String sendtype) {
        this.sendtype = sendtype == null ? null : sendtype.trim();
    }

    /**
     * 发布日期
     * @return ReleseDate 发布日期
     */
    public Date getRelesedate() {
        return relesedate;
    }

    /**
     * 发布日期
     * @param relesedate 发布日期
     */
    public void setRelesedate(Date relesedate) {
        this.relesedate = relesedate;
    }

    /**
     * 创建时间
     * @return CreateTime 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 创建时间
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}