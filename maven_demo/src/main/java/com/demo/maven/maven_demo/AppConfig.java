package com.demo.maven.maven_demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Responsible for giving objects
@Configuration
public class AppConfig {

	@Bean
	public Samsung getPhone() {

		return new Samsung();
	}

	@Bean
	public MobileProcessor getCPU() {

		return new Snapdragon();
	}
}
