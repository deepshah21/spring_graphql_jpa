package com.pluralsight.fundamentals.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pluralsight.fundamentals.entity.Application;

public interface ApplicationRepository  extends CrudRepository<Application, Integer>{
	List<Application> findByName(String name);
	
}
