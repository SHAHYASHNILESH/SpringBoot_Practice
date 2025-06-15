package com.jwt.practice.JWT.Practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.practice.JWT.Practice.model.LoginRequest;
import com.jwt.practice.JWT.Practice.model.LoginResponse;
import com.jwt.practice.JWT.Practice.util.JwtUtil;

// STEP : 10 - Create LoginController

@RestController
public class LoginController {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationProvider authenticationProvider;

//	@GetMapping("/hello")
//	public String hello() {
//		return "hello";
//	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

		try {
			// Fetch user from DB
			UserDetails user = userDetailsService.loadUserByUsername(loginRequest.getEmail());
			System.out.println(user);

			// Validate user
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					loginRequest.getEmail(), loginRequest.getPassword());
			authenticationProvider.authenticate(usernamePasswordAuthenticationToken);

			String token = jwtUtil.generateToken(user);

			return ResponseEntity.ok(new LoginResponse(token));
		} catch (UsernameNotFoundException e) {
			return ResponseEntity.status(404).body("User Does not exist");
		}

	}
}
