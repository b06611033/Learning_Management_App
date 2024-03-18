package com.springprojects.learningApp.user;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	private UserRepository userRepository;
	
	public AuthenticationService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public boolean authenticate(String username, String password) {
		User user = userRepository.findByUsername(username);
		if(user == null) return false;
		boolean isValidPassword = password.equals(user.getPassword());
		return isValidPassword;
	}
}
