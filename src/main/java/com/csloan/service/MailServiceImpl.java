package com.csloan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.csloan.data.Message;

@Service
public class MailServiceImpl implements MailService {

	private final static char NEWLINE = '\n';
	
	private JavaMailSender mailSender;
	private SimpleMailMessage templateMessage;
    
	@Autowired
    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
	
	@Autowired
	public void setTemplateMessage(SimpleMailMessage templateMessage) {
		this.templateMessage = templateMessage;
	}
	
	@Override
	public void sendMessageAsMail(Message message) {
		SimpleMailMessage toSend = new SimpleMailMessage(templateMessage);
		toSend.setSubject("From Site: "+message.getSubject());
		toSend.setText("Name: "+message.getName() +NEWLINE+ "Email: "+message.getEmail()+
				NEWLINE+NEWLINE+message.getMessage());
		mailSender.send(toSend);
	}

	@Override
	public void sendMail(SimpleMailMessage message) {
		mailSender.send(message); 	
	}

}
