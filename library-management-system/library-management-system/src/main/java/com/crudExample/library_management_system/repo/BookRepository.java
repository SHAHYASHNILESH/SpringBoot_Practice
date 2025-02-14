package com.crudExample.library_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudExample.library_management_system.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
