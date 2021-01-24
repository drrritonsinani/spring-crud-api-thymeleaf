package com.example.MedicationServiceApp.services;

import com.example.MedicationServiceApp.models.Medicament;
import com.example.MedicationServiceApp.repositories.medicamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class medicamentService {
    @Autowired
    private medicamentRepository medicamentRepository;

    public List<Medicament> getAllMedicament(){
        return medicamentRepository.findAll();
    }

    public Medicament saveMedicament(Medicament medicament) {
        return medicamentRepository.save(medicament);
    }

    public Medicament getMedicamentById(Long id) {
        return medicamentRepository.findById(id).orElse(null);
    }

    public String deleteMedicament(Long id) {
        medicamentRepository.deleteById(id);
        return "Medicament removed !! " + id;
    }

    public Medicament updateMedicament(Medicament medicament, long id) {
        Medicament existingMedicament =medicamentRepository.findById(id).orElse(null);
        existingMedicament.setName(medicament.getName());
        existingMedicament.setFormula(medicament.getFormula());
        existingMedicament.setPharmacy(medicament.getPharmacy());
        existingMedicament.setPharmacy(medicament.getPharmacy());
        return medicamentRepository.save(existingMedicament);
    }
}

