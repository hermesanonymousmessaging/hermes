package domain;

import org.springframework.data.annotation.Id;


public class FavMessages {

    @Id
    public String id;
    
    private String userId;
    private String messageId;

    public FavMessages() {
    }

    public FavMessages(String userId, String messageId) {
        this.userId = userId;
        this.messageId = messageId;
    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String channelId) {
		this.messageId = channelId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}