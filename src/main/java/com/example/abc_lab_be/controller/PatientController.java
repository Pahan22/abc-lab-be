package com.example.abc_lab_be.controller;

import com.example.abc_lab_be.entity.Patient;
import com.example.abc_lab_be.service.PatientService;
import com.example.abc_lab_be.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/patient")
@CrossOrigin
public class PatientController {

    @Autowired
    private PatientService service;

    @PostMapping("/add")
    public ResponseEntity addPatient(@RequestBody Patient patient) {
        return new ResponseEntity(new StandardResponse("200", "Done", service.savePatient(patient)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity findAllPatients() {
        return new ResponseEntity(new StandardResponse("200", "Done", service.getAllPatients()), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity findPatientById(@PathVariable Long id) {
        return new ResponseEntity(new StandardResponse("200", "Done", service.getPatientById(id)), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Patient> searchByEmail(@RequestParam String email) {
        Patient patient = service.findByEmail(email);
        if (patient != null) {
            return new ResponseEntity<>(patient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity updatePatient(@RequestBody Patient Patient) {
        return new ResponseEntity(new StandardResponse("200", "Done", service.updatePatient(Patient)), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePatient(@PathVariable Long id) {
        service.deletePatient(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }

}
