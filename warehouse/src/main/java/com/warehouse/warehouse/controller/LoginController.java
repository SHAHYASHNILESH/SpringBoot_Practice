package com.warehouse.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.warehouse.dto.AuthRequest;
import com.warehouse.warehouse.dto.JwtResponse;
import com.warehouse.warehouse.service.JwtService;
import com.warehouse.warehouse.service.UserInfoService;

@RestController
@RequestMapping("/api/public")
public class LoginController {

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private AuthenticationProvider authenticationProvider;

	@Autowired
	private JwtService jwtService;

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody AuthRequest authRequest) {
		try {
			UserDetails user = userInfoService.loadUserByUsername(authRequest.getUsername());
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					authRequest.getUsername(), authRequest.getPassword());
			authenticationProvider.authenticate(usernamePasswordAuthenticationToken);
			String token = jwtService.generateToken(user.getUsername());
			return ResponseEntity.status(200).body(new JwtResponse(token, 200));
		} catch (Exception e) {
			return ResponseEntity.status(400).build();
		}
	}
}
