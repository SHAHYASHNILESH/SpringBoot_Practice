package com.file_upload_download.example.storage_service.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.file_upload_download.example.storage_service.entity.FileData;
import com.file_upload_download.example.storage_service.service.StorageService;

@RestController
public class StorageController {

	@Autowired
	private StorageService storageService;

	@PostMapping("/storage/upload")
	public ResponseEntity<?> uploadFile(@RequestParam MultipartFile file) throws IOException {
		FileData uploadFile = storageService.uploadFile(file);
		return new ResponseEntity<>(uploadFile, HttpStatus.CREATED);
	}

	@GetMapping("/storage/download")
	public ResponseEntity<?> downloadFile(@RequestParam String fileName) throws IOException {
		FileData downloadFile = storageService.downloadFile(fileName);

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(downloadFile.getType()))
				.body(downloadFile.getData());
	}
}
