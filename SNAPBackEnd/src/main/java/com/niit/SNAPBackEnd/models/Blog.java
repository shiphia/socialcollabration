	package com.niit.SNAPBackEnd.models;

	import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

	@Entity
	@Component	
	@Table(name="BLOG")
	public class Blog   {

		/**
		 * 
		 */
 		
		 
		@Id
		@GeneratedValue
		  @Column(name = "BlogID", nullable = false)
		private int blogid;
		
		@Column(name = "BlogName", nullable = false)
	    private String blogName;
		
		@Column(name = "BlogContent", nullable = false)
	    private String blogContent;
		
		@Column(name = "Username", nullable = false)
	    private String username;
		
		@Column(name = "Status", nullable = false)
	    private String status;
		
		@Column(name = "Likes", nullable = false)
	    private int likes;
		
		@Column(name = "UserId", nullable = false)
	    private String userid;
		 
		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public int getBlogid() {
			return blogid;
		}
		public void setBlogid(int blogid) {
			this.blogid = blogid;
		}
		
		public String getBlogName() {
			return blogName;
		}
		public void setBlogName(String blogName) {
			this.blogName = blogName;
		}
		public String getBlogContent() {
			return blogContent;
		}
		public void setBlogContent(String blogContent) {
			this.blogContent = blogContent;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public int getLikes() {
			return likes;
		}
		public void setLikes(int likes) {
			this.likes = likes;
		}
		@Override
		public String toString() {
			return "Blog [blogid=" + blogid + ", blogName=" + blogName + ", blogContent=" + blogContent + ", username="
					+ username + " status=" + status + ", likes=" + likes + "]";

		}
	}
		