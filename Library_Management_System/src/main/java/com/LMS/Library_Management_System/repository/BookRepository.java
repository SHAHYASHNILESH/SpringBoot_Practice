package com.LMS.Library_Management_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.LMS.Library_Management_System.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM Book WHERE title = :title")
	public Book findByBookName(@Param("title") String title);
}
