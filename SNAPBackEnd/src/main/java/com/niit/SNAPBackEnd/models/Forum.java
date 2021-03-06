package com.niit.SNAPBackEnd.models;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Component
@Table(name="FORUM")
public class Forum implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue 
    @Column(name = "ForumID", nullable = false)
	private int forumid;
	@Column(name = "Formname", nullable = false)
    private String formname;
	@Column(name = "FormContent", nullable = false)
    private String formcontent;

	
	 
	 
	public int getForumid() {
		return forumid;
	}

	public void setForumid(int forumid) {
		this.forumid = forumid;
	}

	public String getFormname() {
		return formname;
	}

	


	public void setFormname(String formname) {
		this.formname = formname;
	}

	public String getFormcontent() {
		return formcontent;
	}
	public void setFormcontent(String formcontent) {
		this.formcontent = formcontent;
	}


	
	

}