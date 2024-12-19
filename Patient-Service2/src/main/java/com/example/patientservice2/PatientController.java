package com.example.patientservice2;

import com.example.patientservice2.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private List<Patient> patients = new ArrayList<>();

    @GetMapping("/get/{id}")
    public Patient getPatient(@PathVariable int id){
        return patients.stream().filter(obj -> obj.getId() == id).findFirst().orElse(null);
    }

    @PostMapping("/add")
    public Patient addPatient(@RequestBody Patient patient) {

        patients.add(patient);
        return patient;
        }

    @DeleteMapping("/del/{id}")
    public String delPatient(@PathVariable int id) {
        Patient patient = getPatient(id);
        if (patient != null) {
            patients.remove(patient);
            return "Success";
        } else {
            return "Patient not found";
        }
    }

    @PutMapping("/update/{id}")
    public String updatePatient(@PathVariable int id, @RequestBody Patient updatedPatient) {
        Patient oldPatient = getPatient(id);
        if (oldPatient != null) {
            oldPatient.setName(updatedPatient.getName());
            oldPatient.setEmail(updatedPatient.getEmail());
            oldPatient.setPhone(updatedPatient.getPhone());
            return "Update success";
        } else {
            return "Patient not found";
        }
    }
}