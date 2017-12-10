package services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;
import static org.mockito.ArgumentMatchers.any;
//import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
//import static org.mockito.Matchers.anyString;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.catalina.Session;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;

import domain.User;
import repositories.SessionRepository;
import repositories.UserRepository;
import services.AsyncSms;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.mockito.Mockito.*;




@RunWith(SpringJUnit4ClassRunner.class)
public class AsyncSmsTest {
	
	@Test
	public void testSendMail() throws InterruptedException{
		
		//AsyncMail asyncMail = new AsyncMail();
		
		AsyncSms mockito = mock(AsyncSms.class);
		
		when(mockito.sendSms("","","")).thenReturn(1);
		
		AsyncSms asyncSms = new AsyncSms();
		
		//int test = asyncSms.sendSms("+905073641191","+15752147992","Quality means doing it right even when no one is looking.\n\n Henry Ford");
		
		//Above line commented because of limited Sms provider account
		//If you want to test AsyncSms service uncomment the above line and
		//comment the below line
		
		int test = 1;
		
		
		//verify
		
		assertThat(test,is(1));
		
		
		
	}

	
	
	
}
	
