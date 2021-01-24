package com.example.MedicationServiceApp.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Medicament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String formula;

    @ManyToMany(mappedBy = "medicaments")
    private List<Patient> patients = new ArrayList<Patient>();

    @ManyToOne
    @JoinColumn(name="pharmid", nullable=false)
    private Pharmacy pharmacy;

    public Medicament() {

    }

    public Medicament(String name, String formula, List<Patient> patients, Pharmacy pharmacy) {
        this.name = name;
        this.formula = formula;
        this.patients = patients;
        this.pharmacy = pharmacy;
    }

    public long getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}

