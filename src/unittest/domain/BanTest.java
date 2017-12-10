package domain;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.catalina.Session;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;

import domain.Ban;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class BanTest {
	@Rule
    public ExpectedException exception = ExpectedException.none();
	
	private static Ban Bantest;
	private static Ban Bantest2;
    public static String id = "123";
    private static String userId = "1234";
    private static String channelId = "5231";
    private Date timestamp;
    
	@BeforeClass
    public static void setUpBeforeClass() throws ParseException {
        Bantest = new Ban(userId,channelId); 
        Bantest2 = new Ban();
        Bantest2.setUserId(userId);
        Bantest2.setId(id);
        Bantest2.setChannelId(channelId);
    }
	
	
	@Test
	public void testgetChannelId() throws ParseException {
		Assert.assertEquals(channelId,Bantest.getChannelId());
	}
	
	@Test
	public void testgetUserId() throws ParseException {
		Assert.assertEquals(userId,Bantest.getUserId());
	}
	
	@Test
	public void testgetId() throws ParseException {
		Assert.assertEquals(id,Bantest2.getId());
	}
	
	@Test
	public void testtoString() throws ParseException {
		Assert.assertEquals("Customer[id=123, userId='1234', channelId='5231']",Bantest2.toString());
	}
	
}