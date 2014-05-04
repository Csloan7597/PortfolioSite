package com.csloan.dao;

import java.util.List;

import com.csloan.data.Project;

public interface ProjectDAO {

	public List<Project> getProjects();
	 
	public Project getProjectByName(String name);
	
	public Project getProjectById(String id);
	
	public int getProjectCount();
	
}
