
package domain;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.catalina.Session;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;

import domain.User;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {
	@Rule
    public ExpectedException exception = ExpectedException.none();
	
	private static User Usertest;
	private static User Usertest2;
	private static User Usertest3;
    private static String username = "bedri";
    private static String firstName= "berk";
    private static String lastName= "dehri";
    private static String password= "150694"; //CHANGE THIS 
    private static String email= "bdehri@yahoo.com";
    private static String phoneNumber= "00905376525265";
    private static String photoUrl = "url";
    private static List<String> list ;


    
	@BeforeClass
    public static void setUpBeforeClass() throws ParseException {
		Usertest = new User();
		Usertest.setId("123");
		Usertest.setUsername(username);
		Usertest.setFirstName(firstName);
		Usertest.setLastName(lastName);
		Usertest.setEmail(email);
		Usertest.setPhoneNumber(phoneNumber);
		Usertest.setPassword(password);
		Usertest.addChannel("123");
		Usertest.addChannel("124");
		Usertest.setProfilePicture(photoUrl);
		Usertest.removeChannel("123");
		Usertest2 = new User(firstName,lastName);
		Usertest3 = new User(firstName,lastName, email, password, username, phoneNumber,photoUrl);		
	}
	
	
	@Test
	public void testgetUsername() throws ParseException {
		Assert.assertEquals(username,Usertest.getUsername());
	}
	
	@Test
	public void testgetFirstname() throws ParseException {
		Assert.assertEquals(firstName,Usertest.getFirstName());
	}
	
	@Test
	public void testgetLastname() throws ParseException {
		Assert.assertEquals(lastName,Usertest.getLastName());
	}
	
	@Test
	public void testgetEmail() throws ParseException {
		Assert.assertEquals(email,Usertest.getEmail());
	}
	
	@Test
	public void testgetPhonenumber() throws ParseException {
		Assert.assertEquals(phoneNumber,Usertest.getPhoneNumber());
	}
	
	@Test
	public void testgetPassword() throws ParseException {
		Assert.assertEquals(password,Usertest.getPassword());
	}
	
	@Test
	public void testgetId() throws ParseException {
		Assert.assertEquals("123",Usertest.getId());
	}
	
	@Test
	public void testgetFirstname2() throws ParseException {
		Assert.assertEquals(firstName,Usertest2.getFirstName());
	}
	
	@Test
	public void testgetLastname2() throws ParseException {
		Assert.assertEquals(lastName,Usertest2.getLastName());
	}
	
	
	@Test
	public void testConstructor() throws ParseException{
		Assert.assertEquals(firstName,Usertest3.getFirstName());
		Assert.assertEquals(lastName,Usertest3.getLastName());
		Assert.assertEquals(username,Usertest3.getUsername());
		Assert.assertEquals(password,Usertest3.getPassword());
		Assert.assertEquals(phoneNumber,Usertest3.getPhoneNumber());
		Assert.assertEquals(photoUrl,Usertest3.getProfilePicture());
	}
	
	
	

	
}