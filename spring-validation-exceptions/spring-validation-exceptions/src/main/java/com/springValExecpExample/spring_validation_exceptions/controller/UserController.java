package com.springValExecpExample.spring_validation_exceptions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springValExecpExample.spring_validation_exceptions.advice.UserNotFoundException;
import com.springValExecpExample.spring_validation_exceptions.dto.UserRequest;
import com.springValExecpExample.spring_validation_exceptions.entity.User;
import com.springValExecpExample.spring_validation_exceptions.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable Integer id) throws UserNotFoundException {
		return userService.getUserById(id);
	}

	@PostMapping("/users")
	@ResponseStatus(HttpStatus.CREATED)
	public User addUser(@RequestBody @Valid UserRequest userRequest) {
		return userService.addUser(userRequest);
	}
}
