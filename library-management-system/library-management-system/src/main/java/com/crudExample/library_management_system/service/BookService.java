package com.crudExample.library_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudExample.library_management_system.entity.Book;
import com.crudExample.library_management_system.repo.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;

	public List<Book> getAllBooks() {

		return bookRepo.findAll();

	}

	public Book getBookById(Long id) {

		return bookRepo.findById(id).get();

	}

	public void addBook(Book book) {

		bookRepo.save(book);

	}

	public Book updateBook(Long id, Book book) {

		Book bk = bookRepo.findById(id).get();

		bk.setTitle(book.getTitle());
		bk.setAuthor(book.getAuthor());
		bk.setIsbn(book.getIsbn());
		bk.setAvailable(book.isAvailable());

		Book newBook = bookRepo.save(bk);

		return newBook;

	}

	public void deleteBookById(Long id) {

		bookRepo.deleteById(id);

	}
}
