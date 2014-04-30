package com.csloan.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjectController {

	@RequestMapping(value="/projects")
	public ModelAndView projectHome(HttpServletResponse resp) throws IOException {
		ModelAndView projects = new ModelAndView("projects");
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
 