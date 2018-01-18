package com.niit.SNAPBackEnd.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.SNAPBackEnd.models.Blog;
import com.niit.SNAPBackEnd.models.Blogcomments;

 
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
public boolean addBlog(Blog blog) {
	try
	{
	sessionfactory.getCurrentSession().save(blog);
	return true;
	}
	catch(Exception e)
	{
	System.out.println(e);
	return false;
	}
	
}
@Transactional
public boolean updateBlog(Blog blog) {
	
	try
	{
	sessionfactory.getCurrentSession().saveOrUpdate(blog);
	return true;
	}
	catch(Exception e)
	{
	System.out.println(e);
	return false;
	}
}
@Transactional
public boolean deleteBlog(Blog blog) {

	try
	{
	sessionfactory.getCurrentSession().delete(blog);
	return true;
	}
	catch(Exception e)
	{
	System.out.println(e);
	return false;
	}
}
@Transactional
public Blog getBlog(int blogId) {
	Session session=sessionfactory.openSession();
	Blog blog = (Blog) session.get(Blog.class, blogId);
	session.close();
	return blog;
	
}
@Transactional
public ArrayList<Blog> getAllBlogs() {

	Session session = sessionfactory.openSession();
	ArrayList<Blog> blogList=(ArrayList<Blog>)session.createQuery("from Blog where status='YES'").list();
	session.close();
	return blogList;
}
@Transactional
public boolean approveBlog(Blog blog) {
	
	try{
		blog.setStatus("Y");
		sessionfactory.getCurrentSession().saveOrUpdate(blog);
		return true;
		
	}
	catch(Exception e)
	{
	
	return false;
	}
}
@Transactional
public boolean rejectBlog(Blog blog) {
	try{
		blog.setStatus("N");
		sessionfactory.getCurrentSession().saveOrUpdate(blog);
		return true;
		
	}
	catch(Exception e)
	{
	
	return false;
	}
	

}


@Transactional
public boolean like(int blogid) {

try
{
	Session session=sessionfactory.openSession();
	Blog blog = (Blog) session.get(Blog.class, blogid);
	
	session.update(blog);
	
return true;
}
catch(Exception e)
{
System.out.println(e);
return false;
}



}
@Transactional
public boolean dislike(int blogid) {
try
{
	Session session=sessionfactory.openSession();
	Blog blog = (Blog) session.get(Blog.class, blogid);
	blog.setLikes(blog.getLikes()+1);
	session.update(blog);
return true;
}
catch(Exception e)
{
System.out.println(e);
return false;
}


}

@Transactional
public boolean addBlogComment(Blogcomments blogcomment) {
	try
	{
	sessionfactory.getCurrentSession().save(blogcomment);
	return true;
	}
	catch(Exception e)
	{
	System.out.println(e);
	return false;
	}

	
}
@Transactional
public Blogcomments getBlogComment(int commentId)
{
Session session=sessionfactory.openSession();
Blogcomments blogcomment = (Blogcomments) session.get(Blogcomments.class, commentId);
session.close();
return blogcomment;

}

@Transactional
public boolean deleteBlogComment(Blogcomments blogcomment) {
	try
	{
	sessionfactory.getCurrentSession().delete(blogcomment);
	return true;
	}
	catch(Exception e)
	{
	System.out.println(e);
	return false;
	}

	
}
@Transactional
public boolean updateBlogComment(Blogcomments blogcomment) {
	try
	{
	sessionfactory.getCurrentSession().update(blogcomment);
	return true;
	}
	catch(Exception e)
	{
	System.out.println(e);
	return false;
	}

	
}


@Transactional
public ArrayList<Blogcomments> getAllBlogComments(int blogid) {
Session ssn=sessionfactory.openSession();


org.hibernate.Query q= ssn.createQuery("from Blogcomments where blogid="+blogid);
ArrayList<Blogcomments> l=(ArrayList<Blogcomments>) q.list();


ssn.close();



return l;

}

@Transactional
public boolean incview(int blogid) {
try
{
	Session session=sessionfactory.openSession();
	Blog blog = (Blog) session.get(Blog.class, blogid);
	
	session.update(blog);
	
return true;
}
catch(Exception e)
{
System.out.println(e);
return false;
}	
}


@Transactional
public ArrayList<Blog> getAllBlogRequests()
{

Session session = sessionfactory.openSession();
ArrayList<Blog> blogreq=(ArrayList<Blog>)session.createQuery("from Blog where status='A'").list();
session.close();
return blogreq;	

}
public ArrayList<Blog> getAllMyBlogs(String email) {


Session session = sessionfactory.openSession();
ArrayList<Blog> myblogs=(ArrayList<Blog>)session.createQuery("from Blog where username='"+email+"'").list();
session.close();
return myblogs;	

}




}
