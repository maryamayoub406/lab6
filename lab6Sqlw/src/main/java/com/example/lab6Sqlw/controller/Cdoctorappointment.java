package com.example.lab6Sqlw.controller;

import com.example.lab6Sqlw.entity.Edoctorappointment;
import com.example.lab6Sqlw.repository.Rdoctorappointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/appointments")
public class Cdoctorappointment {

    @Autowired
    private Rdoctorappointment appointmentRepo;

    @PostMapping
    public Edoctorappointment bookAppointment(@RequestBody Edoctorappointment appointment) {
        return appointmentRepo.save(appointment);
    }

    @GetMapping
    public List<Edoctorappointment> getAllAppointments() {
        return appointmentRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Edoctorappointment> getAppointmentById(@PathVariable Integer id) {
        Edoctorappointment appointment = appointmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
        return ResponseEntity.ok(appointment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Edoctorappointment> updateAppointmentStatus(@PathVariable Integer id, @RequestParam String status) {
        Edoctorappointment appointment = appointmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
        appointment.setStatus(status);
        Edoctorappointment updatedAppointment = appointmentRepo.save(appointment);
        return ResponseEntity.ok(updatedAppointment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAppointment(@PathVariable Integer id) {
        Edoctorappointment appointment = appointmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
        if (!"Canceled".equalsIgnoreCase(appointment.getStatus())) {
            throw new RuntimeException("Only canceled appointments can be deleted.");
        }
        appointmentRepo.delete(appointment);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}