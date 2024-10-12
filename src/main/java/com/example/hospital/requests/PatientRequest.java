package com.example.hospital.requests;

import lombok.Data;

@Data
public class PatientRequest {

    private String name;
    private String disease;
    private int age;
    private int doctorId;

}
