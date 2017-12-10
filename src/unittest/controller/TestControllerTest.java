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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import controllers.HomeController;
import controllers.TestController;
import services.ChannelService;
import services.LogService;
import services.UserService;

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
	private UserService userService;
	
	@Mock
	private ChannelService channelService;
	
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
	
	/*@Test
    public void testChannelView() throws Exception {
		String name ="kagan";
        this.mockMvc.perform(post("/test/channelView/{name}").param(name, "name"))
        		.andExpect(status().isOk());
        		//.andExpect(view().name("about"))
                //.andExpect(forwardedUrl("/WEB-INF/view/about.jsp"));
     
    }*/
}