package com.assessment.crud_assessment.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExcepHandler {

//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<Map<String, String>> handleExcep(MethodArgumentNotValidException exception) {
//
//		Map<String, String> errorMap = new HashMap<>();
//
//		exception.getBindingResult().getFieldErrors().forEach(error -> {
//			errorMap.put(error.getField(), error.getDefaultMessage());
//		});
//
//		return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
//	}

//	@ExceptionHandler(ResourceNotFoundException.class)
//	public ResponseEntity<Map<String, String>> handleEmployeeNotFoundException(ResourceNotFoundException ex) {
//
//		Map<String, String> errorResponse = new HashMap<>();
//
//		errorResponse.put("error", "Employee Not Found");
//		errorResponse.put("message", ex.getMessage());
//
//		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//
//	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handlingException(ResourceNotFoundException ex) {

		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), ex.getMessage(), "Employee Not Found");
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

	}
}