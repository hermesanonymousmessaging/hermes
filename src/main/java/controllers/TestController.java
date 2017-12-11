package controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import domain.Ban;
import domain.Channel;
import domain.Email;
import domain.Log;
import domain.Message;
import domain.Session;
import domain.User;
import domain.Sms;
import domain.FavMessages;
import domain.FavChannels;

import repositories.BanRepository;
import repositories.ChannelRepository;
import repositories.MessageRepository;
import repositories.SessionRepository;
import repositories.UserRepository;
import repositories.FavMessagesRepository;
import repositories.FavChannelsRepository;
import services.AsyncMail;
import services.AsyncSms;
import services.BanService;
import services.ChannelService;
import services.FavChannelsService;
import services.FavMessagesService;
import services.LogService;
import services.MessageService;
import services.SessionService;
import services.UserService;

@Controller
@SessionAttributes({"login"})
public class TestController {
	private static final String SMS_SENDER = "+15752147992";
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ChannelService channelService;
	@Autowired
	private ChannelRepository channelRepository;
	@Autowired
	private LogService logService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private SessionRepository sessionRepository;
	@Autowired
	private SessionService sessionService;
	@Autowired
	private FavMessagesService favMessagesService;
	@Autowired
	private FavMessagesRepository favMessagesRepository;
	@Autowired
	private FavChannelsService favChannelsService;
	@Autowired
	private FavChannelsRepository favChannelsRepository;

	
	@Autowired
	private AsyncMail asyncMail;
	@Autowired
	private AsyncSms asyncSms;
	@Autowired
	private BanService banService;
	@Autowired
	private BanRepository banRepository;
	
	@RequestMapping(value = "/test/createChannel", method = RequestMethod.GET)
	public ModelAndView createChannelGet(Locale locale, ModelMap model) {
		
		Log newlog = new Log("A new channel created, returning Model");
		logService.saveOrUpdate(newlog);
		User current = userService.getById(((User) model.get("login")).getId());
		List<Channel> myChannels = new ArrayList<Channel>();
		List<Channel> joinedChannels = new ArrayList<Channel>();
		Channel channel1;
		for(String channel1Id : current.getChannelsList()) {
			channel1 = channelService.getById(channel1Id);
			if(channel1.getOwnerId().equals(current.getId())) {
				myChannels.add(channel1);
			}else
				joinedChannels.add(channel1);
					
		}
		model.addAttribute("mychannels",myChannels);
		model.addAttribute("joinedChannels",joinedChannels);
        return new ModelAndView("createChannel", "channel", new Channel());
    }
	
	@RequestMapping(value = "/test/createChannel", method = RequestMethod.POST)
	public String createChannelPost(@RequestParam (value="public") String publictype,
									@RequestParam (value="group") String group,
									@ModelAttribute("channel")Channel channel, ModelMap model,
									@RequestParam (value="sms", required = false) String sms,
									@RequestParam (value="email", required = false) String email,
									@RequestParam (value="daterange0") String date0,
									@RequestParam (value="daterange1", required = false) String date1,
									@RequestParam (value="daterange2", required = false) String date2,
									@RequestParam (value="daterange3", required = false) String date3,
									@RequestParam (value="daterange4", required = false) String date4,
									@RequestParam (value="public") String publicType,
									@RequestParam (value="dateCount") Integer dateCount) throws ParseException {
		
		//sms, email  on/null
		
		
		List<String> dateList = new ArrayList<String>();
		dateList.add(date1);
		dateList.add(date2);
		dateList.add(date3);
		dateList.add(date4);
		
		String userid = ((User)(model.get("login"))).getId();
		channel.setOwnerId(userid);
		if(sms != null)
			channel.setSms(true);
		if(email != null)
			channel.setEmail(true);
		channel.setType(publicType);
		Channel newChannel = channelService.saveOrUpdate(channel);
		//CREATE CHANNEL OPERATIONS
		
		//TRY CREATING A SESSION
		Session session = new Session(newChannel.getId(),date0);
		session = sessionService.saveOrUpdate(session);
		newChannel.addSession(session.getId());
		newChannel = channelService.saveOrUpdate(newChannel);
		
		for(String date : dateList) {
			if(date == null)
				break;
			session = new Session(newChannel.getId(),date);
			session = sessionService.saveOrUpdate(session);
			newChannel.addSession(session.getId());
			newChannel = channelService.saveOrUpdate(newChannel);
		}
		
		User current = userService.getById(userid);
		current.addChannel(newChannel.getId());
		current = userService.saveOrUpdate(current);
		
		model.put("login", current);
		
		Log newlog = new Log("A new channel with ID: " + newChannel.getId() + " is created by user with ID: " + userid);
		logService.saveOrUpdate(newlog);
        return "redirect:/test/calendar";
    }
	
	@RequestMapping(value = "/test/channel/{channelId}", method = RequestMethod.GET )
	public String channel(@PathVariable("channelId") String channelId, ModelMap model){
		
		Channel channel = channelService.getById(channelId);
		if( channel == null) {
			Log newlog = new Log("Could not access to channel with ID: " + channelId + " because there does not exist any channel");
			logService.saveOrUpdate(newlog);
			
			return "redirect:/test/profile";
		}
		
		//add security
		
		//adding channel members
		List<User> members = new ArrayList<User>();
		for(String memberId : channel.getMembersList()) {
			User member = userService.getById(memberId);
			members.add(member);
		}
		User current = userService.getById(((User) model.get("login")).getId());
		List<Channel> myChannels = new ArrayList<Channel>();
		List<Channel> joinedChannels = new ArrayList<Channel>();
		Channel channel1;
		for(String channel1Id : current.getChannelsList()) {
			channel1 = channelService.getById(channel1Id);
			if(channel1.getOwnerId().equals(current.getId())) {
				myChannels.add(channel1);
			}else
				joinedChannels.add(channel1);
					
		}
		model.addAttribute("mychannels",myChannels);
		model.addAttribute("joinedChannels",joinedChannels);
		model.addAttribute("members", members);
		model.addAttribute("channel", channel);
		
		//adding session
		Session session = new Session();
		for(String sessionId : channel.getSessions()) {
			session = sessionService.getById(sessionId);
			if(session.isActive())
				break;
		}
		if(!session.isActive()) {
			return "redirect:/test/sessionClosed";
		}
		model.addAttribute("session",session);
	    
		//adding channel messages
		List<Message> messages = new ArrayList<Message>();
		HashMap<String,String> senders = new HashMap<String,String>();
		HashMap<String,String> senderPics = new HashMap<String,String>();
		for(String messageId : session.getMessages()) {
			Message message = messageService.getById(messageId);
			messages.add(message);
			User sender = userService.getById(message.getSenderId());
			senders.put(message.getSenderId(), sender.getUsername());
			senderPics.put(message.getSenderId(), sender.getProfilePicture());
		}
		
		List<FavMessages> favMessagesList = new ArrayList<FavMessages>();
		
		favMessagesList = favMessagesRepository.findByUserId(current.getId());
		List<Message> favMessages = new ArrayList<Message>();
		for(FavMessages favmsg : favMessagesList) {
			
			favMessages.add(messageService.getById(favmsg.getMessageId()));
			
		}
		
		
		model.addAttribute("favMessages",favMessages);

		model.addAttribute("messages", messages);
		model.addAttribute("senders", senders);
		model.addAttribute("senderPics", senderPics);
		
		//adding non-members
		List<User> allUsers = userRepository.findAll();
		model.addAttribute("nonMembers", allUsers);
		
		//adding banned-members
		List<User> bannedUsers = new ArrayList<User>();
		List<Ban> bans = banRepository.findByChannelId(channel.getId());
		for(Ban ban : bans) {
			bannedUsers.add(userService.getById(ban.getUserId()));
		}
		model.addAttribute("bannedUsers", bannedUsers);
		
		Log newlog = new Log("Viewing channel with ID: " + channelId);
		logService.saveOrUpdate(newlog);
		
	    return "channel";
	}
	
	@RequestMapping(value = "/test/channel/{channelId}/deletechannel", method = RequestMethod.POST)
	public String deleteChannel(@RequestParam (value="channelId") String channelId, 
									ModelMap model) {
		User current = userService.getById(((User) model.get("login")).getId());
		Channel channel = channelService.getById(channelId);
		
		if(channel.getOwnerId().equals(current.getId())) {	
			for (String memberId : channel.getMembersList()) {
				User member = userService.getById(memberId);

					member.removeChannel(channel.getId());
					userService.saveOrUpdate(member);
					
				
					Log newlog = new Log("Deleted chann"+ channel.getId() + "from member" + member.getId());
					logService.saveOrUpdate(newlog);
				
			}
			channelRepository.delete(channel.getId());
		}

		
		return "redirect:/test/profile";
	}
	
	@RequestMapping(value = "/test/channel/{channelId}/leavechannel", method = RequestMethod.POST)
	public String leaveChannel(@RequestParam (value="channelId") String channelId, 
									ModelMap model) {
		User current = userService.getById(((User) model.get("login")).getId());
		Channel channel = channelService.getById(channelId);
		
		if(!channel.isOwner(current.getId())) {
			channel.removeMember(current.getId());
			current.removeChannel(channel.getId());
			
			channelService.saveOrUpdate(channel);
			userService.saveOrUpdate(current);
			
			Log newlog = new Log("User with ID: " + current.getId() + " left channel with ID: " + channelId);
			logService.saveOrUpdate(newlog);
			
		}else {
			
			Log newlog = new Log("User with ID: " + current.getId() + " could not leave channel with ID: " + channelId + "as that user was the owner");
			logService.saveOrUpdate(newlog);
		}
		
		
		return "redirect:/test/profile";
	}
	
	@RequestMapping(value = "/test/channel/{channelId}", method = RequestMethod.POST)
	public String addUserToChannel(@RequestParam (value="channelId") String channelId, 
									@RequestParam (value="name") String username,
									ModelMap model) {
		
		User newuser = userRepository.findByUsername(username);
		if(newuser != null) {
			//username is in database
			
			Channel channel = channelService.getById(channelId);
			Ban newBan = banRepository.findByUserId(newuser.getId());
			
			if(!channel.isMember(username) && (newBan == null)) {
				channel.addMember(newuser.getId());
				newuser.addChannel(channel.getId());
				
				channelService.saveOrUpdate(channel);
				userService.saveOrUpdate(newuser);
				Log newlog = new Log("Added a new user with ID: " + newuser.getId() + " to channel with ID: " + channelId);
				logService.saveOrUpdate(newlog);
			}else {
				Log newlog = new Log("Could not add user with username: " + username + " to channel with ID: " + channelId + "as that user was banned previously");
				logService.saveOrUpdate(newlog);
			}
			
	        return "redirect:/test/channel/" + channelId;
		}
		Log newlog = new Log("Could not add user with username: " + username + "as it was not found in the database");
		logService.saveOrUpdate(newlog);
		
        return "redirect:/test/home";
    }
	
	@RequestMapping(value = "/test/channel/{channelId}/deleteuser/{deleteName}", method = RequestMethod.POST)
	public String deleteUserFromChannel(@RequestParam (value="channelId") String channelId, 
									@RequestParam (value="deleteName") String deleteName,
									ModelMap model) {
		
		User current = userService.getById(((User) model.get("login")).getId());
		Channel channel = channelService.getById(channelId);
		
		if(channel.getOwnerId().equals(current.getId())) {	
			User deleteUser = userRepository.findByUsername(deleteName);
			if(deleteUser != null) {
				//username is in database
				
				if(channel.isMember(deleteUser.getId())) {
					channel.removeMember(deleteUser.getId());
					deleteUser.removeChannel(channel.getId());
				}
				
				channelService.saveOrUpdate(channel);
				userService.saveOrUpdate(deleteUser);
				
				channelService.saveOrUpdate(channel);
				userService.saveOrUpdate(deleteUser);
				
				Log newlog = new Log("Delete user with ID: " + deleteUser.getId() + " from channel with ID: " + channelId);
				logService.saveOrUpdate(newlog);
				
				
			}
		}
		
		return "redirect:/test/channel/" + channelId;
	}
	
	@RequestMapping(value = "/test/channel/{channelId}/{banName}", method = RequestMethod.POST)
	public String banUserFromChannel(@RequestParam (value="channelId") String channelId, 
									@RequestParam (value="banName") String banName,
									ModelMap model) {
		
		User newuser = userRepository.findByUsername(banName);
		if(newuser != null) {
			//username is in database
			
			Channel channel = channelService.getById(channelId);
			
			if(channel.isMember(newuser.getId())) {
				channel.removeMember(newuser.getId());
				newuser.removeChannel(channel.getId());
				
				Ban newBan = new Ban(newuser.getId(),channel.getId());
				banService.saveOrUpdate(newBan);
			}
			
			channelService.saveOrUpdate(channel);
			userService.saveOrUpdate(newuser);
			Log newlog = new Log("Banned a user with ID: " + newuser.getId() + " from channel with ID: " + channelId);
			logService.saveOrUpdate(newlog);
			
	        return "redirect:/test/channel/" + channelId;
		}
		Log newlog = new Log("Could not ban user with username: " + banName + "as it was not found in the database");
		logService.saveOrUpdate(newlog);
		
        return "redirect:/test/home";
    }
	
	@RequestMapping(value = "/test/channel/{channelId}/unban/{banName}", method = RequestMethod.POST)
	public String unBanUserFromChannel(@RequestParam (value="channelId") String channelId, 
									@RequestParam (value="banName") String banName,
									ModelMap model) {
		
		User newuser = userRepository.findByUsername(banName);
		if(newuser != null) {
			//username is in database
			
			Channel channel = channelService.getById(channelId);
			Ban newBan = banRepository.findByUserId(newuser.getId());
			
			if(newBan != null) {
				
				banService.delete(newBan.getId());
				
				Log newlog = new Log("Unbanned a user with ID: " + newuser.getId() + " from channel with ID: " + channelId);
				logService.saveOrUpdate(newlog);
				
			}else {
				Log newlog = new Log("Could not unban user with username: " + banName + " from channel with ID: " + channelId + "as it was not banned");
				logService.saveOrUpdate(newlog);
			}
			
	        return "redirect:/test/channel/" + channelId;
		}
		Log newlog = new Log("Could not unban user with username: " + banName + "as it was not found in the database");
		logService.saveOrUpdate(newlog);
		
        return "redirect:/test/home";
    }
	
	@RequestMapping(value = "/test/createUser", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("user")User user, ModelMap model) {
		User newuser = userRepository.findByUsername(user.getUsername());
		if(newuser != null) {
			//username is taken
			Log newlog = new Log("Could not create user with username: " + user.getUsername() + "as it was taken");
			logService.saveOrUpdate(newlog);
			
			return "redirect:/test/home";
		}
		newuser = userRepository.findByEmail(user.getEmail());
		if(newuser != null) {
			//email is taken
			Log newlog = new Log("Could not create user with Email: " + user.getEmail() + "as it was taken");
			logService.saveOrUpdate(newlog);
			
			return "redirect:/test/home";
		}
		
		newuser = userService.saveOrUpdate(user);
        
        model.put("login",newuser);
        
        Log newlog = new Log("Created a new user with username: " + user.getUsername() + " and Email: " + user.getEmail());
		logService.saveOrUpdate(newlog);
		
        return "redirect:/test/profile";
    }
	@RequestMapping(value = "/test/login", method = RequestMethod.POST)
    public String login(@RequestParam (value="username") String username,
			    		@RequestParam (value="password") String password
						, Locale locale, ModelMap model) {
		User newuser = userRepository.findByUsername(username);
		//username check
		if(newuser == null) {
			Log newlog = new Log("Could not find a user with username: " + username + "to login");
			logService.saveOrUpdate(newlog);
		
			return "redirect:/test/home";
		}
		
		//password check
		if(!newuser.getPassword().equals(password)) {
			Log newlog = new Log("Could not log in a user with username: " + username + "because of wrong password");
			logService.saveOrUpdate(newlog);
			
			return "redirect:/test/home";
		}
		
        model.put("login",newuser);
        Log newlog = new Log("Logged in a user with username: " + username);
		logService.saveOrUpdate(newlog);
        
        return "redirect:/test/profile";
    }
	@RequestMapping(value = "/test/logout", method = RequestMethod.GET)
	public String logout(Locale locale, ModelMap model) {
		if(model.get("login") == null) {
			Log newlog = new Log("Could not log out because no one is logged in");
			logService.saveOrUpdate(newlog);
			
			return "redirect:/test/home";
		}
		else {
			model.remove("login");
		}
		Log newlog = new Log("Logged out current user");
		logService.saveOrUpdate(newlog);
		
		return "redirect:/test/home";
	}
	
	@RequestMapping(value = "/test/deleteProfile", method = RequestMethod.POST)
	public String deleteProfile(@ModelAttribute("user") User user, ModelMap model) {

		User current = userService.getById(((User) model.get("login")).getId());
		Channel channel;

		for (String channel1Id : current.getChannelsList()) {
			channel = channelService.getById(channel1Id);
			if (channel != null) {
				if (channel.getOwnerId().equals(current.getId())) { // if owner then delete all members from channels
					for (String memberId : channel.getMembersList()) {
						User member = userService.getById(memberId);
						if (member != null) {
							channel.removeMember(member.getId());
							member.removeChannel(channel.getId());
							
							userService.saveOrUpdate(member);
							channelService.saveOrUpdate(channel);
						}
						channelRepository.delete(channel.getId());				
					}
				} else {  // else delete only current from channels
					channel.removeMember(current.getId());
					channelService.saveOrUpdate(channel);
				}
			}
		}

		userService.delete(current.getId());

		String username = current.getUsername();
		Log newlog = new Log("Delete user with the username " + username);
		logService.saveOrUpdate(newlog);

		return "redirect:/test/home";
	}
	
	@RequestMapping(value = "/test/search/{query}", method = RequestMethod.POST)
	public String query(@RequestParam (value="query") String query) {
		
		return "redirect:/test/search/" + query;
    }
	
	@RequestMapping(value = "/test/search/{query}", method = RequestMethod.GET)
	public String search(@PathVariable("query") String query, ModelMap model){
		
		User otherProfile = userRepository.findByUsername(query);
		if( otherProfile != null) {
			model.addAttribute("otherProfileUser",otherProfile);
		}
		
		List<User> otherProfilesFirst = userRepository.findByFirstName(query);
		if( otherProfilesFirst != null) {
			model.addAttribute("otherProfilesFirst",otherProfilesFirst);
		}
		
		List<User> otherProfilesLast = userRepository.findByLastName(query);
		if( otherProfilesLast != null) {
			model.addAttribute("otherProfilesLast",otherProfilesLast);
		}
		List<Channel> channels = channelRepository.findByName(query);
		if(channels != null) {
			//excluding hidden channels
			for(int i = 0; i<channels.size(); i++) {
				Channel ch = channels.get(i);
				if(ch.getType().equals("hidden"))
					channels.remove(i);
			}
			model.addAttribute("searchChannels", channels);
		
		}
		
		User current = userService.getById(((User) model.get("login")).getId());
		List<Channel> myChannels = new ArrayList<Channel>();
		List<Channel> joinedChannels = new ArrayList<Channel>();
		Channel channel1;
		for(String channel1Id : current.getChannelsList()) {
			channel1 = channelService.getById(channel1Id);
			if(channel1.getOwnerId().equals(current.getId())) {
				myChannels.add(channel1);
			}else
				joinedChannels.add(channel1);	
					
		}
		model.addAttribute("mychannels",myChannels);
		model.addAttribute("joinedChannels",joinedChannels);
		Log newlog = new Log("User made a search with query: " + query + " from GET method");
		logService.saveOrUpdate(newlog);
		
		return "search";
	}
	
	@RequestMapping(value = "/test/profile/{query}", method = RequestMethod.GET)
	public String testProfile(@PathVariable("query") String query, Locale locale, ModelMap model) throws JsonProcessingException {
		
		List<Channel> joinedChannels = new ArrayList<Channel>();
		List<Channel> myChannels = new ArrayList<Channel>();
		List<Channel> favouriteChannels = new ArrayList<Channel>();
		List<FavChannels> favouriteChannelsList = new ArrayList<FavChannels>();
		
		User otherProfile = userRepository.findByUsername(query);
		
		favouriteChannelsList = favChannelsService.getByUserId(otherProfile.getId());
		
		for(FavChannels msg : favouriteChannelsList) {
			favouriteChannels.add(channelService.getById(msg.getchannelId()));
		}
		
		Channel channel;
		for(String channel1Id : otherProfile.getChannelsList()) {
			channel = channelService.getById(channel1Id);
			if(channel.getOwnerId().equals(otherProfile.getId())) {
				myChannels.add(channel);
			}else {
				joinedChannels.add(channel);
			}
		}
		
		model.addAttribute("favouriteChannels",favouriteChannels);
		model.addAttribute("mychannels",myChannels);
		model.addAttribute("joinedChannels",joinedChannels);
		model.addAttribute("profile", otherProfile);
		List<Session> session = new ArrayList<Session>();
		session = sessionService.listAll();
		
		model.addAttribute("sessionList",session);
		
		
		//BEKOSHOW
		HashMap<String,String> channelNames = new HashMap<String,String>();
		session = new ArrayList<Session>();
		myChannels = new ArrayList<Channel>();
		for(String channelid : otherProfile.getChannelsList()) {
			channel = channelService.getById(channelid);
			for(String sesid : channel.getSessionsList()) {
				session.add(sessionService.getById(sesid));
				channelNames.put(sesid, channel.getName());
			}
		}
		ObjectMapper objectMapper = new ObjectMapper();
		model.addAttribute("bekoSessions",objectMapper.writeValueAsString(session));
		model.addAttribute("bekoChannelNames",objectMapper.writeValueAsString(channelNames));
		
		Log newlog = new Log("Accessed to profile of user with ID: " + otherProfile.id);
		logService.saveOrUpdate(newlog);
		
		return "otherProfile";
	}
	
	@RequestMapping(value = "/test/home", method = RequestMethod.GET)
	public ModelAndView testHome() {
		
        return new ModelAndView("home", "user", new User());
    }
	
	@RequestMapping(value = "/test/profile", method = RequestMethod.GET)
	public String testProfile(Locale locale, ModelMap model) throws JsonProcessingException {
		if(model.get("login") == null) {
			Log newlog = new Log("Could not access to profile because user is not logged in");
			logService.saveOrUpdate(newlog);
			
			return "redirect:/test/home";
		}
		User current = userService.getById(((User) model.get("login")).getId());
		if(current == null) {
			//SESSION - DB CONFLICT
			Log newlog = new Log("Could not access to profile because there exist a session-database conflict");
			logService.saveOrUpdate(newlog);
			
			return "redirect:/test/home";
		}
		List<Channel> joinedChannels = new ArrayList<Channel>();
		List<Channel> myChannels = new ArrayList<Channel>();
		List<Channel> favouriteChannels = new ArrayList<Channel>();
		
		List<FavChannels> favouriteChannelsList = new ArrayList<FavChannels>();
		
		favouriteChannelsList = favChannelsService.getByUserId(current.getId());
		
		for(FavChannels msg : favouriteChannelsList) {
			
			
			
			favouriteChannels.add(channelService.getById(msg.getchannelId()));
			
		}

		
		Channel channel;
		for(String channel1Id : current.getChannelsList()) {
			channel = channelService.getById(channel1Id);
			if(channel.getOwnerId().equals(current.getId())) {
				myChannels.add(channel);

			}else {
				joinedChannels.add(channel);
				
			}

		}
		
		model.addAttribute("favouriteChannels",favouriteChannels);
		model.addAttribute("mychannels",myChannels);
		model.addAttribute("joinedChannels",joinedChannels);
		model.addAttribute("profile", current);
		List<Session> session = new ArrayList<Session>();
		session = sessionService.listAll();
		
		model.addAttribute("sessionList",session);
		
		
		//BEKOSHOW
		HashMap<String,String> channelNames = new HashMap<String,String>();
		session = new ArrayList<Session>();
		myChannels = new ArrayList<Channel>();
		for(String channelid : current.getChannelsList()) {
			channel = channelService.getById(channelid);
			for(String sesid : channel.getSessionsList()) {
				session.add(sessionService.getById(sesid));
				channelNames.put(sesid, channel.getName());
			}
		}
		ObjectMapper objectMapper = new ObjectMapper();
		model.addAttribute("bekoSessions",objectMapper.writeValueAsString(session));
		model.addAttribute("bekoChannelNames",objectMapper.writeValueAsString(channelNames));
		
		
		
		
		Log newlog = new Log("Accessed to profile of user with ID: " + current.id);
		logService.saveOrUpdate(newlog);
		
		return "profile";
	}
	
	@RequestMapping(value = "/test/favouriteMessages", method = RequestMethod.GET)
	public String testFavouriteMessages(Locale locale, ModelMap model) {
		
		User current = userService.getById(((User) model.get("login")).getId());
        //return new ModelAndView("home", "user", new User());
		
		List<FavMessages> favouriteMessagesList = new ArrayList<FavMessages>();
		
		favouriteMessagesList = favMessagesService.getByUserId(current.getId());
		
		List<Message> favouriteMessages = new ArrayList<Message>();
		
		for(FavMessages msg : favouriteMessagesList) {
			
			
			
			favouriteMessages.add(messageService.getById(msg.getMessageId()));
			
		}
		List<Channel> joinedChannels = new ArrayList<Channel>();
		List<Channel> myChannels = new ArrayList<Channel>();
		Channel channel;
		for(String channel1Id : current.getChannelsList()) {
			channel = channelService.getById(channel1Id);
			if(channel.getOwnerId().equals(current.getId())) {
				myChannels.add(channel);

			}else {
				joinedChannels.add(channel);
				
			}

		}
		

		model.addAttribute("mychannels",myChannels);
		model.addAttribute("joinedChannels",joinedChannels);
		model.addAttribute("favouriteMessages",favouriteMessages);
		
		Log newlog = new Log("Messages favorited by user with ID: " + current.id + " is requested");
		logService.saveOrUpdate(newlog);
		
        return "favMessages";
    }

	
	@RequestMapping(value = "/test/addFavourites", method = RequestMethod.POST)
	public String addFovourites(@RequestParam (value="favChannelId") String channelId,
			ModelMap model)  {
		
		User current = userService.getById(((User) model.get("login")).getId());
		
		FavChannels channel = new FavChannels(current.getId(),channelId);
		
		favChannelsService.saveOrUpdate(channel);
		
		Log newlog = new Log("Channel with ID: " + channelId + " is favorited by user with ID: " + current.id);
		logService.saveOrUpdate(newlog);
		
		return "redirect:/test/channel/" + channelId;

		
	}
	
	@RequestMapping(value = "/test/dropFavourites", method = RequestMethod.POST)
	public String dropFovourites(@RequestParam (value="favChannelId") String channelId,
			ModelMap model)  {
		
		User current = userService.getById(((User) model.get("login")).getId());
		
		List<FavChannels> favouriteChannelsList = new ArrayList<FavChannels>();
		
		favouriteChannelsList = favChannelsRepository.findByUserId(current.getId());
		
		String favChnId;
		String tempfavChnId = "Unknown favorited channel id";
		
		for(FavChannels temp:favouriteChannelsList) {
			
			if(temp.getchannelId().equals(channelId)) {
				
				favChnId = temp.getId();
				tempfavChnId = temp.getId();
				
				favChannelsService.delete(favChnId);
				
				break;
				
			}
			
			
		}
		
		Log newlog = new Log("Channel with ID: " + tempfavChnId + " is unfavorited by user with ID: " + current.id);
		logService.saveOrUpdate(newlog);
		
		return "redirect:/test/channel/" + channelId;

	}
	
	@RequestMapping(value = "/test/addFavouritesMessages", method = RequestMethod.POST)
	public String addFovouritesMessages(@RequestParam (value="favMsgId") String messageId,@RequestParam (value="favChannelId") String channelId,
			ModelMap model)  {
		
		User current = userService.getById(((User) model.get("login")).getId());
		
		String userId = current.getId();
		
		FavMessages message = new FavMessages(userId,messageId);
		
		favMessagesService.saveOrUpdate(message);
		
		Log newlog = new Log("Message with ID: " + messageId + " is favorited by user with ID: " + current.id);
		logService.saveOrUpdate(newlog);
		
		return "redirect:/test/channel/" + channelId;

		
	}
	
	@RequestMapping(value = "/test/dropFavouritesMessages", method = RequestMethod.POST)
	public String dropFovouritesMessages(@RequestParam (value="favMsgId") String messageId,@RequestParam (value="favChannelId") String channelId,
			ModelMap model)  {
		
		User current = userService.getById(((User) model.get("login")).getId());
		
		List<FavMessages> favouriteMessagesList = new ArrayList<FavMessages>();
		
		favouriteMessagesList = favMessagesRepository.findByUserId(current.getId());
		
		String favMsgId;
		String tempfavMsgId = "Unknown favorited message id";
		
		for(FavMessages temp:favouriteMessagesList) {
			
			if(temp.getMessageId().equals(messageId)) {
				
				favMsgId = temp.getId();
				tempfavMsgId = temp.getId();
				
				favMessagesService.delete(favMsgId);
				
				break;
				
			}
			
			
		}
		
		Log newlog = new Log("Message with ID: " + tempfavMsgId + " is unfavorited by user with ID: " + current.id);
		logService.saveOrUpdate(newlog);

		return "redirect:/test/channel/" + channelId;
		
	}

	@RequestMapping(value = "/test/chat", method = RequestMethod.GET)
	public String testChat(Locale locale, ModelMap model) {
		if(model.get("login") == null) {
			Log newlog = new Log("Could not access to chat because user is not logged in");
			logService.saveOrUpdate(newlog);
			
			return "redirect:/test/home";
		}
		User current = userService.getById(((User) model.get("login")).getId());
		if(current == null) {
			//SESSION - DB CONFLICT
			Log newlog = new Log("Could not access to chat because there exist a session-database conflict");
			logService.saveOrUpdate(newlog);
			
			return "redirect:/test/home";
		}
		model.addAttribute("profile", current);

		List<Message> messageList;
		List<String> channels = current.getChannelsList();
		
		
		
		if(channels == null) {
			Log newlog = new Log("Could not access to chat because there does not exist any channel");
			logService.saveOrUpdate(newlog);
			
	        return "redirect:/test/profile";
		}
		
		//TRY WITH FIRST CHANNEL
		Channel channel = channelService.getById(channels.get(0));
		
		//TRY WITH FIRST SESSION
		String sessionid = channel.getSessionsList().get(0);
		Session session = sessionService.getById(sessionid);
		
		
		messageList = messageRepository.findBySessionId(session.getId());
		
		Collections.sort(messageList, Message.COMPARE_BY_TIMESTAMP);
		model.addAttribute("sessionId",sessionid);
		model.addAttribute("channelId",session.getChannelId());
		model.addAttribute("messageList", messageList);
		
		Log newlog = new Log("Accessed to chat by user with ID: " + current.id);
		logService.saveOrUpdate(newlog);
		
		return "chat";
	}
	@RequestMapping(value = "/test/register", method = RequestMethod.GET)
	public String testRegister(Locale locale, ModelMap model) {
		
		return "register";
		
	}
	@RequestMapping(value = "/test/calendar", method = RequestMethod.GET)
	public String testCalendar(Locale locale, ModelMap model) throws JsonProcessingException {
		
		User current = userService.getById(((User) model.get("login")).getId());
		List<Channel> myChannels = new ArrayList<Channel>();
		List<Channel> joinedChannels = new ArrayList<Channel>();
		Channel channel1;
		for(String channel1Id : current.getChannelsList()) {
			channel1 = channelService.getById(channel1Id);
			if(channel1.getOwnerId().equals(current.getId())) {
				myChannels.add(channel1);
			}else
				joinedChannels.add(channel1);	
					
		}
		model.addAttribute("mychannels",myChannels);
		model.addAttribute("joinedChannels",joinedChannels);
		
		//BEKOSHOW
		List<Session> session = new ArrayList<Session>();
		session = sessionService.listAll();
		
		model.addAttribute("sessionList",session);
		
		
		//BEKOSHOW
		HashMap<String,String> channelNames = new HashMap<String,String>();
		session = new ArrayList<Session>();
		myChannels = new ArrayList<Channel>();
		for(String channelid : current.getChannelsList()) {
			channel1 = channelService.getById(channelid);
			for(String sesid : channel1.getSessionsList()) {
				session.add(sessionService.getById(sesid));
				channelNames.put(sesid, channel1.getName());
			}
		}
		ObjectMapper objectMapper = new ObjectMapper();
		model.addAttribute("bekoSessions",objectMapper.writeValueAsString(session));
		model.addAttribute("bekoChannelNames",objectMapper.writeValueAsString(channelNames));
		return "calendar";
		
	}
	
	@RequestMapping(value = "/test/channelView/{name}", method = RequestMethod.POST)
	public String channelView() {
		
		return "channelView";
    }
	
	@RequestMapping(value = "/test/channelView/{id}", method = RequestMethod.GET)
	public String channelView(@PathVariable("id") String id,ModelMap model){
		Channel channel;
		channel = channelService.getById(id);
		User owner = userService.getById(channel.getOwnerId());
		List<Session> sessionList = new ArrayList<Session>();
		for(int i=0;i<channel.getSessionsList().size();i++) {
			sessionList.add(sessionService.getById(channel.getSessionsList().get(i)));
		}
		User current = userService.getById(((User) model.get("login")).getId());
		List<Channel> myChannels = new ArrayList<Channel>();
		List<Channel> joinedChannels = new ArrayList<Channel>();
		Channel channel1;
		for(String channel1Id : current.getChannelsList()) {
			channel1 = channelService.getById(channel1Id);
			if(channel1.getOwnerId().equals(current.getId())) {
				myChannels.add(channel1);
			}else
				joinedChannels.add(channel1);
					
		}
		int memberNo = channel.getMembersList().size();
		
		model.addAttribute("mychannels",myChannels);
		model.addAttribute("joinedChannels",joinedChannels);
		model.addAttribute("memberNo", memberNo);
		model.addAttribute("owner", owner);
		model.addAttribute("channel",channel);
		model.addAttribute("sessionList",sessionList);
		return "channelView";
	}
	
	@RequestMapping(value = "/test/about", method = RequestMethod.GET)
	public String testAbout(Locale locale, ModelMap model) {
		
		return "about";
	}
	
	@RequestMapping(value = "/test/sessionClosed", method = RequestMethod.GET)
	public String testSesionClosed(Locale locale, ModelMap model) {
		User current = userService.getById(((User) model.get("login")).getId());
		List<Channel> myChannels = new ArrayList<Channel>();
		List<Channel> joinedChannels = new ArrayList<Channel>();
		Channel channel1;
		for(String channel1Id : current.getChannelsList()) {
			channel1 = channelService.getById(channel1Id);
			if(channel1.getOwnerId().equals(current.getId())) {
				myChannels.add(channel1);
			}else
				joinedChannels.add(channel1);
					
		}
		model.addAttribute("mychannels",myChannels);
		model.addAttribute("joinedChannels",joinedChannels);
		return "closed";
	}
	
	@RequestMapping(value = "/test/list", method = RequestMethod.GET)
	public String testList(Locale locale, ModelMap model) {
		
		//creating a 2d list array
		List<List<String>> list = new ArrayList<List<String>>();
		List<String> l1 = new ArrayList<String>();
		l1.add("List 1 item 1");
		l1.add("List 1 item 2");
		l1.add("List 1 item 3");
		List<String> l2 = new ArrayList<String>();
		l2.add("List 2 item 1");
		l2.add("List 2 item 2");
		l2.add("List 2 item 3");
		list.add(l1);
		list.add(l2);
		
		//passing the list to the model
		model.addAttribute("list", list);
		//lets render the whole thing
		
		return "list";
	}
	
}
