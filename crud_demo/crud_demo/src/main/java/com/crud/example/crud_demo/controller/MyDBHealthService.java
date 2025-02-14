package com.crud.example.crud_demo.controller;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class MyDBHealthService implements HealthIndicator {

	public boolean isHealthGood() {
		// custom logic
		return true;
	}

	@Override
	public Health health() {

		// TODO Auto-generated method stub
		if (isHealthGood())
			return Health.up().withDetail("DBService", "DB Service is working fine...").build();
		return Health.down().withDetail("DBService", "DB service is not working fine").build();
	}

}
