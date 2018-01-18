package com.niit.SNAPBackEnd.dao;


import java.util.ArrayList;
import java.util.List;


import com.niit.SNAPBackEnd.models.Blog;
import com.niit.SNAPBackEnd.models.Blogcomments;

public interface Blogdao
{
	public boolean addBlog(Blog blog);
	public boolean updateBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public Blog getBlog(int blogId);
	public ArrayList<Blog> getAllBlogs();
	public boolean approveBlog(Blog blog);
	public boolean rejectBlog(Blog blog);
	public boolean addBlogComment(Blogcomments blogcomment);
	public boolean deleteBlogComment(Blogcomments blogcomment);
	public boolean updateBlogComment(Blogcomments blogcomment);
	public Blogcomments getBlogComment(int commentId);
	public ArrayList<Blogcomments> getAllBlogComments(int blogid);
	public boolean like(int blogid);
	public boolean dislike(int blogid);
	
	public ArrayList<Blog> getAllBlogRequests();
	public ArrayList<Blog> getAllMyBlogs(String email);
}
