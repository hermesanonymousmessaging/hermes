
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
    private static String username = "bedri";
    private static String firstName= "berk";
    private static String lastName= "dehri";
    private static String password= "150694"; //CHANGE THIS 
    private static String email= "bdehri@yahoo.com";
    private static String phoneNumber= "00905376525265";

    
	@BeforeClass
    public static void setUpBeforeClass() throws ParseException {
		Usertest = new User();
		Usertest.setUsername(username);
		Usertest.setFirstName(firstName);
		Usertest.setLastName(lastName);
		Usertest.setEmail(email);
		Usertest.setPhoneNumber(phoneNumber);
		Usertest.setPassword(password);
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
	
}