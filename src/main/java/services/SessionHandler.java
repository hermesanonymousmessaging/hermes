package services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import repositories.SessionRepository;
import domain.Log;
import domain.Session;
import services.LogService;

@Component
public class SessionHandler {

	@Autowired
	private SessionRepository sessionRepository;
	
	@Autowired
	private SessionService sessionService;
	@Autowired
	private LogService logService;
    @Scheduled(fixedRate = 3000)
    public void reportCurrentTime() throws ParseException {
    
    	List<Session> sessions = sessionService.listAll();
    	for(Session item : sessions) {
    		if(item.getActive() == false){
    			if((item.getStartDate_Date().compareTo((Calendar.getInstance().getTime())) <= 0) &&
    					(item.getEndDate_Date().compareTo((Calendar.getInstance().getTime()))  > 0)){
    				item.setActive();
    				sessionService.saveOrUpdate(item);
    				Log newlog = new Log("Session with ID: " + item.getId() + " is activated. ");
    				logService.saveOrUpdate(newlog);
    			}
    		}
    		else if((item.getActive() == true) &&
    				(item.getEndDate_Date().compareTo(Calendar.getInstance().getTime())) < 0) {
    			item.disable();
    			sessionService.saveOrUpdate(item);
    			Log newlog = new Log("Session with ID: " + item.getId() + " is deactivated. ");
				logService.saveOrUpdate(newlog);
    		}
    		
    	}
    	
    	
    }
}
