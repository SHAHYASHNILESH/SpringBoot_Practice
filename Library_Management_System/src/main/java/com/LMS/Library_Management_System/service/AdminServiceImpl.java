package com.LMS.Library_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.Library_Management_System.entity.Book;
import com.LMS.Library_Management_System.entity.UserEntity;
import com.LMS.Library_Management_System.exception.ResourceNotFoundException;
import com.LMS.Library_Management_System.exception.ResourceNotFoundException;
import com.LMS.Library_Management_System.repository.BookRepository;
import com.LMS.Library_Management_System.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BookRepository bookRepo;

	@Override
	public List<Book> getAllBooks() {

		return bookRepo.findAll();

	}

	@Override
	public List<UserEntity> getAllUsers() {

		return userRepo.findAll();

	}

	@Override
	public UserEntity getUserById(Long id) throws ResourceNotFoundException {

		return userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));

	}
	
	@Override
	public Book getBookById(Long id) throws ResourceNotFoundException {

		return bookRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book Not Found"));

	}

}
