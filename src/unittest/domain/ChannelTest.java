package domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;

import domain.Channel;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class ChannelTest {
	@Rule
    public ExpectedException exception = ExpectedException.none();
	
	private static Channel testChannel;
	private static String id = "0123456789";
	private static Boolean sms = false;
	private static Boolean email = false;
	private static String name = "PUBG";
	private static String ownerId = "150130121";
	private static String nonOwnerId = "150130000";
	private static Integer userCount = 1;
	private static Integer userCountWithOwner = 2;
	private static String memberId = "150130121";
	private static String sessionId = "0017";
	private static Set<String> members = new HashSet<String>();
	private static List<String> membersList = new ArrayList<String>();
	private static Set<String> sessions  = new HashSet<String>();
	private static List<String> sessionsList = new ArrayList<String>();
	private static boolean favourite = false;
	private static String type = "public";
	private static Boolean isPublic = true;
	private static Boolean isMember = true;
	private static Boolean isOwner = true;
	private static Boolean isNonOwner = false;
	
	@BeforeClass
    public static void setUpBeforeClass() {
        testChannel = new Channel();
        testChannel.setId(id);
        testChannel.setSms(sms);
        testChannel.setEmail(email);
        testChannel.setName(name);
        testChannel.setOwnerId(ownerId);
        testChannel.setUserCount(userCount);
        members.add(memberId);
        membersList.addAll(members);
        testChannel.addMember(memberId);
        sessions.add(sessionId);
        sessionsList.addAll(sessions);
        testChannel.addSession(sessionId);
        testChannel.setFavourite(favourite);
        testChannel.setType(type);
    }
	
	@Test
	public void testgetId() {
		Assert.assertEquals(id,testChannel.getId());
	}
	
	@Test
	public void testgetSms() {
		Assert.assertEquals(sms,testChannel.getSms());
	}
	
	@Test
	public void testgetEmail() {
		Assert.assertEquals(email,testChannel.getEmail());
	}
	
	@Test
	public void testgetName() {
		Assert.assertEquals(name,testChannel.getName());
	}
	
	@Test
	public void testgetOwnerId() {
		Assert.assertEquals(ownerId,testChannel.getOwnerId());
	}
	
	@Test
	public void testgetUserCount() {
		Assert.assertEquals(userCountWithOwner,testChannel.getUserCount());
	}
	
	@Test
	public void testisOwner() {
		Assert.assertEquals(isOwner,testChannel.isOwner(ownerId));
	}
	
	@Test
	public void testisNonOwner() {
		Assert.assertEquals(isNonOwner,testChannel.isOwner(nonOwnerId));
	}
	
	@Test
	public void testisMember() {
		Assert.assertEquals(isMember,testChannel.isMember(memberId));
	}
	
	@Test
	public void testisFavourite() {
		Assert.assertEquals(favourite,testChannel.isFavourite());
	}
	
	@Test
	public void testgetMembers() {
		Assert.assertEquals(members,testChannel.getMembers());
	}
	
	@Test
	public void testgetMembersList() {
		Assert.assertEquals(membersList,testChannel.getMembersList());
	}
	
	@Test
	public void testgetSessions() {
		Assert.assertEquals(sessions,testChannel.getSessions());
	}
	
	@Test
	public void testgetSessionsList() {
		Assert.assertEquals(sessionsList,testChannel.getSessionsList());
	}
	
	@Test
	public void testisPublic() {
		Assert.assertEquals(isPublic,testChannel.isPublic());
	}
	
	@Test
	public void testgetType() {
		Assert.assertEquals(type,testChannel.getType());
	}
}
