package domain;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Channel {
	@Id
    public String id;
    
	private String type;
	private String name;
	private String ownerId;
	private Integer userCount;
	private HashMap<String, Boolean> members;
	private List<String> sessions;
	
	public Channel() {
		members = new HashMap<String, Boolean>();
		sessions = new ArrayList<String>();
		userCount = 0;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public HashMap<String, Boolean> getMembers() {
		return members;
	}
	public List<String> getSessions() {
		return sessions;
	}
	public void setSessions(List<String> sessions) {
		this.sessions = sessions;
	}
	
	public Boolean isOwner(String id) {
		if(this.ownerId.equals(id))
			return true;
		else
			return false;
	}
	public Boolean isMember(String userId) {
		return members.containsKey(userId);
	}
	public void addMember(String userId) {
		members.put(userId,true);
		userCount++;
	}
	public void removeMember(String userId) {
		members.remove(userId);
	}
	public void addSession(String sessionId) {
		sessions.add(sessionId);
	}
	
	
	
}
