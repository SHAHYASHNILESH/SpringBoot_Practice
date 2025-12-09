package com.tender_management.tender_management_system.repository;

import com.tender_management.tender_management_system.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
