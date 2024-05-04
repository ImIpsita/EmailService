package com.email.Emailsend.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.email.Emailsend.Dto.CustomeResponse;
import com.email.Emailsend.Dto.EmailRequest;
import com.email.Emailsend.service.EmailService;

@RestController
@CrossOrigin("*")
@RequestMapping("email")
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	@SuppressWarnings("unchecked")
	@PostMapping("/send")
	public ResponseEntity<?>sendEmail(@RequestBody EmailRequest emailRequest){
		emailService.sendEmailWithHtml(emailRequest.getSendto(), emailRequest.getSubject(), emailRequest.getMessage());
		return new ResponseEntity(new CustomeResponse("Email sent successfully"),HttpStatus.OK);
		
	}
	
	@PostMapping("/sendHtml")
	public ResponseEntity<?>sendEmailwithHtmlContent(@RequestPart EmailRequest emailRequest,@RequestPart MultipartFile file) throws IOException{
		emailService.sendEmailWithFile(emailRequest.getSendto(), emailRequest.getSubject(), emailRequest.getMessage(),file.getInputStream());
		return ResponseEntity.status(HttpStatus.OK).body(new CustomeResponse("Email sent successfully",HttpStatus.OK));
		
	}

}
