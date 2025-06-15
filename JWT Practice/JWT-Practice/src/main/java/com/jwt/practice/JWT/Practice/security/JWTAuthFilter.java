package com.jwt.practice.JWT.Practice.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jwt.practice.JWT.Practice.service.UserService;
import com.jwt.practice.JWT.Practice.util.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// STEP : 6 - Create JWTAuthFilter Class

@Component
public class JWTAuthFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// Extract Authentication Token from Request Header
		String authHeader = request.getHeader("Authorization");
		
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			// Proceed with remaining filters
			filterChain.doFilter(request, response);
			return;
		}

		// JWT Purpose
		String token = authHeader.substring(7);

		// Extracting username from token
		String username = jwtUtil.extractUsername(token);

		// User not authenticated
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails user = userDetailsService.loadUserByUsername(username);
			
			if (user != null && jwtUtil.validateToken(token, user)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						username, null, user.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetails(request));

				// Update my user as Valid user
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}

		// Continue with remaining filters
		filterChain.doFilter(request, response);
	}

}
