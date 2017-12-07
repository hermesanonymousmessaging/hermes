package controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import domain.Channel;
import domain.Email;
import domain.Log;
import domain.Message;
import domain.Session;
import domain.User;
import domain.Sms;
import repositories.ChannelRepository;
import repositories.MessageRepository;
import repositories.SessionRepository;
import repositories.UserRepository;
import services.ChannelService;
import services.LogService;
import services.MessageService;
import services.SessionService;
import services.UserService;

@Controller
@SessionAttributes({"login"})
public class TestController {
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
	
	@RequestMapping(value = "/test/createChannel", method = RequestMethod.GET)
	public ModelAndView createChannelGet(Locale locale, ModelMap model) {
		
		Log newlog = new Log("A new channel created, returning Model");
		logService.saveOrUpdate(newlog);
		
        return new ModelAndView("createChannel", "channel", new Channel());
    }
	
	@RequestMapping(value = "/test/createChannel", method = RequestMethod.POST)
	public String createChannelPost(@RequestParam (value="public") String publictype,
									@RequestParam (value="group") String group,
									@ModelAttribute("channel")Channel channel, ModelMap model,
									@RequestParam (value="daterange") String date) throws ParseException {
		String userid = ((User)(model.get("login"))).getId();
		channel.setOwnerId(userid);
		Channel newChannel = channelService.saveOrUpdate(channel);
		//CREATE CHANNEL OPERATIONS
		
		//TRY CREATING A SESSION
		Session session = new Session(newChannel.getId(),date);
		session.setActive();
		session = sessionService.saveOrUpdate(session);
		newChannel.addSession(session.getId());
		newChannel = channelService.saveOrUpdate(newChannel);
		
		User current = userService.getById(userid);
		current.addChannel(newChannel.getId());
		current = userService.saveOrUpdate(current);
		
		model.put("login", current);
		
		Log newlog = new Log("A new channel with ID: " + newChannel.getId() + " is created by user with ID: " + userid);
		logService.saveOrUpdate(newlog);
        return "redirect:/test/channel/" + newChannel.getId();
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
		
		
		model.addAttribute("members", members);
		model.addAttribute("channel", channel);
		
		//adding session
		Session session = new Session();
		for(String sessionId : channel.getSessions()) {
			session = sessionService.getById(sessionId);
			if(session.isActive())
				break;
		}
		model.addAttribute("session",session);
	    
		//adding channel messages
		List<Message> messages = new ArrayList<Message>();
		HashMap<String,String> senders = new HashMap<String,String>();
		for(String messageId : session.getMessages()) {
			Message message = messageService.getById(messageId);
			messages.add(message);
			User sender = userService.getById(message.getSenderId());
			senders.put(message.getSenderId(), sender.getUsername());
		}
		model.addAttribute("messages", messages);
		model.addAttribute("senders", senders);
		
		Log newlog = new Log("Viewing channel with ID: " + channelId);
		logService.saveOrUpdate(newlog);
		
	    return "channel";
	}
	
	@RequestMapping(value = "/test/channel/{channelId}", method = RequestMethod.POST)
	public String addUserToChannel(@RequestParam (value="channelId") String channelId, 
									@RequestParam (value="name") String username,
									ModelMap model) {
		
		User newuser = userRepository.findByUsername(username);
		if(newuser != null) {
			//username is in database
			
			Channel channel = channelService.getById(channelId);
			
			if(!channel.isMember(username)) {
				channel.addMember(newuser.getId());
				newuser.addChannel(channel.getId());
			}
			
			channelService.saveOrUpdate(channel);
			userService.saveOrUpdate(newuser);
			model.put("login", newuser);
			Log newlog = new Log("Added a new user with ID: " + newuser.getId() + " to channel with ID: " + channelId);
			logService.saveOrUpdate(newlog);
			
	        return "redirect:/test/channel/" + channelId;
		}
		Log newlog = new Log("Could not add user with username: " + username + "as it was not found in the database");
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
		System.out.println(username);
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
	
	@RequestMapping(value = "/test/send", method = RequestMethod.POST)
    public String send( @RequestParam (value="usermsg") String text,
    					@RequestParam (value="sessionId") String sessionId,
    					@RequestParam (value="channelId") String channelId
						, Locale locale, ModelMap model) {
		Session session = sessionService.getById(sessionId);
		String senderId = ((User)model.get("login")).getId();
		Message newmsg = new Message(1,text,senderId,channelId, sessionId);
		/*Sms sms1 = new Sms();             //SMS
		Sms sms2 = new Sms();
		sms1.SendSms("+905058652462","+15752147992",text);
		sms2.SendSms("+905378877769","+15752147992",text);*/
		
		/*
		Email newemail = new Email();
		newemail.SendEmail("birkandenizer@gmail.com",text);
		*/
		
		newmsg = messageService.saveOrUpdate(newmsg);
		session.addMessage(newmsg.getId());
		sessionService.saveOrUpdate(session);
		Log newlog = new Log("Sent a new message to channel with ID: " + channelId + " with session ID: " + sessionId);
		logService.saveOrUpdate(newlog);
		
        return "redirect:/test/channel/"+session.getChannelId();
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
		
		Log newlog = new Log("User made a search with query: " + query + " from GET method");
		logService.saveOrUpdate(newlog);
		
		return "search";
	}
	
	@RequestMapping(value = "/test/profile/{query}", method = RequestMethod.GET)
	public String otherProfile(@PathVariable("query") String query, ModelMap model){
		
		User otherProfile = userRepository.findByUsername(query);
		
		if( otherProfile == null) {
			Log newlog = new Log("Could not find a user with username: " + query);
			logService.saveOrUpdate(newlog);
			
			return "redirect:/test/home";
		}
		
		model.addAttribute("otherProfile",otherProfile);
		Log newlog = new Log("Found a user with username: " + query + "from search query");
		logService.saveOrUpdate(newlog);
		
	    return "otherProfile";
	}
	
	@RequestMapping(value = "/test/home", method = RequestMethod.GET)
	public ModelAndView testHome() {
		
        return new ModelAndView("home", "user", new User());
    }
	
	@RequestMapping(value = "/test/profile", method = RequestMethod.GET)
	public String testProfile(Locale locale, ModelMap model) {
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
		
		List<String> myChannelNames = new ArrayList<String>();
		List<String> joinedChannelNames = new ArrayList<String>();
		Channel channel;
		
		for(String channelId : current.getChannelsList()) {
			
			channel = channelService.getById(channelId);
			if(channel.getOwnerId().equals(current.getId()))
				myChannelNames.add(channel.getName());
			else
				joinedChannelNames.add(channel.getName());
		}
		
		model.addAttribute("channelNames",myChannelNames);
		model.addAttribute("joinedChannelNames",joinedChannelNames);
		model.addAttribute("profile", current);
		
		Log newlog = new Log("Accessed to profile of user with ID: " + current.id);
		logService.saveOrUpdate(newlog);
		
		return "profile";
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
	public String testCalendar(Locale locale, ModelMap model) {
		
		
		List<Session> session = new ArrayList<Session>();
		session = sessionService.listAll();
		
		model.addAttribute("sessionList",session);
		return "calendar";
		
	}

	@RequestMapping(value = "/test/about", method = RequestMethod.GET)
	public String testAbout(Locale locale, ModelMap model) {
		
		return "about";
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
