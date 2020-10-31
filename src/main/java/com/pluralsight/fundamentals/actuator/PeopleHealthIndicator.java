package com.pluralsight.fundamentals.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class PeopleHealthIndicator implements HealthIndicator{

	private final String message_key = "peopleService";
	@Override
	public Health health() {
		// TODO Auto-generated method stub
		if(!isRunningPeopleService()) {
			return Health.down().withDetail(message_key, "Not available").build();
		}
		return Health.up().withDetail(message_key, "available").build();
	}
	
	public boolean isRunningPeopleService() {
		return false;
	}

}
