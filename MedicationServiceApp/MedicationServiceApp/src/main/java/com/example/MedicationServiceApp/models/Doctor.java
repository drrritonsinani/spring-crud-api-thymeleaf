package com.example.MedicationServiceApp.models;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long docid;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int exp_years;

    @Column(nullable = false)
    private String specialty;

    @OneToMany(mappedBy="doctor")
    private Set<Patient> patients;

    public Doctor() {

    }

    public Doctor(String name, int exp_years, String specialty, Set<Patient> patients) {
        this.name = name;
        this.exp_years = exp_years;
        this.specialty = specialty;
        this.patients = patients;
    }

    public long getDocid() {
        return docid;
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExp_years() {
        return exp_years;
    }

    public void setExp_years(int exp_years) {
        this.exp_years = exp_years;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}
