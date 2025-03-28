package com.file_upload_download.example.storage_service.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.file_upload_download.example.storage_service.entity.FileData;

public interface StorageRepository extends JpaRepository<FileData, Long> {

	Optional<FileData> findImgByName(String name);
}
