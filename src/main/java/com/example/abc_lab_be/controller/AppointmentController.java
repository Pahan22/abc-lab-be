package com.example.abc_lab_be.controller;

import com.example.abc_lab_be.dto.AppoinmentDTO;
import com.example.abc_lab_be.entity.Appointment;
import com.example.abc_lab_be.service.AppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/appointment")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private ModelMapper mapper;


    @GetMapping("{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        return ResponseEntity.ok(appointment);
    }

    @GetMapping
    public ResponseEntity<List<AppoinmentDTO>> findAllAppointments() {
        List<AppoinmentDTO> appointments = appointmentService.getAppointments();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Appointment> createAppointment(@RequestBody AppoinmentDTO dto) {
        Appointment appointment = appointmentService.createAppointment(mapper.map(dto, Appointment.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(appointment);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<AppoinmentDTO> updateAppointment(@PathVariable Long id, @RequestBody AppoinmentDTO appointmentDTO) {
        Appointment appointment = appointmentService.convertToEntity(appointmentDTO);
        appointment.setId(id);
        Appointment updatedAppointment = appointmentService.updateAppointment(appointment);
        if (updatedAppointment != null) {
            AppoinmentDTO updatedDTO = appointmentService.convertToDTO(updatedAppointment);
            return new ResponseEntity<>(updatedDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}

