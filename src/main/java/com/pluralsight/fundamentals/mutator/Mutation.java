package com.pluralsight.fundamentals.mutator;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.pluralsight.fundamentals.entity.Application;
import com.pluralsight.fundamentals.exceptions.ApplicationNotFountException;
import com.pluralsight.fundamentals.repository.ApplicationRepository;

@Component
public class Mutation implements GraphQLMutationResolver{

	private ApplicationRepository applicationRepository;
	
	public Mutation(ApplicationRepository applicationRepository) {
		this.applicationRepository = applicationRepository;
	}
	
	public Application newApplication(String name) {
		Application app = new Application(name);
		applicationRepository.save(app);
		return app;
	}
	
	public boolean deleteApplication(Integer id) {
		applicationRepository.deleteById(id);
		return true;
	}
	
	public Application updateApplicatioName(String newName, Integer id) {
		Optional<Application> oppApplication = applicationRepository.findById(id);
		if(oppApplication.isPresent()) {
			Application app = oppApplication.get();
			app.setName(newName);
			applicationRepository.save(app);
			return app;
		}else {
			throw new ApplicationNotFountException(id);
		}
	}
}
