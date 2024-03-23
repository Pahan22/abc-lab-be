package com.example.abc_lab_be.service;

import com.example.abc_lab_be.entity.Patient;
import com.example.abc_lab_be.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public Patient findByEmail(String email) {
        return patientRepository.findByEmail(email);
    }

    public Patient updatePatient(Patient patient) {
        Patient existingPatient = patientRepository.findById(patient.getPatientID()).orElse(null);
        if (existingPatient != null) {
            existingPatient.setFullName(patient.getFullName());
            existingPatient.setAge(patient.getAge());
            existingPatient.setContactNumber(patient.getContactNumber());
            existingPatient.setEmail(patient.getEmail());
            existingPatient.setPassword(patient.getPassword());
            return patientRepository.save(existingPatient);
        }
        return null;

    }

    public String deletePatient(Long id) {
        patientRepository.deleteById(id);
        return "Patient Removed!! " + id;
    }
}
