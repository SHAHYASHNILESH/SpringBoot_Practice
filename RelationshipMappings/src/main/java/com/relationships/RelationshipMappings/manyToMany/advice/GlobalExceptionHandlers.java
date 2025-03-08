package com.relationships.RelationshipMappings.manyToMany.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.relationships.RelationshipMappings.manyToMany.exception.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandlers {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleException(ResourceNotFoundException e) {

		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("error Message", e.getMessage());

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

	}

}