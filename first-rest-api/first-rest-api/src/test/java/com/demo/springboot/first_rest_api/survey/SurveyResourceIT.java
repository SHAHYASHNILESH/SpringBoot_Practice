package com.demo.springboot.first_rest_api.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

// Order of execution cannot be comtrolled wrt unit tests

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SurveyResourceIT {

	// URL to be hit: http://localhost:8082/surveys/survey1/questions/Question1
	private static String SPECIFIC_QUESTION_URL = "/surveys/survey1/questions/Question1";

	private static String GENERIC_QUESTIONS_URL = "/surveys/survey1/questions";

	@Autowired
	private TestRestTemplate template;

	String str = """
			{
				"id": "Question1",
				"description": "Most Popular Cloud Platform Today",
				"options": [
					"AWS",
					"Azure",
					"Google Cloud",
					"Oracle Cloud"
				],
				"correctAnswer": "AWS"
			}
			""";

	// responseEntity.getBody():
	// {"id":"Question1","description":"Most Popular Cloud Platform
	// Today","options":["AWS","Azure","Google Cloud","Oracle
	// Cloud"],"correctAnswer":"AWS"}

	// responseEntity.getHeaders():
	// [Content-Type:"application/json", Transfer-Encoding:"chunked", Date:"Sun, 02
	// Feb 2025 13:25:52 GMT", Keep-Alive:"timeout=60", Connection:"keep-alive"]

	@Test
	void retrieveSpecificSurveyQuestionById_basicScenario() throws JSONException {

		ResponseEntity<String> responseEntity = template.getForEntity(SPECIFIC_QUESTION_URL, String.class);

		String expectedResponse = """
				{"id":"Question1","description":"Most Popular Cloud Platform Today","correctAnswer":"AWS"}
				""";

		// Status of Response is 200?
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());

		// [Content-Type:"application/json"?
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));

		// To avoid comparing all the attributes in actual and expected response, we use
		// false as third parameter in JSONAssert.assertEquals(expected,actual,false)
		// Expected response has attributes: id,description, correctAnswer which will be
		// compared in actual response
		JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);

		// assertEquals(expectedResponse.trim(), responseEntity.getBody());

		System.out.println(responseEntity.getBody());
		System.out.println(responseEntity.getHeaders());

	}

	@Test
	void retrieveAllSurveyQuestionsById_basicScenario() throws JSONException {

		ResponseEntity<String> responseEntity = template.getForEntity(GENERIC_QUESTIONS_URL, String.class);

		String expectedResponse = """
						[
							{
								"id": "Question1",
								"description": "Most Popular Cloud Platform Today",
								"options": [
									"AWS",
									"Azure",
									"Google Cloud",
									"Oracle Cloud"
								],
								"correctAnswer": "AWS"
							},
							{
								"id": "Question2",
								"description": "Fastest Growing Cloud Platform",
								"options": [
									"AWS",
									"Azure",
									"Google Cloud",
									"Oracle Cloud"
								],
								"correctAnswer": "Google Cloud"
							},
							{
								"id": "Question3",
								"description": "Most Popular DevOps Tool",
								"options": [
									"Kubernetes",
									"Docker",
									"Terraform",
									"Azure DevOps"
								],
								"correctAnswer": "Kubernetes"
							}
						]
				""";

		// Status of Response is 200?
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());

		// [Content-Type:"application/json"?
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));

		JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), true);

	}

	@Test
	void addNewSurveyQuestion_basicScenario() {

		// RequestBody
		String requestBody = """
								{
								    "description": "Your Favourite Cloud Platform",
								    "options": [
								        "AWS",
								        "Azure",
								        "Google Cloud",
								        "Oracle Cloud"
								    ],
								    "correctAnswer": "AWS"
								}
				""";

		// Content-Type: application/json
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");

		// Represents an HTTP request or response entity consisting of headers and body
		HttpEntity<String> httpEntity = new HttpEntity<String>(requestBody, headers);

		// http://localhost:8082/surveys/survey1/questions
		// POST
		ResponseEntity<String> responseEntity = template.exchange(GENERIC_QUESTIONS_URL, HttpMethod.POST, httpEntity,
				String.class);
		System.out.println(responseEntity.getBody());
		System.out.println(responseEntity.getHeaders());

		// ASSERTS
		// 201 status code
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());

		// Location:
		// http://localhost:{RANDOM_PORT}/surveys/survey1/questions/{RANDOM_ID}
		String locationHeader = responseEntity.getHeaders().get("Location").get(0);
		assertTrue(locationHeader.contains("/surveys/survey1/questions/"));

		// DELETE
		// locationHeader
		template.delete(locationHeader);
	}
}
