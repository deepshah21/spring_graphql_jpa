package com.pluralsight.fundamentals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.pluralsight.fundamentals.entity.Application;
import com.pluralsight.fundamentals.exceptions.ApplicationNotFountException;
import com.pluralsight.fundamentals.service.ApplicationService;

@RestController
public class ApplicationController {

	@Autowired
	ApplicationService applicationService;
	
	@GetMapping("/application/{id}")
	public ResponseEntity<Application> getApplication(@PathVariable("id") Integer id){
		try{
			return new ResponseEntity<>(applicationService.findApplication(id),HttpStatus.OK);
		}catch(ApplicationNotFountException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Application not found");
		}
	}
	
	@GetMapping("/application")
	public List<Application> getApplicationByName(@RequestParam("name") String name){
		try{
			return applicationService.findByName(name);
		}catch(ApplicationNotFountException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Application not found");
		}
	}
	
}
