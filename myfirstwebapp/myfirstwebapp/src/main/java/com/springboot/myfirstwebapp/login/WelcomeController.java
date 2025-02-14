package com.springboot.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

//	private AuthenticationService as;
//
//	public LoginController(AuthenticationService as) {
//		super();
//		this.as = as;
//	}

	// http://localhost:8080/login-page
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goToWelcomePage(ModelMap model) {

		model.put("name", getLoggedinUsername());
		return "welcome";

	}

	private String getLoggedinUsername() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		return authentication.getName();

	}
	
	// http://localhost:8080/login-page?name=in28minutes && password=1234
//	@RequestMapping(value = "login", method = RequestMethod.POST)
//	public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
//
//		if (as.authenticateUser(name, password)) {
//
//			model.put("name", name);
//			// model.put("password", password);
//
//			// Authentication
//			// name- Yash
//			// password- 1234
//			return "welcome";
//
//		}
//
//		model.put("errorMessage", "Invalid credentials !! Pls try again...");
//		return "login";
//
//	}
}
