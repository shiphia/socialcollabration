package com.niit.SNAPBackEnd.dao;

import java.util.List;
import com.niit.SNAPBackEnd.models.Blogcomments;
public interface Blogcommentdao {
	
	public boolean saveBlogComments(Blogcomments blogComments);

	public boolean deleteBlogComments(Blogcomments blogComments);

	public boolean updateBlogComments(Blogcomments blogComments);

	public Blogcomments getBlogComments(int blogCommentsId);

	public List<Blogcomments> getAllBlogComments();

}
