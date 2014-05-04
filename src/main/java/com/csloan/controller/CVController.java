package com.csloan.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CVController {
	
	@RequestMapping(value="/cv")
	public ModelAndView homePage(HttpServletResponse response) throws IOException{
		return new ModelAndView("cv");
	}
}
