package com.anno.example.annotation.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class MyController {

	public String hello() {

		return "hello controller!";

	}

	@RequestMapping(value = { "/hello", "/hello-world", "/world" })
	// @ResponseStatus(value=HttpStatus.CREATED)
	// @ResponseBody
	public String sayHello() {

		return "Hello World!";
	}

	@GetMapping("/helloWorld/{id}")
	public String sayHelloWorld(@PathVariable int id) {

		return "Hello World!" + id;

	}

	// http://localhost:8080/demo/hello/world?id=2
	@GetMapping("/hello/world")
	public String sayHelloWorld1(@RequestParam int id) {

		return "Hello World!" + id;

	}
}
