package com.niit.SNAPBackEnd.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="ForumComments")
public class Forumcomments implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue 
    @Column(name = "ForumcomId", nullable = false)
	private int forumcomid;
	 @Column(name = "ForumComm", nullable = false)
		private String forumcomm;
	 @ManyToOne
	    @JoinColumn(name="F_id",updatable=true,insertable=true,nullable=false)
	    private Forum forumm;
	 
	 
	 
	public Forum getForumm() {
		return forumm;
	}
	public void setForumm(Forum forumm) {
		this.forumm = forumm;
	}
	public int getForumcomid() {
		return forumcomid;
	}
	public void setForumcomid(int forumcomid) {
		this.forumcomid = forumcomid;
	}
	public String getForumcomm() {
		return forumcomm;
	}
	public void setForumcomm(String forumcomm) {
		this.forumcomm = forumcomm;
	}
}
