package com.example.abc_lab_be.service;

import com.example.abc_lab_be.dto.AppoinmentDTO;
import com.example.abc_lab_be.entity.Appointment;
import com.example.abc_lab_be.repository.AppointmentRepository;
import com.example.abc_lab_be.repository.DoctorRepository;
import com.example.abc_lab_be.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    public List<AppoinmentDTO> getAppointments() {
        return appointmentRepository.findAll().stream()
                .map(appointment -> new AppoinmentDTO(
                        appointment.getId(),
                        appointment.getFee(),
                        appointment.getAppointmentDateTime() + "",
                        appointment.getPatientId().getPatientID(),
                        appointment.getDocId().getDocId(),
                        appointment.getTestName(),
                        appointment.getTestResult(),
                        appointment.getPayResult()))
                .collect(Collectors.toList());
    }

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(Appointment appointment) {
        Appointment existingAppointment = appointmentRepository.findById(appointment.getId()).orElse(null);
        if (existingAppointment != null) {
            existingAppointment.setPatientId(appointment.getPatientId());
            existingAppointment.setDocId(appointment.getDocId());
            existingAppointment.setTestName(appointment.getTestName());
            existingAppointment.setTestResult(appointment.getTestResult());
            existingAppointment.setAppointmentDateTime(appointment.getAppointmentDateTime());
            existingAppointment.setFee(appointment.getFee());
            return appointmentRepository.save(existingAppointment);
        }
        return null;
    }

    public Appointment convertToEntity(AppoinmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        appointment.setId(appointmentDTO.getId());
        appointment.setFee(appointmentDTO.getFee());
        appointment.setAppointmentDateTime(appointmentDTO.getAppointmentDateTime());
        appointment.setPatientId(patientRepository.findById(appointmentDTO.getPatientId()).orElse(null));
        appointment.setDocId(doctorRepository.findById(appointmentDTO.getDocId()).orElse(null));
        appointment.setTestName(appointmentDTO.getTestName());
        appointment.setTestResult(appointmentDTO.getTestResult());
        appointment.setPayResult(appointmentDTO.getPayResult());
        return appointment;
    }

    public AppoinmentDTO convertToDTO(Appointment appointment) {
        AppoinmentDTO appointmentDTO = new AppoinmentDTO();
        appointmentDTO.setId(appointment.getId());
        appointmentDTO.setFee(appointment.getFee());
        appointmentDTO.setAppointmentDateTime(appointment.getAppointmentDateTime());
        appointmentDTO.setPatientId(appointment.getPatientId().getPatientID());
        appointmentDTO.setDocId(appointment.getDocId().getDocId());
        appointmentDTO.setTestName(appointment.getTestName());
        appointmentDTO.setTestResult(appointment.getTestResult());
        appointmentDTO.setPayResult(appointment.getPayResult());
        return appointmentDTO;
    }

    public String deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
        return "Appointment Removed!! " + id;
    }
}
