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
public class FavouriteController {	
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
	@Autowired
	private NotificationRepository notificationRepository;
	@Autowired
	private NotificationService notificationService;
	
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

		model.put("notifications", notificationService.getByIdWithNames(((User) model.get("login")).getId()));
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

		model.put("notifications", notificationService.getByIdWithNames(((User) model.get("login")).getId()));
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

		model.put("notifications", notificationService.getByIdWithNames(((User) model.get("login")).getId()));
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

		model.put("notifications", notificationService.getByIdWithNames(((User) model.get("login")).getId()));
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

		model.put("notifications", notificationService.getByIdWithNames(((User) model.get("login")).getId()));
		return "redirect:/test/channel/" + channelId;
		
	}
	
}
