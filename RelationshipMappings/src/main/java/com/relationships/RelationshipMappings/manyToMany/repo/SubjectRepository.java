package com.relationships.RelationshipMappings.manyToMany.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relationships.RelationshipMappings.manyToMany.entity.Subjects;

public interface SubjectRepository extends JpaRepository<Subjects, Long> {

}
