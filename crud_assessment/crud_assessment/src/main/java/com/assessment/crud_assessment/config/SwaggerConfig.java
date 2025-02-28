package com.assessment.crud_assessment.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI myCustomeConfig() {

		return new OpenAPI().info(new Info().title("Employee Management System APIs").description("By Yash shah"))
				.servers(List.of(new Server().url("http://localhost:8080").description("Local Server"),
						new Server().url("http://localhost:8080").description("Live Server")))

				.tags(List.of(

						new Tag().name("Employee Management APIs")));

	}
}
