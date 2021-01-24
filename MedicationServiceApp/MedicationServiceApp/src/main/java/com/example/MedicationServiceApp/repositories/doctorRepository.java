package com.example.MedicationServiceApp.repositories;

import com.example.MedicationServiceApp.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface doctorRepository extends JpaRepository<Doctor, Long>{

}
