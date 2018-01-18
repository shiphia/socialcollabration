package com.niit.SNAPBackEnd.dao;

import java.util.ArrayList;

import com.niit.SNAPBackEnd.models.Notifications;



public interface Notificationsdao {
	public boolean addNotifications(Notifications notification) ;
	public ArrayList<Notifications> getAllNotifications( String username) ;
	public boolean deleteNotifications(Notifications notification);
	public Notifications getNotifications(int notifid);
}
