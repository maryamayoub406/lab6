package com.example.lab6Sqlw.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Edoctorappointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;

    private String patientName;
    private String doctorName;
    private LocalDate appointmentDate;

    @Column(nullable = false)
    private String status; // Scheduled, Completed, or Canceled

    public Edoctorappointment() {}

    public Edoctorappointment(String patientName, String doctorName, LocalDate appointmentDate, String status) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }

    // Getters and Setters
    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
