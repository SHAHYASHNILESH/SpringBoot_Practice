package com.anno.example.annotation.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.anno.example.annotation.demo.service.Pizza;
import com.anno.example.annotation.demo.service.VegPizza;

@Configuration
public class AppConfig {

	@Bean
	// @Bean(name="vegPizzaBean")
	public Pizza vegPizza() {

		return new VegPizza();

	}
}
