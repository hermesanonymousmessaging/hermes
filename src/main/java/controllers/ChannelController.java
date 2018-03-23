package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import com.google.common.hash.Hashing;

import domain.Ban;
import domain.Channel;
import domain.Config;
import domain.Email;
import domain.Log;
import domain.Message;
import domain.Notification;
import domain.Session;
import domain.User;
import domain.Sms;
import domain.FavMessages;
import domain.FavChannels;

import repositories.BanRepository;
import repositories.ChannelRepository;
import repositories.ConfigRepository;
import repositories.MessageRepository;
import repositories.NotificationRepository;
import repositories.SessionRepository;
import repositories.UserRepository;
import repositories.FavMessagesRepository;
import repositories.FavChannelsRepository;
import services.AsyncMail;
import services.AsyncSms;
import services.BanService;
import services.ChannelService;
import services.ConfigService;
import services.FavChannelsService;
import services.FavMessagesService;
import services.LogService;
import services.MessageService;
import services.NotificationService;
import services.SessionService;
import services.UserService;

@Controller
@SessionAttributes({"login", "notifications"})
public class ChannelController {	
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
	private NotificationRepository notificationRepository;
	@Autowired
	private NotificationService notificationService;
	@Autowired
	private ConfigRepository configRepository;
	@Autowired
	private ConfigService configService;

	@Autowired
	private HomeController homeController;
	
	@Autowired
	private AsyncMail asyncMail;
	@Autowired
	private AsyncSms asyncSms;
	@Autowired
	private BanService banService;
	@Autowired
	private BanRepository banRepository;
	
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
		
		boolean isMember=false;
		
		for(String userId : channel.getMembersList()) {
			if(userId.equals(current.getId())) {
				
				isMember = true;
			}
		}
		
		if(isMember == false) {
			Log newlog = new Log("Could not access to channel with ID: " + channelId + " because user does not have authorization");
			logService.saveOrUpdate(newlog);
			
			return "redirect:/test/profile";
			
		}
		
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

		if(channel.isFriendly()) {
			senders = channel.getFriendlyNames();
		}
		for(String messageId : session.getMessages()) {
			Message message = messageService.getById(messageId);
			messages.add(message);
			User sender = userService.getById(message.getSenderId());
			if(!channel.isFriendly()) {
				senders.put(message.getSenderId(), sender.getUsername());
			}
			if(channel.isFriendly()) {
				String picname = senders.get(message.getSenderId());
				String[] splitStr = picname.split("\\s+");
				senderPics.put(message.getSenderId(), "https://ssl.gstatic.com/docs/common/profile/" + splitStr[1] +"_lg.png");
			}
			else
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
		List<User> nonMemberList = new ArrayList<User>();
		
		for(User nonMember : allUsers) {
			if(!channel.isMember(nonMember.getId())) {
				nonMemberList.add(nonMember);
			}
		}
		
		model.addAttribute("nonMembers", nonMemberList);
		//adding banned-members
		List<User> bannedUsers = new ArrayList<User>();
		List<Ban> bans = banRepository.findByChannelId(channel.getId());
		for(Ban ban : bans) {
			bannedUsers.add(userService.getById(ban.getUserId()));
		}
		
		model.addAttribute("bannedUsers", bannedUsers);
		
		Log newlog = new Log("Viewing channel with ID: " + channelId);
		logService.saveOrUpdate(newlog);
				
		model.put("notifications", notificationService.getByIdWithNames(current.getId()));
	    return "channel";
	}
	
	@RequestMapping(value = "/test/channel/{channelId}/{banName}", method = RequestMethod.POST)
	public String banUserFromChannel(@RequestParam (value="channelId") String channelId, 
									@RequestParam (value="banName") String banName,
									ModelMap model) {
		
		User current = userService.getById(((User) model.get("login")).getId());
		User newuser = userRepository.findByUsername(banName);

		if(!banName.equals(current.getUsername())) {
			System.out.println("user is not channel owner");
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
				
				Notification notification = new Notification(newuser.getId(), channelId);
				notification.setBanned(true);			
				notificationService.saveOrUpdate(notification);
				
		        return "redirect:/test/channel/" + channelId;
			}
		}
		Log newlog = new Log("Could not ban user with username: " + banName + "as it was not found in the database");
		logService.saveOrUpdate(newlog);
		
		model.put("notifications", notificationService.getByIdWithNames(((User) model.get("login")).getId()));
		return "redirect:/test/channel/" + channelId;
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
				
				Notification notification = new Notification(deleteUser.getId(), channelId);
				notification.setKicked(true);			
				notificationService.saveOrUpdate(notification);
				
				
			}
		}
		model.put("notifications", notificationService.getByIdWithNames(((User) model.get("login")).getId()));
		return "redirect:/test/channel/" + channelId;
	}
	
	@RequestMapping(value = "/test/channel/{channelId}", method = RequestMethod.POST)
	public String addUserToChannel(@RequestParam (value="channelId") String channelId, 
									@RequestParam (value="name") String username,
									ModelMap model) throws FileNotFoundException {
		
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
				
				Notification notification = new Notification(newuser.getId(), channelId);
				notification.setApproved(true);			
				notificationService.saveOrUpdate(notification);
				
			}else {
				Log newlog = new Log("Could not add user with username: " + username + " to channel with ID: " + channelId + "as that user was banned previously");
				logService.saveOrUpdate(newlog);
			}
			model.put("notifications", notificationService.getByIdWithNames(((User) model.get("login")).getId()));
	        return "redirect:/test/channel/" + channelId;
		}
		Log newlog = new Log("Could not add user with username: " + username + "as it was not found in the database");
		logService.saveOrUpdate(newlog);
		model.put("notifications", notificationService.getByIdWithNames(((User) model.get("login")).getId()));
        return "redirect:/test/home";
    }
	
	@RequestMapping(value = "/test/channel/{channelId}/joinRequest", method = RequestMethod.POST)
	public String joinRequestToChannel(@RequestParam (value="channelId") String channelId, 
									@RequestParam (value="name") String username,
									ModelMap model) throws FileNotFoundException {
		
		User newuser = userRepository.findByUsername(username);
		if(newuser != null) {
			//username is in database
			
			Channel channel = channelService.getById(channelId);
			Ban newBan = banRepository.findByUserId(newuser.getId());
			
			if(!channel.isMember(username) && (newBan == null) && !(newuser.getId().equals(channel.getOwnerId()))) {
				//channel.addMember(newuser.getId());
				//newuser.addChannel(channel.getId());
				
				//channelService.saveOrUpdate(channel);
				//userService.saveOrUpdate(newuser);
				Log newlog = new Log("Sended a join request for user with ID: " + newuser.getId() + " to channel with ID: " + channelId);
				logService.saveOrUpdate(newlog);
				
				Notification notification = new Notification(channel.getOwnerId(), channelId);
				notification.setJoin(true);	
				notification.setApplicantName(username);
				notificationService.saveOrUpdate(notification);
				
			}else {
				Log newlog = new Log("Could not send join request for the user with username: " + username + " to channel with ID: " + channelId + "as that user was banned previously or owner of the channel");
				logService.saveOrUpdate(newlog);
			}
			model.put("notifications", notificationService.getByIdWithNames(((User) model.get("login")).getId()));
	        return "redirect:/test/profile";
		}
		Log newlog = new Log("Could not add user with username: " + username + "as it was not found in the database");
		logService.saveOrUpdate(newlog);
		model.put("notifications", notificationService.getByIdWithNames(((User) model.get("login")).getId()));
        return "redirect:/test/home";
    }
	
	@RequestMapping(value = "/test/channel/{channelId}/inviteRequest", method = RequestMethod.POST)
	public String inviteRequestToChannel(@RequestParam (value="channelId") String channelId, 
									@RequestParam (value="name") String username,
									ModelMap model) throws FileNotFoundException {
		
		User newuser = userRepository.findByUsername(username);
		if(newuser != null) {
			//username is in database
			
			Channel channel = channelService.getById(channelId);
			Ban newBan = banRepository.findByUserId(newuser.getId());
			
			if(!channel.isMember(username) && (newBan == null) && !(newuser.getId().equals(channel.getOwnerId()))) {
				//channel.addMember(newuser.getId());
				//newuser.addChannel(channel.getId());
				
				//channelService.saveOrUpdate(channel);
				//userService.saveOrUpdate(newuser);
				Notification notification = new Notification(newuser.getId(), channelId);
				notification.setInvite(true);
				notification.setRecipientName(username);
				notificationService.saveOrUpdate(notification);
				
				Log newlog = new Log("Sended an invite request for user with ID: " + newuser.getId() + " to channel with ID: " + channelId);
				logService.saveOrUpdate(newlog);
				
			}else {
				Log newlog = new Log("Could not send invite request for the user with username: " + username + " to channel with ID: " + channelId + "as that user was banned previously or owner of the channel");
				logService.saveOrUpdate(newlog);
			}
			model.put("notifications", notificationService.getByIdWithNames(((User) model.get("login")).getId()));
	        return "redirect:/test/channel/" + channelId;
		}
		Log newlog = new Log("Could not add user with username: " + username + "as it was not found in the database");
		logService.saveOrUpdate(newlog);
		model.put("notifications", notificationService.getByIdWithNames(((User) model.get("login")).getId()));
        return "redirect:/test/home";
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
		
		model.put("notifications", notificationService.getByIdWithNames(((User) model.get("login")).getId()));
		return "redirect:/test/profile";
	}
	
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
		model.put("notifications", notificationService.getByIdWithNames(((User) model.get("login")).getId()));
        return new ModelAndView("createChannel", "channel", new Channel());
    }
	
	@RequestMapping(value = "/test/createChannel", method = RequestMethod.POST)
	public String createChannelPost(@RequestParam (value="public") String publictype,
									@RequestParam (value="group") String group,
									@ModelAttribute("channel")Channel channel, ModelMap model,
									@RequestParam (value="sms", required = false) String sms,
									@RequestParam (value="email", required = false) String email,
									@RequestParam (value="friendlyChannel", required = false) String friendlyChannel,
									@RequestParam (value="friendlyUser", required = false) String friendlyUser,
									@RequestParam (value="daterange0") String date0,
									@RequestParam (value="daterange1", required = false) String date1,
									@RequestParam (value="daterange2", required = false) String date2,
									@RequestParam (value="daterange3", required = false) String date3,
									@RequestParam (value="daterange4", required = false) String date4,
									@RequestParam (value="public") String publicType,
									@RequestParam (value="dateCount") Integer dateCount) throws ParseException, FileNotFoundException {
		
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
		if(friendlyChannel != null) {
			String filePath = new File("").getAbsolutePath();
			JacksonJsonParser parser = new JacksonJsonParser();
			Scanner s = new Scanner(new File(filePath + "/src/main/webapp/resources/fruits.txt"));
			ArrayList<String> list = new ArrayList<String>();
			while (s.hasNext()){
				list.add(s.next());
			}
			s.close();
			
			Config config = configService.getConfig();
			int i = config.getFriendlyChannelNum();
			i++;
			config.setFriendlyChannelNum(i);
			String channelName = list.get(i % list.size());
			if(i >= list.size()) {
				channelName += " " + new Integer(i/list.size()).toString();
			}
			newChannel.setName(channelName);
			newChannel = channelService.saveOrUpdate(newChannel);
			config = configService.saveOrUpdate(config);
		}
		if(friendlyUser != null) {
			newChannel.setFriendly(true);
			newChannel.removeMember(newChannel.getOwnerId());
			newChannel.addMember(newChannel.getOwnerId());
			newChannel = channelService.saveOrUpdate(newChannel);
		}
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
		model.put("notifications", notificationService.getByIdWithNames(((User) model.get("login")).getId()));
        return "redirect:/test/calendar";
    }
	
	@RequestMapping(value = "/test/channel/{channelId}/deletechannel", method = RequestMethod.POST)
	public String deleteChannel(@RequestParam (value="channelId") String channelId, 
									ModelMap model) {
		User current = userService.getById(((User) model.get("login")).getId());
		Channel channel = channelService.getById(channelId);
		
		if(channel.getOwnerId().equals(current.getId())) {
			for (Message message: messageRepository.findByChannelId(channel.getId())){
				messageService.delete(message.getId());
			}
			for (String sessionId : channel.getSessionsList()){
				sessionService.delete(sessionId);
			}
			for(FavMessages favMessage : favMessagesRepository.findByChannelId(channelId)){
				favMessagesService.delete(favMessage.getId());
			}
			for(FavChannels favChannel : favChannelsRepository.findByChannelId(channelId)){
				favChannelsRepository.delete(favChannel.getId());
			}
			for(domain.Ban ban : banRepository.findByChannelId(channelId)){
				banRepository.delete(ban.getId());
			}
			for (String memberId : channel.getMembersList()) {
				User member = userService.getById(memberId);

					member.removeChannel(channel.getId());
					userService.saveOrUpdate(member);
					
				
					Log newlog = new Log("Deleted chann"+ channel.getId() + "from member" + member.getId());
					logService.saveOrUpdate(newlog);
				
			}
			channelRepository.delete(channel.getId());
		}



		model.put("notifications", notificationService.getByIdWithNames(((User) model.get("login")).getId()));
		return "redirect:/test/profile";
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
		model.put("notifications", notificationService.getByIdWithNames(((User) model.get("login")).getId()));
        return "redirect:/test/home";
    }
	

	@RequestMapping(value = "/test/channelView/{name}", method = RequestMethod.POST)
	public String channelView(ModelMap model) {
		model.put("notifications", notificationService.getByIdWithNames(((User) model.get("login")).getId()));
		return "channelView";
    }
	
}
