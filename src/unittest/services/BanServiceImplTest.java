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

import domain.Ban;
import repositories.BanRepository;
import repositories.MessageRepository;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.mockito.Mockito.*;




@RunWith(SpringJUnit4ClassRunner.class)
public class BanServiceImplTest {
	
	
	
	
	@Test
	public void testListAll () {
		
		List<Ban> bannedUsersMockito = Arrays.asList(new Ban("5a2c25c053161f2668a31d9d","5a2c25d353161f2668a31da4"),new Ban("5a2d3d0953161f173ccac7d2","5a2c25d353161f2668a31da4"));
		
		BanRepository mockito = mock(BanRepository.class);
		
		when(mockito.findAll()).thenReturn(bannedUsersMockito);
		
		BanServiceImpl ban = new BanServiceImpl(mockito);
		
		List<Ban> bannedUsers = Arrays.asList();
		
		bannedUsers = ban.listAll();
		
		//verify
		
		assertThat(bannedUsers,is(bannedUsersMockito));
		
	}
	
	@Test
	public void testGetById() {
		
		Ban bannedUserMockito = new Ban("5a2c25c053161f2668a31d9d","5a2c25d353161f2668a31da4");
		
		bannedUserMockito.setUserId("1");
		
		BanRepository mockito = mock(BanRepository.class);
		
		when(mockito.findOne("1")).thenReturn(bannedUserMockito);
		
		BanServiceImpl ban = new BanServiceImpl(mockito);
		
		Ban bannedUser = ban.getById("1");
		
		//verify
		
		assertThat(bannedUser,is(bannedUserMockito));
		
	}
	
	@Test
	public void testGetUserId() {
		
		Ban bannedUserMockito = new Ban("5a2c25c053161f2668a31d9d","5a2c25d353161f2668a31da4");
		
		BanRepository mockito = mock(BanRepository.class);
		
		when(mockito.findOne("5a2c25c053161f2668a31d9d")).thenReturn(bannedUserMockito);
		
		BanServiceImpl ban = new BanServiceImpl(mockito);
		
		Ban bannedUser = ban.getByUserId("5a2c25c053161f2668a31d9d");
		
		//verify
		
		assertThat(bannedUser,is(bannedUserMockito));
		
	}
	
	@Test
	public void testSaveOrUpdate() {
		
		Ban bannedUserMockito = new Ban("5a2c25c053161f2668a31d9d","5a2c25d353161f2668a31da4");
		
		BanRepository mockito = mock(BanRepository.class);
		
		when(mockito.save(bannedUserMockito)).thenReturn(bannedUserMockito);
		
		BanServiceImpl ban = new BanServiceImpl(mockito);
		
		Ban bannedUser = new Ban();
		
		bannedUser = ban.saveOrUpdate(bannedUserMockito);
		
		//verify
		
		assertThat(bannedUser,is(bannedUserMockito));
		
	}
	
	@Test
	public void testDelete() {
		
		BanRepository mockito = mock(BanRepository.class);
		
		BanServiceImpl ban = new BanServiceImpl(mockito);
		
		ban.delete("");
		
		//verify
		
		verify(mockito,times(1)).delete("");
		
	}
	
	
	
	
}
	
