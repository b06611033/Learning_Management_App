package com.springprojects.learningApp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String username, String password) {
		
		boolean isValidUserName = true;
		boolean isValidPassword = true;
		
		return isValidUserName && isValidPassword;
	}
}
