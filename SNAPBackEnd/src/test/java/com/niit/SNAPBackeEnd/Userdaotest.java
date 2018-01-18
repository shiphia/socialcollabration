/*package com.niit.SNAPBackeEnd;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SNAPBackEnd.dao.Blogdao;
import com.niit.SNAPBackEnd.dao.Userdao;
import com.niit.SNAPBackEnd.models.Users;
public class Userdaotest {

	@Autowired
public static Userdao userDAO;
	
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.SNAPBackEnd");
		context.refresh();
		
		userDAO=(Userdao)context.getBean("userdao");
	}
	

	
	@Test
	public void addUserTest()
	{
		Users users =new Users();
		users.setFirstname("keerthy1");
		users.setLastname("ouseph1");
		users.setEmail("kiranouseph1111@gmail.com");
		users.setIsonline("N1");
		users.setPassword("kiranous1eph12");
		users.setRole("ROLE_USER");
		
		
		
	
		assertTrue("Problem in Inserting User",userDAO.saveUser(users));
		
		
		
		
	}
}
*/