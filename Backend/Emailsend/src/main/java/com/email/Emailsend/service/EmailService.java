package com.email.Emailsend.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import com.email.Emailsend.Dto.Messages;

public interface EmailService {
	
	//send email to single person
	void sendEmail(String to,String subject,String message);
	
	//send email to multiple person
	void sendEmail(List<String> to,String subject,String message);
	
	//send email with html
	void sendEmailWithHtml(String to,String subject,String htmlContent);
	
	//send email with file
	void sendEmailWithFile(String to,String subject,String message,File file);
	
	//send email with file
	void sendEmailWithFile(String to,String subject,String message,InputStream ins);
	
	List<Messages> getInboxMessages();
	
}
