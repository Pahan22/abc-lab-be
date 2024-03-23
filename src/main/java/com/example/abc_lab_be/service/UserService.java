package com.example.abc_lab_be.service;

import com.example.abc_lab_be.entity.User;
import com.example.abc_lab_be.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByUserNameAndPw(String userName, String password) {
        return userRepository.findByUsernameAndPasswordAndRole(userName, password, "Admin");
    }
}
