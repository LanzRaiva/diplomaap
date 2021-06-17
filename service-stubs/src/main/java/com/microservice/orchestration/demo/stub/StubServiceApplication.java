package com.microservice.orchestration.demo.stub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.microservice.orchestration.demo")
public class StubServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StubServiceApplication.class, args);
	}

}
