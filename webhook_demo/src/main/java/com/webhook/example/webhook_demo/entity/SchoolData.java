package com.webhook.example.webhook_demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SchoolData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	private String schoolName;
	@OneToMany(mappedBy = "schoolWebhook", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<WebhookData> webhookDataList;
	
	@OneToMany(mappedBy = "schoolData", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Student> studentDataList;
}
