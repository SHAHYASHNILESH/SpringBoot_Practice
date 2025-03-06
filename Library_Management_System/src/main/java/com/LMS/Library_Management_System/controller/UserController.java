package com.LMS.Library_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.LMS.Library_Management_System.entity.UserEntity;
import com.LMS.Library_Management_System.exception.ResourceNotFoundException;
import com.LMS.Library_Management_System.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/users")
	public UserEntity saveUser(@RequestBody UserEntity user) {
		return userService.saveUser(user);
	}

	@PostMapping("/issue-book/{id}/{title}")
	public ResponseEntity<?> issueBook(@PathVariable Long id, @PathVariable String title)
			throws ResourceNotFoundException {

		UserEntity issueBook = userService.issueBook(id, title);

		return new ResponseEntity<>(
				("Book Issued Successfully! Book to be returned on " + issueBook.getBooks().get(0).getReturnDate()),
				HttpStatus.OK);

	}

	@PutMapping("/return-book/{id}/{bookId}")
	public ResponseEntity<?> returnBook(@PathVariable Long id,@PathVariable Long bookId) throws ResourceNotFoundException {

		UserEntity issueBook = userService.returnBook(id,bookId);

		return new ResponseEntity<>("Book Returned Successfully!", HttpStatus.OK);

	}
}
