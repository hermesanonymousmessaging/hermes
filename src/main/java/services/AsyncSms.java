package services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import domain.Sms;


@Service
public class AsyncSms {
	
	@Async
	public void sendSms(String receiver, String sender, String text) throws InterruptedException {
        Thread.sleep(100);
		
        System.out.println("Sending SMS...");
        //FORMAT SENT MESSAGES
		//FORMAT SENT MESSAGES
		//FORMAT SENT MESSAGES
        Sms newsms = new Sms();
        
		newsms.SendSms(receiver, sender, text);
        
		System.out.println("SMS Sent!");
	}
}
