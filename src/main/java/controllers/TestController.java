package controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
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
import domain.Message;
import domain.Session;
import domain.User;
import domain.Sms;
import repositories.ChannelRepository;
import repositories.MessageRepository;
import repositories.SessionRepository;
import repositories.UserRepository;
import services.ChannelService;
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
	private MessageService messageService;
	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private SessionRepository sessionRepository;
	@Autowired
	private SessionService sessionService;
	
	@RequestMapping(value = "/test/createChannel", method = RequestMethod.GET)
	public ModelAndView createChannelGet(Locale locale, ModelMap model) {
		
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
        return "redirect:/test/channel/" + newChannel.getId();
    }
	
	@RequestMapping(value = "/test/channel/{channelId}", method = RequestMethod.GET )
	public String channel(@PathVariable("channelId") String channelId, ModelMap model){
		
		Channel channel = channelService.getById(channelId);
		if( channel == null) {
			return "redirect:/test/profile";
		}
		
		//add security
		List<User> members = new ArrayList<User>();
		for(String memberId : channel.getMembersList()) {
			User member = userService.getById(memberId);
			members.add(member);
		}
		model.addAttribute("members", members);
		model.addAttribute("channel", channel);
		Session session = new Session();
		for(String sessionId : channel.getSessions()) {
			session = sessionService.getById(sessionId);
			if(session.isActive())
				break;
		}
		model.addAttribute("session",session);
	    
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
			
	        return "redirect:/test/channel/" + channelId;
		}
        return "redirect:/test/home";
    }
	
	@RequestMapping(value = "/test/createUser", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("user")User user, ModelMap model) {
		User newuser = userRepository.findByUsername(user.getUsername());
		if(newuser != null) {
			//username is taken
			return "redirect:/test/home";
		}
		newuser = userRepository.findByEmail(user.getEmail());
		if(newuser != null) {
			//email is taken
			return "redirect:/test/home";
		}
		
		newuser = userService.saveOrUpdate(user);
        
        model.put("login",newuser);
        return "redirect:/test/profile";
    }
	@RequestMapping(value = "/test/login", method = RequestMethod.POST)
    public String login(@RequestParam (value="username") String username,
			    		@RequestParam (value="password") String password
						, Locale locale, ModelMap model) {
		System.out.println(username);
		User newuser = userRepository.findByUsername(username);
		if(newuser == null)
			return "redirect:/test/home";
		//username check
        
		if(!newuser.getPassword().equals(password))
			return "redirect:/test/home";
		//password check
		
        model.put("login",newuser);
        return "redirect:/test/profile";
    }
	@RequestMapping(value = "/test/logout", method = RequestMethod.GET)
	public String logout(Locale locale, ModelMap model) {
		if(model.get("login") == null) {
			return "redirect:/test/home";
		}
		else {
			model.remove("login");
		}
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
        return "redirect:/test/chat";
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
		
		return "search";
	}
	
	@RequestMapping(value = "/test/profile/{query}", method = RequestMethod.GET)
	public String otherProfile(@PathVariable("query") String query, ModelMap model){
		
		User otherProfile = userRepository.findByUsername(query);
		
		if( otherProfile == null) {
			return "redirect:/test/home";
		}
		
		model.addAttribute("otherProfile",otherProfile);
		
	    return "otherProfile";
	}
	
	@RequestMapping(value = "/test/home", method = RequestMethod.GET)
	public ModelAndView testHome() {
        return new ModelAndView("home", "user", new User());
    }
	
	@RequestMapping(value = "/test/profile", method = RequestMethod.GET)
	public String testProfile(Locale locale, ModelMap model) {
		if(model.get("login") == null) {
			return "redirect:/test/home";
		}
		User current = userService.getById(((User) model.get("login")).getId());
		if(current == null) {
			//SESSION - DB CONFLICT
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
		return "profile";
	}

	@RequestMapping(value = "/test/chat", method = RequestMethod.GET)
	public String testChat(Locale locale, ModelMap model) {
		if(model.get("login") == null) {
			return "redirect:/test/home";
		}
		User current = userService.getById(((User) model.get("login")).getId());
		if(current == null) {
			//SESSION - DB CONFLICT
			return "redirect:/test/home";
		}
		model.addAttribute("profile", current);

		List<Message> messageList;
		List<String> channels = current.getChannelsList();
		
		
		if(channels == null) {
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
		return "chat";
	}
	@RequestMapping(value = "/test/register", method = RequestMethod.GET)
	public String testRegister(Locale locale, ModelMap model) {
		
		return "register";
		
	}
	@RequestMapping(value = "/test/calendar", method = RequestMethod.GET)
	public String testCalendar(Locale locale, ModelMap model) {
		
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
