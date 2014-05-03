package com.csloan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csloan.data.Project;
import com.csloan.data.ProjectDAO;

@Service
public class ProjectServiceImpl implements ProjectService{

	
	private ProjectDAO projectDAO;

	@Autowired
	public void setProjectDAO(ProjectDAO dao) {
		this.projectDAO = dao;
	}
	
	@Override
	@Transactional
	public List<Project> getProjects() {
		return projectDAO.getProjects();
	}

	@Override
	@Transactional
	public Project getProjectByName(String name) {
		return projectDAO.getProjectByName(name);
	}

	@Override
	@Transactional
	public Project getProjectById(String id) {
		return projectDAO.getProjectById(id);
	}

	@Override
	@Transactional
	public int getProjectCount() {
		return projectDAO.getProjectCount();
	}
	
}
