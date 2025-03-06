package com.LMS.Library_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.Library_Management_System.entity.Book;
import com.LMS.Library_Management_System.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book saveBook(Book book) {

		return bookRepository.save(book);
	}

}
