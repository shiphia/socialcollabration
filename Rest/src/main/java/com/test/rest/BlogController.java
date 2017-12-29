package com.test.rest;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SNAPBackEnd.dao.Blogdao;
import com.niit.SNAPBackEnd.dao.Userdao;
import com.niit.SNAPBackEnd.models.Blog;
import com.niit.SNAPBackEnd.models.Blogcomments;
import com.niit.SNAPBackEnd.models.Users;


@RestController
@RequestMapping("/blogs")
public class BlogController {
	@Autowired 
	Blogdao blogDAO;
	@Autowired 
	Userdao userDAO;
	
	

	@RequestMapping(value="/getAllBlogs",method=RequestMethod.GET,headers = "Accept=application/json")
	public ArrayList<Blog> getAllBlogs(){
		
		System.out.println("in getall blogs");
		ArrayList<Blog> blogs=(ArrayList<Blog>)blogDAO.getAllBlogs();
		for(Blog blo:blogs)
		{
			System.out.println(blo.getBlogContent());
			System.out.println(blo.getBlogName());
			
		
		}
				return blogs;
				
	
	
	
	}

	
	
	
	@RequestMapping(value="/addBlog",method=RequestMethod.POST)
	public ResponseEntity<String> addBlog(@RequestBody Blog blog){
	
	
		
		
		boolean isSaved=blogDAO.addBlog(blog);
		if(isSaved)
		{
			
		return new ResponseEntity<String>("Adding blog successful",HttpStatus.OK);
		}
		else
		{	
			return new ResponseEntity<String>("Error in adding blog",HttpStatus.BAD_REQUEST);
		}

	}
	
	
	@RequestMapping(value="/getBlogById/{blogid}",method=RequestMethod.GET)
	public ResponseEntity<Blog> getBlog(@PathVariable("blogid") int blogId){
	
	Blog tempblog=blogDAO.getBlog(blogId);
	if(tempblog==null){
		return new ResponseEntity<Blog>(tempblog,HttpStatus.BAD_REQUEST);		
	}
	else
	{
	return new ResponseEntity<Blog>(tempblog,HttpStatus.OK);	
	}		
	
	
	
	}
	
	
	@RequestMapping(value="/deleteBlog/{blogid}",method=RequestMethod.GET)
	public ResponseEntity<String> deleteBlog(@PathVariable("blogid") int blogId){
	
		Blog blog=blogDAO.getBlog(blogId);
	if(blogDAO.deleteBlog(blog))
	{
		return new ResponseEntity<String>("Blog deleted successfully",HttpStatus.OK);	
	}
	else
	{
	
	return new ResponseEntity<String>("Problem in deleting blog",HttpStatus.BAD_REQUEST);	
	
	}
	
	
	
	}
	
	@RequestMapping(value="/updateBlog/{blogid}",method=RequestMethod.POST)
	public ResponseEntity<String> updateBlog(@RequestBody Blog blog,@PathVariable("blogid") int blogid){
		Blog tempblog=blogDAO.getBlog(blogid);
		
		tempblog.setBlogContent(blog.getBlogContent());
		tempblog.setBlogName(blog.getBlogName());
		tempblog.setStatus("A");
		
		
		boolean isSaved=blogDAO.updateBlog(tempblog);
		if(isSaved)
		return new ResponseEntity<String>("Blog updated successfully",HttpStatus.OK);
		else
			return new ResponseEntity<String>("problrm in updating blog",HttpStatus.BAD_REQUEST);
		
	}
	
	
	@RequestMapping(value="/approveBlog/{blogId}",method=RequestMethod.GET)
	public ResponseEntity<String> approveBlog(@PathVariable("blogId") int blogId){
		Blog blog=blogDAO.getBlog(blogId);
		blog.setStatus("Y");
		
		boolean isSaved=blogDAO.updateBlog(blog);
		if(isSaved)
		return new ResponseEntity<String>("Blog approved successfully",HttpStatus.OK);
		else
			return new ResponseEntity<String>("Problem in approving blog",HttpStatus.BAD_REQUEST);
		
		
	}
	
	
	@RequestMapping(value="/rejectBlog/{blogId}",method=RequestMethod.GET)
	public ResponseEntity<String> rejectBlog(@PathVariable("blogId") int blogId){
		Blog blog=blogDAO.getBlog(blogId);
		blog.setStatus("N");
		
		boolean isSaved=blogDAO.updateBlog(blog);
		if(isSaved)
		return new ResponseEntity<String>("Blog rejected successfully",HttpStatus.OK);
		else
			return new ResponseEntity<String>("Problem in rejecting blog",HttpStatus.BAD_REQUEST);
		
	}	
	
	
	
	@RequestMapping(value="/likeBlog/{blogId}",method=RequestMethod.GET)
	public ResponseEntity<String> likeBlog(@PathVariable("blogId") int blogId){
		
		Blog blog=blogDAO.getBlog(blogId);
		blog.setLikes(blog.getLikes()+1);
		
		boolean isSaved=blogDAO.updateBlog(blog);
		if(isSaved)
		return new ResponseEntity<String>("Blog liked successfully",HttpStatus.OK);
		else
			return new ResponseEntity<String>("Problem in liking blog",HttpStatus.BAD_REQUEST);
		
	}	
	
	
	@RequestMapping(value="/dislikeBlog/{blogId}",method=RequestMethod.GET)
	public ResponseEntity<String> dislikeBlog(@PathVariable("blogId") int blogId){
		Blog blog=blogDAO.getBlog(blogId);
		blog.setLikes(blog.getLikes()+1);
		
		boolean isSaved=blogDAO.updateBlog(blog);
		if(isSaved)
		return new ResponseEntity<String>("Blog disliked successfully",HttpStatus.OK);
		else
			return new ResponseEntity<String>("Problem in disliking blog",HttpStatus.BAD_REQUEST);
		
	}	

	
	@RequestMapping(value="/incview/{blogId}",method=RequestMethod.GET)
	public ResponseEntity<String> incview(@PathVariable("blogId") int blogId){
		
		Blog blog=blogDAO.getBlog(blogId);
		blog.setViews(blog.getViews()+1);
		boolean isSaved=blogDAO.updateBlog(blog);
		if(isSaved)
		return new ResponseEntity<String>("Blog view incremented successfully",HttpStatus.OK);
		else
			return new ResponseEntity<String>("Problem in view incrementing blog",HttpStatus.BAD_REQUEST);
		
	}
	
	@RequestMapping(value="/addBlogComments/{blogId}",method=RequestMethod.POST)
	public ResponseEntity<String> addBlogComments(@RequestBody Blogcomments blogcomment,@PathVariable("blogId") int blogId){
		
		blogcomment.setBlogcomid(blogId);
		boolean isSaved=blogDAO.addBlog(blogcomment);
		if(isSaved)
		return new ResponseEntity<String>("Blogcomment added successfully",HttpStatus.OK);
		else
			return new ResponseEntity<String>("Problem in adding blog comment",HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	@RequestMapping(value="/updateBlogComments",method=RequestMethod.POST)
	public ResponseEntity<String> updateBlogComments(@RequestBody Blogcomments blogcomment){
		Blogcomments tempblogcomment=blogDAO.getBlogComment(blogcomment.getBlogcomid());
		tempblogcomment.setBlogcomm(blogcomment.getBlogcomm());
		boolean isSaved=blogDAO.updateBlogComment(tempblogcomment);
		if(isSaved)
		return new ResponseEntity<String>("Blog comment updated successfully",HttpStatus.OK);
		else
			return new ResponseEntity<String>("Problem in updating blog commnet",HttpStatus.BAD_REQUEST);
		
	}
	
	
	@RequestMapping(value="/getBlogComment/{blogcommentId}",method=RequestMethod.GET,headers = "Accept=application/json")
	public Blogcomments getBlogComment(@PathVariable("blogid") int blogcommentId){
	
	Blogcomments blogcomment=blogDAO.getBlogComment(blogcommentId);
	if(blogcomment==null){
		return null;
	}
	else
	{
	return blogcomment;
	}		
	
	
	
	}
	
	
	@RequestMapping(value="/getAllBlogComments/{blogId}",method=RequestMethod.GET,headers = "Accept=application/json")
	public ArrayList<BlogComments> getAllBlogComment(@PathVariable("blogId") int blogId){
	
	ArrayList<Blogcomments> blogcomments=blogDAO.getAllBlogComments(blogId);
	if(blogcomments.isEmpty()){
		return null;
	}
	else
	{
	return blogcomments;
			
	}
	}
	
	
	@RequestMapping(value="/deleteBlogComment/{blogcommentid}",method=RequestMethod.GET)
	public ResponseEntity<String> deleteBlogComment(@PathVariable("blogcommentid") int blogcommentId){
	
	Blogcomments blogComments=blogDAO.getBlogComment(blogcommentId);

	if(blogDAO.getBlogComment(blogComments))
	{
		return new ResponseEntity<String>("BlogComment deleted successfully",HttpStatus.OK);	
	}
	else
	{
		return new ResponseEntity<String>("Problem in deleting blogcomment",HttpStatus.BAD_REQUEST);
	}		
	}
	
	
	
	
	@RequestMapping(value="/blogrequests",method=RequestMethod.GET)
	public ResponseEntity<ArrayList<Blog>> getBlogRequest()
	{
		ArrayList<Blog> blogreq=(ArrayList<Blog>)blogDAO.getAllBlogRequests(); 
	return new ResponseEntity<ArrayList<Blog>>(blogreq,HttpStatus.OK);
	
	}
	
	@RequestMapping(value="/approveblogRequests/{blogid}",method=RequestMethod.GET)
	public ResponseEntity<Blog> approveBlogRequest(@PathVariable("blogid") int blogid)
	{
	Blog blog=blogDAO.getBlog(blogid);
	blog.setStatus("YES");
	blogDAO.updateBlog(blog);
	return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	
	}
	
	
	
}
