package controller;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import controllers.HomeController;
import controllers.TestController;
import services.ChannelService;
import services.FavChannelsService;
import services.LogService;
import services.UserService;

import domain.User;
import repositories.UserRepository;
import domain.Channel;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestControllerTest {

	@InjectMocks
	private TestController testController;
	
	@Mock
	private LogService logService;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private UserService userService;
	
	@Mock
	private ChannelService channelService;
	
	@Mock
	private FavChannelsService favchannelService;
	
	private MockMvc mockMvc;
	
	String formattedDate;

	@Before
	public void setup() {
		Locale locale = new Locale("en");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		formattedDate = dateFormat.format(date);
		// Process mock annotations
		MockitoAnnotations.initMocks(this);
		
		ModelMap m = new ModelMap();
		
		User u1 = new User();
		User mockLoginUser = new User("berk","dehri","bdehrioglu@yahoo.com","150694","bdehri","05378877769", "dajfahjafs");
		User mockuser = mock(User.class);
		u1.setId("user1");
		
		Channel ch1 = new Channel();
		
        when(userService.getById("user1")).thenReturn(u1);
        when(userRepository.findByUsername("bdehri")).thenReturn(mockLoginUser);
        when(userRepository.findByUsername("berk")).thenReturn(null);
        
		// Setup Spring test in standalone mode
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
		this.mockMvc = MockMvcBuilders.standaloneSetup(testController)
				.setViewResolvers(viewResolver)
				.build();

	}

	@Test
    public void testabout() throws Exception {
        this.mockMvc.perform(get("/test/about"))
        		.andExpect(status().isOk())
        		.andExpect(view().name("about"))
                .andExpect(forwardedUrl("/WEB-INF/view/about.jsp"));
     
    }
	
	@Test
    public void testChannelView() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/test/channelView/{name}",1L))
        		.andExpect(status().isOk())
        		.andExpect(view().name("channelView"))
                .andExpect(forwardedUrl("/WEB-INF/view/channelView.jsp"));
     
    }
	
	@Test
    public void testRegister() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/test/register"))
        		.andExpect(status().isOk())
        		.andExpect(view().name("register"))
                .andExpect(forwardedUrl("/WEB-INF/view/register.jsp"));
     
    }
	
	@Test
    public void testHome() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/test/home"))
        		.andExpect(status().isOk());
        		
    }
	
	@Test
    public void testquery() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/test/search/{query}",1L).param("query", "kagan"))
        		.andExpect(status().is3xxRedirection());
        		
    }
	
	@Test
	public void testLogin() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/test/login").param("username", "bdehri").param("password", "150694"))
		.andExpect(model().attributeExists("login"));
	}
	
	@Test
	public void testFalsePassLogin() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/test/login").param("username", "bdehri").param("password", "1506"))
		.andExpect(view().name("redirect:/test/home"))
		.andExpect(model().attributeDoesNotExist("login"))
		.andExpect(status().is3xxRedirection());
	}
	
	@Test
	public void testNotUserLogin() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/test/login").param("username", "berk").param("password", "1506"))
		.andExpect(view().name("redirect:/test/home"))
		.andExpect(model().attributeDoesNotExist("login"))
		.andExpect(status().is3xxRedirection());
	}
	
	/*@Test
    public void testLogout() throws Exception {
		MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/test/login").param("username", "bdehri").param("password", "150694")).andReturn();
		
        this.mockMvc.perform(MockMvcRequestBuilders.get("/test/logout"))
        		.andExpect(status().is3xxRedirection())
        		.andExpect(view().name("redirect:/test/home"))
        		.andExpect(model().attributeDoesNotExist("login"));
        		
    }*/
	
	/*@Test
    public void testAddFav() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/test/addFavourites"))
        		.andExpect(status().isOk());
        		
    }*/
	
	
}