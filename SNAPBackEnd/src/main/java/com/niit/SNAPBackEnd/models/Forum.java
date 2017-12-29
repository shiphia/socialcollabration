package com.niit.SNAPBackEnd.models;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
 
	private int forumid;
	@Column(name = "Formname", nullable = false)
    private String formname;
	@Column(name = "FormContent", nullable = false)
    private String formcontent;

	@Column(name = "Status", nullable = false)
    private String status;
	
	@OneToMany(targetEntity=Forumcomments.class,mappedBy="forumm",cascade = CascadeType.DETACH,fetch=FetchType.EAGER)
    private Set<Forumcomments> forumcomments ;
	@Column(name = "Username", nullable = false)
    private String username;

	 
	 
	public int getForumid() {
		return forumid;
	}

	public void setForumid(int forumid) {
		this.forumid = forumid;
	}

	public String getFormname() {
		return formname;
	}

	public Set<Forumcomments> getForumcomments() {
		return forumcomments;
	}

	public void setForumcomments(Set<Forumcomments> forumcomments) {
		this.forumcomments = forumcomments;
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


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	

}