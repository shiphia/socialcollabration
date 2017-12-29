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
@Table(name="Blogcomments")
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
	@ManyToOne
    @JoinColumn(name="B_id",updatable=true,insertable=true,nullable=false)
    private Blog blogg;
	
	
	public Blog getBlogg() {
		return blogg;
	}
	public void setBlogg(Blog blogg) {
		this.blogg = blogg;
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


