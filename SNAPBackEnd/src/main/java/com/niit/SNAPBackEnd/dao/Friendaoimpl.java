
package com.niit.SNAPBackEnd.dao;

import java.util.ArrayList;



import org.apache.commons.collections.Factory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.SNAPBackEnd.models.Friend;
import com.niit.SNAPBackEnd.models.Users;


@Repository("friendDAO")
public class Friendaoimpl implements Frienddao {
	
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Autowired
	public Friendaoimpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	//sending friend requests
@Transactional
	public boolean addFriend(Friend friend) {
		try
		{
		sessionFactory.getCurrentSession().save(friend);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}

//accept friend requests
@Transactional
	public boolean accept(int friendreqid) {
		try
		{Session session=sessionFactory.openSession();
		Friend friend=(Friend) session.get(Friend.class,friendreqid);
		friend.setStatus("Y");
		session.saveOrUpdate(friend);
		session.close();
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
		
	}


//rejecting friendrequests
@Transactional
	public boolean reject(int friendreqid) {
		try
		{Session session=sessionFactory.openSession();
		Friend friend=(Friend) session.get(Friend.class,friendreqid);
		friend.setStatus("N");
		session.saveOrUpdate(friend);
		session.close();
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}	}


//fetching all my friend requests
@Transactional
	public ArrayList<Friend> getAllFriendRequestsByUser( int userid) {
		

		Session session = sessionFactory.openSession();
		ArrayList<Friend> myfriends=(ArrayList<Friend>)session.createQuery("from Friend where FRI_ID="+userid+" and status='A'").list();
		session.close();
		return myfriends;
	}

//retyrieving everything from friend table 
@Transactional
	public ArrayList<Friend> getAllFriend() {
		Session session = sessionFactory.openSession();
		ArrayList<Friend> Allfriends=(ArrayList<Friend>)session.createQuery("from Friend").list();
		session.close();
		return Allfriends;
		
	}

//fetching all my friends 
@Transactional
public ArrayList<Friend> getAllMyFriend(int myid) {
	Session session = sessionFactory.openSession();
	Query q= session.createQuery("from Friend where status='YES' and (U_ID="+myid+" or FRI_ID="+myid+")" );
ArrayList<Friend> myfriends=(ArrayList<Friend>)q.list();
return myfriends;
	}

@Transactional
public ArrayList<Friend> getAllMyFriendpend(int myid) {
	Session session = sessionFactory.openSession();
	Query q= session.createQuery("from Friend where (U_ID="+myid+" or FRI_ID="+myid+")");
ArrayList<Friend> myfriends=(ArrayList<Friend>)q.list();
return myfriends;
	}


//fetching all pending entries like we not acceped or he not accepted
@Transactional
public ArrayList<Friend> getAllpendingentries(int myid) {
	Session session = sessionFactory.openSession();
	Query q= session.createQuery("from Friend where  status='A' and( U_ID="+myid+" or FRI_ID="+myid+") ");
ArrayList<Friend> myfriends=(ArrayList<Friend>)q.list();
return myfriends;
	}


//
@Transactional
public ArrayList<Friend> getAllPendingrequests( int userid) {
	

	Session session = sessionFactory.openSession();
	ArrayList<Friend> myfriends=(ArrayList<Friend>)session.createQuery("from Friend where U_ID="+userid+" and status='A'").list();
	session.close();
	return myfriends;
}



@Transactional
public Users getUserById(int userid) {
	Users user=new Users();
	try{
		Session session= sessionFactory.openSession();
		Query query=session.createQuery("from Users where userid="+userid);
		 user=(Users)query.list().get(0);
		session.close();
		
	}
	catch(Exception e)
	{
		
		
	}
	return user;
}

@Transactional
public boolean delete(Friend friend) {
	try
	{
		
	sessionFactory.getCurrentSession().delete(friend);
	return true;
	}
	catch(Exception e)
	{
	System.out.println(e);
	return false;
	}
}

@Transactional
public Friend getfriendrequest(int friendreqid,int myid) {
	
	Session session = sessionFactory.openSession();
	Query q= session.createQuery("from Friend where (U_ID="+myid+" and FRI_ID="+friendreqid+") or (U_ID="+friendreqid+" and FRI_ID="+myid+")" );
Friend mynfriend=(Friend)q.list().get(0);
return mynfriend;
	
}


@Transactional
public Friend acceptfriendrequest(Friend friend)
{
	try
	{
	sessionFactory.getCurrentSession().update(friend);
	return null;
	}
	catch(Exception e)
	{
	System.out.println(e);
	return null;
	}
}




}
