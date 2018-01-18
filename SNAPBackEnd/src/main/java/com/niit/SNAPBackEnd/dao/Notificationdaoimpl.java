
package com.niit.SNAPBackEnd.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.SNAPBackEnd.models.Notifications;



@Repository("NotificationsDAO")
public class Notificationdaoimpl implements Notificationsdao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	public Notificationdaoimpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	@Transactional
	public boolean addNotifications(Notifications notification) {
		
		try
		{
		sessionFactory.getCurrentSession().save(notification);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
		
	}
	
	@Transactional
	public ArrayList<Notifications> getAllNotifications(String username) {
	
		Session session = sessionFactory.openSession();
		ArrayList<Notifications> notis=(ArrayList<Notifications>)session.createQuery("from Notifications where username='"+username+"'").list();
		session.close();
		return notis;
	}
	
	@Transactional
	public boolean deleteNotifications(Notifications notification) {
		
		try
		{
		sessionFactory.getCurrentSession().delete(notification);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
		
	}
	
	

	@Transactional
	public Notifications getNotifications(int notifid) {
		Session session=sessionFactory.openSession();
		Notifications noti = (Notifications) session.get(Notifications.class,notifid);
		session.close();
		return noti;
		
	}


	
	

}
