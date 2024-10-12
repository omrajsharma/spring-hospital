package com.example.hospital.controllers;

import com.example.hospital.entities.Patient;
import com.example.hospital.requests.PatientRequest;
import com.example.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/all")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable int id) {
        return patientService.getPatientById(id);
    }

    @PostMapping
    public Patient addPatient(@RequestBody PatientRequest patientRequest) {
        return patientService.addPatient(patientRequest);
    }

    @PutMapping
    public Patient updatePatient(@RequestBody PatientRequest patientRequest) {
        Patient patient = new Patient();
        patient.setName(patientRequest.getName());
        patient.setDisease(patientRequest.getDisease());
        patient.setAge(patientRequest.getAge());
        return patientService.updatePatient(patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable int id) {
        patientService.deletePatient(id);
    }
}
