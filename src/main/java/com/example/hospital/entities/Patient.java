package com.example.hospital.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String disease;
    private int age;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
