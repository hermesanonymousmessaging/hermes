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
    public String id = "123";
    private static String userId = "bedri";
    private static String channelId = "5a3b";
    private Date timestamp;
    
	@BeforeClass
    public static void setUpBeforeClass() throws ParseException {
        Bantest = new Ban(userId,channelId); 
    }
	
	
	@Test
	public void testgetChannelId() throws ParseException {
		Assert.assertEquals(channelId,Bantest.getChannelId());
	}
	
	@Test
	public void testgetUserId() throws ParseException {
		Assert.assertEquals(userId,Bantest.getUserId());
	}
	
}