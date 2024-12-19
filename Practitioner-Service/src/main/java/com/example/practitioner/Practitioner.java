package com.example.practitioner.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Practitioner {

    @Id
    private Long id;
    private String name;
    private String specialty;
    private String phone;

    // Getters and setters
}