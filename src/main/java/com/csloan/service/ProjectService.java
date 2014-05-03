package com.csloan.service;

import java.util.List;

import com.csloan.data.Project;

public interface ProjectService {

	public List<Project> getProjects();
	 
	public Project getProjectByName(String name);
	
	public Project getProjectById(String id);
	
	public int getProjectCount();
	
	
}
