package com.niit.SNAPBackEnd.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.SNAPBackEnd.dao.Blogcommentdao;
import com.niit.SNAPBackEnd.models.Blogcomments;


@Repository("blogcommentdao")
public class Blogcommentdaoimpl implements Blogcommentdao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean saveBlogComments(Blogcomments blogComments) {
		try {
			sessionFactory.getCurrentSession().save(blogComments);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised"+e);
		}
		return false;
	}
	@Transactional
	public boolean deleteBlogComments(Blogcomments blogComments) {
		try {
			sessionFactory.getCurrentSession().delete(blogComments);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" +e);
		}
		return false;
	}
	@Transactional
	public boolean updateBlogComments(Blogcomments blogComments) {
		try {
			sessionFactory.getCurrentSession().update(blogComments);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" +e);
		}
		return false;
	}
	@Transactional
	public Blogcomments getBlogComments(int blogCommentsId) {
		Session session = sessionFactory.openSession();
		Blogcomments blogComments = (Blogcomments) session.get(Blogcomments.class, new Integer(blogCommentsId));
		return blogComments;
		
	}
	@Transactional
	public List<Blogcomments> getAllBlogComments() {
		return sessionFactory.getCurrentSession().createQuery("from BlogComments").list();
	}

}

