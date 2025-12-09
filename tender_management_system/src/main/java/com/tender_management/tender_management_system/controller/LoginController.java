package com.tender_management.tender_management_system.controller;

import com.tender_management.tender_management_system.dto.LoginRequest;
import com.tender_management.tender_management_system.dto.LoginResponse;
import com.tender_management.tender_management_system.service.UserService;
import com.tender_management.tender_management_system.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            UserDetails user = userService.loadUserByUsername(loginRequest.getEmail());
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());
            authenticationProvider.authenticate(usernamePasswordAuthenticationToken);
            String token = jwtUtils.generateToken(user);
            return ResponseEntity.status(200).body(new LoginResponse(token, 200));
        } catch (Exception e) {
            return ResponseEntity.status(404).body("User Doesn't Exists!");
        }
    }
}
