package com.example.MedicationServiceApp.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name="docid")
    private Doctor doctor;

    @ManyToMany()
    @JoinTable(name = "patient_uses_medicaments",
            joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "medicament_id",referencedColumnName = "id"))
    private List<Medicament> medicaments = new ArrayList<Medicament>();

    public Patient() {

    }




    public Patient( String name, int age, String address, Doctor doctor, List<Medicament> medicaments) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.doctor = doctor;
        this.medicaments=medicaments;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<Medicament> getDrugs() {
        return medicaments;
    }

    public void setDrugs(List<Medicament> medicaments) {
        this.medicaments = medicaments;
    }
}

