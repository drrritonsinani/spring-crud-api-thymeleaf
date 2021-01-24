package com.example.MedicationServiceApp.controllers;

import com.example.MedicationServiceApp.models.Doctor;
import com.example.MedicationServiceApp.models.Medicament;
import com.example.MedicationServiceApp.models.Patient;
import com.example.MedicationServiceApp.repositories.doctorRepository;
import com.example.MedicationServiceApp.repositories.patientRepository;
import com.example.MedicationServiceApp.services.doctorService;
import com.example.MedicationServiceApp.services.patientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class patientController {
    @Autowired
    private patientService patientService;

    @Autowired
    private doctorRepository doctorRepository;

    @GetMapping("/patients")
    public String patients(Model model) {
        model.addAttribute("patients",patientService.getAllPatients());
        return "patients";
    }

    @GetMapping("/addNewPatient")
    public String addNewPatient(Model model) {
        // create model attribute to bind form data
        Patient patient=new Patient();
        model.addAttribute("patient", patient);
        model.addAttribute("doctors",doctorRepository.findAll() );
        return "newPatient";
    }

    @PostMapping("/savePatient")
    public String newPatient(@ModelAttribute Patient patient){
        patientService.savePatient(patient);
        return"redirect:/patients";
    }

    @GetMapping("/editPatient/{id}")
    public String editPatient(@PathVariable( value = "id") long id, Model model) {

        // get doctor from the service
        Patient patient = patientService.getPatientById(id);

        // set doctor as a model attribute to pre-populate the form
        model.addAttribute("patient", patient);
        model.addAttribute("doctors",doctorRepository.findAll() );
        return "updatePatient";
    }

    @PostMapping("/editPatient/{id}")
    public String saveUpdatetPatient(@ModelAttribute Patient updatetPatient, @PathVariable ( value = "id") long id){
//
        patientService.updatePatient(updatetPatient, id);
        return"redirect:/patients";
    }
}
