package com.demo.maven.maven_demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

//		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//
//		Vehicle obj = (Vehicle) context.getBean("car");
//		obj.drive();

//		Tyre t = (Tyre) context.getBean("tyre");
//		System.out.println(t);

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		Samsung s7 = context.getBean(Samsung.class);
		s7.config();
	}
}
