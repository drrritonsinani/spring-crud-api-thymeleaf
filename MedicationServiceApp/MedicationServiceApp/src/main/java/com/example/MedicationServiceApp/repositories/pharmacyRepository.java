package com.example.MedicationServiceApp.repositories;

import com.example.MedicationServiceApp.models.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface pharmacyRepository extends JpaRepository<Pharmacy, Long> {

}
