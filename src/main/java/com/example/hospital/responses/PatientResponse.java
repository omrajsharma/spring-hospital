package com.example.hospital.responses;

import lombok.Data;

@Data
public class PatientResponse {
    private int id;
    private String name;
    private String disease;
    private int age;
    private int doctorId;  // Only the doctor ID is exposed
}
