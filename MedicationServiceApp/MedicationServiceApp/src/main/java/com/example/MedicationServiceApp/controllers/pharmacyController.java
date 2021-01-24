package com.example.MedicationServiceApp.controllers;

import com.example.MedicationServiceApp.models.Patient;
import com.example.MedicationServiceApp.models.Pharmacy;
import com.example.MedicationServiceApp.services.patientService;
import com.example.MedicationServiceApp.services.pharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class pharmacyController {
    @Autowired
    private pharmacyService pharmacyService;

    @GetMapping("/pharmacies")
    public String pharmacies(Model model) {
        model.addAttribute("pharmacies",pharmacyService.getAllPharmacies());
        return "pharmacies";
    }

    @GetMapping("/addNewPharmacy")
    public String addNewPharmacy(Model model) {
        // create model attribute to bind form data
        Pharmacy pharmacy=new Pharmacy();
        model.addAttribute("pharmacy", pharmacy);
        return "newPharmacy";
    }

    @PostMapping("/savePharmacy")
    public String newPharmacy(@ModelAttribute Pharmacy pharmacy){
        pharmacyService.savePharmacy(pharmacy);
        return"redirect:/pharmacies";
    }

    @GetMapping("/editPharmacy/{id}")
    public String editPharmacy(@PathVariable( value = "id") long id, Model model) {

        // get pharmacy from the service
        Pharmacy pharmacy = pharmacyService.getPharmacyById(id);

        // set pharmacy as a model attribute to pre-populate the form
        model.addAttribute("pharmacy", pharmacy);
        return "updatePharmacy";
    }

    @PostMapping("/editPharmacy/{id}")
    public String saveUpdatetPharmacy(@ModelAttribute Pharmacy updatetPharmacy, @PathVariable ( value = "id") long id){
//
        pharmacyService.updatePharmacy(updatetPharmacy, id);
        return"redirect:/pharmacies";
    }
}