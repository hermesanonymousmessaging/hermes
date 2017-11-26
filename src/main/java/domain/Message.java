package domain;

import java.util.Comparator;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class Message {
	@Id
    public String id;
    
	private Date timestamp;
	private Integer type;
	private String text;
	private String senderId;
	private String channelId;
	
	public static Comparator<Message> COMPARE_BY_TIMESTAMP = new Comparator<Message>() {
        public int compare(Message one, Message other) {
            return one.getTimestamp().compareTo(other.getTimestamp());
        }
    };
    
	public Message() {
		this.timestamp = new Date();
	}
	
	public Message(String text) {
		this.timestamp = new Date();
		this.text = text;
	}
	
	public Message(Integer type, String text, String senderId, String channelId) {
		this.timestamp = new Date();
		this.type = type;
		this.text = text;
		this.senderId = senderId;
		this.channelId = channelId;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	
	
}
