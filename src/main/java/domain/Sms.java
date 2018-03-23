package domain;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
public class Sms {
	public static final String ACCOUNT_SID = "AC011f76cbba8c08d57ef4876e2bcd5e63";
	public static final String AUTH_TOKEN = "84fa02ca84b83c1386e4d5a060e7aa0b";
	public  void SendSms(String from,String to,String message) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message HermesSmsService = Message.creator(new PhoneNumber(from),
		        new PhoneNumber(to), message).create();
		System.out.println(HermesSmsService.getSid());
	}
}
