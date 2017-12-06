package domain;

import org.springframework.data.annotation.Id;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Session {
	@Id
	private String id;

	private Date startDate;
	private Date endDate;
	private String channelId;
	private Boolean active;
	
	public Session() {
		this.active = false;
	}
	public Session(String channelId, String dateRange) throws ParseException {
		this.channelId = channelId;
		this.active = false;
		String[] dates = dateRange.split(" - ");
		DateFormat f1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		this.startDate = f1.parse(dates[0]); 
		this.endDate = f1.parse(dates[1]);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
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
