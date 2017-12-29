package com.niit.SNAPBackEnd.dao;

import java.util.ArrayList;

import com.niit.SNAPBackEnd.models.Job;

public interface Jobdao {
	public boolean addjob(Job job);
	public boolean updatejob(Job job);
	public boolean deletejob(Job job);
	public Job getjob(int jobId);
	public ArrayList<Job> getAlljobs();

}
