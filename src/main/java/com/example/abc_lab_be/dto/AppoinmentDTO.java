package com.example.abc_lab_be.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppoinmentDTO {
    private Long id;
    private BigDecimal fee;
    private String appointmentDateTime;
    private Long patientId;
    private Long docId;
    private String testName;
    private String testResult;
    private String payResult;
}
