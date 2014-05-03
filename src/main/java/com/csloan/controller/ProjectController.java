package com.csloan.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csloan.service.ProjectService;

@Controller
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value="/projects")
	public ModelAndView projectHome(HttpServletResponse resp) throws IOException {
		ModelAndView projects = new ModelAndView("projects");
		if(projectService != null) {
			projects.addObject("numProjects", projectService.getProjectCount());
		} else {
			System.err.println("ERROR: projectservice is null");
		}
		return projects;
	}
	
	@RequestMapping(value="/projects/{project_name}")
	public ModelAndView projectView(HttpServletResponse resp, 
			@PathVariable("project_name") String projectName) throws IOException {
		ModelAndView project = new ModelAndView("project"); 
		project.addObject("project_name", projectName);
		return project;
	}
	
}
 