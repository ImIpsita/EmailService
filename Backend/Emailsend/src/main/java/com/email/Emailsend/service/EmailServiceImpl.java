package com.email.Emailsend.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.email.Emailsend.Dto.Messages;

import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.NoSuchProviderException;
import jakarta.mail.Session;
import jakarta.mail.Store;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {
	
	public static final Logger logger=LoggerFactory.getLogger(EmailServiceImpl.class);

	@Autowired
	JavaMailSender javaMailSender;
	
	@Value("${mail.store.protocol}")
	String protocol;
	
	@Value("${mail.imaps.host}")
	String host;
	
	@Value("${mail.imaps.port}")
	String port;
	
	@Value("${spring.mail.username}")
	String userName;
	
	@Value("${spring.mail.password}")
	String password;

	@Override
	public void sendEmail(String to, String subject, String message) {
		SimpleMailMessage simpleMailmessage= new SimpleMailMessage();
		simpleMailmessage.setTo(to);
		simpleMailmessage.setSubject(subject);
		simpleMailmessage.setText(message);
		simpleMailmessage.setFrom("testipsita1@gmail.com");
		

		javaMailSender.send(simpleMailmessage);
		logger.info("Email send successfully");
	}
	@Override
	public void sendEmail(List<String> to, String subject, String message) {
//          SimpleMailMessage mailmessage = new SimpleMailMessage();
//          mailmessage.setTo((String[]) to.toArray());
//          mailmessage.setSubject(subject);
//          mailmessage.setText(message);
//          mailmessage.setFrom("panda2ipsita@gmail.com");
//          
//          javaMailSender.send(mailmessage);
//          logger.info("Email send successfully");

	}

	@Override
	public void sendEmailWithHtml(String to, String subject, String htmlContent) {
		MimeMessage mailmessage = javaMailSender.createMimeMessage();

		try {
			MimeMessageHelper mimeMsgHelper = new MimeMessageHelper(mailmessage, true, "UTF-8");
			mimeMsgHelper.setTo(to);
			mimeMsgHelper.setSubject(subject);
			mimeMsgHelper.setFrom("testIpsita1@gmail.com");
			mimeMsgHelper.setText(htmlContent, true);

			javaMailSender.send(mailmessage);
			 logger.info("Email send successfully");

		} catch (MessagingException e) {
			throw new RuntimeException(e);

		}

	}

	@Override
	public void sendEmailWithFile(String to, String subject, String message, File file) {
		MimeMessage mailmessage = javaMailSender.createMimeMessage();

		try {
			MimeMessageHelper mimeMsgHelper = new MimeMessageHelper(mailmessage, true, "UTF-8");
			mimeMsgHelper.setTo(to);
			mimeMsgHelper.setSubject(subject);
			mimeMsgHelper.setFrom("panda2ipsita@gmail.com");
			mimeMsgHelper.setText(message);
			
			
			FileSystemResource fileSys = new FileSystemResource(file);
			mimeMsgHelper.addAttachment(fileSys.getFilename(),file);
			javaMailSender.send(mailmessage);
			 logger.info("Email send successfully");

		} catch (MessagingException e) {
			throw new RuntimeException(e);

		}

	}
	@Override
	public void sendEmailWithFile(String to, String subject, String message, InputStream ins) {
		MimeMessage mailmessage = javaMailSender.createMimeMessage();

		try {
			MimeMessageHelper mimeMsgHelper = new MimeMessageHelper(mailmessage, true, "UTF-8");
			mimeMsgHelper.setTo(to);
			mimeMsgHelper.setSubject(subject);
			mimeMsgHelper.setFrom("testipsita1@gmail.com");
			mimeMsgHelper.setText(message);
			
			File file = new File("C://Users//DELL//OneDrive//Pictures//Saved Pictures//test.jpg");
			Files.copy(ins, file.toPath(),StandardCopyOption.REPLACE_EXISTING);
			
			FileSystemResource fileSys = new FileSystemResource(file);
			
			
			mimeMsgHelper.addAttachment(fileSys.getFilename(),file);
			javaMailSender.send(mailmessage);
			 logger.info("Email send successfully");

		} catch (MessagingException e) {
			throw new RuntimeException(e);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	@Override
	public List<Messages> getInboxMessages() {
		Properties properties= new Properties();
		properties.setProperty("mail.store.protocol",protocol);
		properties.setProperty("mail.imaps.host", host);
		properties.setProperty("mail.imaps.port", port);
		
   Session session= Session.getDefaultInstance(properties);
   List<Messages> messageList = new ArrayList<Messages>();
    try {
		Store store=session.getStore();
		store.connect(userName,password);
		Folder inbox = store.getFolder("INBOX");
		inbox.open(Folder.READ_ONLY);
		
		Message[] messages = inbox.getMessages();
		
		for(Message msg:messages) {
			Messages custmsg = new Messages();
			System.out.println(msg.getSubject());
			System.out.println("----------------------");
			 custmsg.setSubjects(msg.getSubject());
			    messageList.add(custmsg);
		}
		
	} catch (NoSuchProviderException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return messageList;
	}

}
