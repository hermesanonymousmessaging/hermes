package services;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SessionHandler {


    @Scheduled(fixedRate = 30000)
    public void reportCurrentTime() {
    	System.out.println("Checking sessions");
    	
    	// OPEN AND CLOSE SESSIONS HERE
    }
}
