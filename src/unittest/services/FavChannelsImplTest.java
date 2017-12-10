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

import domain.FavChannels;
import repositories.FavChannelsRepository;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.mockito.Mockito.*;




@RunWith(SpringJUnit4ClassRunner.class)
public class FavChannelsImplTest {
	
	
	
	
	@Test
	public void testListAll () {
		
		List<FavChannels> favChannelsListMockito = Arrays.asList(new FavChannels("5a2c25c053161f2668a31d9d","5a2c25d353161f2668a31da4"),new FavChannels("5a2d3d0953161f173ccac7d2","5a2c25d353161f2668a31da4"));
		
		FavChannelsRepository mockito = mock(FavChannelsRepository.class);
		
		when(mockito.findAll()).thenReturn(favChannelsListMockito);
		
		FavChannelsServiceImpl fav = new FavChannelsServiceImpl(mockito);
		
		List<FavChannels> favChannelsList = Arrays.asList();
		
		favChannelsList = fav.listAll();
		
		//verify
		
		assertThat(favChannelsList,is(favChannelsListMockito));
		
	}
	
	@Test
	public void testGetById() {
		
		FavChannels FavChannelsMockito = new FavChannels("5a2c25c053161f2668a31d9d","5a2c25d353161f2668a31da4");
		
		FavChannelsMockito.setUserId("1");
		
		FavChannelsRepository mockito = mock(FavChannelsRepository.class);
		
		when(mockito.findOne("1")).thenReturn(FavChannelsMockito);
		
		FavChannelsServiceImpl fav = new FavChannelsServiceImpl(mockito);
		
		FavChannels FavChannels = fav.getById("1");
		
		//verify
		
		assertThat(FavChannels,is(FavChannelsMockito));
		
	}
	
	@Test
	public void testGetUserId() {
		
		List<FavChannels> favChannelsListMockito = Arrays.asList(new FavChannels("5a2c25c053161f2668a31d9d","5a2c25d353161f2668a31da4"),new FavChannels("5a2d3d0953161f173ccac7d2","5a2c25d353161f2668a31da4"));
		
		FavChannelsRepository mockito = mock(FavChannelsRepository.class);
		
		when(mockito.findByUserId("5a2c25c053161f2668a31d9d")).thenReturn(favChannelsListMockito);
		
		FavChannelsServiceImpl fav = new FavChannelsServiceImpl(mockito);
		
		List<FavChannels> FavChannelsList = Arrays.asList();
		
		FavChannelsList = fav.getByUserId("5a2c25c053161f2668a31d9d");
		
		//verify
		
		assertThat(FavChannelsList,is(favChannelsListMockito));
		
	}
	
	@Test
	public void testSaveOrUpdate() {
		
		FavChannels FavChannelsMockito = new FavChannels("5a2c25c053161f2668a31d9d","5a2c25d353161f2668a31da4");
		
		FavChannelsRepository mockito = mock(FavChannelsRepository.class);
		
		when(mockito.save(FavChannelsMockito)).thenReturn(FavChannelsMockito);
		
		FavChannelsServiceImpl fav = new FavChannelsServiceImpl(mockito);
		
		FavChannels FavChannels = new FavChannels();
		
		FavChannels = fav.saveOrUpdate(FavChannelsMockito);
		
		//verify
		
		assertThat(FavChannels,is(FavChannelsMockito));
		
	}
	
	
	
	
}
	
