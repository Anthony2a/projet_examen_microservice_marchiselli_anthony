package com.example.medicalrecord.service;

import com.example.medicalrecord.model.MedicalRecord;
import com.example.medicalrecord.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    public MedicalRecord createMedicalRecord(MedicalRecord medicalRecord) {
        return medicalRecordRepository.save(medicalRecord);
    }

    public MedicalRecord updateMedicalRecord(Long id, MedicalRecord medicalRecord) {
        Optional<MedicalRecord> existingRecord = medicalRecordRepository.findById(id);
        if (existingRecord.isPresent()) {
            medicalRecord.setId(id);
            return medicalRecordRepository.save(medicalRecord);
        }
        return null;
    }

    public void deleteMedicalRecord(Long id) {
        medicalRecordRepository.deleteById(id);
    }

    public MedicalRecord getMedicalRecord(Long id) {
        return medicalRecordRepository.findById(id).orElse(null);
    }

    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordRepository.findAll();
    }
}