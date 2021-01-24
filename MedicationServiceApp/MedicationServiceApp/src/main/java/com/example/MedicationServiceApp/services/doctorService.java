package com.example.MedicationServiceApp.services;


import com.example.MedicationServiceApp.models.Doctor;
import com.example.MedicationServiceApp.repositories.doctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class doctorService {
    @Autowired
    private doctorRepository doctorRepository;

    public List<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public String deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
        return "Product removed !! " + id;
    }

    public Doctor updateDoctor(Doctor doctor, long id) {
        Doctor existingDoctor =doctorRepository.findById(id).orElse(null);
        existingDoctor.setName(doctor.getName());
        existingDoctor.setSpecialty(doctor.getSpecialty());
        existingDoctor.setExp_years(doctor.getExp_years());
        existingDoctor.setPatients(doctor.getPatients());
        return doctorRepository.save(existingDoctor);
    }
}
