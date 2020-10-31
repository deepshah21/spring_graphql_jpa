package com.pluralsight.fundamentals.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pluralsight.fundamentals.entity.Ticket;

public interface SessionJpaRepository extends JpaRepository<Ticket, Integer>{
	
	List<Ticket> findByTitle(String title);
	
	List<Ticket> findBySessionNameContains(String name);

	List<Ticket>  findBySessionLengthNot(Integer sessionLength);
	
}
