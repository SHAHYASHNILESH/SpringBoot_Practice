package com.webhook.example.webhook_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.webhook.example.webhook_demo.entity.SchoolData;
import com.webhook.example.webhook_demo.entity.Student;
import com.webhook.example.webhook_demo.entity.WebhookData;
import com.webhook.example.webhook_demo.repository.SchoolDataRepository;

@RestController
public class SchoolDataController {

	@Autowired
	private SchoolDataRepository schoolDataRepository;

	@PostMapping("/add-school")
	public SchoolData registerSchool(@RequestParam String schoolName) {

		SchoolData sData = new SchoolData();
		sData.setSchoolName(schoolName);
		schoolDataRepository.save(sData);

		return sData;

	}

	@PostMapping("/add-webhook")
	public String addWebhookData(@RequestParam Long schoolId, @RequestBody WebhookData webhookData) {

		SchoolData byId = schoolDataRepository.findById(schoolId).get();

		List<WebhookData> webhookDatas = byId.getWebhookDataList();

		webhookDatas.add(webhookData);
		webhookData.setSchoolWebhook(byId);
		schoolDataRepository.save(byId);

		return "Webhook added";

	}

	@PostMapping("/add-student")
	public String addStudentData(@RequestParam Long schoolId, @RequestBody Student studentData) {

		SchoolData byId = schoolDataRepository.findById(schoolId).get();

		List<Student> students = byId.getStudentDataList();

		students.add(studentData);
		studentData.setSchoolData(byId); 
		schoolDataRepository.save(byId);

		WebhookData webhookData = byId.getWebhookDataList().stream().filter(w -> w.getEventName().equals("add"))
				.findFirst().orElse(null);
		if (webhookData != null) {

			String urlString = webhookData.getEndpointUrl();
			urlString += "/" + studentData.getStudentName();
			RestTemplate restTemplate = new RestTemplate();
			String forObject = restTemplate.getForObject(urlString, String.class);
			System.out.println("Response: " + forObject);

		}
		return "Student added";

	}
}
