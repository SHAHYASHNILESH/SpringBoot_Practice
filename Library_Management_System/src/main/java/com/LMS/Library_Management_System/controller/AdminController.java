package com.LMS.Library_Management_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.LMS.Library_Management_System.entity.Book;
import com.LMS.Library_Management_System.entity.UserEntity;
import com.LMS.Library_Management_System.exception.ResourceNotFoundException;
import com.LMS.Library_Management_System.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/admin/books")
	public List<Book> getAllBooks() {
		return adminService.getAllBooks();
	}

	@GetMapping("/admin/users")
	public List<UserEntity> getAllUsers() {
		return adminService.getAllUsers();
	}

	@GetMapping("/admin/users/{id}")
	public UserEntity getUserById(@PathVariable Long id) throws ResourceNotFoundException {
		return adminService.getUserById(id);
	}

	@GetMapping("/admin/books/{id}")
	public Book getBookById(@PathVariable Long id) throws ResourceNotFoundException {
		return adminService.getBookById(id);
	}
}
