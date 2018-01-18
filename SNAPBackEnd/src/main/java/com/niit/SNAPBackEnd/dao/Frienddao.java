package com.niit.SNAPBackEnd.dao;

import java.util.ArrayList;

import com.niit.SNAPBackEnd.models.Friend;
import com.niit.SNAPBackEnd.models.Users;


public interface Frienddao {
	public boolean addFriend(Friend friend);
	public boolean delete(Friend friend );
	public boolean accept(int friendreqid);
	public boolean reject(int friendreqid);
	public Friend getfriendrequest(int friendreqid,int myid);
	public ArrayList<Friend> getAllFriendRequestsByUser(int userid);
	public ArrayList<Friend> getAllFriend();
	public ArrayList<Friend> getAllMyFriend(int myid);
	public ArrayList<Friend> getAllpendingentries(int myid);
	public ArrayList<Friend> getAllPendingrequests( int userid);
public Users getUserById(int userid);
public Friend acceptfriendrequest(Friend friend);
public ArrayList<Friend> getAllMyFriendpend(int myid);

}