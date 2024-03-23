package com.example.abc_lab_be.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Doctor {

    @Id
    @GeneratedValue
    private Long docId;
    private String name;
    private String email;
    private String contactNumber;
    private String specializedField;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Appointment> appointmentList;

}
