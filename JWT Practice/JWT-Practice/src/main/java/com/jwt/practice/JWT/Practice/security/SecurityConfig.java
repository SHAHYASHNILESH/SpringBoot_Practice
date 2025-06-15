package com.jwt.practice.JWT.Practice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// STEP : 8 - Create SecurityConfig Class

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private JWTAuthFilter jwtAuthFilter;

	@Autowired
	private AuthenticationProvider authenticationProvider;

	@Autowired
	private AuthenticationEntryPoint authEntryPoint;

	private final String[] WHITE_LIST_URLS = { "/login" };

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// STEP : 1: Disable CSRF
		http.csrf(csrf -> csrf.disable());
		// STEP : 2: Change Session Management Policy
		http.sessionManagement(sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		// STEP : 3: Register Custom Filter
		http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
		// STEP : 4: Register Authentication Provider
		http.authenticationProvider(authenticationProvider);
		// STEP : 5: Configure Authorization
		http.authorizeHttpRequests(auth -> auth.requestMatchers(WHITE_LIST_URLS).permitAll()
				.requestMatchers(HttpMethod.POST, "/leave/user").hasAuthority("USER")
				.requestMatchers(HttpMethod.GET, "/leave/user").hasAnyAuthority("ADMIN", "USER")
				.requestMatchers("/leave/comment").hasAuthority("USER").requestMatchers("/leave/status")
				.hasAuthority("ADMIN").requestMatchers("/leave/{id}").hasAuthority("ADMIN")
				.requestMatchers("/leave/days").hasAuthority("ADMIN").anyRequest().authenticated());

		// STEP : 6: Handle Exception
		http.exceptionHandling(ex -> ex.authenticationEntryPoint(authEntryPoint));

		return http.build();
	}
}
