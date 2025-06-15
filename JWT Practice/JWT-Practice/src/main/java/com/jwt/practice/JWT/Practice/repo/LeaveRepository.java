package com.jwt.practice.JWT.Practice.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jwt.practice.JWT.Practice.model.Leave;

public interface LeaveRepository extends JpaRepository<Leave, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM Leave where leave_id = :id")
	Optional<Leave> findLeavesByUsername(Long id);
}
