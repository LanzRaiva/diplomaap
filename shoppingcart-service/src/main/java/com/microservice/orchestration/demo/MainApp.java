package com.microservice.orchestration.demo;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication
public class MainApp {

	public static void main(String... args) {
		SpringApplication.run(MainApp.class, args);
	}
}
