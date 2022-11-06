package com.example.test_springboot_app.service;

import com.example.test_springboot_app.model.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {
    int calculateAge(LocalDate dateOfBirth);

    User save(User user);

    User findUserInfo(long id);

    List<User> getAllUsers();

}
