package com.test.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SNAPBackEnd.dao.Forumcommentdao;
import com.niit.SNAPBackEnd.dao.Forumdao;
import com.niit.SNAPBackEnd.dao.Notificationsdao;
import com.niit.SNAPBackEnd.dao.Userdao;
import com.niit.SNAPBackEnd.models.Blog;
import com.niit.SNAPBackEnd.models.Forum;
import com.niit.SNAPBackEnd.models.Forumcomments;
import com.niit.SNAPBackEnd.models.Forumrequests;
import com.niit.SNAPBackEnd.models.Notifications;
import com.niit.SNAPBackEnd.models.Users;


@RestController
@RequestMapping("/forums")
public class ForumController {
	@Autowired 
	Forumdao forumDAO;
	@Autowired 
	Userdao userDAO;
	@Autowired 
	Notificationsdao notificationsDAO;
	
	
	@RequestMapping(value="/getAllForums",method=RequestMethod.GET)
	public  ArrayList<Forum> getAllForums(){
		
		ArrayList<Forum> forum=forumDAO.getAllForum();
		
		return  forum;
				
	}
	
	
	@RequestMapping(value="/addForum",method=RequestMethod.POST)
	public ResponseEntity<String> addforum(@RequestBody Forum forum){
	
		System.out.println("in add Forum......");
		
		
		boolean isSaved=forumDAO.addForum(forum);
		if(isSaved)
		{
			
		return new ResponseEntity<String>("Adding forum successful",HttpStatus.OK);
		}
		else
		{	
			return new ResponseEntity<String>("Error in adding forum",HttpStatus.BAD_REQUEST);
		}

	}
	
	
	@RequestMapping(value="/getForumById/{forumid}",method=RequestMethod.GET)
	public ResponseEntity<Forum> getForum(@PathVariable("forumid") int forumId){
	
	
	if(forumDAO.getForum(forumId)==null){
		
	}
	return new ResponseEntity<Forum>(forumDAO.getForum(forumId),HttpStatus.OK);	
			
	
	
	
	}
	
	
	

	
	
	
	
	@RequestMapping(value="/deleteForum/{forumid}",method=RequestMethod.GET)
	public ResponseEntity<Forum> deleteForum(@PathVariable("forumid") int forumId){

	Forum forum=forumDAO.getForum(forumId);
	forumDAO.deleteForum(forum);
	ArrayList<Forumrequests> fr=forumDAO.getAllForumRequestAll(forumId);
	for(Forumrequests f:fr)
	{
		forumDAO.deleteForumRequest(f);
	}
	
	ArrayList<Forumcomments> fc=forumDAO.getAllForumCommentsById(forumId);
	for(Forumcomments fcc:fc)
	{
		forumDAO.deleteForumComment(fcc);
	}
	if(forumDAO.getForum(forumId)==null){
		
	}
	return new ResponseEntity<Forum>(forum,HttpStatus.OK);	
			
	
	
	
	}

	@RequestMapping(value="/updateForum/{forumid}/{forumname}/{forumcontent}",method=RequestMethod.POST)
	public ResponseEntity<Forum> updateForum(@PathVariable("forumid") int forumid,@PathVariable("forumname") String forumname,@PathVariable("forumcontent") String forumcontent){
		System.err.println(forumid+"  "+forumname+"  "+forumcontent);
		Forum tempforum=forumDAO.getForum(forumid);
		tempforum.setFormname(forumname);
		tempforum.setFormcontent(forumcontent);
		boolean isSaved=forumDAO.updateForum(tempforum);
		if(isSaved)
		return new ResponseEntity<Forum>(tempforum,HttpStatus.OK);
		else
			return new ResponseEntity<Forum>(tempforum,HttpStatus.BAD_REQUEST);
		
	}
	
	

	

	
	@RequestMapping(value="/addForumComments/{forumid}/{username}/{forumcomm}",method=RequestMethod.GET)
	public ResponseEntity<Forumcomments> addForumcomments(@PathVariable("forumid") int forumid,@PathVariable("username") String username,@PathVariable("forumcomm") String forumcomm){

		
		Forumcomments forumcomments=new Forumcomments();
		forumcomments.setForumcomm(forumcomm);
		forumcomments.setForumcomid(forumid);
		forumcomments.setUsername(username);

		boolean isSaved=forumDAO.addForumComment(forumcomments);
		if(isSaved)
		return new ResponseEntity<Forumcomments>(forumcomments,HttpStatus.OK);
		else
			return new ResponseEntity<Forumcomments>(forumcomments,HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	@RequestMapping(value="/updateForumComments",method=RequestMethod.PUT)
	public ResponseEntity<Forumcomments> updateBlogComments(@RequestBody Forumcomments forumcomments){
		
		boolean isSaved=forumDAO.updateForumComment(forumcomments);
		if(isSaved)
		return new ResponseEntity<Forumcomments>(forumcomments,HttpStatus.OK);
		else
			return new ResponseEntity<Forumcomments>(forumcomments,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@RequestMapping(value="/deleteForumComment/{forumcommentid}",method=RequestMethod.DELETE)
	public ResponseEntity<Forumcomments> deleteForumComment(@PathVariable("forumcommentid") int forumcommentId){
	
	Forumcomments forumComments=forumDAO.getForumComment(forumcommentId);
forumDAO.deleteForumComment(forumComments);
	if(forumDAO.getForumComment(forumcommentId)==null)
	{
		
	}
	return new ResponseEntity<Forumcomments>(forumDAO.getForumComment(forumcommentId),HttpStatus.OK);	
			
	}
	
	
	@RequestMapping(value="/getForumComment/{forumcommentId}",method=RequestMethod.GET)
	public ResponseEntity<Forumcomments> getforumComment(@PathVariable("forumcomentid") int forumcommentId){
	
	
	if(forumDAO.getForumComment(forumcommentId)==null){
		
	}
	return new ResponseEntity<Forumcomments>(forumDAO.getForumComment(forumcommentId),HttpStatus.OK);	
			
	
	
	
	}
	
	@RequestMapping(value="/getAllForumComments/{forumId}",method=RequestMethod.GET)
	public ArrayList<Forumcomments> getAllForumComment(@PathVariable("forumId") int forumId){
		System.err.println(forumId);
	
	ArrayList<Forumcomments> forumcomments=forumDAO.getAllForumCommentsById(forumId);
			if(forumcomments.isEmpty()){
				return null;
			}
			else
			{
			return forumcomments;
					
			}
	
	}
	
	@RequestMapping(value="/myforums/{myid}",method=RequestMethod.GET)
	public ArrayList<Forum> getmyforums(@PathVariable("myid") int myid)
	{ArrayList<Forum> myforums=new ArrayList<Forum>();  
		ArrayList<Forumrequests> freq=forumDAO.getAllMyForum(myid);
		for(Forumrequests f:freq)
		{
			
			Forum fo=forumDAO.getForum(f.getForumid());
			myforums.add(fo);
		}
		return myforums;
	}
	
	
	
	@RequestMapping(value="/checkIfMyForum/{forumid}/{myid}",method=RequestMethod.GET)
	public ResponseEntity<ArrayList<Forumrequests>> getcheckifmyforum(@PathVariable("forumid") int forumId,@PathVariable("myid") int myid){
		
		System.err.println(forumId+"  "+myid);
		Forumrequests f=new Forumrequests();
	ArrayList<Forumrequests> foru=forumDAO.checkIfMyForum(forumId, myid);
	return new ResponseEntity<ArrayList<Forumrequests>>(foru,HttpStatus.OK);	
			
	
	
	
	}
	
	
	@RequestMapping(value="/addForumReq/{forumid}/{myid}",method=RequestMethod.GET)
	public ResponseEntity<Forumrequests> addForumReq(@PathVariable("forumid") int forumId,@PathVariable("myid") int myid){
	
	Users u=userDAO.getUser(myid);
	Forum f=forumDAO.getForum(forumId);
	Forumrequests fr=new Forumrequests();
	fr.setForumid(forumId);
	fr.setUserid(myid);
	fr.setStatus("A");
	fr.setUsername(u.getEmail());
	fr.setForumname(f.getFormname());
	
	
	
		boolean isSaved=forumDAO.addForumRequest(fr);
		if(isSaved)
		{
			return new ResponseEntity<Forumrequests>(fr,HttpStatus.OK);	
		}
		else
		{
			return new ResponseEntity<Forumrequests>(fr,HttpStatus.BAD_REQUEST);
		}
				
	
	
	
	}
	
	
	@RequestMapping(value="/getForumRequests",method=RequestMethod.GET)
	public ResponseEntity<ArrayList<Forumrequests>> getForumrequests()
    {
		ArrayList<Forumrequests> ff=forumDAO.getAllForumRequest();
		for(Forumrequests fff:ff)
		{
			System.err.println(fff.getForumname());
			System.err.println(fff.getUsername());
			
		}
	return new ResponseEntity<ArrayList<Forumrequests>>(forumDAO.getAllForumRequest(),HttpStatus.OK);		
	}
	
	
	@RequestMapping(value="/approveForumRequests/{forumReqId}",method=RequestMethod.GET)
	public void approveForumRequets(@PathVariable("forumReqId") int forumreqid)
	{
		Forumrequests fr=forumDAO.getForumRequest(forumreqid);
		fr.setStatus("YES");
boolean IsSaved=forumDAO.acceptForumRequest(fr);

String noti="your forumrequest for forum:"+fr.getForumname()+" is approved";
Notifications not=new Notifications();
not.setName(noti);
not.setUsername(fr.getUsername());

notificationsDAO.addNotifications(not);

	}
	
	@RequestMapping(value="/rejectForumRequests/{forumReqId}",method=RequestMethod.GET)
	public void rejectForumRequets(@PathVariable("forumReqId") int forumreqid)
	{
		Forumrequests fr=forumDAO.getForumRequest(forumreqid);
		fr.setStatus("R");
boolean IsSaved=forumDAO.rejectForumRequest(fr);
String noti="your forumrequest for forum:"+fr.getForumname()+" is approved";
Notifications not=new Notifications();
not.setName(noti);
not.setUsername(fr.getUsername());

notificationsDAO.addNotifications(not);
	}
	
	
	@RequestMapping(value="/forumreqbyforumid/{forumid}",method=RequestMethod.GET)
	public ArrayList<Users> getforumusers(@PathVariable("forumid") int forumid)
	{ArrayList<Users> users=new ArrayList<Users>(); 
		ArrayList<Forumrequests> f=forumDAO.forreqbyforid(forumid);
		for(Forumrequests ff:f)
		{
			Users u=userDAO.getUser(ff.getUserid());
			users.add(u);
		}
		return users;
	}

}