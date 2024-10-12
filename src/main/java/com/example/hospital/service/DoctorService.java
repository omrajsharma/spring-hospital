package com.example.hospital.service;

import com.example.hospital.entities.Doctor;
import com.example.hospital.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(int id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        return doctor.orElse(null);
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);  // save() can also update if the entity exists
    }

    public void deleteDoctor(int id) {
        doctorRepository.deleteById(id);
    }
}
