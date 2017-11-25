package controllers;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import domain.User;
import repositories.UserRepository;
import services.UserService;

@Controller
@SessionAttributes({"login"})
public class TestController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/test/createUser", method = RequestMethod.POST)
    public String addAdvert(@ModelAttribute("user")User user, ModelMap model) {
		User newuser = userService.saveOrUpdate(user);
        System.out.println(newuser.getId());
        
        model.put("login",newuser);
        return "redirect:/test/home";
    }	
	
	@RequestMapping(value = "/test/home", method = RequestMethod.GET)
	public ModelAndView testHome() {
        return new ModelAndView("home", "user", new User());
    }
	
	@RequestMapping(value = "/test/profile", method = RequestMethod.GET)
	public String testProfile(Locale locale, ModelMap model) {
		return "profile";
	}
	@RequestMapping(value = "/test/chat", method = RequestMethod.GET)
	public String testChat(Locale locale, ModelMap model) {
		
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
	@RequestMapping(value = "/test/login", method = RequestMethod.GET)
	public String testLogin(Locale locale, ModelMap model) {
		
		return "login";
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
