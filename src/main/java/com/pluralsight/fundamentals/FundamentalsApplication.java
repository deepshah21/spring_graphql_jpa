package com.pluralsight.fundamentals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.pluralsight.fundamentals.entity.Application;
import com.pluralsight.fundamentals.repository.ApplicationRepository;

@SpringBootApplication
@ComponentScan
public class FundamentalsApplication {

	private static final Logger log = LoggerFactory.getLogger(FunctionalInterface.class);
	
	public static void main(String[] args) {
		SpringApplication.run(FundamentalsApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ApplicationRepository repository) {
		return (args) -> {
			repository.save(new Application("deep shah"));
			repository.save(new Application("parth patel"));
			
			for(Application application: repository.findAll()) {
				log.info(application.getName());
				System.out.print(application.getName());
			}
		};
	}
}
