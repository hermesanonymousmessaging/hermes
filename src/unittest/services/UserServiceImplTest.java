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

import domain.User;
import repositories.UserRepository;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.mockito.Mockito.*;




@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {
	
	
	
	
	@Test
	public void testListAll () {
		
		List<User> UsersListMockito = Arrays.asList(new User(),new User());
		
		UserRepository mockito = mock(UserRepository.class);
		
		when(mockito.findAll()).thenReturn(UsersListMockito);
		
		UserServiceImpl usr = new UserServiceImpl(mockito);
		
		List<User> UsersList = Arrays.asList();
		
		UsersList = usr.listAll();
		
		//verify
		
		assertThat(UsersList,is(UsersListMockito));
		
	}
	
	@Test
	public void testGetById() {
		
		User UserMockito = new User();
		
		UserMockito.setId("1");
		
		UserRepository mockito = mock(UserRepository.class);
		
		when(mockito.findOne("1")).thenReturn(UserMockito);
		
		UserServiceImpl usr = new UserServiceImpl(mockito);
		
		User User = usr.getById("1");
		
		//verify
		
		assertThat(User,is(UserMockito));
		
	}
	
	@Test
	public void testSaveOrUpdate() {
		
		User UserMockito = new User();
		
		UserRepository mockito = mock(UserRepository.class);
		
		when(mockito.save(UserMockito)).thenReturn(UserMockito);
		
		UserServiceImpl usr = new UserServiceImpl(mockito);
		
		User User = new User();
		
		User = usr.saveOrUpdate(UserMockito);
		
		//verify
		
		assertThat(User,is(UserMockito));
		
	}
	
	@Test
	public void testDelete() {
		
		//User UserMockito = new User();
		
		UserRepository mockito = mock(UserRepository.class);
		
		UserServiceImpl usr = new UserServiceImpl(mockito);
		
		usr.delete("");
		
		//when(mockito.save(UserMockito)).thenReturn(UserMockito);
		
		verify(mockito,times(1)).delete("");
		
		//UserServiceImpl usr = new UserServiceImpl(mockito);
		
		//User User = new User();
		
		//usr.delete(UserMockito);
		
		//verify
		
		//assertThat(User,is(UserMockito));
		
	}

	
	
	
}
	
