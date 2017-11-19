package com.hermes.webapp;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	
	@RequestMapping(value = "/test/home", method = RequestMethod.GET)
	public String testHome(Locale locale, Model model) {
		
		return "home";
	}
	@RequestMapping(value = "/test/profile", method = RequestMethod.GET)
	public String testProfile(Locale locale, Model model) {
		
		return "profile";
	}
	@RequestMapping(value = "/test/chat", method = RequestMethod.GET)
	public String testChat(Locale locale, Model model) {
		
		return "chat";
	}
	@RequestMapping(value = "/test/register", method = RequestMethod.GET)
	public String testRegister(Locale locale, Model model) {
		
		return "register";
	}
	@RequestMapping(value = "/test/login", method = RequestMethod.GET)
	public String testLogin(Locale locale, Model model) {
		
		return "login";
	}
	@RequestMapping(value = "/test/about", method = RequestMethod.GET)
	public String testAbout(Locale locale, Model model) {
		
		return "about";
	}
	
	@RequestMapping(value = "/test/list", method = RequestMethod.GET)
	public String testList(Locale locale, Model model) {
		
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
