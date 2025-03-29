package com.file_upload_download.example.storage_service.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.file_upload_download.example.storage_service.entity.FileData;
import com.file_upload_download.example.storage_service.exception.ResourceNotFoundException;
import com.file_upload_download.example.storage_service.repo.StorageRepository;
import com.file_upload_download.example.storage_service.utils.ImageUtils;

@Service
public class StorageService {

	@Autowired
	private StorageRepository storageRepository;

	public FileData uploadFile(MultipartFile file) throws IOException {

		return storageRepository.save(new FileData(file.getOriginalFilename(), file.getContentType(),
				ImageUtils.compressImage(file.getBytes())));

	}

	public FileData downloadFile(String fileName) throws ResourceNotFoundException {

		FileData fileData = storageRepository.findImgByName(fileName)
				.orElseThrow(() -> new ResourceNotFoundException("File Not Found"));

		fileData.setData(ImageUtils.decompressImage(fileData.getData()));
		return fileData;

	}
}
