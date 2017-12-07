package domain;

import java.util.Comparator;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class Log {
	@Id
    public String id;
    
	private Date timestamp;
	private String text;
	
	//This allows sorting Messages by time stamps
	public static Comparator<Message> COMPARE_BY_TIMESTAMP = new Comparator<Message>() {
        public int compare(Message one, Message other) {
            return one.getTimestamp().compareTo(other.getTimestamp());
        }
    };
    
	public Log() {
		this.timestamp = new Date();
	}
	
	public Log(String text) {
		this.timestamp = new Date();
		this.text = text;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getTimestampD() {
		return timestamp;
	}
	public String getTimestamp() {
		String hour,min,day,month;
		if(timestamp.getDate() < 10) {
			day = "0"+Integer.toString(timestamp.getDate());
		}else {
			day = Integer.toString(timestamp.getDate());
		}
		if(timestamp.getHours() < 10) {
			hour = "0"+Integer.toString(timestamp.getHours());
		}else {
			hour = Integer.toString(timestamp.getHours());
		}
		if(timestamp.getMinutes() < 10) {
			min = "0"+Integer.toString(timestamp.getMinutes());
		}else {
			min = Integer.toString(timestamp.getMinutes());
		}
		if(timestamp.getMonth() < 10) {
			month = "0"+Integer.toString(timestamp.getMonth());
		}else {
			month = Integer.toString(timestamp.getMonth());
		}
		String year = Integer.toString(timestamp.getYear()+1900);
		String date = hour + ":" + min + "  " + day + "/" + month + "/" + year;
		return date;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
