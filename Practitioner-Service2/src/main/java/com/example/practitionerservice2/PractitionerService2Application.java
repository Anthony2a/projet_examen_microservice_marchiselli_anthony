package com.example.practitionerservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PractitionerService2Application {

	public static void main(String[] args) {
		SpringApplication.run(PractitionerService2Application.class, args);
	}

}