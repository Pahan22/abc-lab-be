package com.example.abc_lab_be.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal fee;
    private String appointmentDateTime;
    private String testName;
    private String testResult;
    private String payResult;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patientid")
    @JsonIgnore
    private Patient patientId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_id")
    @JsonIgnore
    private Doctor docId;
}
