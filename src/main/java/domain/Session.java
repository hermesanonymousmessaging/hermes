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
		DateFormat f1 = new SimpleDateFormat("MM/dd/yyyy HH:mm");
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
	public String getStartDate() {
		String hour,min,day,month;
		if(startDate.getDate() < 10) {
			day = "0"+Integer.toString(startDate.getDate());
		}else {
			day = Integer.toString(startDate.getDate());
		}
		if(startDate.getHours() < 10) {
			hour = "0"+Integer.toString(startDate.getHours());
		}else {
			hour = Integer.toString(startDate.getHours());
		}
		if(startDate.getMinutes() < 10) {
			min = "0"+Integer.toString(startDate.getMinutes());
		}else {
			min = Integer.toString(startDate.getMinutes());
		}
		if(startDate.getMonth() < 10) {
			month = "0"+Integer.toString(startDate.getMonth());
		}else {
			month = Integer.toString(startDate.getMonth());
		}
		String year = Integer.toString(startDate.getYear()+1900);
		String date = hour + ":" + min + "  " + day + "/" + month + "/" + year;
		return date;
	}
	public String getStartDateD() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format1.format(startDate);
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		String hour,min,day,month;
		if(endDate.getDate() < 10) {
			day = "0"+Integer.toString(endDate.getDate());
		}else {
			day = Integer.toString(endDate.getDate());
		}
		if(endDate.getHours() < 10) {
			hour = "0"+Integer.toString(endDate.getHours());
		}else {
			hour = Integer.toString(endDate.getHours());
		}
		if(endDate.getMinutes() < 10) {
			min = "0"+Integer.toString(endDate.getMinutes());
		}else {
			min = Integer.toString(endDate.getMinutes());
		}
		if(endDate.getMonth() < 10) {
			month = "0"+Integer.toString(endDate.getMonth());
		}else {
			month = Integer.toString(endDate.getMonth());
		}
		String year = Integer.toString(endDate.getYear()+1900);
		String date = hour + ":" + min + "  " + day + "/" + month + "/" + year;
		return date;
	}
	public String getEndDateD() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format1.format(endDate);
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
