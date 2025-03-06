package com.LMS.Library_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.LMS.Library_Management_System.entity.Book;
import com.LMS.Library_Management_System.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping("/books")
	public Book saveBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}
}
