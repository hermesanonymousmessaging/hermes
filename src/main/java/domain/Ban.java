package domain;

import java.util.Date;

import org.springframework.data.annotation.Id;


public class Ban {

    @Id
    public String id;
    
    private String userId;
    private String channelId;
    private Date timestamp;

    public Ban() {
    		this.timestamp = new Date();
    }

    public Ban(String userId, String channelId) {
        this.userId = userId;
        this.channelId = channelId;
        this.timestamp = new Date();
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, userId='%s', channelId='%s']",
                id, userId, channelId);
    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}