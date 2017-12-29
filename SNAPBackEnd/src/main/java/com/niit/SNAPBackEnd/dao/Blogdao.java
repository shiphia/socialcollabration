package com.niit.SNAPBackEnd.dao;


import java.util.List;


import com.niit.SNAPBackEnd.models.Blog;
import com.niit.SNAPBackEnd.models.Blogcomments;

public interface Blogdao
{
	public boolean addBlog(Blogcomments blogcomment);
	public boolean updateBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public Blog getBlog(int blogId);
	public List<Blog> getAllBlogs();
	public boolean approveBlog(Blog blog);
	public Blogcomments getBlogComment(int blogcommentId);
	public boolean updateBlogComment(Blogcomments tempblogcomment);
}
