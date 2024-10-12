package com.example.hospital.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String speciality;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Patient> patients;
}
