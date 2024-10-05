package com.example.hospital.repositories;

import com.example.hospital.entities.Doctor;
import com.example.hospital.entities.Patient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class DoctorRepository {
    private HashMap<Integer, Doctor> doctorMap = new HashMap<>();
    private int idCounter = 1;

    public List<Doctor> getAllDoctor() {
        return new ArrayList<>(doctorMap.values());
    }

    public Doctor getDoctorById(int id) {
        return doctorMap.get(id);
    }

    public Doctor addDoctor(Doctor doctor) {
        doctor.setId(idCounter++);
        doctorMap.put(doctor.getId(), doctor);
        return doctor;
    }

    public Doctor updateDoctor(Doctor doctor) {
        return doctorMap.put(doctor.getId(), doctor);
    }

    public Doctor deleteDoctorById(int id) {
        return doctorMap.remove(id);
    }

}
