package com.example.abc_lab_be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long patientID;
    private String fullName;
    private int age;
    @Column(unique = true)
    private String contactNumber;
    @Column(unique = true)
    private String email;
    private String password;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Appointment> appointmentList;
}

