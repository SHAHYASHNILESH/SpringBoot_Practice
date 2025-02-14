package com.crudExample.library_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crudExample.library_management_system.entity.Book;
import com.crudExample.library_management_system.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	// GET: Get all Books
	@GetMapping("/books")
	public List<Book> getAllBooks() {

		return bookService.getAllBooks();

	}

	// GET: Get Book by ID
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable Long id) {

		return bookService.getBookById(id);

	}

	// POST: Add new Book
	@PostMapping("/books")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void addBook(@RequestBody Book book) {

		bookService.addBook(book);

	}

	// PUT: Update Book By Id
	@PutMapping("/books/{id}")
	public Book updateBook(@PathVariable Long id, @RequestBody Book book) {

		return bookService.updateBook(id, book);

	}

	// DELETE: Delete Book By Id
	@DeleteMapping("/books/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteBookById(@PathVariable Long id) {

		bookService.deleteBookById(id);

	}
}
