package com.crud.example.crud_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.crud.example.crud_demo.controller.StudentController;

@SpringBootApplication
public class CrudDemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	public static void main(String[] args) {
		logger.info("I am inside main method");
		SpringApplication.run(CrudDemoApplication.class, args);
	}

}
