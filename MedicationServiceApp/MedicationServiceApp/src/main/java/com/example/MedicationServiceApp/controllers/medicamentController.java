package com.example.MedicationServiceApp.controllers;

import com.example.MedicationServiceApp.models.Doctor;
import com.example.MedicationServiceApp.models.Medicament;
import com.example.MedicationServiceApp.repositories.pharmacyRepository;
import com.example.MedicationServiceApp.services.doctorService;
import com.example.MedicationServiceApp.services.medicamentService;
import com.example.MedicationServiceApp.services.pharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class medicamentController {
    @Autowired
    private medicamentService medicamentService;
    @Autowired
    private pharmacyRepository pharmacyRepository;

    @GetMapping("/medicament")
    public String medicament(Model model) {
        model.addAttribute("medicament",medicamentService.getAllMedicament());
        return "medicament";
    }

    @GetMapping("/addNewMedicament")
    public String addNewMedicament(Model model) {
        // create model attribute to bind form data
        Medicament medicament=new Medicament();
        model.addAttribute("medicament", medicament);
        model.addAttribute("pharmacies", pharmacyRepository.findAll());
        return "newMedicament";
    }

    @PostMapping("/saveMedicament")
    public String newMedicament(@ModelAttribute Medicament medicament){
        medicamentService.saveMedicament(medicament);
        return"redirect:/medicament";
    }

    @GetMapping("/editMedicament/{id}")
    public String editMedicament(@PathVariable( value = "id") long id, Model model) {

        // get medicament from the service
        Medicament medicament = medicamentService.getMedicamentById(id);

        // set medicament as a model attribute to pre-populate the form
        model.addAttribute("medicament", medicament);
        model.addAttribute("pharmacies", pharmacyRepository.findAll());
        return "updateMedicament";
    }

    @PostMapping("/editMedicament/{id}")
    public String saveUpdatetMedicament(@ModelAttribute Medicament updatetMediacment,@PathVariable ( value = "id") long id){
//
        medicamentService.updateMedicament(updatetMediacment, id);
        return"redirect:/medicament";
    }
}
