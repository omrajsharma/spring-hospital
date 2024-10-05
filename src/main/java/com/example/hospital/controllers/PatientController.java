package com.example.hospital.controllers;

import com.example.hospital.entities.Patient;
import com.example.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/v1/patients")
public class PatientController {

//    HashMap<Integer, Patient> patients = new HashMap<>();
//
//    @GetMapping("/hello-world")
//    public String helloWorld() {
//        return "Hello World from PatientController";
//    }
//
//    @PostMapping("")
//    public String addPatient(@RequestBody Patient patient) {
//        int key = patient.getId();
//
//        patients.put(key, patient);
//
//        return "Patient added successfully";
//    }
//
//    @GetMapping("/all")
//    public List<Patient> getAll() {
//        return new ArrayList<>(patients.values());
//    }
//
//    @GetMapping("/{patientId}")
//    public Patient getPatient(@PathVariable int patientId) {
//        return patients.get(patientId);
//    }
//
//    @GetMapping("")
//    public Patient getPatientByQuery(@RequestParam int patientId) {
//        return patients.get(patientId);
//    }

    /**
     * CRUD - CREATE, READ, UPDATE, DELETE
     */
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
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    @PutMapping
    public Patient updatePatient(@RequestBody Patient patient) {
        return patientService.updatePatient(patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable int id) {
        patientService.deletePatient(id);
    }

}
