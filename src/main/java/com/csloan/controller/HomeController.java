package com.csloan.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public ModelAndView homePage(HttpServletResponse response) throws IOException{
		System.out.println("Home Controller");
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/about")
	public ModelAndView aboutPage(HttpServletResponse response) throws IOException {
		return new ModelAndView("about");
	}
	
	
}
