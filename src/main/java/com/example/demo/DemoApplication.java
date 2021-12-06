package com.example.demo;

import javax.annotation.PostConstruct;

import org.osgi.application.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostConstruct
	public void init() {
		Logger log = LoggerFactory.getLogger(ApplicationContext.class);
		log.info("Java app started");
	}

	public String getStatus() {
		return "OK";
	}

}
