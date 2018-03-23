package domain;

import org.springframework.data.annotation.Id;


public class FavMessages {

    @Id
    public String id;
    
    private String userId;
    private String messageId;
    private String channelId;
    private String channelName;
    private String userName;
    private String messageText;

    public FavMessages() {
    }

    public FavMessages(String userId,String userName, String messageId,String channelId,String channelName) {
    	
    	this.channelId = channelId;
    	this.channelName = channelName;
        this.userId = userId;
        this.userName = userName;
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

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	
}