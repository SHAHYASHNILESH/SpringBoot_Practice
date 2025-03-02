package com.gson_example.gson_demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gson_example.gson_demo.entity.JointAccount;
import com.gson_example.gson_demo.exception.ResourceNotFoundException;
import com.gson_example.gson_demo.repository.JointAccountRepository;

@Service
public class JointAccountService {

	@Autowired
	private JointAccountRepository jointAccountRepository;

	public String getJointAccountById(Long leadId) throws ResourceNotFoundException {

		// Map<String, Object> values = new HashMap<>();
		Map<String, Object> nValues = new HashMap<>();
		Map<String, Object> presentValues = new HashMap<>();
		Map<String, Object> finalResponse = new HashMap<>();

		JointAccount jointAccById = jointAccountRepository.findById(leadId)
				.orElseThrow(() -> new ResourceNotFoundException("Joint Account Not Found"));

//		values.put("leadId", jointAccById.getLeadId());
//		values.put("name", jointAccById.getName());
//		values.put("address", jointAccById.getAddress());
//		values.put("age", jointAccById.getAge());
//		values.put("gender", jointAccById.getGender());

//		presentValues.put("presentValues", values);
		presentValues.put("presentValues", jointAccById);

		if (jointAccById.getLeadId() == null) {
			nValues.put("leadId", jointAccById.getLeadId());
		}
		if (jointAccById.getName() == null) {
			nValues.put("name", jointAccById.getName());
		}
		if (jointAccById.getAddress() == null) {
			nValues.put("address", jointAccById.getAddress());
		}
		if (jointAccById.getAge() == 0) {
			nValues.put("age", jointAccById.getAge());
		}
		if (jointAccById.getGender() == null) {
			nValues.put("gender", jointAccById.getGender());
		}

		finalResponse.put("presentResponse", presentValues);
		finalResponse.put("nullResponse", nValues);

		Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
		return gson.toJson(finalResponse);

	}

	public JointAccount createJointAccount(JointAccount jointAccount) {
		// TODO Auto-generated method stub
		return jointAccountRepository.save(jointAccount);

	}

}
