package com.niit.SNAPBackEnd.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SNAPBackEnd.dao.Forumcommentdao;


@Repository("forumCommentDAO")
public class Forumcommentdaoimpl implements Forumcommentdao {
	
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public Forumcommentdaoimpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

}