package com.relationships.RelationshipMappings.manyToMany.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relationships.RelationshipMappings.manyToMany.entity.Student;
import com.relationships.RelationshipMappings.manyToMany.entity.Subjects;
import com.relationships.RelationshipMappings.manyToMany.exception.ResourceNotFoundException;
import com.relationships.RelationshipMappings.manyToMany.repo.StudentRepository;
import com.relationships.RelationshipMappings.manyToMany.repo.SubjectRepository;

@Service
public class SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private StudentRepository studentRepository;

	public List<Subjects> getSubjects() {

		return subjectRepository.findAll();

	}

	public Subjects addSubject(Subjects subject) {

		return subjectRepository.save(subject);

	}

	public Subjects addSubjectForStudent(Long subid, Long sid) throws ResourceNotFoundException {

		Subjects subject = subjectRepository.findById(subid)
				.orElseThrow(() -> new ResourceNotFoundException("Subject Not Found"));
		
		Student student = studentRepository.findById(sid)
				.orElseThrow(() -> new ResourceNotFoundException("Student Not Found"));

		Set<Student> enrolledStudents = new HashSet<>();
		enrolledStudents.add(student);

		subject.setEnrolledStudents(enrolledStudents);

		return subjectRepository.save(subject);

	}

}
