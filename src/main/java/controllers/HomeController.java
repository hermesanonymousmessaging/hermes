package controllers;

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
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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
import services.FavChannelsService;
import services.FavMessagesService;
import services.LogService;
import services.MessageService;
import services.NotificationService;
import services.SessionService;
import services.UserService;

@Controller
@SessionAttributes({"login"})
public class HomeController {
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
	private NotificationRepository notificationRepository;
	@Autowired
	private NotificationService notificationService;

	
	@Autowired
	private AsyncMail asyncMail;
	@Autowired
	private AsyncSms asyncSms;
	@Autowired
	private BanService banService;
	@Autowired
	private BanRepository banRepository;
	
	@RequestMapping(value = "/test/search/{query}", method = RequestMethod.POST)
	public String query(@RequestParam (value="query") String query) {

		return "redirect:/test/search/" + query;
    }
	
	@RequestMapping(value = "/test/search/{query}", method = RequestMethod.GET)
	public String search(@PathVariable("query") String query, ModelMap model){
		
		User otherProfile = userRepository.findByUsernameIgnoreCase(query);
		if( otherProfile != null) {
			model.addAttribute("otherProfileUser",otherProfile);
		}
		
		List<User> otherProfilesFirst = userRepository.findByFirstNameIgnoreCase(query);
		if( otherProfilesFirst != null) {
			model.addAttribute("otherProfilesFirst",otherProfilesFirst);
		}
		
		List<User> otherProfilesLast = userRepository.findByLastNameIgnoreCase(query);
		if( otherProfilesLast != null) {
			model.addAttribute("otherProfilesLast",otherProfilesLast);
		}
		List<Channel> channels = channelRepository.findByNameIgnoreCase(query);
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

		model.put("notifications", notificationService.getByIdWithNames(((User) model.get("login")).getId()));
		return "search";
	}
	
	@RequestMapping(value = "/test/home", method = RequestMethod.GET)
	public ModelAndView testHome() {
		
        return new ModelAndView("home", "user", new User());
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

		model.put("notifications", notificationService.getByIdWithNames(((User) model.get("login")).getId()));
		return "chat";
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
		
		model.put("notifications", notificationService.getByIdWithNames(((User) model.get("login")).getId()));
		return "calendar";
		
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

		model.put("notifications", notificationService.getByIdWithNames(((User) model.get("login")).getId()));
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
		
		model.put("notifications", notificationService.getByIdWithNames(((User) model.get("login")).getId()));
		return "closed";
	}
	
	
}
