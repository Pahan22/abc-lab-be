package com.example.abc_lab_be.controller;

import com.example.abc_lab_be.entity.Doctor;
import com.example.abc_lab_be.service.DoctorService;
import com.example.abc_lab_be.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/doctor")
@CrossOrigin
public class DoctorController {

    @Autowired
    private DoctorService service;

    @PostMapping("/add")
    public ResponseEntity addDoctor(@RequestBody Doctor doctor) {
        return new ResponseEntity(new StandardResponse("200", "Done", service.saveDoctor(doctor)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity findAllDoctors() {
        return new ResponseEntity(new StandardResponse("200", "Done", service.getDoctors()), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity findDoctorById(@PathVariable Long id) {
        return new ResponseEntity(new StandardResponse("200", "Done", service.getDoctorById(id)), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateDoctor(@RequestBody Doctor doctor) {
        return new ResponseEntity(new StandardResponse("200", "Done", service.updateDoctor(doctor)), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDoctor(@PathVariable Long id) {
        service.deleteDoctor(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }
}
