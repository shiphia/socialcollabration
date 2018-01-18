package com.niit.SNAPBackEnd.dao;

import java.util.ArrayList;


import com.niit.SNAPBackEnd.models.Forum;
import com.niit.SNAPBackEnd.models.Forumcomments;
import com.niit.SNAPBackEnd.models.Forumrequests;

public interface Forumdao {
	public boolean addForum(Forum forum);
	public boolean updateForum(Forum forum);
	public boolean deleteForum(Forum forum);
	public Forum getForum(int forumId);
	public ArrayList<Forum> getAllForum();
	
	
	public ArrayList<Forumrequests> getAllMyForum(int userid);
	
	public boolean addForumComment(Forumcomments forumcomment);
	public boolean updateForumComment(Forumcomments forumcomment);
	public boolean deleteForumComment(Forumcomments forumcomment);
	public Forumcomments getForumComment(int commentId);
	public ArrayList<Forumcomments> getAllForumCommentsById(int forumid);

	public boolean addForumRequest(Forumrequests forumrequest);
	public boolean acceptForumRequest(Forumrequests forumrequest);
	public boolean blockUser(Forumrequests forumrequest);
	public ArrayList<Forumrequests> getAllForumRequest();
	public Forumrequests getForumRequest(int ForumReqId);
		
	public ArrayList<Forumrequests> checkIfMyForum(int ForumId, int myid);
	public ArrayList<Forumrequests> forreqbyforid(int forumid);
	public ArrayList<Forumrequests> getAllForumRequestAll(int forumid);
	public boolean deleteForumRequest(Forumrequests forumreq);
	public boolean rejectForumRequest(Forumrequests forumrequest);
	public Forumrequests myforreq(String email,int forumid);
}