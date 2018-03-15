package domain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.google.common.hash.Hashing;


public class Notification implements Comparable<Notification>{
	
    @Id
    public String id;
    
    private Boolean message;
    private Boolean invite;
    private Boolean join;
    private Boolean approved;
    private Boolean banned;
    private Boolean kicked;
    
    private String channelName;
    
    private String channelId;
    private String recipientId; // recipient that gets notified
    
    private Integer messageCount;
    
    private Date timestamp;
    
    public Notification(String recipientId, String channelId) {
    	this.timestamp = new Date();
    	this.message = false;
    	this.invite = false;
    	this.join = false;
    	this.approved = false;
    	this.banned = false;
    	this.kicked = false;
    	messageCount = 0;
    	this.channelId = channelId;
    	this.recipientId = recipientId;
    	this.channelName = "";
    }
    
    public String toString() {
    	String text = "";
    	if(this.message) {
    		text = messageCount.toString() + " new message from the channel: " + this.channelName;
    	}
    	else if(this.invite) {
    		text = "You have been invited to channel: " + this.channelName;
    	}
    	else if(this.join) {
    		text = "Join request for channel: " + this.channelName;
    	}
    	else if(this.approved) {
    		text = "You have joined to channel: " + this.channelName;
    	}
    	else if(this.banned) {
    		text = "You have been banned from channel: " + this.channelName;    		
    	}
    	else if(this.kicked) {
    		text = "You have been kicked from channel: " + this.channelName;  
    	}
    	
    	return text;
    	
    }

	public Boolean isMessage() {
		return message;
	}

	public void setMessage(Boolean message) {
		this.message = message;
	}

	public Boolean isInvite() {
		return invite;
	}

	public void setInvite(Boolean invite) {
		this.invite = invite;
	}

	public Boolean isJoin() {
		return join;
	}

	public void setJoin(Boolean join) {
		this.join = join;
	}

	public Boolean isApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public Boolean isBanned() {
		return banned;
	}

	public void setBanned(Boolean banned) {
		this.banned = banned;
	}

	public Boolean isKicked() {
		return kicked;
	}

	public void setKicked(Boolean kicked) {
		this.kicked = kicked;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getId() {
		return id;
	}
	
	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	@Override
	public int compareTo(Notification other) {
        return this.timestamp.compareTo(other.timestamp);
	}
    
    
    
	
	
}