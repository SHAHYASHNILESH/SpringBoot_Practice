package com.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authenticateUser(String username, String password) {

		if (username.equalsIgnoreCase("in28minutes") && password.equalsIgnoreCase("1234"))
			return true;

		return false;

	}
}
