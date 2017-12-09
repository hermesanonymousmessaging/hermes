package domain;

import org.springframework.data.annotation.Id;


public class FavChannels {

    @Id
    public String id;
    
    private String userId;
    private String channelId;

    public FavChannels() {
    }

    public FavChannels(String userId, String channelId) {
        this.userId = userId;
        this.channelId = channelId;
    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getchannelId() {
		return channelId;
	}

	public void setchannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}