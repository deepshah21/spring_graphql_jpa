package com.pluralsight.fundamentals.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluralsight.fundamentals.entity.Application;
import com.pluralsight.fundamentals.exceptions.ApplicationNotFountException;
import com.pluralsight.fundamentals.repository.ApplicationRepository;

@Service
public class ApplicationService {

	@Autowired
	ApplicationRepository applicationRepository;
	
	public Application findApplication(Integer id) {
		// TODO Auto-generated method stub
		Optional<Application> optionalApplication = applicationRepository.findById(id);
		if(optionalApplication.isPresent()) {
			return optionalApplication.get();
		}else {
			throw new ApplicationNotFountException(id);
		}
	}

	public List<Application> findByName(String name){
		return applicationRepository.findByName(name);
	}
}
