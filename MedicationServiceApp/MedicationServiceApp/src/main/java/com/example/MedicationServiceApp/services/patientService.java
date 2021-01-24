package com.example.MedicationServiceApp.services;

import com.example.MedicationServiceApp.models.Patient;
import com.example.MedicationServiceApp.models.Medicament;
import com.example.MedicationServiceApp.models.Patient;
import com.example.MedicationServiceApp.repositories.medicamentRepository;
import com.example.MedicationServiceApp.repositories.patientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class patientService {
    @Autowired
    private patientRepository patientRepository;

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public String deletePatient(Long id) {
        patientRepository.deleteById(id);
        return "Patient removed !! " + id;
    }

    public Patient updatePatient(Patient patient, long id) {
        Patient existingPatient =patientRepository.findById(id).orElse(null);
        existingPatient.setName(patient.getName());
        existingPatient.setAge(patient.getAge());
        existingPatient.setAddress(patient.getAddress());
        existingPatient.setDoctor(patient.getDoctor());
        return patientRepository.save(existingPatient);
    }
}
