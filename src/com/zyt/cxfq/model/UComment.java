package com.zyt.cxfq.model;

import java.io.Serializable;
import java.util.Date;

public class UComment implements Serializable {
    /**
     * 
     */
    private String commentid;

    /**
     * 
     */
    private String authorid;

    /**
     * 
     */
    private String criticid;

    /**
     * 
     */
    private String circleid;

    /**
     * 
     */
    private Date commenttime;

    /**
     * 
     */
    private String parentcommentid;

    /**
     * 
     */
    private String message;

    /**
     * u_comment
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * @return commentId 
     */
    public String getCommentid() {
        return commentid;
    }

    /**
     * 
     * @param commentid 
     */
    public void setCommentid(String commentid) {
        this.commentid = commentid == null ? null : commentid.trim();
    }

    /**
     * 
     * @return authorId 
     */
    public String getAuthorid() {
        return authorid;
    }

    /**
     * 
     * @param authorid 
     */
    public void setAuthorid(String authorid) {
        this.authorid = authorid == null ? null : authorid.trim();
    }

    /**
     * 
     * @return criticId 
     */
    public String getCriticid() {
        return criticid;
    }

    /**
     * 
     * @param criticid 
     */
    public void setCriticid(String criticid) {
        this.criticid = criticid == null ? null : criticid.trim();
    }

    /**
     * 
     * @return circleId 
     */
    public String getCircleid() {
        return circleid;
    }

    /**
     * 
     * @param circleid 
     */
    public void setCircleid(String circleid) {
        this.circleid = circleid == null ? null : circleid.trim();
    }

    /**
     * 
     * @return commentTime 
     */
    public Date getCommenttime() {
        return commenttime;
    }

    /**
     * 
     * @param commenttime 
     */
    public void setCommenttime(Date commenttime) {
        this.commenttime = commenttime;
    }

    /**
     * 
     * @return parentcommentid 
     */
    public String getParentcommentid() {
        return parentcommentid;
    }

    /**
     * 
     * @param parentcommentid 
     */
    public void setParentcommentid(String parentcommentid) {
        this.parentcommentid = parentcommentid == null ? null : parentcommentid.trim();
    }

    /**
     * 
     * @return message 
     */
    public String getMessage() {
        return message;
    }

    /**
     * 
     * @param message 
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }
}