package com.file_upload_download.example.storage_service.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.file_upload_download.example.storage_service.exception.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex) {

		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("errorMessage", ex.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);

	}
}
