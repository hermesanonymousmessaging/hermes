package domain;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;

import domain.Session;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
public class SessionTest {
	@Rule
    public ExpectedException exception = ExpectedException.none();
	
	private static Session Sessiontest;
	private static String id = "dwqdasdasd";
	private static String date = "Thu Jun 18 20:56:02 EDT 2009";
	private static SimpleDateFormat f1 = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");;
	private static String channelId = "channelid879461";
	private static Boolean active = false;
	private static String message1 = "hi";
	private static String message2 = "salut";
	private static String message3 = "aloha";
	private static List<String> messages = new ArrayList<String>();
	private static Date d1;
	
	@BeforeClass
    public static void setUpBeforeClass() throws ParseException {
        Sessiontest = new Session();
        Sessiontest.setId(id);
        Sessiontest.setChannelId(channelId);
        Sessiontest.setActive();
        messages.add(message1);
        messages.add(message2);
        messages.add(message3);
        Sessiontest.addMessage(message1);
        Sessiontest.addMessage(message2);
        Sessiontest.addMessage(message3);
        
        
    }
	
	
	@Test
	public void testgetId() {
		Assert.assertEquals(id,Sessiontest.getId());
	}
	
	@Test
	public void testgetChannelId() throws ParseException {
		Assert.assertEquals(channelId,Sessiontest.getChannelId());
	}
	
	@Test
	public void testisActive() throws ParseException {
		Assert.assertEquals(false,Sessiontest.isActive());
	}
	@Test
	public void testgetActive() throws ParseException {
		Assert.assertEquals(true,Sessiontest.getActive());
	}
	@Test
	public void testgetMessages() throws ParseException {
		Assert.assertEquals(messages,Sessiontest.getMessages());
	}
	@Test
	public void testdisable() throws ParseException {
		Sessiontest.disable();
		Assert.assertEquals(false,Sessiontest.isActive());
	}
	
}
