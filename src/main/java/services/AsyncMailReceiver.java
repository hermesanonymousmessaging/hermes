package services;

import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMessage;
import javax.mail.search.FlagTerm;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AsyncMailReceiver {
	
	@Scheduled(fixedDelay=10000)
	public void doSomething() {
	    System.out.println("[*]Mail receiver");
	    String host = "imap.gmail.com";
	    String mailStoreType = "imap";
	    String user = "hermesanonymousmessaging@gmail.com";
	    String password = "hgpturotvshvpxlk";
	    
	    try {
	        Properties properties = new Properties();
	        properties.put("mail.imap.host", host);
	        properties.put("mail.imap.port", "993");
	        properties.put("mail.imap.starttls.enable", "true");
	        Session emailSession = Session.getDefaultInstance(properties);
	    
	        Store store = emailSession.getStore("imaps");

	        store.connect(host, user, password);

	        Folder emailFolder = store.getFolder("INBOX");
	        emailFolder.open(Folder.READ_WRITE);

	        Message[] messages = emailFolder.search(new FlagTerm(new Flags(
                    Flags.Flag.SEEN), false));

            System.out.println("[*]No. of Unread Messages : " + messages.length);
	        

	        for (int i = 0, n = messages.length; i < n; i++) {
	           Message message = messages[i];
	           System.out.println("---------------------------------");
	           System.out.println("Email Number " + (i + 1));
	           System.out.println("Subject: " + message.getSubject());
	           System.out.println("From: " + message.getFrom()[0]);
	           System.out.println("Text: " + message.getContent().toString());
	           MimeMessage source = (MimeMessage) message;
	           MimeMessage copy = new MimeMessage(source);
	        }
	               
	        emailFolder.close(false);
	        store.close();

	        } catch (NoSuchProviderException e) {
	           e.printStackTrace();
	        } catch (MessagingException e) {
	           e.printStackTrace();
	        } catch (Exception e) {
	           e.printStackTrace();
	        }
	}
	
}
