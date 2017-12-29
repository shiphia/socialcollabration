package com.niit.SNAPBackEnd.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.SNAPBackEnd.dao.Forumdao;
import com.niit.SNAPBackEnd.models.Blogcomments;
import com.niit.SNAPBackEnd.models.Forum;
import com.niit.SNAPBackEnd.models.Forumcomments;

@Repository("forumdao")
public class Forumdaoimpl implements Forumdao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	public Forumdaoimpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	
	@Transactional
	public boolean addForum(Forum forum) {
		try
		{
		sessionFactory.getCurrentSession().save(forum);
		return true;
		}
		catch(Exception e)
		{
		e.printStackTrace();
		return false;
		}
	}


	
	
	@Transactional

	public boolean updateForum(Forum forum) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(forum);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}
	
	
	
	
	@Transactional
	public boolean deleteForum(Forum forum) {
		try
		{
			sessionFactory.getCurrentSession().delete(forum);
			return true;
			}
			catch(Exception e)
			{
			System.out.println(e);
			return false;
			}
		}

		
		
		@Transactional
		public Forum getForum(int forumId) {
			Session session=sessionFactory.openSession();
			Forum forum = (Forum) session.get(Forum.class, forumId);
			session.close();
			return forum;
		}
		
		
		
		@Transactional
		public ArrayList<Forum> getAllForum() {
			Session session = sessionFactory.openSession();
			ArrayList<Forum> forumList=(ArrayList<Forum>)session.createQuery("from Forum").list();
			session.close();
			return forumList;
		}


		@Transactional
		public boolean approveForum(Forum forum) {
			try{
				forum.setStatus("Y");
				sessionFactory.getCurrentSession().saveOrUpdate(forum);
				return true;
				
			}
			catch(Exception e)
			{
			
			return false;
			}
		}

		
		
		@Transactional
		public boolean rejectforum(Forum forum) {
			try{
				forum.setStatus("N");
				sessionFactory.getCurrentSession().saveOrUpdate(forum);
				return true;
				
			}
			catch(Exception e)
			{
			
			return false;
			}
		}

		
		
		@Transactional
		public boolean addForumComment(Forumcomments forumcomment) {
			
			try
			{
			sessionFactory.getCurrentSession().save(forumcomment);
			return true;
			}
			catch(Exception e)
			{
			System.out.println(e);
			return false;
			}
		}

		
		
		@Transactional
		public boolean updateForumComment(Forumcomments forumcomment) {
			try
			{
			sessionFactory.getCurrentSession().saveOrUpdate(forumcomment);
			return true;
			}
			catch(Exception e)
			{
			System.out.println(e);
			return false;
			}
		}

		
		
		@Transactional
		public boolean deleteForumComment(Forumcomments forumcomment)
		{
			try
		{
		sessionFactory.getCurrentSession().delete(forumcomment);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
		}


		@Transactional
		public Forumcomments getForumComment(int commentId) {
			Session session=sessionFactory.openSession();
			Forumcomments forumcomment = (Forumcomments) session.get(Forumcomments.class, commentId);
			session.close();
			return forumcomment;
		}

	@Transactional
		public ArrayList<Forumcomments> getAllForumComments(int forumid) {
			Session ssn=sessionFactory.openSession();
			
			
			org.hibernate.Query q= ssn.createQuery("from ForumComments where forumid="+forumid);
			ArrayList<Forumcomments> l=(ArrayList<Forumcomments>) q.list();
			
	        
	        ssn.close();


			
			return l;
			
		}
}


		
		
		

	
		
