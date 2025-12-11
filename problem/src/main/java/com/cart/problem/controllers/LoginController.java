package com.cart.problem.controllers;

import com.cart.problem.dto.AuthRequest;
import com.cart.problem.dto.JwtResponse;
import com.cart.problem.models.UserInfo;
import com.cart.problem.repo.UserRepository;
import com.cart.problem.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/public")
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        try {
            Optional<UserInfo> optionalUserInfo = userRepository.findByUsername(authRequest.getUsername());
            if (!optionalUserInfo.isPresent()) {
                return ResponseEntity.status(400).build();
            }

            UserInfo userInfo = optionalUserInfo.get();
            if (!userInfo.getPassword().equalsIgnoreCase(authRequest.getPassword())) {
                return ResponseEntity.status(401).build();
            }

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
            authenticationProvider.authenticate(usernamePasswordAuthenticationToken);

            String token = jwtService.generateToken(userInfo.getUsername());
            return ResponseEntity.status(200).body(new JwtResponse(token, 200));
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

}
