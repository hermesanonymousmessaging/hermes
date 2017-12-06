package domain;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
public class Sms {
	public static final String ACCOUNT_SID = "AC18ad0206b64e080ff89926dd0058c6ba";
	public static final String AUTH_TOKEN = "f55569504240ed664da9695eae638248";
	public  void SendSms(String from,String to,String message) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message HermesSmsService = Message.creator(new PhoneNumber(from),
		        new PhoneNumber(to), message).create();
		System.out.println(HermesSmsService.getSid());
	}
}
