package domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;

import domain.FavMessages;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class FavMessagesTest {
	@Rule
    public ExpectedException exception = ExpectedException.none();
	private static FavMessages favMessages;
	private static FavMessages favMessages2;
	
    private static String id = "123";
    
    private static String userId =  "5a3b";
    private static String messageId = "3r5";
    private static String userName = "dehri";
    private static String channelId = "123";
    private static String channelName = "channel";
	
	@BeforeClass
    public static void setUpBeforeClass() {
		favMessages = new FavMessages();
		favMessages2 = new FavMessages(userId,userName,messageId,channelId,channelName);
		
		
		
		favMessages.setMessageId(messageId);
		favMessages.setId(id);
		favMessages.setUserId(userId);
    }
	
	@Test
	public void testgetId() {
		Assert.assertEquals(id,favMessages.getId());
	}
	
	@Test
	public void testgetUserId() {
		Assert.assertEquals(userId,favMessages.getUserId());
	}
	
	@Test
	public void testgetMessageId() {
		Assert.assertEquals(messageId,favMessages.getMessageId());
	}
	
	@Test
	public void testCostructor() {
		Assert.assertEquals(messageId,favMessages2.getMessageId());
		Assert.assertEquals(userId,favMessages2.getUserId());
	}
}
