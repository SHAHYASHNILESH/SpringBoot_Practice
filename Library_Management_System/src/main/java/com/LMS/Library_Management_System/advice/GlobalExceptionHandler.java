package com.LMS.Library_Management_System.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.LMS.Library_Management_System.exception.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleException(ResourceNotFoundException e) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("errorMessage", e.getMessage());
		return new ResponseEntity<>(errorMap, HttpStatus.NOT_FOUND);
	}
}
