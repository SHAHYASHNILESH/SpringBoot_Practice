package com.demo.springboot.first_rest_api.survey;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SurveyService {

	private static List<Survey> surveys = new ArrayList<>();
	private String string;

	static {

		Question question1 = new Question("Question1", "Most Popular Cloud Platform Today",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
		Question question2 = new Question("Question2", "Fastest Growing Cloud Platform",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
		Question question3 = new Question("Question3", "Most Popular DevOps Tool",
				Arrays.asList("Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");

		List<Question> questions = new ArrayList<>(Arrays.asList(question1, question2, question3));

		Survey survey = new Survey("Survey1", "My Favorite Survey", "Description of the Survey", questions);

		surveys.add(survey);

	}

	public List<Survey> retrieveAllSurveys() {
		// TODO Auto-generated method stub
		return surveys;

	}

	public Survey retrieveSpecificSurvey(String surveyId) {
		// TODO Auto-generated method stub

		for (int i = 0; i < surveys.size(); i++) {

			if (surveys.get(i).getId().equalsIgnoreCase(surveyId)) {

				return surveys.get(i);

			}

		}

		return null;

	}

	public List<Question> retrieveAllSurveyQuestionsById(String surveyId) {

		// TODO Auto-generated method stub

		List<Question> questionsList = new ArrayList<>();

		for (int i = 0; i < surveys.size(); i++) {

			if (surveys.get(i).getId().equalsIgnoreCase(surveyId)) {

				questionsList.addAll(surveys.get(i).getQuestions());

			}

		}

		return questionsList;
	}

	public Question retrieveSpecificSurveyQuestionById(String surveyId, String questionId) {

		// TODO Auto-generated method stub

		for (int i = 0; i < surveys.size(); i++) {

			if (surveys.get(i).getId().equalsIgnoreCase(surveyId)) {

				for (int j = 0; j < surveys.get(i).getQuestions().size(); j++) {

					if (surveys.get(i).getQuestions().get(j).getId().equalsIgnoreCase(questionId)) {

						return surveys.get(i).getQuestions().get(j);

					}

				}

			}

		}

		return null;

	}

	public String addNewSurveyQuestion(String surveyId, Question question) {

		// TODO Auto-generated method stub
		question.setId(generateRandomId());

		for (int i = 0; i < surveys.size(); i++) {

			if (surveys.get(i).getId().equalsIgnoreCase(surveyId))
				surveys.get(i).getQuestions().add(question);

		}

		return question.getId();

	}

	private String generateRandomId() {
		SecureRandom secureRandom = new SecureRandom();
		String randomId = new BigInteger(32, secureRandom).toString();
		return randomId;
	}

	public String deleteSpecificSurveyQuestion(String surveyId, String questionId) {

		// TODO Auto-generated method stub
		boolean isRemoved = false;
		for (int i = 0; i < surveys.size(); i++) {

			if (surveys.get(i).getId().equalsIgnoreCase(surveyId))

				for (int j = 0; j < surveys.get(i).getQuestions().size(); j++) {

					if (surveys.get(i).getQuestions().get(j).getId().equalsIgnoreCase(questionId)) {

						isRemoved = true;
						surveys.get(i).getQuestions().remove(surveys.get(i).getQuestions().get(j));

					}
				}

		}

		if (isRemoved == false)
			return null;
		else
			return questionId;

	}

	public void updateSpecificSurveyQuestion(String surveyId, String questionId, Question question) {

		// TODO Auto-generated method stub
		for (int i = 0; i < surveys.size(); i++) {

			if (surveys.get(i).getId().equalsIgnoreCase(surveyId))

				for (int j = 0; j < surveys.get(i).getQuestions().size(); j++) {

					if (surveys.get(i).getQuestions().get(j).getId().equalsIgnoreCase(questionId)) {

						surveys.get(i).getQuestions().remove(surveys.get(i).getQuestions().get(j));
						surveys.get(i).getQuestions().add(question);

					}

				}

		}

	}

}
