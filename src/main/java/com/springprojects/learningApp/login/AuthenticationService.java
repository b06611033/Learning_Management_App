package com.springprojects.learningApp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String username, String password) {
		
		boolean isValidUserName = username.equalsIgnoreCase("Bryan");
		boolean isValidPassword = password.equalsIgnoreCase("dummy2");
		
		return isValidUserName && isValidPassword;
	}
}
