package com.anno.example.annotation.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.anno.example.annotation.demo.service.Pizza;

// Name of bean is same as class name but the first letter is in smaller case
@Component
//@Component("pizzaController")
public class PizzaController {

//  METHOD - 1 (Field Injection)
//	@Autowired
//	private VegPizza vegPizza;

// METHOD - 2 (Constructor Injection)
//	private VegPizza vegPizza;
//	
//	@Autowired
//	public PizzaController(VegPizza vegPizza) {
//		super();
//		this.vegPizza = vegPizza;
//	}

//  METHOD - 3 (Setter Injection)
//	private VegPizza vegPizza;
//
//	@Autowired
//	public void setVegPizza(VegPizza vegPizza) {
//		this.vegPizza = vegPizza;
//	}

	private Pizza pizza;

//	@Autowired
//	public PizzaController(@Qualifier("nonVegPizza") Pizza pizza) {
//		super();
//		this.pizza = pizza;
//	}
	
	@Autowired
	public PizzaController(Pizza pizza) {
		super();
		this.pizza = pizza;
	}
	
	public String getPizza() {

		// return "Hot Pizza!";

		return pizza.getPizza();

	}

}
