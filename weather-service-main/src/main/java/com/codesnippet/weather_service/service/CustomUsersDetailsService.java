package com.codesnippet.weather_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codesnippet.weather_service.repository.UsersRepository;

@Service
public class CustomUsersDetailsService implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return usersRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Username Not Found"));
	}

}
