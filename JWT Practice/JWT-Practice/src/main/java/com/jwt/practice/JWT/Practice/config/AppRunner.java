package com.jwt.practice.JWT.Practice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.jwt.practice.JWT.Practice.model.Role;
import com.jwt.practice.JWT.Practice.model.User;
import com.jwt.practice.JWT.Practice.repo.RoleRepository;
import com.jwt.practice.JWT.Practice.repo.UserRepository;

// STEP : 9 - Create AppRunner

@Component
public class AppRunner implements ApplicationRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Role role1 = new Role();
		role1.setRoleName("ADMIN");

		Role role2 = new Role();
		role2.setRoleName("USER");

		Role saveRole1 = roleRepository.save(role1);
		Role saveRole2 = roleRepository.save(role2);

		User user1 = new User();
		user1.setEmail("yash@gmail.com");
		user1.setPassword("1234");
		user1.setRole(saveRole1);

		User user2 = new User();
		user2.setEmail("yash1@gmail.com");
		user2.setPassword("1234");
		user2.setRole(saveRole2);
		
		User user3 = new User();
		user3.setEmail("yash2@gmail.com");
		user3.setPassword("1234");
		user3.setRole(saveRole2);

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);

	}
}
