package com.csloan.data;

import java.util.List;

public interface ProjectDAO {

	public List<Project> getProjects();
	 
	public Project getProjectByName(String name);
	
	public Project getProjectById(String id);
	
	public int getProjectCount();
	
}
