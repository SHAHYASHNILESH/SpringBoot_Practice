package com.LMS.Library_Management_System.service;

import com.LMS.Library_Management_System.entity.UserEntity;
import com.LMS.Library_Management_System.exception.ResourceNotFoundException;

public interface UserService {

	UserEntity saveUser(UserEntity user);

	UserEntity issueBook(Long userId, String bookName) throws ResourceNotFoundException;

	UserEntity returnBook(Long bookId, Long bookId2) throws ResourceNotFoundException;
}
