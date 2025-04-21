package com.webhook.example.webhook_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webhook.example.webhook_demo.entity.SchoolData;

public interface SchoolDataRepository extends JpaRepository<SchoolData, Long> {

}
