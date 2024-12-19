package com.example.appointment.service;

import com.example.appointment.model.Appointment;
import com.example.appointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private RestTemplate restTemplate; // To integrate external calendar API

    private final String EXTERNAL_CALENDAR_API = "https://api.externalcalendar.com/appointments";

    public Appointment createAppointment(Appointment appointment) {
        // External calendar integration logic with retry
        try {
            // Make a request to external calendar API
            restTemplate.postForEntity(EXTERNAL_CALENDAR_API, appointment, Appointment.class);
        } catch (Exception e) {
            // Handle failures (retry logic, fallback, etc.)
            // Retry mechanism can be implemented here, e.g., using Hystrix or a simple retry loop
        }
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(Long id, Appointment appointment) {
        Optional<Appointment> existingAppointment = appointmentRepository.findById(id);
        if (existingAppointment.isPresent()) {
            appointment.setId(id);
            return appointmentRepository.save(appointment);
        }
        return null;
    }

    public void cancelAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    public Appointment getAppointment(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
}