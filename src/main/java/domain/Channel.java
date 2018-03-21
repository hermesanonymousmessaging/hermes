package domain;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import org.springframework.boot.json.JacksonJsonParser;
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
	private String type;
	private Boolean friendly;
	private ArrayList<String> animalNames;
	private Integer friendlyNamesGeneration;
	private HashMap<String, String> friendlyNames;
	
	public Channel() {
		this.friendly = false;
		this.sms = false;
		this.email = false;
		this.members = new HashSet<String>();
		this.sessions = new HashSet<String>();
		this.animalNames = new ArrayList<String>();
		this.friendlyNames = new HashMap<String,String>();
		this.friendlyNamesGeneration = 0;
		this.userCount = 0;
	}
	
	public Boolean isFriendly() {
		return friendly;
	}
	
	public Boolean getFriendly() {
		return friendly;
	}

	public void setFriendly(Boolean friendly) throws FileNotFoundException {
		this.friendly = friendly;
		if(this.friendly) {
			String filePath = new File("").getAbsolutePath();
			System.out.println (filePath);
			Scanner s = new Scanner(new File(filePath + "/src/main/webapp/resources/animalnames.txt"));
			while (s.hasNext()){
				this.animalNames.add(s.next());
			}
			s.close();
			Collections.shuffle(this.animalNames);
		}
	}

	public boolean isPublic() {
		return this.type.equals("public");
	}
	
	public boolean isPrivate() {
		return this.type.equals("private");
	}
	
	public boolean isHidden() {
		return this.type.equals("hidden");
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
	public void setOwnerId(String ownerId) throws FileNotFoundException {
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
	public HashMap<String, String> getFriendlyNames() {
		return friendlyNames;
	}
	public void setFriendlyNames(HashMap<String, String> friendlyNames) {
		this.friendlyNames = friendlyNames;
	}

	public void setAnimalNames(ArrayList<String> animalNames) {
		this.animalNames = animalNames;
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
	public void addMember(String userId) throws FileNotFoundException {
		if(this.animalNames.isEmpty() && this.isFriendly()) {
			this.setFriendly(true);
			//create new namelist
			this.friendlyNamesGeneration++;
		}
		
		if(this.friendly) {
			String filePath = new File("").getAbsolutePath();
			Scanner s = new Scanner(new File(filePath + "/src/main/webapp/resources/adjectives.txt"));
			ArrayList<String> adj = new ArrayList<String>();
			while (s.hasNext()){
				adj.add(s.next());
			}
			s.close();
			Random r = new Random();
			int rand = r.nextInt(adj.size());
			String adjective = adj.get(rand);
			
			String newname = adjective + " " + this.animalNames.get(userCount);
			animalNames.remove(userCount);
			
			if(this.friendlyNamesGeneration > 0)
				newname += " " + this.friendlyNamesGeneration.toString();
			
			this.friendlyNames.put(userId, newname);
			System.out.println(userId);
			System.out.println("AHA");
			System.out.println(newname);
		}
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

	public Integer getFriendlyNamesGeneration() {
		return friendlyNamesGeneration;
	}

	public void setFriendlyNamesGeneration(Integer friendlyNamesGeneration) {
		this.friendlyNamesGeneration = friendlyNamesGeneration;
	}

	public ArrayList<String> getAnimalNames() {
		return animalNames;
	}
	

	
	
	
}
