package com.example.MedicationServiceApp.controllers;

import com.example.MedicationServiceApp.models.Doctor;
import com.example.MedicationServiceApp.repositories.doctorRepository;
import com.example.MedicationServiceApp.services.doctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
public class doctorController {
    @Autowired
    private doctorService doctorService;

//    @Autowired
//    private doctorRepository doctorRepository;

    @GetMapping("/doctors")
    public String doctors(Model model) {
        model.addAttribute("doctors",doctorService.getDoctors());
        return "doctors";
    }

    @GetMapping("/addNewDoctor")
    public String addNewDoctor(Model model) {
        // create model attribute to bind form data
        Doctor doctor = new Doctor();
        model.addAttribute("doctor", doctor);
        return "newDoctor";
    }

    @PostMapping("/saveDoctor")
    public String newDoctor(@ModelAttribute Doctor doctor){
        doctorService.saveDoctor(doctor);
        return"redirect:/doctors";
    }

    @GetMapping("/editDoctor/{id}")
    public String editDoctor(@PathVariable ( value = "id") long id, Model model) {

        // get doctor from the service
        Doctor doctor = doctorService.getDoctorById(id);

        // set doctor as a model attribute to pre-populate the form
        model.addAttribute("doctor", doctor);
        return "updateDoctor";
    }

    @PostMapping("/editDoctor/{id}")
    public String saveUpdatetDoctor(@ModelAttribute Doctor updatetDoctor,@PathVariable ( value = "id") long id){
//
        doctorService.updateDoctor(updatetDoctor,id);
        return"redirect:/doctors";
    }


}
