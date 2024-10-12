package com.example.hospital.controllers;

import com.example.hospital.entities.Doctor;
import com.example.hospital.requests.DoctorRequest;
import com.example.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/all")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable int id) {
        return doctorService.getDoctorById(id);
    }

    @PostMapping
    public Doctor addDoctor(@RequestBody DoctorRequest doctorRequest) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorRequest.getName());
        doctor.setSpeciality(doctorRequest.getSpeciality());
        return doctorService.saveDoctor(doctor);
    }

    @PutMapping
    public Doctor updateDoctor(@RequestBody DoctorRequest doctorRequest) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorRequest.getName());
        doctor.setSpeciality(doctorRequest.getSpeciality());
        return doctorService.updateDoctor(doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable int id) {
        doctorService.deleteDoctor(id);
    }
}
