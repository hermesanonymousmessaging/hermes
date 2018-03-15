package services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import domain.Email;

@Service
public class AsyncMail {
	
	@Async
	public int sendMail(String address, String text) throws InterruptedException {
			
			Thread.sleep(100);
			
	        System.out.println("Sending email...");
	        Email newemail = new Email();
			
	        newemail.SendEmail(address,text);
	        
			System.out.println("Email Sent!");
			
			return 1;
        
	}
	
	@Async
	public int sendMailWithTitle(String address, String text, String title) throws InterruptedException {
			
			Thread.sleep(100);
			
	        System.out.println("Sending email with Title ...");
	        Email newemail = new Email();
			
	        newemail.SendEmailWithTitle(address,text, title);
	        
			System.out.println("Email with Title Sent!");
			
			return 1;
        
	}
}
