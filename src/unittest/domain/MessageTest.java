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
public class MessageTest {
	
	@Rule
    public ExpectedException exception = ExpectedException.none();
	
	private static Message msg1;
	private static Message msg2;
	private static Date d1; 
	
	@BeforeClass
    public static void setUpBeforeClass() {
		msg1 = new Message(1,"hello","kgn","ch1","s01");
		msg2 = new Message(2,"hi","ozgn","ch2","s02");
		d1 = new Date();
		d1.setDate(10);
		d1.setMonth(12);
		d1.setYear(2017);
		d1.setHours(01);
		d1.setMinutes(42);
		msg1.setTimestamp(d1);
		msg2.setId("msg2");
	}
	
	@Test
	public void testMessage() {
		Message msg3 = new Message();
		msg3.setChannelId("ch15");
		Assert.assertEquals("ch15",msg3.getChannelId());
	}
	
	@Test
	public void testMessage2() {
		Message msg4 = new Message("salut");
		Assert.assertEquals("salut",msg4.getText());
	}
	
	@Test
	public void testMessage3() {
		Message msg5 = new Message(20,"aloha","beko","ch98","s06");
		Assert.assertEquals("beko",msg5.getSenderId());
	}
	
	@Test
	public void testgetId() {
		Assert.assertEquals("msg2",msg2.getId());
	}
	
	@Test
	public void testsetId() {
		msg1.setId("msg1");
		Assert.assertEquals("msg1",msg1.getId());
	}
	
	@Test
	public void testgetTimestampD() {
		Assert.assertEquals(1,msg1.getTimestampD().compareTo(d1));
	}
	
	@Test
	public void testsetTimestamp() {
		Date d2 = new Date();
		d2.setDate(11);
		d2.setMonth(12);
		d2.setHours(02);
		d2.setMinutes(45);
		d2.setYear(2017);
		msg1.setTimestamp(d2);
		Assert.assertEquals(d2,msg1.getTimestampD());
	}
	
	@Test
	public void testgetType() {
		Assert.assertEquals((Integer)1,msg1.getType());
	}
	
	@Test
	public void testsetType() {
		Integer i = new Integer(95);
		msg1.setType(i);
		Assert.assertEquals(i,msg1.getType());
	}
	
	@Test
	public void testgetText() {
		Assert.assertEquals("hello",msg1.getText());
	}
	
	@Test
	public void testsetText() {
		String txt = "selam";
		msg1.setText(txt);
		Assert.assertEquals(txt,msg1.getText());
	}
	
	@Test
	public void testgetSenderId() {
		Assert.assertEquals("kgn",msg1.getSenderId());
	}
	
	@Test
	public void testsetSenderId() {
		Message msg9 = new Message();
		String id = "kagan";
		msg9.setSenderId(id);
		Assert.assertEquals(id,msg9.getSenderId());
	}
	
	@Test
	public void testgetChannelId() {
		Assert.assertEquals("ch1",msg1.getChannelId());
	}
	
	@Test
	public void testsetChannelId() {
		String ch = "ch1995";
		msg1.setChannelId(ch);
		Assert.assertEquals(ch,msg1.getChannelId());
	}
	
	@Test
	public void testgetSessionId() {
		Assert.assertEquals("s01",msg1.getSessionId());
	}
	
	@Test
	public void testsetSessionId() {
		Message msg10 = new Message();
		String sid = "s007";
		msg10.setSessionId(sid);
		Assert.assertEquals(sid,msg10.getSessionId());
	}
	
	@Test
	public void testsetFavoutite() {
		msg1.setFavourite(true);
		Assert.assertEquals(true,msg1.isFavourite());
	}
	
	
	@Test
	public void testcompare() {
		Assert.assertTrue(msg1.COMPARE_BY_TIMESTAMP.compare(msg1, msg2) > 0);
	}

}
