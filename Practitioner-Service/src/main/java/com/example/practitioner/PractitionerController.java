package com.example.practitioner.controller;

import com.example.practitioner.model.Practitioner;
import com.example.practitioner.service.PractitionerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/practitioners")
public class PractitionerController {

    @Autowired
    private PractitionerService practitionerService;

    @PostMapping
    public Practitioner addPractitioner(@RequestBody Practitioner practitioner) {
        return practitionerService.addPractitioner(practitioner);
    }

    @PutMapping("/{id}")
    public Practitioner updatePractitioner(@PathVariable Long id, @RequestBody Practitioner practitioner) {
        return practitionerService.updatePractitioner(id, practitioner);
    }

    @DeleteMapping("/{id}")
    public void deletePractitioner(@PathVariable Long id) {
        practitionerService.deletePractitioner(id);
    }

    @GetMapping("/{id}")
    public Practitioner getPractitioner(@PathVariable Long id) {
        return practitionerService.getPractitioner(id);
    }

    @GetMapping
    public List<Practitioner> getAllPractitioners() {
        return practitionerService.getAllPractitioners();
    }
}