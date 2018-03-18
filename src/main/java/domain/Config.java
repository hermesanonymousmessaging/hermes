package domain;


import org.springframework.data.annotation.Id;


public class Config {

    @Id
    public String id;
    
    private String name;
    
    private Integer friendlyChannelNum;

    public Config() {
    	this.name = "hermes";
    	this.friendlyChannelNum = 0;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFriendlyChannelNum() {
		return friendlyChannelNum;
	}

	public void setFriendlyChannelNum(Integer friendlyChannelNum) {
		this.friendlyChannelNum = friendlyChannelNum;
	}

	public String getId() {
		return id;
	}
	
}