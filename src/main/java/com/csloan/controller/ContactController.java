package com.csloan.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.csloan.data.Message;

@Controller
public class ContactController {

	@RequestMapping(value="/contact")
	public ModelAndView contactPage(HttpServletResponse response) throws IOException {
		ModelAndView contact = new ModelAndView("contact");
		Message message = new Message();
		message.setSubject("Subject");
		message.setMessage("Message");
		message.setName("Name");
		message.setEmail("Email");
		contact.addObject("message", message);
		return contact;
	}
	
	 @RequestMapping(value = "/contact/addMessage", method = RequestMethod.POST)
	   public String addStudent(@ModelAttribute("message") Message message, 
	   ModelMap model) {
	     
		 
	      
	      return "result";
	   }
}
