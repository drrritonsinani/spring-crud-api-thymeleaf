package com.example.MedicationServiceApp.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pharmid;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "pharmacy", cascade = CascadeType.PERSIST)
    private List<Medicament> medicaments;

    public Pharmacy() {

    }

    public Pharmacy(String name, String phoneNumber, String address, List<Medicament> medicaments) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.medicaments=medicaments;
    }


    public long getPharmid() {
        return pharmid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Medicament> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(List<Medicament> drugs) {
        this.medicaments=medicaments;
    }
}

