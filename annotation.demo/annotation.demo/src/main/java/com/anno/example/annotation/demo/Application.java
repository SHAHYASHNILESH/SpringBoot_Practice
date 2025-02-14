package com.anno.example.annotation.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anno.example.annotation.demo.controller.MyController;
import com.anno.example.annotation.demo.controller.PizzaController;
import com.anno.example.annotation.demo.lazy.LazyLoader;
import com.anno.example.annotation.demo.repository.MyRepository;
import com.anno.example.annotation.demo.service.MyService;
import com.anno.example.annotation.demo.service.VegPizza;
import com.anno.example.annotation.demo.value.ValueAnnotationDemo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		var context = SpringApplication.run(Application.class, args);
		PizzaController pizzaController = context.getBean(PizzaController.class);
//		 PizzaController pizzaController =(PizzaController)context.getBean("pizzaController");
		System.out.println(pizzaController.getPizza());

		VegPizza vegPizza = context.getBean(VegPizza.class);
//		 VegPizza vegPizza = (VegPizza) context.getBean("vegPizzaBean");
		System.out.println(vegPizza.getPizza());

		MyController myController = context.getBean(MyController.class);
		System.out.println(myController.hello());

		MyService myService = context.getBean(MyService.class);
		System.out.println(myService.hello());

		MyRepository myRepository = context.getBean(MyRepository.class);
		System.out.println(myRepository.hello());

		LazyLoader lazyLoader = context.getBean(LazyLoader.class);

		ValueAnnotationDemo valueAnno = context.getBean(ValueAnnotationDemo.class);
		System.out.println(valueAnno.getDefaultName());

		// Reading values from application.properties file using @Value("${key name}")
		// In application.properties, key=value pair : mail.host=gmail.com
		System.out.println(valueAnno.getHost());
		System.out.println(valueAnno.getPassword());

		System.out.println(valueAnno.getJavaHome());
		//System.out.println(valueAnno.getHomeDir());
	}

}
