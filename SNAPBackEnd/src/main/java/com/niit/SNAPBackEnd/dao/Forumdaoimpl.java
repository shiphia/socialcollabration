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
import com.niit.SNAPBackEnd.models.Forumrequests;

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
		public ArrayList<Forumcomments> getAllForumCommentsById(int forumid) {
				Session ssn=sessionFactory.openSession();
				
				
				org.hibernate.Query q= ssn.createQuery("from Forumcomments where forumid="+forumid);
				ArrayList<Forumcomments> l=(ArrayList<Forumcomments>) q.list();
				
		        
		        ssn.close();


				
				return l;
				
			}
		
		
		
		
		
		
		
		@Transactional
	public boolean addForumRequest(Forumrequests forumrequest) {
		try
		{
			sessionFactory.getCurrentSession().save(forumrequest);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}

	@Transactional
	public boolean acceptForumRequest(Forumrequests forumrequest) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(forumrequest);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}

	@Transactional
	public boolean rejectForumRequest(Forumrequests forumrequest) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(forumrequest);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}

	@Transactional
	public boolean blockUser(Forumrequests forumrequest) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(forumrequest);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}	
	}
	@Transactional
	public ArrayList<Forumrequests> getAllForumRequest() {
		Session session = sessionFactory.openSession();
		ArrayList<Forumrequests> forumReqList=(ArrayList<Forumrequests>)session.createQuery("from Forumrequests where status='A'").list();
		session.close();
		return forumReqList;

	}

	@Transactional
	public Forumrequests getForumRequest(int ForumReqId) {
		
		Session session=sessionFactory.openSession();
		Forumrequests forumReq = (Forumrequests) session.get(Forumrequests.class, ForumReqId);
		session.close();
		return forumReq;
		
	}

	@Transactional
	public ArrayList<Forumrequests> getAllMyForum(int myid) {
		Session session = sessionFactory.openSession();
		ArrayList<Forumrequests> myforums=(ArrayList<Forumrequests>)session.createQuery("from Forumrequests where userid="+myid+" and status='YES'").list();
		session.close();
		return myforums;
		
	}

	@Transactional
	public ArrayList<Forumrequests> checkIfMyForum(int ForumId, int myid) {
		
		Session session = sessionFactory.openSession();
		ArrayList<Forumrequests> myforums=(ArrayList<Forumrequests>)session.createQuery("from Forumrequests where userid="+myid+" and forumid="+ForumId).list();
		session.close();
		return myforums;
	}

	@Transactional
	public ArrayList<Forumrequests> forreqbyforid(int forumid) {
		Session session = sessionFactory.openSession();
		ArrayList<Forumrequests> forumsbyforid=(ArrayList<Forumrequests>)session.createQuery("from Forumrequests where forumid="+forumid+" and status='YES'").list();
		session.close();
		return forumsbyforid;
		
	}

	@Transactional
	public ArrayList<Forumrequests> getAllForumRequestAll(int forumid) {
		Session session = sessionFactory.openSession();
		ArrayList<Forumrequests> forumReqList=(ArrayList<Forumrequests>)session.createQuery("from Forumrequests where forumid="+forumid).list();
		session.close();
		return forumReqList;
	}


	
	

	@Transactional
	public Forumrequests myforreq(String email, int forumid) {
		Session session = sessionFactory.openSession();
		Forumrequests forumsreme=(Forumrequests)session.createQuery("from Forumrequests where forumid="+forumid+" and username='"+email+"'").list().get(0);
		return forumsreme;
	}


	@Transactional
	public boolean deleteForumRequest(Forumrequests forumreq)
	{
		try
	{
	sessionFactory.getCurrentSession().delete(forumreq);
	return true;
	}
	catch(Exception e)
	{
	System.out.println(e);
	return false;
	}
	}

	


	
	


	
}


		
		
		

	
		
