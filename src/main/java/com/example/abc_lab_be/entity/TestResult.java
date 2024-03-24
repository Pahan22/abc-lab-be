package com.example.abc_lab_be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TestResult {

    @Id
    @GeneratedValue
    private Long testId;
    private String testName;
    private String testFee;

}
