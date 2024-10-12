package com.example.hospital.responses;

import lombok.Data;

import java.util.List;

@Data
public class DoctorResponse {
    private int id;
    private String name;
    private String speciality;
//    private List<PatientResponse> patients;
}
