package com.example.practitioner.service;

import com.example.practitioner.model.Practitioner;
import com.example.practitioner.repository.PractitionerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PractitionerService {

    @Autowired
    private PractitionerRepository practitionerRepository;

    public Practitioner addPractitioner(Practitioner practitioner) {
        return practitionerRepository.save(practitioner);
    }

    public Practitioner updatePractitioner(Long id, Practitioner practitioner) {
        Optional<Practitioner> existingPractitioner = practitionerRepository.findById(id);
        if (existingPractitioner.isPresent()) {
            practitioner.setId(id);
            return practitionerRepository.save(practitioner);
        }
        return null;
    }

    public void deletePractitioner(Long id) {
        practitionerRepository.deleteById(id);
    }

    public Practitioner getPractitioner(Long id) {
        return practitionerRepository.findById(id).orElse(null);
    }

    public List<Practitioner> getAllPractitioners() {
        return practitionerRepository.findAll();
    }
}