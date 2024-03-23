package com.example.abc_lab_be.repository;

import com.example.abc_lab_be.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByName(String name);
}
