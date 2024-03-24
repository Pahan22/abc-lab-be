package com.example.abc_lab_be.service;

import com.example.abc_lab_be.entity.TestResult;
import com.example.abc_lab_be.repository.TestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TestResultService {

    @Autowired
    private TestResultRepository testRepository;

    public TestResult save(TestResult test){
        return testRepository.save(test);
    }

    public List<TestResult> getAll() {
        return testRepository.findAll();
    }


    public TestResult findByTestName(String testName) {
        return testRepository.findByTestName(testName);
    }

    public TestResult update(TestResult test) {
        TestResult existingPatient = testRepository.findById(test.getTestId()).orElse(null);
        if (existingPatient != null) {
            existingPatient.setTestName(test.getTestName());
            existingPatient.setTestFee(test.getTestFee());
            return testRepository.save(existingPatient);
        }
        return null;

    }

    public String delete(Long id) {
        testRepository.deleteById(id);
        return "Test Removed!! " + id;
    }

}
