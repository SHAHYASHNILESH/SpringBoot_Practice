package com.LMS.Library_Management_System.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.Library_Management_System.entity.Book;
import com.LMS.Library_Management_System.entity.UserEntity;
import com.LMS.Library_Management_System.exception.ResourceNotFoundException;
import com.LMS.Library_Management_System.repository.BookRepository;
import com.LMS.Library_Management_System.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BookRepository bookRepo;

	@Override
	public UserEntity saveUser(UserEntity user) {

//		user.getBooks().forEach(book -> book.setUser(user));
		return userRepo.save(user);

	}

	@Override
	public UserEntity issueBook(Long userId, String bookName) throws ResourceNotFoundException {

		UserEntity user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));

		Book bookByName = bookRepo.findByBookName(bookName);

		if (bookByName.isAvailabilityStatus() && user.getBooks().size() < 1) {

			bookByName.setUser(user);
			bookByName.setBorrowDate(LocalDate.now());
			bookByName.setReturnDate(LocalDate.now().plusDays(30));
			bookByName.setAvailabilityStatus(false);
			return userRepo.save(user);

		}

		else if (user.getBooks().size() >= 1) {

			throw new ResourceNotFoundException("One Book can be Issued per day by user");

		}

		throw new ResourceNotFoundException("Book Not Available In the Library");

	}

	@Override
	public UserEntity returnBook(Long id, Long bookId) throws ResourceNotFoundException {

		Book bookById = bookRepo.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book Not Found"));

		UserEntity user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));

		bookById.setAvailabilityStatus(true);
		bookById.setBorrowDate(null);
		bookById.setReturnDate(null);

		for (int i = 0; i < user.getBooks().size(); i++) {

			if (user.getBooks().get(i).getBookId() == bookId) {

				user.getBooks().remove(i);

			}
		}

		bookRepo.save(bookById);

		return userRepo.save(user);

	}
}
