package com.example.abc_lab_be.service;

import com.example.abc_lab_be.entity.Doctor;
import com.example.abc_lab_be.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    public Doctor saveDoctor(Doctor doctor) {
        return repository.save(doctor);
    }

    public List<Doctor> getDoctors() {
        return repository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteDoctor(Long id) {
        repository.deleteById(id);
        return "Doctor Removed!! " + id;
    }

    public Doctor updateDoctor(Doctor doctor) {
        Doctor existingDoctor = repository.findById(doctor.getDocId()).orElse(null);
        if (existingDoctor != null) {

            existingDoctor.setName(doctor.getName());
            existingDoctor.setEmail(doctor.getEmail());
            existingDoctor.setContactNumber(doctor.getContactNumber());
            existingDoctor.setSpecializedField(doctor.getSpecializedField());
            return repository.save(existingDoctor);
        }
        return null;
    }
}
