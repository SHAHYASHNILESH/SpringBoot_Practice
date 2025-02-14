package com.demo.springboot.first_rest_api.helloworld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HelloWorldResource {

	// hello-world => Hello World
	@RequestMapping("hello-world")
	// @ResponseBody
	public String sayHello() {

		return "Hello World!";

	}

	@RequestMapping("hello-world-bean")
	// @ResponseBody
	public HelloWorldBean sayHelloBean() {

		return new HelloWorldBean("Hello World!");

	}

	@RequestMapping("hello-world-path-param/{name}")
	// @ResponseBody
	public HelloWorldBean sayHelloPathParam(@PathVariable String name) {

		return new HelloWorldBean("Hello World, " + name);

	}

	// http://localhost:8082/hello-world-path-param/ranga/message/hola
	@RequestMapping("hello-world-path-param/{name}/message/{message}")
	// @ResponseBody
	public HelloWorldBean sayHelloMultiplePathParam(@PathVariable String name, @PathVariable String message) {

		return new HelloWorldBean("Hello World " + name + ", " + message);

	}
}
