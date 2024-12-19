package com.example.patientservice2;

public class Patient {

    private final int id;
    private String name;
    private String email;
    private String phone;
    private static int id_counter = 0;

    public Patient() {
        this.id = ++id_counter;
    }

    public Patient(String name, String email, String phone) {
        this.id = ++id_counter;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}