package com.ecomm.app.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.app.ecommerce.dto.AuthRequest;
import com.ecomm.app.ecommerce.dto.JwtResponse;
import com.ecomm.app.ecommerce.service.JwtService;

@RestController
@RequestMapping("/api/public")
public class LoginController {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationProvider authenticationProvider;

	@Autowired
	private JwtService jwtService;

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody AuthRequest authRequest) {
		try {
			UserDetails user = userDetailsService.loadUserByUsername(authRequest.getUsername());
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					authRequest.getUsername(), authRequest.getPassword());
			authenticationProvider.authenticate(usernamePasswordAuthenticationToken);
			String token = jwtService.generateToken(user.getUsername());

			return ResponseEntity.status(200).body(new JwtResponse(token, 200));
		} catch (Exception e) {
			return ResponseEntity.status(404).build();
		}
	}
}
