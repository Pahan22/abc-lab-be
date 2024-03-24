package com.example.abc_lab_be.repository;

import com.example.abc_lab_be.entity.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult, Long> {

    TestResult findByTestName(String testName);

}
