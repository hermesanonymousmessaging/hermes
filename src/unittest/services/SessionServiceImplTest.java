package services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
//import static org.mockito.Mockito.doThrow;
import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
//import static org.mockito.Matchers.anyString;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//import org.apache.catalina.Session;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;

import domain.Session;
import repositories.SessionRepository;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.mockito.Mockito.*;




@RunWith(SpringJUnit4ClassRunner.class)
public class SessionServiceImplTest {
	
	
	
	
	@Test
	public void testListAll () {
		
		List<Session> SessionsListMockito = Arrays.asList(new Session(),new Session());
		
		SessionRepository mockito = mock(SessionRepository.class);
		
		when(mockito.findAll()).thenReturn(SessionsListMockito);
		
		SessionServiceImpl usr = new SessionServiceImpl(mockito);
		
		List<Session> SessionsList = Arrays.asList();
		
		SessionsList = usr.listAll();
		
		//verify
		
		assertThat(SessionsList,is(SessionsListMockito));
		
	}
	
	@Test
	public void testGetById() {
		
		Session SessionMockito = new Session();
		
		SessionMockito.setId("1");
		
		SessionRepository mockito = mock(SessionRepository.class);
		
		when(mockito.findOne("1")).thenReturn(SessionMockito);
		
		SessionServiceImpl usr = new SessionServiceImpl(mockito);
		
		Session Session = usr.getById("1");
		
		//verify
		
		assertThat(Session,is(SessionMockito));
		
	}
	
	@Test
	public void testSaveOrUpdate() {
		
		Session SessionMockito = new Session();
		
		SessionRepository mockito = mock(SessionRepository.class);
		
		when(mockito.save(SessionMockito)).thenReturn(SessionMockito);
		
		SessionServiceImpl usr = new SessionServiceImpl(mockito);
		
		Session Session = new Session();
		
		Session = usr.saveOrUpdate(SessionMockito);
		
		//verify
		
		assertThat(Session,is(SessionMockito));
		
	}

	
	
	
}
	
