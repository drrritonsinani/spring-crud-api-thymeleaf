package com.example.MedicationServiceApp.services;

import com.example.MedicationServiceApp.models.Doctor;
import com.example.MedicationServiceApp.models.Pharmacy;
import com.example.MedicationServiceApp.repositories.doctorRepository;
import com.example.MedicationServiceApp.repositories.pharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class pharmacyService {
    @Autowired
    private pharmacyRepository pharmacyRepository;

    public List<Pharmacy> getAllPharmacies(){
        return pharmacyRepository.findAll();
    }

    public Pharmacy savePharmacy(Pharmacy pharmacy) {
        return pharmacyRepository.save(pharmacy);
    }

    public Pharmacy getPharmacyById(Long id) {
        return pharmacyRepository.findById(id).orElse(null);
    }

    public String deletePharmacy(Long id) {
        pharmacyRepository.deleteById(id);
        return "Pharmacy removed !! " + id;
    }

    public Pharmacy updatePharmacy(Pharmacy pharmacy, long id) {
        Pharmacy existingPharmacy =pharmacyRepository.findById(id).orElse(null);
        existingPharmacy.setName(pharmacy.getName());
        existingPharmacy.setAddress(pharmacy.getAddress());
        existingPharmacy.setPhoneNumber(pharmacy.getPhoneNumber());
        existingPharmacy.setMedicaments(pharmacy.getMedicaments());
        return pharmacyRepository.save(existingPharmacy);
    }
}
