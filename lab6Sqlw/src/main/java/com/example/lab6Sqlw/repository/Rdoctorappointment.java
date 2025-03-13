package com.example.lab6Sqlw.repository;

import com.example.lab6Sqlw.entity.Edoctorappointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Rdoctorappointment extends JpaRepository<Edoctorappointment, Integer> {
    // Custom query methods can be added here if needed
}




