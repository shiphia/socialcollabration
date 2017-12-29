package com.niit.SNAPBackEnd.models;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Date;
import java.util.Set;
@SuppressWarnings("unused")
@Entity
@Component
@Table(name="USERS")
public class Users implements Serializable{
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 @Id
	 
	  
	private int userid;
	
	 @Column(name = "Firstname", nullable = false)
	    private String firstname;
	 
	 @Column(name = "Lastname", nullable = false)
	    private String lastname;
	 
	 
	 
	@Column(name = "Email", nullable = false)
    private String email;
	
    @Column(name = "Password", nullable = false)
    private String password;
    
    @Column(name = "Role", nullable = false)
    private String role;
    
   
    
    @Column(name = "Isonline", nullable = false)
    private String isonline;



	public int getUserid() {
		return userid;
	}



	public void setUserid(int userid) {
		this.userid = userid;
	}


	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}






	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public String getIsonline() {
		return isonline;
	}



	public void setIsonline(String isonline) {
		this.isonline = isonline;
	}
} 
    
    
  
   


    
    

