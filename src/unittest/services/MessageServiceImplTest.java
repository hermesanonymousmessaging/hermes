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

import org.apache.catalina.Session;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;

import domain.Message;
import repositories.MessageRepository;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.mockito.Mockito.*;




@RunWith(SpringJUnit4ClassRunner.class)
public class MessageServiceImplTest {
	
	
	
	
	@Test
	public void testListAll () {
		
		List<Message> MessagesListMockito = Arrays.asList(new Message(),new Message());
		
		MessageRepository mockito = mock(MessageRepository.class);
		
		when(mockito.findAll()).thenReturn(MessagesListMockito);
		
		MessageServiceImpl mes = new MessageServiceImpl(mockito);
		
		List<Message> mesMessagesList = Arrays.asList();
		
		mesMessagesList = mes.listAll();
		
		//verify
		
		assertThat(mesMessagesList,is(MessagesListMockito));
		
	}
	
	@Test
	public void testGetById() {
		
		Message MessageMockito = new Message();
		
		MessageMockito.setId("1");
		
		MessageRepository mockito = mock(MessageRepository.class);
		
		when(mockito.findOne("1")).thenReturn(MessageMockito);
		
		MessageServiceImpl mes = new MessageServiceImpl(mockito);
		
		Message Message = mes.getById("1");
		
		//verify
		
		assertThat(Message,is(MessageMockito));
		
	}
	
	@Test
	public void testSaveOrUpdate() {
		
		Message MessageMockito = new Message();
		
		MessageRepository mockito = mock(MessageRepository.class);
		
		when(mockito.save(MessageMockito)).thenReturn(MessageMockito);
		
		MessageServiceImpl mes = new MessageServiceImpl(mockito);
		
		Message Message = new Message();
		
		Message = mes.saveOrUpdate(MessageMockito);
		
		//verify
		
		assertThat(Message,is(MessageMockito));
		
	}

	
	
	
}
	
