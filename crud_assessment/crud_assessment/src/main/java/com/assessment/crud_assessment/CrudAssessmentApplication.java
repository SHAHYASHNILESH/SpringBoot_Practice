package com.assessment.crud_assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CrudAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAssessmentApplication.class, args);
	}

}
