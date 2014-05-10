package com.csloan.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.csloan.data.Message;
import com.csloan.service.MailService;

@Controller
public class ContactController {

	
	
	@Autowired
	public MailService mailService;
	
	@Autowired
	private Message templateMessage;
	
	@RequestMapping(value="/contact")
	public ModelAndView contactPage(HttpServletResponse response) throws IOException {
		ModelAndView contact = new ModelAndView("contact");
		contact.addObject("message", templateMessage);
		contact.addObject("messageSent", false);
		return contact;  
	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "/contact/addMessage", method = RequestMethod.POST)
	public ModelAndView addStudent(@ModelAttribute("message") Message message, 
	   ModelMap model) {
		System.out.println("In the addStudent method");
		 ModelAndView contact = new ModelAndView("contact");
		 contact.addObject("message", templateMessage);
		boolean messageSent = false;
		try{ 
			 System.out.println("About to send message: "+message.getSubject());
			 mailService.sendMessageAsMail(message);
			 System.out.println("Sent!");
			 messageSent = true;
		 } catch(Throwable e) {
			 System.out.println("There was an error...");
			 contact.addObject("errorMessage", e.getMessage());
		 } finally {
			 System.out.println("Finally block");
			 contact.addObject("messageSent", messageSent);
			 return contact;
		 }
   }
}
