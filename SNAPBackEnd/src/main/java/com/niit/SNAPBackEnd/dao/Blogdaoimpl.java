package com.niit.SNAPBackEnd.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.SNAPBackEnd.models.Blog;

 
@Repository("blogdao")
public class Blogdaoimpl implements Blogdao 
{
	@Autowired
	
	SessionFactory sessionfactory;
	@Autowired
	public Blogdaoimpl(SessionFactory saseeionfactory)
	{
		this.sessionfactory=sessionfactory;
	}
	 
@Transactional	 
	public boolean addBlog(Blog blog) 
	{
		try
		{
			
	sessionfactory.getCurrentSession().save(blog);
		return true;
		}
		catch(Exception e)
		{
		e.printStackTrace();
		return false;
		}
	}

	
	public boolean updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean deleteBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public Blog getBlog(int blogId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Blog> getAllBlogs() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean approveBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

}
