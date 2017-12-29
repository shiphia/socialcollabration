package com.niit.SNAPBackeEnd;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SNAPBackEnd.dao.Blogdao;
import com.niit.SNAPBackEnd.dao.Jobdao;
import com.niit.SNAPBackEnd.models.Job;
public class Jobdaotest {
	@Autowired
	private static  Jobdao jobDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.SNAPBackEnd");
		context.refresh();
		
		jobDAO=(Jobdao)context.getBean("jobdao");
	}
	@Ignore
	@Test
	public void addjob()
	{
		Job job=new Job();
		job.setJobdesc("Devops");
		
		job.setJobprofile("Web App developer");
		
		assertTrue("Problem in inserting job",jobDAO.addjob(job));		
	}

}
