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
public class FavChannelsTest {
	
	@Rule
    public ExpectedException exception = ExpectedException.none();
	private static FavChannels favch3;
	private static FavChannels favch4;
	@BeforeClass
    public static void setUpBeforeClass() {
		favch3 = new FavChannels("u3","ch3");
		favch4 = new FavChannels();
		favch3.setId("123");
		
	}
	
	@Test
	public void testFavChannels() {
		FavChannels favch1 = new FavChannels();
		favch1.setchannelId("ch1");
		Assert.assertEquals("ch1", favch1.getchannelId());
	}
	
	@Test
	public void testFavChannels2() {
		FavChannels favch2 = new FavChannels("u1","ch2");
		Assert.assertEquals("u1", favch2.getUserId());
		Assert.assertEquals("ch2", favch2.getchannelId());
	}
	
	@Test
	public void testgetUserId() {
		Assert.assertEquals("u3", favch3.getUserId());
	}
	
	@Test
	public void testsettUserId() {
		favch4.setUserId("u4");
		Assert.assertEquals("u4", favch4.getUserId());
	}
	
	@Test
	public void testgetChannelId() {
		Assert.assertEquals("ch3", favch3.getchannelId());
	}
	
	@Test
	public void testsetChannelId() {
		favch4.setchannelId("ch4");
		Assert.assertEquals("ch4", favch4.getchannelId());
	}
	
	@Test
	public void testgetId() {
		Assert.assertEquals("123", favch3.getId());
	}
	
	@Test
	public void testsetId() {
		favch4.setId("456");
		Assert.assertEquals("456", favch4.getId());
	}
}
