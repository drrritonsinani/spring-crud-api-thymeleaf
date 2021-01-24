package com.example.MedicationServiceApp.repositories;

import com.example.MedicationServiceApp.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface patientRepository extends JpaRepository<Patient, Long> {

}