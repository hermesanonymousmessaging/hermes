package domain;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
	private List<String> messages;
	
	public Session() {
		this.active = false;
		messages = new ArrayList<String>();
	}
	public Session(String channelId, String dateRange) throws ParseException {
		this.channelId = channelId;
		this.active = false;
		String[] dates = dateRange.split(" - ");
		DateFormat f1 = new SimpleDateFormat("MM/dd/yyyy HH:mm ");
		this.startDate = f1.parse(dates[0]); 
		this.endDate = f1.parse(dates[1]);
		messages = new ArrayList<String>();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getStartDateD() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format1.format(startDate);
	}
	public Date getStartDate_Date() {
		return this.startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public String getEndDateD() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format1.format(endDate);
	}
	public Date getEndDate_Date() {
		return this.endDate;
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
	public List<String> getMessages() {
		return messages;
	}
	public void addMessage(String messageId) {
		messages.add(messageId);
	}
	
}
