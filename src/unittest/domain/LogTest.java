package domain;

import java.util.Date;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;

import domain.Log;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class LogTest {
	@Rule
    public ExpectedException exception = ExpectedException.none();
	
	private static Log testLog;
	private static Log testLog2;
	private static String id = "0123456789";
	private static Date timestamp = new Date();
	private static String text = "This is a test log";
	
	@BeforeClass
    public static void setUpBeforeClass() {
        testLog = new Log();
        testLog.setId(id);
        testLog.setTimestamp(timestamp);
        testLog.setText(text);
        
        testLog2 = new Log(text);
    }
	
	@Test
	public void testgetId() {
		Assert.assertEquals(id,testLog.getId());
	}
	
	@Test
	public void testgetTimestamp() {
		Assert.assertEquals(timestamp,testLog.getTimestamp());
	}
	
	@Test
	public void testgetText() {
		Assert.assertEquals(text,testLog.getText());
	}
	
	@Test
	public void testgetTex2t() {
		Assert.assertEquals(text,testLog2.getText());
	}
	
}