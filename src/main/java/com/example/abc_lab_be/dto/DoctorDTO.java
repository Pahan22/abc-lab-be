package com.example.abc_lab_be.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {
    private Long docId;
    private String name;
    private String email;
    private String contactNumber;
    private String specializedField;
}
