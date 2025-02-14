package com.demo.springboot.first_rest_api.survey;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class SurveyResource {

	private SurveyService surveyService;

	public SurveyResource(SurveyService surveyService) {
		super();
		this.surveyService = surveyService;
	}

	@RequestMapping("surveys")
	public List<Survey> retrieveAllSurveys() {

		return surveyService.retrieveAllSurveys();

	}

	@RequestMapping("surveys/{surveyId}")
	public Survey retrieveSpecificSurvey(@PathVariable String surveyId) {

		Survey specificSurvey = surveyService.retrieveSpecificSurvey(surveyId);
		if (specificSurvey == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		return specificSurvey;

	}

	@RequestMapping("surveys/{surveyId}/questions")
	public List<Question> retrieveAllSurveyQuestionsById(@PathVariable String surveyId) {

		List<Question> allSurveyQuestionsById = surveyService.retrieveAllSurveyQuestionsById(surveyId);

		if (allSurveyQuestionsById.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		return allSurveyQuestionsById;

	}

	@RequestMapping("surveys/{surveyId}/questions/{questionId}")
	public Question retrieveSpecificSurveyQuestionById(@PathVariable String surveyId, @PathVariable String questionId) {

		Question specificSurveyQuestionById = surveyService.retrieveSpecificSurveyQuestionById(surveyId, questionId);

		if (specificSurveyQuestionById == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		return specificSurveyQuestionById;

	}

	@RequestMapping(value = "surveys/{surveyId}/questions", method = RequestMethod.POST)
	public ResponseEntity<Object> addNewSurveyQuestion(@PathVariable String surveyId, @RequestBody Question question) {

		String qId = surveyService.addNewSurveyQuestion(surveyId, question);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{qId}").buildAndExpand(qId).toUri();

		return ResponseEntity.created(location).build();

	}

	@RequestMapping(value = "surveys/{surveyId}/questions/{questionId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteSpecificSurveyQuestion(@PathVariable String surveyId,
			@PathVariable String questionId) {

		String qId = surveyService.deleteSpecificSurveyQuestion(surveyId, questionId);

		return ResponseEntity.noContent().build();

	}

	@RequestMapping(value = "surveys/{surveyId}/questions/{questionId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateSpecificSurveyQuestion(@PathVariable String surveyId,
			@PathVariable String questionId, @RequestBody Question question) {

		surveyService.updateSpecificSurveyQuestion(surveyId, questionId, question);

		return ResponseEntity.noContent().build();
		
	}
}
