package com.example.hospital.entities;

import lombok.Data;

import java.util.List;

@Data
public class Doctor {
    private int id;
    private String name;
    private String speciality;
    private List<Patient> patients;
}
