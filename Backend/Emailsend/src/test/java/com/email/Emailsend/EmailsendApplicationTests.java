package com.email.Emailsend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.email.Emailsend.service.EmailService;

@SpringBootTest
class EmailsendApplicationTests {
	
	@Autowired
	EmailService emailService;

//	@Test
//	void contextLoads() {
//	}
	
//	@Test
//	 void sendEmail() {
//		emailService.sendEmail("panda2ipsita@gmail.com", "Springboot Email API", "Testing purpose");
//        System.out.println("Email sent successfully");
//	}
	
//	@Test
//	 void sendEmailhtml() {
//		String html= ""+"<h1>welcome</h1>"+"";
//		emailService.sendEmailWithHtml("panda2ipsita@gmail.com", "Springboot HTML Email AP",html);
//       System.out.println("Email sent successfully");
//	}
	
//	@Test
//	 void sendEmailFile() {
//		emailService.sendEmailWithFile("panda2ipsita@gmail.com", "Springboot file Email", "below is the content for file in springboot", new File("C:\\Users\\DELL\\OneDrive\\Pictures\\Saved Pictures\\smil.jpg"));
//      System.out.println("Email sent successfully");
//	}
	
//	@Test
//	 void sendEmailFile() throws FileNotFoundException {
//		File file = new File("C://Users//DELL//OneDrive//Pictures//Saved Pictures//smil.jpg");
//		InputStream in = new FileInputStream(file);
//		emailService.sendEmailWithFile("panda2ipsita@gmail.com", "Springboot file inputstream Email", "below is the content for file in springboot",in);
//     System.out.println("Email sent successfully");
//	}
//	
	   @Test
       void getInboxMessages() {
		   emailService.getInboxMessages();
}

}
