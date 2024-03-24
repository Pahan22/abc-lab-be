package com.example.abc_lab_be.controller;

import com.example.abc_lab_be.entity.TestResult;
import com.example.abc_lab_be.service.TestResultService;
import com.example.abc_lab_be.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/test")
@CrossOrigin
public class TestResultController {

    @Autowired
    private TestResultService testResultService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody TestResult test) {
        return new ResponseEntity(new StandardResponse("200", "Done", testResultService.save(test)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity(new StandardResponse("200", "Done", testResultService.getAll()), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<TestResult> searchByName(@RequestParam String testName) {
        TestResult test = testResultService.findByTestName(testName);
        if (test != null) {
            return new ResponseEntity<>(test, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody TestResult test) {
        return new ResponseEntity(new StandardResponse("200", "Done", testResultService.update(test)), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        testResultService.delete(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }
}
