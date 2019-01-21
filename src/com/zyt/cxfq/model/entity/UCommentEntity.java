package com.zyt.cxfq.model.entity;

import java.util.List;

import com.zyt.cxfq.model.UComment;

public class UCommentEntity extends UComment  {
	
	private List<UCommentEntity> Pcoment=null;

	public List<UCommentEntity> getPcoment() {
		return Pcoment;
	}

	public void setPcoment(List<UCommentEntity> pcoment) {
		Pcoment = pcoment;
	}
	public static UCommentEntity toc(UComment u){
		UCommentEntity n=new UCommentEntity();
		n.setCircleid(u.getCircleid());
		n.setParentcommentid(u.getParentcommentid());
		n.setCommentid(u.getCommentid());
		return n;
	}
}
