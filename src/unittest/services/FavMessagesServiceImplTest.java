package services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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

import domain.FavMessages;
import repositories.FavMessagesRepository;
import repositories.MessageRepository;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.mockito.Mockito.*;




@RunWith(SpringJUnit4ClassRunner.class)
public class FavMessagesServiceImplTest {
	
	
	
	
	@Test
	public void testListAll () {
		
		List<FavMessages> favMessagesListMockito = Arrays.asList(new FavMessages("5a2c25c053161f2668a31d9d","5a2c25d353161f2668a31da4"),new FavMessages("5a2d3d0953161f173ccac7d2","5a2c25d353161f2668a31da4"));
		
		FavMessagesRepository mockito = mock(FavMessagesRepository.class);
		
		when(mockito.findAll()).thenReturn(favMessagesListMockito);
		
		FavMessagesServiceImpl fav = new FavMessagesServiceImpl(mockito);
		
		List<FavMessages> favMessagesList = Arrays.asList();
		
		favMessagesList = fav.listAll();
		
		//verify
		
		assertThat(favMessagesList,is(favMessagesListMockito));
		
	}
	
	@Test
	public void testGetById() {
		
		FavMessages FavMessagesMockito = new FavMessages("5a2c25c053161f2668a31d9d","5a2c25d353161f2668a31da4");
		
		FavMessagesMockito.setId("1");
		
		FavMessagesRepository mockito = mock(FavMessagesRepository.class);
		
		when(mockito.findOne("1")).thenReturn(FavMessagesMockito);
		
		FavMessagesServiceImpl fav = new FavMessagesServiceImpl(mockito);
		
		FavMessages FavMessages = fav.getById("1");
		
		//verify
		
		assertThat(FavMessages,is(FavMessagesMockito));
		
	}
	
	@Test
	public void testGetUserId() {
		
		List<FavMessages> favMessagesListMockito = Arrays.asList(new FavMessages("5a2c25c053161f2668a31d9d","5a2c25d353161f2668a31da4"),new FavMessages("5a2d3d0953161f173ccac7d2","5a2c25d353161f2668a31da4"));
		
		FavMessagesRepository mockito = mock(FavMessagesRepository.class);
		
		when(mockito.findByUserId("5a2c25c053161f2668a31d9d")).thenReturn(favMessagesListMockito);
		
		FavMessagesServiceImpl fav = new FavMessagesServiceImpl(mockito);
		
		List<FavMessages> FavMessagesList = Arrays.asList();
		
		FavMessagesList = fav.getByUserId("5a2c25c053161f2668a31d9d");
		
		//verify
		
		assertThat(FavMessagesList,is(favMessagesListMockito));
		
	}
	
	@Test
	public void testSaveOrUpdate() {
		
		FavMessages FavMessagesMockito = new FavMessages("5a2c25c053161f2668a31d9d","5a2c25d353161f2668a31da4");
		
		FavMessagesRepository mockito = mock(FavMessagesRepository.class);
		
		when(mockito.save(FavMessagesMockito)).thenReturn(FavMessagesMockito);
		
		FavMessagesServiceImpl fav = new FavMessagesServiceImpl(mockito);
		
		FavMessages FavMessages = new FavMessages();
		
		FavMessages = fav.saveOrUpdate(FavMessagesMockito);
		
		//verify
		
		assertThat(FavMessages,is(FavMessagesMockito));
		
	}
	
	@Test
	public void testDelete() {
		
		FavMessagesRepository mockito = mock(FavMessagesRepository.class);
		
		FavMessagesServiceImpl favmes = new FavMessagesServiceImpl(mockito);
		
		favmes.delete("");
		
		//verify
		
		verify(mockito,times(1)).delete("");
		
	}
	
	
	
	
}
	
