package com.demo.springboot.first_rest_api.user;

import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.catalina.Group;
import org.apache.catalina.Role;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsCommandLineRunner implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private UserDetailsRepository userDetailsRepository;

	public UserDetailsCommandLineRunner(UserDetailsRepository userDetailsRepository) {
		super();
		this.userDetailsRepository = userDetailsRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		// TODO Auto-generated method stub

		logger.info(Arrays.toString(args));

		userDetailsRepository.save(new UserDetails("Yash", "Admin"));
		userDetailsRepository.save(new UserDetails("Ranga", "Admin"));
		userDetailsRepository.save(new UserDetails("Ravi", "User"));

		// List<UserDetails> users = userDetailsRepository.findAll();

		List<UserDetails> users = userDetailsRepository.findByRole("Admin");

		users.forEach(user -> logger.info(user.toString()));

	}

}
