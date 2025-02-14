package com.crud.example.crud_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.example.crud_demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByName(String name);

}
