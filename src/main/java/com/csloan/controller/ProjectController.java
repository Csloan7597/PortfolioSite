package com.csloan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import com.csloan.data.Project;
import com.csloan.service.ProjectService;

@Controller
public class ProjectController {

	Logger logger = LogManager.getLogger(ProjectController.class);
	
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value="/projects")
	public ModelAndView projectHome(HttpServletResponse resp) throws IOException {
		// Get all projects & add them to the model
		ModelAndView projects = new ModelAndView("projects");
		List<Project> projectList = projectService.getProjects();
		if(projectList == null) {
			System.err.println("Projects is null in the controller!");
			logger.info("NULL @ CONTROLLER");
		}
		projects.addObject("projects", projectList);
		return projects;
	}
	
	@RequestMapping(value="/projects/{project_name}")
	public ModelAndView projectView(HttpServletRequest req, HttpServletResponse resp, 
			@PathVariable("project_name") String projectName) throws IOException, NoSuchRequestHandlingMethodException {
		Project project = projectService.getProjectById(projectName);
		// If there is no project for this name, throw a 404 error
		if(project == null) {
			throw new NoSuchRequestHandlingMethodException(req);
		}
		// Add the project to the model 
		ModelAndView projectView = new ModelAndView("project"); 
		projectView.addObject("project", project);
		return projectView;
	}
	
}
 