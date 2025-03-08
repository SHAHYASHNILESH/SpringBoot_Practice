package com.relationships.RelationshipMappings.manyToMany.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relationships.RelationshipMappings.manyToMany.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
