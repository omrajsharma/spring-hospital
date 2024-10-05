package com.example.hospital.repositories;


import com.example.hospital.entities.Patient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class PatientRepository {
    private HashMap<Integer, Patient> patients = new HashMap<>();
    private int idCounter = 1;

    public List<Patient> getAllPatients() {
        return new ArrayList<>(patients.values());
    }

    public Patient getPatientById(int id) {
        return patients.get(id);
    }

    public Patient addPatient(Patient patient) {
        patient.setId(idCounter++);
        patients.put(patient.getId(), patient);
        return patient;
    }

    public Patient updatePatient(Patient patient) {
        return patients.put(patient.getId(), patient);
    }

    public Patient deletePatient(Integer id) {
        return patients.remove(id);
    }
}
