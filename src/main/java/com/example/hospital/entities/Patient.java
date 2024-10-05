package com.example.hospital.entities;

import lombok.Data;

@Data
public class Patient {
    private int id;
    private String name;
    private String disease;
    private int age;
}
