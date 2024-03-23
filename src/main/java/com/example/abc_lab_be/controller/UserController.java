package com.example.abc_lab_be.controller;

import com.example.abc_lab_be.entity.User;
import com.example.abc_lab_be.service.UserService;
import com.example.abc_lab_be.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/login")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity login(@RequestBody User user) {
        return new ResponseEntity(new StandardResponse("200", "Done", service.getUserByUserNameAndPw(user.getUsername(), user.getPassword())), HttpStatus.OK);
    }

}
