package com.example.hospital.controllers;

import com.example.hospital.entities.Doctor;
import com.example.hospital.entities.Patient;
import com.example.hospital.requests.DoctorRequest;
import com.example.hospital.responses.DoctorResponse;
import com.example.hospital.responses.PatientResponse;
import com.example.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/all")
    public List<DoctorResponse> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        List<DoctorResponse> responses = new ArrayList<>();

        for (Doctor doctor : doctors) {
            responses.add(convertToResponse(doctor));
        }

        return responses;
    }


    @GetMapping("/{id}")
    public DoctorResponse getDoctorById(@PathVariable int id) {
        Doctor doctor = doctorService.getDoctorById(id);
        return convertToResponse(doctor);
    }

    @PostMapping
    public DoctorResponse addDoctor(@RequestBody DoctorRequest doctorRequest) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorRequest.getName());
        doctor.setSpeciality(doctorRequest.getSpeciality());
        Doctor savedDoctor = doctorService.saveDoctor(doctor);
        return convertToResponse(savedDoctor);
    }

    @PutMapping("/{id}")
    public DoctorResponse updateDoctor(@PathVariable int id, @RequestBody DoctorRequest doctorRequest) {
        Doctor doctor = new Doctor();
        doctor.setId(id);
        doctor.setName(doctorRequest.getName());
        doctor.setSpeciality(doctorRequest.getSpeciality());
        Doctor updatedDoctor = doctorService.updateDoctor(doctor);
        return convertToResponse(updatedDoctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable int id) {
        doctorService.deleteDoctor(id);
    }

    public DoctorResponse convertToResponse(Doctor doctor){
        if(doctor == null) {
            return null;
        }
        DoctorResponse response = new DoctorResponse();
        response.setId(doctor.getId());
        response.setName(doctor.getName());
        response.setSpeciality(doctor.getSpeciality());
        return response;
    }
}
