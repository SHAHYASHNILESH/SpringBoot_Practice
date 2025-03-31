package com.relationships.RelationshipMappings.manyToMany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.relationships.RelationshipMappings.manyToMany.entity.Subjects;
import com.relationships.RelationshipMappings.manyToMany.exception.ResourceNotFoundException;
import com.relationships.RelationshipMappings.manyToMany.service.SubjectService;

@RestController
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	@GetMapping("/subjects")
	public List<Subjects> getSubjects() {

		return subjectService.getSubjects();

	}

	@PostMapping("/subjects")
	public Subjects addSubject(@RequestBody Subjects subject) {

		return subjectService.addSubject(subject);

	}

	@PostMapping("/subjects/{subid}/students/{sid}")
	public Subjects addSubjectForStudent(@PathVariable Long subid, @PathVariable Long sid) throws ResourceNotFoundException {

		return subjectService.addSubjectForStudent(subid, sid);

	}

}
