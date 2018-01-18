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
@Table(name="BLOGCOMMENTS")
public class Blogcomments implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue 
    @Column(name = "BlogcomId", nullable = false)
	private int blogcomid;
	
	@Column(name = "BlogComm", nullable = false)
    private String blogcomm;
	@Column(name = "Blogid", nullable = false)
	private int blogid;
	
	@Column(name = "Username", nullable = false)
	private String username;
	
	
	
	public int getBlogid() {
		return blogid;
	}
	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getBlogcomid() {
		return blogcomid;
	}
	public String getBlogcomm() {
		return blogcomm;
	}
	public void setBlogcomm(String blogcomm) {
		this.blogcomm = blogcomm;
	}
	public void setBlogcomid(int blogcomid) {
		this.blogcomid = blogcomid;
	}


}


