package domain;

import org.springframework.data.annotation.Id;

public class Session {
	@Id
	private String id;

	private String startDate;
	private String endDate;
	private String channelId;
	private Boolean active;
	
	public Session() {
		this.active = false;
	}
	public Session(String channelId, String startDate, String endDate) {
		this.channelId = channelId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.active = false;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive() {
		this.active = true;
	}
	public Boolean isActive() {
		return active;
	}
	public void disable() {
		this.active = false;
	}
	
}
