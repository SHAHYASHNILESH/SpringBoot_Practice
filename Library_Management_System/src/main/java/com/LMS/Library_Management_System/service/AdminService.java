package com.LMS.Library_Management_System.service;

import java.util.List;

import com.LMS.Library_Management_System.entity.Book;
import com.LMS.Library_Management_System.entity.UserEntity;
import com.LMS.Library_Management_System.exception.ResourceNotFoundException;

public interface AdminService {

	List<Book> getAllBooks();

	List<UserEntity> getAllUsers();

	UserEntity getUserById(Long id) throws ResourceNotFoundException;

	Book getBookById(Long id) throws ResourceNotFoundException;

}
