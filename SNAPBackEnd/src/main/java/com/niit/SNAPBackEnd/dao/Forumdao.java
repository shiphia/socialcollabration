package com.niit.SNAPBackEnd.dao;

import java.util.ArrayList;


import com.niit.SNAPBackEnd.models.Forum;
import com.niit.SNAPBackEnd.models.Forumcomments;

public interface Forumdao {
	public boolean addForum(Forum forum);
	public boolean updateForum(Forum forum);
	public boolean deleteForum(Forum forum);
	public Forum getForum(int forumId);
	public ArrayList<Forum> getAllForum();
	public boolean approveForum(Forum forum);
	public boolean rejectforum(Forum forum);
	public boolean addForumComment(Forumcomments forumcomment);
	public boolean updateForumComment(Forumcomments forumcomment);
	public boolean deleteForumComment(Forumcomments forumcomment);
	public Forumcomments getForumComment(int commentId);
	public ArrayList<Forumcomments> getAllForumComments(int forumid);

	
}