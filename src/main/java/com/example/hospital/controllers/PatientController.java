package com.example.hospital.controllers;

import com.example.hospital.entities.Patient;
import com.example.hospital.requests.PatientRequest;
import com.example.hospital.responses.DoctorResponse;
import com.example.hospital.responses.PatientResponse;
import com.example.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/all")
    public List<PatientResponse> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        List<PatientResponse> patientResponses = new ArrayList<>();
        for (Patient patient : patients){
            patientResponses.add(convertToResponse(patient));
        }
        return patientResponses;
    }

    private PatientResponse convertToResponse(Patient patient) {
        PatientResponse response = new PatientResponse();
        response.setId(patient.getId());
        response.setName(patient.getName());
        response.setDisease(patient.getDisease());
        response.setAge(patient.getAge());

        if(patient.getDoctor() != null) {
            DoctorResponse doctorResponse = new DoctorResponse();
            doctorResponse.setId(patient.getDoctor().getId());
            doctorResponse.setName(patient.getDoctor().getName());
            doctorResponse.setSpeciality(patient.getDoctor().getSpeciality());
            response.setDoctor(doctorResponse);
        }

        return response;
    }

    @GetMapping("/{id}")
    public PatientResponse getPatientById(@PathVariable int id) {
        Patient patient = patientService.getPatientById(id);
        return convertToResponse(patient);
    }

    @PostMapping
    public PatientResponse addPatient(@RequestBody PatientRequest patientRequest) {
        //todo: updatePatient logic in patientService
        Patient patient = patientService.addPatient(patientRequest);
        return convertToResponse(patient);
    }

    @PutMapping("/{id}")
    public PatientResponse updatePatient(@PathVariable int id, @RequestBody PatientRequest patientRequest) {
        Patient patient = patientService.updatePatient(id, patientRequest);
        return convertToResponse(patient);
//        Patient patient = new Patient();
//        patient.setName(patientRequest.getName());
//        patient.setDisease(patientRequest.getDisease());
//        patient.setAge(patientRequest.getAge());
//        return patientService.updatePatient(patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable int id) {
        patientService.deletePatient(id);
    }
}
