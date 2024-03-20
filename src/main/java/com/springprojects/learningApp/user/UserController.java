package com.springprojects.learningApp.user;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;



@Controller
@SessionAttributes({"name", "user"})
public class UserController {

	private AuthenticationService authenticationService;
	private UserRepository userRepository;
	
	public UserController(UserRepository userRepository, AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
		this.userRepository = userRepository;
	}
	
	
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String gotoHomePage() {
		return "home";
	}
	
	@RequestMapping(value="welcome",method = RequestMethod.GET)
	public String gotbacktoWelcomePage() {
		return "welcome";
	}
	
	@RequestMapping(value="register",method = RequestMethod.GET)
	public String gotoRegisterPage(ModelMap model) {
		User user = new User(0, "", "", new ArrayList<>(), null, new HashSet<>());
		model.put("user", user);
		return "register";
	}

	@RequestMapping(value="register",method = RequestMethod.POST)
	public String RegisterUser(User user, ModelMap model, BindingResult result) {
		user.setSchool(null);
		userRepository.save(user);
		return "home";
	}

	@RequestMapping(value="login",method = RequestMethod.GET)
	public String gotoLoginPage() {
		return "login";
	}

	@RequestMapping(value="login",method = RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name, 
			@RequestParam String password, ModelMap model) {
		
		if(authenticationService.authenticate(name, password)) {
			User user = userRepository.findByUsername(name);
			model.put("name", name);	
			model.put("user", user);
			return "welcome";
		}
		
		model.put("errorMessage", "Invalid Credentials! Please try again.");
		return "login";
	}
	
	@RequestMapping(value="logout",method = RequestMethod.GET)
	public String gotoLogoutPage(ModelMap model, SessionStatus status) {
		status.setComplete();
		return "logout";
	}
}
