package com.example.abc_lab_be.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
    private Long patientID;
    private String fullName;
    private int age;
    private String contactNumber;
    private String email;
    private String password;

}
