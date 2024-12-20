package com.example.patientservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PatientService2Application {

    public static void main(String[] args) {
        SpringApplication.run(PatientService2Application.class, args);
    }

}