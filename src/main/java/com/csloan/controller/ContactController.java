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
	
	@RequestMapping(value = "/contact/addMessage", method = RequestMethod.POST)
	public ModelAndView addMessage(@ModelAttribute("message") Message message, 
	   ModelMap model) {
		 ModelAndView contact = new ModelAndView("contact");
		 contact.addObject("message", templateMessage);
		boolean messageSent = false;
		try{ 
			 mailService.sendMessageAsMail(message);
			 messageSent = true;
		 } catch(Throwable e) {
			 contact.addObject("errorMessage", e.getMessage());
		 } finally {
			 contact.addObject("messageSent", messageSent);
		 }
		return contact;
   }
}
