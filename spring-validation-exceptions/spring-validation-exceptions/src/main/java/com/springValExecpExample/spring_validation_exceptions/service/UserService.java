package com.springValExecpExample.spring_validation_exceptions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springValExecpExample.spring_validation_exceptions.advice.UserNotFoundException;
import com.springValExecpExample.spring_validation_exceptions.dto.UserRequest;
import com.springValExecpExample.spring_validation_exceptions.entity.User;
import com.springValExecpExample.spring_validation_exceptions.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	public User getUserById(Integer id) throws UserNotFoundException {

		return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

	}

	public User addUser(UserRequest userRequest) {

		User u = new User();

		u.setName(userRequest.getName());
		u.setAddress(userRequest.getAddress());
		u.setEmail(userRequest.getEmail());
		u.setAge(userRequest.getAge());
		u.setSalary(userRequest.getSalary());

		return userRepo.save(u);
	}
}
