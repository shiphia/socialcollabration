/*package com.niit.SNAPBackeEnd;

import static org.junit.Assert.*;

import org.junit.Test;


import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SNAPBackEnd.dao.Blogdao;
import com.niit.SNAPBackEnd.dao.Forumdao;
import com.niit.SNAPBackEnd.dao.Userdao;
import com.niit.SNAPBackEnd.models.Blog;
import com.niit.SNAPBackEnd.models.Blogcomments;
import com.niit.SNAPBackEnd.models.Forum;
import com.niit.SNAPBackEnd.models.Forumcomments;
import com.niit.SNAPBackEnd.models.Users;

public class Forumdaotest {
	@Autowired
	private static Forumdao forumDAO;
	 
	@Autowired
	private static Userdao userDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.SNAPBackEnd");
		context.refresh();
		
		forumDAO=(Forumdao)context.getBean("forumdao");
 	}
	@Ignore
	@Test
	public void addForumTest()
	{
		Forum forum=new Forum();
		//Users user=userDAO.getUser(1);
		forum.setFormcontent("Java or .Net");
		forum.setFormname("JAVA");
 		forum.setStatus("N");
		
		assertTrue("Problem in adding Forum  ",forumDAO.addForum(forum));
	
	
	}

	
}

	*/