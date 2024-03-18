package com.springprojects.learningApp.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.springprojects.learningApp.todo.TodoRepository;

@Controller
@SessionAttributes("name")
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
	
	@RequestMapping(value="register",method = RequestMethod.GET)
	public String gotoRegisterPage() {
		return "register";
	}

	@RequestMapping(value="register",method = RequestMethod.POST)
	public String RegisterUser(@RequestParam String name, 
			@RequestParam String password, ModelMap model) {
		User newUser = new User(0, name, password);
		userRepository.save(newUser);
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
		
			model.put("name", name);		
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
