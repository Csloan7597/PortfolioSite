package com.csloan.service;

import org.springframework.mail.SimpleMailMessage;

import com.csloan.data.Message;

public interface MailService {

	void sendMail(SimpleMailMessage message);

	void sendMessageAsMail(Message message);
	
}
