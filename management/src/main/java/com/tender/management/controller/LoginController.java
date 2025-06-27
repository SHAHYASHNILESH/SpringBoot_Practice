package com.tender.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tender.management.dto.JwtResponse;
import com.tender.management.dto.LoginDTO;
import com.tender.management.security.JWTUtil;
import com.tender.management.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private LoginService loginService;

	@Autowired
	private AuthenticationProvider authenticationProvider;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
		try {
			UserDetails user = loginService.loadUserByUsername(loginDTO.getEmail());
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					loginDTO.getEmail(), loginDTO.getPassword());
			authenticationProvider.authenticate(usernamePasswordAuthenticationToken);

			String token = jwtUtil.generateToken(loginDTO.getEmail());
			return ResponseEntity.ok(new JwtResponse(token, 200));
		} catch (Exception e) {
			return ResponseEntity.status(400).build();
		}
	}
}
