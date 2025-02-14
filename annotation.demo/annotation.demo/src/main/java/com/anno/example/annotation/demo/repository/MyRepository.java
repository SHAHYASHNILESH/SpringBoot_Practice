package com.anno.example.annotation.demo.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {

	public String hello() {

		return "hello repo!";

	}

}
