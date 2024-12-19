package com.example.patient.controller;

import com.example.patient.model.Patient;
import com.example.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private List<Patient> patients = new ArrayList<>();

    @GetMapping("/get")
    public Patient getPatient(@PathVariable int id){
        return patients.stream().filter(obj -> obj.getId() == id).findFirst().orElse(null);
    }

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable int id, @RequestBody Patient patient) {
        return patientService.updatePatient(id, patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable int id) {
        patientService.deletePatient(id);
    }

    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable int id) {
        return patientService.getPatient(id);
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }
}