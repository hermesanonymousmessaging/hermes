package domain;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;

public class Channel {
	@Id
    public String id;
    
	private Boolean sms;
	private Boolean email;
	private String name;
	private String ownerId;
	private Integer userCount;
	private Set<String> members;
	private Set<String> sessions;
	private boolean favourite;
	private String type;
	
	public Channel() {
		sms = false;
		email = false;
		members = new HashSet<String>();
		sessions = new HashSet<String>();
		userCount = 0;
		favourite = false;
	}
	
	public Boolean getSms() {
		return sms;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setSms(Boolean sms) {
		this.sms = sms;
	}

	public Boolean getEmail() {
		return email;
	}

	public void setEmail(Boolean email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getUserCount() {
		return userCount;
	}
	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
		addMember(ownerId);
	}
	public Set<String> getMembers() {
		return members;
	}
	public List<String> getMembersList(){
		List<String> myList = new ArrayList<String>();
		myList.addAll(this.members);
		return myList;
	}
	public Set<String> getSessions() {
		return sessions;
	}
	
	public List<String> getSessionsList() {
		List<String> myList = new ArrayList<String>();
		myList.addAll(this.sessions);
		return myList;
	}
	
	public Boolean isOwner(String id) {
		if(this.ownerId.equals(id))
			return true;
		else
			return false;
	}
	public Boolean isMember(String userId) {
		return members.contains(userId);
	}
	public void addMember(String userId) {
		members.add(userId);
		userCount++;
	}
	public void removeMember(String userId) {
		members.remove(userId);
	}
	public void addSession(String sessionId) {
		sessions.add(sessionId);
	}
	public void removeSession(String sessionId) {
		sessions.remove(sessionId);
	}

	public boolean isFavourite() {
		return favourite;
	}

	public void setFavourite(boolean favourite) {
		this.favourite = favourite;
	}
	
	
	
}
