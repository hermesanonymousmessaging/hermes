package domain;

import java.util.Comparator;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class Log {
	@Id
    public String id;
    
	private Date timestamp;
	private String text;
	
	//This allows sorting Messages by time stamps
	public static Comparator<Message> COMPARE_BY_TIMESTAMP = new Comparator<Message>() {
        public int compare(Message one, Message other) {
            return one.getTimestamp().compareTo(other.getTimestamp());
        }
    };
    
	public Log() {
		this.timestamp = new Date();
	}
	
	public Log(String text) {
		this.timestamp = new Date();
		this.text = text;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
