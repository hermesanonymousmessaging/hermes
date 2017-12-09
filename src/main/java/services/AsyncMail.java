package services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import domain.Email;

@Service
public class AsyncMail {
	
	@Async
	public void sendMail(String address, String text) throws InterruptedException {
        Thread.sleep(100);
		
        System.out.println("Sending email...");
        //FORMAT SENT MESSAGES
		//FORMAT SENT MESSAGES
		//FORMAT SENT MESSAGES
        Email newemail = new Email();
		
        newemail.SendEmail(address,text);
        
		System.out.println("Email Sent!");
	}
}
