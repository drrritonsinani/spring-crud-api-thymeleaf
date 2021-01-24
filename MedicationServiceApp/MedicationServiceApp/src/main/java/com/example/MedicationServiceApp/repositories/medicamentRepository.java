package com.example.MedicationServiceApp.repositories;

import com.example.MedicationServiceApp.models.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface medicamentRepository extends JpaRepository<Medicament, Long> {

}
