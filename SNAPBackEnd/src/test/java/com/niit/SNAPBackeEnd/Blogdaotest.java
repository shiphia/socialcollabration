//package com.niit.SNAPBackeEnd;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.niit.SNAPBackEnd.dao.Blogdao;
//import com.niit.SNAPBackEnd.models.Blog;
//
//import junit.framework.TestCase;
//
//
//import java.sql.Date.*;
//import java.util.*;
//public class Blogdaotest 
//{
//	@Autowired
//private static Blogdao blogDAO;
//	@BeforeClass
//	public static void initialize()
//	{
//		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
//		context.scan("com.niit.SNAPBackend");
//		context.refresh();
//		
//		blogDAO=(Blogdao)context.getBean("blogdao");
//		
//	
//	}
//	
//	@Test
//	public void addBlogTest()
//	{
//		Blog blog=new Blog();
//		
//		
//		blog.setBlogName("yahoo");
//		blog.setBlogContent("fdesggfdg");
//	
//		blog.setStatus("A");
//		blog.setLikes(3);
//		
//		
//		
//		
//		assertTrue("Problem in inserting   Blog",blogDAO.addBlog(blog));
//		
//		
//		
//	
//	}
//}
//
//
//
//	