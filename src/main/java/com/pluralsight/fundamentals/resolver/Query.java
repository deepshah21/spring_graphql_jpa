package com.pluralsight.fundamentals.resolver;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pluralsight.fundamentals.entity.Application;
import com.pluralsight.fundamentals.repository.ApplicationRepository;


@Component
public class Query implements GraphQLQueryResolver{

	private ApplicationRepository applicationRepository;
	
	public Query(ApplicationRepository applicationRepository) {
		this.applicationRepository = applicationRepository;
	}
	
	public Iterable<Application> findAllApplications(){
		return applicationRepository.findAll();
	}
	
	public long countApplication() {
		return applicationRepository.count();
	}
}
