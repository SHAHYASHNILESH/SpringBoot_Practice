package com.codesnippet.weather_service.filters;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.codesnippet.weather_service.service.CustomUsersDetailsService;
import com.codesnippet.weather_service.utils.JWTUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {
	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private CustomUsersDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String header = request.getHeader("Authorization");
		String tokenString = null;
		String username = null;

		if (header != null && header.startsWith("Bearer ")) {
			tokenString = header.substring(7);
			username = jwtUtil.extractUsername(tokenString);
		}
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userByUsername = userDetailsService.loadUserByUsername(username);
			if (jwtUtil.validateToken(username, userByUsername, tokenString)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userByUsername, null, userByUsername.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		filterChain.doFilter(request, response);
	}

}
